package com.tal.app.thinkacademy.live.business.chatbox.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public abstract class ChatBoxItemBean implements MultiItemEntity {
    public static final int ITEM_TYPE_ME_EMOJI = 6;
    public static final int ITEM_TYPE_ME_TEXT = 2;
    public static final int ITEM_TYPE_OTHER_STUDENT_EMOJI = 5;
    public static final int ITEM_TYPE_OTHER_STUDENT_TEXT = 1;
    public static final int ITEM_TYPE_TEACHER_EMOJI = 7;
    public static final int ITEM_TYPE_TEACHER_TEXT = 4;
    public static final int ITEM_TYPE_TIP = 3;
    public static final int ITEM_TYPE_UNKNOWN = -1;
    private String msgType;
    private String sendStatus;
    private ChatBoxSendToType sendToType = ChatBoxSendToType.ALL;
    private String toUid;

    public String getMsgType() {
        return this.msgType;
    }

    public void setMsgType(String str) {
        this.msgType = str;
    }

    public String getSendStatus() {
        return this.sendStatus;
    }

    public void setSendStatus(String str) {
        this.sendStatus = str;
    }

    public ChatBoxSendToType getSendToType() {
        return this.sendToType;
    }

    public void setSendToType(ChatBoxSendToType chatBoxSendToType) {
        this.sendToType = chatBoxSendToType;
    }

    public String getToUid() {
        return this.toUid;
    }

    public void setToUid(String str) {
        this.toUid = str;
    }

    public int getItemType() {
        if (ChatBoxMsgType.ME.name().equals(getMsgType())) {
            return 2;
        }
        if (ChatBoxMsgType.OTHER_STUDENT.name().equals(getMsgType())) {
            return 1;
        }
        if (ChatBoxMsgType.TEACHER.name().equals(getMsgType()) || ChatBoxMsgType.TUTOR.name().equals(getMsgType())) {
            return 4;
        }
        if (ChatBoxMsgType.SYSTEM.name().equals(getMsgType()) || ChatBoxMsgType.TIP.name().equals(getMsgType())) {
            return 3;
        }
        if (ChatBoxMsgType.ME_EMOJI.name().equals(getMsgType())) {
            return 6;
        }
        if (ChatBoxMsgType.OTHER_STUDENT_EMOJI.name().equals(getMsgType())) {
            return 5;
        }
        return (ChatBoxMsgType.TEACHER_EMOJI.name().equals(getMsgType()) || ChatBoxMsgType.TUTOR_EMOJI.name().equals(getMsgType())) ? 7 : -1;
    }
}
