package io.ktor.http;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import io.agora.rtc.Constants;
import io.ktor.http.ContentDisposition;
import io.ktor.util.date.GMTDate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b!\b\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0011¢\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u0017\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0011HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u000eHÆ\u0003J\t\u0010,\u001a\u00020\u000eHÆ\u0003J\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0011HÆ\u0001J\u0013\u0010.\u001a\u00020\u000e2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\bHÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0007\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u00062"}, d2 = {"Lio/ktor/http/Cookie;", "", "name", "", "value", "encoding", "Lio/ktor/http/CookieEncoding;", "maxAge", "", "expires", "Lio/ktor/util/date/GMTDate;", "domain", "path", "secure", "", "httpOnly", "extensions", "", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/http/CookieEncoding;ILio/ktor/util/date/GMTDate;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;)V", "getDomain", "()Ljava/lang/String;", "getEncoding", "()Lio/ktor/http/CookieEncoding;", "getExpires", "()Lio/ktor/util/date/GMTDate;", "getExtensions", "()Ljava/util/Map;", "getHttpOnly", "()Z", "getMaxAgeInt", "()I", "getName", "getPath", "getSecure", "getValue", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Cookie.kt */
public final class Cookie {
    private final String domain;
    private final CookieEncoding encoding;
    private final GMTDate expires;
    private final Map<String, String> extensions;
    private final boolean httpOnly;
    private final int maxAge;
    private final String name;
    private final String path;
    private final boolean secure;
    private final String value;

    public static /* synthetic */ Cookie copy$default(Cookie cookie, String str, String str2, CookieEncoding cookieEncoding, int i, GMTDate gMTDate, String str3, String str4, boolean z, boolean z2, Map map, int i2, Object obj) {
        Cookie cookie2 = cookie;
        int i3 = i2;
        return cookie.copy((i3 & 1) != 0 ? cookie2.name : str, (i3 & 2) != 0 ? cookie2.value : str2, (i3 & 4) != 0 ? cookie2.encoding : cookieEncoding, (i3 & 8) != 0 ? cookie2.maxAge : i, (i3 & 16) != 0 ? cookie2.expires : gMTDate, (i3 & 32) != 0 ? cookie2.domain : str3, (i3 & 64) != 0 ? cookie2.path : str4, (i3 & Constants.ERR_WATERMARK_ARGB) != 0 ? cookie2.secure : z, (i3 & 256) != 0 ? cookie2.httpOnly : z2, (i3 & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0 ? cookie2.extensions : map);
    }

    public final String component1() {
        return this.name;
    }

    public final Map<String, String> component10() {
        return this.extensions;
    }

    public final String component2() {
        return this.value;
    }

    public final CookieEncoding component3() {
        return this.encoding;
    }

    public final int component4() {
        return this.maxAge;
    }

    public final GMTDate component5() {
        return this.expires;
    }

    public final String component6() {
        return this.domain;
    }

    public final String component7() {
        return this.path;
    }

    public final boolean component8() {
        return this.secure;
    }

    public final boolean component9() {
        return this.httpOnly;
    }

    public final Cookie copy(String str, String str2, CookieEncoding cookieEncoding, int i, GMTDate gMTDate, String str3, String str4, boolean z, boolean z2, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str2, "value");
        Intrinsics.checkNotNullParameter(cookieEncoding, "encoding");
        Map<String, String> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "extensions");
        return new Cookie(str, str2, cookieEncoding, i, gMTDate, str3, str4, z, z2, map2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return Intrinsics.areEqual(this.name, cookie.name) && Intrinsics.areEqual(this.value, cookie.value) && this.encoding == cookie.encoding && this.maxAge == cookie.maxAge && Intrinsics.areEqual(this.expires, cookie.expires) && Intrinsics.areEqual(this.domain, cookie.domain) && Intrinsics.areEqual(this.path, cookie.path) && this.secure == cookie.secure && this.httpOnly == cookie.httpOnly && Intrinsics.areEqual(this.extensions, cookie.extensions);
    }

    public int hashCode() {
        int hashCode = ((((((this.name.hashCode() * 31) + this.value.hashCode()) * 31) + this.encoding.hashCode()) * 31) + this.maxAge) * 31;
        GMTDate gMTDate = this.expires;
        int i = 0;
        int hashCode2 = (hashCode + (gMTDate == null ? 0 : gMTDate.hashCode())) * 31;
        String str = this.domain;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.path;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int i2 = (hashCode3 + i) * 31;
        boolean z = this.secure;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i3 = (i2 + (z ? 1 : 0)) * 31;
        boolean z3 = this.httpOnly;
        if (!z3) {
            z2 = z3;
        }
        return ((i3 + (z2 ? 1 : 0)) * 31) + this.extensions.hashCode();
    }

    public String toString() {
        return "Cookie(name=" + this.name + ", value=" + this.value + ", encoding=" + this.encoding + ", maxAge=" + this.maxAge + ", expires=" + this.expires + ", domain=" + this.domain + ", path=" + this.path + ", secure=" + this.secure + ", httpOnly=" + this.httpOnly + ", extensions=" + this.extensions + ')';
    }

    public Cookie(String str, String str2, CookieEncoding cookieEncoding, int i, GMTDate gMTDate, String str3, String str4, boolean z, boolean z2, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str2, "value");
        Intrinsics.checkNotNullParameter(cookieEncoding, "encoding");
        Intrinsics.checkNotNullParameter(map, "extensions");
        this.name = str;
        this.value = str2;
        this.encoding = cookieEncoding;
        this.maxAge = i;
        this.expires = gMTDate;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.extensions = map;
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Cookie(java.lang.String r14, java.lang.String r15, io.ktor.http.CookieEncoding r16, int r17, io.ktor.util.date.GMTDate r18, java.lang.String r19, java.lang.String r20, boolean r21, boolean r22, java.util.Map r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r13 = this;
            r0 = r24
            r1 = r0 & 4
            if (r1 == 0) goto L_0x000a
            io.ktor.http.CookieEncoding r1 = io.ktor.http.CookieEncoding.URI_ENCODING
            r5 = r1
            goto L_0x000c
        L_0x000a:
            r5 = r16
        L_0x000c:
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0013
            r6 = r2
            goto L_0x0015
        L_0x0013:
            r6 = r17
        L_0x0015:
            r1 = r0 & 16
            r3 = 0
            if (r1 == 0) goto L_0x001c
            r7 = r3
            goto L_0x001e
        L_0x001c:
            r7 = r18
        L_0x001e:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0024
            r8 = r3
            goto L_0x0026
        L_0x0024:
            r8 = r19
        L_0x0026:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002c
            r9 = r3
            goto L_0x002e
        L_0x002c:
            r9 = r20
        L_0x002e:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0034
            r10 = r2
            goto L_0x0036
        L_0x0034:
            r10 = r21
        L_0x0036:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x003c
            r11 = r2
            goto L_0x003e
        L_0x003c:
            r11 = r22
        L_0x003e:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0048
            java.util.Map r0 = kotlin.collections.MapsKt.emptyMap()
            r12 = r0
            goto L_0x004a
        L_0x0048:
            r12 = r23
        L_0x004a:
            r2 = r13
            r3 = r14
            r4 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.Cookie.<init>(java.lang.String, java.lang.String, io.ktor.http.CookieEncoding, int, io.ktor.util.date.GMTDate, java.lang.String, java.lang.String, boolean, boolean, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final CookieEncoding getEncoding() {
        return this.encoding;
    }

    public final int getMaxAgeInt() {
        return this.maxAge;
    }

    public final GMTDate getExpires() {
        return this.expires;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getPath() {
        return this.path;
    }

    public final boolean getSecure() {
        return this.secure;
    }

    public final boolean getHttpOnly() {
        return this.httpOnly;
    }

    public final Map<String, String> getExtensions() {
        return this.extensions;
    }
}
