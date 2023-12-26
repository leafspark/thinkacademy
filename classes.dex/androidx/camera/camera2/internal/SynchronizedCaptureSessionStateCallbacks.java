package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.ApiCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class SynchronizedCaptureSessionStateCallbacks extends SynchronizedCaptureSession.StateCallback {
    private final List<SynchronizedCaptureSession.StateCallback> mCallbacks;

    static SynchronizedCaptureSession.StateCallback createComboCallback(SynchronizedCaptureSession.StateCallback... stateCallbackArr) {
        return new SynchronizedCaptureSessionStateCallbacks(Arrays.asList(stateCallbackArr));
    }

    SynchronizedCaptureSessionStateCallbacks(List<SynchronizedCaptureSession.StateCallback> list) {
        ArrayList arrayList = new ArrayList();
        this.mCallbacks = arrayList;
        arrayList.addAll(list);
    }

    public void onSurfacePrepared(SynchronizedCaptureSession synchronizedCaptureSession, Surface surface) {
        for (SynchronizedCaptureSession.StateCallback onSurfacePrepared : this.mCallbacks) {
            onSurfacePrepared.onSurfacePrepared(synchronizedCaptureSession, surface);
        }
    }

    public void onReady(SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback onReady : this.mCallbacks) {
            onReady.onReady(synchronizedCaptureSession);
        }
    }

    public void onActive(SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback onActive : this.mCallbacks) {
            onActive.onActive(synchronizedCaptureSession);
        }
    }

    public void onCaptureQueueEmpty(SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback onCaptureQueueEmpty : this.mCallbacks) {
            onCaptureQueueEmpty.onCaptureQueueEmpty(synchronizedCaptureSession);
        }
    }

    public void onConfigured(SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback onConfigured : this.mCallbacks) {
            onConfigured.onConfigured(synchronizedCaptureSession);
        }
    }

    public void onConfigureFailed(SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback onConfigureFailed : this.mCallbacks) {
            onConfigureFailed.onConfigureFailed(synchronizedCaptureSession);
        }
    }

    public void onClosed(SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback onClosed : this.mCallbacks) {
            onClosed.onClosed(synchronizedCaptureSession);
        }
    }

    /* access modifiers changed from: package-private */
    public void onSessionFinished(SynchronizedCaptureSession synchronizedCaptureSession) {
        for (SynchronizedCaptureSession.StateCallback onSessionFinished : this.mCallbacks) {
            onSessionFinished.onSessionFinished(synchronizedCaptureSession);
        }
    }

    static class Adapter extends SynchronizedCaptureSession.StateCallback {
        private final CameraCaptureSession.StateCallback mCameraCaptureSessionStateCallback;

        /* access modifiers changed from: package-private */
        public void onSessionFinished(SynchronizedCaptureSession synchronizedCaptureSession) {
        }

        Adapter(CameraCaptureSession.StateCallback stateCallback) {
            this.mCameraCaptureSessionStateCallback = stateCallback;
        }

        Adapter(List<CameraCaptureSession.StateCallback> list) {
            this(CameraCaptureSessionStateCallbacks.createComboCallback(list));
        }

        public void onSurfacePrepared(SynchronizedCaptureSession synchronizedCaptureSession, Surface surface) {
            ApiCompat.Api23Impl.onSurfacePrepared(this.mCameraCaptureSessionStateCallback, synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession(), surface);
        }

        public void onReady(SynchronizedCaptureSession synchronizedCaptureSession) {
            this.mCameraCaptureSessionStateCallback.onReady(synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        public void onActive(SynchronizedCaptureSession synchronizedCaptureSession) {
            this.mCameraCaptureSessionStateCallback.onActive(synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        public void onCaptureQueueEmpty(SynchronizedCaptureSession synchronizedCaptureSession) {
            ApiCompat.Api26Impl.onCaptureQueueEmpty(this.mCameraCaptureSessionStateCallback, synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        public void onConfigured(SynchronizedCaptureSession synchronizedCaptureSession) {
            this.mCameraCaptureSessionStateCallback.onConfigured(synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        public void onConfigureFailed(SynchronizedCaptureSession synchronizedCaptureSession) {
            this.mCameraCaptureSessionStateCallback.onConfigureFailed(synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }

        public void onClosed(SynchronizedCaptureSession synchronizedCaptureSession) {
            this.mCameraCaptureSessionStateCallback.onClosed(synchronizedCaptureSession.toCameraCaptureSessionCompat().toCameraCaptureSession());
        }
    }
}
