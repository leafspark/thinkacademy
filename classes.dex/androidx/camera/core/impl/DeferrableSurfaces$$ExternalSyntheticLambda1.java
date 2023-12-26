package androidx.camera.core.impl;

import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class DeferrableSurfaces$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ ListenableFuture f$0;

    public /* synthetic */ DeferrableSurfaces$$ExternalSyntheticLambda1(ListenableFuture listenableFuture) {
        this.f$0 = listenableFuture;
    }

    public final void run() {
        this.f$0.cancel(true);
    }
}
