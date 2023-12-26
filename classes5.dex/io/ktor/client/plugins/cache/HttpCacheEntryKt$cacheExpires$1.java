package io.ktor.client.plugins.cache;

import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/ktor/util/date/GMTDate;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpCacheEntry.kt */
final class HttpCacheEntryKt$cacheExpires$1 extends Lambda implements Function0<GMTDate> {
    public static final HttpCacheEntryKt$cacheExpires$1 INSTANCE = new HttpCacheEntryKt$cacheExpires$1();

    HttpCacheEntryKt$cacheExpires$1() {
        super(0);
    }

    public final GMTDate invoke() {
        return DateJvmKt.GMTDate$default((Long) null, 1, (Object) null);
    }
}
