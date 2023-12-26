package io.ktor.client.plugins.cache.storage;

import io.ktor.client.plugins.cache.HttpCacheEntry;
import io.ktor.http.Url;
import io.ktor.util.collections.ConcurrentMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0016R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/cache/storage/UnlimitedCacheStorage;", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "()V", "store", "Lio/ktor/util/collections/ConcurrentMap;", "Lio/ktor/http/Url;", "", "Lio/ktor/client/plugins/cache/HttpCacheEntry;", "find", "url", "varyKeys", "", "", "findByUrl", "", "", "value", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnlimitedCacheStorage.kt */
public final class UnlimitedCacheStorage extends HttpCacheStorage {
    private final ConcurrentMap<Url, Set<HttpCacheEntry>> store = new ConcurrentMap<>(0, 1, (DefaultConstructorMarker) null);

    public void store(Url url, HttpCacheEntry httpCacheEntry) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(httpCacheEntry, "value");
        Set computeIfAbsent = this.store.computeIfAbsent(url, UnlimitedCacheStorage$store$data$1.INSTANCE);
        if (!computeIfAbsent.add(httpCacheEntry)) {
            computeIfAbsent.remove(httpCacheEntry);
            computeIfAbsent.add(httpCacheEntry);
        }
    }

    public HttpCacheEntry find(Url url, Map<String, String> map) {
        Object obj;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(map, "varyKeys");
        Iterator it = this.store.computeIfAbsent(url, UnlimitedCacheStorage$find$data$1.INSTANCE).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((HttpCacheEntry) obj).getVaryKeys(), map)) {
                break;
            }
        }
        return (HttpCacheEntry) obj;
    }

    public Set<HttpCacheEntry> findByUrl(Url url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Set<HttpCacheEntry> set = this.store.get(url);
        return set == null ? SetsKt.emptySet() : set;
    }
}
