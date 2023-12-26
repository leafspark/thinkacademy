package com.tal100.chatsdk;

import com.tal100.chatsdk.PMDefs;

public abstract class IPeerChatListener {
    public void onRecvPeerBinaryMessage(PMDefs.PeerChatBinaryMessage peerChatBinaryMessage) {
    }

    public void onRecvPeerMessage(PMDefs.PeerChatMessage peerChatMessage) {
    }

    public void onSendPeerBinaryMessageResponse(PMDefs.SendPeerBinaryMessageResp sendPeerBinaryMessageResp) {
    }

    public void onSendPeerMessageResponse(PMDefs.SendPeerMessageResp sendPeerMessageResp) {
    }
}
