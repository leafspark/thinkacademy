package com.tal.app.thinkacademy.live.business.chatbox.bean;

import java.io.Serializable;

public class ChatBoxTextMsgBean extends ChatBoxItemBean implements Serializable {
    private String msg;
    private String name;
    private String path;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
