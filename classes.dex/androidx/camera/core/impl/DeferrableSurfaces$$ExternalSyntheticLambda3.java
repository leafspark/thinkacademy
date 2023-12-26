package androidx.camera.core.impl;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public final /* synthetic */ class DeferrableSurfaces$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ Executor f$0;
    public final /* synthetic */ ListenableFuture f$1;
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$2;
    public final /* synthetic */ long f$3;

    public /* synthetic */ DeferrableSurfaces$$ExternalSyntheticLambda3(Executor executor, ListenableFuture listenableFuture, CallbackToFutureAdapter.Completer completer, long j) {
        this.f$0 = executor;
        this.f$1 = listenableFuture;
        this.f$2 = completer;
        this.f$3 = j;
    }

    public final void run() {
        this.f$0.execute(new DeferrableSurfaces$$ExternalSyntheticLambda2(this.f$1, this.f$2, this.f$3));
    }
}
