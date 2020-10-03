package com.example.asm_gd2_mob202.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context){
        super(context, "QuanLyThuChi.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE LOAI_THU_CHI(MaLoai integer PRIMARY KEY AUTOINCREMENT, TenLoai text, TrangThai text)");
        // Insert into table LOAI_THU_CHI
        db.execSQL("INSERT INTO LOAI_THU_CHI(TenLoai, TrangThai) VALUES('Lương tháng 5', 'Thu')");
        db.execSQL("INSERT INTO LOAI_THU_CHI(TenLoai, TrangThai) VALUES('Tiền trọ tháng 7', 'Chi')");

        // tạo bảng "khoản thu chi "phí
        db.execSQL("CREATE TABLE KHOAN_THU(Id_Thu integer PRIMARY KEY AUTOINCREMENT, Ten_Thu text, Ngay_Thu text, Tien_Thu double, GhiChu_Thu Text, MaLoai integer, FOREIGN KEY (MaLoai) REFERENCES LOAI_THU_CHI(MaLoai))");
        db.execSQL("CREATE TABLE KHOAN_CHI(Id_Chi integer PRIMARY KEY AUTOINCREMENT, Ten_Chi text, Ngay_Chi text, Tien_Chi double, GhiChu_Chi Text, MaLoai integer, FOREIGN KEY (MaLoai) REFERENCES LOAI_THU_CHI(MaLoai))");
        // Insert into table GIAO_DICH
        db.execSQL("INSERT INTO KHOAN_THU(Ten_Thu, Ngay_Thu, Tien_Thu, GhiChu_Thu, MaLoai) VALUES ('Lương tháng 6', '30/06/2020', 12500000, 'Không', 0)");
        db.execSQL("INSERT INTO KHOAN_CHI(Ten_Chi, Ngay_Chi, Tien_Chi, GhiChu_Chi, MaLoai) VALUES ('Tiền sinh hoạt', '27/04/2020', 105000, 'Không', 0)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS LOAI_THU_CHI");
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS KHOAN_THU");
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS KHOAN_CHI");
        onCreate(db);
    }
}
