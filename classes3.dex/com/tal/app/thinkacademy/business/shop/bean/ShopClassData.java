package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassData;", "", "()V", "filter", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassFilterData;", "getFilter", "()Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassFilterData;", "setFilter", "(Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassFilterData;)V", "goodsList", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassGoodListData;", "getGoodsList", "()Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassGoodListData;", "setGoodsList", "(Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassGoodListData;)V", "id", "", "getId", "()I", "setId", "(I)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassData.kt */
public final class ShopClassData {
    private ShopClassFilterData filter;
    private ShopClassGoodListData goodsList;
    private int id;
    private String name;

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final ShopClassFilterData getFilter() {
        return this.filter;
    }

    public final void setFilter(ShopClassFilterData shopClassFilterData) {
        this.filter = shopClassFilterData;
    }

    public final ShopClassGoodListData getGoodsList() {
        return this.goodsList;
    }

    public final void setGoodsList(ShopClassGoodListData shopClassGoodListData) {
        this.goodsList = shopClassGoodListData;
    }
}
