package androidx.camera.core;

import androidx.camera.core.ImageCapture;

public final /* synthetic */ class ImageCapture$ImageCaptureRequest$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ImageCapture.ImageCaptureRequest f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ Throwable f$3;

    public /* synthetic */ ImageCapture$ImageCaptureRequest$$ExternalSyntheticLambda0(ImageCapture.ImageCaptureRequest imageCaptureRequest, int i, String str, Throwable th) {
        this.f$0 = imageCaptureRequest;
        this.f$1 = i;
        this.f$2 = str;
        this.f$3 = th;
    }

    public final void run() {
        this.f$0.lambda$notifyCallbackError$1$ImageCapture$ImageCaptureRequest(this.f$1, this.f$2, this.f$3);
    }
}
