package com.example.mchp;

public class State {
    private String country;
    private String capital;
    private int flag;

    public State(String country, String capital, int flag) {
        this.country=country;
        this.capital=capital;
        this.flag=flag;
    }

    public String getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}