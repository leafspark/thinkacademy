package com.tal.app.thinkacademy.live.abilitypack.allonstage.listenbody;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0005\"\u0004\b\u0006\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/listenbody/OnStageChanged;", "Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/listenbody/AllOnStageListenerBody;", "isOnStage", "", "(Z)V", "()Z", "setOnStage", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStageListenerBody.kt */
public final class OnStageChanged extends AllOnStageListenerBody {
    private boolean isOnStage;

    public static /* synthetic */ OnStageChanged copy$default(OnStageChanged onStageChanged, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = onStageChanged.isOnStage;
        }
        return onStageChanged.copy(z);
    }

    public final boolean component1() {
        return this.isOnStage;
    }

    public final OnStageChanged copy(boolean z) {
        return new OnStageChanged(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OnStageChanged) && this.isOnStage == ((OnStageChanged) obj).isOnStage;
    }

    public int hashCode() {
        boolean z = this.isOnStage;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "OnStageChanged(isOnStage=" + this.isOnStage + ')';
    }

    public OnStageChanged(boolean z) {
        super((DefaultConstructorMarker) null);
        this.isOnStage = z;
    }

    public final boolean isOnStage() {
        return this.isOnStage;
    }

    public final void setOnStage(boolean z) {
        this.isOnStage = z;
    }
}
