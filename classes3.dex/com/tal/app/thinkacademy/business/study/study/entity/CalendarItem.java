package com.tal.app.thinkacademy.business.study.study.entity;

import android.text.TextUtils;
import com.chad.library.adapter.base.entity.SectionEntity;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.business.study.study.speaker.ScheduleType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\fJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003JO\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0013HÖ\u0001J\t\u0010%\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000e¨\u0006&"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/CalendarItem;", "Lcom/chad/library/adapter/base/entity/SectionEntity;", "examDetails", "Lcom/tal/app/thinkacademy/business/study/study/entity/ExamDetails;", "lessonDetails", "Lcom/tal/app/thinkacademy/business/study/study/entity/LessonDetails;", "scheduleName", "", "scheduleType", "isHeader", "", "date", "(Lcom/tal/app/thinkacademy/business/study/study/entity/ExamDetails;Lcom/tal/app/thinkacademy/business/study/study/entity/LessonDetails;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getDate", "()Ljava/lang/String;", "getExamDetails", "()Lcom/tal/app/thinkacademy/business/study/study/entity/ExamDetails;", "()Z", "itemType", "", "getItemType", "()I", "getLessonDetails", "()Lcom/tal/app/thinkacademy/business/study/study/entity/LessonDetails;", "getScheduleName", "getScheduleType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassCalendarEntity.kt */
public final class CalendarItem implements SectionEntity {
    private final String date;
    private final ExamDetails examDetails;
    private final boolean isHeader;
    private final LessonDetails lessonDetails;
    private final String scheduleName;
    private final String scheduleType;

    public CalendarItem() {
        this((ExamDetails) null, (LessonDetails) null, (String) null, (String) null, false, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CalendarItem copy$default(CalendarItem calendarItem, ExamDetails examDetails2, LessonDetails lessonDetails2, String str, String str2, boolean z, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            examDetails2 = calendarItem.examDetails;
        }
        if ((i & 2) != 0) {
            lessonDetails2 = calendarItem.lessonDetails;
        }
        LessonDetails lessonDetails3 = lessonDetails2;
        if ((i & 4) != 0) {
            str = calendarItem.scheduleName;
        }
        String str4 = str;
        if ((i & 8) != 0) {
            str2 = calendarItem.scheduleType;
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            z = calendarItem.isHeader();
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            str3 = calendarItem.date;
        }
        return calendarItem.copy(examDetails2, lessonDetails3, str4, str5, z2, str3);
    }

    public final ExamDetails component1() {
        return this.examDetails;
    }

    public final LessonDetails component2() {
        return this.lessonDetails;
    }

    public final String component3() {
        return this.scheduleName;
    }

    public final String component4() {
        return this.scheduleType;
    }

    public final boolean component5() {
        return isHeader();
    }

    public final String component6() {
        return this.date;
    }

    public final CalendarItem copy(ExamDetails examDetails2, LessonDetails lessonDetails2, String str, String str2, boolean z, String str3) {
        return new CalendarItem(examDetails2, lessonDetails2, str, str2, z, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarItem)) {
            return false;
        }
        CalendarItem calendarItem = (CalendarItem) obj;
        return Intrinsics.areEqual((Object) this.examDetails, (Object) calendarItem.examDetails) && Intrinsics.areEqual((Object) this.lessonDetails, (Object) calendarItem.lessonDetails) && Intrinsics.areEqual((Object) this.scheduleName, (Object) calendarItem.scheduleName) && Intrinsics.areEqual((Object) this.scheduleType, (Object) calendarItem.scheduleType) && isHeader() == calendarItem.isHeader() && Intrinsics.areEqual((Object) this.date, (Object) calendarItem.date);
    }

    public int hashCode() {
        ExamDetails examDetails2 = this.examDetails;
        int i = 0;
        int hashCode = (examDetails2 == null ? 0 : examDetails2.hashCode()) * 31;
        LessonDetails lessonDetails2 = this.lessonDetails;
        int hashCode2 = (hashCode + (lessonDetails2 == null ? 0 : lessonDetails2.hashCode())) * 31;
        String str = this.scheduleName;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.scheduleType;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean isHeader2 = isHeader();
        if (isHeader2) {
            isHeader2 = true;
        }
        int i2 = (hashCode4 + (isHeader2 ? 1 : 0)) * 31;
        String str3 = this.date;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "CalendarItem(examDetails=" + this.examDetails + ", lessonDetails=" + this.lessonDetails + ", scheduleName=" + this.scheduleName + ", scheduleType=" + this.scheduleType + ", isHeader=" + isHeader() + ", date=" + this.date + ')';
    }

    public CalendarItem(ExamDetails examDetails2, LessonDetails lessonDetails2, String str, String str2, boolean z, String str3) {
        this.examDetails = examDetails2;
        this.lessonDetails = lessonDetails2;
        this.scheduleName = str;
        this.scheduleType = str2;
        this.isHeader = z;
        this.date = str3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CalendarItem(com.tal.app.thinkacademy.business.study.study.entity.ExamDetails r5, com.tal.app.thinkacademy.business.study.study.entity.LessonDetails r6, java.lang.String r7, java.lang.String r8, boolean r9, java.lang.String r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            r0 = 0
            if (r12 == 0) goto L_0x0007
            r12 = r0
            goto L_0x0008
        L_0x0007:
            r12 = r5
        L_0x0008:
            r5 = r11 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r11 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r11 & 8
            if (r5 == 0) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r0 = r8
        L_0x001c:
            r5 = r11 & 16
            if (r5 == 0) goto L_0x0021
            r9 = 0
        L_0x0021:
            r3 = r9
            r5 = r11 & 32
            if (r5 == 0) goto L_0x0028
            java.lang.String r10 = ""
        L_0x0028:
            r11 = r10
            r5 = r4
            r6 = r12
            r7 = r1
            r8 = r2
            r9 = r0
            r10 = r3
            r5.<init>(r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.entity.CalendarItem.<init>(com.tal.app.thinkacademy.business.study.study.entity.ExamDetails, com.tal.app.thinkacademy.business.study.study.entity.LessonDetails, java.lang.String, java.lang.String, boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final ExamDetails getExamDetails() {
        return this.examDetails;
    }

    public final LessonDetails getLessonDetails() {
        return this.lessonDetails;
    }

    public final String getScheduleName() {
        return this.scheduleName;
    }

    public final String getScheduleType() {
        return this.scheduleType;
    }

    public boolean isHeader() {
        return this.isHeader;
    }

    public final String getDate() {
        return this.date;
    }

    public int getItemType() {
        if (isHeader() || !TextUtils.isEmpty(this.date)) {
            return -99;
        }
        if (TextUtils.equals(ScheduleType.Lesson.getType(), this.scheduleType)) {
            return -100;
        }
        return ClassParamsKt.TYPE_EXAM;
    }
}
