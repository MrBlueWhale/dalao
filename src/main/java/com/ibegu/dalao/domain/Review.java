package com.ibegu.dalao.domain;

import java.util.Date;

public class Review {
    private Long rid;

    private Long contestId;

    private Long reviewerId;

    private String reviewContent;

    private Date reviewDate;

    private Integer like;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public Long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rid=").append(rid);
        sb.append(", contestId=").append(contestId);
        sb.append(", reviewerId=").append(reviewerId);
        sb.append(", reviewContent=").append(reviewContent);
        sb.append(", reviewDate=").append(reviewDate);
        sb.append(", like=").append(like);
        sb.append("]");
        return sb.toString();
    }
}