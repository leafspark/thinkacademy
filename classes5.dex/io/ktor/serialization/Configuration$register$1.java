package io.ktor.serialization;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "Lio/ktor/serialization/ContentConverter;", "invoke", "(Lio/ktor/serialization/ContentConverter;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContentConverter.kt */
final class Configuration$register$1 extends Lambda implements Function1<T, Unit> {
    public static final Configuration$register$1 INSTANCE = new Configuration$register$1();

    Configuration$register$1() {
        super(1);
    }

    public final void invoke(T t) {
        Intrinsics.checkNotNullParameter(t, "$this$null");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentConverter) obj);
        return Unit.INSTANCE;
    }
}
