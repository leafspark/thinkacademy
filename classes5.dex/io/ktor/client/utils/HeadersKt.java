package io.ktor.client.utils;

import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a!\u0010\u0000\u001a\u00020\u00012\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"buildHeaders", "Lio/ktor/http/Headers;", "block", "Lkotlin/Function1;", "Lio/ktor/http/HeadersBuilder;", "", "Lkotlin/ExtensionFunctionType;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: headers.kt */
public final class HeadersKt {
    public static /* synthetic */ Headers buildHeaders$default(Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = (Function1) HeadersKt$buildHeaders$1.INSTANCE;
        }
        return buildHeaders(function1);
    }

    public static final Headers buildHeaders(Function1<? super HeadersBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, (DefaultConstructorMarker) null);
        function1.invoke(headersBuilder);
        return headersBuilder.build();
    }
}
