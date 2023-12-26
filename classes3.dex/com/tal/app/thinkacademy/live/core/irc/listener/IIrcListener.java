package com.tal.app.thinkacademy.live.core.irc.listener;

import com.tal.app.thinkacademy.live.core.irc.entity.MessageInfo;
import java.util.List;

public abstract class IIrcListener {
    public void onRoomHistoryMessage(List<MessageInfo> list) {
    }

    public void onSendPeerMessageFailed(int i, String str, long j) {
    }

    public void onSendPeerMessageSuccess(long j) {
    }

    public void onSendRoomMessageFailed(int i, String str, long j) {
    }

    public void onSendRoomMessageSuccess(long j) {
    }
}
