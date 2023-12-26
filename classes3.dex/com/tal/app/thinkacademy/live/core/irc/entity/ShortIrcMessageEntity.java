package com.tal.app.thinkacademy.live.core.irc.entity;

public class ShortIrcMessageEntity implements Comparable<ShortIrcMessageEntity> {
    private String ircKey;
    private String message;
    private long sendTime;

    public ShortIrcMessageEntity(String str, long j, String str2) {
        this.ircKey = str;
        this.sendTime = j;
        this.message = str2;
    }

    public String getIrcKey() {
        return this.ircKey;
    }

    public void setIrcKey(String str) {
        this.ircKey = str;
    }

    public long getSendTime() {
        return this.sendTime;
    }

    public void setSendTime(long j) {
        this.sendTime = j;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public int compareTo(ShortIrcMessageEntity shortIrcMessageEntity) {
        return (int) (shortIrcMessageEntity.sendTime - this.sendTime);
    }
}
