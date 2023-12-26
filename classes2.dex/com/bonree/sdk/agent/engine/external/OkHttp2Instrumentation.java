package com.bonree.sdk.agent.engine.external;

import android.text.TextUtils;
import com.bonree.sdk.agent.engine.network.okhttp2.external.CallExtension;
import com.bonree.sdk.i.l;
import com.bonree.sdk.m.g;
import com.bonree.sdk.m.k;
import com.bonree.sdk.n.b;
import com.bonree.sdk.q.a;
import com.bonree.sdk.q.d;
import com.didi.hummer.adapter.navigator.impl.DefaultNavigatorAdapter;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.internal.Version;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class OkHttp2Instrumentation {
    private static final String OKHTTP2_NEWCALL = "okhttp2/newCall";

    public static Call newCall(OkHttpClient okHttpClient, Request request) {
        try {
            b bVar = new b();
            URL url = request != null ? request.url() : null;
            if (!isSpecificOkhttp()) {
                if (g.a().b()) {
                    if (url != null) {
                        k.b().a(url.getHost(), url.getPath(), bVar.X(), request, k.a.e);
                    }
                    l.b(OKHTTP2_NEWCALL, url, bVar.X());
                    Call newCall = okHttpClient.newCall(request);
                    l.b(OKHTTP2_NEWCALL, url, bVar.X());
                    return new CallExtension(okHttpClient, newCall, request, bVar, getOk2Timeout(okHttpClient));
                }
            }
            l.a(OKHTTP2_NEWCALL, url, (String) null);
            Call newCall2 = okHttpClient.newCall(request);
            l.b(OKHTTP2_NEWCALL, url, (String) null);
            return newCall2;
        } catch (Throwable unused) {
            return okHttpClient.newCall(request);
        }
    }

    private static int getOk2Timeout(OkHttpClient okHttpClient) {
        int connectTimeout = okHttpClient.getConnectTimeout() + okHttpClient.getReadTimeout() + okHttpClient.getWriteTimeout();
        if (connectTimeout > 0) {
            return connectTimeout;
        }
        return 10000;
    }

    public static String getVersion() {
        try {
            Method declaredMethod = Class.forName("com.squareup.okhttp.internal.Version").getDeclaredMethod("userAgent", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke((Object) null, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean isSpecificOkhttp() {
        String[] split;
        try {
            String userAgent = Version.userAgent();
            if (TextUtils.isEmpty(userAgent) || (split = userAgent.split("/")) == null || split[1].startsWith("2.4.")) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static HttpURLConnection open(OkUrlFactory okUrlFactory, URL url) {
        try {
            HttpURLConnection open = okUrlFactory.open(url);
            String protocol = url.getProtocol();
            if (protocol.equals("http")) {
                return new a(open, new b());
            }
            if (!protocol.equals(DefaultNavigatorAdapter.SCHEME_HTTPS) || !(open instanceof HttpsURLConnection)) {
                return new a(open, new b());
            }
            return new d((HttpsURLConnection) open, new b());
        } catch (Throwable unused) {
            return okUrlFactory.open(url);
        }
    }

    public static HttpURLConnection open(HttpURLConnection httpURLConnection) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            return new d((HttpsURLConnection) httpURLConnection, new b());
        }
        if (httpURLConnection != null) {
            return new a(httpURLConnection, new b());
        }
        return null;
    }

    public static HttpURLConnection openWithProxy(HttpURLConnection httpURLConnection) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            return new d((HttpsURLConnection) httpURLConnection, new b());
        }
        if (httpURLConnection != null) {
            return new a(httpURLConnection, new b());
        }
        return null;
    }
}
