package com.tal.app.thinkacademy.business.shop.viewmodel;

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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.shop.viewmodel.GradeAggregateVm$submitIntention$2", f = "GradeAggregateVm.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GradeAggregateVm.kt */
final class GradeAggregateVm$submitIntention$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $day;
    final /* synthetic */ String $email;
    final /* synthetic */ String $name;
    final /* synthetic */ Integer $subStatus;
    final /* synthetic */ String $time;
    final /* synthetic */ String $yearGroup;
    Object L$0;
    int label;
    final /* synthetic */ GradeAggregateVm this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GradeAggregateVm$submitIntention$2(GradeAggregateVm gradeAggregateVm, String str, String str2, String str3, String str4, String str5, Integer num, Continuation<? super GradeAggregateVm$submitIntention$2> continuation) {
        super(2, continuation);
        this.this$0 = gradeAggregateVm;
        this.$yearGroup = str;
        this.$day = str2;
        this.$time = str3;
        this.$email = str4;
        this.$name = str5;
        this.$subStatus = num;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GradeAggregateVm$submitIntention$2(this.this$0, this.$yearGroup, this.$day, this.$time, this.$email, this.$name, this.$subStatus, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GradeAggregateVm$submitIntention$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        StateLiveData<Object> stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData<Object> submitIntention = this.this$0.getSubmitIntention();
            this.L$0 = submitIntention;
            this.label = 1;
            Object submitIntention2 = this.this$0.repository.submitIntention(this.$yearGroup, this.$day, this.$time, this.$email, this.$name, this.$subStatus, this);
            if (submitIntention2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = submitIntention;
            obj = submitIntention2;
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
