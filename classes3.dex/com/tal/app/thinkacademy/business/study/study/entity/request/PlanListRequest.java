package com.tal.app.thinkacademy.business.study.study.entity.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/request/PlanListRequest;", "", "viewType", "", "classId", "cardStyle", "", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCardStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getClassId", "()Ljava/lang/String;", "getType", "getViewType", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/business/study/study/entity/request/PlanListRequest;", "equals", "", "other", "hashCode", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlanListRequest.kt */
public final class PlanListRequest {
    private final Integer cardStyle;
    private final String classId;
    private final Integer type;
    private final String viewType;

    public static /* synthetic */ PlanListRequest copy$default(PlanListRequest planListRequest, String str, String str2, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = planListRequest.viewType;
        }
        if ((i & 2) != 0) {
            str2 = planListRequest.classId;
        }
        if ((i & 4) != 0) {
            num = planListRequest.cardStyle;
        }
        if ((i & 8) != 0) {
            num2 = planListRequest.type;
        }
        return planListRequest.copy(str, str2, num, num2);
    }

    public final String component1() {
        return this.viewType;
    }

    public final String component2() {
        return this.classId;
    }

    public final Integer component3() {
        return this.cardStyle;
    }

    public final Integer component4() {
        return this.type;
    }

    public final PlanListRequest copy(String str, String str2, Integer num, Integer num2) {
        return new PlanListRequest(str, str2, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlanListRequest)) {
            return false;
        }
        PlanListRequest planListRequest = (PlanListRequest) obj;
        return Intrinsics.areEqual((Object) this.viewType, (Object) planListRequest.viewType) && Intrinsics.areEqual((Object) this.classId, (Object) planListRequest.classId) && Intrinsics.areEqual((Object) this.cardStyle, (Object) planListRequest.cardStyle) && Intrinsics.areEqual((Object) this.type, (Object) planListRequest.type);
    }

    public int hashCode() {
        String str = this.viewType;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.classId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.cardStyle;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.type;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "PlanListRequest(viewType=" + this.viewType + ", classId=" + this.classId + ", cardStyle=" + this.cardStyle + ", type=" + this.type + ')';
    }

    public PlanListRequest(String str, String str2, Integer num, Integer num2) {
        this.viewType = str;
        this.classId = str2;
        this.cardStyle = num;
        this.type = num2;
    }

    public final String getViewType() {
        return this.viewType;
    }

    public final String getClassId() {
        return this.classId;
    }

    public final Integer getCardStyle() {
        return this.cardStyle;
    }

    public final Integer getType() {
        return this.type;
    }
}
