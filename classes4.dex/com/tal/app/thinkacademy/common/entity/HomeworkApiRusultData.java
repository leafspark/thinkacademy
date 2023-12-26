package com.tal.app.thinkacademy.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÆ\u0003JQ\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\f¨\u0006%"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/HomeworkApiRusultData;", "", "path", "responseTime", "status", "uploadDuration", "uploadStatus", "uploadType", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getPath", "()Ljava/lang/Object;", "setPath", "(Ljava/lang/Object;)V", "getResponseTime", "setResponseTime", "getStatus", "setStatus", "getUploadDuration", "setUploadDuration", "getUploadStatus", "setUploadStatus", "getUploadType", "setUploadType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeworkApiRusultData.kt */
public final class HomeworkApiRusultData {
    private Object path;
    private Object responseTime;
    private Object status;
    private Object uploadDuration;
    private Object uploadStatus;
    private Object uploadType;

    public static /* synthetic */ HomeworkApiRusultData copy$default(HomeworkApiRusultData homeworkApiRusultData, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, int i, Object obj7) {
        if ((i & 1) != 0) {
            obj = homeworkApiRusultData.path;
        }
        if ((i & 2) != 0) {
            obj2 = homeworkApiRusultData.responseTime;
        }
        Object obj8 = obj2;
        if ((i & 4) != 0) {
            obj3 = homeworkApiRusultData.status;
        }
        Object obj9 = obj3;
        if ((i & 8) != 0) {
            obj4 = homeworkApiRusultData.uploadDuration;
        }
        Object obj10 = obj4;
        if ((i & 16) != 0) {
            obj5 = homeworkApiRusultData.uploadStatus;
        }
        Object obj11 = obj5;
        if ((i & 32) != 0) {
            obj6 = homeworkApiRusultData.uploadType;
        }
        return homeworkApiRusultData.copy(obj, obj8, obj9, obj10, obj11, obj6);
    }

    public final Object component1() {
        return this.path;
    }

    public final Object component2() {
        return this.responseTime;
    }

    public final Object component3() {
        return this.status;
    }

    public final Object component4() {
        return this.uploadDuration;
    }

    public final Object component5() {
        return this.uploadStatus;
    }

    public final Object component6() {
        return this.uploadType;
    }

    public final HomeworkApiRusultData copy(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return new HomeworkApiRusultData(obj, obj2, obj3, obj4, obj5, obj6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeworkApiRusultData)) {
            return false;
        }
        HomeworkApiRusultData homeworkApiRusultData = (HomeworkApiRusultData) obj;
        return Intrinsics.areEqual(this.path, homeworkApiRusultData.path) && Intrinsics.areEqual(this.responseTime, homeworkApiRusultData.responseTime) && Intrinsics.areEqual(this.status, homeworkApiRusultData.status) && Intrinsics.areEqual(this.uploadDuration, homeworkApiRusultData.uploadDuration) && Intrinsics.areEqual(this.uploadStatus, homeworkApiRusultData.uploadStatus) && Intrinsics.areEqual(this.uploadType, homeworkApiRusultData.uploadType);
    }

    public int hashCode() {
        Object obj = this.path;
        int i = 0;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.responseTime;
        int hashCode2 = (hashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.status;
        int hashCode3 = (hashCode2 + (obj3 == null ? 0 : obj3.hashCode())) * 31;
        Object obj4 = this.uploadDuration;
        int hashCode4 = (hashCode3 + (obj4 == null ? 0 : obj4.hashCode())) * 31;
        Object obj5 = this.uploadStatus;
        int hashCode5 = (hashCode4 + (obj5 == null ? 0 : obj5.hashCode())) * 31;
        Object obj6 = this.uploadType;
        if (obj6 != null) {
            i = obj6.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "HomeworkApiRusultData(path=" + this.path + ", responseTime=" + this.responseTime + ", status=" + this.status + ", uploadDuration=" + this.uploadDuration + ", uploadStatus=" + this.uploadStatus + ", uploadType=" + this.uploadType + ')';
    }

    public HomeworkApiRusultData(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        this.path = obj;
        this.responseTime = obj2;
        this.status = obj3;
        this.uploadDuration = obj4;
        this.uploadStatus = obj5;
        this.uploadType = obj6;
    }

    public final Object getPath() {
        return this.path;
    }

    public final void setPath(Object obj) {
        this.path = obj;
    }

    public final Object getResponseTime() {
        return this.responseTime;
    }

    public final void setResponseTime(Object obj) {
        this.responseTime = obj;
    }

    public final Object getStatus() {
        return this.status;
    }

    public final void setStatus(Object obj) {
        this.status = obj;
    }

    public final Object getUploadDuration() {
        return this.uploadDuration;
    }

    public final void setUploadDuration(Object obj) {
        this.uploadDuration = obj;
    }

    public final Object getUploadStatus() {
        return this.uploadStatus;
    }

    public final void setUploadStatus(Object obj) {
        this.uploadStatus = obj;
    }

    public final Object getUploadType() {
        return this.uploadType;
    }

    public final void setUploadType(Object obj) {
        this.uploadType = obj;
    }
}
