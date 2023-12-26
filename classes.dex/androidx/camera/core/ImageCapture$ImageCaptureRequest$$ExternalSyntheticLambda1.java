package androidx.camera.core;

import androidx.camera.core.ImageCapture;

public final /* synthetic */ class ImageCapture$ImageCaptureRequest$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ ImageCapture.ImageCaptureRequest f$0;
    public final /* synthetic */ ImageProxy f$1;

    public /* synthetic */ ImageCapture$ImageCaptureRequest$$ExternalSyntheticLambda1(ImageCapture.ImageCaptureRequest imageCaptureRequest, ImageProxy imageProxy) {
        this.f$0 = imageCaptureRequest;
        this.f$1 = imageProxy;
    }

    public final void run() {
        this.f$0.lambda$dispatchImage$0$ImageCapture$ImageCaptureRequest(this.f$1);
    }
}
