package androidx.camera.camera2.internal;

import androidx.camera.core.UseCase;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class Camera2CameraImpl$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ Camera2CameraImpl f$0;
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$1;
    public final /* synthetic */ UseCase f$2;

    public /* synthetic */ Camera2CameraImpl$$ExternalSyntheticLambda3(Camera2CameraImpl camera2CameraImpl, CallbackToFutureAdapter.Completer completer, UseCase useCase) {
        this.f$0 = camera2CameraImpl;
        this.f$1 = completer;
        this.f$2 = useCase;
    }

    public final void run() {
        this.f$0.lambda$isUseCaseAttached$9$Camera2CameraImpl(this.f$1, this.f$2);
    }
}
