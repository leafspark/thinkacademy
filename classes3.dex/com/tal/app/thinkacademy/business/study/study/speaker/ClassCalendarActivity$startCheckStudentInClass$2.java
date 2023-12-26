package com.tal.app.thinkacademy.business.study.study.speaker;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.study.study.speaker.ClassCalendarActivity$startCheckStudentInClass$2", f = "ClassCalendarActivity.kt", i = {}, l = {479}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ClassCalendarActivity.kt */
final class ClassCalendarActivity$startCheckStudentInClass$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $listen;
    final /* synthetic */ Integer $planId;
    int label;
    final /* synthetic */ ClassCalendarActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClassCalendarActivity$startCheckStudentInClass$2(Integer num, ClassCalendarActivity classCalendarActivity, Function0<Unit> function0, Continuation<? super ClassCalendarActivity$startCheckStudentInClass$2> continuation) {
        super(2, continuation);
        this.$planId = num;
        this.this$0 = classCalendarActivity;
        this.$listen = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClassCalendarActivity$startCheckStudentInClass$2(this.$planId, this.this$0, this.$listen, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ClassCalendarActivity$startCheckStudentInClass$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        r5 = r5.getLastInClassSameDevice();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x002d
        L_0x000f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.Integer r5 = r4.$planId
            r1 = -1
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r3 = r4
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4.label = r2
            java.lang.Object r5 = com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt.checkStudentInClass(r5, r1, r3)
            if (r5 != r0) goto L_0x002d
            return r0
        L_0x002d:
            com.tal.app.thinkacademy.business.study.study.entity.CheckStudentInClass r5 = (com.tal.app.thinkacademy.business.study.study.entity.CheckStudentInClass) r5
            com.tal.app.thinkacademy.business.study.study.speaker.ClassCalendarActivity r0 = r4.this$0
            r0.hideLoading()
            r0 = 0
            if (r5 != 0) goto L_0x0039
        L_0x0037:
            r1 = r0
            goto L_0x0047
        L_0x0039:
            java.lang.Integer r1 = r5.getMaybeInClass()
            if (r1 != 0) goto L_0x0040
            goto L_0x0037
        L_0x0040:
            int r1 = r1.intValue()
            if (r1 != r2) goto L_0x0037
            r1 = r2
        L_0x0047:
            if (r1 == 0) goto L_0x0068
            if (r5 != 0) goto L_0x004d
        L_0x004b:
            r5 = r0
            goto L_0x005c
        L_0x004d:
            java.lang.Integer r5 = r5.getLastInClassSameDevice()
            r1 = 2
            if (r5 != 0) goto L_0x0055
            goto L_0x004b
        L_0x0055:
            int r5 = r5.intValue()
            if (r5 != r1) goto L_0x004b
            r5 = r2
        L_0x005c:
            if (r5 == 0) goto L_0x0068
            com.tal.app.thinkacademy.business.study.study.speaker.ClassCalendarActivity r5 = r4.this$0
            kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r4.$listen
            r5.showEnterTipsDialog(r0)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0068:
            java.lang.Object[] r5 = new java.lang.Object[r2]
            java.lang.String r1 = "checkStudentInClass success"
            r5[r0] = r1
            java.lang.String r0 = "ClassCalendarActivity"
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r0, r5)
            kotlin.jvm.functions.Function0<kotlin.Unit> r5 = r4.$listen
            r5.invoke()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.ClassCalendarActivity$startCheckStudentInClass$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
