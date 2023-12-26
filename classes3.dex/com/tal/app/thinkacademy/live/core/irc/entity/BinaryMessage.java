package com.tal.app.thinkacademy.live.core.irc.entity;

import java.util.List;

public class BinaryMessage {
    public int code;
    public List<BinaryMessageInfo> contents;
    public String info;
    public boolean isHistory;
    public String key;
    public boolean order;
    public long traceId;

    public String toString() {
        return "BinaryMessage{isHistory=" + this.isHistory + ", code=" + this.code + ", info='" + this.info + '\'' + ", key='" + this.key + '\'' + ", traceId=" + this.traceId + ", order=" + this.order + ", contents=" + this.contents + '}';
    }
}
