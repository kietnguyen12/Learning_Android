package com.example.kietnguyen.danhsachcauthu;

public class CauThu {
    private String name;
    private String position;
    private int year;
    private int avatar;
    private int country;

    public CauThu(String name, String position, int year, int avatar, int country) {
        this.name = name;
        this.position = position;
        this.year = year;
        this.avatar = avatar;
        this.country = country;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
