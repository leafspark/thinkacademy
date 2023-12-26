package com.tal.app.thinkacademy.live.core.irc.entity;

import java.io.Serializable;

public class MessageInfo implements Serializable {
    private String ircType;
    private String msg;

    public String getIrcType() {
        return this.ircType;
    }

    public void setIrcType(String str) {
        this.ircType = str;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
