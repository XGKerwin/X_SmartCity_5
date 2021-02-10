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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.bean.BusList;
import com.example.x_smartcity_5.bean.BusStationById;
import com.example.x_smartcity_5.bean.Color1;

import java.util.ArrayList;
import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/5  11:35
 */
public class Fragment_fuwu_bashi2 extends Fragment {
    private BusList busList;
    private ImageView back;
    private TextView title;
    private TextView txtWode;
    private RecyclerView recyclerview;
    private TextView txtRiqi;
    private Button btnTijiao;
    private List<Color1> color1s;
    private String[] strings = {"","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17",
                                "18","19","20","21","22","23","24","25","26","27","28","","","","","",""};
    private FUwu_bashi_2_adapter adapter;

    public Fragment_fuwu_bashi2(BusList busList) {
        this.busList = busList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bashi2, container, false);
        initView(view);
        color1s = new ArrayList<>();
        title.setText("日期选择");


        show();

        btn();
        return view;
    }

    private String time;
    private void show() {
        for (int i = 0;i<strings.length;i++){
            color1s.add(new Color1(1));
        }

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),7);
        recyclerview.setLayoutManager(gridLayoutManager);


        adapter = new FUwu_bashi_2_adapter(strings,color1s);
        recyclerview.setAdapter(adapter);

        adapter.setBashi(new FUwu_bashi_2_adapter.Item_bashi() {
            @Override
            public void setOnClick(int position, String string) {
                Color1 color1 = color1s.get(position);
                if (color1.getYanse()==1){
                    color1.setYanse(2);
                }else {
                    color1.setYanse(1);
                }
                getData(string);
                adapter.notifyDataSetChanged();
            }
        });
    }
    List<String> strings1 = new ArrayList<>();
    private void getData(String string) {
        time = string;
        if (strings1.size()==0){
            txtRiqi.setText("选择日期：2021-02-"+string);
            strings1.add(string);
        }else {
            for (int i=0;i<strings1.size();i++){
                String s1 = strings1.get(i);
                if (s1.equals(string)){
                    strings1.remove(i);
                }else {
                    strings1.add(string);
                }
            }
            for (int i=0;i<strings1.size();i++){
                String s = strings1.get(i);
                if (i==0){
                    txtRiqi.setText("选择日期："+s);
                }else {
                    txtRiqi.setText(","+s);
                }
            }

        }

        adapter.notifyDataSetChanged();



    }

    private void btn() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_fuwu_bashi1(busList));
            }
        });

        btnTijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_fuwu_bashi3(busList,time));
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
        recyclerview = view.findViewById(R.id.recyclerview);
        txtRiqi = view.findViewById(R.id.txt_riqi);
        btnTijiao = view.findViewById(R.id.btn_tijiao);
    }
}
