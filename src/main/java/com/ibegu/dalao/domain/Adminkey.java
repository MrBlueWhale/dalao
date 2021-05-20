package com.ibegu.dalao.domain;

public class Adminkey {
    private Long akid;

    private String adminKey;

    private Integer ifUsed;

    public Long getAkid() {
        return akid;
    }

    public void setAkid(Long akid) {
        this.akid = akid;
    }

    public String getAdminKey() {
        return adminKey;
    }

    public void setAdminKey(String adminKey) {
        this.adminKey = adminKey;
    }

    public Integer getIfUsed() {
        return ifUsed;
    }

    public void setIfUsed(Integer ifUsed) {
        this.ifUsed = ifUsed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", akid=").append(akid);
        sb.append(", adminKey=").append(adminKey);
        sb.append(", ifUsed=").append(ifUsed);
        sb.append("]");
        return sb.toString();
    }
}