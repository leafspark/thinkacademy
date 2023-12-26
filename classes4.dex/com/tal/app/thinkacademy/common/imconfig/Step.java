package com.tal.app.thinkacademy.common.imconfig;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/Step;", "", "desc", "", "isHide", "", "title", "(Ljava/lang/String;ZLjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "()Z", "getTitle", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchoolListInfo.kt */
public final class Step {
    private final String desc;
    private final boolean isHide;
    private final String title;

    public Step() {
        this((String) null, false, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Step copy$default(Step step, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = step.desc;
        }
        if ((i & 2) != 0) {
            z = step.isHide;
        }
        if ((i & 4) != 0) {
            str2 = step.title;
        }
        return step.copy(str, z, str2);
    }

    public final String component1() {
        return this.desc;
    }

    public final boolean component2() {
        return this.isHide;
    }

    public final String component3() {
        return this.title;
    }

    public final Step copy(String str, boolean z, String str2) {
        return new Step(str, z, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Step)) {
            return false;
        }
        Step step = (Step) obj;
        return Intrinsics.areEqual(this.desc, step.desc) && this.isHide == step.isHide && Intrinsics.areEqual(this.title, step.title);
    }

    public int hashCode() {
        String str = this.desc;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z = this.isHide;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + (z ? 1 : 0)) * 31;
        String str2 = this.title;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "Step(desc=" + this.desc + ", isHide=" + this.isHide + ", title=" + this.title + ')';
    }

    public Step(String str, boolean z, String str2) {
        this.desc = str;
        this.isHide = z;
        this.title = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Step(String str, boolean z, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : str2);
    }

    public final String getDesc() {
        return this.desc;
    }

    public final boolean isHide() {
        return this.isHide;
    }

    public final String getTitle() {
        return this.title;
    }
}
