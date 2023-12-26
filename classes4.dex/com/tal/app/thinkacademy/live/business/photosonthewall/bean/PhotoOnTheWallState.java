package com.tal.app.thinkacademy.live.business.photosonthewall.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotoOnTheWallState;", "", "interactId", "", "state", "", "(Ljava/lang/String;Z)V", "getInteractId", "()Ljava/lang/String;", "getState", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhotoOnTheWallState.kt */
public final class PhotoOnTheWallState {
    private final String interactId;
    private final boolean state;

    public PhotoOnTheWallState() {
        this((String) null, false, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PhotoOnTheWallState copy$default(PhotoOnTheWallState photoOnTheWallState, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = photoOnTheWallState.interactId;
        }
        if ((i & 2) != 0) {
            z = photoOnTheWallState.state;
        }
        return photoOnTheWallState.copy(str, z);
    }

    public final String component1() {
        return this.interactId;
    }

    public final boolean component2() {
        return this.state;
    }

    public final PhotoOnTheWallState copy(String str, boolean z) {
        return new PhotoOnTheWallState(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhotoOnTheWallState)) {
            return false;
        }
        PhotoOnTheWallState photoOnTheWallState = (PhotoOnTheWallState) obj;
        return Intrinsics.areEqual(this.interactId, photoOnTheWallState.interactId) && this.state == photoOnTheWallState.state;
    }

    public int hashCode() {
        String str = this.interactId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z = this.state;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "PhotoOnTheWallState(interactId=" + this.interactId + ", state=" + this.state + ')';
    }

    public PhotoOnTheWallState(String str, boolean z) {
        this.interactId = str;
        this.state = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoOnTheWallState(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z);
    }

    public final String getInteractId() {
        return this.interactId;
    }

    public final boolean getState() {
        return this.state;
    }
}
