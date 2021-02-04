package com.example.x_smartcity_5.bean;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/4  16:10
 */
public class Shejiao {
    private String title,msg,time;

    public Shejiao(String title, String msg, String time) {
        this.title = title;
        this.msg = msg;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
