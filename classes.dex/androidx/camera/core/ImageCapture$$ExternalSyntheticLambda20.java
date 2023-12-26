package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class ImageCapture$$ExternalSyntheticLambda20 implements AsyncFunction {
    public final /* synthetic */ ImageCapture f$0;
    public final /* synthetic */ ImageCapture.TakePictureState f$1;

    public /* synthetic */ ImageCapture$$ExternalSyntheticLambda20(ImageCapture imageCapture, ImageCapture.TakePictureState takePictureState) {
        this.f$0 = imageCapture;
        this.f$1 = takePictureState;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f$0.lambda$preTakePicture$12$ImageCapture(this.f$1, (Void) obj);
    }
}
