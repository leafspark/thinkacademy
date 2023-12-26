package com.tal.app.thinkacademy.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/TimeZoneInfo;", "", "timeZone", "", "isShowTip", "", "(Ljava/lang/String;Z)V", "()Z", "getTimeZone", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TimeZoneInfo.kt */
public final class TimeZoneInfo {
    private final boolean isShowTip;
    private final String timeZone;

    public static /* synthetic */ TimeZoneInfo copy$default(TimeZoneInfo timeZoneInfo, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = timeZoneInfo.timeZone;
        }
        if ((i & 2) != 0) {
            z = timeZoneInfo.isShowTip;
        }
        return timeZoneInfo.copy(str, z);
    }

    public final String component1() {
        return this.timeZone;
    }

    public final boolean component2() {
        return this.isShowTip;
    }

    public final TimeZoneInfo copy(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "timeZone");
        return new TimeZoneInfo(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeZoneInfo)) {
            return false;
        }
        TimeZoneInfo timeZoneInfo = (TimeZoneInfo) obj;
        return Intrinsics.areEqual(this.timeZone, timeZoneInfo.timeZone) && this.isShowTip == timeZoneInfo.isShowTip;
    }

    public int hashCode() {
        int hashCode = this.timeZone.hashCode() * 31;
        boolean z = this.isShowTip;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "TimeZoneInfo(timeZone=" + this.timeZone + ", isShowTip=" + this.isShowTip + ')';
    }

    public TimeZoneInfo(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "timeZone");
        this.timeZone = str;
        this.isShowTip = z;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final boolean isShowTip() {
        return this.isShowTip;
    }
}
