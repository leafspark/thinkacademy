package com.tal.app.thinkacademy.business.login.config;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.login.config.DeviceTestRepository", f = "DeviceTestRepository.kt", i = {}, l = {36, 33}, m = "checkUrl", n = {}, s = {})
/* compiled from: DeviceTestRepository.kt */
final class DeviceTestRepository$checkUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceTestRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceTestRepository$checkUrl$1(DeviceTestRepository deviceTestRepository, Continuation<? super DeviceTestRepository$checkUrl$1> continuation) {
        super(continuation);
        this.this$0 = deviceTestRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= IntCompanionObject.MIN_VALUE;
        return this.this$0.checkUrl((String) null, this);
    }
}
