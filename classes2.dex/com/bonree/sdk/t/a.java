package com.bonree.sdk.t;

import com.bonree.sdk.agent.engine.network.okhttp2.external.Okhttp2Dns;
import com.bonree.sdk.bc.x;
import com.bonree.sdk.be.g;
import com.bonree.sdk.bs.u;
import com.bonree.sdk.common.json.HTTP;
import com.bonree.sdk.m.j;
import com.bonree.sdk.n.b;
import com.bonree.sdk.n.c;
import com.squareup.okhttp.Dns;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Version;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class a extends j {
    public static void a(b bVar, Request request) {
        if (request == null) {
            g.b("Missing request", new Object[0]);
            return;
        }
        Headers headers = request.headers();
        if (headers != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : headers.names()) {
                linkedHashMap.put(str, headers.get(str));
            }
            bVar.a((Map<String, String>) linkedHashMap);
            bVar.h(headers.toString());
        }
        bVar.j(request.method());
        a(bVar, request.urlString());
    }

    private static Response a(b bVar, Response response) {
        int i;
        try {
            bVar.f(com.bonree.sdk.d.a.b());
            String str = "";
            long j = 0;
            if (response == null) {
                i = 642;
                g.b("Missing response", new Object[0]);
            } else {
                bVar.c(response.request().url().toString());
                Map<String, String> d = u.d((Map<String, List<String>>) response.headers().toMultimap());
                if (d != null) {
                    bVar.b(d);
                }
                str = response.headers().toString();
                int code = response.code();
                if (response.protocol() != null) {
                    String protocol = response.protocol().toString();
                    if ("http/1.1".equals(protocol.toLowerCase()) || "http/1.0".equals(protocol.toLowerCase())) {
                        str = (protocol.toUpperCase() + " " + code + " " + response.message()) + HTTP.CRLF + str;
                    }
                    bVar.g(protocol);
                }
                i = code;
                j = response.body().contentLength();
            }
            a(bVar, str, (int) j, i);
        } catch (Throwable th) {
            g.b("Missing body or content length:" + th, new Object[0]);
        }
        return b(bVar, response);
    }

    private static Response b(b bVar, Response response) {
        bVar.n();
        if (response != null) {
            try {
                String header = response.header("Content-Type");
                if (header != null && header.length() > 0) {
                    bVar.f(header);
                }
            } catch (Throwable th) {
                g.b("Content-Type get fail:" + th, new Object[0]);
            }
        }
        com.bonree.sdk.m.g.a().notifyService((c) bVar);
        g.a("okhttp2 data:" + bVar.toString(), new Object[0]);
        return response;
    }

    public static Response a(Response response, b bVar) {
        return !bVar.h() ? a(bVar, response) : response;
    }

    public static void a(Exception exc, b bVar) {
        j.a(bVar, exc);
        if (!bVar.h()) {
            bVar.n();
            com.bonree.sdk.m.g.a().notifyService((c) bVar);
            g.a("okhttp2 error :" + bVar.toString(), new Object[0]);
        }
    }

    public static void a(OkHttpClient okHttpClient, Request request, b bVar) {
        if (!a()) {
            bVar.c(u.g(request.url().getHost()));
        } else if (okHttpClient != null) {
            try {
                if (okHttpClient.getDns() == null) {
                    okHttpClient.setDns(Dns.SYSTEM);
                }
                if (okHttpClient.getDns() == null) {
                    return;
                }
                if (!(okHttpClient.getDns() instanceof Okhttp2Dns)) {
                    okHttpClient.setDns(new Okhttp2Dns(okHttpClient.getDns(), bVar));
                } else {
                    okHttpClient.getDns().a(bVar);
                }
            } catch (Throwable th) {
                g.a("replaceDefaultDns failed:" + th, new Object[0]);
            }
        }
    }

    private static boolean a() {
        boolean z;
        try {
            x.a aVar = new x.a(Version.userAgent());
            if (aVar.a() == 2 && aVar.b() >= 6) {
                z = true;
                g.a("okhttp2 dns interface is " + z, new Object[0]);
                return z;
            }
        } catch (Throwable th) {
            g.a("get okhttp2 version error:" + th, new Object[0]);
        }
        z = false;
        g.a("okhttp2 dns interface is " + z, new Object[0]);
        return z;
    }

    private static void a(OkHttpClient okHttpClient, b bVar) {
        if (okHttpClient != null) {
            try {
                if (okHttpClient.getDns() == null) {
                    okHttpClient.setDns(Dns.SYSTEM);
                }
                if (okHttpClient.getDns() == null) {
                    return;
                }
                if (!(okHttpClient.getDns() instanceof Okhttp2Dns)) {
                    okHttpClient.setDns(new Okhttp2Dns(okHttpClient.getDns(), bVar));
                } else {
                    okHttpClient.getDns().a(bVar);
                }
            } catch (Throwable th) {
                g.a("replaceDefaultDns failed:" + th, new Object[0]);
            }
        }
    }
}
