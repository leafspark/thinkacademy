package com.tal.app.thinkacademy.business.login.entity;

import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\tJ\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J:\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/TimeZoneEntity;", "", "tzList", "", "", "list", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/business/login/entity/TimeZone;", "Lkotlin/collections/ArrayList;", "([Ljava/lang/String;Ljava/util/ArrayList;)V", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "getTzList", "()[Ljava/lang/String;", "setTzList", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "component1", "component2", "copy", "([Ljava/lang/String;Ljava/util/ArrayList;)Lcom/tal/app/thinkacademy/business/login/entity/TimeZoneEntity;", "equals", "", "other", "hashCode", "", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TimeZoneEntity.kt */
public final class TimeZoneEntity {
    private ArrayList<TimeZone> list;
    private String[] tzList;

    public TimeZoneEntity() {
        this((String[]) null, (ArrayList) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TimeZoneEntity copy$default(TimeZoneEntity timeZoneEntity, String[] strArr, ArrayList<TimeZone> arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            strArr = timeZoneEntity.tzList;
        }
        if ((i & 2) != 0) {
            arrayList = timeZoneEntity.list;
        }
        return timeZoneEntity.copy(strArr, arrayList);
    }

    public final String[] component1() {
        return this.tzList;
    }

    public final ArrayList<TimeZone> component2() {
        return this.list;
    }

    public final TimeZoneEntity copy(String[] strArr, ArrayList<TimeZone> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "list");
        return new TimeZoneEntity(strArr, arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeZoneEntity)) {
            return false;
        }
        TimeZoneEntity timeZoneEntity = (TimeZoneEntity) obj;
        return Intrinsics.areEqual((Object) this.tzList, (Object) timeZoneEntity.tzList) && Intrinsics.areEqual((Object) this.list, (Object) timeZoneEntity.list);
    }

    public int hashCode() {
        String[] strArr = this.tzList;
        return ((strArr == null ? 0 : Arrays.hashCode(strArr)) * 31) + this.list.hashCode();
    }

    public String toString() {
        return "TimeZoneEntity(tzList=" + Arrays.toString(this.tzList) + ", list=" + this.list + ')';
    }

    public TimeZoneEntity(String[] strArr, ArrayList<TimeZone> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "list");
        this.tzList = strArr;
        this.list = arrayList;
    }

    public final String[] getTzList() {
        return this.tzList;
    }

    public final void setTzList(String[] strArr) {
        this.tzList = strArr;
    }

    public final ArrayList<TimeZone> getList() {
        return this.list;
    }

    public final void setList(ArrayList<TimeZone> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.list = arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TimeZoneEntity(String[] strArr, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? (String[]) ((Object[]) new String[0]) : strArr, (i & 2) != 0 ? new ArrayList() : arrayList);
    }
}
