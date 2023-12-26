package io.ktor.http;

import io.ktor.http.ContentDisposition;
import io.ktor.util.StringValues;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lio/ktor/http/Headers;", "Lio/ktor/util/StringValues;", "Companion", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Headers.kt */
public interface Headers extends StringValues {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Headers.kt */
    public static final class DefaultImpls {
        public static boolean contains(Headers headers, String str) {
            Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
            return StringValues.DefaultImpls.contains(headers, str);
        }

        public static boolean contains(Headers headers, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
            Intrinsics.checkNotNullParameter(str2, "value");
            return StringValues.DefaultImpls.contains(headers, str, str2);
        }

        public static void forEach(Headers headers, Function2<? super String, ? super List<String>, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "body");
            StringValues.DefaultImpls.forEach(headers, function2);
        }

        public static String get(Headers headers, String str) {
            Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
            return StringValues.DefaultImpls.get(headers, str);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\b\u001a\u00020\u00042\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\bø\u0001\u0000R\u0017\u0010\u0003\u001a\u00020\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000e"}, d2 = {"Lio/ktor/http/Headers$Companion;", "", "()V", "Empty", "Lio/ktor/http/Headers;", "getEmpty$annotations", "getEmpty", "()Lio/ktor/http/Headers;", "build", "builder", "Lkotlin/Function1;", "Lio/ktor/http/HeadersBuilder;", "", "Lkotlin/ExtensionFunctionType;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Headers.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Headers Empty = EmptyHeaders.INSTANCE;

        public static /* synthetic */ void getEmpty$annotations() {
        }

        private Companion() {
        }

        public final Headers getEmpty() {
            return Empty;
        }

        public final Headers build(Function1<? super HeadersBuilder, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "builder");
            HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, (DefaultConstructorMarker) null);
            function1.invoke(headersBuilder);
            return headersBuilder.build();
        }
    }
}
