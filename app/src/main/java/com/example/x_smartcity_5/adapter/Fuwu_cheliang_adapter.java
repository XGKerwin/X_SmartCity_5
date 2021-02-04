package com.example.x_smartcity_5.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.bean.Cheliangguanli;

import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/4  18:07
 */
public class Fuwu_cheliang_adapter extends RecyclerView.Adapter<Fuwu_cheliang_adapter.ViewHolder> {

    private List<Cheliangguanli> cheliangguanlis;


    public Fuwu_cheliang_adapter(List<Cheliangguanli> cheliangguanlis) {
        this.cheliangguanlis = cheliangguanlis;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_cheliang, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cheliangguanli cheliangguanli = cheliangguanlis.get(position);
        holder.name.setText("姓名："+cheliangguanli.getName());
        holder.cph.setText("车牌号："+cheliangguanli.getCph());
        holder.tel.setText("手机号："+cheliangguanli.getTel());
        holder.dizhi.setText("地址："+cheliangguanli.getDizhi());
        holder.chewei.setText("车位号："+cheliangguanli.getCwh());
        holder.kahao.setText("停车卡号："+cheliangguanli.getTckh());
    }

    @Override
    public int getItemCount() {
        return cheliangguanlis.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView cph;
        private TextView chewei;
        private TextView kahao;
        private TextView tel;
        private TextView dizhi;

        public ViewHolder(@NonNull View view) {
            super(view);
            name = view.findViewById(R.id.name);
            cph = view.findViewById(R.id.cph);
            chewei = view.findViewById(R.id.chewei);
            kahao = view.findViewById(R.id.kahao);
            tel = view.findViewById(R.id.tel);
            dizhi = view.findViewById(R.id.dizhi);
        }
    }
}
