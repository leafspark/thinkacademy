package com.wushuangtech.library.video.opengles.output;

import com.wushuangtech.library.video.opengles.GLRenderer;
import com.wushuangtech.library.video.opengles.input.GLTextureOutputRenderer;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.utils.TextureRotationUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

public class VideoEncodeEndpoint extends GLRenderer implements GLTextureInputRenderer {
    public static final int VIDEO_ENCODE_TYPE_DUAL = 2;
    public static final int VIDEO_ENCODE_TYPE_MAIN = 1;
    private int mCameraId = 1;
    private int mCapHeight;
    private int mCapWidth;
    private int mEncHeight;
    private int mEncWidth;
    private float[] mLocalTextureArray = new float[8];
    private final FloatBuffer mLocalTextureBuffer;
    private final Object mLock = new Object();
    private int mRawHeight;
    private int mRawWidth;
    private boolean mRemoteHorMirror = false;
    private boolean mRenderArgsSetting;
    private int mRotate = 90;

    public VideoEncodeEndpoint(int i) {
        if (i == 1) {
            this.TAG = "VideoEncodeEndpoint<Main>";
        } else if (i == 2) {
            this.TAG = "VideoEncodeEndpoint<Dual>";
        }
        this.mLocalTextureBuffer = ByteBuffer.allocateDirect(this.mLocalTextureArray.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public void setCameraId(int i) {
        if (this.mCameraId != i) {
            String str = this.TAG;
            log(str, "Setting camera id = " + i);
            this.mCameraId = i;
            updateRenderArgs();
        }
    }

    public void setRenderMirror(boolean z) {
        if (z != this.mRemoteHorMirror) {
            String str = this.TAG;
            log(str, "Setting mirror = " + z);
            this.mRemoteHorMirror = z;
            updateRenderArgs();
        }
    }

    public void setMatrixRotate(int i) {
        if (i != this.mRotate) {
            String str = this.TAG;
            log(str, "Setting rotate = " + i);
            this.mRotate = i;
            updateRenderArgs();
        }
    }

    public void setEncodeRawSize(int i, int i2) {
        if (i != 0 && i2 != 0) {
            if (this.mRawWidth != i || this.mRawHeight != i2) {
                String str = this.TAG;
                log(str, "Setting video encode raw size : " + i + " * " + i2);
                this.mRawWidth = i;
                this.mRawHeight = i2;
                updateRenderArgs();
            }
        }
    }

    public void setEncodeSize(int i, int i2) {
        if (i != 0 && i2 != 0) {
            if (this.mEncWidth != i || this.mEncHeight != i2) {
                String str = this.TAG;
                log(str, "Setting video encode size : " + i + " * " + i2);
                this.mEncWidth = i;
                this.mEncHeight = i2;
                updateRenderArgs();
            }
        }
    }

    /* access modifiers changed from: protected */
    public FloatBuffer getTextureBuffer() {
        FloatBuffer floatBuffer;
        synchronized (this.mLock) {
            floatBuffer = this.mLocalTextureBuffer;
        }
        return floatBuffer;
    }

    public void newTextureReady(int i, GLTextureOutputRenderer gLTextureOutputRenderer, boolean z) {
        if (this.mTextureIn != i) {
            this.mTextureIn = i;
        }
        int width = gLTextureOutputRenderer.getWidth();
        int height = gLTextureOutputRenderer.getHeight();
        if (width != 0 && height != 0) {
            if (!(width == this.mCapWidth && height == this.mCapHeight)) {
                String str = this.TAG;
                log(str, "Size changed, setting video data size, width = " + width + ", height = " + height + ", thread = " + Thread.currentThread().getName());
                this.mCapWidth = width;
                this.mCapHeight = height;
                updateRenderArgs();
            }
            if (this.mRenderArgsSetting) {
                onDrawFrame();
            }
        }
    }

    private void updateRenderArgs() {
        boolean z;
        if (this.mCapWidth > 0 && this.mCapHeight > 0 && this.mRawWidth > 0 && this.mRawHeight > 0 && this.mEncWidth > 0 && this.mEncHeight > 0) {
            OmniLog.i(OmniLog.VIDEO_RENDER_WATCH, this.TAG, "Setting video local encode render args, cap size : " + this.mCapWidth + " * " + this.mCapHeight + " | raw size : " + this.mRawWidth + " * " + this.mRawHeight + " | enc size : " + this.mEncWidth + " * " + this.mEncHeight + " | mirror : " + this.mRemoteHorMirror + " | rotate : " + this.mRotate + " | cameraId : " + this.mCameraId);
            int i = this.mRotate;
            boolean z2 = this.mRemoteHorMirror;
            if (this.mCameraId == 0 && i == 90) {
                i = 270;
            }
            if (i == 90 || i == 270) {
                z = z2;
                z2 = false;
            } else {
                z = false;
            }
            float[] rotation = TextureRotationUtils.getRotation(TextureRotationUtils.Rotation.fromInt(i), z2, z);
            this.mLocalTextureArray = Arrays.copyOf(rotation, rotation.length);
            synchronized (this.mLock) {
                this.mLocalTextureBuffer.clear();
                this.mLocalTextureBuffer.put(this.mLocalTextureArray);
                this.mLocalTextureBuffer.position(0);
            }
            OmniLog.i(OmniLog.VIDEO_RENDER_WATCH, this.TAG, "Finally render size = " + this.mEncWidth + " * " + this.mEncHeight);
            super.setRenderSize(this.mEncWidth, this.mEncHeight);
            this.mRenderArgsSetting = true;
        }
    }

    private void handleCrop() {
        float f = ((float) this.mCapWidth) / ((float) this.mCapHeight);
        float f2 = ((float) this.mEncWidth) / ((float) this.mEncHeight);
        if (((double) Math.abs(f2 - f)) >= 0.001d) {
            if (f2 >= f) {
                this.mStartX = 0;
                int i = this.mCapWidth;
                int i2 = this.mEncHeight;
                int i3 = (i * i2) / this.mEncWidth;
                this.mStartY = (i2 * ((this.mCapHeight - i3) / 2)) / i3;
                return;
            }
            int i4 = this.mCapHeight;
            int i5 = this.mEncWidth;
            int i6 = (i4 * i5) / this.mEncHeight;
            this.mStartX = (i5 * ((this.mCapWidth - i6) / 2)) / i6;
            this.mStartY = 0;
        }
    }
}
