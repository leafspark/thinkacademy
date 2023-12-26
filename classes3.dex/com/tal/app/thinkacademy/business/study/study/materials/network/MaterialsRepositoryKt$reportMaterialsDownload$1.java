package com.tal.app.thinkacademy.business.study.study.materials.network;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.study.study.materials.network.MaterialsRepositoryKt", f = "MaterialsRepository.kt", i = {}, l = {33, 31}, m = "reportMaterialsDownload", n = {}, s = {})
/* compiled from: MaterialsRepository.kt */
final class MaterialsRepositoryKt$reportMaterialsDownload$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    MaterialsRepositoryKt$reportMaterialsDownload$1(Continuation<? super MaterialsRepositoryKt$reportMaterialsDownload$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= IntCompanionObject.MIN_VALUE;
        return MaterialsRepositoryKt.reportMaterialsDownload((ArrayList<String>) null, this);
    }
}
