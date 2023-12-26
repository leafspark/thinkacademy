package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CameraDeviceStateCallbacks {
    private CameraDeviceStateCallbacks() {
    }

    public static CameraDevice.StateCallback createNoOpCallback() {
        return new NoOpDeviceStateCallback();
    }

    public static CameraDevice.StateCallback createComboCallback(List<CameraDevice.StateCallback> list) {
        if (list.isEmpty()) {
            return createNoOpCallback();
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        return new ComboDeviceStateCallback(list);
    }

    public static CameraDevice.StateCallback createComboCallback(CameraDevice.StateCallback... stateCallbackArr) {
        return createComboCallback((List<CameraDevice.StateCallback>) Arrays.asList(stateCallbackArr));
    }

    static final class NoOpDeviceStateCallback extends CameraDevice.StateCallback {
        public void onClosed(CameraDevice cameraDevice) {
        }

        public void onDisconnected(CameraDevice cameraDevice) {
        }

        public void onError(CameraDevice cameraDevice, int i) {
        }

        public void onOpened(CameraDevice cameraDevice) {
        }

        NoOpDeviceStateCallback() {
        }
    }

    private static final class ComboDeviceStateCallback extends CameraDevice.StateCallback {
        private final List<CameraDevice.StateCallback> mCallbacks = new ArrayList();

        ComboDeviceStateCallback(List<CameraDevice.StateCallback> list) {
            for (CameraDevice.StateCallback next : list) {
                if (!(next instanceof NoOpDeviceStateCallback)) {
                    this.mCallbacks.add(next);
                }
            }
        }

        public void onOpened(CameraDevice cameraDevice) {
            for (CameraDevice.StateCallback onOpened : this.mCallbacks) {
                onOpened.onOpened(cameraDevice);
            }
        }

        public void onClosed(CameraDevice cameraDevice) {
            for (CameraDevice.StateCallback onClosed : this.mCallbacks) {
                onClosed.onClosed(cameraDevice);
            }
        }

        public void onDisconnected(CameraDevice cameraDevice) {
            for (CameraDevice.StateCallback onDisconnected : this.mCallbacks) {
                onDisconnected.onDisconnected(cameraDevice);
            }
        }

        public void onError(CameraDevice cameraDevice, int i) {
            for (CameraDevice.StateCallback onError : this.mCallbacks) {
                onError.onError(cameraDevice, i);
            }
        }
    }
}
