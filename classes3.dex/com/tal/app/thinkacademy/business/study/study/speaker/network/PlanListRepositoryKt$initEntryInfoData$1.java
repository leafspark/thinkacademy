package com.tal.app.thinkacademy.business.study.study.speaker.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt", f = "PlanListRepository.kt", i = {}, l = {288, 287}, m = "initEntryInfoData", n = {}, s = {})
/* compiled from: PlanListRepository.kt */
final class PlanListRepositoryKt$initEntryInfoData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    PlanListRepositoryKt$initEntryInfoData$1(Continuation<? super PlanListRepositoryKt$initEntryInfoData$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= IntCompanionObject.MIN_VALUE;
        return PlanListRepositoryKt.initEntryInfoData(this);
    }
}
