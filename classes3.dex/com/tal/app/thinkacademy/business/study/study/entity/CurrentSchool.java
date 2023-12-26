package com.tal.app.thinkacademy.business.study.study.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/CurrentSchool;", "", "live", "", "record", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getLive", "()Ljava/lang/Boolean;", "setLive", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getRecord", "setRecord", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/tal/app/thinkacademy/business/study/study/entity/CurrentSchool;", "equals", "other", "hashCode", "", "toString", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CurrentSchool.kt */
public final class CurrentSchool {
    private Boolean live;
    private Boolean record;

    public CurrentSchool() {
        this((Boolean) null, (Boolean) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CurrentSchool copy$default(CurrentSchool currentSchool, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = currentSchool.live;
        }
        if ((i & 2) != 0) {
            bool2 = currentSchool.record;
        }
        return currentSchool.copy(bool, bool2);
    }

    public final Boolean component1() {
        return this.live;
    }

    public final Boolean component2() {
        return this.record;
    }

    public final CurrentSchool copy(Boolean bool, Boolean bool2) {
        return new CurrentSchool(bool, bool2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CurrentSchool)) {
            return false;
        }
        CurrentSchool currentSchool = (CurrentSchool) obj;
        return Intrinsics.areEqual((Object) this.live, (Object) currentSchool.live) && Intrinsics.areEqual((Object) this.record, (Object) currentSchool.record);
    }

    public int hashCode() {
        Boolean bool = this.live;
        int i = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.record;
        if (bool2 != null) {
            i = bool2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CurrentSchool(live=" + this.live + ", record=" + this.record + ')';
    }

    public CurrentSchool(Boolean bool, Boolean bool2) {
        this.live = bool;
        this.record = bool2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CurrentSchool(Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : bool, (i & 2) != 0 ? false : bool2);
    }

    public final Boolean getLive() {
        return this.live;
    }

    public final void setLive(Boolean bool) {
        this.live = bool;
    }

    public final Boolean getRecord() {
        return this.record;
    }

    public final void setRecord(Boolean bool) {
        this.record = bool;
    }
}
