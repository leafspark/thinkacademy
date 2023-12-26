package com.tal.app.thinkacademy.business.home.main.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bw\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0001\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001a\u0010\u0010R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001b\u0010\u0010¨\u0006,"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Teacher;", "", "accountType", "", "avatar", "", "contactInfoList", "", "education", "empNo", "experience", "sysName", "teacherId", "teacherType", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAccountType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAvatar", "()Ljava/lang/String;", "getContactInfoList", "()Ljava/util/List;", "getEducation", "getEmpNo", "getExperience", "getSysName", "getTeacherId", "getTeacherType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Teacher;", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeDataType2.kt */
public final class Teacher {
    private final Integer accountType;
    private final String avatar;
    private final List<Object> contactInfoList;
    private final String education;
    private final String empNo;
    private final String experience;
    private final String sysName;
    private final Integer teacherId;
    private final Integer teacherType;

    public Teacher() {
        this((Integer) null, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, 511, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Teacher copy$default(Teacher teacher, Integer num, String str, List list, String str2, String str3, String str4, String str5, Integer num2, Integer num3, int i, Object obj) {
        Teacher teacher2 = teacher;
        int i2 = i;
        return teacher.copy((i2 & 1) != 0 ? teacher2.accountType : num, (i2 & 2) != 0 ? teacher2.avatar : str, (i2 & 4) != 0 ? teacher2.contactInfoList : list, (i2 & 8) != 0 ? teacher2.education : str2, (i2 & 16) != 0 ? teacher2.empNo : str3, (i2 & 32) != 0 ? teacher2.experience : str4, (i2 & 64) != 0 ? teacher2.sysName : str5, (i2 & 128) != 0 ? teacher2.teacherId : num2, (i2 & 256) != 0 ? teacher2.teacherType : num3);
    }

    public final Integer component1() {
        return this.accountType;
    }

    public final String component2() {
        return this.avatar;
    }

    public final List<Object> component3() {
        return this.contactInfoList;
    }

    public final String component4() {
        return this.education;
    }

    public final String component5() {
        return this.empNo;
    }

    public final String component6() {
        return this.experience;
    }

    public final String component7() {
        return this.sysName;
    }

    public final Integer component8() {
        return this.teacherId;
    }

    public final Integer component9() {
        return this.teacherType;
    }

    public final Teacher copy(Integer num, String str, List<? extends Object> list, String str2, String str3, String str4, String str5, Integer num2, Integer num3) {
        return new Teacher(num, str, list, str2, str3, str4, str5, num2, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Teacher)) {
            return false;
        }
        Teacher teacher = (Teacher) obj;
        return Intrinsics.areEqual((Object) this.accountType, (Object) teacher.accountType) && Intrinsics.areEqual((Object) this.avatar, (Object) teacher.avatar) && Intrinsics.areEqual((Object) this.contactInfoList, (Object) teacher.contactInfoList) && Intrinsics.areEqual((Object) this.education, (Object) teacher.education) && Intrinsics.areEqual((Object) this.empNo, (Object) teacher.empNo) && Intrinsics.areEqual((Object) this.experience, (Object) teacher.experience) && Intrinsics.areEqual((Object) this.sysName, (Object) teacher.sysName) && Intrinsics.areEqual((Object) this.teacherId, (Object) teacher.teacherId) && Intrinsics.areEqual((Object) this.teacherType, (Object) teacher.teacherType);
    }

    public int hashCode() {
        Integer num = this.accountType;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.avatar;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<Object> list = this.contactInfoList;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.education;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.empNo;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.experience;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.sysName;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num2 = this.teacherId;
        int hashCode8 = (hashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.teacherType;
        if (num3 != null) {
            i = num3.hashCode();
        }
        return hashCode8 + i;
    }

    public String toString() {
        return "Teacher(accountType=" + this.accountType + ", avatar=" + this.avatar + ", contactInfoList=" + this.contactInfoList + ", education=" + this.education + ", empNo=" + this.empNo + ", experience=" + this.experience + ", sysName=" + this.sysName + ", teacherId=" + this.teacherId + ", teacherType=" + this.teacherType + ')';
    }

    public Teacher(Integer num, String str, List<? extends Object> list, String str2, String str3, String str4, String str5, Integer num2, Integer num3) {
        this.accountType = num;
        this.avatar = str;
        this.contactInfoList = list;
        this.education = str2;
        this.empNo = str3;
        this.experience = str4;
        this.sysName = str5;
        this.teacherId = num2;
        this.teacherType = num3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Teacher(java.lang.Integer r11, java.lang.String r12, java.util.List r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.Integer r18, java.lang.Integer r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            if (r1 == 0) goto L_0x000d
            r1 = r2
            goto L_0x000e
        L_0x000d:
            r1 = r11
        L_0x000e:
            r3 = r0 & 2
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0016
            r3 = r4
            goto L_0x0017
        L_0x0016:
            r3 = r12
        L_0x0017:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0020
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0021
        L_0x0020:
            r5 = r13
        L_0x0021:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0027
            r6 = r4
            goto L_0x0028
        L_0x0027:
            r6 = r14
        L_0x0028:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002e
            r7 = r4
            goto L_0x002f
        L_0x002e:
            r7 = r15
        L_0x002f:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0035
            r8 = r4
            goto L_0x0037
        L_0x0035:
            r8 = r16
        L_0x0037:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r4 = r17
        L_0x003e:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0044
            r9 = r2
            goto L_0x0046
        L_0x0044:
            r9 = r18
        L_0x0046:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r2 = r19
        L_0x004d:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r4
            r19 = r9
            r20 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.shop.bean.Teacher.<init>(java.lang.Integer, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer getAccountType() {
        return this.accountType;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final List<Object> getContactInfoList() {
        return this.contactInfoList;
    }

    public final String getEducation() {
        return this.education;
    }

    public final String getEmpNo() {
        return this.empNo;
    }

    public final String getExperience() {
        return this.experience;
    }

    public final String getSysName() {
        return this.sysName;
    }

    public final Integer getTeacherId() {
        return this.teacherId;
    }

    public final Integer getTeacherType() {
        return this.teacherType;
    }
}
