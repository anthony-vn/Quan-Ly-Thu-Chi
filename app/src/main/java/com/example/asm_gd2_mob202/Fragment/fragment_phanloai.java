package com.example.asm_gd2_mob202.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.asm_gd2_mob202.Adapter.PhanLoaiAdapter;
import com.example.asm_gd2_mob202.DAO.PhanLoai_DAO;
import com.example.asm_gd2_mob202.Dialog.BottomSheet_Insert_PhanLoai;
import com.example.asm_gd2_mob202.Modal.PhanLoai;
import com.example.asm_gd2_mob202.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class fragment_phanloai extends Fragment {
    FloatingActionButton fl_phanloai;
    public static PhanLoaiAdapter phanloai_adapters;
    PhanLoai_DAO phanloai_dao;
    public static RecyclerView rv_phanloai;
    ArrayList<PhanLoai> ds_phanloai;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_phanloai, container, false);
        fl_phanloai = view.findViewById(R.id.fl_pl);
        rv_phanloai = view.findViewById(R.id.rv_pl);
        rv_phanloai.setLayoutManager(new LinearLayoutManager(getContext()));
        ds_phanloai = new ArrayList<>();
        phanloai_dao = new PhanLoai_DAO(getContext());

        fl_phanloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheet_Insert_PhanLoai bottom_sheet = new BottomSheet_Insert_PhanLoai();
                bottom_sheet.show(getFragmentManager(),"tag");
            }
        });
        ds_phanloai = phanloai_dao.getAll();
        phanloai_adapters = new PhanLoaiAdapter(ds_phanloai, getContext());
        rv_phanloai.setAdapter(phanloai_adapters);


        return view;
    }

}
