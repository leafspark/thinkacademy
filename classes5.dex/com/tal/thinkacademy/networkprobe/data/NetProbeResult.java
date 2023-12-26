package com.tal.thinkacademy.networkprobe.data;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0006\u0010\u0002\u001a\u00020\u0003R*\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/tal/thinkacademy/networkprobe/data/NetProbeResult;", "", "url", "", "repeatCount", "", "(Ljava/lang/String;I)V", "durationArray", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getDurationArray", "()Ljava/util/ArrayList;", "setDurationArray", "(Ljava/util/ArrayList;)V", "average", "", "toString", "networkprobe_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetProbeResult.kt */
public final class NetProbeResult {
    private ArrayList<Long> durationArray = new ArrayList<>();
    private final int repeatCount;
    private final String url;

    public NetProbeResult(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.url = str;
        this.repeatCount = i;
    }

    public final ArrayList<Long> getDurationArray() {
        return this.durationArray;
    }

    public final void setDurationArray(ArrayList<Long> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.durationArray = arrayList;
    }

    public final String url() {
        return this.url;
    }

    public final int repeatCount() {
        return this.repeatCount;
    }

    public final float average() {
        Iterator<Long> it = this.durationArray.iterator();
        long j = 0;
        while (it.hasNext()) {
            Long next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "duration");
            j += next.longValue();
        }
        return (((float) j) * 1.0f) / ((float) this.durationArray.size());
    }

    public String toString() {
        return "NetProbeResult(url='" + this.url + "', repeatCount=" + this.repeatCount + ", durationArray=" + this.durationArray + ", average=" + average() + ')';
    }
}
