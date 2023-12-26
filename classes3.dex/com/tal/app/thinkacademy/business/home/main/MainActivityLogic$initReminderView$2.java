package com.tal.app.thinkacademy.business.home.main;

import android.os.Bundle;
import com.tal.app.thinkacademy.business.home.main.bean.LessonReminderData;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.lib.language.LanguageUtil;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MainActivityLogic.kt */
final class MainActivityLogic$initReminderView$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MainActivityLogic this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainActivityLogic$initReminderView$2(MainActivityLogic mainActivityLogic) {
        super(0);
        this.this$0 = mainActivityLogic;
    }

    public final void invoke() {
        Integer planId;
        String num;
        LessonReminderData access$getMLessonReminderData$p = this.this$0.mLessonReminderData;
        String str = null;
        String type = access$getMLessonReminderData$p == null ? null : access$getMLessonReminderData$p.getType();
        if (Intrinsics.areEqual((Object) type, (Object) "LESSON")) {
            this.this$0.enterClass();
            LaunchTrack launchTrack = LaunchTrack.INSTANCE;
            LessonReminderData access$getMLessonReminderData$p2 = this.this$0.mLessonReminderData;
            Integer planId2 = access$getMLessonReminderData$p2 == null ? null : access$getMLessonReminderData$p2.getPlanId();
            LessonReminderData access$getMLessonReminderData$p3 = this.this$0.mLessonReminderData;
            if (access$getMLessonReminderData$p3 != null) {
                str = access$getMLessonReminderData$p3.getLessonType();
            }
            String stringByChinese = this.this$0.mCurrentTabNameStringId > 0 ? LanguageUtil.getStringByChinese(this.this$0.activityProvider.getActivity(), this.this$0.mCurrentTabNameStringId) : "";
            Intrinsics.checkNotNullExpressionValue(stringByChinese, "if (mCurrentTabNameStrin…                        }");
            launchTrack.hw_class_reminder_enter_click(planId2, str, stringByChinese);
        } else if (Intrinsics.areEqual((Object) type, (Object) "REPORT")) {
            Bundle bundle = new Bundle();
            LessonReminderData access$getMLessonReminderData$p4 = this.this$0.mLessonReminderData;
            if (access$getMLessonReminderData$p4 != null) {
                str = access$getMLessonReminderData$p4.getUrl();
            }
            bundle.putString("jump_key", str);
            bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).build());
            XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
            LaunchTrack launchTrack2 = LaunchTrack.INSTANCE;
            LessonReminderData access$getMLessonReminderData$p5 = this.this$0.mLessonReminderData;
            String str2 = "0";
            if (!(access$getMLessonReminderData$p5 == null || (planId = access$getMLessonReminderData$p5.getPlanId()) == null || (num = planId.toString()) == null)) {
                str2 = num;
            }
            launchTrack2.lesson_report_tips_click(str2);
        }
    }
}
