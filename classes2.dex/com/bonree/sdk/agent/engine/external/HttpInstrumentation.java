package com.bonree.sdk.agent.engine.external;

import android.text.TextUtils;
import com.bonree.sdk.agent.engine.network.httpclient.external.ResponseHandlerImpl;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.bs.u;
import com.bonree.sdk.i.l;
import com.bonree.sdk.m.g;
import com.bonree.sdk.m.j;
import com.bonree.sdk.m.k;
import com.bonree.sdk.n.b;
import com.bonree.sdk.n.c;
import com.bonree.sdk.q.a;
import com.bonree.sdk.q.d;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class HttpInstrumentation {
    private static final String HTTPCLIENT_EXECUTE = "HttpClient/execute";
    private static final String HTTP_CLIENT = "HttpClient";
    private static final String HTTP_URL_CONNECTION = "HttpURLConnection";
    private static final String URLCONNECTION_OPENCONNECTION = "URLConnection/openConnection";
    private static final String URLCONNECTION_OPENCONNECTION_PROXY = "URLConnection/openConnectionWithProxy";

    public static URLConnection openConnection(URLConnection uRLConnection) {
        if (uRLConnection == null) {
            return uRLConnection;
        }
        if (!g.a().b()) {
            l.a(URLCONNECTION_OPENCONNECTION, uRLConnection.getURL(), (String) null);
            l.b(URLCONNECTION_OPENCONNECTION, uRLConnection.getURL(), (String) null);
            return uRLConnection;
        }
        b bVar = new b();
        setBrHeader(uRLConnection, bVar);
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

    public static void setBrHeader(URLConnection uRLConnection, b bVar) {
        k.b().a(uRLConnection.getURL().getHost(), uRLConnection.getURL().getPath(), bVar.X(), uRLConnection, k.a.b);
    }

    public static URLConnection openConnectionWithProxy(URLConnection uRLConnection) {
        if (uRLConnection == null) {
            return uRLConnection;
        }
        if (!g.a().b()) {
            l.a(URLCONNECTION_OPENCONNECTION_PROXY, uRLConnection.getURL(), (String) null);
            l.b(URLCONNECTION_OPENCONNECTION_PROXY, uRLConnection.getURL(), (String) null);
            return uRLConnection;
        }
        b bVar = new b();
        setBrHeader(uRLConnection, bVar);
        try {
            l.a(URLCONNECTION_OPENCONNECTION_PROXY, uRLConnection.getURL(), bVar.X());
            if (uRLConnection instanceof HttpsURLConnection) {
                d dVar = new d((HttpsURLConnection) uRLConnection, bVar);
                l.b(URLCONNECTION_OPENCONNECTION_PROXY, uRLConnection.getURL(), bVar.X());
                return dVar;
            }
            if (uRLConnection instanceof HttpURLConnection) {
                a aVar = new a((HttpURLConnection) uRLConnection, bVar);
                l.b(URLCONNECTION_OPENCONNECTION_PROXY, uRLConnection.getURL(), bVar.X());
                return aVar;
            }
            return uRLConnection;
        } catch (Throwable unused) {
            l.b(URLCONNECTION_OPENCONNECTION_PROXY, uRLConnection.getURL(), bVar.X());
        }
    }

    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest) throws IOException {
        if (!g.a().b()) {
            beforeMethod(httpUriRequest, (String) null);
            try {
                return httpClient.execute(httpUriRequest);
            } finally {
                afterMethod(httpUriRequest, (String) null);
            }
        } else {
            b bVar = new b();
            BasicHttpContext basicHttpContext = new BasicHttpContext();
            setBrHeader(basicHttpContext, httpUriRequest, bVar);
            int httpClientTimeput = getHttpClientTimeput(httpClient);
            try {
                beforeMethod(httpUriRequest, bVar.X(), httpClientTimeput);
                HttpResponse delegate = delegate(httpClient.execute(delegate(httpUriRequest, bVar), basicHttpContext), bVar, (HttpContext) basicHttpContext);
                afterMethod(httpUriRequest, bVar.X(), httpClientTimeput);
                return delegate;
            } catch (Exception e) {
                afterMethod(httpUriRequest, bVar.X(), httpClientTimeput);
                httpClientError(bVar, e);
                throw e;
            }
        }
    }

    private static void setBrHeader(HttpContext httpContext, HttpUriRequest httpUriRequest, b bVar) {
        HttpHost httpHost;
        if (httpUriRequest != null) {
            String str = null;
            if (!(httpContext == null || (httpHost = (HttpHost) httpContext.getAttribute("http.target_host")) == null)) {
                str = httpHost.toURI();
            }
            if (TextUtils.isEmpty(str)) {
                str = httpUriRequest.getURI().getHost();
            }
            k.b().a(u.a(str), httpUriRequest.getURI().getPath(), bVar.X(), httpUriRequest, k.a.c);
        }
    }

    private static void setBrHeader(HttpContext httpContext, HttpHost httpHost, HttpRequest httpRequest, b bVar) {
        HttpHost httpHost2;
        if (httpRequest != null && httpHost != null) {
            String str = null;
            if (!(httpContext == null || (httpHost2 = (HttpHost) httpContext.getAttribute("http.target_host")) == null)) {
                str = httpHost2.toURI();
            }
            if (TextUtils.isEmpty(str)) {
                str = httpHost.toURI();
            }
            String a = u.a(str);
            k.b().a(a, u.b(a), bVar.X(), httpRequest, k.a.d);
        }
    }

    public static HttpResponse execute(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        if (!g.a().b()) {
            beforeMethod(httpUriRequest, (String) null);
            try {
                return httpClient.execute(httpUriRequest, httpContext);
            } finally {
                afterMethod(httpUriRequest, (String) null);
            }
        } else {
            b bVar = new b();
            setBrHeader(httpContext, httpUriRequest, bVar);
            int httpClientTimeput = getHttpClientTimeput(httpClient);
            try {
                beforeMethod(httpUriRequest, bVar.X(), httpClientTimeput);
                HttpResponse delegate = delegate(httpClient.execute(delegate(httpUriRequest, bVar), httpContext), bVar, httpContext);
                afterMethod(httpUriRequest, bVar.X(), httpClientTimeput);
                return delegate;
            } catch (Exception e) {
                afterMethod(httpUriRequest, bVar.X(), httpClientTimeput);
                httpClientError(bVar, e);
                throw e;
            }
        }
    }

    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        if (!g.a().b()) {
            beforeMethod(httpUriRequest, (String) null);
            try {
                return httpClient.execute(httpUriRequest, responseHandler);
            } finally {
                afterMethod(httpUriRequest, (String) null);
            }
        } else {
            b bVar = new b();
            setBrHeader((HttpContext) null, httpUriRequest, bVar);
            int httpClientTimeput = getHttpClientTimeput(httpClient);
            beforeMethod(httpUriRequest, bVar.X(), httpClientTimeput);
            try {
                T execute = httpClient.execute(delegate(httpUriRequest, bVar), delegate(responseHandler, bVar));
                afterMethod(httpUriRequest, bVar.X(), httpClientTimeput);
                return execute;
            } catch (Exception e) {
                afterMethod(httpUriRequest, bVar.X(), httpClientTimeput);
                httpClientError(bVar, e);
                throw e;
            }
        }
    }

    public static <T> T execute(HttpClient httpClient, HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        if (!g.a().b()) {
            beforeMethod(httpUriRequest, (String) null);
            try {
                return httpClient.execute(httpUriRequest, responseHandler, httpContext);
            } finally {
                afterMethod(httpUriRequest, (String) null);
            }
        } else {
            b bVar = new b();
            setBrHeader((HttpContext) null, httpUriRequest, bVar);
            int httpClientTimeput = getHttpClientTimeput(httpClient);
            try {
                beforeMethod(httpUriRequest, bVar.X(), httpClientTimeput);
                T execute = httpClient.execute(delegate(httpUriRequest, bVar), delegate(responseHandler, bVar), httpContext);
                afterMethod(httpUriRequest, bVar.X(), httpClientTimeput);
                return execute;
            } catch (Exception e) {
                afterMethod(httpUriRequest, bVar.X(), httpClientTimeput);
                httpClientError(bVar, e);
                throw e;
            }
        }
    }

    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        URI uri = getUri(httpHost, httpRequest);
        if (!g.a().b()) {
            l.a(HTTPCLIENT_EXECUTE, uri, (String) null);
            try {
                return httpClient.execute(httpHost, httpRequest);
            } finally {
                l.b(HTTPCLIENT_EXECUTE, uri, (String) null);
            }
        } else {
            BasicHttpContext basicHttpContext = new BasicHttpContext();
            b bVar = new b();
            setBrHeader((HttpContext) null, httpHost, httpRequest, bVar);
            try {
                int httpClientTimeput = getHttpClientTimeput(httpClient);
                l.a(HTTPCLIENT_EXECUTE, uri, bVar.X(), httpClientTimeput);
                HttpResponse delegate = delegate(httpClient.execute(httpHost, delegate(httpHost, httpRequest, bVar), basicHttpContext), bVar, (HttpContext) basicHttpContext);
                l.b(HTTPCLIENT_EXECUTE, uri, bVar.X(), httpClientTimeput);
                return delegate;
            } catch (IOException e) {
                l.b(HTTPCLIENT_EXECUTE, uri, bVar.X());
                httpClientError(bVar, e);
                throw e;
            }
        }
    }

    private static int getHttpClientTimeput(HttpClient httpClient) {
        try {
            HttpParams params = httpClient.getParams();
            int soTimeout = HttpConnectionParams.getSoTimeout(params) + HttpConnectionParams.getConnectionTimeout(params);
            if (soTimeout > 0) {
                return soTimeout;
            }
            return 10000;
        } catch (Exception e) {
            e.printStackTrace();
            return 10000;
        }
    }

    public static HttpResponse execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        URI uri = getUri(httpHost, httpRequest);
        boolean z = httpClient != null && "com.alipay.mobile.common.transport.http.AndroidHttpClient".equals(httpClient.getClass().getName());
        if (!g.a().b() || z) {
            l.a(HTTPCLIENT_EXECUTE, uri, (String) null);
            try {
                HttpResponse execute = httpClient.execute(httpHost, httpRequest, httpContext);
                l.b(HTTPCLIENT_EXECUTE, uri, (String) null);
                return execute;
            } catch (IOException e) {
                l.b(HTTPCLIENT_EXECUTE, uri, (String) null);
                throw e;
            }
        } else {
            b bVar = new b();
            setBrHeader((HttpContext) null, httpHost, httpRequest, bVar);
            try {
                l.a(HTTPCLIENT_EXECUTE, uri, bVar.X(), getHttpClientTimeput(httpClient));
                com.bonree.sdk.be.g.a("httpClient.execute start:" + ad.a(), new Object[0]);
                HttpResponse execute2 = httpClient.execute(httpHost, delegate(httpHost, httpRequest, bVar), httpContext);
                com.bonree.sdk.be.g.a("httpClient.execute end:" + ad.a(), new Object[0]);
                HttpResponse delegate = delegate(execute2, bVar, httpContext);
                l.b(HTTPCLIENT_EXECUTE, uri, bVar.X());
                return delegate;
            } catch (IOException e2) {
                l.b(HTTPCLIENT_EXECUTE, uri, bVar.X());
                httpClientError(bVar, e2);
                throw e2;
            }
        }
    }

    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        URI uri = getUri(httpHost, httpRequest);
        if (!g.a().b()) {
            l.a(HTTPCLIENT_EXECUTE, uri, (String) null);
            try {
                return httpClient.execute(httpHost, httpRequest, responseHandler);
            } finally {
                l.b(HTTPCLIENT_EXECUTE, uri, (String) null);
            }
        } else {
            b bVar = new b();
            setBrHeader((HttpContext) null, httpHost, httpRequest, bVar);
            try {
                int httpClientTimeput = getHttpClientTimeput(httpClient);
                l.a(HTTPCLIENT_EXECUTE, uri, bVar.X(), httpClientTimeput);
                T execute = httpClient.execute(httpHost, delegate(httpHost, httpRequest, bVar), delegate(responseHandler, bVar));
                l.b(HTTPCLIENT_EXECUTE, uri, bVar.X(), httpClientTimeput);
                return execute;
            } catch (IOException e) {
                l.b(HTTPCLIENT_EXECUTE, uri, bVar.X());
                httpClientError(bVar, e);
                throw e;
            }
        }
    }

    public static <T> T execute(HttpClient httpClient, HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        URI uri = getUri(httpHost, httpRequest);
        if (!g.a().b()) {
            l.a(HTTPCLIENT_EXECUTE, uri, (String) null);
            try {
                return httpClient.execute(httpHost, httpRequest, responseHandler, httpContext);
            } finally {
                l.b(HTTPCLIENT_EXECUTE, uri, (String) null);
            }
        } else {
            b bVar = new b();
            setBrHeader(httpContext, httpHost, httpRequest, bVar);
            int httpClientTimeput = getHttpClientTimeput(httpClient);
            l.a(HTTPCLIENT_EXECUTE, uri, bVar.X(), httpClientTimeput);
            try {
                T execute = httpClient.execute(httpHost, delegate(httpHost, httpRequest, bVar), delegate(responseHandler, bVar), httpContext);
                l.b(HTTPCLIENT_EXECUTE, uri, bVar.X(), httpClientTimeput);
                return execute;
            } catch (IOException e) {
                l.b(HTTPCLIENT_EXECUTE, uri, bVar.X(), httpClientTimeput);
                httpClientError(bVar, e);
                throw e;
            }
        }
    }

    protected static void httpClientError(b bVar, Exception exc) {
        if (!bVar.h()) {
            j.a(bVar, exc);
            bVar.n();
            g.a().notifyService((c) bVar);
            com.bonree.sdk.be.g.a("httpClientError :" + bVar, new Object[0]);
        }
    }

    private static HttpUriRequest delegate(HttpUriRequest httpUriRequest, b bVar) {
        bVar.e(com.bonree.sdk.d.a.b());
        return com.bonree.sdk.o.a.a(bVar, httpUriRequest);
    }

    private static HttpRequest delegate(HttpHost httpHost, HttpRequest httpRequest, b bVar) {
        bVar.e(com.bonree.sdk.d.a.b());
        return com.bonree.sdk.o.a.a(bVar, httpHost, httpRequest);
    }

    private static HttpResponse delegate(HttpResponse httpResponse, b bVar, HttpContext httpContext) {
        return com.bonree.sdk.o.a.a(bVar, httpResponse, httpContext);
    }

    private static <T> ResponseHandler<? extends T> delegate(ResponseHandler<? extends T> responseHandler, b bVar) {
        return ResponseHandlerImpl.wrap(responseHandler, bVar);
    }

    private static URI getUri(HttpHost httpHost, HttpRequest httpRequest) {
        if (httpRequest == null || httpRequest.getRequestLine() == null) {
            return null;
        }
        String uri = httpRequest.getRequestLine().getUri();
        boolean z = false;
        if (uri != null && uri.length() >= 10 && uri.substring(0, 10).indexOf("://") >= 0) {
            z = true;
        }
        if (!(z || uri == null || httpHost == null)) {
            String str = httpHost.toURI().toString();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String str2 = "/";
            if (str.endsWith(str2) || uri.startsWith(str2)) {
                str2 = "";
            }
            sb.append(str2);
            sb.append(uri);
            uri = sb.toString();
        }
        return URI.create(uri);
    }

    private static void beforeMethod(HttpUriRequest httpUriRequest, String str) {
        if (httpUriRequest != null) {
            l.a(HTTPCLIENT_EXECUTE, httpUriRequest.getURI(), str);
        }
    }

    private static void beforeMethod(HttpUriRequest httpUriRequest, String str, int i) {
        if (httpUriRequest != null) {
            l.a(HTTPCLIENT_EXECUTE, httpUriRequest.getURI(), str, i);
        }
    }

    private static void afterMethod(HttpUriRequest httpUriRequest, String str) {
        if (httpUriRequest != null) {
            l.b(HTTPCLIENT_EXECUTE, httpUriRequest.getURI(), str);
        }
    }

    private static void afterMethod(HttpUriRequest httpUriRequest, String str, int i) {
        if (httpUriRequest != null) {
            l.b(HTTPCLIENT_EXECUTE, httpUriRequest.getURI(), str, i);
        }
    }
}
