package com.didi.hummer.module;

import com.didi.hummer.adapter.navigator.NavCallback;
import com.didi.hummer.core.engine.JSCallback;
import java.util.Map;

public final /* synthetic */ class Navigator$$ExternalSyntheticLambda0 implements NavCallback {
    public final /* synthetic */ JSCallback f$0;

    public /* synthetic */ Navigator$$ExternalSyntheticLambda0(JSCallback jSCallback) {
        this.f$0 = jSCallback;
    }

    public final void onResult(Map map) {
        Navigator.lambda$openPage$0(this.f$0, map);
    }
}
