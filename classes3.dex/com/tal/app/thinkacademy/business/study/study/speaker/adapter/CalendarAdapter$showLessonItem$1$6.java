package com.tal.app.thinkacademy.business.study.study.speaker.adapter;

import com.tal.app.thinkacademy.business.study.study.entity.CalendarItem;
import com.tal.app.thinkacademy.business.study.study.entity.LessonDetails;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CalendarAdapter.kt */
final class CalendarAdapter$showLessonItem$1$6 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CalendarItem $item;
    final /* synthetic */ LessonDetails $this_run;
    final /* synthetic */ CalendarAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CalendarAdapter$showLessonItem$1$6(LessonDetails lessonDetails, CalendarAdapter calendarAdapter, CalendarItem calendarItem) {
        super(0);
        this.$this_run = lessonDetails;
        this.this$0 = calendarAdapter;
        this.$item = calendarItem;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        r0 = r0.getSourceType();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r5 = this;
            com.tal.app.thinkacademy.business.study.study.entity.LessonDetails r0 = r5.$this_run
            com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity r0 = r0.getAssignment()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            r0 = r2
            goto L_0x001a
        L_0x000c:
            java.lang.Integer r0 = r0.getSourceType()
            if (r0 != 0) goto L_0x0013
            goto L_0x000a
        L_0x0013:
            int r0 = r0.intValue()
            if (r0 != 0) goto L_0x000a
            r0 = r1
        L_0x001a:
            if (r0 == 0) goto L_0x00d2
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r0 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r0 = r0.getInstance()
            boolean r0 = r0.isGuest()
            if (r0 != 0) goto L_0x00e2
            com.tal.app.thinkacademy.business.study.study.entity.LessonDetails r0 = r5.$this_run
            com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity r0 = r0.getAssignment()
            java.lang.String r0 = r0.getUrl()
            if (r0 == 0) goto L_0x00e2
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            com.tal.app.thinkacademy.business.study.study.entity.LessonDetails r3 = r5.$this_run
            com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity r3 = r3.getAssignment()
            java.lang.String r3 = r3.getUrl()
            java.lang.String r4 = "jump_key"
            r0.putString(r4, r3)
            com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig$Builder r3 = new com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig$Builder
            r3.<init>()
            com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig$Builder r1 = r3.setShowProgressBar(r1)
            com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig$Builder r1 = r1.setShowTitle(r2)
            com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter r3 = r5.this$0
            android.content.Context r3 = r3.getContext()
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.string.assignment_tile
            java.lang.String r3 = r3.getString(r4)
            com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig$Builder r1 = r1.setLocalTitle(r3)
            com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig r1 = r1.build()
            java.io.Serializable r1 = (java.io.Serializable) r1
            java.lang.String r3 = "agent_config"
            r0.putSerializable(r3, r1)
            com.tal.app.thinkacademy.business.study.study.entity.LessonDetails r1 = r5.$this_run
            com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity r1 = r1.getAssignment()
            com.tal.app.thinkacademy.business.study.study.entity.JumpParamsEntity r1 = r1.getJumpParams()
            r3 = 0
            if (r1 != 0) goto L_0x007f
            r1 = r3
            goto L_0x0083
        L_0x007f:
            java.lang.String r1 = r1.getHomeworkId()
        L_0x0083:
            java.lang.String r4 = "homework_id"
            r0.putString(r4, r1)
            com.tal.app.thinkacademy.business.study.study.entity.LessonDetails r1 = r5.$this_run
            com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity r1 = r1.getAssignment()
            com.tal.app.thinkacademy.business.study.study.entity.JumpParamsEntity r1 = r1.getJumpParams()
            if (r1 != 0) goto L_0x0095
            goto L_0x0099
        L_0x0095:
            java.lang.Integer r3 = r1.getClassId()
        L_0x0099:
            java.lang.String r1 = java.lang.String.valueOf(r3)
            java.lang.String r3 = "class_id"
            r0.putString(r3, r1)
            com.tal.app.thinkacademy.business.study.study.entity.LessonDetails r1 = r5.$this_run
            com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity r1 = r1.getAssignment()
            com.tal.app.thinkacademy.business.study.study.entity.JumpParamsEntity r1 = r1.getJumpParams()
            if (r1 != 0) goto L_0x00b0
        L_0x00ae:
            r1 = r2
            goto L_0x00bb
        L_0x00b0:
            java.lang.Integer r1 = r1.getPlanId()
            if (r1 != 0) goto L_0x00b7
            goto L_0x00ae
        L_0x00b7:
            int r1 = r1.intValue()
        L_0x00bb:
            java.lang.String r3 = "plan_id"
            r0.putInt(r3, r1)
            java.lang.String r1 = "homework_type"
            r0.putInt(r1, r2)
            com.tal.app.thinkacademy.lib.route.XesRoute r1 = com.tal.app.thinkacademy.lib.route.XesRoute.getInstance()
            java.lang.String r2 = "/commui/browser_activity"
            r1.navigation(r2, r0)
            r0.clear()
            goto L_0x00e2
        L_0x00d2:
            com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter r0 = r5.this$0
            kotlin.jvm.functions.Function2 r0 = r0.listener
            if (r0 != 0) goto L_0x00db
            goto L_0x00e2
        L_0x00db:
            com.tal.app.thinkacademy.business.study.study.entity.CalendarItem r1 = r5.$item
            com.tal.app.thinkacademy.business.study.study.speaker.ClickType r2 = com.tal.app.thinkacademy.business.study.study.speaker.ClickType.Homework
            r0.invoke(r2, r1)
        L_0x00e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$6.invoke():void");
    }
}
