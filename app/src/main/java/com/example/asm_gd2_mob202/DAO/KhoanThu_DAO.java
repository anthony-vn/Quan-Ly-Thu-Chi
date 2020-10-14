package com.example.asm_gd2_mob202.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.asm_gd2_mob202.Database.DbHelper;
import com.example.asm_gd2_mob202.Modal.KhoanThu;

import java.util.ArrayList;

public class KhoanThu_DAO {

    public DbHelper dbh;
    public SQLiteDatabase sdb;

    public KhoanThu_DAO(Context context) {
        dbh = new DbHelper(context);
    }

    public void insert(KhoanThu gd) {
        sdb = dbh.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Ten_Thu", gd.getTenThu());
        values.put("Ngay_Thu", gd.getNgayThu());
        values.put("Tien_Thu", gd.getTienThu());
        values.put("GhiChu_Thu", gd.getGhiChuThu());
        values.put("MaLoai", gd.getMaLoai());
        sdb.insert("KHOAN_THU", null, values);
    }

    public ArrayList<KhoanThu> getAll() {
        ArrayList<KhoanThu> ds_gd = new ArrayList<>();
        sdb = dbh.getWritableDatabase();
        Cursor cursor = sdb.query("KHOAN_THU", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String tieude = cursor.getString(1);
                String ngay = cursor.getString(2);
                Double tien = cursor.getDouble(3);
                String note = cursor.getString(4);
                int maloai = cursor.getInt(5);
                ds_gd.add(new KhoanThu(id, tieude, ngay, tien, note, maloai));
            } while (cursor.moveToNext());
        }
        return ds_gd;
    }

    public void delete(int id_khoanthu) {
        sdb = dbh.getWritableDatabase();
        sdb.delete("KHOAN_THU", "Id_Thu = ?", new String[]{id_khoanthu + ""});
    }

    public void update(KhoanThu gd) {
        sdb = dbh.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Ten_Thu", gd.getTenThu());
        values.put("Ngay_Thu", gd.getNgayThu());
        values.put("Tien_Thu", gd.getTienThu());
        values.put("GhiChu_Thu", gd.getGhiChuThu());
        values.put("MaLoai", gd.getMaLoai());
        sdb.update("KHOAN_THU", values, "Id_Thu = ?", new String[]{gd.getIdThu() + ""});

    }

}
