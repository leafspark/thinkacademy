package com.tal.app.thinkacademy.business.study.study;

import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedCoursesFragment.kt */
final class RecordedCoursesFragment$gotoSeletedCourse$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ RecordedCoursesFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecordedCoursesFragment$gotoSeletedCourse$1(RecordedCoursesFragment recordedCoursesFragment) {
        super(0);
        this.this$0 = recordedCoursesFragment;
    }

    public final void invoke() {
        if (!PadUtils.isPad(this.this$0.getContext())) {
            XesDataBus.with("main_tab_switch").postStickyData("TAB_SHOP");
            StudyTrack.INSTANCE.hw_buy_class_click(ShowTab.Recorded.getAliasName());
        }
    }
}
