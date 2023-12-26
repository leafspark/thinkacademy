package io.ktor.client.plugins.cookies;

import io.ktor.http.Cookie;
import io.ktor.http.Parameters;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLProtocol;
import io.ktor.http.Url;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J!\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\tH\u0016J\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/cookies/ConstantCookiesStorage;", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "cookies", "", "Lio/ktor/http/Cookie;", "([Lio/ktor/http/Cookie;)V", "storage", "", "addCookie", "", "requestUrl", "Lio/ktor/http/Url;", "cookie", "(Lio/ktor/http/Url;Lio/ktor/http/Cookie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "get", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConstantCookiesStorage.kt */
public final class ConstantCookiesStorage implements CookiesStorage {
    private final List<Cookie> storage;

    public void close() {
    }

    public ConstantCookiesStorage(Cookie... cookieArr) {
        Cookie[] cookieArr2 = cookieArr;
        Intrinsics.checkNotNullParameter(cookieArr2, "cookies");
        Collection arrayList = new ArrayList(cookieArr2.length);
        for (Cookie fillDefaults : cookieArr2) {
            arrayList.add(CookiesStorageKt.fillDefaults(fillDefaults, new URLBuilder((URLProtocol) null, (String) null, 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 511, (DefaultConstructorMarker) null).build()));
        }
        this.storage = CollectionsKt.toList((List) arrayList);
    }

    public Object get(Url url, Continuation<? super List<Cookie>> continuation) {
        Collection arrayList = new ArrayList();
        for (Object next : this.storage) {
            if (CookiesStorageKt.matches((Cookie) next, url)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public Object addCookie(Url url, Cookie cookie, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }
}
