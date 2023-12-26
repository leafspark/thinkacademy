package com.wushuangtech.myvideoimprove;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.wushuangtech.bean.CommonEventBean;
import com.wushuangtech.inter.OnRtcGlobalMessageCallBack;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.GlobalVideoConfig;
import com.wushuangtech.library.HandlerUrgentQueue;
import com.wushuangtech.library.video.VideoDataWriter;
import com.wushuangtech.library.video.VideoErrorConstants;
import com.wushuangtech.library.video.VideoStatistical;
import com.wushuangtech.library.video.VideoStatus;
import com.wushuangtech.library.video.bean.MediaCodecSurface;
import com.wushuangtech.library.video.bean.VideoFrame;
import com.wushuangtech.library.video.opengles.WaterMarkController;
import com.wushuangtech.myvideoimprove.VideoRenderer;
import com.wushuangtech.myvideoimprove.bean.BaseVideoModelConfigureBean;
import com.wushuangtech.myvideoimprove.bean.VideoCapCameraConfigureBean;
import com.wushuangtech.myvideoimprove.bean.VideoRenderViewLifeBean;
import com.wushuangtech.myvideoimprove.bean.VideoRotateBean;
import com.wushuangtech.myvideoimprove.capture.VideoCapCameraInterImpl;
import com.wushuangtech.myvideoimprove.capture.VideoCapFrame;
import com.wushuangtech.myvideoimprove.capture.camera.BaseCameraInterImpl;
import com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder;
import com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder;
import com.wushuangtech.myvideoimprove.inter.OnLocalVideoModuleEventCallBack;
import com.wushuangtech.myvideoimprove.render.LocalVideoRenderer;
import com.wushuangtech.myvideoimprove.view.VideoRenderView;
import com.wushuangtech.utils.DeviceUtils;
import com.wushuangtech.utils.OmniLog;
import java.io.File;
import java.lang.ref.WeakReference;

public class LocalVideoRenderModel extends BaseVideoRenderModel implements VideoRenderer.OnVideoRendererAddSurfaceCallBack, OnRtcGlobalMessageCallBack {
    private static final String TAG = "LVRM";
    private static final int WORK_CALLBACK_VIDEO_CAP_OPEN_RESULT = 300;
    private static final int WORK_CALLBACK_VIDEO_RENDER_ERROR = 301;
    private static final int WORK_MSG_CONFIG = 400;
    private static final int WORK_MSG_ENCODER_BITRATE_MODE = 109;
    private static final int WORK_MSG_ENCODER_EVENT = 100;
    private static final int WORK_MSG_ENCODER_PARAMS_SETTING = 107;
    private static final int WORK_MSG_ENCODER_REQUEST_KEY_FRAME = 108;
    private static final int WORK_MSG_ENCODER_START_STATUS = 106;
    private static final int WORK_MSG_INIT = 1;
    private static final int WORK_MSG_RESET = 3;
    private static final int WORK_MSG_ROTATE_CHANGED = 6;
    private static final int WORK_MSG_START_VIDEO_RENDERER = 4;
    private static final int WORK_MSG_STOP_VIDEO_RENDERER = 5;
    private static final int WORK_MSG_UNINIT = 2;
    private static final int WORK_MSG_VIDEO_CAP_EVENT = 200;
    private static final int WORK_MSG_VIDEO_CAP_PREVIEW_RESOLUTION = 206;
    private static final int WORK_MSG_VIDEO_CAP_RESTART = 205;
    private static final int WORK_MSG_VIDEO_CAP_SWITCH = 203;
    private static final int WORK_MSG_VIDEO_CAP_SWITCH_OVER = 204;
    private static final int WORK_MSG_VIDEO_LOCAL_MIRROR = 56;
    private static final int WORK_MSG_VIDEO_REMOTE_MIRROR = 57;
    private static final int WORK_MSG_VIEW_CHANGE = 7;
    private static final int WORK_MSG_VIEW_RENDER_EVENT = 50;
    private static final int WORK_MSG_VIEW_SIZE_CHANGED = 8;
    /* access modifiers changed from: private */
    public volatile boolean mCameraError;
    /* access modifiers changed from: private */
    public volatile boolean mCameraStartFailed;
    /* access modifiers changed from: private */
    public final Object mControlLock = new Object();
    private Thread mControlThread;
    private boolean mCustomVideoCapSizeSetting;
    private boolean mForcedSoftEncoding;
    /* access modifiers changed from: private */
    public HandlerUrgentQueue mHandlerUrgentQueue;
    private LocalCameraCaptureCallBackImpl mLocalCameraCaptureCallBack;
    private LocalVideoEncoder mLocalVideoEncoder;
    private final LocalVideoRenderConfigure mLocalVideoRenderConfigure = new LocalVideoRenderConfigure();
    private LocalVideoRenderViewCallBackImpl mLocalVideoRenderViewCallBack;
    /* access modifiers changed from: private */
    public OnLocalVideoModuleEventCallBack mOnLocalVideoModuleEventCallBack;
    /* access modifiers changed from: private */
    public OnLocalVideoNV21DataCallBack mOnLocalVideoNV21DataCallBack;
    /* access modifiers changed from: private */
    public OnLocalVideoRenderModelCallBack mOnLocalVideoRenderModelCallBack;
    private OnLocalVideoTextureCallBack mOnLocalVideoTextureCallBack;
    /* access modifiers changed from: private */
    public volatile boolean mSetupLocal;
    private VideoDataWriter mTestVideoDataWriter;
    private int mVideoCapFps = 15;
    private int mVideoCapHeight = GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_HEIGHT;
    private int mVideoCapWidth = GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_WIDTH;
    private VideoCapCameraInterImpl mVideoCapturer;
    private int mVideoDualEncoderBitrate;
    private int mVideoDualEncoderFps;
    private int mVideoDualEncoderHeight;
    private int mVideoDualEncoderWidth;
    private int mVideoEncoderBitrate = GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_BITRATE;
    private int mVideoEncoderFps = 15;
    private int mVideoEncoderHeight = GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_WIDTH;
    private final int mVideoEncoderIFrameInterval = 1;
    private int mVideoEncoderWidth = GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_HEIGHT;
    protected VideoRenderView mVideoRenderView;
    /* access modifiers changed from: private */
    public LocalVideoRenderer mVideoRenderer;
    protected final Object mViewLock = new Object();
    private final WaterMarkController mWaterMarkController = new WaterMarkController();
    /* access modifiers changed from: private */
    public volatile WorkThreadHandler mWorkHandler;
    private volatile HandlerThread mWorkHandlerThread = new HandlerThread(VideoStatus.THREAD_VIDEO_LOCAL_MODULE, 10);

    public interface OnLocalVideoNV21DataCallBack {
        void onVideoFrameData(byte[] bArr, int i, int i2, int i3, long j);
    }

    public interface OnLocalVideoRenderModelCallBack {
        void onVideoCaptureError(int i);

        void onVideoCaptureSuccess(int i, int i2, int i3);

        void onVideoEncodedDataReport(boolean z, byte[] bArr, int i, int i2, int i3, long j);

        void onVideoFirstLocalVideoFrame(int i, int i2);

        void onVideoRenderFailed(int i);

        void onVideoRenderModelDestoryed();

        void onVideoStartEncoderFailed(int i);
    }

    public interface OnLocalVideoTextureCallBack {
        int onVideoFrameTexture(int i, byte[] bArr, int i2, int i3, int i4, long j);
    }

    public void initVideoRendererResult(boolean z) {
    }

    /* access modifiers changed from: package-private */
    public void setActivityDirector(int i) {
    }

    /* access modifiers changed from: package-private */
    public void setVideoCapRotate(int i) {
    }

    /* access modifiers changed from: package-private */
    public void setVideoCapRotateFromSystem(int i) {
    }

    LocalVideoRenderModel() {
        super(OmniLog.LOCAL_PREVIEW, TAG);
        this.mWorkHandlerThread.start();
        this.mWorkHandler = new WorkThreadHandler(this.mWorkHandlerThread.getLooper(), this);
        this.mHandlerUrgentQueue = new HandlerUrgentQueue("LPW][LVRM");
        GlobalHolder.getInstance().addRtcGlobalMessageCallBack(this);
    }

    public boolean createVideoRenderer(BaseVideoModelConfigureBean baseVideoModelConfigureBean) {
        localSendEmptyMessage(1);
        return true;
    }

    public void destroyVideoRenderer(BaseVideoModelConfigureBean baseVideoModelConfigureBean) {
        localSendEmptyMessage(2);
    }

    public boolean startVideoRender(BaseVideoModelConfigureBean baseVideoModelConfigureBean) {
        synchronized (this.mControlLock) {
            if (this.mControlThread == null) {
                logE("Start local video renderer failed! Controller thread is null! init = " + this.mModelInited);
                return true;
            } else if (this.mSetupLocal) {
                this.mControlThread.interrupt();
                return true;
            } else {
                logI("Start local video module!");
                this.mSetupLocal = true;
                this.mControlThread.interrupt();
                return true;
            }
        }
    }

    public void stopVideoRender() {
        synchronized (this.mControlLock) {
            if (this.mControlThread == null) {
                logE("Stop local video renderer failed! Controller thread is null! init = " + this.mModelInited);
            } else if (!this.mSetupLocal) {
                this.mControlThread.interrupt();
            } else {
                logI("Stop local video renderer success!");
                this.mSetupLocal = false;
                this.mControlThread.interrupt();
            }
        }
    }

    public void resetStatus() {
        stopVideoRender();
        localSendEmptyMessage(3);
    }

    public void setVideoRenderView(VideoRenderView videoRenderView) {
        Message obtain = Message.obtain();
        obtain.what = 7;
        obtain.obj = videoRenderView;
        localSendMessage(obtain);
    }

    /* access modifiers changed from: package-private */
    public void setOnLocalVideoRenderModelCallBack(OnLocalVideoRenderModelCallBack onLocalVideoRenderModelCallBack) {
        this.mOnLocalVideoRenderModelCallBack = onLocalVideoRenderModelCallBack;
    }

    /* access modifiers changed from: package-private */
    public void setOnLocalVideoModuleEventCallBack(OnLocalVideoModuleEventCallBack onLocalVideoModuleEventCallBack) {
        this.mOnLocalVideoModuleEventCallBack = onLocalVideoModuleEventCallBack;
    }

    /* access modifiers changed from: package-private */
    public void setOnLocalVideoNV21DataCallBack(OnLocalVideoNV21DataCallBack onLocalVideoNV21DataCallBack) {
        this.mOnLocalVideoNV21DataCallBack = onLocalVideoNV21DataCallBack;
    }

    /* access modifiers changed from: package-private */
    public void setOnLocalVideoTextureCallBack(OnLocalVideoTextureCallBack onLocalVideoTextureCallBack) {
        this.mOnLocalVideoTextureCallBack = onLocalVideoTextureCallBack;
    }

    /* access modifiers changed from: package-private */
    public void setVideoEncoderParams(LocalVideoEncoder.VideoEncoderType videoEncoderType, int i, int i2) {
        if (i2 != 0 && i != 0) {
            LocalVideoEncoder localVideoEncoder = this.mLocalVideoEncoder;
            LocalVideoRenderer localVideoRenderer = this.mVideoRenderer;
            if (localVideoEncoder != null && localVideoRenderer != null && localVideoRenderer.isRendererStarted()) {
                if (videoEncoderType == LocalVideoEncoder.VideoEncoderType.MAIN) {
                    localVideoRenderer.setVideoEncodeRate(i2);
                } else {
                    localVideoRenderer.setVideoDualEncodeRate(i2);
                }
                localVideoEncoder.setVideoEncoderParams(videoEncoderType, i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setVideoEncoderParams(int i, int i2, int i3, int i4, boolean z) {
        if (i != 0 && i2 != 0 && i3 != 0 && i4 != 0) {
            sendEventBean(100, new CommonEventBean(107, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)));
        }
    }

    /* access modifiers changed from: package-private */
    public void setVideoEncoderType(boolean z) {
        logI("Setting encoding type : " + z);
        this.mForcedSoftEncoding = z;
    }

    /* access modifiers changed from: package-private */
    public void setVideoEncoderStatus(boolean z, boolean z2) {
        sendEventBean(100, new CommonEventBean(106, Boolean.valueOf(z), Boolean.valueOf(z2)));
    }

    /* access modifiers changed from: package-private */
    public void setVideoEncoderKeyFrame(LocalVideoEncoder.VideoEncoderType videoEncoderType) {
        sendEventBean(100, new CommonEventBean(108, videoEncoderType));
    }

    /* access modifiers changed from: package-private */
    public void setVideoEncoderBitrateMode(int i) {
        sendEventBean(100, new CommonEventBean(109, Integer.valueOf(i)));
    }

    /* access modifiers changed from: package-private */
    public void setVideoCapSwitch() {
        sendEventBean(200, new CommonEventBean(203, new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public void setWaterMark(WaterMarkController waterMarkController) {
        if (!checkModelStatus()) {
            if (waterMarkController == null) {
                if (this.mWaterMarkController.getBitmap() != null) {
                    this.mWaterMarkController.setBitmap((Bitmap) null);
                }
            } else if (this.mWorkHandler != null) {
                this.mWaterMarkController.updateValues(waterMarkController);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setVideoLocalMirror(boolean z, boolean z2) {
        sendEventBean(50, new CommonEventBean(56, Boolean.valueOf(z), Boolean.valueOf(z2)));
    }

    /* access modifiers changed from: package-private */
    public void setVideoRemoteMirror(boolean z) {
        sendEventBean(50, new CommonEventBean(57, (Object) Boolean.valueOf(z)));
    }

    /* access modifiers changed from: package-private */
    public void configRenderer(int i, Object... objArr) {
        Message obtain = Message.obtain();
        obtain.what = 400;
        obtain.obj = objArr;
        obtain.arg1 = i;
        localSendMessage(obtain);
    }

    /* access modifiers changed from: package-private */
    public WaterMarkController getWaterMark() {
        return this.mWaterMarkController;
    }

    /* access modifiers changed from: package-private */
    public int getVideoCapCameraMaxZoom() {
        VideoCapCameraInterImpl videoCapCameraInterImpl = this.mVideoCapturer;
        if (videoCapCameraInterImpl == null) {
            return 0;
        }
        return videoCapCameraInterImpl.getCameraMaxZoom();
    }

    /* access modifiers changed from: package-private */
    public boolean getVideoCapCameraFuncSupported(int i) {
        VideoCapCameraInterImpl videoCapCameraInterImpl = this.mVideoCapturer;
        if (videoCapCameraInterImpl == null) {
            return false;
        }
        return videoCapCameraInterImpl.cameraInspectFunction(i);
    }

    /* access modifiers changed from: package-private */
    public int getVideoCapCameraId() {
        VideoCapCameraInterImpl videoCapCameraInterImpl = this.mVideoCapturer;
        if (videoCapCameraInterImpl == null) {
            return 0;
        }
        return videoCapCameraInterImpl.getCameraId();
    }

    public void setVideoCapPreviewResolution(int i, int i2) {
        CommonEventBean commonEventBean = new CommonEventBean(206, new Object[0]);
        commonEventBean.mObjects = new Object[]{Integer.valueOf(i), Integer.valueOf(i2)};
        sendEventBean(200, commonEventBean);
    }

    /* access modifiers changed from: package-private */
    public VideoRenderView getVideoRenderView() {
        VideoRenderView videoRenderView;
        synchronized (this.mViewLock) {
            videoRenderView = this.mVideoRenderView;
        }
        return videoRenderView;
    }

    /* access modifiers changed from: private */
    public void sendEventBean(int i, CommonEventBean commonEventBean) {
        WorkThreadHandler workThreadHandler = this.mWorkHandler;
        if (workThreadHandler != null) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = commonEventBean;
            workThreadHandler.sendMessage(obtain);
        }
    }

    private void localSendEmptyMessage(int i) {
        WorkThreadHandler workThreadHandler = this.mWorkHandler;
        if (workThreadHandler != null) {
            workThreadHandler.sendEmptyMessage(i);
        }
    }

    /* access modifiers changed from: private */
    public void localSendMessage(Message message) {
        WorkThreadHandler workThreadHandler = this.mWorkHandler;
        if (workThreadHandler != null) {
            workThreadHandler.sendMessage(message);
        }
    }

    /* access modifiers changed from: private */
    public void receiveWorkMessage(Message message) {
        if (!(message.arg1 != 1 || this.mHandlerUrgentQueue == null || this.mWorkHandler == null)) {
            this.mHandlerUrgentQueue.onUrgentMessageExecuteFinish(this.mWorkHandler, message.what);
        }
        if (message.what == 1 || this.mModelInited) {
            int i = message.what;
            if (i == 50) {
                handleViewRenderEvent(message);
            } else if (i == 100) {
                handleVideoEncoderEvent(message);
            } else if (i == 200) {
                handleVideoCapEvent(message);
            } else if (i == 400) {
                this.mLocalVideoRenderConfigure.configRenderer(message.arg1, (Object[]) message.obj);
            } else if (i == 300) {
                handleCallBackVideoCapOpenResult(message);
            } else if (i != 301) {
                switch (i) {
                    case 1:
                        if (!this.mModelInited) {
                            logI("Create the local video renderer model...");
                            this.mLocalCameraCaptureCallBack = new LocalCameraCaptureCallBackImpl(this);
                            this.mLocalVideoRenderViewCallBack = new LocalVideoRenderViewCallBackImpl(this);
                            VideoCapCameraInterImpl videoCapCameraInterImpl = new VideoCapCameraInterImpl(this.mLocalCameraCaptureCallBack);
                            this.mVideoCapturer = videoCapCameraInterImpl;
                            videoCapCameraInterImpl.setContext(this.mContext);
                            LocalVideoEncoder localVideoEncoder = new LocalVideoEncoder("LOCAL");
                            this.mLocalVideoEncoder = localVideoEncoder;
                            localVideoEncoder.init(new LocalVideoEncoder.VideoEncoderType[]{LocalVideoEncoder.VideoEncoderType.MAIN, LocalVideoEncoder.VideoEncoderType.DUAL});
                            this.mLocalVideoEncoder.setOnLocalVideoEncoderTypeChangedListener(new LocalVideoEncoderCallBackImpl(this));
                            this.mLocalVideoEncoder.setOnHardwareSurfaceLifeListener(new HardwareEncoder.OnHardwareSurfaceLifeListener() {
                                public void onSurfaceCreated(MediaCodecSurface mediaCodecSurface) {
                                    LocalVideoRenderModel.this.mVideoRenderer.setVideoSurfaceWindowForEncode(true, mediaCodecSurface);
                                }

                                public void onSurfaceReleased(MediaCodecSurface mediaCodecSurface) {
                                    LocalVideoRenderModel.this.mVideoRenderer.setVideoSurfaceWindowForEncode(false, mediaCodecSurface);
                                }
                            });
                            LocalVideoRenderer localVideoRenderer = new LocalVideoRenderer(this);
                            this.mVideoRenderer = localVideoRenderer;
                            this.mLocalVideoRenderConfigure.initRenderer(this.mVideoCapturer, localVideoRenderer, this.mOnLocalVideoRenderModelCallBack);
                            Thread thread = new Thread(new ControlThreadRunnable(this));
                            this.mControlThread = thread;
                            thread.setName("LVRM-CONTROL");
                            Thread thread2 = this.mControlThread;
                            if (!(thread2 instanceof Thread)) {
                                thread2.start();
                            } else {
                                AsynchronousInstrumentation.threadStart(thread2);
                            }
                            this.mModelInited = true;
                        }
                        LocalVideoRenderer localVideoRenderer2 = this.mVideoRenderer;
                        if (localVideoRenderer2 != null) {
                            localVideoRenderer2.initRenderer();
                            this.mVideoRenderer.setWaterMark(this.mWaterMarkController);
                            return;
                        }
                        return;
                    case 2:
                        if (this.mModelInited) {
                            long currentTimeMillis = System.currentTimeMillis();
                            this.mVideoRenderer.unInitVideoRenderer();
                            this.mModelInited = false;
                            logI("Destroy the local video renderer model! spent time : " + (System.currentTimeMillis() - currentTimeMillis));
                            return;
                        }
                        return;
                    case 3:
                        handleReset();
                        return;
                    case 4:
                        handleVideoRendererStart();
                        return;
                    case 5:
                        handleVideoRendererStop();
                        return;
                    case 6:
                        dynamicAdjustRotate(message);
                        return;
                    case 7:
                        handleNewRenderView((VideoRenderView) message.obj);
                        return;
                    case 8:
                        handleViewSizeChanged((int[]) message.obj);
                        return;
                    default:
                        throw new IllegalStateException("Unexpected value: " + message.what);
                }
            } else {
                handleCallBackRenderError(message);
            }
        }
    }

    private void handleReset() {
        this.mVideoCapturer.resetStatus();
        this.mVideoRenderer.setCameraId(this.mVideoCapturer.getCameraId());
    }

    private void handleNewRenderView(VideoRenderView videoRenderView) {
        if (videoRenderView != null) {
            synchronized (this.mViewLock) {
                VideoRenderView videoRenderView2 = this.mVideoRenderView;
                if (videoRenderView2 != null) {
                    videoRenderView2.setVideoRenderViewCallBack((VideoRenderView.OnVideoRenderViewCallBack) null);
                }
                this.mVideoRenderer.setVideoRenderView(videoRenderView);
                this.mVideoRenderView = videoRenderView;
                videoRenderView.setVideoRenderViewCallBack(this.mLocalVideoRenderViewCallBack);
            }
            logI("Setting the new video view, videoRenderView = " + videoRenderView);
        }
    }

    private void handleViewSizeChanged(int[] iArr) {
        this.mVideoRenderer.setViewSize(iArr[0], iArr[1]);
    }

    private void handleVideoCapEvent(Message message) {
        CommonEventBean commonEventBean = (CommonEventBean) message.obj;
        switch (commonEventBean.mEventType) {
            case 203:
                recvVideoCapEventForSwitch();
                return;
            case 204:
                handleVideoCapSwitchOver();
                return;
            case 205:
                handleVideoCapCameraRestart();
                return;
            case 206:
                handleVideoCapPreviewResolution(commonEventBean, false);
                return;
            default:
                return;
        }
    }

    private void recvVideoCapEventForSwitch() {
        this.mVideoCapturer.stopVideoCapture();
        this.mVideoCapturer.cameraSwitch();
        int startVideoCaping = startVideoCaping();
        if (startVideoCaping != 0) {
            logE("Switch camera failed! video cap start failed!");
            Message.obtain(this.mWorkHandler, 300, Integer.valueOf(startVideoCaping)).sendToTarget();
        } else {
            Message.obtain(this.mWorkHandler, 300, 0).sendToTarget();
        }
        this.mVideoRenderer.setCameraId(this.mVideoCapturer.getCameraId());
        this.mVideoRenderer.pauseRender();
        logI("[SWITCH_CAMERA] Switch camera over, pause render");
    }

    private void handleVideoCapSwitchOver() {
        if (this.mStartRendered) {
            this.mVideoRenderer.resumeRender();
            logI("[SWITCH_CAMERA] Switch camera over, resume render");
        }
    }

    private void handleVideoCapCameraRestart() {
        this.mVideoCapturer.stopVideoCapture();
        if (startVideoCaping() == 0) {
            synchronized (this.mControlLock) {
                this.mCameraError = false;
            }
        }
    }

    private void handleVideoCapPreviewResolution(CommonEventBean commonEventBean, boolean z) {
        int intValue = ((Integer) commonEventBean.mObjects[0]).intValue();
        int intValue2 = ((Integer) commonEventBean.mObjects[1]).intValue();
        if (intValue != this.mVideoCapWidth || intValue2 != this.mVideoCapHeight) {
            if (!z) {
                this.mCustomVideoCapSizeSetting = true;
            }
            this.mVideoCapWidth = intValue;
            this.mVideoCapHeight = intValue2;
            this.mVideoCapturer.stopVideoCapture();
            startVideoCaping();
            BaseCameraInterImpl.CameraPreSize cameraPreSize = this.mVideoCapturer.getCameraPreSize();
            if (cameraPreSize != null) {
                this.mVideoRenderer.setVideoSize(cameraPreSize.width, cameraPreSize.height);
            }
        }
    }

    private void handleViewRenderEvent(Message message) {
        CommonEventBean commonEventBean = (CommonEventBean) message.obj;
        int i = commonEventBean.mEventType;
        if (i == 56) {
            Object[] objArr = commonEventBean.mObjects;
            boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
            boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
            this.mVideoRenderer.setRenderMirror(booleanValue, booleanValue2);
            logI("Setting the video local mirror, hor = " + booleanValue + ", ver = " + booleanValue2);
        } else if (i == 57) {
            boolean booleanValue3 = ((Boolean) commonEventBean.mObject).booleanValue();
            logI("Setting the video remote mirror = " + booleanValue3);
            this.mVideoRenderer.setRenderEncodeMirror(booleanValue3);
        }
    }

    private void handleVideoEncoderEvent(Message message) {
        CommonEventBean commonEventBean = (CommonEventBean) message.obj;
        Object[] objArr = commonEventBean.mObjects;
        switch (commonEventBean.mEventType) {
            case 106:
                boolean booleanValue = ((Boolean) objArr[0]).booleanValue();
                boolean booleanValue2 = ((Boolean) objArr[1]).booleanValue();
                if (!GlobalConfig.mExternalVideoSource || !booleanValue) {
                    logI("Setting video encoder started status, renderer start? : " + this.mStartRendered + " | open? : " + booleanValue + " | dual? : " + booleanValue2 + " - VIDEO_ENCODER_WATCH bug1000 bug1001");
                    executingControlEncoder(booleanValue, booleanValue2);
                    return;
                }
                return;
            case 107:
                executingVideoEncoderParamsSetting(objArr);
                return;
            case 108:
                this.mLocalVideoEncoder.requestKeyFrame((LocalVideoEncoder.VideoEncoderType) objArr[0]);
                return;
            case 109:
                this.mLocalVideoEncoder.setVideoBitrateMode((LocalVideoEncoder.VideoEncoderType) null, ((Integer) objArr[0]).intValue());
                return;
            default:
                return;
        }
    }

    private void handleCallBackVideoCapOpenResult(Message message) {
        int i;
        int intValue = ((Integer) message.obj).intValue();
        if (intValue == 0) {
            BaseCameraInterImpl.CameraPreSize cameraPreSize = this.mVideoCapturer.getCameraPreSize();
            int cameraRotate = this.mVideoCapturer.getCameraRotate();
            int i2 = 0;
            if (cameraPreSize != null) {
                i2 = cameraPreSize.width;
                i = cameraPreSize.height;
            } else {
                i = 0;
            }
            this.mOnLocalVideoRenderModelCallBack.onVideoCaptureSuccess(i2, i, cameraRotate);
            return;
        }
        this.mOnLocalVideoRenderModelCallBack.onVideoCaptureError(intValue);
    }

    private void handleCallBackRenderError(Message message) {
        int intValue = ((Integer) message.obj).intValue();
        if (intValue == 1500) {
            OmniLog.e(TAG, "Recv local egl display surface add failed...");
            synchronized (this.mViewLock) {
                VideoRenderView videoRenderView = this.mVideoRenderView;
                if (videoRenderView != null) {
                    videoRenderView.resetSurface();
                }
            }
        } else if (intValue == 1501) {
            OmniLog.e(TAG, "Recv local egl display surface render failed...");
        }
    }

    private void executingVideoEncoderParamsSetting(Object[] objArr) {
        boolean z = false;
        int intValue = objArr[0].intValue();
        int intValue2 = objArr[1].intValue();
        int intValue3 = objArr[2].intValue();
        int intValue4 = objArr[3].intValue();
        if (objArr[4].booleanValue()) {
            if (this.mVideoDualEncoderWidth != intValue || this.mVideoDualEncoderHeight != intValue2 || this.mVideoDualEncoderFps != intValue3 || this.mVideoDualEncoderBitrate != intValue4) {
                synchronized (this.mControlLock) {
                    if (this.mVideoDualEncoderWidth != intValue || this.mVideoDualEncoderHeight != intValue2) {
                        z = true;
                    }
                    this.mVideoDualEncoderWidth = intValue;
                    this.mVideoDualEncoderHeight = intValue2;
                    this.mVideoDualEncoderFps = intValue3;
                    this.mVideoDualEncoderBitrate = intValue4;
                    if (!z) {
                        this.mVideoRenderer.setVideoDualEncodeRate(intValue3);
                        this.mLocalVideoEncoder.setVideoEncoderParams(LocalVideoEncoder.VideoEncoderType.DUAL, intValue4);
                    } else {
                        updateVideoDualEncoderParams();
                        this.mVideoRenderer.setVideoDualEncodedSize(this.mVideoEncoderWidth, this.mVideoEncoderHeight);
                    }
                }
                logI("Setting dual video params! render started? " + this.mStartRendered + " | width : " + this.mVideoDualEncoderWidth + " | height : " + this.mVideoDualEncoderHeight + " | fps : " + this.mVideoDualEncoderFps + " | bitrate : " + this.mVideoDualEncoderBitrate);
            }
        } else if (this.mVideoEncoderWidth != intValue || this.mVideoEncoderHeight != intValue2 || this.mVideoEncoderFps != intValue3 || this.mVideoEncoderBitrate != intValue4) {
            synchronized (this.mControlLock) {
                boolean z2 = (this.mVideoEncoderWidth == intValue && this.mVideoEncoderHeight == intValue2) ? false : true;
                this.mVideoEncoderWidth = intValue;
                this.mVideoEncoderHeight = intValue2;
                this.mVideoEncoderFps = intValue3;
                this.mVideoEncoderBitrate = intValue4;
                this.mVideoCapFps = intValue3;
                this.mVideoRenderer.setVideoCapRate(intValue3);
                if (!z2) {
                    this.mLocalVideoEncoder.setVideoEncoderParams(LocalVideoEncoder.VideoEncoderType.MAIN, intValue4);
                } else {
                    updateVideoEncoderParams();
                    this.mVideoRenderer.setVideoEncodedSize(this.mVideoEncoderWidth, this.mVideoEncoderHeight);
                }
            }
            if (!this.mCustomVideoCapSizeSetting) {
                boolean isVideoCaping = this.mVideoCapturer.isVideoCaping();
                int[] adjustSizeByRotate = DeviceUtils.adjustSizeByRotate(intValue, intValue2, this.mVideoCapturer.getCameraRotate());
                if (isVideoCaping) {
                    CommonEventBean commonEventBean = new CommonEventBean(206, new Object[0]);
                    commonEventBean.mObjects = new Object[]{Integer.valueOf(intValue), Integer.valueOf(intValue2)};
                    handleVideoCapPreviewResolution(commonEventBean, true);
                } else {
                    this.mVideoCapWidth = adjustSizeByRotate[0];
                    this.mVideoCapHeight = adjustSizeByRotate[1];
                }
            } else {
                BaseCameraInterImpl.CameraPreSize cameraPreSize = this.mVideoCapturer.getCameraPreSize();
                if (cameraPreSize != null) {
                    this.mVideoRenderer.setVideoSize(cameraPreSize.width, cameraPreSize.height);
                }
            }
            logI("Setting video params! render started? " + this.mStartRendered + " | newCapWidth : " + this.mVideoEncoderWidth + " | newCapHeight : " + this.mVideoEncoderHeight + " | newCapFps : " + this.mVideoEncoderFps + " | newCapBitrate : " + this.mVideoEncoderBitrate);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0068, code lost:
        r1 = r5.mVideoCapturer.getCameraPreSize();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006e, code lost:
        if (r1 != null) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0070, code lost:
        r5.mOnLocalVideoRenderModelCallBack.onVideoCaptureError(com.wushuangtech.library.video.VideoErrorConstants.VIDEO_CAP_ERROR_PREVIEW_PARAMS_GET_NULL);
        logE("Start local video module failed, " + "CameraPreSize is null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0092, code lost:
        if (r5.mVideoCapturer.getVideoCapSize() != null) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0094, code lost:
        logE("Start local video module failed, " + "Video cap size is null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a8, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a9, code lost:
        r2 = r5.mVideoCapturer.getCameraRotate();
        updateVideoEncoderParams();
        updateVideoDualEncoderParams();
        r5.mVideoRenderer.setRotate(r2);
        r5.mVideoRenderer.setVideoSize(r1.width, r1.height);
        r5.mVideoRenderer.setVideoEncodedSize(r5.mVideoEncoderWidth, r5.mVideoEncoderHeight);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d2, code lost:
        if (r5.mVideoRenderer.startRender() != false) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d4, code lost:
        logE("Start local video module failed, " + "Video renderer start failed!");
        r5.mOnLocalVideoRenderModelCallBack.onVideoRenderFailed(com.wushuangtech.library.video.VideoErrorConstants.VIDEO_RENDER_START_FAILED);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ef, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f0, code lost:
        r5.mStartRendered = true;
        logI("Start local video module success!");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f7, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleVideoRendererStart() {
        /*
            r5 = this;
            boolean r0 = r5.mStartRendered
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = com.wushuangtech.library.GlobalConfig.mExternalVideoSource
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = "External video started, abort action."
            r5.logE(r0)
            return
        L_0x000f:
            java.lang.String r0 = "Executing start local video module!"
            r5.logI(r0)
            java.lang.String r0 = "Start local video module failed, "
            com.wushuangtech.library.GlobalHolder r1 = com.wushuangtech.library.GlobalHolder.getInstance()
            android.content.Context r1 = r1.getContext()
            int r1 = com.wushuangtech.utils.DeviceUtils.getRotation(r1)
            r2 = -1
            if (r1 != r2) goto L_0x003a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "update camera orientation failed!"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r5.logE(r0)
            return
        L_0x003a:
            com.wushuangtech.myvideoimprove.capture.VideoCapCameraInterImpl r2 = r5.mVideoCapturer
            r2.setCameraOrientation(r1)
            int r1 = r5.startVideoCaping()
            java.lang.Object r2 = r5.mControlLock
            monitor-enter(r2)
            r3 = 1
            if (r1 == 0) goto L_0x0064
            r5.mCameraStartFailed = r3     // Catch:{ all -> 0x00f8 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f8 }
            r3.<init>()     // Catch:{ all -> 0x00f8 }
            r3.append(r0)     // Catch:{ all -> 0x00f8 }
            java.lang.String r0 = "Camera start failed! ret = "
            r3.append(r0)     // Catch:{ all -> 0x00f8 }
            r3.append(r1)     // Catch:{ all -> 0x00f8 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00f8 }
            r5.logE(r0)     // Catch:{ all -> 0x00f8 }
            monitor-exit(r2)     // Catch:{ all -> 0x00f8 }
            return
        L_0x0064:
            r1 = 0
            r5.mCameraStartFailed = r1     // Catch:{ all -> 0x00f8 }
            monitor-exit(r2)     // Catch:{ all -> 0x00f8 }
            com.wushuangtech.myvideoimprove.capture.VideoCapCameraInterImpl r1 = r5.mVideoCapturer
            com.wushuangtech.myvideoimprove.capture.camera.BaseCameraInterImpl$CameraPreSize r1 = r1.getCameraPreSize()
            if (r1 != 0) goto L_0x008c
            com.wushuangtech.myvideoimprove.LocalVideoRenderModel$OnLocalVideoRenderModelCallBack r1 = r5.mOnLocalVideoRenderModelCallBack
            r2 = 601(0x259, float:8.42E-43)
            r1.onVideoCaptureError(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "CameraPreSize is null"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r5.logE(r0)
            return
        L_0x008c:
            com.wushuangtech.myvideoimprove.capture.VideoCapCameraInterImpl r2 = r5.mVideoCapturer
            int[] r2 = r2.getVideoCapSize()
            if (r2 != 0) goto L_0x00a9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "Video cap size is null"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r5.logE(r0)
            return
        L_0x00a9:
            com.wushuangtech.myvideoimprove.capture.VideoCapCameraInterImpl r2 = r5.mVideoCapturer
            int r2 = r2.getCameraRotate()
            r5.updateVideoEncoderParams()
            r5.updateVideoDualEncoderParams()
            com.wushuangtech.myvideoimprove.render.LocalVideoRenderer r4 = r5.mVideoRenderer
            r4.setRotate(r2)
            com.wushuangtech.myvideoimprove.render.LocalVideoRenderer r2 = r5.mVideoRenderer
            int r4 = r1.width
            int r1 = r1.height
            r2.setVideoSize(r4, r1)
            com.wushuangtech.myvideoimprove.render.LocalVideoRenderer r1 = r5.mVideoRenderer
            int r2 = r5.mVideoEncoderWidth
            int r4 = r5.mVideoEncoderHeight
            r1.setVideoEncodedSize(r2, r4)
            com.wushuangtech.myvideoimprove.render.LocalVideoRenderer r1 = r5.mVideoRenderer
            boolean r1 = r1.startRender()
            if (r1 != 0) goto L_0x00f0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "Video renderer start failed!"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r5.logE(r0)
            com.wushuangtech.myvideoimprove.LocalVideoRenderModel$OnLocalVideoRenderModelCallBack r0 = r5.mOnLocalVideoRenderModelCallBack
            r1 = 10050(0x2742, float:1.4083E-41)
            r0.onVideoRenderFailed(r1)
            return
        L_0x00f0:
            r5.mStartRendered = r3
            java.lang.String r0 = "Start local video module success!"
            r5.logI(r0)
            return
        L_0x00f8:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00f8 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.LocalVideoRenderModel.handleVideoRendererStart():void");
    }

    private void handleVideoRendererStop() {
        if (this.mStartRendered) {
            long currentTimeMillis = System.currentTimeMillis();
            this.mVideoRenderer.stopRender();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            this.mVideoCapturer.stopVideoCapture();
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
            this.mStartRendered = false;
            logI("Stop local video module success! spend time : " + currentTimeMillis2 + " | " + currentTimeMillis3);
        }
    }

    private void executingControlEncoder(boolean z, boolean z2) {
        if (z) {
            executingOpenEncoder(z2, this.mForcedSoftEncoding);
            return;
        }
        if (z2) {
            this.mLocalVideoEncoder.stopEncoder(LocalVideoEncoder.VideoEncoderType.DUAL);
        } else {
            this.mLocalVideoEncoder.stopEncoder(LocalVideoEncoder.VideoEncoderType.MAIN);
        }
        this.mVideoRenderer.setEnableReadPixel(false);
    }

    private void executingOpenEncoder(boolean z, boolean z2) {
        LocalVideoEncoder.VideoEncoderType videoEncoderType = LocalVideoEncoder.VideoEncoderType.MAIN;
        if (z) {
            videoEncoderType = LocalVideoEncoder.VideoEncoderType.DUAL;
        }
        if (z2) {
            this.mVideoRenderer.setEnableReadPixel(true);
        }
        this.mLocalVideoEncoder.setSoftEncodrType(videoEncoderType, z2);
        this.mLocalVideoEncoder.startEncoder(videoEncoderType);
    }

    private int startVideoCaping() {
        if (this.mVideoCapturer.isVideoCaping()) {
            return 0;
        }
        try {
            if (GlobalConfig.mVideoCapStartTimestamp == 0) {
                GlobalConfig.mVideoCapStartTimestamp = System.currentTimeMillis();
            }
            OmniLog.i(OmniLog.VIDEO_CAP_SPEED_WATCH, TAG, "Prepare camera start: " + (System.currentTimeMillis() - GlobalConfig.mVideoCapStartTimestamp));
            OmniLog.i(OmniLog.VIDEO_CAP_SPEED_WATCH, TAG, "Camera params width=" + this.mVideoCapWidth + ", height=" + this.mVideoCapHeight + ", fps=" + this.mVideoCapFps);
            this.mVideoCapturer.setCameraParams(this.mVideoCapWidth, this.mVideoCapHeight, this.mVideoCapFps);
            VideoCapCameraConfigureBean videoCapCameraConfigureBean = (VideoCapCameraConfigureBean) this.mVideoCapturer.initVideoCapture();
            if (!(videoCapCameraConfigureBean.mCameraOpenResult != 0 || videoCapCameraConfigureBean.mCamera == null || videoCapCameraConfigureBean.mPreviewWidth == 0)) {
                if (videoCapCameraConfigureBean.mPreviewHeight != 0) {
                    SurfaceTexture videoCapSurfaceTexture = this.mVideoRenderer.getVideoCapSurfaceTexture();
                    if (videoCapSurfaceTexture == null) {
                        logE("Get video capture texture failed... " + videoCapCameraConfigureBean.toString());
                        Message.obtain(this.mWorkHandler, 300, 600).sendToTarget();
                        return 600;
                    }
                    videoCapCameraConfigureBean.mCameraTexture = videoCapSurfaceTexture;
                    int i = ((VideoCapCameraConfigureBean) this.mVideoCapturer.startVideoCapture(videoCapCameraConfigureBean)).mCameraOpenResult;
                    if (i != 0) {
                        Message.obtain(this.mWorkHandler, 300, Integer.valueOf(i)).sendToTarget();
                    } else {
                        Message.obtain(this.mWorkHandler, 300, 0).sendToTarget();
                    }
                    return i;
                }
            }
            logE("Init video capture failed... " + videoCapCameraConfigureBean.toString());
            int i2 = videoCapCameraConfigureBean.mCameraOpenResult;
            if (i2 != 0) {
                Message.obtain(this.mWorkHandler, 300, Integer.valueOf(i2)).sendToTarget();
            }
            return i2;
        } finally {
            Message.obtain(this.mWorkHandler, 300, 0).sendToTarget();
        }
    }

    private void dynamicAdjustRotate(Message message) {
        long currentTimeMillis = System.currentTimeMillis();
        int i = ((VideoRotateBean) message.obj).mRotation;
        int[] videoCapSize = this.mVideoCapturer.getVideoCapSize();
        BaseCameraInterImpl.CameraPreSize cameraPreSize = this.mVideoCapturer.getCameraPreSize();
        if (videoCapSize == null || cameraPreSize == null) {
            logE("Dynamic adjust rotate failed! videoCapSize or CameraPreSize is null!");
            return;
        }
        this.mVideoCapturer.setCameraOrientation(i);
        updateVideoEncoderParams();
        updateVideoDualEncoderParams();
        this.mVideoRenderer.setRotate(this.mVideoCapturer.getCameraRotate());
        logI("Adjust rotate spent time : " + (System.currentTimeMillis() - currentTimeMillis));
    }

    private void printThreadLog() {
        if (this.mWorkHandlerThread != null) {
            this.mWorkHandlerThread.isAlive();
        }
    }

    private void updateVideoEncoderParams() {
        int[] adjustSizeByRotate = DeviceUtils.adjustSizeByRotate(this.mVideoEncoderWidth, this.mVideoEncoderHeight, this.mVideoCapturer.getCameraRotate());
        int i = adjustSizeByRotate[0];
        int i2 = adjustSizeByRotate[1];
        int i3 = i - (i % 16);
        int i4 = i2 - (i2 % 16);
        this.mLocalVideoEncoder.setVideoEncoderParams(LocalVideoEncoder.VideoEncoderType.MAIN, i3, i4, this.mVideoEncoderFps, this.mVideoEncoderBitrate, 1);
        if (this.mVideoDualEncoderWidth == 0 && this.mVideoDualEncoderHeight == 0 && this.mVideoDualEncoderFps == 0 && this.mVideoDualEncoderBitrate == 0) {
            this.mLocalVideoEncoder.setVideoEncoderParams(LocalVideoEncoder.VideoEncoderType.DUAL, i3 / 4, i4 / 4, this.mVideoEncoderFps, this.mVideoEncoderBitrate / 4, 1);
        }
    }

    private void updateVideoDualEncoderParams() {
        if (this.mVideoDualEncoderWidth != 0 && this.mVideoDualEncoderHeight != 0 && this.mVideoDualEncoderFps != 0 && this.mVideoDualEncoderBitrate != 0) {
            int[] adjustSizeByRotate = DeviceUtils.adjustSizeByRotate(this.mVideoDualEncoderWidth, this.mVideoDualEncoderHeight, this.mVideoCapturer.getCameraRotate());
            int i = adjustSizeByRotate[0];
            int i2 = adjustSizeByRotate[1];
            this.mLocalVideoEncoder.setVideoEncoderParams(LocalVideoEncoder.VideoEncoderType.DUAL, i - (i % 16), i2 - (i2 % 16), this.mVideoDualEncoderFps, this.mVideoDualEncoderBitrate, 1);
        }
    }

    private void writeVideoLocalRawData(byte[] bArr, int i, int i2) {
        File externalFilesDir;
        Context context = GlobalHolder.getInstance().getContext();
        if (context != null && (externalFilesDir = context.getExternalFilesDir((String) null)) != null && externalFilesDir.exists()) {
            try {
                String str = externalFilesDir.getAbsolutePath() + "/VideoDataSave/video_local_raw_data_+ " + i + "_" + i2 + ".nv21";
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                file.mkdirs();
                if (this.mTestVideoDataWriter == null) {
                    VideoDataWriter videoDataWriter = new VideoDataWriter();
                    this.mTestVideoDataWriter = videoDataWriter;
                    videoDataWriter.setFilePath(str);
                    this.mTestVideoDataWriter.initTest();
                }
                this.mTestVideoDataWriter.writeVideoRawDatas(bArr, i, i2);
            } catch (Exception unused) {
            }
        }
    }

    public int onVideoFrameData(int i, byte[] bArr, int i2, int i3, int i4, long j) {
        OnLocalVideoTextureCallBack onLocalVideoTextureCallBack = this.mOnLocalVideoTextureCallBack;
        if (onLocalVideoTextureCallBack != null) {
            i = onLocalVideoTextureCallBack.onVideoFrameTexture(i, bArr, i2, i3, i4, j);
            VideoFrame videoFrame = new VideoFrame();
            videoFrame.format = 1;
            videoFrame.data = bArr;
            videoFrame.width = i2;
            videoFrame.height = i3;
            videoFrame.timeStamp = j;
            videoFrame.mRotate = i4;
            LocalVideoEncoder localVideoEncoder = this.mLocalVideoEncoder;
            if (localVideoEncoder != null) {
                localVideoEncoder.receiveVideoData(videoFrame);
            }
        }
        return i;
    }

    public void onVideoFrameDrawingFailed(int i) {
        OmniLog.e(OmniLog.VIDEO_RENDER_WATCH, TAG, "Import renderer error hanppend... " + i + ", try next...");
        Message obtain = Message.obtain();
        obtain.what = 301;
        obtain.obj = Integer.valueOf(i);
        this.mWorkHandler.sendMessageDelayed(obtain, 1000);
    }

    public boolean onVideoRendererFirstFrame() {
        BaseCameraInterImpl.CameraPreSize cameraPreSize = this.mVideoCapturer.getCameraPreSize();
        if (cameraPreSize == null) {
            return false;
        }
        this.mOnLocalVideoRenderModelCallBack.onVideoFirstLocalVideoFrame(cameraPreSize.width, cameraPreSize.height);
        return true;
    }

    public void onVideoRendererUninit() {
        this.mWaterMarkController.clearResource();
        LocalVideoRenderer localVideoRenderer = this.mVideoRenderer;
        if (localVideoRenderer != null) {
            localVideoRenderer.destroyVideoRenderer();
            this.mVideoRenderer = null;
        }
        VideoCapCameraInterImpl videoCapCameraInterImpl = this.mVideoCapturer;
        if (videoCapCameraInterImpl != null) {
            videoCapCameraInterImpl.stopVideoCapture();
            this.mVideoCapturer = null;
        }
        LocalVideoEncoder localVideoEncoder = this.mLocalVideoEncoder;
        if (localVideoEncoder != null) {
            localVideoEncoder.clearResource();
            this.mLocalVideoEncoder = null;
        }
        if (this.mWorkHandler != null) {
            this.mWorkHandler.removeCallbacksAndMessages((Object) null);
            this.mWorkHandler.removeRef();
            this.mWorkHandler = null;
        }
        if (this.mWorkHandlerThread != null) {
            this.mWorkHandlerThread.quit();
            this.mWorkHandlerThread = null;
        }
        HandlerUrgentQueue handlerUrgentQueue = this.mHandlerUrgentQueue;
        if (handlerUrgentQueue != null) {
            handlerUrgentQueue.destroyQueue();
            this.mHandlerUrgentQueue = null;
        }
        this.mOnLocalVideoRenderModelCallBack.onVideoRenderModelDestoryed();
        OmniLog.i("Destory local video render model success!");
    }

    public void onScreenRotateChanged(int i) {
        if (this.mWorkHandler != null) {
            this.mHandlerUrgentQueue.executeUrgentMsg(this.mWorkHandler, Message.obtain(this.mWorkHandler, 6, new VideoRotateBean(i)));
        }
    }

    public void onGlobalMessage(int i, Object... objArr) {
        if (3000 == i) {
            sendEventBean(200, new CommonEventBean(204, new Object[0]));
        }
    }

    private static class LocalCameraCaptureCallBackImpl implements VideoCapCameraInterImpl.OnCameraCaptureCallBack {
        private final WeakReference<LocalVideoRenderModel> mOutReference;

        public LocalCameraCaptureCallBackImpl(LocalVideoRenderModel localVideoRenderModel) {
            this.mOutReference = new WeakReference<>(localVideoRenderModel);
        }

        public void onCameraError(int i) {
            LocalVideoRenderModel localVideoRenderModel = (LocalVideoRenderModel) this.mOutReference.get();
            if (localVideoRenderModel != null) {
                if (i == 2) {
                    localVideoRenderModel.mOnLocalVideoModuleEventCallBack.onVideoCameraError(VideoErrorConstants.VIDEO_CAP_ERROR_BUSY);
                }
                synchronized (localVideoRenderModel.mControlLock) {
                    boolean unused = localVideoRenderModel.mCameraError = true;
                }
            }
        }

        public void onCameraPreviewFrameCallBack(VideoCapFrame videoCapFrame) {
            LocalVideoRenderModel localVideoRenderModel = (LocalVideoRenderModel) this.mOutReference.get();
            if (localVideoRenderModel != null) {
                if (localVideoRenderModel.mOnLocalVideoNV21DataCallBack != null) {
                    localVideoRenderModel.mOnLocalVideoNV21DataCallBack.onVideoFrameData(videoCapFrame.mData, videoCapFrame.mWidth, videoCapFrame.mHeight, videoCapFrame.mRotate, videoCapFrame.mTimestamp);
                }
                localVideoRenderModel.mVideoRenderer.notifyPreviewFrameOutput(videoCapFrame);
            }
        }
    }

    private static class LocalVideoRenderViewCallBackImpl implements VideoRenderView.OnVideoRenderViewCallBack {
        private final WeakReference<LocalVideoRenderModel> mOutReference;

        public void onViewRenderAttachedToWindow(VideoRenderView videoRenderView) {
        }

        public void onViewRenderDetachedFromWindow(VideoRenderView videoRenderView) {
        }

        public LocalVideoRenderViewCallBackImpl(LocalVideoRenderModel localVideoRenderModel) {
            this.mOutReference = new WeakReference<>(localVideoRenderModel);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0063, code lost:
            com.wushuangtech.myvideoimprove.LocalVideoRenderModel.access$000(r0).setDisplaySurfaceWindow(r6.mRenderView, r6.mSurface);
            r1 = r6.mWidth;
            r6 = r6.mHeight;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0072, code lost:
            if (r1 == 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0074, code lost:
            if (r6 == 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0076, code lost:
            r2 = android.os.Message.obtain();
            r2.what = 8;
            r2.obj = new int[]{r1, r6};
            com.wushuangtech.myvideoimprove.LocalVideoRenderModel.access$500(r0, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onVideoRenderSurfaceAvailable(com.wushuangtech.myvideoimprove.bean.VideoRenderViewLifeBean r6) {
            /*
                r5 = this;
                java.lang.ref.WeakReference<com.wushuangtech.myvideoimprove.LocalVideoRenderModel> r0 = r5.mOutReference
                java.lang.Object r0 = r0.get()
                com.wushuangtech.myvideoimprove.LocalVideoRenderModel r0 = (com.wushuangtech.myvideoimprove.LocalVideoRenderModel) r0
                if (r0 != 0) goto L_0x000b
                return
            L_0x000b:
                java.lang.String r1 = "LVRM"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Setting the display surface create... "
                r2.append(r3)
                java.lang.String r3 = r6.toString()
                r2.append(r3)
                java.lang.String r3 = " | current: "
                r2.append(r3)
                com.wushuangtech.myvideoimprove.view.VideoRenderView r3 = r0.mVideoRenderView
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                com.wushuangtech.utils.OmniLog.i(r1, r2)
                java.lang.Object r1 = r0.mViewLock
                monitor-enter(r1)
                java.lang.Object r2 = r6.mRenderView     // Catch:{ all -> 0x008d }
                if (r2 != 0) goto L_0x0038
                monitor-exit(r1)     // Catch:{ all -> 0x008d }
                return
            L_0x0038:
                java.lang.Object r2 = r6.mRenderView     // Catch:{ all -> 0x008d }
                com.wushuangtech.myvideoimprove.view.VideoRenderView r3 = r0.mVideoRenderView     // Catch:{ all -> 0x008d }
                if (r2 == r3) goto L_0x0062
                java.lang.String r2 = "LVRM"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
                r3.<init>()     // Catch:{ all -> 0x008d }
                java.lang.String r4 = "Setting the display surface create... but view not same, come : "
                r3.append(r4)     // Catch:{ all -> 0x008d }
                java.lang.Object r6 = r6.mRenderView     // Catch:{ all -> 0x008d }
                r3.append(r6)     // Catch:{ all -> 0x008d }
                java.lang.String r6 = " | current: "
                r3.append(r6)     // Catch:{ all -> 0x008d }
                com.wushuangtech.myvideoimprove.view.VideoRenderView r6 = r0.mVideoRenderView     // Catch:{ all -> 0x008d }
                r3.append(r6)     // Catch:{ all -> 0x008d }
                java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x008d }
                com.wushuangtech.utils.OmniLog.w(r2, r6)     // Catch:{ all -> 0x008d }
                monitor-exit(r1)     // Catch:{ all -> 0x008d }
                return
            L_0x0062:
                monitor-exit(r1)     // Catch:{ all -> 0x008d }
                com.wushuangtech.myvideoimprove.render.LocalVideoRenderer r1 = r0.mVideoRenderer
                java.lang.Object r2 = r6.mRenderView
                java.lang.Object r3 = r6.mSurface
                r1.setDisplaySurfaceWindow(r2, r3)
                int r1 = r6.mWidth
                int r6 = r6.mHeight
                if (r1 == 0) goto L_0x008c
                if (r6 == 0) goto L_0x008c
                android.os.Message r2 = android.os.Message.obtain()
                r3 = 8
                r2.what = r3
                r3 = 2
                int[] r3 = new int[r3]
                r4 = 0
                r3[r4] = r1
                r1 = 1
                r3[r1] = r6
                r2.obj = r3
                r0.localSendMessage(r2)
            L_0x008c:
                return
            L_0x008d:
                r6 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x008d }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.LocalVideoRenderModel.LocalVideoRenderViewCallBackImpl.onVideoRenderSurfaceAvailable(com.wushuangtech.myvideoimprove.bean.VideoRenderViewLifeBean):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0063, code lost:
            r1 = r6.mWidth;
            r6 = r6.mHeight;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0067, code lost:
            if (r1 == 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
            if (r6 == 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x006b, code lost:
            r2 = android.os.Message.obtain();
            r2.what = 8;
            r2.obj = new int[]{r1, r6};
            com.wushuangtech.myvideoimprove.LocalVideoRenderModel.access$500(r0, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onVideoRenderSurfaceSizeChanged(com.wushuangtech.myvideoimprove.bean.VideoRenderViewLifeBean r6) {
            /*
                r5 = this;
                java.lang.ref.WeakReference<com.wushuangtech.myvideoimprove.LocalVideoRenderModel> r0 = r5.mOutReference
                java.lang.Object r0 = r0.get()
                com.wushuangtech.myvideoimprove.LocalVideoRenderModel r0 = (com.wushuangtech.myvideoimprove.LocalVideoRenderModel) r0
                if (r0 != 0) goto L_0x000b
                return
            L_0x000b:
                java.lang.String r1 = "LVRM"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Setting the display surface size... "
                r2.append(r3)
                java.lang.String r3 = r6.toString()
                r2.append(r3)
                java.lang.String r3 = " | current: "
                r2.append(r3)
                com.wushuangtech.myvideoimprove.view.VideoRenderView r3 = r0.mVideoRenderView
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                com.wushuangtech.utils.OmniLog.i(r1, r2)
                java.lang.Object r1 = r0.mViewLock
                monitor-enter(r1)
                java.lang.Object r2 = r6.mRenderView     // Catch:{ all -> 0x0082 }
                if (r2 != 0) goto L_0x0038
                monitor-exit(r1)     // Catch:{ all -> 0x0082 }
                return
            L_0x0038:
                java.lang.Object r2 = r6.mRenderView     // Catch:{ all -> 0x0082 }
                com.wushuangtech.myvideoimprove.view.VideoRenderView r3 = r0.mVideoRenderView     // Catch:{ all -> 0x0082 }
                if (r2 == r3) goto L_0x0062
                java.lang.String r2 = "LVRM"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
                r3.<init>()     // Catch:{ all -> 0x0082 }
                java.lang.String r4 = "Setting the display surface size... but view not same, come : "
                r3.append(r4)     // Catch:{ all -> 0x0082 }
                java.lang.Object r6 = r6.mRenderView     // Catch:{ all -> 0x0082 }
                r3.append(r6)     // Catch:{ all -> 0x0082 }
                java.lang.String r6 = " | current: "
                r3.append(r6)     // Catch:{ all -> 0x0082 }
                com.wushuangtech.myvideoimprove.view.VideoRenderView r6 = r0.mVideoRenderView     // Catch:{ all -> 0x0082 }
                r3.append(r6)     // Catch:{ all -> 0x0082 }
                java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x0082 }
                com.wushuangtech.utils.OmniLog.w(r2, r6)     // Catch:{ all -> 0x0082 }
                monitor-exit(r1)     // Catch:{ all -> 0x0082 }
                return
            L_0x0062:
                monitor-exit(r1)     // Catch:{ all -> 0x0082 }
                int r1 = r6.mWidth
                int r6 = r6.mHeight
                if (r1 == 0) goto L_0x0081
                if (r6 == 0) goto L_0x0081
                android.os.Message r2 = android.os.Message.obtain()
                r3 = 8
                r2.what = r3
                r3 = 2
                int[] r3 = new int[r3]
                r4 = 0
                r3[r4] = r1
                r1 = 1
                r3[r1] = r6
                r2.obj = r3
                r0.localSendMessage(r2)
            L_0x0081:
                return
            L_0x0082:
                r6 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0082 }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.LocalVideoRenderModel.LocalVideoRenderViewCallBackImpl.onVideoRenderSurfaceSizeChanged(com.wushuangtech.myvideoimprove.bean.VideoRenderViewLifeBean):void");
        }

        public void onVideoRenderSurfaceDestroyed(VideoRenderViewLifeBean videoRenderViewLifeBean) {
            LocalVideoRenderModel localVideoRenderModel = (LocalVideoRenderModel) this.mOutReference.get();
            if (localVideoRenderModel != null) {
                OmniLog.i(LocalVideoRenderModel.TAG, "Setting the display surface release... " + videoRenderViewLifeBean.toString() + " | current: " + localVideoRenderModel.mVideoRenderView);
                synchronized (localVideoRenderModel.mViewLock) {
                    if (videoRenderViewLifeBean.mRenderView != null) {
                        if (videoRenderViewLifeBean.mRenderView != localVideoRenderModel.mVideoRenderView) {
                            OmniLog.w(LocalVideoRenderModel.TAG, "Setting the display surface release... but view not same, come : " + videoRenderViewLifeBean.mRenderView + " | current: " + localVideoRenderModel.mVideoRenderView);
                            return;
                        }
                        localVideoRenderModel.mVideoRenderer.releaseDisplaySurfaceWindow(videoRenderViewLifeBean.mRenderView, videoRenderViewLifeBean.mSurface);
                    }
                }
            }
        }
    }

    private static class LocalVideoEncoderCallBackImpl implements LocalVideoEncoder.OnLocalVideoEncoderCallBack {
        private final WeakReference<LocalVideoRenderModel> mOutReference;

        public LocalVideoEncoderCallBackImpl(LocalVideoRenderModel localVideoRenderModel) {
            this.mOutReference = new WeakReference<>(localVideoRenderModel);
        }

        public void onEncodedDataReport(boolean z, byte[] bArr, int i, int i2, int i3, long j) {
            LocalVideoRenderModel localVideoRenderModel = (LocalVideoRenderModel) this.mOutReference.get();
            if (localVideoRenderModel != null) {
                VideoStatistical globalVideoStatistical = GlobalHolder.getInstance().getGlobalVideoStatistical();
                if (globalVideoStatistical != null) {
                    globalVideoStatistical.updateVideoLocalEncodeEnd();
                    boolean z2 = z;
                    byte[] bArr2 = bArr;
                    globalVideoStatistical.updateVideoLocalEncStats(z, bArr);
                } else {
                    boolean z3 = z;
                    byte[] bArr3 = bArr;
                }
                if (localVideoRenderModel.mOnLocalVideoRenderModelCallBack != null) {
                    localVideoRenderModel.mOnLocalVideoRenderModelCallBack.onVideoEncodedDataReport(z, bArr, i, i2, i3, j);
                }
            }
        }

        public void onEncoderTypeChanged(boolean z) {
            LocalVideoRenderer access$000;
            LocalVideoRenderModel localVideoRenderModel = (LocalVideoRenderModel) this.mOutReference.get();
            if (localVideoRenderModel != null && (access$000 = localVideoRenderModel.mVideoRenderer) != null) {
                OmniLog.i("onEncoderTypeChanged Enable read piexl for soft encoder...");
                access$000.setEnableReadPixel(true);
            }
        }

        public void onEncoderStartSuccess() {
            LocalVideoRenderModel localVideoRenderModel = (LocalVideoRenderModel) this.mOutReference.get();
            if (localVideoRenderModel != null && localVideoRenderModel.mVideoRenderer != null) {
                localVideoRenderModel.mVideoRenderer.setWaitingForEncoderRestart(false);
            }
        }

        public void onEncoderStartFailed() {
            LocalVideoRenderModel localVideoRenderModel = (LocalVideoRenderModel) this.mOutReference.get();
            if (localVideoRenderModel != null) {
                localVideoRenderModel.mOnLocalVideoRenderModelCallBack.onVideoStartEncoderFailed(501);
            }
        }
    }

    private static class WorkThreadHandler extends Handler {
        private final WeakReference<LocalVideoRenderModel> mOutReference;

        WorkThreadHandler(Looper looper, LocalVideoRenderModel localVideoRenderModel) {
            super(looper);
            this.mOutReference = new WeakReference<>(localVideoRenderModel);
        }

        /* access modifiers changed from: package-private */
        public void removeRef() {
            this.mOutReference.clear();
        }

        public void handleMessage(Message message) {
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            LocalVideoRenderModel localVideoRenderModel = (LocalVideoRenderModel) this.mOutReference.get();
            if (localVideoRenderModel == null) {
                AsynchronousInstrumentation.handlerMessageEnd();
                return;
            }
            localVideoRenderModel.receiveWorkMessage(message);
            AsynchronousInstrumentation.handlerMessageEnd();
        }
    }

    private static class ControlThreadRunnable implements Runnable {
        private static final int INTERVAL_CAMERA_ERROR = 1500;
        private static final int INTERVAL_CAMERA_START_ERROR = 3000;
        private static final int INTERVAL_FAST = 10;
        private static final int INTERVAL_NORMAL = 50;
        private boolean mCameraError;
        private boolean mCameraStartFailed;
        private final WeakReference<LocalVideoRenderModel> mLocalVideoRenderModelRef;

        public ControlThreadRunnable(LocalVideoRenderModel localVideoRenderModel) {
            this.mLocalVideoRenderModelRef = new WeakReference<>(localVideoRenderModel);
        }

        public void run() {
            boolean isStartRendererFun;
            LocalVideoRenderModel localVideoRenderModel = (LocalVideoRenderModel) this.mLocalVideoRenderModelRef.get();
            if (localVideoRenderModel != null) {
                Process.setThreadPriority(10);
                while (true) {
                    synchronized (localVideoRenderModel.mControlLock) {
                        isStartRendererFun = isStartRendererFun(localVideoRenderModel);
                        this.mCameraError = localVideoRenderModel.mCameraError;
                        this.mCameraStartFailed = localVideoRenderModel.mCameraStartFailed;
                        if (!isStartRendererFun) {
                            this.mCameraStartFailed = false;
                        }
                    }
                    if (this.mCameraError && isStartRendererFun) {
                        localVideoRenderModel.sendEventBean(200, new CommonEventBean(205, new Object[0]));
                    }
                    if (isStartRendererFun) {
                        if (!localVideoRenderModel.mStartRendered) {
                            startRender(localVideoRenderModel);
                        }
                    } else if (localVideoRenderModel.mStartRendered) {
                        stopRender(localVideoRenderModel);
                    }
                    try {
                        Thread.sleep((long) calcSleepTime(localVideoRenderModel));
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }

        public void startRender(LocalVideoRenderModel localVideoRenderModel) {
            localVideoRenderModel.mHandlerUrgentQueue.executeUrgentMsg(localVideoRenderModel.mWorkHandler, Message.obtain(localVideoRenderModel.mWorkHandler, 4));
        }

        public void stopRender(LocalVideoRenderModel localVideoRenderModel) {
            localVideoRenderModel.mHandlerUrgentQueue.executeUrgentMsg(localVideoRenderModel.mWorkHandler, Message.obtain(localVideoRenderModel.mWorkHandler, 5));
        }

        private int calcSleepTime(LocalVideoRenderModel localVideoRenderModel) {
            if (this.mCameraError) {
                return 1500;
            }
            if (this.mCameraStartFailed) {
                return 3000;
            }
            return isStartRendererFun(localVideoRenderModel) != localVideoRenderModel.mStartRendered ? 10 : 50;
        }

        private boolean isStartRendererFun(LocalVideoRenderModel localVideoRenderModel) {
            return localVideoRenderModel.mSetupLocal && GlobalConfig.mVideoLocalEnabled && !GlobalConfig.mExternalVideoSource;
        }
    }
}
