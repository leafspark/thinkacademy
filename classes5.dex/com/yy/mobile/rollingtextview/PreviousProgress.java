package com.yy.mobile.rollingtextview;

import com.tal.app.thinkacademy.common.entity.ScreenInfo$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006!"}, d2 = {"Lcom/yy/mobile/rollingtextview/PreviousProgress;", "", "currentIndex", "", "offsetPercentage", "", "progress", "currentChar", "", "currentWidth", "", "(IDDCF)V", "getCurrentChar", "()C", "getCurrentIndex", "()I", "getCurrentWidth", "()F", "getOffsetPercentage", "()D", "getProgress", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "com.github.YvesCheung.RollingText"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: TextManager.kt */
public final class PreviousProgress {
    private final char currentChar;
    private final int currentIndex;
    private final float currentWidth;
    private final double offsetPercentage;
    private final double progress;

    public static /* synthetic */ PreviousProgress copy$default(PreviousProgress previousProgress, int i, double d, double d2, char c, float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = previousProgress.currentIndex;
        }
        if ((i2 & 2) != 0) {
            d = previousProgress.offsetPercentage;
        }
        double d3 = d;
        if ((i2 & 4) != 0) {
            d2 = previousProgress.progress;
        }
        double d4 = d2;
        if ((i2 & 8) != 0) {
            c = previousProgress.currentChar;
        }
        char c2 = c;
        if ((i2 & 16) != 0) {
            f = previousProgress.currentWidth;
        }
        return previousProgress.copy(i, d3, d4, c2, f);
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

    public final char component4() {
        return this.currentChar;
    }

    public final float component5() {
        return this.currentWidth;
    }

    public final PreviousProgress copy(int i, double d, double d2, char c, float f) {
        return new PreviousProgress(i, d, d2, c, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreviousProgress)) {
            return false;
        }
        PreviousProgress previousProgress = (PreviousProgress) obj;
        return this.currentIndex == previousProgress.currentIndex && Intrinsics.areEqual(Double.valueOf(this.offsetPercentage), Double.valueOf(previousProgress.offsetPercentage)) && Intrinsics.areEqual(Double.valueOf(this.progress), Double.valueOf(previousProgress.progress)) && this.currentChar == previousProgress.currentChar && Intrinsics.areEqual(Float.valueOf(this.currentWidth), Float.valueOf(previousProgress.currentWidth));
    }

    public int hashCode() {
        return (((((((this.currentIndex * 31) + ScreenInfo$.ExternalSyntheticBackport0.m(this.offsetPercentage)) * 31) + ScreenInfo$.ExternalSyntheticBackport0.m(this.progress)) * 31) + this.currentChar) * 31) + Float.floatToIntBits(this.currentWidth);
    }

    public String toString() {
        return "PreviousProgress(currentIndex=" + this.currentIndex + ", offsetPercentage=" + this.offsetPercentage + ", progress=" + this.progress + ", currentChar=" + this.currentChar + ", currentWidth=" + this.currentWidth + ')';
    }

    public PreviousProgress(int i, double d, double d2, char c, float f) {
        this.currentIndex = i;
        this.offsetPercentage = d;
        this.progress = d2;
        this.currentChar = c;
        this.currentWidth = f;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PreviousProgress(int i, double d, double d2, char c, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, d, d2, (i2 & 8) != 0 ? 0 : c, (i2 & 16) != 0 ? 0.0f : f);
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

    public final char getCurrentChar() {
        return this.currentChar;
    }

    public final float getCurrentWidth() {
        return this.currentWidth;
    }
}
