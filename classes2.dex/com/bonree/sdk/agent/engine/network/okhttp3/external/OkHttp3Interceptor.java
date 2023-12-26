package com.bonree.sdk.agent.engine.network.okhttp3.external;

import com.bonree.sdk.agent.business.util.c;
import com.bonree.sdk.be.a;
import com.bonree.sdk.bs.z;
import com.bonree.sdk.m.g;
import com.bonree.sdk.m.k;
import com.bonree.sdk.m.o;
import com.bonree.sdk.n.b;
import com.bonree.sdk.v.d;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.UUID;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

public class OkHttp3Interceptor implements Interceptor {
    private OkHttpClient a;

    public final void a(OkHttpClient okHttpClient) {
        this.a = okHttpClient;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        ArrayDeque arrayDeque;
        OkHttpClient okHttpClient;
        Interceptor.Chain chain2 = chain;
        if (!g.a().b()) {
            return chain2.proceed(chain.request());
        }
        Request request = chain.request();
        b bVar = new b();
        boolean z = request.tag() == null;
        try {
            if (request.header("br_interactive_uuid") != null) {
                bVar.m(request.header("br_interactive_uuid"));
                o.a(request, "br_interactive_uuid");
            }
            if (g.a().c()) {
                RequestBody body = request.body();
                if ((body != null && !(body instanceof MultipartBody) && !body.getClass().getName().contains("ProgressRequestBody")) && body.contentLength() > 0 && body.contentLength() < 102400) {
                    MediaType contentType = body.contentType();
                    Buffer buffer = new Buffer();
                    body.writeTo(buffer);
                    Charset forName = Charset.forName(Key.STRING_CHARSET_NAME);
                    if (contentType != null) {
                        forName = contentType.charset(Charset.forName(Key.STRING_CHARSET_NAME));
                    }
                    String readString = buffer.readString(forName);
                    a.a().a("ok3 requestBody is: %s", readString);
                    bVar.k(readString);
                }
            }
        } catch (Throwable unused) {
        }
        Request a2 = com.bonree.sdk.u.a.a(request, bVar);
        k.b().a(a2.url().host(), a2.url().uri().getPath(), UUID.randomUUID().toString(), a2, k.a.f);
        try {
            bVar.e(String.valueOf(System.identityHashCode(chain.call())));
        } catch (Throwable unused2) {
        }
        com.bonree.sdk.u.a.a(bVar, a2);
        OkHttpClient okHttpClient2 = this.a;
        if (!(okHttpClient2 == null || okHttpClient2.dns() == null || (okHttpClient = this.a) == null)) {
            try {
                if (okHttpClient.dns() != null) {
                    if (!(okHttpClient.dns() instanceof Okhttp3Dns)) {
                        z.a("dns", okHttpClient, new Okhttp3Dns(okHttpClient.dns(), bVar));
                    } else {
                        okHttpClient.dns().a(bVar);
                    }
                }
            } catch (Throwable unused3) {
                com.bonree.sdk.be.g.b("replaceDefaultDns failed:");
            }
        }
        bVar.e(com.bonree.sdk.d.a.b());
        try {
            Response proceed = chain2.proceed(a2);
            if (!z) {
                Object obj = null;
                try {
                    Object a3 = z.a((Object) this.a, "connectionPool");
                    if (a3 != null) {
                        obj = z.a(a3, "delegate");
                        if (obj != null) {
                            arrayDeque = (ArrayDeque) z.a(obj, "connections");
                        } else {
                            arrayDeque = (ArrayDeque) z.a(a3, "connections");
                        }
                        if (arrayDeque != null) {
                            if (arrayDeque.size() == 1) {
                                Object a4 = z.a(arrayDeque.getFirst(), "rawSocket");
                                if (a4 != null) {
                                    Object a5 = z.a(a4, "impl");
                                    if (a5 instanceof d) {
                                        ((d) a5).a(bVar);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    com.bonree.sdk.be.g.a("socket guanlian fail:" + th, new Object[0]);
                }
            }
            if (proceed.networkResponse() == null || com.bonree.sdk.u.a.a(this.a)) {
                bVar.a(true);
            }
            com.bonree.sdk.u.a.a(bVar, proceed);
            return proceed.newBuilder().body(new BrResponseBody(proceed.body(), bVar)).build();
        } catch (IOException e) {
            IOException iOException = e;
            c.a(bVar, (Exception) iOException);
            if (!bVar.h()) {
                bVar.r();
                g.a().notifyService((com.bonree.sdk.n.c) bVar);
            }
            com.bonree.sdk.be.g.a("okhttp3 error data:" + bVar.toString(), new Object[0]);
            throw iOException;
        }
    }

    private static boolean a(RequestBody requestBody) {
        if (requestBody != null && !(requestBody instanceof MultipartBody) && !requestBody.getClass().getName().contains("ProgressRequestBody")) {
            return true;
        }
        return false;
    }
}
