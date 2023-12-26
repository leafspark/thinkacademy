package com.didi.hummer.context;

import com.didi.hummer.adapter.scriptloader.ScriptLoadCallback;
import com.didi.hummer.core.engine.JSCallback;

public final /* synthetic */ class HummerInvoker$$ExternalSyntheticLambda0 implements ScriptLoadCallback {
    public final /* synthetic */ HummerInvoker f$0;
    public final /* synthetic */ JSCallback f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ HummerInvoker$$ExternalSyntheticLambda0(HummerInvoker hummerInvoker, JSCallback jSCallback, String str) {
        this.f$0 = hummerInvoker;
        this.f$1 = jSCallback;
        this.f$2 = str;
    }

    public final void onScriptLoad(String str, int i, String str2) {
        this.f$0.lambda$invoke$1$HummerInvoker(this.f$1, this.f$2, str, i, str2);
    }
}
