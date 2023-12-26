package io.ktor.http;

import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a \u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a$\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a\u001c\u0010\u0010\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u000bH\u0002\u001a,\u0010\u0013\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002\u001a$\u0010\u0015\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a$\u0010\u0016\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a$\u0010\u0017\u001a\u00020\u0006*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002\u001a\u0012\u0010\u0018\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0002\u001a\u0014\u0010\u0019\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u001a"}, d2 = {"ROOT_PATH", "", "", "getROOT_PATH", "()Ljava/util/List;", "count", "", "urlString", "startIndex", "endIndex", "char", "", "findScheme", "fillHost", "", "Lio/ktor/http/URLBuilder;", "indexOfColonInHostPort", "isLetter", "", "parseFile", "slashCount", "parseFragment", "parseMailto", "parseQuery", "takeFrom", "takeFromUnsafe", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: URLParser.kt */
public final class URLParserKt {
    private static final List<String> ROOT_PATH = CollectionsKt.listOf("");

    public static final List<String> getROOT_PATH() {
        return ROOT_PATH;
    }

    public static final URLBuilder takeFrom(URLBuilder uRLBuilder, String str) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(str, "urlString");
        if (StringsKt.isBlank(str)) {
            return uRLBuilder;
        }
        try {
            return takeFromUnsafe(uRLBuilder, str);
        } catch (Throwable th) {
            throw new URLParserException(str, th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final io.ktor.http.URLBuilder takeFromUnsafe(io.ktor.http.URLBuilder r18, java.lang.String r19) {
        /*
            r0 = r18
            r1 = r19
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "urlString"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r3 = r2.length()
            r4 = 0
        L_0x0016:
            r10 = -1
            r11 = 1
            if (r4 >= r3) goto L_0x0029
            char r5 = r2.charAt(r4)
            boolean r5 = kotlin.text.CharsKt.isWhitespace(r5)
            r5 = r5 ^ r11
            if (r5 == 0) goto L_0x0026
            goto L_0x002a
        L_0x0026:
            int r4 = r4 + 1
            goto L_0x0016
        L_0x0029:
            r4 = r10
        L_0x002a:
            int r3 = r2.length()
            int r3 = r3 + r10
            if (r3 < 0) goto L_0x0044
        L_0x0031:
            int r5 = r3 + -1
            char r6 = r2.charAt(r3)
            boolean r6 = kotlin.text.CharsKt.isWhitespace(r6)
            r6 = r6 ^ r11
            if (r6 == 0) goto L_0x003f
            goto L_0x0045
        L_0x003f:
            if (r5 >= 0) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            r3 = r5
            goto L_0x0031
        L_0x0044:
            r3 = r10
        L_0x0045:
            int r12 = r3 + 1
            int r3 = findScheme(r1, r4, r12)
            java.lang.String r13 = "this as java.lang.String…ing(startIndex, endIndex)"
            if (r3 <= 0) goto L_0x0063
            int r5 = r4 + r3
            java.lang.String r5 = r1.substring(r4, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r13)
            io.ktor.http.URLProtocol$Companion r6 = io.ktor.http.URLProtocol.Companion
            io.ktor.http.URLProtocol r5 = r6.createOrDefault(r5)
            r0.setProtocol(r5)
            int r3 = r3 + r11
            int r4 = r4 + r3
        L_0x0063:
            r14 = 47
            int r15 = count(r1, r4, r12, r14)
            int r4 = r4 + r15
            io.ktor.http.URLProtocol r3 = r18.getProtocol()
            java.lang.String r3 = r3.getName()
            java.lang.String r5 = "file"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r5)
            if (r3 == 0) goto L_0x007e
            parseFile(r0, r1, r4, r12, r15)
            return r0
        L_0x007e:
            io.ktor.http.URLProtocol r3 = r18.getProtocol()
            java.lang.String r3 = r3.getName()
            java.lang.String r5 = "mailto"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r5)
            if (r3 == 0) goto L_0x00a5
            if (r15 != 0) goto L_0x0092
            r9 = r11
            goto L_0x0093
        L_0x0092:
            r9 = 0
        L_0x0093:
            if (r9 == 0) goto L_0x0099
            parseMailto(r0, r1, r4, r12)
            return r0
        L_0x0099:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Failed requirement."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00a5:
            r3 = 2
            r16 = 0
            if (r15 < r3) goto L_0x0113
            r8 = r4
        L_0x00ab:
            java.lang.String r3 = "@/\\?#"
            char[] r4 = io.ktor.util.CharsetKt.toCharArray(r3)
            r6 = 0
            r7 = 4
            r17 = 0
            r3 = r2
            r5 = r8
            r9 = r8
            r8 = r17
            int r3 = kotlin.text.StringsKt.indexOfAny$default((java.lang.CharSequence) r3, (char[]) r4, (int) r5, (boolean) r6, (int) r7, (java.lang.Object) r8)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = r3
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            if (r4 <= 0) goto L_0x00cd
            r4 = r11
            goto L_0x00ce
        L_0x00cd:
            r4 = 0
        L_0x00ce:
            if (r4 == 0) goto L_0x00d1
            goto L_0x00d3
        L_0x00d1:
            r3 = r16
        L_0x00d3:
            if (r3 == 0) goto L_0x00db
            int r3 = r3.intValue()
            r4 = r3
            goto L_0x00dc
        L_0x00db:
            r4 = r12
        L_0x00dc:
            if (r4 >= r12) goto L_0x0110
            char r3 = r1.charAt(r4)
            r5 = 64
            if (r3 != r5) goto L_0x0110
            int r3 = indexOfColonInHostPort(r1, r9, r4)
            if (r3 == r10) goto L_0x0103
            java.lang.String r5 = r1.substring(r9, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r13)
            r0.setEncodedUser(r5)
            int r3 = r3 + 1
            java.lang.String r3 = r1.substring(r3, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r0.setEncodedPassword(r3)
            goto L_0x010d
        L_0x0103:
            java.lang.String r3 = r1.substring(r9, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            r0.setEncodedUser(r3)
        L_0x010d:
            int r8 = r4 + 1
            goto L_0x00ab
        L_0x0110:
            fillHost(r0, r1, r9, r4)
        L_0x0113:
            r9 = r4
            if (r9 < r12) goto L_0x0128
            int r12 = r12 - r11
            char r1 = r1.charAt(r12)
            if (r1 != r14) goto L_0x0120
            java.util.List<java.lang.String> r1 = ROOT_PATH
            goto L_0x0124
        L_0x0120:
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0124:
            r0.setEncodedPathSegments(r1)
            return r0
        L_0x0128:
            if (r15 != 0) goto L_0x0133
            java.util.List r3 = r18.getEncodedPathSegments()
            java.util.List r3 = kotlin.collections.CollectionsKt.dropLast(r3, r11)
            goto L_0x0137
        L_0x0133:
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0137:
            r0.setEncodedPathSegments(r3)
            java.lang.String r3 = "?#"
            char[] r4 = io.ktor.util.CharsetKt.toCharArray(r3)
            r6 = 0
            r7 = 4
            r8 = 0
            r3 = r2
            r5 = r9
            int r2 = kotlin.text.StringsKt.indexOfAny$default((java.lang.CharSequence) r3, (char[]) r4, (int) r5, (boolean) r6, (int) r7, (java.lang.Object) r8)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = r2
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            if (r3 <= 0) goto L_0x0158
            r3 = r11
            goto L_0x0159
        L_0x0158:
            r3 = 0
        L_0x0159:
            if (r3 == 0) goto L_0x015d
            r16 = r2
        L_0x015d:
            if (r16 == 0) goto L_0x0164
            int r2 = r16.intValue()
            goto L_0x0165
        L_0x0164:
            r2 = r12
        L_0x0165:
            if (r2 <= r9) goto L_0x01ce
            java.lang.String r3 = r1.substring(r9, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)
            java.util.List r4 = r18.getEncodedPathSegments()
            int r4 = r4.size()
            if (r4 != r11) goto L_0x0192
            java.util.List r4 = r18.getEncodedPathSegments()
            java.lang.Object r4 = kotlin.collections.CollectionsKt.first(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 != 0) goto L_0x018a
            r4 = r11
            goto L_0x018b
        L_0x018a:
            r4 = 0
        L_0x018b:
            if (r4 == 0) goto L_0x0192
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0196
        L_0x0192:
            java.util.List r4 = r18.getEncodedPathSegments()
        L_0x0196:
            java.lang.String r5 = "/"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r5)
            if (r5 == 0) goto L_0x01a1
            java.util.List<java.lang.String> r3 = ROOT_PATH
            goto L_0x01b1
        L_0x01a1:
            r5 = r3
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            char[] r6 = new char[r11]
            r3 = 0
            r6[r3] = r14
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            java.util.List r3 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r5, (char[]) r6, (boolean) r7, (int) r8, (int) r9, (java.lang.Object) r10)
        L_0x01b1:
            if (r15 != r11) goto L_0x01b6
            java.util.List<java.lang.String> r5 = ROOT_PATH
            goto L_0x01ba
        L_0x01b6:
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
        L_0x01ba:
            java.util.Collection r5 = (java.util.Collection) r5
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.List r3 = kotlin.collections.CollectionsKt.plus(r5, r3)
            java.util.Collection r4 = (java.util.Collection) r4
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.List r3 = kotlin.collections.CollectionsKt.plus(r4, r3)
            r0.setEncodedPathSegments(r3)
            r9 = r2
        L_0x01ce:
            if (r9 >= r12) goto L_0x01dc
            char r2 = r1.charAt(r9)
            r3 = 63
            if (r2 != r3) goto L_0x01dc
            int r9 = parseQuery(r0, r1, r9, r12)
        L_0x01dc:
            parseFragment(r0, r1, r9, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.URLParserKt.takeFromUnsafe(io.ktor.http.URLBuilder, java.lang.String):io.ktor.http.URLBuilder");
    }

    private static final void parseFile(URLBuilder uRLBuilder, String str, int i, int i2, int i3) {
        if (i3 == 2) {
            int indexOf$default = StringsKt.indexOf$default((CharSequence) str, '/', i, false, 4, (Object) null);
            if (indexOf$default == -1 || indexOf$default == i2) {
                String substring = str.substring(i, i2);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                uRLBuilder.setHost(substring);
                return;
            }
            String substring2 = str.substring(i, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.setHost(substring2);
            String substring3 = str.substring(indexOf$default, i2);
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
            URLBuilderKt.setEncodedPath(uRLBuilder, substring3);
        } else if (i3 == 3) {
            uRLBuilder.setHost("");
            StringBuilder sb = new StringBuilder();
            sb.append('/');
            String substring4 = str.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String…ing(startIndex, endIndex)");
            sb.append(substring4);
            URLBuilderKt.setEncodedPath(uRLBuilder, sb.toString());
        } else {
            throw new IllegalArgumentException("Invalid file url: " + str);
        }
    }

    private static final void parseMailto(URLBuilder uRLBuilder, String str, int i, int i2) {
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, "@", i, false, 4, (Object) null);
        if (indexOf$default != -1) {
            String substring = str.substring(i, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.setUser(CodecsKt.decodeURLPart$default(substring, 0, 0, (Charset) null, 7, (Object) null));
            String substring2 = str.substring(indexOf$default + 1, i2);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.setHost(substring2);
            return;
        }
        throw new IllegalArgumentException("Invalid mailto url: " + str + ", it should contain '@'.");
    }

    private static final int parseQuery(URLBuilder uRLBuilder, String str, int i, int i2) {
        boolean z = true;
        int i3 = i + 1;
        if (i3 == i2) {
            uRLBuilder.setTrailingQuery(true);
            return i2;
        }
        Integer valueOf = Integer.valueOf(StringsKt.indexOf$default((CharSequence) str, '#', i3, false, 4, (Object) null));
        if (valueOf.intValue() <= 0) {
            z = false;
        }
        if (!z) {
            valueOf = null;
        }
        if (valueOf != null) {
            i2 = valueOf.intValue();
        }
        String substring = str.substring(i3, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        QueryKt.parseQueryString$default(substring, 0, 0, false, 6, (Object) null).forEach(new URLParserKt$parseQuery$1(uRLBuilder));
        return i2;
    }

    private static final void parseFragment(URLBuilder uRLBuilder, String str, int i, int i2) {
        if (i < i2 && str.charAt(i) == '#') {
            String substring = str.substring(i + 1, i2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.setEncodedFragment(substring);
        }
    }

    private static final void fillHost(URLBuilder uRLBuilder, String str, int i, int i2) {
        Integer valueOf = Integer.valueOf(indexOfColonInHostPort(str, i, i2));
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        int intValue = valueOf != null ? valueOf.intValue() : i2;
        String substring = str.substring(i, intValue);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        uRLBuilder.setHost(substring);
        int i3 = intValue + 1;
        if (i3 < i2) {
            String substring2 = str.substring(i3, i2);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.setPort(Integer.parseInt(substring2));
            return;
        }
        uRLBuilder.setPort(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final int findScheme(java.lang.String r12, int r13, int r14) {
        /*
            char r0 = r12.charAt(r13)
            r1 = 123(0x7b, float:1.72E-43)
            r2 = 97
            r3 = 1
            r4 = 0
            if (r2 > r0) goto L_0x0010
            if (r0 >= r1) goto L_0x0010
            r5 = r3
            goto L_0x0011
        L_0x0010:
            r5 = r4
        L_0x0011:
            r6 = 91
            r7 = 65
            r8 = -1
            if (r5 != 0) goto L_0x0024
            if (r7 > r0) goto L_0x001e
            if (r0 >= r6) goto L_0x001e
            r0 = r3
            goto L_0x001f
        L_0x001e:
            r0 = r4
        L_0x001f:
            if (r0 != 0) goto L_0x0024
            r0 = r13
            r5 = r0
            goto L_0x0026
        L_0x0024:
            r0 = r13
            r5 = r8
        L_0x0026:
            if (r0 >= r14) goto L_0x0087
            char r9 = r12.charAt(r0)
            r10 = 58
            if (r9 != r10) goto L_0x004b
            if (r5 != r8) goto L_0x0034
            int r0 = r0 - r13
            return r0
        L_0x0034:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Illegal character in scheme at position "
            r13.append(r14)
            r13.append(r5)
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            throw r12
        L_0x004b:
            r11 = 47
            if (r9 == r11) goto L_0x0087
            r11 = 63
            if (r9 == r11) goto L_0x0087
            r11 = 35
            if (r9 != r11) goto L_0x0058
            goto L_0x0087
        L_0x0058:
            if (r5 != r8) goto L_0x0084
            if (r2 > r9) goto L_0x0060
            if (r9 >= r1) goto L_0x0060
            r11 = r3
            goto L_0x0061
        L_0x0060:
            r11 = r4
        L_0x0061:
            if (r11 != 0) goto L_0x0084
            if (r7 > r9) goto L_0x0069
            if (r9 >= r6) goto L_0x0069
            r11 = r3
            goto L_0x006a
        L_0x0069:
            r11 = r4
        L_0x006a:
            if (r11 != 0) goto L_0x0084
            r11 = 48
            if (r11 > r9) goto L_0x0074
            if (r9 >= r10) goto L_0x0074
            r10 = r3
            goto L_0x0075
        L_0x0074:
            r10 = r4
        L_0x0075:
            if (r10 != 0) goto L_0x0084
            r10 = 46
            if (r9 == r10) goto L_0x0084
            r10 = 43
            if (r9 == r10) goto L_0x0084
            r10 = 45
            if (r9 == r10) goto L_0x0084
            r5 = r0
        L_0x0084:
            int r0 = r0 + 1
            goto L_0x0026
        L_0x0087:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.URLParserKt.findScheme(java.lang.String, int, int):int");
    }

    private static final int count(String str, int i, int i2, char c) {
        int i3 = 0;
        while (true) {
            int i4 = i + i3;
            if (i4 >= i2 || str.charAt(i4) != c) {
                return i3;
            }
            i3++;
        }
        return i3;
    }

    private static final int indexOfColonInHostPort(String str, int i, int i2) {
        boolean z = false;
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt == '[') {
                z = true;
            } else if (charAt == ']') {
                z = false;
            } else if (charAt == ':' && !z) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static final boolean isLetter(char c) {
        char lowerCase = Character.toLowerCase(c);
        return 'a' <= lowerCase && lowerCase < '{';
    }
}
