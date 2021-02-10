package com.example.x_smartcity_5.adapter;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.x_smartcity_5.Fragment.fuwu.Fragment_fuwu_bashi;
import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.bean.BusList;
import com.example.x_smartcity_5.bean.BusStationById;
import com.example.x_smartcity_5.net.OKHttpTo;
import com.example.x_smartcity_5.net.OkHttpLo;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/5  14:12
 */
public class Fragment_fuwu_bashi_4 extends Fragment {
    private String s;
    private String name, tel, dizhi1, dizhi2, desc;
    private BusList busList;
    private ImageView back;
    private TextView title;
    private TextView dizhi;
    private TextView shangche;
    private TextView xiache;
    private TextView shijian;
    private Button btnTijiao;
    private TextView txtname;
    private TextView txttel;
    private TextView txtWode;
    private List<BusStationById> busStationByIds;

    public Fragment_fuwu_bashi_4(String s, String name, String tel, String dizhi1, String dizhi2, String time, BusList busList, List<BusStationById> busStationByIds) {
        this.s = s;
        this.name = name;
        this.tel = tel;
        this.dizhi1 = dizhi1;
        this.dizhi2 = dizhi2;
        this.busList = busList;
        this.desc = time;
        this.busStationByIds = busStationByIds;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragent_fuwu_tijiao, container, false);
        initView(view);


        Log.d("sadasd", "onCreateView: ssssss");
        title.setText("提交订单");
        dizhi.setText(s);
        shangche.setText("上车："+dizhi1);
        xiache.setText("下车："+dizhi2);
        shijian.setText("乘车时间：" + desc);
        txtname.setText("乘客姓名："+name);
        txttel.setText("手机号："+tel);

        Log.d("sadasd", "onCreateView: ssssss");

        btnTijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getOkHttp();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_fuwu_bashi3(busList,desc));
            }
        });

        return view;
    }

    private void getOkHttp() {

        /**
         * {busid:1,"name":"abc","phone":"1234",
         * "upsite":"火车站","downsite":"阳光新天地","traveltime":"2020-10-5,2020-10-6","isPay":"N"}
         */

        new OKHttpTo()
                .setUrl("setOrderBus")
                .setJSONObject("busid",busList.getBusid())
                .setJSONObject("name",name)
                .setJSONObject("phone",tel)
                .setJSONObject("upsite",dizhi1)
                .setJSONObject("downsite",dizhi2)
                .setJSONObject("traveltime",desc)
                .setJSONObject("isPay","N")
                .setOkHttpLo(new OkHttpLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Toast.makeText(getContext(),"提交成功",Toast.LENGTH_SHORT).show();
                        getFragment(new Fragment_fuwu_bashi());
                    }

                    @Override
                    public void onFailure(IOException obj) {

                    }
                }).start();
    }


    private void getFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_home, fragment).commit();
    }


    private void initView(View view) {
        back = view.findViewById(R.id.back);
        title = view.findViewById(R.id.title);
        dizhi = view.findViewById(R.id.dizhi);
        shangche = view.findViewById(R.id.shangche);
        xiache = view.findViewById(R.id.xiache);
        shijian = view.findViewById(R.id.shijian);
        btnTijiao = view.findViewById(R.id.btn_tijiao);
        txtname = view.findViewById(R.id.txtname);
        txttel = view.findViewById(R.id.txttel);
    }
}
