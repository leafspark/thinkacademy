package com.tal.app.thinkacademy.business.login.presenter;

import com.tal.app.thinkacademy.business.login.entity.NetTestState;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.login.presenter.DeviceTestViewModel$checkServerHealth$2", f = "DeviceTestViewModel.kt", i = {0}, l = {290}, m = "invokeSuspend", n = {"startNanoTime"}, s = {"J$0"})
/* compiled from: DeviceTestViewModel.kt */
final class DeviceTestViewModel$checkServerHealth$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $checkUrl;
    long J$0;
    int label;
    final /* synthetic */ DeviceTestViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceTestViewModel$checkServerHealth$2(DeviceTestViewModel deviceTestViewModel, String str, Continuation<? super DeviceTestViewModel$checkServerHealth$2> continuation) {
        super(2, continuation);
        this.this$0 = deviceTestViewModel;
        this.$checkUrl = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceTestViewModel$checkServerHealth$2(this.this$0, this.$checkUrl, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceTestViewModel$checkServerHealth$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        long j;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            XesLog.it("DeviceTest_VM", new Object[]{"checkServerHealth start"});
            long currentTimeMillis = System.currentTimeMillis();
            this.J$0 = currentTimeMillis;
            this.label = 1;
            if (this.this$0.mRepository.checkUrl(this.$checkUrl, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            j = currentTimeMillis;
        } else if (i == 1) {
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        long currentTimeMillis2 = System.currentTimeMillis() - j;
        XesLog.it("DeviceTest_VM", new Object[]{Intrinsics.stringPlus("checkServerHealth finish ", Boxing.boxLong(currentTimeMillis2))});
        this.this$0.getMNetTestState().postStickyData(NetTestState.INSTANCE.createServerBean(currentTimeMillis2));
        return Unit.INSTANCE;
    }
}
