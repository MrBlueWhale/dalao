package com.ibegu.dalao.resp;

import java.util.ArrayList;
import java.util.Date;

public class AdminViewBannedAccountResp {
    // private Long bid;

    private String reason;

    private Date releasetime;

    private Date bannedtime;

    // private Integer userType;

    private ArrayList<String> banType;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public Date getBannedtime() {
        return bannedtime;
    }

    public void setBannedtime(Date bannedtime) {
        this.bannedtime = bannedtime;
    }

    public ArrayList<String> getBanType() {
        return banType;
    }

    public void setBanType(ArrayList<String> banType) {
        this.banType = banType;
    }

    @Override
    public String toString() {
        return "AdminViewBannedAccountResp{" +
                "reason='" + reason + '\'' +
                ", releasetime=" + releasetime +
                ", bannedtime=" + bannedtime +
                ", banType=" + banType +
                '}';
    }
}