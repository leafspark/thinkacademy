package androidx.camera.view;

import android.content.Context;
import android.util.Log;
import androidx.camera.core.Camera;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.impl.utils.Threads;
import androidx.lifecycle.LifecycleOwner;

public final class LifecycleCameraController extends CameraController {
    private static final String TAG = "CamLifecycleController";
    private LifecycleOwner mLifecycleOwner;

    public LifecycleCameraController(Context context) {
        super(context);
    }

    public void bindToLifecycle(LifecycleOwner lifecycleOwner) {
        Threads.checkMainThread();
        this.mLifecycleOwner = lifecycleOwner;
        startCameraAndTrackStates();
    }

    public void unbind() {
        Threads.checkMainThread();
        this.mLifecycleOwner = null;
        this.mCamera = null;
        if (this.mCameraProvider != null) {
            this.mCameraProvider.unbindAll();
        }
    }

    /* access modifiers changed from: package-private */
    public Camera startCamera() {
        if (this.mLifecycleOwner == null) {
            Log.d(TAG, "Lifecycle is not set.");
            return null;
        } else if (this.mCameraProvider == null) {
            Log.d(TAG, "CameraProvider is not ready.");
            return null;
        } else {
            UseCaseGroup createUseCaseGroup = createUseCaseGroup();
            if (createUseCaseGroup == null) {
                return null;
            }
            return this.mCameraProvider.bindToLifecycle(this.mLifecycleOwner, this.mCameraSelector, createUseCaseGroup);
        }
    }

    /* access modifiers changed from: package-private */
    public void shutDownForTests() {
        if (this.mCameraProvider != null) {
            this.mCameraProvider.unbindAll();
            this.mCameraProvider.shutdown();
        }
    }
}
