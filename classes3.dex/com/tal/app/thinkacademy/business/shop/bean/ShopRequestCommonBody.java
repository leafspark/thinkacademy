package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0003\u001a\u00028\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopRequestCommonBody;", "T", "", "data", "header", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopRequestCommonHeader;", "(Ljava/lang/Object;Lcom/tal/app/thinkacademy/business/shop/bean/ShopRequestCommonHeader;)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getHeader", "()Lcom/tal/app/thinkacademy/business/shop/bean/ShopRequestCommonHeader;", "setHeader", "(Lcom/tal/app/thinkacademy/business/shop/bean/ShopRequestCommonHeader;)V", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopRequestCommonBody.kt */
public final class ShopRequestCommonBody<T> {
    private T data;
    private ShopRequestCommonHeader header;

    public ShopRequestCommonBody(T t, ShopRequestCommonHeader shopRequestCommonHeader) {
        this.data = t;
        this.header = shopRequestCommonHeader;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopRequestCommonBody(Object obj, ShopRequestCommonHeader shopRequestCommonHeader, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? null : shopRequestCommonHeader);
    }

    public final T getData() {
        return this.data;
    }

    public final void setData(T t) {
        this.data = t;
    }

    public final ShopRequestCommonHeader getHeader() {
        return this.header;
    }

    public final void setHeader(ShopRequestCommonHeader shopRequestCommonHeader) {
        this.header = shopRequestCommonHeader;
    }
}
