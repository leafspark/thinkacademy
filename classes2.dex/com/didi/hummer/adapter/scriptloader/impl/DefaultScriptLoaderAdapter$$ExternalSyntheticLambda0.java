package com.didi.hummer.adapter.scriptloader.impl;

import com.didi.hummer.adapter.http.HttpCallback;
import com.didi.hummer.adapter.http.HttpResponse;
import com.didi.hummer.adapter.scriptloader.ScriptLoadCallback;

public final /* synthetic */ class DefaultScriptLoaderAdapter$$ExternalSyntheticLambda0 implements HttpCallback {
    public final /* synthetic */ ScriptLoadCallback f$0;

    public /* synthetic */ DefaultScriptLoaderAdapter$$ExternalSyntheticLambda0(ScriptLoadCallback scriptLoadCallback) {
        this.f$0 = scriptLoadCallback;
    }

    public final void onResult(HttpResponse httpResponse) {
        DefaultScriptLoaderAdapter.lambda$loadScriptWithUrl$0(this.f$0, httpResponse);
    }
}
