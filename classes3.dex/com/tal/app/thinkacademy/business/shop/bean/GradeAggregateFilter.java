package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateFilter;", "", "id", "", "shortName", "", "(ILjava/lang/String;)V", "getId", "()I", "getShortName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateDetailInfo.kt */
public final class GradeAggregateFilter {
    private final int id;
    private final String shortName;

    public GradeAggregateFilter() {
        this(0, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GradeAggregateFilter copy$default(GradeAggregateFilter gradeAggregateFilter, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = gradeAggregateFilter.id;
        }
        if ((i2 & 2) != 0) {
            str = gradeAggregateFilter.shortName;
        }
        return gradeAggregateFilter.copy(i, str);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.shortName;
    }

    public final GradeAggregateFilter copy(int i, String str) {
        return new GradeAggregateFilter(i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GradeAggregateFilter)) {
            return false;
        }
        GradeAggregateFilter gradeAggregateFilter = (GradeAggregateFilter) obj;
        return this.id == gradeAggregateFilter.id && Intrinsics.areEqual((Object) this.shortName, (Object) gradeAggregateFilter.shortName);
    }

    public int hashCode() {
        int i = this.id * 31;
        String str = this.shortName;
        return i + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "GradeAggregateFilter(id=" + this.id + ", shortName=" + this.shortName + ')';
    }

    public GradeAggregateFilter(int i, String str) {
        this.id = i;
        this.shortName = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GradeAggregateFilter(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str);
    }

    public final int getId() {
        return this.id;
    }

    public final String getShortName() {
        return this.shortName;
    }
}
