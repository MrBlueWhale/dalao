package com.ibegu.dalao.domain;

import java.util.Date;

public class Reply {
    private Long rpid;

    private Long rid;

    private Long fromId;

    private Long toId;

    private String replyContent;

    private Integer like;

    private Date replyDate;

    public Long getRpid() {
        return rpid;
    }

    public void setRpid(Long rpid) {
        this.rpid = rpid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rpid=").append(rpid);
        sb.append(", rid=").append(rid);
        sb.append(", fromId=").append(fromId);
        sb.append(", toId=").append(toId);
        sb.append(", replyContent=").append(replyContent);
        sb.append(", like=").append(like);
        sb.append(", replyDate=").append(replyDate);
        sb.append("]");
        return sb.toString();
    }
}