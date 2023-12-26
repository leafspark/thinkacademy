package com.tal.app.thinkacademy.live.business.function;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.function.FunctionPluginDriver$getEnterRoomMuteData$2", f = "FunctionPluginDriver.kt", i = {}, l = {628}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FunctionPluginDriver.kt */
final class FunctionPluginDriver$getEnterRoomMuteData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FunctionRepository $repository;
    Object L$0;
    int label;
    final /* synthetic */ FunctionPluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FunctionPluginDriver$getEnterRoomMuteData$2(FunctionPluginDriver functionPluginDriver, FunctionRepository functionRepository, Continuation<? super FunctionPluginDriver$getEnterRoomMuteData$2> continuation) {
        super(2, continuation);
        this.this$0 = functionPluginDriver;
        this.$repository = functionRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new FunctionPluginDriver$getEnterRoomMuteData$2(this.this$0, this.$repository, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        FunctionPluginDriver functionPluginDriver;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FunctionPluginDriver functionPluginDriver2 = this.this$0;
            this.L$0 = functionPluginDriver2;
            this.label = 1;
            Object enterRoomMuteData = this.$repository.getEnterRoomMuteData(functionPluginDriver2.planId, (Continuation) this);
            if (enterRoomMuteData == coroutine_suspended) {
                return coroutine_suspended;
            }
            functionPluginDriver = functionPluginDriver2;
            obj = enterRoomMuteData;
        } else if (i == 1) {
            functionPluginDriver = (FunctionPluginDriver) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        functionPluginDriver.enterRoomMuteData = (EnterRoomMuteData) obj;
        XesLog.it(this.this$0.TAG, Intrinsics.stringPlus("获取进入教室麦克风默认设置成功=", GsonUtil.getInstance().objToJson(this.this$0.enterRoomMuteData)));
        this.this$0.isRequestEnterRoomMuteDataEnd = true;
        this.this$0.initMicStatus();
        return Unit.INSTANCE;
    }
}
