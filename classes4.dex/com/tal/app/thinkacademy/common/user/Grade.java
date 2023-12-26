package com.tal.app.thinkacademy.common.user;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/common/user/Grade;", "", "name", "", "value", "", "shortName", "(Ljava/lang/String;ILjava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getShortName", "getValue", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeStageList.kt */
public final class Grade {
    private String name;
    private final String shortName;
    private final int value;

    public static /* synthetic */ Grade copy$default(Grade grade, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = grade.name;
        }
        if ((i2 & 2) != 0) {
            i = grade.value;
        }
        if ((i2 & 4) != 0) {
            str2 = grade.shortName;
        }
        return grade.copy(str, i, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.value;
    }

    public final String component3() {
        return this.shortName;
    }

    public final Grade copy(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "shortName");
        return new Grade(str, i, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Grade)) {
            return false;
        }
        Grade grade = (Grade) obj;
        return Intrinsics.areEqual(this.name, grade.name) && this.value == grade.value && Intrinsics.areEqual(this.shortName, grade.shortName);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.value) * 31) + this.shortName.hashCode();
    }

    public String toString() {
        return "Grade(name=" + this.name + ", value=" + this.value + ", shortName=" + this.shortName + ')';
    }

    public Grade(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "shortName");
        this.name = str;
        this.value = i;
        this.shortName = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final int getValue() {
        return this.value;
    }

    public final String getShortName() {
        return this.shortName;
    }
}
