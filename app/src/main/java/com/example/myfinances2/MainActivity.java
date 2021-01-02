package com.example.myfinances2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentController;
import androidx.fragment.app.FragmentTransaction;


import com.example.myfinances2.db.DatabaseHelper;
import com.example.myfinances2.model.Category;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    private static final String TAG = "ListDataActivity";
    PopupWindow popUp;
    boolean clicked = false;
    Category chosenCategory;
    PieChart pieChart;

    private float x1, x2, y1, y2;

    @SuppressLint("ClickableViewAccessibility")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabaseHelper = new DatabaseHelper(this);

        pieChart = (PieChart) findViewById(R.id.chart);

        ArrayList<Category> listData = listCategories();

        LinearLayout ll = (LinearLayout)findViewById(R.id.linear_layout);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);


        popUp = new PopupWindow(this);
        LinearLayout loypop = new LinearLayout(this);

        EditText editText = new EditText(this);
        Button but = new Button(this);
        but.setText("Add");

        int sum = 0;

        for (Category item : listData)
        {
            Button myButton = new Button(this);
            myButton.setText("+");

            int color = Color.rgb(0,255,0); //red for example
            int radius = 50000; //radius will be 5px
            int strokeWidth = 2;

            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(color);
            gradientDrawable.setCornerRadius(radius);
            gradientDrawable.setStroke(strokeWidth, color);
            myButton.setBackground(gradientDrawable);


            TextView textView = new TextView(this);
            String message = item.name();
            textView.setText(message);


            LinearLayout linside = new LinearLayout(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    1000/listData.size(),
                    LinearLayout.LayoutParams.MATCH_PARENT
            );
            params.leftMargin = 5;
            params.rightMargin = 5;

            linside.setOrientation(LinearLayout.VERTICAL);
            linside.addView(myButton, params);
            linside.addView(textView, params);

            ll.addView(linside, lp);


            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!clicked)
                    {
                        popUp.showAtLocation(ll, Gravity.CENTER, 0, 0);
                        popUp.setFocusable(true);
                        popUp.update(50, 50, 500, 300);
                        clicked = true;
                        chosenCategory = new Category(item);
                    } else {
                        popUp.dismiss();
                        clicked = false;
                    }
                }
            });
            sum += item.value();
        }


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        loypop.setOrientation(LinearLayout.VERTICAL);
        editText.setText("");
        editText.requestFocus();

        loypop.addView(editText, params);
        loypop.addView(but, params);
        popUp.setContentView(loypop);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = editText.getText().toString();
                if (!value.equals(""))
                {
                    chosenCategory.addValue(Integer.parseInt(value));
                    mDatabaseHelper.updateCategory(chosenCategory);
                    finish();
                    startActivity(getIntent());
                }
                popUp.dismiss();
            }
        });

//        for (int i = 1; i <= 20; i++) {
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.MATCH_PARENT,
//                    LinearLayout.LayoutParams.WRAP_CONTENT);
//            Button btn = new Button(this);
//            btn.setId(i);
//            final int id_ = btn.getId();
//            btn.setText("button " + id_);
//            btn.setBackgroundColor(Color.rgb(70, 80, 90));
//            linear.addView(btn, params);
//            btn1 = ((Button) view.findViewById(id_));
//            btn1.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View view) {
//                    Toast.makeText(view.this,
//                            "Button clicked index = " + id_, Toast.LENGTH_SHORT)
//                            .show();
//                }
//            });
//        }


        findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();

            }
        });

        Description description = new Description();
        description.setText("Total expenses");
        pieChart.setDescription(description);
        pieChart.setRotationEnabled(true);
        //pieChart.setUsePercentValues(true);
        //pieChart.setHoleColor(Color.BLUE);
        //pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setHoleRadius(40f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText(String.valueOf(sum) + " PLN");
        pieChart.setCenterTextSize(18);
        //pieChart.setDrawEntryLabels(true);
        //pieChart.setEntryLabelTextSize(20);
        //More options just check out the documentation!

        addDataSet();
    }

    private void addDataSet() {
        Log.d(TAG, "addDataSet started");
        ArrayList<PieEntry> yEntrys = new ArrayList<>();

        ArrayList<Category> categories = listCategories();

        for(int i = 0; i < categories.size(); i++){
            yEntrys.add(new PieEntry(categories.get(i).value(), categories.get(i).name() , i));
        }

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

    public void sendMessage() {
        Intent intent = new Intent(this, AddCategoryActivity.class);
        startActivity(intent);
    }


    private ArrayList<Category> listCategories() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");
        Cursor data = mDatabaseHelper.getData();
        ArrayList<Category> listData = new ArrayList<>();
        while (data.moveToNext()) {
            listData.add(new Category(data.getString(0), data.getInt(1)));
        }
        return listData;
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
                if(x1 < x2){
                Intent i = new Intent(MainActivity.this, StatisticsActivity.class);
                startActivity(i);
            }else if(x1 > x2){
                Intent i = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(i);
            }
            break;
        }
        return false;
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}