package com.tal.app.thinkacademy.live.core.irc.entity;

public class BinaryMessageInfo {
    public byte[] content;
    public String from;
    public String key;
    public long keyMsgId;
    public long msgId;
    public String roomId;
    public long timestamp;

    public String toString() {
        return "BinaryMessageInfo{msgId=" + this.msgId + ", keyMsgId=" + this.keyMsgId + ", timestamp=" + this.timestamp + ", key='" + this.key + '\'' + ", roomId='" + this.roomId + '\'' + ", from='" + this.from + '\'' + '}';
    }
}
