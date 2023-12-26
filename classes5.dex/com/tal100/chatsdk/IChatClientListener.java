package com.tal100.chatsdk;

import com.tal100.chatsdk.PMDefs;

public abstract class IChatClientListener {
    public void onKickoutNotice(PMDefs.KickoutNotice kickoutNotice) {
    }

    public void onLoginResponse(PMDefs.LoginResp loginResp) {
    }

    public void onLogoutNotice(PMDefs.LogoutNotice logoutNotice) {
    }

    public void onNetStatusChanged(PMDefs.NetStatusResp netStatusResp) {
    }

    public void onSdkPrivisionStatusNotice(PMDefs.SdkPrivisionStatusNotice sdkPrivisionStatusNotice) {
    }
}
