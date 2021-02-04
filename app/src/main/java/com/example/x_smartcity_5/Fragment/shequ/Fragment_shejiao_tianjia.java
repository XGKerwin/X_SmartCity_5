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

import com.example.x_smartcity_5.App;
import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.bean.Shejiao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/4  16:28
 */
public class Fragment_shejiao_tianjia extends Fragment {

    private ImageView back;
    private TextView title;
    private TextView txtWode;
    private EditText edTitle;
    private EditText edMsg;
    private Button btnTijiao;
    private App app;
    private List<Shejiao> shejiaos;

    public Fragment_shejiao_tianjia(List<Shejiao> sqtbs) {
        this.shejiaos =sqtbs;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_shejiao_tianjia, container, false);
        initView(view);
        title.setText("发表贴吧");
        btn();
        app = (App) getActivity().getApplication();
        btnTijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tit = edTitle.getText().toString();
                String msg = edMsg.getText().toString();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date(System.currentTimeMillis());
                String str = simpleDateFormat.format(date);
                if (tit.equals("")){
                    Toast.makeText(getContext(),"请输入标题",Toast.LENGTH_SHORT).show();
                }else if (msg.equals("")){
                    Toast.makeText(getContext(),"请输入内容",Toast.LENGTH_SHORT).show();
                }else {
                    shejiaos.add(new Shejiao(tit,msg,str));
                    Toast.makeText(getContext(),"提交成功",Toast.LENGTH_SHORT).show();
                    getFragment(new Fragment_shequ_shejiao(shejiaos));
                }
            }
        });

        return view;
    }

    private void btn() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_shequ_shejiao());
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
        edTitle = view.findViewById(R.id.ed_title);
        edMsg = view.findViewById(R.id.ed_msg);
        btnTijiao = view.findViewById(R.id.btn_tijiao);
    }
}