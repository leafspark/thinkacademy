package com.igexin.sdk.message;

public class GTNotificationMessage extends GTPushMessage {
    private String a;
    private String b;
    private String c;
    private String d;

    public GTNotificationMessage() {
    }

    public GTNotificationMessage(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public String getContent() {
        return this.d;
    }

    public String getMessageId() {
        return this.b;
    }

    public String getTaskId() {
        return this.a;
    }

    public String getTitle() {
        return this.c;
    }

    public void setContent(String str) {
        this.d = str;
    }

    public void setMessageId(String str) {
        this.b = str;
    }

    public void setTaskId(String str) {
        this.a = str;
    }

    public void setTitle(String str) {
        this.c = str;
    }
}
