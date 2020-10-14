package com.example.asm_gd2_mob202.Dialog;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.asm_gd2_mob202.Adapter.KhoanThu_Adapter;
import com.example.asm_gd2_mob202.DAO.KhoanThu_DAO;
import com.example.asm_gd2_mob202.Modal.KhoanThu;
import com.example.asm_gd2_mob202.Modal.PhanLoai;
import com.example.asm_gd2_mob202.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

import static com.example.asm_gd2_mob202.Fragment.fragment_khoanthu.khoanThu_adapter;
import static com.example.asm_gd2_mob202.Fragment.fragment_khoanthu.rcv_khoanthu;

public class BottomSheet_Update_KhoanThu extends BottomSheetDialogFragment {
    EditText edt_tieude, edt_tien, edt_ghichu, edt_ngay;
    Button btn_update;
    KhoanThu_DAO khoanThu_dao;
    ArrayList<KhoanThu> ds_gd;
    int id;

    public BottomSheet_Update_KhoanThu() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottomsheet_update_khoanthu, container, false);
        edt_tieude = view.findViewById(R.id.edtUpdate_ten_khoanthu);
        edt_ngay = view.findViewById(R.id.edtUpdate_ngay_khoanthu);
        edt_tien = view.findViewById(R.id.edtUpdate_tien_khoanthu);
        edt_ghichu = view.findViewById(R.id.edtUpdate_ghichu_khoanthu);
        btn_update = view.findViewById(R.id.btnUpdate_khoanthu);

        // Get Bundle
        Bundle mArgs = getArguments();
        id = mArgs.getInt("idT");
        String tieu_de = mArgs.getString("TenT");
        String ngay = mArgs.getString("NgayT");
        double tiens = mArgs.getDouble("TienT");
        String mota = mArgs.getString("GhiChuT");
        final int maloai_ = mArgs.getInt("MaLoaiT");

        // Hiển thị lên itemKhoanthu Update
        edt_tieude.setText(tieu_de);
        edt_ngay.setText(ngay);
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        formatter.applyPattern("#,###,###,###");
        String formattedString = formatter.format(tiens);

        edt_tien.setText(formattedString);
        edt_tien.addTextChangedListener(onTextChangedListener());
        edt_ghichu.setText(mota);
        // Get trạng thái của GIAO_DICH

        //Update khoanthu
        khoanThu_dao = new KhoanThu_DAO(getContext());
        ds_gd = new ArrayList<>();

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tieudes = edt_tieude.getText().toString();
                String ngays = edt_ngay.getText().toString();
                String str = edt_tien.getText().toString();
                DecimalFormat format = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                format.setParseBigDecimal(true);
                BigDecimal number = null;
                try {
                    number = (BigDecimal) format.parse(str);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int so = Integer.parseInt(number + "");
                String ghichus = edt_ghichu.getText().toString();

                KhoanThu gd = new KhoanThu(id, tieudes, ngays, so, ghichus, Integer.valueOf(maloai_));
                khoanThu_dao = new KhoanThu_DAO(getContext());
                khoanThu_dao.update(gd);

                capnhat();
                Toast.makeText(getContext(), "Cập nhật thành công!" + number, Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        return view;
    }

    public void capnhat() {
        ds_gd = new ArrayList<>();
        ds_gd = khoanThu_dao.getAll();
        khoanThu_adapter = new KhoanThu_Adapter(ds_gd, getContext());
        rcv_khoanthu.setAdapter(khoanThu_adapter);
    }

    private TextWatcher onTextChangedListener() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                edt_tien.removeTextChangedListener(this);

                try {
                    String originalString = s.toString();

                    Long longval;
                    if (originalString.contains(",")) {
                        originalString = originalString.replaceAll(",", "");
                    }
                    longval = Long.parseLong(originalString);

                    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
                    formatter.applyPattern("#,###,###,###");
                    String formattedString = formatter.format(longval);

                    //setting text after format to EditText
                    edt_tien.setText(formattedString);
                    edt_tien.setSelection(edt_tien.getText().length());
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }

                edt_tien.addTextChangedListener(this);
            }
        };
    }
}
