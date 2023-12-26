package com.tal.app.thinkacademy.business.home.main.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000e\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ChannelListBodyData;", "", "mallGroup", "", "hideGroup", "", "defaultChannelId", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getDefaultChannelId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHideGroup", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMallGroup", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ChannelListBodyData;", "equals", "other", "hashCode", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelListBody.kt */
public final class ChannelListBodyData {
    private final Integer defaultChannelId;
    private final Boolean hideGroup;
    private final Integer mallGroup;

    public ChannelListBodyData() {
        this((Integer) null, (Boolean) null, (Integer) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ChannelListBodyData copy$default(ChannelListBodyData channelListBodyData, Integer num, Boolean bool, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = channelListBodyData.mallGroup;
        }
        if ((i & 2) != 0) {
            bool = channelListBodyData.hideGroup;
        }
        if ((i & 4) != 0) {
            num2 = channelListBodyData.defaultChannelId;
        }
        return channelListBodyData.copy(num, bool, num2);
    }

    public final Integer component1() {
        return this.mallGroup;
    }

    public final Boolean component2() {
        return this.hideGroup;
    }

    public final Integer component3() {
        return this.defaultChannelId;
    }

    public final ChannelListBodyData copy(Integer num, Boolean bool, Integer num2) {
        return new ChannelListBodyData(num, bool, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelListBodyData)) {
            return false;
        }
        ChannelListBodyData channelListBodyData = (ChannelListBodyData) obj;
        return Intrinsics.areEqual((Object) this.mallGroup, (Object) channelListBodyData.mallGroup) && Intrinsics.areEqual((Object) this.hideGroup, (Object) channelListBodyData.hideGroup) && Intrinsics.areEqual((Object) this.defaultChannelId, (Object) channelListBodyData.defaultChannelId);
    }

    public int hashCode() {
        Integer num = this.mallGroup;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Boolean bool = this.hideGroup;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num2 = this.defaultChannelId;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ChannelListBodyData(mallGroup=" + this.mallGroup + ", hideGroup=" + this.hideGroup + ", defaultChannelId=" + this.defaultChannelId + ')';
    }

    public ChannelListBodyData(Integer num, Boolean bool, Integer num2) {
        this.mallGroup = num;
        this.hideGroup = bool;
        this.defaultChannelId = num2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelListBodyData(Integer num, Boolean bool, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1 : num, (i & 2) != 0 ? false : bool, (i & 4) != 0 ? null : num2);
    }

    public final Integer getMallGroup() {
        return this.mallGroup;
    }

    public final Boolean getHideGroup() {
        return this.hideGroup;
    }

    public final Integer getDefaultChannelId() {
        return this.defaultChannelId;
    }
}
