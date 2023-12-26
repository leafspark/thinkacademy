package com.didi.hummer.devtools;

import com.didi.hummer.devtools.HummerDevTools;
import com.didi.hummer.devtools.ws.WebSocketManager;

public final /* synthetic */ class HummerDevTools$$ExternalSyntheticLambda1 implements WebSocketManager.WSMsgListener {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ HummerDevTools.IHotReloadCallback f$1;

    public /* synthetic */ HummerDevTools$$ExternalSyntheticLambda1(String str, HummerDevTools.IHotReloadCallback iHotReloadCallback) {
        this.f$0 = str;
        this.f$1 = iHotReloadCallback;
    }

    public final void onMsgReceived(String str) {
        HummerDevTools.lambda$connectWebSocket$0(this.f$0, this.f$1, str);
    }
}
