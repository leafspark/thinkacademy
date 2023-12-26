package com.tal.app.thinkacademy.business.study.study;

import com.tal.app.thinkacademy.business.study.study.vm.PrepareClassVM;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "clickType", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrepareClassActivity.kt */
final class PrepareClassActivity$startObserve$3$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ PrepareClassActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PrepareClassActivity$startObserve$3$1(PrepareClassActivity prepareClassActivity) {
        super(1);
        this.this$0 = prepareClassActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        if (i == 1) {
            this.this$0.showLoading();
            PrepareClassVM access$getMViewModel = this.this$0.getMViewModel();
            String access$getMPlanId$p = this.this$0.mPlanId;
            Integer num = null;
            Integer valueOf = access$getMPlanId$p == null ? null : Integer.valueOf(Integer.parseInt(access$getMPlanId$p));
            String access$getMCourseId$p = this.this$0.mCourseId;
            if (access$getMCourseId$p != null) {
                num = Integer.valueOf(Integer.parseInt(access$getMCourseId$p));
            }
            access$getMViewModel.requestCheckIn(valueOf, num);
            StudyTrack.classroomCheckin$default(StudyTrack.INSTANCE, "hw_classroom_checkin_click", this.this$0.subPlatformType, this.this$0.mCourseId, this.this$0.mPlanId, (String) null, Integer.valueOf(i), 16, (Object) null);
        }
    }
}
