package com.gisconsultoria.com.apiBox.services;

import com.gisconsultoria.com.apiBox.model.Sucursal;
import com.gisconsultoria.com.apiBox.service.ISucursalService;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author Luis Enrique Morales Soriano
 */
@Service
public class ApBoxXsaService {

    protected static final Logger LOG = Logger.getLogger(ApBoxXsaService.class.getName());

    @Value("${path.archivo.archivosXml}")
    private String pathArchivos;

    @Value("${api.xsa.url.descarga.cfdi}")
    private String path;

    @Autowired
    private ISucursalService sucursalService;

    public void ObtenerArchivos(Long sucursalId, Date fecha) throws IOException {

        Sucursal sucursal = sucursalService.findById(sucursalId);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(fecha);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        String urlPath = "https://".concat(sucursal.getServidor()).concat(":9050/")
                .concat(sucursal.getKeyXsa()).concat(path).concat("?")
                .concat("fechaInicial=").concat(dateString).concat("&")
                .concat("fechaFinal=").concat(dateFormat.format(calendar.getTime()));

        URL url = new URL(urlPath);

        InputStream in = new BufferedInputStream(url.openStream(), 1024);
        File zip = File.createTempFile(sucursal.getRfc(), dateString.concat(".zip"));
        OutputStream out = new BufferedOutputStream(new FileOutputStream(zip));
        copyInputStream(in, out);
        out.close();

        File path = new File(pathArchivos);
        LOG.info("Obteniendo archivos para la sucursal: " + sucursal.getNombre());
        if(zip.length() > 0){
            unpackArchive(zip, path);
        }

        sucursal.setFechaInicial(calendar.getTime());
        sucursalService.save(sucursal);

    }

    private void unpackArchive(File zip, File path) throws IOException {
        if (!zip.exists()) {
            throw new IOException(zip.getAbsolutePath() + " no existe el archivo");
        }
        if (!path.exists()) {
            throw new IOException("No se puede encontrar el directorio: " + path);
        }

        ZipFile zipFile = new ZipFile(zip);
        for (Enumeration entries = zipFile.entries(); entries.hasMoreElements(); ) {
            ZipEntry entry = (ZipEntry) entries.nextElement();

            if (entry.getName().contains(".xml") || entry.getName().toUpperCase().contains(".xml")) {
                LOG.info("Obteniendo el archivo: " + entry.getName());
                File file = new File(path, File.separator + entry.getName());
                if (!buildDirectory(file.getParentFile())) {
                    throw new IOException("No se puede crear el directorio: " + file.getParentFile());
                }
                if (!entry.isDirectory()) {
                    copyInputStream(zipFile.getInputStream(entry), new BufferedOutputStream(new FileOutputStream(file)));
                } else {
                    if (!buildDirectory(file)) {
                        throw new IOException("No se puede crear el directorio: " + file);
                    }
                }
            }
        }

        zipFile.close();

    }

    private void copyInputStream(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[2048];

        int len = in.read(buffer);
        while (len >= 0) {
            out.write(buffer, 0, len);
            len = in.read(buffer);
        }

        in.close();
        out.close();
    }

    private boolean buildDirectory(File file) {
        return file.exists() || file.mkdir();
    }
}
