package com.tal.app.thinkacademy.business.home.main.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ChannelListBody;", "", "head", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ChannelListBodyHead;", "data", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ChannelListBodyData;", "(Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ChannelListBodyHead;Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ChannelListBodyData;)V", "getData", "()Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ChannelListBodyData;", "getHead", "()Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ChannelListBodyHead;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelListBody.kt */
public final class ChannelListBody {
    private final ChannelListBodyData data;
    private final ChannelListBodyHead head;

    public static /* synthetic */ ChannelListBody copy$default(ChannelListBody channelListBody, ChannelListBodyHead channelListBodyHead, ChannelListBodyData channelListBodyData, int i, Object obj) {
        if ((i & 1) != 0) {
            channelListBodyHead = channelListBody.head;
        }
        if ((i & 2) != 0) {
            channelListBodyData = channelListBody.data;
        }
        return channelListBody.copy(channelListBodyHead, channelListBodyData);
    }

    public final ChannelListBodyHead component1() {
        return this.head;
    }

    public final ChannelListBodyData component2() {
        return this.data;
    }

    public final ChannelListBody copy(ChannelListBodyHead channelListBodyHead, ChannelListBodyData channelListBodyData) {
        return new ChannelListBody(channelListBodyHead, channelListBodyData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelListBody)) {
            return false;
        }
        ChannelListBody channelListBody = (ChannelListBody) obj;
        return Intrinsics.areEqual((Object) this.head, (Object) channelListBody.head) && Intrinsics.areEqual((Object) this.data, (Object) channelListBody.data);
    }

    public int hashCode() {
        ChannelListBodyHead channelListBodyHead = this.head;
        int i = 0;
        int hashCode = (channelListBodyHead == null ? 0 : channelListBodyHead.hashCode()) * 31;
        ChannelListBodyData channelListBodyData = this.data;
        if (channelListBodyData != null) {
            i = channelListBodyData.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ChannelListBody(head=" + this.head + ", data=" + this.data + ')';
    }

    public ChannelListBody(ChannelListBodyHead channelListBodyHead, ChannelListBodyData channelListBodyData) {
        this.head = channelListBodyHead;
        this.data = channelListBodyData;
    }

    public final ChannelListBodyData getData() {
        return this.data;
    }

    public final ChannelListBodyHead getHead() {
        return this.head;
    }
}
