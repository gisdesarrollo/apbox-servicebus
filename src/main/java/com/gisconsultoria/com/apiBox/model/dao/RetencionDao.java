package com.gisconsultoria.com.apiBox.model.dao;

import com.gisconsultoria.com.apiBox.model.enums.ImpuestoEnum;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Luis Enrique Morales Soriano
 */
@XmlType(name = "Retencion")
@XmlAccessorType(XmlAccessType.FIELD)
public class RetencionDao {

    @XmlAttribute(name = "Impuesto")
    private ImpuestoEnum impuesto;

    @XmlAttribute(name = "Importe")
    private Double importe;

    public ImpuestoEnum getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(ImpuestoEnum impuesto) {
        this.impuesto = impuesto;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }
}
