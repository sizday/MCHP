package com.example.mchp.recycle_base;

public class State {
    private String country;
    private String capital;
    private int flag;
    private boolean radio;

    public State(String country, String capital, int flag, boolean rb) {
        this.country=country;
        this.capital=capital;
        this.flag=flag;
        this.radio = rb;
    }

    public String getState() {
        return country;
    }

    public String getCapital() {
        return capital;
    }

    public int getFlag() {
        return flag;
    }

    public boolean isRadio() {
        return radio;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setState(String state) {
        this.country = state;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setRadio(boolean rb) {this.radio=rb;}
}
