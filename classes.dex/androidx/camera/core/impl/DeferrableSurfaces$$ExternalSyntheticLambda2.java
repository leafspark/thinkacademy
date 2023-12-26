package androidx.camera.core.impl;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class DeferrableSurfaces$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ ListenableFuture f$0;
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ DeferrableSurfaces$$ExternalSyntheticLambda2(ListenableFuture listenableFuture, CallbackToFutureAdapter.Completer completer, long j) {
        this.f$0 = listenableFuture;
        this.f$1 = completer;
        this.f$2 = j;
    }

    public final void run() {
        DeferrableSurfaces.lambda$surfaceListWithTimeout$0(this.f$0, this.f$1, this.f$2);
    }
}
