package io.ktor.util;

import io.ktor.http.ContentDisposition;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016J\u0011\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\f0\u000bH&J(\u0010\u000e\u001a\u00020\u000f2\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r\u0012\u0004\u0012\u00020\u000f0\u0011H\u0016J\u0013\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\u0014\u001a\u00020\u0003H&J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0017"}, d2 = {"Lio/ktor/util/StringValues;", "", "caseInsensitiveName", "", "getCaseInsensitiveName", "()Z", "contains", "name", "", "value", "entries", "", "", "", "forEach", "", "body", "Lkotlin/Function2;", "get", "getAll", "isEmpty", "names", "Companion", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StringValues.kt */
public interface StringValues {
    public static final Companion Companion = Companion.$$INSTANCE;

    boolean contains(String str);

    boolean contains(String str, String str2);

    Set<Map.Entry<String, List<String>>> entries();

    void forEach(Function2<? super String, ? super List<String>, Unit> function2);

    String get(String str);

    List<String> getAll(String str);

    boolean getCaseInsensitiveName();

    boolean isEmpty();

    Set<String> names();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\bø\u0001\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000f"}, d2 = {"Lio/ktor/util/StringValues$Companion;", "", "()V", "Empty", "Lio/ktor/util/StringValues;", "getEmpty", "()Lio/ktor/util/StringValues;", "build", "caseInsensitiveName", "", "builder", "Lkotlin/Function1;", "Lio/ktor/util/StringValuesBuilder;", "", "Lkotlin/ExtensionFunctionType;", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StringValues.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final StringValues Empty = new StringValuesImpl(false, (Map) null, 3, (DefaultConstructorMarker) null);

        private Companion() {
        }

        public final StringValues getEmpty() {
            return Empty;
        }

        public static /* synthetic */ StringValues build$default(Companion companion, boolean z, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            Intrinsics.checkNotNullParameter(function1, "builder");
            StringValuesBuilderImpl stringValuesBuilderImpl = new StringValuesBuilderImpl(z, 0, 2, (DefaultConstructorMarker) null);
            function1.invoke(stringValuesBuilderImpl);
            return stringValuesBuilderImpl.build();
        }

        public final StringValues build(boolean z, Function1<? super StringValuesBuilder, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "builder");
            StringValuesBuilderImpl stringValuesBuilderImpl = new StringValuesBuilderImpl(z, 0, 2, (DefaultConstructorMarker) null);
            function1.invoke(stringValuesBuilderImpl);
            return stringValuesBuilderImpl.build();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StringValues.kt */
    public static final class DefaultImpls {
        public static String get(StringValues stringValues, String str) {
            Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
            List<String> all = stringValues.getAll(str);
            if (all != null) {
                return (String) CollectionsKt.firstOrNull(all);
            }
            return null;
        }

        public static boolean contains(StringValues stringValues, String str) {
            Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
            return stringValues.getAll(str) != null;
        }

        public static boolean contains(StringValues stringValues, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
            Intrinsics.checkNotNullParameter(str2, "value");
            List<String> all = stringValues.getAll(str);
            if (all != null) {
                return all.contains(str2);
            }
            return false;
        }

        public static void forEach(StringValues stringValues, Function2<? super String, ? super List<String>, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "body");
            for (Map.Entry entry : stringValues.entries()) {
                function2.invoke((String) entry.getKey(), (List) entry.getValue());
            }
        }
    }
}
