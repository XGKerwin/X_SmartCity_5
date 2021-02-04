package com.example.x_smartcity_5.Fragment.shequ;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.bean.Cheliangguanli;

import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/4  18:20
 */
public class Fragment_cheliang_tianjia extends Fragment {
    private List<Cheliangguanli> list;
    private ImageView back;
    private TextView title;
    private TextView txtWode;
    private EditText edName;
    private EditText edChepai;
    private EditText edTel;
    private EditText edChewei;
    private EditText edKahao;
    private EditText edDizhi;
    private EditText edBeizhu;
    private Button btnTijiao;

    public Fragment_cheliang_tianjia(List<Cheliangguanli> cheliangguanlis) {
        this.list = cheliangguanlis;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_cheliang_tianjiam, container, false);
        initView(view);
        title.setText("添加信息卡");

        btn();

        return view;
    }

    private void btn() {
        btnTijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edName.getText().toString();
                String tel = edTel.getText().toString();
                String cph = edChepai.getText().toString();
                String chewei = edChewei.getText().toString();
                String kahao = edKahao.getText().toString();
                String dizhi = edDizhi.getText().toString();
                String beizhu = edBeizhu.getText().toString();
                if (name.equals("")){
                    Toast.makeText(getContext(),"请输入用户名",Toast.LENGTH_SHORT).show();
                }else if (cph.equals("")){
                    Toast.makeText(getContext(),"请输入车牌号",Toast.LENGTH_SHORT).show();
                } else if (tel.equals("")){
                    Toast.makeText(getContext(),"请输入手机号",Toast.LENGTH_SHORT).show();
                } else if (chewei.equals("")){
                    Toast.makeText(getContext(),"请输入车位号",Toast.LENGTH_SHORT).show();
                } else if (kahao.equals("")){
                    Toast.makeText(getContext(),"请输入停车卡号",Toast.LENGTH_SHORT).show();
                } else if (dizhi.equals("")){
                    Toast.makeText(getContext(),"请输入地址",Toast.LENGTH_SHORT).show();
                } else if (beizhu.equals("")){
                    Toast.makeText(getContext(),"请输入备注",Toast.LENGTH_SHORT).show();
                }else {
                    list.add(new Cheliangguanli(cph,chewei,kahao,name,tel,dizhi,beizhu));
                    Toast.makeText(getContext(),"提交成功",Toast.LENGTH_SHORT).show();
                    getFragment(new Fragment_shequ_cheliang(list));
                }


            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_shequ_cheliang());
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
        edName = view.findViewById(R.id.ed_name);
        edChepai = view.findViewById(R.id.ed_chepai);
        edTel = view.findViewById(R.id.ed_tel);
        edChewei = view.findViewById(R.id.ed_chewei);
        edKahao = view.findViewById(R.id.ed_kahao);
        edDizhi = view.findViewById(R.id.ed_dizhi);
        edBeizhu = view.findViewById(R.id.ed_beizhu);
        btnTijiao = view.findViewById(R.id.btn_tijiao);
    }
}
