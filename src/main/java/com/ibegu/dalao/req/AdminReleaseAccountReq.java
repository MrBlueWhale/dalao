package com.ibegu.dalao.req;

import java.util.ArrayList;
import java.util.Date;

public class AdminReleaseAccountReq {
    // private Long bid;

    private Boolean delivery;

    // private String reason;

    // private Date bannedtime;

    // private String interval;

    private Long uid;

    private String note;

    private Date releasetime;

    // private Date bannedtime;

    private Integer userType;

    private ArrayList<String> banType;

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Boolean getDelivery() {
        return delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public ArrayList<String> getBanType() {
        return banType;
    }

    public void setBanType(ArrayList<String> banType) {
        this.banType = banType;
    }

    @Override
    public String toString() {
        return "AdminReleaseAccountReq{" +
                "delivery=" + delivery +
                ", uid=" + uid +
                ", note='" + note + '\'' +
                ", releasetime=" + releasetime +
                ", userType=" + userType +
                ", banType=" + banType +
                '}';
    }
}