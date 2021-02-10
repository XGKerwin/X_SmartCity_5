package com.example.x_smartcity_5.Fragment.fuwu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.adapter.Fuwu_bashi_wode_adapter;
import com.example.x_smartcity_5.bean.GetOrderBus;
import com.example.x_smartcity_5.net.OKHttpTo;
import com.example.x_smartcity_5.net.OkHttpLo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/5  15:16
 */
public class Fragment_bashi_wode extends Fragment {


    private ImageView back;
    private TextView title;
    private EditText edName;
    private TextView btnYizhifu;
    private TextView btnWeizhifu;
    private RecyclerView recyclerview;
    private List<GetOrderBus> getOrderBuses, buses;
    private Fuwu_bashi_wode_adapter wode_adapter;
    private String abc;
    private Button btnChazhao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragent_fuwu_bashi_wode, container, false);
        initView(view);
        title.setText("我的订单");

        getOkHttp(abc);

        btn();

        return view;
    }

    private void getOkHttp(String abc) {
        if (getOrderBuses == null) {
            getOrderBuses = new ArrayList<>();
        } else {
            getOrderBuses.clear();
        }
        new OKHttpTo()
                .setUrl("getOrderBus")
                .setJSONObject("name", abc)
                .setOkHttpLo(new OkHttpLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        getOrderBuses.addAll(new Gson().fromJson(jsonObject.optJSONArray("ROWS_DETAIL").toString(),
                                new TypeToken<List<GetOrderBus>>() {
                                }.getType()));
                        getData("N");
                    }

                    @Override
                    public void onFailure(IOException obj) {

                    }
                }).start();
    }

    private void getData(String n) {
        if (buses == null) {
            buses = new ArrayList<>();
        } else {
            buses.clear();
        }

        for (int i = 0; i < getOrderBuses.size(); i++) {
            GetOrderBus bus = getOrderBuses.get(i);
            if (bus.getIsPay().equals(n)) {
                buses.add(bus);
            }
        }
        if (wode_adapter == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            recyclerview.setLayoutManager(linearLayoutManager);

            wode_adapter = new Fuwu_bashi_wode_adapter(buses);
            recyclerview.setAdapter(wode_adapter);
        } else {
            wode_adapter.notifyDataSetChanged();
        }


    }

    private void btn() {
        btnWeizhifu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData("N");
            }
        });

        btnYizhifu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData("Y");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_fuwu_bashi());
            }
        });

        btnChazhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edName.getText().toString();
                if (s.equals("")){
                    Toast.makeText(getContext(),"请输入姓名",Toast.LENGTH_SHORT).show();
                }else {
                    getOkHttp(s);
                }
            }
        });
    }

    private void getFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_home, fragment).commit();
    }

    private void initView(View view) {
        back = view.findViewById(R.id.back);
        title = view.findViewById(R.id.title);
        edName = view.findViewById(R.id.ed_name);
        btnYizhifu = view.findViewById(R.id.btn_yizhifu);
        btnWeizhifu = view.findViewById(R.id.btn_weizhifu);
        recyclerview = view.findViewById(R.id.recyclerview);
        btnChazhao = view.findViewById(R.id.btn_chazhao);
    }

}
