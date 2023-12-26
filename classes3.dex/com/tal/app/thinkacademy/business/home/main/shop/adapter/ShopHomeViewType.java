package com.tal.app.thinkacademy.business.home.main.shop.adapter;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/adapter/ShopHomeViewType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ROOT_TITLE", "ROOT_VIEW_MORE", "ROOT_VIEW_FOOT", "ITEM_NORMAL_CARD", "ITEM_NORMAL_CARD_CTA", "ITEM_ClASS_CARD", "RECORDED_CLASS_CARD", "RECORDED_CLASS_GOODS_CARD", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeViewType.kt */
public enum ShopHomeViewType {
    ROOT_TITLE(0),
    ROOT_VIEW_MORE(1),
    ROOT_VIEW_FOOT(2),
    ITEM_NORMAL_CARD(3),
    ITEM_NORMAL_CARD_CTA(4),
    ITEM_ClASS_CARD(5),
    RECORDED_CLASS_CARD(6),
    RECORDED_CLASS_GOODS_CARD(7);
    
    private final int value;

    private ShopHomeViewType(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
