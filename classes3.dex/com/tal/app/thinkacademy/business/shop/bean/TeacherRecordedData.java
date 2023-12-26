package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/TeacherRecordedData;", "", "id", "", "showOrgPrice", "", "showPrice", "categoryType", "spec", "Lcom/tal/app/thinkacademy/business/shop/bean/TeacherRecordedSpec;", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tal/app/thinkacademy/business/shop/bean/TeacherRecordedSpec;)V", "getCategoryType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getShowOrgPrice", "getShowPrice", "getSpec", "()Lcom/tal/app/thinkacademy/business/shop/bean/TeacherRecordedSpec;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tal/app/thinkacademy/business/shop/bean/TeacherRecordedSpec;)Lcom/tal/app/thinkacademy/business/shop/bean/TeacherRecordedData;", "equals", "", "other", "hashCode", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherRecordedData.kt */
public final class TeacherRecordedData {
    private final Integer categoryType;
    private final Long id;
    private final Integer showOrgPrice;
    private final Integer showPrice;
    private final TeacherRecordedSpec spec;

    public TeacherRecordedData() {
        this((Long) null, (Integer) null, (Integer) null, (Integer) null, (TeacherRecordedSpec) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TeacherRecordedData copy$default(TeacherRecordedData teacherRecordedData, Long l, Integer num, Integer num2, Integer num3, TeacherRecordedSpec teacherRecordedSpec, int i, Object obj) {
        if ((i & 1) != 0) {
            l = teacherRecordedData.id;
        }
        if ((i & 2) != 0) {
            num = teacherRecordedData.showOrgPrice;
        }
        Integer num4 = num;
        if ((i & 4) != 0) {
            num2 = teacherRecordedData.showPrice;
        }
        Integer num5 = num2;
        if ((i & 8) != 0) {
            num3 = teacherRecordedData.categoryType;
        }
        Integer num6 = num3;
        if ((i & 16) != 0) {
            teacherRecordedSpec = teacherRecordedData.spec;
        }
        return teacherRecordedData.copy(l, num4, num5, num6, teacherRecordedSpec);
    }

    public final Long component1() {
        return this.id;
    }

    public final Integer component2() {
        return this.showOrgPrice;
    }

    public final Integer component3() {
        return this.showPrice;
    }

    public final Integer component4() {
        return this.categoryType;
    }

    public final TeacherRecordedSpec component5() {
        return this.spec;
    }

    public final TeacherRecordedData copy(Long l, Integer num, Integer num2, Integer num3, TeacherRecordedSpec teacherRecordedSpec) {
        return new TeacherRecordedData(l, num, num2, num3, teacherRecordedSpec);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TeacherRecordedData)) {
            return false;
        }
        TeacherRecordedData teacherRecordedData = (TeacherRecordedData) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) teacherRecordedData.id) && Intrinsics.areEqual((Object) this.showOrgPrice, (Object) teacherRecordedData.showOrgPrice) && Intrinsics.areEqual((Object) this.showPrice, (Object) teacherRecordedData.showPrice) && Intrinsics.areEqual((Object) this.categoryType, (Object) teacherRecordedData.categoryType) && Intrinsics.areEqual((Object) this.spec, (Object) teacherRecordedData.spec);
    }

    public int hashCode() {
        Long l = this.id;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Integer num = this.showOrgPrice;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.showPrice;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.categoryType;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        TeacherRecordedSpec teacherRecordedSpec = this.spec;
        if (teacherRecordedSpec != null) {
            i = teacherRecordedSpec.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "TeacherRecordedData(id=" + this.id + ", showOrgPrice=" + this.showOrgPrice + ", showPrice=" + this.showPrice + ", categoryType=" + this.categoryType + ", spec=" + this.spec + ')';
    }

    public TeacherRecordedData(Long l, Integer num, Integer num2, Integer num3, TeacherRecordedSpec teacherRecordedSpec) {
        this.id = l;
        this.showOrgPrice = num;
        this.showPrice = num2;
        this.categoryType = num3;
        this.spec = teacherRecordedSpec;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TeacherRecordedData(java.lang.Long r4, java.lang.Integer r5, java.lang.Integer r6, java.lang.Integer r7, com.tal.app.thinkacademy.business.shop.bean.TeacherRecordedSpec r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x000a
            r0 = 0
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
        L_0x000a:
            r10 = r9 & 2
            r0 = 0
            if (r10 == 0) goto L_0x0013
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
        L_0x0013:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x001c
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
        L_0x001c:
            r0 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x0026
            r5 = 1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
        L_0x0026:
            r1 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L_0x002c
            r8 = 0
        L_0x002c:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.TeacherRecordedData.<init>(java.lang.Long, java.lang.Integer, java.lang.Integer, java.lang.Integer, com.tal.app.thinkacademy.business.shop.bean.TeacherRecordedSpec, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Long getId() {
        return this.id;
    }

    public final Integer getShowOrgPrice() {
        return this.showOrgPrice;
    }

    public final Integer getShowPrice() {
        return this.showPrice;
    }

    public final Integer getCategoryType() {
        return this.categoryType;
    }

    public final TeacherRecordedSpec getSpec() {
        return this.spec;
    }
}
