package com.tal.app.thinkacademy.live.core.irc.entity;

import java.io.Serializable;

public class FromUserInfoBean implements Serializable {
    private String ircNickname;
    private String path;
    private String userId;
    private String username;

    public String getIrcNickname() {
        return this.ircNickname;
    }

    public void setIrcNickname(String str) {
        this.ircNickname = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }
}
