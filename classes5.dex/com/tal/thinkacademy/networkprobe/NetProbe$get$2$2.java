package com.tal.thinkacademy.networkprobe;

import com.tal.thinkacademy.networkprobe.cache.NetworkTraceCache;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.UtilsKt;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLBuilderKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lio/ktor/http/URLBuilder;", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetProbe.kt */
final class NetProbe$get$2$2 extends Lambda implements Function2<URLBuilder, URLBuilder, Unit> {
    final /* synthetic */ Map<String, String> $params;
    final /* synthetic */ String $path;
    final /* synthetic */ HttpRequestBuilder $this_get;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetProbe$get$2$2(String str, Map<String, String> map, HttpRequestBuilder httpRequestBuilder) {
        super(2);
        this.$path = str;
        this.$params = map;
        this.$this_get = httpRequestBuilder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((URLBuilder) obj, (URLBuilder) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(URLBuilder uRLBuilder, URLBuilder uRLBuilder2) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "$this$url");
        Intrinsics.checkNotNullParameter(uRLBuilder2, "it");
        String str = this.$path;
        if (!(str.length() > 0)) {
            str = null;
        }
        if (str != null) {
            URLBuilderKt.path(uRLBuilder, str);
        }
        Map<String, String> map = this.$params;
        if (map != null) {
            HttpRequestBuilder httpRequestBuilder = this.$this_get;
            for (Map.Entry next : map.entrySet()) {
                UtilsKt.parameter(httpRequestBuilder, (String) next.getKey(), (String) next.getValue());
            }
        }
        UtilsKt.parameter(this.$this_get, NetworkTraceCache.TRACE_REQUEST_ID, Utils.INSTANCE.getUuid());
    }
}
