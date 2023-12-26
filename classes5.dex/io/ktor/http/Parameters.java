package io.ktor.http;

import io.ktor.http.ContentDisposition;
import io.ktor.util.StringValues;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lio/ktor/http/Parameters;", "Lio/ktor/util/StringValues;", "Companion", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Parameters.kt */
public interface Parameters extends StringValues {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Parameters.kt */
    public static final class DefaultImpls {
        public static boolean contains(Parameters parameters, String str) {
            Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
            return StringValues.DefaultImpls.contains(parameters, str);
        }

        public static boolean contains(Parameters parameters, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
            Intrinsics.checkNotNullParameter(str2, "value");
            return StringValues.DefaultImpls.contains(parameters, str, str2);
        }

        public static void forEach(Parameters parameters, Function2<? super String, ? super List<String>, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "body");
            StringValues.DefaultImpls.forEach(parameters, function2);
        }

        public static String get(Parameters parameters, String str) {
            Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
            return StringValues.DefaultImpls.get(parameters, str);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0007\u001a\u00020\u00042\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fH\bø\u0001\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b20\u0001¨\u0006\r"}, d2 = {"Lio/ktor/http/Parameters$Companion;", "", "()V", "Empty", "Lio/ktor/http/Parameters;", "getEmpty", "()Lio/ktor/http/Parameters;", "build", "builder", "Lkotlin/Function1;", "Lio/ktor/http/ParametersBuilder;", "", "Lkotlin/ExtensionFunctionType;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Parameters.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Parameters Empty = EmptyParameters.INSTANCE;

        private Companion() {
        }

        public final Parameters getEmpty() {
            return Empty;
        }

        public final Parameters build(Function1<? super ParametersBuilder, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "builder");
            ParametersBuilder ParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
            function1.invoke(ParametersBuilder$default);
            return ParametersBuilder$default.build();
        }
    }
}
