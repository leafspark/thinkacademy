package androidx.camera.core;

import androidx.lifecycle.LiveData;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface CameraInfo {
    public static final String IMPLEMENTATION_TYPE_CAMERA2 = "androidx.camera.camera2";
    public static final String IMPLEMENTATION_TYPE_CAMERA2_LEGACY = "androidx.camera.camera2.legacy";
    public static final String IMPLEMENTATION_TYPE_FAKE = "androidx.camera.fake";
    public static final String IMPLEMENTATION_TYPE_UNKNOWN = "<unknown>";

    /* renamed from: androidx.camera.core.CameraInfo$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$isFocusMeteringSupported(CameraInfo cameraInfo, FocusMeteringAction focusMeteringAction) {
            return false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ImplementationType {
    }

    CameraSelector getCameraSelector();

    LiveData<CameraState> getCameraState();

    ExposureState getExposureState();

    String getImplementationType();

    int getSensorRotationDegrees();

    int getSensorRotationDegrees(int i);

    LiveData<Integer> getTorchState();

    LiveData<ZoomState> getZoomState();

    boolean hasFlashUnit();

    boolean isFocusMeteringSupported(FocusMeteringAction focusMeteringAction);
}
