package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailPlatformContent;", "", "classRoom", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailClassRoom;", "(Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailClassRoom;)V", "getClassRoom", "()Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailClassRoom;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailInfoBean.kt */
public final class ShopClassDetailPlatformContent {
    private final ShopClassDetailClassRoom classRoom;

    public ShopClassDetailPlatformContent() {
        this((ShopClassDetailClassRoom) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopClassDetailPlatformContent copy$default(ShopClassDetailPlatformContent shopClassDetailPlatformContent, ShopClassDetailClassRoom shopClassDetailClassRoom, int i, Object obj) {
        if ((i & 1) != 0) {
            shopClassDetailClassRoom = shopClassDetailPlatformContent.classRoom;
        }
        return shopClassDetailPlatformContent.copy(shopClassDetailClassRoom);
    }

    public final ShopClassDetailClassRoom component1() {
        return this.classRoom;
    }

    public final ShopClassDetailPlatformContent copy(ShopClassDetailClassRoom shopClassDetailClassRoom) {
        return new ShopClassDetailPlatformContent(shopClassDetailClassRoom);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ShopClassDetailPlatformContent) && Intrinsics.areEqual((Object) this.classRoom, (Object) ((ShopClassDetailPlatformContent) obj).classRoom);
    }

    public int hashCode() {
        ShopClassDetailClassRoom shopClassDetailClassRoom = this.classRoom;
        if (shopClassDetailClassRoom == null) {
            return 0;
        }
        return shopClassDetailClassRoom.hashCode();
    }

    public String toString() {
        return "ShopClassDetailPlatformContent(classRoom=" + this.classRoom + ')';
    }

    public ShopClassDetailPlatformContent(ShopClassDetailClassRoom shopClassDetailClassRoom) {
        this.classRoom = shopClassDetailClassRoom;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopClassDetailPlatformContent(ShopClassDetailClassRoom shopClassDetailClassRoom, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : shopClassDetailClassRoom);
    }

    public final ShopClassDetailClassRoom getClassRoom() {
        return this.classRoom;
    }
}
