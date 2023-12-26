package com.tal100.chatsdk;

import com.tal100.chatsdk.PMDefs;

public abstract class ITMChannelListener {
    public void onChannelStateChanged(PMDefs.TMChannelStatusNotice tMChannelStatusNotice) {
    }

    public void onKickoutNotice(PMDefs.TMChannelKickoutNotice tMChannelKickoutNotice) {
    }

    public void onKickoutResponse(PMDefs.TMChannelKickoutResponse tMChannelKickoutResponse) {
    }

    public void onRecvBinaryDataNotice(PMDefs.TMRecvChannelBinaryDataNotice tMRecvChannelBinaryDataNotice) {
    }

    public void onRecvDataNotice(PMDefs.TMRecvChannelDataNotice tMRecvChannelDataNotice) {
    }

    public void onSendBinaryDataResponse(PMDefs.TMSendChannelBinaryDataResponse tMSendChannelBinaryDataResponse) {
    }

    public void onSendDataResponse(PMDefs.TMSendChannelDataResponse tMSendChannelDataResponse) {
    }
}
