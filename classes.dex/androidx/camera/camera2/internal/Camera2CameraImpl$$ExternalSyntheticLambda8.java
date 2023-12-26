package androidx.camera.camera2.internal;

import androidx.camera.core.UseCase;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class Camera2CameraImpl$$ExternalSyntheticLambda8 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ Camera2CameraImpl f$0;
    public final /* synthetic */ UseCase f$1;

    public /* synthetic */ Camera2CameraImpl$$ExternalSyntheticLambda8(Camera2CameraImpl camera2CameraImpl, UseCase useCase) {
        this.f$0 = camera2CameraImpl;
        this.f$1 = useCase;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$isUseCaseAttached$10$Camera2CameraImpl(this.f$1, completer);
    }
}
