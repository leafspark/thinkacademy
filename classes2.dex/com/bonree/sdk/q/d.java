package com.bonree.sdk.q;

import com.bonree.sdk.be.a;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.u;
import com.bonree.sdk.i.l;
import com.bonree.sdk.n.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class d extends HttpsURLConnection {
    private static final String a = "HttpsURLConnection/connect";
    private static final String b = "HttpsURLConnection/disconnect";
    /* access modifiers changed from: private */
    public static final f c = a.a();
    /* access modifiers changed from: private */
    public final HttpsURLConnection d;
    /* access modifiers changed from: private */
    public final b e;
    private com.bonree.sdk.s.a f = null;

    public d(HttpsURLConnection httpsURLConnection, b bVar) {
        super(httpsURLConnection.getURL());
        this.d = httpsURLConnection;
        this.e = bVar;
        com.bonree.sdk.p.a.b(bVar, (HttpURLConnection) httpsURLConnection);
        bVar.c(u.g(httpsURLConnection.getURL().getHost()));
    }

    public final String getCipherSuite() {
        return this.d.getCipherSuite();
    }

    public final Certificate[] getLocalCertificates() {
        return this.d.getLocalCertificates();
    }

    public final Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        try {
            return this.d.getServerCertificates();
        } catch (SSLPeerUnverifiedException e2) {
            com.bonree.sdk.p.a.a((Exception) e2, (HttpURLConnection) this.d, this.e);
            throw e2;
        }
    }

    public final Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        return this.d.getPeerPrincipal();
    }

    public final void addRequestProperty(String str, String str2) {
        this.d.addRequestProperty(str, str2);
    }

    public final Principal getLocalPrincipal() {
        return this.d.getLocalPrincipal();
    }

    public final void disconnect() {
        b bVar = this.e;
        if (bVar != null && !bVar.h()) {
            com.bonree.sdk.p.a.a(this.e, this.d);
        }
        l.a(b, this.d.getURL(), (String) null);
        try {
            this.d.disconnect();
        } finally {
            l.b(b, this.d.getURL(), (String) null);
        }
    }

    public final boolean usingProxy() {
        return this.d.usingProxy();
    }

    public final boolean getAllowUserInteraction() {
        return this.d.getAllowUserInteraction();
    }

    public final void connect() throws IOException {
        long b2 = com.bonree.sdk.d.a.b();
        int connectTimeout = this.d.getConnectTimeout() + this.d.getReadTimeout();
        if (connectTimeout <= 0) {
            connectTimeout = 10000;
        }
        l.a(a, this.d.getURL(), this.e.X(), connectTimeout);
        try {
            this.d.connect();
            l.b(a, this.d.getURL(), this.e.X(), connectTimeout);
            long b3 = com.bonree.sdk.d.a.b();
            this.e.e((int) (b3 - b2));
            this.e.a(b3);
        } catch (Throwable th) {
            l.b(a, this.d.getURL(), this.e.X(), connectTimeout);
            com.bonree.sdk.p.a.a(th, (HttpURLConnection) this.d, this.e);
            throw th;
        }
    }

    private int b() {
        int connectTimeout = this.d.getConnectTimeout() + this.d.getReadTimeout();
        if (connectTimeout > 0) {
            return connectTimeout;
        }
        return 10000;
    }

    public final int getConnectTimeout() {
        return this.d.getConnectTimeout();
    }

    public final String getHeaderFieldKey(int i) {
        String headerFieldKey = this.d.getHeaderFieldKey(i);
        com.bonree.sdk.p.a.c(this.e, (HttpURLConnection) this.d);
        return headerFieldKey;
    }

    public final Object getContent() throws IOException {
        try {
            Object content = this.d.getContent();
            int contentLength = this.d.getContentLength();
            if (contentLength >= 0 && !this.e.h()) {
                this.e.d((long) contentLength);
                com.bonree.sdk.p.a.a(this.e, this.d);
            }
            return content;
        } catch (IOException e2) {
            com.bonree.sdk.p.a.a((Exception) e2, (HttpURLConnection) this.d, this.e);
            throw e2;
        }
    }

    public final void setFixedLengthStreamingMode(int i) {
        this.d.setFixedLengthStreamingMode(i);
    }

    public final Object getContent(Class[] clsArr) throws IOException {
        try {
            Object content = this.d.getContent(clsArr);
            com.bonree.sdk.p.a.c(this.e, (HttpURLConnection) this.d);
            return content;
        } catch (IOException e2) {
            com.bonree.sdk.p.a.a((Exception) e2, (HttpURLConnection) this.d, this.e);
            throw e2;
        }
    }

    public final void setChunkedStreamingMode(int i) {
        this.d.setChunkedStreamingMode(i);
    }

    public final String getContentEncoding() {
        String contentEncoding = this.d.getContentEncoding();
        com.bonree.sdk.p.a.c(this.e, (HttpURLConnection) this.d);
        return contentEncoding;
    }

    public final String getHeaderField(int i) {
        String headerField = this.d.getHeaderField(i);
        com.bonree.sdk.p.a.c(this.e, (HttpURLConnection) this.d);
        return headerField;
    }

    public final int getContentLength() {
        int contentLength = this.d.getContentLength();
        com.bonree.sdk.p.a.c(this.e, (HttpURLConnection) this.d);
        return contentLength;
    }

    public final String getContentType() {
        String contentType = this.d.getContentType();
        com.bonree.sdk.p.a.c(this.e, (HttpURLConnection) this.d);
        return contentType;
    }

    public final long getDate() {
        long date = this.d.getDate();
        com.bonree.sdk.p.a.c(this.e, (HttpURLConnection) this.d);
        return date;
    }

    public final InputStream getErrorStream() {
        try {
            com.bonree.sdk.s.a aVar = this.f;
            if (aVar == null || aVar.available() == 0) {
                com.bonree.sdk.s.a aVar2 = new com.bonree.sdk.s.a(this.d.getErrorStream());
                this.f = aVar2;
                aVar2.a(this.e);
            }
            return this.f;
        } catch (Throwable th) {
            c.a("HttpsURLConnectionExtension: ", th);
            return this.d.getErrorStream();
        }
    }

    public final long getHeaderFieldDate(String str, long j) {
        long headerFieldDate = this.d.getHeaderFieldDate(str, j);
        com.bonree.sdk.p.a.c(this.e, (HttpURLConnection) this.d);
        return headerFieldDate;
    }

    public final boolean getInstanceFollowRedirects() {
        return this.d.getInstanceFollowRedirects();
    }

    public final Permission getPermission() throws IOException {
        return this.d.getPermission();
    }

    public final String getRequestMethod() {
        return this.d.getRequestMethod();
    }

    public final int getResponseCode() throws IOException {
        try {
            int responseCode = this.d.getResponseCode();
            com.bonree.sdk.p.a.c(this.e, (HttpURLConnection) this.d);
            return responseCode;
        } catch (IOException e2) {
            com.bonree.sdk.p.a.a((Exception) e2, (HttpURLConnection) this.d, this.e);
            throw e2;
        }
    }

    public final String getResponseMessage() throws IOException {
        try {
            String responseMessage = this.d.getResponseMessage();
            com.bonree.sdk.p.a.c(this.e, (HttpURLConnection) this.d);
            return responseMessage;
        } catch (IOException e2) {
            com.bonree.sdk.p.a.a((Exception) e2, (HttpURLConnection) this.d, this.e);
            throw e2;
        }
    }

    public final void setInstanceFollowRedirects(boolean z) {
        this.d.setInstanceFollowRedirects(z);
    }

    public final void setRequestMethod(String str) throws ProtocolException {
        try {
            this.d.setRequestMethod(str);
        } catch (ProtocolException e2) {
            com.bonree.sdk.p.a.a((Exception) e2, (HttpURLConnection) this.d, this.e);
            throw e2;
        }
    }

    public final boolean getDefaultUseCaches() {
        return this.d.getDefaultUseCaches();
    }

    public final boolean getDoInput() {
        return this.d.getDoInput();
    }

    public final boolean getDoOutput() {
        return this.d.getDoOutput();
    }

    public final long getExpiration() {
        long expiration = this.d.getExpiration();
        com.bonree.sdk.p.a.c(this.e, (HttpURLConnection) this.d);
        return expiration;
    }

    public final String getHeaderField(String str) {
        String headerField = this.d.getHeaderField(str);
        com.bonree.sdk.p.a.c(this.e, (HttpURLConnection) this.d);
        return headerField;
    }

    public final int getHeaderFieldInt(String str, int i) {
        int headerFieldInt = this.d.getHeaderFieldInt(str, i);
        com.bonree.sdk.p.a.c(this.e, (HttpURLConnection) this.d);
        return headerFieldInt;
    }

    public final Map<String, List<String>> getHeaderFields() {
        Map<String, List<String>> headerFields = this.d.getHeaderFields();
        com.bonree.sdk.p.a.c(this.e, (HttpURLConnection) this.d);
        return headerFields;
    }

    public final long getIfModifiedSince() {
        long ifModifiedSince = this.d.getIfModifiedSince();
        com.bonree.sdk.p.a.c(this.e, (HttpURLConnection) this.d);
        return ifModifiedSince;
    }

    public final InputStream getInputStream() throws IOException {
        try {
            com.bonree.sdk.s.a aVar = new com.bonree.sdk.s.a(this.d.getInputStream());
            aVar.a(this.e);
            com.bonree.sdk.p.a.a(this.e, (HttpURLConnection) this.d);
            aVar.a((com.bonree.sdk.r.b) new e(this));
            return aVar;
        } catch (IOException e2) {
            com.bonree.sdk.p.a.a((Exception) e2, (HttpURLConnection) this.d, this.e);
            throw e2;
        } catch (Throwable th) {
            com.bonree.sdk.p.a.a(th, (HttpURLConnection) this.d, this.e);
            return this.d.getInputStream();
        }
    }

    public final long getLastModified() {
        long lastModified = this.d.getLastModified();
        com.bonree.sdk.p.a.c(this.e, (HttpURLConnection) this.d);
        return lastModified;
    }

    public final OutputStream getOutputStream() throws IOException {
        try {
            if (this.e.H() == 0) {
                this.e.e(com.bonree.sdk.d.a.b());
            }
            com.bonree.sdk.s.b bVar = new com.bonree.sdk.s.b(this.d.getOutputStream());
            bVar.a((com.bonree.sdk.r.b) new f(this));
            return bVar;
        } catch (IOException e2) {
            com.bonree.sdk.p.a.a((Exception) e2, (HttpURLConnection) this.d, this.e);
            throw e2;
        } catch (Throwable th) {
            com.bonree.sdk.p.a.a(th, (HttpURLConnection) this.d, this.e);
            return this.d.getOutputStream();
        }
    }

    public final int getReadTimeout() {
        return this.d.getReadTimeout();
    }

    public final Map<String, List<String>> getRequestProperties() {
        return this.d.getRequestProperties();
    }

    public final String getRequestProperty(String str) {
        return this.d.getRequestProperty(str);
    }

    public final URL getURL() {
        return this.d.getURL();
    }

    public final boolean getUseCaches() {
        return this.d.getUseCaches();
    }

    public final void setAllowUserInteraction(boolean z) {
        this.d.setAllowUserInteraction(z);
    }

    public final void setConnectTimeout(int i) {
        this.d.setConnectTimeout(i);
    }

    public final void setDefaultUseCaches(boolean z) {
        this.d.setDefaultUseCaches(z);
    }

    public final void setDoInput(boolean z) {
        this.d.setDoInput(z);
    }

    public final void setDoOutput(boolean z) {
        this.d.setDoOutput(z);
    }

    public final void setIfModifiedSince(long j) {
        this.d.setIfModifiedSince(j);
    }

    public final void setReadTimeout(int i) {
        this.d.setReadTimeout(i);
    }

    public final void setRequestProperty(String str, String str2) {
        this.d.setRequestProperty(str, str2);
    }

    public final void setUseCaches(boolean z) {
        this.d.setUseCaches(z);
    }

    public final void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.d.setHostnameVerifier(hostnameVerifier);
    }

    public final HostnameVerifier getHostnameVerifier() {
        return this.d.getHostnameVerifier();
    }

    public final void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.d.setSSLSocketFactory(sSLSocketFactory);
    }

    public final SSLSocketFactory getSSLSocketFactory() {
        return this.d.getSSLSocketFactory();
    }
}
