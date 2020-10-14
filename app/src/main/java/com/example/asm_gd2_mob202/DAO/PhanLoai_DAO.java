package com.example.asm_gd2_mob202.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.asm_gd2_mob202.Database.DbHelper;
import com.example.asm_gd2_mob202.Modal.PhanLoai;

import java.util.ArrayList;

public class PhanLoai_DAO {
    public DbHelper dbh;
    public SQLiteDatabase db;

    public PhanLoai_DAO(Context context){
        dbh = new DbHelper(context);
    }


    public ArrayList<PhanLoai> getAll() {
        ArrayList<PhanLoai> ds_pl = new ArrayList<>();
        db = dbh.getReadableDatabase();
        Cursor cursor = db.query("LOAI_THU_CHI", null, null, null, null, null, null);
        if (cursor.moveToFirst()){
            do {
                int maloai = cursor.getInt(0);
                String tenloai = cursor.getString(1);
                String trangthai = cursor.getString(2);
                ds_pl.add(new PhanLoai(maloai, tenloai, trangthai));
            } while (cursor.moveToNext());
        }
        return ds_pl;
    }

    public void insert(PhanLoai pl){
        db = dbh.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenLoai", pl.getTenLoai());
        values.put("TrangThai", pl.getTrangThai());
        db.insert("LOAI_THU_CHI",null, values);
    }

    public void update(PhanLoai pl){
        db = dbh.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenLoai", pl.getTenLoai());
        values.put("TrangThai", pl.getTrangThai());
        db.update("LOAI_THU_CHI", values, "MaLoai = ?", new String[]{pl.getMaLoai() + ""});
    }

    public void delete(int maloai) {
        db = dbh.getWritableDatabase();
        db.delete("LOAI_THU_CHI", "MaLoai = ?", new String[]{maloai + ""});
    }
}
