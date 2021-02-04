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
import com.example.x_smartcity_5.adapter.Fuwu_shequ_tuiguang_adapter;
import com.example.x_smartcity_5.bean.Tuiguang;

import java.util.ArrayList;
import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/4  16:58
 */
public class Fragment_shequ_tuiguang extends Fragment {

    private ImageView back;
    private TextView title;
    private TextView txtWode;
    private RecyclerView recyclerview;
    private List<Tuiguang> tuiguangs;
    private Fuwu_shequ_tuiguang_adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_shequ_tuiguang, container, false);
        initView(view);
        title.setText("商业推广");
        btn();
        tuiguangs = new ArrayList<>();

        getShow();


        return view;
    }

    private void getShow() {
        tuiguangs.add(new Tuiguang("大爱湖北行，千里送爱心","人民网银川10月13日电 记者获悉，宁夏原州区金融扶贫案例于近期作为联合国中国扶贫经典案例在联合国网站展示，并成为联合国对发展中国家扶贫开发的课程。",1));

        tuiguangs.add(new Tuiguang("推进“一乡一品”产业发展","在浙江扶贫实践中,涌现出了一大批饱含为民情怀、富有引领作用、具有示范意义的生动事例。 在近日举行的2020国家扶贫日浙江主场活动上,发布了浙江精准扶贫十大案例。",2));

        if (adapter == null){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            recyclerview.setLayoutManager(linearLayoutManager);

            adapter = new Fuwu_shequ_tuiguang_adapter(tuiguangs,getActivity());
            recyclerview.setAdapter(adapter);
        }
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
        txtWode = view.findViewById(R.id.txt_wode);
        recyclerview = view.findViewById(R.id.recyclerview);
    }
}
