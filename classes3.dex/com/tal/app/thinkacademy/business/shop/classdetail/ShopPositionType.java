package com.tal.app.thinkacademy.business.shop.classdetail;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopPositionType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "First", "Normal", "Last", "ONLY_ONE", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailItemType.kt */
public enum ShopPositionType {
    First(0),
    Normal(1),
    Last(2),
    ONLY_ONE(3);
    
    private final int type;

    private ShopPositionType(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }
}
