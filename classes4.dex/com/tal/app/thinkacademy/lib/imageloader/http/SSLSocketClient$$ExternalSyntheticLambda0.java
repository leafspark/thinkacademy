package com.tal.app.thinkacademy.lib.imageloader.http;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public final /* synthetic */ class SSLSocketClient$$ExternalSyntheticLambda0 implements HostnameVerifier {
    public static final /* synthetic */ SSLSocketClient$$ExternalSyntheticLambda0 INSTANCE = new SSLSocketClient$$ExternalSyntheticLambda0();

    private /* synthetic */ SSLSocketClient$$ExternalSyntheticLambda0() {
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        return SSLSocketClient.m88_get_hostnameVerifier_$lambda0(str, sSLSession);
    }
}
