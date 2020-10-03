package com.example.asm_gd2_mob202.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.asm_gd2_mob202.Database.DbHelper;

import java.util.ArrayList;

public class ThongKe_DAO {
    DbHelper dbh;
    SQLiteDatabase sdb;

    public static double tongTienTheoTT(Context context, String trangthai){
        double tongTien = 0;
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT SUM(Tien_Thu) AS TongTien" +
//                "FORM KHOAN_THU.MaLoai = LOAI_THU_CHI.MaLoai" +
//                "WHERE TrangThai = '"+trangthai+"'", null);
        Cursor cursor = db.rawQuery("SELECT SUM(Tien_Thu) AS TongTien" +
                "FORM KHOAN_THU.MaLoai = LOAI_THU_CHI.MaLoai" +
                "WHERE TrangThai = '"+trangthai+"'", null);
        if (cursor.getCount() >= 0){
            tongTien = cursor.getDouble(0);
        }
        cursor.moveToFirst();
        return tongTien;
    }
    public double thongkeTHU() {
        double tong = 0;
        sdb = dbh.getWritableDatabase();
        ArrayList<String> array_list = new ArrayList<String>();
        Cursor res = sdb.rawQuery( "SELECT (SUM(Tien_Thu)) FROM KHOAN_THU", null );
        res.moveToFirst();
//        while(res.isAfterLast() == false){
//            array_list.add(res.getString(res.getColumnIndex("fullname")));
//            res.moveToNext();
//        }
        if (res.moveToFirst()){
            do {
                tong = res.getDouble(0);

            }while (res.moveToNext());
        }
        return tong;
    }
}
