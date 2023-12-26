package com.tal.app.thinkacademy.business.study.study.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u0004\u001a\u00020\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/PlanInfo;", "", "name", "", "order", "", "startTime", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStartTime", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/tal/app/thinkacademy/business/study/study/entity/PlanInfo;", "equals", "", "other", "hashCode", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LearnMaterialsEntity.kt */
public final class PlanInfo {
    private final String name;
    private final Integer order;
    private final String startTime;

    public static /* synthetic */ PlanInfo copy$default(PlanInfo planInfo, String str, Integer num, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = planInfo.name;
        }
        if ((i & 2) != 0) {
            num = planInfo.order;
        }
        if ((i & 4) != 0) {
            str2 = planInfo.startTime;
        }
        return planInfo.copy(str, num, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final Integer component2() {
        return this.order;
    }

    public final String component3() {
        return this.startTime;
    }

    public final PlanInfo copy(String str, Integer num, String str2) {
        return new PlanInfo(str, num, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlanInfo)) {
            return false;
        }
        PlanInfo planInfo = (PlanInfo) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) planInfo.name) && Intrinsics.areEqual((Object) this.order, (Object) planInfo.order) && Intrinsics.areEqual((Object) this.startTime, (Object) planInfo.startTime);
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.order;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.startTime;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "PlanInfo(name=" + this.name + ", order=" + this.order + ", startTime=" + this.startTime + ')';
    }

    public PlanInfo(String str, Integer num, String str2) {
        this.name = str;
        this.order = num;
        this.startTime = str2;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlanInfo(String str, Integer num, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 1 : num, str2);
    }

    public final Integer getOrder() {
        return this.order;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String order() {
        Integer num = this.order;
        return (num == null ? 1 : num.intValue()) < 10 ? Intrinsics.stringPlus("0", this.order) : String.valueOf(this.order);
    }
}
