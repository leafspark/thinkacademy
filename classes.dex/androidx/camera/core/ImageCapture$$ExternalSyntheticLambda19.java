package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class ImageCapture$$ExternalSyntheticLambda19 implements AsyncFunction {
    public final /* synthetic */ ImageCapture f$0;
    public final /* synthetic */ ImageCapture.TakePictureState f$1;

    public /* synthetic */ ImageCapture$$ExternalSyntheticLambda19(ImageCapture imageCapture, ImageCapture.TakePictureState takePictureState) {
        this.f$0 = imageCapture;
        this.f$1 = takePictureState;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f$0.lambda$preTakePicture$11$ImageCapture(this.f$1, (CameraCaptureResult) obj);
    }
}
