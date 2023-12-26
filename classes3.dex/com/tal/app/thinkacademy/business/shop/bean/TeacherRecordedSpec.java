package com.tal.app.thinkacademy.business.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JV\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006!"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/TeacherRecordedSpec;", "", "subject", "", "subjectFullName", "lessonCount", "", "teacherList", "", "Lcom/tal/app/thinkacademy/business/shop/bean/RecordedTeacherItem;", "tutorList", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)V", "getLessonCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSubject", "()Ljava/lang/String;", "getSubjectFullName", "getTeacherList", "()Ljava/util/List;", "getTutorList", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)Lcom/tal/app/thinkacademy/business/shop/bean/TeacherRecordedSpec;", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherRecordedData.kt */
public final class TeacherRecordedSpec {
    private final Integer lessonCount;
    private final String subject;
    private final String subjectFullName;
    private final List<RecordedTeacherItem> teacherList;
    private final List<RecordedTeacherItem> tutorList;

    public TeacherRecordedSpec() {
        this((String) null, (String) null, (Integer) null, (List) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TeacherRecordedSpec copy$default(TeacherRecordedSpec teacherRecordedSpec, String str, String str2, Integer num, List<RecordedTeacherItem> list, List<RecordedTeacherItem> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = teacherRecordedSpec.subject;
        }
        if ((i & 2) != 0) {
            str2 = teacherRecordedSpec.subjectFullName;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            num = teacherRecordedSpec.lessonCount;
        }
        Integer num2 = num;
        if ((i & 8) != 0) {
            list = teacherRecordedSpec.teacherList;
        }
        List<RecordedTeacherItem> list3 = list;
        if ((i & 16) != 0) {
            list2 = teacherRecordedSpec.tutorList;
        }
        return teacherRecordedSpec.copy(str, str3, num2, list3, list2);
    }

    public final String component1() {
        return this.subject;
    }

    public final String component2() {
        return this.subjectFullName;
    }

    public final Integer component3() {
        return this.lessonCount;
    }

    public final List<RecordedTeacherItem> component4() {
        return this.teacherList;
    }

    public final List<RecordedTeacherItem> component5() {
        return this.tutorList;
    }

    public final TeacherRecordedSpec copy(String str, String str2, Integer num, List<RecordedTeacherItem> list, List<RecordedTeacherItem> list2) {
        return new TeacherRecordedSpec(str, str2, num, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TeacherRecordedSpec)) {
            return false;
        }
        TeacherRecordedSpec teacherRecordedSpec = (TeacherRecordedSpec) obj;
        return Intrinsics.areEqual((Object) this.subject, (Object) teacherRecordedSpec.subject) && Intrinsics.areEqual((Object) this.subjectFullName, (Object) teacherRecordedSpec.subjectFullName) && Intrinsics.areEqual((Object) this.lessonCount, (Object) teacherRecordedSpec.lessonCount) && Intrinsics.areEqual((Object) this.teacherList, (Object) teacherRecordedSpec.teacherList) && Intrinsics.areEqual((Object) this.tutorList, (Object) teacherRecordedSpec.tutorList);
    }

    public int hashCode() {
        String str = this.subject;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subjectFullName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.lessonCount;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        List<RecordedTeacherItem> list = this.teacherList;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        List<RecordedTeacherItem> list2 = this.tutorList;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "TeacherRecordedSpec(subject=" + this.subject + ", subjectFullName=" + this.subjectFullName + ", lessonCount=" + this.lessonCount + ", teacherList=" + this.teacherList + ", tutorList=" + this.tutorList + ')';
    }

    public TeacherRecordedSpec(String str, String str2, Integer num, List<RecordedTeacherItem> list, List<RecordedTeacherItem> list2) {
        this.subject = str;
        this.subjectFullName = str2;
        this.lessonCount = num;
        this.teacherList = list;
        this.tutorList = list2;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final String getSubjectFullName() {
        return this.subjectFullName;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TeacherRecordedSpec(java.lang.String r4, java.lang.String r5, java.lang.Integer r6, java.util.List r7, java.util.List r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            java.lang.String r0 = ""
            if (r10 == 0) goto L_0x0008
            r10 = r0
            goto L_0x0009
        L_0x0008:
            r10 = r4
        L_0x0009:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r0 = r5
        L_0x000f:
            r4 = r9 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
        L_0x0018:
            r1 = r6
            r4 = r9 & 8
            if (r4 == 0) goto L_0x0021
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0021:
            r2 = r7
            r4 = r9 & 16
            if (r4 == 0) goto L_0x002a
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
        L_0x002a:
            r9 = r8
            r4 = r3
            r5 = r10
            r6 = r0
            r7 = r1
            r8 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.TeacherRecordedSpec.<init>(java.lang.String, java.lang.String, java.lang.Integer, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer getLessonCount() {
        return this.lessonCount;
    }

    public final List<RecordedTeacherItem> getTeacherList() {
        return this.teacherList;
    }

    public final List<RecordedTeacherItem> getTutorList() {
        return this.tutorList;
    }
}
