package com.tal.app.thinkacademy.business.home.main.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeBodyDataSpecValue;", "", "specId", "", "specValue", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getSpecId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSpecValue", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeBodyDataSpecValue;", "equals", "", "other", "hashCode", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeBody.kt */
public final class ShopHomeBodyDataSpecValue {
    private final Integer specId;
    private final Integer specValue;

    public static /* synthetic */ ShopHomeBodyDataSpecValue copy$default(ShopHomeBodyDataSpecValue shopHomeBodyDataSpecValue, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = shopHomeBodyDataSpecValue.specId;
        }
        if ((i & 2) != 0) {
            num2 = shopHomeBodyDataSpecValue.specValue;
        }
        return shopHomeBodyDataSpecValue.copy(num, num2);
    }

    public final Integer component1() {
        return this.specId;
    }

    public final Integer component2() {
        return this.specValue;
    }

    public final ShopHomeBodyDataSpecValue copy(Integer num, Integer num2) {
        return new ShopHomeBodyDataSpecValue(num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopHomeBodyDataSpecValue)) {
            return false;
        }
        ShopHomeBodyDataSpecValue shopHomeBodyDataSpecValue = (ShopHomeBodyDataSpecValue) obj;
        return Intrinsics.areEqual((Object) this.specId, (Object) shopHomeBodyDataSpecValue.specId) && Intrinsics.areEqual((Object) this.specValue, (Object) shopHomeBodyDataSpecValue.specValue);
    }

    public int hashCode() {
        Integer num = this.specId;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.specValue;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ShopHomeBodyDataSpecValue(specId=" + this.specId + ", specValue=" + this.specValue + ')';
    }

    public ShopHomeBodyDataSpecValue(Integer num, Integer num2) {
        this.specId = num;
        this.specValue = num2;
    }

    public final Integer getSpecId() {
        return this.specId;
    }

    public final Integer getSpecValue() {
        return this.specValue;
    }
}
