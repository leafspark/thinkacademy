package com.bonree.sdk.o;

import android.text.TextUtils;
import com.bonree.sdk.agent.engine.network.httpclient.external.HttpRequestEntityImpl;
import com.bonree.sdk.bc.cx;
import com.bonree.sdk.be.f;
import com.bonree.sdk.be.g;
import com.bonree.sdk.bs.u;
import com.bonree.sdk.bs.z;
import com.bonree.sdk.common.json.HTTP;
import com.bonree.sdk.m.j;
import com.bonree.sdk.n.b;
import com.bonree.sdk.n.c;
import com.bonree.sdk.v.d;
import com.bonree.sdk.v.e;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.RequestLine;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

public final class a extends j {
    private static final f a = com.bonree.sdk.be.a.a();

    public static HttpUriRequest a(b bVar, HttpUriRequest httpUriRequest) {
        if (httpUriRequest != null) {
            if (httpUriRequest.getAllHeaders() != null) {
                StringBuilder sb = new StringBuilder();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Header header : httpUriRequest.getAllHeaders()) {
                    linkedHashMap.put(header.getName(), header.getValue());
                    sb.append(header);
                    sb.append(HTTP.CRLF);
                }
                bVar.a((Map<String, String>) linkedHashMap);
                bVar.h(sb.toString());
            }
            bVar.j(httpUriRequest.getMethod());
            a(bVar, httpUriRequest.getURI().toString());
            a(bVar, (HttpRequest) httpUriRequest);
            a(u.c(httpUriRequest.getURI().toString()), bVar);
        }
        return httpUriRequest;
    }

    private static void a(String str, b bVar) {
        if (!u.a()) {
            try {
                long b = com.bonree.sdk.d.a.b();
                InetAddress[] allByName = InetAddress.getAllByName(str);
                bVar.c((int) (com.bonree.sdk.d.a.b() - b));
                for (InetAddress inetAddress : allByName) {
                    bVar.a(cx.a.a((Serializable) inetAddress, cx.a.b(inetAddress)));
                }
            } catch (UnknownHostException unused) {
                g.a("dns parse fail", new Object[0]);
            }
        }
    }

    public static HttpRequest a(b bVar, HttpHost httpHost, HttpRequest httpRequest) {
        String str = "/";
        String str2 = null;
        try {
            RequestLine requestLine = httpRequest.getRequestLine();
            if (requestLine != null) {
                String uri = requestLine.getUri();
                boolean z = uri != null && uri.length() >= 10 && uri.substring(0, 10).contains("://");
                if (!z && uri != null && httpHost != null) {
                    String uri2 = httpHost.toURI();
                    StringBuilder sb = new StringBuilder();
                    sb.append(uri2);
                    if (uri2.endsWith(str) || uri.startsWith(str)) {
                        str = "";
                    }
                    sb.append(str);
                    sb.append(uri);
                    str2 = sb.toString();
                } else if (z) {
                    str2 = uri;
                }
                a(bVar, str2);
            }
            if (httpRequest.getAllHeaders() != null) {
                StringBuilder sb2 = new StringBuilder();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Header header : httpRequest.getAllHeaders()) {
                    sb2.append(header);
                    sb2.append(HTTP.CRLF);
                    linkedHashMap.put(header.getName(), header.getValue());
                }
                bVar.a((Map<String, String>) linkedHashMap);
                bVar.h(sb2.toString());
            }
            if (bVar.f() != null) {
                a(bVar, httpRequest);
                if (str2 != null) {
                    a(u.c(str2), bVar);
                }
                return httpRequest;
            }
            throw new Exception("TransactionData constructor was not provided with a valid URL, host or HTTP method");
        } catch (Throwable th) {
            a.e("TransactionStateUtil.inspectAndInstrument(...) :" + th, new Object[0]);
            return httpRequest;
        }
    }

    private static void a(b bVar, HttpRequest httpRequest) {
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            HttpEntityEnclosingRequest httpEntityEnclosingRequest = (HttpEntityEnclosingRequest) httpRequest;
            if (httpEntityEnclosingRequest.getEntity() != null) {
                httpEntityEnclosingRequest.setEntity(new HttpRequestEntityImpl(httpEntityEnclosingRequest.getEntity(), bVar));
            }
        }
    }

    private static void a(HttpContext httpContext, b bVar) {
        if (httpContext != null) {
            try {
                HttpHost httpHost = (HttpHost) httpContext.getAttribute("http.target_host");
                HttpUriRequest httpUriRequest = (HttpUriRequest) httpContext.getAttribute("http.request");
                if (httpHost != null && httpUriRequest != null && !httpUriRequest.getURI().isAbsolute()) {
                    String str = httpHost.toURI() + httpUriRequest.getURI();
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(bVar.f()) && !str.equals(bVar.f())) {
                        a.c("url not equals,do again dns", new Object[0]);
                        bVar.a().clear();
                        a(u.c(str), bVar);
                    }
                    bVar.c(httpHost.toURI() + httpUriRequest.getURI());
                    if (TextUtils.isEmpty(bVar.Q())) {
                        bVar.j(httpUriRequest.getMethod());
                    }
                }
            } catch (Throwable th) {
                a.e("TransactionStateUtil.inspectHttpURl:" + th, new Object[0]);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a7, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        a.e("TransactionStateUtil.inspectHttpURl:" + r10, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x026f, code lost:
        a.e("TransactionStateUtil.inspectAndInstrument(...) response :" + r8, new java.lang.Object[0]);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:2:0x0005, B:7:0x0017] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.apache.http.HttpResponse a(com.bonree.sdk.n.b r8, org.apache.http.HttpResponse r9, org.apache.http.protocol.HttpContext r10) {
        /*
            java.lang.String r0 = "\r\n"
            r1 = 0
            if (r9 != 0) goto L_0x0013
            com.bonree.sdk.be.f r8 = a     // Catch:{ all -> 0x0010 }
            java.lang.String r10 = "Missing response"
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x0010 }
            r8.d(r10, r0)     // Catch:{ all -> 0x0010 }
            goto L_0x0284
        L_0x0010:
            r8 = move-exception
            goto L_0x026f
        L_0x0013:
            if (r10 == 0) goto L_0x00bd
            java.lang.String r2 = "http.target_host"
            java.lang.Object r2 = r10.getAttribute(r2)     // Catch:{ all -> 0x00a7 }
            org.apache.http.HttpHost r2 = (org.apache.http.HttpHost) r2     // Catch:{ all -> 0x00a7 }
            java.lang.String r3 = "http.request"
            java.lang.Object r10 = r10.getAttribute(r3)     // Catch:{ all -> 0x00a7 }
            org.apache.http.client.methods.HttpUriRequest r10 = (org.apache.http.client.methods.HttpUriRequest) r10     // Catch:{ all -> 0x00a7 }
            if (r2 == 0) goto L_0x00bd
            if (r10 == 0) goto L_0x00bd
            java.net.URI r3 = r10.getURI()     // Catch:{ all -> 0x00a7 }
            boolean r3 = r3.isAbsolute()     // Catch:{ all -> 0x00a7 }
            if (r3 != 0) goto L_0x00bd
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a7 }
            r3.<init>()     // Catch:{ all -> 0x00a7 }
            java.lang.String r4 = r2.toURI()     // Catch:{ all -> 0x00a7 }
            r3.append(r4)     // Catch:{ all -> 0x00a7 }
            java.net.URI r4 = r10.getURI()     // Catch:{ all -> 0x00a7 }
            r3.append(r4)     // Catch:{ all -> 0x00a7 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00a7 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00a7 }
            if (r4 != 0) goto L_0x007b
            java.lang.String r4 = r8.f()     // Catch:{ all -> 0x00a7 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00a7 }
            if (r4 != 0) goto L_0x007b
            java.lang.String r4 = r8.f()     // Catch:{ all -> 0x00a7 }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x00a7 }
            if (r4 != 0) goto L_0x007b
            com.bonree.sdk.be.f r4 = a     // Catch:{ all -> 0x00a7 }
            java.lang.String r5 = "url not equals,do again dns"
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x00a7 }
            r4.c(r5, r6)     // Catch:{ all -> 0x00a7 }
            java.util.List r4 = r8.a()     // Catch:{ all -> 0x00a7 }
            r4.clear()     // Catch:{ all -> 0x00a7 }
            java.lang.String r3 = com.bonree.sdk.bs.u.c((java.lang.String) r3)     // Catch:{ all -> 0x00a7 }
            a((java.lang.String) r3, (com.bonree.sdk.n.b) r8)     // Catch:{ all -> 0x00a7 }
        L_0x007b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a7 }
            r3.<init>()     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = r2.toURI()     // Catch:{ all -> 0x00a7 }
            r3.append(r2)     // Catch:{ all -> 0x00a7 }
            java.net.URI r2 = r10.getURI()     // Catch:{ all -> 0x00a7 }
            r3.append(r2)     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x00a7 }
            r8.c((java.lang.String) r2)     // Catch:{ all -> 0x00a7 }
            java.lang.String r2 = r8.Q()     // Catch:{ all -> 0x00a7 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00a7 }
            if (r2 == 0) goto L_0x00bd
            java.lang.String r10 = r10.getMethod()     // Catch:{ all -> 0x00a7 }
            r8.j((java.lang.String) r10)     // Catch:{ all -> 0x00a7 }
            goto L_0x00bd
        L_0x00a7:
            r10 = move-exception
            com.bonree.sdk.be.f r2 = a     // Catch:{ all -> 0x0010 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0010 }
            java.lang.String r4 = "TransactionStateUtil.inspectHttpURl:"
            r3.<init>(r4)     // Catch:{ all -> 0x0010 }
            r3.append(r10)     // Catch:{ all -> 0x0010 }
            java.lang.String r10 = r3.toString()     // Catch:{ all -> 0x0010 }
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x0010 }
            r2.e(r10, r3)     // Catch:{ all -> 0x0010 }
        L_0x00bd:
            com.bonree.sdk.be.f r10 = a     // Catch:{ all -> 0x0010 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0010 }
            java.lang.String r3 = "httpclient url : "
            r2.<init>(r3)     // Catch:{ all -> 0x0010 }
            java.lang.String r3 = r8.f()     // Catch:{ all -> 0x0010 }
            r2.append(r3)     // Catch:{ all -> 0x0010 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0010 }
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x0010 }
            r10.c(r2, r3)     // Catch:{ all -> 0x0010 }
            org.apache.http.HttpEntity r2 = r9.getEntity()     // Catch:{ all -> 0x011f }
            if (r2 == 0) goto L_0x0127
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x011f }
            java.lang.String r4 = "httpEntity:"
            r3.<init>(r4)     // Catch:{ all -> 0x011f }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x011f }
            r3.append(r4)     // Catch:{ all -> 0x011f }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x011f }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x011f }
            r10.c(r3, r4)     // Catch:{ all -> 0x011f }
            java.lang.String r10 = "managedConn"
            java.lang.Object r10 = com.bonree.sdk.bs.z.a((java.lang.Object) r2, (java.lang.String) r10)     // Catch:{ all -> 0x011f }
            java.lang.String r2 = "wrappedConnection"
            java.lang.Object r10 = com.bonree.sdk.bs.z.a((java.lang.Object) r10, (java.lang.String) r2)     // Catch:{ all -> 0x011f }
            java.lang.String r2 = "socket"
            java.lang.Object r10 = com.bonree.sdk.bs.z.a((java.lang.Object) r10, (java.lang.String) r2)     // Catch:{ all -> 0x011f }
            boolean r2 = r10 instanceof com.bonree.sdk.v.e     // Catch:{ all -> 0x011f }
            if (r2 == 0) goto L_0x010f
            com.bonree.sdk.v.e r10 = (com.bonree.sdk.v.e) r10     // Catch:{ all -> 0x011f }
            r10.a(r8)     // Catch:{ all -> 0x011f }
            goto L_0x0127
        L_0x010f:
            java.lang.String r2 = "impl"
            java.lang.Object r10 = com.bonree.sdk.bs.z.a((java.lang.Object) r10, (java.lang.String) r2)     // Catch:{ all -> 0x011f }
            boolean r2 = r10 instanceof com.bonree.sdk.v.d     // Catch:{ all -> 0x011f }
            if (r2 == 0) goto L_0x0127
            com.bonree.sdk.v.d r10 = (com.bonree.sdk.v.d) r10     // Catch:{ all -> 0x011f }
            r10.a(r8)     // Catch:{ all -> 0x011f }
            goto L_0x0127
        L_0x011f:
            r10 = move-exception
            com.bonree.sdk.be.f r2 = a     // Catch:{ all -> 0x0010 }
            java.lang.String r3 = "httpclient mathch socket fail :"
            r2.a((java.lang.String) r3, (java.lang.Throwable) r10)     // Catch:{ all -> 0x0010 }
        L_0x0127:
            com.bonree.sdk.be.f r10 = a     // Catch:{ all -> 0x0010 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0010 }
            java.lang.String r3 = "TransactionData: ResponseTimeMs : "
            r2.<init>(r3)     // Catch:{ all -> 0x0010 }
            long r3 = com.bonree.sdk.d.a.b()     // Catch:{ all -> 0x0010 }
            r2.append(r3)     // Catch:{ all -> 0x0010 }
            java.lang.String r3 = com.bonree.sdk.bs.ad.a()     // Catch:{ all -> 0x0010 }
            r2.append(r3)     // Catch:{ all -> 0x0010 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0010 }
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x0010 }
            r10.c(r2, r3)     // Catch:{ all -> 0x0010 }
            long r2 = com.bonree.sdk.d.a.b()     // Catch:{ all -> 0x0010 }
            r8.f((long) r2)     // Catch:{ all -> 0x0010 }
            org.apache.http.StatusLine r10 = r9.getStatusLine()     // Catch:{ all -> 0x0010 }
            int r10 = r10.getStatusCode()     // Catch:{ all -> 0x0010 }
            r8.a((int) r10)     // Catch:{ all -> 0x0010 }
            org.apache.http.Header[] r10 = r9.getAllHeaders()     // Catch:{ all -> 0x0010 }
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap     // Catch:{ all -> 0x0010 }
            r2.<init>()     // Catch:{ all -> 0x0010 }
            if (r10 == 0) goto L_0x019a
            int r3 = r10.length     // Catch:{ all -> 0x0010 }
            if (r3 <= 0) goto L_0x019a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0010 }
            r3.<init>()     // Catch:{ all -> 0x0010 }
            org.apache.http.StatusLine r4 = r9.getStatusLine()     // Catch:{ all -> 0x0010 }
            r3.append(r4)     // Catch:{ all -> 0x0010 }
            r3.append(r0)     // Catch:{ all -> 0x0010 }
            int r4 = r10.length     // Catch:{ all -> 0x0010 }
            r5 = r1
        L_0x0178:
            if (r5 >= r4) goto L_0x0190
            r6 = r10[r5]     // Catch:{ all -> 0x0010 }
            r3.append(r6)     // Catch:{ all -> 0x0010 }
            r3.append(r0)     // Catch:{ all -> 0x0010 }
            java.lang.String r7 = r6.getName()     // Catch:{ all -> 0x0010 }
            java.lang.String r6 = r6.getValue()     // Catch:{ all -> 0x0010 }
            r2.put(r7, r6)     // Catch:{ all -> 0x0010 }
            int r5 = r5 + 1
            goto L_0x0178
        L_0x0190:
            java.lang.String r10 = r3.toString()     // Catch:{ all -> 0x0010 }
            r8.b((java.lang.String) r10)     // Catch:{ all -> 0x0010 }
            r8.b((java.util.Map<java.lang.String, java.lang.String>) r2)     // Catch:{ all -> 0x0010 }
        L_0x019a:
            org.apache.http.ProtocolVersion r10 = r9.getProtocolVersion()     // Catch:{ all -> 0x0010 }
            if (r10 == 0) goto L_0x01ab
            org.apache.http.ProtocolVersion r10 = r9.getProtocolVersion()     // Catch:{ all -> 0x0010 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0010 }
            r8.g((java.lang.String) r10)     // Catch:{ all -> 0x0010 }
        L_0x01ab:
            java.lang.String r10 = "Content-Type"
            org.apache.http.Header[] r10 = r9.getHeaders(r10)     // Catch:{ all -> 0x0010 }
            r0 = 0
            if (r10 == 0) goto L_0x01be
            int r2 = r10.length     // Catch:{ all -> 0x0010 }
            if (r2 <= 0) goto L_0x01be
            r10 = r10[r1]     // Catch:{ all -> 0x0010 }
            java.lang.String r10 = r10.getValue()     // Catch:{ all -> 0x0010 }
            goto L_0x01bf
        L_0x01be:
            r10 = r0
        L_0x01bf:
            if (r10 == 0) goto L_0x01ca
            int r2 = r10.length()     // Catch:{ all -> 0x0010 }
            if (r2 <= 0) goto L_0x01ca
            r8.f((java.lang.String) r10)     // Catch:{ all -> 0x0010 }
        L_0x01ca:
            java.lang.String r10 = "Content-length"
            org.apache.http.Header[] r10 = r9.getHeaders(r10)     // Catch:{ all -> 0x0010 }
            java.lang.String r2 = "Failed to parse content length: "
            if (r10 == 0) goto L_0x01e9
            int r3 = r10.length     // Catch:{ all -> 0x0010 }
            if (r3 <= 0) goto L_0x01e9
            r3 = r10[r1]     // Catch:{ NumberFormatException -> 0x01e5 }
            java.lang.String r3 = r3.getValue()     // Catch:{ NumberFormatException -> 0x01e5 }
            long r3 = java.lang.Long.parseLong(r3)     // Catch:{ NumberFormatException -> 0x01e5 }
            r8.d((long) r3)     // Catch:{ NumberFormatException -> 0x01e5 }
            goto L_0x01e9
        L_0x01e5:
            r3 = move-exception
            com.bonree.sdk.be.g.a((java.lang.String) r2, (java.lang.Throwable) r3)     // Catch:{ all -> 0x0010 }
        L_0x01e9:
            if (r10 == 0) goto L_0x023e
            int r3 = r10.length     // Catch:{ all -> 0x0010 }
            if (r3 > 0) goto L_0x01ef
            goto L_0x023e
        L_0x01ef:
            r10 = r10[r1]     // Catch:{ NumberFormatException -> 0x0225 }
            java.lang.String r10 = r10.getValue()     // Catch:{ NumberFormatException -> 0x0225 }
            long r3 = java.lang.Long.parseLong(r10)     // Catch:{ NumberFormatException -> 0x0225 }
            r8.c((long) r3)     // Catch:{ NumberFormatException -> 0x0225 }
            org.apache.http.HttpEntity r10 = r9.getEntity()     // Catch:{ NumberFormatException -> 0x0225 }
            if (r10 != 0) goto L_0x0209
            r9.setEntity(r0)     // Catch:{ NumberFormatException -> 0x0225 }
            a(r8)     // Catch:{ NumberFormatException -> 0x0225 }
            goto L_0x023d
        L_0x0209:
            boolean r10 = r10 instanceof org.apache.http.entity.HttpEntityWrapper     // Catch:{ NumberFormatException -> 0x0225 }
            if (r10 == 0) goto L_0x0219
            com.bonree.sdk.agent.engine.network.httpclient.external.HttpResponseEntityWrapperImpl r10 = new com.bonree.sdk.agent.engine.network.httpclient.external.HttpResponseEntityWrapperImpl     // Catch:{ NumberFormatException -> 0x0225 }
            r10.<init>(r9, r8, r3)     // Catch:{ NumberFormatException -> 0x0225 }
            r9.setEntity(r10)     // Catch:{ NumberFormatException -> 0x0225 }
            b(r8)     // Catch:{ NumberFormatException -> 0x0225 }
            goto L_0x023d
        L_0x0219:
            com.bonree.sdk.agent.engine.network.httpclient.external.HttpResponseEntityImpl r10 = new com.bonree.sdk.agent.engine.network.httpclient.external.HttpResponseEntityImpl     // Catch:{ NumberFormatException -> 0x0225 }
            r10.<init>(r9, r8, r3)     // Catch:{ NumberFormatException -> 0x0225 }
            r9.setEntity(r10)     // Catch:{ NumberFormatException -> 0x0225 }
            b(r8)     // Catch:{ NumberFormatException -> 0x0225 }
            goto L_0x023d
        L_0x0225:
            r8 = move-exception
            com.bonree.sdk.be.f r10 = a     // Catch:{ all -> 0x0010 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0010 }
            r0.<init>(r2)     // Catch:{ all -> 0x0010 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0010 }
            r0.append(r8)     // Catch:{ all -> 0x0010 }
            java.lang.String r8 = r0.toString()     // Catch:{ all -> 0x0010 }
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch:{ all -> 0x0010 }
            r10.e(r8, r0)     // Catch:{ all -> 0x0010 }
        L_0x023d:
            return r9
        L_0x023e:
            org.apache.http.HttpEntity r10 = r9.getEntity()     // Catch:{ all -> 0x0010 }
            if (r10 != 0) goto L_0x024d
            r2 = 0
            r8.c((long) r2)     // Catch:{ all -> 0x0010 }
            a(r8)     // Catch:{ all -> 0x0010 }
            goto L_0x026e
        L_0x024d:
            org.apache.http.HttpEntity r10 = r9.getEntity()     // Catch:{ all -> 0x0010 }
            boolean r10 = r10 instanceof org.apache.http.entity.HttpEntityWrapper     // Catch:{ all -> 0x0010 }
            r2 = -1
            if (r10 == 0) goto L_0x0263
            com.bonree.sdk.agent.engine.network.httpclient.external.HttpResponseEntityWrapperImpl r10 = new com.bonree.sdk.agent.engine.network.httpclient.external.HttpResponseEntityWrapperImpl     // Catch:{ all -> 0x0010 }
            r10.<init>(r9, r8, r2)     // Catch:{ all -> 0x0010 }
            r9.setEntity(r10)     // Catch:{ all -> 0x0010 }
            b(r8)     // Catch:{ all -> 0x0010 }
            goto L_0x026e
        L_0x0263:
            com.bonree.sdk.agent.engine.network.httpclient.external.HttpResponseEntityImpl r10 = new com.bonree.sdk.agent.engine.network.httpclient.external.HttpResponseEntityImpl     // Catch:{ all -> 0x0010 }
            r10.<init>(r9, r8, r2)     // Catch:{ all -> 0x0010 }
            r9.setEntity(r10)     // Catch:{ all -> 0x0010 }
            b(r8)     // Catch:{ all -> 0x0010 }
        L_0x026e:
            return r9
        L_0x026f:
            com.bonree.sdk.be.f r10 = a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "TransactionStateUtil.inspectAndInstrument(...) response :"
            r0.<init>(r2)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            java.lang.Object[] r0 = new java.lang.Object[r1]
            r10.e(r8, r0)
        L_0x0284:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.o.a.a(com.bonree.sdk.n.b, org.apache.http.HttpResponse, org.apache.http.protocol.HttpContext):org.apache.http.HttpResponse");
    }

    private static void a(HttpResponse httpResponse, b bVar) {
        try {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                f fVar = a;
                fVar.c("httpEntity:" + entity.toString(), new Object[0]);
                Object a2 = z.a(z.a(z.a((Object) entity, "managedConn"), "wrappedConnection"), "socket");
                if (a2 instanceof e) {
                    ((e) a2).a(bVar);
                    return;
                }
                Object a3 = z.a(a2, "impl");
                if (a3 instanceof d) {
                    ((d) a3).a(bVar);
                }
            }
        } catch (Throwable th) {
            a.a("httpclient mathch socket fail :", th);
        }
    }

    public static void a(b bVar) {
        if (bVar != null) {
            bVar.r();
            com.bonree.sdk.m.g.a().notifyService((c) bVar);
            f fVar = a;
            fVar.c("httpclient:" + bVar.toString(), new Object[0]);
        }
    }

    private static void b(b bVar) {
        bVar.n();
        com.bonree.sdk.m.a.a().a((Object) bVar);
    }

    public static void b(b bVar, Exception exc) {
        if (!bVar.p()) {
            j.a(bVar, exc);
            bVar.r();
            com.bonree.sdk.m.g.a().notifyService((c) bVar);
            f fVar = a;
            fVar.c("httpClientError :" + bVar, new Object[0]);
        }
    }
}
