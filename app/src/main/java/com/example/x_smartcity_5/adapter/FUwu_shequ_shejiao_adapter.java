package com.example.x_smartcity_5.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.bean.Shejiao;

import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/4  16:20
 */
public class FUwu_shequ_shejiao_adapter extends RecyclerView.Adapter<FUwu_shequ_shejiao_adapter.ViewHolder> {

    private List<Shejiao> shejiaos;


    public FUwu_shequ_shejiao_adapter(List<Shejiao> shejiao) {
        this.shejiaos = shejiao;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_shejiao, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Shejiao shejiao = shejiaos.get(position);
        holder.txtTitle.setText(shejiao.getTitle());
        holder.txtMsg.setText(shejiao.getMsg());
        holder.txtTime.setText(shejiao.getTime());
    }

    @Override
    public int getItemCount() {
        return shejiaos.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle;
        private TextView txtMsg;
        private TextView txtTime;

        public ViewHolder(@NonNull View view) {
            super(view);
            txtTitle = view.findViewById(R.id.txt_title);
            txtMsg = view.findViewById(R.id.txt_msg);
            txtTime = view.findViewById(R.id.txt_time);
        }
    }

}
