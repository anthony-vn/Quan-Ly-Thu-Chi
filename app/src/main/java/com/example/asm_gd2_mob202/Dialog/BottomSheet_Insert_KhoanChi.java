package com.example.asm_gd2_mob202.Dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.asm_gd2_mob202.Adapter.KhoanChi_Adapter;
import com.example.asm_gd2_mob202.DAO.KhoanChi_DAO;
import com.example.asm_gd2_mob202.DAO.PhanLoai_DAO;
import com.example.asm_gd2_mob202.Modal.KhoanChi;
import com.example.asm_gd2_mob202.Modal.PhanLoai;
import com.example.asm_gd2_mob202.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

import static com.example.asm_gd2_mob202.Fragment.fragment_khoanchi.khoanChi_adapter;
import static com.example.asm_gd2_mob202.Fragment.fragment_khoanchi.rcv_khoanchi;

public class BottomSheet_Insert_KhoanChi extends BottomSheetDialogFragment {
    EditText tieude, tien, ghichu, ngay;
    Button btn_them_khoanchi;
    KhoanChi_DAO khoanChiDao;
    PhanLoai_DAO phanLoai_dao;
    ArrayList<KhoanChi> ds_gd;
    ArrayList<PhanLoai> ds_pl;

    public BottomSheet_Insert_KhoanChi() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottomsheet_insert_khoanchi, container, false);
        tieude = view.findViewById(R.id.edt_ten_khoanchi);
        ngay = view.findViewById(R.id.edt_ngay_khoanchi);
        tien = view.findViewById(R.id.edt_tien_khoanchi);
        ghichu = view.findViewById(R.id.edt_ghichu_khoanchi);
        btn_them_khoanchi = view.findViewById(R.id.btnAdd_khoanchi);

        khoanChiDao = new KhoanChi_DAO(getContext());
        ds_pl = new ArrayList<>();

        btn_them_khoanchi.setOnClickListener(new View.OnClickListener() {
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
                    String trangthai = "Chi";
                    phanLoai_dao = new PhanLoai_DAO(getContext());
                    PhanLoai pl = new PhanLoai(tieudes, trangthai);
                    phanLoai_dao.insert(pl);
                    int maloaiss = pl.getMaLoai();

                    //Thêm vào giao dịch khoản chi
                    KhoanChi gd = new KhoanChi(tieudes, date, tiens, mota, maloaiss);
                    khoanChiDao = new KhoanChi_DAO(getContext());
                    khoanChiDao.insert(gd);

                    capnhat();

                    Toast.makeText(getContext(), "Thêm khoản chi thành công", Toast.LENGTH_SHORT).show();
                    dismiss();
                }
            }
        });
        return view;
    }

    public void capnhat() {
        ds_gd = khoanChiDao.getAll();
        khoanChi_adapter = new KhoanChi_Adapter(ds_gd, getContext());
        rcv_khoanchi.setAdapter(khoanChi_adapter);
    }
}
