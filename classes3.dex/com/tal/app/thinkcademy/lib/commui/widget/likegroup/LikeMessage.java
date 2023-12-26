package com.tal.app.thinkcademy.lib.commui.widget.likegroup;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/likegroup/LikeMessage;", "", "url", "", "likeCount", "", "time", "", "(Ljava/lang/String;IJ)V", "getLikeCount", "()I", "getTime", "()J", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LikeMessage.kt */
public final class LikeMessage {
    private final int likeCount;
    private final long time;
    private final String url;

    public static /* synthetic */ LikeMessage copy$default(LikeMessage likeMessage, String str, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = likeMessage.url;
        }
        if ((i2 & 2) != 0) {
            i = likeMessage.likeCount;
        }
        if ((i2 & 4) != 0) {
            j = likeMessage.time;
        }
        return likeMessage.copy(str, i, j);
    }

    public final String component1() {
        return this.url;
    }

    public final int component2() {
        return this.likeCount;
    }

    public final long component3() {
        return this.time;
    }

    public final LikeMessage copy(String str, int i, long j) {
        Intrinsics.checkNotNullParameter(str, "url");
        return new LikeMessage(str, i, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LikeMessage)) {
            return false;
        }
        LikeMessage likeMessage = (LikeMessage) obj;
        return Intrinsics.areEqual((Object) this.url, (Object) likeMessage.url) && this.likeCount == likeMessage.likeCount && this.time == likeMessage.time;
    }

    public int hashCode() {
        return (((this.url.hashCode() * 31) + this.likeCount) * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.time);
    }

    public String toString() {
        return "LikeMessage(url=" + this.url + ", likeCount=" + this.likeCount + ", time=" + this.time + ')';
    }

    public LikeMessage(String str, int i, long j) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.url = str;
        this.likeCount = i;
        this.time = j;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    public final long getTime() {
        return this.time;
    }

    public final String getUrl() {
        return this.url;
    }
}
