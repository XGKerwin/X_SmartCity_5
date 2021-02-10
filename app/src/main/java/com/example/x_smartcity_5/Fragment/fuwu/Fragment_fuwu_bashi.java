package com.example.x_smartcity_5.Fragment.fuwu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.adapter.Fuwu_bashi_Eadaper;
import com.example.x_smartcity_5.bean.BusList;
import com.example.x_smartcity_5.bean.BusStationById;
import com.example.x_smartcity_5.net.OKHttpTo;
import com.example.x_smartcity_5.net.OkHttpLo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/5  10:13
 */
public class Fragment_fuwu_bashi extends Fragment {

    private ImageView back;
    private TextView title;
    private TextView txtWode;
    private ExpandableListView expandbableListview;
    private Fuwu_bashi_Eadaper adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_fuwu_bashi, container, false);
        initView(view);
        title.setText("智慧巴士");
        txtWode.setVisibility(View.VISIBLE);
        getOkHttp();

        txtWode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_bashi_wode());
            }
        });


        btn();

        return view;
    }

    private List<BusList> busLists = new ArrayList<>();
    Map<BusList, List<BusStationById>> map = new HashMap<>();

    private void getOkHttp() {

        new OKHttpTo()
                .setUrl("busList")
                .setOkHttpLo(new OkHttpLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        busLists.addAll(new Gson().fromJson(jsonObject.optJSONArray("ROWS_DETAIL").toString(),
                                new TypeToken<List<BusList>>() {
                                }.getType()));
                        getokhttp1();
                    }

                    @Override
                    public void onFailure(IOException obj) {

                    }
                }).start();

    }

    private void getokhttp1() {
        for (int i = 0; i < busLists.size(); i++) {
            BusList busList = busLists.get(i);
            new OKHttpTo().setUrl("busStationById")
                    .setJSONObject("busid", busList.getBusid())
                    .setOkHttpLo(new OkHttpLo() {
                        @Override
                        public void onResponse(JSONObject jsonObject) {
                            List<BusStationById> busDetails = new Gson().fromJson(jsonObject.optJSONArray("ROWS_DETAIL").toString()
                                    , new TypeToken<List<BusStationById>>() {
                                    }.getType());
                            map.put(busList, busDetails);

                            if (adapter == null){
                                adapter = new Fuwu_bashi_Eadaper(map, busLists, getActivity());
                                expandbableListview.setAdapter(adapter);
                            }else {
                                adapter.notifyDataSetChanged();
                            }

//                            if (map.size() == busDetails.size()) {
//                                getelistview();
//                            }

                        }

                        @Override
                        public void onFailure(IOException obj) {

                        }
                    }).start();
        }
    }

    private void getelistview() {

    }

    private void btn() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_fuwu());
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
        txtWode = view.findViewById(R.id.txt_wode);
        expandbableListview = view.findViewById(R.id.expandbableListview);
        expandbableListview.setGroupIndicator(null);
    }
}
