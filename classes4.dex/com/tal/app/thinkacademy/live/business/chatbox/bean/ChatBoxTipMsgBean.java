package com.tal.app.thinkacademy.live.business.chatbox.bean;

import java.io.Serializable;

public class ChatBoxTipMsgBean extends ChatBoxItemBean implements Serializable {
    private String tip;

    public String getTip() {
        return this.tip;
    }

    public void setTip(String str) {
        this.tip = str;
    }
}
