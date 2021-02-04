package com.example.x_smartcity_5.net;

import android.graphics.Bitmap;
import android.telecom.Call;

import java.io.IOException;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/3  14:38
 */
public interface OkHttpLoImage {
    void onResponse(Call call, Bitmap bitmap);

    void onFailure(Call call, IOException obj);
}
