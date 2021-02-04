package com.example.x_smartcity_5.Fragment.shequ;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.adapter.Fuwu_shequ_kuaidi_adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/4  14:04
 */
public class Fragment_shequ_kuaidi extends Fragment {

    private ImageView back;
    private TextView title;
    private RecyclerView recyclerview;
    private List<String> strings;
    private Fuwu_shequ_kuaidi_adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_shequ_kuaidi, container, false);
        initView(view);
        title.setText("快递详情");
        btn();


        shwoRecycler();

        return view;
    }

    private void shwoRecycler() {
        strings = new ArrayList<>();
        strings.add("顺丰快递");
        strings.add("圆通快递");
        strings.add("中通快递");
        strings.add("京东快递");
        strings.add("宅急送");
        strings.add("韵达快递");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerview.setLayoutManager(linearLayoutManager);

        adapter = new Fuwu_shequ_kuaidi_adapter(strings,getActivity());
        recyclerview.setAdapter(adapter);

    }

    private void btn() {
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
        recyclerview = view.findViewById(R.id.recyclerview);
    }
}
