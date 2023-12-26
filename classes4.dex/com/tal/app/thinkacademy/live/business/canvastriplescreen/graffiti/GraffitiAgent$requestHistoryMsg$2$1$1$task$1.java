package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import com.xueersi.lib.graffiti.WXWBAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lcom/xueersi/lib/graffiti/WXWBAction;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent$requestHistoryMsg$2$1$1$task$1", f = "GraffitiAgent.kt", i = {}, l = {307}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GraffitiAgent.kt */
final class GraffitiAgent$requestHistoryMsg$2$1$1$task$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends WXWBAction>>, Object> {
    final /* synthetic */ String $key;
    final /* synthetic */ long $msgId;
    int label;
    final /* synthetic */ GraffitiAgent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GraffitiAgent$requestHistoryMsg$2$1$1$task$1(GraffitiAgent graffitiAgent, String str, long j, Continuation<? super GraffitiAgent$requestHistoryMsg$2$1$1$task$1> continuation) {
        super(2, continuation);
        this.this$0 = graffitiAgent;
        this.$key = str;
        this.$msgId = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new GraffitiAgent$requestHistoryMsg$2$1$1$task$1(this.this$0, this.$key, this.$msgId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends WXWBAction>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.loadHistoryMsg(this.$key, this.$msgId, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
