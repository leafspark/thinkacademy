package com.tal.app.thinkacademy.common.user;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/common/user/GradeStageList;", "", "list", "", "Lcom/tal/app/thinkacademy/common/user/GradeStage;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeStageList.kt */
public final class GradeStageList {
    private final List<GradeStage> list;

    public static /* synthetic */ GradeStageList copy$default(GradeStageList gradeStageList, List<GradeStage> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list2 = gradeStageList.list;
        }
        return gradeStageList.copy(list2);
    }

    public final List<GradeStage> component1() {
        return this.list;
    }

    public final GradeStageList copy(List<GradeStage> list2) {
        Intrinsics.checkNotNullParameter(list2, "list");
        return new GradeStageList(list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GradeStageList) && Intrinsics.areEqual(this.list, ((GradeStageList) obj).list);
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    public String toString() {
        return "GradeStageList(list=" + this.list + ')';
    }

    public GradeStageList(List<GradeStage> list2) {
        Intrinsics.checkNotNullParameter(list2, "list");
        this.list = list2;
    }

    public final List<GradeStage> getList() {
        return this.list;
    }
}
