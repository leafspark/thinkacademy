package com.tal.app.thinkacademy.business.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailStaticData;", "", "planDescription", "", "portrait", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailPortrait;", "trialLessons", "", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailTrialLesson;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailPortrait;Ljava/util/List;)V", "getPlanDescription", "()Ljava/lang/String;", "getPortrait", "()Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailPortrait;", "getTrialLessons", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailInfoBean.kt */
public final class ShopClassDetailStaticData {
    private final String planDescription;
    private final ShopClassDetailPortrait portrait;
    private final List<ShopClassDetailTrialLesson> trialLessons;

    public ShopClassDetailStaticData() {
        this((String) null, (ShopClassDetailPortrait) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopClassDetailStaticData copy$default(ShopClassDetailStaticData shopClassDetailStaticData, String str, ShopClassDetailPortrait shopClassDetailPortrait, List<ShopClassDetailTrialLesson> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopClassDetailStaticData.planDescription;
        }
        if ((i & 2) != 0) {
            shopClassDetailPortrait = shopClassDetailStaticData.portrait;
        }
        if ((i & 4) != 0) {
            list = shopClassDetailStaticData.trialLessons;
        }
        return shopClassDetailStaticData.copy(str, shopClassDetailPortrait, list);
    }

    public final String component1() {
        return this.planDescription;
    }

    public final ShopClassDetailPortrait component2() {
        return this.portrait;
    }

    public final List<ShopClassDetailTrialLesson> component3() {
        return this.trialLessons;
    }

    public final ShopClassDetailStaticData copy(String str, ShopClassDetailPortrait shopClassDetailPortrait, List<ShopClassDetailTrialLesson> list) {
        return new ShopClassDetailStaticData(str, shopClassDetailPortrait, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopClassDetailStaticData)) {
            return false;
        }
        ShopClassDetailStaticData shopClassDetailStaticData = (ShopClassDetailStaticData) obj;
        return Intrinsics.areEqual((Object) this.planDescription, (Object) shopClassDetailStaticData.planDescription) && Intrinsics.areEqual((Object) this.portrait, (Object) shopClassDetailStaticData.portrait) && Intrinsics.areEqual((Object) this.trialLessons, (Object) shopClassDetailStaticData.trialLessons);
    }

    public int hashCode() {
        String str = this.planDescription;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ShopClassDetailPortrait shopClassDetailPortrait = this.portrait;
        int hashCode2 = (hashCode + (shopClassDetailPortrait == null ? 0 : shopClassDetailPortrait.hashCode())) * 31;
        List<ShopClassDetailTrialLesson> list = this.trialLessons;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ShopClassDetailStaticData(planDescription=" + this.planDescription + ", portrait=" + this.portrait + ", trialLessons=" + this.trialLessons + ')';
    }

    public ShopClassDetailStaticData(String str, ShopClassDetailPortrait shopClassDetailPortrait, List<ShopClassDetailTrialLesson> list) {
        this.planDescription = str;
        this.portrait = shopClassDetailPortrait;
        this.trialLessons = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopClassDetailStaticData(String str, ShopClassDetailPortrait shopClassDetailPortrait, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : shopClassDetailPortrait, (i & 4) != 0 ? null : list);
    }

    public final String getPlanDescription() {
        return this.planDescription;
    }

    public final ShopClassDetailPortrait getPortrait() {
        return this.portrait;
    }

    public final List<ShopClassDetailTrialLesson> getTrialLessons() {
        return this.trialLessons;
    }
}
