package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailHighlight;", "", "content", "", "id", "", "title", "(Ljava/lang/String;ILjava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getId", "()I", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailInfoBean.kt */
public final class ShopClassDetailHighlight {
    private final String content;
    private final int id;
    private final String title;

    public ShopClassDetailHighlight() {
        this((String) null, 0, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopClassDetailHighlight copy$default(ShopClassDetailHighlight shopClassDetailHighlight, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = shopClassDetailHighlight.content;
        }
        if ((i2 & 2) != 0) {
            i = shopClassDetailHighlight.id;
        }
        if ((i2 & 4) != 0) {
            str2 = shopClassDetailHighlight.title;
        }
        return shopClassDetailHighlight.copy(str, i, str2);
    }

    public final String component1() {
        return this.content;
    }

    public final int component2() {
        return this.id;
    }

    public final String component3() {
        return this.title;
    }

    public final ShopClassDetailHighlight copy(String str, int i, String str2) {
        return new ShopClassDetailHighlight(str, i, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopClassDetailHighlight)) {
            return false;
        }
        ShopClassDetailHighlight shopClassDetailHighlight = (ShopClassDetailHighlight) obj;
        return Intrinsics.areEqual((Object) this.content, (Object) shopClassDetailHighlight.content) && this.id == shopClassDetailHighlight.id && Intrinsics.areEqual((Object) this.title, (Object) shopClassDetailHighlight.title);
    }

    public int hashCode() {
        String str = this.content;
        int i = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.id) * 31;
        String str2 = this.title;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ShopClassDetailHighlight(content=" + this.content + ", id=" + this.id + ", title=" + this.title + ')';
    }

    public ShopClassDetailHighlight(String str, int i, String str2) {
        this.content = str;
        this.id = i;
        this.title = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopClassDetailHighlight(String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : str2);
    }

    public final String getContent() {
        return this.content;
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }
}
