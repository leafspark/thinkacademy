package io.ktor.client.plugins.cookies;

import io.ktor.http.Cookie;
import io.ktor.http.CookieKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpCookies.kt */
/* synthetic */ class HttpCookiesKt$renderClientCookies$1 extends FunctionReferenceImpl implements Function1<Cookie, String> {
    public static final HttpCookiesKt$renderClientCookies$1 INSTANCE = new HttpCookiesKt$renderClientCookies$1();

    HttpCookiesKt$renderClientCookies$1() {
        super(1, CookieKt.class, "renderCookieHeader", "renderCookieHeader(Lio/ktor/http/Cookie;)Ljava/lang/String;", 1);
    }

    public final String invoke(Cookie cookie) {
        Intrinsics.checkNotNullParameter(cookie, "p0");
        return CookieKt.renderCookieHeader(cookie);
    }
}
