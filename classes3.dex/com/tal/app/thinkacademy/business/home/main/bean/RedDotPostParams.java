package com.tal.app.thinkacademy.business.home.main.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/bean/RedDotPostParams;", "", "schoolCode", "", "studentId", "(Ljava/lang/String;Ljava/lang/String;)V", "getSchoolCode", "()Ljava/lang/String;", "getStudentId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedDotPostBody.kt */
public final class RedDotPostParams {
    private final String schoolCode;
    private final String studentId;

    public static /* synthetic */ RedDotPostParams copy$default(RedDotPostParams redDotPostParams, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = redDotPostParams.schoolCode;
        }
        if ((i & 2) != 0) {
            str2 = redDotPostParams.studentId;
        }
        return redDotPostParams.copy(str, str2);
    }

    public final String component1() {
        return this.schoolCode;
    }

    public final String component2() {
        return this.studentId;
    }

    public final RedDotPostParams copy(String str, String str2) {
        return new RedDotPostParams(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedDotPostParams)) {
            return false;
        }
        RedDotPostParams redDotPostParams = (RedDotPostParams) obj;
        return Intrinsics.areEqual((Object) this.schoolCode, (Object) redDotPostParams.schoolCode) && Intrinsics.areEqual((Object) this.studentId, (Object) redDotPostParams.studentId);
    }

    public int hashCode() {
        String str = this.schoolCode;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.studentId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "RedDotPostParams(schoolCode=" + this.schoolCode + ", studentId=" + this.studentId + ')';
    }

    public RedDotPostParams(String str, String str2) {
        this.schoolCode = str;
        this.studentId = str2;
    }

    public final String getSchoolCode() {
        return this.schoolCode;
    }

    public final String getStudentId() {
        return this.studentId;
    }
}
