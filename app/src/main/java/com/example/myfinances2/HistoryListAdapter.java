package com.example.myfinances2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myfinances2.model.HistoryRecord;

import java.util.ArrayList;

public class HistoryListAdapter extends ArrayAdapter<HistoryRecord> {

    private Context m_context;
    private int m_resource;

    public HistoryListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<HistoryRecord> objects) {
        super(context, resource, objects);
        m_context = context;
        m_resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String category = getItem(position).getCategory();
        int value = getItem(position).getValue();
        String date = getItem(position).getDate();

        HistoryRecord historyRecord = new HistoryRecord(category, value, date);

        LayoutInflater inflater = LayoutInflater.from(m_context);
        convertView = inflater.inflate(m_resource, parent, false);

        TextView tvCategory = (TextView) convertView.findViewById(R.id.textView1);
        TextView tvValue = (TextView) convertView.findViewById(R.id.textView2);
        TextView tvDate = (TextView) convertView.findViewById(R.id.textView3);

        tvCategory.setText(category);
        tvValue.setText(String.valueOf(value));
        tvDate.setText(date);

        return convertView;
    }
}
