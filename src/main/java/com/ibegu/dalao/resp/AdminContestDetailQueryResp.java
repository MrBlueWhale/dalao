package com.ibegu.dalao.resp;

public class AdminContestDetailQueryResp {
    private Long cid;

    private String contestName;

    private Long sponsorId;

    private String sponsorName;

    private String sponsorAvatar;

    private String registrationStartTime;

    private String registrationEndTime;

    private String competeStartTime;

    private String competeEndTime;

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

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public String getSponsorAvatar() {
        return sponsorAvatar;
    }

    public void setSponsorAvatar(String sponsorAvatar) {
        this.sponsorAvatar = sponsorAvatar;
    }

    public String getRegistrationStartTime() {
        return registrationStartTime;
    }

    public void setRegistrationStartTime(String registrationStartTime) {
        this.registrationStartTime = registrationStartTime;
    }

    public String getRegistrationEndTime() {
        return registrationEndTime;
    }

    public void setRegistrationEndTime(String registrationEndTime) {
        this.registrationEndTime = registrationEndTime;
    }

    public String getCompeteStartTime() {
        return competeStartTime;
    }

    public void setCompeteStartTime(String competeStartTime) {
        this.competeStartTime = competeStartTime;
    }

    public String getCompeteEndTime() {
        return competeEndTime;
    }

    public void setCompeteEndTime(String competeEndTime) {
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
        return "AdminContestDetailQueryResp{" +
                "cid=" + cid +
                ", contestName='" + contestName + '\'' +
                ", sponsorId=" + sponsorId +
                ", sponsorName='" + sponsorName + '\'' +
                ", sponsorAvatar='" + sponsorAvatar + '\'' +
                ", registrationStartTime='" + registrationStartTime + '\'' +
                ", registrationEndTime='" + registrationEndTime + '\'' +
                ", competeStartTime='" + competeStartTime + '\'' +
                ", competeEndTime='" + competeEndTime + '\'' +
                ", pageView=" + pageView +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", entryFee=" + entryFee +
                ", rank='" + rank + '\'' +
                ", audience='" + audience + '\'' +
                ", contestStatus=" + contestStatus +
                ", contestIntro='" + contestIntro + '\'' +
                '}';
    }
}