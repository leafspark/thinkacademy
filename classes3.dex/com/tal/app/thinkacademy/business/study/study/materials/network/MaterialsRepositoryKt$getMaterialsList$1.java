package com.tal.app.thinkacademy.business.study.study.materials.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.study.study.materials.network.MaterialsRepositoryKt", f = "MaterialsRepository.kt", i = {}, l = {23, 21}, m = "getMaterialsList", n = {}, s = {})
/* compiled from: MaterialsRepository.kt */
final class MaterialsRepositoryKt$getMaterialsList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    MaterialsRepositoryKt$getMaterialsList$1(Continuation<? super MaterialsRepositoryKt$getMaterialsList$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= IntCompanionObject.MIN_VALUE;
        return MaterialsRepositoryKt.getMaterialsList((String) null, this);
    }
}
