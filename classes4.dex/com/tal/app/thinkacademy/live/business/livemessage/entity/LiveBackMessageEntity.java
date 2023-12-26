package com.tal.app.thinkacademy.live.business.livemessage.entity;

import com.google.gson.JsonObject;

public class LiveBackMessageEntity {
    public static final String MESSAGE_TYPE = "130";
    private long id;
    private int notice;
    private JsonObject text;

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public int getNotice() {
        return this.notice;
    }

    public void setNotice(int i) {
        this.notice = i;
    }

    public JsonObject getText() {
        return this.text;
    }

    public void setText(JsonObject jsonObject) {
        this.text = jsonObject;
    }
}
