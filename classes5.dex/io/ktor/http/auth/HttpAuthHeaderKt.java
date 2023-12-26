package io.ktor.http.auth;

import io.ktor.http.CookieUtilsKt;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.http.parsing.ParseException;
import io.ktor.util.date.GMTDateParser;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\"\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a,\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\rH\u0002\u001a$\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002\u001a\u001a\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002\u001a\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\n\u001a\f\u0010\u0013\u001a\u00020\u0014*\u00020\u0002H\u0002\u001a\f\u0010\u0015\u001a\u00020\u0014*\u00020\u0002H\u0002\u001a\u001c\u0010\u0016\u001a\u00020\b*\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0002H\u0002\u001a\u0014\u0010\u0018\u001a\u00020\b*\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002\u001a\f\u0010\u0019\u001a\u00020\n*\u00020\nH\u0002\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"TOKEN68_EXTRA", "", "", "TOKEN_EXTRA", "escapeRegex", "Lkotlin/text/Regex;", "token68Pattern", "matchParameter", "", "headerValue", "", "startIndex", "parameters", "", "matchParameters", "", "matchToken68", "parseAuthorizationHeader", "Lio/ktor/http/auth/HttpAuthHeader;", "isToken", "", "isToken68", "skipDelimiter", "delimiter", "skipSpaces", "unescaped", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpAuthHeader.kt */
public final class HttpAuthHeaderKt {
    private static final Set<Character> TOKEN68_EXTRA = SetsKt.setOf(new Character[]{'-', '.', '_', '~', '+', '/'});
    private static final Set<Character> TOKEN_EXTRA = SetsKt.setOf(new Character[]{'!', '#', Character.valueOf(Typography.dollar), '%', Character.valueOf(Typography.amp), '\'', Character.valueOf(GMTDateParser.ANY), '+', '-', '.', '^', '_', '`', '|', '~'});
    private static final Regex escapeRegex = new Regex("\\\\.");
    /* access modifiers changed from: private */
    public static final Regex token68Pattern = new Regex("[a-zA-Z0-9\\-._~+/]+=*");

    public static final HttpAuthHeader parseAuthorizationHeader(String str) {
        Intrinsics.checkNotNullParameter(str, "headerValue");
        int skipSpaces = skipSpaces(str, 0);
        int i = skipSpaces;
        while (i < str.length() && isToken(str.charAt(i))) {
            i++;
        }
        String substring = StringsKt.substring(str, RangesKt.until(skipSpaces, i));
        int skipSpaces2 = skipSpaces(str, i);
        if (StringsKt.isBlank(substring)) {
            return null;
        }
        if (str.length() == skipSpaces2) {
            return new HttpAuthHeader.Parameterized(substring, CollectionsKt.emptyList(), (HeaderValueEncoding) null, 4, (DefaultConstructorMarker) null);
        }
        String matchToken68 = matchToken68(str, skipSpaces2);
        if (matchToken68 != null) {
            return new HttpAuthHeader.Single(substring, matchToken68);
        }
        return new HttpAuthHeader.Parameterized(substring, (Map) matchParameters(str, skipSpaces2), (HeaderValueEncoding) null, 4, (DefaultConstructorMarker) null);
    }

    private static final Map<String, String> matchParameters(String str, int i) {
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        while (i > 0 && i < str.length()) {
            i = skipDelimiter(str, matchParameter(str, i, linkedHashMap), ',');
        }
        return linkedHashMap;
    }

    private static final int matchParameter(String str, int i, Map<String, String> map) {
        int i2;
        int skipSpaces = skipSpaces(str, i);
        int i3 = skipSpaces;
        while (i3 < str.length() && isToken(str.charAt(i3))) {
            i3++;
        }
        String substring = StringsKt.substring(str, RangesKt.until(skipSpaces, i3));
        int skipSpaces2 = skipSpaces(str, i3);
        if (skipSpaces2 >= str.length() || str.charAt(skipSpaces2) != '=') {
            throw new ParseException("Expected `=` after parameter key '" + substring + "': " + str, (Throwable) null, 2, (DefaultConstructorMarker) null);
        }
        boolean z = true;
        int skipSpaces3 = skipSpaces(str, skipSpaces2 + 1);
        if (str.charAt(skipSpaces3) == '\"') {
            skipSpaces3++;
            i2 = skipSpaces3;
            boolean z2 = false;
            while (i2 < str.length() && (str.charAt(i2) != '\"' || z2)) {
                z2 = !z2 && str.charAt(i2) == '\\';
                i2++;
            }
            if (i2 == str.length()) {
                throw new ParseException("Expected closing quote'\"' in parameter: " + str + ' ', (Throwable) null, 2, (DefaultConstructorMarker) null);
            }
        } else {
            int i4 = skipSpaces3;
            while (i2 < str.length() && str.charAt(i2) != ' ' && str.charAt(i2) != ',') {
                i4 = i2 + 1;
            }
            z = false;
        }
        String substring2 = StringsKt.substring(str, RangesKt.until(skipSpaces3, i2));
        if (z) {
            substring2 = unescaped(substring2);
        }
        map.put(substring, substring2);
        return z ? i2 + 1 : i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.String matchToken68(java.lang.String r6, int r7) {
        /*
            r0 = r7
        L_0x0001:
            int r1 = r6.length()
            if (r0 >= r1) goto L_0x0014
            char r1 = r6.charAt(r0)
            boolean r1 = isToken68(r1)
            if (r1 == 0) goto L_0x0014
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0014:
            int r1 = r6.length()
            if (r0 >= r1) goto L_0x0025
            char r1 = r6.charAt(r0)
            r2 = 61
            if (r1 != r2) goto L_0x0025
            int r0 = r0 + 1
            goto L_0x0014
        L_0x0025:
            int r1 = r6.length()
            kotlin.ranges.IntRange r1 = kotlin.ranges.RangesKt.until(r0, r1)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r2 = r1 instanceof java.util.Collection
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0040
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0040
        L_0x003e:
            r3 = r4
            goto L_0x005e
        L_0x0040:
            java.util.Iterator r1 = r1.iterator()
        L_0x0044:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x003e
            r2 = r1
            kotlin.collections.IntIterator r2 = (kotlin.collections.IntIterator) r2
            int r2 = r2.nextInt()
            char r2 = r6.charAt(r2)
            r5 = 32
            if (r2 != r5) goto L_0x005b
            r2 = r4
            goto L_0x005c
        L_0x005b:
            r2 = r3
        L_0x005c:
            if (r2 != 0) goto L_0x0044
        L_0x005e:
            if (r3 == 0) goto L_0x0069
            kotlin.ranges.IntRange r7 = kotlin.ranges.RangesKt.until(r7, r0)
            java.lang.String r6 = kotlin.text.StringsKt.substring((java.lang.String) r6, (kotlin.ranges.IntRange) r7)
            return r6
        L_0x0069:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.auth.HttpAuthHeaderKt.matchToken68(java.lang.String, int):java.lang.String");
    }

    private static final String unescaped(String str) {
        return escapeRegex.replace((CharSequence) str, (Function1<? super MatchResult, ? extends CharSequence>) HttpAuthHeaderKt$unescaped$1.INSTANCE);
    }

    private static final int skipDelimiter(String str, int i, char c) {
        int skipSpaces = skipSpaces(str, i);
        while (skipSpaces < str.length() && str.charAt(skipSpaces) != c) {
            skipSpaces++;
        }
        if (skipSpaces == str.length()) {
            return -1;
        }
        return skipSpaces(str, skipSpaces + 1);
    }

    private static final int skipSpaces(String str, int i) {
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        return i;
    }

    private static final boolean isToken68(char c) {
        if ('a' <= c && c < '{') {
            return true;
        }
        return ('A' <= c && c < '[') || CookieUtilsKt.isDigit(c) || TOKEN68_EXTRA.contains(Character.valueOf(c));
    }

    private static final boolean isToken(char c) {
        if ('a' <= c && c < '{') {
            return true;
        }
        return ('A' <= c && c < '[') || CookieUtilsKt.isDigit(c) || TOKEN_EXTRA.contains(Character.valueOf(c));
    }
}
