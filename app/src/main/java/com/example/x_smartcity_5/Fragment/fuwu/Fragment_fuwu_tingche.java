package com.example.x_smartcity_5.Fragment.fuwu;

import android.app.Person;
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

import java.util.Set;
import java.util.TreeSet;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/5  15:37
 */
public class Fragment_fuwu_tingche extends Fragment {

    private ImageView back;
    private TextView title;
    private LinearLayout btnLiebiao;
    private LinearLayout btnTcc;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_tcc,container,false);
        initView(view);
        title.setText("停车场");
        

        btn();
        return view;
    }
    private void btn() {
        btnTcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_fuwu_tcc_tcc());
            }
        });

        btnLiebiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_fuwu_tcc_lishi());
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_fuwu());
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
        btnLiebiao = view.findViewById(R.id.btn_liebiao);
        btnTcc = view.findViewById(R.id.btn_tcc);
    }
}
