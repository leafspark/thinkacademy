package com.bonree.sdk.agent.engine.external;

import com.bonree.sdk.i.l;
import com.bonree.sdk.m.g;
import com.bonree.sdk.m.k;
import com.bonree.sdk.n.b;
import com.bonree.sdk.q.a;
import com.bonree.sdk.q.d;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public class HttpFilterInstrumentation extends HttpInstrumentation {
    private static final String HTTPCLIENT_EXECUTE = "HttpClient/execute";
    private static final String HTTP_URL_CONNECTION = "HttpURLConnection";
    private static final String URLCONNECTION_OPENCONNECTION = "URLConnection/openConnection";
    private static final String URLCONNECTION_OPENCONNECTION_PROXY = "URLConnection/openConnectionWithProxy";

    public static URLConnection openConnectionFilter(URLConnection uRLConnection) {
        if (uRLConnection == null) {
            return uRLConnection;
        }
        if (!g.a().b()) {
            l.a(URLCONNECTION_OPENCONNECTION, uRLConnection.getURL(), (String) null);
            l.b(URLCONNECTION_OPENCONNECTION, uRLConnection.getURL(), (String) null);
            return uRLConnection;
        }
        b bVar = new b();
        bVar.b(true);
        k.b().a(uRLConnection.getURL().getHost(), uRLConnection.getURL().getPath(), bVar.X(), uRLConnection, k.a.b);
        try {
            l.a(URLCONNECTION_OPENCONNECTION, uRLConnection.getURL(), bVar.X());
            if (uRLConnection instanceof HttpsURLConnection) {
                d dVar = new d((HttpsURLConnection) uRLConnection, bVar);
                l.b(URLCONNECTION_OPENCONNECTION, uRLConnection.getURL(), bVar.X());
                return dVar;
            }
            if (uRLConnection instanceof HttpURLConnection) {
                a aVar = new a((HttpURLConnection) uRLConnection, bVar);
                l.b(URLCONNECTION_OPENCONNECTION, uRLConnection.getURL(), bVar.X());
                return aVar;
            }
            return uRLConnection;
        } catch (Throwable unused) {
            l.b(URLCONNECTION_OPENCONNECTION, uRLConnection.getURL(), bVar.X());
        }
    }
}
