package com.tal.app.thinkacademy.live.abilitypack.coincenter;

import androidx.window.embedding.ActivityRule$;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/coincenter/CoinAnimationData;", "", "coins", "", "isShowToast", "", "location", "", "(IZ[I)V", "getCoins", "()I", "()Z", "getLocation", "()[I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoinCenterViewModel.kt */
public final class CoinAnimationData {
    private final int coins;
    private final boolean isShowToast;
    private final int[] location;

    public static /* synthetic */ CoinAnimationData copy$default(CoinAnimationData coinAnimationData, int i, boolean z, int[] iArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = coinAnimationData.coins;
        }
        if ((i2 & 2) != 0) {
            z = coinAnimationData.isShowToast;
        }
        if ((i2 & 4) != 0) {
            iArr = coinAnimationData.location;
        }
        return coinAnimationData.copy(i, z, iArr);
    }

    public final int component1() {
        return this.coins;
    }

    public final boolean component2() {
        return this.isShowToast;
    }

    public final int[] component3() {
        return this.location;
    }

    public final CoinAnimationData copy(int i, boolean z, int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "location");
        return new CoinAnimationData(i, z, iArr);
    }

    public String toString() {
        return "CoinAnimationData(coins=" + this.coins + ", isShowToast=" + this.isShowToast + ", location=" + Arrays.toString(this.location) + ')';
    }

    public CoinAnimationData(int i, boolean z, int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "location");
        this.coins = i;
        this.isShowToast = z;
        this.location = iArr;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CoinAnimationData(int i, boolean z, int[] iArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? true : z, iArr);
    }

    public final int getCoins() {
        return this.coins;
    }

    public final boolean isShowToast() {
        return this.isShowToast;
    }

    public final int[] getLocation() {
        return this.location;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), obj == null ? null : obj.getClass())) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinAnimationData");
        CoinAnimationData coinAnimationData = (CoinAnimationData) obj;
        return this.coins == coinAnimationData.coins && this.isShowToast == coinAnimationData.isShowToast && Arrays.equals(this.location, coinAnimationData.location);
    }

    public int hashCode() {
        return (((this.coins * 31) + ActivityRule$.ExternalSyntheticBackport0.m(this.isShowToast)) * 31) + Arrays.hashCode(this.location);
    }
}
