package com.tal.app.thinkacademy.business.login.config;

import com.tal.app.thinkacademy.business.login.entity.CurriculumListData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.login.config.TempClassRepository", f = "TempClassRepository.kt", i = {}, l = {29, 29}, m = "getStudentCurriculumList", n = {}, s = {})
/* compiled from: TempClassRepository.kt */
final class TempClassRepository$getStudentCurriculumList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TempClassRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TempClassRepository$getStudentCurriculumList$1(TempClassRepository tempClassRepository, Continuation<? super TempClassRepository$getStudentCurriculumList$1> continuation) {
        super(continuation);
        this.this$0 = tempClassRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= IntCompanionObject.MIN_VALUE;
        return this.this$0.getStudentCurriculumList((CurriculumListData) null, this);
    }
}
