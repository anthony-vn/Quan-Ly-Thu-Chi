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

import com.example.asm_gd2_mob202.Adapter.KhoanThu_Adapter;
import com.example.asm_gd2_mob202.DAO.KhoanThu_DAO;
import com.example.asm_gd2_mob202.Dialog.BottomSheet_Insert_KhoanThu;
import com.example.asm_gd2_mob202.Modal.KhoanThu;
import com.example.asm_gd2_mob202.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class fragment_khoanthu extends Fragment {
    public static KhoanThu_Adapter khoanThu_adapter;
    public static RecyclerView rcv_khoanthu;
    ArrayList<KhoanThu> ds_gd;
    KhoanThu_DAO khoanThu_dao;
    FloatingActionButton fab_thu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thu, container, false);
        rcv_khoanthu = view.findViewById(R.id.rcv_khoanthu);
        rcv_khoanthu.setLayoutManager(new LinearLayoutManager(getContext()));
        ds_gd = new ArrayList<>();
        khoanThu_dao = new KhoanThu_DAO(getContext());
        fab_thu = view.findViewById(R.id.fab_khoanthu);

        fab_thu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheet_Insert_KhoanThu bottom_sheet = new BottomSheet_Insert_KhoanThu();
                bottom_sheet.show(getFragmentManager(),"tag");
            }
        });

        ds_gd = khoanThu_dao.getAll();
        khoanThu_adapter = new KhoanThu_Adapter(ds_gd, getContext());
        rcv_khoanthu.setAdapter(khoanThu_adapter);

        return view;
    }
}
