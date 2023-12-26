package com.tal.app.thinkacademy.business.home.main.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J=\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\bHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopDialogChannelData;", "", "defaultChannel", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Channel;", "list", "", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ChannelDialogSection;", "selectorTitle", "", "isServerDefaultChannelId", "", "(Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Channel;Ljava/util/List;Ljava/lang/String;Z)V", "getDefaultChannel", "()Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Channel;", "setDefaultChannel", "(Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Channel;)V", "()Z", "setServerDefaultChannelId", "(Z)V", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getSelectorTitle", "()Ljava/lang/String;", "setSelectorTitle", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelDialogSection.kt */
public final class ShopDialogChannelData {
    private Channel defaultChannel;
    private boolean isServerDefaultChannelId;
    private List<ChannelDialogSection> list;
    private String selectorTitle;

    public ShopDialogChannelData() {
        this((Channel) null, (List) null, (String) null, false, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopDialogChannelData copy$default(ShopDialogChannelData shopDialogChannelData, Channel channel, List<ChannelDialogSection> list2, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = shopDialogChannelData.defaultChannel;
        }
        if ((i & 2) != 0) {
            list2 = shopDialogChannelData.list;
        }
        if ((i & 4) != 0) {
            str = shopDialogChannelData.selectorTitle;
        }
        if ((i & 8) != 0) {
            z = shopDialogChannelData.isServerDefaultChannelId;
        }
        return shopDialogChannelData.copy(channel, list2, str, z);
    }

    public final Channel component1() {
        return this.defaultChannel;
    }

    public final List<ChannelDialogSection> component2() {
        return this.list;
    }

    public final String component3() {
        return this.selectorTitle;
    }

    public final boolean component4() {
        return this.isServerDefaultChannelId;
    }

    public final ShopDialogChannelData copy(Channel channel, List<ChannelDialogSection> list2, String str, boolean z) {
        return new ShopDialogChannelData(channel, list2, str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopDialogChannelData)) {
            return false;
        }
        ShopDialogChannelData shopDialogChannelData = (ShopDialogChannelData) obj;
        return Intrinsics.areEqual((Object) this.defaultChannel, (Object) shopDialogChannelData.defaultChannel) && Intrinsics.areEqual((Object) this.list, (Object) shopDialogChannelData.list) && Intrinsics.areEqual((Object) this.selectorTitle, (Object) shopDialogChannelData.selectorTitle) && this.isServerDefaultChannelId == shopDialogChannelData.isServerDefaultChannelId;
    }

    public int hashCode() {
        Channel channel = this.defaultChannel;
        int i = 0;
        int hashCode = (channel == null ? 0 : channel.hashCode()) * 31;
        List<ChannelDialogSection> list2 = this.list;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str = this.selectorTitle;
        if (str != null) {
            i = str.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.isServerDefaultChannelId;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        return "ShopDialogChannelData(defaultChannel=" + this.defaultChannel + ", list=" + this.list + ", selectorTitle=" + this.selectorTitle + ", isServerDefaultChannelId=" + this.isServerDefaultChannelId + ')';
    }

    public ShopDialogChannelData(Channel channel, List<ChannelDialogSection> list2, String str, boolean z) {
        this.defaultChannel = channel;
        this.list = list2;
        this.selectorTitle = str;
        this.isServerDefaultChannelId = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopDialogChannelData(Channel channel, List list2, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : channel, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? false : z);
    }

    public final Channel getDefaultChannel() {
        return this.defaultChannel;
    }

    public final void setDefaultChannel(Channel channel) {
        this.defaultChannel = channel;
    }

    public final List<ChannelDialogSection> getList() {
        return this.list;
    }

    public final void setList(List<ChannelDialogSection> list2) {
        this.list = list2;
    }

    public final String getSelectorTitle() {
        return this.selectorTitle;
    }

    public final void setSelectorTitle(String str) {
        this.selectorTitle = str;
    }

    public final boolean isServerDefaultChannelId() {
        return this.isServerDefaultChannelId;
    }

    public final void setServerDefaultChannelId(boolean z) {
        this.isServerDefaultChannelId = z;
    }
}
