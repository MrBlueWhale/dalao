package com.ibegu.dalao.domain;

import java.util.Date;

public class Contest {
    private Long cid;

    private String contestName;

    private Long sponsorId;

    private Date registrationStartTime;

    private Date registrationEndTime;

    private Date competeStartTime;

    private Date competeEndTime;

    private Integer pageView;

    private String type;

    private String category;

    private Integer entryFee;

    private String rank;

    private String audience;

    private Integer contestStatus;

    private String contestIntro;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

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

    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
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

    public String getContestIntro() {
        return contestIntro;
    }

    public void setContestIntro(String contestIntro) {
        this.contestIntro = contestIntro;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cid=").append(cid);
        sb.append(", contestName=").append(contestName);
        sb.append(", sponsorId=").append(sponsorId);
        sb.append(", registrationStartTime=").append(registrationStartTime);
        sb.append(", registrationEndTime=").append(registrationEndTime);
        sb.append(", competeStartTime=").append(competeStartTime);
        sb.append(", competeEndTime=").append(competeEndTime);
        sb.append(", pageView=").append(pageView);
        sb.append(", type=").append(type);
        sb.append(", category=").append(category);
        sb.append(", entryFee=").append(entryFee);
        sb.append(", rank=").append(rank);
        sb.append(", audience=").append(audience);
        sb.append(", contestStatus=").append(contestStatus);
        sb.append(", contestIntro=").append(contestIntro);
        sb.append("]");
        return sb.toString();
    }
}