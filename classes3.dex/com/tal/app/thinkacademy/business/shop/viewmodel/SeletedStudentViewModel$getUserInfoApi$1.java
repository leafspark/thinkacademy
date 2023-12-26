package com.tal.app.thinkacademy.business.shop.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.shop.viewmodel.SeletedStudentViewModel", f = "SeletedStudentViewModel.kt", i = {}, l = {156, 154}, m = "getUserInfoApi", n = {}, s = {})
/* compiled from: SeletedStudentViewModel.kt */
final class SeletedStudentViewModel$getUserInfoApi$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SeletedStudentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SeletedStudentViewModel$getUserInfoApi$1(SeletedStudentViewModel seletedStudentViewModel, Continuation<? super SeletedStudentViewModel$getUserInfoApi$1> continuation) {
        super(continuation);
        this.this$0 = seletedStudentViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= IntCompanionObject.MIN_VALUE;
        return this.this$0.getUserInfoApi(this);
    }
}
