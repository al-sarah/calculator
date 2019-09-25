package com.example.calculator_easy;

public class calculatoreasy {
    private int value1;
    private int value2;
    private Double result1;
    public calculatoreasy()
    {
        value1=1;
        value2=2;
        result1=3.0;
    }

    public calculatoreasy(int value1, int value2, Double result1) {
        this.value1 = value1;
        this.value2 = value2;
        this.result1 = result1;
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    public Double getResult1() {
        return result1;
    }

    public void setResult1(Double result1) {
        this.result1 = result1;
    }
}
