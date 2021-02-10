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

import com.example.x_smartcity_5.Fragment.fuwu.Fragment_fuwu_tcc_tcc;
import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.bean.GetParkInfor;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/5  15:47
 */
public class Fragment_fuwu_tcc_xiangqing extends Fragment {
    private GetParkInfor parkInfor;
    private ImageView back;
    private TextView title;
    private TextView jvli;
    private TextView zhuangtai;
    private TextView shoufei;
    private TextView shengyu;
    private TextView dizhi;
    private TextView title1;

    public Fragment_fuwu_tcc_xiangqing(GetParkInfor parkInfor) {
        this.parkInfor = parkInfor;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_tcc_xiangqing, container, false);
        initView(view);
        title.setText("停车场详情");

        title1.setText(parkInfor.getParkName());
        jvli.setText("距离：" + parkInfor.getDistance() + "M");
        shoufei.setText("收费标准：" + parkInfor.getRateRefer());
        shengyu.setText("剩余车位：" + parkInfor.getSpaceNum());
        dizhi.setText("地址：" + parkInfor.getAddress());

        switch (parkInfor.getIsOpen()) {
            case "Y":
                zhuangtai.setText("对外开放");
                break;
            case "N":
                zhuangtai.setText("未开放");
                break;
        }


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_fuwu_tcc_tcc());
            }
        });

        return view;
    }

    private void getFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_home, fragment).commit();
    }

    private void initView(View view) {
        back = view.findViewById(R.id.back);
        title = view.findViewById(R.id.title);
        jvli = view.findViewById(R.id.jvli);
        zhuangtai = view.findViewById(R.id.zhuangtai);
        shoufei = view.findViewById(R.id.shoufei);
        shengyu = view.findViewById(R.id.shengyu);
        dizhi = view.findViewById(R.id.dizhi);
        title1 = view.findViewById(R.id.title1);
    }
}
