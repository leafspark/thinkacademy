package com.tal.app.thinkacademy.live.abilitypack.playback.bean;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/playback/bean/PageIndexData;", "", "offsetTs", "", "pageId", "", "imgUrl", "timestamp", "(JLjava/lang/String;Ljava/lang/String;J)V", "getImgUrl", "()Ljava/lang/String;", "getOffsetTs", "()J", "getPageId", "getTimestamp", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PageIndexData.kt */
public final class PageIndexData {
    private final String imgUrl;
    private final long offsetTs;
    private final String pageId;
    private final long timestamp;

    public static /* synthetic */ PageIndexData copy$default(PageIndexData pageIndexData, long j, String str, String str2, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = pageIndexData.offsetTs;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            str = pageIndexData.pageId;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = pageIndexData.imgUrl;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            j2 = pageIndexData.timestamp;
        }
        return pageIndexData.copy(j3, str3, str4, j2);
    }

    public final long component1() {
        return this.offsetTs;
    }

    public final String component2() {
        return this.pageId;
    }

    public final String component3() {
        return this.imgUrl;
    }

    public final long component4() {
        return this.timestamp;
    }

    public final PageIndexData copy(long j, String str, String str2, long j2) {
        Intrinsics.checkNotNullParameter(str, "pageId");
        Intrinsics.checkNotNullParameter(str2, "imgUrl");
        return new PageIndexData(j, str, str2, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PageIndexData)) {
            return false;
        }
        PageIndexData pageIndexData = (PageIndexData) obj;
        return this.offsetTs == pageIndexData.offsetTs && Intrinsics.areEqual(this.pageId, pageIndexData.pageId) && Intrinsics.areEqual(this.imgUrl, pageIndexData.imgUrl) && this.timestamp == pageIndexData.timestamp;
    }

    public int hashCode() {
        return (((((SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.offsetTs) * 31) + this.pageId.hashCode()) * 31) + this.imgUrl.hashCode()) * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.timestamp);
    }

    public String toString() {
        return "PageIndexData(offsetTs=" + this.offsetTs + ", pageId=" + this.pageId + ", imgUrl=" + this.imgUrl + ", timestamp=" + this.timestamp + ')';
    }

    public PageIndexData(long j, String str, String str2, long j2) {
        Intrinsics.checkNotNullParameter(str, "pageId");
        Intrinsics.checkNotNullParameter(str2, "imgUrl");
        this.offsetTs = j;
        this.pageId = str;
        this.imgUrl = str2;
        this.timestamp = j2;
    }

    public final long getOffsetTs() {
        return this.offsetTs;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getImgUrl() {
        return this.imgUrl;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }
}
