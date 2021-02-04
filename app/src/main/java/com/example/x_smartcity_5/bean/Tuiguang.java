package com.example.x_smartcity_5.bean;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/4  17:03
 */
public class Tuiguang {

    private String title;
    private String msg;
    private int s;

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public Tuiguang(String title, String msg, int s) {
        this.title = title;
        this.msg = msg;
        this.s = s;
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
}
