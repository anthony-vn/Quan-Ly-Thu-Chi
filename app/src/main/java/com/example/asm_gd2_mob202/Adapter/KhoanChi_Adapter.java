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

import com.example.asm_gd2_mob202.DAO.KhoanChi_DAO;
import com.example.asm_gd2_mob202.DAO.KhoanThu_DAO;
import com.example.asm_gd2_mob202.Dialog.BottomSheet_Update_KhoanChi;
import com.example.asm_gd2_mob202.Dialog.BottomSheet_Update_KhoanThu;
import com.example.asm_gd2_mob202.Modal.KhoanChi;
import com.example.asm_gd2_mob202.Modal.KhoanThu;
import com.example.asm_gd2_mob202.Modal.PhanLoai;
import com.example.asm_gd2_mob202.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.example.asm_gd2_mob202.Fragment.fragment_khoanchi.khoanChi_adapter;
import static com.example.asm_gd2_mob202.Fragment.fragment_khoanchi.rcv_khoanchi;

public class KhoanChi_Adapter extends RecyclerView.Adapter<KhoanChi_Adapter.MyViewHolder> {
    private ArrayList<KhoanChi> ds_gd;
    private Context context;
    KhoanChi_DAO khoanChi_dao;
    ArrayList<PhanLoai> ds_pl;

    public KhoanChi_Adapter(ArrayList<KhoanChi> ds_gd, Context context) {
        this.ds_gd = ds_gd;
        this.context = context;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_tieude, tv_ngay, tv_tien, tv_ghichu;
        private ImageView img_xoa_kc, img_edit_kc;
        public MyViewHolder(View v) {
            super(v);
            tv_tieude = v.findViewById(R.id.tv_tieude_khoanchi);
            tv_ngay = v.findViewById(R.id.tv_ngay_khoanchi);
            tv_tien = v.findViewById(R.id.tv_tien_khoanchi);
            tv_ghichu = v.findViewById(R.id.tv_ghichu_khoanchi);
            img_xoa_kc = v.findViewById(R.id.img_delete_khoanchi);
            img_edit_kc = v.findViewById(R.id.img_edit_khoanchi);
        }
    }

    @Override
    public KhoanChi_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_khoanchi, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_tieude.setText(ds_gd.get(position).getTenChi());
        holder.tv_ngay.setText(ds_gd.get(position).getNgayChi()+"");
        //Dinh dang hien thi so tien
        DecimalFormat formatter = new DecimalFormat("#,###");
        String s = formatter.format(ds_gd.get(position).getTienChi());
        holder.tv_tien.setText(s);
        holder.tv_ghichu.setText(ds_gd.get(position).getGhiChuChi());
        holder.img_xoa_kc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                builder1.setMessage("Bạn có chắc muốn xóa "+ds_gd.get(position).getTenChi());
                builder1.setCancelable(true);
                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                khoanChi_dao = new KhoanChi_DAO(context);
                                khoanChi_dao.delete(ds_gd.get(position).getIdChi());
                                Toast.makeText(context, "Xóa thành công "+ds_gd.get(position).getTenChi(), Toast.LENGTH_SHORT).show();
                                ds_gd.remove(position);
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

        holder.img_edit_kc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = new Bundle();
                args.putInt("idChi", ds_gd.get(position).getIdChi());
                args.putString("tenChi", ds_gd.get(position).getTenChi());
                args.putString("ngayChi", ds_gd.get(position).getNgayChi());
                args.putDouble("tienChi", ds_gd.get(position).getTienChi());
                args.putString("ghichuChi", ds_gd.get(position).getGhiChuChi());
                args.putInt("maloaiChi", ds_gd.get(position).getMaLoai());
                khoanChi_dao = new KhoanChi_DAO(context);

                BottomSheet_Update_KhoanChi bottom_sheet = new BottomSheet_Update_KhoanChi();
                bottom_sheet.setArguments(args);
                bottom_sheet.show(((AppCompatActivity) context).getSupportFragmentManager(),bottom_sheet.getTag());
            }
        });
    }

    @Override
    public int getItemCount() {
        return ds_gd.size();
    }
}

