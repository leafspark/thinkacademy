package com.didi.hummer;

import com.didi.hummer.adapter.http.HttpCallback;
import com.didi.hummer.adapter.http.HttpResponse;

public final /* synthetic */ class HummerRender$$ExternalSyntheticLambda0 implements HttpCallback {
    public final /* synthetic */ HummerRender f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ HummerRender$$ExternalSyntheticLambda0(HummerRender hummerRender, boolean z, String str) {
        this.f$0 = hummerRender;
        this.f$1 = z;
        this.f$2 = str;
    }

    public final void onResult(HttpResponse httpResponse) {
        this.f$0.lambda$requestJsBundle$4$HummerRender(this.f$1, this.f$2, httpResponse);
    }
}
