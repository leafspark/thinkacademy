package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.ApiCompat;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import java.util.List;
import java.util.concurrent.Executor;

public final class CameraCaptureSessionCompat {
    private final CameraCaptureSessionCompatImpl mImpl;

    interface CameraCaptureSessionCompatImpl {
        int captureBurstRequests(List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

        int captureSingleRequest(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

        int setRepeatingBurstRequests(List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

        int setSingleRepeatingRequest(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

        CameraCaptureSession unwrap();
    }

    private CameraCaptureSessionCompat(CameraCaptureSession cameraCaptureSession, Handler handler) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mImpl = new CameraCaptureSessionCompatApi28Impl(cameraCaptureSession);
        } else {
            this.mImpl = CameraCaptureSessionCompatBaseImpl.create(cameraCaptureSession, handler);
        }
    }

    public static CameraCaptureSessionCompat toCameraCaptureSessionCompat(CameraCaptureSession cameraCaptureSession) {
        return toCameraCaptureSessionCompat(cameraCaptureSession, MainThreadAsyncHandler.getInstance());
    }

    public static CameraCaptureSessionCompat toCameraCaptureSessionCompat(CameraCaptureSession cameraCaptureSession, Handler handler) {
        return new CameraCaptureSessionCompat(cameraCaptureSession, handler);
    }

    public CameraCaptureSession toCameraCaptureSession() {
        return this.mImpl.unwrap();
    }

    public int captureBurstRequests(List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.mImpl.captureBurstRequests(list, executor, captureCallback);
    }

    public int captureSingleRequest(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.mImpl.captureSingleRequest(captureRequest, executor, captureCallback);
    }

    public int setRepeatingBurstRequests(List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.mImpl.setRepeatingBurstRequests(list, executor, captureCallback);
    }

    public int setSingleRepeatingRequest(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.mImpl.setSingleRepeatingRequest(captureRequest, executor, captureCallback);
    }

    static final class CaptureCallbackExecutorWrapper extends CameraCaptureSession.CaptureCallback {
        private final Executor mExecutor;
        final CameraCaptureSession.CaptureCallback mWrappedCallback;

        CaptureCallbackExecutorWrapper(Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
            this.mExecutor = executor;
            this.mWrappedCallback = captureCallback;
        }

        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
            final CameraCaptureSession cameraCaptureSession2 = cameraCaptureSession;
            final CaptureRequest captureRequest2 = captureRequest;
            final long j3 = j;
            final long j4 = j2;
            this.mExecutor.execute(new Runnable() {
                public void run() {
                    CaptureCallbackExecutorWrapper.this.mWrappedCallback.onCaptureStarted(cameraCaptureSession2, captureRequest2, j3, j4);
                }
            });
        }

        public void onCaptureProgressed(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final CaptureResult captureResult) {
            this.mExecutor.execute(new Runnable() {
                public void run() {
                    CaptureCallbackExecutorWrapper.this.mWrappedCallback.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                }
            });
        }

        public void onCaptureCompleted(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final TotalCaptureResult totalCaptureResult) {
            this.mExecutor.execute(new Runnable() {
                public void run() {
                    CaptureCallbackExecutorWrapper.this.mWrappedCallback.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                }
            });
        }

        public void onCaptureFailed(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final CaptureFailure captureFailure) {
            this.mExecutor.execute(new Runnable() {
                public void run() {
                    CaptureCallbackExecutorWrapper.this.mWrappedCallback.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                }
            });
        }

        public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i, long j) {
            final CameraCaptureSession cameraCaptureSession2 = cameraCaptureSession;
            final int i2 = i;
            final long j2 = j;
            this.mExecutor.execute(new Runnable() {
                public void run() {
                    CaptureCallbackExecutorWrapper.this.mWrappedCallback.onCaptureSequenceCompleted(cameraCaptureSession2, i2, j2);
                }
            });
        }

        public void onCaptureSequenceAborted(final CameraCaptureSession cameraCaptureSession, final int i) {
            this.mExecutor.execute(new Runnable() {
                public void run() {
                    CaptureCallbackExecutorWrapper.this.mWrappedCallback.onCaptureSequenceAborted(cameraCaptureSession, i);
                }
            });
        }

        public void onCaptureBufferLost(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j) {
            final CameraCaptureSession cameraCaptureSession2 = cameraCaptureSession;
            final CaptureRequest captureRequest2 = captureRequest;
            final Surface surface2 = surface;
            final long j2 = j;
            this.mExecutor.execute(new Runnable() {
                public void run() {
                    ApiCompat.Api24Impl.onCaptureBufferLost(CaptureCallbackExecutorWrapper.this.mWrappedCallback, cameraCaptureSession2, captureRequest2, surface2, j2);
                }
            });
        }
    }

    static final class StateCallbackExecutorWrapper extends CameraCaptureSession.StateCallback {
        private final Executor mExecutor;
        final CameraCaptureSession.StateCallback mWrappedCallback;

        StateCallbackExecutorWrapper(Executor executor, CameraCaptureSession.StateCallback stateCallback) {
            this.mExecutor = executor;
            this.mWrappedCallback = stateCallback;
        }

        public void onConfigured(final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() {
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onConfigured(cameraCaptureSession);
                }
            });
        }

        public void onConfigureFailed(final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() {
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onConfigureFailed(cameraCaptureSession);
                }
            });
        }

        public void onReady(final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() {
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onReady(cameraCaptureSession);
                }
            });
        }

        public void onActive(final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() {
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onActive(cameraCaptureSession);
                }
            });
        }

        public void onCaptureQueueEmpty(final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() {
                public void run() {
                    ApiCompat.Api26Impl.onCaptureQueueEmpty(StateCallbackExecutorWrapper.this.mWrappedCallback, cameraCaptureSession);
                }
            });
        }

        public void onClosed(final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() {
                public void run() {
                    StateCallbackExecutorWrapper.this.mWrappedCallback.onClosed(cameraCaptureSession);
                }
            });
        }

        public void onSurfacePrepared(final CameraCaptureSession cameraCaptureSession, final Surface surface) {
            this.mExecutor.execute(new Runnable() {
                public void run() {
                    ApiCompat.Api23Impl.onSurfacePrepared(StateCallbackExecutorWrapper.this.mWrappedCallback, cameraCaptureSession, surface);
                }
            });
        }
    }
}
