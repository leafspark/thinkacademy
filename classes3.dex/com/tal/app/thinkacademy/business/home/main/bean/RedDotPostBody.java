package com.tal.app.thinkacademy.business.home.main.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/bean/RedDotPostBody;", "", "header", "Lcom/tal/app/thinkacademy/business/home/main/bean/RedDotPostParams;", "(Lcom/tal/app/thinkacademy/business/home/main/bean/RedDotPostParams;)V", "getHeader", "()Lcom/tal/app/thinkacademy/business/home/main/bean/RedDotPostParams;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedDotPostBody.kt */
public final class RedDotPostBody {
    private final RedDotPostParams header;

    public static /* synthetic */ RedDotPostBody copy$default(RedDotPostBody redDotPostBody, RedDotPostParams redDotPostParams, int i, Object obj) {
        if ((i & 1) != 0) {
            redDotPostParams = redDotPostBody.header;
        }
        return redDotPostBody.copy(redDotPostParams);
    }

    public final RedDotPostParams component1() {
        return this.header;
    }

    public final RedDotPostBody copy(RedDotPostParams redDotPostParams) {
        Intrinsics.checkNotNullParameter(redDotPostParams, "header");
        return new RedDotPostBody(redDotPostParams);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RedDotPostBody) && Intrinsics.areEqual((Object) this.header, (Object) ((RedDotPostBody) obj).header);
    }

    public int hashCode() {
        return this.header.hashCode();
    }

    public String toString() {
        return "RedDotPostBody(header=" + this.header + ')';
    }

    public RedDotPostBody(RedDotPostParams redDotPostParams) {
        Intrinsics.checkNotNullParameter(redDotPostParams, "header");
        this.header = redDotPostParams;
    }

    public final RedDotPostParams getHeader() {
        return this.header;
    }
}
