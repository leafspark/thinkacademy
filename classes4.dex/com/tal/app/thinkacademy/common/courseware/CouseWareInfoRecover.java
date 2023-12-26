package com.tal.app.thinkacademy.common.courseware;

import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bo\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0016\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0016\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b\u000b\u0010$\"\u0004\b%\u0010&¨\u00069"}, d2 = {"Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfoRecover;", "Ljava/io/Serializable;", "id", "", "catalog", "compressIndexUrl", "compressIndexUrlSpareList", "", "baseZipUrl", "baseZipUrlSpareList", "baseZipMd5", "isBindCourseware", "", "baseZipSize", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getBaseZipMd5", "()Ljava/lang/String;", "setBaseZipMd5", "(Ljava/lang/String;)V", "getBaseZipSize", "setBaseZipSize", "getBaseZipUrl", "setBaseZipUrl", "getBaseZipUrlSpareList", "()[Ljava/lang/String;", "setBaseZipUrlSpareList", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getCatalog", "setCatalog", "getCompressIndexUrl", "setCompressIndexUrl", "getCompressIndexUrlSpareList", "setCompressIndexUrlSpareList", "getId", "setId", "()Ljava/lang/Boolean;", "setBindCourseware", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/tal/app/thinkacademy/common/courseware/CouseWareInfoRecover;", "equals", "other", "", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CouseWareInfoRecover.kt */
public final class CouseWareInfoRecover implements Serializable {
    private String baseZipMd5;
    private String baseZipSize;
    private String baseZipUrl;
    private String[] baseZipUrlSpareList;
    private String catalog;
    private String compressIndexUrl;
    private String[] compressIndexUrlSpareList;
    private String id;
    private Boolean isBindCourseware;

    public static /* synthetic */ CouseWareInfoRecover copy$default(CouseWareInfoRecover couseWareInfoRecover, String str, String str2, String str3, String[] strArr, String str4, String[] strArr2, String str5, Boolean bool, String str6, int i, Object obj) {
        CouseWareInfoRecover couseWareInfoRecover2 = couseWareInfoRecover;
        int i2 = i;
        return couseWareInfoRecover.copy((i2 & 1) != 0 ? couseWareInfoRecover2.id : str, (i2 & 2) != 0 ? couseWareInfoRecover2.catalog : str2, (i2 & 4) != 0 ? couseWareInfoRecover2.compressIndexUrl : str3, (i2 & 8) != 0 ? couseWareInfoRecover2.compressIndexUrlSpareList : strArr, (i2 & 16) != 0 ? couseWareInfoRecover2.baseZipUrl : str4, (i2 & 32) != 0 ? couseWareInfoRecover2.baseZipUrlSpareList : strArr2, (i2 & 64) != 0 ? couseWareInfoRecover2.baseZipMd5 : str5, (i2 & LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP) != 0 ? couseWareInfoRecover2.isBindCourseware : bool, (i2 & 256) != 0 ? couseWareInfoRecover2.baseZipSize : str6);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.catalog;
    }

    public final String component3() {
        return this.compressIndexUrl;
    }

    public final String[] component4() {
        return this.compressIndexUrlSpareList;
    }

    public final String component5() {
        return this.baseZipUrl;
    }

    public final String[] component6() {
        return this.baseZipUrlSpareList;
    }

    public final String component7() {
        return this.baseZipMd5;
    }

    public final Boolean component8() {
        return this.isBindCourseware;
    }

    public final String component9() {
        return this.baseZipSize;
    }

    public final CouseWareInfoRecover copy(String str, String str2, String str3, String[] strArr, String str4, String[] strArr2, String str5, Boolean bool, String str6) {
        return new CouseWareInfoRecover(str, str2, str3, strArr, str4, strArr2, str5, bool, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CouseWareInfoRecover)) {
            return false;
        }
        CouseWareInfoRecover couseWareInfoRecover = (CouseWareInfoRecover) obj;
        return Intrinsics.areEqual(this.id, couseWareInfoRecover.id) && Intrinsics.areEqual(this.catalog, couseWareInfoRecover.catalog) && Intrinsics.areEqual(this.compressIndexUrl, couseWareInfoRecover.compressIndexUrl) && Intrinsics.areEqual(this.compressIndexUrlSpareList, couseWareInfoRecover.compressIndexUrlSpareList) && Intrinsics.areEqual(this.baseZipUrl, couseWareInfoRecover.baseZipUrl) && Intrinsics.areEqual(this.baseZipUrlSpareList, couseWareInfoRecover.baseZipUrlSpareList) && Intrinsics.areEqual(this.baseZipMd5, couseWareInfoRecover.baseZipMd5) && Intrinsics.areEqual(this.isBindCourseware, couseWareInfoRecover.isBindCourseware) && Intrinsics.areEqual(this.baseZipSize, couseWareInfoRecover.baseZipSize);
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.catalog;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.compressIndexUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String[] strArr = this.compressIndexUrlSpareList;
        int hashCode4 = (hashCode3 + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        String str4 = this.baseZipUrl;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String[] strArr2 = this.baseZipUrlSpareList;
        int hashCode6 = (hashCode5 + (strArr2 == null ? 0 : Arrays.hashCode(strArr2))) * 31;
        String str5 = this.baseZipMd5;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.isBindCourseware;
        int hashCode8 = (hashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str6 = this.baseZipSize;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode8 + i;
    }

    public String toString() {
        return "CouseWareInfoRecover(id=" + this.id + ", catalog=" + this.catalog + ", compressIndexUrl=" + this.compressIndexUrl + ", compressIndexUrlSpareList=" + Arrays.toString(this.compressIndexUrlSpareList) + ", baseZipUrl=" + this.baseZipUrl + ", baseZipUrlSpareList=" + Arrays.toString(this.baseZipUrlSpareList) + ", baseZipMd5=" + this.baseZipMd5 + ", isBindCourseware=" + this.isBindCourseware + ", baseZipSize=" + this.baseZipSize + ')';
    }

    public CouseWareInfoRecover(String str, String str2, String str3, String[] strArr, String str4, String[] strArr2, String str5, Boolean bool, String str6) {
        this.id = str;
        this.catalog = str2;
        this.compressIndexUrl = str3;
        this.compressIndexUrlSpareList = strArr;
        this.baseZipUrl = str4;
        this.baseZipUrlSpareList = strArr2;
        this.baseZipMd5 = str5;
        this.isBindCourseware = bool;
        this.baseZipSize = str6;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getCatalog() {
        return this.catalog;
    }

    public final void setCatalog(String str) {
        this.catalog = str;
    }

    public final String getCompressIndexUrl() {
        return this.compressIndexUrl;
    }

    public final void setCompressIndexUrl(String str) {
        this.compressIndexUrl = str;
    }

    public final String[] getCompressIndexUrlSpareList() {
        return this.compressIndexUrlSpareList;
    }

    public final void setCompressIndexUrlSpareList(String[] strArr) {
        this.compressIndexUrlSpareList = strArr;
    }

    public final String getBaseZipUrl() {
        return this.baseZipUrl;
    }

    public final void setBaseZipUrl(String str) {
        this.baseZipUrl = str;
    }

    public final String[] getBaseZipUrlSpareList() {
        return this.baseZipUrlSpareList;
    }

    public final void setBaseZipUrlSpareList(String[] strArr) {
        this.baseZipUrlSpareList = strArr;
    }

    public final String getBaseZipMd5() {
        return this.baseZipMd5;
    }

    public final void setBaseZipMd5(String str) {
        this.baseZipMd5 = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CouseWareInfoRecover(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String[] r16, java.lang.String r17, java.lang.String[] r18, java.lang.String r19, java.lang.Boolean r20, java.lang.String r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r12 = this;
            r0 = r22
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x000d
            r1 = 0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r10 = r1
            goto L_0x000f
        L_0x000d:
            r10 = r20
        L_0x000f:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0017
            java.lang.String r0 = ""
            r11 = r0
            goto L_0x0019
        L_0x0017:
            r11 = r21
        L_0x0019:
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.courseware.CouseWareInfoRecover.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String, java.lang.Boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Boolean isBindCourseware() {
        return this.isBindCourseware;
    }

    public final void setBindCourseware(Boolean bool) {
        this.isBindCourseware = bool;
    }

    public final String getBaseZipSize() {
        return this.baseZipSize;
    }

    public final void setBaseZipSize(String str) {
        this.baseZipSize = str;
    }
}
