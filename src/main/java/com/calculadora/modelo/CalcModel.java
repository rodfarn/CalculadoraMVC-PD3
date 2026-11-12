package com.calculadora.modelo;

public class CalcModel {
    private float m_total;

    public CalcModel() {
        reset();
    }

    public void reset() {
        setValue("1");
    }

    public void multiplyBy(String operand) {
        m_total *= Float.parseFloat(operand);
    }

    public void add(String operand) {
        m_total += Float.parseFloat(operand);
    }

    public void setValue(String value) {
        m_total = Float.parseFloat(value);
    }

    public String getValue() {
        return Float.toString(m_total);
    }
}
