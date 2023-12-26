package androidx.camera.core.impl;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final /* synthetic */ class DeferrableSurfaces$$ExternalSyntheticLambda0 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ List f$0;
    public final /* synthetic */ ScheduledExecutorService f$1;
    public final /* synthetic */ Executor f$2;
    public final /* synthetic */ long f$3;
    public final /* synthetic */ boolean f$4;

    public /* synthetic */ DeferrableSurfaces$$ExternalSyntheticLambda0(List list, ScheduledExecutorService scheduledExecutorService, Executor executor, long j, boolean z) {
        this.f$0 = list;
        this.f$1 = scheduledExecutorService;
        this.f$2 = executor;
        this.f$3 = j;
        this.f$4 = z;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return DeferrableSurfaces.lambda$surfaceListWithTimeout$3(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, completer);
    }
}
