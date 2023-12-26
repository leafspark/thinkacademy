package com.tal.app.thinkacademy.business.login.view.item;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/item/SchoolItem;", "", "country", "", "resFlag", "schoolCode", "isChecked", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getCountry", "()Ljava/lang/String;", "setCountry", "(Ljava/lang/String;)V", "()Z", "setChecked", "(Z)V", "getResFlag", "setResFlag", "getSchoolCode", "setSchoolCode", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchoolItem.kt */
public final class SchoolItem {
    private String country;
    private boolean isChecked;
    private String resFlag;
    private String schoolCode;

    public static /* synthetic */ SchoolItem copy$default(SchoolItem schoolItem, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = schoolItem.country;
        }
        if ((i & 2) != 0) {
            str2 = schoolItem.resFlag;
        }
        if ((i & 4) != 0) {
            str3 = schoolItem.schoolCode;
        }
        if ((i & 8) != 0) {
            z = schoolItem.isChecked;
        }
        return schoolItem.copy(str, str2, str3, z);
    }

    public final String component1() {
        return this.country;
    }

    public final String component2() {
        return this.resFlag;
    }

    public final String component3() {
        return this.schoolCode;
    }

    public final boolean component4() {
        return this.isChecked;
    }

    public final SchoolItem copy(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "country");
        Intrinsics.checkNotNullParameter(str2, "resFlag");
        Intrinsics.checkNotNullParameter(str3, "schoolCode");
        return new SchoolItem(str, str2, str3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SchoolItem)) {
            return false;
        }
        SchoolItem schoolItem = (SchoolItem) obj;
        return Intrinsics.areEqual((Object) this.country, (Object) schoolItem.country) && Intrinsics.areEqual((Object) this.resFlag, (Object) schoolItem.resFlag) && Intrinsics.areEqual((Object) this.schoolCode, (Object) schoolItem.schoolCode) && this.isChecked == schoolItem.isChecked;
    }

    public int hashCode() {
        int hashCode = ((((this.country.hashCode() * 31) + this.resFlag.hashCode()) * 31) + this.schoolCode.hashCode()) * 31;
        boolean z = this.isChecked;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "SchoolItem(country=" + this.country + ", resFlag=" + this.resFlag + ", schoolCode=" + this.schoolCode + ", isChecked=" + this.isChecked + ')';
    }

    public SchoolItem(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "country");
        Intrinsics.checkNotNullParameter(str2, "resFlag");
        Intrinsics.checkNotNullParameter(str3, "schoolCode");
        this.country = str;
        this.resFlag = str2;
        this.schoolCode = str3;
        this.isChecked = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SchoolItem(String str, String str2, String str3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? false : z);
    }

    public final String getCountry() {
        return this.country;
    }

    public final void setCountry(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.country = str;
    }

    public final String getResFlag() {
        return this.resFlag;
    }

    public final void setResFlag(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.resFlag = str;
    }

    public final String getSchoolCode() {
        return this.schoolCode;
    }

    public final void setSchoolCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.schoolCode = str;
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final void setChecked(boolean z) {
        this.isChecked = z;
    }
}
