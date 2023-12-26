package com.tal.app.thinkacademy.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/PushData;", "", "clientId", "", "clientType", "", "(Ljava/lang/String;I)V", "getClientId", "()Ljava/lang/String;", "getClientType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PushRequestBean.kt */
public final class PushData {
    private final String clientId;
    private final int clientType;

    public static /* synthetic */ PushData copy$default(PushData pushData, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = pushData.clientId;
        }
        if ((i2 & 2) != 0) {
            i = pushData.clientType;
        }
        return pushData.copy(str, i);
    }

    public final String component1() {
        return this.clientId;
    }

    public final int component2() {
        return this.clientType;
    }

    public final PushData copy(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "clientId");
        return new PushData(str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PushData)) {
            return false;
        }
        PushData pushData = (PushData) obj;
        return Intrinsics.areEqual(this.clientId, pushData.clientId) && this.clientType == pushData.clientType;
    }

    public int hashCode() {
        return (this.clientId.hashCode() * 31) + this.clientType;
    }

    public String toString() {
        return "PushData(clientId=" + this.clientId + ", clientType=" + this.clientType + ')';
    }

    public PushData(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "clientId");
        this.clientId = str;
        this.clientType = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PushData(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 1 : i);
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final int getClientType() {
        return this.clientType;
    }
}
