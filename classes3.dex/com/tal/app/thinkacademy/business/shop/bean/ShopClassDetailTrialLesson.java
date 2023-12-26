package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailTrialLesson;", "", "duration", "", "name", "", "url", "(ILjava/lang/String;Ljava/lang/String;)V", "getDuration", "()I", "getName", "()Ljava/lang/String;", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailInfoBean.kt */
public final class ShopClassDetailTrialLesson {
    private final int duration;
    private final String name;
    private final String url;

    public ShopClassDetailTrialLesson() {
        this(0, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopClassDetailTrialLesson copy$default(ShopClassDetailTrialLesson shopClassDetailTrialLesson, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = shopClassDetailTrialLesson.duration;
        }
        if ((i2 & 2) != 0) {
            str = shopClassDetailTrialLesson.name;
        }
        if ((i2 & 4) != 0) {
            str2 = shopClassDetailTrialLesson.url;
        }
        return shopClassDetailTrialLesson.copy(i, str, str2);
    }

    public final int component1() {
        return this.duration;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.url;
    }

    public final ShopClassDetailTrialLesson copy(int i, String str, String str2) {
        return new ShopClassDetailTrialLesson(i, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopClassDetailTrialLesson)) {
            return false;
        }
        ShopClassDetailTrialLesson shopClassDetailTrialLesson = (ShopClassDetailTrialLesson) obj;
        return this.duration == shopClassDetailTrialLesson.duration && Intrinsics.areEqual((Object) this.name, (Object) shopClassDetailTrialLesson.name) && Intrinsics.areEqual((Object) this.url, (Object) shopClassDetailTrialLesson.url);
    }

    public int hashCode() {
        int i = this.duration * 31;
        String str = this.name;
        int i2 = 0;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.url;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "ShopClassDetailTrialLesson(duration=" + this.duration + ", name=" + this.name + ", url=" + this.url + ')';
    }

    public ShopClassDetailTrialLesson(int i, String str, String str2) {
        this.duration = i;
        this.name = str;
        this.url = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopClassDetailTrialLesson(int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2);
    }

    public final int getDuration() {
        return this.duration;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUrl() {
        return this.url;
    }
}
