package com.tal.app.thinkacademy.business.home.main.dialog;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.home.main.dialog.MainDialogManager$next$2", f = "MainDialogManager.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MainDialogManager.kt */
final class MainDialogManager$next$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ MainDialogManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainDialogManager$next$2(MainDialogManager mainDialogManager, Continuation<? super MainDialogManager$next$2> continuation) {
        super(2, continuation);
        this.this$0 = mainDialogManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MainDialogManager$next$2 mainDialogManager$next$2 = new MainDialogManager$next$2(this.this$0, continuation);
        mainDialogManager$next$2.Z$0 = ((Boolean) obj).booleanValue();
        return mainDialogManager$next$2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) (Continuation) obj2);
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((MainDialogManager$next$2) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            boolean z = this.Z$0;
            this.label = 1;
            if (this.this$0.next(z, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
