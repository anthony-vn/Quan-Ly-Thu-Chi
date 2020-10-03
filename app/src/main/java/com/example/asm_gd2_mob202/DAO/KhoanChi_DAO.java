package com.example.asm_gd2_mob202.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.asm_gd2_mob202.Database.DbHelper;
import com.example.asm_gd2_mob202.Modal.KhoanChi;

import java.util.ArrayList;

public class KhoanChi_DAO {

    public DbHelper dbh;
    public SQLiteDatabase sdb;

    public KhoanChi_DAO(Context context) {
        dbh = new DbHelper(context);
    }

    public boolean insert(KhoanChi kc) {
        sdb = dbh.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Ten_Chi", kc.getTenChi());
        values.put("Ngay_Chi", kc.getNgayChi());
        values.put("Tien_Chi", kc.getTienChi());
        values.put("GhiChu_Chi", kc.getGhiChuChi());
        values.put("MaLoai", kc.getMaLoai());
        long row = sdb.insert("KHOAN_CHI", null, values);
        if (row < 0){
            return false;
        }
        return true;
    }

    public ArrayList<KhoanChi> getAll() {
        ArrayList<KhoanChi> ds_kc = new ArrayList<>();
        sdb = dbh.getWritableDatabase();
        Cursor cursor = sdb.query("KHOAN_CHI", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String tieude = cursor.getString(1);
                String ngay = cursor.getString(2);
                double tien = cursor.getDouble(3);
                String note = cursor.getString(4);
                int maloai = cursor.getInt(5);
                ds_kc.add(new KhoanChi(id, tieude, ngay, tien, note, maloai));
            } while (cursor.moveToNext());
        }
        return ds_kc;
    }

    public boolean delete(int id_khoanchi) {
        sdb = dbh.getWritableDatabase();
        long row = sdb.delete("KHOAN_CHI", "Id_Chi = ?", new String[]{id_khoanchi + ""});
        if (row <= 0){
            return false;
        }
        return true;
    }

    public boolean update(KhoanChi gd) {
        sdb = dbh.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Ten_Chi", gd.getTenChi());
        values.put("Ngay_Chi", gd.getNgayChi());
        values.put("Tien_Chi", gd.getTienChi());
        values.put("GhiChu_Chi", gd.getGhiChuChi());
        values.put("MaLoai", gd.getMaLoai());
        long row = sdb.update("KHOAN_CHI", values, "Id_Chi = ?", new String[]{gd.getIdChi() + ""});
        if (row <= 0) {
            return false;
        }
        return true;
    }

}
