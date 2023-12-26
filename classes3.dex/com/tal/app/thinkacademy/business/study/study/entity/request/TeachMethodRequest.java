package com.tal.app.thinkacademy.business.study.study.entity.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/request/TeachMethodRequest;", "", "classId", "", "orderNum", "(Ljava/lang/String;Ljava/lang/String;)V", "getClassId", "()Ljava/lang/String;", "getOrderNum", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeachMethodRequest.kt */
public final class TeachMethodRequest {
    private final String classId;
    private final String orderNum;

    public static /* synthetic */ TeachMethodRequest copy$default(TeachMethodRequest teachMethodRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = teachMethodRequest.classId;
        }
        if ((i & 2) != 0) {
            str2 = teachMethodRequest.orderNum;
        }
        return teachMethodRequest.copy(str, str2);
    }

    public final String component1() {
        return this.classId;
    }

    public final String component2() {
        return this.orderNum;
    }

    public final TeachMethodRequest copy(String str, String str2) {
        return new TeachMethodRequest(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TeachMethodRequest)) {
            return false;
        }
        TeachMethodRequest teachMethodRequest = (TeachMethodRequest) obj;
        return Intrinsics.areEqual((Object) this.classId, (Object) teachMethodRequest.classId) && Intrinsics.areEqual((Object) this.orderNum, (Object) teachMethodRequest.orderNum);
    }

    public int hashCode() {
        String str = this.classId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.orderNum;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "TeachMethodRequest(classId=" + this.classId + ", orderNum=" + this.orderNum + ')';
    }

    public TeachMethodRequest(String str, String str2) {
        this.classId = str;
        this.orderNum = str2;
    }

    public final String getClassId() {
        return this.classId;
    }

    public final String getOrderNum() {
        return this.orderNum;
    }
}
