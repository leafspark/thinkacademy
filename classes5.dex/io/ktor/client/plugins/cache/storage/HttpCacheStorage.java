package io.ktor.client.plugins.cache.storage;

import io.ktor.client.plugins.cache.HttpCacheEntry;
import io.ktor.http.Url;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH&J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004H&¨\u0006\u0010"}, d2 = {"Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "", "()V", "find", "Lio/ktor/client/plugins/cache/HttpCacheEntry;", "url", "Lio/ktor/http/Url;", "varyKeys", "", "", "findByUrl", "", "store", "", "value", "Companion", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpCacheStorage.kt */
public abstract class HttpCacheStorage {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final HttpCacheStorage Disabled = DisabledCacheStorage.INSTANCE;
    /* access modifiers changed from: private */
    public static final Function0<HttpCacheStorage> Unlimited = ((Function0) HttpCacheStorage$Companion$Unlimited$1.INSTANCE);

    public abstract HttpCacheEntry find(Url url, Map<String, String> map);

    public abstract Set<HttpCacheEntry> findByUrl(Url url);

    public abstract void store(Url url, HttpCacheEntry httpCacheEntry);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/client/plugins/cache/storage/HttpCacheStorage$Companion;", "", "()V", "Disabled", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "getDisabled", "()Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "Unlimited", "Lkotlin/Function0;", "getUnlimited", "()Lkotlin/jvm/functions/Function0;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpCacheStorage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function0<HttpCacheStorage> getUnlimited() {
            return HttpCacheStorage.Unlimited;
        }

        public final HttpCacheStorage getDisabled() {
            return HttpCacheStorage.Disabled;
        }
    }
}
