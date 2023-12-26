package com.tal.app.thinkacademy.business.study.study.entity;

import com.tal.app.thinkacademy.business.study.study.adapter.ClassStatea;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/ClassGroups;", "", "tabStatus", "", "records", "", "Lcom/tal/app/thinkacademy/business/study/study/entity/Record;", "(Ljava/lang/String;Ljava/util/List;)V", "getRecords", "()Ljava/util/List;", "getTabStatus", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassListEntity.kt */
public final class ClassGroups {
    private final List<Record> records;
    private final String tabStatus;

    public static /* synthetic */ ClassGroups copy$default(ClassGroups classGroups, String str, List<Record> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = classGroups.tabStatus;
        }
        if ((i & 2) != 0) {
            list = classGroups.records;
        }
        return classGroups.copy(str, list);
    }

    public final String component1() {
        return this.tabStatus;
    }

    public final List<Record> component2() {
        return this.records;
    }

    public final ClassGroups copy(String str, List<Record> list) {
        Intrinsics.checkNotNullParameter(str, "tabStatus");
        Intrinsics.checkNotNullParameter(list, "records");
        return new ClassGroups(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassGroups)) {
            return false;
        }
        ClassGroups classGroups = (ClassGroups) obj;
        return Intrinsics.areEqual((Object) this.tabStatus, (Object) classGroups.tabStatus) && Intrinsics.areEqual((Object) this.records, (Object) classGroups.records);
    }

    public int hashCode() {
        return (this.tabStatus.hashCode() * 31) + this.records.hashCode();
    }

    public String toString() {
        return "ClassGroups(tabStatus=" + this.tabStatus + ", records=" + this.records + ')';
    }

    public ClassGroups(String str, List<Record> list) {
        Intrinsics.checkNotNullParameter(str, "tabStatus");
        Intrinsics.checkNotNullParameter(list, "records");
        this.tabStatus = str;
        this.records = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClassGroups(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ClassStatea.CURRENT.getStatename() : str, list);
    }

    public final String getTabStatus() {
        return this.tabStatus;
    }

    public final List<Record> getRecords() {
        return this.records;
    }
}
