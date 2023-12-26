package com.tal.app.thinkacademy.business.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003JJ\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopRecordedItemData;", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopItemRecordedCardNode;", "id", "", "title", "", "showOrgPrice", "", "showPrice", "spec", "Lcom/tal/app/thinkacademy/business/shop/bean/RecordedSpec;", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tal/app/thinkacademy/business/shop/bean/RecordedSpec;)V", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getShowOrgPrice", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShowPrice", "getSpec", "()Lcom/tal/app/thinkacademy/business/shop/bean/RecordedSpec;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tal/app/thinkacademy/business/shop/bean/RecordedSpec;)Lcom/tal/app/thinkacademy/business/shop/bean/ShopRecordedItemData;", "equals", "", "other", "", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopRecordedItemData.kt */
public final class ShopRecordedItemData extends ShopItemRecordedCardNode {
    private final Long id;
    private final Integer showOrgPrice;
    private final Integer showPrice;
    private final RecordedSpec spec;
    private final String title;

    public ShopRecordedItemData() {
        this((Long) null, (String) null, (Integer) null, (Integer) null, (RecordedSpec) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopRecordedItemData copy$default(ShopRecordedItemData shopRecordedItemData, Long l, String str, Integer num, Integer num2, RecordedSpec recordedSpec, int i, Object obj) {
        if ((i & 1) != 0) {
            l = shopRecordedItemData.id;
        }
        if ((i & 2) != 0) {
            str = shopRecordedItemData.title;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            num = shopRecordedItemData.showOrgPrice;
        }
        Integer num3 = num;
        if ((i & 8) != 0) {
            num2 = shopRecordedItemData.showPrice;
        }
        Integer num4 = num2;
        if ((i & 16) != 0) {
            recordedSpec = shopRecordedItemData.spec;
        }
        return shopRecordedItemData.copy(l, str2, num3, num4, recordedSpec);
    }

    public final Long component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final Integer component3() {
        return this.showOrgPrice;
    }

    public final Integer component4() {
        return this.showPrice;
    }

    public final RecordedSpec component5() {
        return this.spec;
    }

    public final ShopRecordedItemData copy(Long l, String str, Integer num, Integer num2, RecordedSpec recordedSpec) {
        return new ShopRecordedItemData(l, str, num, num2, recordedSpec);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopRecordedItemData)) {
            return false;
        }
        ShopRecordedItemData shopRecordedItemData = (ShopRecordedItemData) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) shopRecordedItemData.id) && Intrinsics.areEqual((Object) this.title, (Object) shopRecordedItemData.title) && Intrinsics.areEqual((Object) this.showOrgPrice, (Object) shopRecordedItemData.showOrgPrice) && Intrinsics.areEqual((Object) this.showPrice, (Object) shopRecordedItemData.showPrice) && Intrinsics.areEqual((Object) this.spec, (Object) shopRecordedItemData.spec);
    }

    public int hashCode() {
        Long l = this.id;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.showOrgPrice;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.showPrice;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        RecordedSpec recordedSpec = this.spec;
        if (recordedSpec != null) {
            i = recordedSpec.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "ShopRecordedItemData(id=" + this.id + ", title=" + this.title + ", showOrgPrice=" + this.showOrgPrice + ", showPrice=" + this.showPrice + ", spec=" + this.spec + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShopRecordedItemData(java.lang.Long r4, java.lang.String r5, java.lang.Integer r6, java.lang.Integer r7, com.tal.app.thinkacademy.business.shop.bean.RecordedSpec r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x000a
            r0 = 0
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
        L_0x000a:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x0010
            java.lang.String r5 = ""
        L_0x0010:
            r10 = r5
            r5 = r9 & 4
            r0 = 0
            if (r5 == 0) goto L_0x001a
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)
        L_0x001a:
            r1 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x0023
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
        L_0x0023:
            r0 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0029
            r8 = 0
        L_0x0029:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r1
            r9 = r0
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.ShopRecordedItemData.<init>(java.lang.Long, java.lang.String, java.lang.Integer, java.lang.Integer, com.tal.app.thinkacademy.business.shop.bean.RecordedSpec, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Long getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getShowOrgPrice() {
        return this.showOrgPrice;
    }

    public final Integer getShowPrice() {
        return this.showPrice;
    }

    public final RecordedSpec getSpec() {
        return this.spec;
    }

    public ShopRecordedItemData(Long l, String str, Integer num, Integer num2, RecordedSpec recordedSpec) {
        super((List) null, 1, (DefaultConstructorMarker) null);
        this.id = l;
        this.title = str;
        this.showOrgPrice = num;
        this.showPrice = num2;
        this.spec = recordedSpec;
    }
}
