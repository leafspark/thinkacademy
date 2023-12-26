package com.tal.app.thinkacademy.business.home.main.vm;

import com.tal.app.thinkacademy.business.home.main.bean.SchoolCode;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.home.main.vm.LaunchViewModel$getSchoolCode$2", f = "LaunchViewModel.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LaunchViewModel.kt */
final class LaunchViewModel$getSchoolCode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $countryCode;
    Object L$0;
    int label;
    final /* synthetic */ LaunchViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LaunchViewModel$getSchoolCode$2(LaunchViewModel launchViewModel, String str, Continuation<? super LaunchViewModel$getSchoolCode$2> continuation) {
        super(2, continuation);
        this.this$0 = launchViewModel;
        this.$countryCode = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LaunchViewModel$getSchoolCode$2(this.this$0, this.$countryCode, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LaunchViewModel$getSchoolCode$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        StateLiveData<SchoolCode> stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData<SchoolCode> schoolCode = this.this$0.getSchoolCode();
            this.L$0 = schoolCode;
            this.label = 1;
            Object schoolCode2 = this.this$0.repository.getSchoolCode(this.$countryCode, this);
            if (schoolCode2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = schoolCode;
            obj = schoolCode2;
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
