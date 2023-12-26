package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class ImageCapture$$ExternalSyntheticLambda2 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ ImageCapture f$0;
    public final /* synthetic */ ImageCapture.TakePictureState f$1;

    public /* synthetic */ ImageCapture$$ExternalSyntheticLambda2(ImageCapture imageCapture, ImageCapture.TakePictureState takePictureState) {
        this.f$0 = imageCapture;
        this.f$1 = takePictureState;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$openTorch$15$ImageCapture(this.f$1, completer);
    }
}
