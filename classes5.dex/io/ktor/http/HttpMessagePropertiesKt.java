package io.ktor.http;

import io.ktor.http.LinkHeader;
import io.ktor.http.auth.HttpAuthHeader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003\u001a\u0012\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006*\u00020\u0003\u001a\u0012\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006*\u00020\u0007\u001a\u001f\u0010\u0004\u001a\u0004\u0018\u00010\b*\u00020\u00072\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0007¢\u0006\u0002\u0010\t\u001a\u0011\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u0003¢\u0006\u0002\u0010\f\u001a\u0011\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u0007¢\u0006\u0002\u0010\r\u001a\u0014\u0010\n\u001a\u00020\b*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\f\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u0003\u001a\f\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u0007\u001a\u0012\u0010\u0010\u001a\u00020\b*\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011\u001a\u0010\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0001*\u00020\u0007\u001a\f\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u0003\u001a\f\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u0007\u001a\u0012\u0010\u0017\u001a\u00020\b*\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0016\u001a\u0012\u0010\u0019\u001a\u00020\b*\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u000f\u001a\u0010\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0001*\u00020\u0003\u001a\u0012\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u0001*\u00020\u0016H\u0000\u001a\u0012\u0010\u001d\u001a\u00020\b*\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0016\u001a\u0012\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0001*\u00020\u0003\u001a\u0012\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0001*\u00020\u0007¨\u0006 "}, d2 = {"cacheControl", "", "Lio/ktor/http/HeaderValue;", "Lio/ktor/http/HttpMessage;", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "Lio/ktor/http/HttpMessageBuilder;", "", "(Lio/ktor/http/HttpMessageBuilder;Ljava/nio/charset/Charset;)Lkotlin/Unit;", "contentLength", "", "(Lio/ktor/http/HttpMessage;)Ljava/lang/Long;", "(Lio/ktor/http/HttpMessageBuilder;)Ljava/lang/Long;", "length", "", "contentType", "Lio/ktor/http/ContentType;", "type", "cookies", "Lio/ktor/http/Cookie;", "etag", "", "ifNoneMatch", "value", "maxAge", "seconds", "setCookie", "splitSetCookieHeader", "userAgent", "content", "vary", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpMessageProperties.kt */
public final class HttpMessagePropertiesKt {
    public static final void contentType(HttpMessageBuilder httpMessageBuilder, ContentType contentType) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(contentType, LinkHeader.Parameters.Type);
        httpMessageBuilder.getHeaders().set(HttpHeaders.INSTANCE.getContentType(), contentType.toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Content-Length is controlled by underlying engine. Don't specify it explicitly.")
    public static final void contentLength(HttpMessageBuilder httpMessageBuilder, int i) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        httpMessageBuilder.getHeaders().set(HttpHeaders.INSTANCE.getContentLength(), String.valueOf(i));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use content with particular content type and charset instead")
    public static final Unit charset(HttpMessageBuilder httpMessageBuilder, Charset charset) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(charset, HttpAuthHeader.Parameters.Charset);
        ContentType contentType = contentType(httpMessageBuilder);
        if (contentType == null) {
            return null;
        }
        contentType(httpMessageBuilder, ContentTypesKt.withCharset(contentType, charset));
        return Unit.INSTANCE;
    }

    public static final void maxAge(HttpMessageBuilder httpMessageBuilder, int i) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        HeadersBuilder headers = httpMessageBuilder.getHeaders();
        String cacheControl = HttpHeaders.INSTANCE.getCacheControl();
        headers.append(cacheControl, "max-age=" + i);
    }

    public static final void ifNoneMatch(HttpMessageBuilder httpMessageBuilder, String str) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, "value");
        httpMessageBuilder.getHeaders().set(HttpHeaders.INSTANCE.getIfNoneMatch(), str);
    }

    public static final void userAgent(HttpMessageBuilder httpMessageBuilder, String str) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, "content");
        httpMessageBuilder.getHeaders().set(HttpHeaders.INSTANCE.getUserAgent(), str);
    }

    public static final ContentType contentType(HttpMessageBuilder httpMessageBuilder) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        String str = httpMessageBuilder.getHeaders().get(HttpHeaders.INSTANCE.getContentType());
        if (str != null) {
            return ContentType.Companion.parse(str);
        }
        return null;
    }

    public static final Charset charset(HttpMessageBuilder httpMessageBuilder) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        ContentType contentType = contentType(httpMessageBuilder);
        if (contentType != null) {
            return ContentTypesKt.charset(contentType);
        }
        return null;
    }

    public static final String etag(HttpMessageBuilder httpMessageBuilder) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        return httpMessageBuilder.getHeaders().get(HttpHeaders.INSTANCE.getETag());
    }

    public static final List<String> vary(HttpMessageBuilder httpMessageBuilder) {
        List split$default;
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        String str = httpMessageBuilder.getHeaders().get(HttpHeaders.INSTANCE.getVary());
        if (str == null || (split$default = StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null)) == null) {
            return null;
        }
        Iterable<String> iterable = split$default;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String trim : iterable) {
            arrayList.add(StringsKt.trim((CharSequence) trim).toString());
        }
        return (List) arrayList;
    }

    public static final Long contentLength(HttpMessageBuilder httpMessageBuilder) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        String str = httpMessageBuilder.getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
        if (str != null) {
            return Long.valueOf(Long.parseLong(str));
        }
        return null;
    }

    public static final ContentType contentType(HttpMessage httpMessage) {
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        String str = httpMessage.getHeaders().get(HttpHeaders.INSTANCE.getContentType());
        if (str != null) {
            return ContentType.Companion.parse(str);
        }
        return null;
    }

    public static final Charset charset(HttpMessage httpMessage) {
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        ContentType contentType = contentType(httpMessage);
        if (contentType != null) {
            return ContentTypesKt.charset(contentType);
        }
        return null;
    }

    public static final String etag(HttpMessage httpMessage) {
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        return httpMessage.getHeaders().get(HttpHeaders.INSTANCE.getETag());
    }

    public static final List<String> vary(HttpMessage httpMessage) {
        List split$default;
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        String str = httpMessage.getHeaders().get(HttpHeaders.INSTANCE.getVary());
        if (str == null || (split$default = StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null)) == null) {
            return null;
        }
        Iterable<String> iterable = split$default;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String trim : iterable) {
            arrayList.add(StringsKt.trim((CharSequence) trim).toString());
        }
        return (List) arrayList;
    }

    public static final Long contentLength(HttpMessage httpMessage) {
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        String str = httpMessage.getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
        if (str != null) {
            return Long.valueOf(Long.parseLong(str));
        }
        return null;
    }

    public static final List<Cookie> setCookie(HttpMessage httpMessage) {
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        List<String> all = httpMessage.getHeaders().getAll(HttpHeaders.INSTANCE.getSetCookie());
        if (all == null) {
            return CollectionsKt.emptyList();
        }
        Collection arrayList = new ArrayList();
        for (String splitSetCookieHeader : all) {
            CollectionsKt.addAll(arrayList, splitSetCookieHeader(splitSetCookieHeader));
        }
        Iterable<String> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String parseServerSetCookieHeader : iterable) {
            arrayList2.add(CookieKt.parseServerSetCookieHeader(parseServerSetCookieHeader));
        }
        return (List) arrayList2;
    }

    public static final List<Cookie> cookies(HttpMessageBuilder httpMessageBuilder) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        List<String> all = httpMessageBuilder.getHeaders().getAll(HttpHeaders.INSTANCE.getSetCookie());
        if (all == null) {
            return CollectionsKt.emptyList();
        }
        Iterable<String> iterable = all;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String parseServerSetCookieHeader : iterable) {
            arrayList.add(CookieKt.parseServerSetCookieHeader(parseServerSetCookieHeader));
        }
        return (List) arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0015, code lost:
        r1 = io.ktor.http.HttpHeaderValueParserKt.parseHeaderValue(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<io.ktor.http.HeaderValue> cacheControl(io.ktor.http.HttpMessage r1) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            io.ktor.http.Headers r1 = r1.getHeaders()
            io.ktor.http.HttpHeaders r0 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r0 = r0.getCacheControl()
            java.lang.String r1 = r1.get(r0)
            if (r1 == 0) goto L_0x001b
            java.util.List r1 = io.ktor.http.HttpHeaderValueParserKt.parseHeaderValue(r1)
            if (r1 != 0) goto L_0x001f
        L_0x001b:
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
        L_0x001f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpMessagePropertiesKt.cacheControl(io.ktor.http.HttpMessage):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<java.lang.String> splitSetCookieHeader(java.lang.String r17) {
        /*
            r0 = r17
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r3 = 44
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            r2 = r1
            int r8 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r2, (char) r3, (int) r4, (boolean) r5, (int) r6, (java.lang.Object) r7)
            r9 = -1
            if (r8 != r9) goto L_0x001d
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r17)
            return r0
        L_0x001d:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r10 = r2
            java.util.List r10 = (java.util.List) r10
            r11 = 0
            r3 = 61
            r5 = 0
            r6 = 4
            r7 = 0
            r2 = r1
            r4 = r8
            int r12 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r2, (char) r3, (int) r4, (boolean) r5, (int) r6, (java.lang.Object) r7)
            r3 = 59
            int r2 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r2, (char) r3, (int) r4, (boolean) r5, (int) r6, (java.lang.Object) r7)
            r16 = r8
            r8 = r2
            r2 = r12
            r12 = r11
            r11 = r16
        L_0x003e:
            int r3 = r17.length()
            java.lang.String r13 = "this as java.lang.String).substring(startIndex)"
            if (r12 >= r3) goto L_0x00ab
            if (r11 <= 0) goto L_0x00ab
            if (r2 >= r11) goto L_0x0055
            r3 = 61
            r5 = 0
            r6 = 4
            r7 = 0
            r2 = r1
            r4 = r11
            int r2 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r2, (char) r3, (int) r4, (boolean) r5, (int) r6, (java.lang.Object) r7)
        L_0x0055:
            r14 = r2
            r3 = 44
            int r4 = r11 + 1
            r5 = 0
            r6 = 4
            r7 = 0
            r2 = r1
            int r2 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r2, (char) r3, (int) r4, (boolean) r5, (int) r6, (java.lang.Object) r7)
        L_0x0062:
            r15 = r11
            r11 = r2
            if (r11 < 0) goto L_0x0075
            if (r11 >= r14) goto L_0x0075
            r3 = 44
            int r4 = r11 + 1
            r5 = 0
            r6 = 4
            r7 = 0
            r2 = r1
            int r2 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r2, (char) r3, (int) r4, (boolean) r5, (int) r6, (java.lang.Object) r7)
            goto L_0x0062
        L_0x0075:
            if (r8 >= r15) goto L_0x0083
            r3 = 59
            r5 = 0
            r6 = 4
            r7 = 0
            r2 = r1
            r4 = r15
            int r2 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r2, (char) r3, (int) r4, (boolean) r5, (int) r6, (java.lang.Object) r7)
            r8 = r2
        L_0x0083:
            if (r14 >= 0) goto L_0x0093
            r1 = r10
            java.util.Collection r1 = (java.util.Collection) r1
            java.lang.String r0 = r0.substring(r12)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r13)
            r1.add(r0)
            return r10
        L_0x0093:
            if (r8 == r9) goto L_0x0097
            if (r8 <= r14) goto L_0x00a9
        L_0x0097:
            r2 = r10
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.String r3 = r0.substring(r12, r15)
            java.lang.String r4 = "this as java.lang.String…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r2.add(r3)
            int r15 = r15 + 1
            r12 = r15
        L_0x00a9:
            r2 = r14
            goto L_0x003e
        L_0x00ab:
            int r1 = r17.length()
            if (r12 >= r1) goto L_0x00be
            r1 = r10
            java.util.Collection r1 = (java.util.Collection) r1
            java.lang.String r0 = r0.substring(r12)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r13)
            r1.add(r0)
        L_0x00be:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.HttpMessagePropertiesKt.splitSetCookieHeader(java.lang.String):java.util.List");
    }
}
