package io.ktor.client.request;

import io.agora.rtc.Constants;
import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.Cookie;
import io.ktor.http.CookieEncoding;
import io.ktor.http.CookieKt;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.util.Base64Kt;
import io.ktor.util.date.GMTDate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0012\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u001a\u0010\u0013\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001\u001a\u0012\u0010\u0016\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0001\u001at\u0010\u0018\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u001a\u001a\u00020\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020 2\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010#\u001a\u001c\u0010$\u001a\u00020\u000f*\u00020\u00102\u0006\u0010%\u001a\u00020\u00012\b\u0010\u0000\u001a\u0004\u0018\u00010&\u001a\u001c\u0010'\u001a\u00020\u000f*\u00020\u00032\u0006\u0010%\u001a\u00020\u00012\b\u0010\u0000\u001a\u0004\u0018\u00010&\"(\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"(\u0010\t\u001a\u00020\b*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\b8F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006("}, d2 = {"value", "", "host", "Lio/ktor/client/request/HttpRequestBuilder;", "getHost", "(Lio/ktor/client/request/HttpRequestBuilder;)Ljava/lang/String;", "setHost", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/String;)V", "", "port", "getPort", "(Lio/ktor/client/request/HttpRequestBuilder;)I", "setPort", "(Lio/ktor/client/request/HttpRequestBuilder;I)V", "accept", "", "Lio/ktor/http/HttpMessageBuilder;", "contentType", "Lio/ktor/http/ContentType;", "basicAuth", "username", "password", "bearerAuth", "token", "cookie", "name", "maxAge", "expires", "Lio/ktor/util/date/GMTDate;", "domain", "path", "secure", "", "httpOnly", "extensions", "", "header", "key", "", "parameter", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: utils.kt */
public final class UtilsKt {
    public static final String getHost(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return httpRequestBuilder.getUrl().getHost();
    }

    public static final void setHost(HttpRequestBuilder httpRequestBuilder, String str) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, "value");
        httpRequestBuilder.getUrl().setHost(str);
    }

    public static final int getPort(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return httpRequestBuilder.getUrl().getPort();
    }

    public static final void setPort(HttpRequestBuilder httpRequestBuilder, int i) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        httpRequestBuilder.getUrl().setPort(i);
    }

    public static final void header(HttpMessageBuilder httpMessageBuilder, String str, Object obj) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        if (obj != null) {
            httpMessageBuilder.getHeaders().append(str, obj.toString());
            Unit unit = Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void cookie$default(HttpMessageBuilder httpMessageBuilder, String str, String str2, int i, GMTDate gMTDate, String str3, String str4, boolean z, boolean z2, Map map, int i2, Object obj) {
        Map map2;
        int i3 = i2;
        int i4 = (i3 & 4) != 0 ? 0 : i;
        GMTDate gMTDate2 = (i3 & 8) != 0 ? null : gMTDate;
        String str5 = (i3 & 16) != 0 ? null : str3;
        String str6 = (i3 & 32) != 0 ? null : str4;
        boolean z3 = (i3 & 64) != 0 ? false : z;
        boolean z4 = (i3 & Constants.ERR_WATERMARK_ARGB) != 0 ? false : z2;
        if ((i3 & 256) != 0) {
            map2 = MapsKt.emptyMap();
        } else {
            map2 = map;
        }
        cookie(httpMessageBuilder, str, str2, i4, gMTDate2, str5, str6, z3, z4, map2);
    }

    public static final void cookie(HttpMessageBuilder httpMessageBuilder, String str, String str2, int i, GMTDate gMTDate, String str3, String str4, boolean z, boolean z2, Map<String, String> map) {
        HttpMessageBuilder httpMessageBuilder2 = httpMessageBuilder;
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        String str5 = str;
        Intrinsics.checkNotNullParameter(str5, ContentDisposition.Parameters.Name);
        String str6 = str2;
        Intrinsics.checkNotNullParameter(str6, "value");
        Map<String, String> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "extensions");
        String renderCookieHeader = CookieKt.renderCookieHeader(new Cookie(str5, str6, (CookieEncoding) null, i, gMTDate, str3, str4, z, z2, map2, 4, (DefaultConstructorMarker) null));
        if (!httpMessageBuilder.getHeaders().contains(HttpHeaders.INSTANCE.getCookie())) {
            httpMessageBuilder.getHeaders().append(HttpHeaders.INSTANCE.getCookie(), renderCookieHeader);
            return;
        }
        HeadersBuilder headers = httpMessageBuilder.getHeaders();
        String cookie = HttpHeaders.INSTANCE.getCookie();
        headers.set(cookie, httpMessageBuilder.getHeaders().get(HttpHeaders.INSTANCE.getCookie()) + "; " + renderCookieHeader);
    }

    public static final void parameter(HttpRequestBuilder httpRequestBuilder, String str, Object obj) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        if (obj != null) {
            httpRequestBuilder.getUrl().getParameters().append(str, obj.toString());
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final void accept(HttpMessageBuilder httpMessageBuilder, ContentType contentType) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        httpMessageBuilder.getHeaders().append(HttpHeaders.INSTANCE.getAccept(), contentType.toString());
    }

    public static final void basicAuth(HttpMessageBuilder httpMessageBuilder, String str, String str2) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, "username");
        Intrinsics.checkNotNullParameter(str2, "password");
        String authorization = HttpHeaders.INSTANCE.getAuthorization();
        StringBuilder sb = new StringBuilder();
        sb.append("Basic ");
        sb.append(Base64Kt.encodeBase64(str + ':' + str2));
        header(httpMessageBuilder, authorization, sb.toString());
    }

    public static final void bearerAuth(HttpMessageBuilder httpMessageBuilder, String str) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, "token");
        String authorization = HttpHeaders.INSTANCE.getAuthorization();
        header(httpMessageBuilder, authorization, "Bearer " + str);
    }
}
