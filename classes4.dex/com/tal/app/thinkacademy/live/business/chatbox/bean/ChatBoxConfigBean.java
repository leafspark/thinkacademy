package com.tal.app.thinkacademy.live.business.chatbox.bean;

import java.io.Serializable;
import java.util.List;

public class ChatBoxConfigBean implements Serializable {
    private String messageMaxLength;
    private List<String> quickMsgArray;
    private String quickMsgList;
    private int sendMsgCount;
    private int sendMsgFrozenTime;
    private int sendMsgGap;

    public boolean hasSendControl() {
        return this.sendMsgCount > 0 && this.sendMsgFrozenTime > 0 && this.sendMsgGap > 0;
    }

    public List<String> getQuickMsgArray() {
        return this.quickMsgArray;
    }

    public void setQuickMsgArray(List<String> list) {
        this.quickMsgArray = list;
    }

    public String getMessageMaxLength() {
        return this.messageMaxLength;
    }

    public void setMessageMaxLength(String str) {
        this.messageMaxLength = str;
    }

    public String getQuickMsgList() {
        return this.quickMsgList;
    }

    public void setQuickMsgList(String str) {
        this.quickMsgList = str;
    }

    public int getSendMsgCount() {
        return this.sendMsgCount;
    }

    public void setSendMsgCount(int i) {
        this.sendMsgCount = i;
    }

    public int getSendMsgFrozenTime() {
        return this.sendMsgFrozenTime;
    }

    public void setSendMsgFrozenTime(int i) {
        this.sendMsgFrozenTime = i;
    }

    public int getSendMsgGap() {
        return this.sendMsgGap;
    }

    public void setSendMsgGap(int i) {
        this.sendMsgGap = i;
    }
}
