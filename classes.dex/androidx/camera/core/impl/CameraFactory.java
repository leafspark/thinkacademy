package androidx.camera.core.impl;

import android.content.Context;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import java.util.Set;

public interface CameraFactory {

    public interface Provider {
        CameraFactory newInstance(Context context, CameraThreadConfig cameraThreadConfig, CameraSelector cameraSelector) throws InitializationException;
    }

    Set<String> getAvailableCameraIds();

    CameraInternal getCamera(String str) throws CameraUnavailableException;

    Object getCameraManager();
}
