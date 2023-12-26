package com.tal.app.thinkacademy.live.core.irc.entity;

public class HistoryBinMsgReqParam {
    public int count = -1;
    public String key;
    public long msgId;
    public boolean order = true;

    public String toString() {
        return "HistoryBinMsgReqParam{key='" + this.key + '\'' + ", msgId=" + this.msgId + ", count=" + this.count + ", order=" + this.order + '}';
    }
}
