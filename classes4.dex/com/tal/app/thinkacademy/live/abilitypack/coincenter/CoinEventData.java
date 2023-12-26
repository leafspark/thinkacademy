package com.tal.app.thinkacademy.live.abilitypack.coincenter;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/coincenter/CoinEventData;", "", "source", "", "addCoinNum", "", "isPlayScrollText", "", "isPlayCoinPAG", "(Ljava/lang/String;IZZ)V", "getAddCoinNum", "()I", "()Z", "getSource", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoinCenterViewModel.kt */
public final class CoinEventData {
    private final int addCoinNum;
    private final boolean isPlayCoinPAG;
    private final boolean isPlayScrollText;
    private final String source;

    public static /* synthetic */ CoinEventData copy$default(CoinEventData coinEventData, String str, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = coinEventData.source;
        }
        if ((i2 & 2) != 0) {
            i = coinEventData.addCoinNum;
        }
        if ((i2 & 4) != 0) {
            z = coinEventData.isPlayScrollText;
        }
        if ((i2 & 8) != 0) {
            z2 = coinEventData.isPlayCoinPAG;
        }
        return coinEventData.copy(str, i, z, z2);
    }

    public final String component1() {
        return this.source;
    }

    public final int component2() {
        return this.addCoinNum;
    }

    public final boolean component3() {
        return this.isPlayScrollText;
    }

    public final boolean component4() {
        return this.isPlayCoinPAG;
    }

    public final CoinEventData copy(String str, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "source");
        return new CoinEventData(str, i, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CoinEventData)) {
            return false;
        }
        CoinEventData coinEventData = (CoinEventData) obj;
        return Intrinsics.areEqual(this.source, coinEventData.source) && this.addCoinNum == coinEventData.addCoinNum && this.isPlayScrollText == coinEventData.isPlayScrollText && this.isPlayCoinPAG == coinEventData.isPlayCoinPAG;
    }

    public int hashCode() {
        int hashCode = ((this.source.hashCode() * 31) + this.addCoinNum) * 31;
        boolean z = this.isPlayScrollText;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.isPlayCoinPAG;
        if (!z3) {
            z2 = z3;
        }
        return i + (z2 ? 1 : 0);
    }

    public String toString() {
        return "CoinEventData(source=" + this.source + ", addCoinNum=" + this.addCoinNum + ", isPlayScrollText=" + this.isPlayScrollText + ", isPlayCoinPAG=" + this.isPlayCoinPAG + ')';
    }

    public CoinEventData(String str, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "source");
        this.source = str;
        this.addCoinNum = i;
        this.isPlayScrollText = z;
        this.isPlayCoinPAG = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CoinEventData(String str, int i, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? true : z2);
    }

    public final String getSource() {
        return this.source;
    }

    public final int getAddCoinNum() {
        return this.addCoinNum;
    }

    public final boolean isPlayScrollText() {
        return this.isPlayScrollText;
    }

    public final boolean isPlayCoinPAG() {
        return this.isPlayCoinPAG;
    }
}
