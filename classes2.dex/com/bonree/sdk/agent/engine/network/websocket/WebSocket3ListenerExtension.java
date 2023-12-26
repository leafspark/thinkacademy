package com.bonree.sdk.agent.engine.network.websocket;

import com.bonree.sdk.agent.business.util.c;
import com.bonree.sdk.be.g;
import com.bonree.sdk.d.a;
import com.bonree.sdk.n.b;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class WebSocket3ListenerExtension extends WebSocketListener {
    private WebSocketListener a;
    private b b;
    private Request c;

    private WebSocket3ListenerExtension(WebSocketListener webSocketListener, Request request, b bVar) {
        this.a = webSocketListener;
        this.c = request;
        this.b = bVar;
        a();
    }

    public void onOpen(WebSocket webSocket, Response response) {
        this.b.g(Thread.currentThread().getId());
        this.a.onOpen(webSocket, response);
        a((Throwable) null, response);
    }

    public void onMessage(WebSocket webSocket, String str) {
        this.a.onMessage(webSocket, str);
    }

    public void onMessage(WebSocket webSocket, ByteString byteString) {
        this.a.onMessage(webSocket, byteString);
    }

    public void onClosing(WebSocket webSocket, int i, String str) {
        this.a.onClosing(webSocket, i, str);
    }

    public void onClosed(WebSocket webSocket, int i, String str) {
        this.a.onClosed(webSocket, i, str);
    }

    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        this.b.g(Thread.currentThread().getId());
        if (!this.b.h()) {
            a();
            this.a.onFailure(webSocket, th, response);
            a(th, response);
            return;
        }
        this.a.onFailure(webSocket, th, response);
    }

    private void a() {
        Request request = this.c;
        if (request != null && request.url() != null) {
            this.b.e(a.b());
            this.b.c(this.c.url().toString());
        }
    }

    private void a(Throwable th, Response response) {
        if (response != null) {
            if (th != null) {
                try {
                    c.a(this.b, th);
                } catch (Throwable th2) {
                    g.a("websokcet failed:", th2);
                    return;
                }
            }
            if (this.b.i() == 0) {
                this.b.a(response.code());
            }
            com.bonree.sdk.u.a.b(this.b, response);
        } else if (th != null) {
            c.a(this.b, th);
        }
        if (!this.b.f().startsWith("https://")) {
            if (!this.b.f().startsWith("wss://")) {
                this.b.g("ws");
                this.b.n();
                com.bonree.sdk.m.g.a().notifyService((com.bonree.sdk.n.c) this.b);
                g.a("websokcet3 :" + this.b.toString(), new Object[0]);
            }
        }
        this.b.g("wss");
        this.b.n();
        com.bonree.sdk.m.g.a().notifyService((com.bonree.sdk.n.c) this.b);
        g.a("websokcet3 :" + this.b.toString(), new Object[0]);
    }
}
