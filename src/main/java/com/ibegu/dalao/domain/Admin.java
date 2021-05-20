package com.ibegu.dalao.domain;

import java.util.Date;

public class Admin {
    private Long aid;

    private String avatar;

    private String password;

    private String telNum;

    private String email;

    private String adminKey;

    private Date joinDate;

    private String adminName;

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdminKey() {
        return adminKey;
    }

    public void setAdminKey(String adminKey) {
        this.adminKey = adminKey;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", aid=").append(aid);
        sb.append(", avatar=").append(avatar);
        sb.append(", password=").append(password);
        sb.append(", telNum=").append(telNum);
        sb.append(", email=").append(email);
        sb.append(", adminKey=").append(adminKey);
        sb.append(", joinDate=").append(joinDate);
        sb.append(", adminName=").append(adminName);
        sb.append("]");
        return sb.toString();
    }
}