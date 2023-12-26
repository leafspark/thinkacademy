package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public final /* synthetic */ class SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda0 implements AsyncFunction {
    public final /* synthetic */ SynchronizedCaptureSessionImpl f$0;
    public final /* synthetic */ CameraDevice f$1;
    public final /* synthetic */ SessionConfigurationCompat f$2;
    public final /* synthetic */ List f$3;

    public /* synthetic */ SynchronizedCaptureSessionImpl$$ExternalSyntheticLambda0(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl, CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat, List list) {
        this.f$0 = synchronizedCaptureSessionImpl;
        this.f$1 = cameraDevice;
        this.f$2 = sessionConfigurationCompat;
        this.f$3 = list;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f$0.lambda$openCaptureSession$1$SynchronizedCaptureSessionImpl(this.f$1, this.f$2, this.f$3, (List) obj);
    }
}
