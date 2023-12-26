package io.ktor.client.request;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.URLParserKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.util.AttributesKt;
import io.ktor.util.InternalAPI;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006\u001a&\u0010\u0007\u001a\u00020\b*\u00020\t2\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006H\u0002\u001a]\u0010\u0007\u001a\u00020\b*\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0019\b\u0002\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006H\u0002¢\u0006\u0002\u0010\u0011\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0007\u001a\u0012\u0010\u0015\u001a\u00020\b*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017\u001a\u0012\u0010\u0015\u001a\u00020\b*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0014\u001a#\u0010\u0018\u001a\u00020\u0005*\u00020\b2\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006\u001a\u0012\u0010\u0018\u001a\u00020\u0005*\u00020\b2\u0006\u0010\u0019\u001a\u00020\f\u001aZ\u0010\u0018\u001a\u00020\u0005*\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0019\b\u0002\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"headers", "Lio/ktor/http/HeadersBuilder;", "Lio/ktor/http/HttpMessageBuilder;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "invoke", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/request/HttpRequestBuilder$Companion;", "Lio/ktor/http/URLBuilder;", "scheme", "", "host", "port", "", "path", "(Lio/ktor/client/request/HttpRequestBuilder$Companion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lio/ktor/client/request/HttpRequestBuilder;", "isUpgradeRequest", "", "Lio/ktor/client/request/HttpRequestData;", "takeFrom", "request", "Lio/ktor/client/request/HttpRequest;", "url", "urlString", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpRequest.kt */
public final class HttpRequestKt {
    public static final HeadersBuilder headers(HttpMessageBuilder httpMessageBuilder, Function1<? super HeadersBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        HeadersBuilder headers = httpMessageBuilder.getHeaders();
        function1.invoke(headers);
        return headers;
    }

    public static final HttpRequestBuilder takeFrom(HttpRequestBuilder httpRequestBuilder, HttpRequest httpRequest) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(httpRequest, "request");
        httpRequestBuilder.setMethod(httpRequest.getMethod());
        httpRequestBuilder.setBody(httpRequest.getContent());
        httpRequestBuilder.setBodyType((TypeInfo) httpRequestBuilder.getAttributes().getOrNull(RequestBodyKt.getBodyTypeAttributeKey()));
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), httpRequest.getUrl());
        httpRequestBuilder.getHeaders().appendAll(httpRequest.getHeaders());
        AttributesKt.putAll(httpRequestBuilder.getAttributes(), httpRequest.getAttributes());
        return httpRequestBuilder;
    }

    public static final void url(HttpRequestBuilder httpRequestBuilder, Function1<? super URLBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        function1.invoke(httpRequestBuilder.getUrl());
    }

    public static final HttpRequestBuilder takeFrom(HttpRequestBuilder httpRequestBuilder, HttpRequestData httpRequestData) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(httpRequestData, "request");
        httpRequestBuilder.setMethod(httpRequestData.getMethod());
        httpRequestBuilder.setBody(httpRequestData.getBody());
        httpRequestBuilder.setBodyType((TypeInfo) httpRequestBuilder.getAttributes().getOrNull(RequestBodyKt.getBodyTypeAttributeKey()));
        URLUtilsKt.takeFrom(httpRequestBuilder.getUrl(), httpRequestData.getUrl());
        httpRequestBuilder.getHeaders().appendAll(httpRequestData.getHeaders());
        AttributesKt.putAll(httpRequestBuilder.getAttributes(), httpRequestData.getAttributes());
        return httpRequestBuilder;
    }

    public static final HttpRequestBuilder invoke(HttpRequestBuilder.Companion companion, Function1<? super URLBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        url(httpRequestBuilder, function1);
        return httpRequestBuilder;
    }

    public static /* synthetic */ void url$default(HttpRequestBuilder httpRequestBuilder, String str, String str2, Integer num, String str3, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            function1 = (Function1) HttpRequestKt$url$1.INSTANCE;
        }
        url(httpRequestBuilder, str, str2, num, str3, function1);
    }

    public static final void url(HttpRequestBuilder httpRequestBuilder, String str, String str2, Integer num, String str3, Function1<? super URLBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        URLBuilderKt.set(httpRequestBuilder.getUrl(), str, str2, num, str3, function1);
    }

    public static /* synthetic */ HttpRequestBuilder invoke$default(HttpRequestBuilder.Companion companion, String str, String str2, Integer num, String str3, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            function1 = (Function1) HttpRequestKt$invoke$2.INSTANCE;
        }
        return invoke(companion, str, str2, num, str3, function1);
    }

    public static final HttpRequestBuilder invoke(HttpRequestBuilder.Companion companion, String str, String str2, Integer num, String str3, Function1<? super URLBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        url(httpRequestBuilder, str, str2, num, str3, function1);
        return httpRequestBuilder;
    }

    public static final void url(HttpRequestBuilder httpRequestBuilder, String str) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, "urlString");
        URLParserKt.takeFrom(httpRequestBuilder.getUrl(), str);
    }

    @InternalAPI
    public static final boolean isUpgradeRequest(HttpRequestData httpRequestData) {
        Intrinsics.checkNotNullParameter(httpRequestData, "<this>");
        return httpRequestData.getBody() instanceof ClientUpgradeContent;
    }
}
