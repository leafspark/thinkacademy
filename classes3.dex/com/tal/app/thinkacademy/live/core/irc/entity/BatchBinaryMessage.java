package com.tal.app.thinkacademy.live.core.irc.entity;

import java.util.List;

public class BatchBinaryMessage {
    public int code;
    public String info;
    public List<BinaryMessage> keyMsgs;
    public long traceId;

    public String toString() {
        return "BinaryMessage{, code=" + this.code + ", info='" + this.info + '\'' + ", traceId=" + this.traceId + '}';
    }
}
