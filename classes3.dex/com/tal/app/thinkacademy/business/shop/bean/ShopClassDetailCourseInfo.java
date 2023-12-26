package com.tal.app.thinkacademy.business.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailCourseInfo;", "", "description", "", "syllabus", "", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailSyllabu;", "(Ljava/lang/String;Ljava/util/List;)V", "getDescription", "()Ljava/lang/String;", "getSyllabus", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailInfoBean.kt */
public final class ShopClassDetailCourseInfo {
    private final String description;
    private final List<ShopClassDetailSyllabu> syllabus;

    public ShopClassDetailCourseInfo() {
        this((String) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopClassDetailCourseInfo copy$default(ShopClassDetailCourseInfo shopClassDetailCourseInfo, String str, List<ShopClassDetailSyllabu> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopClassDetailCourseInfo.description;
        }
        if ((i & 2) != 0) {
            list = shopClassDetailCourseInfo.syllabus;
        }
        return shopClassDetailCourseInfo.copy(str, list);
    }

    public final String component1() {
        return this.description;
    }

    public final List<ShopClassDetailSyllabu> component2() {
        return this.syllabus;
    }

    public final ShopClassDetailCourseInfo copy(String str, List<ShopClassDetailSyllabu> list) {
        return new ShopClassDetailCourseInfo(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopClassDetailCourseInfo)) {
            return false;
        }
        ShopClassDetailCourseInfo shopClassDetailCourseInfo = (ShopClassDetailCourseInfo) obj;
        return Intrinsics.areEqual((Object) this.description, (Object) shopClassDetailCourseInfo.description) && Intrinsics.areEqual((Object) this.syllabus, (Object) shopClassDetailCourseInfo.syllabus);
    }

    public int hashCode() {
        String str = this.description;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<ShopClassDetailSyllabu> list = this.syllabus;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ShopClassDetailCourseInfo(description=" + this.description + ", syllabus=" + this.syllabus + ')';
    }

    public ShopClassDetailCourseInfo(String str, List<ShopClassDetailSyllabu> list) {
        this.description = str;
        this.syllabus = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopClassDetailCourseInfo(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list);
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<ShopClassDetailSyllabu> getSyllabus() {
        return this.syllabus;
    }
}
