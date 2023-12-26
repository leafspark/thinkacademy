package io.agora.rtc.mediaio;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.Log;
import android.view.WindowManager;
import com.wushuangtech.constants.LocalSDKConstants;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.RendererCommon;
import io.agora.rtc.mediaio.MediaIO;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;

public class AgoraTextureCamera extends TextureSource {
    private static final String TAG = "AgoraTextureCamera";
    private Camera camera;
    private Camera.CameraInfo info;
    private Context mContext;

    public AgoraTextureCamera(Context context, int i, int i2) {
        super((EglBase.Context) null, i, i2);
        this.mContext = context;
    }

    public AgoraTextureCamera(Context context, int i, int i2, boolean z) {
        super((EglBase.Context) null, i, i2, z);
        this.mContext = context;
    }

    public void onTextureFrameAvailable(int i, float[] fArr, long j) {
        IVideoFrameConsumer iVideoFrameConsumer;
        super.onTextureFrameAvailable(i, fArr, j);
        int frameOrientation = getFrameOrientation();
        if (this.info.facing == 1) {
            fArr = RendererCommon.multiplyMatrices(fArr, RendererCommon.horizontalFlipMatrix());
        }
        float[] fArr2 = fArr;
        WeakReference weakReference = this.mConsumer;
        if (weakReference != null && (iVideoFrameConsumer = (IVideoFrameConsumer) weakReference.get()) != null) {
            iVideoFrameConsumer.consumeTextureFrame(i, MediaIO.PixelFormat.TEXTURE_OES.intValue(), this.mWidth, this.mHeight, frameOrientation, System.currentTimeMillis(), fArr2);
        }
    }

    public void onTextureFrameAvailable(int i, MediaIO.PixelFormat pixelFormat, float[] fArr, long j) {
        IVideoFrameConsumer iVideoFrameConsumer;
        super.onTextureFrameAvailable(i, pixelFormat, fArr, j);
        int frameOrientation = getFrameOrientation();
        if (this.info.facing == 1) {
            fArr = RendererCommon.multiplyMatrices(fArr, RendererCommon.horizontalFlipMatrix());
        }
        float[] fArr2 = fArr;
        WeakReference weakReference = this.mConsumer;
        if (weakReference != null && (iVideoFrameConsumer = (IVideoFrameConsumer) weakReference.get()) != null) {
            iVideoFrameConsumer.consumeTextureFrame(i, pixelFormat.intValue(), this.mWidth, this.mHeight, frameOrientation, System.currentTimeMillis(), fArr2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onCapturerOpened() {
        try {
            openCamera();
            this.camera.setPreviewTexture(getSurfaceTexture());
            this.camera.startPreview();
            return true;
        } catch (IOException unused) {
            Log.e(TAG, "initialize: failed to initalize camera device");
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onCapturerStarted() {
        this.camera.startPreview();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCapturerStopped() {
        this.camera.stopPreview();
    }

    /* access modifiers changed from: protected */
    public void onCapturerClosed() {
        releaseCamera();
    }

    private void openCamera() {
        if (this.camera == null) {
            this.info = new Camera.CameraInfo();
            int numberOfCameras = Camera.getNumberOfCameras();
            int i = 0;
            while (true) {
                if (i >= numberOfCameras) {
                    break;
                }
                Camera.getCameraInfo(i, this.info);
                if (this.info.facing == 1) {
                    this.camera = Camera.open(i);
                    break;
                }
                i++;
            }
            if (this.camera == null) {
                Log.d(TAG, "No front-facing camera found; opening default");
                this.camera = Camera.open();
            }
            Camera camera2 = this.camera;
            if (camera2 != null) {
                Camera.Parameters parameters = camera2.getParameters();
                List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                parameters.setPreviewFpsRange(supportedPreviewFpsRange.get(supportedPreviewFpsRange.size() - 1)[0], supportedPreviewFpsRange.get(supportedPreviewFpsRange.size() - 1)[1]);
                parameters.setPreviewSize(this.mWidth, this.mHeight);
                parameters.setRecordingHint(true);
                this.camera.setParameters(parameters);
                Camera.Size previewSize = parameters.getPreviewSize();
                String str = TAG;
                Log.i(str, "Camera config: " + (previewSize.width + "x" + previewSize.height));
                return;
            }
            throw new RuntimeException("Unable to open camera");
        }
        throw new RuntimeException("camera already initialized");
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

    private int getFrameOrientation() {
        int deviceOrientation = getDeviceOrientation();
        if (this.info.facing == 0) {
            deviceOrientation = 360 - deviceOrientation;
        }
        return (this.info.orientation + deviceOrientation) % 360;
    }

    private void releaseCamera() {
        Camera camera2 = this.camera;
        if (camera2 != null) {
            camera2.stopPreview();
            try {
                this.camera.setPreviewTexture((SurfaceTexture) null);
            } catch (Exception unused) {
                Log.e(TAG, "failed to set Preview Texture");
            }
            this.camera.release();
            this.camera = null;
            Log.d(TAG, "releaseCamera -- done");
        }
    }
}
