package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraControl;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

final class TorchControl {
    static final int DEFAULT_TORCH_STATE = 0;
    private static final String TAG = "TorchControl";
    private final Camera2CameraControlImpl mCamera2CameraControlImpl;
    private final Camera2CameraControlImpl.CaptureResultListener mCaptureResultListener;
    CallbackToFutureAdapter.Completer<Void> mEnableTorchCompleter;
    private final Executor mExecutor;
    private final boolean mHasFlashUnit;
    private boolean mIsActive;
    boolean mTargetTorchEnabled;
    private final MutableLiveData<Integer> mTorchState;

    TorchControl(Camera2CameraControlImpl camera2CameraControlImpl, CameraCharacteristicsCompat cameraCharacteristicsCompat, Executor executor) {
        AnonymousClass1 r0 = new Camera2CameraControlImpl.CaptureResultListener() {
            public boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
                if (TorchControl.this.mEnableTorchCompleter != null) {
                    Integer num = (Integer) totalCaptureResult.getRequest().get(CaptureRequest.FLASH_MODE);
                    if ((num != null && num.intValue() == 2) == TorchControl.this.mTargetTorchEnabled) {
                        TorchControl.this.mEnableTorchCompleter.set(null);
                        TorchControl.this.mEnableTorchCompleter = null;
                    }
                }
                return false;
            }
        };
        this.mCaptureResultListener = r0;
        this.mCamera2CameraControlImpl = camera2CameraControlImpl;
        this.mExecutor = executor;
        Boolean bool = (Boolean) cameraCharacteristicsCompat.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        this.mHasFlashUnit = bool != null && bool.booleanValue();
        this.mTorchState = new MutableLiveData<>(0);
        camera2CameraControlImpl.addCaptureResultListener(r0);
    }

    /* access modifiers changed from: package-private */
    public void setActive(boolean z) {
        if (this.mIsActive != z) {
            this.mIsActive = z;
            if (!z) {
                if (this.mTargetTorchEnabled) {
                    this.mTargetTorchEnabled = false;
                    this.mCamera2CameraControlImpl.enableTorchInternal(false);
                    setLiveDataValue(this.mTorchState, 0);
                }
                CallbackToFutureAdapter.Completer<Void> completer = this.mEnableTorchCompleter;
                if (completer != null) {
                    completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
                    this.mEnableTorchCompleter = null;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<Void> enableTorch(boolean z) {
        if (!this.mHasFlashUnit) {
            Logger.d(TAG, "Unable to enableTorch due to there is no flash unit.");
            return Futures.immediateFailedFuture(new IllegalStateException("No flash unit"));
        }
        setLiveDataValue(this.mTorchState, Integer.valueOf(z ? 1 : 0));
        return CallbackToFutureAdapter.getFuture(new TorchControl$$ExternalSyntheticLambda0(this, z));
    }

    public /* synthetic */ Object lambda$enableTorch$1$TorchControl(boolean z, CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new TorchControl$$ExternalSyntheticLambda1(this, completer, z));
        return "enableTorch: " + z;
    }

    /* access modifiers changed from: package-private */
    public LiveData<Integer> getTorchState() {
        return this.mTorchState;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: enableTorchInternal */
    public void lambda$enableTorch$0$TorchControl(CallbackToFutureAdapter.Completer<Void> completer, boolean z) {
        if (!this.mIsActive) {
            setLiveDataValue(this.mTorchState, 0);
            completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
            return;
        }
        this.mTargetTorchEnabled = z;
        this.mCamera2CameraControlImpl.enableTorchInternal(z);
        setLiveDataValue(this.mTorchState, Integer.valueOf(z ? 1 : 0));
        CallbackToFutureAdapter.Completer<Void> completer2 = this.mEnableTorchCompleter;
        if (completer2 != null) {
            completer2.setException(new CameraControl.OperationCanceledException("There is a new enableTorch being set"));
        }
        this.mEnableTorchCompleter = completer;
    }

    private <T> void setLiveDataValue(MutableLiveData<T> mutableLiveData, T t) {
        if (Threads.isMainThread()) {
            mutableLiveData.setValue(t);
        } else {
            mutableLiveData.postValue(t);
        }
    }
}
