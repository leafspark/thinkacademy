package io.agora.rtc.mediaio;

import android.content.Context;
import android.graphics.ImageFormat;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import android.view.WindowManager;
import com.wushuangtech.constants.LocalSDKConstants;
import io.agora.rtc.mediaio.MediaIO;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class AgoraBufferedCamera2 extends CameraSource {
    private static final int STATE_PREVIEW = 0;
    private static final int STATE_WAITING_LOCK = 1;
    private static final int STATE_WAITING_NON_PRECAPTURE = 3;
    private static final int STATE_WAITING_PRECAPTURE = 2;
    /* access modifiers changed from: private */
    public static final String TAG = "AgoraBufferedCamera2";
    private int cameraOrientation;
    private boolean isCameraFrontFacing;
    /* access modifiers changed from: private */
    public Handler mBackgroundHandler;
    private HandlerThread mBackgroundThread;
    /* access modifiers changed from: private */
    public byte[] mBufferArrayData;
    /* access modifiers changed from: private */
    public ByteBuffer mByteBufferData;
    /* access modifiers changed from: private */
    public CameraDevice mCameraDevice;
    private String mCameraId;
    /* access modifiers changed from: private */
    public Semaphore mCameraOpenCloseLock = new Semaphore(1);
    /* access modifiers changed from: private */
    public CameraCaptureSession.CaptureCallback mCaptureCallback = new CameraCaptureSession.CaptureCallback() {
        private void process(CaptureResult captureResult) {
            Integer num;
            Integer num2;
            int access$900 = AgoraBufferedCamera2.this.mState;
            if (access$900 == 1) {
                Integer num3 = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (num3 != null) {
                    if ((4 == num3.intValue() || 5 == num3.intValue()) && (num = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE)) != null) {
                        num.intValue();
                    }
                }
            } else if (access$900 == 2) {
                Integer num4 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num4 == null || num4.intValue() == 5 || num4.intValue() == 4) {
                    int unused = AgoraBufferedCamera2.this.mState = 3;
                }
            } else if (access$900 == 3 && (num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE)) != null) {
                num2.intValue();
            }
        }

        public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            process(captureResult);
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            process(totalCaptureResult);
        }
    };
    /* access modifiers changed from: private */
    public CameraCaptureSession mCaptureSession;
    private CameraCharacteristics mCharacteristics;
    private Context mContext;
    private boolean mFlashSupported;
    private ImageReader mImageReader;
    private final ImageReader.OnImageAvailableListener mOnImageAvailableListener = new ImageReader.OnImageAvailableListener() {
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0145 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onImageAvailable(android.media.ImageReader r11) {
            /*
                r10 = this;
                java.lang.String r0 = "x"
                r1 = 0
                android.media.Image r1 = r11.acquireLatestImage()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                if (r1 != 0) goto L_0x000f
                if (r1 == 0) goto L_0x000e
                r1.close()
            L_0x000e:
                return
            L_0x000f:
                int r2 = r1.getFormat()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                r3 = 35
                if (r2 != r3) goto L_0x0114
                android.media.Image$Plane[] r2 = r1.getPlanes()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                int r2 = r2.length     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                r3 = 3
                if (r2 == r3) goto L_0x0021
                goto L_0x0114
            L_0x0021:
                int r2 = r11.getWidth()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                int r3 = r1.getWidth()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                if (r2 != r3) goto L_0x00d9
                int r2 = r11.getHeight()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                int r3 = r1.getHeight()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                if (r2 != r3) goto L_0x00d9
                io.agora.rtc.mediaio.AgoraBufferedCamera2 r11 = io.agora.rtc.mediaio.AgoraBufferedCamera2.this     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                byte[] r11 = r11.mBufferArrayData     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                io.agora.rtc.mediaio.AgoraBufferedCamera2.readImageIntoBuffer(r1, r11)     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                io.agora.rtc.mediaio.AgoraBufferedCamera2 r11 = io.agora.rtc.mediaio.AgoraBufferedCamera2.this     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                int r7 = r11.getFrameOrientation()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                io.agora.rtc.mediaio.AgoraBufferedCamera2 r11 = io.agora.rtc.mediaio.AgoraBufferedCamera2.this     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                io.agora.rtc.mediaio.IVideoFrameConsumer r11 = r11.consumer     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                if (r11 == 0) goto L_0x007c
                io.agora.rtc.mediaio.AgoraBufferedCamera2 r11 = io.agora.rtc.mediaio.AgoraBufferedCamera2.this     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                io.agora.rtc.mediaio.CaptureParameters r11 = r11.mParameters     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                int r11 = r11.bufferType     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                io.agora.rtc.mediaio.MediaIO$BufferType r0 = io.agora.rtc.mediaio.MediaIO.BufferType.BYTE_ARRAY     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                int r0 = r0.intValue()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                if (r11 != r0) goto L_0x007c
                io.agora.rtc.mediaio.AgoraBufferedCamera2 r11 = io.agora.rtc.mediaio.AgoraBufferedCamera2.this     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                io.agora.rtc.mediaio.IVideoFrameConsumer r2 = r11.consumer     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                io.agora.rtc.mediaio.AgoraBufferedCamera2 r11 = io.agora.rtc.mediaio.AgoraBufferedCamera2.this     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                byte[] r3 = r11.mBufferArrayData     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                io.agora.rtc.mediaio.AgoraBufferedCamera2 r11 = io.agora.rtc.mediaio.AgoraBufferedCamera2.this     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                io.agora.rtc.mediaio.CaptureParameters r11 = r11.mParameters     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                int r4 = r11.pixelFormat     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                int r5 = r1.getWidth()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                int r6 = r1.getHeight()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                long r8 = java.lang.System.currentTimeMillis()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                r2.consumeByteArrayFrame(r3, r4, r5, r6, r7, r8)     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                goto L_0x00d3
            L_0x007c:
                io.agora.rtc.mediaio.AgoraBufferedCamera2 r11 = io.agora.rtc.mediaio.AgoraBufferedCamera2.this     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                io.agora.rtc.mediaio.IVideoFrameConsumer r11 = r11.consumer     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                if (r11 == 0) goto L_0x00d3
                io.agora.rtc.mediaio.AgoraBufferedCamera2 r11 = io.agora.rtc.mediaio.AgoraBufferedCamera2.this     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                io.agora.rtc.mediaio.CaptureParameters r11 = r11.mParameters     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                int r11 = r11.bufferType     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                io.agora.rtc.mediaio.MediaIO$BufferType r0 = io.agora.rtc.mediaio.MediaIO.BufferType.BYTE_BUFFER     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                int r0 = r0.intValue()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                if (r11 != r0) goto L_0x00d3
                io.agora.rtc.mediaio.AgoraBufferedCamera2 r11 = io.agora.rtc.mediaio.AgoraBufferedCamera2.this     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                java.nio.ByteBuffer r11 = r11.mByteBufferData     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                r11.rewind()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                io.agora.rtc.mediaio.AgoraBufferedCamera2 r11 = io.agora.rtc.mediaio.AgoraBufferedCamera2.this     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                java.nio.ByteBuffer r11 = r11.mByteBufferData     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                io.agora.rtc.mediaio.AgoraBufferedCamera2 r0 = io.agora.rtc.mediaio.AgoraBufferedCamera2.this     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                byte[] r0 = r0.mBufferArrayData     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                r2 = 0
                io.agora.rtc.mediaio.AgoraBufferedCamera2 r3 = io.agora.rtc.mediaio.AgoraBufferedCamera2.this     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                byte[] r3 = r3.mBufferArrayData     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                int r3 = r3.length     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                r11.put(r0, r2, r3)     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                io.agora.rtc.mediaio.AgoraBufferedCamera2 r11 = io.agora.rtc.mediaio.AgoraBufferedCamera2.this     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                io.agora.rtc.mediaio.IVideoFrameConsumer r2 = r11.consumer     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                io.agora.rtc.mediaio.AgoraBufferedCamera2 r11 = io.agora.rtc.mediaio.AgoraBufferedCamera2.this     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                java.nio.ByteBuffer r3 = r11.mByteBufferData     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                io.agora.rtc.mediaio.AgoraBufferedCamera2 r11 = io.agora.rtc.mediaio.AgoraBufferedCamera2.this     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                io.agora.rtc.mediaio.CaptureParameters r11 = r11.mParameters     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                int r4 = r11.pixelFormat     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                int r5 = r1.getWidth()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                int r6 = r1.getHeight()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                long r8 = java.lang.System.currentTimeMillis()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                r2.consumeByteBufferFrame(r3, r4, r5, r6, r7, r8)     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
            L_0x00d3:
                if (r1 == 0) goto L_0x00d8
                r1.close()
            L_0x00d8:
                return
            L_0x00d9:
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                r3.<init>()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                java.lang.String r4 = "ImageReader size "
                r3.append(r4)     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                int r4 = r11.getWidth()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                r3.append(r4)     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                r3.append(r0)     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                int r11 = r11.getHeight()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                r3.append(r11)     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                java.lang.String r11 = " did not match Image size: "
                r3.append(r11)     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                int r11 = r1.getWidth()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                r3.append(r11)     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                r3.append(r0)     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                int r11 = r1.getHeight()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                r3.append(r11)     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                java.lang.String r11 = r3.toString()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                r2.<init>(r11)     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                throw r2     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
            L_0x0114:
                java.lang.String r11 = io.agora.rtc.mediaio.AgoraBufferedCamera2.TAG     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                r0.<init>()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                java.lang.String r2 = "Unexpected image format: "
                r0.append(r2)     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                int r2 = r1.getFormat()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                r0.append(r2)     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                java.lang.String r2 = "or #planes:"
                r0.append(r2)     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                android.media.Image$Plane[] r2 = r1.getPlanes()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                int r2 = r2.length     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                r0.append(r2)     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                java.lang.String r0 = r0.toString()     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                io.agora.rtc.internal.Logging.e(r11, r0)     // Catch:{ IllegalStateException -> 0x0154, Exception -> 0x0145 }
                if (r1 == 0) goto L_0x0142
                r1.close()
            L_0x0142:
                return
            L_0x0143:
                r11 = move-exception
                goto L_0x0164
            L_0x0145:
                java.lang.String r11 = io.agora.rtc.mediaio.AgoraBufferedCamera2.TAG     // Catch:{ all -> 0x0143 }
                java.lang.String r0 = "fetch image failed..."
                android.util.Log.e(r11, r0)     // Catch:{ all -> 0x0143 }
                if (r1 == 0) goto L_0x0153
                r1.close()
            L_0x0153:
                return
            L_0x0154:
                r11 = move-exception
                java.lang.String r0 = io.agora.rtc.mediaio.AgoraBufferedCamera2.TAG     // Catch:{ all -> 0x0143 }
                java.lang.String r2 = "acquireLastest Image():"
                android.util.Log.e(r0, r2, r11)     // Catch:{ all -> 0x0143 }
                if (r1 == 0) goto L_0x0163
                r1.close()
            L_0x0163:
                return
            L_0x0164:
                if (r1 == 0) goto L_0x0169
                r1.close()
            L_0x0169:
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.mediaio.AgoraBufferedCamera2.AnonymousClass1.onImageAvailable(android.media.ImageReader):void");
        }
    };
    /* access modifiers changed from: private */
    public CaptureParameters mParameters;
    /* access modifiers changed from: private */
    public CaptureRequest mPreviewRequest;
    /* access modifiers changed from: private */
    public CaptureRequest.Builder mPreviewRequestBuilder;
    /* access modifiers changed from: private */
    public int mState = 0;
    private final CameraDevice.StateCallback mStateCallback = new CameraDevice.StateCallback() {
        public void onOpened(CameraDevice cameraDevice) {
            CameraDevice unused = AgoraBufferedCamera2.this.mCameraDevice = cameraDevice;
            AgoraBufferedCamera2.this.createCameraPreviewSession();
            AgoraBufferedCamera2.this.mCameraOpenCloseLock.release();
        }

        public void onDisconnected(CameraDevice cameraDevice) {
            cameraDevice.close();
            CameraDevice unused = AgoraBufferedCamera2.this.mCameraDevice = null;
            AgoraBufferedCamera2.this.mCameraOpenCloseLock.release();
        }

        public void onError(CameraDevice cameraDevice, int i) {
            cameraDevice.close();
            CameraDevice unused = AgoraBufferedCamera2.this.mCameraDevice = null;
            AgoraBufferedCamera2.this.mCameraOpenCloseLock.release();
        }
    };

    public AgoraBufferedCamera2(Context context) {
        this.mContext = context;
        CaptureParameters captureParameters = new CaptureParameters();
        this.mParameters = captureParameters;
        captureParameters.width = 640;
        this.mParameters.height = 480;
        this.mParameters.fps = 15;
        this.mParameters.pixelFormat = MediaIO.PixelFormat.I420.intValue();
        this.mParameters.bufferType = MediaIO.BufferType.BYTE_BUFFER.intValue();
        this.mParameters.captureType = MediaIO.CaptureType.CAMERA.intValue();
        this.mParameters.contentHint = MediaIO.ContentHint.NONE.intValue();
    }

    public AgoraBufferedCamera2(Context context, CaptureParameters captureParameters) {
        this.mContext = context;
        if (captureParameters != null) {
            CaptureParameters captureParameters2 = new CaptureParameters();
            this.mParameters = captureParameters2;
            captureParameters2.width = captureParameters.width;
            this.mParameters.height = captureParameters.height;
            this.mParameters.fps = captureParameters.fps;
            this.mParameters.pixelFormat = captureParameters.pixelFormat;
            this.mParameters.bufferType = captureParameters.bufferType;
            this.mParameters.captureType = captureParameters.captureType;
            this.mParameters.contentHint = captureParameters.contentHint;
        }
    }

    public void useFrontCamera(boolean z) {
        this.isCameraFrontFacing = z;
    }

    public boolean onInitialize(IVideoFrameConsumer iVideoFrameConsumer) {
        this.consumer = iVideoFrameConsumer;
        allocateBuffer(this.mParameters.pixelFormat);
        return true;
    }

    public boolean onStart() {
        startBackgroundThread();
        openCamera(this.mParameters.width, this.mParameters.height);
        return true;
    }

    public void onStop() {
        doStop();
    }

    public void onDispose() {
        doStop();
        this.mBufferArrayData = null;
        this.mByteBufferData = null;
    }

    public int getBufferType() {
        return this.mParameters.bufferType;
    }

    public int getCaptureType() {
        return this.mParameters.captureType;
    }

    public int getContentHint() {
        return this.mParameters.contentHint;
    }

    private void allocateBuffer(int i) {
        int bitsPerPixel = i == MediaIO.PixelFormat.I420.intValue() ? ((this.mParameters.width * this.mParameters.height) * ImageFormat.getBitsPerPixel(35)) / 8 : 0;
        if (this.mParameters.bufferType == MediaIO.BufferType.BYTE_ARRAY.intValue()) {
            this.mBufferArrayData = new byte[bitsPerPixel];
        } else if (this.mParameters.bufferType == MediaIO.BufferType.BYTE_BUFFER.intValue()) {
            this.mBufferArrayData = new byte[bitsPerPixel];
            this.mByteBufferData = ByteBuffer.allocateDirect(bitsPerPixel);
        }
    }

    private void openCamera(int i, int i2) {
        setUpCameraOutputs(i, i2);
        CameraManager cameraManager = (CameraManager) this.mContext.getSystemService("camera");
        try {
            if (this.mCameraOpenCloseLock.tryAcquire(2500, TimeUnit.MILLISECONDS)) {
                cameraManager.openCamera(this.mCameraId, this.mStateCallback, this.mBackgroundHandler);
                return;
            }
            throw new RuntimeException("Time out waiting to lock camera opening.");
        } catch (CameraAccessException e) {
            Log.e(TAG, e.toString());
        } catch (InterruptedException e2) {
            throw new RuntimeException("Interrupted while trying to lock camera opening.", e2);
        } catch (SecurityException e3) {
            Log.e(TAG, e3.toString());
        }
    }

    private void doStop() {
        closeCamera();
        stopBackgroundThread();
    }

    /* access modifiers changed from: private */
    public void createCameraPreviewSession() {
        try {
            CaptureRequest.Builder createCaptureRequest = this.mCameraDevice.createCaptureRequest(1);
            this.mPreviewRequestBuilder = createCaptureRequest;
            createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, 1);
            this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_MODE, 1);
            this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, 3);
            this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AE_LOCK, false);
            if (this.mFlashSupported) {
                this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_AE_MODE, 2);
            }
            this.mPreviewRequestBuilder.addTarget(this.mImageReader.getSurface());
            this.mCameraDevice.createCaptureSession(Arrays.asList(new Surface[]{this.mImageReader.getSurface()}), new CameraCaptureSession.StateCallback() {
                public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                    if (AgoraBufferedCamera2.this.mCameraDevice != null) {
                        CameraCaptureSession unused = AgoraBufferedCamera2.this.mCaptureSession = cameraCaptureSession;
                        try {
                            AgoraBufferedCamera2 agoraBufferedCamera2 = AgoraBufferedCamera2.this;
                            CaptureRequest unused2 = agoraBufferedCamera2.mPreviewRequest = agoraBufferedCamera2.mPreviewRequestBuilder.build();
                            AgoraBufferedCamera2.this.mCaptureSession.setRepeatingRequest(AgoraBufferedCamera2.this.mPreviewRequest, AgoraBufferedCamera2.this.mCaptureCallback, AgoraBufferedCamera2.this.mBackgroundHandler);
                        } catch (CameraAccessException | IllegalStateException e) {
                            e.printStackTrace();
                        }
                    }
                }

                public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                    Log.e(AgoraBufferedCamera2.TAG, "Configure camera failed");
                }
            }, (Handler) null);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void setUpCameraOutputs(int i, int i2) {
        boolean z;
        CameraManager cameraManager = (CameraManager) this.mContext.getSystemService("camera");
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            int i3 = 0;
            while (true) {
                if (i3 >= cameraIdList.length) {
                    break;
                }
                String str = cameraIdList[i3];
                this.mCameraId = str;
                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                this.mCharacteristics = cameraCharacteristics;
                this.cameraOrientation = ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
                Boolean bool = (Boolean) this.mCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
                if (bool == null) {
                    z = false;
                } else {
                    z = bool.booleanValue();
                }
                this.mFlashSupported = z;
                if (!this.isCameraFrontFacing) {
                    break;
                } else if (((Integer) this.mCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
                    break;
                } else {
                    i3++;
                }
            }
            ImageReader newInstance = ImageReader.newInstance(this.mParameters.width, this.mParameters.height, getAndroidImageFormat(this.mParameters.pixelFormat), 2);
            this.mImageReader = newInstance;
            newInstance.setOnImageAvailableListener(this.mOnImageAvailableListener, this.mBackgroundHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (NullPointerException unused) {
        }
    }

    private int getAndroidImageFormat(int i) {
        return i == MediaIO.PixelFormat.I420.intValue() ? 35 : 0;
    }

    static class CompareSizesByArea implements Comparator<Size> {
        CompareSizesByArea() {
        }

        public int compare(Size size, Size size2) {
            return Long.signum((((long) size.getWidth()) * ((long) size.getHeight())) - (((long) size2.getWidth()) * ((long) size2.getHeight())));
        }
    }

    private static Size chooseOptimalSize(Size[] sizeArr, int i, int i2, int i3, int i4, Size size) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int width = size.getWidth();
        int height = size.getHeight();
        for (Size size2 : sizeArr) {
            if (size2.getWidth() <= i3 && size2.getHeight() <= i4 && size2.getHeight() == (size2.getWidth() * height) / width) {
                if (size2.getWidth() < i || size2.getHeight() < i2) {
                    arrayList2.add(size2);
                } else {
                    arrayList.add(size2);
                }
            }
        }
        if (arrayList.size() > 0) {
            return (Size) Collections.min(arrayList, new CompareSizesByArea());
        }
        if (arrayList2.size() > 0) {
            return (Size) Collections.max(arrayList2, new CompareSizesByArea());
        }
        Log.e(TAG, "Couldn't find any suitable preview size");
        return sizeArr[0];
    }

    private void closeCamera() {
        try {
            this.mCameraOpenCloseLock.acquire();
            CameraCaptureSession cameraCaptureSession = this.mCaptureSession;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.close();
                this.mCaptureSession = null;
            }
            CameraDevice cameraDevice = this.mCameraDevice;
            if (cameraDevice != null) {
                cameraDevice.close();
                this.mCameraDevice = null;
            }
            ImageReader imageReader = this.mImageReader;
            if (imageReader != null) {
                imageReader.close();
                this.mImageReader = null;
            }
            this.mCameraOpenCloseLock.release();
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted while trying to lock camera closing.", e);
        } catch (Throwable th) {
            this.mCameraOpenCloseLock.release();
            throw th;
        }
    }

    private void startBackgroundThread() {
        HandlerThread handlerThread = new HandlerThread("CameraBackground");
        this.mBackgroundThread = handlerThread;
        handlerThread.start();
        this.mBackgroundHandler = new Handler(this.mBackgroundThread.getLooper());
    }

    private void stopBackgroundThread() {
        HandlerThread handlerThread = this.mBackgroundThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            try {
                this.mBackgroundThread.join();
                this.mBackgroundThread = null;
                this.mBackgroundHandler = null;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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

    private int getDeviceOrientation() {
        int rotation = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 1) {
            return 90;
        }
        if (rotation == 2) {
            return LocalSDKConstants.SCREEN_ROTATE_180;
        }
        if (rotation != 3) {
            return 0;
        }
        return LocalSDKConstants.SCREEN_ROTATE_270;
    }

    /* access modifiers changed from: private */
    public int getFrameOrientation() {
        int deviceOrientation = getDeviceOrientation();
        if (!this.isCameraFrontFacing) {
            deviceOrientation = 360 - deviceOrientation;
        }
        return (this.cameraOrientation + deviceOrientation) % 360;
    }
}
