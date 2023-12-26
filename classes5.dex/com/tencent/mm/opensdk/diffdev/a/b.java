package com.tencent.mm.opensdk.diffdev.a;

import android.os.Handler;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import java.util.ArrayList;

final class b implements OAuthListener {
    final /* synthetic */ a f;

    b(a aVar) {
        this.f = aVar;
    }

    public final void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
        Log.d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", new Object[]{oAuthErrCode.toString(), str}));
        d unused = this.f.d = null;
        ArrayList<OAuthListener> arrayList = new ArrayList<>();
        arrayList.addAll(this.f.c);
        for (OAuthListener onAuthFinish : arrayList) {
            onAuthFinish.onAuthFinish(oAuthErrCode, str);
        }
    }

    public final void onAuthGotQrcode(String str, byte[] bArr) {
        Log.d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = ".concat(String.valueOf(str)));
        ArrayList<OAuthListener> arrayList = new ArrayList<>();
        arrayList.addAll(this.f.c);
        for (OAuthListener onAuthGotQrcode : arrayList) {
            onAuthGotQrcode.onAuthGotQrcode(str, bArr);
        }
    }

    public final void onQrcodeScanned() {
        Log.d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
        if (this.f.handler != null) {
            Handler b = this.f.handler;
            c cVar = new c(this);
            if (!(b instanceof Handler)) {
                b.post(cVar);
            } else {
                AsynchronousInstrumentation.handlerPost(b, cVar);
            }
        }
    }
}
