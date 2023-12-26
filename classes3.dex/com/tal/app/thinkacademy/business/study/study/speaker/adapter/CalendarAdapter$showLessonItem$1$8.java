package com.tal.app.thinkacademy.business.study.study.speaker.adapter;

import com.tal.app.thinkacademy.business.study.study.entity.LessonDetails;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CalendarAdapter.kt */
final class CalendarAdapter$showLessonItem$1$8 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LessonDetails $this_run;
    final /* synthetic */ CalendarAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CalendarAdapter$showLessonItem$1$8(LessonDetails lessonDetails, CalendarAdapter calendarAdapter) {
        super(0);
        this.$this_run = lessonDetails;
        this.this$0 = calendarAdapter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0023, code lost:
        r1 = r1.getCount();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r19 = this;
            r0 = r19
            com.tal.app.thinkacademy.business.study.study.entity.LessonDetails r1 = r0.$this_run
            java.lang.String r1 = r1.getClassId()
            java.lang.String r3 = java.lang.String.valueOf(r1)
            com.tal.app.thinkacademy.business.study.study.entity.LessonDetails r1 = r0.$this_run
            java.lang.String r1 = r1.getPlanId()
            java.lang.String r4 = java.lang.String.valueOf(r1)
            com.tal.app.thinkacademy.business.study.study.entity.LessonDetails r1 = r0.$this_run
            com.tal.app.thinkacademy.business.study.study.entity.MaterialEntity r1 = r1.getMaterial()
            r18 = 0
            if (r1 != 0) goto L_0x0023
        L_0x0020:
            r5 = r18
            goto L_0x002f
        L_0x0023:
            java.lang.Integer r1 = r1.getCount()
            if (r1 != 0) goto L_0x002a
            goto L_0x0020
        L_0x002a:
            java.lang.String r1 = r1.toString()
            r5 = r1
        L_0x002f:
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 16368(0x3ff0, float:2.2936E-41)
            r17 = 0
            java.lang.String r2 = "click_learning_material_enter_button"
            com.tal.app.thinkacademy.common.utils.LeanplumUtil.longTrack$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            com.tal.app.thinkacademy.business.study.study.StudyTrack r1 = com.tal.app.thinkacademy.business.study.study.StudyTrack.INSTANCE
            com.tal.app.thinkacademy.business.study.study.entity.LessonDetails r2 = r0.$this_run
            java.lang.String r2 = r2.getPlanId()
            r1.learningMaterialClick(r2)
            com.tal.app.thinkacademy.common.appmonitor.HWEventTracking$Companion r1 = com.tal.app.thinkacademy.common.appmonitor.HWEventTracking.Companion
            com.tal.app.thinkacademy.common.appmonitor.HWEventTracking r1 = r1.get()
            com.tal.app.thinkacademy.business.study.study.entity.LessonDetails r2 = r0.$this_run
            java.lang.String r2 = r2.getPlanId()
            if (r2 != 0) goto L_0x005d
            java.lang.String r2 = ""
        L_0x005d:
            r1.ostaLeraningMaterial(r2)
            com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivity$Companion r1 = com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivity.Companion
            com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter r2 = r0.this$0
            android.content.Context r2 = r2.getContext()
            com.tal.app.thinkacademy.business.study.study.entity.LessonDetails r3 = r0.$this_run
            java.lang.String r3 = r3.getPlanId()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            com.tal.app.thinkacademy.business.study.study.entity.LessonDetails r4 = r0.$this_run
            java.lang.String r4 = r4.getClassId()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            com.tal.app.thinkacademy.business.study.study.entity.LessonDetails r5 = r0.$this_run
            com.tal.app.thinkacademy.business.study.study.entity.MaterialEntity r5 = r5.getMaterial()
            if (r5 != 0) goto L_0x0087
        L_0x0084:
            r5 = r18
            goto L_0x0093
        L_0x0087:
            java.lang.Integer r5 = r5.getCount()
            if (r5 != 0) goto L_0x008e
            goto L_0x0084
        L_0x008e:
            java.lang.String r18 = r5.toString()
            goto L_0x0084
        L_0x0093:
            r1.startActivity(r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$8.invoke():void");
    }
}
