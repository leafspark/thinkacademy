package com.bonree.sdk.agent.engine.network.okhttp2.external;

import com.bonree.sdk.n.b;
import com.bonree.sdk.t.a;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

public class CallbackExtension implements Callback {
    private b a;
    private Callback b;

    CallbackExtension(Callback callback, b bVar) {
        this.b = callback;
        this.a = bVar;
    }

    public void onFailure(Request request, IOException iOException) {
        this.a.g(Thread.currentThread().getId());
        a.a((Exception) iOException, this.a);
        this.b.onFailure(request, iOException);
    }

    public void onResponse(Response response) throws IOException {
        this.a.g(Thread.currentThread().getId());
        this.b.onResponse(response);
        a.a(response, this.a);
    }
}
