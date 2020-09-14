package com.gisconsultoria.com.apiBox.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

/**
 * @author Luis Enrique Morales Soriano
 */
@Entity
@Table(name = "rel_xml_facturas_emitidas",
        indexes = { @Index(name = "IUuid", columnList = "Uuid"), })
public class RelXmlFacturaEmitida implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "IdFe")
    private Long idFe;

    @Column(name = "Uuid")
    private String uuid;

    @Lob
    @Column(name = "ArchivoFisicoXml")
    private byte[] archivoFisicoXml;

    @ManyToOne(optional = false)
    @JoinColumn(name = "IdFe", insertable = false, updatable = false)
    private FacturaEmitida facturaEmitida;

    public RelXmlFacturaEmitida() {
    }

    public RelXmlFacturaEmitida(Long idFe, String uuid, byte[] archivoFisicoXml,
                                FacturaEmitida facturaEmitida) {
        this.idFe = idFe;
        this.uuid = uuid;
        this.archivoFisicoXml = archivoFisicoXml;
        this.facturaEmitida = facturaEmitida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdFe() {
        return idFe;
    }

    public void setIdFe(Long idFe) {
        this.idFe = idFe;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public byte[] getArchivoFisicoXml() {
        return archivoFisicoXml;
    }

    public void setArchivoFisicoXml(byte[] archivoFisicoXml) {
        this.archivoFisicoXml = archivoFisicoXml;
    }

    public FacturaEmitida getFacturaEmitida() {
        return facturaEmitida;
    }

    public void setFacturaEmitida(FacturaEmitida facturaEmitida) {
        this.facturaEmitida = facturaEmitida;
    }
}
