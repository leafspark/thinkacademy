package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import com.xueersi.lib.graffiti.WXWBAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "actionData", "Lcom/xueersi/lib/graffiti/WXWBAction;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiDrawAgent.kt */
final class GraffitiDrawAgent$setListener$2 extends Lambda implements Function1<WXWBAction, Unit> {
    final /* synthetic */ GraffitiDrawAgent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GraffitiDrawAgent$setListener$2(GraffitiDrawAgent graffitiDrawAgent) {
        super(1);
        this.this$0 = graffitiDrawAgent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((WXWBAction) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(WXWBAction wXWBAction) {
        Intrinsics.checkNotNullParameter(wXWBAction, "actionData");
        Channel access$getMChannel$p = this.this$0.mChannel;
        if (access$getMChannel$p != null) {
            ChannelResult.box-impl(access$getMChannel$p.trySend-JP2dKIU(wXWBAction));
        }
    }
}
