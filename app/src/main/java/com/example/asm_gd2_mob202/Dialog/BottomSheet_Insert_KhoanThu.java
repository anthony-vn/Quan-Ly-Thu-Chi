package com.example.asm_gd2_mob202.Dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.asm_gd2_mob202.Adapter.KhoanThu_Adapter;
import com.example.asm_gd2_mob202.DAO.KhoanThu_DAO;
import com.example.asm_gd2_mob202.DAO.PhanLoai_DAO;
import com.example.asm_gd2_mob202.Modal.KhoanThu;
import com.example.asm_gd2_mob202.Modal.PhanLoai;
import com.example.asm_gd2_mob202.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import static com.example.asm_gd2_mob202.Fragment.fragment_khoanthu.khoanThu_adapter;
import static com.example.asm_gd2_mob202.Fragment.fragment_khoanthu.rcv_khoanthu;

import java.util.ArrayList;

public class BottomSheet_Insert_KhoanThu extends BottomSheetDialogFragment {
    EditText tieude, tien, ghichu, ngay;
    Button btn_them_khoanthu;
    KhoanThu_DAO khoanThu_dao;
    PhanLoai_DAO phanLoai_dao;
    ArrayList<KhoanThu> ds_gd;
    ArrayList<PhanLoai> ds_pl;

    public BottomSheet_Insert_KhoanThu() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottomsheet_insert_khoanthu, container, false);
        tieude = view.findViewById(R.id.edt_ten_khoanthu);
        ngay = view.findViewById(R.id.edt_ngay_khoanthu);
        tien = view.findViewById(R.id.edt_tien_khoanthu);
        ghichu = view.findViewById(R.id.edt_ghichu_khoanthu);
        btn_them_khoanthu = view.findViewById(R.id.btnAdd_khoanthu);

        khoanThu_dao = new KhoanThu_DAO(getContext());
        ds_pl = new ArrayList<>();

        btn_them_khoanthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = ngay.getText().toString();
                String tieudes = tieude.getText().toString();
                String moneys = tien.getText().toString();
                double tiens = Double.parseDouble(moneys);
                String mota = ghichu.getText().toString();

                if (tieudes.isEmpty() || date.isEmpty() || moneys.isEmpty()) {
                    Toast.makeText(getContext(), "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                } else {
                    if (mota.isEmpty()) {
                        mota = "None";
                    }
                    //Thêm mã loại
                    String trangthai = "Thu";
                    phanLoai_dao = new PhanLoai_DAO(getContext());
                    PhanLoai pl = new PhanLoai(tieudes, trangthai);
                    phanLoai_dao.insert(pl);
                    int maloaiss = pl.getMaLoai();

                    //Thêm vào giao dịch khoản thu
                    KhoanThu gd = new KhoanThu(tieudes, date, tiens, mota, maloaiss);
                    khoanThu_dao = new KhoanThu_DAO(getContext());
                    khoanThu_dao.insert(gd);

                    capnhat();

                    Toast.makeText(getContext(), "Thêm khoản thu thành công", Toast.LENGTH_SHORT).show();
                    dismiss();
                }
            }
        });
        return view;
    }

    public void capnhat() {
        ds_gd = khoanThu_dao.getAll();
        khoanThu_adapter = new KhoanThu_Adapter(ds_gd, getContext());
        rcv_khoanthu.setAdapter(khoanThu_adapter);
    }
}
