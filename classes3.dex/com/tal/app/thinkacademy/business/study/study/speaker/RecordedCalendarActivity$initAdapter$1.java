package com.tal.app.thinkacademy.business.study.study.speaker;

import com.tal.app.thinkacademy.business.study.study.entity.RecordedSchedule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "clickType", "Lcom/tal/app/thinkacademy/business/study/study/speaker/RecordedClickType;", "item", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedSchedule;", "position", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedCalendarActivity.kt */
final class RecordedCalendarActivity$initAdapter$1 extends Lambda implements Function3<RecordedClickType, RecordedSchedule, Integer, Unit> {
    final /* synthetic */ RecordedCalendarActivity this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RecordedCalendarActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RecordedClickType.values().length];
            iArr[RecordedClickType.RecordedCourseType.ordinal()] = 1;
            iArr[RecordedClickType.ExamType.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecordedCalendarActivity$initAdapter$1(RecordedCalendarActivity recordedCalendarActivity) {
        super(3);
        this.this$0 = recordedCalendarActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((RecordedClickType) obj, (RecordedSchedule) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: type inference failed for: r8v8, types: [java.lang.String] */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0026, code lost:
        r6 = r6.getHomework();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(com.tal.app.thinkacademy.business.study.study.speaker.RecordedClickType r6, com.tal.app.thinkacademy.business.study.study.entity.RecordedSchedule r7, int r8) {
        /*
            r5 = this;
            java.lang.String r0 = "clickType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            int[] r0 = com.tal.app.thinkacademy.business.study.study.speaker.RecordedCalendarActivity$initAdapter$1.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r0[r6]
            r0 = 0
            r1 = 1
            java.lang.String r2 = ""
            if (r6 == r1) goto L_0x00f3
            r8 = 2
            if (r6 == r8) goto L_0x001d
            goto L_0x014d
        L_0x001d:
            com.tal.app.thinkacademy.business.study.study.entity.RecordLesson r6 = r7.getRecordLesson()
            r8 = 0
            if (r6 != 0) goto L_0x0026
        L_0x0024:
            r6 = r8
            goto L_0x0031
        L_0x0026:
            com.tal.app.thinkacademy.business.study.study.entity.RecordHomework r6 = r6.getHomework()
            if (r6 != 0) goto L_0x002d
            goto L_0x0024
        L_0x002d:
            java.lang.String r6 = r6.getDisplayStatus()
        L_0x0031:
            com.tal.app.thinkacademy.business.study.study.speaker.RecordedFinalExamStatus r3 = com.tal.app.thinkacademy.business.study.study.speaker.RecordedFinalExamStatus.TO_BE_SUBMIT
            java.lang.String r3 = r3.getType()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r3)
            if (r6 == 0) goto L_0x0096
            com.tal.app.thinkacademy.business.study.study.speaker.RecordedExamNoteActivity$Companion r6 = com.tal.app.thinkacademy.business.study.study.speaker.RecordedExamNoteActivity.Companion
            com.tal.app.thinkacademy.business.study.study.speaker.RecordedCalendarActivity r3 = r5.this$0
            r4 = r3
            android.content.Context r4 = (android.content.Context) r4
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity r3 = r3.mListEntity
            if (r3 != 0) goto L_0x004b
            goto L_0x005e
        L_0x004b:
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarCourse r3 = r3.getCourse()
            if (r3 != 0) goto L_0x0052
            goto L_0x005e
        L_0x0052:
            java.lang.Boolean r0 = r3.getPermanent()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
        L_0x005e:
            if (r0 == 0) goto L_0x0069
            com.tal.app.thinkacademy.business.study.study.speaker.RecordedCalendarActivity r0 = r5.this$0
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.string.valid_permanently
            java.lang.String r2 = r0.getString(r1)
            goto L_0x0081
        L_0x0069:
            com.tal.app.thinkacademy.business.study.study.speaker.RecordedCalendarActivity r0 = r5.this$0
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity r0 = r0.mListEntity
            if (r0 != 0) goto L_0x0072
            goto L_0x0081
        L_0x0072:
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarCourse r0 = r0.getCourse()
            if (r0 != 0) goto L_0x0079
            goto L_0x0081
        L_0x0079:
            java.lang.String r0 = r0.getExpirationTime()
            if (r0 != 0) goto L_0x0080
            goto L_0x0081
        L_0x0080:
            r2 = r0
        L_0x0081:
            java.lang.String r0 = "if (mListEntity?.course?…                    ?: \"\""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            com.tal.app.thinkacademy.business.study.study.entity.RecordLesson r7 = r7.getRecordLesson()
            if (r7 != 0) goto L_0x008d
            goto L_0x0091
        L_0x008d:
            com.tal.app.thinkacademy.business.study.study.entity.RecordHomework r8 = r7.getHomework()
        L_0x0091:
            r6.startActivity(r4, r2, r8)
            goto L_0x014d
        L_0x0096:
            com.tal.app.thinkacademy.business.study.study.entity.RecordLesson r6 = r7.getRecordLesson()
            if (r6 != 0) goto L_0x009e
        L_0x009c:
            r6 = r8
            goto L_0x00a9
        L_0x009e:
            com.tal.app.thinkacademy.business.study.study.entity.RecordHomework r6 = r6.getHomework()
            if (r6 != 0) goto L_0x00a5
            goto L_0x009c
        L_0x00a5:
            java.lang.String r6 = r6.getDisplayStatus()
        L_0x00a9:
            com.tal.app.thinkacademy.business.study.study.speaker.RecordedFinalExamStatus r0 = com.tal.app.thinkacademy.business.study.study.speaker.RecordedFinalExamStatus.SUBMITTED
            java.lang.String r0 = r0.getType()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r0)
            if (r6 == 0) goto L_0x014d
            com.tal.app.thinkacademy.business.study.study.speaker.RecordedCalendarActivity r6 = r5.this$0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.tal.app.thinkacademy.business.study.study.entity.RecordLesson r7 = r7.getRecordLesson()
            if (r7 != 0) goto L_0x00c4
        L_0x00c2:
            r7 = r8
            goto L_0x00cf
        L_0x00c4:
            com.tal.app.thinkacademy.business.study.study.entity.RecordHomework r7 = r7.getHomework()
            if (r7 != 0) goto L_0x00cb
            goto L_0x00c2
        L_0x00cb:
            java.lang.String r7 = r7.getUrl()
        L_0x00cf:
            r0.append(r7)
            java.lang.String r7 = "&token="
            r0.append(r7)
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r7 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r7 = r7.getInstance()
            com.tal.app.thinkacademy.common.user.UserInfo r7 = r7.getUserInfoEntity()
            if (r7 != 0) goto L_0x00e4
            goto L_0x00e8
        L_0x00e4:
            java.lang.String r8 = r7.getUnifiedAccessToken()
        L_0x00e8:
            r0.append(r8)
            java.lang.String r7 = r0.toString()
            r6.jumpToWeb(r7)
            goto L_0x014d
        L_0x00f3:
            com.tal.app.thinkacademy.business.study.study.Tag r6 = com.tal.app.thinkacademy.business.study.study.Tag.RecordedCalendarActivity
            com.tal.app.thinkacademy.lib.logger.XesLogTag r6 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r6
            java.lang.Object[] r7 = new java.lang.Object[r1]
            java.lang.String r1 = "点击录播item"
            r7[r0] = r1
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r6, r7)
            com.tal.app.thinkacademy.business.study.study.vodplayer.VodPlayerDataHolder$Companion r6 = com.tal.app.thinkacademy.business.study.study.vodplayer.VodPlayerDataHolder.Companion
            com.tal.app.thinkacademy.business.study.study.vodplayer.VodPlayerDataHolder r6 = r6.getInstance()
            com.tal.app.thinkacademy.business.study.study.speaker.RecordedCalendarActivity r7 = r5.this$0
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity r7 = r7.mListEntity
            r6.setVodPlayerData(r7)
            com.tal.app.thinkacademy.business.study.study.vodplayer.VideoPlayerClassActivity$Companion r6 = com.tal.app.thinkacademy.business.study.study.vodplayer.VideoPlayerClassActivity.Companion
            com.tal.app.thinkacademy.business.study.study.speaker.RecordedCalendarActivity r7 = r5.this$0
            android.content.Context r7 = (android.content.Context) r7
            r6.startActivity(r7, r8)
            com.tal.app.thinkacademy.business.study.study.StudyTrack r6 = com.tal.app.thinkacademy.business.study.study.StudyTrack.INSTANCE
            com.tal.app.thinkacademy.business.study.study.speaker.RecordedCalendarActivity r7 = r5.this$0
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity r7 = r7.mListEntity
            if (r7 != 0) goto L_0x0124
        L_0x0122:
            r7 = r2
            goto L_0x0132
        L_0x0124:
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarCourse r7 = r7.getCourse()
            if (r7 != 0) goto L_0x012b
            goto L_0x0122
        L_0x012b:
            java.lang.String r7 = r7.getSkuId()
            if (r7 != 0) goto L_0x0132
            goto L_0x0122
        L_0x0132:
            com.tal.app.thinkacademy.business.study.study.speaker.RecordedCalendarActivity r8 = r5.this$0
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity r8 = r8.mListEntity
            if (r8 != 0) goto L_0x013b
            goto L_0x014a
        L_0x013b:
            com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarCourse r8 = r8.getCourse()
            if (r8 != 0) goto L_0x0142
            goto L_0x014a
        L_0x0142:
            java.lang.String r8 = r8.getName()
            if (r8 != 0) goto L_0x0149
            goto L_0x014a
        L_0x0149:
            r2 = r8
        L_0x014a:
            r6.hw_recorded_course_enter_click(r7, r2)
        L_0x014d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.RecordedCalendarActivity$initAdapter$1.invoke(com.tal.app.thinkacademy.business.study.study.speaker.RecordedClickType, com.tal.app.thinkacademy.business.study.study.entity.RecordedSchedule, int):void");
    }
}
