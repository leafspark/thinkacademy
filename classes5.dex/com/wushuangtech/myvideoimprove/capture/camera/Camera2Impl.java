package com.wushuangtech.myvideoimprove.capture.camera;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import com.wushuangtech.myvideoimprove.bean.VideoCapCameraConfigureBean;
import com.wushuangtech.myvideoimprove.capture.camera.BaseCameraInterImpl;
import com.wushuangtech.myvideoimprove.utils.MyCameraUtils;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Camera2Impl extends BaseCameraInterImpl {
    private static final String TAG = "Camera2Impl";
    private Handler mBackgroundHandler;
    private HandlerThread mBackgroundThread;
    /* access modifiers changed from: private */
    public CameraCaptureSession mCameraCaptureSession;
    /* access modifiers changed from: private */
    public boolean mCameraCaptureSessionConfigured;
    /* access modifiers changed from: private */
    public boolean mCameraCaptureSessionError;
    private int mCameraCaptureStartError;
    private boolean mCameraCaptureStarted;
    private CameraCharacteristics mCameraCharacteristics;
    /* access modifiers changed from: private */
    public int mCameraConfigureErrorCode;
    /* access modifiers changed from: private */
    public boolean mCameraConfigured;
    /* access modifiers changed from: private */
    public CameraDevice mCameraDevice;
    private int mCameraFps;
    private boolean mCameraOpenFlash;
    private boolean mCameraOpened;
    private CaptureRequest mCaptureRequest;
    private CaptureRequest.Builder mCaptureRequestBuilder;
    private String mCurrentCameraId;
    private LocalCaptureCallback mLocalCaptureCallback = new LocalCaptureCallback(this);
    private LocalCaptureSessionStateCallback mLocalCaptureSessionStateCallback = new LocalCaptureSessionStateCallback(this);
    private LocalStateCallback mLocalStateCallback = new LocalStateCallback(this);
    private Surface mPreviewSurface;
    private List<Surface> mSurfaces = new ArrayList();

    private void createImageReader() {
    }

    public VideoCapCameraConfigureBean initCamera(BaseCameraInterImpl.CameraParams cameraParams) {
        VideoCapCameraConfigureBean videoCapCameraConfigureBean = new VideoCapCameraConfigureBean();
        Context context = cameraParams.mContext;
        int i = cameraParams.cameraId;
        if (context == null) {
            videoCapCameraConfigureBean.mCameraOpenResult = -1;
            OmniLog.lpe(TAG, "Context is null!");
            return videoCapCameraConfigureBean;
        }
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        if (cameraManager == null) {
            videoCapCameraConfigureBean.mCameraOpenResult = -2;
            Log.e(TAG, "CameraManager obj is null!");
            return videoCapCameraConfigureBean;
        }
        String autoSelectCamera2ID = MyCameraUtils.autoSelectCamera2ID(context, i);
        if (autoSelectCamera2ID == null) {
            videoCapCameraConfigureBean.mCameraOpenResult = -3;
            OmniLog.lpe(TAG, "Camera2 id is null! " + i);
            return videoCapCameraConfigureBean;
        }
        if (this.mBackgroundThread == null || this.mBackgroundHandler == null) {
            HandlerThread handlerThread = new HandlerThread("Camera2Background");
            this.mBackgroundThread = handlerThread;
            handlerThread.start();
            this.mBackgroundHandler = new Handler(this.mBackgroundThread.getLooper());
        }
        int i2 = 0;
        this.mCameraConfigured = false;
        try {
            cameraManager.openCamera(autoSelectCamera2ID, this.mLocalStateCallback, this.mBackgroundHandler);
            while (!this.mCameraConfigured) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i2 += 5;
                if (i2 > 5000) {
                    logE(TAG, "Configure camera2 is too slow! spend time : " + i2);
                    videoCapCameraConfigureBean.mCameraOpenResult = -5;
                    return videoCapCameraConfigureBean;
                }
            }
            int i3 = this.mCameraConfigureErrorCode;
            if (i3 != 0) {
                if (i3 == 1) {
                    videoCapCameraConfigureBean.mCameraOpenResult = -6;
                } else if (i3 == 2) {
                    videoCapCameraConfigureBean.mCameraOpenResult = -7;
                } else if (i3 == 3) {
                    videoCapCameraConfigureBean.mCameraOpenResult = -8;
                } else if (i3 == 4) {
                    videoCapCameraConfigureBean.mCameraOpenResult = -9;
                } else if (i3 == 5) {
                    videoCapCameraConfigureBean.mCameraOpenResult = -10;
                }
                return videoCapCameraConfigureBean;
            }
            try {
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(autoSelectCamera2ID);
                Size[] outputSizes = getOutputSizes(cameraManager, autoSelectCamera2ID);
                if (outputSizes == null) {
                    videoCapCameraConfigureBean.mCameraOpenResult = -12;
                    Log.e(TAG, "outputSizes obj is null!");
                    return videoCapCameraConfigureBean;
                }
                BaseCameraInterImpl.CameraPreSize findCloselyPreSize = findCloselyPreSize(cameraParams.width, cameraParams.height, getSupportedPreviewSizes(outputSizes));
                this.mCameraPreSize = new BaseCameraInterImpl.CameraPreSize(findCloselyPreSize.width, findCloselyPreSize.height);
                this.mCameraFps = cameraParams.fps;
                this.mCameraOpenFlash = cameraParams.openFlash;
                this.mCurrentCameraId = autoSelectCamera2ID;
                this.mCameraCharacteristics = cameraCharacteristics;
                return videoCapCameraConfigureBean;
            } catch (CameraAccessException | IllegalArgumentException e2) {
                videoCapCameraConfigureBean.mCameraOpenResult = -11;
                OmniLog.lpe(TAG, "Exception happened! " + e2.getLocalizedMessage());
                return videoCapCameraConfigureBean;
            }
        } catch (CameraAccessException | SecurityException unused) {
            videoCapCameraConfigureBean.mCameraOpenResult = -4;
            OmniLog.lpe(TAG, "not camera permission!");
            return videoCapCameraConfigureBean;
        }
    }

    public VideoCapCameraConfigureBean openCamera(VideoCapCameraConfigureBean videoCapCameraConfigureBean, SurfaceTexture surfaceTexture) {
        CameraDevice cameraDevice = this.mCameraDevice;
        CameraCharacteristics cameraCharacteristics = this.mCameraCharacteristics;
        List<Surface> list = this.mSurfaces;
        BaseCameraInterImpl.CameraPreSize cameraPreSize = this.mCameraPreSize;
        String str = this.mCurrentCameraId;
        if (cameraDevice == null || cameraCharacteristics == null || str == null) {
            videoCapCameraConfigureBean.mCameraOpenResult = -20;
            return videoCapCameraConfigureBean;
        } else if (cameraPreSize == null) {
            videoCapCameraConfigureBean.mCameraOpenResult = -21;
            Log.e(TAG, "CameraPreSize obj is null!");
            return videoCapCameraConfigureBean;
        } else {
            Surface surface = new Surface(surfaceTexture);
            surfaceTexture.setDefaultBufferSize(cameraPreSize.width, cameraPreSize.height);
            list.add(surface);
            int i = 0;
            this.mCameraCaptureSessionConfigured = false;
            try {
                cameraDevice.createCaptureSession(list, this.mLocalCaptureSessionStateCallback, this.mBackgroundHandler);
                while (!this.mCameraCaptureSessionConfigured) {
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i += 5;
                    if (i > 2000) {
                        logE(TAG, "Configure camera2 is too slow! spend time : " + i);
                        videoCapCameraConfigureBean.mCameraOpenResult = -23;
                        return videoCapCameraConfigureBean;
                    }
                }
                if (this.mCameraCaptureSessionError) {
                    videoCapCameraConfigureBean.mCameraOpenResult = -24;
                    return videoCapCameraConfigureBean;
                }
                try {
                    CaptureRequest.Builder createCaptureRequest = cameraDevice.createCaptureRequest(1);
                    for (Surface addTarget : this.mSurfaces) {
                        createCaptureRequest.addTarget(addTarget);
                    }
                    CaptureRequest build = createCaptureRequest.build();
                    try {
                        this.mCameraCaptureSession.setRepeatingRequest(build, this.mLocalCaptureCallback, this.mBackgroundHandler);
                        this.mPreviewSurface = surface;
                        this.mCaptureRequest = build;
                        this.mCaptureRequestBuilder = createCaptureRequest;
                        logI(TAG, "camera2 opend! " + cameraPreSize.width + " * " + cameraPreSize.height);
                        this.mCameraOpened = true;
                        return videoCapCameraConfigureBean;
                    } catch (Exception e2) {
                        OmniLog.lpe(TAG, "Exception hanppened! msg : " + e2.getLocalizedMessage());
                        videoCapCameraConfigureBean.mCameraOpenResult = -26;
                        return videoCapCameraConfigureBean;
                    }
                } catch (Exception e3) {
                    OmniLog.lpe(TAG, "Exception hanppened! msg : " + e3.getLocalizedMessage());
                    videoCapCameraConfigureBean.mCameraOpenResult = -25;
                    return videoCapCameraConfigureBean;
                }
            } catch (Exception e4) {
                OmniLog.lpe(TAG, "Exception hanppened! msg : " + e4.getLocalizedMessage());
                videoCapCameraConfigureBean.mCameraOpenResult = -22;
                surface.release();
                list.remove(surface);
                return videoCapCameraConfigureBean;
            }
        }
    }

    public void releaseCamera() {
        CameraCaptureSession cameraCaptureSession = this.mCameraCaptureSession;
        if (cameraCaptureSession != null) {
            cameraCaptureSession.close();
            this.mCameraCaptureSession = null;
        }
        CameraDevice cameraDevice = this.mCameraDevice;
        if (cameraDevice != null) {
            cameraDevice.close();
            this.mCameraDevice = null;
        }
        this.mCameraCharacteristics = null;
        this.mCaptureRequest = null;
        List<Surface> list = this.mSurfaces;
        if (list != null) {
            list.clear();
        }
        Surface surface = this.mPreviewSurface;
        if (surface != null) {
            surface.release();
            this.mPreviewSurface = null;
        }
        Handler handler = this.mBackgroundHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.mBackgroundHandler = null;
        }
        HandlerThread handlerThread = this.mBackgroundThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.mBackgroundThread = null;
        }
        this.mCameraOpened = false;
        this.mCurrentCameraId = null;
    }

    public boolean isCameraOpened() {
        return this.mCameraOpened;
    }

    public boolean startPreview() {
        CaptureRequest captureRequest;
        CameraCaptureSession cameraCaptureSession = this.mCameraCaptureSession;
        if (cameraCaptureSession == null || (captureRequest = this.mCaptureRequest) == null) {
            return true;
        }
        try {
            cameraCaptureSession.setRepeatingRequest(captureRequest, this.mLocalCaptureCallback, this.mBackgroundHandler);
            return false;
        } catch (CameraAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean stopPreview() {
        CameraCaptureSession cameraCaptureSession = this.mCameraCaptureSession;
        if (cameraCaptureSession == null) {
            return true;
        }
        try {
            cameraCaptureSession.stopRepeating();
            return true;
        } catch (CameraAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setCameraOrientation(int i) {
        super.setCameraOrientation(i);
        return true;
    }

    public boolean setCameraPreviewFps(int i) {
        this.mCameraParams.fps = i;
        return true;
    }

    public boolean setCameraParams(int i, int i2, int i3) {
        super.setCameraParams(i, i2, i3);
        return true;
    }

    public void setCameraZoom(int i) {
        Float f;
        Rect rect;
        if (i != 0) {
            CameraCharacteristics cameraCharacteristics = this.mCameraCharacteristics;
            CaptureRequest.Builder builder = this.mCaptureRequestBuilder;
            CameraCaptureSession cameraCaptureSession = this.mCameraCaptureSession;
            if (cameraCharacteristics != null && builder != null && cameraCaptureSession != null && (f = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)) != null && (rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE)) != null) {
                int intValue = f.intValue();
                int i2 = ((rect.right / intValue) * i) / 2;
                int i3 = ((rect.bottom / intValue) * i) / 2;
                Rect rect2 = new Rect();
                rect2.left = rect.left + i2;
                rect2.top = rect.top + i3;
                rect2.right = rect.right - i2;
                rect2.bottom = rect.bottom - i3;
                builder.set(CaptureRequest.SCALER_CROP_REGION, rect2);
                CaptureRequest build = builder.build();
                try {
                    cameraCaptureSession.setRepeatingRequest(build, this.mLocalCaptureCallback, this.mBackgroundHandler);
                    this.mCaptureRequest = build;
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setCameraTorch(boolean z) {
        Boolean bool;
        CameraCharacteristics cameraCharacteristics = this.mCameraCharacteristics;
        CaptureRequest.Builder builder = this.mCaptureRequestBuilder;
        CameraCaptureSession cameraCaptureSession = this.mCameraCaptureSession;
        if (cameraCharacteristics != null && builder != null && cameraCaptureSession != null && (bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)) != null && bool.booleanValue()) {
            builder.set(CaptureRequest.FLASH_MODE, 2);
            CaptureRequest build = builder.build();
            try {
                cameraCaptureSession.setRepeatingRequest(build, this.mLocalCaptureCallback, this.mBackgroundHandler);
                this.mCaptureRequest = build;
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCameraMaxZoom() {
        Float f;
        CameraCharacteristics cameraCharacteristics = this.mCameraCharacteristics;
        if (cameraCharacteristics == null || (f = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)) == null) {
            return 0;
        }
        return f.intValue();
    }

    public void setContext(Context context) {
        this.mCameraParams.mContext = context;
    }

    private Size[] getOutputSizes(CameraManager cameraManager, String str) {
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                OmniLog.lpe(TAG, "StreamConfigurationMap is null!");
                return null;
            }
            Size[] outputSizes = streamConfigurationMap.getOutputSizes(35);
            if (outputSizes != null) {
                return outputSizes;
            }
            OmniLog.lpe(TAG, "outputSizes is null!");
            return null;
        } catch (CameraAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void configCamera(CaptureRequest.Builder builder) {
        boolean z;
        Range[] rangeArr = (Range[]) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        OmniLog.d(OmniLog.VIDEO_CAP_WATCH, TAG, "fps ranges : " + Arrays.toString(rangeArr));
        if (rangeArr != null) {
            int length = rangeArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                }
                Range range = rangeArr[i];
                if (((Integer) range.getLower()).intValue() == this.mCameraFps && ((Integer) range.getUpper()).intValue() == this.mCameraFps) {
                    Range create = Range.create(range.getLower(), range.getUpper());
                    OmniLog.d(OmniLog.VIDEO_CAP_WATCH, TAG, "finally set fps ranges : " + create);
                    builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, create);
                    z = true;
                    break;
                }
                i++;
            }
            if (!z) {
                int length2 = rangeArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        break;
                    }
                    Range range2 = rangeArr[i2];
                    if (range2.contains(Integer.valueOf(this.mCameraFps))) {
                        builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, Range.create(range2.getLower(), range2.getUpper()));
                        OmniLog.d(OmniLog.VIDEO_CAP_WATCH, TAG, "finally set fps ranges : " + range2.toString());
                        break;
                    }
                    i2++;
                }
            }
        }
        Boolean bool = (Boolean) this.mCameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        if (bool == null || !bool.booleanValue()) {
            builder.set(CaptureRequest.CONTROL_AE_MODE, 0);
            OmniLog.lpe(TAG, "createCamera2::createCaptureSession -> not support flash!");
        } else if (this.mCameraOpenFlash) {
            builder.set(CaptureRequest.CONTROL_AE_MODE, 3);
        } else {
            builder.set(CaptureRequest.CONTROL_AE_MODE, 0);
        }
        int[] iArr = (int[]) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (iArr != null) {
            for (int i3 : iArr) {
                if (1 == i3) {
                    builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
                    return;
                }
            }
        }
    }

    private List<BaseCameraInterImpl.CameraPreSize> getSupportedPreviewSizes(Size[] sizeArr) {
        ArrayList arrayList = new ArrayList();
        for (Size size : sizeArr) {
            arrayList.add(new BaseCameraInterImpl.CameraPreSize(size.getWidth(), size.getHeight()));
        }
        return arrayList;
    }

    private static class LocalStateCallback extends CameraDevice.StateCallback {
        private final WeakReference<Camera2Impl> outReference;

        LocalStateCallback(Camera2Impl camera2Impl) {
            this.outReference = new WeakReference<>(camera2Impl);
        }

        public void onOpened(CameraDevice cameraDevice) {
            Camera2Impl camera2Impl = (Camera2Impl) this.outReference.get();
            if (camera2Impl != null) {
                OmniLog.d(OmniLog.VIDEO_CAP_WATCH, Camera2Impl.TAG, "onOpened happened!");
                CameraDevice unused = camera2Impl.mCameraDevice = cameraDevice;
                boolean unused2 = camera2Impl.mCameraConfigured = true;
            }
        }

        public void onDisconnected(CameraDevice cameraDevice) {
            OmniLog.lpe(Camera2Impl.TAG, "onDisconnected happened!");
            Camera2Impl camera2Impl = (Camera2Impl) this.outReference.get();
            if (camera2Impl != null) {
                int unused = camera2Impl.mCameraConfigureErrorCode = -1;
                boolean unused2 = camera2Impl.mCameraConfigured = true;
            }
        }

        public void onError(CameraDevice cameraDevice, int i) {
            OmniLog.lpe(Camera2Impl.TAG, "onError happened! error : " + i);
            Camera2Impl camera2Impl = (Camera2Impl) this.outReference.get();
            if (camera2Impl != null) {
                boolean unused = camera2Impl.mCameraConfigured = true;
                int unused2 = camera2Impl.mCameraConfigureErrorCode = i;
            }
        }
    }

    private static class LocalCaptureSessionStateCallback extends CameraCaptureSession.StateCallback {
        private final WeakReference<Camera2Impl> outReference;

        LocalCaptureSessionStateCallback(Camera2Impl camera2Impl) {
            this.outReference = new WeakReference<>(camera2Impl);
        }

        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            Camera2Impl camera2Impl = (Camera2Impl) this.outReference.get();
            if (camera2Impl != null) {
                CameraCaptureSession unused = camera2Impl.mCameraCaptureSession = cameraCaptureSession;
                boolean unused2 = camera2Impl.mCameraCaptureSessionError = false;
                boolean unused3 = camera2Impl.mCameraCaptureSessionConfigured = true;
            }
        }

        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            Camera2Impl camera2Impl = (Camera2Impl) this.outReference.get();
            if (camera2Impl != null) {
                boolean unused = camera2Impl.mCameraCaptureSessionError = true;
                boolean unused2 = camera2Impl.mCameraCaptureSessionConfigured = true;
            }
        }
    }

    private static class LocalCaptureCallback extends CameraCaptureSession.CaptureCallback {
        private final WeakReference<Camera2Impl> outReference;

        public LocalCaptureCallback(Camera2Impl camera2Impl) {
            this.outReference = new WeakReference<>(camera2Impl);
        }

        public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
            super.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
        }

        public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            super.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
            OmniLog.debugD(Camera2Impl.TAG, "Capture progressed...");
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
        }

        public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
            OmniLog.debugD(Camera2Impl.TAG, "Capture failed... reason : " + captureFailure.getReason());
        }

        public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i, long j) {
            super.onCaptureSequenceCompleted(cameraCaptureSession, i, j);
            OmniLog.debugD(Camera2Impl.TAG, "Capture sequence completed... frameNumber : " + j);
        }

        public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i) {
            super.onCaptureSequenceAborted(cameraCaptureSession, i);
            OmniLog.debugD(Camera2Impl.TAG, "Capture sequence aborted... sequenceId : " + i);
        }

        public void onCaptureBufferLost(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j) {
            super.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j);
            OmniLog.debugD(Camera2Impl.TAG, "Capture buffer lost... target : " + surface);
        }
    }
}
