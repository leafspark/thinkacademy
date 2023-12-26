package com.tal.app.thinkacademy.live.business.canvastriplescreen.entity;

public class CanvasBinaryEntity {
    private String content;
    private long msgId;
    private long ts;

    public long getMsgId() {
        return this.msgId;
    }

    public void setMsgId(long j) {
        this.msgId = j;
    }

    public long getTs() {
        return this.ts;
    }

    public void setTs(long j) {
        this.ts = j;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }
}
