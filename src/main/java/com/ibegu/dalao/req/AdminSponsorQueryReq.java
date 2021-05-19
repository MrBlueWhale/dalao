package com.ibegu.dalao.req;

import java.util.Date;

public class AdminSponsorQueryReq extends PageReq {
    private Long sid;

    // private String avatar;

    private String name;

    private String address;

    // private String telNum;

    // private String email;

    // private String password;

    // private String intro;

    private String identityStatus;

    private Date joinDate;

    private Integer accountStatus;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
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
        return "AdminSponsorQueryReq{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", identityStatus='" + identityStatus + '\'' +
                ", joinDate=" + joinDate +
                ", accountStatus=" + accountStatus +
                "} " + super.toString();
    }
}