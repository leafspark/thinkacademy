package com.tal.app.thinkacademy.business.shop.viewmodel;

import com.tal.app.thinkacademy.business.shop.bean.GradeAggregateClassListData;
import com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTitleNode;
import com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository;
import java.util.ArrayList;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.shop.viewmodel.GradeAggregateVm$getClassList$2", f = "GradeAggregateVm.kt", i = {}, l = {282}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GradeAggregateVm.kt */
final class GradeAggregateVm$getClassList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GradeAggregateTitleNode $node;
    int label;
    final /* synthetic */ GradeAggregateVm this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GradeAggregateVm$getClassList$2(GradeAggregateVm gradeAggregateVm, GradeAggregateTitleNode gradeAggregateTitleNode, Continuation<? super GradeAggregateVm$getClassList$2> continuation) {
        super(2, continuation);
        this.this$0 = gradeAggregateVm;
        this.$node = gradeAggregateTitleNode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GradeAggregateVm$getClassList$2(this.this$0, this.$node, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GradeAggregateVm$getClassList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ShopClassListRepository access$getRepository$p = this.this$0.repository;
            ArrayList<Integer> courseIds = this.$node.getCourseIds();
            Intrinsics.checkNotNull(courseIds);
            this.label = 1;
            obj = access$getRepository$p.getClassList(courseIds, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        GradeAggregateClassListData gradeAggregateClassListData = (GradeAggregateClassListData) obj;
        if (gradeAggregateClassListData != null) {
            gradeAggregateClassListData.setNode(this.$node);
        }
        this.this$0.getClassList().postSuccess(gradeAggregateClassListData);
        return Unit.INSTANCE;
    }
}
