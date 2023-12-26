package io.ktor.http;

import io.ktor.util.StringValues;
import io.ktor.util.StringValuesBuilder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0006H\u0000\u001a\u0014\u0010\u0007\u001a\u00020\b*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0014\u0010\t\u001a\u00020\b*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0006H\u0002¨\u0006\n"}, d2 = {"decodeParameters", "Lio/ktor/http/Parameters;", "parameters", "Lio/ktor/util/StringValuesBuilder;", "encodeParameters", "Lio/ktor/http/ParametersBuilder;", "Lio/ktor/util/StringValues;", "appendAllDecoded", "", "appendAllEncoded", "ktor-http"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: UrlDecodedParametersBuilder.kt */
public final class UrlDecodedParametersBuilderKt {
    public static final Parameters decodeParameters(StringValuesBuilder stringValuesBuilder) {
        Intrinsics.checkNotNullParameter(stringValuesBuilder, "parameters");
        ParametersBuilder ParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
        appendAllDecoded(ParametersBuilder$default, stringValuesBuilder);
        return ParametersBuilder$default.build();
    }

    public static final ParametersBuilder encodeParameters(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "parameters");
        ParametersBuilder ParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
        appendAllEncoded(ParametersBuilder$default, stringValues);
        return ParametersBuilder$default;
    }

    private static final void appendAllDecoded(StringValuesBuilder stringValuesBuilder, StringValuesBuilder stringValuesBuilder2) {
        for (String str : stringValuesBuilder2.names()) {
            List<String> all = stringValuesBuilder2.getAll(str);
            if (all == null) {
                all = CollectionsKt.emptyList();
            }
            String decodeURLQueryComponent$default = CodecsKt.decodeURLQueryComponent$default(str, 0, 0, false, (Charset) null, 15, (Object) null);
            Iterable<String> iterable = all;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (String decodeURLQueryComponent$default2 : iterable) {
                arrayList.add(CodecsKt.decodeURLQueryComponent$default(decodeURLQueryComponent$default2, 0, 0, true, (Charset) null, 11, (Object) null));
            }
            stringValuesBuilder.appendAll(decodeURLQueryComponent$default, (List) arrayList);
        }
    }

    /* access modifiers changed from: private */
    public static final void appendAllEncoded(StringValuesBuilder stringValuesBuilder, StringValues stringValues) {
        for (String str : stringValues.names()) {
            List<String> all = stringValues.getAll(str);
            if (all == null) {
                all = CollectionsKt.emptyList();
            }
            String encodeURLParameter$default = CodecsKt.encodeURLParameter$default(str, false, 1, (Object) null);
            Iterable<String> iterable = all;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (String encodeURLParameterValue : iterable) {
                arrayList.add(CodecsKt.encodeURLParameterValue(encodeURLParameterValue));
            }
            stringValuesBuilder.appendAll(encodeURLParameter$default, (List) arrayList);
        }
    }
}
