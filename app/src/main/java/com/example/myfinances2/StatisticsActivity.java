package com.example.myfinances2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.myfinances2.db.DatabaseHelper;
import com.example.myfinances2.model.Category;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class StatisticsActivity extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    PieChart pieChart;
    Spinner spinner;
    private float x1, x2, y1, y2;

    private ArrayList<String> getSpinnerValues()
    {
        return new ArrayList<>(listCategories().keySet());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        mDatabaseHelper = new DatabaseHelper(this);
        pieChart = (PieChart) findViewById(R.id.chart2);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayList<String> array_spinner = getSpinnerValues();
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, array_spinner);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selected = (String) parentView.getItemAtPosition(position);
                populateListView(selected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // do nothing
            }

        });
    }

    private Map<String, ArrayList<Category>> listCategories() {
        Cursor data = mDatabaseHelper.getGroupedByMonthAndCateoory();
        Map<String, ArrayList<Category>> sorted = new HashMap<>();
        String month = "";
        ArrayList<Category> listData = new ArrayList<>();
        boolean flag = true;
        int dupa = data.getCount();
        while (data.moveToNext()) {
            if(flag)
            {
                month = data.getString(0);
                flag = false;
            }
            if (month.equals(data.getString(0)))
            {
                listData.add(new Category(data.getString(1), data.getInt(2)));
            }
            else
            {
                sorted.put(month, listData);
                month = data.getString(0);
                listData = new ArrayList<>();
                listData.add(new Category(data.getString(1), data.getInt(2)));
            }
        }
        sorted.put(month, listData);
        return sorted;
    }

    private void populateListView(String date)
    {
        Description description = new Description();
        description.setText("Monthly expenses");
        pieChart.setDescription(description);
        pieChart.setRotationEnabled(true);
        //pieChart.setUsePercentValues(true);
        //pieChart.setHoleColor(Color.BLUE);
        //pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setHoleRadius(40f);
        pieChart.setTransparentCircleAlpha(0);
        //pieChart.setDrawEntryLabels(true);
        //pieChart.setEntryLabelTextSize(20);
        //More options just check out the documentation!
        addDataSet(date);
    }

    private void addDataSet(String date) {
        ArrayList<PieEntry> yEntrys = new ArrayList<>();

        Map<String, ArrayList<Category>> mapCategories = listCategories();
        ArrayList<Category> categories = mapCategories.get(date);

        int sum = 0;

        for(int i = 0; i < categories.size(); i++){
            yEntrys.add(new PieEntry(categories.get(i).value(), categories.get(i).name() , i));
            sum += categories.get(i).value();
        }

        SimpleDateFormat month_date = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        SimpleDateFormat sdf = new SimpleDateFormat("MM-yyyy");
        try {
            Date dateDate = sdf.parse(date);
            String month_name = month_date.format(dateDate);
            pieChart.setCenterText(month_name + " " + sum + " PLN");
        }
        catch (ParseException ignored)
        {

        }
        pieChart.setCenterTextSize(18);

        //create the data set
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "Categories");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        //add colors to dataset
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.GRAY);
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.CYAN);
        colors.add(Color.YELLOW);
        colors.add(Color.MAGENTA);

        pieDataSet.setColors(colors);

        //add legend to chart
        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
//        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }

    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1 > x2){
                    Intent i = new Intent(StatisticsActivity.this, MainActivity.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }

}