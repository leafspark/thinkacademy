package androidx.camera.view;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.view.Display;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.ViewPort;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.video.OnVideoSavedCallback;
import androidx.camera.view.video.OutputFileOptions;
import androidx.camera.view.video.OutputFileResults;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class CameraController {
    private static final float AE_SIZE = 0.25f;
    private static final float AF_SIZE = 0.16666667f;
    private static final String CAMERA_NOT_ATTACHED = "Use cases not attached to camera.";
    private static final String CAMERA_NOT_INITIALIZED = "Camera not initialized.";
    public static final int IMAGE_ANALYSIS = 2;
    public static final int IMAGE_CAPTURE = 1;
    private static final String IMAGE_CAPTURE_DISABLED = "ImageCapture disabled.";
    private static final String PREVIEW_VIEW_NOT_ATTACHED = "PreviewView not attached.";
    private static final String TAG = "CameraController";
    public static final int TAP_TO_FOCUS_FAILED = 4;
    public static final int TAP_TO_FOCUS_NOT_STARTED = 0;
    public static final int TAP_TO_FOCUS_STARTED = 1;
    public static final int TAP_TO_FOCUS_SUCCESSFUL = 2;
    public static final int TAP_TO_FOCUS_UNSUCCESSFUL = 3;
    public static final int VIDEO_CAPTURE = 4;
    private static final String VIDEO_CAPTURE_DISABLED = "VideoCapture disabled.";
    private ImageAnalysis.Analyzer mAnalysisAnalyzer;
    private Executor mAnalysisBackgroundExecutor;
    private Executor mAnalysisExecutor;
    private final Context mAppContext;
    Camera mCamera;
    ProcessCameraProvider mCameraProvider;
    CameraSelector mCameraSelector = CameraSelector.DEFAULT_BACK_CAMERA;
    private final DisplayRotationListener mDisplayRotationListener;
    private int mEnabledUseCases = 3;
    ImageAnalysis mImageAnalysis;
    OutputSize mImageAnalysisTargetSize;
    ImageCapture mImageCapture;
    Executor mImageCaptureIoExecutor;
    OutputSize mImageCaptureTargetSize;
    private final ListenableFuture<Void> mInitializationFuture;
    private boolean mPinchToZoomEnabled = true;
    Preview mPreview;
    Display mPreviewDisplay;
    OutputSize mPreviewTargetSize;
    final RotationReceiver mRotationReceiver;
    Preview.SurfaceProvider mSurfaceProvider;
    private boolean mTapToFocusEnabled = true;
    final MutableLiveData<Integer> mTapToFocusState = new MutableLiveData<>(0);
    private final ForwardingLiveData<Integer> mTorchState = new ForwardingLiveData<>();
    VideoCapture mVideoCapture;
    OutputSize mVideoCaptureOutputSize;
    final AtomicBoolean mVideoIsRecording = new AtomicBoolean(false);
    ViewPort mViewPort;
    private final ForwardingLiveData<ZoomState> mZoomState = new ForwardingLiveData<>();

    @Retention(RetentionPolicy.SOURCE)
    public @interface TapToFocusStates {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface UseCases {
    }

    private float speedUpZoomBy2X(float f) {
        return f > 1.0f ? ((f - 1.0f) * 2.0f) + 1.0f : 1.0f - ((1.0f - f) * 2.0f);
    }

    /* access modifiers changed from: package-private */
    public abstract Camera startCamera();

    CameraController(Context context) {
        Context applicationContext = getApplicationContext(context);
        this.mAppContext = applicationContext;
        this.mPreview = new Preview.Builder().build();
        this.mImageCapture = new ImageCapture.Builder().build();
        this.mImageAnalysis = new ImageAnalysis.Builder().build();
        this.mVideoCapture = new VideoCapture.Builder().build();
        this.mInitializationFuture = Futures.transform(ProcessCameraProvider.getInstance(applicationContext), new CameraController$$ExternalSyntheticLambda0(this), CameraXExecutors.mainThreadExecutor());
        this.mDisplayRotationListener = new DisplayRotationListener();
        this.mRotationReceiver = new RotationReceiver(applicationContext) {
            public void onRotationChanged(int i) {
                CameraController.this.mImageAnalysis.setTargetRotation(i);
                CameraController.this.mImageCapture.setTargetRotation(i);
                CameraController.this.mVideoCapture.setTargetRotation(i);
            }
        };
    }

    public /* synthetic */ Void lambda$new$0$CameraController(ProcessCameraProvider processCameraProvider) {
        this.mCameraProvider = processCameraProvider;
        startCameraAndTrackStates();
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r3 = androidx.camera.view.CameraController.Api30Impl.getAttributionTag(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.Context getApplicationContext(android.content.Context r3) {
        /*
            android.content.Context r0 = r3.getApplicationContext()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 30
            if (r1 < r2) goto L_0x0015
            java.lang.String r3 = androidx.camera.view.CameraController.Api30Impl.getAttributionTag(r3)
            if (r3 == 0) goto L_0x0015
            android.content.Context r3 = androidx.camera.view.CameraController.Api30Impl.createAttributionContext(r0, r3)
            return r3
        L_0x0015:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.view.CameraController.getApplicationContext(android.content.Context):android.content.Context");
    }

    public ListenableFuture<Void> getInitializationFuture() {
        return this.mInitializationFuture;
    }

    private boolean isCameraInitialized() {
        return this.mCameraProvider != null;
    }

    private boolean isPreviewViewAttached() {
        return (this.mSurfaceProvider == null || this.mViewPort == null || this.mPreviewDisplay == null) ? false : true;
    }

    private boolean isCameraAttached() {
        return this.mCamera != null;
    }

    public void setEnabledUseCases(int i) {
        Threads.checkMainThread();
        int i2 = this.mEnabledUseCases;
        if (i != i2) {
            this.mEnabledUseCases = i;
            if (!isVideoCaptureEnabled()) {
                stopRecording();
            }
            startCameraAndTrackStates(new CameraController$$ExternalSyntheticLambda1(this, i2));
        }
    }

    public /* synthetic */ void lambda$setEnabledUseCases$1$CameraController(int i) {
        this.mEnabledUseCases = i;
    }

    private boolean isUseCaseEnabled(int i) {
        return (i & this.mEnabledUseCases) != 0;
    }

    private void setTargetOutputSize(ImageOutputConfig.Builder<?> builder, OutputSize outputSize) {
        if (outputSize != null) {
            if (outputSize.getResolution() != null) {
                builder.setTargetResolution(outputSize.getResolution());
            } else if (outputSize.getAspectRatio() != -1) {
                builder.setTargetAspectRatio(outputSize.getAspectRatio());
            } else {
                Logger.e(TAG, "Invalid target surface size. " + outputSize);
            }
        }
    }

    private boolean isOutputSizeEqual(OutputSize outputSize, OutputSize outputSize2) {
        if (outputSize == outputSize2) {
            return true;
        }
        return outputSize != null && outputSize.equals(outputSize2);
    }

    /* access modifiers changed from: package-private */
    public void attachPreviewSurface(Preview.SurfaceProvider surfaceProvider, ViewPort viewPort, Display display) {
        Threads.checkMainThread();
        if (this.mSurfaceProvider != surfaceProvider) {
            this.mSurfaceProvider = surfaceProvider;
            this.mPreview.setSurfaceProvider(surfaceProvider);
        }
        this.mViewPort = viewPort;
        this.mPreviewDisplay = display;
        startListeningToRotationEvents();
        startCameraAndTrackStates();
    }

    /* access modifiers changed from: package-private */
    public void clearPreviewSurface() {
        Threads.checkMainThread();
        ProcessCameraProvider processCameraProvider = this.mCameraProvider;
        if (processCameraProvider != null) {
            processCameraProvider.unbindAll();
        }
        this.mPreview.setSurfaceProvider((Preview.SurfaceProvider) null);
        this.mCamera = null;
        this.mSurfaceProvider = null;
        this.mViewPort = null;
        this.mPreviewDisplay = null;
        stopListeningToRotationEvents();
    }

    private void startListeningToRotationEvents() {
        getDisplayManager().registerDisplayListener(this.mDisplayRotationListener, new Handler(Looper.getMainLooper()));
        if (this.mRotationReceiver.canDetectOrientation()) {
            this.mRotationReceiver.enable();
        }
    }

    private void stopListeningToRotationEvents() {
        getDisplayManager().unregisterDisplayListener(this.mDisplayRotationListener);
        this.mRotationReceiver.disable();
    }

    private DisplayManager getDisplayManager() {
        return (DisplayManager) this.mAppContext.getSystemService("display");
    }

    public void setPreviewTargetSize(OutputSize outputSize) {
        Threads.checkMainThread();
        if (!isOutputSizeEqual(this.mPreviewTargetSize, outputSize)) {
            this.mPreviewTargetSize = outputSize;
            unbindPreviewAndRecreate();
            startCameraAndTrackStates();
        }
    }

    public OutputSize getPreviewTargetSize() {
        Threads.checkMainThread();
        return this.mPreviewTargetSize;
    }

    private void unbindPreviewAndRecreate() {
        if (isCameraInitialized()) {
            this.mCameraProvider.unbind(this.mPreview);
        }
        Preview.Builder builder = new Preview.Builder();
        setTargetOutputSize(builder, this.mPreviewTargetSize);
        this.mPreview = builder.build();
    }

    public boolean isImageCaptureEnabled() {
        Threads.checkMainThread();
        return isUseCaseEnabled(1);
    }

    public int getImageCaptureFlashMode() {
        Threads.checkMainThread();
        return this.mImageCapture.getFlashMode();
    }

    public void setImageCaptureFlashMode(int i) {
        Threads.checkMainThread();
        this.mImageCapture.setFlashMode(i);
    }

    public void takePicture(ImageCapture.OutputFileOptions outputFileOptions, Executor executor, ImageCapture.OnImageSavedCallback onImageSavedCallback) {
        Threads.checkMainThread();
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        Preconditions.checkState(isImageCaptureEnabled(), IMAGE_CAPTURE_DISABLED);
        updateMirroringFlagInOutputFileOptions(outputFileOptions);
        this.mImageCapture.lambda$takePicture$5$ImageCapture(outputFileOptions, executor, onImageSavedCallback);
    }

    /* access modifiers changed from: package-private */
    public void updateMirroringFlagInOutputFileOptions(ImageCapture.OutputFileOptions outputFileOptions) {
        if (this.mCameraSelector.getLensFacing() != null && !outputFileOptions.getMetadata().isReversedHorizontalSet()) {
            outputFileOptions.getMetadata().setReversedHorizontal(this.mCameraSelector.getLensFacing().intValue() == 0);
        }
    }

    public void takePicture(Executor executor, ImageCapture.OnImageCapturedCallback onImageCapturedCallback) {
        Threads.checkMainThread();
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        Preconditions.checkState(isImageCaptureEnabled(), IMAGE_CAPTURE_DISABLED);
        this.mImageCapture.lambda$takePicture$4$ImageCapture(executor, onImageCapturedCallback);
    }

    public void setImageCaptureMode(int i) {
        Threads.checkMainThread();
        if (this.mImageCapture.getCaptureMode() != i) {
            unbindImageCaptureAndRecreate(i);
            startCameraAndTrackStates();
        }
    }

    public int getImageCaptureMode() {
        Threads.checkMainThread();
        return this.mImageCapture.getCaptureMode();
    }

    public void setImageCaptureTargetSize(OutputSize outputSize) {
        Threads.checkMainThread();
        if (!isOutputSizeEqual(this.mImageCaptureTargetSize, outputSize)) {
            this.mImageCaptureTargetSize = outputSize;
            unbindImageCaptureAndRecreate(getImageCaptureMode());
            startCameraAndTrackStates();
        }
    }

    public OutputSize getImageCaptureTargetSize() {
        Threads.checkMainThread();
        return this.mImageCaptureTargetSize;
    }

    public void setImageCaptureIoExecutor(Executor executor) {
        Threads.checkMainThread();
        if (this.mImageCaptureIoExecutor != executor) {
            this.mImageCaptureIoExecutor = executor;
            unbindImageCaptureAndRecreate(this.mImageCapture.getCaptureMode());
            startCameraAndTrackStates();
        }
    }

    public Executor getImageCaptureIoExecutor() {
        Threads.checkMainThread();
        return this.mImageCaptureIoExecutor;
    }

    private void unbindImageCaptureAndRecreate(int i) {
        if (isCameraInitialized()) {
            this.mCameraProvider.unbind(this.mImageCapture);
        }
        ImageCapture.Builder captureMode = new ImageCapture.Builder().setCaptureMode(i);
        setTargetOutputSize(captureMode, this.mImageCaptureTargetSize);
        Executor executor = this.mImageCaptureIoExecutor;
        if (executor != null) {
            captureMode.setIoExecutor(executor);
        }
        this.mImageCapture = captureMode.build();
    }

    public boolean isImageAnalysisEnabled() {
        Threads.checkMainThread();
        return isUseCaseEnabled(2);
    }

    public void setImageAnalysisAnalyzer(Executor executor, ImageAnalysis.Analyzer analyzer) {
        Threads.checkMainThread();
        if (this.mAnalysisAnalyzer != analyzer || this.mAnalysisExecutor != executor) {
            this.mAnalysisExecutor = executor;
            this.mAnalysisAnalyzer = analyzer;
            this.mImageAnalysis.setAnalyzer(executor, analyzer);
        }
    }

    public void clearImageAnalysisAnalyzer() {
        Threads.checkMainThread();
        this.mAnalysisExecutor = null;
        this.mAnalysisAnalyzer = null;
        this.mImageAnalysis.clearAnalyzer();
    }

    public int getImageAnalysisBackpressureStrategy() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getBackpressureStrategy();
    }

    public void setImageAnalysisBackpressureStrategy(int i) {
        Threads.checkMainThread();
        if (this.mImageAnalysis.getBackpressureStrategy() != i) {
            unbindImageAnalysisAndRecreate(i, this.mImageAnalysis.getImageQueueDepth());
            startCameraAndTrackStates();
        }
    }

    public void setImageAnalysisImageQueueDepth(int i) {
        Threads.checkMainThread();
        if (this.mImageAnalysis.getImageQueueDepth() != i) {
            unbindImageAnalysisAndRecreate(this.mImageAnalysis.getBackpressureStrategy(), i);
            startCameraAndTrackStates();
        }
    }

    public int getImageAnalysisImageQueueDepth() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getImageQueueDepth();
    }

    public void setImageAnalysisTargetSize(OutputSize outputSize) {
        Threads.checkMainThread();
        if (!isOutputSizeEqual(this.mImageAnalysisTargetSize, outputSize)) {
            this.mImageAnalysisTargetSize = outputSize;
            unbindImageAnalysisAndRecreate(this.mImageAnalysis.getBackpressureStrategy(), this.mImageAnalysis.getImageQueueDepth());
            startCameraAndTrackStates();
        }
    }

    public OutputSize getImageAnalysisTargetSize() {
        Threads.checkMainThread();
        return this.mImageAnalysisTargetSize;
    }

    public void setImageAnalysisBackgroundExecutor(Executor executor) {
        Threads.checkMainThread();
        if (this.mAnalysisBackgroundExecutor != executor) {
            this.mAnalysisBackgroundExecutor = executor;
            unbindImageAnalysisAndRecreate(this.mImageAnalysis.getBackpressureStrategy(), this.mImageAnalysis.getImageQueueDepth());
            startCameraAndTrackStates();
        }
    }

    public Executor getImageAnalysisBackgroundExecutor() {
        Threads.checkMainThread();
        return this.mAnalysisBackgroundExecutor;
    }

    private void unbindImageAnalysisAndRecreate(int i, int i2) {
        ImageAnalysis.Analyzer analyzer;
        if (isCameraInitialized()) {
            this.mCameraProvider.unbind(this.mImageAnalysis);
        }
        ImageAnalysis.Builder imageQueueDepth = new ImageAnalysis.Builder().setBackpressureStrategy(i).setImageQueueDepth(i2);
        setTargetOutputSize(imageQueueDepth, this.mImageAnalysisTargetSize);
        Executor executor = this.mAnalysisBackgroundExecutor;
        if (executor != null) {
            imageQueueDepth.setBackgroundExecutor(executor);
        }
        ImageAnalysis build = imageQueueDepth.build();
        this.mImageAnalysis = build;
        Executor executor2 = this.mAnalysisExecutor;
        if (executor2 != null && (analyzer = this.mAnalysisAnalyzer) != null) {
            build.setAnalyzer(executor2, analyzer);
        }
    }

    public boolean isVideoCaptureEnabled() {
        Threads.checkMainThread();
        return isUseCaseEnabled(4);
    }

    public void startRecording(OutputFileOptions outputFileOptions, Executor executor, final OnVideoSavedCallback onVideoSavedCallback) {
        Threads.checkMainThread();
        Preconditions.checkState(isCameraInitialized(), CAMERA_NOT_INITIALIZED);
        Preconditions.checkState(isVideoCaptureEnabled(), VIDEO_CAPTURE_DISABLED);
        this.mVideoCapture.lambda$startRecording$0$VideoCapture(outputFileOptions.toVideoCaptureOutputFileOptions(), executor, new VideoCapture.OnVideoSavedCallback() {
            public void onVideoSaved(VideoCapture.OutputFileResults outputFileResults) {
                CameraController.this.mVideoIsRecording.set(false);
                onVideoSavedCallback.onVideoSaved(OutputFileResults.create(outputFileResults.getSavedUri()));
            }

            public void onError(int i, String str, Throwable th) {
                CameraController.this.mVideoIsRecording.set(false);
                onVideoSavedCallback.onError(i, str, th);
            }
        });
        this.mVideoIsRecording.set(true);
    }

    public void stopRecording() {
        Threads.checkMainThread();
        if (this.mVideoIsRecording.get()) {
            this.mVideoCapture.lambda$stopRecording$5$VideoCapture();
        }
    }

    public boolean isRecording() {
        Threads.checkMainThread();
        return this.mVideoIsRecording.get();
    }

    public void setVideoCaptureTargetSize(OutputSize outputSize) {
        Threads.checkMainThread();
        if (!isOutputSizeEqual(this.mVideoCaptureOutputSize, outputSize)) {
            this.mVideoCaptureOutputSize = outputSize;
            unbindVideoAndRecreate();
            startCameraAndTrackStates();
        }
    }

    public OutputSize getVideoCaptureTargetSize() {
        Threads.checkMainThread();
        return this.mVideoCaptureOutputSize;
    }

    private void unbindVideoAndRecreate() {
        if (isCameraInitialized()) {
            this.mCameraProvider.unbind(this.mVideoCapture);
        }
        VideoCapture.Builder builder = new VideoCapture.Builder();
        setTargetOutputSize(builder, this.mVideoCaptureOutputSize);
        this.mVideoCapture = builder.build();
    }

    public void setCameraSelector(CameraSelector cameraSelector) {
        Threads.checkMainThread();
        CameraSelector cameraSelector2 = this.mCameraSelector;
        if (cameraSelector2 != cameraSelector) {
            this.mCameraSelector = cameraSelector;
            ProcessCameraProvider processCameraProvider = this.mCameraProvider;
            if (processCameraProvider != null) {
                processCameraProvider.unbindAll();
                startCameraAndTrackStates(new CameraController$$ExternalSyntheticLambda2(this, cameraSelector2));
            }
        }
    }

    public /* synthetic */ void lambda$setCameraSelector$2$CameraController(CameraSelector cameraSelector) {
        this.mCameraSelector = cameraSelector;
    }

    public boolean hasCamera(CameraSelector cameraSelector) {
        Threads.checkMainThread();
        Preconditions.checkNotNull(cameraSelector);
        ProcessCameraProvider processCameraProvider = this.mCameraProvider;
        if (processCameraProvider != null) {
            try {
                return processCameraProvider.hasCamera(cameraSelector);
            } catch (CameraInfoUnavailableException e) {
                Logger.w(TAG, "Failed to check camera availability", e);
                return false;
            }
        } else {
            throw new IllegalStateException("Camera not initialized. Please wait for the initialization future to finish. See #getInitializationFuture().");
        }
    }

    public CameraSelector getCameraSelector() {
        Threads.checkMainThread();
        return this.mCameraSelector;
    }

    public boolean isPinchToZoomEnabled() {
        Threads.checkMainThread();
        return this.mPinchToZoomEnabled;
    }

    public void setPinchToZoomEnabled(boolean z) {
        Threads.checkMainThread();
        this.mPinchToZoomEnabled = z;
    }

    /* access modifiers changed from: package-private */
    public void onPinchToZoom(float f) {
        if (!isCameraAttached()) {
            Logger.w(TAG, CAMERA_NOT_ATTACHED);
        } else if (!this.mPinchToZoomEnabled) {
            Logger.d(TAG, "Pinch to zoom disabled.");
        } else {
            Logger.d(TAG, "Pinch to zoom with scale: " + f);
            ZoomState value = getZoomState().getValue();
            if (value != null) {
                setZoomRatio(Math.min(Math.max(value.getZoomRatio() * speedUpZoomBy2X(f), value.getMinZoomRatio()), value.getMaxZoomRatio()));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void onTapToFocus(MeteringPointFactory meteringPointFactory, float f, float f2) {
        if (!isCameraAttached()) {
            Logger.w(TAG, CAMERA_NOT_ATTACHED);
        } else if (!this.mTapToFocusEnabled) {
            Logger.d(TAG, "Tap to focus disabled. ");
        } else {
            Logger.d(TAG, "Tap to focus started: " + f + ", " + f2);
            this.mTapToFocusState.postValue(1);
            MeteringPoint createPoint = meteringPointFactory.createPoint(f, f2, AF_SIZE);
            Futures.addCallback(this.mCamera.getCameraControl().startFocusAndMetering(new FocusMeteringAction.Builder(createPoint, 1).addPoint(meteringPointFactory.createPoint(f, f2, AE_SIZE), 2).build()), new FutureCallback<FocusMeteringResult>() {
                public void onSuccess(FocusMeteringResult focusMeteringResult) {
                    if (focusMeteringResult != null) {
                        Logger.d(CameraController.TAG, "Tap to focus onSuccess: " + focusMeteringResult.isFocusSuccessful());
                        CameraController.this.mTapToFocusState.postValue(Integer.valueOf(focusMeteringResult.isFocusSuccessful() ? 2 : 3));
                    }
                }

                public void onFailure(Throwable th) {
                    if (th instanceof CameraControl.OperationCanceledException) {
                        Logger.d(CameraController.TAG, "Tap-to-focus is canceled by new action.");
                        return;
                    }
                    Logger.d(CameraController.TAG, "Tap to focus failed.", th);
                    CameraController.this.mTapToFocusState.postValue(4);
                }
            }, CameraXExecutors.directExecutor());
        }
    }

    public boolean isTapToFocusEnabled() {
        Threads.checkMainThread();
        return this.mTapToFocusEnabled;
    }

    public void setTapToFocusEnabled(boolean z) {
        Threads.checkMainThread();
        this.mTapToFocusEnabled = z;
    }

    public LiveData<Integer> getTapToFocusState() {
        Threads.checkMainThread();
        return this.mTapToFocusState;
    }

    public LiveData<ZoomState> getZoomState() {
        Threads.checkMainThread();
        return this.mZoomState;
    }

    public CameraInfo getCameraInfo() {
        Threads.checkMainThread();
        Camera camera = this.mCamera;
        if (camera == null) {
            return null;
        }
        return camera.getCameraInfo();
    }

    public CameraControl getCameraControl() {
        Threads.checkMainThread();
        Camera camera = this.mCamera;
        if (camera == null) {
            return null;
        }
        return camera.getCameraControl();
    }

    public ListenableFuture<Void> setZoomRatio(float f) {
        Threads.checkMainThread();
        if (isCameraAttached()) {
            return this.mCamera.getCameraControl().setZoomRatio(f);
        }
        Logger.w(TAG, CAMERA_NOT_ATTACHED);
        return Futures.immediateFuture(null);
    }

    public ListenableFuture<Void> setLinearZoom(float f) {
        Threads.checkMainThread();
        if (isCameraAttached()) {
            return this.mCamera.getCameraControl().setLinearZoom(f);
        }
        Logger.w(TAG, CAMERA_NOT_ATTACHED);
        return Futures.immediateFuture(null);
    }

    public LiveData<Integer> getTorchState() {
        Threads.checkMainThread();
        return this.mTorchState;
    }

    public ListenableFuture<Void> enableTorch(boolean z) {
        Threads.checkMainThread();
        if (isCameraAttached()) {
            return this.mCamera.getCameraControl().enableTorch(z);
        }
        Logger.w(TAG, CAMERA_NOT_ATTACHED);
        return Futures.immediateFuture(null);
    }

    /* access modifiers changed from: package-private */
    public void startCameraAndTrackStates() {
        startCameraAndTrackStates((Runnable) null);
    }

    /* access modifiers changed from: package-private */
    public void startCameraAndTrackStates(Runnable runnable) {
        try {
            this.mCamera = startCamera();
            if (!isCameraAttached()) {
                Logger.d(TAG, CAMERA_NOT_ATTACHED);
                return;
            }
            this.mZoomState.setSource(this.mCamera.getCameraInfo().getZoomState());
            this.mTorchState.setSource(this.mCamera.getCameraInfo().getTorchState());
        } catch (IllegalArgumentException e) {
            if (runnable != null) {
                runnable.run();
            }
            throw new IllegalStateException("The selected camera does not support the enabled use cases. Please disable use case and/or select a different camera. e.g. #setVideoCaptureEnabled(false)", e);
        }
    }

    /* access modifiers changed from: protected */
    public UseCaseGroup createUseCaseGroup() {
        if (!isCameraInitialized()) {
            Logger.d(TAG, CAMERA_NOT_INITIALIZED);
            return null;
        } else if (!isPreviewViewAttached()) {
            Logger.d(TAG, PREVIEW_VIEW_NOT_ATTACHED);
            return null;
        } else {
            UseCaseGroup.Builder addUseCase = new UseCaseGroup.Builder().addUseCase(this.mPreview);
            if (isImageCaptureEnabled()) {
                addUseCase.addUseCase(this.mImageCapture);
            } else {
                this.mCameraProvider.unbind(this.mImageCapture);
            }
            if (isImageAnalysisEnabled()) {
                addUseCase.addUseCase(this.mImageAnalysis);
            } else {
                this.mCameraProvider.unbind(this.mImageAnalysis);
            }
            if (isVideoCaptureEnabled()) {
                addUseCase.addUseCase(this.mVideoCapture);
            } else {
                this.mCameraProvider.unbind(this.mVideoCapture);
            }
            addUseCase.setViewPort(this.mViewPort);
            return addUseCase.build();
        }
    }

    class DisplayRotationListener implements DisplayManager.DisplayListener {
        public void onDisplayAdded(int i) {
        }

        public void onDisplayRemoved(int i) {
        }

        DisplayRotationListener() {
        }

        public void onDisplayChanged(int i) {
            if (CameraController.this.mPreviewDisplay != null && CameraController.this.mPreviewDisplay.getDisplayId() == i) {
                CameraController.this.mPreview.setTargetRotation(CameraController.this.mPreviewDisplay.getRotation());
            }
        }
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static Context createAttributionContext(Context context, String str) {
            return context.createAttributionContext(str);
        }

        static String getAttributionTag(Context context) {
            return context.getAttributionTag();
        }
    }

    public static class OutputSize {
        public static final int UNASSIGNED_ASPECT_RATIO = -1;
        private final int mAspectRatio;
        private final Size mResolution;

        @Retention(RetentionPolicy.SOURCE)
        public @interface OutputAspectRatio {
        }

        public OutputSize(int i) {
            Preconditions.checkArgument(i != -1);
            this.mAspectRatio = i;
            this.mResolution = null;
        }

        public OutputSize(Size size) {
            Preconditions.checkNotNull(size);
            this.mAspectRatio = -1;
            this.mResolution = size;
        }

        public int getAspectRatio() {
            return this.mAspectRatio;
        }

        public Size getResolution() {
            return this.mResolution;
        }
    }
}
