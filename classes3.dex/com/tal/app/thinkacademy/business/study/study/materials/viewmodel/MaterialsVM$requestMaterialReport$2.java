package com.tal.app.thinkacademy.business.study.study.materials.viewmodel;

import com.tal.app.thinkacademy.business.study.study.materials.network.MaterialsRepositoryKt;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.entity.EmptyBean;
import java.util.ArrayList;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.study.study.materials.viewmodel.MaterialsVM$requestMaterialReport$2", f = "MaterialsVM.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MaterialsVM.kt */
final class MaterialsVM$requestMaterialReport$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayList<String> $materialIds;
    Object L$0;
    int label;
    final /* synthetic */ MaterialsVM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MaterialsVM$requestMaterialReport$2(MaterialsVM materialsVM, ArrayList<String> arrayList, Continuation<? super MaterialsVM$requestMaterialReport$2> continuation) {
        super(2, continuation);
        this.this$0 = materialsVM;
        this.$materialIds = arrayList;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MaterialsVM$requestMaterialReport$2(this.this$0, this.$materialIds, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MaterialsVM$requestMaterialReport$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        StateLiveData<EmptyBean> stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData<EmptyBean> materialReportData = this.this$0.getMaterialReportData();
            this.L$0 = materialReportData;
            this.label = 1;
            Object reportMaterialsDownload = MaterialsRepositoryKt.reportMaterialsDownload(this.$materialIds, this);
            if (reportMaterialsDownload == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = materialReportData;
            obj = reportMaterialsDownload;
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
