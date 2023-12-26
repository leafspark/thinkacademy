package com.tal.app.thinkacademy.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/TimeZoneCheckEntity;", "", "invalid", "", "(I)V", "getInvalid", "()I", "setInvalid", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TimeZoneCheckEntity.kt */
public final class TimeZoneCheckEntity {
    private int invalid;

    public TimeZoneCheckEntity() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TimeZoneCheckEntity copy$default(TimeZoneCheckEntity timeZoneCheckEntity, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = timeZoneCheckEntity.invalid;
        }
        return timeZoneCheckEntity.copy(i);
    }

    public final int component1() {
        return this.invalid;
    }

    public final TimeZoneCheckEntity copy(int i) {
        return new TimeZoneCheckEntity(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TimeZoneCheckEntity) && this.invalid == ((TimeZoneCheckEntity) obj).invalid;
    }

    public int hashCode() {
        return this.invalid;
    }

    public String toString() {
        return "TimeZoneCheckEntity(invalid=" + this.invalid + ')';
    }

    public TimeZoneCheckEntity(int i) {
        this.invalid = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TimeZoneCheckEntity(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i);
    }

    public final int getInvalid() {
        return this.invalid;
    }

    public final void setInvalid(int i) {
        this.invalid = i;
    }
}
