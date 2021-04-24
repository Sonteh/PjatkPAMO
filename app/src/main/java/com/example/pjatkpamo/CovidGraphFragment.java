package com.example.pjatkpamo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Color;

import androidx.appcompat.widget.Toolbar;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CovidGraphFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_covid_graph, container, false);

        BarChart barChart = view.findViewById(R.id.barChart);

        final ArrayList<String> xLabel = new ArrayList<>();
        xLabel.add("USA");
        xLabel.add("India");
        xLabel.add("Germany");
        xLabel.add("Poland");

        List<BarEntry> covid = new ArrayList<>();
        covid.add(new BarEntry(0f, 32185302f));
        covid.add(new BarEntry(1f, 16263695f));
        covid.add(new BarEntry(2f, 3180810f));
        covid.add(new BarEntry(3f, 2751632f));

        BarDataSet barDataSet = new BarDataSet(covid, "Covid cases");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return xLabel.get((int)value);
            }
        });

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Covid");
        barChart.animateY(2000);
        barChart.invalidate();

        return view;
    }
}