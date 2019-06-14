package com.onedata.scratch;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class Linecht extends AppCompatActivity {
    LineChart line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linecht);
        line=findViewById(R.id.linechrt);

        line.setDrawGridBackground(false);
        ArrayList<Entry> y= new ArrayList<>();
        y.add(new Entry(0,44));
        y.add(new Entry(1,54));
        y.add(new Entry(2,67));
        y.add(new Entry(3,13));
        y.add(new Entry(4,55));
        LineDataSet dataSet=new LineDataSet(y,"Months");
        LineData data=new LineData(dataSet);
        data.setValueTextSize(10f);

        line.setData(data);

    }
}
