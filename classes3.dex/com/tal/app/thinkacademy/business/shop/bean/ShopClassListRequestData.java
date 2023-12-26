package com.tal.app.thinkacademy.business.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b'\b\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0002\u0010\u000fJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003Ja\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0001J\u0013\u00101\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0003HÖ\u0001J\t\u00104\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\n\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017¨\u00065"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassListRequestData;", "", "pageSize", "", "pageNum", "courseId", "onlyNotFull", "", "timeRange", "", "dayOfWeek", "teacherId", "sorted", "", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassRequestSortData;", "(IIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCourseId", "()I", "setCourseId", "(I)V", "getDayOfWeek", "()Ljava/lang/String;", "setDayOfWeek", "(Ljava/lang/String;)V", "getOnlyNotFull", "()Z", "setOnlyNotFull", "(Z)V", "getPageNum", "setPageNum", "getPageSize", "setPageSize", "getSorted", "()Ljava/util/List;", "setSorted", "(Ljava/util/List;)V", "getTeacherId", "setTeacherId", "getTimeRange", "setTimeRange", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassListRequestData.kt */
public final class ShopClassListRequestData {
    private int courseId;
    private String dayOfWeek;
    private boolean onlyNotFull;
    private int pageNum;
    private int pageSize;
    private List<ShopClassRequestSortData> sorted;
    private String teacherId;
    private String timeRange;

    public static /* synthetic */ ShopClassListRequestData copy$default(ShopClassListRequestData shopClassListRequestData, int i, int i2, int i3, boolean z, String str, String str2, String str3, List list, int i4, Object obj) {
        ShopClassListRequestData shopClassListRequestData2 = shopClassListRequestData;
        int i5 = i4;
        return shopClassListRequestData.copy((i5 & 1) != 0 ? shopClassListRequestData2.pageSize : i, (i5 & 2) != 0 ? shopClassListRequestData2.pageNum : i2, (i5 & 4) != 0 ? shopClassListRequestData2.courseId : i3, (i5 & 8) != 0 ? shopClassListRequestData2.onlyNotFull : z, (i5 & 16) != 0 ? shopClassListRequestData2.timeRange : str, (i5 & 32) != 0 ? shopClassListRequestData2.dayOfWeek : str2, (i5 & 64) != 0 ? shopClassListRequestData2.teacherId : str3, (i5 & 128) != 0 ? shopClassListRequestData2.sorted : list);
    }

    public final int component1() {
        return this.pageSize;
    }

    public final int component2() {
        return this.pageNum;
    }

    public final int component3() {
        return this.courseId;
    }

    public final boolean component4() {
        return this.onlyNotFull;
    }

    public final String component5() {
        return this.timeRange;
    }

    public final String component6() {
        return this.dayOfWeek;
    }

    public final String component7() {
        return this.teacherId;
    }

    public final List<ShopClassRequestSortData> component8() {
        return this.sorted;
    }

    public final ShopClassListRequestData copy(int i, int i2, int i3, boolean z, String str, String str2, String str3, List<ShopClassRequestSortData> list) {
        Intrinsics.checkNotNullParameter(str, "timeRange");
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str4, "dayOfWeek");
        String str5 = str3;
        Intrinsics.checkNotNullParameter(str5, "teacherId");
        return new ShopClassListRequestData(i, i2, i3, z, str, str4, str5, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopClassListRequestData)) {
            return false;
        }
        ShopClassListRequestData shopClassListRequestData = (ShopClassListRequestData) obj;
        return this.pageSize == shopClassListRequestData.pageSize && this.pageNum == shopClassListRequestData.pageNum && this.courseId == shopClassListRequestData.courseId && this.onlyNotFull == shopClassListRequestData.onlyNotFull && Intrinsics.areEqual((Object) this.timeRange, (Object) shopClassListRequestData.timeRange) && Intrinsics.areEqual((Object) this.dayOfWeek, (Object) shopClassListRequestData.dayOfWeek) && Intrinsics.areEqual((Object) this.teacherId, (Object) shopClassListRequestData.teacherId) && Intrinsics.areEqual((Object) this.sorted, (Object) shopClassListRequestData.sorted);
    }

    public int hashCode() {
        int i = ((((this.pageSize * 31) + this.pageNum) * 31) + this.courseId) * 31;
        boolean z = this.onlyNotFull;
        if (z) {
            z = true;
        }
        int hashCode = (((((((i + (z ? 1 : 0)) * 31) + this.timeRange.hashCode()) * 31) + this.dayOfWeek.hashCode()) * 31) + this.teacherId.hashCode()) * 31;
        List<ShopClassRequestSortData> list = this.sorted;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "ShopClassListRequestData(pageSize=" + this.pageSize + ", pageNum=" + this.pageNum + ", courseId=" + this.courseId + ", onlyNotFull=" + this.onlyNotFull + ", timeRange=" + this.timeRange + ", dayOfWeek=" + this.dayOfWeek + ", teacherId=" + this.teacherId + ", sorted=" + this.sorted + ')';
    }

    public ShopClassListRequestData(int i, int i2, int i3, boolean z, String str, String str2, String str3, List<ShopClassRequestSortData> list) {
        Intrinsics.checkNotNullParameter(str, "timeRange");
        Intrinsics.checkNotNullParameter(str2, "dayOfWeek");
        Intrinsics.checkNotNullParameter(str3, "teacherId");
        this.pageSize = i;
        this.pageNum = i2;
        this.courseId = i3;
        this.onlyNotFull = z;
        this.timeRange = str;
        this.dayOfWeek = str2;
        this.teacherId = str3;
        this.sorted = list;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final void setPageSize(int i) {
        this.pageSize = i;
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final void setPageNum(int i) {
        this.pageNum = i;
    }

    public final int getCourseId() {
        return this.courseId;
    }

    public final void setCourseId(int i) {
        this.courseId = i;
    }

    public final boolean getOnlyNotFull() {
        return this.onlyNotFull;
    }

    public final void setOnlyNotFull(boolean z) {
        this.onlyNotFull = z;
    }

    public final String getTimeRange() {
        return this.timeRange;
    }

    public final void setTimeRange(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timeRange = str;
    }

    public final String getDayOfWeek() {
        return this.dayOfWeek;
    }

    public final void setDayOfWeek(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dayOfWeek = str;
    }

    public final String getTeacherId() {
        return this.teacherId;
    }

    public final void setTeacherId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.teacherId = str;
    }

    public final List<ShopClassRequestSortData> getSorted() {
        return this.sorted;
    }

    public final void setSorted(List<ShopClassRequestSortData> list) {
        this.sorted = list;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShopClassListRequestData(int r13, int r14, int r15, boolean r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.util.List r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r7 = r2
            goto L_0x000b
        L_0x0009:
            r7 = r16
        L_0x000b:
            r1 = r0 & 16
            java.lang.String r3 = ""
            if (r1 == 0) goto L_0x0013
            r8 = r3
            goto L_0x0015
        L_0x0013:
            r8 = r17
        L_0x0015:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x001b
            r9 = r3
            goto L_0x001d
        L_0x001b:
            r9 = r18
        L_0x001d:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0023
            r10 = r3
            goto L_0x0025
        L_0x0023:
            r10 = r19
        L_0x0025:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003d
            r0 = 1
            com.tal.app.thinkacademy.business.shop.bean.ShopClassRequestSortData[] r0 = new com.tal.app.thinkacademy.business.shop.bean.ShopClassRequestSortData[r0]
            com.tal.app.thinkacademy.business.shop.bean.ShopClassRequestSortData r1 = new com.tal.app.thinkacademy.business.shop.bean.ShopClassRequestSortData
            java.lang.String r3 = "startData"
            r1.<init>(r3, r2)
            r0[r2] = r1
            java.util.ArrayList r0 = kotlin.collections.CollectionsKt.arrayListOf(r0)
            java.util.List r0 = (java.util.List) r0
            r11 = r0
            goto L_0x003f
        L_0x003d:
            r11 = r20
        L_0x003f:
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.ShopClassListRequestData.<init>(int, int, int, boolean, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
