package com.ibegu.dalao.req;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AdminSponsorResetPasswordReq {
    private Long sid;

    @NotNull(message = "【密码】不能为空")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,32}$", message = "【密码】至少包含 数字和英文，长度6-32")
    private String password;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
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
                "sid=" + sid +
                ", password='" + password + '\'' +
                '}';
    }
}