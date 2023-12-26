package io.ktor.http;

import com.tekartik.sqflite.Constant;
import io.ktor.http.Parameters;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b\u001a \u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002\u001a \u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\rH\u0002\u001a4\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a,\u0010\u0015\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u0016"}, d2 = {"parseQueryString", "Lio/ktor/http/Parameters;", "query", "", "startIndex", "", "limit", "decode", "", "trimEnd", "start", "end", "text", "", "trimStart", "appendParam", "", "Lio/ktor/http/ParametersBuilder;", "nameIndex", "equalIndex", "endIndex", "parse", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Query.kt */
public final class QueryKt {
    public static /* synthetic */ Parameters parseQueryString$default(String str, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 1000;
        }
        if ((i3 & 8) != 0) {
            z = true;
        }
        return parseQueryString(str, i, i2, z);
    }

    public static final Parameters parseQueryString(String str, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(str, Constant.METHOD_QUERY);
        if (i > StringsKt.getLastIndex(str)) {
            return Parameters.Companion.getEmpty();
        }
        Parameters.Companion companion = Parameters.Companion;
        ParametersBuilder ParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
        parse(ParametersBuilder$default, str, i, i2, z);
        return ParametersBuilder$default.build();
    }

    private static final void parse(ParametersBuilder parametersBuilder, String str, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = i2;
        int lastIndex = StringsKt.getLastIndex(str);
        int i6 = 0;
        int i7 = i;
        if (i7 <= lastIndex) {
            int i8 = 0;
            i4 = i7;
            int i9 = i4;
            i3 = -1;
            while (i8 != i5) {
                char charAt = str.charAt(i9);
                if (charAt == '&') {
                    appendParam(parametersBuilder, str, i4, i3, i9, z);
                    i8++;
                    i4 = i9 + 1;
                    i3 = -1;
                } else if (charAt == '=' && i3 == -1) {
                    i3 = i9;
                }
                if (i9 != lastIndex) {
                    i9++;
                } else {
                    i6 = i8;
                }
            }
            return;
        }
        i4 = i7;
        i3 = -1;
        if (i6 != i5) {
            appendParam(parametersBuilder, str, i4, i3, str.length(), z);
        }
    }

    private static final void appendParam(ParametersBuilder parametersBuilder, String str, int i, int i2, int i3, boolean z) {
        String str2;
        String str3;
        String str4;
        if (i2 == -1) {
            CharSequence charSequence = str;
            int trimStart = trimStart(i, i3, charSequence);
            int trimEnd = trimEnd(trimStart, i3, charSequence);
            if (trimEnd > trimStart) {
                if (z) {
                    str4 = CodecsKt.decodeURLQueryComponent$default(str, trimStart, trimEnd, false, (Charset) null, 12, (Object) null);
                } else {
                    str4 = str.substring(trimStart, trimEnd);
                    Intrinsics.checkNotNullExpressionValue(str4, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                parametersBuilder.appendAll(str4, CollectionsKt.emptyList());
                return;
            }
            return;
        }
        CharSequence charSequence2 = str;
        int trimStart2 = trimStart(i, i2, charSequence2);
        int trimEnd2 = trimEnd(trimStart2, i2, charSequence2);
        if (trimEnd2 > trimStart2) {
            if (z) {
                str2 = CodecsKt.decodeURLQueryComponent$default(str, trimStart2, trimEnd2, false, (Charset) null, 12, (Object) null);
            } else {
                str2 = str.substring(trimStart2, trimEnd2);
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            int trimStart3 = trimStart(i2 + 1, i3, charSequence2);
            int trimEnd3 = trimEnd(trimStart3, i3, charSequence2);
            if (z) {
                str3 = CodecsKt.decodeURLQueryComponent$default(str, trimStart3, trimEnd3, true, (Charset) null, 8, (Object) null);
            } else {
                str3 = str.substring(trimStart3, trimEnd3);
                Intrinsics.checkNotNullExpressionValue(str3, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            parametersBuilder.append(str2, str3);
        }
    }

    private static final int trimEnd(int i, int i2, CharSequence charSequence) {
        while (i2 > i && CharsKt.isWhitespace(charSequence.charAt(i2 - 1))) {
            i2--;
        }
        return i2;
    }

    private static final int trimStart(int i, int i2, CharSequence charSequence) {
        while (i < i2 && CharsKt.isWhitespace(charSequence.charAt(i))) {
            i++;
        }
        return i;
    }
}
