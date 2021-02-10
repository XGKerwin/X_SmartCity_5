package com.example.x_smartcity_5.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.bean.Color1;

import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/5  11:55
 */
public class FUwu_bashi_2_adapter extends RecyclerView.Adapter<FUwu_bashi_2_adapter.ViewHolder> {

    private String[] strings;
    public Item_bashi bashi;

    public interface Item_bashi{

        void setOnClick(int position, String string);
    }

    public Item_bashi getBashi() {
        return bashi;
    }

    public void setBashi(Item_bashi bashi) {
        this.bashi = bashi;
    }

    private List<Color1> color1s;

    public FUwu_bashi_2_adapter(String[] strings, List<Color1> color1s) {
        this.color1s = color1s;
        this.strings = strings;
        this.color1s = color1s;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_bashi_2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Color1 color1 = color1s.get(position);
        holder.txt.setText(strings[position]);
        if (color1.getYanse()==1){
            holder.txt.setBackgroundResource(R.drawable.bai_hui1);
        }else {
            holder.txt.setBackgroundResource(R.drawable.bai_hui12);
        }


        holder.txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bashi.setOnClick(position,strings[position]);
            }
        });


    }

    @Override
    public int getItemCount() {
        return strings.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txt;

        public ViewHolder(@NonNull View view) {
            super(view);
            txt = view.findViewById(R.id.txt);
        }
    }
}
