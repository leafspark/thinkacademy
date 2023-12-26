package com.tal.app.thinkacademy.live.core.irc.entity;

import java.io.Serializable;

public class MsgBean<T> implements Serializable {
    private T data;
    private FromUserInfoBean from;
    private String ircType;
    private Long sendTime;

    public String getIrcType() {
        return this.ircType;
    }

    public void setIrcType(String str) {
        this.ircType = str;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T t) {
        this.data = t;
    }

    public FromUserInfoBean getFrom() {
        return this.from;
    }

    public void setFrom(FromUserInfoBean fromUserInfoBean) {
        this.from = fromUserInfoBean;
    }

    public long getSendTime() {
        return this.sendTime.longValue();
    }

    public void setSendTime(long j) {
        this.sendTime = Long.valueOf(j);
    }
}
