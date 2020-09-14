package com.gisconsultoria.com.apiBox.model.dao;

import javax.xml.bind.annotation.*;

/**
 * @author Luis Enrique Morales Soriano
 */
@XmlType(name = "InformacionAduanera")
@XmlAccessorType(XmlAccessType.FIELD)
public class InformacionAduaneraDao {

    @XmlAttribute(name = "NumeroPedimento")
    private String numeroPedimento;

    public String getNumeroPedimento() {
        return numeroPedimento;
    }

    public void setNumeroPedimento(String numeroPedimento) {
        this.numeroPedimento = numeroPedimento;
    }
}
