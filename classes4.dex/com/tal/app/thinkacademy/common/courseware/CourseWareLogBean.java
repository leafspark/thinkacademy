package com.tal.app.thinkacademy.common.courseware;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkacademy/common/courseware/CourseWareLogBean;", "", "coursewareId", "", "url", "packageSize", "", "downloadCost", "isSuccess", "", "(Ljava/lang/String;Ljava/lang/String;JJI)V", "getCoursewareId", "()Ljava/lang/String;", "getDownloadCost", "()J", "()I", "getPackageSize", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CourseWareLogBean.kt */
public final class CourseWareLogBean {
    private final String coursewareId;
    private final long downloadCost;
    private final int isSuccess;
    private final long packageSize;
    private final String url;

    public static /* synthetic */ CourseWareLogBean copy$default(CourseWareLogBean courseWareLogBean, String str, String str2, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = courseWareLogBean.coursewareId;
        }
        if ((i2 & 2) != 0) {
            str2 = courseWareLogBean.url;
        }
        String str3 = str2;
        if ((i2 & 4) != 0) {
            j = courseWareLogBean.packageSize;
        }
        long j3 = j;
        if ((i2 & 8) != 0) {
            j2 = courseWareLogBean.downloadCost;
        }
        long j4 = j2;
        if ((i2 & 16) != 0) {
            i = courseWareLogBean.isSuccess;
        }
        return courseWareLogBean.copy(str, str3, j3, j4, i);
    }

    public final String component1() {
        return this.coursewareId;
    }

    public final String component2() {
        return this.url;
    }

    public final long component3() {
        return this.packageSize;
    }

    public final long component4() {
        return this.downloadCost;
    }

    public final int component5() {
        return this.isSuccess;
    }

    public final CourseWareLogBean copy(String str, String str2, long j, long j2, int i) {
        Intrinsics.checkNotNullParameter(str, "coursewareId");
        Intrinsics.checkNotNullParameter(str2, "url");
        return new CourseWareLogBean(str, str2, j, j2, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CourseWareLogBean)) {
            return false;
        }
        CourseWareLogBean courseWareLogBean = (CourseWareLogBean) obj;
        return Intrinsics.areEqual(this.coursewareId, courseWareLogBean.coursewareId) && Intrinsics.areEqual(this.url, courseWareLogBean.url) && this.packageSize == courseWareLogBean.packageSize && this.downloadCost == courseWareLogBean.downloadCost && this.isSuccess == courseWareLogBean.isSuccess;
    }

    public int hashCode() {
        return (((((((this.coursewareId.hashCode() * 31) + this.url.hashCode()) * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.packageSize)) * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.downloadCost)) * 31) + this.isSuccess;
    }

    public String toString() {
        return "CourseWareLogBean(coursewareId=" + this.coursewareId + ", url=" + this.url + ", packageSize=" + this.packageSize + ", downloadCost=" + this.downloadCost + ", isSuccess=" + this.isSuccess + ')';
    }

    public CourseWareLogBean(String str, String str2, long j, long j2, int i) {
        Intrinsics.checkNotNullParameter(str, "coursewareId");
        Intrinsics.checkNotNullParameter(str2, "url");
        this.coursewareId = str;
        this.url = str2;
        this.packageSize = j;
        this.downloadCost = j2;
        this.isSuccess = i;
    }

    public final String getCoursewareId() {
        return this.coursewareId;
    }

    public final String getUrl() {
        return this.url;
    }

    public final long getPackageSize() {
        return this.packageSize;
    }

    public final long getDownloadCost() {
        return this.downloadCost;
    }

    public final int isSuccess() {
        return this.isSuccess;
    }
}
