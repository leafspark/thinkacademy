package androidx.camera.core;

import androidx.camera.core.impl.ImageReaderProxy;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class ImageCapture$$ExternalSyntheticLambda15 implements ImageReaderProxy.OnImageAvailableListener {
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$0;

    public /* synthetic */ ImageCapture$$ExternalSyntheticLambda15(CallbackToFutureAdapter.Completer completer) {
        this.f$0 = completer;
    }

    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        ImageCapture.lambda$takePictureInternal$7(this.f$0, imageReaderProxy);
    }
}
