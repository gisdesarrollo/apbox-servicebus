package com.gisconsultoria.com.apiBox.model.dao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Luis Enrique Morales Soriano
 */
@XmlType(name = "ConceptoCuentaPredial")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConceptoCuentaPredialDao {

    @XmlAttribute(name = "Numero")
    private Double numero;

    public Double getNumero() {
        return numero;
    }

    public void setNumero(Double numero) {
        this.numero = numero;
    }
}
