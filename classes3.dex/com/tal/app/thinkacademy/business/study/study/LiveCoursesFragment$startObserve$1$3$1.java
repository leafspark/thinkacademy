package com.tal.app.thinkacademy.business.study.study;

import com.tal.app.thinkacademy.business.study.study.adapter.ChildClick;
import com.tal.app.thinkacademy.business.study.study.adapter.ClassAdapter;
import com.tal.app.thinkacademy.common.CommonStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "childClick", "Lcom/tal/app/thinkacademy/business/study/study/adapter/ChildClick;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveCoursesFragment.kt */
final class LiveCoursesFragment$startObserve$1$3$1 extends Lambda implements Function1<ChildClick, Unit> {
    final /* synthetic */ LiveCoursesFragment this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LiveCoursesFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ChildClick.values().length];
            iArr[ChildClick.CLOSE.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LiveCoursesFragment$startObserve$1$3$1(LiveCoursesFragment liveCoursesFragment) {
        super(1);
        this.this$0 = liveCoursesFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ChildClick) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ChildClick childClick) {
        Intrinsics.checkNotNullParameter(childClick, "childClick");
        if (WhenMappings.$EnumSwitchMapping$0[childClick.ordinal()] == 1) {
            CommonStateKt.setCloseDeviceTesting(true);
            ClassAdapter access$getMAdapter$p = this.this$0.mAdapter;
            if (access$getMAdapter$p != null) {
                access$getMAdapter$p.removeAt(this.this$0.deviceTestingIndex);
            }
            StudyTrack.INSTANCE.hw_device_test_close_click();
        }
    }
}
