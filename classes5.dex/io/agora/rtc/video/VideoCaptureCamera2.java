package io.agora.rtc.video;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.Face;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import com.yalantis.ucrop.view.CropImageView;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.RendererCommon;
import io.agora.rtc.gl.SurfaceTextureHelper;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.internal.Logging;
import io.agora.rtc.video.VideoCapture;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class VideoCaptureCamera2 extends VideoCapture implements SurfaceTextureHelper.OnTextureFrameAvailableListener {
    private static final int DEFAULT_MATCH_FPS = 15;
    private static final float DEFAULT_VALUE = -1.0f;
    private static final String TAG = "CAMERA2";
    private static final boolean VERBOSE = false;
    /* access modifiers changed from: private */
    public static final MeteringRectangle[] ZERO_WEIGHT_3A_REGION = {new MeteringRectangle(0, 0, 0, 0, 0)};
    private static final float ZOOM_UNSUPPORTED_DEFAULT_VALUE = 1.0f;
    private static final double kNanoSecondsToFps = 1.0E-9d;
    /* access modifiers changed from: private */
    public int[] distanceArray = null;
    /* access modifiers changed from: private */
    public boolean faceDistaneEnabled = false;
    /* access modifiers changed from: private */
    public MeteringRectangle[] mAFAERegions = ZERO_WEIGHT_3A_REGION;
    private CameraCaptureSession.CaptureCallback mAfCaptureCallback = new CameraCaptureSession.CaptureCallback() {
        private void process(CaptureResult captureResult) {
            Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
            if (num != null && VideoCaptureCamera2.this.mPreviewBuilder != null) {
                if (4 == num.intValue() || 5 == num.intValue()) {
                    VideoCaptureCamera2.this.mPreviewBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                    VideoCaptureCamera2.this.startNormalPreview();
                }
            }
        }

        public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            process(captureResult);
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            process(totalCaptureResult);
        }
    };
    private int mAntiBandingMode = 3;
    public CameraManager.AvailabilityCallback mAvailabilityCallback = new CameraManager.AvailabilityCallback() {
        public synchronized void onCameraAvailable(String str) {
            super.onCameraAvailable(str);
            synchronized (VideoCaptureCamera2.this.mCameraStateLock) {
                if (VideoCaptureCamera2.this.mCameraState == CameraState.EVICTED) {
                    Logging.i(VideoCaptureCamera2.TAG, "Camera " + str + " available, try start capture again");
                    if (VideoCaptureCamera2.this.tryOpenCamera() != 0) {
                        Logging.e(VideoCaptureCamera2.TAG, "start capture failed");
                    } else if (VideoCaptureCamera2.this.mNativeVideoCaptureDeviceAndroid != 0) {
                        VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                        videoCaptureCamera2.onCameraError(videoCaptureCamera2.mNativeVideoCaptureDeviceAndroid, 0);
                    }
                }
            }
        }

        public synchronized void onCameraUnavailable(String str) {
            super.onCameraUnavailable(str);
            Logging.e(VideoCaptureCamera2.TAG, "Camera " + str + " unavailable");
        }
    };
    /* access modifiers changed from: private */
    public CameraDevice mCameraDevice = null;
    /* access modifiers changed from: private */
    public CameraState mCameraState = CameraState.STOPPED;
    /* access modifiers changed from: private */
    public final Object mCameraStateLock = new Object();
    private HandlerThread mCameraStateThread = null;
    /* access modifiers changed from: private */
    public final CameraCaptureSession.CaptureCallback mCaptureCallback = new CameraCaptureSession.CaptureCallback() {
        private long mLastFocusedTs;

        public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        }

        private void notifyCameraFocusAreaChanged(Rect rect, Rect rect2) {
            Rect sensorToNormalizedPreview = CoordinatesTransform.sensorToNormalizedPreview(rect2, VideoCaptureCamera2.this.mCaptureWidth, VideoCaptureCamera2.this.mCaptureHeight, rect);
            Logging.d(VideoCaptureCamera2.TAG, "face bound = " + rect2.toString());
            Logging.d(VideoCaptureCamera2.TAG, "rect (-1000, 1000) = " + sensorToNormalizedPreview.toString());
            boolean z = true;
            if (VideoCaptureCamera2.this.mId != 1) {
                z = false;
            }
            RectF normalizedFaceRect = CoordinatesTransform.normalizedFaceRect(sensorToNormalizedPreview, 0, z);
            Logging.d(VideoCaptureCamera2.TAG, "preview size width = " + VideoCaptureCamera2.this.mCaptureWidth + " height = " + VideoCaptureCamera2.this.mCaptureHeight);
            Logging.d(VideoCaptureCamera2.TAG, "auto face focus left =" + normalizedFaceRect.left + " top = " + normalizedFaceRect.top + " right = " + normalizedFaceRect.right + " bottom = " + normalizedFaceRect.bottom + "isMirror =" + z);
            float f = normalizedFaceRect.left;
            float f2 = normalizedFaceRect.top;
            float width = normalizedFaceRect.width();
            float height = normalizedFaceRect.height();
            if (VideoCaptureCamera2.this.mNativeVideoCaptureDeviceAndroid != 0) {
                VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                videoCaptureCamera2.NotifyCameraFocusAreaChanged(f, f2, width, height, videoCaptureCamera2.mNativeVideoCaptureDeviceAndroid);
            }
        }

        private void notifyFaceDetection(Rect rect, Face[] faceArr) {
            RectF[] unused = VideoCaptureCamera2.this.rectArray = null;
            boolean z = true;
            if (VideoCaptureCamera2.this.mId != 1) {
                z = false;
            }
            if (faceArr != null && faceArr.length > 0) {
                int length = faceArr.length;
                RectF[] unused2 = VideoCaptureCamera2.this.rectArray = new RectF[length];
                int[] unused3 = VideoCaptureCamera2.this.distanceArray = new int[length];
                for (int i = 0; i < length; i++) {
                    VideoCaptureCamera2.this.rectArray[i] = CoordinatesTransform.normalizedFaceRect(CoordinatesTransform.sensorToNormalizedPreview(faceArr[i].getBounds(), VideoCaptureCamera2.this.mCaptureWidth, VideoCaptureCamera2.this.mCaptureHeight, rect), 0, z);
                    VideoCaptureCamera2.this.distanceArray[i] = 5;
                }
                Logging.d(VideoCaptureCamera2.TAG, "before notify face");
                VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                videoCaptureCamera2.NotifyFaceDetection(videoCaptureCamera2.mCaptureWidth, VideoCaptureCamera2.this.mCaptureHeight, VideoCaptureCamera2.this.rectArray, (long) length, VideoCaptureCamera2.this.mNativeVideoCaptureDeviceAndroid);
            }
        }

        private void process(CaptureResult captureResult) {
            Face[] faceArr = (Face[]) captureResult.get(CaptureResult.STATISTICS_FACES);
            if (faceArr == null || faceArr.length <= 0) {
                MeteringRectangle[] unused = VideoCaptureCamera2.this.mAFAERegions = VideoCaptureCamera2.ZERO_WEIGHT_3A_REGION;
            } else if (System.currentTimeMillis() - this.mLastFocusedTs < 3000) {
                if (faceArr[0].getScore() > 20) {
                    notifyCameraFocusAreaChanged((Rect) captureResult.get(CaptureResult.SCALER_CROP_REGION), faceArr[0].getBounds());
                }
            } else if (faceArr[0].getScore() > 50) {
                MeteringRectangle[] unused2 = VideoCaptureCamera2.this.mAFAERegions = new MeteringRectangle[]{new MeteringRectangle(faceArr[0].getBounds(), 1000)};
                if (VideoCaptureCamera2.this.mPreviewBuilder != null) {
                    VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                    videoCaptureCamera2.addRegionsToCaptureRequestBuilder(videoCaptureCamera2.mPreviewBuilder);
                    if (VideoCaptureCamera2.this.mCameraState == CameraState.STARTED) {
                        try {
                            Rect rect = (Rect) captureResult.get(CaptureResult.SCALER_CROP_REGION);
                            Logging.d(VideoCaptureCamera2.TAG, "cropRegion = " + rect.toString());
                            Logging.d(VideoCaptureCamera2.TAG, "capture size wxh = " + VideoCaptureCamera2.this.mCaptureWidth + " x " + VideoCaptureCamera2.this.mCaptureHeight);
                            notifyCameraFocusAreaChanged(rect, faceArr[0].getBounds());
                            if (VideoCaptureCamera2.this.mCaptureSession != null) {
                                synchronized (VideoCaptureCamera2.this.mCaptureSessionLock) {
                                    if (VideoCaptureCamera2.this.mCaptureSession != null) {
                                        VideoCaptureCamera2.this.mCaptureSession.capture(VideoCaptureCamera2.this.mPreviewBuilder.build(), VideoCaptureCamera2.this.mCaptureCallback, (Handler) null);
                                    }
                                }
                            }
                            int unused3 = VideoCaptureCamera2.this.createCaptureRequest();
                            this.mLastFocusedTs = System.currentTimeMillis();
                        } catch (Exception e) {
                            Logging.e(VideoCaptureCamera2.TAG, "capture: " + e);
                        }
                    }
                }
            }
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            if (VideoCaptureCamera2.this.mIsAutoFaceFocusEnabled && VideoCaptureCamera2.this.isAutoFaceFocusSupported()) {
                process(totalCaptureResult);
            }
            if (VideoCaptureCamera2.this.faceDistaneEnabled) {
                notifyFaceDetection((Rect) totalCaptureResult.get(CaptureResult.SCALER_CROP_REGION), (Face[]) totalCaptureResult.get(CaptureResult.STATISTICS_FACES));
            }
        }
    };
    /* access modifiers changed from: private */
    public byte[] mCaptureData;
    private int mCaptureFormat = 35;
    private int mCaptureFps = -1;
    /* access modifiers changed from: private */
    public int mCaptureHeight = -1;
    /* access modifiers changed from: private */
    public CameraCaptureSession mCaptureSession = null;
    /* access modifiers changed from: private */
    public final Object mCaptureSessionLock = new Object();
    /* access modifiers changed from: private */
    public int mCaptureWidth = -1;
    private float mCurZoomRatio = 1.0f;
    private int mEdgeEnhanceMode = 0;
    private int mFaceDetectMode;
    private boolean mFaceDetectSupported;
    private ImageReader mImageReader = null;
    /* access modifiers changed from: private */
    public boolean mIsAutoFaceFocusEnabled = false;
    private final boolean mIsCameraFacingFront;
    private float mLastZoomRatio = DEFAULT_VALUE;
    private CameraManager mManager = null;
    private float mMaxZoom = DEFAULT_VALUE;
    private int mNoiseReductionMode = 1;
    /* access modifiers changed from: private */
    public CaptureRequest.Builder mPreviewBuilder = null;
    private HandlerThread mPreviewThread = null;
    private Rect mSensorRect = null;
    private Handler mStateHandler = null;
    private Surface mTextureOutputSurface;
    private int mVideoStabilityMode = 0;
    /* access modifiers changed from: private */
    public RectF[] rectArray = null;

    private enum CameraState {
        OPENING,
        STARTED,
        EVICTED,
        STOPPED
    }

    static String getCaptureName() {
        return "camera2";
    }

    private int toCamera2ABMode(int i) {
        if (i < 0 || i > 3) {
            return 3;
        }
        return i;
    }

    private int toCamera2EdgeEnhanceMode(int i) {
        if (i < 0 || i > 3) {
            return 0;
        }
        return i;
    }

    private int toCamera2NoiseMode(int i) {
        if (i < 0 || i > 4) {
            return 0;
        }
        return i;
    }

    private int toCamera2VideoStabilityMode(int i) {
        if (i < 0 || i > 1) {
            return 0;
        }
        return i;
    }

    static boolean isCameraFacingFront(Context context, int i) {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(context, i);
        if (cameraCharacteristics == null) {
            return true;
        }
        Integer num = 0;
        return num.equals(cameraCharacteristics.get(CameraCharacteristics.LENS_FACING));
    }

    private static CameraCharacteristics getCameraCharacteristics(Context context, int i) {
        if (i == 0 || i == 1 || i == 2) {
            try {
                return ((CameraManager) context.getSystemService("camera")).getCameraCharacteristics(Integer.toString(i));
            } catch (CameraAccessException e) {
                Logging.i(TAG, "getNumberOfCameras: getCameraIdList(): " + e);
                return null;
            } catch (Exception e2) {
                Logging.i(TAG, "getNumberOfCameras: got exception: " + e2);
                return null;
            }
        } else {
            Logging.i(TAG, "getCameraCharacteristics error,  camera id: " + i);
            return null;
        }
    }

    public static int getFrontCameraIndex(Context context) {
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            int length = cameraIdList.length;
            int i = 0;
            while (i < length) {
                String str = cameraIdList[i];
                Integer num = (Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING);
                if (num == null || num.intValue() != 0) {
                    i++;
                } else {
                    Logging.d(TAG, "getFrontCameraIndex str= " + str + ", int = " + Integer.parseInt(str));
                    return Integer.parseInt(str);
                }
            }
        } catch (Exception e) {
            Logging.e(TAG, "getFrontCameraIndex: ", e);
        }
        return 0;
    }

    static boolean isLegacyDevice(Context context, int i) {
        try {
            CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(context, i);
            if (cameraCharacteristics == null || ((Integer) cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            Logging.w(TAG, "this is a legacy camera device");
            return true;
        }
    }

    static int getNumberOfCameras(Context context) {
        try {
            int length = ((CameraManager) context.getSystemService("camera")).getCameraIdList().length;
            Logging.i(TAG, "VideoCaptureCamera2 listCount:" + length);
            return length;
        } catch (Exception e) {
            Logging.e(TAG, "getNumberOfCameras: getCameraIdList(): ", e);
            return 0;
        }
    }

    static String getName(int i, Context context) {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(context, i);
        if (cameraCharacteristics == null) {
            return null;
        }
        int intValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue();
        StringBuilder sb = new StringBuilder();
        sb.append("camera2 ");
        sb.append(i);
        sb.append(", facing ");
        sb.append(intValue == 0 ? "front" : "back");
        return sb.toString();
    }

    static int getSensorOrientation(int i, Context context) {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(context, i);
        if (cameraCharacteristics == null) {
            return -1;
        }
        return ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
    }

    VideoCaptureCamera2(Context context, int i, int i2, EglBase.Context context2, long j) {
        super(context, i, i2, context2, j);
        this.mIsCameraFacingFront = isCameraFacingFront(context, i);
    }

    /* access modifiers changed from: private */
    public void startNormalPreview() {
        CaptureRequest.Builder builder = this.mPreviewBuilder;
        if (builder != null) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
            this.mPreviewBuilder.set(CaptureRequest.CONTROL_AE_MODE, 1);
            Handler handler = new Handler(this.mPreviewThread.getLooper());
            try {
                if (this.mCaptureSession != null) {
                    synchronized (this.mCaptureSessionLock) {
                        CameraCaptureSession cameraCaptureSession = this.mCaptureSession;
                        if (cameraCaptureSession != null) {
                            cameraCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), this.mCaptureCallback, handler);
                        }
                    }
                }
            } catch (CameraAccessException e) {
                Logging.e(TAG, "setRepeatingRequest failed, error message : " + e.getMessage());
            }
        }
    }

    private class CrStateListener extends CameraDevice.StateCallback {
        private CrStateListener() {
        }

        public void onOpened(CameraDevice cameraDevice) {
            CameraDevice unused = VideoCaptureCamera2.this.mCameraDevice = cameraDevice;
            if (VideoCaptureCamera2.this.doStartCapture() < 0) {
                int unused2 = VideoCaptureCamera2.this.doStopCapture();
                if (VideoCaptureCamera2.this.mCameraState != CameraState.EVICTED) {
                    VideoCaptureCamera2.this.changeCameraStateAndNotify(CameraState.STOPPED);
                }
                Logging.e(VideoCaptureCamera2.TAG, "Camera startCapture failed!!");
                if (VideoCaptureCamera2.this.mNativeVideoCaptureDeviceAndroid != 0) {
                    VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                    videoCaptureCamera2.onCameraError(videoCaptureCamera2.mNativeVideoCaptureDeviceAndroid, 100);
                }
            }
        }

        public void onDisconnected(CameraDevice cameraDevice) {
            synchronized (VideoCaptureCamera2.this.mCameraStateLock) {
                if (VideoCaptureCamera2.this.mCameraState != CameraState.STOPPED) {
                    Logging.w(VideoCaptureCamera2.TAG, "camera client is evicted by other application");
                    if (VideoCaptureCamera2.this.mNativeVideoCaptureDeviceAndroid != 0) {
                        VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                        videoCaptureCamera2.onCameraError(videoCaptureCamera2.mNativeVideoCaptureDeviceAndroid, 6);
                    }
                    Logging.i(VideoCaptureCamera2.TAG, "Camera device enter state: EVICTED");
                    if (VideoCaptureCamera2.this.mCameraDevice != null) {
                        VideoCaptureCamera2.this.mCameraDevice.close();
                        CameraDevice unused = VideoCaptureCamera2.this.mCameraDevice = null;
                    }
                    CameraState unused2 = VideoCaptureCamera2.this.mCameraState = CameraState.EVICTED;
                    VideoCaptureCamera2.this.mCameraStateLock.notifyAll();
                }
            }
        }

        public void onError(CameraDevice cameraDevice, int i) {
            if (VideoCaptureCamera2.this.mCameraState != CameraState.EVICTED) {
                if (VideoCaptureCamera2.this.mCameraDevice != null) {
                    VideoCaptureCamera2.this.mCameraDevice.close();
                    CameraDevice unused = VideoCaptureCamera2.this.mCameraDevice = null;
                }
                VideoCaptureCamera2.this.changeCameraStateAndNotify(CameraState.STOPPED);
                Logging.e(VideoCaptureCamera2.TAG, "CameraDevice Error :" + Integer.toString(i));
                if (VideoCaptureCamera2.this.mNativeVideoCaptureDeviceAndroid != 0) {
                    int i2 = VideoCapture.VideoCaptureEvent.kCameraErrorRuntimeUnknown;
                    if (i == 1) {
                        i2 = 1;
                    } else if (i == 2) {
                        i2 = 2;
                    } else if (i == 3) {
                        i2 = 3;
                    } else if (i == 4) {
                        i2 = 4;
                    } else if (i == 5) {
                        i2 = 5;
                    }
                    VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                    videoCaptureCamera2.onCameraError(videoCaptureCamera2.mNativeVideoCaptureDeviceAndroid, i2);
                }
            }
        }
    }

    private class CaptureSessionListener extends CameraCaptureSession.StateCallback {
        private CaptureSessionListener() {
        }

        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            CameraCaptureSession unused = VideoCaptureCamera2.this.mCaptureSession = cameraCaptureSession;
            if (VideoCaptureCamera2.this.createCaptureRequest() != 0) {
                VideoCaptureCamera2.this.changeCameraStateAndNotify(CameraState.STOPPED);
                if (VideoCaptureCamera2.this.mNativeVideoCaptureDeviceAndroid != 0) {
                    VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                    videoCaptureCamera2.onCameraError(videoCaptureCamera2.mNativeVideoCaptureDeviceAndroid, 102);
                    return;
                }
                return;
            }
            VideoCaptureCamera2.this.changeCameraStateAndNotify(CameraState.STARTED);
        }

        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            Logging.e(VideoCaptureCamera2.TAG, "onConfigureFailed");
            if (VideoCaptureCamera2.this.mCameraState != CameraState.EVICTED) {
                VideoCaptureCamera2.this.changeCameraStateAndNotify(CameraState.STOPPED);
            }
            if (VideoCaptureCamera2.this.mNativeVideoCaptureDeviceAndroid != 0) {
                VideoCaptureCamera2 videoCaptureCamera2 = VideoCaptureCamera2.this;
                videoCaptureCamera2.onCameraError(videoCaptureCamera2.mNativeVideoCaptureDeviceAndroid, 101);
            }
        }
    }

    /* access modifiers changed from: private */
    public void changeCameraStateAndNotify(CameraState cameraState) {
        synchronized (this.mCameraStateLock) {
            this.mCameraState = cameraState;
            this.mCameraStateLock.notifyAll();
        }
    }

    private class ImageReaderListener implements ImageReader.OnImageAvailableListener {
        private ImageReaderListener() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x008a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f7, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f9, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00fb, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onImageAvailable(android.media.ImageReader r7) {
            /*
                r6 = this;
                io.agora.rtc.video.VideoCaptureCamera2 r0 = io.agora.rtc.video.VideoCaptureCamera2.this
                java.lang.Object r0 = r0.mCameraStateLock
                monitor-enter(r0)
                r1 = 0
                io.agora.rtc.video.VideoCaptureCamera2 r2 = io.agora.rtc.video.VideoCaptureCamera2.this     // Catch:{ IllegalStateException -> 0x00fe }
                io.agora.rtc.video.VideoCaptureCamera2$CameraState r2 = r2.mCameraState     // Catch:{ IllegalStateException -> 0x00fe }
                io.agora.rtc.video.VideoCaptureCamera2$CameraState r3 = io.agora.rtc.video.VideoCaptureCamera2.CameraState.STARTED     // Catch:{ IllegalStateException -> 0x00fe }
                if (r2 != r3) goto L_0x00fa
                if (r7 != 0) goto L_0x0016
                goto L_0x00fa
            L_0x0016:
                io.agora.rtc.video.VideoCaptureCamera2 r2 = io.agora.rtc.video.VideoCaptureCamera2.this     // Catch:{ IllegalStateException -> 0x00fe }
                byte[] r2 = r2.mCaptureData     // Catch:{ IllegalStateException -> 0x00fe }
                if (r2 == 0) goto L_0x00f8
                io.agora.rtc.video.VideoCaptureCamera2 r2 = io.agora.rtc.video.VideoCaptureCamera2.this     // Catch:{ IllegalStateException -> 0x00fe }
                byte[] r2 = r2.mCaptureData     // Catch:{ IllegalStateException -> 0x00fe }
                int r2 = r2.length     // Catch:{ IllegalStateException -> 0x00fe }
                if (r2 != 0) goto L_0x0029
                goto L_0x00f8
            L_0x0029:
                android.media.Image r1 = r7.acquireLatestImage()     // Catch:{ IllegalStateException -> 0x00fe }
                if (r1 != 0) goto L_0x0036
                if (r1 == 0) goto L_0x0034
                r1.close()     // Catch:{ all -> 0x0113 }
            L_0x0034:
                monitor-exit(r0)     // Catch:{ all -> 0x0113 }
                return
            L_0x0036:
                int r2 = r1.getFormat()     // Catch:{ IllegalStateException -> 0x00fe }
                r3 = 35
                if (r2 != r3) goto L_0x00ca
                android.media.Image$Plane[] r2 = r1.getPlanes()     // Catch:{ IllegalStateException -> 0x00fe }
                int r2 = r2.length     // Catch:{ IllegalStateException -> 0x00fe }
                r3 = 3
                if (r2 == r3) goto L_0x0048
                goto L_0x00ca
            L_0x0048:
                int r2 = r7.getWidth()     // Catch:{ IllegalStateException -> 0x00fe }
                int r3 = r1.getWidth()     // Catch:{ IllegalStateException -> 0x00fe }
                if (r2 != r3) goto L_0x008b
                int r2 = r7.getHeight()     // Catch:{ IllegalStateException -> 0x00fe }
                int r3 = r1.getHeight()     // Catch:{ IllegalStateException -> 0x00fe }
                if (r2 != r3) goto L_0x008b
                io.agora.rtc.video.VideoCaptureCamera2 r7 = io.agora.rtc.video.VideoCaptureCamera2.this     // Catch:{ IllegalStateException -> 0x00fe }
                byte[] r7 = r7.mCaptureData     // Catch:{ IllegalStateException -> 0x00fe }
                io.agora.rtc.video.VideoCaptureCamera2.readImageIntoBuffer(r1, r7)     // Catch:{ IllegalStateException -> 0x00fe }
                io.agora.rtc.video.VideoCaptureCamera2 r7 = io.agora.rtc.video.VideoCaptureCamera2.this     // Catch:{ IllegalStateException -> 0x00fe }
                long r2 = r7.mNativeVideoCaptureDeviceAndroid     // Catch:{ IllegalStateException -> 0x00fe }
                r4 = 0
                int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r7 == 0) goto L_0x007d
                io.agora.rtc.video.VideoCaptureCamera2 r7 = io.agora.rtc.video.VideoCaptureCamera2.this     // Catch:{ IllegalStateException -> 0x00fe }
                byte[] r2 = r7.mCaptureData     // Catch:{ IllegalStateException -> 0x00fe }
                io.agora.rtc.video.VideoCaptureCamera2 r3 = io.agora.rtc.video.VideoCaptureCamera2.this     // Catch:{ IllegalStateException -> 0x00fe }
                int r3 = r3.mExpectedRawBufferSize     // Catch:{ IllegalStateException -> 0x00fe }
                r7.onRawBufferAvailable(r2, r3)     // Catch:{ IllegalStateException -> 0x00fe }
                goto L_0x0084
            L_0x007d:
                java.lang.String r7 = "CAMERA2"
                java.lang.String r2 = "warning mNativeVideoCaptureDeviceAndroid = 0, error"
                io.agora.rtc.internal.Logging.w(r7, r2)     // Catch:{ IllegalStateException -> 0x00fe }
            L_0x0084:
                if (r1 == 0) goto L_0x0089
                r1.close()     // Catch:{ all -> 0x0113 }
            L_0x0089:
                monitor-exit(r0)     // Catch:{ all -> 0x0113 }
                return
            L_0x008b:
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ IllegalStateException -> 0x00fe }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x00fe }
                r3.<init>()     // Catch:{ IllegalStateException -> 0x00fe }
                java.lang.String r4 = "ImageReader size "
                r3.append(r4)     // Catch:{ IllegalStateException -> 0x00fe }
                int r4 = r7.getWidth()     // Catch:{ IllegalStateException -> 0x00fe }
                r3.append(r4)     // Catch:{ IllegalStateException -> 0x00fe }
                java.lang.String r4 = "x"
                r3.append(r4)     // Catch:{ IllegalStateException -> 0x00fe }
                int r7 = r7.getHeight()     // Catch:{ IllegalStateException -> 0x00fe }
                r3.append(r7)     // Catch:{ IllegalStateException -> 0x00fe }
                java.lang.String r7 = " did not match Image size: "
                r3.append(r7)     // Catch:{ IllegalStateException -> 0x00fe }
                int r7 = r1.getWidth()     // Catch:{ IllegalStateException -> 0x00fe }
                r3.append(r7)     // Catch:{ IllegalStateException -> 0x00fe }
                java.lang.String r7 = "x"
                r3.append(r7)     // Catch:{ IllegalStateException -> 0x00fe }
                int r7 = r1.getHeight()     // Catch:{ IllegalStateException -> 0x00fe }
                r3.append(r7)     // Catch:{ IllegalStateException -> 0x00fe }
                java.lang.String r7 = r3.toString()     // Catch:{ IllegalStateException -> 0x00fe }
                r2.<init>(r7)     // Catch:{ IllegalStateException -> 0x00fe }
                throw r2     // Catch:{ IllegalStateException -> 0x00fe }
            L_0x00ca:
                java.lang.String r7 = "CAMERA2"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x00fe }
                r2.<init>()     // Catch:{ IllegalStateException -> 0x00fe }
                java.lang.String r3 = "Unexpected image format: "
                r2.append(r3)     // Catch:{ IllegalStateException -> 0x00fe }
                int r3 = r1.getFormat()     // Catch:{ IllegalStateException -> 0x00fe }
                r2.append(r3)     // Catch:{ IllegalStateException -> 0x00fe }
                java.lang.String r3 = "or #planes:"
                r2.append(r3)     // Catch:{ IllegalStateException -> 0x00fe }
                android.media.Image$Plane[] r3 = r1.getPlanes()     // Catch:{ IllegalStateException -> 0x00fe }
                int r3 = r3.length     // Catch:{ IllegalStateException -> 0x00fe }
                r2.append(r3)     // Catch:{ IllegalStateException -> 0x00fe }
                java.lang.String r2 = r2.toString()     // Catch:{ IllegalStateException -> 0x00fe }
                io.agora.rtc.internal.Logging.e(r7, r2)     // Catch:{ IllegalStateException -> 0x00fe }
                if (r1 == 0) goto L_0x00f6
                r1.close()     // Catch:{ all -> 0x0113 }
            L_0x00f6:
                monitor-exit(r0)     // Catch:{ all -> 0x0113 }
                return
            L_0x00f8:
                monitor-exit(r0)     // Catch:{ all -> 0x0113 }
                return
            L_0x00fa:
                monitor-exit(r0)     // Catch:{ all -> 0x0113 }
                return
            L_0x00fc:
                r7 = move-exception
                goto L_0x010d
            L_0x00fe:
                r7 = move-exception
                java.lang.String r2 = "CAMERA2"
                java.lang.String r3 = "acquireLastest Image():"
                io.agora.rtc.internal.Logging.e(r2, r3, r7)     // Catch:{ all -> 0x00fc }
                if (r1 == 0) goto L_0x010b
                r1.close()     // Catch:{ all -> 0x0113 }
            L_0x010b:
                monitor-exit(r0)     // Catch:{ all -> 0x0113 }
                return
            L_0x010d:
                if (r1 == 0) goto L_0x0112
                r1.close()     // Catch:{ all -> 0x0113 }
            L_0x0112:
                throw r7     // Catch:{ all -> 0x0113 }
            L_0x0113:
                r7 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0113 }
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.video.VideoCaptureCamera2.ImageReaderListener.onImageAvailable(android.media.ImageReader):void");
        }
    }

    /* access modifiers changed from: private */
    public int createCaptureRequest() {
        if (this.mPreviewBuilder == null) {
            return -1;
        }
        try {
            if (this.mCaptureSession == null) {
                return 0;
            }
            synchronized (this.mCaptureSessionLock) {
                CameraCaptureSession cameraCaptureSession = this.mCaptureSession;
                if (cameraCaptureSession != null) {
                    cameraCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), this.mCaptureCallback, (Handler) null);
                }
            }
            return 0;
        } catch (CameraAccessException e) {
            Logging.e(TAG, "setRepeatingRequest: ", e);
            return -1;
        } catch (IllegalArgumentException e2) {
            Logging.e(TAG, "setRepeatingRequest: ", e2);
            return -2;
        } catch (SecurityException e3) {
            Logging.e(TAG, "setRepeatingRequest: ", e3);
            return -3;
        } catch (IllegalStateException e4) {
            Logging.e(TAG, "capture:" + e4);
            return -4;
        }
    }

    /* access modifiers changed from: private */
    public static void readImageIntoBuffer(Image image, byte[] bArr) {
        int i;
        int i2;
        byte[] bArr2 = bArr;
        int width = image.getWidth();
        int height = image.getHeight();
        Image.Plane[] planes = image.getPlanes();
        int i3 = 0;
        for (int i4 = 0; i4 < planes.length; i4++) {
            ByteBuffer buffer = planes[i4].getBuffer();
            if (buffer == null) {
                Logging.e(TAG, "plane " + i4 + " buffer is null ");
                return;
            }
            int rowStride = planes[i4].getRowStride();
            int pixelStride = planes[i4].getPixelStride();
            if (i4 == 0) {
                i = width;
            } else {
                i = width / 2;
            }
            if (i4 == 0) {
                i2 = height;
            } else {
                i2 = height / 2;
            }
            if (pixelStride == 1 && rowStride == i) {
                int i5 = i * i2;
                buffer.get(bArr2, i3, i5);
                i3 += i5;
            } else {
                byte[] bArr3 = new byte[rowStride];
                for (int i6 = 0; i6 < i2 - 1; i6++) {
                    buffer.get(bArr3, 0, rowStride);
                    int i7 = 0;
                    while (i7 < i) {
                        bArr2[i3] = bArr3[i7 * pixelStride];
                        i7++;
                        i3++;
                    }
                }
                buffer.get(bArr3, 0, Math.min(rowStride, buffer.remaining()));
                int i8 = 0;
                while (i8 < i) {
                    bArr2[i3] = bArr3[i8 * pixelStride];
                    i8++;
                    i3++;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public int tryOpenCamera() {
        try {
            this.mManager.openCamera(Integer.toString(this.mId), new CrStateListener(), this.mStateHandler);
            return 0;
        } catch (CameraAccessException e) {
            Logging.e(TAG, "allocate: manager.openCamera: ", e);
            return -1;
        } catch (IllegalArgumentException e2) {
            Logging.e(TAG, "allocate: manager.openCamera: ", e2);
            return -2;
        } catch (SecurityException e3) {
            Logging.e(TAG, "allocate: manager.openCamera: ", e3);
            return -3;
        } catch (Exception e4) {
            Logging.e(TAG, "unknown error", e4);
            return -4;
        }
    }

    /* access modifiers changed from: private */
    public void addRegionsToCaptureRequestBuilder(CaptureRequest.Builder builder) {
        builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        builder.set(CaptureRequest.CONTROL_AE_REGIONS, this.mAFAERegions);
        builder.set(CaptureRequest.CONTROL_AF_REGIONS, this.mAFAERegions);
        builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
        builder.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
    }

    /* access modifiers changed from: private */
    public int doStartCapture() {
        Range[] rangeArr;
        if (this.mPreviewThread == null) {
            HandlerThread handlerThread = new HandlerThread("CameraPreview");
            this.mPreviewThread = handlerThread;
            handlerThread.start();
        }
        try {
            CaptureRequest.Builder createCaptureRequest = this.mCameraDevice.createCaptureRequest(1);
            this.mPreviewBuilder = createCaptureRequest;
            if (createCaptureRequest == null) {
                Logging.e(TAG, "mPreviewBuilder error");
                return -4;
            }
            CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
            if (cameraCharacteristics != null && (rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES)) != null) {
                if (this.mPQFirst >= 1) {
                    Arrays.sort(rangeArr, new Comparator<Range<Integer>>() {
                        public int compare(Range<Integer> range, Range<Integer> range2) {
                            return range.getUpper().intValue() - range2.getUpper().intValue();
                        }
                    });
                    Logging.i(TAG, "sorted fps Ranges List:" + Arrays.toString(rangeArr));
                    int length = rangeArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        Range range = rangeArr[i];
                        if (((Integer) range.getUpper()).intValue() >= this.mCaptureFps) {
                            Logging.i(TAG, "set fps :" + range.toString() + " to camera2::PQ first, request:" + this.mCaptureFps);
                            this.mPreviewBuilder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
                            break;
                        }
                        i++;
                    }
                } else {
                    Arrays.sort(rangeArr, new Comparator<Range<Integer>>() {
                        public int compare(Range<Integer> range, Range<Integer> range2) {
                            return range.getLower().intValue() - range2.getLower().intValue();
                        }
                    });
                    Logging.i(TAG, "sorted fps Ranges List:" + Arrays.toString(rangeArr));
                    int length2 = rangeArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            break;
                        }
                        Range range2 = rangeArr[i2];
                        if (((Integer) range2.getLower()).intValue() >= Math.max(this.mCaptureFps, 15)) {
                            Logging.i(TAG, "set fps :" + range2.toString() + " to camera2::fps first, request:" + this.mCaptureFps);
                            this.mPreviewBuilder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range2);
                            break;
                        }
                        i2++;
                    }
                }
            }
            this.mPreviewBuilder.set(CaptureRequest.CONTROL_MODE, 1);
            this.mPreviewBuilder.set(CaptureRequest.CONTROL_AF_MODE, 3);
            this.mPreviewBuilder.set(CaptureRequest.CONTROL_AE_MODE, 1);
            setFaceDetect(this.mPreviewBuilder, this.mFaceDetectMode);
            ArrayList arrayList = new ArrayList();
            if (this.mCaptureOutputDataType == 1 || this.mCaptureOutputDataType == 2) {
                this.mSurfaceTextureHelper = SurfaceTextureHelper.create("Camera2TexThread", this.mShareContext, 6);
                if (this.mSurfaceTextureHelper == null) {
                    Logging.e(TAG, "Failed to create SurfaceTextureHelper, force fallback to raw data type");
                    this.mCaptureOutputDataType = 0;
                } else {
                    this.mSurfaceTextureHelper.getSurfaceTexture().setDefaultBufferSize(this.mCaptureWidth, this.mCaptureHeight);
                    this.mSurfaceTextureHelper.startListening(this);
                    this.mEglContext = this.mSurfaceTextureHelper.getEglContext();
                    Surface surface = new Surface(this.mSurfaceTextureHelper.getSurfaceTexture());
                    this.mTextureOutputSurface = surface;
                    this.mPreviewBuilder.addTarget(surface);
                    arrayList.add(this.mTextureOutputSurface);
                    if (this.mCaptureOutputDataType == 2 && this.mTextureAndRawBufferSynchronizer == null) {
                        this.mTextureAndRawBufferSynchronizer = new VideoCapture.TextureAndRawBufferSynchronizer();
                    }
                }
            }
            if (this.mCaptureOutputDataType == 0 || this.mCaptureOutputDataType == 2) {
                this.mExpectedRawBufferSize = ((this.mCaptureWidth * this.mCaptureHeight) * ImageFormat.getBitsPerPixel(this.mCaptureFormat)) / 8;
                this.mCaptureData = new byte[this.mExpectedRawBufferSize];
                this.mImageReader = ImageReader.newInstance(this.mCaptureWidth, this.mCaptureHeight, this.mCaptureFormat, 2);
                Handler handler = new Handler(this.mPreviewThread.getLooper());
                this.mImageReader.setOnImageAvailableListener(new ImageReaderListener(), handler);
                Surface surface2 = this.mImageReader.getSurface();
                this.mPreviewBuilder.addTarget(surface2);
                arrayList.add(surface2);
            }
            try {
                this.mCameraDevice.createCaptureSession(arrayList, new CaptureSessionListener(), (Handler) null);
                return 0;
            } catch (CameraAccessException e) {
                Logging.e(TAG, "createCaptureSession :", e);
                return -1;
            } catch (IllegalArgumentException e2) {
                Logging.e(TAG, "createCaptureSession :", e2);
                return -2;
            } catch (SecurityException e3) {
                Logging.e(TAG, "createCaptureSession :", e3);
                return -3;
            }
        } catch (CameraAccessException e4) {
            Logging.e(TAG, "createCaptureRequest: ", e4);
            return -1;
        } catch (IllegalArgumentException e5) {
            Logging.e(TAG, "createCaptureRequest: ", e5);
            return -2;
        } catch (SecurityException e6) {
            Logging.e(TAG, "createCaptureRequest ", e6);
            return -3;
        }
    }

    /* access modifiers changed from: private */
    public int doStopCapture() {
        Logging.i(TAG, "doStopCapture");
        HandlerThread handlerThread = this.mPreviewThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.mPreviewThread = null;
        }
        if (this.mCaptureSession != null) {
            try {
                synchronized (this.mCaptureSessionLock) {
                    this.mCaptureSession.abortCaptures();
                    this.mCaptureSession = null;
                }
                ImageReader imageReader = this.mImageReader;
                if (imageReader != null) {
                    imageReader.setOnImageAvailableListener((ImageReader.OnImageAvailableListener) null, (Handler) null);
                    this.mImageReader.close();
                    this.mImageReader = null;
                }
                CameraDevice cameraDevice = this.mCameraDevice;
                if (cameraDevice != null) {
                    cameraDevice.close();
                    this.mCameraDevice = null;
                }
            } catch (CameraAccessException e) {
                Logging.e(TAG, "abortCaptures: ", e);
                ImageReader imageReader2 = this.mImageReader;
                if (imageReader2 != null) {
                    imageReader2.setOnImageAvailableListener((ImageReader.OnImageAvailableListener) null, (Handler) null);
                    this.mImageReader.close();
                    this.mImageReader = null;
                }
                CameraDevice cameraDevice2 = this.mCameraDevice;
                if (cameraDevice2 != null) {
                    cameraDevice2.close();
                    this.mCameraDevice = null;
                }
                return -1;
            } catch (IllegalStateException e2) {
                Logging.e(TAG, "abortCaptures: ", e2);
                ImageReader imageReader3 = this.mImageReader;
                if (imageReader3 != null) {
                    imageReader3.setOnImageAvailableListener((ImageReader.OnImageAvailableListener) null, (Handler) null);
                    this.mImageReader.close();
                    this.mImageReader = null;
                }
                CameraDevice cameraDevice3 = this.mCameraDevice;
                if (cameraDevice3 != null) {
                    cameraDevice3.close();
                    this.mCameraDevice = null;
                }
                return -1;
            } catch (IllegalArgumentException e3) {
                Logging.e(TAG, "abortCaptures: ", e3);
                ImageReader imageReader4 = this.mImageReader;
                if (imageReader4 != null) {
                    imageReader4.setOnImageAvailableListener((ImageReader.OnImageAvailableListener) null, (Handler) null);
                    this.mImageReader.close();
                    this.mImageReader = null;
                }
                CameraDevice cameraDevice4 = this.mCameraDevice;
                if (cameraDevice4 != null) {
                    cameraDevice4.close();
                    this.mCameraDevice = null;
                }
                return -1;
            } catch (Exception e4) {
                try {
                    Logging.e(TAG, "abortCaptures: ", e4);
                    return -1;
                } finally {
                    ImageReader imageReader5 = this.mImageReader;
                    if (imageReader5 != null) {
                        imageReader5.setOnImageAvailableListener((ImageReader.OnImageAvailableListener) null, (Handler) null);
                        this.mImageReader.close();
                        this.mImageReader = null;
                    }
                    CameraDevice cameraDevice5 = this.mCameraDevice;
                    if (cameraDevice5 != null) {
                        cameraDevice5.close();
                        this.mCameraDevice = null;
                    }
                }
            }
        }
        ImageReader imageReader6 = this.mImageReader;
        if (imageReader6 != null) {
            imageReader6.setOnImageAvailableListener((ImageReader.OnImageAvailableListener) null, (Handler) null);
            this.mImageReader.close();
            this.mImageReader = null;
        }
        AgoraVideoDebugger.reset();
        this.mDroppedTextureBufferCount = 0;
        if (this.mTextureAndRawBufferSynchronizer != null) {
            this.mTextureAndRawBufferSynchronizer.reset();
        }
        if (this.mSurfaceTextureHelper != null) {
            this.mSurfaceTextureHelper.stopListening();
            this.mSurfaceTextureHelper.dispose();
            this.mSurfaceTextureHelper = null;
            this.mEglContext = null;
        }
        Surface surface = this.mTextureOutputSurface;
        if (surface != null) {
            surface.release();
            this.mTextureOutputSurface = null;
        }
        CameraDevice cameraDevice6 = this.mCameraDevice;
        if (cameraDevice6 != null) {
            cameraDevice6.close();
            this.mCameraDevice = null;
        }
        return 0;
    }

    public int UnRegisterNativeHandle() {
        this.mNativeVideoCaptureDeviceAndroid = 0;
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r0 != null) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (io.agora.rtc.video.VideoCapture.fetchCapability(r8.mId, r8.mContext, getCaptureName()) != null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        createCapabilities(r8.mId, r8.mContext);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        if (r8.mNativeVideoCaptureDeviceAndroid == 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        r8.mIsAutoFaceFocusEnabled = isAutoFaceFocusEnabled(r8.mNativeVideoCaptureDeviceAndroid);
        r8.faceDistaneEnabled = isFaceDetectionEnabled(r8.mNativeVideoCaptureDeviceAndroid);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004c, code lost:
        r8.mCameraNativeOrientation = ((java.lang.Integer) r0.get(android.hardware.camera2.CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        r8.mManager = (android.hardware.camera2.CameraManager) r8.mContext.getSystemService("camera");
        r1 = (int[]) r0.get(android.hardware.camera2.CameraCharacteristics.STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES);
        r0 = ((java.lang.Integer) r0.get(android.hardware.camera2.CameraCharacteristics.STATISTICS_INFO_MAX_FACE_COUNT)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007d, code lost:
        if (r1.length <= 1) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007f, code lost:
        if (r0 <= 0) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0081, code lost:
        r8.mFaceDetectSupported = true;
        r2 = r1.length;
        r5 = 0;
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0086, code lost:
        if (r5 >= r2) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0088, code lost:
        r6 = r6 + r1[r5];
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0090, code lost:
        if ((r6 % 2) == 0) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0092, code lost:
        r8.mFaceDetectMode = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0095, code lost:
        r8.mFaceDetectMode = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0097, code lost:
        io.agora.rtc.internal.Logging.i(TAG, "allocate() face detection: " + r8.mFaceDetectMode + " " + r0 + " " + r8.mFaceDetectSupported);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c3, code lost:
        if (r8.mCameraStateThread != null) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c5, code lost:
        r0 = new android.os.HandlerThread("CameraCallbackThread");
        r8.mCameraStateThread = r0;
        r0.start();
        r8.mStateHandler = new android.os.Handler(r8.mCameraStateThread.getLooper());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00de, code lost:
        r8.mManager.registerAvailabilityCallback(r8.mAvailabilityCallback, r8.mStateHandler);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e7, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r0 = getCameraCharacteristics(r8.mContext, r8.mId);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int allocate() {
        /*
            r8 = this;
            java.lang.Object r0 = r8.mCameraStateLock
            monitor-enter(r0)
            io.agora.rtc.video.VideoCaptureCamera2$CameraState r1 = r8.mCameraState     // Catch:{ all -> 0x00e8 }
            io.agora.rtc.video.VideoCaptureCamera2$CameraState r2 = io.agora.rtc.video.VideoCaptureCamera2.CameraState.OPENING     // Catch:{ all -> 0x00e8 }
            r3 = -1
            if (r1 != r2) goto L_0x0013
            java.lang.String r1 = "CAMERA2"
            java.lang.String r2 = "allocate() invoked while Camera is busy opening/configuring"
            io.agora.rtc.internal.Logging.e(r1, r2)     // Catch:{ all -> 0x00e8 }
            monitor-exit(r0)     // Catch:{ all -> 0x00e8 }
            return r3
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x00e8 }
            android.content.Context r0 = r8.mContext
            int r1 = r8.mId
            android.hardware.camera2.CameraCharacteristics r0 = getCameraCharacteristics(r0, r1)
            if (r0 != 0) goto L_0x001f
            return r3
        L_0x001f:
            int r1 = r8.mId
            android.content.Context r2 = r8.mContext
            java.lang.String r3 = getCaptureName()
            java.lang.String r1 = io.agora.rtc.video.VideoCapture.fetchCapability(r1, r2, r3)
            if (r1 != 0) goto L_0x0034
            int r1 = r8.mId
            android.content.Context r2 = r8.mContext
            createCapabilities(r1, r2)
        L_0x0034:
            long r1 = r8.mNativeVideoCaptureDeviceAndroid
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x004c
            long r1 = r8.mNativeVideoCaptureDeviceAndroid
            boolean r1 = r8.isAutoFaceFocusEnabled(r1)
            r8.mIsAutoFaceFocusEnabled = r1
            long r1 = r8.mNativeVideoCaptureDeviceAndroid
            boolean r1 = r8.isFaceDetectionEnabled(r1)
            r8.faceDistaneEnabled = r1
        L_0x004c:
            android.hardware.camera2.CameraCharacteristics$Key r1 = android.hardware.camera2.CameraCharacteristics.SENSOR_ORIENTATION
            java.lang.Object r1 = r0.get(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r8.mCameraNativeOrientation = r1
            android.content.Context r1 = r8.mContext
            java.lang.String r2 = "camera"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.hardware.camera2.CameraManager r1 = (android.hardware.camera2.CameraManager) r1
            r8.mManager = r1
            android.hardware.camera2.CameraCharacteristics$Key r1 = android.hardware.camera2.CameraCharacteristics.STATISTICS_INFO_AVAILABLE_FACE_DETECT_MODES
            java.lang.Object r1 = r0.get(r1)
            int[] r1 = (int[]) r1
            android.hardware.camera2.CameraCharacteristics$Key r2 = android.hardware.camera2.CameraCharacteristics.STATISTICS_INFO_MAX_FACE_COUNT
            java.lang.Object r0 = r0.get(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r2 = r1.length
            r3 = 0
            r4 = 1
            if (r2 <= r4) goto L_0x0097
            if (r0 <= 0) goto L_0x0097
            r8.mFaceDetectSupported = r4
            int r2 = r1.length
            r5 = r3
            r6 = r5
        L_0x0086:
            if (r5 >= r2) goto L_0x008e
            r7 = r1[r5]
            int r6 = r6 + r7
            int r5 = r5 + 1
            goto L_0x0086
        L_0x008e:
            r1 = 2
            int r6 = r6 % r1
            if (r6 == 0) goto L_0x0095
            r8.mFaceDetectMode = r4
            goto L_0x0097
        L_0x0095:
            r8.mFaceDetectMode = r1
        L_0x0097:
            java.lang.String r1 = "CAMERA2"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "allocate() face detection: "
            r2.append(r4)
            int r4 = r8.mFaceDetectMode
            r2.append(r4)
            java.lang.String r4 = " "
            r2.append(r4)
            r2.append(r0)
            java.lang.String r0 = " "
            r2.append(r0)
            boolean r0 = r8.mFaceDetectSupported
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            io.agora.rtc.internal.Logging.i(r1, r0)
            android.os.HandlerThread r0 = r8.mCameraStateThread
            if (r0 != 0) goto L_0x00de
            android.os.HandlerThread r0 = new android.os.HandlerThread
            java.lang.String r1 = "CameraCallbackThread"
            r0.<init>(r1)
            r8.mCameraStateThread = r0
            r0.start()
            android.os.Handler r0 = new android.os.Handler
            android.os.HandlerThread r1 = r8.mCameraStateThread
            android.os.Looper r1 = r1.getLooper()
            r0.<init>(r1)
            r8.mStateHandler = r0
        L_0x00de:
            android.hardware.camera2.CameraManager r0 = r8.mManager
            android.hardware.camera2.CameraManager$AvailabilityCallback r1 = r8.mAvailabilityCallback
            android.os.Handler r2 = r8.mStateHandler
            r0.registerAvailabilityCallback(r1, r2)
            return r3
        L_0x00e8:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00e8 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.video.VideoCaptureCamera2.allocate():int");
    }

    public int setCaptureFormat(int i, int i2, boolean z) {
        Logging.i(TAG, "setCaptureFormat: " + i + " type: " + i2 + " force texture oes: " + z);
        VideoCapture.FORCE_ENC_TEXTURE_OES = z;
        this.mCaptureOutputDataType = translateToCaptureOutputDataType(i2);
        if (translateToAndroidFormat(i) == this.mCaptureFormat) {
            return 0;
        }
        Logging.e(TAG, "For camera2 api, only YUV_420_888 format are supported");
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005a, code lost:
        changeCameraStateAndNotify(io.agora.rtc.video.VideoCaptureCamera2.CameraState.OPENING);
        r4 = tryOpenCamera();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
        if (r4 == 0) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0065, code lost:
        changeCameraStateAndNotify(io.agora.rtc.video.VideoCaptureCamera2.CameraState.STOPPED);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006a, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int startCapture(int r4, int r5, int r6) {
        /*
            r3 = this;
            java.lang.String r0 = "CAMERA2"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "startCapture, w="
            r1.append(r2)
            r1.append(r4)
            java.lang.String r2 = ", h="
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = ", fps="
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            io.agora.rtc.internal.Logging.i(r0, r1)
            r3.mCaptureWidth = r4
            r3.mCaptureHeight = r5
            r3.mCaptureFps = r6
            java.lang.Object r4 = r3.mCameraStateLock
            monitor-enter(r4)
        L_0x002f:
            io.agora.rtc.video.VideoCaptureCamera2$CameraState r5 = r3.mCameraState     // Catch:{ all -> 0x006b }
            io.agora.rtc.video.VideoCaptureCamera2$CameraState r6 = io.agora.rtc.video.VideoCaptureCamera2.CameraState.STARTED     // Catch:{ all -> 0x006b }
            if (r5 == r6) goto L_0x0050
            io.agora.rtc.video.VideoCaptureCamera2$CameraState r5 = r3.mCameraState     // Catch:{ all -> 0x006b }
            io.agora.rtc.video.VideoCaptureCamera2$CameraState r6 = io.agora.rtc.video.VideoCaptureCamera2.CameraState.EVICTED     // Catch:{ all -> 0x006b }
            if (r5 == r6) goto L_0x0050
            io.agora.rtc.video.VideoCaptureCamera2$CameraState r5 = r3.mCameraState     // Catch:{ all -> 0x006b }
            io.agora.rtc.video.VideoCaptureCamera2$CameraState r6 = io.agora.rtc.video.VideoCaptureCamera2.CameraState.STOPPED     // Catch:{ all -> 0x006b }
            if (r5 == r6) goto L_0x0050
            java.lang.Object r5 = r3.mCameraStateLock     // Catch:{ InterruptedException -> 0x0047 }
            r5.wait()     // Catch:{ InterruptedException -> 0x0047 }
            goto L_0x002f
        L_0x0047:
            r5 = move-exception
            java.lang.String r6 = "CAMERA2"
            java.lang.String r0 = "CaptureStartedEvent: "
            io.agora.rtc.internal.Logging.e(r6, r0, r5)     // Catch:{ all -> 0x006b }
            goto L_0x002f
        L_0x0050:
            io.agora.rtc.video.VideoCaptureCamera2$CameraState r5 = r3.mCameraState     // Catch:{ all -> 0x006b }
            io.agora.rtc.video.VideoCaptureCamera2$CameraState r6 = io.agora.rtc.video.VideoCaptureCamera2.CameraState.STARTED     // Catch:{ all -> 0x006b }
            if (r5 != r6) goto L_0x0059
            r5 = 0
            monitor-exit(r4)     // Catch:{ all -> 0x006b }
            return r5
        L_0x0059:
            monitor-exit(r4)     // Catch:{ all -> 0x006b }
            io.agora.rtc.video.VideoCaptureCamera2$CameraState r4 = io.agora.rtc.video.VideoCaptureCamera2.CameraState.OPENING
            r3.changeCameraStateAndNotify(r4)
            int r4 = r3.tryOpenCamera()
            if (r4 == 0) goto L_0x006a
            io.agora.rtc.video.VideoCaptureCamera2$CameraState r5 = io.agora.rtc.video.VideoCaptureCamera2.CameraState.STOPPED
            r3.changeCameraStateAndNotify(r5)
        L_0x006a:
            return r4
        L_0x006b:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x006b }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.video.VideoCaptureCamera2.startCapture(int, int, int):int");
    }

    public int stopCapture() {
        Logging.i(TAG, "stopCapture");
        synchronized (this.mCameraStateLock) {
            while (this.mCameraState != CameraState.STARTED && this.mCameraState != CameraState.EVICTED && this.mCameraState != CameraState.STOPPED) {
                try {
                    this.mCameraStateLock.wait();
                } catch (InterruptedException e) {
                    Logging.e(TAG, "CaptureStartedEvent: ", e);
                }
            }
            if (this.mCameraState == CameraState.EVICTED) {
                this.mCameraState = CameraState.STOPPED;
            }
            if (this.mCameraState == CameraState.STOPPED) {
                return 0;
            }
            doStopCapture();
            this.mCameraState = CameraState.STOPPED;
            this.mCameraStateLock.notifyAll();
            return 0;
        }
    }

    public boolean isTorchSupported() {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            Logging.w(TAG, "warning cameraCharacteristics is null");
            return false;
        }
        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isFocusSupported() {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            Logging.w(TAG, "warning cameraCharacteristics is null");
            return false;
        }
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (iArr != null) {
            for (int i = 0; i < iArr.length; i++) {
                if (1 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isExposureSupported() {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            Logging.w(TAG, "warning cameraCharacteristics is null");
            return false;
        }
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        if (iArr != null) {
            for (int i = 0; i < iArr.length; i++) {
                Logging.d(TAG, "isExposureSupported AE mode = " + iArr[i]);
                if (1 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isZoomSupported() {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            Logging.w(TAG, "warning cameraCharacteristics is null");
            return false;
        } else if (((Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue() > 1.0f) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAutoFaceFocusSupported() {
        if (!isFocusSupported()) {
            return false;
        }
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            Logging.w(TAG, "warning cameraCharacteristics is null");
            return false;
        } else if (((Integer) cameraCharacteristics.get(CameraCharacteristics.STATISTICS_INFO_MAX_FACE_COUNT)).intValue() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int setZoom(float f) {
        Log.d("zoom", "setCameraZoom api2 called zoomValue =" + f);
        if (this.mPreviewBuilder == null) {
            Logging.d(TAG, "setZoom mPreviewBuilder is null");
            return -1;
        }
        if (this.mSensorRect == null) {
            CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
            if (cameraCharacteristics == null) {
                Logging.w(TAG, "warning cameraCharacteristics is null");
                return -1;
            }
            this.mSensorRect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            this.mMaxZoom = ((Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
        }
        if (Math.abs(this.mMaxZoom - 1.0f) < 0.001f) {
            Logging.w(TAG, "Camera " + this.mId + " does not support camera zoom");
            return -1;
        }
        this.mCurZoomRatio = f;
        if (!(f >= 1.0f && f <= this.mMaxZoom && f != this.mLastZoomRatio)) {
            return -2;
        }
        Rect cropRegionForZoom = cropRegionForZoom(f);
        CaptureRequest.Builder builder = this.mPreviewBuilder;
        if (builder == null) {
            return -1;
        }
        builder.set(CaptureRequest.SCALER_CROP_REGION, cropRegionForZoom);
        this.mLastZoomRatio = this.mCurZoomRatio;
        if (this.mPreviewThread != null) {
            Handler handler = new Handler(this.mPreviewThread.getLooper());
            CameraCaptureSession cameraCaptureSession = this.mCaptureSession;
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), this.mCaptureCallback, handler);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                    return -3;
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                    return -4;
                }
            }
        }
        return 0;
    }

    public float getMaxZoom() {
        if (this.mMaxZoom <= CropImageView.DEFAULT_ASPECT_RATIO) {
            CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
            if (cameraCharacteristics == null) {
                Logging.w(TAG, "warning cameraCharacteristics is null");
                return DEFAULT_VALUE;
            }
            this.mMaxZoom = ((Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
        }
        return this.mMaxZoom;
    }

    public int setTorchMode(boolean z) {
        boolean z2;
        Log.d("flash", "setFlashMode isTorchOn " + z);
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            Logging.w(TAG, "warning cameraCharacteristics is null");
            return -1;
        } else if (this.mPreviewBuilder == null) {
            return -1;
        } else {
            Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
            if (bool == null) {
                z2 = false;
            } else {
                z2 = bool.booleanValue();
            }
            if (!z2) {
                Logging.w(TAG, "flash is not supported");
            } else if (!(this.mPreviewThread == null || this.mPreviewBuilder == null)) {
                Handler handler = new Handler(this.mPreviewThread.getLooper());
                if (z) {
                    this.mPreviewBuilder.set(CaptureRequest.FLASH_MODE, 2);
                } else {
                    this.mPreviewBuilder.set(CaptureRequest.FLASH_MODE, 0);
                }
                CameraCaptureSession cameraCaptureSession = this.mCaptureSession;
                if (cameraCaptureSession != null) {
                    try {
                        cameraCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), (CameraCaptureSession.CaptureCallback) null, handler);
                        return 0;
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    } catch (IllegalStateException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return -1;
        }
    }

    public int setFocus(float f, float f2, boolean z) {
        Rect rect;
        int i;
        int i2;
        float f3 = f;
        float f4 = f2;
        if (f3 < CropImageView.DEFAULT_ASPECT_RATIO || f3 > 1.0f || f4 < CropImageView.DEFAULT_ASPECT_RATIO || f4 > 1.0f) {
            Logging.e(TAG, "set focus unreasonable inputs");
            return -1;
        }
        CaptureRequest.Builder builder = this.mPreviewBuilder;
        if (builder == null) {
            Logging.d(TAG, "setFocus mPreviewBuilder is null");
            return -1;
        }
        double d = (double) f3;
        double d2 = (double) f4;
        if (builder == null || (rect = (Rect) builder.get(CaptureRequest.SCALER_CROP_REGION)) == null) {
            return -1;
        }
        int width = rect.width();
        int height = rect.height();
        Log.d("test", "crop width = " + width + " crop height = " + height + " capture width = " + this.mCaptureWidth + " capture height = " + this.mCaptureHeight);
        int i3 = this.mCaptureHeight;
        int i4 = width * i3;
        int i5 = this.mCaptureWidth;
        if (i4 > height * i5) {
            int i6 = (i5 * height) / i3;
            i2 = (int) (((double) (((float) (width - i6)) / 2.0f)) + (d * ((double) i6)));
            i = (int) (d2 * ((double) height));
        } else {
            int i7 = (i3 * width) / i5;
            int i8 = (int) (d * ((double) width));
            i = (int) (((double) (((float) (height - i7)) / 2.0f)) + (d2 * ((double) i7)));
            i2 = i8;
        }
        Rect rect2 = new Rect();
        double d3 = (double) i2;
        double d4 = ((double) width) * 0.05d;
        rect2.left = clamp((int) (d3 - d4), 0, width);
        rect2.right = clamp((int) (d3 + d4), 0, width);
        double d5 = (double) i;
        double d6 = ((double) height) * 0.05d;
        rect2.top = clamp((int) (d5 - d6), 0, height);
        rect2.bottom = clamp((int) (d5 + d6), 0, height);
        this.mPreviewBuilder.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect2, 1000)});
        this.mPreviewBuilder.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect2, 1000)});
        this.mPreviewBuilder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        this.mPreviewBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        this.mPreviewBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
        if (this.mPreviewThread != null) {
            Handler handler = new Handler(this.mPreviewThread.getLooper());
            CameraCaptureSession cameraCaptureSession = this.mCaptureSession;
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), this.mAfCaptureCallback, handler);
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                    return -1;
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                    return -1;
                }
            }
            if (this.mNativeVideoCaptureDeviceAndroid != 0) {
                NotifyCameraFocusAreaChanged(f, f2, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, this.mNativeVideoCaptureDeviceAndroid);
            }
        }
        return 0;
    }

    public int setExposure(float f, float f2, boolean z) {
        int i;
        int i2;
        float f3 = f;
        float f4 = f2;
        Logging.d(TAG, "setExposure called camera api2");
        if (f3 < CropImageView.DEFAULT_ASPECT_RATIO || f3 > 1.0f || f4 < CropImageView.DEFAULT_ASPECT_RATIO || f4 > 1.0f) {
            Logging.e(TAG, "set exposure unreasonable inputs");
            return -1;
        }
        CaptureRequest.Builder builder = this.mPreviewBuilder;
        if (builder == null) {
            Logging.d(TAG, "setExposure mPreviewBuilder is null");
            return -1;
        }
        double d = (double) f3;
        double d2 = (double) f4;
        Rect rect = (Rect) builder.get(CaptureRequest.SCALER_CROP_REGION);
        if (rect == null) {
            return -1;
        }
        int width = rect.width();
        int height = rect.height();
        Logging.d(TAG, "crop width = " + width + " crop height = " + height + " capture width = " + this.mCaptureWidth + " capture height = " + this.mCaptureHeight);
        int i3 = this.mCaptureHeight;
        int i4 = width * i3;
        int i5 = this.mCaptureWidth;
        if (i4 > height * i5) {
            int i6 = (i5 * height) / i3;
            i2 = (int) (((double) (((float) (width - i6)) / 2.0f)) + (d * ((double) i6)));
            i = (int) (d2 * ((double) height));
        } else {
            int i7 = (i3 * width) / i5;
            int i8 = (int) (d * ((double) width));
            i = (int) (((double) (((float) (height - i7)) / 2.0f)) + (d2 * ((double) i7)));
            i2 = i8;
        }
        Rect rect2 = new Rect();
        double d3 = (double) i2;
        double d4 = ((double) width) * 0.05d;
        rect2.left = clamp((int) (d3 - d4), 0, width);
        rect2.right = clamp((int) (d3 + d4), 0, width);
        double d5 = (double) i;
        double d6 = ((double) height) * 0.05d;
        rect2.top = clamp((int) (d5 - d6), 0, height);
        rect2.bottom = clamp((int) (d5 + d6), 0, height);
        this.mPreviewBuilder.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(rect2, 1000)});
        this.mPreviewBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
        CameraCaptureSession cameraCaptureSession = this.mCaptureSession;
        if (cameraCaptureSession != null) {
            try {
                cameraCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), (CameraCaptureSession.CaptureCallback) null, (Handler) null);
            } catch (CameraAccessException e) {
                e.printStackTrace();
                return -1;
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                return -1;
            }
        }
        if (this.mNativeVideoCaptureDeviceAndroid != 0) {
            NotifyCameraExposureAreaChanged(f, f2, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, this.mNativeVideoCaptureDeviceAndroid);
        }
        return 0;
    }

    public int setAutoFaceFocus(boolean z) {
        boolean z2 = this.mIsAutoFaceFocusEnabled != z;
        this.mIsAutoFaceFocusEnabled = z;
        if (!this.mFaceDetectSupported || !z2) {
            Logging.w(TAG, "face detect no change");
        } else if (!(this.mPreviewThread == null || this.mPreviewBuilder == null)) {
            Handler handler = new Handler(this.mPreviewThread.getLooper());
            if (this.mIsAutoFaceFocusEnabled) {
                this.mPreviewBuilder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, Integer.valueOf(this.mFaceDetectMode));
            } else if (this.faceDistaneEnabled) {
                Logging.w(TAG, "face detect did not turn off due to faceDistance on");
                return 0;
            } else {
                this.mPreviewBuilder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, 0);
            }
            CameraCaptureSession cameraCaptureSession = this.mCaptureSession;
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), this.mCaptureCallback, handler);
                    return 0;
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return 0;
    }

    public int setFaceDetection(boolean z) {
        boolean z2 = this.faceDistaneEnabled != z;
        this.faceDistaneEnabled = z;
        if (!this.mFaceDetectSupported || !z2) {
            Logging.w(TAG, "face detect no change");
        } else if (!(this.mPreviewThread == null || this.mPreviewBuilder == null)) {
            Handler handler = new Handler(this.mPreviewThread.getLooper());
            if (this.faceDistaneEnabled) {
                this.mPreviewBuilder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, Integer.valueOf(this.mFaceDetectMode));
            } else if (this.mIsAutoFaceFocusEnabled) {
                Logging.w(TAG, "face detect did not turn off due to autoFocus on");
                return 0;
            } else {
                this.mPreviewBuilder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, 0);
            }
            CameraCaptureSession cameraCaptureSession = this.mCaptureSession;
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), this.mCaptureCallback, handler);
                    return 0;
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return 0;
    }

    public void deallocate() {
        Logging.i(TAG, "deallocate");
        CameraManager cameraManager = this.mManager;
        if (cameraManager != null) {
            cameraManager.unregisterAvailabilityCallback(this.mAvailabilityCallback);
            HandlerThread handlerThread = this.mCameraStateThread;
            if (handlerThread != null) {
                handlerThread.quitSafely();
                this.mCameraStateThread = null;
                this.mStateHandler = null;
            }
        }
    }

    private void setFaceDetect(CaptureRequest.Builder builder, int i) {
        if (!this.mFaceDetectSupported) {
            return;
        }
        if (this.mIsAutoFaceFocusEnabled || this.faceDistaneEnabled) {
            builder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, Integer.valueOf(i));
        }
    }

    public static int createCapabilities(int i, Context context) {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(context, i);
        if (cameraCharacteristics == null) {
            return -1;
        }
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            Logging.e(TAG, "Failed to create capabilities");
            return -1;
        }
        try {
            Logging.i(TAG, "dump configuration map:" + streamConfigurationMap.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(streamConfigurationMap.getOutputSizes(35)));
        if ("SM-G9300".equals(Build.MODEL)) {
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (((Size) arrayList.get(i2)).getHeight() >= 720) {
                    arrayList2.add(arrayList.get(i2));
                }
            }
            arrayList = arrayList2;
        }
        String str = "\"id\":" + i + ",";
        String valueOf = String.valueOf(15);
        Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        if (rangeArr != null) {
            ArrayList arrayList3 = new ArrayList();
            for (Range upper : rangeArr) {
                arrayList3.add(upper.getUpper());
            }
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                sb.append(((Integer) it.next()) + ",");
            }
            if (arrayList3.size() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            valueOf = sb.toString();
        }
        String str2 = "";
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            int width = ((Size) arrayList.get(i3)).getWidth();
            int height = ((Size) arrayList.get(i3)).getHeight();
            if (width >= 240 && height >= 240 && (width >= 320 || height >= 320)) {
                String str3 = "{\"w\":" + width + ",\"h\":" + height + "}";
                if (!str2.isEmpty()) {
                    str2 = str2 + "," + str3;
                } else {
                    str2 = str3;
                }
            }
        }
        cacheCapability(i, context, "{" + str + "\"resolution\":" + "[" + str2 + "]," + "\"format\":" + "[" + ("" + translateToEngineFormat(35)) + "]," + "\"fps\":" + "[" + valueOf + "]}", getCaptureName());
        return 0;
    }

    private Rect cropRegionForZoom(float f) {
        int width = this.mSensorRect.width() / 2;
        int height = this.mSensorRect.height() / 2;
        int width2 = (int) ((((float) this.mSensorRect.width()) * 0.5f) / f);
        int height2 = (int) ((((float) this.mSensorRect.height()) * 0.5f) / f);
        return new Rect(width - width2, height - height2, width + width2, height + height2);
    }

    private static int clamp(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    private boolean isMeteringAreaAFSupported() {
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            Logging.w(TAG, "warning cameraCharacteristics is null");
            return false;
        } else if (((Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() >= 1) {
            return true;
        } else {
            return false;
        }
    }

    public void onTextureFrameAvailable(int i, float[] fArr, long j) {
        int frameOrientation = getFrameOrientation();
        if (this.mIsCameraFacingFront) {
            fArr = RendererCommon.multiplyMatrices(fArr, RendererCommon.horizontalFlipMatrix());
        }
        VideoFrame.TextureBuffer createTextureBuffer = this.mSurfaceTextureHelper.createTextureBuffer(this.mCaptureWidth, this.mCaptureHeight, RendererCommon.convertMatrixToAndroidGraphicsMatrix(RendererCommon.rotateTextureMatrix(fArr, (float) (360 - frameOrientation))));
        onTextureBufferAvailable(createTextureBuffer, frameOrientation, j);
        createTextureBuffer.release();
    }

    private int getFrameOrientation() {
        int checkOrientation = checkOrientation();
        if (!this.mIsCameraFacingFront) {
            checkOrientation = 360 - checkOrientation;
        }
        return (getSensorOrientation(this.mId, this.mContext) + checkOrientation) % 360;
    }

    public int setAntiBandingMode(int i) {
        this.mAntiBandingMode = toCamera2ABMode(i);
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            return -1;
        }
        int i2 = this.mAntiBandingMode;
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_ANTIBANDING_MODES);
        if (iArr.length > 0) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    if (!(this.mPreviewThread == null || this.mPreviewBuilder == null)) {
                        Handler handler = new Handler(this.mPreviewThread.getLooper());
                        this.mPreviewBuilder.set(CaptureRequest.CONTROL_AE_ANTIBANDING_MODE, Integer.valueOf(i2));
                        CameraCaptureSession cameraCaptureSession = this.mCaptureSession;
                        if (cameraCaptureSession != null) {
                            try {
                                cameraCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), this.mCaptureCallback, handler);
                                return 0;
                            } catch (CameraAccessException e) {
                                e.printStackTrace();
                            } catch (IllegalStateException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    Logging.i(TAG, "AgoraVideo set anti-banding = " + i2);
                    return 0;
                }
            }
        }
        Logging.i(TAG, "not supported anti-banding = " + i2);
        return -1;
    }

    public int setExposureCompensation(int i) {
        setExposureCompensation_l(i);
        return 0;
    }

    public int setNoiseReductionMode(int i) {
        this.mNoiseReductionMode = toCamera2NoiseMode(i);
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            return -1;
        }
        if (!(!isSupported(this.mNoiseReductionMode, (int[]) cameraCharacteristics.get(CameraCharacteristics.NOISE_REDUCTION_AVAILABLE_NOISE_REDUCTION_MODES)) || this.mPreviewThread == null || this.mPreviewBuilder == null)) {
            Handler handler = new Handler(this.mPreviewThread.getLooper());
            this.mPreviewBuilder.set(CaptureRequest.NOISE_REDUCTION_MODE, Integer.valueOf(this.mNoiseReductionMode));
            if (this.mCaptureSession != null) {
                try {
                    Logging.i(TAG, "setNoiseReductionMode = " + i);
                    this.mCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), this.mCaptureCallback, handler);
                    return 0;
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                }
            }
        }
        Logging.e(TAG, "not supported NoiseReductionMode = " + i);
        return -1;
    }

    public int setEdgeEnhanceMode(int i) {
        this.mEdgeEnhanceMode = toCamera2EdgeEnhanceMode(i);
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            return -1;
        }
        if (!(!isSupported(this.mEdgeEnhanceMode, (int[]) cameraCharacteristics.get(CameraCharacteristics.EDGE_AVAILABLE_EDGE_MODES)) || this.mPreviewThread == null || this.mPreviewBuilder == null)) {
            Handler handler = new Handler(this.mPreviewThread.getLooper());
            this.mPreviewBuilder.set(CaptureRequest.EDGE_MODE, Integer.valueOf(this.mEdgeEnhanceMode));
            if (this.mCaptureSession != null) {
                try {
                    Logging.i(TAG, "setEdgeEnhanceMode = " + i);
                    this.mCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), this.mCaptureCallback, handler);
                    return 0;
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                }
            }
        }
        Logging.e(TAG, "not supported EdgeEnhance Mode = " + i);
        return -1;
    }

    public int setVideoStabilityMode(int i) {
        this.mVideoStabilityMode = toCamera2VideoStabilityMode(i);
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics == null) {
            return -1;
        }
        if (!(!isSupported(this.mVideoStabilityMode, (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES)) || this.mPreviewThread == null || this.mPreviewBuilder == null)) {
            Handler handler = new Handler(this.mPreviewThread.getLooper());
            this.mPreviewBuilder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, Integer.valueOf(this.mVideoStabilityMode));
            if (this.mCaptureSession != null) {
                try {
                    Logging.i(TAG, "setVideoStabilityMode = " + i);
                    this.mCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), this.mCaptureCallback, handler);
                    return 0;
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                }
            }
        }
        Logging.e(TAG, "not supported VideoStability Mode = " + i);
        return -1;
    }

    private void setExposureCompensation_l(int i) {
        Logging.i(TAG, "setExposureCompensation:" + i);
        CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mContext, this.mId);
        if (cameraCharacteristics != null) {
            Rational rational = (Rational) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
            Range range = (Range) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
            int intValue = ((Integer) range.getUpper()).intValue();
            int intValue2 = ((Integer) range.getLower()).intValue();
            Logging.i(TAG, "compensation step=" + rational + ", min=" + intValue2 + ", max=" + intValue);
            if (i > intValue) {
                i = intValue;
            }
            if (i >= intValue2) {
                intValue2 = i;
            }
            if (this.mPreviewThread != null && this.mPreviewBuilder != null) {
                Handler handler = new Handler(this.mPreviewThread.getLooper());
                int intValue3 = ((Integer) this.mPreviewBuilder.get(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION)).intValue();
                Logging.i(TAG, "bf cur index=" + intValue3);
                this.mPreviewBuilder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(intValue2));
                CameraCaptureSession cameraCaptureSession = this.mCaptureSession;
                if (cameraCaptureSession != null) {
                    try {
                        cameraCaptureSession.setRepeatingRequest(this.mPreviewBuilder.build(), this.mCaptureCallback, handler);
                        int intValue4 = ((Integer) this.mPreviewBuilder.get(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION)).intValue();
                        Logging.i(TAG, "af cur index=" + intValue4 + ", ev=" + ((intValue4 * rational.getNumerator()) / rational.getDenominator()));
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    } catch (IllegalStateException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    private static boolean isSupported(int i, int[] iArr) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
