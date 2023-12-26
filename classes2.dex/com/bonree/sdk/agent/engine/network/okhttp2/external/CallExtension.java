package com.bonree.sdk.agent.engine.network.okhttp2.external;

import com.bonree.sdk.i.l;
import com.bonree.sdk.n.b;
import com.bonree.sdk.t.a;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

public class CallExtension extends Call {
    private static final String a = "okhttp2/enqueue";
    private static final String b = "okhttp2/execute";
    private b c;
    private Request d;
    private Call e;
    private int f;

    public CallExtension(OkHttpClient okHttpClient, Call call, Request request, b bVar, int i) {
        super(okHttpClient, request);
        this.c = bVar;
        this.d = request;
        a.a(okHttpClient, request, bVar);
        this.e = call;
        this.f = i;
    }

    public Response execute() throws IOException {
        a.a(this.c, this.d);
        this.c.g(Thread.currentThread().getId());
        this.c.e(com.bonree.sdk.d.a.b());
        Response response = null;
        try {
            Request request = this.d;
            if (request != null) {
                l.a(b, request.url(), this.c.X(), this.f);
            }
            response = this.e.execute();
            Request request2 = this.d;
            if (request2 != null) {
                l.b(b, request2.url(), this.c.X(), this.f);
            }
        } catch (IOException e2) {
            a.a((Exception) e2, this.c);
            throw e2;
        } catch (Exception e3) {
            a.a(e3, this.c);
        }
        return a.a(response, this.c);
    }

    public void enqueue(Callback callback) {
        Request request = this.d;
        if (request != null) {
            a.a(this.c, request);
        }
        this.c.e(com.bonree.sdk.d.a.b());
        Request request2 = this.d;
        if (request2 != null) {
            l.a(a, request2.url(), this.c.X(), this.f);
        }
        this.e.enqueue(new CallbackExtension(callback, this.c));
        Request request3 = this.d;
        if (request3 != null) {
            l.b(a, request3.url(), this.c.X(), this.f);
        }
    }

    private void a() {
        this.e.cancel();
    }

    private boolean b() {
        return this.e.isCanceled();
    }
}
