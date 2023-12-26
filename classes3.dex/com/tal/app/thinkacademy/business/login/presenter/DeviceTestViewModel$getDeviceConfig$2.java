package com.tal.app.thinkacademy.business.login.presenter;

import com.tal.app.thinkacademy.business.login.entity.DeviceConfig;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.login.presenter.DeviceTestViewModel$getDeviceConfig$2", f = "DeviceTestViewModel.kt", i = {}, l = {389}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceTestViewModel.kt */
final class DeviceTestViewModel$getDeviceConfig$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DeviceTestViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceTestViewModel$getDeviceConfig$2(DeviceTestViewModel deviceTestViewModel, Continuation<? super DeviceTestViewModel$getDeviceConfig$2> continuation) {
        super(2, continuation);
        this.this$0 = deviceTestViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceTestViewModel$getDeviceConfig$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceTestViewModel$getDeviceConfig$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        StateLiveData<DeviceConfig> stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData<DeviceConfig> mDeviceConfig = this.this$0.getMDeviceConfig();
            this.L$0 = mDeviceConfig;
            this.label = 1;
            Object deviceConfig = this.this$0.mRepository.getDeviceConfig(this);
            if (deviceConfig == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = mDeviceConfig;
            obj = deviceConfig;
        } else if (i == 1) {
            stateLiveData = (StateLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        stateLiveData.postSuccess(obj);
        return Unit.INSTANCE;
    }
}
