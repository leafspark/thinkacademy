package io.ktor.serialization;

import io.ktor.http.HeaderValue;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u00032\f\b\u0002\u0010\u0004\u001a\u00060\u0001j\u0002`\u0002\u001a \u0010\u0005\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002*\u00020\u00032\f\b\u0002\u0010\u0004\u001a\u00060\u0001j\u0002`\u0002¨\u0006\u0006"}, d2 = {"suitableCharset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "Lio/ktor/http/Headers;", "defaultCharset", "suitableCharsetOrNull", "ktor-serialization"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContentConverter.kt */
public final class ContentConverterKt {
    public static /* synthetic */ Charset suitableCharset$default(Headers headers, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return suitableCharset(headers, charset);
    }

    public static final Charset suitableCharset(Headers headers, Charset charset) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        Intrinsics.checkNotNullParameter(charset, "defaultCharset");
        Charset suitableCharsetOrNull = suitableCharsetOrNull(headers, charset);
        return suitableCharsetOrNull == null ? charset : suitableCharsetOrNull;
    }

    public static /* synthetic */ Charset suitableCharsetOrNull$default(Headers headers, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return suitableCharsetOrNull(headers, charset);
    }

    public static final Charset suitableCharsetOrNull(Headers headers, Charset charset) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        Intrinsics.checkNotNullParameter(charset, "defaultCharset");
        for (HeaderValue component1 : HttpHeaderValueParserKt.parseAndSortHeader(headers.get(HttpHeaders.INSTANCE.getAcceptCharset()))) {
            String component12 = component1.component1();
            if (Intrinsics.areEqual(component12, "*")) {
                return charset;
            }
            if (Charset.isSupported(component12)) {
                return Charset.forName(component12);
            }
        }
        return null;
    }
}
