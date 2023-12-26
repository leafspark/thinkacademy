package com.tal.app.thinkacademy.live.abilitypack.playback.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/playback/bean/InteractData;", "", "ircType", "", "interactId", "pub", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getInteractId", "()Ljava/lang/String;", "getIrcType", "getPub", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InteractData.kt */
public final class InteractData {
    private final String interactId;
    private final String ircType;
    private final boolean pub;

    public static /* synthetic */ InteractData copy$default(InteractData interactData, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = interactData.ircType;
        }
        if ((i & 2) != 0) {
            str2 = interactData.interactId;
        }
        if ((i & 4) != 0) {
            z = interactData.pub;
        }
        return interactData.copy(str, str2, z);
    }

    public final String component1() {
        return this.ircType;
    }

    public final String component2() {
        return this.interactId;
    }

    public final boolean component3() {
        return this.pub;
    }

    public final InteractData copy(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "ircType");
        Intrinsics.checkNotNullParameter(str2, "interactId");
        return new InteractData(str, str2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InteractData)) {
            return false;
        }
        InteractData interactData = (InteractData) obj;
        return Intrinsics.areEqual(this.ircType, interactData.ircType) && Intrinsics.areEqual(this.interactId, interactData.interactId) && this.pub == interactData.pub;
    }

    public int hashCode() {
        int hashCode = ((this.ircType.hashCode() * 31) + this.interactId.hashCode()) * 31;
        boolean z = this.pub;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "InteractData(ircType=" + this.ircType + ", interactId=" + this.interactId + ", pub=" + this.pub + ')';
    }

    public InteractData(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "ircType");
        Intrinsics.checkNotNullParameter(str2, "interactId");
        this.ircType = str;
        this.interactId = str2;
        this.pub = z;
    }

    public final String getInteractId() {
        return this.interactId;
    }

    public final String getIrcType() {
        return this.ircType;
    }

    public final boolean getPub() {
        return this.pub;
    }
}
