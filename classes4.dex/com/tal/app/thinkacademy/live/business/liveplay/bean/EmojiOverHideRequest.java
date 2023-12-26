package com.tal.app.thinkacademy.live.business.liveplay.bean;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R*\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/liveplay/bean/EmojiOverHideRequest;", "", "orderIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getOrderIds", "()Ljava/util/ArrayList;", "setOrderIds", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiOverHideRequest.kt */
public final class EmojiOverHideRequest {
    private ArrayList<Integer> orderIds;

    public static /* synthetic */ EmojiOverHideRequest copy$default(EmojiOverHideRequest emojiOverHideRequest, ArrayList<Integer> arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = emojiOverHideRequest.orderIds;
        }
        return emojiOverHideRequest.copy(arrayList);
    }

    public final ArrayList<Integer> component1() {
        return this.orderIds;
    }

    public final EmojiOverHideRequest copy(ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "orderIds");
        return new EmojiOverHideRequest(arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EmojiOverHideRequest) && Intrinsics.areEqual(this.orderIds, ((EmojiOverHideRequest) obj).orderIds);
    }

    public int hashCode() {
        return this.orderIds.hashCode();
    }

    public String toString() {
        return "EmojiOverHideRequest(orderIds=" + this.orderIds + ')';
    }

    public EmojiOverHideRequest(ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "orderIds");
        this.orderIds = arrayList;
    }

    public final ArrayList<Integer> getOrderIds() {
        return this.orderIds;
    }

    public final void setOrderIds(ArrayList<Integer> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.orderIds = arrayList;
    }
}
