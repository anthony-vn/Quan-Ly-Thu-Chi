package com.example.asm_gd2_mob202.Modal;

public class KhoanThu {
    private int IdThu;
    private String TenThu;
    private String NgayThu;
    private double TienThu;
    private String GhiChuThu;
    private int MaLoai;

    public KhoanThu() {
    }

    public KhoanThu(String tenThu, String ngayThu, double tienThu, String ghiChuThu, int maLoai) {
        TenThu = tenThu;
        NgayThu = ngayThu;
        TienThu = tienThu;
        GhiChuThu = ghiChuThu;
        MaLoai = maLoai;
    }

    public KhoanThu(int idThu, String tenThu, String ngayThu, double tienThu, String ghiChuThu, int maLoai) {
        IdThu = idThu;
        TenThu = tenThu;
        NgayThu = ngayThu;
        TienThu = tienThu;
        GhiChuThu = ghiChuThu;
        MaLoai = maLoai;
    }

    public int getIdThu() {
        return IdThu;
    }

    public void setIdThu(int idThu) {
        IdThu = idThu;
    }

    public String getTenThu() {
        return TenThu;
    }

    public void setTenThu(String tenThu) {
        TenThu = tenThu;
    }

    public String getNgayThu() {
        return NgayThu;
    }

    public void setNgayThu(String ngayThu) {
        NgayThu = ngayThu;
    }

    public double getTienThu() {
        return TienThu;
    }

    public void setTienThu(double tienThu) {
        TienThu = tienThu;
    }

    public String getGhiChuThu() {
        return GhiChuThu;
    }

    public void setGhiChuThu(String ghiChuThu) {
        GhiChuThu = ghiChuThu;
    }

    public int getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(int maLoai) {
        MaLoai = maLoai;
    }
}
