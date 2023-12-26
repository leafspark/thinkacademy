package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageSaver;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.IoConfig;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.YuvToJpegProcessor;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.ImageCaptureWashedOutImageQuirk;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.alibaba.fastjson.asm.Opcodes;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ImageCapture extends UseCase {
    public static final int CAPTURE_MODE_MAXIMIZE_QUALITY = 0;
    public static final int CAPTURE_MODE_MINIMIZE_LATENCY = 1;
    private static final long CHECK_3A_TIMEOUT_IN_MS = 1000;
    private static final int DEFAULT_CAPTURE_MODE = 1;
    public static final Defaults DEFAULT_CONFIG = new Defaults();
    private static final int DEFAULT_FLASH_MODE = 2;
    public static final int ERROR_CAMERA_CLOSED = 3;
    public static final int ERROR_CAPTURE_FAILED = 2;
    public static final int ERROR_FILE_IO = 1;
    public static final int ERROR_INVALID_CAMERA = 4;
    public static final int ERROR_UNKNOWN = 0;
    public static final int FLASH_MODE_AUTO = 0;
    public static final int FLASH_MODE_OFF = 2;
    public static final int FLASH_MODE_ON = 1;
    private static final int FLASH_MODE_UNKNOWN = -1;
    private static final byte JPEG_QUALITY_MAXIMIZE_QUALITY_MODE = 100;
    private static final byte JPEG_QUALITY_MINIMIZE_LATENCY_MODE = 95;
    private static final int MAX_IMAGES = 2;
    private static final String TAG = "ImageCapture";
    private CaptureBundle mCaptureBundle;
    private CaptureConfig mCaptureConfig;
    private final int mCaptureMode;
    private CaptureProcessor mCaptureProcessor;
    private final ImageReaderProxy.OnImageAvailableListener mClosingListener = ImageCapture$$ExternalSyntheticLambda16.INSTANCE;
    private Rational mCropAspectRatio = null;
    private DeferrableSurface mDeferrableSurface;
    private final boolean mEnableCheck3AConverged;
    private ExecutorService mExecutor;
    private int mFlashMode = -1;
    private ImageCaptureRequestProcessor mImageCaptureRequestProcessor;
    SafeCloseImageReaderProxy mImageReader;
    final Executor mIoExecutor;
    private final AtomicReference<Integer> mLockedFlashMode = new AtomicReference<>((Object) null);
    private int mMaxCaptureStages;
    private CameraCaptureCallback mMetadataMatchingCaptureCallback;
    ProcessingImageReader mProcessingImageReader;
    final Executor mSequentialIoExecutor;
    private final CaptureCallbackChecker mSessionCallbackChecker = new CaptureCallbackChecker();
    SessionConfig.Builder mSessionConfigBuilder;
    private boolean mUseSoftwareJpeg;
    private final boolean mUseTorchFlash;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CaptureMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FlashMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ImageCaptureError {
    }

    public static abstract class OnImageCapturedCallback {
        public void onCaptureSuccess(ImageProxy imageProxy) {
        }

        public void onError(ImageCaptureException imageCaptureException) {
        }
    }

    public interface OnImageSavedCallback {
        void onError(ImageCaptureException imageCaptureException);

        void onImageSaved(OutputFileResults outputFileResults);
    }

    static /* synthetic */ void lambda$closeTorch$16() {
    }

    static /* synthetic */ Void lambda$issueTakePicture$20(List list) {
        return null;
    }

    static /* synthetic */ Void lambda$preTakePicture$13(Boolean bool) {
        return null;
    }

    static /* synthetic */ Void lambda$triggerAePrecapture$18(CameraCaptureResult cameraCaptureResult) {
        return null;
    }

    static /* synthetic */ void lambda$triggerAf$17() {
    }

    static /* synthetic */ void lambda$new$0(ImageReaderProxy imageReaderProxy) {
        ImageProxy acquireLatestImage;
        try {
            acquireLatestImage = imageReaderProxy.acquireLatestImage();
            Log.d(TAG, "Discarding ImageProxy which was inadvertently acquired: " + acquireLatestImage);
            if (acquireLatestImage != null) {
                acquireLatestImage.close();
                return;
            }
            return;
        } catch (IllegalStateException e) {
            Log.e(TAG, "Failed to acquire latest image.", e);
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    ImageCapture(ImageCaptureConfig imageCaptureConfig) {
        super(imageCaptureConfig);
        boolean z = false;
        this.mUseSoftwareJpeg = false;
        ImageCaptureConfig imageCaptureConfig2 = (ImageCaptureConfig) getCurrentConfig();
        if (imageCaptureConfig2.containsOption(ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE)) {
            this.mCaptureMode = imageCaptureConfig2.getCaptureMode();
        } else {
            this.mCaptureMode = 1;
        }
        Executor executor = (Executor) Preconditions.checkNotNull(imageCaptureConfig2.getIoExecutor(CameraXExecutors.ioExecutor()));
        this.mIoExecutor = executor;
        this.mSequentialIoExecutor = CameraXExecutors.newSequentialExecutor(executor);
        if (this.mCaptureMode == 0) {
            this.mEnableCheck3AConverged = true;
        } else {
            this.mEnableCheck3AConverged = false;
        }
        z = DeviceQuirks.get(ImageCaptureWashedOutImageQuirk.class) != null ? true : z;
        this.mUseTorchFlash = z;
        if (z) {
            Logger.d(TAG, "Open and close torch to replace the flash fired by flash mode.");
        }
    }

    /* access modifiers changed from: package-private */
    public SessionConfig.Builder createPipeline(String str, ImageCaptureConfig imageCaptureConfig, Size size) {
        int i;
        CaptureProcessor captureProcessor;
        CaptureProcessorPipeline captureProcessorPipeline;
        YuvToJpegProcessor yuvToJpegProcessor;
        YuvToJpegProcessor yuvToJpegProcessor2;
        YuvToJpegProcessor yuvToJpegProcessor3;
        Threads.checkMainThread();
        SessionConfig.Builder createFrom = SessionConfig.Builder.createFrom(imageCaptureConfig);
        createFrom.addRepeatingCameraCaptureCallback(this.mSessionCallbackChecker);
        if (imageCaptureConfig.getImageReaderProxyProvider() != null) {
            this.mImageReader = new SafeCloseImageReaderProxy(imageCaptureConfig.getImageReaderProxyProvider().newInstance(size.getWidth(), size.getHeight(), getImageFormat(), 2, 0));
            this.mMetadataMatchingCaptureCallback = new CameraCaptureCallback() {
            };
        } else {
            CaptureProcessor captureProcessor2 = this.mCaptureProcessor;
            if (captureProcessor2 != null || this.mUseSoftwareJpeg) {
                int imageFormat = getImageFormat();
                int imageFormat2 = getImageFormat();
                if (!this.mUseSoftwareJpeg) {
                    captureProcessor = captureProcessor2;
                    i = imageFormat2;
                    yuvToJpegProcessor = null;
                    captureProcessorPipeline = null;
                } else if (Build.VERSION.SDK_INT >= 26) {
                    Logger.i(TAG, "Using software JPEG encoder.");
                    if (this.mCaptureProcessor != null) {
                        YuvToJpegProcessor yuvToJpegProcessor4 = new YuvToJpegProcessor(getJpegQuality(), this.mMaxCaptureStages);
                        captureProcessorPipeline = new CaptureProcessorPipeline(this.mCaptureProcessor, this.mMaxCaptureStages, yuvToJpegProcessor4, this.mExecutor);
                        yuvToJpegProcessor2 = yuvToJpegProcessor4;
                        yuvToJpegProcessor3 = captureProcessorPipeline;
                    } else {
                        yuvToJpegProcessor3 = new YuvToJpegProcessor(getJpegQuality(), this.mMaxCaptureStages);
                        captureProcessorPipeline = null;
                        yuvToJpegProcessor2 = yuvToJpegProcessor3;
                    }
                    captureProcessor = yuvToJpegProcessor3;
                    i = 256;
                    yuvToJpegProcessor = yuvToJpegProcessor2;
                } else {
                    throw new IllegalStateException("Software JPEG only supported on API 26+");
                }
                ProcessingImageReader processingImageReader = new ProcessingImageReader(size.getWidth(), size.getHeight(), imageFormat, this.mMaxCaptureStages, this.mExecutor, getCaptureBundle(CaptureBundles.singleDefaultCaptureBundle()), captureProcessor, i);
                this.mProcessingImageReader = processingImageReader;
                this.mMetadataMatchingCaptureCallback = processingImageReader.getCameraCaptureCallback();
                this.mImageReader = new SafeCloseImageReaderProxy(this.mProcessingImageReader);
                if (yuvToJpegProcessor != null) {
                    this.mProcessingImageReader.getCloseFuture().addListener(new ImageCapture$$ExternalSyntheticLambda7(yuvToJpegProcessor, captureProcessorPipeline), CameraXExecutors.directExecutor());
                }
            } else {
                MetadataImageReader metadataImageReader = new MetadataImageReader(size.getWidth(), size.getHeight(), getImageFormat(), 2);
                this.mMetadataMatchingCaptureCallback = metadataImageReader.getCameraCaptureCallback();
                this.mImageReader = new SafeCloseImageReaderProxy(metadataImageReader);
            }
        }
        this.mImageCaptureRequestProcessor = new ImageCaptureRequestProcessor(2, new ImageCapture$$ExternalSyntheticLambda14(this));
        this.mImageReader.setOnImageAvailableListener(this.mClosingListener, CameraXExecutors.mainThreadExecutor());
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.mImageReader;
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        ImmediateSurface immediateSurface = new ImmediateSurface(this.mImageReader.getSurface());
        this.mDeferrableSurface = immediateSurface;
        ListenableFuture<Void> terminationFuture = immediateSurface.getTerminationFuture();
        Objects.requireNonNull(safeCloseImageReaderProxy);
        terminationFuture.addListener(new ImageAnalysis$$ExternalSyntheticLambda2(safeCloseImageReaderProxy), CameraXExecutors.mainThreadExecutor());
        createFrom.addNonRepeatingSurface(this.mDeferrableSurface);
        createFrom.addErrorListener(new ImageCapture$$ExternalSyntheticLambda17(this, str, imageCaptureConfig, size));
        return createFrom;
    }

    static /* synthetic */ void lambda$createPipeline$1(YuvToJpegProcessor yuvToJpegProcessor, CaptureProcessorPipeline captureProcessorPipeline) {
        if (Build.VERSION.SDK_INT >= 26) {
            yuvToJpegProcessor.close();
            captureProcessorPipeline.close();
        }
    }

    public /* synthetic */ void lambda$createPipeline$3$ImageCapture(String str, ImageCaptureConfig imageCaptureConfig, Size size, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        clearPipeline();
        if (isCurrentCamera(str)) {
            SessionConfig.Builder createPipeline = createPipeline(str, imageCaptureConfig, size);
            this.mSessionConfigBuilder = createPipeline;
            updateSessionConfig(createPipeline.build());
            notifyReset();
        }
    }

    /* access modifiers changed from: package-private */
    public void clearPipeline() {
        Threads.checkMainThread();
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        this.mDeferrableSurface = null;
        this.mImageReader = null;
        this.mProcessingImageReader = null;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
    }

    public UseCaseConfig<?> getDefaultConfig(boolean z, UseCaseConfigFactory useCaseConfigFactory) {
        Config config = useCaseConfigFactory.getConfig(UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE);
        if (z) {
            config = Config.CC.mergeConfigs(config, DEFAULT_CONFIG.getConfig());
        }
        if (config == null) {
            return null;
        }
        return getUseCaseConfigBuilder(config).getUseCaseConfig();
    }

    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config config) {
        return Builder.fromConfig(config);
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [androidx.camera.core.impl.UseCaseConfig$Builder, androidx.camera.core.impl.UseCaseConfig$Builder<?, ?, ?>] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.core.impl.UseCaseConfig<?> onMergeConfig(androidx.camera.core.impl.CameraInfoInternal r8, androidx.camera.core.impl.UseCaseConfig.Builder<?, ?, ?> r9) {
        /*
            r7 = this;
            androidx.camera.core.impl.UseCaseConfig r0 = r9.getUseCaseConfig()
            androidx.camera.core.impl.Config$Option<androidx.camera.core.impl.CaptureProcessor> r1 = androidx.camera.core.impl.ImageCaptureConfig.OPTION_CAPTURE_PROCESSOR
            r2 = 0
            java.lang.Object r0 = r0.retrieveOption(r1, r2)
            java.lang.String r1 = "ImageCapture"
            r3 = 1
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)
            if (r0 == 0) goto L_0x0029
            int r0 = android.os.Build.VERSION.SDK_INT
            r5 = 29
            if (r0 < r5) goto L_0x0029
            java.lang.String r8 = "Requesting software JPEG due to a CaptureProcessor is set."
            androidx.camera.core.Logger.i(r1, r8)
            androidx.camera.core.impl.MutableConfig r8 = r9.getMutableConfig()
            androidx.camera.core.impl.Config$Option<java.lang.Boolean> r0 = androidx.camera.core.impl.ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER
            r8.insertOption(r0, r4)
            goto L_0x005b
        L_0x0029:
            androidx.camera.core.impl.Quirks r8 = r8.getCameraQuirks()
            java.lang.Class<androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk> r0 = androidx.camera.core.internal.compat.quirk.SoftwareJpegEncodingPreferredQuirk.class
            boolean r8 = r8.contains(r0)
            if (r8 == 0) goto L_0x005b
            androidx.camera.core.impl.MutableConfig r8 = r9.getMutableConfig()
            androidx.camera.core.impl.Config$Option<java.lang.Boolean> r0 = androidx.camera.core.impl.ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER
            java.lang.Object r8 = r8.retrieveOption(r0, r4)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x004d
            java.lang.String r8 = "Device quirk suggests software JPEG encoder, but it has been explicitly disabled."
            androidx.camera.core.Logger.w(r1, r8)
            goto L_0x005b
        L_0x004d:
            java.lang.String r8 = "Requesting software JPEG due to device quirk."
            androidx.camera.core.Logger.i(r1, r8)
            androidx.camera.core.impl.MutableConfig r8 = r9.getMutableConfig()
            androidx.camera.core.impl.Config$Option<java.lang.Boolean> r0 = androidx.camera.core.impl.ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER
            r8.insertOption(r0, r4)
        L_0x005b:
            androidx.camera.core.impl.MutableConfig r8 = r9.getMutableConfig()
            boolean r8 = enforceSoftwareJpegConstraints(r8)
            androidx.camera.core.impl.MutableConfig r0 = r9.getMutableConfig()
            androidx.camera.core.impl.Config$Option<java.lang.Integer> r1 = androidx.camera.core.impl.ImageCaptureConfig.OPTION_BUFFER_FORMAT
            java.lang.Object r0 = r0.retrieveOption(r1, r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r1 = 0
            r4 = 35
            if (r0 == 0) goto L_0x009d
            androidx.camera.core.impl.MutableConfig r5 = r9.getMutableConfig()
            androidx.camera.core.impl.Config$Option<androidx.camera.core.impl.CaptureProcessor> r6 = androidx.camera.core.impl.ImageCaptureConfig.OPTION_CAPTURE_PROCESSOR
            java.lang.Object r2 = r5.retrieveOption(r6, r2)
            if (r2 != 0) goto L_0x0082
            r2 = r3
            goto L_0x0083
        L_0x0082:
            r2 = r1
        L_0x0083:
            java.lang.String r5 = "Cannot set buffer format with CaptureProcessor defined."
            androidx.core.util.Preconditions.checkArgument(r2, r5)
            androidx.camera.core.impl.MutableConfig r2 = r9.getMutableConfig()
            androidx.camera.core.impl.Config$Option<java.lang.Integer> r5 = androidx.camera.core.impl.ImageInputConfig.OPTION_INPUT_FORMAT
            if (r8 == 0) goto L_0x0091
            goto L_0x0095
        L_0x0091:
            int r4 = r0.intValue()
        L_0x0095:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
            r2.insertOption(r5, r8)
            goto L_0x00c9
        L_0x009d:
            androidx.camera.core.impl.MutableConfig r0 = r9.getMutableConfig()
            androidx.camera.core.impl.Config$Option<androidx.camera.core.impl.CaptureProcessor> r5 = androidx.camera.core.impl.ImageCaptureConfig.OPTION_CAPTURE_PROCESSOR
            java.lang.Object r0 = r0.retrieveOption(r5, r2)
            if (r0 != 0) goto L_0x00bc
            if (r8 == 0) goto L_0x00ac
            goto L_0x00bc
        L_0x00ac:
            androidx.camera.core.impl.MutableConfig r8 = r9.getMutableConfig()
            androidx.camera.core.impl.Config$Option<java.lang.Integer> r0 = androidx.camera.core.impl.ImageInputConfig.OPTION_INPUT_FORMAT
            r2 = 256(0x100, float:3.59E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r8.insertOption(r0, r2)
            goto L_0x00c9
        L_0x00bc:
            androidx.camera.core.impl.MutableConfig r8 = r9.getMutableConfig()
            androidx.camera.core.impl.Config$Option<java.lang.Integer> r0 = androidx.camera.core.impl.ImageInputConfig.OPTION_INPUT_FORMAT
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r8.insertOption(r0, r2)
        L_0x00c9:
            androidx.camera.core.impl.MutableConfig r8 = r9.getMutableConfig()
            androidx.camera.core.impl.Config$Option<java.lang.Integer> r0 = androidx.camera.core.impl.ImageCaptureConfig.OPTION_MAX_CAPTURE_STAGES
            r2 = 2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r8 = r8.retrieveOption(r0, r2)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r8 < r3) goto L_0x00e1
            goto L_0x00e2
        L_0x00e1:
            r3 = r1
        L_0x00e2:
            java.lang.String r8 = "Maximum outstanding image count must be at least 1"
            androidx.core.util.Preconditions.checkArgument(r3, r8)
            androidx.camera.core.impl.UseCaseConfig r8 = r9.getUseCaseConfig()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageCapture.onMergeConfig(androidx.camera.core.impl.CameraInfoInternal, androidx.camera.core.impl.UseCaseConfig$Builder):androidx.camera.core.impl.UseCaseConfig");
    }

    /* access modifiers changed from: protected */
    public void onCameraControlReady() {
        trySetFlashModeToCameraControl();
    }

    public int getFlashMode() {
        int i;
        synchronized (this.mLockedFlashMode) {
            i = this.mFlashMode;
            if (i == -1) {
                i = ((ImageCaptureConfig) getCurrentConfig()).getFlashMode(2);
            }
        }
        return i;
    }

    public void setFlashMode(int i) {
        if (i == 0 || i == 1 || i == 2) {
            synchronized (this.mLockedFlashMode) {
                this.mFlashMode = i;
                trySetFlashModeToCameraControl();
            }
            return;
        }
        throw new IllegalArgumentException("Invalid flash mode: " + i);
    }

    public void setCropAspectRatio(Rational rational) {
        this.mCropAspectRatio = rational;
    }

    public int getTargetRotation() {
        return getTargetRotationInternal();
    }

    public void setTargetRotation(int i) {
        int targetRotation = getTargetRotation();
        if (setTargetRotationInternal(i) && this.mCropAspectRatio != null) {
            this.mCropAspectRatio = ImageUtil.getRotatedAspectRatio(Math.abs(CameraOrientationUtil.surfaceRotationToDegrees(i) - CameraOrientationUtil.surfaceRotationToDegrees(targetRotation)), this.mCropAspectRatio);
        }
    }

    public int getCaptureMode() {
        return this.mCaptureMode;
    }

    public ResolutionInfo getResolutionInfo() {
        return super.getResolutionInfo();
    }

    /* access modifiers changed from: protected */
    public ResolutionInfo getResolutionInfoInternal() {
        CameraInternal camera = getCamera();
        Size attachedSurfaceResolution = getAttachedSurfaceResolution();
        if (camera == null || attachedSurfaceResolution == null) {
            return null;
        }
        Rect viewPortCropRect = getViewPortCropRect();
        Rational rational = this.mCropAspectRatio;
        if (viewPortCropRect == null) {
            if (rational != null) {
                viewPortCropRect = ImageUtil.computeCropRectFromAspectRatio(attachedSurfaceResolution, rational);
            } else {
                viewPortCropRect = new Rect(0, 0, attachedSurfaceResolution.getWidth(), attachedSurfaceResolution.getHeight());
            }
        }
        return ResolutionInfo.create(attachedSurfaceResolution, viewPortCropRect, getRelativeRotation(camera));
    }

    /* renamed from: takePicture */
    public void lambda$takePicture$4$ImageCapture(Executor executor, OnImageCapturedCallback onImageCapturedCallback) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.mainThreadExecutor().execute(new ImageCapture$$ExternalSyntheticLambda6(this, executor, onImageCapturedCallback));
        } else {
            sendImageCaptureRequest(executor, onImageCapturedCallback);
        }
    }

    /* renamed from: takePicture */
    public void lambda$takePicture$5$ImageCapture(OutputFileOptions outputFileOptions, Executor executor, final OnImageSavedCallback onImageSavedCallback) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            CameraXExecutors.mainThreadExecutor().execute(new ImageCapture$$ExternalSyntheticLambda5(this, outputFileOptions, executor, onImageSavedCallback));
            return;
        }
        final AnonymousClass2 r6 = new ImageSaver.OnImageSavedCallback() {
            public void onImageSaved(OutputFileResults outputFileResults) {
                onImageSavedCallback.onImageSaved(outputFileResults);
            }

            public void onError(ImageSaver.SaveError saveError, String str, Throwable th) {
                int i = 1;
                if (AnonymousClass9.$SwitchMap$androidx$camera$core$ImageSaver$SaveError[saveError.ordinal()] != 1) {
                    i = 0;
                }
                onImageSavedCallback.onError(new ImageCaptureException(i, str, th));
            }
        };
        final OutputFileOptions outputFileOptions2 = outputFileOptions;
        final Executor executor2 = executor;
        final OnImageSavedCallback onImageSavedCallback2 = onImageSavedCallback;
        sendImageCaptureRequest(CameraXExecutors.mainThreadExecutor(), new OnImageCapturedCallback() {
            public void onCaptureSuccess(ImageProxy imageProxy) {
                ImageCapture.this.mIoExecutor.execute(new ImageSaver(imageProxy, outputFileOptions2, imageProxy.getImageInfo().getRotationDegrees(), executor2, ImageCapture.this.mSequentialIoExecutor, r6));
            }

            public void onError(ImageCaptureException imageCaptureException) {
                onImageSavedCallback2.onError(imageCaptureException);
            }
        });
    }

    /* renamed from: androidx.camera.core.ImageCapture$9  reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$ImageSaver$SaveError;

        static {
            int[] iArr = new int[ImageSaver.SaveError.values().length];
            $SwitchMap$androidx$camera$core$ImageSaver$SaveError = iArr;
            try {
                iArr[ImageSaver.SaveError.FILE_IO_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void onStateDetached() {
        abortImageCaptureRequests();
    }

    private void abortImageCaptureRequests() {
        this.mImageCaptureRequestProcessor.cancelRequests(new CameraClosedException("Camera is closed."));
    }

    private void sendImageCaptureRequest(Executor executor, OnImageCapturedCallback onImageCapturedCallback) {
        CameraInternal camera = getCamera();
        if (camera == null) {
            executor.execute(new ImageCapture$$ExternalSyntheticLambda4(this, onImageCapturedCallback));
        } else {
            this.mImageCaptureRequestProcessor.sendRequest(new ImageCaptureRequest(getRelativeRotation(camera), getJpegQuality(), this.mCropAspectRatio, getViewPortCropRect(), executor, onImageCapturedCallback));
        }
    }

    public /* synthetic */ void lambda$sendImageCaptureRequest$6$ImageCapture(OnImageCapturedCallback onImageCapturedCallback) {
        onImageCapturedCallback.onError(new ImageCaptureException(4, "Not bound to a valid Camera [" + this + "]", (Throwable) null));
    }

    private void lockFlashMode() {
        synchronized (this.mLockedFlashMode) {
            if (this.mLockedFlashMode.get() == null) {
                this.mLockedFlashMode.set(Integer.valueOf(getFlashMode()));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void unlockFlashMode() {
        /*
            r3 = this;
            java.util.concurrent.atomic.AtomicReference<java.lang.Integer> r0 = r3.mLockedFlashMode
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicReference<java.lang.Integer> r1 = r3.mLockedFlashMode     // Catch:{ all -> 0x001f }
            r2 = 0
            java.lang.Object r1 = r1.getAndSet(r2)     // Catch:{ all -> 0x001f }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x0010
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x0010:
            int r1 = r1.intValue()     // Catch:{ all -> 0x001f }
            int r2 = r3.getFlashMode()     // Catch:{ all -> 0x001f }
            if (r1 == r2) goto L_0x001d
            r3.trySetFlashModeToCameraControl()     // Catch:{ all -> 0x001f }
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.ImageCapture.unlockFlashMode():void");
    }

    private void trySetFlashModeToCameraControl() {
        synchronized (this.mLockedFlashMode) {
            if (this.mLockedFlashMode.get() == null) {
                getCameraControl().setFlashMode(getFlashMode());
            }
        }
    }

    private int getJpegQuality() {
        int i = this.mCaptureMode;
        if (i == 0) {
            return 100;
        }
        if (i == 1) {
            return 95;
        }
        throw new IllegalStateException("CaptureMode " + this.mCaptureMode + " is invalid");
    }

    /* access modifiers changed from: private */
    /* renamed from: takePictureInternal */
    public ListenableFuture<ImageProxy> lambda$createPipeline$2$ImageCapture(ImageCaptureRequest imageCaptureRequest) {
        return CallbackToFutureAdapter.getFuture(new ImageCapture$$ExternalSyntheticLambda1(this, imageCaptureRequest));
    }

    public /* synthetic */ Object lambda$takePictureInternal$10$ImageCapture(ImageCaptureRequest imageCaptureRequest, final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mImageReader.setOnImageAvailableListener(new ImageCapture$$ExternalSyntheticLambda15(completer), CameraXExecutors.mainThreadExecutor());
        final TakePictureState takePictureState = new TakePictureState();
        FutureChain transformAsync = FutureChain.from(preTakePicture(takePictureState)).transformAsync(new ImageCapture$$ExternalSyntheticLambda18(this, imageCaptureRequest), this.mExecutor);
        Futures.addCallback(transformAsync, new FutureCallback<Void>() {
            public void onSuccess(Void voidR) {
                ImageCapture.this.postTakePicture(takePictureState);
            }

            public void onFailure(Throwable th) {
                ImageCapture.this.postTakePicture(takePictureState);
                completer.setException(th);
            }
        }, this.mExecutor);
        completer.addCancellationListener(new ImageCapture$$ExternalSyntheticLambda9(transformAsync), CameraXExecutors.directExecutor());
        return "takePictureInternal";
    }

    static /* synthetic */ void lambda$takePictureInternal$7(CallbackToFutureAdapter.Completer completer, ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy acquireLatestImage = imageReaderProxy.acquireLatestImage();
            if (acquireLatestImage == null) {
                completer.setException(new IllegalStateException("Unable to acquire image"));
            } else if (!completer.set(acquireLatestImage)) {
                acquireLatestImage.close();
            }
        } catch (IllegalStateException e) {
            completer.setException(e);
        }
    }

    public /* synthetic */ ListenableFuture lambda$takePictureInternal$8$ImageCapture(ImageCaptureRequest imageCaptureRequest, Void voidR) throws Exception {
        return issueTakePicture(imageCaptureRequest);
    }

    static class ImageCaptureRequestProcessor implements ForwardingImageProxy.OnImageCloseListener {
        ImageCaptureRequest mCurrentRequest = null;
        ListenableFuture<ImageProxy> mCurrentRequestFuture = null;
        private final ImageCaptor mImageCaptor;
        final Object mLock = new Object();
        private final int mMaxImages;
        int mOutstandingImages = 0;
        private final Deque<ImageCaptureRequest> mPendingRequests = new ArrayDeque();

        interface ImageCaptor {
            ListenableFuture<ImageProxy> capture(ImageCaptureRequest imageCaptureRequest);
        }

        ImageCaptureRequestProcessor(int i, ImageCaptor imageCaptor) {
            this.mMaxImages = i;
            this.mImageCaptor = imageCaptor;
        }

        public void sendRequest(ImageCaptureRequest imageCaptureRequest) {
            synchronized (this.mLock) {
                this.mPendingRequests.offer(imageCaptureRequest);
                Locale locale = Locale.US;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(this.mCurrentRequest != null ? 1 : 0);
                objArr[1] = Integer.valueOf(this.mPendingRequests.size());
                Logger.d(ImageCapture.TAG, String.format(locale, "Send image capture request [current, pending] = [%d, %d]", objArr));
                processNextRequest();
            }
        }

        public void cancelRequests(Throwable th) {
            ImageCaptureRequest imageCaptureRequest;
            ListenableFuture<ImageProxy> listenableFuture;
            ArrayList<ImageCaptureRequest> arrayList;
            synchronized (this.mLock) {
                imageCaptureRequest = this.mCurrentRequest;
                this.mCurrentRequest = null;
                listenableFuture = this.mCurrentRequestFuture;
                this.mCurrentRequestFuture = null;
                arrayList = new ArrayList<>(this.mPendingRequests);
                this.mPendingRequests.clear();
            }
            if (!(imageCaptureRequest == null || listenableFuture == null)) {
                imageCaptureRequest.notifyCallbackError(ImageCapture.getError(th), th.getMessage(), th);
                listenableFuture.cancel(true);
            }
            for (ImageCaptureRequest notifyCallbackError : arrayList) {
                notifyCallbackError.notifyCallbackError(ImageCapture.getError(th), th.getMessage(), th);
            }
        }

        public void onImageClose(ImageProxy imageProxy) {
            synchronized (this.mLock) {
                this.mOutstandingImages--;
                processNextRequest();
            }
        }

        /* access modifiers changed from: package-private */
        public void processNextRequest() {
            synchronized (this.mLock) {
                if (this.mCurrentRequest == null) {
                    if (this.mOutstandingImages >= this.mMaxImages) {
                        Logger.w(ImageCapture.TAG, "Too many acquire images. Close image to be able to process next.");
                        return;
                    }
                    final ImageCaptureRequest poll = this.mPendingRequests.poll();
                    if (poll != null) {
                        this.mCurrentRequest = poll;
                        ListenableFuture<ImageProxy> capture = this.mImageCaptor.capture(poll);
                        this.mCurrentRequestFuture = capture;
                        Futures.addCallback(capture, new FutureCallback<ImageProxy>() {
                            public void onSuccess(ImageProxy imageProxy) {
                                synchronized (ImageCaptureRequestProcessor.this.mLock) {
                                    Preconditions.checkNotNull(imageProxy);
                                    SingleCloseImageProxy singleCloseImageProxy = new SingleCloseImageProxy(imageProxy);
                                    singleCloseImageProxy.addOnImageCloseListener(ImageCaptureRequestProcessor.this);
                                    ImageCaptureRequestProcessor.this.mOutstandingImages++;
                                    poll.dispatchImage(singleCloseImageProxy);
                                    ImageCaptureRequestProcessor.this.mCurrentRequest = null;
                                    ImageCaptureRequestProcessor.this.mCurrentRequestFuture = null;
                                    ImageCaptureRequestProcessor.this.processNextRequest();
                                }
                            }

                            public void onFailure(Throwable th) {
                                synchronized (ImageCaptureRequestProcessor.this.mLock) {
                                    if (!(th instanceof CancellationException)) {
                                        poll.notifyCallbackError(ImageCapture.getError(th), th != null ? th.getMessage() : "Unknown error", th);
                                    }
                                    ImageCaptureRequestProcessor.this.mCurrentRequest = null;
                                    ImageCaptureRequestProcessor.this.mCurrentRequestFuture = null;
                                    ImageCaptureRequestProcessor.this.processNextRequest();
                                }
                            }
                        }, CameraXExecutors.directExecutor());
                    }
                }
            }
        }
    }

    public String toString() {
        return "ImageCapture:" + getName();
    }

    static int getError(Throwable th) {
        if (th instanceof CameraClosedException) {
            return 3;
        }
        return th instanceof CaptureFailedException ? 2 : 0;
    }

    static boolean enforceSoftwareJpegConstraints(MutableConfig mutableConfig) {
        boolean z = false;
        if (((Boolean) mutableConfig.retrieveOption(ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER, false)).booleanValue()) {
            boolean z2 = true;
            if (Build.VERSION.SDK_INT < 26) {
                Logger.w(TAG, "Software JPEG only supported on API 26+, but current API level is " + Build.VERSION.SDK_INT);
                z2 = false;
            }
            Integer num = (Integer) mutableConfig.retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, null);
            if (num == null || num.intValue() == 256) {
                z = z2;
            } else {
                Logger.w(TAG, "Software JPEG cannot be used with non-JPEG output buffer format.");
            }
            if (!z) {
                Logger.w(TAG, "Unable to support software JPEG. Disabling.");
                mutableConfig.insertOption(ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER, false);
            }
        }
        return z;
    }

    public void onDetached() {
        abortImageCaptureRequests();
        clearPipeline();
        this.mUseSoftwareJpeg = false;
        this.mExecutor.shutdown();
    }

    public void onAttached() {
        ImageCaptureConfig imageCaptureConfig = (ImageCaptureConfig) getCurrentConfig();
        this.mCaptureConfig = CaptureConfig.Builder.createFrom(imageCaptureConfig).build();
        this.mCaptureProcessor = imageCaptureConfig.getCaptureProcessor((CaptureProcessor) null);
        this.mMaxCaptureStages = imageCaptureConfig.getMaxCaptureStages(2);
        this.mCaptureBundle = imageCaptureConfig.getCaptureBundle(CaptureBundles.singleDefaultCaptureBundle());
        this.mUseSoftwareJpeg = imageCaptureConfig.isSoftwareJpegEncoderRequested();
        this.mExecutor = Executors.newFixedThreadPool(1, new ThreadFactory() {
            private final AtomicInteger mId = new AtomicInteger(0);

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "CameraX-image_capture_" + this.mId.getAndIncrement());
            }
        });
    }

    /* access modifiers changed from: protected */
    public Size onSuggestedResolutionUpdated(Size size) {
        SessionConfig.Builder createPipeline = createPipeline(getCameraId(), (ImageCaptureConfig) getCurrentConfig(), size);
        this.mSessionConfigBuilder = createPipeline;
        updateSessionConfig(createPipeline.build());
        notifyActive();
        return size;
    }

    private ListenableFuture<Void> preTakePicture(TakePictureState takePictureState) {
        lockFlashMode();
        return FutureChain.from(getPreCaptureStateIfNeeded()).transformAsync(new ImageCapture$$ExternalSyntheticLambda19(this, takePictureState), this.mExecutor).transformAsync(new ImageCapture$$ExternalSyntheticLambda20(this, takePictureState), this.mExecutor).transform(ImageCapture$$ExternalSyntheticLambda10.INSTANCE, this.mExecutor);
    }

    public /* synthetic */ ListenableFuture lambda$preTakePicture$11$ImageCapture(TakePictureState takePictureState, CameraCaptureResult cameraCaptureResult) throws Exception {
        takePictureState.mPreCaptureState = cameraCaptureResult;
        triggerAfIfNeeded(takePictureState);
        if (!isFlashRequired(takePictureState)) {
            return Futures.immediateFuture(null);
        }
        if (this.mUseTorchFlash) {
            return openTorch(takePictureState);
        }
        return triggerAePrecapture(takePictureState);
    }

    public /* synthetic */ ListenableFuture lambda$preTakePicture$12$ImageCapture(TakePictureState takePictureState, Void voidR) throws Exception {
        return check3AConverged(takePictureState);
    }

    /* access modifiers changed from: package-private */
    public void postTakePicture(TakePictureState takePictureState) {
        closeTorch(takePictureState);
        cancelAfAeTrigger(takePictureState);
        unlockFlashMode();
    }

    private ListenableFuture<Void> openTorch(TakePictureState takePictureState) {
        CameraInternal camera = getCamera();
        if (camera != null && camera.getCameraInfo().getTorchState().getValue().intValue() == 1) {
            return Futures.immediateFuture(null);
        }
        Logger.d(TAG, "openTorch");
        return CallbackToFutureAdapter.getFuture(new ImageCapture$$ExternalSyntheticLambda2(this, takePictureState));
    }

    public /* synthetic */ Object lambda$openTorch$15$ImageCapture(TakePictureState takePictureState, CallbackToFutureAdapter.Completer completer) throws Exception {
        CameraControlInternal cameraControl = getCameraControl();
        takePictureState.mIsTorchOpened = true;
        cameraControl.enableTorch(true).addListener(new ImageCapture$$ExternalSyntheticLambda8(completer), CameraXExecutors.directExecutor());
        return "openTorch";
    }

    private void closeTorch(TakePictureState takePictureState) {
        if (takePictureState.mIsTorchOpened) {
            CameraControlInternal cameraControl = getCameraControl();
            takePictureState.mIsTorchOpened = false;
            cameraControl.enableTorch(false).addListener(ImageCapture$$ExternalSyntheticLambda11.INSTANCE, CameraXExecutors.directExecutor());
        }
    }

    private ListenableFuture<CameraCaptureResult> getPreCaptureStateIfNeeded() {
        if (this.mEnableCheck3AConverged || getFlashMode() == 0) {
            return this.mSessionCallbackChecker.checkCaptureResult(new CaptureCallbackChecker.CaptureResultChecker<CameraCaptureResult>() {
                public CameraCaptureResult check(CameraCaptureResult cameraCaptureResult) {
                    if (Logger.isDebugEnabled(ImageCapture.TAG)) {
                        Logger.d(ImageCapture.TAG, "preCaptureState, AE=" + cameraCaptureResult.getAeState() + " AF =" + cameraCaptureResult.getAfState() + " AWB=" + cameraCaptureResult.getAwbState());
                    }
                    return cameraCaptureResult;
                }
            });
        }
        return Futures.immediateFuture(null);
    }

    /* access modifiers changed from: package-private */
    public boolean isFlashRequired(TakePictureState takePictureState) {
        int flashMode = getFlashMode();
        if (flashMode != 0) {
            if (flashMode == 1) {
                return true;
            }
            if (flashMode == 2) {
                return false;
            }
            throw new AssertionError(getFlashMode());
        } else if (takePictureState.mPreCaptureState.getAeState() == CameraCaptureMetaData.AeState.FLASH_REQUIRED) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<Boolean> check3AConverged(TakePictureState takePictureState) {
        if (this.mEnableCheck3AConverged || takePictureState.mIsAePrecaptureTriggered || takePictureState.mIsTorchOpened) {
            return this.mSessionCallbackChecker.checkCaptureResult(new CaptureCallbackChecker.CaptureResultChecker<Boolean>() {
                public Boolean check(CameraCaptureResult cameraCaptureResult) {
                    if (Logger.isDebugEnabled(ImageCapture.TAG)) {
                        Logger.d(ImageCapture.TAG, "checkCaptureResult, AE=" + cameraCaptureResult.getAeState() + " AF =" + cameraCaptureResult.getAfState() + " AWB=" + cameraCaptureResult.getAwbState());
                    }
                    return ImageCapture.this.is3AConverged(cameraCaptureResult) ? true : null;
                }
            }, CHECK_3A_TIMEOUT_IN_MS, false);
        }
        return Futures.immediateFuture(false);
    }

    /* access modifiers changed from: package-private */
    public boolean is3AConverged(CameraCaptureResult cameraCaptureResult) {
        if (cameraCaptureResult == null) {
            return false;
        }
        boolean z = cameraCaptureResult.getAfMode() == CameraCaptureMetaData.AfMode.ON_CONTINUOUS_AUTO || cameraCaptureResult.getAfMode() == CameraCaptureMetaData.AfMode.OFF || cameraCaptureResult.getAfMode() == CameraCaptureMetaData.AfMode.UNKNOWN || cameraCaptureResult.getAfState() == CameraCaptureMetaData.AfState.FOCUSED || cameraCaptureResult.getAfState() == CameraCaptureMetaData.AfState.LOCKED_FOCUSED || cameraCaptureResult.getAfState() == CameraCaptureMetaData.AfState.LOCKED_NOT_FOCUSED;
        boolean z2 = cameraCaptureResult.getAeState() == CameraCaptureMetaData.AeState.CONVERGED || cameraCaptureResult.getAeState() == CameraCaptureMetaData.AeState.FLASH_REQUIRED || cameraCaptureResult.getAeState() == CameraCaptureMetaData.AeState.UNKNOWN;
        boolean z3 = cameraCaptureResult.getAwbState() == CameraCaptureMetaData.AwbState.CONVERGED || cameraCaptureResult.getAwbState() == CameraCaptureMetaData.AwbState.UNKNOWN;
        if (!z || !z2 || !z3) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void triggerAfIfNeeded(TakePictureState takePictureState) {
        if (this.mEnableCheck3AConverged && takePictureState.mPreCaptureState.getAfMode() == CameraCaptureMetaData.AfMode.ON_MANUAL_AUTO && takePictureState.mPreCaptureState.getAfState() == CameraCaptureMetaData.AfState.INACTIVE) {
            triggerAf(takePictureState);
        }
    }

    private void triggerAf(TakePictureState takePictureState) {
        Logger.d(TAG, "triggerAf");
        takePictureState.mIsAfTriggered = true;
        getCameraControl().triggerAf().addListener(ImageCapture$$ExternalSyntheticLambda12.INSTANCE, CameraXExecutors.directExecutor());
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<Void> triggerAePrecapture(TakePictureState takePictureState) {
        Logger.d(TAG, "triggerAePrecapture");
        takePictureState.mIsAePrecaptureTriggered = true;
        return Futures.transform(getCameraControl().triggerAePrecapture(), ImageCapture$$ExternalSyntheticLambda0.INSTANCE, CameraXExecutors.directExecutor());
    }

    /* access modifiers changed from: package-private */
    public void cancelAfAeTrigger(TakePictureState takePictureState) {
        if (takePictureState.mIsAfTriggered || takePictureState.mIsAePrecaptureTriggered) {
            getCameraControl().cancelAfAeTrigger(takePictureState.mIsAfTriggered, takePictureState.mIsAePrecaptureTriggered);
            takePictureState.mIsAfTriggered = false;
            takePictureState.mIsAePrecaptureTriggered = false;
        }
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<Void> issueTakePicture(ImageCaptureRequest imageCaptureRequest) {
        String str;
        CaptureBundle captureBundle;
        Logger.d(TAG, "issueTakePicture");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (this.mProcessingImageReader != null) {
            captureBundle = getCaptureBundle(CaptureBundles.singleDefaultCaptureBundle());
            if (captureBundle == null) {
                return Futures.immediateFailedFuture(new IllegalArgumentException("ImageCapture cannot set empty CaptureBundle."));
            }
            if (this.mCaptureProcessor == null && captureBundle.getCaptureStages().size() > 1) {
                return Futures.immediateFailedFuture(new IllegalArgumentException("No CaptureProcessor can be found to process the images captured for multiple CaptureStages."));
            }
            if (captureBundle.getCaptureStages().size() > this.mMaxCaptureStages) {
                return Futures.immediateFailedFuture(new IllegalArgumentException("ImageCapture has CaptureStages > Max CaptureStage size"));
            }
            this.mProcessingImageReader.setCaptureBundle(captureBundle);
            str = this.mProcessingImageReader.getTagBundleKey();
        } else {
            captureBundle = getCaptureBundle(CaptureBundles.singleDefaultCaptureBundle());
            if (captureBundle.getCaptureStages().size() > 1) {
                return Futures.immediateFailedFuture(new IllegalArgumentException("ImageCapture have no CaptureProcess set with CaptureBundle size > 1."));
            }
            str = null;
        }
        for (CaptureStage next : captureBundle.getCaptureStages()) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setTemplateType(this.mCaptureConfig.getTemplateType());
            builder.addImplementationOptions(this.mCaptureConfig.getImplementationOptions());
            builder.addAllCameraCaptureCallbacks(this.mSessionConfigBuilder.getSingleCameraCaptureCallbacks());
            builder.addSurface(this.mDeferrableSurface);
            if (new ExifRotationAvailability().isRotationOptionSupported()) {
                builder.addImplementationOption(CaptureConfig.OPTION_ROTATION, Integer.valueOf(imageCaptureRequest.mRotationDegrees));
            }
            builder.addImplementationOption(CaptureConfig.OPTION_JPEG_QUALITY, Integer.valueOf(imageCaptureRequest.mJpegQuality));
            builder.addImplementationOptions(next.getCaptureConfig().getImplementationOptions());
            if (str != null) {
                builder.addTag(str, Integer.valueOf(next.getId()));
            }
            builder.addCameraCaptureCallback(this.mMetadataMatchingCaptureCallback);
            arrayList.add(CallbackToFutureAdapter.getFuture(new ImageCapture$$ExternalSyntheticLambda3(this, builder, arrayList2, next)));
        }
        getCameraControl().submitCaptureRequests(arrayList2);
        return Futures.transform(Futures.allAsList(arrayList), ImageCapture$$ExternalSyntheticLambda13.INSTANCE, CameraXExecutors.directExecutor());
    }

    public /* synthetic */ Object lambda$issueTakePicture$19$ImageCapture(CaptureConfig.Builder builder, List list, CaptureStage captureStage, final CallbackToFutureAdapter.Completer completer) throws Exception {
        builder.addCameraCaptureCallback(new CameraCaptureCallback() {
            public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
                completer.set(null);
            }

            public void onCaptureFailed(CameraCaptureFailure cameraCaptureFailure) {
                completer.setException(new CaptureFailedException("Capture request failed with reason " + cameraCaptureFailure.getReason()));
            }

            public void onCaptureCancelled() {
                completer.setException(new CameraClosedException("Capture request is cancelled because camera is closed"));
            }
        });
        list.add(builder.build());
        return "issueTakePicture[stage=" + captureStage.getId() + "]";
    }

    static final class CaptureFailedException extends RuntimeException {
        CaptureFailedException(String str, Throwable th) {
            super(str, th);
        }

        CaptureFailedException(String str) {
            super(str);
        }
    }

    private CaptureBundle getCaptureBundle(CaptureBundle captureBundle) {
        List<CaptureStage> captureStages = this.mCaptureBundle.getCaptureStages();
        return (captureStages == null || captureStages.isEmpty()) ? captureBundle : CaptureBundles.createCaptureBundle(captureStages);
    }

    public static final class Defaults implements ConfigProvider<ImageCaptureConfig> {
        private static final int DEFAULT_ASPECT_RATIO = 0;
        private static final ImageCaptureConfig DEFAULT_CONFIG = new Builder().setSurfaceOccupancyPriority(4).setTargetAspectRatio(0).getUseCaseConfig();
        private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 4;

        public ImageCaptureConfig getConfig() {
            return DEFAULT_CONFIG;
        }
    }

    public static final class OutputFileOptions {
        private final ContentResolver mContentResolver;
        private final ContentValues mContentValues;
        private final File mFile;
        private final Metadata mMetadata;
        private final OutputStream mOutputStream;
        private final Uri mSaveCollection;

        OutputFileOptions(File file, ContentResolver contentResolver, Uri uri, ContentValues contentValues, OutputStream outputStream, Metadata metadata) {
            this.mFile = file;
            this.mContentResolver = contentResolver;
            this.mSaveCollection = uri;
            this.mContentValues = contentValues;
            this.mOutputStream = outputStream;
            this.mMetadata = metadata == null ? new Metadata() : metadata;
        }

        /* access modifiers changed from: package-private */
        public File getFile() {
            return this.mFile;
        }

        /* access modifiers changed from: package-private */
        public ContentResolver getContentResolver() {
            return this.mContentResolver;
        }

        /* access modifiers changed from: package-private */
        public Uri getSaveCollection() {
            return this.mSaveCollection;
        }

        /* access modifiers changed from: package-private */
        public ContentValues getContentValues() {
            return this.mContentValues;
        }

        /* access modifiers changed from: package-private */
        public OutputStream getOutputStream() {
            return this.mOutputStream;
        }

        public Metadata getMetadata() {
            return this.mMetadata;
        }

        public static final class Builder {
            private ContentResolver mContentResolver;
            private ContentValues mContentValues;
            private File mFile;
            private Metadata mMetadata;
            private OutputStream mOutputStream;
            private Uri mSaveCollection;

            public Builder(File file) {
                this.mFile = file;
            }

            public Builder(ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
                this.mContentResolver = contentResolver;
                this.mSaveCollection = uri;
                this.mContentValues = contentValues;
            }

            public Builder(OutputStream outputStream) {
                this.mOutputStream = outputStream;
            }

            public Builder setMetadata(Metadata metadata) {
                this.mMetadata = metadata;
                return this;
            }

            public OutputFileOptions build() {
                return new OutputFileOptions(this.mFile, this.mContentResolver, this.mSaveCollection, this.mContentValues, this.mOutputStream, this.mMetadata);
            }
        }
    }

    public static class OutputFileResults {
        private Uri mSavedUri;

        OutputFileResults(Uri uri) {
            this.mSavedUri = uri;
        }

        public Uri getSavedUri() {
            return this.mSavedUri;
        }
    }

    public static final class Metadata {
        private boolean mIsReversedHorizontal;
        private boolean mIsReversedHorizontalSet = false;
        private boolean mIsReversedVertical;
        private Location mLocation;

        public boolean isReversedHorizontal() {
            return this.mIsReversedHorizontal;
        }

        public boolean isReversedHorizontalSet() {
            return this.mIsReversedHorizontalSet;
        }

        public void setReversedHorizontal(boolean z) {
            this.mIsReversedHorizontal = z;
            this.mIsReversedHorizontalSet = true;
        }

        public boolean isReversedVertical() {
            return this.mIsReversedVertical;
        }

        public void setReversedVertical(boolean z) {
            this.mIsReversedVertical = z;
        }

        public Location getLocation() {
            return this.mLocation;
        }

        public void setLocation(Location location) {
            this.mLocation = location;
        }
    }

    static final class TakePictureState {
        boolean mIsAePrecaptureTriggered = false;
        boolean mIsAfTriggered = false;
        boolean mIsTorchOpened = false;
        CameraCaptureResult mPreCaptureState = CameraCaptureResult.EmptyCameraCaptureResult.create();

        TakePictureState() {
        }
    }

    static final class CaptureCallbackChecker extends CameraCaptureCallback {
        private static final long NO_TIMEOUT = 0;
        private final Set<CaptureResultListener> mCaptureResultListeners = new HashSet();

        public interface CaptureResultChecker<T> {
            T check(CameraCaptureResult cameraCaptureResult);
        }

        private interface CaptureResultListener {
            boolean onCaptureResult(CameraCaptureResult cameraCaptureResult);
        }

        CaptureCallbackChecker() {
        }

        public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
            deliverCaptureResultToListeners(cameraCaptureResult);
        }

        /* access modifiers changed from: package-private */
        public <T> ListenableFuture<T> checkCaptureResult(CaptureResultChecker<T> captureResultChecker) {
            return checkCaptureResult(captureResultChecker, 0, (Object) null);
        }

        /* access modifiers changed from: package-private */
        public <T> ListenableFuture<T> checkCaptureResult(CaptureResultChecker<T> captureResultChecker, long j, T t) {
            long j2 = 0;
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i >= 0) {
                if (i != 0) {
                    j2 = SystemClock.elapsedRealtime();
                }
                return CallbackToFutureAdapter.getFuture(new ImageCapture$CaptureCallbackChecker$$ExternalSyntheticLambda0(this, captureResultChecker, j2, j, t));
            }
            throw new IllegalArgumentException("Invalid timeout value: " + j);
        }

        public /* synthetic */ Object lambda$checkCaptureResult$0$ImageCapture$CaptureCallbackChecker(CaptureResultChecker captureResultChecker, long j, long j2, Object obj, CallbackToFutureAdapter.Completer completer) throws Exception {
            final CaptureResultChecker captureResultChecker2 = captureResultChecker;
            final CallbackToFutureAdapter.Completer completer2 = completer;
            final long j3 = j;
            final long j4 = j2;
            final Object obj2 = obj;
            addListener(new CaptureResultListener() {
                public boolean onCaptureResult(CameraCaptureResult cameraCaptureResult) {
                    Object check = captureResultChecker2.check(cameraCaptureResult);
                    if (check != null) {
                        completer2.set(check);
                        return true;
                    } else if (j3 <= 0 || SystemClock.elapsedRealtime() - j3 <= j4) {
                        return false;
                    } else {
                        completer2.set(obj2);
                        return true;
                    }
                }
            });
            return "checkCaptureResult";
        }

        private void deliverCaptureResultToListeners(CameraCaptureResult cameraCaptureResult) {
            synchronized (this.mCaptureResultListeners) {
                HashSet hashSet = null;
                Iterator it = new HashSet(this.mCaptureResultListeners).iterator();
                while (it.hasNext()) {
                    CaptureResultListener captureResultListener = (CaptureResultListener) it.next();
                    if (captureResultListener.onCaptureResult(cameraCaptureResult)) {
                        if (hashSet == null) {
                            hashSet = new HashSet();
                        }
                        hashSet.add(captureResultListener);
                    }
                }
                if (hashSet != null) {
                    this.mCaptureResultListeners.removeAll(hashSet);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void addListener(CaptureResultListener captureResultListener) {
            synchronized (this.mCaptureResultListeners) {
                this.mCaptureResultListeners.add(captureResultListener);
            }
        }
    }

    static class ImageCaptureRequest {
        private final OnImageCapturedCallback mCallback;
        AtomicBoolean mDispatched = new AtomicBoolean(false);
        final int mJpegQuality;
        private final Executor mListenerExecutor;
        final int mRotationDegrees;
        private final Rational mTargetRatio;
        private final Rect mViewPortCropRect;

        ImageCaptureRequest(int i, int i2, Rational rational, Rect rect, Executor executor, OnImageCapturedCallback onImageCapturedCallback) {
            boolean z = false;
            this.mRotationDegrees = i;
            this.mJpegQuality = i2;
            if (rational != null) {
                Preconditions.checkArgument(!rational.isZero(), "Target ratio cannot be zero");
                Preconditions.checkArgument(rational.floatValue() > 0.0f ? true : z, "Target ratio must be positive");
            }
            this.mTargetRatio = rational;
            this.mViewPortCropRect = rect;
            this.mListenerExecutor = executor;
            this.mCallback = onImageCapturedCallback;
        }

        /* access modifiers changed from: package-private */
        public void dispatchImage(ImageProxy imageProxy) {
            int i;
            Size size;
            if (!this.mDispatched.compareAndSet(false, true)) {
                imageProxy.close();
                return;
            }
            if (new ExifRotationAvailability().shouldUseExifOrientation(imageProxy)) {
                try {
                    ByteBuffer buffer = imageProxy.getPlanes()[0].getBuffer();
                    buffer.rewind();
                    byte[] bArr = new byte[buffer.capacity()];
                    buffer.get(bArr);
                    Exif createFromInputStream = Exif.createFromInputStream(new ByteArrayInputStream(bArr));
                    buffer.rewind();
                    size = new Size(createFromInputStream.getWidth(), createFromInputStream.getHeight());
                    i = createFromInputStream.getRotation();
                } catch (IOException e) {
                    notifyCallbackError(1, "Unable to parse JPEG exif", e);
                    imageProxy.close();
                    return;
                }
            } else {
                size = new Size(imageProxy.getWidth(), imageProxy.getHeight());
                i = this.mRotationDegrees;
            }
            SettableImageProxy settableImageProxy = new SettableImageProxy(imageProxy, size, ImmutableImageInfo.create(imageProxy.getImageInfo().getTagBundle(), imageProxy.getImageInfo().getTimestamp(), i));
            Rect rect = this.mViewPortCropRect;
            if (rect != null) {
                settableImageProxy.setCropRect(getDispatchCropRect(rect, this.mRotationDegrees, size, i));
            } else {
                Rational rational = this.mTargetRatio;
                if (rational != null) {
                    if (i % Opcodes.GETFIELD != 0) {
                        rational = new Rational(this.mTargetRatio.getDenominator(), this.mTargetRatio.getNumerator());
                    }
                    Size size2 = new Size(settableImageProxy.getWidth(), settableImageProxy.getHeight());
                    if (ImageUtil.isAspectRatioValid(size2, rational)) {
                        settableImageProxy.setCropRect(ImageUtil.computeCropRectFromAspectRatio(size2, rational));
                    }
                }
            }
            try {
                this.mListenerExecutor.execute(new ImageCapture$ImageCaptureRequest$$ExternalSyntheticLambda1(this, settableImageProxy));
            } catch (RejectedExecutionException unused) {
                Logger.e(ImageCapture.TAG, "Unable to post to the supplied executor.");
                imageProxy.close();
            }
        }

        public /* synthetic */ void lambda$dispatchImage$0$ImageCapture$ImageCaptureRequest(ImageProxy imageProxy) {
            this.mCallback.onCaptureSuccess(imageProxy);
        }

        static Rect getDispatchCropRect(Rect rect, int i, Size size, int i2) {
            Matrix matrix = new Matrix();
            matrix.setRotate((float) (i2 - i));
            float[] sizeToVertexes = ImageUtil.sizeToVertexes(size);
            matrix.mapPoints(sizeToVertexes);
            matrix.postTranslate(-ImageUtil.min(sizeToVertexes[0], sizeToVertexes[2], sizeToVertexes[4], sizeToVertexes[6]), -ImageUtil.min(sizeToVertexes[1], sizeToVertexes[3], sizeToVertexes[5], sizeToVertexes[7]));
            matrix.invert(matrix);
            RectF rectF = new RectF();
            matrix.mapRect(rectF, new RectF(rect));
            rectF.sort();
            Rect rect2 = new Rect();
            rectF.round(rect2);
            return rect2;
        }

        /* access modifiers changed from: package-private */
        public void notifyCallbackError(int i, String str, Throwable th) {
            if (this.mDispatched.compareAndSet(false, true)) {
                try {
                    this.mListenerExecutor.execute(new ImageCapture$ImageCaptureRequest$$ExternalSyntheticLambda0(this, i, str, th));
                } catch (RejectedExecutionException unused) {
                    Logger.e(ImageCapture.TAG, "Unable to post to the supplied executor.");
                }
            }
        }

        public /* synthetic */ void lambda$notifyCallbackError$1$ImageCapture$ImageCaptureRequest(int i, String str, Throwable th) {
            this.mCallback.onError(new ImageCaptureException(i, str, th));
        }
    }

    public static final class Builder implements UseCaseConfig.Builder<ImageCapture, ImageCaptureConfig, Builder>, ImageOutputConfig.Builder<Builder>, IoConfig.Builder<Builder> {
        private final MutableOptionsBundle mMutableConfig;

        public Builder() {
            this(MutableOptionsBundle.create());
        }

        private Builder(MutableOptionsBundle mutableOptionsBundle) {
            this.mMutableConfig = mutableOptionsBundle;
            Class cls = (Class) mutableOptionsBundle.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
            if (cls == null || cls.equals(ImageCapture.class)) {
                setTargetClass((Class<ImageCapture>) ImageCapture.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }

        public static Builder fromConfig(Config config) {
            return new Builder(MutableOptionsBundle.from(config));
        }

        static Builder fromConfig(ImageCaptureConfig imageCaptureConfig) {
            return new Builder(MutableOptionsBundle.from(imageCaptureConfig));
        }

        public MutableConfig getMutableConfig() {
            return this.mMutableConfig;
        }

        public ImageCaptureConfig getUseCaseConfig() {
            return new ImageCaptureConfig(OptionsBundle.from(this.mMutableConfig));
        }

        public ImageCapture build() {
            int intValue;
            if (getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_TARGET_ASPECT_RATIO, null) == null || getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_TARGET_RESOLUTION, null) == null) {
                Integer num = (Integer) getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, null);
                boolean z = false;
                if (num != null) {
                    Preconditions.checkArgument(getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_CAPTURE_PROCESSOR, null) == null, "Cannot set buffer format with CaptureProcessor defined.");
                    getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, num);
                } else if (getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_CAPTURE_PROCESSOR, null) != null) {
                    getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 35);
                } else {
                    getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 256);
                }
                ImageCapture imageCapture = new ImageCapture(getUseCaseConfig());
                Size size = (Size) getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_TARGET_RESOLUTION, null);
                if (size != null) {
                    imageCapture.setCropAspectRatio(new Rational(size.getWidth(), size.getHeight()));
                }
                if (((Integer) getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_MAX_CAPTURE_STAGES, 2)).intValue() >= 1) {
                    z = true;
                }
                Preconditions.checkArgument(z, "Maximum outstanding image count must be at least 1");
                Preconditions.checkNotNull((Executor) getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_IO_EXECUTOR, CameraXExecutors.ioExecutor()), "The IO executor can't be null");
                if (!getMutableConfig().containsOption(ImageCaptureConfig.OPTION_FLASH_MODE) || (intValue = ((Integer) getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_FLASH_MODE)).intValue()) == 0 || intValue == 1 || intValue == 2) {
                    return imageCapture;
                }
                throw new IllegalArgumentException("The flash mode is not allowed to set: " + intValue);
            }
            throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        }

        public Builder setCaptureMode(int i) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE, Integer.valueOf(i));
            return this;
        }

        public Builder setFlashMode(int i) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_FLASH_MODE, Integer.valueOf(i));
            return this;
        }

        public Builder setCaptureBundle(CaptureBundle captureBundle) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_CAPTURE_BUNDLE, captureBundle);
            return this;
        }

        public Builder setCaptureProcessor(CaptureProcessor captureProcessor) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_CAPTURE_PROCESSOR, captureProcessor);
            return this;
        }

        public Builder setBufferFormat(int i) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, Integer.valueOf(i));
            return this;
        }

        public Builder setMaxCaptureStages(int i) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_MAX_CAPTURE_STAGES, Integer.valueOf(i));
            return this;
        }

        public Builder setSupportedResolutions(List<Pair<Integer, Size[]>> list) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
            return this;
        }

        public Builder setTargetClass(Class<ImageCapture> cls) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_CLASS, cls);
            if (getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_TARGET_NAME, null) == null) {
                setTargetName(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        public Builder setTargetName(String str) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_NAME, str);
            return this;
        }

        public Builder setTargetAspectRatio(int i) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_ASPECT_RATIO, Integer.valueOf(i));
            return this;
        }

        public Builder setTargetRotation(int i) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_ROTATION, Integer.valueOf(i));
            return this;
        }

        public Builder setTargetResolution(Size size) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_RESOLUTION, size);
            return this;
        }

        public Builder setDefaultResolution(Size size) {
            getMutableConfig().insertOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, size);
            return this;
        }

        public Builder setMaxResolution(Size size) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_MAX_RESOLUTION, size);
            return this;
        }

        public Builder setImageReaderProxyProvider(ImageReaderProxyProvider imageReaderProxyProvider) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_IMAGE_READER_PROXY_PROVIDER, imageReaderProxyProvider);
            return this;
        }

        public Builder setSoftwareJpegEncoderRequested(boolean z) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER, Boolean.valueOf(z));
            return this;
        }

        public Builder setIoExecutor(Executor executor) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_IO_EXECUTOR, executor);
            return this;
        }

        public Builder setDefaultSessionConfig(SessionConfig sessionConfig) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_DEFAULT_SESSION_CONFIG, sessionConfig);
            return this;
        }

        public Builder setDefaultCaptureConfig(CaptureConfig captureConfig) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_DEFAULT_CAPTURE_CONFIG, captureConfig);
            return this;
        }

        public Builder setSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_SESSION_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        public Builder setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_CAPTURE_CONFIG_UNPACKER, optionUnpacker);
            return this;
        }

        public Builder setCameraSelector(CameraSelector cameraSelector) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, cameraSelector);
            return this;
        }

        public Builder setSurfaceOccupancyPriority(int i) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, Integer.valueOf(i));
            return this;
        }

        public Builder setUseCaseEventCallback(UseCase.EventCallback eventCallback) {
            getMutableConfig().insertOption(ImageCaptureConfig.OPTION_USE_CASE_EVENT_CALLBACK, eventCallback);
            return this;
        }

        public Builder setAttachedUseCasesUpdateListener(Consumer<Collection<UseCase>> consumer) {
            getMutableConfig().insertOption(UseCaseConfig.OPTION_ATTACHED_USE_CASES_UPDATE_LISTENER, consumer);
            return this;
        }
    }
}
