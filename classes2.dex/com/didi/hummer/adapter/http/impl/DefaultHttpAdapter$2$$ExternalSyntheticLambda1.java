package com.didi.hummer.adapter.http.impl;

import com.didi.hummer.adapter.http.HttpCallback;
import com.didi.hummer.adapter.http.impl.DefaultHttpAdapter;
import java.io.IOException;

public final /* synthetic */ class DefaultHttpAdapter$2$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ DefaultHttpAdapter.AnonymousClass2 f$0;
    public final /* synthetic */ HttpCallback f$1;
    public final /* synthetic */ IOException f$2;

    public /* synthetic */ DefaultHttpAdapter$2$$ExternalSyntheticLambda1(DefaultHttpAdapter.AnonymousClass2 r1, HttpCallback httpCallback, IOException iOException) {
        this.f$0 = r1;
        this.f$1 = httpCallback;
        this.f$2 = iOException;
    }

    public final void run() {
        this.f$0.lambda$onFailure$1$DefaultHttpAdapter$2(this.f$1, this.f$2);
    }
}
