package com.tal.app.thinkacademy.business.study.study.entity.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/request/SwitchOptionsRequest;", "", "category", "", "haveCourse", "", "(Ljava/lang/String;Z)V", "getCategory", "()Ljava/lang/String;", "getHaveCourse", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwitchOptionsRequest.kt */
public final class SwitchOptionsRequest {
    private final String category;
    private final boolean haveCourse;

    public static /* synthetic */ SwitchOptionsRequest copy$default(SwitchOptionsRequest switchOptionsRequest, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = switchOptionsRequest.category;
        }
        if ((i & 2) != 0) {
            z = switchOptionsRequest.haveCourse;
        }
        return switchOptionsRequest.copy(str, z);
    }

    public final String component1() {
        return this.category;
    }

    public final boolean component2() {
        return this.haveCourse;
    }

    public final SwitchOptionsRequest copy(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "category");
        return new SwitchOptionsRequest(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwitchOptionsRequest)) {
            return false;
        }
        SwitchOptionsRequest switchOptionsRequest = (SwitchOptionsRequest) obj;
        return Intrinsics.areEqual((Object) this.category, (Object) switchOptionsRequest.category) && this.haveCourse == switchOptionsRequest.haveCourse;
    }

    public int hashCode() {
        int hashCode = this.category.hashCode() * 31;
        boolean z = this.haveCourse;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "SwitchOptionsRequest(category=" + this.category + ", haveCourse=" + this.haveCourse + ')';
    }

    public SwitchOptionsRequest(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "category");
        this.category = str;
        this.haveCourse = z;
    }

    public final String getCategory() {
        return this.category;
    }

    public final boolean getHaveCourse() {
        return this.haveCourse;
    }
}
