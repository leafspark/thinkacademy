package com.tal.app.thinkacademy.business.home.main.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeDataModuleContent;", "", "content", "", "id", "", "type", "shortName", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShortName", "setShortName", "(Ljava/lang/String;)V", "getType", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeDataModuleContent;", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeData.kt */
public final class ShopHomeDataModuleContent {
    private final String content;
    private final Integer id;
    private String shortName;
    private final Integer type;

    public static /* synthetic */ ShopHomeDataModuleContent copy$default(ShopHomeDataModuleContent shopHomeDataModuleContent, String str, Integer num, Integer num2, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopHomeDataModuleContent.content;
        }
        if ((i & 2) != 0) {
            num = shopHomeDataModuleContent.id;
        }
        if ((i & 4) != 0) {
            num2 = shopHomeDataModuleContent.type;
        }
        if ((i & 8) != 0) {
            str2 = shopHomeDataModuleContent.shortName;
        }
        return shopHomeDataModuleContent.copy(str, num, num2, str2);
    }

    public final String component1() {
        return this.content;
    }

    public final Integer component2() {
        return this.id;
    }

    public final Integer component3() {
        return this.type;
    }

    public final String component4() {
        return this.shortName;
    }

    public final ShopHomeDataModuleContent copy(String str, Integer num, Integer num2, String str2) {
        return new ShopHomeDataModuleContent(str, num, num2, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopHomeDataModuleContent)) {
            return false;
        }
        ShopHomeDataModuleContent shopHomeDataModuleContent = (ShopHomeDataModuleContent) obj;
        return Intrinsics.areEqual((Object) this.content, (Object) shopHomeDataModuleContent.content) && Intrinsics.areEqual((Object) this.id, (Object) shopHomeDataModuleContent.id) && Intrinsics.areEqual((Object) this.type, (Object) shopHomeDataModuleContent.type) && Intrinsics.areEqual((Object) this.shortName, (Object) shopHomeDataModuleContent.shortName);
    }

    public int hashCode() {
        String str = this.content;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.id;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.type;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.shortName;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ShopHomeDataModuleContent(content=" + this.content + ", id=" + this.id + ", type=" + this.type + ", shortName=" + this.shortName + ')';
    }

    public ShopHomeDataModuleContent(String str, Integer num, Integer num2, String str2) {
        this.content = str;
        this.id = num;
        this.type = num2;
        this.shortName = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopHomeDataModuleContent(String str, Integer num, Integer num2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, num, num2, (i & 8) != 0 ? null : str2);
    }

    public final String getContent() {
        return this.content;
    }

    public final Integer getId() {
        return this.id;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getShortName() {
        return this.shortName;
    }

    public final void setShortName(String str) {
        this.shortName = str;
    }
}
