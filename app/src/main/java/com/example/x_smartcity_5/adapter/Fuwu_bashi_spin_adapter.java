package com.example.x_smartcity_5.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/5  14:08
 */
public class Fuwu_bashi_spin_adapter extends ArrayAdapter<String> {
    public Fuwu_bashi_spin_adapter(List<String> strings, Context context) {
        super(context,0,strings);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = View.inflate(getContext(),android.R.layout.simple_list_item_1,null);
        TextView textView = view.findViewById(android.R.id.text1);
        textView.setText(getItem(position));
        textView.setTextSize(17);
        textView.setTextColor(Color.BLACK);
        textView.setGravity(Gravity.LEFT);
        return view;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = View.inflate(getContext(),android.R.layout.simple_list_item_1,null);
        TextView textView = view.findViewById(android.R.id.text1);
        textView.setText(getItem(position));
        textView.setTextSize(17);
        textView.setTextColor(Color.BLACK);
        textView.setGravity(Gravity.LEFT);
        return view;
    }
}
