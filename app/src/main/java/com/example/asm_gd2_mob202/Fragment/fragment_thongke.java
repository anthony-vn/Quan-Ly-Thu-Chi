package com.example.asm_gd2_mob202.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.example.asm_gd2_mob202.R;

import java.util.ArrayList;
import java.util.List;

public class fragment_thongke extends Fragment {
    AnyChartView anyChartView;
    TextView tv_thongke;

    String [] ex = {"Thu", "Chi"};
    int [] earnings = {50, 20};
    @Nullable
    @Override
    public android.view.View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thongke, container, false);
        anyChartView = view.findViewById(R.id.myAnyChartView);
        tv_thongke = view.findViewById(R.id.tv_thongke_thu);

        // Tổng tiền

        // Thông kê
        setupPieChart();

        return view;
    }

    public void setupPieChart(){
        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();

        for (int i = 0; i < ex.length; i++){
            dataEntries.add(new ValueDataEntry(ex[i], earnings[i]));
        }
        pie.data(dataEntries);
        anyChartView.setChart(pie);
    }


}
