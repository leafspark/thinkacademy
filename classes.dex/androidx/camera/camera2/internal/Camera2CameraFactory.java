package androidx.camera.camera2.internal;

import android.content.Context;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.camera.core.impl.CameraThreadConfig;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Camera2CameraFactory implements CameraFactory {
    private static final int DEFAULT_ALLOWED_CONCURRENT_OPEN_CAMERAS = 1;
    private final List<String> mAvailableCameraIds;
    private final Map<String, Camera2CameraInfoImpl> mCameraInfos = new HashMap();
    private final CameraManagerCompat mCameraManager;
    private final CameraStateRegistry mCameraStateRegistry;
    private final CameraThreadConfig mThreadConfig;

    public Camera2CameraFactory(Context context, CameraThreadConfig cameraThreadConfig, CameraSelector cameraSelector) throws InitializationException {
        this.mThreadConfig = cameraThreadConfig;
        this.mCameraStateRegistry = new CameraStateRegistry(1);
        this.mCameraManager = CameraManagerCompat.from(context, cameraThreadConfig.getSchedulerHandler());
        this.mAvailableCameraIds = CameraSelectionOptimizer.getSelectedAvailableCameraIds(this, cameraSelector);
    }

    public CameraInternal getCamera(String str) throws CameraUnavailableException {
        if (this.mAvailableCameraIds.contains(str)) {
            return new Camera2CameraImpl(this.mCameraManager, str, getCameraInfo(str), this.mCameraStateRegistry, this.mThreadConfig.getCameraExecutor(), this.mThreadConfig.getSchedulerHandler());
        }
        throw new IllegalArgumentException("The given camera id is not on the available camera id list.");
    }

    /* access modifiers changed from: package-private */
    public Camera2CameraInfoImpl getCameraInfo(String str) throws CameraUnavailableException {
        try {
            Camera2CameraInfoImpl camera2CameraInfoImpl = this.mCameraInfos.get(str);
            if (camera2CameraInfoImpl != null) {
                return camera2CameraInfoImpl;
            }
            Camera2CameraInfoImpl camera2CameraInfoImpl2 = new Camera2CameraInfoImpl(str, this.mCameraManager.getCameraCharacteristicsCompat(str));
            this.mCameraInfos.put(str, camera2CameraInfoImpl2);
            return camera2CameraInfoImpl2;
        } catch (CameraAccessExceptionCompat e) {
            throw CameraUnavailableExceptionHelper.createFrom(e);
        }
    }

    public Set<String> getAvailableCameraIds() {
        return new LinkedHashSet(this.mAvailableCameraIds);
    }

    public CameraManagerCompat getCameraManager() {
        return this.mCameraManager;
    }
}
