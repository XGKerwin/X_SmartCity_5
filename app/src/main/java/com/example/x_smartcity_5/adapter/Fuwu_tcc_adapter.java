package com.example.x_smartcity_5.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.bean.GetParkInfor;

import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/5  15:45
 */
public class Fuwu_tcc_adapter extends RecyclerView.Adapter<Fuwu_tcc_adapter.ViewHolder> {
    private List<GetParkInfor> getParkInfors;
    private int size;
    private FragmentActivity activity;


    public Fuwu_tcc_adapter(List<GetParkInfor> getParkInfors, int size, FragmentActivity activity) {
        this.getParkInfors = getParkInfors;
        this.size = size;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_tcc, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetParkInfor parkInfor = getParkInfors.get(position);
        holder.title.setText(parkInfor.getParkName());
        holder.dizhi.setText("地址" + parkInfor.getAddress());
        holder.jvli.setText("距离：" + parkInfor.getDistance() + "M");
        holder.shoufei.setText("停车费：" + parkInfor.getRateRefer());
        holder.shengyu.setText("剩余车位：" + parkInfor.getSpaceNum());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_fuwu_tcc_xiangqing(parkInfor));
            }
        });

    }

    private void getFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_home,fragment).commit();
    }

    @Override
    public int getItemCount() {
        return size;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView dizhi;
        private TextView zhuangtai;
        private TextView jvli;
        private TextView shoufei;
        private LinearLayout layout;
        private TextView shengyu;

        public ViewHolder(@NonNull View view) {
            super(view);
            title = view.findViewById(R.id.title);
            dizhi = view.findViewById(R.id.dizhi);
            zhuangtai = view.findViewById(R.id.zhuangtai);
            jvli = view.findViewById(R.id.jvli);
            shoufei = view.findViewById(R.id.shoufei);
            shengyu = view.findViewById(R.id.shengyu);
            layout = view.findViewById(R.id.layout);
        }
    }
}
