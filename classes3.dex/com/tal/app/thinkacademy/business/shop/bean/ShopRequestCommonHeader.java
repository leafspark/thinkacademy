package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopRequestCommonHeader;", "", "schoolCode", "", "channelCode", "(Ljava/lang/String;Ljava/lang/String;)V", "getChannelCode", "()Ljava/lang/String;", "setChannelCode", "(Ljava/lang/String;)V", "getSchoolCode", "setSchoolCode", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopRequestCommonHeader.kt */
public final class ShopRequestCommonHeader {
    private String channelCode;
    private String schoolCode;

    public ShopRequestCommonHeader() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopRequestCommonHeader copy$default(ShopRequestCommonHeader shopRequestCommonHeader, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopRequestCommonHeader.schoolCode;
        }
        if ((i & 2) != 0) {
            str2 = shopRequestCommonHeader.channelCode;
        }
        return shopRequestCommonHeader.copy(str, str2);
    }

    public final String component1() {
        return this.schoolCode;
    }

    public final String component2() {
        return this.channelCode;
    }

    public final ShopRequestCommonHeader copy(String str, String str2) {
        return new ShopRequestCommonHeader(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopRequestCommonHeader)) {
            return false;
        }
        ShopRequestCommonHeader shopRequestCommonHeader = (ShopRequestCommonHeader) obj;
        return Intrinsics.areEqual((Object) this.schoolCode, (Object) shopRequestCommonHeader.schoolCode) && Intrinsics.areEqual((Object) this.channelCode, (Object) shopRequestCommonHeader.channelCode);
    }

    public int hashCode() {
        String str = this.schoolCode;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.channelCode;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ShopRequestCommonHeader(schoolCode=" + this.schoolCode + ", channelCode=" + this.channelCode + ')';
    }

    public ShopRequestCommonHeader(String str, String str2) {
        this.schoolCode = str;
        this.channelCode = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopRequestCommonHeader(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getSchoolCode() {
        return this.schoolCode;
    }

    public final void setSchoolCode(String str) {
        this.schoolCode = str;
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final void setChannelCode(String str) {
        this.channelCode = str;
    }
}
