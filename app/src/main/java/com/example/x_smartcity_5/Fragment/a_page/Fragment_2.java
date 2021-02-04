package com.example.x_smartcity_5.Fragment.a_page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.x_smartcity_5.R;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/3  11:03
 */
public class Fragment_2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_2,container,false);
        return view;
    }
}
