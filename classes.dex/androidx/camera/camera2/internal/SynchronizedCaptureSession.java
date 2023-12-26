package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;

interface SynchronizedCaptureSession {

    public static abstract class StateCallback {
        /* access modifiers changed from: package-private */
        public void onActive(SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        /* access modifiers changed from: package-private */
        public void onCaptureQueueEmpty(SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        /* access modifiers changed from: package-private */
        public void onClosed(SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        /* access modifiers changed from: package-private */
        public void onConfigureFailed(SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        /* access modifiers changed from: package-private */
        public void onConfigured(SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        /* access modifiers changed from: package-private */
        public void onReady(SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        /* access modifiers changed from: package-private */
        public void onSessionFinished(SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        /* access modifiers changed from: package-private */
        public void onSurfacePrepared(SynchronizedCaptureSession synchronizedCaptureSession, Surface surface) {
        }
    }

    void abortCaptures() throws CameraAccessException;

    int captureBurstRequests(List<CaptureRequest> list, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

    int captureBurstRequests(List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

    int captureSingleRequest(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

    int captureSingleRequest(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

    void close();

    void finishClose();

    CameraDevice getDevice();

    StateCallback getStateCallback();

    ListenableFuture<Void> getSynchronizedBlocker(String str);

    int setRepeatingBurstRequests(List<CaptureRequest> list, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

    int setRepeatingBurstRequests(List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

    int setSingleRepeatingRequest(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

    int setSingleRepeatingRequest(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

    void stopRepeating() throws CameraAccessException;

    CameraCaptureSessionCompat toCameraCaptureSessionCompat();
}
