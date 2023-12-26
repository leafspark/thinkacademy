package com.didi.hummer;

import com.didi.hummer.adapter.http.HttpCallback;
import com.didi.hummer.adapter.http.HttpResponse;

public final /* synthetic */ class HummerDebugger$$ExternalSyntheticLambda0 implements HttpCallback {
    public final /* synthetic */ String f$0;

    public /* synthetic */ HummerDebugger$$ExternalSyntheticLambda0(String str) {
        this.f$0 = str;
    }

    public final void onResult(HttpResponse httpResponse) {
        Hummer.getV8Debugger().addScriptSource(this.f$0, (String) httpResponse.data);
    }
}
