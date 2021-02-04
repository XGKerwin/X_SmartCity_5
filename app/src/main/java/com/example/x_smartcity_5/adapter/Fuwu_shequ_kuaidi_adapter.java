package com.example.x_smartcity_5.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.x_smartcity_5.Fragment.shequ.Fragment_shequ_kuaidi;
import com.example.x_smartcity_5.R;

import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/4  14:10
 */
public class Fuwu_shequ_kuaidi_adapter extends RecyclerView.Adapter<Fuwu_shequ_kuaidi_adapter.ViewHolder> {
    private List<String> strings;
    private FragmentActivity activity;

    public Fuwu_shequ_kuaidi_adapter(List<String> strings, FragmentActivity activity) {
        this.strings = strings;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_text, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String s = strings.get(position);
        holder.text.setText(s);
        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmet(new Fragment_shequ_kuaidi_xinxi(s));
            }
        });
    }

    private void getFragmet(Fragment fragment) {
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_home,fragment).commit();
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text;

        public ViewHolder(@NonNull View view) {
            super(view);
            text = view.findViewById(R.id.text);
        }
    }
}
