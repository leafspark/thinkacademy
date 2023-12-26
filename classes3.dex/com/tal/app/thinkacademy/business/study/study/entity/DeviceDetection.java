package com.tal.app.thinkacademy.business.study.study.entity;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/DeviceDetection;", "", "rtcToken", "", "studentId", "", "(Ljava/lang/String;J)V", "getRtcToken", "()Ljava/lang/String;", "getStudentId", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReadyClassBean.kt */
public final class DeviceDetection {
    private final String rtcToken;
    private final long studentId;

    public static /* synthetic */ DeviceDetection copy$default(DeviceDetection deviceDetection, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceDetection.rtcToken;
        }
        if ((i & 2) != 0) {
            j = deviceDetection.studentId;
        }
        return deviceDetection.copy(str, j);
    }

    public final String component1() {
        return this.rtcToken;
    }

    public final long component2() {
        return this.studentId;
    }

    public final DeviceDetection copy(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "rtcToken");
        return new DeviceDetection(str, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceDetection)) {
            return false;
        }
        DeviceDetection deviceDetection = (DeviceDetection) obj;
        return Intrinsics.areEqual((Object) this.rtcToken, (Object) deviceDetection.rtcToken) && this.studentId == deviceDetection.studentId;
    }

    public int hashCode() {
        return (this.rtcToken.hashCode() * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.studentId);
    }

    public String toString() {
        return "DeviceDetection(rtcToken=" + this.rtcToken + ", studentId=" + this.studentId + ')';
    }

    public DeviceDetection(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "rtcToken");
        this.rtcToken = str;
        this.studentId = j;
    }

    public final String getRtcToken() {
        return this.rtcToken;
    }

    public final long getStudentId() {
        return this.studentId;
    }
}
