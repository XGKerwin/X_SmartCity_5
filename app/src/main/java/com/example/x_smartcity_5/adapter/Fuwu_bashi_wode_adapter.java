package com.example.x_smartcity_5.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.bean.GetOrderBus;

import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/5  15:19
 */
public class Fuwu_bashi_wode_adapter extends RecyclerView.Adapter<Fuwu_bashi_wode_adapter.ViewHolder> {

    private List<GetOrderBus> buses;


    public Fuwu_bashi_wode_adapter(List<GetOrderBus> buses) {
        this.buses = buses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_bashi_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetOrderBus bus = buses.get(position);
        holder.biamhao.setText("订单编号："+bus.getId());
        holder.luxian.setText(bus.getUpsite()+"------"+bus.getDownsite());
        holder.chehao.setText(bus.getBusid()+"路");
        holder.piaojia.setText("票价："+bus.getBusid());
        holder.riqi.setText(bus.getTravetime());
    }

    @Override
    public int getItemCount() {
        if (buses.size()==0)return 0;
        return buses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView biamhao;
        private TextView chehao;
        private TextView luxian;
        private TextView piaojia;
        private TextView riqi;

        public ViewHolder(@NonNull View view) {
            super(view);
            biamhao = view.findViewById(R.id.biamhao);
            chehao = view.findViewById(R.id.chehao);
            luxian = view.findViewById(R.id.luxian);
            piaojia = view.findViewById(R.id.piaojia);
            riqi = view.findViewById(R.id.riqi);
        }
    }
}
