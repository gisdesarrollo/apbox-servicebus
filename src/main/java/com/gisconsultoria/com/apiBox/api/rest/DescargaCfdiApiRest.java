package com.gisconsultoria.com.apiBox.api.rest;

import com.gisconsultoria.com.apiBox.model.Sucursal;
import com.gisconsultoria.com.apiBox.service.ISucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DescargaCfdiApiRest {

    @Autowired
    private ISucursalService sucursalService;

    @Value("${api.xsa.url.descarga.cfdi}")
    private String path;

    @GetMapping("/getCfdiZip/{rfc}/{fechaInicial}/{fechaFinal}")
    @ResponseBody
    public String getCfdiZip(@PathVariable String fechaInicial, @PathVariable String fechaFinal, @PathVariable String rfc){

        String res = null;
        Sucursal sucursal = sucursalService.getSucursalByRfc(rfc);
        RestTemplate restTemplate = new RestTemplate();

        if(sucursal == null){
            return "Error: Sucursal no encontrada";
        }

        Map<String, String> params = new HashMap<>();
        params.put("fechaInicial", fechaInicial);
        params.put("fechaFinal", fechaFinal);

        String url = "https://".concat(sucursal.getServidor()).concat(sucursal.getKeyXsa()).concat(path).concat("{fechaInicial}").concat("{fechaFinal}");

        res = restTemplate.getForObject(url, String.class, params);

        if(res.isEmpty()){
            return "Error: No hay archivos cfdi qué descargar";
        }

        return res;
    }

}
