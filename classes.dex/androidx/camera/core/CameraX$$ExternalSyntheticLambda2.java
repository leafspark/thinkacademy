package androidx.camera.core;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;

public final /* synthetic */ class CameraX$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ CameraX f$0;
    public final /* synthetic */ Executor f$1;
    public final /* synthetic */ long f$2;
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$3;

    public /* synthetic */ CameraX$$ExternalSyntheticLambda2(CameraX cameraX, Executor executor, long j, CallbackToFutureAdapter.Completer completer) {
        this.f$0 = cameraX;
        this.f$1 = executor;
        this.f$2 = j;
        this.f$3 = completer;
    }

    public final void run() {
        this.f$0.lambda$initAndRetryRecursively$8$CameraX(this.f$1, this.f$2, this.f$3);
    }
}
