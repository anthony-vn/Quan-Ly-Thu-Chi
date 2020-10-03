package com.example.asm_gd2_mob202.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm_gd2_mob202.DAO.KhoanThu_DAO;
import com.example.asm_gd2_mob202.Dialog.BottomSheet_Update_KhoanThu;
import com.example.asm_gd2_mob202.Modal.KhoanThu;
import com.example.asm_gd2_mob202.Modal.PhanLoai;
import com.example.asm_gd2_mob202.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class KhoanThu_Adapter extends RecyclerView.Adapter<KhoanThu_Adapter.MyViewHolder> {
    private ArrayList<KhoanThu> ds_kt;
    private Context context;
    KhoanThu_DAO khoanThu_dao;
    ArrayList<PhanLoai> ds_pl;

    public KhoanThu_Adapter(ArrayList<KhoanThu> ds_kt, Context context) {
        this.ds_kt = ds_kt;
        this.context = context;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_tieude, tv_ngay, tv_tien, tv_ghichu;
        private ImageView img_xoa_kt, img_edit_kt;
        public MyViewHolder(View v) {
            super(v);
            tv_tieude = v.findViewById(R.id.tv_tieude_khoanthu);
            tv_ngay = v.findViewById(R.id.tv_ngay_khoanthu);
            tv_tien = v.findViewById(R.id.tv_tien_khoanthu);
            tv_ghichu = v.findViewById(R.id.tv_ghichu_khoanthu);
            img_xoa_kt = v.findViewById(R.id.img_delete_khoanthu);
            img_edit_kt = v.findViewById(R.id.img_edit_khoanthu);
        }
    }

    @Override
    public KhoanThu_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_khoanthu, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_tieude.setText(ds_kt.get(position).getTenThu());
        holder.tv_ngay.setText(ds_kt.get(position).getNgayThu()+"");
        //Dinh dang hien thi so tien
        DecimalFormat formatter = new DecimalFormat("#,###");
        String s = formatter.format(ds_kt.get(position).getTienThu());
        holder.tv_tien.setText(s);
        holder.tv_ghichu.setText(ds_kt.get(position).getGhiChuThu());
        holder.img_xoa_kt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                builder1.setMessage("Bạn có chắc muốn xóa "+ds_kt.get(position).getTenThu());
                builder1.setCancelable(true);
                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                khoanThu_dao = new KhoanThu_DAO(context);
                                khoanThu_dao.delete(ds_kt.get(position).getIdThu());
                                Toast.makeText(context, "Xóa thành công "+ds_kt.get(position).getTenThu(), Toast.LENGTH_SHORT).show();
                                ds_kt.remove(position);
                                notifyDataSetChanged();
                                dialog.cancel();
                            }
                        }).setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = builder1.create();
                alert.show();
            }
        });

        holder.img_edit_kt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putInt("idT", ds_kt.get(position).getIdThu());
                args.putString("TenT", ds_kt.get(position).getTenThu());
                args.putString("NgayT", ds_kt.get(position).getNgayThu());
                args.putDouble("TienT", ds_kt.get(position).getTienThu());
                args.putString("GhiChuT", ds_kt.get(position).getGhiChuThu());
                args.putInt("MaLoaiT", ds_kt.get(position).getMaLoai());
                khoanThu_dao = new KhoanThu_DAO(context);

                BottomSheet_Update_KhoanThu bottom_sheet = new BottomSheet_Update_KhoanThu();
                bottom_sheet.setArguments(args);
                bottom_sheet.show(((AppCompatActivity) context).getSupportFragmentManager(),bottom_sheet.getTag());
            }
        });
    }

    @Override
    public int getItemCount() {
        return ds_kt.size();
    }

}

