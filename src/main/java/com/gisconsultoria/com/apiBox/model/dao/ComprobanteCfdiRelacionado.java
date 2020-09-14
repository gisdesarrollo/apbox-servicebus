package com.gisconsultoria.com.apiBox.model.dao;

import com.gisconsultoria.com.apiBox.model.enums.TipoRelacionEnum;

import javax.xml.bind.annotation.*;

/**
 * @author Luis Enrique Morales Soriano
 */
@XmlType(name = "CfdiRelacionado")
@XmlAccessorType(XmlAccessType.FIELD)
public class ComprobanteCfdiRelacionado {

    @XmlElement(name = "CfdiRelacionado")
    private CfdiRelacionadoDao cfdiRelacionado;

    @XmlAttribute(name = "TipoRelacion")
    private TipoRelacionEnum tipoRelacion;

    public CfdiRelacionadoDao getCfdiRelacionado() {
        return cfdiRelacionado;
    }

    public void setCfdiRelacionado(CfdiRelacionadoDao cfdiRelacionado) {
        this.cfdiRelacionado = cfdiRelacionado;
    }

    public TipoRelacionEnum getTipoRelacion() {
        return tipoRelacion;
    }

    public void setTipoRelacion(TipoRelacionEnum tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }
}
