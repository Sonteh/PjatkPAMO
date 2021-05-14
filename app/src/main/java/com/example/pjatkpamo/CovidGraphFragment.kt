package com.example.pjatkpamo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate

import android.renderscript.Sampler
import android.graphics.Color


class CovidGraphFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(R.layout.fragment_covid_graph, container, false)

        val barChart: BarChart = view.findViewById(R.id.barChart)

        val xLabel: ArrayList<String> = ArrayList()
        xLabel.add("USA")
        xLabel.add("India")
        xLabel.add("Germany")
        xLabel.add("Poland")

        val covid: MutableList<BarEntry> = ArrayList()
        covid.add(BarEntry(0f, 32185302f))
        covid.add(BarEntry(1f, 16263695f))
        covid.add(BarEntry(2f, 3180810f))
        covid.add(BarEntry(3f, 2751632f))

        val barDataSet = BarDataSet(covid, "Covid cases")
        barDataSet.setColors(*ColorTemplate.MATERIAL_COLORS)
        barDataSet.valueTextColor = Color.BLACK
        barDataSet.valueTextSize = 16f

        val barData = BarData(barDataSet);

        val xAxis: XAxis = barChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.granularity = 1f
        //xAxis.setValueFormatter(ValueFormatter() {


        barChart.setFitBars(true)
        barChart.data = barData
        barChart.description.text = "Covid"
        barChart.animateY(2000)
        barChart.invalidate()

        return view
    }
}