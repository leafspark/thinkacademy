package com.tal.app.thinkacademy.common.user;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/common/user/GradeStage;", "", "stageId", "", "gradeStage", "", "icon", "list", "", "Lcom/tal/app/thinkacademy/common/user/Grade;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getGradeStage", "()Ljava/lang/String;", "getIcon", "getList", "()Ljava/util/List;", "getStageId", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeStageList.kt */
public final class GradeStage {
    private final String gradeStage;
    private final String icon;
    private final List<Grade> list;
    private final int stageId;

    public static /* synthetic */ GradeStage copy$default(GradeStage gradeStage2, int i, String str, String str2, List<Grade> list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = gradeStage2.stageId;
        }
        if ((i2 & 2) != 0) {
            str = gradeStage2.gradeStage;
        }
        if ((i2 & 4) != 0) {
            str2 = gradeStage2.icon;
        }
        if ((i2 & 8) != 0) {
            list2 = gradeStage2.list;
        }
        return gradeStage2.copy(i, str, str2, list2);
    }

    public final int component1() {
        return this.stageId;
    }

    public final String component2() {
        return this.gradeStage;
    }

    public final String component3() {
        return this.icon;
    }

    public final List<Grade> component4() {
        return this.list;
    }

    public final GradeStage copy(int i, String str, String str2, List<Grade> list2) {
        Intrinsics.checkNotNullParameter(str, "gradeStage");
        Intrinsics.checkNotNullParameter(str2, "icon");
        Intrinsics.checkNotNullParameter(list2, "list");
        return new GradeStage(i, str, str2, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GradeStage)) {
            return false;
        }
        GradeStage gradeStage2 = (GradeStage) obj;
        return this.stageId == gradeStage2.stageId && Intrinsics.areEqual(this.gradeStage, gradeStage2.gradeStage) && Intrinsics.areEqual(this.icon, gradeStage2.icon) && Intrinsics.areEqual(this.list, gradeStage2.list);
    }

    public int hashCode() {
        return (((((this.stageId * 31) + this.gradeStage.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.list.hashCode();
    }

    public String toString() {
        return "GradeStage(stageId=" + this.stageId + ", gradeStage=" + this.gradeStage + ", icon=" + this.icon + ", list=" + this.list + ')';
    }

    public GradeStage(int i, String str, String str2, List<Grade> list2) {
        Intrinsics.checkNotNullParameter(str, "gradeStage");
        Intrinsics.checkNotNullParameter(str2, "icon");
        Intrinsics.checkNotNullParameter(list2, "list");
        this.stageId = i;
        this.gradeStage = str;
        this.icon = str2;
        this.list = list2;
    }

    public final int getStageId() {
        return this.stageId;
    }

    public final String getGradeStage() {
        return this.gradeStage;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final List<Grade> getList() {
        return this.list;
    }
}
