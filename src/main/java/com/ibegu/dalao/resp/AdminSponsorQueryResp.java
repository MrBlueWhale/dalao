package com.ibegu.dalao.resp;

import java.util.Date;

public class AdminSponsorQueryResp {
    private Long sid;

    private String avatar;

    private String name;

    private String address;

    private String telNum;

    private String email;

    // private String password;

    private String intro;

    private String identityStatus;

    private Date joinDate;

    private Integer accountStatus;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getIdentityStatus() {
        return identityStatus;
    }

    public void setIdentityStatus(String identityStatus) {
        this.identityStatus = identityStatus;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "AdminSponsorQueryResp{" +
                "sid=" + sid +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telNum='" + telNum + '\'' +
                ", email='" + email + '\'' +
                ", intro='" + intro + '\'' +
                ", identityStatus='" + identityStatus + '\'' +
                ", joinDate=" + joinDate +
                ", accountStatus=" + accountStatus +
                '}';
    }
}