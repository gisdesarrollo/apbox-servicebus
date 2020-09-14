package com.gisconsultoria.com.apiBox.model.dao;

import com.gisconsultoria.com.apiBox.model.enums.RegimenFiscalEnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Luis Enrique Morales Soriano
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class EmisorDao {

    @XmlAttribute(name = "Rfc")
    private String rfc;

    @XmlAttribute(name = "Nombre")
    private String nombre;

    @XmlAttribute(name = "RegimenFiscal")
    private RegimenFiscalEnum regimenFiscal;

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public RegimenFiscalEnum getRegimenFiscal() {
        return regimenFiscal;
    }

    public void setRegimenFiscal(RegimenFiscalEnum regimenFiscal) {
        this.regimenFiscal = regimenFiscal;
    }
}
