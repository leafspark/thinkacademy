package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import com.xueersi.lib.graffiti.WXTGraffitiEngineImpl;
import com.xueersi.lib.graffiti.WXWBAction;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0018\u00010\u0005H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "pageId", "", "<anonymous parameter 1>", "", "", "Lcom/xueersi/lib/graffiti/WXWBAction;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiDrawAgent.kt */
final class GraffitiDrawAgent$setListener$1 extends Lambda implements Function2<String, Map<String, ? extends List<? extends WXWBAction>>, Unit> {
    final /* synthetic */ GraffitiDrawAgent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GraffitiDrawAgent$setListener$1(GraffitiDrawAgent graffitiDrawAgent) {
        super(2);
        this.this$0 = graffitiDrawAgent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (Map<String, ? extends List<? extends WXWBAction>>) (Map) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(String str, Map<String, ? extends List<? extends WXWBAction>> map) {
        Intrinsics.checkNotNullParameter(str, "pageId");
        WXTGraffitiEngineImpl mGraffitiEngine = this.this$0.getMGraffitiEngine();
        if (mGraffitiEngine != null) {
            mGraffitiEngine.disableSaveDBCurrentPage();
        }
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Intrinsics.stringPlus("teacher_", str), -1L);
        linkedHashMap.put(str, -1L);
        this.this$0.requestHistoryMsg(str, linkedHashMap);
    }
}
