package com.tal.app.thinkacademy.business.shop.bean.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/request/TaxCategoryBean;", "", "categoryId", "", "sellPrice", "skuId", "(III)V", "getCategoryId", "()I", "setCategoryId", "(I)V", "getSellPrice", "setSellPrice", "getSkuId", "setSkuId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: QueryCategoryTaxRequest.kt */
public final class TaxCategoryBean {
    private int categoryId;
    private int sellPrice;
    private int skuId;

    public TaxCategoryBean() {
        this(0, 0, 0, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TaxCategoryBean copy$default(TaxCategoryBean taxCategoryBean, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = taxCategoryBean.categoryId;
        }
        if ((i4 & 2) != 0) {
            i2 = taxCategoryBean.sellPrice;
        }
        if ((i4 & 4) != 0) {
            i3 = taxCategoryBean.skuId;
        }
        return taxCategoryBean.copy(i, i2, i3);
    }

    public final int component1() {
        return this.categoryId;
    }

    public final int component2() {
        return this.sellPrice;
    }

    public final int component3() {
        return this.skuId;
    }

    public final TaxCategoryBean copy(int i, int i2, int i3) {
        return new TaxCategoryBean(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TaxCategoryBean)) {
            return false;
        }
        TaxCategoryBean taxCategoryBean = (TaxCategoryBean) obj;
        return this.categoryId == taxCategoryBean.categoryId && this.sellPrice == taxCategoryBean.sellPrice && this.skuId == taxCategoryBean.skuId;
    }

    public int hashCode() {
        return (((this.categoryId * 31) + this.sellPrice) * 31) + this.skuId;
    }

    public String toString() {
        return "TaxCategoryBean(categoryId=" + this.categoryId + ", sellPrice=" + this.sellPrice + ", skuId=" + this.skuId + ')';
    }

    public TaxCategoryBean(int i, int i2, int i3) {
        this.categoryId = i;
        this.sellPrice = i2;
        this.skuId = i3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TaxCategoryBean(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    public final int getCategoryId() {
        return this.categoryId;
    }

    public final void setCategoryId(int i) {
        this.categoryId = i;
    }

    public final int getSellPrice() {
        return this.sellPrice;
    }

    public final void setSellPrice(int i) {
        this.sellPrice = i;
    }

    public final int getSkuId() {
        return this.skuId;
    }

    public final void setSkuId(int i) {
        this.skuId = i;
    }
}
