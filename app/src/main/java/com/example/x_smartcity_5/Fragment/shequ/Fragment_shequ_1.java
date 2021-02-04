package com.example.x_smartcity_5.Fragment.shequ;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.x_smartcity_5.R;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/4  13:37
 */
public class Fragment_shequ_1 extends Fragment {

    private ImageView back;
    private TextView title;
    private TextView txtWode;
    private EditText edFankui;
    private LinearLayout btnTel;
    private Button btnTijiao;
    private String name, tel;
    private TextView txtTel;

    public Fragment_shequ_1(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_shequ_1, container, false);
        initView(view);
        title.setText(name);
        txtTel.setText(tel);


        btn();


        return view;
    }

    private void btn() {
        btnTijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = edFankui.getText().toString();
                if (msg.equals("")){
                    Toast.makeText(getContext(),"请输入内容",Toast.LENGTH_SHORT).show();
                }else {
                    edFankui.setText("");
                    Toast.makeText(getContext(),"感谢您的评价，提交成功",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + tel));
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
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
        txtWode = view.findViewById(R.id.txt_wode);
        edFankui = view.findViewById(R.id.ed_fankui);
        btnTel = view.findViewById(R.id.btn_tel);
        btnTijiao = view.findViewById(R.id.btn_tijiao);
        txtTel = view.findViewById(R.id.txt_tel);
    }
}
