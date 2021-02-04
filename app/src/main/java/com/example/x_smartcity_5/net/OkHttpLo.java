package com.example.x_smartcity_5.net;

import org.json.JSONObject;

import java.io.IOException;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/3  14:37
 */
public interface OkHttpLo {
    void onResponse(JSONObject jsonObject);

    void onFailure(IOException obj);
}
