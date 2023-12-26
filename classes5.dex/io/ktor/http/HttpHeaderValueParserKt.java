package io.ktor.http;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u001a\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\t\u001a>\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u001c\u0010\r\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u000fj\b\u0012\u0004\u0012\u00020\u0002`\u00100\u000e2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a6\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u001c\u0010\u0012\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00130\u000fj\b\u0012\u0004\u0012\u00020\u0013`\u00100\u000eH\u0002\u001a$\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002\u001a$\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002\u001a\u0014\u0010\u0018\u001a\u00020\t*\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002\u001a\u001c\u0010\u0019\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0002\u001a\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00150\u001c\u001a$\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001e0\u0001\"\u0004\b\u0000\u0010\u001e*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001e0\u00010\u000eH\u0002¨\u0006\u001f"}, d2 = {"parseAndSortContentTypeHeader", "", "Lio/ktor/http/HeaderValue;", "header", "", "parseAndSortHeader", "parseHeaderValue", "text", "parametersOnly", "", "parseHeaderValueItem", "", "start", "items", "Lkotlin/Lazy;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "parseHeaderValueParameter", "parameters", "Lio/ktor/http/HeaderValueParam;", "parseHeaderValueParameterValue", "Lkotlin/Pair;", "value", "parseHeaderValueParameterValueQuoted", "nextIsSemicolonOrEnd", "subtrim", "end", "toHeaderParamsList", "", "valueOrEmpty", "T", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpHeaderValueParser.kt */
public final class HttpHeaderValueParserKt {
    public static final List<HeaderValue> parseAndSortHeader(String str) {
        return CollectionsKt.sortedWith(parseHeaderValue(str), new HttpHeaderValueParserKt$parseAndSortHeader$$inlined$sortedByDescending$1());
    }

    public static final List<HeaderValue> parseAndSortContentTypeHeader(String str) {
        return CollectionsKt.sortedWith(parseHeaderValue(str), new HttpHeaderValueParserKt$parseAndSortContentTypeHeader$$inlined$thenByDescending$1(new HttpHeaderValueParserKt$parseAndSortContentTypeHeader$$inlined$thenBy$1(new HttpHeaderValueParserKt$parseAndSortContentTypeHeader$$inlined$compareByDescending$1())));
    }

    public static final List<HeaderValue> parseHeaderValue(String str) {
        return parseHeaderValue(str, false);
    }

    public static final List<HeaderValue> parseHeaderValue(String str, boolean z) {
        if (str == null) {
            return CollectionsKt.emptyList();
        }
        int i = 0;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, HttpHeaderValueParserKt$parseHeaderValue$items$1.INSTANCE);
        while (i <= StringsKt.getLastIndex(str)) {
            i = parseHeaderValueItem(str, i, lazy, z);
        }
        return valueOrEmpty(lazy);
    }

    private static final <T> List<T> valueOrEmpty(Lazy<? extends List<? extends T>> lazy) {
        return lazy.isInitialized() ? (List) lazy.getValue() : CollectionsKt.emptyList();
    }

    private static final String subtrim(String str, int i, int i2) {
        String substring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return StringsKt.trim((CharSequence) substring).toString();
    }

    private static final int parseHeaderValueItem(String str, int i, Lazy<? extends ArrayList<HeaderValue>> lazy, boolean z) {
        Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1.INSTANCE);
        Integer valueOf = z ? Integer.valueOf(i) : null;
        int i2 = i;
        while (i2 <= StringsKt.getLastIndex(str)) {
            char charAt = str.charAt(i2);
            if (charAt == ',') {
                ((ArrayList) lazy.getValue()).add(new HeaderValue(subtrim(str, i, valueOf != null ? valueOf.intValue() : i2), valueOrEmpty(lazy2)));
                return i2 + 1;
            } else if (charAt == ';') {
                if (valueOf == null) {
                    valueOf = Integer.valueOf(i2);
                }
                i2 = parseHeaderValueParameter(str, i2 + 1, lazy2);
            } else {
                i2 = z ? parseHeaderValueParameter(str, i2, lazy2) : i2 + 1;
            }
        }
        ((ArrayList) lazy.getValue()).add(new HeaderValue(subtrim(str, i, valueOf != null ? valueOf.intValue() : i2), valueOrEmpty(lazy2)));
        return i2;
    }

    private static final void parseHeaderValueParameter$addParam(Lazy<? extends ArrayList<HeaderValueParam>> lazy, String str, int i, int i2, String str2) {
        String subtrim = subtrim(str, i, i2);
        if (!(subtrim.length() == 0)) {
            ((ArrayList) lazy.getValue()).add(new HeaderValueParam(subtrim, str2));
        }
    }

    private static final int parseHeaderValueParameter(String str, int i, Lazy<? extends ArrayList<HeaderValueParam>> lazy) {
        int i2 = i;
        while (i2 <= StringsKt.getLastIndex(str)) {
            char charAt = str.charAt(i2);
            if (charAt == '=') {
                Pair<Integer, String> parseHeaderValueParameterValue = parseHeaderValueParameterValue(str, i2 + 1);
                int intValue = parseHeaderValueParameterValue.component1().intValue();
                parseHeaderValueParameter$addParam(lazy, str, i, i2, parseHeaderValueParameterValue.component2());
                return intValue;
            }
            boolean z = true;
            if (!(charAt == ';' || charAt == ',')) {
                z = false;
            }
            if (z) {
                parseHeaderValueParameter$addParam(lazy, str, i, i2, "");
                return i2;
            }
            i2++;
        }
        parseHeaderValueParameter$addParam(lazy, str, i, i2, "");
        return i2;
    }

    private static final Pair<Integer, String> parseHeaderValueParameterValue(String str, int i) {
        if (str.length() == i) {
            return TuplesKt.to(Integer.valueOf(i), "");
        }
        if (str.charAt(i) == '\"') {
            return parseHeaderValueParameterValueQuoted(str, i + 1);
        }
        int i2 = i;
        while (i2 <= StringsKt.getLastIndex(str)) {
            char charAt = str.charAt(i2);
            if (charAt == ';' || charAt == ',') {
                return TuplesKt.to(Integer.valueOf(i2), subtrim(str, i, i2));
            }
            i2++;
        }
        return TuplesKt.to(Integer.valueOf(i2), subtrim(str, i, i2));
    }

    private static final Pair<Integer, String> parseHeaderValueParameterValueQuoted(String str, int i) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            CharSequence charSequence = str;
            if (i <= StringsKt.getLastIndex(charSequence)) {
                char charAt = str.charAt(i);
                if (charAt == '\"' && nextIsSemicolonOrEnd(str, i)) {
                    Integer valueOf = Integer.valueOf(i + 1);
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
                    return TuplesKt.to(valueOf, sb2);
                } else if (charAt != '\\' || i >= StringsKt.getLastIndex(charSequence) - 2) {
                    sb.append(charAt);
                    i++;
                } else {
                    sb.append(str.charAt(i + 1));
                    i += 2;
                }
            } else {
                Integer valueOf2 = Integer.valueOf(i);
                String sb3 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb3, "builder.toString()");
                return TuplesKt.to(valueOf2, Typography.quote + sb3);
            }
        }
    }

    private static final boolean nextIsSemicolonOrEnd(String str, int i) {
        int i2 = i + 1;
        while (i2 < str.length() && str.charAt(i2) == ' ') {
            i2++;
        }
        if (i2 == str.length() || str.charAt(i2) == ';') {
            return true;
        }
        return false;
    }

    public static final List<HeaderValueParam> toHeaderParamsList(Iterable<Pair<String, String>> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Pair next : iterable) {
            arrayList.add(new HeaderValueParam((String) next.getFirst(), (String) next.getSecond()));
        }
        return (List) arrayList;
    }
}
