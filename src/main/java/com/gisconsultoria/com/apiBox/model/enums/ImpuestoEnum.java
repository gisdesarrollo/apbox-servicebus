package com.gisconsultoria.com.apiBox.model.enums;

/**
 * @author Luis Enrique Morales Soriano
 */
public enum ImpuestoEnum {
    ISR(1),
    IVA(2),
    IEPS(3);

    public final int number;

    private ImpuestoEnum(int number){
        this.number = number;
    }
}
