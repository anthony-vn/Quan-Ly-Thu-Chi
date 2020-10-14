package com.example.asm_gd2_mob202.Dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.example.asm_gd2_mob202.Fragment.fragment_phanloai.phanloai_adapters;
import static com.example.asm_gd2_mob202.Fragment.fragment_phanloai.rv_phanloai;

import com.example.asm_gd2_mob202.Adapter.PhanLoaiAdapter;
import com.example.asm_gd2_mob202.DAO.PhanLoai_DAO;
import com.example.asm_gd2_mob202.Modal.PhanLoai;
import com.example.asm_gd2_mob202.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.ArrayList;

public class BottomSheet_Insert_PhanLoai extends BottomSheetDialogFragment {
//    EditText edt_tenloai;
//    Spinner sp_loai;
//    Button btn_them;
//    PhanLoai_DAO phanloai_dao;
//    ArrayList<PhanLoai> ds_phanloai;
//    public BottomSheet_Insert_PhanLoai(){
//    }
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.bottomsheet_insert_phanloai, container, false);
//        edt_tenloai = view.findViewById(R.id.edt_tenloai_pl);
//        sp_loai = view.findViewById(R.id.sp_phanloai);
//        btn_them = view.findViewById(R.id.btn_thempl);
//        phanloai_dao = new PhanLoai_DAO(getContext());
//
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
//                R.array.plane_array_spinner_phanloai, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        sp_loai.setAdapter(adapter);
//
//        btn_them.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String ten_loai = edt_tenloai.getText().toString();
//                String phanloai = sp_loai.getSelectedItem().toString();
//                PhanLoai pl = new PhanLoai(ten_loai,phanloai);
//                phanloai_dao.insert(pl);
//                capnhat();
//                Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
//                dismiss();
//            }
//        });
//
//
//        return view;
//    }
//
//
//    public void capnhat(){
//        ds_phanloai = new ArrayList<>();
//        ds_phanloai = phanloai_dao.getAll();
//        phanloai_adapters = new PhanLoaiAdapter(ds_phanloai, getContext());
//        rv_phanloai.setAdapter(phanloai_adapters);
//    }
}
