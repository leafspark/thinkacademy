package com.adyen.checkout.core.api;

import com.bonree.sdk.agent.engine.external.HttpInstrumentation;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

abstract class BaseHttpUrlConnectionFactory {
    /* access modifiers changed from: package-private */
    public abstract HttpURLConnection handleInsecureConnection(HttpURLConnection httpURLConnection);

    BaseHttpUrlConnectionFactory() {
    }

    static {
        HttpsURLConnection.setDefaultSSLSocketFactory(SSLSocketUtil.TLS_SOCKET_FACTORY);
    }

    /* access modifiers changed from: package-private */
    public HttpURLConnection createHttpUrlConnection(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) HttpInstrumentation.openConnection(new URL(str).openConnection());
        if (!(httpURLConnection instanceof HttpsURLConnection)) {
            return handleInsecureConnection(httpURLConnection);
        }
        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(SSLSocketUtil.TLS_SOCKET_FACTORY);
        return httpURLConnection;
    }
}
