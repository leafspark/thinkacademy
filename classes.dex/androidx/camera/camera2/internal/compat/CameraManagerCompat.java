package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.util.ArrayMap;
import androidx.camera.camera2.internal.compat.ApiCompat;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import java.util.Map;
import java.util.concurrent.Executor;

public final class CameraManagerCompat {
    private final Map<String, CameraCharacteristicsCompat> mCameraCharacteristicsMap = new ArrayMap(4);
    private final CameraManagerCompatImpl mImpl;

    private CameraManagerCompat(CameraManagerCompatImpl cameraManagerCompatImpl) {
        this.mImpl = cameraManagerCompatImpl;
    }

    public static CameraManagerCompat from(Context context) {
        return from(context, MainThreadAsyncHandler.getInstance());
    }

    public static CameraManagerCompat from(Context context, Handler handler) {
        return new CameraManagerCompat(CameraManagerCompatImpl.CC.from(context, handler));
    }

    public static CameraManagerCompat from(CameraManagerCompatImpl cameraManagerCompatImpl) {
        return new CameraManagerCompat(cameraManagerCompatImpl);
    }

    public String[] getCameraIdList() throws CameraAccessExceptionCompat {
        return this.mImpl.getCameraIdList();
    }

    public void registerAvailabilityCallback(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
        this.mImpl.registerAvailabilityCallback(executor, availabilityCallback);
    }

    public void unregisterAvailabilityCallback(CameraManager.AvailabilityCallback availabilityCallback) {
        this.mImpl.unregisterAvailabilityCallback(availabilityCallback);
    }

    public CameraCharacteristicsCompat getCameraCharacteristicsCompat(String str) throws CameraAccessExceptionCompat {
        CameraCharacteristicsCompat cameraCharacteristicsCompat;
        synchronized (this.mCameraCharacteristicsMap) {
            cameraCharacteristicsCompat = this.mCameraCharacteristicsMap.get(str);
            if (cameraCharacteristicsCompat == null) {
                cameraCharacteristicsCompat = CameraCharacteristicsCompat.toCameraCharacteristicsCompat(this.mImpl.getCameraCharacteristics(str));
                this.mCameraCharacteristicsMap.put(str, cameraCharacteristicsCompat);
            }
        }
        return cameraCharacteristicsCompat;
    }

    public void openCamera(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat {
        this.mImpl.openCamera(str, executor, stateCallback);
    }

    public CameraManager unwrap() {
        return this.mImpl.getCameraManager();
    }

    public interface CameraManagerCompatImpl {
        CameraCharacteristics getCameraCharacteristics(String str) throws CameraAccessExceptionCompat;

        String[] getCameraIdList() throws CameraAccessExceptionCompat;

        CameraManager getCameraManager();

        void openCamera(String str, Executor executor, CameraDevice.StateCallback stateCallback) throws CameraAccessExceptionCompat;

        void registerAvailabilityCallback(Executor executor, CameraManager.AvailabilityCallback availabilityCallback);

        void unregisterAvailabilityCallback(CameraManager.AvailabilityCallback availabilityCallback);

        /* renamed from: androidx.camera.camera2.internal.compat.CameraManagerCompat$CameraManagerCompatImpl$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static CameraManagerCompatImpl from(Context context, Handler handler) {
                if (Build.VERSION.SDK_INT >= 29) {
                    return new CameraManagerCompatApi29Impl(context);
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    return CameraManagerCompatApi28Impl.create(context);
                }
                return CameraManagerCompatBaseImpl.create(context, handler);
            }
        }
    }

    static final class AvailabilityCallbackExecutorWrapper extends CameraManager.AvailabilityCallback {
        private boolean mDisabled = false;
        private final Executor mExecutor;
        private final Object mLock = new Object();
        final CameraManager.AvailabilityCallback mWrappedCallback;

        AvailabilityCallbackExecutorWrapper(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
            this.mExecutor = executor;
            this.mWrappedCallback = availabilityCallback;
        }

        /* access modifiers changed from: package-private */
        public void setDisabled() {
            synchronized (this.mLock) {
                this.mDisabled = true;
            }
        }

        public void onCameraAccessPrioritiesChanged() {
            synchronized (this.mLock) {
                if (!this.mDisabled) {
                    this.mExecutor.execute(new Runnable() {
                        public void run() {
                            ApiCompat.Api29Impl.onCameraAccessPrioritiesChanged(AvailabilityCallbackExecutorWrapper.this.mWrappedCallback);
                        }
                    });
                }
            }
        }

        public void onCameraAvailable(final String str) {
            synchronized (this.mLock) {
                if (!this.mDisabled) {
                    this.mExecutor.execute(new Runnable() {
                        public void run() {
                            AvailabilityCallbackExecutorWrapper.this.mWrappedCallback.onCameraAvailable(str);
                        }
                    });
                }
            }
        }

        public void onCameraUnavailable(final String str) {
            synchronized (this.mLock) {
                if (!this.mDisabled) {
                    this.mExecutor.execute(new Runnable() {
                        public void run() {
                            AvailabilityCallbackExecutorWrapper.this.mWrappedCallback.onCameraUnavailable(str);
                        }
                    });
                }
            }
        }
    }
}
