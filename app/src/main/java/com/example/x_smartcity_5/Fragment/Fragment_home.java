package com.example.x_smartcity_5.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.x_smartcity_5.Fragment.fuwu.Fragment_fuwu;
import com.example.x_smartcity_5.Fragment.shequ.Fragment_shequ;
import com.example.x_smartcity_5.Fragment.wode.Fragment_wode;
import com.example.x_smartcity_5.Fragment.xinwen.Fragment_xinwen;
import com.example.x_smartcity_5.Fragment.zhuye.Fragment_zhuye;
import com.example.x_smartcity_5.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/3  14:22
 */
public class Fragment_home extends Fragment {

    private BottomNavigationView bottomNav;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container, false);
        initView(view);

        btnNav();
        getFragment(new Fragment_zhuye());

        return view;
    }
    @SuppressLint("WrongConstant")
    private void btnNav() {
        bottomNav.setLabelVisibilityMode(1);    //显示下列文字
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bom_home:
                        getFragment(new Fragment_zhuye());
                        break;
                    case R.id.bom_fuwu:
                        getFragment(new Fragment_fuwu());
                        break;
                    case R.id.bom_shequ:
                        getFragment(new Fragment_shequ());
                        break;
                    case R.id.bom_xinwen:
                        getFragment(new Fragment_xinwen());
                        break;
                    case R.id.bom_wode:
                        getFragment(new Fragment_wode());
                        break;
                }
                return true;
            }
        });
    }

    private void getFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_home,fragment).commit();
    }

    private void initView(View view) {
        bottomNav = view.findViewById(R.id.bottom_nav);
    }
}
