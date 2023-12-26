package com.tal.app.thinkacademy.business.shop.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType;
import com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ$\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0007\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailCourseDetailPic;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "url", "", "local_position_type", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "itemType", "getItemType", "()I", "getLocal_position_type", "()Ljava/lang/Integer;", "setLocal_position_type", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailCourseDetailPic;", "equals", "", "other", "", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailInfoBean.kt */
public final class ShopClassDetailCourseDetailPic implements MultiItemEntity {
    private Integer local_position_type;
    private String url;

    public static /* synthetic */ ShopClassDetailCourseDetailPic copy$default(ShopClassDetailCourseDetailPic shopClassDetailCourseDetailPic, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopClassDetailCourseDetailPic.url;
        }
        if ((i & 2) != 0) {
            num = shopClassDetailCourseDetailPic.local_position_type;
        }
        return shopClassDetailCourseDetailPic.copy(str, num);
    }

    public final String component1() {
        return this.url;
    }

    public final Integer component2() {
        return this.local_position_type;
    }

    public final ShopClassDetailCourseDetailPic copy(String str, Integer num) {
        Intrinsics.checkNotNullParameter(str, "url");
        return new ShopClassDetailCourseDetailPic(str, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopClassDetailCourseDetailPic)) {
            return false;
        }
        ShopClassDetailCourseDetailPic shopClassDetailCourseDetailPic = (ShopClassDetailCourseDetailPic) obj;
        return Intrinsics.areEqual((Object) this.url, (Object) shopClassDetailCourseDetailPic.url) && Intrinsics.areEqual((Object) this.local_position_type, (Object) shopClassDetailCourseDetailPic.local_position_type);
    }

    public int hashCode() {
        int hashCode = this.url.hashCode() * 31;
        Integer num = this.local_position_type;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "ShopClassDetailCourseDetailPic(url=" + this.url + ", local_position_type=" + this.local_position_type + ')';
    }

    public ShopClassDetailCourseDetailPic(String str, Integer num) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.url = str;
        this.local_position_type = num;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopClassDetailCourseDetailPic(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? Integer.valueOf(ShopPositionType.Normal.getType()) : num);
    }

    public final Integer getLocal_position_type() {
        return this.local_position_type;
    }

    public final void setLocal_position_type(Integer num) {
        this.local_position_type = num;
    }

    public int getItemType() {
        return ShopClassDetailItemType.CourseDetailInfo.getType();
    }
}
