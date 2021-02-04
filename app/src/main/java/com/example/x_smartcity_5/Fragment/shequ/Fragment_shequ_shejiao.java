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

import com.example.x_smartcity_5.App;
import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.adapter.FUwu_shequ_shejiao_adapter;
import com.example.x_smartcity_5.bean.Shejiao;

import java.util.ArrayList;
import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/4  15:14
 */
public class Fragment_shequ_shejiao extends Fragment {


    private ImageView back;
    private TextView title;
    private RecyclerView recyclerview;
    private ImageView tianjia;
    private App app;
    private FUwu_shequ_shejiao_adapter adapter;
    private List<Shejiao> sqtbs;

    public Fragment_shequ_shejiao(List<Shejiao> shejiaos) {
        this.sqtbs = shejiaos;
    }

    public Fragment_shequ_shejiao() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_shequ_shejiao, container, false);
        initView(view);
        if (sqtbs == null){
            sqtbs = new ArrayList<>();
        }
        title.setText("友邻社交");

        getshow();

        btn();

        return view;
    }

    private void getshow() {
        if (sqtbs.size()==0){
            sqtbs.add(new Shejiao("精准扶贫让老树逢春1","人民网银川10月13日电 记者获悉，宁夏原州区金融扶贫案例于近期作为联合国中国扶贫经典案例在联合国网站展示，并成为联合国对发展中国家扶贫开发的课程","2020-02-01"));
            sqtbs.add(new Shejiao("精准扶贫让老树逢春2","人民网银川10月13日电 记者获悉，宁夏原州区金融扶贫案例于近期作为联合国中国扶贫经典案例在联合国网站展示，并成为联合国对发展中国家扶贫开发的课程","2020-02-02"));
            sqtbs.add(new Shejiao("精准扶贫让老树逢春3","人民网银川10月13日电 记者获悉，宁夏原州区金融扶贫案例于近期作为联合国中国扶贫经典案例在联合国网站展示，并成为联合国对发展中国家扶贫开发的课程","2020-02-03"));
        }

        if (adapter == null){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            recyclerview.setLayoutManager(linearLayoutManager);

            adapter = new FUwu_shequ_shejiao_adapter(sqtbs);
            recyclerview.setAdapter(adapter);
        }else {
            adapter.notifyDataSetChanged();
        }
    }

    private void btn() {
        tianjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_shejiao_tianjia(sqtbs));
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
        recyclerview = view.findViewById(R.id.recyclerview);
        tianjia = view.findViewById(R.id.tianjia);
    }
}
