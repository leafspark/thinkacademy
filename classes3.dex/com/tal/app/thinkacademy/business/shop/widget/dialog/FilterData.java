package com.tal.app.thinkacademy.business.shop.widget.dialog;

import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassTeacherData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J7\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0000J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006%"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/widget/dialog/FilterData;", "", "day", "", "time", "teacher", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassTeacherData;", "checked", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassTeacherData;Z)V", "getChecked", "()Z", "setChecked", "(Z)V", "getDay", "()Ljava/lang/String;", "setDay", "(Ljava/lang/String;)V", "getTeacher", "()Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassTeacherData;", "setTeacher", "(Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassTeacherData;)V", "getTime", "setTime", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "merge", "", "data", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassFilterDialog.kt */
final class FilterData {
    private boolean checked;
    private String day;
    private ShopClassTeacherData teacher;
    private String time;

    public FilterData() {
        this((String) null, (String) null, (ShopClassTeacherData) null, false, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FilterData copy$default(FilterData filterData, String str, String str2, ShopClassTeacherData shopClassTeacherData, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = filterData.day;
        }
        if ((i & 2) != 0) {
            str2 = filterData.time;
        }
        if ((i & 4) != 0) {
            shopClassTeacherData = filterData.teacher;
        }
        if ((i & 8) != 0) {
            z = filterData.checked;
        }
        return filterData.copy(str, str2, shopClassTeacherData, z);
    }

    public final String component1() {
        return this.day;
    }

    public final String component2() {
        return this.time;
    }

    public final ShopClassTeacherData component3() {
        return this.teacher;
    }

    public final boolean component4() {
        return this.checked;
    }

    public final FilterData copy(String str, String str2, ShopClassTeacherData shopClassTeacherData, boolean z) {
        return new FilterData(str, str2, shopClassTeacherData, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterData)) {
            return false;
        }
        FilterData filterData = (FilterData) obj;
        return Intrinsics.areEqual((Object) this.day, (Object) filterData.day) && Intrinsics.areEqual((Object) this.time, (Object) filterData.time) && Intrinsics.areEqual((Object) this.teacher, (Object) filterData.teacher) && this.checked == filterData.checked;
    }

    public int hashCode() {
        String str = this.day;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.time;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ShopClassTeacherData shopClassTeacherData = this.teacher;
        if (shopClassTeacherData != null) {
            i = shopClassTeacherData.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.checked;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        return "FilterData(day=" + this.day + ", time=" + this.time + ", teacher=" + this.teacher + ", checked=" + this.checked + ')';
    }

    public FilterData(String str, String str2, ShopClassTeacherData shopClassTeacherData, boolean z) {
        this.day = str;
        this.time = str2;
        this.teacher = shopClassTeacherData;
        this.checked = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FilterData(String str, String str2, ShopClassTeacherData shopClassTeacherData, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : shopClassTeacherData, (i & 8) != 0 ? false : z);
    }

    public final String getDay() {
        return this.day;
    }

    public final void setDay(String str) {
        this.day = str;
    }

    public final String getTime() {
        return this.time;
    }

    public final void setTime(String str) {
        this.time = str;
    }

    public final ShopClassTeacherData getTeacher() {
        return this.teacher;
    }

    public final void setTeacher(ShopClassTeacherData shopClassTeacherData) {
        this.teacher = shopClassTeacherData;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final void setChecked(boolean z) {
        this.checked = z;
    }

    public final void merge(FilterData filterData) {
        Intrinsics.checkNotNullParameter(filterData, DbParams.KEY_DATA);
        this.day = filterData.day;
        this.time = filterData.time;
        this.teacher = filterData.teacher;
        this.checked = filterData.checked;
    }
}
