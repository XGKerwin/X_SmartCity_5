package com.example.x_smartcity_5.adapter;

import android.graphics.Bitmap;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.x_smartcity_5.Fragment.fuwu.Fragment_S_huodong_xiangqing;
import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.bean.GetRecommandAction;
import com.example.x_smartcity_5.net.OkHttpLoImage;
import com.example.x_smartcity_5.net.OkHttpToImage;

import java.io.IOException;
import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/3  17:07
 */
public class Zhuye_huodong_remen_adapter extends RecyclerView.Adapter<Zhuye_huodong_remen_adapter.ViewHolder> {
    private List<GetRecommandAction> actions;
    private FragmentActivity activity;

    public Zhuye_huodong_remen_adapter(List<GetRecommandAction> actions, FragmentActivity activity) {
        this.actions = actions;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_huodong_tuijian, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetRecommandAction action = actions.get(position);
        holder.txtTitle.setText(action.getName());
        holder.txt1.setText(action.getDescription());
        holder.txt2.setText("时间："+action.getTime()+"    报名："+action.getCount()+"    点赞："+action.getPraiseCount());

        new OkHttpToImage()
                .setUrl(action.getImage())
                .setOkHttpLoImage(new OkHttpLoImage() {
                    @Override
                    public void onResponse(Call call, Bitmap bitmap) {
                        holder.img.setImageBitmap(bitmap);
                    }

                    @Override
                    public void onFailure(Call call, IOException obj) {

                    }
                }).start();

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_S_huodong_xiangqing(action.getId()));
            }
        });
    }



    @Override
    public int getItemCount() {
        return actions.size();
    }

    private void getFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_home,fragment).commit();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout layout;
        private ImageView img;
        private TextView txtTitle;
        private TextView txt1;
        private TextView txt2;

        public ViewHolder(@NonNull View view) {
            super(view);
            layout = view.findViewById(R.id.layout);
            img = view.findViewById(R.id.img);
            txtTitle = view.findViewById(R.id.txt_title);
            txt1 = view.findViewById(R.id.txt1);
            txt2 = view.findViewById(R.id.txt2);
        }
    }
}
