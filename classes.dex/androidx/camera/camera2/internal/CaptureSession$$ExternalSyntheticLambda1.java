package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public final /* synthetic */ class CaptureSession$$ExternalSyntheticLambda1 implements AsyncFunction {
    public final /* synthetic */ CaptureSession f$0;
    public final /* synthetic */ SessionConfig f$1;
    public final /* synthetic */ CameraDevice f$2;

    public /* synthetic */ CaptureSession$$ExternalSyntheticLambda1(CaptureSession captureSession, SessionConfig sessionConfig, CameraDevice cameraDevice) {
        this.f$0 = captureSession;
        this.f$1 = sessionConfig;
        this.f$2 = cameraDevice;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f$0.lambda$open$0$CaptureSession(this.f$1, this.f$2, (List) obj);
    }
}
