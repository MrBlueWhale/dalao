package com.ibegu.dalao.req;

import java.util.Date;

public class SponsorCreateContestReq {
    // private Long cid;

    private String contestName;

    private Long sponsorId;

    private String contestIntro;

    private Date registrationStartTime;

    private Date registrationEndTime;

    private Date competeStartTime;

    private Date competeEndTime;

    // private Integer pageView;

    private Integer entryFee;

    private Integer contestStatus;

    private String type;
    private String category;
    private String rank;
    private String audience;

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public Long getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(Long sponsorId) {
        this.sponsorId = sponsorId;
    }

    public String getContestIntro() {
        return contestIntro;
    }

    public void setContestIntro(String contestIntro) {
        this.contestIntro = contestIntro;
    }

    public Date getRegistrationStartTime() {
        return registrationStartTime;
    }

    public void setRegistrationStartTime(Date registrationStartTime) {
        this.registrationStartTime = registrationStartTime;
    }

    public Date getRegistrationEndTime() {
        return registrationEndTime;
    }

    public void setRegistrationEndTime(Date registrationEndTime) {
        this.registrationEndTime = registrationEndTime;
    }

    public Date getCompeteStartTime() {
        return competeStartTime;
    }

    public void setCompeteStartTime(Date competeStartTime) {
        this.competeStartTime = competeStartTime;
    }

    public Date getCompeteEndTime() {
        return competeEndTime;
    }

    public void setCompeteEndTime(Date competeEndTime) {
        this.competeEndTime = competeEndTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(Integer entryFee) {
        this.entryFee = entryFee;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public Integer getContestStatus() {
        return contestStatus;
    }

    public void setContestStatus(Integer contestStatus) {
        this.contestStatus = contestStatus;
    }

    @Override
    public String toString() {
        return "SponsorCreateContestReq{" +
                "contestName='" + contestName + '\'' +
                ", sponsorId=" + sponsorId +
                ", contestIntro='" + contestIntro + '\'' +
                ", registrationStartTime=" + registrationStartTime +
                ", registrationEndTime=" + registrationEndTime +
                ", competeStartTime=" + competeStartTime +
                ", competeEndTime=" + competeEndTime +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", entryFee=" + entryFee +
                ", rank='" + rank + '\'' +
                ", audience='" + audience + '\'' +
                ", contestStatus=" + contestStatus +
                '}';
    }
}