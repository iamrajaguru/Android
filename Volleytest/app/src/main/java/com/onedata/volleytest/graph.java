package com.onedata.volleytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class graph extends AppCompatActivity {
    BarChart bcht;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        bcht=findViewById(R.id.barchart);
        bcht.setDrawBarShadow(false);
          bcht.setDrawValueAboveBar(true);
        bcht.setDrawBorders(false);
        /*bcht.getAxisLeft().isEnabled()=false;*/
       /* bcht.setMaxVisibleValueCount(90);*/


        bcht.setPinchZoom(true);
        bcht.setDrawGridBackground(false);
        bcht.getAxisRight().setDrawGridLines(false);
        bcht.getAxisLeft().setDrawGridLines(false);
        bcht.getXAxis().setDrawGridLines(false);
      /*  bcht.invalidate();*/

        bcht.setDrawBorders(false);

        ArrayList<BarEntry> bEntry=new ArrayList<>();


        bEntry.add(new BarEntry(1,40f));

        bEntry.add(new BarEntry(2,33f));

        bEntry.add(new BarEntry(3,84f));

        bEntry.add(new BarEntry(4,10f));

        bEntry.add(new BarEntry(5,90f));
        BarDataSet barDataSet=new BarDataSet(bEntry,"Data set1");
        barDataSet.setColors(ColorTemplate.LIBERTY_COLORS);
        BarData data=new BarData(barDataSet);
        data.setBarWidth(0.9f);
        bcht.setData(data);
    }
}
