package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "code", "", "msg", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiDrawAgent.kt */
final class GraffitiDrawAgent$initGraffiti$1 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ GraffitiDrawAgent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GraffitiDrawAgent$initGraffiti$1(GraffitiDrawAgent graffitiDrawAgent) {
        super(2);
        this.this$0 = graffitiDrawAgent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, String str) {
        GraffitiDrawAgent graffitiDrawAgent = this.this$0;
        graffitiDrawAgent.log("发送队列消息异常 code = " + i + " ; msg = " + str);
    }
}
