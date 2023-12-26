package com.tal.app.thinkacademy.business.study.study.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/Recorded;", "", "schoolCodes", "", "", "(Ljava/util/List;)V", "getSchoolCodes", "()Ljava/util/List;", "setSchoolCodes", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllSchoolsList.kt */
public final class Recorded {
    private List<String> schoolCodes;

    public static /* synthetic */ Recorded copy$default(Recorded recorded, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = recorded.schoolCodes;
        }
        return recorded.copy(list);
    }

    public final List<String> component1() {
        return this.schoolCodes;
    }

    public final Recorded copy(List<String> list) {
        return new Recorded(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Recorded) && Intrinsics.areEqual((Object) this.schoolCodes, (Object) ((Recorded) obj).schoolCodes);
    }

    public int hashCode() {
        List<String> list = this.schoolCodes;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "Recorded(schoolCodes=" + this.schoolCodes + ')';
    }

    public Recorded(List<String> list) {
        this.schoolCodes = list;
    }

    public final List<String> getSchoolCodes() {
        return this.schoolCodes;
    }

    public final void setSchoolCodes(List<String> list) {
        this.schoolCodes = list;
    }
}
