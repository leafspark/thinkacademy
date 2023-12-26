package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Range;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraControl;
import androidx.camera.core.ExposureState;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public class ExposureControl {
    private static final int DEFAULT_EXPOSURE_COMPENSATION = 0;
    private final Camera2CameraControlImpl mCameraControl;
    private final Executor mExecutor;
    private final ExposureStateImpl mExposureStateImpl;
    private boolean mIsActive = false;
    private Camera2CameraControlImpl.CaptureResultListener mRunningCaptureResultListener;
    private CallbackToFutureAdapter.Completer<Integer> mRunningCompleter;

    ExposureControl(Camera2CameraControlImpl camera2CameraControlImpl, CameraCharacteristicsCompat cameraCharacteristicsCompat, Executor executor) {
        this.mCameraControl = camera2CameraControlImpl;
        this.mExposureStateImpl = new ExposureStateImpl(cameraCharacteristicsCompat, 0);
        this.mExecutor = executor;
    }

    static ExposureState getDefaultExposureState(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        return new ExposureStateImpl(cameraCharacteristicsCompat, 0);
    }

    /* access modifiers changed from: package-private */
    public void setActive(boolean z) {
        if (z != this.mIsActive) {
            this.mIsActive = z;
            if (!z) {
                this.mExposureStateImpl.setExposureCompensationIndex(0);
                clearRunningTask();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setCaptureRequestOption(Camera2ImplConfig.Builder builder) {
        builder.setCaptureRequestOption(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(this.mExposureStateImpl.getExposureCompensationIndex()));
    }

    /* access modifiers changed from: package-private */
    public ExposureState getExposureState() {
        return this.mExposureStateImpl;
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<Integer> setExposureCompensationIndex(int i) {
        if (!this.mExposureStateImpl.isExposureCompensationSupported()) {
            return Futures.immediateFailedFuture(new IllegalArgumentException("ExposureCompensation is not supported"));
        }
        Range<Integer> exposureCompensationRange = this.mExposureStateImpl.getExposureCompensationRange();
        if (!exposureCompensationRange.contains(Integer.valueOf(i))) {
            return Futures.immediateFailedFuture(new IllegalArgumentException("Requested ExposureCompensation " + i + " is not within valid range [" + exposureCompensationRange.getUpper() + ".." + exposureCompensationRange.getLower() + "]"));
        }
        this.mExposureStateImpl.setExposureCompensationIndex(i);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new ExposureControl$$ExternalSyntheticLambda1(this, i)));
    }

    public /* synthetic */ Object lambda$setExposureCompensationIndex$2$ExposureControl(int i, CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new ExposureControl$$ExternalSyntheticLambda2(this, completer, i));
        return "setExposureCompensationIndex[" + i + "]";
    }

    public /* synthetic */ void lambda$setExposureCompensationIndex$1$ExposureControl(CallbackToFutureAdapter.Completer completer, int i) {
        boolean z = false;
        if (!this.mIsActive) {
            this.mExposureStateImpl.setExposureCompensationIndex(0);
            completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
            return;
        }
        clearRunningTask();
        Preconditions.checkState(this.mRunningCompleter == null, "mRunningCompleter should be null when starting set a new exposure compensation value");
        if (this.mRunningCaptureResultListener == null) {
            z = true;
        }
        Preconditions.checkState(z, "mRunningCaptureResultListener should be null when starting set a new exposure compensation value");
        ExposureControl$$ExternalSyntheticLambda0 exposureControl$$ExternalSyntheticLambda0 = new ExposureControl$$ExternalSyntheticLambda0(i, completer);
        this.mRunningCaptureResultListener = exposureControl$$ExternalSyntheticLambda0;
        this.mRunningCompleter = completer;
        this.mCameraControl.addCaptureResultListener(exposureControl$$ExternalSyntheticLambda0);
        this.mCameraControl.updateSessionConfigSynchronous();
    }

    static /* synthetic */ boolean lambda$setExposureCompensationIndex$0(int i, CallbackToFutureAdapter.Completer completer, TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION);
        if (num != null && num2 != null) {
            int intValue = num.intValue();
            if ((intValue != 2 && intValue != 3 && intValue != 4) || num2.intValue() != i) {
                return false;
            }
            completer.set(Integer.valueOf(i));
            return true;
        } else if (num2 == null || num2.intValue() != i) {
            return false;
        } else {
            completer.set(Integer.valueOf(i));
            return true;
        }
    }

    private void clearRunningTask() {
        CallbackToFutureAdapter.Completer<Integer> completer = this.mRunningCompleter;
        if (completer != null) {
            completer.setException(new CameraControl.OperationCanceledException("Cancelled by another setExposureCompensationIndex()"));
            this.mRunningCompleter = null;
        }
        Camera2CameraControlImpl.CaptureResultListener captureResultListener = this.mRunningCaptureResultListener;
        if (captureResultListener != null) {
            this.mCameraControl.removeCaptureResultListener(captureResultListener);
            this.mRunningCaptureResultListener = null;
        }
    }
}
