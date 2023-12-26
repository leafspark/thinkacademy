package com.wushuangtech.myvideoimprove.capture.camera;

import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.video.RenderSmooth;
import com.wushuangtech.library.video.VideoErrorConstants;
import com.wushuangtech.myvideoimprove.bean.VideoCapCameraConfigureBean;
import com.wushuangtech.myvideoimprove.capture.VideoCapFrame;
import com.wushuangtech.myvideoimprove.capture.camera.BaseCameraInterImpl;
import com.wushuangtech.myvideoimprove.utils.MyCameraUtils;
import com.wushuangtech.utils.DeviceUtils;
import com.wushuangtech.utils.OmniLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlinx.coroutines.DebugKt;

public class CameraImpl extends BaseCameraInterImpl implements Camera.PreviewCallback {
    /* access modifiers changed from: private */
    public static final String TAG = "CameraImpl";
    private Camera mCamera;
    private final CameraConfig mCameraConfig = new CameraConfig();
    private long mCameraOpenTimestamp;
    private boolean mCameraSwitch;
    private boolean mRecvFirstRawData;
    private RenderSmooth mRenderSmooth;
    boolean mTestCameraError;

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0077, code lost:
        if (r1 != null) goto L_0x0079;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.wushuangtech.myvideoimprove.bean.VideoCapCameraConfigureBean initCamera(com.wushuangtech.myvideoimprove.capture.camera.BaseCameraInterImpl.CameraParams r10) {
        /*
            r9 = this;
            java.lang.String r0 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "initCamera:"
            r1.append(r2)
            java.lang.String r2 = r10.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.wushuangtech.utils.OmniLog.i(r0, r1)
            r1 = 0
            r2 = 0
            java.util.concurrent.locks.Lock r3 = r9.mLock     // Catch:{ all -> 0x0160 }
            r3.lock()     // Catch:{ all -> 0x0160 }
            com.wushuangtech.myvideoimprove.bean.VideoCapCameraConfigureBean r3 = new com.wushuangtech.myvideoimprove.bean.VideoCapCameraConfigureBean     // Catch:{ all -> 0x0160 }
            r3.<init>()     // Catch:{ all -> 0x0160 }
            android.hardware.Camera r4 = r9.mCamera     // Catch:{ all -> 0x0160 }
            if (r4 == 0) goto L_0x0035
            java.lang.String r10 = "Init camera failed -> Camera already opened!"
            r9.logE(r0, r10)     // Catch:{ all -> 0x0160 }
        L_0x002f:
            java.util.concurrent.locks.Lock r10 = r9.mLock
            r10.unlock()
            return r3
        L_0x0035:
            java.lang.String r4 = "android.permission.CAMERA"
            boolean r4 = com.wushuangtech.utils.AppUtils.hasPermission(r4)     // Catch:{ all -> 0x0160 }
            if (r4 != 0) goto L_0x004a
            int r4 = r10.cameraId     // Catch:{ all -> 0x0160 }
            boolean r4 = com.wushuangtech.utils.AppUtils.checkCameraPermission(r4)     // Catch:{ all -> 0x0160 }
            if (r4 != 0) goto L_0x004a
            r10 = 602(0x25a, float:8.44E-43)
            r3.mCameraOpenResult = r10     // Catch:{ all -> 0x0160 }
            goto L_0x002f
        L_0x004a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0160 }
            r4.<init>()     // Catch:{ all -> 0x0160 }
            java.lang.String r5 = "Prepare init camera, params list : "
            r4.append(r5)     // Catch:{ all -> 0x0160 }
            java.lang.String r5 = r10.toString()     // Catch:{ all -> 0x0160 }
            r4.append(r5)     // Catch:{ all -> 0x0160 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0160 }
            r9.logI(r0, r4)     // Catch:{ all -> 0x0160 }
            int r4 = r10.cameraId     // Catch:{ Exception -> 0x013f }
            android.hardware.Camera r1 = android.hardware.Camera.open(r4)     // Catch:{ Exception -> 0x013f }
            r4 = 501(0x1f5, float:7.02E-43)
            android.hardware.Camera$Parameters r5 = r1.getParameters()     // Catch:{ Exception -> 0x011e }
            if (r5 != 0) goto L_0x007d
            java.lang.String r10 = "Get Parameters is null!"
            r9.logE(r0, r10)     // Catch:{ Exception -> 0x011e }
            r3.mCameraOpenResult = r4     // Catch:{ Exception -> 0x011e }
            if (r1 == 0) goto L_0x002f
        L_0x0079:
            r1.release()
            goto L_0x002f
        L_0x007d:
            r9.initParameters(r5, r10)     // Catch:{ Exception -> 0x011e }
            r9.initDispensableParameters(r5, r10)     // Catch:{ Exception -> 0x011e }
            r1.setParameters(r5)     // Catch:{ Exception -> 0x011e }
            int r4 = r10.cameraId     // Catch:{ Exception -> 0x00fb }
            int r5 = r10.mRotation     // Catch:{ Exception -> 0x00fb }
            int r5 = com.wushuangtech.utils.DeviceUtils.getRotate(r5)     // Catch:{ Exception -> 0x00fb }
            r9.setCameraDisplayOrientation(r1, r4, r5)     // Catch:{ Exception -> 0x00fb }
            r2 = 1
            r3.mCamera = r1     // Catch:{ all -> 0x0160 }
            com.wushuangtech.myvideoimprove.capture.camera.BaseCameraInterImpl$CameraPreSize r4 = r9.mCameraPreSize     // Catch:{ all -> 0x0160 }
            int r4 = r4.width     // Catch:{ all -> 0x0160 }
            r3.mPreviewWidth = r4     // Catch:{ all -> 0x0160 }
            com.wushuangtech.myvideoimprove.capture.camera.BaseCameraInterImpl$CameraPreSize r4 = r9.mCameraPreSize     // Catch:{ all -> 0x0160 }
            int r4 = r4.height     // Catch:{ all -> 0x0160 }
            r3.mPreviewHeight = r4     // Catch:{ all -> 0x0160 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0160 }
            r4.<init>()     // Catch:{ all -> 0x0160 }
            java.lang.String r5 = "Camera init success -> Set params list,  rotate : "
            r4.append(r5)     // Catch:{ all -> 0x0160 }
            int r10 = r10.previewAngle     // Catch:{ all -> 0x0160 }
            r4.append(r10)     // Catch:{ all -> 0x0160 }
            java.lang.String r10 = " | preview : "
            r4.append(r10)     // Catch:{ all -> 0x0160 }
            com.wushuangtech.myvideoimprove.capture.camera.BaseCameraInterImpl$CameraPreSize r10 = r9.mCameraPreSize     // Catch:{ all -> 0x0160 }
            int r10 = r10.width     // Catch:{ all -> 0x0160 }
            r4.append(r10)     // Catch:{ all -> 0x0160 }
            java.lang.String r10 = " * "
            r4.append(r10)     // Catch:{ all -> 0x0160 }
            com.wushuangtech.myvideoimprove.capture.camera.BaseCameraInterImpl$CameraPreSize r10 = r9.mCameraPreSize     // Catch:{ all -> 0x0160 }
            int r10 = r10.height     // Catch:{ all -> 0x0160 }
            r4.append(r10)     // Catch:{ all -> 0x0160 }
            java.lang.String r10 = ", config="
            r4.append(r10)     // Catch:{ all -> 0x0160 }
            com.wushuangtech.myvideoimprove.capture.camera.CameraConfig r10 = r9.mCameraConfig     // Catch:{ all -> 0x0160 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0160 }
            r4.append(r10)     // Catch:{ all -> 0x0160 }
            java.lang.String r10 = r4.toString()     // Catch:{ all -> 0x0160 }
            r9.logI(r0, r10)     // Catch:{ all -> 0x0160 }
            java.lang.String r10 = "VCSW"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0160 }
            r4.<init>()     // Catch:{ all -> 0x0160 }
            java.lang.String r5 = "Camera config over: "
            r4.append(r5)     // Catch:{ all -> 0x0160 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0160 }
            long r7 = com.wushuangtech.library.GlobalConfig.mVideoCapStartTimestamp     // Catch:{ all -> 0x0160 }
            long r5 = r5 - r7
            r4.append(r5)     // Catch:{ all -> 0x0160 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0160 }
            com.wushuangtech.utils.OmniLog.i(r10, r0, r4)     // Catch:{ all -> 0x0160 }
            goto L_0x002f
        L_0x00fb:
            r10 = move-exception
            r0 = 500(0x1f4, float:7.0E-43)
            r3.mCameraOpenResult = r0     // Catch:{ all -> 0x0160 }
            java.lang.String r0 = TAG     // Catch:{ all -> 0x0160 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0160 }
            r4.<init>()     // Catch:{ all -> 0x0160 }
            java.lang.String r5 = "Setting display orientation failed! exception : "
            r4.append(r5)     // Catch:{ all -> 0x0160 }
            java.lang.String r10 = r10.getLocalizedMessage()     // Catch:{ all -> 0x0160 }
            r4.append(r10)     // Catch:{ all -> 0x0160 }
            java.lang.String r10 = r4.toString()     // Catch:{ all -> 0x0160 }
            r9.logE(r0, r10)     // Catch:{ all -> 0x0160 }
            if (r1 == 0) goto L_0x002f
            goto L_0x0079
        L_0x011e:
            r10 = move-exception
            r3.mCameraOpenResult = r4     // Catch:{ all -> 0x0160 }
            java.lang.String r0 = TAG     // Catch:{ all -> 0x0160 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0160 }
            r4.<init>()     // Catch:{ all -> 0x0160 }
            java.lang.String r5 = "Setting parameters failed! exception : "
            r4.append(r5)     // Catch:{ all -> 0x0160 }
            java.lang.String r10 = r10.getLocalizedMessage()     // Catch:{ all -> 0x0160 }
            r4.append(r10)     // Catch:{ all -> 0x0160 }
            java.lang.String r10 = r4.toString()     // Catch:{ all -> 0x0160 }
            r9.logE(r0, r10)     // Catch:{ all -> 0x0160 }
            if (r1 == 0) goto L_0x002f
            goto L_0x0079
        L_0x013f:
            r10 = move-exception
            r0 = 502(0x1f6, float:7.03E-43)
            r3.mCameraOpenResult = r0     // Catch:{ all -> 0x0160 }
            java.lang.String r0 = TAG     // Catch:{ all -> 0x0160 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0160 }
            r4.<init>()     // Catch:{ all -> 0x0160 }
            java.lang.String r5 = "Camera open failed! exception : "
            r4.append(r5)     // Catch:{ all -> 0x0160 }
            java.lang.String r10 = r10.getLocalizedMessage()     // Catch:{ all -> 0x0160 }
            r4.append(r10)     // Catch:{ all -> 0x0160 }
            java.lang.String r10 = r4.toString()     // Catch:{ all -> 0x0160 }
            r9.logE(r0, r10)     // Catch:{ all -> 0x0160 }
            goto L_0x002f
        L_0x0160:
            r10 = move-exception
            if (r2 != 0) goto L_0x0168
            if (r1 == 0) goto L_0x0168
            r1.release()
        L_0x0168:
            java.util.concurrent.locks.Lock r0 = r9.mLock
            r0.unlock()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.capture.camera.CameraImpl.initCamera(com.wushuangtech.myvideoimprove.capture.camera.BaseCameraInterImpl$CameraParams):com.wushuangtech.myvideoimprove.bean.VideoCapCameraConfigureBean");
    }

    private void initParameters(Camera.Parameters parameters, BaseCameraInterImpl.CameraParams cameraParams) {
        BaseCameraInterImpl.CameraPreSize findCloselyPreSize = findCloselyPreSize(cameraParams.width, cameraParams.height, getSupportedPreviewSizes(parameters.getSupportedPreviewSizes()));
        parameters.setPreviewSize(findCloselyPreSize.width, findCloselyPreSize.height);
        this.mCameraPreSize = new BaseCameraInterImpl.CameraPreSize(findCloselyPreSize.width, findCloselyPreSize.height);
        if (this.mCameraConfig.mFpsEnabled) {
            int[] findClosestFpsRange = findClosestFpsRange(cameraParams.fps, parameters.getSupportedPreviewFpsRange());
            String str = TAG;
            logI(str, "Select fps : " + Arrays.toString(findClosestFpsRange));
            parameters.setPreviewFpsRange(findClosestFpsRange[0], findClosestFpsRange[1]);
        }
    }

    private void initDispensableParameters(Camera.Parameters parameters, BaseCameraInterImpl.CameraParams cameraParams) {
        int i;
        if (this.mCameraConfig.mFlashEnabled) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(cameraParams.cameraId, cameraInfo);
            if (cameraInfo.facing == 1) {
                parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            } else if (cameraParams.openFlash) {
                parameters.setFlashMode("torch");
            } else {
                parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            }
        }
        if (this.mCameraConfig.mFocusEnabled && parameters.getSupportedFocusModes().contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
        }
        if (this.mCameraConfig.mZoomEnabled && (i = cameraParams.mCameraZoom) != 0) {
            parameters.setZoom(i);
        }
        if (cameraParams.userRecordMode && this.mCameraConfig.mRecordModeEnabled) {
            parameters.setRecordingHint(true);
        }
    }

    private void setCameraDisplayOrientation(Camera camera, int i, int i2) {
        int i3;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        if (cameraInfo.facing == 1) {
            i3 = (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
        } else {
            i3 = ((cameraInfo.orientation - i2) + 360) % 360;
        }
        camera.setDisplayOrientation(i3);
        this.mCameraParams.previewAngle = i3;
    }

    public VideoCapCameraConfigureBean openCamera(VideoCapCameraConfigureBean videoCapCameraConfigureBean, SurfaceTexture surfaceTexture) {
        String str = TAG;
        OmniLog.i(str, "openCamera cameraConfigureBean:" + videoCapCameraConfigureBean.toString() + " surfaceTexture:" + surfaceTexture);
        boolean z = false;
        try {
            this.mLock.lock();
            try {
                videoCapCameraConfigureBean.mCamera.setPreviewTexture(surfaceTexture);
                int bitsPerPixel = ((videoCapCameraConfigureBean.mPreviewWidth * videoCapCameraConfigureBean.mPreviewHeight) * ImageFormat.getBitsPerPixel(17)) / 8;
                videoCapCameraConfigureBean.mCamera.addCallbackBuffer(new byte[bitsPerPixel]);
                videoCapCameraConfigureBean.mCamera.addCallbackBuffer(new byte[bitsPerPixel]);
                videoCapCameraConfigureBean.mCamera.setPreviewCallbackWithBuffer(this);
                videoCapCameraConfigureBean.mCamera.startPreview();
                videoCapCameraConfigureBean.mCamera.setErrorCallback(new Camera.ErrorCallback() {
                    public void onError(int i, Camera camera) {
                        CameraImpl cameraImpl = CameraImpl.this;
                        String access$000 = CameraImpl.TAG;
                        cameraImpl.logE(access$000, "Camera disconnect! reason: " + i);
                        CameraImpl.this.releaseCamera();
                        if (CameraImpl.this.onCameraErrorCallBack != null) {
                            CameraImpl.this.onCameraErrorCallBack.onError(i);
                        }
                    }
                });
                z = true;
                this.mCameraOpenTimestamp = System.currentTimeMillis();
                logI(str, "Camera open success, texture=" + surfaceTexture + ",size = " + videoCapCameraConfigureBean.mPreviewWidth + " * " + videoCapCameraConfigureBean.mPreviewHeight);
                StringBuilder sb = new StringBuilder();
                sb.append("Camera start preview over: ");
                sb.append(System.currentTimeMillis() - GlobalConfig.mVideoCapStartTimestamp);
                OmniLog.i(OmniLog.VIDEO_CAP_SPEED_WATCH, str, sb.toString());
                sendPreviewSizeChangedEvent(videoCapCameraConfigureBean.mPreviewWidth, videoCapCameraConfigureBean.mPreviewHeight);
                this.mCamera = videoCapCameraConfigureBean.mCamera;
                this.mLock.unlock();
                return videoCapCameraConfigureBean;
            } catch (Exception e) {
                String str2 = TAG;
                logE(str2, "Camera prepare open failed! exception = " + e.getLocalizedMessage());
                videoCapCameraConfigureBean.mCameraOpenResult = VideoErrorConstants.VIDEO_CAP_ERROR_CAMERA_PREVIEW_FAILED;
                this.mLock.unlock();
                releaseCamera();
                return videoCapCameraConfigureBean;
            }
        } catch (Exception e2) {
            String str3 = TAG;
            logE(str3, "Camera open failed! exception = " + e2.getLocalizedMessage());
            this.mCameraConfig.increaseErrorTimes();
            videoCapCameraConfigureBean.mCameraOpenResult = VideoErrorConstants.VIDEO_CAP_ERROR_CAMERA_PREVIEW_START_FAILED;
            this.mLock.unlock();
            releaseCamera();
            return videoCapCameraConfigureBean;
        } catch (Throwable th) {
            if (z) {
                this.mCamera = videoCapCameraConfigureBean.mCamera;
                this.mLock.unlock();
            } else {
                this.mLock.unlock();
                releaseCamera();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void releaseCamera() {
        /*
            r9 = this;
            java.lang.String r0 = " but there is an exception = "
            java.lang.String r1 = "[SWITCH_CAMERA] Camera released!"
            java.lang.String r2 = TAG
            java.lang.String r3 = "releaseCamera"
            com.wushuangtech.utils.OmniLog.i(r2, r3)
            r3 = 0
            r4 = 0
            r6 = 0
            java.util.concurrent.locks.Lock r7 = r9.mLock     // Catch:{ all -> 0x0080 }
            r7.lock()     // Catch:{ all -> 0x0080 }
            android.hardware.Camera r7 = r9.mCamera     // Catch:{ all -> 0x0080 }
            if (r7 != 0) goto L_0x0029
            r9.mCamera = r6
            r9.mCameraPreSize = r6
            r9.mCameraOpenTimestamp = r4
            r9.mRecvFirstRawData = r3
            r9.logI(r2, r1)
            java.util.concurrent.locks.Lock r0 = r9.mLock
            r0.unlock()
            return
        L_0x0029:
            r7.setPreviewCallbackWithBuffer(r6)     // Catch:{ Exception -> 0x002e }
            r2 = r6
            goto L_0x0033
        L_0x002e:
            r2 = move-exception
            java.lang.String r2 = r2.getLocalizedMessage()     // Catch:{ all -> 0x0080 }
        L_0x0033:
            android.hardware.Camera r7 = r9.mCamera     // Catch:{ Exception -> 0x003e }
            r7.setPreviewCallback(r6)     // Catch:{ Exception -> 0x003e }
            goto L_0x0043
        L_0x0039:
            r7 = move-exception
            r8 = r7
            r7 = r2
            r2 = r8
            goto L_0x0082
        L_0x003e:
            r7 = move-exception
            java.lang.String r2 = r7.getLocalizedMessage()     // Catch:{ all -> 0x0039 }
        L_0x0043:
            android.hardware.Camera r7 = r9.mCamera     // Catch:{ Exception -> 0x0049 }
            r7.stopPreview()     // Catch:{ Exception -> 0x0049 }
            goto L_0x004e
        L_0x0049:
            r7 = move-exception
            java.lang.String r2 = r7.getLocalizedMessage()     // Catch:{ all -> 0x0039 }
        L_0x004e:
            android.hardware.Camera r7 = r9.mCamera     // Catch:{ Exception -> 0x0054 }
            r7.release()     // Catch:{ Exception -> 0x0054 }
            goto L_0x0059
        L_0x0054:
            r7 = move-exception
            java.lang.String r2 = r7.getLocalizedMessage()     // Catch:{ all -> 0x0039 }
        L_0x0059:
            r9.mCamera = r6
            r9.mCameraPreSize = r6
            r9.mCameraOpenTimestamp = r4
            r9.mRecvFirstRawData = r3
            if (r2 == 0) goto L_0x0075
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            r3.append(r0)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
        L_0x0075:
            java.lang.String r0 = TAG
            r9.logI(r0, r1)
            java.util.concurrent.locks.Lock r0 = r9.mLock
            r0.unlock()
            return
        L_0x0080:
            r2 = move-exception
            r7 = r6
        L_0x0082:
            r9.mCamera = r6
            r9.mCameraPreSize = r6
            r9.mCameraOpenTimestamp = r4
            r9.mRecvFirstRawData = r3
            if (r7 == 0) goto L_0x009e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            r3.append(r0)
            r3.append(r7)
            java.lang.String r1 = r3.toString()
        L_0x009e:
            java.lang.String r0 = TAG
            r9.logI(r0, r1)
            java.util.concurrent.locks.Lock r0 = r9.mLock
            r0.unlock()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.capture.camera.CameraImpl.releaseCamera():void");
    }

    public boolean startPreview() {
        try {
            this.mLock.lock();
            Camera camera = this.mCamera;
            if (camera == null) {
                this.mLock.unlock();
                return false;
            }
            camera.startPreview();
            this.mLock.unlock();
            return true;
        } catch (Exception e) {
            String str = TAG;
            logE(str, "Start preview exception: " + e.getLocalizedMessage());
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public boolean stopPreview() {
        try {
            this.mLock.lock();
            Camera camera = this.mCamera;
            if (camera == null) {
                this.mLock.unlock();
                return false;
            }
            camera.stopPreview();
            this.mLock.unlock();
            return true;
        } catch (Exception e) {
            String str = TAG;
            logE(str, "Stop preview exception: " + e.getLocalizedMessage());
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public int getCameraMaxZoom() {
        int i = 0;
        try {
            this.mLock.lock();
            Camera camera = this.mCamera;
            if (camera == null) {
                i = MyCameraUtils.getCameraMaxZoom(this.mCameraParams.cameraId);
            } else {
                Camera.Parameters parameters = camera.getParameters();
                if (parameters != null) {
                    i = parameters.getMaxZoom();
                }
            }
        } catch (Exception e) {
            String str = TAG;
            logE(str, "Get camera max zoom exception: " + e.getLocalizedMessage());
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
        this.mLock.unlock();
        return i;
    }

    public boolean setCameraOrientation(int i) {
        super.setCameraOrientation(i);
        try {
            this.mLock.lock();
            String str = TAG;
            logI(str, "set camera orientation : " + i + " ... " + this.mCamera);
            int rotate = DeviceUtils.getRotate(i);
            Camera camera = this.mCamera;
            if (camera != null) {
                setCameraDisplayOrientation(camera, this.mCameraParams.cameraId, rotate);
            }
            this.mLock.unlock();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            String str2 = TAG;
            logE(str2, "setCameraOrientation -> expcetion : " + e.getLocalizedMessage());
            this.mLock.unlock();
            return false;
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public boolean setCameraPreviewFps(int i) {
        try {
            this.mLock.lock();
            if (this.mCamera != null) {
                if (this.mCameraParams.fps != i) {
                    Camera.Parameters parameters = this.mCamera.getParameters();
                    if (parameters != null) {
                        int[] findClosestFpsRange = findClosestFpsRange(i, parameters.getSupportedPreviewFpsRange());
                        String str = TAG;
                        logI(str, "Select fps : " + Arrays.toString(findClosestFpsRange));
                        parameters.setPreviewFpsRange(findClosestFpsRange[0], findClosestFpsRange[1]);
                        this.mCamera.setParameters(parameters);
                        this.mCameraParams.fps = i;
                        RenderSmooth renderSmooth = this.mRenderSmooth;
                        if (renderSmooth == null) {
                            this.mRenderSmooth = new RenderSmooth(this.mCameraParams.fps);
                        } else {
                            renderSmooth.setRenderFps(this.mCameraParams.fps);
                        }
                        this.mLock.unlock();
                        return true;
                    }
                    this.mLock.unlock();
                    return false;
                }
            }
            this.mLock.unlock();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public void setCameraZoom(int i) {
        try {
            this.mLock.lock();
            Camera camera = this.mCamera;
            if (camera != null) {
                Camera.Parameters parameters = camera.getParameters();
                if (parameters != null) {
                    int maxZoom = parameters.getMaxZoom();
                    if (i >= 1) {
                        if (i <= maxZoom) {
                            parameters.setZoom(i);
                            this.mCamera.setParameters(parameters);
                            this.mCameraParams.mCameraZoom = i;
                            this.mLock.unlock();
                            return;
                        }
                    }
                }
            }
            this.mLock.unlock();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public void setCameraTorch(boolean z) {
        try {
            this.mLock.lock();
            Camera camera = this.mCamera;
            if (camera != null) {
                Camera.Parameters parameters = camera.getParameters();
                if (parameters != null) {
                    if (MyCameraUtils.inspectCameraSupports(parameters, 2)) {
                        String flashMode = parameters.getFlashMode();
                        if (z) {
                            if (flashMode.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                                parameters.setFlashMode("torch");
                                this.mCamera.setParameters(parameters);
                                this.mCameraParams.openFlash = z;
                                this.mLock.unlock();
                                return;
                            }
                        }
                        parameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                        this.mCamera.setParameters(parameters);
                        this.mCameraParams.openFlash = z;
                        this.mLock.unlock();
                        return;
                    }
                }
            }
            this.mLock.unlock();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public void switchCamera() {
        super.switchCamera();
        try {
            this.mLock.lock();
            this.mCameraSwitch = true;
        } finally {
            this.mLock.unlock();
        }
    }

    private List<BaseCameraInterImpl.CameraPreSize> getSupportedPreviewSizes(List<Camera.Size> list) {
        ArrayList arrayList = new ArrayList();
        for (Camera.Size next : list) {
            arrayList.add(new BaseCameraInterImpl.CameraPreSize(next.width, next.height));
        }
        return arrayList;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (bArr != null) {
            try {
                this.mLock.lock();
                if (!this.mRecvFirstRawData) {
                    this.mRecvFirstRawData = true;
                    String str = TAG;
                    OmniLog.i(OmniLog.VIDEO_CAP_SPEED_WATCH, str, "Recv first raw data: " + (System.currentTimeMillis() - GlobalConfig.mVideoCapStartTimestamp));
                }
                if (this.mCameraPreSize != null) {
                    if (this.mCameraSwitch) {
                        String str2 = TAG;
                        OmniLog.i(str2, "[SWITCH_CAMERA] onPreviewFrame...: " + Thread.currentThread().getId());
                        GlobalHolder.getInstance().sendSyncGlobalMessage(3000, new Object[0]);
                        this.mCameraSwitch = false;
                    }
                    if (this.mRenderSmooth == null) {
                        this.mRenderSmooth = new RenderSmooth(this.mCameraParams.fps);
                    }
                    if (this.mRenderSmooth.smoothTimestamp() > 0) {
                        int i = this.mCameraPreSize.width;
                        int i2 = this.mCameraPreSize.height;
                        if (this.mCameraPreSize.width < this.mCameraPreSize.height) {
                            i = this.mCameraPreSize.height;
                            i2 = this.mCameraPreSize.width;
                        }
                        byte[] bArr2 = bArr;
                        VideoCapFrame videoCapFrame = new VideoCapFrame(bArr2, i, i2, this.mCameraParams.previewAngle, System.currentTimeMillis(), isDropData());
                        camera.addCallbackBuffer(bArr);
                        this.mLock.unlock();
                        if (this.mOnCameraPreviewFrameCallBack != null) {
                            this.mOnCameraPreviewFrameCallBack.onPreviewFrame(videoCapFrame);
                        }
                    }
                }
            } finally {
                camera.addCallbackBuffer(bArr);
                this.mLock.unlock();
            }
        }
    }

    public boolean isCameraOpened() {
        try {
            this.mLock.lock();
            return this.mCamera != null;
        } finally {
            this.mLock.unlock();
        }
    }

    public boolean cameraInspectFunction(int i) {
        boolean z;
        try {
            this.mLock.lock();
            Camera camera = this.mCamera;
            if (camera != null) {
                z = MyCameraUtils.inspectCameraSupports(camera.getParameters(), i);
                this.mLock.unlock();
                return z;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
        z = false;
        this.mLock.unlock();
        return z;
    }

    private boolean isDropData() {
        try {
            this.mLock.lock();
            if (this.mCameraOpenTimestamp != 0) {
                if (System.currentTimeMillis() - this.mCameraOpenTimestamp <= 1500) {
                    logI(TAG, "Need drop black preview data...");
                    this.mLock.unlock();
                    return true;
                }
                this.mCameraOpenTimestamp = 0;
            }
            return false;
        } finally {
            this.mLock.unlock();
        }
    }

    private void testCameraError() {
        if (!this.mTestCameraError) {
            this.mTestCameraError = true;
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    CameraImpl.this.logE(CameraImpl.TAG, "延迟4秒模拟摄像头出问题");
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    CameraImpl.this.logE(CameraImpl.TAG, "摄像头出问题");
                    CameraImpl.this.releaseCamera();
                    if (CameraImpl.this.onCameraErrorCallBack != null) {
                        CameraImpl.this.onCameraErrorCallBack.onError(3);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        }
    }
}
