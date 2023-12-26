package androidx.camera.camera2.internal;

import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build;
import android.util.Rational;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.core.CameraControl;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.TagBundle;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class FocusMeteringControl {
    private static final MeteringRectangle[] EMPTY_RECTANGLES = new MeteringRectangle[0];
    private static final String TAG = "FocusMeteringControl";
    private MeteringRectangle[] mAeRects;
    private MeteringRectangle[] mAfRects;
    private ScheduledFuture<?> mAutoCancelHandle;
    private MeteringRectangle[] mAwbRects;
    private final Camera2CameraControlImpl mCameraControl;
    Integer mCurrentAfState = 0;
    final Executor mExecutor;
    long mFocusTimeoutCounter = 0;
    private volatile boolean mIsActive = false;
    boolean mIsAutoFocusCompleted = false;
    boolean mIsFocusSuccessful = false;
    private boolean mIsInAfAutoMode = false;
    private volatile Rational mPreviewAspectRatio = null;
    CallbackToFutureAdapter.Completer<FocusMeteringResult> mRunningActionCompleter;
    CallbackToFutureAdapter.Completer<Void> mRunningCancelCompleter;
    private final ScheduledExecutorService mScheduler;
    private Camera2CameraControlImpl.CaptureResultListener mSessionListenerForCancel = null;
    private Camera2CameraControlImpl.CaptureResultListener mSessionListenerForFocus = null;
    private int mTemplate = 1;

    FocusMeteringControl(Camera2CameraControlImpl camera2CameraControlImpl, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        MeteringRectangle[] meteringRectangleArr = EMPTY_RECTANGLES;
        this.mAfRects = meteringRectangleArr;
        this.mAeRects = meteringRectangleArr;
        this.mAwbRects = meteringRectangleArr;
        this.mRunningActionCompleter = null;
        this.mRunningCancelCompleter = null;
        this.mCameraControl = camera2CameraControlImpl;
        this.mExecutor = executor;
        this.mScheduler = scheduledExecutorService;
    }

    /* access modifiers changed from: package-private */
    public void setActive(boolean z) {
        if (z != this.mIsActive) {
            this.mIsActive = z;
            if (!this.mIsActive) {
                cancelFocusAndMeteringWithoutAsyncResult();
            }
        }
    }

    public void setPreviewAspectRatio(Rational rational) {
        this.mPreviewAspectRatio = rational;
    }

    private Rational getDefaultAspectRatio() {
        if (this.mPreviewAspectRatio != null) {
            return this.mPreviewAspectRatio;
        }
        Rect cropSensorRegion = this.mCameraControl.getCropSensorRegion();
        return new Rational(cropSensorRegion.width(), cropSensorRegion.height());
    }

    /* access modifiers changed from: package-private */
    public void setTemplate(int i) {
        this.mTemplate = i;
    }

    /* access modifiers changed from: package-private */
    public void addFocusMeteringOptions(Camera2ImplConfig.Builder builder) {
        int i;
        if (this.mIsInAfAutoMode) {
            i = 1;
        } else {
            i = getDefaultAfMode();
        }
        builder.setCaptureRequestOption(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(this.mCameraControl.getSupportedAfMode(i)));
        if (this.mAfRects.length != 0) {
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_AF_REGIONS, this.mAfRects);
        }
        if (this.mAeRects.length != 0) {
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_AE_REGIONS, this.mAeRects);
        }
        if (this.mAwbRects.length != 0) {
            builder.setCaptureRequestOption(CaptureRequest.CONTROL_AWB_REGIONS, this.mAwbRects);
        }
    }

    private static boolean isValid(MeteringPoint meteringPoint) {
        return meteringPoint.getX() >= 0.0f && meteringPoint.getX() <= 1.0f && meteringPoint.getY() >= 0.0f && meteringPoint.getY() <= 1.0f;
    }

    private static PointF getFovAdjustedPoint(MeteringPoint meteringPoint, Rational rational, Rational rational2) {
        if (meteringPoint.getSurfaceAspectRatio() != null) {
            rational2 = meteringPoint.getSurfaceAspectRatio();
        }
        PointF pointF = new PointF(meteringPoint.getX(), meteringPoint.getY());
        if (!rational2.equals(rational)) {
            if (rational2.compareTo(rational) > 0) {
                float doubleValue = (float) (rational2.doubleValue() / rational.doubleValue());
                pointF.y = (((float) ((((double) doubleValue) - 1.0d) / 2.0d)) + pointF.y) * (1.0f / doubleValue);
            } else {
                float doubleValue2 = (float) (rational.doubleValue() / rational2.doubleValue());
                pointF.x = (((float) ((((double) doubleValue2) - 1.0d) / 2.0d)) + pointF.x) * (1.0f / doubleValue2);
            }
        }
        return pointF;
    }

    private static MeteringRectangle getMeteringRect(MeteringPoint meteringPoint, PointF pointF, Rect rect) {
        int width = (int) (((float) rect.left) + (pointF.x * ((float) rect.width())));
        int height = (int) (((float) rect.top) + (pointF.y * ((float) rect.height())));
        int size = ((int) (meteringPoint.getSize() * ((float) rect.width()))) / 2;
        int size2 = ((int) (meteringPoint.getSize() * ((float) rect.height()))) / 2;
        Rect rect2 = new Rect(width - size, height - size2, width + size, height + size2);
        rect2.left = rangeLimit(rect2.left, rect.right, rect.left);
        rect2.right = rangeLimit(rect2.right, rect.right, rect.left);
        rect2.top = rangeLimit(rect2.top, rect.bottom, rect.top);
        rect2.bottom = rangeLimit(rect2.bottom, rect.bottom, rect.top);
        return new MeteringRectangle(rect2, 1000);
    }

    private static int rangeLimit(int i, int i2, int i3) {
        return Math.min(Math.max(i, i3), i2);
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<FocusMeteringResult> startFocusAndMetering(FocusMeteringAction focusMeteringAction) {
        return CallbackToFutureAdapter.getFuture(new FocusMeteringControl$$ExternalSyntheticLambda3(this, focusMeteringAction));
    }

    public /* synthetic */ Object lambda$startFocusAndMetering$1$FocusMeteringControl(FocusMeteringAction focusMeteringAction, CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new FocusMeteringControl$$ExternalSyntheticLambda7(this, completer, focusMeteringAction));
        return "startFocusAndMetering";
    }

    private static List<MeteringRectangle> getMeteringRectangles(List<MeteringPoint> list, int i, Rational rational, Rect rect) {
        if (list.isEmpty() || i == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Rational rational2 = new Rational(rect.width(), rect.height());
        for (MeteringPoint next : list) {
            if (arrayList.size() == i) {
                break;
            } else if (isValid(next)) {
                MeteringRectangle meteringRect = getMeteringRect(next, getFovAdjustedPoint(next, rational2, rational), rect);
                if (!(meteringRect.getWidth() == 0 || meteringRect.getHeight() == 0)) {
                    arrayList.add(meteringRect);
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: startFocusAndMeteringInternal */
    public void lambda$startFocusAndMetering$0$FocusMeteringControl(CallbackToFutureAdapter.Completer<FocusMeteringResult> completer, FocusMeteringAction focusMeteringAction) {
        if (!this.mIsActive) {
            completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
            return;
        }
        Rect cropSensorRegion = this.mCameraControl.getCropSensorRegion();
        Rational defaultAspectRatio = getDefaultAspectRatio();
        List<MeteringRectangle> meteringRectangles = getMeteringRectangles(focusMeteringAction.getMeteringPointsAf(), this.mCameraControl.getMaxAfRegionCount(), defaultAspectRatio, cropSensorRegion);
        List<MeteringRectangle> meteringRectangles2 = getMeteringRectangles(focusMeteringAction.getMeteringPointsAe(), this.mCameraControl.getMaxAeRegionCount(), defaultAspectRatio, cropSensorRegion);
        List<MeteringRectangle> meteringRectangles3 = getMeteringRectangles(focusMeteringAction.getMeteringPointsAwb(), this.mCameraControl.getMaxAwbRegionCount(), defaultAspectRatio, cropSensorRegion);
        if (!meteringRectangles.isEmpty() || !meteringRectangles2.isEmpty() || !meteringRectangles3.isEmpty()) {
            failActionFuture("Cancelled by another startFocusAndMetering()");
            failCancelFuture("Cancelled by another startFocusAndMetering()");
            disableAutoCancel();
            this.mRunningActionCompleter = completer;
            MeteringRectangle[] meteringRectangleArr = EMPTY_RECTANGLES;
            executeMeteringAction((MeteringRectangle[]) meteringRectangles.toArray(meteringRectangleArr), (MeteringRectangle[]) meteringRectangles2.toArray(meteringRectangleArr), (MeteringRectangle[]) meteringRectangles3.toArray(meteringRectangleArr), focusMeteringAction);
            return;
        }
        completer.setException(new IllegalArgumentException("None of the specified AF/AE/AWB MeteringPoints is supported on this camera."));
    }

    /* access modifiers changed from: package-private */
    public void triggerAf(final CallbackToFutureAdapter.Completer<CameraCaptureResult> completer) {
        if (this.mIsActive) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setTemplateType(this.mTemplate);
            builder.setUseRepeatingSurface(true);
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AF_TRIGGER, 1);
            builder.addImplementationOptions(builder2.build());
            builder.addCameraCaptureCallback(new CameraCaptureCallback() {
                public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
                    CallbackToFutureAdapter.Completer completer = completer;
                    if (completer != null) {
                        completer.set(cameraCaptureResult);
                    }
                }

                public void onCaptureFailed(CameraCaptureFailure cameraCaptureFailure) {
                    CallbackToFutureAdapter.Completer completer = completer;
                    if (completer != null) {
                        completer.setException(new CameraControlInternal.CameraControlException(cameraCaptureFailure));
                    }
                }

                public void onCaptureCancelled() {
                    CallbackToFutureAdapter.Completer completer = completer;
                    if (completer != null) {
                        completer.setException(new CameraControl.OperationCanceledException("Camera is closed"));
                    }
                }
            });
            this.mCameraControl.lambda$submitCaptureRequests$8$Camera2CameraControlImpl(Collections.singletonList(builder.build()));
        } else if (completer != null) {
            completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
        }
    }

    /* access modifiers changed from: package-private */
    public void triggerAePrecapture(final CallbackToFutureAdapter.Completer<CameraCaptureResult> completer) {
        if (this.mIsActive) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setTemplateType(this.mTemplate);
            builder.setUseRepeatingSurface(true);
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
            builder.addImplementationOptions(builder2.build());
            builder.addCameraCaptureCallback(new CameraCaptureCallback() {
                public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
                    CallbackToFutureAdapter.Completer completer = completer;
                    if (completer != null) {
                        completer.set(cameraCaptureResult);
                    }
                }

                public void onCaptureFailed(CameraCaptureFailure cameraCaptureFailure) {
                    CallbackToFutureAdapter.Completer completer = completer;
                    if (completer != null) {
                        completer.setException(new CameraControlInternal.CameraControlException(cameraCaptureFailure));
                    }
                }

                public void onCaptureCancelled() {
                    CallbackToFutureAdapter.Completer completer = completer;
                    if (completer != null) {
                        completer.setException(new CameraControl.OperationCanceledException("Camera is closed"));
                    }
                }
            });
            this.mCameraControl.lambda$submitCaptureRequests$8$Camera2CameraControlImpl(Collections.singletonList(builder.build()));
        } else if (completer != null) {
            completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
        }
    }

    /* access modifiers changed from: package-private */
    public void cancelAfAeTrigger(boolean z, boolean z2) {
        if (this.mIsActive) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setUseRepeatingSurface(true);
            builder.setTemplateType(this.mTemplate);
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            if (z) {
                builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AF_TRIGGER, 2);
            }
            if (Build.VERSION.SDK_INT >= 23 && z2) {
                builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 2);
            }
            builder.addImplementationOptions(builder2.build());
            this.mCameraControl.lambda$submitCaptureRequests$8$Camera2CameraControlImpl(Collections.singletonList(builder.build()));
        }
    }

    private void disableAutoCancel() {
        ScheduledFuture<?> scheduledFuture = this.mAutoCancelHandle;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.mAutoCancelHandle = null;
        }
    }

    /* access modifiers changed from: package-private */
    public int getDefaultAfMode() {
        return this.mTemplate != 3 ? 4 : 3;
    }

    private boolean isAfModeSupported() {
        return this.mCameraControl.getSupportedAfMode(1) == 1;
    }

    private void completeActionFuture(boolean z) {
        CallbackToFutureAdapter.Completer<FocusMeteringResult> completer = this.mRunningActionCompleter;
        if (completer != null) {
            completer.set(FocusMeteringResult.create(z));
            this.mRunningActionCompleter = null;
        }
    }

    private void failActionFuture(String str) {
        this.mCameraControl.removeCaptureResultListener(this.mSessionListenerForFocus);
        CallbackToFutureAdapter.Completer<FocusMeteringResult> completer = this.mRunningActionCompleter;
        if (completer != null) {
            completer.setException(new CameraControl.OperationCanceledException(str));
            this.mRunningActionCompleter = null;
        }
    }

    private void failCancelFuture(String str) {
        this.mCameraControl.removeCaptureResultListener(this.mSessionListenerForCancel);
        CallbackToFutureAdapter.Completer<Void> completer = this.mRunningCancelCompleter;
        if (completer != null) {
            completer.setException(new CameraControl.OperationCanceledException(str));
            this.mRunningCancelCompleter = null;
        }
    }

    private void completeCancelFuture() {
        CallbackToFutureAdapter.Completer<Void> completer = this.mRunningCancelCompleter;
        if (completer != null) {
            completer.set(null);
            this.mRunningCancelCompleter = null;
        }
    }

    private void executeMeteringAction(MeteringRectangle[] meteringRectangleArr, MeteringRectangle[] meteringRectangleArr2, MeteringRectangle[] meteringRectangleArr3, FocusMeteringAction focusMeteringAction) {
        long j;
        this.mCameraControl.removeCaptureResultListener(this.mSessionListenerForFocus);
        disableAutoCancel();
        this.mAfRects = meteringRectangleArr;
        this.mAeRects = meteringRectangleArr2;
        this.mAwbRects = meteringRectangleArr3;
        if (shouldTriggerAF()) {
            this.mIsInAfAutoMode = true;
            this.mIsAutoFocusCompleted = false;
            this.mIsFocusSuccessful = false;
            j = this.mCameraControl.updateSessionConfigSynchronous();
            triggerAf((CallbackToFutureAdapter.Completer<CameraCaptureResult>) null);
        } else {
            this.mIsInAfAutoMode = false;
            this.mIsAutoFocusCompleted = true;
            this.mIsFocusSuccessful = false;
            j = this.mCameraControl.updateSessionConfigSynchronous();
        }
        this.mCurrentAfState = 0;
        FocusMeteringControl$$ExternalSyntheticLambda1 focusMeteringControl$$ExternalSyntheticLambda1 = new FocusMeteringControl$$ExternalSyntheticLambda1(this, isAfModeSupported(), j);
        this.mSessionListenerForFocus = focusMeteringControl$$ExternalSyntheticLambda1;
        this.mCameraControl.addCaptureResultListener(focusMeteringControl$$ExternalSyntheticLambda1);
        if (focusMeteringAction.isAutoCancelEnabled()) {
            long j2 = this.mFocusTimeoutCounter + 1;
            this.mFocusTimeoutCounter = j2;
            this.mAutoCancelHandle = this.mScheduler.schedule(new FocusMeteringControl$$ExternalSyntheticLambda5(this, j2), focusMeteringAction.getAutoCancelDurationInMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public /* synthetic */ boolean lambda$executeMeteringAction$2$FocusMeteringControl(boolean z, long j, TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        if (shouldTriggerAF()) {
            if (!z || num == null) {
                this.mIsFocusSuccessful = true;
                this.mIsAutoFocusCompleted = true;
            } else if (this.mCurrentAfState.intValue() == 3) {
                if (num.intValue() == 4) {
                    this.mIsFocusSuccessful = true;
                    this.mIsAutoFocusCompleted = true;
                } else if (num.intValue() == 5) {
                    this.mIsFocusSuccessful = false;
                    this.mIsAutoFocusCompleted = true;
                }
            }
        }
        if (!this.mIsAutoFocusCompleted || !isSessionUpdated(totalCaptureResult, j)) {
            if (!this.mCurrentAfState.equals(num) && num != null) {
                this.mCurrentAfState = num;
            }
            return false;
        }
        completeActionFuture(this.mIsFocusSuccessful);
        return true;
    }

    public /* synthetic */ void lambda$executeMeteringAction$4$FocusMeteringControl(long j) {
        this.mExecutor.execute(new FocusMeteringControl$$ExternalSyntheticLambda4(this, j));
    }

    public /* synthetic */ void lambda$executeMeteringAction$3$FocusMeteringControl(long j) {
        if (j == this.mFocusTimeoutCounter) {
            cancelFocusAndMeteringWithoutAsyncResult();
        }
    }

    private boolean shouldTriggerAF() {
        return this.mAfRects.length > 0;
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<Void> cancelFocusAndMetering() {
        return CallbackToFutureAdapter.getFuture(new FocusMeteringControl$$ExternalSyntheticLambda2(this));
    }

    public /* synthetic */ Object lambda$cancelFocusAndMetering$6$FocusMeteringControl(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new FocusMeteringControl$$ExternalSyntheticLambda6(this, completer));
        return "cancelFocusAndMetering";
    }

    /* access modifiers changed from: package-private */
    public void cancelFocusAndMeteringWithoutAsyncResult() {
        lambda$cancelFocusAndMetering$5$FocusMeteringControl((CallbackToFutureAdapter.Completer<Void>) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: cancelFocusAndMeteringInternal */
    public void lambda$cancelFocusAndMetering$5$FocusMeteringControl(CallbackToFutureAdapter.Completer<Void> completer) {
        failCancelFuture("Cancelled by another cancelFocusAndMetering()");
        failActionFuture("Cancelled by cancelFocusAndMetering()");
        this.mRunningCancelCompleter = completer;
        disableAutoCancel();
        if (shouldTriggerAF()) {
            cancelAfAeTrigger(true, false);
        }
        MeteringRectangle[] meteringRectangleArr = EMPTY_RECTANGLES;
        this.mAfRects = meteringRectangleArr;
        this.mAeRects = meteringRectangleArr;
        this.mAwbRects = meteringRectangleArr;
        this.mIsInAfAutoMode = false;
        long updateSessionConfigSynchronous = this.mCameraControl.updateSessionConfigSynchronous();
        if (this.mRunningCancelCompleter != null) {
            FocusMeteringControl$$ExternalSyntheticLambda0 focusMeteringControl$$ExternalSyntheticLambda0 = new FocusMeteringControl$$ExternalSyntheticLambda0(this, this.mCameraControl.getSupportedAfMode(getDefaultAfMode()), updateSessionConfigSynchronous);
            this.mSessionListenerForCancel = focusMeteringControl$$ExternalSyntheticLambda0;
            this.mCameraControl.addCaptureResultListener(focusMeteringControl$$ExternalSyntheticLambda0);
        }
    }

    public /* synthetic */ boolean lambda$cancelFocusAndMeteringInternal$7$FocusMeteringControl(int i, long j, TotalCaptureResult totalCaptureResult) {
        if (((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE)).intValue() != i || !isSessionUpdated(totalCaptureResult, j)) {
            return false;
        }
        completeCancelFuture();
        return true;
    }

    private static boolean isSessionUpdated(TotalCaptureResult totalCaptureResult, long j) {
        Long l;
        if (totalCaptureResult.getRequest() == null) {
            return false;
        }
        Object tag = totalCaptureResult.getRequest().getTag();
        if (!(tag instanceof TagBundle) || (l = (Long) ((TagBundle) tag).getTag("CameraControlSessionUpdateId")) == null || l.longValue() < j) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isFocusMeteringSupported(FocusMeteringAction focusMeteringAction) {
        Rect cropSensorRegion = this.mCameraControl.getCropSensorRegion();
        Rational defaultAspectRatio = getDefaultAspectRatio();
        return !getMeteringRectangles(focusMeteringAction.getMeteringPointsAf(), this.mCameraControl.getMaxAfRegionCount(), defaultAspectRatio, cropSensorRegion).isEmpty() || !getMeteringRectangles(focusMeteringAction.getMeteringPointsAe(), this.mCameraControl.getMaxAeRegionCount(), defaultAspectRatio, cropSensorRegion).isEmpty() || !getMeteringRectangles(focusMeteringAction.getMeteringPointsAwb(), this.mCameraControl.getMaxAwbRegionCount(), defaultAspectRatio, cropSensorRegion).isEmpty();
    }
}
