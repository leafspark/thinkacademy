package com.tal.app.thinkacademy.live.business.photosonthewall.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/OpenStatusBody;", "", "planId", "", "interactId", "", "(Ljava/lang/Long;Ljava/lang/String;)V", "getInteractId", "()Ljava/lang/String;", "getPlanId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/String;)Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/OpenStatusBody;", "equals", "", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OpenStatusBody.kt */
public final class OpenStatusBody {
    private final String interactId;
    private final Long planId;

    public static /* synthetic */ OpenStatusBody copy$default(OpenStatusBody openStatusBody, Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = openStatusBody.planId;
        }
        if ((i & 2) != 0) {
            str = openStatusBody.interactId;
        }
        return openStatusBody.copy(l, str);
    }

    public final Long component1() {
        return this.planId;
    }

    public final String component2() {
        return this.interactId;
    }

    public final OpenStatusBody copy(Long l, String str) {
        return new OpenStatusBody(l, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenStatusBody)) {
            return false;
        }
        OpenStatusBody openStatusBody = (OpenStatusBody) obj;
        return Intrinsics.areEqual(this.planId, openStatusBody.planId) && Intrinsics.areEqual(this.interactId, openStatusBody.interactId);
    }

    public int hashCode() {
        Long l = this.planId;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.interactId;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "OpenStatusBody(planId=" + this.planId + ", interactId=" + this.interactId + ')';
    }

    public OpenStatusBody(Long l, String str) {
        this.planId = l;
        this.interactId = str;
    }

    public final Long getPlanId() {
        return this.planId;
    }

    public final String getInteractId() {
        return this.interactId;
    }
}
