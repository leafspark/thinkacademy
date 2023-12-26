package com.tal.app.thinkacademy.business.shop.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u00106\u001a\u00020\u0003HÖ\u0001J\t\u00107\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0013R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0015¨\u00068"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailTeacher;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "accountType", "", "avatar", "", "contactInfoList", "", "", "education", "empNo", "experience", "sysName", "teacherId", "teacherType", "tutorDuty", "local_position_type", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/Integer;)V", "getAccountType", "()I", "getAvatar", "()Ljava/lang/String;", "getContactInfoList", "()Ljava/util/List;", "getEducation", "getEmpNo", "getExperience", "itemType", "getItemType", "getLocal_position_type", "()Ljava/lang/Integer;", "setLocal_position_type", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSysName", "getTeacherId", "getTeacherType", "getTutorDuty", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailTeacher;", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailInfoBean.kt */
public final class ShopClassDetailTeacher implements MultiItemEntity {
    private final int accountType;
    private final String avatar;
    private final List<Object> contactInfoList;
    private final String education;
    private final String empNo;
    private final String experience;
    private Integer local_position_type;
    private final String sysName;
    private final int teacherId;
    private final int teacherType;
    private final String tutorDuty;

    public ShopClassDetailTeacher() {
        this(0, (String) null, (List) null, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (Integer) null, 2047, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopClassDetailTeacher copy$default(ShopClassDetailTeacher shopClassDetailTeacher, int i, String str, List list, String str2, String str3, String str4, String str5, int i2, int i3, String str6, Integer num, int i4, Object obj) {
        ShopClassDetailTeacher shopClassDetailTeacher2 = shopClassDetailTeacher;
        int i5 = i4;
        return shopClassDetailTeacher.copy((i5 & 1) != 0 ? shopClassDetailTeacher2.accountType : i, (i5 & 2) != 0 ? shopClassDetailTeacher2.avatar : str, (i5 & 4) != 0 ? shopClassDetailTeacher2.contactInfoList : list, (i5 & 8) != 0 ? shopClassDetailTeacher2.education : str2, (i5 & 16) != 0 ? shopClassDetailTeacher2.empNo : str3, (i5 & 32) != 0 ? shopClassDetailTeacher2.experience : str4, (i5 & 64) != 0 ? shopClassDetailTeacher2.sysName : str5, (i5 & 128) != 0 ? shopClassDetailTeacher2.teacherId : i2, (i5 & 256) != 0 ? shopClassDetailTeacher2.teacherType : i3, (i5 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? shopClassDetailTeacher2.tutorDuty : str6, (i5 & 1024) != 0 ? shopClassDetailTeacher2.local_position_type : num);
    }

    public final int component1() {
        return this.accountType;
    }

    public final String component10() {
        return this.tutorDuty;
    }

    public final Integer component11() {
        return this.local_position_type;
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

    public final int component8() {
        return this.teacherId;
    }

    public final int component9() {
        return this.teacherType;
    }

    public final ShopClassDetailTeacher copy(int i, String str, List<? extends Object> list, String str2, String str3, String str4, String str5, int i2, int i3, String str6, Integer num) {
        return new ShopClassDetailTeacher(i, str, list, str2, str3, str4, str5, i2, i3, str6, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopClassDetailTeacher)) {
            return false;
        }
        ShopClassDetailTeacher shopClassDetailTeacher = (ShopClassDetailTeacher) obj;
        return this.accountType == shopClassDetailTeacher.accountType && Intrinsics.areEqual((Object) this.avatar, (Object) shopClassDetailTeacher.avatar) && Intrinsics.areEqual((Object) this.contactInfoList, (Object) shopClassDetailTeacher.contactInfoList) && Intrinsics.areEqual((Object) this.education, (Object) shopClassDetailTeacher.education) && Intrinsics.areEqual((Object) this.empNo, (Object) shopClassDetailTeacher.empNo) && Intrinsics.areEqual((Object) this.experience, (Object) shopClassDetailTeacher.experience) && Intrinsics.areEqual((Object) this.sysName, (Object) shopClassDetailTeacher.sysName) && this.teacherId == shopClassDetailTeacher.teacherId && this.teacherType == shopClassDetailTeacher.teacherType && Intrinsics.areEqual((Object) this.tutorDuty, (Object) shopClassDetailTeacher.tutorDuty) && Intrinsics.areEqual((Object) this.local_position_type, (Object) shopClassDetailTeacher.local_position_type);
    }

    public int hashCode() {
        int i = this.accountType * 31;
        String str = this.avatar;
        int i2 = 0;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        List<Object> list = this.contactInfoList;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.education;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.empNo;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.experience;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.sysName;
        int hashCode6 = (((((hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.teacherId) * 31) + this.teacherType) * 31;
        String str6 = this.tutorDuty;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num = this.local_position_type;
        if (num != null) {
            i2 = num.hashCode();
        }
        return hashCode7 + i2;
    }

    public String toString() {
        return "ShopClassDetailTeacher(accountType=" + this.accountType + ", avatar=" + this.avatar + ", contactInfoList=" + this.contactInfoList + ", education=" + this.education + ", empNo=" + this.empNo + ", experience=" + this.experience + ", sysName=" + this.sysName + ", teacherId=" + this.teacherId + ", teacherType=" + this.teacherType + ", tutorDuty=" + this.tutorDuty + ", local_position_type=" + this.local_position_type + ')';
    }

    public ShopClassDetailTeacher(int i, String str, List<? extends Object> list, String str2, String str3, String str4, String str5, int i2, int i3, String str6, Integer num) {
        this.accountType = i;
        this.avatar = str;
        this.contactInfoList = list;
        this.education = str2;
        this.empNo = str3;
        this.experience = str4;
        this.sysName = str5;
        this.teacherId = i2;
        this.teacherType = i3;
        this.tutorDuty = str6;
        this.local_position_type = num;
    }

    public final int getAccountType() {
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

    public final int getTeacherId() {
        return this.teacherId;
    }

    public final int getTeacherType() {
        return this.teacherType;
    }

    public final String getTutorDuty() {
        return this.tutorDuty;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShopClassDetailTeacher(int r13, java.lang.String r14, java.util.List r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20, int r21, java.lang.String r22, java.lang.Integer r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r13
        L_0x000a:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L_0x0011
            r3 = r4
            goto L_0x0012
        L_0x0011:
            r3 = r14
        L_0x0012:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0018
            r5 = r4
            goto L_0x0019
        L_0x0018:
            r5 = r15
        L_0x0019:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x001f
            r6 = r4
            goto L_0x0021
        L_0x001f:
            r6 = r16
        L_0x0021:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0027
            r7 = r4
            goto L_0x0029
        L_0x0027:
            r7 = r17
        L_0x0029:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x002f
            r8 = r4
            goto L_0x0031
        L_0x002f:
            r8 = r18
        L_0x0031:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0037
            r9 = r4
            goto L_0x0039
        L_0x0037:
            r9 = r19
        L_0x0039:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x003f
            r10 = r2
            goto L_0x0041
        L_0x003f:
            r10 = r20
        L_0x0041:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r2 = r21
        L_0x0048:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            r4 = r22
        L_0x004f:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x005e
            com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType r0 = com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType.Normal
            int r0 = r0.getType()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0060
        L_0x005e:
            r0 = r23
        L_0x0060:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r2
            r23 = r4
            r24 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailTeacher.<init>(int, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer getLocal_position_type() {
        return this.local_position_type;
    }

    public final void setLocal_position_type(Integer num) {
        this.local_position_type = num;
    }

    public int getItemType() {
        return ShopClassDetailItemType.TeacherCard.getType();
    }
}
