package com.didi.hummer.adapter.http.impl;

import com.didi.hummer.adapter.http.HttpCallback;
import com.didi.hummer.adapter.http.HttpResponse;
import com.didi.hummer.adapter.http.impl.DefaultHttpAdapter;

public final /* synthetic */ class DefaultHttpAdapter$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ HttpCallback f$0;
    public final /* synthetic */ HttpResponse f$1;

    public /* synthetic */ DefaultHttpAdapter$1$$ExternalSyntheticLambda0(HttpCallback httpCallback, HttpResponse httpResponse) {
        this.f$0 = httpCallback;
        this.f$1 = httpResponse;
    }

    public final void run() {
        DefaultHttpAdapter.AnonymousClass1.lambda$onResponse$0(this.f$0, this.f$1);
    }
}
