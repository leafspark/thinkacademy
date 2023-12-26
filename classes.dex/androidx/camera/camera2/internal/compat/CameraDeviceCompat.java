package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.os.Build;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import java.util.concurrent.Executor;

public final class CameraDeviceCompat {
    public static final int SESSION_OPERATION_MODE_CONSTRAINED_HIGH_SPEED = 1;
    public static final int SESSION_OPERATION_MODE_NORMAL = 0;
    private final CameraDeviceCompatImpl mImpl;

    interface CameraDeviceCompatImpl {
        void createCaptureSession(SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessException;

        CameraDevice unwrap();
    }

    private CameraDeviceCompat(CameraDevice cameraDevice, Handler handler) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mImpl = new CameraDeviceCompatApi28Impl(cameraDevice);
        } else if (Build.VERSION.SDK_INT >= 24) {
            this.mImpl = CameraDeviceCompatApi24Impl.create(cameraDevice, handler);
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.mImpl = CameraDeviceCompatApi23Impl.create(cameraDevice, handler);
        } else {
            this.mImpl = CameraDeviceCompatBaseImpl.create(cameraDevice, handler);
        }
    }

    public static CameraDeviceCompat toCameraDeviceCompat(CameraDevice cameraDevice) {
        return toCameraDeviceCompat(cameraDevice, MainThreadAsyncHandler.getInstance());
    }

    public static CameraDeviceCompat toCameraDeviceCompat(CameraDevice cameraDevice, Handler handler) {
        return new CameraDeviceCompat(cameraDevice, handler);
    }

    public CameraDevice toCameraDevice() {
        return this.mImpl.unwrap();
    }

    public void createCaptureSession(SessionConfigurationCompat sessionConfigurationCompat) throws CameraAccessException {
        this.mImpl.createCaptureSession(sessionConfigurationCompat);
    }

    static final class StateCallbackExecutorWrapper extends CameraDevice.StateCallback {
        private final Executor mExecutor;
        final CameraDevice.StateCallback mWrappedCallback;

        StateCallbackExecutorWrapper(Executor executor, CameraDevice.StateCallback stateCallback) {
            this.mExecutor = executor;
            this.mWrappedCallback = stateCallback;
        }

        public void onOpened(final CameraDevice cameraDevice) {
            this.mExecutor.execute(new Runnable() {
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onOpened(cameraDevice);
                }
            });
        }

        public void onDisconnected(final CameraDevice cameraDevice) {
            this.mExecutor.execute(new Runnable() {
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onDisconnected(cameraDevice);
                }
            });
        }

        public void onError(final CameraDevice cameraDevice, final int i) {
            this.mExecutor.execute(new Runnable() {
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onError(cameraDevice, i);
                }
            });
        }

        public void onClosed(final CameraDevice cameraDevice) {
            this.mExecutor.execute(new Runnable() {
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onClosed(cameraDevice);
                }
            });
        }
    }
}
