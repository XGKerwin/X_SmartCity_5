package com.example.x_smartcity_5.adapter;

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

import com.example.x_smartcity_5.Fragment.shequ.Fragment_shequ_tuiguang;
import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.bean.Tuiguang;

import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/4  17:07
 */
public class Fuwu_shequ_tuiguang_adapter extends RecyclerView.Adapter<Fuwu_shequ_tuiguang_adapter.ViewHolder> {

    private List<Tuiguang> tuiguangs;
    private FragmentActivity activity;

    public Fuwu_shequ_tuiguang_adapter(List<Tuiguang> tuiguangs, FragmentActivity activity) {
        this.tuiguangs = tuiguangs;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_tuiguang, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tuiguang tuiguang = tuiguangs.get(position);
        holder.txtTitle.setText(tuiguang.getTitle());
        holder.txtMsg.setText(tuiguang.getMsg());
        switch (tuiguang.getS()) {
            case 1:
                holder.img.setImageResource(R.drawable.zhsq_banner);
                break;
            case 2:
                holder.img.setImageResource(R.drawable.zhsq_banner2);
                break;
        }

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(new Fragment_shequ_tuiguang1(tuiguang));
            }
        });
    }

    private void getFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_home,fragment).commit();
    }

    @Override
    public int getItemCount() {
        return tuiguangs.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout layout;
        private ImageView img;
        private TextView txtTitle;
        private TextView txtMsg;
        public ViewHolder(@NonNull View view) {
            super(view);
            layout = view.findViewById(R.id.layout);
            img = view.findViewById(R.id.img);
            txtTitle = view.findViewById(R.id.txt_title);
            txtMsg = view.findViewById(R.id.txt_msg);
        }
    }
}
