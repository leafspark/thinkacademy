package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.ApiCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CameraCaptureSessionStateCallbacks {
    private CameraCaptureSessionStateCallbacks() {
    }

    public static CameraCaptureSession.StateCallback createNoOpCallback() {
        return new NoOpSessionStateCallback();
    }

    public static CameraCaptureSession.StateCallback createComboCallback(List<CameraCaptureSession.StateCallback> list) {
        if (list.isEmpty()) {
            return createNoOpCallback();
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        return new ComboSessionStateCallback(list);
    }

    public static CameraCaptureSession.StateCallback createComboCallback(CameraCaptureSession.StateCallback... stateCallbackArr) {
        return createComboCallback((List<CameraCaptureSession.StateCallback>) Arrays.asList(stateCallbackArr));
    }

    static final class NoOpSessionStateCallback extends CameraCaptureSession.StateCallback {
        public void onActive(CameraCaptureSession cameraCaptureSession) {
        }

        public void onCaptureQueueEmpty(CameraCaptureSession cameraCaptureSession) {
        }

        public void onClosed(CameraCaptureSession cameraCaptureSession) {
        }

        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        }

        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
        }

        public void onReady(CameraCaptureSession cameraCaptureSession) {
        }

        public void onSurfacePrepared(CameraCaptureSession cameraCaptureSession, Surface surface) {
        }

        NoOpSessionStateCallback() {
        }
    }

    static final class ComboSessionStateCallback extends CameraCaptureSession.StateCallback {
        private final List<CameraCaptureSession.StateCallback> mCallbacks = new ArrayList();

        ComboSessionStateCallback(List<CameraCaptureSession.StateCallback> list) {
            for (CameraCaptureSession.StateCallback next : list) {
                if (!(next instanceof NoOpSessionStateCallback)) {
                    this.mCallbacks.add(next);
                }
            }
        }

        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            for (CameraCaptureSession.StateCallback onConfigured : this.mCallbacks) {
                onConfigured.onConfigured(cameraCaptureSession);
            }
        }

        public void onActive(CameraCaptureSession cameraCaptureSession) {
            for (CameraCaptureSession.StateCallback onActive : this.mCallbacks) {
                onActive.onActive(cameraCaptureSession);
            }
        }

        public void onClosed(CameraCaptureSession cameraCaptureSession) {
            for (CameraCaptureSession.StateCallback onClosed : this.mCallbacks) {
                onClosed.onClosed(cameraCaptureSession);
            }
        }

        public void onReady(CameraCaptureSession cameraCaptureSession) {
            for (CameraCaptureSession.StateCallback onReady : this.mCallbacks) {
                onReady.onReady(cameraCaptureSession);
            }
        }

        public void onCaptureQueueEmpty(CameraCaptureSession cameraCaptureSession) {
            for (CameraCaptureSession.StateCallback onCaptureQueueEmpty : this.mCallbacks) {
                ApiCompat.Api26Impl.onCaptureQueueEmpty(onCaptureQueueEmpty, cameraCaptureSession);
            }
        }

        public void onSurfacePrepared(CameraCaptureSession cameraCaptureSession, Surface surface) {
            for (CameraCaptureSession.StateCallback onSurfacePrepared : this.mCallbacks) {
                ApiCompat.Api23Impl.onSurfacePrepared(onSurfacePrepared, cameraCaptureSession, surface);
            }
        }

        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            for (CameraCaptureSession.StateCallback onConfigureFailed : this.mCallbacks) {
                onConfigureFailed.onConfigureFailed(cameraCaptureSession);
            }
        }
    }
}
