package kotlinx.coroutines.future;

import java.util.function.BiConsumer;
import kotlinx.coroutines.CompletableDeferred;

public final /* synthetic */ class FutureKt$$ExternalSyntheticLambda0 implements BiConsumer {
    public final /* synthetic */ CompletableDeferred f$0;

    public /* synthetic */ FutureKt$$ExternalSyntheticLambda0(CompletableDeferred completableDeferred) {
        this.f$0 = completableDeferred;
    }

    public final void accept(Object obj, Object obj2) {
        FutureKt.m47asDeferred$lambda4(this.f$0, obj, (Throwable) obj2);
    }
}
