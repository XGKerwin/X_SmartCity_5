package com.example.x_smartcity_5.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.x_smartcity_5.Fragment.fuwu.Fragment_fuwu_bashi;
import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.bean.BusList;
import com.example.x_smartcity_5.bean.BusStationById;

import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/5  11:18
 */
public class Fragment_fuwu_bashi1 extends Fragment {
    private List<BusStationById> busStationByIds;
    private BusList busList;
    private ImageView back;
    private TextView title;
    private TextView txtWode;
    private TextView qizhi;
    private ImageView imag;
    private TextView piaojia;
    private TextView licheng;
    private Button xiayibu;

    public Fragment_fuwu_bashi1(BusList busList) {
        this.busList = busList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bashi1, container, false);
        initView(view);
        title.setText(busList.getBusid()+"路");
        btn();
        qizhi.setText(busList.getStartSite()+"-------"+busList.getEndSite());
        piaojia.setText("票价："+busList.getPrice()+"元");
        licheng.setText("里程："+busList.getMileage()+"KM");
        int s = busList.getBusid();
        if (s%2==0){
            imag.setImageResource(R.drawable.ditu);
        }else {
            imag.setImageResource(R.drawable.ditu2);
        }

        xiayibu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_fuwu_bashi2(busList));
            }
        });


        return view;
    }

    private void btn() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_fuwu_bashi());
            }
        });
    }

    private void getFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_home,fragment).commit();
    }

    private void initView(View view) {
        back = view.findViewById(R.id.back);
        title = view.findViewById(R.id.title);
        txtWode = view.findViewById(R.id.txt_wode);
        qizhi = view.findViewById(R.id.qizhi);
        imag = view.findViewById(R.id.imag);
        piaojia = view.findViewById(R.id.piaojia);
        licheng = view.findViewById(R.id.licheng);
        xiayibu = view.findViewById(R.id.xiayibu);
    }
}
