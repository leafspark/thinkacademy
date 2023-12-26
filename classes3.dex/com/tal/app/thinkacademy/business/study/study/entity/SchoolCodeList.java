package com.tal.app.thinkacademy.business.study.study.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001R\u001b\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/SchoolCodeList;", "", "schoolCodes", "", "", "(Ljava/util/List;)V", "getSchoolCodes", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchoolCodeList.kt */
public final class SchoolCodeList {
    private final List<String> schoolCodes;

    public static /* synthetic */ SchoolCodeList copy$default(SchoolCodeList schoolCodeList, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = schoolCodeList.schoolCodes;
        }
        return schoolCodeList.copy(list);
    }

    public final List<String> component1() {
        return this.schoolCodes;
    }

    public final SchoolCodeList copy(List<String> list) {
        return new SchoolCodeList(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SchoolCodeList) && Intrinsics.areEqual((Object) this.schoolCodes, (Object) ((SchoolCodeList) obj).schoolCodes);
    }

    public int hashCode() {
        List<String> list = this.schoolCodes;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "SchoolCodeList(schoolCodes=" + this.schoolCodes + ')';
    }

    public SchoolCodeList(List<String> list) {
        this.schoolCodes = list;
    }

    public final List<String> getSchoolCodes() {
        return this.schoolCodes;
    }
}
