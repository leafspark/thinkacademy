package com.bonree.sdk.agent.business.entity;

public class LogReturnUserInfoResponseBean {
    public int code;
    public String data;
    public String message;

    public boolean isSuccess() {
        return this.code == 200;
    }

    public String toString() {
        return "UserInfoResponse{code=" + this.code + ", data='" + this.data + '\'' + ", message='" + this.message + '\'' + '}';
    }
}
