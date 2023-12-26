package kotlinx.coroutines.future;

import java.util.function.BiConsumer;
import kotlinx.coroutines.Job;

public final /* synthetic */ class FutureKt$$ExternalSyntheticLambda1 implements BiConsumer {
    public final /* synthetic */ Job f$0;

    public /* synthetic */ FutureKt$$ExternalSyntheticLambda1(Job job) {
        this.f$0 = job;
    }

    public final void accept(Object obj, Object obj2) {
        FutureKt.m48setupCancellation$lambda2(this.f$0, obj, (Throwable) obj2);
    }
}
