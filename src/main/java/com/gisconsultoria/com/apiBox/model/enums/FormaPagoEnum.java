package com.gisconsultoria.com.apiBox.model.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Luis Enrique Morales Soriano
 */
public enum FormaPagoEnum {

    Efectivo 							("01"),
    ChequeNominativo 					("02"),
    TransferenciaElectronicaDeFondos 	("03"),
    TarjetaDeCredito 					("04"),
    MonederoElectronico 				("05"),
    DineroElectronico 					("06"),
    ValesDeDespensa 					("08"),
    DacionEnPago 						("12"),
    PagoPorSubrogacion 					("13"),
    PagoPorConsignacion 				("14"),
    Condonacion 						("15"),
    Compensacion 						("17"),
    Novacion 							("23"),
    Confusion 							("24"),
    RemisionDeDeuda 					("25"),
    PrescripcionOCaducidad 				("26"),
    ASatisfaccionDelAcreedor 			("27"),
    TarjetaDeDebito 					("28"),
    TarjetaDeServicios					("29"),
    AplicacionDeAnticipos 				("30"),
    PorDefinir 							("99");

    public final String number;

    private FormaPagoEnum(String number){
        this.number = StringUtils.stripStart(number, "0");
    }
}
