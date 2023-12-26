package io.agora.rtc.video;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.yalantis.ucrop.view.CropImageView;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.RendererCommon;
import io.agora.rtc.gl.SurfaceTextureHelper;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.internal.DeviceUtils;
import io.agora.rtc.internal.Logging;
import io.agora.rtc.utils.ThreadUtils;
import io.agora.rtc.video.VideoCapture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.DebugKt;

public class VideoCaptureCamera extends VideoCapture implements Camera.PreviewCallback, SurfaceTextureHelper.OnTextureFrameAvailableListener {
    private static final long CAMERA_OPEN_REQUEST_INTERVAL = 2000;
    private static final int NUM_OF_CAPTURE_BUFFERS = 3;
    private static final String TAG = "CAMERA1";
    private static final boolean VERBOSE = false;
    private int[] distanceArray = null;
    /* access modifiers changed from: private */
    public boolean faceDetectEnabled = false;
    private boolean isCaptureRunning = false;
    private boolean isCaptureStarted = false;
    private boolean isFaceDetectionStarted = false;
    private boolean isSurfaceReady = false;
    private String mAntiBandingMode = DebugKt.DEBUG_PROPERTY_VALUE_AUTO;
    protected Camera mCamera;
    private HandlerThread mCameraPreviewHandlerThread = null;
    private int mCaptureFormat = 17;
    private int mCaptureFps = -1;
    private int mCaptureHeight = -1;
    /* access modifiers changed from: private */
    public ReentrantLock mCaptureLock = new ReentrantLock();
    private int mCaptureWidth = -1;
    private SurfaceTexture mDummySurfaceTexture = null;
    /* access modifiers changed from: private */
    public boolean mIsAutoFaceFocusEnabled = false;
    private final boolean mIsCameraFacingFront;
    /* access modifiers changed from: private */
    public Object mObjectLock = new Object();
    protected ReentrantLock mPreviewBufferLock = new ReentrantLock();
    private Handler mPreviewHandler = null;
    private RectF[] rectArray = null;

    static String getCaptureName() {
        return "camera1";
    }

    private String toCamera1ABMode(int i) {
        return i != 0 ? i != 1 ? i != 2 ? DebugKt.DEBUG_PROPERTY_VALUE_AUTO : "60hz" : "50hz" : DebugKt.DEBUG_PROPERTY_VALUE_OFF;
    }

    VideoCaptureCamera(Context context, int i, int i2, EglBase.Context context2, long j) {
        super(context, i, i2, context2, j);
        this.mIsCameraFacingFront = isCameraFacingFront(i);
    }

    static boolean isCameraFacingFront(int i) {
        Camera.CameraInfo cameraInfo = getCameraInfo(i);
        if (cameraInfo == null || cameraInfo.facing == 1) {
            return true;
        }
        return false;
    }

    protected static Camera.CameraInfo getCameraInfo(int i) {
        if (i >= 0 && i <= Camera.getNumberOfCameras() - 1) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            try {
                Camera.getCameraInfo(i, cameraInfo);
                return cameraInfo;
            } catch (RuntimeException e) {
                Logging.e(TAG, "getCameraInfo: Camera.getCameraInfo: ", e);
            }
        }
        return null;
    }

    public static int getFrontCameraIndex() {
        try {
            return Camera.getNumberOfCameras() > 1 ? 1 : 0;
        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return 0;
        }
    }

    static int getNumberOfCameras() {
        int numberOfCameras = Camera.getNumberOfCameras();
        Logging.e(TAG, "camera1 listCount:" + numberOfCameras);
        return numberOfCameras;
    }

    static String getName(int i) {
        Camera.CameraInfo cameraInfo = getCameraInfo(i);
        if (cameraInfo == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("camera ");
        sb.append(i);
        sb.append(", facing ");
        sb.append(cameraInfo.facing == 1 ? "front" : "back");
        return sb.toString();
    }

    static int getSensorOrientation(int i) {
        Camera.CameraInfo cameraInfo = getCameraInfo(i);
        if (cameraInfo == null) {
            return -1;
        }
        return cameraInfo.orientation;
    }

    public int UnRegisterNativeHandle() {
        Logging.d(TAG, "UnRegisterNativeHandle called");
        this.mNativeVideoCaptureDeviceAndroid = 0;
        return 0;
    }

    public int allocate() {
        if (this.mCameraPreviewHandlerThread == null) {
            HandlerThread handlerThread = new HandlerThread("camera-preview-thread");
            this.mCameraPreviewHandlerThread = handlerThread;
            handlerThread.start();
            if (this.mCameraPreviewHandlerThread != null) {
                this.mPreviewHandler = new Handler(this.mCameraPreviewHandlerThread.getLooper());
            }
        }
        Handler handler = this.mPreviewHandler;
        if (handler == null) {
            return 0;
        }
        ThreadUtils.invokeAtFrontUninterruptibly(handler, (Runnable) new Runnable() {
            public void run() {
                int unused = VideoCaptureCamera.this.allocate_l();
            }
        });
        return 0;
    }

    /* access modifiers changed from: private */
    public int allocate_l() {
        try {
            this.mCamera = Camera.open(this.mId);
            Camera.CameraInfo cameraInfo = getCameraInfo(this.mId);
            if (cameraInfo == null) {
                this.mCamera.release();
                this.mCamera = null;
                return -2;
            }
            if (VideoCapture.fetchCapability(this.mId, this.mContext, getCaptureName()) == null) {
                createCapabilities();
            }
            this.mCameraNativeOrientation = cameraInfo.orientation;
            if (this.mNativeVideoCaptureDeviceAndroid != 0) {
                this.mIsAutoFaceFocusEnabled = isAutoFaceFocusEnabled(this.mNativeVideoCaptureDeviceAndroid);
            }
            this.faceDetectEnabled = isFaceDetectionEnabled(this.mNativeVideoCaptureDeviceAndroid);
            return 0;
        } catch (RuntimeException e) {
            Logging.e(TAG, "allocate: Camera.open: ", e);
            return -1;
        }
    }

    public int setCaptureFormat(int i, int i2, boolean z) {
        Logging.i(TAG, "setCaptureFormat: " + i + " type: " + i2 + " force texture oes: " + z);
        VideoCapture.FORCE_ENC_TEXTURE_OES = z;
        this.mCaptureOutputDataType = translateToCaptureOutputDataType(i2);
        int translateToAndroidFormat = translateToAndroidFormat(i);
        this.mCaptureFormat = translateToAndroidFormat;
        if (translateToAndroidFormat != 0) {
            return 0;
        }
        Logging.e(TAG, "setCaptureFormat failed, unkonwn format: " + i);
        return -1;
    }

    private int tryStartCapture(int i, int i2, int i3) {
        int i4;
        if (this.mCamera == null) {
            Logging.e(TAG, "Camera not initialized %d" + this.mId);
            return -1;
        }
        Logging.i(TAG, "tryStartCapture: " + i + "*" + i2 + ", frameRate: " + i3 + ", isCaptureRunning: " + this.isCaptureRunning + ", isSurfaceReady: " + this.isSurfaceReady + ", isCaptureStarted: " + this.isCaptureStarted + ", outputDataType: " + this.mCaptureOutputDataType);
        if (this.isCaptureRunning || !this.isCaptureStarted) {
            Logging.w(TAG, "tryStartCapture return");
            return 0;
        }
        Camera.Parameters parameters = this.mCamera.getParameters();
        parameters.setPreviewSize(i, i2);
        parameters.setPreviewFormat(this.mCaptureFormat);
        if (this.mPQFirst < 1) {
            Logging.i(TAG, "camera1::fps first");
            List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
            if (supportedPreviewFpsRange.size() <= 0) {
                parameters.setPreviewFrameRate(i3);
            } else {
                int i5 = 0;
                while (true) {
                    if (i5 >= supportedPreviewFpsRange.size()) {
                        break;
                    } else if (supportedPreviewFpsRange.get(i5)[0] >= i3 * 1000) {
                        parameters.setPreviewFpsRange(supportedPreviewFpsRange.get(i5)[0], supportedPreviewFpsRange.get(i5)[1]);
                        break;
                    } else {
                        i5++;
                    }
                }
                if (i5 == supportedPreviewFpsRange.size()) {
                    int i6 = i5 - 1;
                    parameters.setPreviewFpsRange(supportedPreviewFpsRange.get(i6)[0], supportedPreviewFpsRange.get(i6)[1]);
                }
            }
        } else {
            Logging.i(TAG, "camera1::PQ first");
            parameters.setPreviewFrameRate(i3);
        }
        setAdvancedCameraParameters(parameters);
        setDeviceSpecificParameters(parameters);
        this.mCamera.setParameters(parameters);
        if (this.mCaptureOutputDataType == 0 || this.mCaptureOutputDataType == 2) {
            i4 = (((i * i2) * ImageFormat.getBitsPerPixel(this.mCaptureFormat)) / 8) + 4096;
            for (int i7 = 0; i7 < 3; i7++) {
                this.mCamera.addCallbackBuffer(new byte[i4]);
            }
            this.mCamera.setPreviewCallbackWithBuffer(this);
        } else {
            i4 = 0;
        }
        this.mCamera.setErrorCallback(new Camera.ErrorCallback() {
            public void onError(int i, Camera camera) {
                Logging.e(VideoCaptureCamera.TAG, "onError: error code " + i);
                if (VideoCaptureCamera.this.mCamera != null) {
                    VideoCaptureCamera.this.stopCapture();
                    VideoCaptureCamera.this.mCaptureLock.lock();
                    try {
                        if (VideoCaptureCamera.this.mCamera != null) {
                            VideoCaptureCamera.this.mCamera.release();
                            VideoCaptureCamera.this.mCamera = null;
                        }
                    } catch (Exception e) {
                        Logging.e(VideoCaptureCamera.TAG, "Camera release failed, " + e);
                    } catch (Throwable th) {
                        VideoCaptureCamera.this.mCaptureLock.unlock();
                        throw th;
                    }
                    VideoCaptureCamera.this.mCaptureLock.unlock();
                }
                if (VideoCaptureCamera.this.mNativeVideoCaptureDeviceAndroid != 0) {
                    int i2 = VideoCapture.VideoCaptureEvent.kCameraErrorRuntimeUnknown;
                    if (i == 2) {
                        i2 = 6;
                    } else if (i == 100) {
                        i2 = 5;
                    }
                    VideoCaptureCamera videoCaptureCamera = VideoCaptureCamera.this;
                    videoCaptureCamera.onCameraError(videoCaptureCamera.mNativeVideoCaptureDeviceAndroid, i2);
                }
            }
        });
        this.mCamera.startPreview();
        if (isAutoFaceFocusSupported()) {
            this.mCamera.setFaceDetectionListener(new Camera.FaceDetectionListener() {
                private long mLastFocusedTs;

                public void onFaceDetection(Camera.Face[] faceArr, Camera camera) {
                    if (VideoCaptureCamera.this.faceDetectEnabled) {
                        VideoCaptureCamera.this.notifyFaceDetection(faceArr);
                    }
                    if (faceArr != null && faceArr.length != 0 && camera != null && VideoCaptureCamera.this.mIsAutoFaceFocusEnabled) {
                        if (System.currentTimeMillis() - this.mLastFocusedTs < 3000) {
                            if (faceArr[0].score > 20) {
                                VideoCaptureCamera.this.notifyCameraFocusAreaChanged(faceArr[0].rect);
                            }
                        } else if (faceArr[0].score <= 50) {
                            Logging.i(VideoCaptureCamera.TAG, "face score = " + faceArr[0].score);
                        } else {
                            try {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(new Camera.Area(faceArr[0].rect, 1000));
                                if (camera.getParameters().getMaxNumFocusAreas() > 0) {
                                    camera.getParameters().setFocusAreas(arrayList);
                                }
                                if (camera.getParameters().getMaxNumMeteringAreas() > 0) {
                                    camera.getParameters().setMeteringAreas(arrayList);
                                }
                                VideoCaptureCamera.this.notifyCameraFocusAreaChanged(faceArr[0].rect);
                                camera.autoFocus(new Camera.AutoFocusCallback() {
                                    public void onAutoFocus(boolean z, Camera camera) {
                                        Logging.d(VideoCaptureCamera.TAG, "auto face focus called api1 every 3 seconds");
                                        if (camera != null) {
                                            try {
                                                camera.cancelAutoFocus();
                                            } catch (RuntimeException e) {
                                                Logging.w(VideoCaptureCamera.TAG, "Exception in cancelAutoFocus: " + Log.getStackTraceString(e));
                                            }
                                        }
                                    }
                                });
                                this.mLastFocusedTs = System.currentTimeMillis();
                            } catch (RuntimeException e) {
                                Logging.w(VideoCaptureCamera.TAG, "Exception in onFaceDetection callback: " + Log.getStackTraceString(e));
                            }
                        }
                    }
                }
            });
            if (this.mIsAutoFaceFocusEnabled || this.faceDetectEnabled) {
                startFaceDetection();
            }
        } else if (isFaceDetectedSupported()) {
            this.mCamera.setFaceDetectionListener(new Camera.FaceDetectionListener() {
                public void onFaceDetection(Camera.Face[] faceArr, Camera camera) {
                    if (VideoCaptureCamera.this.faceDetectEnabled) {
                        VideoCaptureCamera.this.notifyFaceDetection(faceArr);
                    }
                }
            });
            if (this.faceDetectEnabled) {
                startFaceDetection();
            }
        }
        this.mPreviewBufferLock.lock();
        this.mExpectedRawBufferSize = i4;
        this.isCaptureRunning = true;
        this.mPreviewBufferLock.unlock();
        Camera.Parameters parameters2 = this.mCamera.getParameters();
        Logging.i(TAG, "Params: " + parameters2.flatten());
        return 0;
    }

    private void startFaceDetection() {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            ThreadUtils.invokeAtFrontUninterruptibly(handler, (Runnable) new Runnable() {
                public void run() {
                    VideoCaptureCamera.this.startFaceDetection_l();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void startFaceDetection_l() {
        if (this.mCamera != null) {
            try {
                Logging.i(TAG, "enable face detection");
                this.mCamera.startFaceDetection();
                this.isFaceDetectionStarted = true;
            } catch (Exception e) {
                Logging.e(TAG, "start face detection failed:" + e);
                this.mCamera.stopFaceDetection();
                this.isFaceDetectionStarted = false;
            }
        }
    }

    private void stopFaceDetection() {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            ThreadUtils.invokeAtFrontUninterruptibly(handler, (Runnable) new Runnable() {
                public void run() {
                    VideoCaptureCamera.this.stopFaceDetection_l();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void stopFaceDetection_l() {
        if (this.mCamera != null) {
            Logging.i(TAG, "disable face detection");
            this.mCamera.stopFaceDetection();
            this.isFaceDetectionStarted = false;
        }
    }

    /* access modifiers changed from: private */
    public void notifyCameraFocusAreaChanged(Rect rect) {
        boolean z = true;
        if (this.mId != 1) {
            z = false;
        }
        RectF normalizedFaceRect = CoordinatesTransform.normalizedFaceRect(rect, 0, z);
        float f = normalizedFaceRect.left;
        float f2 = normalizedFaceRect.top;
        float width = normalizedFaceRect.width();
        float height = normalizedFaceRect.height();
        Logging.d(TAG, "auto face focus left =" + normalizedFaceRect.left + " top = " + normalizedFaceRect.top + " right = " + normalizedFaceRect.right + " bottom = " + normalizedFaceRect.bottom);
        NotifyCameraFocusAreaChanged(f, f2, width, height, this.mNativeVideoCaptureDeviceAndroid);
    }

    /* access modifiers changed from: private */
    public void notifyFaceDetection(Camera.Face[] faceArr) {
        this.rectArray = null;
        boolean z = true;
        if (this.mId != 1) {
            z = false;
        }
        if (faceArr != null && faceArr.length > 0) {
            int length = faceArr.length;
            this.rectArray = new RectF[length];
            this.distanceArray = new int[length];
            for (int i = 0; i < length; i++) {
                this.rectArray[i] = CoordinatesTransform.normalizedFaceRect(faceArr[i].rect, 0, z);
                this.distanceArray[i] = 5;
            }
            NotifyFaceDetection(this.mCaptureWidth, this.mCaptureHeight, this.rectArray, (long) length, this.mNativeVideoCaptureDeviceAndroid);
        }
    }

    public int setZoom(final float f) {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Integer) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Integer>() {
                public Integer call() {
                    return Integer.valueOf(VideoCaptureCamera.this.setZoom_l(f));
                }
            })).intValue();
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public int setZoom_l(float f) {
        if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
            return -1;
        }
        int i = (int) ((f * 100.0f) + 0.5f);
        List<Integer> zoomRatios = getZoomRatios();
        if (zoomRatios == null) {
            return -1;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= zoomRatios.size()) {
                i2 = 0;
                break;
            } else if (i <= zoomRatios.get(i2).intValue()) {
                break;
            } else {
                i2++;
            }
        }
        if (this.mCamera != null) {
            Camera.Parameters cameraParameters = getCameraParameters();
            if (isZoomSupported(cameraParameters)) {
                if (i2 > cameraParameters.getMaxZoom()) {
                    Logging.w(TAG, "zoom value is larger than maxZoom value");
                    return -1;
                }
                cameraParameters.setZoom(i2);
                try {
                    this.mCamera.setParameters(cameraParameters);
                } catch (Exception e) {
                    Logging.w(TAG, "setParameters failed, zoomLevel: " + i2 + ", " + e);
                }
            }
        }
        return 0;
    }

    public float getMaxZoom() {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Float) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Float>() {
                public Float call() {
                    return Float.valueOf(VideoCaptureCamera.this.getMaxZoom_l());
                }
            })).floatValue();
        }
        return -1.0f;
    }

    /* access modifiers changed from: private */
    public float getMaxZoom_l() {
        if (this.mCamera == null) {
            return -1.0f;
        }
        Camera.Parameters cameraParameters = getCameraParameters();
        int i = 0;
        if (isZoomSupported(cameraParameters)) {
            i = cameraParameters.getMaxZoom();
        }
        List<Integer> zoomRatios = getZoomRatios();
        if (zoomRatios == null || zoomRatios.size() <= i) {
            return -1.0f;
        }
        return ((float) zoomRatios.get(i).intValue()) / 100.0f;
    }

    public int setTorchMode(final boolean z) {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Integer) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Integer>() {
                public Integer call() {
                    return Integer.valueOf(VideoCaptureCamera.this.setTorchMode_l(z));
                }
            })).intValue();
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public int setTorchMode_l(boolean z) {
        Camera.Parameters cameraParameters;
        if (this.mCamera == null || (cameraParameters = getCameraParameters()) == null) {
            return -2;
        }
        List<String> supportedFlashModes = cameraParameters.getSupportedFlashModes();
        if (supportedFlashModes == null || !supportedFlashModes.contains("torch")) {
            return -1;
        }
        if (z) {
            cameraParameters.setFlashMode("torch");
        } else {
            cameraParameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
        }
        this.mCamera.setParameters(cameraParameters);
        return 0;
    }

    public int setFocus(final float f, final float f2, final boolean z) {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Integer) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Integer>() {
                public Integer call() {
                    return Integer.valueOf(VideoCaptureCamera.this.setFocus_l(f, f2, z));
                }
            })).intValue();
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public int setFocus_l(float f, float f2, boolean z) {
        Logging.d(TAG, "setFocus called camera api1");
        if (this.mCamera == null) {
            return -1;
        }
        if (f < CropImageView.DEFAULT_ASPECT_RATIO || f > 1.0f || f2 < CropImageView.DEFAULT_ASPECT_RATIO || f2 > 1.0f) {
            Logging.e(TAG, "set focus unreasonable inputs");
            return -1;
        }
        Rect calculateTapArea = calculateTapArea(f, f2, 1.0f);
        Rect calculateTapArea2 = calculateTapArea(f, f2, 1.5f);
        try {
            this.mCamera.cancelAutoFocus();
        } catch (RuntimeException e) {
            Logging.w(TAG, "Failed to cancle AutoFocus" + e);
        }
        Camera.Parameters cameraParameters = getCameraParameters();
        if (cameraParameters == null) {
            return -1;
        }
        if (cameraParameters.getMaxNumFocusAreas() > 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Camera.Area(calculateTapArea, 800));
            cameraParameters.setFocusAreas(arrayList);
        } else {
            Logging.i(TAG, "focus areas not supported");
        }
        if (cameraParameters.getMaxNumMeteringAreas() > 0) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new Camera.Area(calculateTapArea2, 800));
            cameraParameters.setMeteringAreas(arrayList2);
        } else {
            Logging.i(TAG, "metering areas not supported");
        }
        final String focusMode = cameraParameters.getFocusMode();
        if (isSupported("macro", cameraParameters.getSupportedFocusModes())) {
            cameraParameters.setFocusMode("macro");
            synchronized (this.mObjectLock) {
                this.mCamera.setParameters(cameraParameters);
            }
        } else {
            Logging.i("focus", "FOCUS_MODE_MACRO is not supported");
        }
        try {
            this.mCamera.autoFocus(new Camera.AutoFocusCallback() {
                public void onAutoFocus(boolean z, Camera camera) {
                    if (VideoCaptureCamera.this.mCamera != null) {
                        Camera.Parameters parameters = camera.getParameters();
                        parameters.setFocusMode(focusMode);
                        synchronized (VideoCaptureCamera.this.mObjectLock) {
                            camera.setParameters(parameters);
                        }
                    }
                }
            });
            if (this.mNativeVideoCaptureDeviceAndroid == 0) {
                return 0;
            }
            NotifyCameraFocusAreaChanged(f, f2, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, this.mNativeVideoCaptureDeviceAndroid);
            return 0;
        } catch (Exception e2) {
            Logging.w(TAG, "mCamera.autoFocus Exception: " + e2);
            return -1;
        }
    }

    public int setExposure(final float f, final float f2, final boolean z) {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Integer) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Integer>() {
                public Integer call() {
                    return Integer.valueOf(VideoCaptureCamera.this.setExposure_l(f, f2, z));
                }
            })).intValue();
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public int setExposure_l(float f, float f2, boolean z) {
        Logging.d(TAG, "setExposure called camera api1 x = " + f + " y = " + f2);
        if (this.mCamera == null) {
            return -1;
        }
        if (f < CropImageView.DEFAULT_ASPECT_RATIO || f > 1.0f || f2 < CropImageView.DEFAULT_ASPECT_RATIO || f2 > 1.0f) {
            Logging.e(TAG, "set exposure unreasonable inputs");
            return -1;
        }
        Rect calculateTapArea = calculateTapArea(f, f2, 1.5f);
        if (this.mCamera != null) {
            Camera.Parameters cameraParameters = getCameraParameters();
            if (cameraParameters == null) {
                return -1;
            }
            if (cameraParameters.getMaxNumMeteringAreas() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Camera.Area(calculateTapArea, 800));
                cameraParameters.setMeteringAreas(arrayList);
            } else {
                Logging.i(TAG, "metering areas not supported");
            }
            try {
                this.mCamera.setParameters(cameraParameters);
                this.mCamera.startPreview();
            } catch (Exception e) {
                Logging.e(TAG, "setExposure failed, " + e);
                return -1;
            }
        }
        if (this.mNativeVideoCaptureDeviceAndroid == 0) {
            return 0;
        }
        NotifyCameraExposureAreaChanged(f, f2, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, this.mNativeVideoCaptureDeviceAndroid);
        return 0;
    }

    public int setAutoFaceFocus(boolean z) {
        Logging.d(TAG, "setAutoFaceFocus: " + z);
        boolean z2 = this.mIsAutoFaceFocusEnabled != z;
        this.mIsAutoFaceFocusEnabled = z;
        if (isAutoFaceFocusSupported() && z2) {
            boolean z3 = this.mIsAutoFaceFocusEnabled;
            if (z3 && !this.isFaceDetectionStarted) {
                startFaceDetection();
            } else if (!z3 && this.isFaceDetectionStarted && !this.faceDetectEnabled) {
                stopFaceDetection();
            }
        }
        return 0;
    }

    public int setFaceDetection(boolean z) {
        Logging.d(TAG, "setFaceDetection: " + z);
        boolean z2 = this.faceDetectEnabled != z;
        this.faceDetectEnabled = z;
        if (isFaceDetectedSupported() && z2) {
            boolean z3 = this.faceDetectEnabled;
            if (z3 && !this.isFaceDetectionStarted) {
                startFaceDetection();
            } else if (!z3 && this.isFaceDetectionStarted && !this.mIsAutoFaceFocusEnabled) {
                stopFaceDetection();
            }
        }
        return 0;
    }

    public int startCapture(final int i, final int i2, final int i3) {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Integer) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Integer>() {
                public Integer call() {
                    return Integer.valueOf(VideoCaptureCamera.this.startCapture_l(i, i2, i3));
                }
            })).intValue();
        }
        return -1;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00be A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int startCapture_l(int r10, int r11, int r12) {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "startCapture, w="
            r0.append(r1)
            r0.append(r10)
            java.lang.String r1 = ", h="
            r0.append(r1)
            r0.append(r11)
            java.lang.String r1 = ", fps="
            r0.append(r1)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "CAMERA1"
            io.agora.rtc.internal.Logging.i(r1, r0)
            android.hardware.Camera r0 = r9.mCamera
            r2 = -1
            if (r0 != 0) goto L_0x0031
            java.lang.String r10 = "startCapture: camera is null!!"
            io.agora.rtc.internal.Logging.e(r1, r10)
            return r2
        L_0x0031:
            int r0 = r9.mCaptureOutputDataType
            r3 = 0
            r4 = 2
            r5 = 1
            r6 = 0
            if (r0 == r5) goto L_0x003d
            int r0 = r9.mCaptureOutputDataType
            if (r0 != r4) goto L_0x0053
        L_0x003d:
            io.agora.rtc.gl.EglBase$Context r0 = r9.mShareContext
            r7 = 6
            java.lang.String r8 = "CameraTexThread"
            io.agora.rtc.gl.SurfaceTextureHelper r0 = io.agora.rtc.gl.SurfaceTextureHelper.create(r8, r0, r7)
            r9.mSurfaceTextureHelper = r0
            io.agora.rtc.gl.SurfaceTextureHelper r0 = r9.mSurfaceTextureHelper
            if (r0 != 0) goto L_0x0055
            java.lang.String r0 = "Failed to create SurfaceTextureHelper, force fallback to raw data type"
            io.agora.rtc.internal.Logging.e(r1, r0)
            r9.mCaptureOutputDataType = r3
        L_0x0053:
            r0 = r6
            goto L_0x0080
        L_0x0055:
            io.agora.rtc.gl.SurfaceTextureHelper r0 = r9.mSurfaceTextureHelper
            android.graphics.SurfaceTexture r0 = r0.getSurfaceTexture()
            r0.setDefaultBufferSize(r10, r11)
            io.agora.rtc.gl.SurfaceTextureHelper r0 = r9.mSurfaceTextureHelper
            r0.startListening(r9)
            io.agora.rtc.gl.SurfaceTextureHelper r0 = r9.mSurfaceTextureHelper
            io.agora.rtc.gl.EglBase$Context r0 = r0.getEglContext()
            r9.mEglContext = r0
            io.agora.rtc.gl.SurfaceTextureHelper r0 = r9.mSurfaceTextureHelper
            android.graphics.SurfaceTexture r0 = r0.getSurfaceTexture()
            int r7 = r9.mCaptureOutputDataType
            if (r7 != r4) goto L_0x0080
            io.agora.rtc.video.VideoCapture$TextureAndRawBufferSynchronizer r4 = r9.mTextureAndRawBufferSynchronizer
            if (r4 != 0) goto L_0x0080
            io.agora.rtc.video.VideoCapture$TextureAndRawBufferSynchronizer r4 = new io.agora.rtc.video.VideoCapture$TextureAndRawBufferSynchronizer
            r4.<init>()
            r9.mTextureAndRawBufferSynchronizer = r4
        L_0x0080:
            int r4 = r9.mCaptureOutputDataType
            if (r4 != 0) goto L_0x0099
            android.graphics.SurfaceTexture r0 = r9.mDummySurfaceTexture
            if (r0 != 0) goto L_0x0097
            android.graphics.SurfaceTexture r0 = new android.graphics.SurfaceTexture     // Catch:{ OutOfResourcesException -> 0x0092 }
            r4 = 42
            r0.<init>(r4)     // Catch:{ OutOfResourcesException -> 0x0092 }
            r9.mDummySurfaceTexture = r0     // Catch:{ OutOfResourcesException -> 0x0092 }
            goto L_0x0097
        L_0x0092:
            java.lang.String r0 = "failed to create dummy SurfaceTexture!"
            io.agora.rtc.internal.Logging.e(r1, r0)
        L_0x0097:
            android.graphics.SurfaceTexture r0 = r9.mDummySurfaceTexture
        L_0x0099:
            if (r0 != 0) goto L_0x009d
        L_0x009b:
            r3 = r2
            goto L_0x00bc
        L_0x009d:
            java.util.concurrent.locks.ReentrantLock r4 = r9.mCaptureLock
            r4.lock()
            android.hardware.Camera r4 = r9.mCamera     // Catch:{ Exception -> 0x00af }
            r4.setPreviewTexture(r0)     // Catch:{ Exception -> 0x00af }
            java.util.concurrent.locks.ReentrantLock r0 = r9.mCaptureLock
            r0.unlock()
            goto L_0x00bc
        L_0x00ad:
            r10 = move-exception
            goto L_0x00f4
        L_0x00af:
            java.lang.String r0 = "failed to set preview texture, invalid surfaceTexture!"
            io.agora.rtc.internal.Logging.e(r1, r0)     // Catch:{ all -> 0x00ad }
            r9.mDummySurfaceTexture = r6     // Catch:{ all -> 0x00ad }
            java.util.concurrent.locks.ReentrantLock r0 = r9.mCaptureLock
            r0.unlock()
            goto L_0x009b
        L_0x00bc:
            if (r3 == 0) goto L_0x00bf
            return r3
        L_0x00bf:
            java.util.concurrent.locks.ReentrantLock r0 = r9.mCaptureLock
            r0.lock()
            r9.isCaptureStarted = r5
            r9.mCaptureWidth = r10
            r9.mCaptureHeight = r11
            r9.mCaptureFps = r12
            int r2 = r9.tryStartCapture(r10, r11, r12)     // Catch:{ all -> 0x00d6 }
        L_0x00d0:
            java.util.concurrent.locks.ReentrantLock r10 = r9.mCaptureLock
            r10.unlock()
            goto L_0x00ec
        L_0x00d6:
            r10 = move-exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ed }
            r11.<init>()     // Catch:{ all -> 0x00ed }
            java.lang.String r12 = "try start capture failed "
            r11.append(r12)     // Catch:{ all -> 0x00ed }
            r11.append(r10)     // Catch:{ all -> 0x00ed }
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x00ed }
            io.agora.rtc.internal.Logging.e(r1, r10)     // Catch:{ all -> 0x00ed }
            goto L_0x00d0
        L_0x00ec:
            return r2
        L_0x00ed:
            r10 = move-exception
            java.util.concurrent.locks.ReentrantLock r11 = r9.mCaptureLock
            r11.unlock()
            throw r10
        L_0x00f4:
            java.util.concurrent.locks.ReentrantLock r11 = r9.mCaptureLock
            r11.unlock()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.video.VideoCaptureCamera.startCapture_l(int, int, int):int");
    }

    public int stopCapture() {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Integer) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Integer>() {
                public Integer call() {
                    return Integer.valueOf(VideoCaptureCamera.this.stopCapture_l());
                }
            })).intValue();
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public int stopCapture_l() {
        int i;
        if (!this.isCaptureStarted) {
            Logging.w(TAG, "already stop capture");
            return 0;
        }
        try {
            if (this.isFaceDetectionStarted) {
                stopFaceDetection();
                this.mCamera.setFaceDetectionListener((Camera.FaceDetectionListener) null);
            }
        } catch (RuntimeException e) {
            Logging.e(TAG, "Failed to stop face detection", e);
        }
        try {
            this.mCamera.cancelAutoFocus();
        } catch (RuntimeException e2) {
            Logging.e(TAG, "Failed to cancle AutoFocus", e2);
        }
        try {
            this.mPreviewBufferLock.lock();
            this.isCaptureRunning = false;
            this.mCamera.stopPreview();
            this.mCamera.setErrorCallback((Camera.ErrorCallback) null);
            AgoraVideoDebugger.reset();
            this.mDroppedTextureBufferCount = 0;
            if (this.mTextureAndRawBufferSynchronizer != null) {
                this.mTextureAndRawBufferSynchronizer.reset();
            }
            if (this.mSurfaceTextureHelper != null) {
                this.mSurfaceTextureHelper.stopListening();
                this.mSurfaceTextureHelper.dispose();
                this.mSurfaceTextureHelper = null;
            }
            this.mEglContext = null;
            if (this.mCaptureOutputDataType == 0 || this.mCaptureOutputDataType == 2) {
                this.mCamera.setPreviewCallbackWithBuffer((Camera.PreviewCallback) null);
            }
            i = 0;
        } catch (RuntimeException e3) {
            Logging.e(TAG, "Failed to stop camera", e3);
            i = -1;
        }
        this.mPreviewBufferLock.unlock();
        if (i == 0) {
            this.isCaptureStarted = false;
        }
        return i;
    }

    public boolean isTorchSupported() {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Boolean) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Boolean>() {
                public Boolean call() {
                    return Boolean.valueOf(VideoCaptureCamera.this.isTorchSupported_l());
                }
            })).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean isTorchSupported_l() {
        Camera.Parameters cameraParameters;
        if (this.mCamera == null || (cameraParameters = getCameraParameters()) == null) {
            return false;
        }
        return isSupported("torch", cameraParameters.getSupportedFlashModes());
    }

    public boolean isFocusSupported() {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Boolean) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Boolean>() {
                public Boolean call() {
                    return Boolean.valueOf(VideoCaptureCamera.this.isFocusSupported_l());
                }
            })).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean isFocusSupported_l() {
        Camera.Parameters cameraParameters;
        if (this.mCamera == null || (cameraParameters = getCameraParameters()) == null || cameraParameters.getMaxNumFocusAreas() <= 0 || !isSupported(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, cameraParameters.getSupportedFocusModes())) {
            return false;
        }
        return true;
    }

    public boolean isExposureSupported() {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Boolean) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Boolean>() {
                public Boolean call() {
                    return Boolean.valueOf(VideoCaptureCamera.this.isExposureSupported_l());
                }
            })).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean isExposureSupported_l() {
        Camera.Parameters cameraParameters;
        if (this.mCamera == null || (cameraParameters = getCameraParameters()) == null || cameraParameters.getMaxNumMeteringAreas() <= 0) {
            return false;
        }
        return true;
    }

    public boolean isZoomSupported() {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Boolean) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Boolean>() {
                public Boolean call() {
                    return Boolean.valueOf(VideoCaptureCamera.this.isZoomSupported_l());
                }
            })).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean isZoomSupported_l() {
        Camera.Parameters cameraParameters;
        if (this.mCamera == null || (cameraParameters = getCameraParameters()) == null) {
            return false;
        }
        return cameraParameters.isZoomSupported();
    }

    public boolean isAutoFaceFocusSupported() {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Boolean) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Boolean>() {
                public Boolean call() {
                    return Boolean.valueOf(VideoCaptureCamera.this.isAutoFaceFocusSupported_l());
                }
            })).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = getCameraParameters();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isAutoFaceFocusSupported_l() {
        /*
            r2 = this;
            android.hardware.Camera r0 = r2.mCamera
            if (r0 == 0) goto L_0x0024
            android.hardware.Camera$Parameters r0 = r2.getCameraParameters()
            if (r0 == 0) goto L_0x0024
            int r1 = r0.getMaxNumDetectedFaces()
            if (r1 <= 0) goto L_0x0024
            int r1 = r0.getMaxNumFocusAreas()
            if (r1 <= 0) goto L_0x0024
            java.util.List r0 = r0.getSupportedFocusModes()
            java.lang.String r1 = "auto"
            boolean r0 = isSupported(r1, r0)
            if (r0 == 0) goto L_0x0024
            r0 = 1
            return r0
        L_0x0024:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.video.VideoCaptureCamera.isAutoFaceFocusSupported_l():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = getCameraParameters();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isFaceDetectedSupported() {
        /*
            r1 = this;
            android.hardware.Camera r0 = r1.mCamera
            if (r0 == 0) goto L_0x0012
            android.hardware.Camera$Parameters r0 = r1.getCameraParameters()
            if (r0 == 0) goto L_0x0012
            int r0 = r0.getMaxNumDetectedFaces()
            if (r0 <= 0) goto L_0x0012
            r0 = 1
            return r0
        L_0x0012:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.video.VideoCaptureCamera.isFaceDetectedSupported():boolean");
    }

    public void deallocate() {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            ThreadUtils.invokeAtFrontUninterruptibly(handler, (Runnable) new Runnable() {
                public void run() {
                    VideoCaptureCamera.this.deallocate_l();
                }
            });
        }
        Handler handler2 = this.mPreviewHandler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
        }
        HandlerThread handlerThread = this.mCameraPreviewHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mCameraPreviewHandlerThread = null;
            this.mPreviewHandler = null;
        }
    }

    /* access modifiers changed from: private */
    public void deallocate_l() {
        this.mNativeVideoCaptureDeviceAndroid = 0;
        stopCapture();
        this.mCaptureLock.lock();
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.release();
            this.mCamera = null;
        }
        this.mCaptureLock.unlock();
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        try {
            this.mPreviewBufferLock.lock();
            if (bArr != null) {
                if (this.isCaptureRunning) {
                    if (bArr.length == this.mExpectedRawBufferSize && this.mNativeVideoCaptureDeviceAndroid != 0) {
                        onRawBufferAvailable(bArr, this.mExpectedRawBufferSize);
                    } else if (this.mNativeVideoCaptureDeviceAndroid == 0) {
                        Logging.w(TAG, "warning mNativeVideoCaptureDeviceAndroid = 0, error");
                    }
                    if (camera != null && this.isCaptureRunning) {
                        camera.addCallbackBuffer(bArr);
                    }
                    this.mPreviewBufferLock.unlock();
                }
            }
        } finally {
            if (camera != null && this.isCaptureRunning) {
                camera.addCallbackBuffer(bArr);
            }
            this.mPreviewBufferLock.unlock();
        }
    }

    public void onTextureFrameAvailable(int i, float[] fArr, long j) {
        int frameOrientation = getFrameOrientation();
        if (this.mIsCameraFacingFront) {
            fArr = RendererCommon.multiplyMatrices(fArr, RendererCommon.horizontalFlipMatrix());
        }
        VideoFrame.TextureBuffer createTextureBuffer = this.mSurfaceTextureHelper.createTextureBuffer(this.mCaptureWidth, this.mCaptureHeight, RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr));
        onTextureBufferAvailable(createTextureBuffer, frameOrientation, j);
        createTextureBuffer.release();
    }

    private static boolean isSupported(String str, List<String> list) {
        return list != null && list.indexOf(str) >= 0;
    }

    private void setAdvancedCameraParameters(Camera.Parameters parameters) {
        if (isSupported(DebugKt.DEBUG_PROPERTY_VALUE_OFF, parameters.getSupportedFlashModes())) {
            Logging.i(TAG, "AgoraVideo set flash mode = FLASH_MODE_OFF");
            parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
        }
        if (isSupported(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, parameters.getSupportedWhiteBalance())) {
            Logging.i(TAG, "AgoraVideo set white blance = WHITE_BALANCE_AUTO");
            parameters.setWhiteBalance(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        }
        if (isSupported("continuous-video", parameters.getSupportedFocusModes())) {
            Logging.i(TAG, "AgoraVideo set Focus mode = FOCUS_MODE_CONTINUOUS_VIDEO");
            parameters.setFocusMode("continuous-video");
        }
        String str = this.mAntiBandingMode;
        if (isSupported(str, parameters.getSupportedAntibanding())) {
            Logging.i(TAG, "AgoraVideo set anti-banding = " + this.mAntiBandingMode);
            parameters.setAntibanding(str);
        }
        if (isSupported(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, parameters.getSupportedSceneModes())) {
            Logging.i(TAG, "AgoraVideo set sence mode = " + DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            if (parameters.getSceneMode() != DebugKt.DEBUG_PROPERTY_VALUE_AUTO) {
                parameters.setSceneMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
            }
        }
    }

    private void setDeviceSpecificParameters(Camera.Parameters parameters) {
        String buildDeviceId = DeviceUtils.buildDeviceId();
        String cpuName = DeviceUtils.getCpuName();
        String cpuABI = DeviceUtils.getCpuABI();
        int numberOfCPUCores = DeviceUtils.getNumberOfCPUCores();
        int cPUMaxFreqKHz = DeviceUtils.getCPUMaxFreqKHz();
        Logging.i(TAG, "Current Device: " + buildDeviceId);
        Logging.i(TAG, "CPU name: " + cpuName + ", with " + numberOfCPUCores + " cores, arch: " + cpuABI + ", max Freq: " + cPUMaxFreqKHz);
        if (buildDeviceId.contains("xiaomi/mi note")) {
            Logging.i(TAG, "set MiNote config");
            parameters.set("scene-detect", DebugKt.DEBUG_PROPERTY_VALUE_ON);
            parameters.set("xiaomi-still-beautify-values", "i:3");
            parameters.set("skinToneEnhancement", "enable");
            parameters.set("auto-exposure", "center-weighted");
        }
        if (buildDeviceId.contains("oppo/r7c/r7c")) {
            Logging.i(TAG, "set oppo r7c config");
            parameters.set("skinToneEnhancement", 1);
            parameters.set("face-beautify", 100);
            parameters.set("auto-exposure", "center-weighted");
        }
    }

    public Camera.Parameters getCameraParameters() {
        try {
            return this.mCamera.getParameters();
        } catch (RuntimeException e) {
            Logging.e(TAG, "getCameraParameters: Camera.getParameters: ", e);
            Camera camera = this.mCamera;
            if (camera != null) {
                camera.release();
                this.mCamera = null;
            }
            return null;
        }
    }

    public int createCapabilities() {
        String str;
        Camera.Parameters cameraParameters = getCameraParameters();
        if (cameraParameters != null) {
            String str2 = "\"id\":" + this.mId + ",";
            List<Camera.Size> supportedPreviewSizes = cameraParameters.getSupportedPreviewSizes();
            String str3 = "";
            String str4 = str3;
            for (int i = 0; i < supportedPreviewSizes.size(); i++) {
                int i2 = supportedPreviewSizes.get(i).width;
                int i3 = supportedPreviewSizes.get(i).height;
                if (i2 >= 240 && i3 >= 240 && (i2 >= 320 || i3 >= 320)) {
                    String str5 = "{\"w\":" + i2 + ",\"h\":" + i3 + "}";
                    if (!str4.isEmpty()) {
                        str4 = str4 + "," + str5;
                    } else {
                        str4 = str5;
                    }
                }
            }
            List<Integer> supportedPreviewFormats = cameraParameters.getSupportedPreviewFormats();
            if (VideoCapture.isEmulator()) {
                supportedPreviewFormats.remove(842094169);
            }
            String str6 = str3;
            for (int i4 = 0; i4 < supportedPreviewFormats.size(); i4++) {
                int translateToEngineFormat = translateToEngineFormat(supportedPreviewFormats.get(i4).intValue());
                if (i4 != supportedPreviewFormats.size() - 1) {
                    str6 = str6 + translateToEngineFormat + ",";
                } else {
                    str6 = str6 + translateToEngineFormat;
                }
            }
            List<Integer> supportedPreviewFrameRates = cameraParameters.getSupportedPreviewFrameRates();
            for (int i5 = 0; i5 < supportedPreviewFrameRates.size(); i5++) {
                int intValue = supportedPreviewFrameRates.get(i5).intValue();
                if (i5 != supportedPreviewFrameRates.size() - 1) {
                    str3 = str3 + intValue + ",";
                } else {
                    str3 = str3 + intValue;
                }
            }
            str = "{" + str2 + "\"resolution\":" + "[" + str4 + "]," + "\"format\":" + "[" + str6 + "]," + "\"fps\":" + "[" + str3 + "]}";
        } else {
            str = null;
        }
        cacheCapability(this.mId, this.mContext, str, getCaptureName());
        return 0;
    }

    private List<Integer> getZoomRatios() {
        if (this.mCamera == null) {
            return null;
        }
        Camera.Parameters cameraParameters = getCameraParameters();
        if (isZoomSupported(cameraParameters)) {
            return cameraParameters.getZoomRatios();
        }
        return null;
    }

    private boolean isZoomSupported(Camera.Parameters parameters) {
        if (parameters != null) {
            if (parameters.isZoomSupported()) {
                return true;
            }
            Logging.w(TAG, "camera zoom is not supported ");
        }
        return false;
    }

    private static Rect calculateTapArea(float f, float f2, float f3) {
        int i = (int) ((f * 2000.0f) - 1000.0f);
        int i2 = (int) ((f2 * 2000.0f) - 1000.0f);
        int intValue = Float.valueOf(f3 * 300.0f).intValue() / 2;
        RectF rectF = new RectF((float) clamp(i - intValue, -1000, 1000), (float) clamp(i2 - intValue, -1000, 1000), (float) clamp(i + intValue, -1000, 1000), (float) clamp(i2 + intValue, -1000, 1000));
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    private static int clamp(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    private boolean isForeground() {
        if (this.mContext != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                Logging.e(TAG, "List of RunningAppProcessInfo is null");
                return false;
            }
            for (int i = 0; i < runningAppProcesses.size(); i++) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i);
                if (runningAppProcessInfo == null) {
                    Logging.e(TAG, "ActivityManager.RunningAppProcessInfo is null");
                } else if (runningAppProcessInfo.processName.equals(this.mContext.getPackageName()) && runningAppProcessInfo.importance == 100) {
                    return true;
                }
            }
        }
        return false;
    }

    private int getFrameOrientation() {
        int checkOrientation = checkOrientation();
        if (!this.mIsCameraFacingFront) {
            checkOrientation = 360 - checkOrientation;
        }
        return (getSensorOrientation(this.mId) + checkOrientation) % 360;
    }

    public int setAntiBandingMode(final int i) {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Integer) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Integer>() {
                public Integer call() {
                    return Integer.valueOf(VideoCaptureCamera.this.setAntiBandingMode_l(i));
                }
            })).intValue();
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public int setAntiBandingMode_l(int i) {
        Camera.Parameters parameters;
        this.mAntiBandingMode = toCamera1ABMode(i);
        Camera camera = this.mCamera;
        if (camera == null || (parameters = camera.getParameters()) == null) {
            return -1;
        }
        String str = this.mAntiBandingMode;
        if (isSupported(str, parameters.getSupportedAntibanding())) {
            Logging.i(TAG, "AgoraVideo set anti-banding = " + str);
            parameters.setAntibanding(str);
            try {
                this.mCamera.setParameters(parameters);
                return 0;
            } catch (Exception e) {
                Logging.e(TAG, "anti banding got exception:" + e);
                return 0;
            }
        } else {
            Logging.i(TAG, "not supported anti-banding = " + str);
            return -1;
        }
    }

    public int setExposureCompensation(final int i) {
        Handler handler = this.mPreviewHandler;
        if (handler != null) {
            return ((Integer) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<Integer>() {
                public Integer call() {
                    VideoCaptureCamera.this.setExposureCompensation_l(i);
                    return 0;
                }
            })).intValue();
        }
        return -1;
    }

    public int setNoiseReductionMode(int i) {
        Logging.e(TAG, "NoiseReduction not supported in camera1 ");
        return -1;
    }

    public int setEdgeEnhanceMode(int i) {
        Logging.e(TAG, "EdgeEnhancement not supported in camera1 ");
        return -1;
    }

    public int setVideoStabilityMode(int i) {
        Logging.e(TAG, "VideoStability not supported in camera1 ");
        return -1;
    }

    /* access modifiers changed from: private */
    public void setExposureCompensation_l(int i) {
        Camera.Parameters parameters;
        Logging.i(TAG, "setExposureCompensation:" + i);
        Camera camera = this.mCamera;
        if (camera != null && (parameters = camera.getParameters()) != null) {
            float exposureCompensationStep = parameters.getExposureCompensationStep();
            int minExposureCompensation = parameters.getMinExposureCompensation();
            int maxExposureCompensation = parameters.getMaxExposureCompensation();
            int exposureCompensation = parameters.getExposureCompensation();
            Logging.i(TAG, "compensation step=" + exposureCompensationStep + ", min=" + minExposureCompensation + ", max=" + maxExposureCompensation + ", cur index=" + exposureCompensation);
            if (i > maxExposureCompensation) {
                i = maxExposureCompensation;
            }
            if (i >= minExposureCompensation) {
                minExposureCompensation = i;
            }
            parameters.setExposureCompensation(minExposureCompensation);
            try {
                this.mCamera.setParameters(parameters);
            } catch (Exception e) {
                Logging.e(TAG, "exposure compensation got exception:" + e);
            }
            int exposureCompensation2 = parameters.getExposureCompensation();
            Logging.i(TAG, "cur index=" + exposureCompensation2 + ", ev=" + (exposureCompensationStep * ((float) exposureCompensation2)));
        }
    }
}
