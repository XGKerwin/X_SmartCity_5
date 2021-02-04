package com.example.x_smartcity_5.adapter;

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

import com.example.x_smartcity_5.Fragment.shequ.Fragment_shequ_kuaidi;
import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.bean.Fuwu_kuaidi;

import java.util.ArrayList;
import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/4  14:25
 */
public class Fragment_shequ_kuaidi_xinxi extends Fragment {
    private ImageView back;
    private TextView title;
    private TextView txtWode;
    private RecyclerView recyclerview;
    private String string;
    private List<Fuwu_kuaidi> kuaidis;
    private Fuwu_kuaidixinxi_adapter adapter;

    public Fragment_shequ_kuaidi_xinxi(String s) {
        this.string = s;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_shequ_kuaidi_xinxi, container, false);
        initView(view);

        title.setText(string);

        getdata();
        btn();

        return view;
    }

    private void getdata() {
        kuaidis = new ArrayList<>();

        kuaidis.add(new Fuwu_kuaidi("东方小区","9012","张三"));
        kuaidis.add(new Fuwu_kuaidi("东方小区","4345","王五"));
        kuaidis.add(new Fuwu_kuaidi("东方小区","9532","kerwin"));
        kuaidis.add(new Fuwu_kuaidi("东方小区","2034","小名"));
        kuaidis.add(new Fuwu_kuaidi("东方小区","2813","奥丽安娜"));
        kuaidis.add(new Fuwu_kuaidi("东方小区","3847","特雷弗斯"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerview.setLayoutManager(linearLayoutManager);

        adapter = new Fuwu_kuaidixinxi_adapter(kuaidis,string);
        recyclerview.setAdapter(adapter);

    }

    private void btn() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_shequ_kuaidi());
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
    }
}
