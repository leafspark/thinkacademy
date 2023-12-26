package com.tal.app.thinkacademy.business.study.study.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/CheckInStatus;", "", "status", "", "(Ljava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "setStatus", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CheckInStatus.kt */
public final class CheckInStatus {
    private String status;

    public CheckInStatus() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CheckInStatus copy$default(CheckInStatus checkInStatus, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = checkInStatus.status;
        }
        return checkInStatus.copy(str);
    }

    public final String component1() {
        return this.status;
    }

    public final CheckInStatus copy(String str) {
        return new CheckInStatus(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CheckInStatus) && Intrinsics.areEqual((Object) this.status, (Object) ((CheckInStatus) obj).status);
    }

    public int hashCode() {
        String str = this.status;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "CheckInStatus(status=" + this.status + ')';
    }

    public CheckInStatus(String str) {
        this.status = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CheckInStatus(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "2" : str);
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }
}
