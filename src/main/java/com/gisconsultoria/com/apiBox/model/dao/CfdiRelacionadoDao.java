package com.gisconsultoria.com.apiBox.model.dao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Luis Enrique Morales Soriano
 */
@XmlType(name = "cfdiRelacionado")
@XmlAccessorType(XmlAccessType.FIELD)
public class CfdiRelacionadoDao {

    @XmlAttribute(name = "UUID")
    private String UUID;

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
}
