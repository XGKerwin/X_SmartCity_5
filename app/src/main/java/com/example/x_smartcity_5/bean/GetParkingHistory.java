package com.example.x_smartcity_5.bean;

/**
 * author : 关鑫
 * Github : XGKerwin
 * date   : 2021/2/5  15:53
 */
public class GetParkingHistory {

    /**
     * id : 28
     * carNum : 沪B30098
     * charge : 6
     * inTime : 2020-08-11 02:21:30
     * outTime : 2020-08-11 05:21:30
     * parkingid : 2
     */

    private int id;
    private String carNum;
    private String charge;
    private String inTime;
    private String outTime;
    private String parkingid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getParkingid() {
        return parkingid;
    }

    public void setParkingid(String parkingid) {
        this.parkingid = parkingid;
    }
}
