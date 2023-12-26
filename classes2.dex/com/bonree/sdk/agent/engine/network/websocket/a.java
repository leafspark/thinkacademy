package com.bonree.sdk.agent.engine.network.websocket;

import android.text.TextUtils;
import com.bonree.sdk.m.g;
import com.bonree.sdk.n.b;
import com.bonree.sdk.n.c;
import java.util.Map;
import okhttp3.Request;
import okhttp3.WebSocket;
import okio.ByteString;

public class a {
    private long a;
    private String b;
    private int c;
    private Map<String, String> d;
    private String e;
    private String f;

    public a() {
    }

    public static boolean a(WebSocket webSocket, String str) {
        b bVar = new b();
        long b2 = com.bonree.sdk.d.a.b();
        boolean send = webSocket.send(str);
        try {
            bVar.f(com.bonree.sdk.d.a.b() - b2 > 0 ? (int) (com.bonree.sdk.d.a.b() - b2) : 1);
            Request request = webSocket.request();
            if (request != null) {
                String url = request.url().url().toString();
                if (!TextUtils.isEmpty(url)) {
                    bVar.c(url);
                    if (!url.startsWith("https://")) {
                        if (!url.startsWith("wss://")) {
                            bVar.g("ws_send");
                            bVar.b(200);
                            bVar.b((long) str.length());
                            bVar.n();
                            g.a().notifyService((c) bVar);
                            com.bonree.sdk.be.g.a("websokcet send :" + bVar.toString(), new Object[0]);
                        }
                    }
                    bVar.g("wss_send");
                    bVar.b(200);
                    bVar.b((long) str.length());
                    bVar.n();
                    g.a().notifyService((c) bVar);
                    com.bonree.sdk.be.g.a("websokcet send :" + bVar.toString(), new Object[0]);
                }
            }
        } catch (Throwable th) {
            com.bonree.sdk.be.g.b("websocket send fail:" + th);
        }
        return send;
    }

    public static boolean a(WebSocket webSocket, ByteString byteString) {
        b bVar = new b();
        long b2 = com.bonree.sdk.d.a.b();
        boolean send = webSocket.send(byteString);
        try {
            bVar.f(com.bonree.sdk.d.a.b() - b2 > 0 ? (int) (com.bonree.sdk.d.a.b() - b2) : 1);
            bVar.g("ws_send");
            Request request = webSocket.request();
            if (request != null) {
                String url = request.url().url().toString();
                if (!TextUtils.isEmpty(url)) {
                    bVar.c(url);
                    if (!url.startsWith("https://")) {
                        if (!url.startsWith("wss://")) {
                            bVar.g("ws_send");
                            bVar.b(200);
                            bVar.b((long) byteString.size());
                            bVar.n();
                            g.a().notifyService((c) bVar);
                            com.bonree.sdk.be.g.a("websokcet send :" + bVar.toString(), new Object[0]);
                        }
                    }
                    bVar.g("wss_send");
                    bVar.b(200);
                    bVar.b((long) byteString.size());
                    bVar.n();
                    g.a().notifyService((c) bVar);
                    com.bonree.sdk.be.g.a("websokcet send :" + bVar.toString(), new Object[0]);
                }
            }
        } catch (Throwable th) {
            com.bonree.sdk.be.g.b("websocket send fail:" + th);
        }
        return send;
    }

    public a(String str) {
        this.c = 0;
        this.a = com.bonree.sdk.d.a.l();
        this.b = str;
    }

    public long a() {
        return this.a;
    }

    public void a(long j) {
        this.a = j;
    }

    public String b() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public int c() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public Map<String, String> d() {
        return this.d;
    }

    public void a(Map<String, String> map) {
        this.d = map;
    }

    public String e() {
        return this.e;
    }

    public void b(String str) {
        this.e = str;
    }

    public String f() {
        return this.f;
    }

    public void c(String str) {
        this.f = str;
    }
}
