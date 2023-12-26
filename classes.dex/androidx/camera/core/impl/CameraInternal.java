package androidx.camera.core.impl;

import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public interface CameraInternal extends Camera, UseCase.StateChangeCallback {
    void attachUseCases(Collection<UseCase> collection);

    void close();

    void detachUseCases(Collection<UseCase> collection);

    CameraControl getCameraControl();

    CameraControlInternal getCameraControlInternal();

    CameraInfo getCameraInfo();

    CameraInfoInternal getCameraInfoInternal();

    LinkedHashSet<CameraInternal> getCameraInternals();

    Observable<State> getCameraState();

    CameraConfig getExtendedConfig();

    void open();

    ListenableFuture<Void> release();

    void setExtendedConfig(CameraConfig cameraConfig);

    public enum State {
        PENDING_OPEN(false),
        OPENING(true),
        OPEN(true),
        CLOSING(true),
        CLOSED(false),
        RELEASING(true),
        RELEASED(false);
        
        private final boolean mHoldsCameraSlot;

        private State(boolean z) {
            this.mHoldsCameraSlot = z;
        }

        /* access modifiers changed from: package-private */
        public boolean holdsCameraSlot() {
            return this.mHoldsCameraSlot;
        }
    }

    /* renamed from: androidx.camera.core.impl.CameraInternal$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$setExtendedConfig(CameraInternal cameraInternal, CameraConfig cameraConfig) {
        }

        public static CameraControl $default$getCameraControl(CameraInternal _this) {
            return _this.getCameraControlInternal();
        }

        public static CameraInfo $default$getCameraInfo(CameraInternal _this) {
            return _this.getCameraInfoInternal();
        }

        public static LinkedHashSet $default$getCameraInternals(CameraInternal _this) {
            return new LinkedHashSet(Collections.singleton(_this));
        }

        public static CameraConfig $default$getExtendedConfig(CameraInternal _this) {
            return CameraConfigs.emptyConfig();
        }
    }
}
