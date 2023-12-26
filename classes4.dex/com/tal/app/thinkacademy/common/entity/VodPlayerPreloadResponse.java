package com.tal.app.thinkacademy.common.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u001b\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/VodPlayerPreloadResponse;", "", "courseInfo", "", "Lcom/tal/app/thinkacademy/common/entity/CourseInfo;", "studentId", "", "(Ljava/util/List;Ljava/lang/String;)V", "getCourseInfo", "()Ljava/util/List;", "getStudentId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VodPlayerPreloadResponse.kt */
public final class VodPlayerPreloadResponse {
    private final List<CourseInfo> courseInfo;
    private final String studentId;

    public VodPlayerPreloadResponse() {
        this((List) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ VodPlayerPreloadResponse copy$default(VodPlayerPreloadResponse vodPlayerPreloadResponse, List<CourseInfo> list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = vodPlayerPreloadResponse.courseInfo;
        }
        if ((i & 2) != 0) {
            str = vodPlayerPreloadResponse.studentId;
        }
        return vodPlayerPreloadResponse.copy(list, str);
    }

    public final List<CourseInfo> component1() {
        return this.courseInfo;
    }

    public final String component2() {
        return this.studentId;
    }

    public final VodPlayerPreloadResponse copy(List<CourseInfo> list, String str) {
        return new VodPlayerPreloadResponse(list, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VodPlayerPreloadResponse)) {
            return false;
        }
        VodPlayerPreloadResponse vodPlayerPreloadResponse = (VodPlayerPreloadResponse) obj;
        return Intrinsics.areEqual(this.courseInfo, vodPlayerPreloadResponse.courseInfo) && Intrinsics.areEqual(this.studentId, vodPlayerPreloadResponse.studentId);
    }

    public int hashCode() {
        List<CourseInfo> list = this.courseInfo;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.studentId;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "VodPlayerPreloadResponse(courseInfo=" + this.courseInfo + ", studentId=" + this.studentId + ')';
    }

    public VodPlayerPreloadResponse(List<CourseInfo> list, String str) {
        this.courseInfo = list;
        this.studentId = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VodPlayerPreloadResponse(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : str);
    }

    public final List<CourseInfo> getCourseInfo() {
        return this.courseInfo;
    }

    public final String getStudentId() {
        return this.studentId;
    }
}
