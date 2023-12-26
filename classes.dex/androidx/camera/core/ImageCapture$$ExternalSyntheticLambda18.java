package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class ImageCapture$$ExternalSyntheticLambda18 implements AsyncFunction {
    public final /* synthetic */ ImageCapture f$0;
    public final /* synthetic */ ImageCapture.ImageCaptureRequest f$1;

    public /* synthetic */ ImageCapture$$ExternalSyntheticLambda18(ImageCapture imageCapture, ImageCapture.ImageCaptureRequest imageCaptureRequest) {
        this.f$0 = imageCapture;
        this.f$1 = imageCaptureRequest;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f$0.lambda$takePictureInternal$8$ImageCapture(this.f$1, (Void) obj);
    }
}
