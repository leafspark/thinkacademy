package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopDetailPositionLocationInfo;", "", "position", "", "tabIndex", "tabNameResId", "(III)V", "getPosition", "()I", "setPosition", "(I)V", "getTabIndex", "setTabIndex", "getTabNameResId", "setTabNameResId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailInfoBean.kt */
public final class ShopDetailPositionLocationInfo {
    private int position;
    private int tabIndex;
    private int tabNameResId;

    public static /* synthetic */ ShopDetailPositionLocationInfo copy$default(ShopDetailPositionLocationInfo shopDetailPositionLocationInfo, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = shopDetailPositionLocationInfo.position;
        }
        if ((i4 & 2) != 0) {
            i2 = shopDetailPositionLocationInfo.tabIndex;
        }
        if ((i4 & 4) != 0) {
            i3 = shopDetailPositionLocationInfo.tabNameResId;
        }
        return shopDetailPositionLocationInfo.copy(i, i2, i3);
    }

    public final int component1() {
        return this.position;
    }

    public final int component2() {
        return this.tabIndex;
    }

    public final int component3() {
        return this.tabNameResId;
    }

    public final ShopDetailPositionLocationInfo copy(int i, int i2, int i3) {
        return new ShopDetailPositionLocationInfo(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopDetailPositionLocationInfo)) {
            return false;
        }
        ShopDetailPositionLocationInfo shopDetailPositionLocationInfo = (ShopDetailPositionLocationInfo) obj;
        return this.position == shopDetailPositionLocationInfo.position && this.tabIndex == shopDetailPositionLocationInfo.tabIndex && this.tabNameResId == shopDetailPositionLocationInfo.tabNameResId;
    }

    public int hashCode() {
        return (((this.position * 31) + this.tabIndex) * 31) + this.tabNameResId;
    }

    public String toString() {
        return "ShopDetailPositionLocationInfo(position=" + this.position + ", tabIndex=" + this.tabIndex + ", tabNameResId=" + this.tabNameResId + ')';
    }

    public ShopDetailPositionLocationInfo(int i, int i2, int i3) {
        this.position = i;
        this.tabIndex = i2;
        this.tabNameResId = i3;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final int getTabIndex() {
        return this.tabIndex;
    }

    public final void setTabIndex(int i) {
        this.tabIndex = i;
    }

    public final int getTabNameResId() {
        return this.tabNameResId;
    }

    public final void setTabNameResId(int i) {
        this.tabNameResId = i;
    }
}
