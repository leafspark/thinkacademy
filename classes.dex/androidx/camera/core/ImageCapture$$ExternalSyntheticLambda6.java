package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import java.util.concurrent.Executor;

public final /* synthetic */ class ImageCapture$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ ImageCapture f$0;
    public final /* synthetic */ Executor f$1;
    public final /* synthetic */ ImageCapture.OnImageCapturedCallback f$2;

    public /* synthetic */ ImageCapture$$ExternalSyntheticLambda6(ImageCapture imageCapture, Executor executor, ImageCapture.OnImageCapturedCallback onImageCapturedCallback) {
        this.f$0 = imageCapture;
        this.f$1 = executor;
        this.f$2 = onImageCapturedCallback;
    }

    public final void run() {
        this.f$0.lambda$takePicture$4$ImageCapture(this.f$1, this.f$2);
    }
}
