package io.ktor.client.plugins.cookies;

import io.ktor.client.HttpClient;
import io.ktor.http.Cookie;
import io.ktor.http.Url;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookiesKt", f = "HttpCookies.kt", i = {}, l = {127}, m = "cookies", n = {}, s = {})
/* compiled from: HttpCookies.kt */
final class HttpCookiesKt$cookies$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    HttpCookiesKt$cookies$1(Continuation<? super HttpCookiesKt$cookies$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HttpCookiesKt.cookies((HttpClient) null, (Url) null, (Continuation<? super List<Cookie>>) (Continuation) this);
    }
}
