package com.tal.app.thinkacademy.business.study.study.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010(\u001a\u00020\fHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\fHÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\fHÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0011\u0010\u000f\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001b¨\u00060"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/Courseware;", "", "baseZipMd5", "", "baseZipSize", "baseZipUrl", "baseZipUrlSpareList", "", "catalog", "compressIndexUrl", "compressIndexUrlSpareList", "compressState", "", "id", "modifyTime", "rate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;I)V", "getBaseZipMd5", "()Ljava/lang/String;", "getBaseZipSize", "getBaseZipUrl", "getBaseZipUrlSpareList", "()Ljava/util/List;", "getCatalog", "getCompressIndexUrl", "getCompressIndexUrlSpareList", "getCompressState", "()I", "getId", "getModifyTime", "getRate", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReadyClassBean.kt */
public final class Courseware {
    private final String baseZipMd5;
    private final String baseZipSize;
    private final String baseZipUrl;
    private final List<String> baseZipUrlSpareList;
    private final String catalog;
    private final String compressIndexUrl;
    private final List<String> compressIndexUrlSpareList;
    private final int compressState;
    private final String id;
    private final String modifyTime;
    private final int rate;

    public static /* synthetic */ Courseware copy$default(Courseware courseware, String str, String str2, String str3, List list, String str4, String str5, List list2, int i, String str6, String str7, int i2, int i3, Object obj) {
        Courseware courseware2 = courseware;
        int i4 = i3;
        return courseware.copy((i4 & 1) != 0 ? courseware2.baseZipMd5 : str, (i4 & 2) != 0 ? courseware2.baseZipSize : str2, (i4 & 4) != 0 ? courseware2.baseZipUrl : str3, (i4 & 8) != 0 ? courseware2.baseZipUrlSpareList : list, (i4 & 16) != 0 ? courseware2.catalog : str4, (i4 & 32) != 0 ? courseware2.compressIndexUrl : str5, (i4 & 64) != 0 ? courseware2.compressIndexUrlSpareList : list2, (i4 & 128) != 0 ? courseware2.compressState : i, (i4 & 256) != 0 ? courseware2.id : str6, (i4 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? courseware2.modifyTime : str7, (i4 & 1024) != 0 ? courseware2.rate : i2);
    }

    public final String component1() {
        return this.baseZipMd5;
    }

    public final String component10() {
        return this.modifyTime;
    }

    public final int component11() {
        return this.rate;
    }

    public final String component2() {
        return this.baseZipSize;
    }

    public final String component3() {
        return this.baseZipUrl;
    }

    public final List<String> component4() {
        return this.baseZipUrlSpareList;
    }

    public final String component5() {
        return this.catalog;
    }

    public final String component6() {
        return this.compressIndexUrl;
    }

    public final List<String> component7() {
        return this.compressIndexUrlSpareList;
    }

    public final int component8() {
        return this.compressState;
    }

    public final String component9() {
        return this.id;
    }

    public final Courseware copy(String str, String str2, String str3, List<String> list, String str4, String str5, List<String> list2, int i, String str6, String str7, int i2) {
        Intrinsics.checkNotNullParameter(str, "baseZipMd5");
        List<String> list3 = list;
        Intrinsics.checkNotNullParameter(list3, "baseZipUrlSpareList");
        String str8 = str4;
        Intrinsics.checkNotNullParameter(str8, "catalog");
        String str9 = str5;
        Intrinsics.checkNotNullParameter(str9, "compressIndexUrl");
        List<String> list4 = list2;
        Intrinsics.checkNotNullParameter(list4, "compressIndexUrlSpareList");
        String str10 = str6;
        Intrinsics.checkNotNullParameter(str10, "id");
        String str11 = str7;
        Intrinsics.checkNotNullParameter(str11, "modifyTime");
        return new Courseware(str, str2, str3, list3, str8, str9, list4, i, str10, str11, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Courseware)) {
            return false;
        }
        Courseware courseware = (Courseware) obj;
        return Intrinsics.areEqual((Object) this.baseZipMd5, (Object) courseware.baseZipMd5) && Intrinsics.areEqual((Object) this.baseZipSize, (Object) courseware.baseZipSize) && Intrinsics.areEqual((Object) this.baseZipUrl, (Object) courseware.baseZipUrl) && Intrinsics.areEqual((Object) this.baseZipUrlSpareList, (Object) courseware.baseZipUrlSpareList) && Intrinsics.areEqual((Object) this.catalog, (Object) courseware.catalog) && Intrinsics.areEqual((Object) this.compressIndexUrl, (Object) courseware.compressIndexUrl) && Intrinsics.areEqual((Object) this.compressIndexUrlSpareList, (Object) courseware.compressIndexUrlSpareList) && this.compressState == courseware.compressState && Intrinsics.areEqual((Object) this.id, (Object) courseware.id) && Intrinsics.areEqual((Object) this.modifyTime, (Object) courseware.modifyTime) && this.rate == courseware.rate;
    }

    public int hashCode() {
        int hashCode = this.baseZipMd5.hashCode() * 31;
        String str = this.baseZipSize;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.baseZipUrl;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((((((((((((((hashCode2 + i) * 31) + this.baseZipUrlSpareList.hashCode()) * 31) + this.catalog.hashCode()) * 31) + this.compressIndexUrl.hashCode()) * 31) + this.compressIndexUrlSpareList.hashCode()) * 31) + this.compressState) * 31) + this.id.hashCode()) * 31) + this.modifyTime.hashCode()) * 31) + this.rate;
    }

    public String toString() {
        return "Courseware(baseZipMd5=" + this.baseZipMd5 + ", baseZipSize=" + this.baseZipSize + ", baseZipUrl=" + this.baseZipUrl + ", baseZipUrlSpareList=" + this.baseZipUrlSpareList + ", catalog=" + this.catalog + ", compressIndexUrl=" + this.compressIndexUrl + ", compressIndexUrlSpareList=" + this.compressIndexUrlSpareList + ", compressState=" + this.compressState + ", id=" + this.id + ", modifyTime=" + this.modifyTime + ", rate=" + this.rate + ')';
    }

    public Courseware(String str, String str2, String str3, List<String> list, String str4, String str5, List<String> list2, int i, String str6, String str7, int i2) {
        Intrinsics.checkNotNullParameter(str, "baseZipMd5");
        Intrinsics.checkNotNullParameter(list, "baseZipUrlSpareList");
        Intrinsics.checkNotNullParameter(str4, "catalog");
        Intrinsics.checkNotNullParameter(str5, "compressIndexUrl");
        Intrinsics.checkNotNullParameter(list2, "compressIndexUrlSpareList");
        Intrinsics.checkNotNullParameter(str6, "id");
        Intrinsics.checkNotNullParameter(str7, "modifyTime");
        this.baseZipMd5 = str;
        this.baseZipSize = str2;
        this.baseZipUrl = str3;
        this.baseZipUrlSpareList = list;
        this.catalog = str4;
        this.compressIndexUrl = str5;
        this.compressIndexUrlSpareList = list2;
        this.compressState = i;
        this.id = str6;
        this.modifyTime = str7;
        this.rate = i2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Courseware(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.util.List r18, java.lang.String r19, java.lang.String r20, java.util.List r21, int r22, java.lang.String r23, java.lang.String r24, int r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r14 = this;
            r0 = r26
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000a
            java.lang.String r1 = "0"
            r4 = r1
            goto L_0x000c
        L_0x000a:
            r4 = r16
        L_0x000c:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0013
            r0 = 1
            r13 = r0
            goto L_0x0015
        L_0x0013:
            r13 = r25
        L_0x0015:
            r2 = r14
            r3 = r15
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            r11 = r23
            r12 = r24
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.entity.Courseware.<init>(java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.util.List, int, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getBaseZipMd5() {
        return this.baseZipMd5;
    }

    public final String getBaseZipSize() {
        return this.baseZipSize;
    }

    public final String getBaseZipUrl() {
        return this.baseZipUrl;
    }

    public final List<String> getBaseZipUrlSpareList() {
        return this.baseZipUrlSpareList;
    }

    public final String getCatalog() {
        return this.catalog;
    }

    public final String getCompressIndexUrl() {
        return this.compressIndexUrl;
    }

    public final List<String> getCompressIndexUrlSpareList() {
        return this.compressIndexUrlSpareList;
    }

    public final int getCompressState() {
        return this.compressState;
    }

    public final String getId() {
        return this.id;
    }

    public final String getModifyTime() {
        return this.modifyTime;
    }

    public final int getRate() {
        return this.rate;
    }
}
