package io.ktor.http.content;

import io.ktor.http.CacheControl;
import io.ktor.util.date.GMTDate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lio/ktor/http/content/CachingOptions;", "", "cacheControl", "Lio/ktor/http/CacheControl;", "expires", "Lio/ktor/util/date/GMTDate;", "(Lio/ktor/http/CacheControl;Lio/ktor/util/date/GMTDate;)V", "getCacheControl", "()Lio/ktor/http/CacheControl;", "getExpires", "()Lio/ktor/util/date/GMTDate;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CachingOptions.kt */
public final class CachingOptions {
    private final CacheControl cacheControl;
    private final GMTDate expires;

    public CachingOptions() {
        this((CacheControl) null, (GMTDate) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CachingOptions copy$default(CachingOptions cachingOptions, CacheControl cacheControl2, GMTDate gMTDate, int i, Object obj) {
        if ((i & 1) != 0) {
            cacheControl2 = cachingOptions.cacheControl;
        }
        if ((i & 2) != 0) {
            gMTDate = cachingOptions.expires;
        }
        return cachingOptions.copy(cacheControl2, gMTDate);
    }

    public final CacheControl component1() {
        return this.cacheControl;
    }

    public final GMTDate component2() {
        return this.expires;
    }

    public final CachingOptions copy(CacheControl cacheControl2, GMTDate gMTDate) {
        return new CachingOptions(cacheControl2, gMTDate);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CachingOptions)) {
            return false;
        }
        CachingOptions cachingOptions = (CachingOptions) obj;
        return Intrinsics.areEqual(this.cacheControl, cachingOptions.cacheControl) && Intrinsics.areEqual(this.expires, cachingOptions.expires);
    }

    public int hashCode() {
        CacheControl cacheControl2 = this.cacheControl;
        int i = 0;
        int hashCode = (cacheControl2 == null ? 0 : cacheControl2.hashCode()) * 31;
        GMTDate gMTDate = this.expires;
        if (gMTDate != null) {
            i = gMTDate.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CachingOptions(cacheControl=" + this.cacheControl + ", expires=" + this.expires + ')';
    }

    public CachingOptions(CacheControl cacheControl2, GMTDate gMTDate) {
        this.cacheControl = cacheControl2;
        this.expires = gMTDate;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CachingOptions(CacheControl cacheControl2, GMTDate gMTDate, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : cacheControl2, (i & 2) != 0 ? null : gMTDate);
    }

    public final CacheControl getCacheControl() {
        return this.cacheControl;
    }

    public final GMTDate getExpires() {
        return this.expires;
    }
}
