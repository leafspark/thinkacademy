package io.ktor.util;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0000\u001a>\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b*\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b0\u000bH\bø\u0001\u0000\u001a\n\u0010\f\u001a\u00020\u0006*\u00020\u0006\u001a\n\u0010\r\u001a\u00020\u0006*\u00020\u0006\u001a\n\u0010\u000e\u001a\u00020\u0006*\u00020\u0006\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000f"}, d2 = {"toLowerCasePreservingASCII", "", "ch", "toUpperCasePreservingASCII", "caseInsensitive", "Lio/ktor/util/CaseInsensitiveString;", "", "chomp", "Lkotlin/Pair;", "separator", "onMissingDelimiter", "Lkotlin/Function0;", "escapeHTML", "toLowerCasePreservingASCIIRules", "toUpperCasePreservingASCIIRules", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Text.kt */
public final class TextKt {
    public static final String escapeHTML(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\'') {
                sb.append("&#x27;");
            } else if (charAt == '\"') {
                sb.append("&quot;");
            } else if (charAt == '&') {
                sb.append("&amp;");
            } else if (charAt == '<') {
                sb.append("&lt;");
            } else if (charAt == '>') {
                sb.append("&gt;");
            } else {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static final Pair<String, String> chomp(String str, String str2, Function0<Pair<String, String>> function0) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "separator");
        Intrinsics.checkNotNullParameter(function0, "onMissingDelimiter");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return (Pair) function0.invoke();
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        String substring2 = str.substring(indexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        return TuplesKt.to(substring, substring2);
    }

    public static final String toLowerCasePreservingASCIIRules(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharSequence charSequence = str;
        int length = charSequence.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            char charAt = charSequence.charAt(i);
            if (toLowerCasePreservingASCII(charAt) != charAt) {
                break;
            }
            i++;
        }
        if (i == -1) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        sb.append(charSequence, 0, i);
        int lastIndex = StringsKt.getLastIndex(charSequence);
        if (i <= lastIndex) {
            while (true) {
                sb.append(toLowerCasePreservingASCII(str.charAt(i)));
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static final String toUpperCasePreservingASCIIRules(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharSequence charSequence = str;
        int length = charSequence.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            char charAt = charSequence.charAt(i);
            if (toUpperCasePreservingASCII(charAt) != charAt) {
                break;
            }
            i++;
        }
        if (i == -1) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        sb.append(charSequence, 0, i);
        int lastIndex = StringsKt.getLastIndex(charSequence);
        if (i <= lastIndex) {
            while (true) {
                sb.append(toUpperCasePreservingASCII(str.charAt(i)));
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    private static final char toLowerCasePreservingASCII(char c) {
        boolean z = true;
        if ('A' <= c && c < '[') {
            return (char) (c + ' ');
        }
        if (c < 0 || c >= 128) {
            z = false;
        }
        return z ? c : Character.toLowerCase(c);
    }

    private static final char toUpperCasePreservingASCII(char c) {
        boolean z = true;
        if ('a' <= c && c < '{') {
            return (char) (c - ' ');
        }
        if (c < 0 || c >= 128) {
            z = false;
        }
        return z ? c : Character.toLowerCase(c);
    }

    public static final CaseInsensitiveString caseInsensitive(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new CaseInsensitiveString(str);
    }
}
