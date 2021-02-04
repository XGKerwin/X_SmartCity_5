package com.example.x_smartcity_5.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.x_smartcity_5.R;
import com.example.x_smartcity_5.bean.GetActionCommitById;

import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/3  17:13
 */
public class Zhuye_huodong_pinglun_adapter extends RecyclerView.Adapter<Zhuye_huodong_pinglun_adapter.ViewHolder> {

    private List<GetActionCommitById> commitByIds;


    public Zhuye_huodong_pinglun_adapter(List<GetActionCommitById> commitByIds) {
        this.commitByIds = commitByIds;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pinglun, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GetActionCommitById commitById = commitByIds.get(position);
        holder.xinwenTitle.setText(commitById.getUsername());
        holder.xinwenMag.setText(commitById.getCommitContent());
        holder.xinwenTime.setText(commitById.getCommitTime());
    }

    @Override
    public int getItemCount() {
        if (commitByIds.size() == 0) return 0;
        return commitByIds.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView xinwenTitle;
        private TextView xinwenMag;
        private TextView xinwenTime;

        public ViewHolder(@NonNull View view) {
            super(view);
            xinwenTitle = view.findViewById(R.id.xinwen_title);
            xinwenMag = view.findViewById(R.id.xinwen_mag);
            xinwenTime = view.findViewById(R.id.xinwen_time);
        }
    }
}
