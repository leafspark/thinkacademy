package com.tal.app.thinkacademy.business.home.main.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JD\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopBannerDataBean;", "", "channelId", "", "gradeId", "locationKey", "", "resources", "", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopBannerResource;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "getChannelId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getGradeId", "getLocationKey", "()Ljava/lang/String;", "getResources", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopBannerDataBean;", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BannerDataBean.kt */
public final class ShopBannerDataBean {
    private final Integer channelId;
    private final Integer gradeId;
    private final String locationKey;
    private final List<ShopBannerResource> resources;

    public ShopBannerDataBean() {
        this((Integer) null, (Integer) null, (String) null, (List) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopBannerDataBean copy$default(ShopBannerDataBean shopBannerDataBean, Integer num, Integer num2, String str, List<ShopBannerResource> list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = shopBannerDataBean.channelId;
        }
        if ((i & 2) != 0) {
            num2 = shopBannerDataBean.gradeId;
        }
        if ((i & 4) != 0) {
            str = shopBannerDataBean.locationKey;
        }
        if ((i & 8) != 0) {
            list = shopBannerDataBean.resources;
        }
        return shopBannerDataBean.copy(num, num2, str, list);
    }

    public final Integer component1() {
        return this.channelId;
    }

    public final Integer component2() {
        return this.gradeId;
    }

    public final String component3() {
        return this.locationKey;
    }

    public final List<ShopBannerResource> component4() {
        return this.resources;
    }

    public final ShopBannerDataBean copy(Integer num, Integer num2, String str, List<ShopBannerResource> list) {
        return new ShopBannerDataBean(num, num2, str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopBannerDataBean)) {
            return false;
        }
        ShopBannerDataBean shopBannerDataBean = (ShopBannerDataBean) obj;
        return Intrinsics.areEqual((Object) this.channelId, (Object) shopBannerDataBean.channelId) && Intrinsics.areEqual((Object) this.gradeId, (Object) shopBannerDataBean.gradeId) && Intrinsics.areEqual((Object) this.locationKey, (Object) shopBannerDataBean.locationKey) && Intrinsics.areEqual((Object) this.resources, (Object) shopBannerDataBean.resources);
    }

    public int hashCode() {
        Integer num = this.channelId;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.gradeId;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.locationKey;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        List<ShopBannerResource> list = this.resources;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ShopBannerDataBean(channelId=" + this.channelId + ", gradeId=" + this.gradeId + ", locationKey=" + this.locationKey + ", resources=" + this.resources + ')';
    }

    public ShopBannerDataBean(Integer num, Integer num2, String str, List<ShopBannerResource> list) {
        this.channelId = num;
        this.gradeId = num2;
        this.locationKey = str;
        this.resources = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopBannerDataBean(Integer num, Integer num2, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? 0 : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : list);
    }

    public final Integer getChannelId() {
        return this.channelId;
    }

    public final Integer getGradeId() {
        return this.gradeId;
    }

    public final String getLocationKey() {
        return this.locationKey;
    }

    public final List<ShopBannerResource> getResources() {
        return this.resources;
    }
}
