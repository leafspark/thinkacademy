package com.wushuangtech.expansion.bean;

public class ChatInfo {
    public int audioDuration;
    public String chatData;
    public int chatType;
    public String seqID;

    public String toString() {
        return "ChatInfo{chatType=" + this.chatType + ", seqID='" + this.seqID + '\'' + ", chatData='" + this.chatData + '\'' + ", audioDuration=" + this.audioDuration + '}';
    }
}
