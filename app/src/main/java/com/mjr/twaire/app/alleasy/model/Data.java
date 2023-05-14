package com.mjr.twaire.app.alleasy.model;

public class Data {
    private String symbol;
    private String unit;

    public Data(String symbol, String unit) {
        this.symbol = symbol;
        this.unit = unit;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
