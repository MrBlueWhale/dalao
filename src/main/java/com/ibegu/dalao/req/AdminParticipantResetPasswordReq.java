package com.ibegu.dalao.req;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AdminParticipantResetPasswordReq {
    private Long pid;

    @NotNull(message = "【密码】不能为空")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,32}$", message = "【密码】至少包含 数字和英文，长度6-32")
    private String password;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminSponsorResetPasswordReq{" +
                "pid=" + pid +
                ", password='" + password + '\'' +
                '}';
    }
}