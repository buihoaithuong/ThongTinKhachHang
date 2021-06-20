package com.example.thongtinkhachhang;

public class ThongTin {
    private int IdKH;
    private String TenKH;
    private String sdt;
    private String uuTien;
    private String dvThem;

    public ThongTin(int idKH, String tenKH, String sdt, String uuTien, String dvThem) {
        IdKH = idKH;
        TenKH = tenKH;
        this.sdt = sdt;
        this.uuTien = uuTien;
        this.dvThem = dvThem;
    }
    public  ThongTin(){}
    public int getIdKH() {
        return IdKH;
    }

    public void setIdKH(int idKH) {
        IdKH = idKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String tenKH) {
        TenKH = tenKH;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getUuTien() {
        return uuTien;
    }

    public void setUuTien(String uuTien) {
        this.uuTien = uuTien;
    }

    public String getDvThem() {
        return dvThem;
    }

    public void setDvThem(String dvThem) {
        this.dvThem = dvThem;
    }
}
