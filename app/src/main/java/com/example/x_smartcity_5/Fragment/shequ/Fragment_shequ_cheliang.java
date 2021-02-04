package com.example.x_smartcity_5.Fragment.shequ;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.adapter.Fuwu_cheliang_adapter;
import com.example.x_smartcity_5.bean.Cheliangguanli;

import java.util.ArrayList;
import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/4  17:31
 */
public class Fragment_shequ_cheliang extends Fragment {

    private List<Cheliangguanli> cheliangguanlis;
    private ImageView back;
    private TextView title;
    private TextView txtWode;
    private RecyclerView recyclerview;
    private Button btnTijiao;
    private Fuwu_cheliang_adapter adapter;

    public Fragment_shequ_cheliang(List<Cheliangguanli> list) {
        this.cheliangguanlis = list;
    }
    public Fragment_shequ_cheliang() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragmentshequ_cheliang, container, false);
        initView(view);
        title.setText("车辆管理");

        btn();

        getData();

        return view;
    }

    private void getData() {
        if (cheliangguanlis == null){
            cheliangguanlis = new ArrayList<>();

            cheliangguanlis.add(new Cheliangguanli("鲁A：10002","018","1000018","张三","10293219483","月河三鹿东阳小区","无"));
            cheliangguanlis.add(new Cheliangguanli("鲁A：10003","019","1000019","李四","10293219213","庆洋小区","无"));
        }else {

        }

        if (adapter == null){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            recyclerview.setLayoutManager(linearLayoutManager);

            adapter = new Fuwu_cheliang_adapter(cheliangguanlis);
        }else {
            adapter.notifyDataSetChanged();
        }
        recyclerview.setAdapter(adapter);


    }

    private void btn() {
        btnTijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_cheliang_tianjia(cheliangguanlis));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_shequ());
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
        btnTijiao = view.findViewById(R.id.btn_tijiao);
    }
}
