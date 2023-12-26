package com.bonree.sdk.agent.engine.network.cronet;

import java.nio.ByteBuffer;
import org.chromium.net.CronetException;
import org.chromium.net.RequestFinishedInfo;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

public final class a extends UrlRequest.Callback {
    private final UrlRequest.Callback a;
    private final com.bonree.sdk.n.a b;

    public a(String str, UrlRequest.Callback callback, com.bonree.sdk.n.a aVar) {
        this.a = callback;
        this.b = aVar;
        aVar.a(str);
    }

    public final void onFinished(RequestFinishedInfo requestFinishedInfo) {
        b.a(requestFinishedInfo, this.b);
    }

    public final void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception {
        this.a.onRedirectReceived(urlRequest, urlResponseInfo, str);
    }

    public final void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception {
        this.a.onResponseStarted(urlRequest, urlResponseInfo);
    }

    public final void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception {
        this.a.onReadCompleted(urlRequest, urlResponseInfo, byteBuffer);
    }

    public final void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        b.a(urlRequest, this.b);
        this.a.onSucceeded(urlRequest, urlResponseInfo);
    }

    public final void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        b.a(urlRequest, this.b);
        this.a.onFailed(urlRequest, urlResponseInfo, cronetException);
    }

    public final void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.a.onCanceled(urlRequest, urlResponseInfo);
    }
}
