package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class ImageCapture$$ExternalSyntheticLambda14 implements ImageCapture.ImageCaptureRequestProcessor.ImageCaptor {
    public final /* synthetic */ ImageCapture f$0;

    public /* synthetic */ ImageCapture$$ExternalSyntheticLambda14(ImageCapture imageCapture) {
        this.f$0 = imageCapture;
    }

    public final ListenableFuture capture(ImageCapture.ImageCaptureRequest imageCaptureRequest) {
        return this.f$0.lambda$createPipeline$2$ImageCapture(imageCaptureRequest);
    }
}
