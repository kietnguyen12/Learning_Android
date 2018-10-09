package com.example.knguyen208.intentexplicit;

import java.io.Serializable;

public class HocSinh implements Serializable {
    private String hoten;
    private int namsinh;

    public HocSinh(String hoten, int namsinh) {
        this.hoten = hoten;
        this.namsinh = namsinh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }
}
