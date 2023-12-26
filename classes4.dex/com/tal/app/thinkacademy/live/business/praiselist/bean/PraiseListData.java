package com.tal.app.thinkacademy.live.business.praiselist.bean;

import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b&\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0002\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0013\u00103\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\bHÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\u0012\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00067"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/praiselist/bean/PraiseListData;", "", "interactId", "", "pub", "", "isUpdate", "praiseType", "", "publishType", "firstTitle", "secondTitle", "courseName", "lessonName", "date", "studentList", "", "Lcom/tal/app/thinkacademy/live/business/praiselist/bean/PraiseListUserData;", "showStudentNum", "position", "(Ljava/lang/String;ZZIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;)V", "getCourseName", "()Ljava/lang/String;", "getDate", "getFirstTitle", "getInteractId", "()Z", "getLessonName", "getPosition", "getPraiseType", "()I", "getPub", "getPublishType", "getSecondTitle", "getShowStudentNum", "getStudentList", "()Ljava/util/List;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PraiseListData.kt */
public final class PraiseListData {
    private final String courseName;
    private final String date;
    private final String firstTitle;
    private final String interactId;
    private final boolean isUpdate;
    private final String lessonName;
    private final String position;
    private final int praiseType;
    private final boolean pub;
    private final int publishType;
    private final String secondTitle;
    private final int showStudentNum;
    private final List<PraiseListUserData> studentList;

    public static /* synthetic */ PraiseListData copy$default(PraiseListData praiseListData, String str, boolean z, boolean z2, int i, int i2, String str2, String str3, String str4, String str5, String str6, List list, int i3, String str7, int i4, Object obj) {
        PraiseListData praiseListData2 = praiseListData;
        int i5 = i4;
        return praiseListData.copy((i5 & 1) != 0 ? praiseListData2.interactId : str, (i5 & 2) != 0 ? praiseListData2.pub : z, (i5 & 4) != 0 ? praiseListData2.isUpdate : z2, (i5 & 8) != 0 ? praiseListData2.praiseType : i, (i5 & 16) != 0 ? praiseListData2.publishType : i2, (i5 & 32) != 0 ? praiseListData2.firstTitle : str2, (i5 & 64) != 0 ? praiseListData2.secondTitle : str3, (i5 & LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP) != 0 ? praiseListData2.courseName : str4, (i5 & 256) != 0 ? praiseListData2.lessonName : str5, (i5 & 512) != 0 ? praiseListData2.date : str6, (i5 & 1024) != 0 ? praiseListData2.studentList : list, (i5 & 2048) != 0 ? praiseListData2.showStudentNum : i3, (i5 & 4096) != 0 ? praiseListData2.position : str7);
    }

    public final String component1() {
        return this.interactId;
    }

    public final String component10() {
        return this.date;
    }

    public final List<PraiseListUserData> component11() {
        return this.studentList;
    }

    public final int component12() {
        return this.showStudentNum;
    }

    public final String component13() {
        return this.position;
    }

    public final boolean component2() {
        return this.pub;
    }

    public final boolean component3() {
        return this.isUpdate;
    }

    public final int component4() {
        return this.praiseType;
    }

    public final int component5() {
        return this.publishType;
    }

    public final String component6() {
        return this.firstTitle;
    }

    public final String component7() {
        return this.secondTitle;
    }

    public final String component8() {
        return this.courseName;
    }

    public final String component9() {
        return this.lessonName;
    }

    public final PraiseListData copy(String str, boolean z, boolean z2, int i, int i2, String str2, String str3, String str4, String str5, String str6, List<PraiseListUserData> list, int i3, String str7) {
        String str8 = str;
        Intrinsics.checkNotNullParameter(str8, "interactId");
        String str9 = str7;
        Intrinsics.checkNotNullParameter(str9, "position");
        return new PraiseListData(str8, z, z2, i, i2, str2, str3, str4, str5, str6, list, i3, str9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PraiseListData)) {
            return false;
        }
        PraiseListData praiseListData = (PraiseListData) obj;
        return Intrinsics.areEqual(this.interactId, praiseListData.interactId) && this.pub == praiseListData.pub && this.isUpdate == praiseListData.isUpdate && this.praiseType == praiseListData.praiseType && this.publishType == praiseListData.publishType && Intrinsics.areEqual(this.firstTitle, praiseListData.firstTitle) && Intrinsics.areEqual(this.secondTitle, praiseListData.secondTitle) && Intrinsics.areEqual(this.courseName, praiseListData.courseName) && Intrinsics.areEqual(this.lessonName, praiseListData.lessonName) && Intrinsics.areEqual(this.date, praiseListData.date) && Intrinsics.areEqual(this.studentList, praiseListData.studentList) && this.showStudentNum == praiseListData.showStudentNum && Intrinsics.areEqual(this.position, praiseListData.position);
    }

    public int hashCode() {
        int hashCode = this.interactId.hashCode() * 31;
        boolean z = this.pub;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.isUpdate;
        if (!z3) {
            z2 = z3;
        }
        int i2 = (((((i + (z2 ? 1 : 0)) * 31) + this.praiseType) * 31) + this.publishType) * 31;
        String str = this.firstTitle;
        int i3 = 0;
        int hashCode2 = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.secondTitle;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.courseName;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.lessonName;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.date;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<PraiseListUserData> list = this.studentList;
        if (list != null) {
            i3 = list.hashCode();
        }
        return ((((hashCode6 + i3) * 31) + this.showStudentNum) * 31) + this.position.hashCode();
    }

    public String toString() {
        return "PraiseListData(interactId=" + this.interactId + ", pub=" + this.pub + ", isUpdate=" + this.isUpdate + ", praiseType=" + this.praiseType + ", publishType=" + this.publishType + ", firstTitle=" + this.firstTitle + ", secondTitle=" + this.secondTitle + ", courseName=" + this.courseName + ", lessonName=" + this.lessonName + ", date=" + this.date + ", studentList=" + this.studentList + ", showStudentNum=" + this.showStudentNum + ", position=" + this.position + ')';
    }

    public PraiseListData(String str, boolean z, boolean z2, int i, int i2, String str2, String str3, String str4, String str5, String str6, List<PraiseListUserData> list, int i3, String str7) {
        Intrinsics.checkNotNullParameter(str, "interactId");
        Intrinsics.checkNotNullParameter(str7, "position");
        this.interactId = str;
        this.pub = z;
        this.isUpdate = z2;
        this.praiseType = i;
        this.publishType = i2;
        this.firstTitle = str2;
        this.secondTitle = str3;
        this.courseName = str4;
        this.lessonName = str5;
        this.date = str6;
        this.studentList = list;
        this.showStudentNum = i3;
        this.position = str7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PraiseListData(java.lang.String r18, boolean r19, boolean r20, int r21, int r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.util.List r28, int r29, java.lang.String r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r17 = this;
            r0 = r31
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r9 = r2
            goto L_0x000b
        L_0x0009:
            r9 = r23
        L_0x000b:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0011
            r10 = r2
            goto L_0x0013
        L_0x0011:
            r10 = r24
        L_0x0013:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0019
            r11 = r2
            goto L_0x001b
        L_0x0019:
            r11 = r25
        L_0x001b:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0021
            r12 = r2
            goto L_0x0023
        L_0x0021:
            r12 = r26
        L_0x0023:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0029
            r13 = r2
            goto L_0x002b
        L_0x0029:
            r13 = r27
        L_0x002b:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0031
            r14 = r2
            goto L_0x0033
        L_0x0031:
            r14 = r28
        L_0x0033:
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            r15 = r29
            r16 = r30
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.praiselist.bean.PraiseListData.<init>(java.lang.String, boolean, boolean, int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getInteractId() {
        return this.interactId;
    }

    public final boolean getPub() {
        return this.pub;
    }

    public final boolean isUpdate() {
        return this.isUpdate;
    }

    public final int getPraiseType() {
        return this.praiseType;
    }

    public final int getPublishType() {
        return this.publishType;
    }

    public final String getFirstTitle() {
        return this.firstTitle;
    }

    public final String getSecondTitle() {
        return this.secondTitle;
    }

    public final String getCourseName() {
        return this.courseName;
    }

    public final String getLessonName() {
        return this.lessonName;
    }

    public final String getDate() {
        return this.date;
    }

    public final List<PraiseListUserData> getStudentList() {
        return this.studentList;
    }

    public final int getShowStudentNum() {
        return this.showStudentNum;
    }

    public final String getPosition() {
        return this.position;
    }
}
