package com.example.asm_gd2_mob202.Modal;

public class KhoanChi {
    private int IdChi;
    private String TenChi;
    private String NgayChi;
    private double TienChi;
    private String GhiChuChi;
    private int MaLoai;

    public KhoanChi() {
    }

    public KhoanChi(String tenChi, String ngayChi, double tienChi, String ghiChuChi, int maLoai) {
        TenChi = tenChi;
        NgayChi = ngayChi;
        TienChi = tienChi;
        GhiChuChi = ghiChuChi;
        MaLoai = maLoai;
    }

    public KhoanChi(int idChi, String tenChi, String ngayChi, double tienChi, String ghiChuChi, int maLoai) {
        IdChi = idChi;
        TenChi = tenChi;
        NgayChi = ngayChi;
        TienChi = tienChi;
        GhiChuChi = ghiChuChi;
        MaLoai = maLoai;
    }

    public int getIdChi() {
        return IdChi;
    }

    public void setIdChi(int idChi) {
        IdChi = idChi;
    }

    public String getTenChi() {
        return TenChi;
    }

    public void setTenChi(String tenChi) {
        TenChi = tenChi;
    }

    public String getNgayChi() {
        return NgayChi;
    }

    public void setNgayChi(String ngayChi) {
        NgayChi = ngayChi;
    }

    public double getTienChi() {
        return TienChi;
    }

    public void setTienChi(double tienChi) {
        TienChi = tienChi;
    }

    public String getGhiChuChi() {
        return GhiChuChi;
    }

    public void setGhiChuChi(String ghiChuChi) {
        GhiChuChi = ghiChuChi;
    }

    public int getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(int maLoai) {
        MaLoai = maLoai;
    }
}
