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

import com.example.asm_gd2_mob202.Adapter.PhanLoaiAdapter;
import com.example.asm_gd2_mob202.DAO.PhanLoai_DAO;
import com.example.asm_gd2_mob202.Modal.PhanLoai;
import com.example.asm_gd2_mob202.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import static com.example.asm_gd2_mob202.Fragment.fragment_phanloai.phanloai_adapters;
import static com.example.asm_gd2_mob202.Fragment.fragment_phanloai.rv_phanloai;


import java.util.ArrayList;

public class BottomSheet_Update_PhanLoai extends BottomSheetDialogFragment {
//    EditText edt_tenloai_edit;
//    Spinner sp_loai_edit;
//    Button btn_update_pl;
//    PhanLoai_DAO phanloai_dao;
//    ArrayList<PhanLoai> ds_phanloai;
//    int id;
//    public BottomSheet_Update_PhanLoai(){
//    }
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.bottomsheet_update_phanloai, container, false);
//        edt_tenloai_edit = view.findViewById(R.id.edt_ten_update_phanloai);
//        sp_loai_edit = view.findViewById(R.id.sp_update_phanloai);
//        btn_update_pl = view.findViewById(R.id.btnUpdate_pl);
//        phanloai_dao = new PhanLoai_DAO(getContext());
//
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
//                R.array.plane_array_spinner_phanloai, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        sp_loai_edit.setAdapter(adapter);
//
//
//        Bundle mArgs = getArguments();
//        id = Integer.parseInt(mArgs.getString("MaLoai"));
//        String ten_loai = mArgs.getString("TenLoai");
//        String trang_thai = mArgs.getString("TrangThai");
//        selectSpinnerValue(sp_loai_edit, trang_thai);
//
//        edt_tenloai_edit.setText(ten_loai);
//
//
//        btn_update_pl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String ten_loais = edt_tenloai_edit.getText().toString();
//                String phanloais = sp_loai_edit.getSelectedItem().toString();
//                PhanLoai pl = new PhanLoai(id, ten_loais, phanloais);
//                phanloai_dao.update(pl);
//                capnhat();
//                Toast.makeText(getContext(), "Cập nhật thành công", Toast.LENGTH_SHORT).show();
//                dismiss();
//            }
//        });
//
//
//        return view;
//    }
//
//    private void selectSpinnerValue(Spinner spinner, String myString)
//    {
//        int index = 0;
//        for(int i = 0; i < spinner.getCount(); i++){
//            if(spinner.getItemAtPosition(i).toString().equals(myString)){
//                spinner.setSelection(i);
//                break;
//            }
//        }
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
