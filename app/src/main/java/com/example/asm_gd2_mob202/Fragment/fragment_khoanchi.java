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

import com.example.asm_gd2_mob202.Adapter.KhoanChi_Adapter;
import com.example.asm_gd2_mob202.Adapter.KhoanThu_Adapter;
import com.example.asm_gd2_mob202.DAO.KhoanChi_DAO;
import com.example.asm_gd2_mob202.DAO.KhoanThu_DAO;
import com.example.asm_gd2_mob202.Dialog.BottomSheet_Insert_KhoanChi;
import com.example.asm_gd2_mob202.Dialog.BottomSheet_Insert_KhoanThu;
import com.example.asm_gd2_mob202.Modal.KhoanChi;
import com.example.asm_gd2_mob202.Modal.KhoanThu;
import com.example.asm_gd2_mob202.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class fragment_khoanchi extends Fragment {
    public static KhoanChi_Adapter khoanChi_adapter;
    public static RecyclerView rcv_khoanchi;
    ArrayList<KhoanChi> ds_gd;
    KhoanChi_DAO khoanChi_dao;
    FloatingActionButton fab_chi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chi, container, false);
        rcv_khoanchi = view.findViewById(R.id.rcv_khoanchi);
        rcv_khoanchi.setLayoutManager(new LinearLayoutManager(getContext()));
        ds_gd = new ArrayList<>();
        khoanChi_dao = new KhoanChi_DAO(getContext());
        fab_chi = view.findViewById(R.id.fab_khoanchi);
        fab_chi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheet_Insert_KhoanChi bottom_sheet = new BottomSheet_Insert_KhoanChi();
                bottom_sheet.show(getFragmentManager(),"tag");
            }
        });

        ds_gd = khoanChi_dao.getAll();
        khoanChi_adapter = new KhoanChi_Adapter(ds_gd, getContext());
        rcv_khoanchi.setAdapter(khoanChi_adapter);

        return view;
    }
}
