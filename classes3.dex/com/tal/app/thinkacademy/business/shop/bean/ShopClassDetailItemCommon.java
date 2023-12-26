package com.tal.app.thinkacademy.business.shop.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.tal.app.thinkacademy.business.shop.classdetail.ShopPositionType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000b\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailItemCommon;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "itemType", "", "data", "", "local_position_type", "(ILjava/lang/Object;I)V", "getData", "()Ljava/lang/Object;", "getItemType", "()I", "getLocal_position_type", "setLocal_position_type", "(I)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailInfoBean.kt */
public final class ShopClassDetailItemCommon implements MultiItemEntity {
    private final Object data;
    private final int itemType;
    private int local_position_type;

    public static /* synthetic */ ShopClassDetailItemCommon copy$default(ShopClassDetailItemCommon shopClassDetailItemCommon, int i, Object obj, int i2, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            i = shopClassDetailItemCommon.getItemType();
        }
        if ((i3 & 2) != 0) {
            obj = shopClassDetailItemCommon.data;
        }
        if ((i3 & 4) != 0) {
            i2 = shopClassDetailItemCommon.local_position_type;
        }
        return shopClassDetailItemCommon.copy(i, obj, i2);
    }

    public final int component1() {
        return getItemType();
    }

    public final Object component2() {
        return this.data;
    }

    public final int component3() {
        return this.local_position_type;
    }

    public final ShopClassDetailItemCommon copy(int i, Object obj, int i2) {
        return new ShopClassDetailItemCommon(i, obj, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopClassDetailItemCommon)) {
            return false;
        }
        ShopClassDetailItemCommon shopClassDetailItemCommon = (ShopClassDetailItemCommon) obj;
        return getItemType() == shopClassDetailItemCommon.getItemType() && Intrinsics.areEqual(this.data, shopClassDetailItemCommon.data) && this.local_position_type == shopClassDetailItemCommon.local_position_type;
    }

    public int hashCode() {
        int itemType2 = getItemType() * 31;
        Object obj = this.data;
        return ((itemType2 + (obj == null ? 0 : obj.hashCode())) * 31) + this.local_position_type;
    }

    public String toString() {
        return "ShopClassDetailItemCommon(itemType=" + getItemType() + ", data=" + this.data + ", local_position_type=" + this.local_position_type + ')';
    }

    public ShopClassDetailItemCommon(int i, Object obj, int i2) {
        this.itemType = i;
        this.data = obj;
        this.local_position_type = i2;
    }

    public int getItemType() {
        return this.itemType;
    }

    public final Object getData() {
        return this.data;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopClassDetailItemCommon(int i, Object obj, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? null : obj, (i3 & 4) != 0 ? ShopPositionType.Normal.getType() : i2);
    }

    public final int getLocal_position_type() {
        return this.local_position_type;
    }

    public final void setLocal_position_type(int i) {
        this.local_position_type = i;
    }
}
