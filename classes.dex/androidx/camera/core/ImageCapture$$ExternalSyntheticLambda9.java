package androidx.camera.core;

import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class ImageCapture$$ExternalSyntheticLambda9 implements Runnable {
    public final /* synthetic */ ListenableFuture f$0;

    public /* synthetic */ ImageCapture$$ExternalSyntheticLambda9(ListenableFuture listenableFuture) {
        this.f$0 = listenableFuture;
    }

    public final void run() {
        this.f$0.cancel(true);
    }
}
