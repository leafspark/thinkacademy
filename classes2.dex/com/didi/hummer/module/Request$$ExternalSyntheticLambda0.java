package com.didi.hummer.module;

import com.didi.hummer.adapter.http.HttpCallback;
import com.didi.hummer.adapter.http.HttpResponse;
import com.didi.hummer.core.engine.JSCallback;

public final /* synthetic */ class Request$$ExternalSyntheticLambda0 implements HttpCallback {
    public final /* synthetic */ Request f$0;
    public final /* synthetic */ JSCallback f$1;

    public /* synthetic */ Request$$ExternalSyntheticLambda0(Request request, JSCallback jSCallback) {
        this.f$0 = request;
        this.f$1 = jSCallback;
    }

    public final void onResult(HttpResponse httpResponse) {
        this.f$0.lambda$send$0$Request(this.f$1, httpResponse);
    }
}
