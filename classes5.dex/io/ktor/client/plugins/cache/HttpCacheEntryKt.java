package io.ktor.client.plugins.cache;

import io.ktor.client.statement.HttpResponse;
import io.ktor.client.utils.CacheControl;
import io.ktor.http.DateUtilsKt;
import io.ktor.http.HeaderValue;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessage;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.DateKt;
import io.ktor.util.date.GMTDate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u001a\u0019\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0006*\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0000\u001a\f\u0010\t\u001a\u00020\n*\u00020\u0001H\u0000\u001a\u0018\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f*\u00020\u0003H\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"HttpCacheEntry", "Lio/ktor/client/plugins/cache/HttpCacheEntry;", "response", "Lio/ktor/client/statement/HttpResponse;", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cacheExpires", "Lio/ktor/util/date/GMTDate;", "fallback", "Lkotlin/Function0;", "shouldValidate", "", "varyKeys", "", "", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpCacheEntry.kt */
public final class HttpCacheEntryKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object HttpCacheEntry(io.ktor.client.statement.HttpResponse r8, kotlin.coroutines.Continuation<? super io.ktor.client.plugins.cache.HttpCacheEntry> r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1 r0 = (io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1 r0 = new io.ktor.client.plugins.cache.HttpCacheEntryKt$HttpCacheEntry$1
            r0.<init>(r9)
        L_0x0019:
            r4 = r0
            java.lang.Object r9 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r7 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 != r7) goto L_0x002f
            java.lang.Object r8 = r4.L$0
            io.ktor.client.statement.HttpResponse r8 = (io.ktor.client.statement.HttpResponse) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x004d
        L_0x002f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.utils.io.ByteReadChannel r1 = r8.getContent()
            r2 = 0
            r5 = 1
            r6 = 0
            r4.L$0 = r8
            r4.label = r7
            java.lang.Object r9 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.readRemaining$default(r1, r2, r4, r5, r6)
            if (r9 != r0) goto L_0x004d
            return r0
        L_0x004d:
            io.ktor.utils.io.core.ByteReadPacket r9 = (io.ktor.utils.io.core.ByteReadPacket) r9
            r0 = 0
            r1 = 0
            byte[] r9 = io.ktor.utils.io.core.StringsKt.readBytes$default(r9, r0, r7, r1)
            io.ktor.client.statement.HttpResponseKt.complete(r8)
            io.ktor.client.plugins.cache.HttpCacheEntry r0 = new io.ktor.client.plugins.cache.HttpCacheEntry
            io.ktor.util.date.GMTDate r1 = cacheExpires$default(r8, r1, r7, r1)
            java.util.Map r2 = varyKeys(r8)
            r0.<init>(r1, r2, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCacheEntryKt.HttpCacheEntry(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Map<String, String> varyKeys(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        List<String> vary = HttpMessagePropertiesKt.vary((HttpMessage) httpResponse);
        if (vary == null) {
            return MapsKt.emptyMap();
        }
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        Headers headers = httpResponse.getCall().getRequest().getHeaders();
        for (String next : vary) {
            String str = headers.get(next);
            if (str == null) {
                str = "";
            }
            linkedHashMap.put(next, str);
        }
        return linkedHashMap;
    }

    public static /* synthetic */ GMTDate cacheExpires$default(HttpResponse httpResponse, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = (Function0) HttpCacheEntryKt$cacheExpires$1.INSTANCE;
        }
        return cacheExpires(httpResponse, function0);
    }

    public static final GMTDate cacheExpires(HttpResponse httpResponse, Function0<GMTDate> function0) {
        Integer num;
        Object obj;
        String value;
        List split$default;
        String str;
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        Intrinsics.checkNotNullParameter(function0, "fallback");
        List<HeaderValue> cacheControl = HttpMessagePropertiesKt.cacheControl(httpResponse);
        String str2 = cacheControl.contains(CacheControl.INSTANCE.getPRIVATE$ktor_client_core()) ? "s-max-age" : CacheControl.MAX_AGE;
        Iterator it = cacheControl.iterator();
        while (true) {
            num = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (StringsKt.startsWith$default(((HeaderValue) obj).getValue(), str2, false, 2, (Object) null)) {
                break;
            }
        }
        HeaderValue headerValue = (HeaderValue) obj;
        if (!(headerValue == null || (value = headerValue.getValue()) == null || (split$default = StringsKt.split$default((CharSequence) value, new String[]{"="}, false, 0, 6, (Object) null)) == null || (str = (String) split$default.get(1)) == null)) {
            num = Integer.valueOf(Integer.parseInt(str));
        }
        if (num != null) {
            return DateKt.plus(httpResponse.getCall().getResponse().getRequestTime(), ((long) num.intValue()) * 1000);
        }
        String str3 = httpResponse.getHeaders().get(HttpHeaders.INSTANCE.getExpires());
        if (str3 == null) {
            return (GMTDate) function0.invoke();
        }
        if (Intrinsics.areEqual(str3, "0") || StringsKt.isBlank(str3)) {
            return (GMTDate) function0.invoke();
        }
        try {
            return DateUtilsKt.fromHttpToGmtDate(str3);
        } catch (Throwable unused) {
            return (GMTDate) function0.invoke();
        }
    }

    public static final boolean shouldValidate(HttpCacheEntry httpCacheEntry) {
        List<HeaderValue> list;
        Intrinsics.checkNotNullParameter(httpCacheEntry, "<this>");
        String str = httpCacheEntry.getResponseHeaders$ktor_client_core().get(HttpHeaders.INSTANCE.getCacheControl());
        if (str == null || (list = HttpHeaderValueParserKt.parseHeaderValue(str)) == null) {
            list = CollectionsKt.emptyList();
        }
        if ((DateJvmKt.GMTDate$default((Long) null, 1, (Object) null).compareTo(httpCacheEntry.getExpires()) > 0) || list.contains(CacheControl.INSTANCE.getNO_CACHE$ktor_client_core())) {
            return true;
        }
        return false;
    }
}
