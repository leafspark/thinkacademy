package com.didi.hummer.tools;

import java.util.Map;

public final /* synthetic */ class EventTracer$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ Map f$2;

    public /* synthetic */ EventTracer$$ExternalSyntheticLambda1(String str, String str2, Map map) {
        this.f$0 = str;
        this.f$1 = str2;
        this.f$2 = map;
    }

    public final void run() {
        EventTracer.lambda$traceEvent$1(this.f$0, this.f$1, this.f$2);
    }
}
