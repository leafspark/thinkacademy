package com.tal.app.thinkacademy.live.business.speedyhand.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/speedyhand/bean/SpeedyHandApiResult;", "", "studentInfo", "Lcom/tal/app/thinkacademy/live/business/speedyhand/bean/StudentInfo;", "(Lcom/tal/app/thinkacademy/live/business/speedyhand/bean/StudentInfo;)V", "getStudentInfo", "()Lcom/tal/app/thinkacademy/live/business/speedyhand/bean/StudentInfo;", "setStudentInfo", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpeedyHandApiResult.kt */
public final class SpeedyHandApiResult {
    private StudentInfo studentInfo;

    public SpeedyHandApiResult() {
        this((StudentInfo) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SpeedyHandApiResult copy$default(SpeedyHandApiResult speedyHandApiResult, StudentInfo studentInfo2, int i, Object obj) {
        if ((i & 1) != 0) {
            studentInfo2 = speedyHandApiResult.studentInfo;
        }
        return speedyHandApiResult.copy(studentInfo2);
    }

    public final StudentInfo component1() {
        return this.studentInfo;
    }

    public final SpeedyHandApiResult copy(StudentInfo studentInfo2) {
        return new SpeedyHandApiResult(studentInfo2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SpeedyHandApiResult) && Intrinsics.areEqual(this.studentInfo, ((SpeedyHandApiResult) obj).studentInfo);
    }

    public int hashCode() {
        StudentInfo studentInfo2 = this.studentInfo;
        if (studentInfo2 == null) {
            return 0;
        }
        return studentInfo2.hashCode();
    }

    public String toString() {
        return "SpeedyHandApiResult(studentInfo=" + this.studentInfo + ')';
    }

    public SpeedyHandApiResult(StudentInfo studentInfo2) {
        this.studentInfo = studentInfo2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SpeedyHandApiResult(StudentInfo studentInfo2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : studentInfo2);
    }

    public final StudentInfo getStudentInfo() {
        return this.studentInfo;
    }

    public final void setStudentInfo(StudentInfo studentInfo2) {
        this.studentInfo = studentInfo2;
    }
}
