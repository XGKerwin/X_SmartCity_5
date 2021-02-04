package com.example.x_smartcity_5.bean;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/4  14:54
 */
public class Fuwu_kuaidi {
    private String xiaoqu;
    private String qujianma;
    private String name;

    public Fuwu_kuaidi(String xiaoqu, String qujianma, String name) {
        this.xiaoqu = xiaoqu;
        this.qujianma = qujianma;
        this.name = name;
    }

    public String getXiaoqu() {
        return xiaoqu;
    }

    public void setXiaoqu(String xiaoqu) {
        this.xiaoqu = xiaoqu;
    }

    public String getQujianma() {
        return qujianma;
    }

    public void setQujianma(String qujianma) {
        this.qujianma = qujianma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
