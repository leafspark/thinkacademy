package com.tal.app.thinkacademy.business.home.main;

import com.tal.app.thinkacademy.business.home.main.bean.LessonReminderData;
import com.tal.app.thinkacademy.lib.language.LanguageUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MainActivityLogic.kt */
final class MainActivityLogic$initReminderView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MainActivityLogic this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainActivityLogic$initReminderView$1(MainActivityLogic mainActivityLogic) {
        super(0);
        this.this$0 = mainActivityLogic;
    }

    public final void invoke() {
        Integer planId;
        Integer planId2;
        LessonReminderData access$getMLessonReminderData$p = this.this$0.mLessonReminderData;
        String str = null;
        String type = access$getMLessonReminderData$p == null ? null : access$getMLessonReminderData$p.getType();
        int i = -1;
        if (Intrinsics.areEqual((Object) type, (Object) "LESSON")) {
            this.this$0.hideRemind();
            MainActivityLogic mainActivityLogic = this.this$0;
            LessonReminderData access$getMLessonReminderData$p2 = mainActivityLogic.mLessonReminderData;
            if (!(access$getMLessonReminderData$p2 == null || (planId2 = access$getMLessonReminderData$p2.getPlanId()) == null)) {
                i = planId2.intValue();
            }
            mainActivityLogic.mOnCloseClassPlanId = i;
            LaunchTrack launchTrack = LaunchTrack.INSTANCE;
            LessonReminderData access$getMLessonReminderData$p3 = this.this$0.mLessonReminderData;
            Integer planId3 = access$getMLessonReminderData$p3 == null ? null : access$getMLessonReminderData$p3.getPlanId();
            LessonReminderData access$getMLessonReminderData$p4 = this.this$0.mLessonReminderData;
            if (access$getMLessonReminderData$p4 != null) {
                str = access$getMLessonReminderData$p4.getLessonType();
            }
            String stringByChinese = this.this$0.mCurrentTabNameStringId > 0 ? LanguageUtil.getStringByChinese(this.this$0.activityProvider.getActivity(), this.this$0.mCurrentTabNameStringId) : "";
            Intrinsics.checkNotNullExpressionValue(stringByChinese, "if (mCurrentTabNameStrin…                        }");
            launchTrack.hw_class_reminder_close_click(planId3, str, stringByChinese);
        } else if (Intrinsics.areEqual((Object) type, (Object) "REPORT")) {
            this.this$0.hideRemind();
            MainActivityLogic mainActivityLogic2 = this.this$0;
            LessonReminderData access$getMLessonReminderData$p5 = mainActivityLogic2.mLessonReminderData;
            if (!(access$getMLessonReminderData$p5 == null || (planId = access$getMLessonReminderData$p5.getPlanId()) == null)) {
                i = planId.intValue();
            }
            mainActivityLogic2.mOnCloseReportPlanId = i;
        }
    }
}
