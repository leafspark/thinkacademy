package com.bonree.sdk.agent.engine.network.okhttp3.external;

import com.bonree.sdk.be.g;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.bs.u;
import com.bonree.sdk.bs.z;
import com.bonree.sdk.common.json.HTTP;
import com.bonree.sdk.d.a;
import com.bonree.sdk.n.c;
import com.bonree.sdk.n.d;
import com.bonree.sdk.n.e;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Ok3EventListener extends EventListener {
    private final EventListener a;
    private e b = new e();
    private d c = new d();

    public Ok3EventListener(EventListener eventListener) {
        this.a = eventListener;
    }

    private static void a(Call call) {
        Headers headers;
        try {
            Object a2 = z.a((Object) call, "originalRequest");
            if (a2 != null && (headers = (Headers) z.a(a2, "headers")) != null) {
                Headers.Builder newBuilder = headers.newBuilder();
                newBuilder.removeAll("br_request_id");
                Headers build = newBuilder.build();
                Field a3 = z.a(a2.getClass(), "headers");
                a3.setAccessible(true);
                a3.set(a2, build);
                Field a4 = z.a(call.getClass(), "originalRequest");
                a4.setAccessible(true);
                a4.set(call, a2);
            }
        } catch (Throwable unused) {
        }
    }

    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        Ok3EventListener.super.proxySelectStart(call, httpUrl);
        if (a()) {
            this.a.proxySelectStart(call, httpUrl);
        }
    }

    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<Proxy> list) {
        Ok3EventListener.super.proxySelectEnd(call, httpUrl, list);
        if (a()) {
            this.a.proxySelectEnd(call, httpUrl, list);
        }
    }

    public void callStart(Call call) {
        Ok3EventListener.super.callStart(call);
        g.c("call start:%s ,url: %s", Integer.valueOf(call.hashCode()), call.request().url());
        String httpUrl = call.request().url().toString();
        d dVar = new d();
        this.c = dVar;
        dVar.a(httpUrl);
        this.c.a(a.l());
        a(call.request());
        if (a()) {
            this.a.callStart(call);
        }
    }

    private void a(Request request) {
        if (request != null) {
            Headers headers = request.headers();
            if (headers != null) {
                this.c.f(headers.toString());
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (String str : headers.names()) {
                    linkedHashMap.put(str, headers.get(str));
                }
                this.c.a((Map<String, String>) linkedHashMap);
            }
            this.c.e(request.method());
        }
    }

    public void dnsStart(Call call, String str) {
        Ok3EventListener.super.dnsStart(call, str);
        if (this.c.n()) {
            this.b = new e(this.c);
            b(call);
        } else if (this.c.m() && !this.b.D()) {
            b(call);
        }
        a(call.request());
        this.c.b(a.b());
        this.c.c(str);
        if (a()) {
            this.a.dnsStart(call, str);
        }
    }

    private void b(Call call) {
        this.b.e(a.b());
        if (ad.b(this.b.x())) {
            this.b.h(String.valueOf(System.identityHashCode(call)));
        }
        if (this.b.e() > 0) {
            this.b.c((int) (a.b() - this.b.e()));
        }
        com.bonree.sdk.m.g.a().notifyService((c) this.b);
        this.b.b(true);
        d dVar = new d();
        this.c = dVar;
        dVar.a(a.l());
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        Ok3EventListener.super.dnsEnd(call, str, list);
        if (this.c.c() > 0) {
            this.c.c((int) (a.b() - this.c.c()));
        }
        if (a()) {
            this.a.dnsEnd(call, str, list);
        }
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Ok3EventListener.super.connectStart(call, inetSocketAddress, proxy);
        if (this.c.n()) {
            this.b = new e(this.c);
            b(call);
        } else if (this.c.m() && !this.b.D()) {
            b(call);
        }
        a(call.request());
        if (this.c.d() <= 0) {
            this.c.c(a.b());
        }
        InetAddress address = inetSocketAddress.getAddress();
        if (address != null) {
            this.c.b(address.getHostAddress());
        } else {
            g.b("IP is null, ok3 eventListener connectStart inetSocketAddress.address isNull ! ");
        }
        this.c.a(inetSocketAddress.getPort());
        if (a()) {
            this.a.connectStart(call, inetSocketAddress, proxy);
        }
    }

    public void secureConnectStart(Call call) {
        Ok3EventListener.super.secureConnectStart(call);
        this.c.d(a.b());
        if (this.c.d() > 0) {
            this.c.b((int) (a.b() - this.c.d()));
        }
        if (a()) {
            this.a.secureConnectStart(call);
        }
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        Ok3EventListener.super.secureConnectEnd(call, handshake);
        if (this.c.g() > 0) {
            this.c.d((int) (a.b() - this.c.g()));
        }
        if (a()) {
            this.a.secureConnectEnd(call, handshake);
        }
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Ok3EventListener.super.connectEnd(call, inetSocketAddress, proxy, protocol);
        this.c.b((int) (a.b() - this.c.d()));
        this.c.d(protocol.toString());
        if (a()) {
            this.a.connectEnd(call, inetSocketAddress, proxy, protocol);
        }
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        Ok3EventListener.super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        g.c("call connectFailed:%s ,url: %s", Integer.valueOf(call.hashCode()), call.request().url());
        this.c.b(true);
        a(iOException);
        if (a()) {
            this.a.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        }
    }

    private void a(IOException iOException) {
        this.c.e(com.bonree.sdk.agent.business.util.c.a((Throwable) iOException, (c) this.c));
        this.c.g(iOException.toString());
        this.c.a(true);
    }

    public void connectionAcquired(Call call, Connection connection) {
        InetSocketAddress socketAddress;
        Ok3EventListener.super.connectionAcquired(call, connection);
        if (!(connection.route() == null || (socketAddress = connection.route().socketAddress()) == null)) {
            InetAddress address = socketAddress.getAddress();
            if (address != null) {
                this.c.b(address.getHostAddress());
            } else {
                g.b("IP is null, ok3 eventListener connectStart inetSocketAddress.address isNull ! ");
            }
            this.c.a(socketAddress.getPort());
        }
        if (this.c.n()) {
            this.b = new e(this.c);
            b(call);
        } else if (this.c.m() && !this.b.D()) {
            b(call);
        }
        this.b = new e(this.c);
        this.c.a(true);
        this.b.h(String.valueOf(System.identityHashCode(call)));
        if (a()) {
            this.a.connectionAcquired(call, connection);
        }
    }

    public void connectionReleased(Call call, Connection connection) {
        Ok3EventListener.super.connectionReleased(call, connection);
        if (a()) {
            this.a.connectionReleased(call, connection);
        }
    }

    public void requestHeadersStart(Call call) {
        Ok3EventListener.super.requestHeadersStart(call);
        this.b.a(a.b());
        if (a()) {
            this.a.requestHeadersStart(call);
        }
    }

    public void requestHeadersEnd(Call call, Request request) {
        Ok3EventListener.super.requestHeadersEnd(call, request);
        if (request != null) {
            Headers headers = request.headers();
            if (headers != null) {
                this.b.e(headers.toString());
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (String str : headers.names()) {
                    linkedHashMap.put(str, headers.get(str));
                }
                this.b.a((Map<String, String>) linkedHashMap);
            }
            this.b.i(request.method());
        }
        if (this.b.d() > 0) {
            this.b.a((int) (a.b() - this.b.d()));
            try {
                RequestBody body = request.body();
                if (body != null) {
                    this.b.f(body.contentLength());
                }
            } catch (IOException unused) {
            }
        }
        this.b.i(a.b());
        if (a()) {
            this.a.requestHeadersEnd(call, request);
        }
    }

    private void b(Request request) {
        if (request != null) {
            Headers headers = request.headers();
            if (headers != null) {
                this.b.e(headers.toString());
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (String str : headers.names()) {
                    linkedHashMap.put(str, headers.get(str));
                }
                this.b.a((Map<String, String>) linkedHashMap);
            }
            this.b.i(request.method());
        }
    }

    public void requestBodyStart(Call call) {
        Ok3EventListener.super.requestBodyStart(call);
        this.b.b(a.b());
        if (a()) {
            this.a.requestBodyStart(call);
        }
    }

    public void requestBodyEnd(Call call, long j) {
        Ok3EventListener.super.requestBodyEnd(call, j);
        if (this.b.d() > 0) {
            this.b.a((int) (a.b() - this.b.d()));
        }
        this.b.f(j);
        this.b.h(a.b());
        if (a()) {
            this.a.requestBodyEnd(call, j);
        }
    }

    public void requestFailed(Call call, IOException iOException) {
        Ok3EventListener.super.requestFailed(call, iOException);
        g.c("call requestFailed:%s ,url: %s", Integer.valueOf(call.hashCode()), call.request().url());
        a(iOException);
        if (a()) {
            this.a.requestFailed(call, iOException);
        }
    }

    public void responseHeadersStart(Call call) {
        Ok3EventListener.super.responseHeadersStart(call);
        this.b.c(a.b());
        if (a()) {
            this.a.responseHeadersStart(call);
        }
    }

    public void responseHeadersEnd(Call call, Response response) {
        int i;
        Ok3EventListener.super.responseHeadersEnd(call, response);
        if (response == null) {
            i = 642;
        } else {
            this.b.b(response.request().url().toString());
            String protocol = response.protocol().toString();
            Map<String, String> d = u.d((Map<String, List<String>>) response.headers().toMultimap());
            if (d != null) {
                this.b.b(d);
            }
            String headers = response.headers().toString();
            int code = response.code();
            if ("http/1.1".equalsIgnoreCase(protocol) || "http/1.0".equalsIgnoreCase(protocol)) {
                this.b.f((protocol.toUpperCase() + " " + code + " " + response.message()) + HTTP.CRLF + headers);
            }
            if (code != 101) {
                this.b.d(protocol);
            } else if (this.b.c().startsWith("https://") || this.b.c().startsWith("wss://")) {
                this.b.d("wss");
            } else {
                this.b.d("ws");
            }
            i = code;
        }
        this.b.d(i);
        if (this.b.A() > 0) {
            this.b.b((int) (a.b() - this.b.A()));
        } else if (this.b.B() > 0) {
            this.b.b((int) (a.b() - this.b.B()));
        }
        if (a()) {
            this.a.responseHeadersEnd(call, response);
        }
    }

    private void a(Response response) {
        int i;
        if (response == null) {
            i = 642;
        } else {
            this.b.b(response.request().url().toString());
            String protocol = response.protocol().toString();
            Map<String, String> d = u.d((Map<String, List<String>>) response.headers().toMultimap());
            if (d != null) {
                this.b.b(d);
            }
            String headers = response.headers().toString();
            int code = response.code();
            if ("http/1.1".equalsIgnoreCase(protocol) || "http/1.0".equalsIgnoreCase(protocol)) {
                this.b.f((protocol.toUpperCase() + " " + code + " " + response.message()) + HTTP.CRLF + headers);
            }
            if (code != 101) {
                this.b.d(protocol);
            } else if (this.b.c().startsWith("https://") || this.b.c().startsWith("wss://")) {
                this.b.d("wss");
            } else {
                this.b.d("ws");
            }
            i = code;
        }
        this.b.d(i);
        if (this.b.A() > 0) {
            this.b.b((int) (a.b() - this.b.A()));
        } else if (this.b.B() > 0) {
            this.b.b((int) (a.b() - this.b.B()));
        }
    }

    public void responseBodyStart(Call call) {
        Ok3EventListener.super.responseBodyStart(call);
        this.b.d(a.b());
        if (a()) {
            this.a.responseBodyStart(call);
        }
    }

    public void responseBodyEnd(Call call, long j) {
        Ok3EventListener.super.responseBodyEnd(call, j);
        this.b.g(j);
        if (this.b.e() > 0) {
            this.b.c((int) (a.b() - this.b.e()));
        }
        if (a()) {
            this.a.responseBodyEnd(call, j);
        }
    }

    public void responseFailed(Call call, IOException iOException) {
        Ok3EventListener.super.responseFailed(call, iOException);
        g.c("call responseFailed:%s ,url: %s", Integer.valueOf(call.hashCode()), call.request().url());
        a(iOException);
        if (a()) {
            this.a.responseFailed(call, iOException);
        }
    }

    public void callEnd(Call call) {
        Ok3EventListener.super.callEnd(call);
        g.c("call end:%s ,url: %s", Integer.valueOf(call.hashCode()), call.request().url());
        this.b.e(a.b());
        if (ad.b(this.b.x())) {
            this.b.h(String.valueOf(System.identityHashCode(call)));
        }
        com.bonree.sdk.m.g.a().notifyService((c) this.b);
        this.b.b(true);
        if (a()) {
            this.a.callEnd(call);
        }
    }

    public void callFailed(Call call, IOException iOException) {
        Ok3EventListener.super.callFailed(call, iOException);
        g.c("call failed:%s ,url: %s", Integer.valueOf(call.hashCode()), call.request().url());
        if (this.b.D()) {
            this.b = new e(this.c);
        }
        if (this.b.C() == 0) {
            this.b.j(this.c.b());
        }
        if (ad.a(this.b.y())) {
            this.b.i(this.c.o());
        }
        if (ad.a(this.b.r())) {
            this.b.e(this.c.p());
        }
        if (this.b.s() == null) {
            this.b.a(this.c.q());
        }
        if (!ad.a(this.c.a())) {
            this.b.b(this.c.a());
        }
        if (!ad.a(this.c.i())) {
            this.b.g(this.c.i());
        }
        if (!ad.a(this.c.e())) {
            this.b.c(this.c.e());
        }
        this.b.e(a.b());
        this.b.d(com.bonree.sdk.agent.business.util.c.a((Throwable) iOException, (c) this.b));
        this.b.a(iOException.toString());
        if (ad.b(this.b.x())) {
            this.b.h(String.valueOf(System.identityHashCode(call)));
        }
        com.bonree.sdk.m.g.a().notifyService((c) this.b);
        this.b.b(true);
        if (a()) {
            this.a.callFailed(call, iOException);
        }
    }

    public void canceled(Call call) {
        Ok3EventListener.super.canceled(call);
        if (a()) {
            this.a.canceled(call);
        }
    }

    public void satisfactionFailure(Call call, Response response) {
        Ok3EventListener.super.satisfactionFailure(call, response);
        if (a()) {
            this.a.satisfactionFailure(call, response);
        }
    }

    public void cacheHit(Call call, Response response) {
        Ok3EventListener.super.cacheHit(call, response);
        this.b.a(true);
        if (a()) {
            this.a.cacheHit(call, response);
        }
    }

    public void cacheMiss(Call call) {
        Ok3EventListener.super.cacheMiss(call);
        if (a()) {
            this.a.cacheMiss(call);
        }
    }

    public void cacheConditionalHit(Call call, Response response) {
        Ok3EventListener.super.cacheConditionalHit(call, response);
        if (a()) {
            this.a.cacheConditionalHit(call, response);
        }
    }

    private boolean a() {
        EventListener eventListener = this.a;
        return eventListener != null && !(eventListener instanceof Ok3EventListener);
    }
}
