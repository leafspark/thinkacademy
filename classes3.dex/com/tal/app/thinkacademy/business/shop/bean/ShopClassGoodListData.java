package com.tal.app.thinkacademy.business.shop.bean;

import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassGoodListData;", "", "()V", "list", "", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassGoodsData;", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "total", "", "getTotal", "()I", "setTotal", "(I)V", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassData.kt */
public final class ShopClassGoodListData {
    private List<ShopClassGoodsData> list;
    private int total;

    public final int getTotal() {
        return this.total;
    }

    public final void setTotal(int i) {
        this.total = i;
    }

    public final List<ShopClassGoodsData> getList() {
        return this.list;
    }

    public final void setList(List<ShopClassGoodsData> list2) {
        this.list = list2;
    }
}
