package io.ktor.client.plugins.cookies;

import io.ktor.http.Cookie;
import io.ktor.http.Url;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lio/ktor/http/Cookie;", "invoke", "(Lio/ktor/http/Cookie;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AcceptAllCookiesStorage.kt */
final class AcceptAllCookiesStorage$addCookie$2$2 extends Lambda implements Function1<Cookie, Boolean> {
    final /* synthetic */ Cookie $cookie;
    final /* synthetic */ Url $requestUrl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AcceptAllCookiesStorage$addCookie$2$2(Cookie cookie, Url url) {
        super(1);
        this.$cookie = cookie;
        this.$requestUrl = url;
    }

    public final Boolean invoke(Cookie cookie) {
        Intrinsics.checkNotNullParameter(cookie, "it");
        return Boolean.valueOf(Intrinsics.areEqual(cookie.getName(), this.$cookie.getName()) && CookiesStorageKt.matches(cookie, this.$requestUrl));
    }
}
