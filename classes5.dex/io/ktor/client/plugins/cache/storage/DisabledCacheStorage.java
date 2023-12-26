package io.ktor.client.plugins.cache.storage;

import io.ktor.client.plugins.cache.HttpCacheEntry;
import io.ktor.http.Url;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/cache/storage/DisabledCacheStorage;", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "()V", "find", "Lio/ktor/client/plugins/cache/HttpCacheEntry;", "url", "Lio/ktor/http/Url;", "varyKeys", "", "", "findByUrl", "", "store", "", "value", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DisabledCacheStorage.kt */
public final class DisabledCacheStorage extends HttpCacheStorage {
    public static final DisabledCacheStorage INSTANCE = new DisabledCacheStorage();

    public HttpCacheEntry find(Url url, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(map, "varyKeys");
        return null;
    }

    public void store(Url url, HttpCacheEntry httpCacheEntry) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(httpCacheEntry, "value");
    }

    private DisabledCacheStorage() {
    }

    public Set<HttpCacheEntry> findByUrl(Url url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return SetsKt.emptySet();
    }
}
