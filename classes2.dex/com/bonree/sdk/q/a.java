package com.bonree.sdk.q;

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
import java.util.List;
import java.util.Map;

public final class a extends HttpURLConnection {
    private static final String a = "HttpURLConnection/connect";
    private static final String b = "HttpURLConnection/disconnect";
    /* access modifiers changed from: private */
    public static final f f = com.bonree.sdk.be.a.a();
    /* access modifiers changed from: private */
    public final HttpURLConnection c;
    /* access modifiers changed from: private */
    public final b d;
    private com.bonree.sdk.s.a e = null;

    public a(HttpURLConnection httpURLConnection, b bVar) {
        super(httpURLConnection.getURL());
        this.d = bVar;
        this.c = httpURLConnection;
        com.bonree.sdk.p.a.b(bVar, httpURLConnection);
        bVar.c(u.g(httpURLConnection.getURL().getHost()));
    }

    public final void addRequestProperty(String str, String str2) {
        this.c.addRequestProperty(str, str2);
    }

    public final void disconnect() {
        b bVar = this.d;
        if (bVar != null && !bVar.h()) {
            com.bonree.sdk.p.a.d(this.d, this.c);
        }
        l.a(b, this.c.getURL(), (String) null);
        try {
            this.c.disconnect();
        } finally {
            l.b(b, this.c.getURL(), (String) null);
        }
    }

    public final boolean usingProxy() {
        return this.c.usingProxy();
    }

    public final void connect() throws IOException {
        long b2 = com.bonree.sdk.d.a.b();
        int connectTimeout = this.c.getConnectTimeout() + this.c.getReadTimeout();
        if (connectTimeout <= 0) {
            connectTimeout = 10000;
        }
        l.a(a, this.c.getURL(), this.d.X(), connectTimeout);
        try {
            this.c.connect();
            l.b(a, this.c.getURL(), this.d.X(), connectTimeout);
            long b3 = com.bonree.sdk.d.a.b();
            this.d.e((int) (b3 - b2));
            this.d.a(b3);
        } catch (Throwable th) {
            l.b(a, this.c.getURL(), this.d.X(), connectTimeout);
            a(th);
            throw th;
        }
    }

    private int b() {
        int connectTimeout = this.c.getConnectTimeout() + this.c.getReadTimeout();
        if (connectTimeout > 0) {
            return connectTimeout;
        }
        return 10000;
    }

    public final boolean getAllowUserInteraction() {
        return this.c.getAllowUserInteraction();
    }

    public final int getConnectTimeout() {
        return this.c.getConnectTimeout();
    }

    public final Object getContent() throws IOException {
        try {
            Object content = this.c.getContent();
            int contentLength = this.c.getContentLength();
            if (contentLength >= 0 && !this.d.h()) {
                this.d.d((long) contentLength);
                com.bonree.sdk.p.a.d(this.d, this.c);
            }
            return content;
        } catch (IOException e2) {
            a((Exception) e2);
            throw e2;
        }
    }

    public final Object getContent(Class[] clsArr) throws IOException {
        try {
            Object content = this.c.getContent(clsArr);
            c();
            return content;
        } catch (IOException e2) {
            a((Exception) e2);
            throw e2;
        }
    }

    public final String getContentEncoding() {
        String contentEncoding = this.c.getContentEncoding();
        c();
        return contentEncoding;
    }

    public final int getContentLength() {
        int contentLength = this.c.getContentLength();
        c();
        return contentLength;
    }

    public final String getContentType() {
        String contentType = this.c.getContentType();
        c();
        return contentType;
    }

    public final long getDate() {
        long date = this.c.getDate();
        c();
        return date;
    }

    public final InputStream getErrorStream() {
        try {
            com.bonree.sdk.s.a aVar = this.e;
            if (aVar == null || aVar.available() == 0) {
                com.bonree.sdk.s.a aVar2 = new com.bonree.sdk.s.a(this.c.getErrorStream());
                this.e = aVar2;
                aVar2.a(this.d);
            }
            return this.e;
        } catch (Throwable th) {
            f.a("HttpsURLConnectionExtension: ", th);
            return this.c.getErrorStream();
        }
    }

    public final long getHeaderFieldDate(String str, long j) {
        long headerFieldDate = this.c.getHeaderFieldDate(str, j);
        c();
        return headerFieldDate;
    }

    public final boolean getInstanceFollowRedirects() {
        return this.c.getInstanceFollowRedirects();
    }

    public final Permission getPermission() throws IOException {
        return this.c.getPermission();
    }

    public final String getRequestMethod() {
        return this.c.getRequestMethod();
    }

    public final int getResponseCode() throws IOException {
        try {
            int responseCode = this.c.getResponseCode();
            c();
            return responseCode;
        } catch (IOException e2) {
            a((Exception) e2);
            throw e2;
        }
    }

    public final String getResponseMessage() throws IOException {
        try {
            String responseMessage = this.c.getResponseMessage();
            c();
            return responseMessage;
        } catch (IOException e2) {
            a((Exception) e2);
            throw e2;
        }
    }

    public final void setChunkedStreamingMode(int i) {
        this.c.setChunkedStreamingMode(i);
    }

    public final void setFixedLengthStreamingMode(int i) {
        this.c.setFixedLengthStreamingMode(i);
    }

    public final void setInstanceFollowRedirects(boolean z) {
        this.c.setInstanceFollowRedirects(z);
    }

    public final void setRequestMethod(String str) throws ProtocolException {
        try {
            this.c.setRequestMethod(str);
        } catch (ProtocolException e2) {
            a((Exception) e2);
            throw e2;
        }
    }

    public final boolean getDefaultUseCaches() {
        return this.c.getDefaultUseCaches();
    }

    public final boolean getDoInput() {
        return this.c.getDoInput();
    }

    public final boolean getDoOutput() {
        return this.c.getDoOutput();
    }

    public final long getExpiration() {
        long expiration = this.c.getExpiration();
        c();
        return expiration;
    }

    public final String getHeaderField(int i) {
        String headerField = this.c.getHeaderField(i);
        c();
        return headerField;
    }

    public final String getHeaderField(String str) {
        String headerField = this.c.getHeaderField(str);
        c();
        return headerField;
    }

    public final int getHeaderFieldInt(String str, int i) {
        int headerFieldInt = this.c.getHeaderFieldInt(str, i);
        c();
        return headerFieldInt;
    }

    public final String getHeaderFieldKey(int i) {
        String headerFieldKey = this.c.getHeaderFieldKey(i);
        c();
        return headerFieldKey;
    }

    public final Map<String, List<String>> getHeaderFields() {
        Map<String, List<String>> headerFields = this.c.getHeaderFields();
        c();
        return headerFields;
    }

    public final long getIfModifiedSince() {
        long ifModifiedSince = this.c.getIfModifiedSince();
        c();
        return ifModifiedSince;
    }

    public final InputStream getInputStream() throws IOException {
        try {
            com.bonree.sdk.s.a aVar = new com.bonree.sdk.s.a(this.c.getInputStream());
            aVar.a(this.d);
            com.bonree.sdk.p.a.a(this.d, this.c);
            aVar.a((com.bonree.sdk.r.b) new b(this));
            return aVar;
        } catch (IOException e2) {
            a((Exception) e2);
            throw e2;
        } catch (Throwable th) {
            a(th);
            return this.c.getInputStream();
        }
    }

    public final long getLastModified() {
        long lastModified = this.c.getLastModified();
        c();
        return lastModified;
    }

    public final OutputStream getOutputStream() throws IOException {
        try {
            if (this.d.H() == 0) {
                this.d.e(com.bonree.sdk.d.a.b());
            }
            com.bonree.sdk.s.b bVar = new com.bonree.sdk.s.b(this.c.getOutputStream());
            bVar.a((com.bonree.sdk.r.b) new c(this));
            return bVar;
        } catch (IOException e2) {
            a((Exception) e2);
            throw e2;
        } catch (Throwable th) {
            com.bonree.sdk.p.a.a(th, this.c, this.d);
            return this.c.getOutputStream();
        }
    }

    public final int getReadTimeout() {
        return this.c.getReadTimeout();
    }

    public final Map<String, List<String>> getRequestProperties() {
        return this.c.getRequestProperties();
    }

    public final String getRequestProperty(String str) {
        return this.c.getRequestProperty(str);
    }

    public final URL getURL() {
        return this.c.getURL();
    }

    public final boolean getUseCaches() {
        return this.c.getUseCaches();
    }

    public final void setAllowUserInteraction(boolean z) {
        this.c.setAllowUserInteraction(z);
    }

    public final void setConnectTimeout(int i) {
        this.c.setConnectTimeout(i);
    }

    public final void setDefaultUseCaches(boolean z) {
        this.c.setDefaultUseCaches(z);
    }

    public final void setDoInput(boolean z) {
        this.c.setDoInput(z);
    }

    public final void setDoOutput(boolean z) {
        this.c.setDoOutput(z);
    }

    public final void setIfModifiedSince(long j) {
        this.c.setIfModifiedSince(j);
    }

    public final void setReadTimeout(int i) {
        this.c.setReadTimeout(i);
    }

    public final void setRequestProperty(String str, String str2) {
        this.c.setRequestProperty(str, str2);
    }

    public final void setUseCaches(boolean z) {
        this.c.setUseCaches(z);
    }

    private void c() {
        com.bonree.sdk.p.a.c(this.d, this.c);
    }

    /* access modifiers changed from: private */
    public void a(Exception exc) {
        com.bonree.sdk.p.a.a(exc, this.c, this.d);
    }

    private void a(Throwable th) {
        com.bonree.sdk.p.a.a(th, this.c, this.d);
    }
}
