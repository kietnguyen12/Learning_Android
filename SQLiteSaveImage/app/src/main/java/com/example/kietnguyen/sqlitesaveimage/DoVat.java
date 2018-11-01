package com.example.kietnguyen.sqlitesaveimage;

public class DoVat {
    private String TenDoVat;
    private String MoTaDoVat;
    private byte[] hinh;

    public DoVat(String tenDoVat, String moTaDoVat, byte[] hinh) {
        TenDoVat = tenDoVat;
        MoTaDoVat = moTaDoVat;
        this.hinh = hinh;
    }

    public String getTenDoVat() {
        return TenDoVat;
    }

    public void setTenDoVat(String tenDoVat) {
        TenDoVat = tenDoVat;
    }

    public String getMoTaDoVat() {
        return MoTaDoVat;
    }

    public void setMoTaDoVat(String moTaDoVat) {
        MoTaDoVat = moTaDoVat;
    }

    public byte[] getHinh() {
        return hinh;
    }

    public void setHinh(byte[] hinh) {
        this.hinh = hinh;
    }
}
