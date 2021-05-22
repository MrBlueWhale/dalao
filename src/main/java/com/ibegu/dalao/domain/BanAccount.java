package com.ibegu.dalao.domain;

import java.util.Date;

public class BanAccount {
    private Long bid;

    private String reason;

    private Date bannedtime;

    private String interval;

    private Long uid;

    private String note;

    private Date releasetime;

    private Integer userType;

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getBannedtime() {
        return bannedtime;
    }

    public void setBannedtime(Date bannedtime) {
        this.bannedtime = bannedtime;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
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

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bid=").append(bid);
        sb.append(", reason=").append(reason);
        sb.append(", bannedtime=").append(bannedtime);
        sb.append(", interval=").append(interval);
        sb.append(", uid=").append(uid);
        sb.append(", note=").append(note);
        sb.append(", releasetime=").append(releasetime);
        sb.append(", userType=").append(userType);
        sb.append("]");
        return sb.toString();
    }
}