package com.tal.app.thinkacademy.common.logan;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011¨\u0006$"}, d2 = {"Lcom/tal/app/thinkacademy/common/logan/FileParams;", "", "logName", "", "createTime", "", "finalTime", "planId", "planMode", "lessonType", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCreateTime", "()J", "getFinalTime", "getLessonType", "()Ljava/lang/String;", "setLessonType", "(Ljava/lang/String;)V", "getLogName", "getPlanId", "setPlanId", "getPlanMode", "setPlanMode", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoganFileParser.kt */
public final class FileParams {
    private final long createTime;
    private final long finalTime;
    private String lessonType;
    private final String logName;
    private String planId;
    private String planMode;

    public static /* synthetic */ FileParams copy$default(FileParams fileParams, String str, long j, long j2, String str2, String str3, String str4, int i, Object obj) {
        FileParams fileParams2 = fileParams;
        return fileParams.copy((i & 1) != 0 ? fileParams2.logName : str, (i & 2) != 0 ? fileParams2.createTime : j, (i & 4) != 0 ? fileParams2.finalTime : j2, (i & 8) != 0 ? fileParams2.planId : str2, (i & 16) != 0 ? fileParams2.planMode : str3, (i & 32) != 0 ? fileParams2.lessonType : str4);
    }

    public final String component1() {
        return this.logName;
    }

    public final long component2() {
        return this.createTime;
    }

    public final long component3() {
        return this.finalTime;
    }

    public final String component4() {
        return this.planId;
    }

    public final String component5() {
        return this.planMode;
    }

    public final String component6() {
        return this.lessonType;
    }

    public final FileParams copy(String str, long j, long j2, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "logName");
        return new FileParams(str, j, j2, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FileParams)) {
            return false;
        }
        FileParams fileParams = (FileParams) obj;
        return Intrinsics.areEqual(this.logName, fileParams.logName) && this.createTime == fileParams.createTime && this.finalTime == fileParams.finalTime && Intrinsics.areEqual(this.planId, fileParams.planId) && Intrinsics.areEqual(this.planMode, fileParams.planMode) && Intrinsics.areEqual(this.lessonType, fileParams.lessonType);
    }

    public int hashCode() {
        int hashCode = ((((this.logName.hashCode() * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.createTime)) * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.finalTime)) * 31;
        String str = this.planId;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.planMode;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.lessonType;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "FileParams(logName=" + this.logName + ", createTime=" + this.createTime + ", finalTime=" + this.finalTime + ", planId=" + this.planId + ", planMode=" + this.planMode + ", lessonType=" + this.lessonType + ')';
    }

    public FileParams(String str, long j, long j2, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "logName");
        this.logName = str;
        this.createTime = j;
        this.finalTime = j2;
        this.planId = str2;
        this.planMode = str3;
        this.lessonType = str4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FileParams(String str, long j, long j2, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, j2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
    }

    public final String getLogName() {
        return this.logName;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final long getFinalTime() {
        return this.finalTime;
    }

    public final String getPlanId() {
        return this.planId;
    }

    public final void setPlanId(String str) {
        this.planId = str;
    }

    public final String getPlanMode() {
        return this.planMode;
    }

    public final void setPlanMode(String str) {
        this.planMode = str;
    }

    public final String getLessonType() {
        return this.lessonType;
    }

    public final void setLessonType(String str) {
        this.lessonType = str;
    }
}
