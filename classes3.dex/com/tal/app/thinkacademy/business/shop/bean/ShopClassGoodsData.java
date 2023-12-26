package com.tal.app.thinkacademy.business.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\u001c\u00100\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\b¨\u00063"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassGoodsData;", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopItemClassCardNode;", "()V", "description", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "id", "", "getId", "()I", "setId", "(I)V", "online", "", "getOnline", "()Z", "setOnline", "(Z)V", "orgPrice", "getOrgPrice", "setOrgPrice", "perOrgPrice", "getPerOrgPrice", "setPerOrgPrice", "perShowPrice", "getPerShowPrice", "setPerShowPrice", "remainSellTime", "getRemainSellTime", "setRemainSellTime", "sellStore", "getSellStore", "setSellStore", "showPrice", "getShowPrice", "setShowPrice", "spec", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassGoodsSpecData;", "getSpec", "()Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassGoodsSpecData;", "setSpec", "(Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassGoodsSpecData;)V", "store", "getStore", "setStore", "title", "getTitle", "setTitle", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassData.kt */
public final class ShopClassGoodsData extends ShopItemClassCardNode {
    private String description;
    private int id;
    private boolean online;
    private int orgPrice;
    private int perOrgPrice;
    private int perShowPrice;
    private int remainSellTime;
    private int sellStore;
    private int showPrice;
    private ShopClassGoodsSpecData spec;
    private int store;
    private String title;

    public ShopClassGoodsData() {
        super((List) null, 1, (DefaultConstructorMarker) null);
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final int getStore() {
        return this.store;
    }

    public final void setStore(int i) {
        this.store = i;
    }

    public final int getSellStore() {
        return this.sellStore;
    }

    public final void setSellStore(int i) {
        this.sellStore = i;
    }

    public final int getShowPrice() {
        return this.showPrice;
    }

    public final void setShowPrice(int i) {
        this.showPrice = i;
    }

    public final int getPerShowPrice() {
        return this.perShowPrice;
    }

    public final void setPerShowPrice(int i) {
        this.perShowPrice = i;
    }

    public final int getOrgPrice() {
        return this.orgPrice;
    }

    public final void setOrgPrice(int i) {
        this.orgPrice = i;
    }

    public final int getPerOrgPrice() {
        return this.perOrgPrice;
    }

    public final void setPerOrgPrice(int i) {
        this.perOrgPrice = i;
    }

    public final int getRemainSellTime() {
        return this.remainSellTime;
    }

    public final void setRemainSellTime(int i) {
        this.remainSellTime = i;
    }

    public final boolean getOnline() {
        return this.online;
    }

    public final void setOnline(boolean z) {
        this.online = z;
    }

    public final ShopClassGoodsSpecData getSpec() {
        return this.spec;
    }

    public final void setSpec(ShopClassGoodsSpecData shopClassGoodsSpecData) {
        this.spec = shopClassGoodsSpecData;
    }
}
