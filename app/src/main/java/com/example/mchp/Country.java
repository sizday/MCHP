package com.example.mchp;

public class Country {
    private String country;
    private String capital;
    private int flag;
    private boolean checked;

    public Country(String country, String capital, int flag, boolean checked) {
        this.country=country;
        this.capital=capital;
        this.flag=flag;
        this.checked = checked;
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

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }
}
