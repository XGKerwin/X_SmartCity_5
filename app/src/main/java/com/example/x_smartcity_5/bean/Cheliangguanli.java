package com.example.x_smartcity_5.bean;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/4  17:57
 */
public class Cheliangguanli {
    //车牌号码、车位号、停车卡号、车主姓名、车主手机号、相关住户姓名和地址。

    private String cph,cwh,tckh,name,tel,dizhi,beizhu;

    public Cheliangguanli(String cph, String cwh, String tckh, String name, String tel, String dizhi, String beizhu) {
        this.cph = cph;
        this.cwh = cwh;
        this.tckh = tckh;
        this.name = name;
        this.tel = tel;
        this.dizhi = dizhi;
        this.beizhu = beizhu;
    }

    public String getCph() {
        return cph;
    }

    public void setCph(String cph) {
        this.cph = cph;
    }

    public String getCwh() {
        return cwh;
    }

    public void setCwh(String cwh) {
        this.cwh = cwh;
    }

    public String getTckh() {
        return tckh;
    }

    public void setTckh(String tckh) {
        this.tckh = tckh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDizhi() {
        return dizhi;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }
}
