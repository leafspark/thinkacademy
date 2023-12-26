package com.tal.thinkacademy.networkprobe;

import io.ktor.client.statement.HttpResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lio/ktor/client/statement/HttpResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.thinkacademy.networkprobe.NetProbe$repeatRequest$2$1$1", f = "NetProbe.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NetProbe.kt */
final class NetProbe$repeatRequest$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpResponse>, Object> {
    final /* synthetic */ String $host;
    final /* synthetic */ Map<String, String> $params;
    final /* synthetic */ String $path;
    int label;
    final /* synthetic */ NetProbe this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetProbe$repeatRequest$2$1$1(NetProbe netProbe, String str, String str2, Map<String, String> map, Continuation<? super NetProbe$repeatRequest$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = netProbe;
        this.$host = str;
        this.$path = str2;
        this.$params = map;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new NetProbe$repeatRequest$2$1$1(this.this$0, this.$host, this.$path, this.$params, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpResponse> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.get(this.$host, this.$path, this.$params, (Continuation) this);
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
