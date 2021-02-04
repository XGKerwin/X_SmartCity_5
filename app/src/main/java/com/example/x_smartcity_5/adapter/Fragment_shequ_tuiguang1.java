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

import com.example.x_smartcity_5.Fragment.shequ.Fragment_shequ_tuiguang;
import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.bean.Tuiguang;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/4  17:17
 */
public class Fragment_shequ_tuiguang1 extends Fragment {
    private ImageView back;
    private TextView title;
    private TextView txtWode;
    private TextView txtTitle;
    private TextView txtMsg;
    private Tuiguang tuiguang;
    private ImageView img;

    public Fragment_shequ_tuiguang1(Tuiguang tuiguang) {
        this.tuiguang = tuiguang;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_shequ_tuiguang1, container, false);
        initView(view);
        btn();

        title.setText("商业推广");
        txtTitle.setText(tuiguang.getTitle());
        txtMsg.setText(tuiguang.getMsg());
        switch (tuiguang.getS()) {
            case 1:
                img.setImageResource(R.drawable.zhsq_banner);
                break;
            case 2:
                img.setImageResource(R.drawable.zhsq_banner2);
                break;
        }


        return view;
    }

    private void btn() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_shequ_tuiguang());
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
        txtTitle = view.findViewById(R.id.txt_title);
        txtMsg = view.findViewById(R.id.txt_msg);
        img = view.findViewById(R.id.img);
    }
}
