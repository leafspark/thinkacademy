package io.ktor.client.plugins.cache;

import io.ktor.http.content.OutgoingContent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "header", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpCache.kt */
final class HttpCacheKt$mergedHeadersLookup$1 extends Lambda implements Function1<String, String> {
    final /* synthetic */ Function1<String, List<String>> $allHeadersExtractor;
    final /* synthetic */ OutgoingContent $content;
    final /* synthetic */ Function1<String, String> $headerExtractor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpCacheKt$mergedHeadersLookup$1(OutgoingContent outgoingContent, Function1<? super String, String> function1, Function1<? super String, ? extends List<String>> function12) {
        super(1);
        this.$content = outgoingContent;
        this.$headerExtractor = function1;
        this.$allHeadersExtractor = function12;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.util.List<java.lang.String>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String invoke(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "header"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            io.ktor.http.HttpHeaders r0 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r0 = r0.getContentLength()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r0)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0026
            io.ktor.http.content.OutgoingContent r11 = r10.$content
            java.lang.Long r11 = r11.getContentLength()
            if (r11 == 0) goto L_0x00a4
            java.lang.String r11 = r11.toString()
            if (r11 != 0) goto L_0x0023
            goto L_0x00a4
        L_0x0023:
            r1 = r11
            goto L_0x00a4
        L_0x0026:
            io.ktor.http.HttpHeaders r0 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r0 = r0.getContentType()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r0)
            if (r0 == 0) goto L_0x0041
            io.ktor.http.content.OutgoingContent r11 = r10.$content
            io.ktor.http.ContentType r11 = r11.getContentType()
            if (r11 == 0) goto L_0x00a4
            java.lang.String r11 = r11.toString()
            if (r11 != 0) goto L_0x0023
            goto L_0x00a4
        L_0x0041:
            io.ktor.http.HttpHeaders r0 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r0 = r0.getUserAgent()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r0)
            if (r0 == 0) goto L_0x0075
            io.ktor.http.content.OutgoingContent r11 = r10.$content
            io.ktor.http.Headers r11 = r11.getHeaders()
            io.ktor.http.HttpHeaders r0 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r0 = r0.getUserAgent()
            java.lang.String r1 = r11.get(r0)
            if (r1 != 0) goto L_0x00a4
            kotlin.jvm.functions.Function1<java.lang.String, java.lang.String> r11 = r10.$headerExtractor
            io.ktor.http.HttpHeaders r0 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r0 = r0.getUserAgent()
            java.lang.Object r11 = r11.invoke(r0)
            r1 = r11
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x00a4
            java.lang.String r1 = io.ktor.client.engine.UtilsKt.getKTOR_DEFAULT_USER_AGENT()
            goto L_0x00a4
        L_0x0075:
            io.ktor.http.content.OutgoingContent r0 = r10.$content
            io.ktor.http.Headers r0 = r0.getHeaders()
            java.util.List r0 = r0.getAll(r11)
            if (r0 != 0) goto L_0x0090
            kotlin.jvm.functions.Function1<java.lang.String, java.util.List<java.lang.String>> r0 = r10.$allHeadersExtractor
            java.lang.Object r11 = r0.invoke(r11)
            r0 = r11
            java.util.List r0 = (java.util.List) r0
            if (r0 != 0) goto L_0x0090
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0090:
            r1 = r0
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.lang.String r11 = ";"
            r2 = r11
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 62
            r9 = 0
            java.lang.String r1 = kotlin.collections.CollectionsKt.joinToString$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x00a4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCacheKt$mergedHeadersLookup$1.invoke(java.lang.String):java.lang.String");
    }
}
