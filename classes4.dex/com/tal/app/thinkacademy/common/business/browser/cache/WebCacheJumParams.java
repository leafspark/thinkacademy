package com.tal.app.thinkacademy.common.business.browser.cache;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/cache/WebCacheJumParams;", "", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebCacheJumParams.kt */
public final class WebCacheJumParams {
    private final String url;

    public WebCacheJumParams() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ WebCacheJumParams copy$default(WebCacheJumParams webCacheJumParams, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = webCacheJumParams.url;
        }
        return webCacheJumParams.copy(str);
    }

    public final String component1() {
        return this.url;
    }

    public final WebCacheJumParams copy(String str) {
        return new WebCacheJumParams(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WebCacheJumParams) && Intrinsics.areEqual(this.url, ((WebCacheJumParams) obj).url);
    }

    public int hashCode() {
        String str = this.url;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "WebCacheJumParams(url=" + this.url + ')';
    }

    public WebCacheJumParams(String str) {
        this.url = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WebCacheJumParams(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    public final String getUrl() {
        return this.url;
    }
}
