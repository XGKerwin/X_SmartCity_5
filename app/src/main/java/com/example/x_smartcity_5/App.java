package com.example.x_smartcity_5;

import android.app.Application;

import com.example.x_smartcity_5.bean.Shejiao;

import java.util.ArrayList;
import java.util.List;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/3  10:56
 */
public class App extends Application {

    private static String Userid;

    public static String getUserid() {
        return Userid;
    }

    public static void setUserid(String userid) {
        Userid = userid;
    }

    @Override
    public void onCreate() {
        super.onCreate();

   }
}
