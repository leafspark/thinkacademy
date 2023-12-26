package com.tal.app.thinkacademy.live.business.redpackagerain.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainStatusBody;", "", "planId", "", "interactId", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getInteractId", "()Ljava/lang/String;", "getPlanId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainStatusBody;", "equals", "", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedPackageRainStatusBody.kt */
public final class RedPackageRainStatusBody {
    private final String interactId;
    private final Integer planId;

    public static /* synthetic */ RedPackageRainStatusBody copy$default(RedPackageRainStatusBody redPackageRainStatusBody, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = redPackageRainStatusBody.planId;
        }
        if ((i & 2) != 0) {
            str = redPackageRainStatusBody.interactId;
        }
        return redPackageRainStatusBody.copy(num, str);
    }

    public final Integer component1() {
        return this.planId;
    }

    public final String component2() {
        return this.interactId;
    }

    public final RedPackageRainStatusBody copy(Integer num, String str) {
        return new RedPackageRainStatusBody(num, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedPackageRainStatusBody)) {
            return false;
        }
        RedPackageRainStatusBody redPackageRainStatusBody = (RedPackageRainStatusBody) obj;
        return Intrinsics.areEqual(this.planId, redPackageRainStatusBody.planId) && Intrinsics.areEqual(this.interactId, redPackageRainStatusBody.interactId);
    }

    public int hashCode() {
        Integer num = this.planId;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.interactId;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "RedPackageRainStatusBody(planId=" + this.planId + ", interactId=" + this.interactId + ')';
    }

    public RedPackageRainStatusBody(Integer num, String str) {
        this.planId = num;
        this.interactId = str;
    }

    public final String getInteractId() {
        return this.interactId;
    }

    public final Integer getPlanId() {
        return this.planId;
    }
}
