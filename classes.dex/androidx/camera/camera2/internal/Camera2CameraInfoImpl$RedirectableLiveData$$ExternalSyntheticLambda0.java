package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.Camera2CameraInfoImpl;
import androidx.lifecycle.Observer;

public final /* synthetic */ class Camera2CameraInfoImpl$RedirectableLiveData$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ Camera2CameraInfoImpl.RedirectableLiveData f$0;

    public /* synthetic */ Camera2CameraInfoImpl$RedirectableLiveData$$ExternalSyntheticLambda0(Camera2CameraInfoImpl.RedirectableLiveData redirectableLiveData) {
        this.f$0 = redirectableLiveData;
    }

    public final void onChanged(Object obj) {
        this.f$0.setValue(obj);
    }
}
