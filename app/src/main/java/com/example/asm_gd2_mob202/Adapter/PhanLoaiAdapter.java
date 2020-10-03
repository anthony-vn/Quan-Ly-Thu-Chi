package com.example.asm_gd2_mob202.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm_gd2_mob202.DAO.PhanLoai_DAO;
import com.example.asm_gd2_mob202.Dialog.BottomSheet_Update_PhanLoai;
import com.example.asm_gd2_mob202.Modal.PhanLoai;
import com.example.asm_gd2_mob202.R;

import static com.example.asm_gd2_mob202.Fragment.fragment_phanloai.phanloai_adapters;
import static com.example.asm_gd2_mob202.Fragment.fragment_phanloai.rv_phanloai;
import java.util.ArrayList;

public class PhanLoaiAdapter extends RecyclerView.Adapter<PhanLoaiAdapter.MyViewHolder> {
    private ArrayList<PhanLoai> ds_pl;
    private Context context;
    PhanLoai_DAO phanloai_dao;

    public PhanLoaiAdapter(ArrayList<PhanLoai> ds_pl, Context context) {
        this.ds_pl = ds_pl;
        this.context = context;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_ten;
        public TextView tv_trangthai;
        private ImageView img_xoa_pl;
        private ImageView img_edit_pl;
        public MyViewHolder(View v) {
            super(v);
            tv_ten = v.findViewById(R.id.tv_tenloai_pl);
            tv_trangthai = v.findViewById(R.id.tv_trangthai_pl);
            img_xoa_pl = v.findViewById(R.id.btn_delete_pl);
            img_edit_pl = v.findViewById(R.id.btn_edit_pl);
        }
    }


    @Override
    public PhanLoaiAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phanloai, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_ten.setText(ds_pl.get(position).getTenLoai());
        holder.tv_trangthai.setText(ds_pl.get(position).getTrangThai());
        holder.img_xoa_pl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                builder1.setMessage("Bạn có chắc muốn xóa "+ds_pl.get(position).getTenLoai());
                builder1.setCancelable(true);
                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                phanloai_dao = new PhanLoai_DAO(context);
                                phanloai_dao.delete(ds_pl.get(position).getMaLoai());
                                Toast.makeText(context, "Xóa thành công "+ds_pl.get(position).getTenLoai(), Toast.LENGTH_SHORT).show();
                                capnhat();
                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });

        holder.img_edit_pl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putString("MaLoai", ds_pl.get(position).getMaLoai()+"");
                args.putString("TenLoai", ds_pl.get(position).getTenLoai()+"");
                args.putString("TrangThai", ds_pl.get(position).getTrangThai()+"");

                BottomSheet_Update_PhanLoai bottom_sheet = new BottomSheet_Update_PhanLoai();
                bottom_sheet.setArguments(args);
                bottom_sheet.show(((AppCompatActivity) context).getSupportFragmentManager(),bottom_sheet.getTag());
            }
        });

    }
    @Override
    public int getItemCount() {
        return ds_pl.size();
    }
    public void capnhat(){
        ds_pl = phanloai_dao.getAll();
        phanloai_adapters = new PhanLoaiAdapter(ds_pl, context);
        rv_phanloai.setAdapter(phanloai_adapters);
    }
}
