package com.tal.app.thinkacademy.business.shop.bean.request;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/request/WishRequestBean;", "", "skuList", "", "", "(Ljava/util/List;)V", "getSkuList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WishRequestBean.kt */
public final class WishRequestBean {
    private final List<String> skuList;

    public WishRequestBean() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WishRequestBean copy$default(WishRequestBean wishRequestBean, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = wishRequestBean.skuList;
        }
        return wishRequestBean.copy(list);
    }

    public final List<String> component1() {
        return this.skuList;
    }

    public final WishRequestBean copy(List<String> list) {
        return new WishRequestBean(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WishRequestBean) && Intrinsics.areEqual((Object) this.skuList, (Object) ((WishRequestBean) obj).skuList);
    }

    public int hashCode() {
        List<String> list = this.skuList;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "WishRequestBean(skuList=" + this.skuList + ')';
    }

    public WishRequestBean(List<String> list) {
        this.skuList = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WishRequestBean(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public final List<String> getSkuList() {
        return this.skuList;
    }
}
