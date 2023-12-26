package com.tal.app.thinkacademy.business.study.study.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/CheckStudentInClass;", "", "maybeInClass", "", "lastInClassSameDevice", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getLastInClassSameDevice", "()Ljava/lang/Integer;", "setLastInClassSameDevice", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMaybeInClass", "setMaybeInClass", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/business/study/study/entity/CheckStudentInClass;", "equals", "", "other", "hashCode", "toString", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CheckStudentInClass.kt */
public final class CheckStudentInClass {
    private Integer lastInClassSameDevice;
    private Integer maybeInClass;

    public CheckStudentInClass() {
        this((Integer) null, (Integer) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CheckStudentInClass copy$default(CheckStudentInClass checkStudentInClass, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = checkStudentInClass.maybeInClass;
        }
        if ((i & 2) != 0) {
            num2 = checkStudentInClass.lastInClassSameDevice;
        }
        return checkStudentInClass.copy(num, num2);
    }

    public final Integer component1() {
        return this.maybeInClass;
    }

    public final Integer component2() {
        return this.lastInClassSameDevice;
    }

    public final CheckStudentInClass copy(Integer num, Integer num2) {
        return new CheckStudentInClass(num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckStudentInClass)) {
            return false;
        }
        CheckStudentInClass checkStudentInClass = (CheckStudentInClass) obj;
        return Intrinsics.areEqual((Object) this.maybeInClass, (Object) checkStudentInClass.maybeInClass) && Intrinsics.areEqual((Object) this.lastInClassSameDevice, (Object) checkStudentInClass.lastInClassSameDevice);
    }

    public int hashCode() {
        Integer num = this.maybeInClass;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.lastInClassSameDevice;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CheckStudentInClass(maybeInClass=" + this.maybeInClass + ", lastInClassSameDevice=" + this.lastInClassSameDevice + ')';
    }

    public CheckStudentInClass(Integer num, Integer num2) {
        this.maybeInClass = num;
        this.lastInClassSameDevice = num2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CheckStudentInClass(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? 0 : num2);
    }

    public final Integer getMaybeInClass() {
        return this.maybeInClass;
    }

    public final void setMaybeInClass(Integer num) {
        this.maybeInClass = num;
    }

    public final Integer getLastInClassSameDevice() {
        return this.lastInClassSameDevice;
    }

    public final void setLastInClassSameDevice(Integer num) {
        this.lastInClassSameDevice = num;
    }
}
