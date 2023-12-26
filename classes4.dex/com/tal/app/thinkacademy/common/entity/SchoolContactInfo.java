package com.tal.app.thinkacademy.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/SchoolContactInfo;", "", "contactInfo", "", "isPhone", "", "(Ljava/lang/String;Z)V", "getContactInfo", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchoolContactInfo.kt */
public final class SchoolContactInfo {
    private final String contactInfo;
    private final boolean isPhone;

    public SchoolContactInfo() {
        this((String) null, false, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SchoolContactInfo copy$default(SchoolContactInfo schoolContactInfo, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = schoolContactInfo.contactInfo;
        }
        if ((i & 2) != 0) {
            z = schoolContactInfo.isPhone;
        }
        return schoolContactInfo.copy(str, z);
    }

    public final String component1() {
        return this.contactInfo;
    }

    public final boolean component2() {
        return this.isPhone;
    }

    public final SchoolContactInfo copy(String str, boolean z) {
        return new SchoolContactInfo(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SchoolContactInfo)) {
            return false;
        }
        SchoolContactInfo schoolContactInfo = (SchoolContactInfo) obj;
        return Intrinsics.areEqual(this.contactInfo, schoolContactInfo.contactInfo) && this.isPhone == schoolContactInfo.isPhone;
    }

    public int hashCode() {
        String str = this.contactInfo;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z = this.isPhone;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "SchoolContactInfo(contactInfo=" + this.contactInfo + ", isPhone=" + this.isPhone + ')';
    }

    public SchoolContactInfo(String str, boolean z) {
        this.contactInfo = str;
        this.isPhone = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SchoolContactInfo(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z);
    }

    public final String getContactInfo() {
        return this.contactInfo;
    }

    public final boolean isPhone() {
        return this.isPhone;
    }
}
