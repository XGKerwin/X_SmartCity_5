package com.example.x_smartcity_5.Fragment.shequ;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.bean.New_dongtai;

import java.util.ArrayList;
import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/3  14:34
 */
public class Fragment_shequ extends Fragment {

    private ImageView back;
    private TextView title;
    private LinearLayout btnFuwu;
    private LinearLayout btnKuaijian;
    private LinearLayout btnShejiao;
    private LinearLayout btnTuiguang;
    private LinearLayout btnCheliangguanli;
    private List<New_dongtai> new_dongtai;
    private ViewFlipper viewFlipper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_shequ, container, false);
        initView(view);
        back.setVisibility(View.GONE);
        title.setText("智慧社区");
        getImage();
        btn();

        return view;
    }

    private void getImage() {
        new_dongtai = new ArrayList<>();
        new_dongtai.add(new New_dongtai(R.drawable.zhsq_banner, "2021-02-04"));
        new_dongtai.add(new New_dongtai(R.drawable.zhsq_banner2, "2021-02-05"));

        for (int i = 0; i < new_dongtai.size(); i++) {
            final New_dongtai smart_home = new_dongtai.get(i);
            View view = LayoutInflater.from(getContext()).inflate(R.layout.shequ_layout, null);
            ImageView itemImage = view.findViewById(R.id.item_image);
            TextView itemName = view.findViewById(R.id.item_name);
            itemImage.setImageResource(smart_home.getImage());
            itemName.setText("日期:" + smart_home.getMsg());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getFragment(new Fragment_new_dongtai(smart_home.getMsg()));
                }
            });
            viewFlipper.addView(view);
        }

    }

    private void btn() {
        btnCheliangguanli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_shequ_cheliang());
            }
        });

        btnTuiguang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_shequ_tuiguang());
            }
        });

        btnShejiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 getFragment(new Fragment_shequ_shejiao());
            }
        });

        btnKuaijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_shequ_kuaidi());
            }
        });

        btnFuwu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_shequ_fuwu());
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
        btnFuwu = view.findViewById(R.id.btn_fuwu);
        btnKuaijian = view.findViewById(R.id.btn_kuaijian);
        btnShejiao = view.findViewById(R.id.btn_shejiao);
        btnTuiguang = view.findViewById(R.id.btn_tuiguang);
        btnCheliangguanli = view.findViewById(R.id.btn_cheliangguanli);
        viewFlipper = view.findViewById(R.id.view_flipper);
    }
}
