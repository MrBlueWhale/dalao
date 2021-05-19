package com.ibegu.dalao.domain;

import java.util.Date;

public class Notification {
    private Long nid;

    private Long contestId;

    private Date releaseTime;

    private String notifyContent;

    private String promulgator;

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
    }

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getNotifyContent() {
        return notifyContent;
    }

    public void setNotifyContent(String notifyContent) {
        this.notifyContent = notifyContent;
    }

    public String getPromulgator() {
        return promulgator;
    }

    public void setPromulgator(String promulgator) {
        this.promulgator = promulgator;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nid=").append(nid);
        sb.append(", contestId=").append(contestId);
        sb.append(", releaseTime=").append(releaseTime);
        sb.append(", notifyContent=").append(notifyContent);
        sb.append(", promulgator=").append(promulgator);
        sb.append("]");
        return sb.toString();
    }
}