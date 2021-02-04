package com.example.x_smartcity_5.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.bean.Fuwu_kuaidi;

import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/4  15:00
 */
public class Fuwu_kuaidixinxi_adapter extends RecyclerView.Adapter<Fuwu_kuaidixinxi_adapter.ViewHolder> {

    private List<Fuwu_kuaidi> kuaidis;
    private String string;


    public Fuwu_kuaidixinxi_adapter(List<Fuwu_kuaidi> kuaidis, String string) {
        this.kuaidis = kuaidis;
        this.string = string;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_kuaidi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fuwu_kuaidi kuaidi = kuaidis.get(position);
        holder.txtXiaoqu.setText(string+"             "+kuaidi.getXiaoqu());
        holder.txt2.setText("姓名："+kuaidi.getName());
        holder.txt3.setText("取件码："+kuaidi.getQujianma());
    }

    @Override
    public int getItemCount() {
        return kuaidis.size();
    }

    private void initView(View view) {

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtXiaoqu;
        private TextView txt2;
        private TextView txt3;

        public ViewHolder(@NonNull View view) {
            super(view);
            txtXiaoqu = view.findViewById(R.id.txt_xiaoqu);
            txt2 = view.findViewById(R.id.txt_2);
            txt3 = view.findViewById(R.id.txt_3);
        }
    }
}
