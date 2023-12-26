package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailGrade;", "", "id", "", "name", "", "order", "(ILjava/lang/String;I)V", "getId", "()I", "getName", "()Ljava/lang/String;", "getOrder", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailInfoBean.kt */
public final class ShopClassDetailGrade {
    private final int id;
    private final String name;
    private final int order;

    public ShopClassDetailGrade() {
        this(0, (String) null, 0, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopClassDetailGrade copy$default(ShopClassDetailGrade shopClassDetailGrade, int i, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = shopClassDetailGrade.id;
        }
        if ((i3 & 2) != 0) {
            str = shopClassDetailGrade.name;
        }
        if ((i3 & 4) != 0) {
            i2 = shopClassDetailGrade.order;
        }
        return shopClassDetailGrade.copy(i, str, i2);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.order;
    }

    public final ShopClassDetailGrade copy(int i, String str, int i2) {
        return new ShopClassDetailGrade(i, str, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopClassDetailGrade)) {
            return false;
        }
        ShopClassDetailGrade shopClassDetailGrade = (ShopClassDetailGrade) obj;
        return this.id == shopClassDetailGrade.id && Intrinsics.areEqual((Object) this.name, (Object) shopClassDetailGrade.name) && this.order == shopClassDetailGrade.order;
    }

    public int hashCode() {
        int i = this.id * 31;
        String str = this.name;
        return ((i + (str == null ? 0 : str.hashCode())) * 31) + this.order;
    }

    public String toString() {
        return "ShopClassDetailGrade(id=" + this.id + ", name=" + this.name + ", order=" + this.order + ')';
    }

    public ShopClassDetailGrade(int i, String str, int i2) {
        this.id = i;
        this.name = str;
        this.order = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopClassDetailGrade(int i, String str, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? 0 : i2);
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final int getOrder() {
        return this.order;
    }
}
