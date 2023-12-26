package com.tal.app.thinkacademy.business.login.presenter;

import com.tal.app.thinkacademy.business.login.entity.TimeZone;
import com.tal.app.thinkacademy.business.login.entity.TimeZoneEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.login.presenter.ChooseTimeZoneViewModel$getTimeZoneList$2", f = "ChooseTimeZoneViewModel.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ChooseTimeZoneViewModel.kt */
final class ChooseTimeZoneViewModel$getTimeZoneList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChooseTimeZoneViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChooseTimeZoneViewModel$getTimeZoneList$2(ChooseTimeZoneViewModel chooseTimeZoneViewModel, Continuation<? super ChooseTimeZoneViewModel$getTimeZoneList$2> continuation) {
        super(2, continuation);
        this.this$0 = chooseTimeZoneViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChooseTimeZoneViewModel$getTimeZoneList$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChooseTimeZoneViewModel$getTimeZoneList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.repository.getTimeZoneList(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String[] strArr = (String[]) obj;
        TimeZoneEntity timeZoneEntity = new TimeZoneEntity((String[]) null, (ArrayList) null, 3, (DefaultConstructorMarker) null);
        timeZoneEntity.setTzList(strArr);
        if (strArr != null) {
            if (!(strArr.length == 0)) {
                z = false;
            }
        }
        if (!z) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new ArrayList();
            if (strArr != null) {
                for (String timeZone : strArr) {
                    ((ArrayList) objectRef.element).add(new TimeZone(timeZone));
                }
            }
            timeZoneEntity.setList((ArrayList) objectRef.element);
        }
        this.this$0.getTimeZoneList().postSuccess(timeZoneEntity);
        return Unit.INSTANCE;
    }
}
