package com.example.asm_gd2_mob202.Modal;

public class PhanLoai {
    private int MaLoai;
    private String TenLoai;
    private String TrangThai;

    public PhanLoai() {
    }

    public PhanLoai(String TenLoai, String TrangThai) {
        this.TenLoai = TenLoai;
        this.TrangThai = TrangThai;
    }

    public PhanLoai(int MaLoai, String TenLoai, String TrangThai) {
        this.MaLoai = MaLoai;
        this.TenLoai = TenLoai;
        this.TrangThai = TrangThai;
    }

    public int getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(int maLoai) {
        MaLoai = maLoai;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String tenLoai) {
        TenLoai = tenLoai;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }
}
