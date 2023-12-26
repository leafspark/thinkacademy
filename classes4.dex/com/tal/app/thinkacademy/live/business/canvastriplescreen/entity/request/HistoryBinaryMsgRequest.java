package com.tal.app.thinkacademy.live.business.canvastriplescreen.entity.request;

import com.tal.app.thinkacademy.lib.util.constant.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\b\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/entity/request/HistoryBinaryMsgRequest;", "", "key", "", "startMsgId", "page", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "endMsgId", "getKey", "()Ljava/lang/String;", "order", "getPage", "()I", "pageSize", "getStartMsgId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HistoryBinaryMsgRequest.kt */
public final class HistoryBinaryMsgRequest {
    private final String endMsgId = "+inf";
    private final String key;
    private final int order;
    private final int page;
    private final int pageSize = AppConfig.SCREEN_RESOLUTION_LANDSCAPE_MAX_PAD;
    private final String startMsgId;

    public static /* synthetic */ HistoryBinaryMsgRequest copy$default(HistoryBinaryMsgRequest historyBinaryMsgRequest, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = historyBinaryMsgRequest.key;
        }
        if ((i2 & 2) != 0) {
            str2 = historyBinaryMsgRequest.startMsgId;
        }
        if ((i2 & 4) != 0) {
            i = historyBinaryMsgRequest.page;
        }
        return historyBinaryMsgRequest.copy(str, str2, i);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.startMsgId;
    }

    public final int component3() {
        return this.page;
    }

    public final HistoryBinaryMsgRequest copy(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "startMsgId");
        return new HistoryBinaryMsgRequest(str, str2, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HistoryBinaryMsgRequest)) {
            return false;
        }
        HistoryBinaryMsgRequest historyBinaryMsgRequest = (HistoryBinaryMsgRequest) obj;
        return Intrinsics.areEqual(this.key, historyBinaryMsgRequest.key) && Intrinsics.areEqual(this.startMsgId, historyBinaryMsgRequest.startMsgId) && this.page == historyBinaryMsgRequest.page;
    }

    public int hashCode() {
        return (((this.key.hashCode() * 31) + this.startMsgId.hashCode()) * 31) + this.page;
    }

    public String toString() {
        return "HistoryBinaryMsgRequest(key=" + this.key + ", startMsgId=" + this.startMsgId + ", page=" + this.page + ')';
    }

    public HistoryBinaryMsgRequest(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "startMsgId");
        this.key = str;
        this.startMsgId = str2;
        this.page = i;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getStartMsgId() {
        return this.startMsgId;
    }

    public final int getPage() {
        return this.page;
    }
}
