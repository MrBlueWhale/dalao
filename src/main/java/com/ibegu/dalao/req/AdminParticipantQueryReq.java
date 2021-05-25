package com.ibegu.dalao.req;

import java.util.Date;

public class AdminParticipantQueryReq extends PageReq {
    private Long pid;

    private String nickname;

    private String name;

    private String university;

    private String college;

    private String telNum;

    private String email;

    private String idNumber;

    private Date joinDate;

    private Integer accountStatus;


    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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
        return "AdminParticipantQueryReq{" +
                "pid=" + pid +
                ", nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", university='" + university + '\'' +
                ", college='" + college + '\'' +
                ", telNum='" + telNum + '\'' +
                ", email='" + email + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", joinDate=" + joinDate +
                ", accountStatus=" + accountStatus +
                "} " + super.toString();
    }
}