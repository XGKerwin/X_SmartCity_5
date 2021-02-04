package com.example.x_smartcity_5.Fragment.shequ;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.x_smartcity_5.R;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/4  12:47
 */
public class Fragment_shequ_fuwu extends Fragment {

    private ImageView back;
    private TextView title;
    private LinearLayout btnWuye;
    private LinearLayout btnTingche;
    private LinearLayout btnKefu;
    private LinearLayout btnBaoxiu;
    private LinearLayout btnBianmin;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_shequ_fuwu, container, false);
        initView(view);
        title.setText("社区服务");


        btn();

        return view;
    }

    private void btn() {
        btnBianmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_shequ_1("便民服务","010-2832-3333"));
            }
        });

        btnBaoxiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_shequ_1("保修电话","010-9288-8888"));
            }
        });

        btnKefu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_shequ_1("客服热线","010-9282-8372"));
            }
        });

        btnTingche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_shequ_1("停车位服务","010-1000-2000"));
            }
        });

        btnWuye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_shequ_1("物业服务","010-2123-3111"));
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
        btnWuye = view.findViewById(R.id.btn_wuye);
        btnTingche = view.findViewById(R.id.btn_tingche);
        btnKefu = view.findViewById(R.id.btn_kefu);
        btnBaoxiu = view.findViewById(R.id.btn_baoxiu);
        btnBianmin = view.findViewById(R.id.btn_bianmin);
    }
}
