package com.ibegu.dalao.resp;

import com.ibegu.dalao.req.PageReq;

import java.util.Date;

public class LoginParticipantResp{
    private Long pid;

    private String str;



    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getString() {
        return str;
    }

    public void setString(String str) {
        this.str = str;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pid=").append(pid);
        sb.append(", str=").append(str);
        sb.append("]");
        return sb.toString();
    }
}