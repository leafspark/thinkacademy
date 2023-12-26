package com.tal.app.thinkacademy.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/CourseLoadResult;", "", "state", "", "isLocal", "", "url", "msg", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "()Z", "getMsg", "()Ljava/lang/String;", "getState", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CourseLoadResult.kt */
public final class CourseLoadResult {
    private final boolean isLocal;
    private final String msg;
    private final String state;
    private final String url;

    public static /* synthetic */ CourseLoadResult copy$default(CourseLoadResult courseLoadResult, String str, boolean z, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = courseLoadResult.state;
        }
        if ((i & 2) != 0) {
            z = courseLoadResult.isLocal;
        }
        if ((i & 4) != 0) {
            str2 = courseLoadResult.url;
        }
        if ((i & 8) != 0) {
            str3 = courseLoadResult.msg;
        }
        return courseLoadResult.copy(str, z, str2, str3);
    }

    public final String component1() {
        return this.state;
    }

    public final boolean component2() {
        return this.isLocal;
    }

    public final String component3() {
        return this.url;
    }

    public final String component4() {
        return this.msg;
    }

    public final CourseLoadResult copy(String str, boolean z, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "state");
        return new CourseLoadResult(str, z, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CourseLoadResult)) {
            return false;
        }
        CourseLoadResult courseLoadResult = (CourseLoadResult) obj;
        return Intrinsics.areEqual(this.state, courseLoadResult.state) && this.isLocal == courseLoadResult.isLocal && Intrinsics.areEqual(this.url, courseLoadResult.url) && Intrinsics.areEqual(this.msg, courseLoadResult.msg);
    }

    public int hashCode() {
        int hashCode = this.state.hashCode() * 31;
        boolean z = this.isLocal;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        String str = this.url;
        int i2 = 0;
        int hashCode2 = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.msg;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "CourseLoadResult(state=" + this.state + ", isLocal=" + this.isLocal + ", url=" + this.url + ", msg=" + this.msg + ')';
    }

    public CourseLoadResult(String str, boolean z, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "state");
        this.state = str;
        this.isLocal = z;
        this.url = str2;
        this.msg = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CourseLoadResult(String str, boolean z, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
    }

    public final String getState() {
        return this.state;
    }

    public final boolean isLocal() {
        return this.isLocal;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getMsg() {
        return this.msg;
    }
}
