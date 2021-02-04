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

import com.example.x_smartcity_5.R;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/4  12:02
 */
public class Fragment_new_dongtai extends Fragment {
    private String string;
    private ImageView back;
    private TextView title;
    private ImageView img;
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;

    public Fragment_new_dongtai(String msg) {
        this.string = msg;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_new_dongtai, container, false);
        initView(view);
        title.setText("通知");

        if (string.equals("2021-02-04")) {
            img.setImageResource(R.drawable.zhsq_banner);
            txt1.setText("物业通知");
            txt2.setText("尊敬的业主：\n" +
                    "　　您好，春节将至，为了让大家能过一个安全、温馨和舒适的节日。我管理处在加强出入口控制和日常巡逻的同时提醒各位业主和住户：\n" +
                    "　　1、如您外出，注意关好门窗以及水、电、气的开关，同时请保管好自己的贵重物品，不要将大额现金留存家中，以免发生火灾和失窃。\n" +
                    "　　2、请您将车辆停放在指定位置，并检查确认车门车窗是否完全锁住，以免造成经济损失;如您长时间外出，而车辆停放在小区内，请及时告之管理处。\n" +
                    "　　3、请不要随意给陌生人开门，以防不测。\n" +
                    "　　4、在使用家用电器及天然气时，请注意用电用火安全，切勿违规操作。\n" +
                    "　　5、春节期间，小区内禁止燃放烟花爆竹。\n" +
                    "　　6、请大家将自家阳台上摆放的物品移至安全地方，以避免高空坠物;同时也请楼上住户不要将物品向楼下丢弃，以免伤及楼下行人及车辆和影响小区的卫生状况。");
            txt3.setText(string);

        } else {
            img.setImageResource(R.drawable.zhsq_banner2);
            txt1.setText("社区居委会通知");
            txt2.setText("社区居委会关于社区安全的紧急通知\n" +
                    "各业主:\n" +
                    "目前zhi在天干物燥之际,极易引起火灾,望各业主仔细检查灭火器是否完好,并注意用电安全。另外,请各业主提高谨惕,若发现可疑人物出现在社区,及时通知保卫处。\n" +
                    "特此\n" +
                    "通知\n" +
                    "社区居委会");
            txt3.setText(string);

        }

        btn();

        return view;
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
        img = view.findViewById(R.id.img);
        txt1 = view.findViewById(R.id.txt_1);
        txt2 = view.findViewById(R.id.txt_2);
        txt3 = view.findViewById(R.id.txt_3);
    }
}
