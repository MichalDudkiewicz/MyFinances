/**
 * Copyright (c) 2015-2021 TomTom N.V. All rights reserved.
 * <p>
 * This software is the proprietary copyright of TomTom N.V. and its subsidiaries and may be used
 * for internal evaluation purposes or commercial use strictly subject to separate licensee
 * agreement between you and TomTom. If you are the licensee, you are only permitted to use
 * this Software in accordance with the terms of your license agreement. If you are not the
 * licensee then you are not authorised to use this software in any manner and should
 * immediately return it to TomTom N.V.
 */
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
