package com.ibegu.dalao.req;

import java.util.Date;

public class ContestReq extends PageReq{

    private Long cid;

    private String contestName;

    private Date competeStartTime;

    private Date competeEndTime;

    private String type;

    private String category;

    private Integer entryFee;

    private String rank;


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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cid=").append(cid);
        sb.append(", contestName=").append(contestName);
        sb.append(", competeStartTime=").append(competeStartTime);
        sb.append(", competeEndTime=").append(competeEndTime);
        sb.append(", type=").append(type);
        sb.append(", category=").append(category);
        sb.append(", entryFee=").append(entryFee);
        sb.append(", rank=").append(rank);
        sb.append("]");
        return sb.toString();
    }
}