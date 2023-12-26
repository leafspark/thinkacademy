package com.yy.mobile.rollingtextview;

import com.tal.app.thinkacademy.common.entity.ScreenInfo$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/yy/mobile/rollingtextview/NextProgress;", "", "currentIndex", "", "offsetPercentage", "", "progress", "(IDD)V", "getCurrentIndex", "()I", "getOffsetPercentage", "()D", "getProgress", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: TextManager.kt */
public final class NextProgress {
    private final int currentIndex;
    private final double offsetPercentage;
    private final double progress;

    public static /* synthetic */ NextProgress copy$default(NextProgress nextProgress, int i, double d, double d2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = nextProgress.currentIndex;
        }
        if ((i2 & 2) != 0) {
            d = nextProgress.offsetPercentage;
        }
        double d3 = d;
        if ((i2 & 4) != 0) {
            d2 = nextProgress.progress;
        }
        return nextProgress.copy(i, d3, d2);
    }

    public final int component1() {
        return this.currentIndex;
    }

    public final double component2() {
        return this.offsetPercentage;
    }

    public final double component3() {
        return this.progress;
    }

    public final NextProgress copy(int i, double d, double d2) {
        return new NextProgress(i, d, d2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NextProgress)) {
            return false;
        }
        NextProgress nextProgress = (NextProgress) obj;
        return this.currentIndex == nextProgress.currentIndex && Intrinsics.areEqual(Double.valueOf(this.offsetPercentage), Double.valueOf(nextProgress.offsetPercentage)) && Intrinsics.areEqual(Double.valueOf(this.progress), Double.valueOf(nextProgress.progress));
    }

    public int hashCode() {
        return (((this.currentIndex * 31) + ScreenInfo$.ExternalSyntheticBackport0.m(this.offsetPercentage)) * 31) + ScreenInfo$.ExternalSyntheticBackport0.m(this.progress);
    }

    public String toString() {
        return "NextProgress(currentIndex=" + this.currentIndex + ", offsetPercentage=" + this.offsetPercentage + ", progress=" + this.progress + ')';
    }

    public NextProgress(int i, double d, double d2) {
        this.currentIndex = i;
        this.offsetPercentage = d;
        this.progress = d2;
    }

    public final int getCurrentIndex() {
        return this.currentIndex;
    }

    public final double getOffsetPercentage() {
        return this.offsetPercentage;
    }

    public final double getProgress() {
        return this.progress;
    }
}
