package com.tal.app.thinkacademy.live.business.livemessage.entity;

public class LiveMessageEntity {
    public static final int MESSAGE_CLASSMATE = 2;
    public static final int MESSAGE_F_TEACHER = 4;
    public static final int MESSAGE_MINE = 0;
    public static final int MESSAGE_SYSTEM_TIP = 3;
    public static final int MESSAGE_SYSTEN_NOTICE = 8;
    public static final int MESSAGE_SYSTEN_NOTICE_MINE = 9;
    public static final int MESSAGE_TEACHER = 1;
    public static final String MODE_TRANING = "in-training";
    private CharSequence charText;
    private String emojiJsonString = "";
    private String evenNum;
    private String headUrl;
    private long id;
    private boolean isLoop = true;
    private String name;
    private String sender;
    private int type;

    public LiveMessageEntity(String str, int i, CharSequence charSequence, String str2) {
        this.sender = str;
        this.type = i;
        this.charText = charSequence;
        this.headUrl = str2;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String str) {
        this.sender = str;
    }

    public int getType() {
        return this.type;
    }

    public String getHeadUrl() {
        return this.headUrl;
    }

    public void setHeadUrl(String str) {
        this.headUrl = str;
    }

    public String getEvenNum() {
        return this.evenNum;
    }

    public void setEvenNum(String str) {
        this.evenNum = str;
    }

    public CharSequence getCharText() {
        return this.charText;
    }

    public void setCharText(CharSequence charSequence) {
        this.charText = charSequence;
    }

    public void setType(int i) {
        this.type = i;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getEmojiJsonString() {
        return this.emojiJsonString;
    }

    public void setEmojiJsonString(String str) {
        this.emojiJsonString = str;
    }

    public boolean isLoop() {
        return this.isLoop;
    }

    public void setLoop(boolean z) {
        this.isLoop = z;
    }

    public String toString() {
        return "LiveMessageEntity{sender='" + this.sender + '\'' + ", charText=" + this.charText + ", type=" + this.type + ", headUrl='" + this.headUrl + '\'' + ", evenNum='" + this.evenNum + '\'' + ", id=" + this.id + ", name='" + this.name + '\'' + ", emojiJsonString=" + this.emojiJsonString + ", isLoop=" + this.isLoop + '}';
    }
}
