package com.bonree.sdk.agent.engine.network.okhttp3.external;

import com.bonree.sdk.i.l;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okio.Timeout;

public class Okhttp3CallWarrper implements Call {
    private static final String a = "okhttp3/enqueue";
    private static final String b = "okhttp3/execute";
    private static final String c = "okhttp3/onFailure";
    private static final String d = "okhttp3/onResponse";
    private final Call e;
    private final String f;
    private final int g;

    private static class Okhttp3CallBack implements Callback {
        private final Callback a;
        private final String b;

        public Okhttp3CallBack(Callback callback, String str) {
            this.a = callback;
            this.b = str;
        }

        public void onFailure(Call call, IOException iOException) {
            if (this.a != null) {
                if (!(call.request() == null || call.request().url() == null)) {
                    l.b(Okhttp3CallWarrper.c, call.request().url().toString(), this.b);
                }
                this.a.onFailure(call, iOException);
                if (call.request() != null && call.request().url() != null) {
                    l.d(Okhttp3CallWarrper.c, call.request().url().toString(), this.b);
                }
            }
        }

        public void onResponse(Call call, Response response) throws IOException {
            if (!(this.a == null || call.request() == null || call.request().url() == null)) {
                l.b(Okhttp3CallWarrper.d, call.request().url().toString(), this.b);
            }
            this.a.onResponse(call, response);
            if (call.request() != null && call.request().url() != null) {
                l.d(Okhttp3CallWarrper.d, call.request().url().toString(), this.b);
            }
        }
    }

    public Okhttp3CallWarrper(Call call, String str, int i) {
        this.e = call;
        this.f = str;
        this.g = i;
    }

    public void cancel() {
        Call call = this.e;
        if (call != null) {
            call.cancel();
        }
    }

    public Call clone() {
        Call call = this.e;
        if (call != null) {
            return call.clone();
        }
        return null;
    }

    public void enqueue(Callback callback) {
        Call call = this.e;
        if (call != null) {
            if (!(call.request() == null || this.e.request().url() == null)) {
                l.a(a, this.e.request().url().toString(), this.f, this.g);
            }
            this.e.enqueue(new Okhttp3CallBack(callback, this.f));
            if (this.e.request() != null && this.e.request().url() != null) {
                l.b(a, this.e.request().url().toString(), this.f, this.g);
            }
        }
    }

    public Response execute() throws IOException {
        Call call = this.e;
        if (call == null) {
            return null;
        }
        if (!(call.request() == null || this.e.request().url() == null)) {
            l.a(b, this.e.request().url().toString(), this.f, this.g);
        }
        Response execute = this.e.execute();
        if (!(this.e.request() == null || this.e.request().url() == null)) {
            l.b(b, this.e.request().url().toString(), this.f, this.g);
        }
        return execute;
    }

    public boolean isCanceled() {
        Call call = this.e;
        if (call != null) {
            return call.isCanceled();
        }
        return false;
    }

    public boolean isExecuted() {
        Call call = this.e;
        if (call != null) {
            return call.isExecuted();
        }
        return false;
    }

    public Request request() {
        Call call = this.e;
        if (call != null) {
            return call.request();
        }
        return null;
    }

    public Timeout timeout() {
        Call call = this.e;
        if (call != null) {
            return call.timeout();
        }
        return null;
    }
}
