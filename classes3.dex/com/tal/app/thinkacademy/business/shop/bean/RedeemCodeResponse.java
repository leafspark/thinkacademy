package com.tal.app.thinkacademy.business.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b*\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0012J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0001\u0010/\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u00100\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\bHÖ\u0001J\t\u00103\u001a\u00020\nHÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010 R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001d¨\u00064"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/RedeemCodeResponse;", "", "gradeList", "", "Lcom/tal/app/thinkacademy/business/shop/bean/RedeemCodeResponseGrade;", "isRedeem", "", "levelDegreeId", "", "levelDegreeName", "", "levelDegreeOrder", "levelDegreeStar", "levelList", "subjectId", "subjectName", "year", "localRedeemCode", "(Ljava/util/List;ZILjava/lang/String;IILjava/lang/Object;ILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "getGradeList", "()Ljava/util/List;", "()Z", "getLevelDegreeId", "()I", "getLevelDegreeName", "()Ljava/lang/String;", "getLevelDegreeOrder", "getLevelDegreeStar", "getLevelList", "()Ljava/lang/Object;", "getLocalRedeemCode", "setLocalRedeemCode", "(Ljava/lang/String;)V", "getSubjectId", "getSubjectName", "getYear", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedeemCodeResponse.kt */
public final class RedeemCodeResponse {
    private final List<RedeemCodeResponseGrade> gradeList;
    private final boolean isRedeem;
    private final int levelDegreeId;
    private final String levelDegreeName;
    private final int levelDegreeOrder;
    private final int levelDegreeStar;
    private final Object levelList;
    private String localRedeemCode;
    private final int subjectId;
    private final String subjectName;
    private final Object year;

    public RedeemCodeResponse() {
        this((List) null, false, 0, (String) null, 0, 0, (Object) null, 0, (String) null, (Object) null, (String) null, 2047, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RedeemCodeResponse copy$default(RedeemCodeResponse redeemCodeResponse, List list, boolean z, int i, String str, int i2, int i3, Object obj, int i4, String str2, Object obj2, String str3, int i5, Object obj3) {
        RedeemCodeResponse redeemCodeResponse2 = redeemCodeResponse;
        int i6 = i5;
        return redeemCodeResponse.copy((i6 & 1) != 0 ? redeemCodeResponse2.gradeList : list, (i6 & 2) != 0 ? redeemCodeResponse2.isRedeem : z, (i6 & 4) != 0 ? redeemCodeResponse2.levelDegreeId : i, (i6 & 8) != 0 ? redeemCodeResponse2.levelDegreeName : str, (i6 & 16) != 0 ? redeemCodeResponse2.levelDegreeOrder : i2, (i6 & 32) != 0 ? redeemCodeResponse2.levelDegreeStar : i3, (i6 & 64) != 0 ? redeemCodeResponse2.levelList : obj, (i6 & 128) != 0 ? redeemCodeResponse2.subjectId : i4, (i6 & 256) != 0 ? redeemCodeResponse2.subjectName : str2, (i6 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? redeemCodeResponse2.year : obj2, (i6 & 1024) != 0 ? redeemCodeResponse2.localRedeemCode : str3);
    }

    public final List<RedeemCodeResponseGrade> component1() {
        return this.gradeList;
    }

    public final Object component10() {
        return this.year;
    }

    public final String component11() {
        return this.localRedeemCode;
    }

    public final boolean component2() {
        return this.isRedeem;
    }

    public final int component3() {
        return this.levelDegreeId;
    }

    public final String component4() {
        return this.levelDegreeName;
    }

    public final int component5() {
        return this.levelDegreeOrder;
    }

    public final int component6() {
        return this.levelDegreeStar;
    }

    public final Object component7() {
        return this.levelList;
    }

    public final int component8() {
        return this.subjectId;
    }

    public final String component9() {
        return this.subjectName;
    }

    public final RedeemCodeResponse copy(List<RedeemCodeResponseGrade> list, boolean z, int i, String str, int i2, int i3, Object obj, int i4, String str2, Object obj2, String str3) {
        return new RedeemCodeResponse(list, z, i, str, i2, i3, obj, i4, str2, obj2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedeemCodeResponse)) {
            return false;
        }
        RedeemCodeResponse redeemCodeResponse = (RedeemCodeResponse) obj;
        return Intrinsics.areEqual((Object) this.gradeList, (Object) redeemCodeResponse.gradeList) && this.isRedeem == redeemCodeResponse.isRedeem && this.levelDegreeId == redeemCodeResponse.levelDegreeId && Intrinsics.areEqual((Object) this.levelDegreeName, (Object) redeemCodeResponse.levelDegreeName) && this.levelDegreeOrder == redeemCodeResponse.levelDegreeOrder && this.levelDegreeStar == redeemCodeResponse.levelDegreeStar && Intrinsics.areEqual(this.levelList, redeemCodeResponse.levelList) && this.subjectId == redeemCodeResponse.subjectId && Intrinsics.areEqual((Object) this.subjectName, (Object) redeemCodeResponse.subjectName) && Intrinsics.areEqual(this.year, redeemCodeResponse.year) && Intrinsics.areEqual((Object) this.localRedeemCode, (Object) redeemCodeResponse.localRedeemCode);
    }

    public int hashCode() {
        List<RedeemCodeResponseGrade> list = this.gradeList;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        boolean z = this.isRedeem;
        if (z) {
            z = true;
        }
        int i2 = (((hashCode + (z ? 1 : 0)) * 31) + this.levelDegreeId) * 31;
        String str = this.levelDegreeName;
        int hashCode2 = (((((i2 + (str == null ? 0 : str.hashCode())) * 31) + this.levelDegreeOrder) * 31) + this.levelDegreeStar) * 31;
        Object obj = this.levelList;
        int hashCode3 = (((hashCode2 + (obj == null ? 0 : obj.hashCode())) * 31) + this.subjectId) * 31;
        String str2 = this.subjectName;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Object obj2 = this.year;
        int hashCode5 = (hashCode4 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        String str3 = this.localRedeemCode;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "RedeemCodeResponse(gradeList=" + this.gradeList + ", isRedeem=" + this.isRedeem + ", levelDegreeId=" + this.levelDegreeId + ", levelDegreeName=" + this.levelDegreeName + ", levelDegreeOrder=" + this.levelDegreeOrder + ", levelDegreeStar=" + this.levelDegreeStar + ", levelList=" + this.levelList + ", subjectId=" + this.subjectId + ", subjectName=" + this.subjectName + ", year=" + this.year + ", localRedeemCode=" + this.localRedeemCode + ')';
    }

    public RedeemCodeResponse(List<RedeemCodeResponseGrade> list, boolean z, int i, String str, int i2, int i3, Object obj, int i4, String str2, Object obj2, String str3) {
        this.gradeList = list;
        this.isRedeem = z;
        this.levelDegreeId = i;
        this.levelDegreeName = str;
        this.levelDegreeOrder = i2;
        this.levelDegreeStar = i3;
        this.levelList = obj;
        this.subjectId = i4;
        this.subjectName = str2;
        this.year = obj2;
        this.localRedeemCode = str3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RedeemCodeResponse(java.util.List r13, boolean r14, int r15, java.lang.String r16, int r17, int r18, java.lang.Object r19, int r20, java.lang.String r21, java.lang.Object r22, java.lang.String r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
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
            r6 = r2
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
            r9 = r2
            goto L_0x0039
        L_0x0037:
            r9 = r19
        L_0x0039:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r4 = r20
        L_0x0040:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0046
            r10 = r2
            goto L_0x0048
        L_0x0046:
            r10 = r21
        L_0x0048:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            r2 = r22
        L_0x004f:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0056
            java.lang.String r0 = ""
            goto L_0x0058
        L_0x0056:
            r0 = r23
        L_0x0058:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r4
            r22 = r10
            r23 = r2
            r24 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.RedeemCodeResponse.<init>(java.util.List, boolean, int, java.lang.String, int, int, java.lang.Object, int, java.lang.String, java.lang.Object, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<RedeemCodeResponseGrade> getGradeList() {
        return this.gradeList;
    }

    public final boolean isRedeem() {
        return this.isRedeem;
    }

    public final int getLevelDegreeId() {
        return this.levelDegreeId;
    }

    public final String getLevelDegreeName() {
        return this.levelDegreeName;
    }

    public final int getLevelDegreeOrder() {
        return this.levelDegreeOrder;
    }

    public final int getLevelDegreeStar() {
        return this.levelDegreeStar;
    }

    public final Object getLevelList() {
        return this.levelList;
    }

    public final int getSubjectId() {
        return this.subjectId;
    }

    public final String getSubjectName() {
        return this.subjectName;
    }

    public final Object getYear() {
        return this.year;
    }

    public final String getLocalRedeemCode() {
        return this.localRedeemCode;
    }

    public final void setLocalRedeemCode(String str) {
        this.localRedeemCode = str;
    }
}
