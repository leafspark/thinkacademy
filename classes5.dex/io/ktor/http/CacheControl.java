package io.ktor.http;

import androidx.window.embedding.ActivityRule$;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nB\u0011\b\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lio/ktor/http/CacheControl;", "", "visibility", "Lio/ktor/http/CacheControl$Visibility;", "(Lio/ktor/http/CacheControl$Visibility;)V", "getVisibility", "()Lio/ktor/http/CacheControl$Visibility;", "MaxAge", "NoCache", "NoStore", "Visibility", "Lio/ktor/http/CacheControl$NoCache;", "Lio/ktor/http/CacheControl$NoStore;", "Lio/ktor/http/CacheControl$MaxAge;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CacheControl.kt */
public abstract class CacheControl {
    private final Visibility visibility;

    public /* synthetic */ CacheControl(Visibility visibility2, DefaultConstructorMarker defaultConstructorMarker) {
        this(visibility2);
    }

    private CacheControl(Visibility visibility2) {
        this.visibility = visibility2;
    }

    public final Visibility getVisibility() {
        return this.visibility;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lio/ktor/http/CacheControl$Visibility;", "", "headerValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getHeaderValue$ktor_http", "()Ljava/lang/String;", "Public", "Private", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CacheControl.kt */
    public enum Visibility {
        Public(io.ktor.client.utils.CacheControl.PUBLIC),
        Private(io.ktor.client.utils.CacheControl.PRIVATE);
        
        private final String headerValue;

        private Visibility(String str) {
            this.headerValue = str;
        }

        public final String getHeaderValue$ktor_http() {
            return this.headerValue;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lio/ktor/http/CacheControl$NoCache;", "Lio/ktor/http/CacheControl;", "visibility", "Lio/ktor/http/CacheControl$Visibility;", "(Lio/ktor/http/CacheControl$Visibility;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CacheControl.kt */
    public static final class NoCache extends CacheControl {
        public NoCache(Visibility visibility) {
            super(visibility, (DefaultConstructorMarker) null);
        }

        public String toString() {
            if (getVisibility() == null) {
                return io.ktor.client.utils.CacheControl.NO_CACHE;
            }
            return "no-cache, " + getVisibility().getHeaderValue$ktor_http();
        }

        public boolean equals(Object obj) {
            return (obj instanceof NoCache) && getVisibility() == ((NoCache) obj).getVisibility();
        }

        public int hashCode() {
            Visibility visibility = getVisibility();
            if (visibility != null) {
                return visibility.hashCode();
            }
            return 0;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lio/ktor/http/CacheControl$NoStore;", "Lio/ktor/http/CacheControl;", "visibility", "Lio/ktor/http/CacheControl$Visibility;", "(Lio/ktor/http/CacheControl$Visibility;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CacheControl.kt */
    public static final class NoStore extends CacheControl {
        public NoStore(Visibility visibility) {
            super(visibility, (DefaultConstructorMarker) null);
        }

        public String toString() {
            if (getVisibility() == null) {
                return io.ktor.client.utils.CacheControl.NO_STORE;
            }
            return "no-store, " + getVisibility().getHeaderValue$ktor_http();
        }

        public boolean equals(Object obj) {
            return (obj instanceof NoStore) && ((NoStore) obj).getVisibility() == getVisibility();
        }

        public int hashCode() {
            Visibility visibility = getVisibility();
            if (visibility != null) {
                return visibility.hashCode();
            }
            return 0;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0019"}, d2 = {"Lio/ktor/http/CacheControl$MaxAge;", "Lio/ktor/http/CacheControl;", "maxAgeSeconds", "", "proxyMaxAgeSeconds", "mustRevalidate", "", "proxyRevalidate", "visibility", "Lio/ktor/http/CacheControl$Visibility;", "(ILjava/lang/Integer;ZZLio/ktor/http/CacheControl$Visibility;)V", "getMaxAgeSeconds", "()I", "getMustRevalidate", "()Z", "getProxyMaxAgeSeconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProxyRevalidate", "equals", "other", "", "hashCode", "toString", "", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CacheControl.kt */
    public static final class MaxAge extends CacheControl {
        private final int maxAgeSeconds;
        private final boolean mustRevalidate;
        private final Integer proxyMaxAgeSeconds;
        private final boolean proxyRevalidate;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ MaxAge(int i, Integer num, boolean z, boolean z2, Visibility visibility, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? null : visibility);
        }

        public final int getMaxAgeSeconds() {
            return this.maxAgeSeconds;
        }

        public final Integer getProxyMaxAgeSeconds() {
            return this.proxyMaxAgeSeconds;
        }

        public final boolean getMustRevalidate() {
            return this.mustRevalidate;
        }

        public final boolean getProxyRevalidate() {
            return this.proxyRevalidate;
        }

        public MaxAge(int i, Integer num, boolean z, boolean z2, Visibility visibility) {
            super(visibility, (DefaultConstructorMarker) null);
            this.maxAgeSeconds = i;
            this.proxyMaxAgeSeconds = num;
            this.mustRevalidate = z;
            this.proxyRevalidate = z2;
        }

        public String toString() {
            ArrayList arrayList = new ArrayList(5);
            arrayList.add("max-age=" + this.maxAgeSeconds);
            if (this.proxyMaxAgeSeconds != null) {
                arrayList.add("s-maxage=" + this.proxyMaxAgeSeconds);
            }
            if (this.mustRevalidate) {
                arrayList.add(io.ktor.client.utils.CacheControl.MUST_REVALIDATE);
            }
            if (this.proxyRevalidate) {
                arrayList.add(io.ktor.client.utils.CacheControl.PROXY_REVALIDATE);
            }
            if (getVisibility() != null) {
                arrayList.add(getVisibility().getHeaderValue$ktor_http());
            }
            return CollectionsKt.joinToString$default(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }

        public boolean equals(Object obj) {
            if (obj != this) {
                if (obj instanceof MaxAge) {
                    MaxAge maxAge = (MaxAge) obj;
                    if (!(maxAge.maxAgeSeconds == this.maxAgeSeconds && Intrinsics.areEqual(maxAge.proxyMaxAgeSeconds, this.proxyMaxAgeSeconds) && maxAge.mustRevalidate == this.mustRevalidate && maxAge.proxyRevalidate == this.proxyRevalidate && maxAge.getVisibility() == getVisibility())) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.maxAgeSeconds * 31;
            Integer num = this.proxyMaxAgeSeconds;
            int i2 = 0;
            int intValue = (((((i + (num != null ? num.intValue() : 0)) * 31) + ActivityRule$.ExternalSyntheticBackport0.m(this.mustRevalidate)) * 31) + ActivityRule$.ExternalSyntheticBackport0.m(this.proxyRevalidate)) * 31;
            Visibility visibility = getVisibility();
            if (visibility != null) {
                i2 = visibility.hashCode();
            }
            return intValue + i2;
        }
    }
}
