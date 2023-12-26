package com.tal.app.thinkacademy.common.imconfig;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/SchoolListInfo;", "", "list", "", "Lcom/tal/app/thinkacademy/common/imconfig/SchoolDataInfo;", "v", "", "(Ljava/util/List;Ljava/lang/String;)V", "getList", "()Ljava/util/List;", "getV", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchoolListInfo.kt */
public final class SchoolListInfo {
    private final List<SchoolDataInfo> list;
    private final String v;

    public SchoolListInfo() {
        this((List) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SchoolListInfo copy$default(SchoolListInfo schoolListInfo, List<SchoolDataInfo> list2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list2 = schoolListInfo.list;
        }
        if ((i & 2) != 0) {
            str = schoolListInfo.v;
        }
        return schoolListInfo.copy(list2, str);
    }

    public final List<SchoolDataInfo> component1() {
        return this.list;
    }

    public final String component2() {
        return this.v;
    }

    public final SchoolListInfo copy(List<SchoolDataInfo> list2, String str) {
        return new SchoolListInfo(list2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SchoolListInfo)) {
            return false;
        }
        SchoolListInfo schoolListInfo = (SchoolListInfo) obj;
        return Intrinsics.areEqual(this.list, schoolListInfo.list) && Intrinsics.areEqual(this.v, schoolListInfo.v);
    }

    public int hashCode() {
        List<SchoolDataInfo> list2 = this.list;
        int i = 0;
        int hashCode = (list2 == null ? 0 : list2.hashCode()) * 31;
        String str = this.v;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "SchoolListInfo(list=" + this.list + ", v=" + this.v + ')';
    }

    public SchoolListInfo(List<SchoolDataInfo> list2, String str) {
        this.list = list2;
        this.v = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SchoolListInfo(List list2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list2, (i & 2) != 0 ? null : str);
    }

    public final List<SchoolDataInfo> getList() {
        return this.list;
    }

    public final String getV() {
        return this.v;
    }
}
