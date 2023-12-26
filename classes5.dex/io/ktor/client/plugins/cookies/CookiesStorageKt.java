package io.ktor.client.plugins.cookies;

import io.ktor.http.Cookie;
import io.ktor.http.CookieEncoding;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.date.GMTDate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0014\u0010\b\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0014\u0010\u000b\u001a\u00020\f*\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"addCookie", "", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "urlString", "", "cookie", "Lio/ktor/http/Cookie;", "(Lio/ktor/client/plugins/cookies/CookiesStorage;Ljava/lang/String;Lio/ktor/http/Cookie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fillDefaults", "requestUrl", "Lio/ktor/http/Url;", "matches", "", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CookiesStorage.kt */
public final class CookiesStorageKt {
    public static final Object addCookie(CookiesStorage cookiesStorage, String str, Cookie cookie, Continuation<? super Unit> continuation) {
        Object addCookie = cookiesStorage.addCookie(URLUtilsKt.Url(str), cookie, continuation);
        return addCookie == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? addCookie : Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0092, code lost:
        if (kotlin.text.StringsKt.endsWith$default(r5, '.' + r0, false, 2, (java.lang.Object) null) == false) goto L_0x0094;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean matches(io.ktor.http.Cookie r11, io.ktor.http.Url r12) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "requestUrl"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = r11.getDomain()
            if (r0 == 0) goto L_0x00c9
            java.lang.String r0 = io.ktor.util.TextKt.toLowerCasePreservingASCIIRules(r0)
            if (r0 == 0) goto L_0x00c9
            r1 = 1
            char[] r2 = new char[r1]
            r3 = 0
            r4 = 46
            r2[r3] = r4
            java.lang.String r0 = kotlin.text.StringsKt.trimStart((java.lang.String) r0, (char[]) r2)
            if (r0 == 0) goto L_0x00c9
            r11.getPath()
            java.lang.String r2 = r11.getPath()
            if (r2 == 0) goto L_0x00bd
            r5 = r2
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6 = 47
            r7 = 2
            r8 = 0
            boolean r5 = kotlin.text.StringsKt.endsWith$default((java.lang.CharSequence) r5, (char) r6, (boolean) r3, (int) r7, (java.lang.Object) r8)
            if (r5 == 0) goto L_0x003b
            goto L_0x004e
        L_0x003b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = r11.getPath()
            r2.append(r5)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
        L_0x004e:
            java.lang.String r5 = r12.getHost()
            java.lang.String r5 = io.ktor.util.TextKt.toLowerCasePreservingASCIIRules(r5)
            java.lang.String r9 = r12.getEncodedPath()
            r10 = r9
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = kotlin.text.StringsKt.endsWith$default((java.lang.CharSequence) r10, (char) r6, (boolean) r3, (int) r7, (java.lang.Object) r8)
            if (r10 == 0) goto L_0x0064
            goto L_0x0073
        L_0x0064:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r9)
            r10.append(r6)
            java.lang.String r9 = r10.toString()
        L_0x0073:
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r0)
            if (r6 != 0) goto L_0x0095
            boolean r6 = io.ktor.http.IpParserKt.hostIsIp(r5)
            if (r6 != 0) goto L_0x0094
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            boolean r0 = kotlin.text.StringsKt.endsWith$default(r5, r0, r3, r7, r8)
            if (r0 != 0) goto L_0x0095
        L_0x0094:
            return r3
        L_0x0095:
            java.lang.String r0 = "/"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r0)
            if (r0 != 0) goto L_0x00aa
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r2)
            if (r0 != 0) goto L_0x00aa
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r9, r2, r3, r7, r8)
            if (r0 != 0) goto L_0x00aa
            return r3
        L_0x00aa:
            boolean r11 = r11.getSecure()
            if (r11 == 0) goto L_0x00bc
            io.ktor.http.URLProtocol r11 = r12.getProtocol()
            boolean r11 = io.ktor.http.URLProtocolKt.isSecure(r11)
            if (r11 == 0) goto L_0x00bb
            goto L_0x00bc
        L_0x00bb:
            r1 = r3
        L_0x00bc:
            return r1
        L_0x00bd:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "Path field should have the default value"
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x00c9:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "Domain field should have the default value"
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.CookiesStorageKt.matches(io.ktor.http.Cookie, io.ktor.http.Url):boolean");
    }

    public static final Cookie fillDefaults(Cookie cookie, Url url) {
        boolean z;
        Cookie cookie2 = cookie;
        Intrinsics.checkNotNullParameter(cookie2, "<this>");
        Intrinsics.checkNotNullParameter(url, "requestUrl");
        String path = cookie.getPath();
        boolean z2 = true;
        if (!(path != null && StringsKt.startsWith$default(path, "/", false, 2, (Object) null))) {
            z = false;
            cookie2 = Cookie.copy$default(cookie, (String) null, (String) null, (CookieEncoding) null, 0, (GMTDate) null, (String) null, url.getEncodedPath(), false, false, (Map) null, 959, (Object) null);
        } else {
            z = false;
        }
        CharSequence domain = cookie2.getDomain();
        if (domain != null && !StringsKt.isBlank(domain)) {
            z2 = z;
        }
        return z2 ? Cookie.copy$default(cookie2, (String) null, (String) null, (CookieEncoding) null, 0, (GMTDate) null, url.getHost(), (String) null, false, false, (Map) null, 991, (Object) null) : cookie2;
    }
}
