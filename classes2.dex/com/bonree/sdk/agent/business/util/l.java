package com.bonree.sdk.agent.business.util;

import android.text.TextUtils;
import com.bonree.sdk.be.f;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

final class l implements HostnameVerifier {
    private /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        if (k.a(this.a)) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a.q, sSLSession);
        }
        String peerHost = sSLSession.getPeerHost();
        if (TextUtils.isEmpty(peerHost)) {
            return false;
        }
        f c = this.a.r;
        c.c("peerHost : " + peerHost, new Object[0]);
        if (!peerHost.contains("317844B0CDB0A832")) {
            return true;
        }
        return false;
    }
}
