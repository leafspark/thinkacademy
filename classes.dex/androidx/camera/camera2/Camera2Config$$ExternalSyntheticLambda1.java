package androidx.camera.camera2;

import android.content.Context;
import androidx.camera.camera2.internal.Camera2CameraFactory;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraThreadConfig;

public final /* synthetic */ class Camera2Config$$ExternalSyntheticLambda1 implements CameraFactory.Provider {
    public static final /* synthetic */ Camera2Config$$ExternalSyntheticLambda1 INSTANCE = new Camera2Config$$ExternalSyntheticLambda1();

    private /* synthetic */ Camera2Config$$ExternalSyntheticLambda1() {
    }

    public final CameraFactory newInstance(Context context, CameraThreadConfig cameraThreadConfig, CameraSelector cameraSelector) {
        return new Camera2CameraFactory(context, cameraThreadConfig, cameraSelector);
    }
}
