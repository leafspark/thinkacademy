package com.tal.app.thinkacademy.business.shop.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.tal.app.thinkacademy.business.shop.classdetail.ShopClassDetailItemType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u000eHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailOperation;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "dynamic", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailDynamic;", "staticData", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailStaticData;", "version", "", "(Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailDynamic;Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailStaticData;Ljava/lang/String;)V", "getDynamic", "()Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailDynamic;", "setDynamic", "(Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailDynamic;)V", "itemType", "", "getItemType", "()I", "getStaticData", "()Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailStaticData;", "getVersion", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailInfoBean.kt */
public final class ShopClassDetailOperation implements MultiItemEntity {
    private ShopClassDetailDynamic dynamic;
    private final ShopClassDetailStaticData staticData;
    private final String version;

    public ShopClassDetailOperation() {
        this((ShopClassDetailDynamic) null, (ShopClassDetailStaticData) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopClassDetailOperation copy$default(ShopClassDetailOperation shopClassDetailOperation, ShopClassDetailDynamic shopClassDetailDynamic, ShopClassDetailStaticData shopClassDetailStaticData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            shopClassDetailDynamic = shopClassDetailOperation.dynamic;
        }
        if ((i & 2) != 0) {
            shopClassDetailStaticData = shopClassDetailOperation.staticData;
        }
        if ((i & 4) != 0) {
            str = shopClassDetailOperation.version;
        }
        return shopClassDetailOperation.copy(shopClassDetailDynamic, shopClassDetailStaticData, str);
    }

    public final ShopClassDetailDynamic component1() {
        return this.dynamic;
    }

    public final ShopClassDetailStaticData component2() {
        return this.staticData;
    }

    public final String component3() {
        return this.version;
    }

    public final ShopClassDetailOperation copy(ShopClassDetailDynamic shopClassDetailDynamic, ShopClassDetailStaticData shopClassDetailStaticData, String str) {
        return new ShopClassDetailOperation(shopClassDetailDynamic, shopClassDetailStaticData, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopClassDetailOperation)) {
            return false;
        }
        ShopClassDetailOperation shopClassDetailOperation = (ShopClassDetailOperation) obj;
        return Intrinsics.areEqual((Object) this.dynamic, (Object) shopClassDetailOperation.dynamic) && Intrinsics.areEqual((Object) this.staticData, (Object) shopClassDetailOperation.staticData) && Intrinsics.areEqual((Object) this.version, (Object) shopClassDetailOperation.version);
    }

    public int hashCode() {
        ShopClassDetailDynamic shopClassDetailDynamic = this.dynamic;
        int i = 0;
        int hashCode = (shopClassDetailDynamic == null ? 0 : shopClassDetailDynamic.hashCode()) * 31;
        ShopClassDetailStaticData shopClassDetailStaticData = this.staticData;
        int hashCode2 = (hashCode + (shopClassDetailStaticData == null ? 0 : shopClassDetailStaticData.hashCode())) * 31;
        String str = this.version;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ShopClassDetailOperation(dynamic=" + this.dynamic + ", staticData=" + this.staticData + ", version=" + this.version + ')';
    }

    public ShopClassDetailOperation(ShopClassDetailDynamic shopClassDetailDynamic, ShopClassDetailStaticData shopClassDetailStaticData, String str) {
        this.dynamic = shopClassDetailDynamic;
        this.staticData = shopClassDetailStaticData;
        this.version = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopClassDetailOperation(ShopClassDetailDynamic shopClassDetailDynamic, ShopClassDetailStaticData shopClassDetailStaticData, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : shopClassDetailDynamic, (i & 2) != 0 ? null : shopClassDetailStaticData, (i & 4) != 0 ? null : str);
    }

    public final ShopClassDetailDynamic getDynamic() {
        return this.dynamic;
    }

    public final void setDynamic(ShopClassDetailDynamic shopClassDetailDynamic) {
        this.dynamic = shopClassDetailDynamic;
    }

    public final ShopClassDetailStaticData getStaticData() {
        return this.staticData;
    }

    public final String getVersion() {
        return this.version;
    }

    public int getItemType() {
        return ShopClassDetailItemType.CourseHighlights.getType();
    }
}
