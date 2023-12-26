package com.wushuangtech.library.video.opengles.output;

import android.text.TextUtils;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.video.opengles.GLRenderer;
import com.wushuangtech.library.video.opengles.input.GLTextureOutputRenderer;
import com.wushuangtech.utils.TextureRotationUtils;
import com.yalantis.ucrop.view.CropImageView;
import java.nio.FloatBuffer;

public class ScreenEndpoint extends GLRenderer implements GLTextureInputRenderer {
    public static final int SCREEN_TYPE_LOCAL = 1;
    public static final int SCREEN_TYPE_REMOTE = 2;
    private int mCameraId;
    private int mEncHeight;
    private int mEncWidth;
    private boolean mPreView;
    private int mPreviewHeight;
    private int mPreviewWidth;
    private int mRawHeight;
    private int mRawWidth;
    private int mRenderMode;
    private int mRotate;
    private final int mScreenType;
    private boolean mVideoLocalHorMirror;
    private boolean mVideoLocalVerMirror;

    public ScreenEndpoint() {
        this((String) null);
    }

    public ScreenEndpoint(String str) {
        this.mRenderMode = 1;
        this.mCameraId = 1;
        this.mRotate = 90;
        if (TextUtils.isEmpty(str)) {
            this.TAG = "ScreenEndpoint<Local>";
            this.mScreenType = 1;
            return;
        }
        this.TAG = "ScreenEndpoint<" + str + ">";
        this.mScreenType = 2;
    }

    public void newTextureReady(int i, GLTextureOutputRenderer gLTextureOutputRenderer, boolean z) {
        int i2;
        int width = gLTextureOutputRenderer.getWidth();
        int height = gLTextureOutputRenderer.getHeight();
        if (width != 0 && height != 0) {
            if (!(width == this.mRawWidth && height == this.mRawHeight)) {
                String str = this.TAG;
                log(str, "Size changed, setting video data size, width = " + width + ", height = " + height + ", thread = " + Thread.currentThread().getName());
                this.mRawWidth = width;
                this.mRawHeight = height;
                int i3 = this.mPreviewWidth;
                if (!(i3 == 0 || (i2 = this.mPreviewHeight) == 0)) {
                    setRenderSize(i3, i2);
                }
            }
            if (!this.mPreView) {
                this.mTextureIn = -1;
            } else {
                this.mTextureIn = i;
            }
            onDrawFrame();
        }
    }

    public void setCameraId(int i) {
        this.mCameraId = i;
    }

    public void setRotate(int i) {
        this.mRotate = i;
    }

    public void setPreView(boolean z) {
        this.mPreView = z;
    }

    public void setViewSize(int i, int i2) {
        if (i != 0 && i2 != 0) {
            this.mPreviewWidth = i;
            this.mPreviewHeight = i2;
            String str = this.TAG;
            log(str, "Setting preview size : " + this.mPreviewWidth + " * " + this.mPreviewHeight);
            setRenderSize(this.mPreviewWidth, this.mPreviewHeight);
        }
    }

    public void setEncodeSize(int i, int i2) {
        if (i != 0 && i2 != 0) {
            if (this.mEncWidth != i || this.mEncHeight != i2) {
                String str = this.TAG;
                log(str, "Setting video encode size : " + i + " * " + i2);
                this.mEncWidth = i;
                this.mEncHeight = i2;
                setRenderSize(this.mPreviewWidth, this.mPreviewHeight);
            }
        }
    }

    public void setRenderMode(int i) {
        String str = this.TAG;
        log(str, "Setting render mode : " + i);
        if (this.mRenderMode != i) {
            this.mRenderMode = i;
            setRenderSize(this.mPreviewWidth, this.mPreviewHeight);
        }
    }

    public void setRenderMirror(boolean z, boolean z2) {
        String str = this.TAG;
        log(str, "Setting mirror, hor = " + z + ", ver = " + z2);
        if (this.mVideoLocalHorMirror != z || this.mVideoLocalVerMirror != z2) {
            this.mVideoLocalHorMirror = z;
            this.mVideoLocalVerMirror = z2;
            GlobalConfig.setLocalRenderHorMirror(z);
        }
    }

    /* access modifiers changed from: protected */
    public FloatBuffer getTextureBuffer() {
        boolean z;
        boolean z2;
        int i = this.mRotate;
        if (this.mScreenType != 1) {
            return getTextureBuffer(TextureRotationUtils.Rotation.NORMAL, this.mVideoLocalHorMirror, false);
        }
        if (i == 90 && this.mCameraId == 0) {
            i = 270;
        }
        if (i == 90 || i == 270) {
            z2 = this.mVideoLocalVerMirror;
            z = this.mVideoLocalHorMirror;
        } else {
            z2 = this.mVideoLocalHorMirror;
            z = this.mVideoLocalVerMirror;
        }
        return getTextureBuffer(TextureRotationUtils.Rotation.fromInt(i), z2, z);
    }

    public void setRenderSize(int i, int i2) {
        int i3;
        int i4;
        float f;
        int i5;
        int i6;
        int i7;
        int i8;
        if (i != 0 && i2 != 0 && (i3 = this.mRawWidth) != 0 && (i4 = this.mRawHeight) != 0) {
            if (this.mScreenType != 1 || this.mEncWidth != 0 || this.mEncHeight != 0) {
                float f2 = (float) i;
                float f3 = (float) i2;
                float f4 = f2 / f3;
                float f5 = ((float) i3) / ((float) i4);
                float f6 = ((float) this.mEncWidth) / ((float) this.mEncHeight);
                log(this.TAG, "type : " + this.mScreenType + " | mode : " + this.mRenderMode + " | bPreView : " + this.mPreView);
                log(this.TAG, "prevWidth : " + i + " | prevHeight : " + i2 + " | preRate : " + f4);
                log(this.TAG, "rawWidth : " + this.mRawWidth + " | rawHeight : " + this.mRawHeight + " | capRate : " + f5);
                log(this.TAG, "encWidth : " + this.mEncWidth + " | encHeight : " + this.mEncHeight + " | encRate : " + f6);
                int i9 = 0;
                if (this.mRenderMode == 2) {
                    if (f4 >= f5) {
                        i7 = (int) (f3 * f5);
                        this.mStartX = (i - i7) / 2;
                        this.mStartY = 0;
                    } else {
                        i8 = (int) (f2 / f5);
                        this.mStartX = 0;
                        this.mStartY = (i2 - i8) / 2;
                        i2 = i8;
                        log(this.TAG, "startX : " + this.mStartX + " | startY : " + this.mStartY);
                        log(this.TAG, "targetWidth : " + i + " | targetHeight : " + i2);
                        super.setRenderSize(i, i2);
                    }
                } else if (f6 != CropImageView.DEFAULT_ASPECT_RATIO) {
                    float f7 = 1.0f;
                    if (f4 >= f5) {
                        f = f4 / f5;
                        i6 = (int) (f2 / f5);
                        i5 = i;
                    } else {
                        i5 = (int) (f3 * f5);
                        float f8 = f5 / f4;
                        f = 1.0f;
                        f7 = f8;
                        i6 = i2;
                    }
                    log(this.TAG, "ampW : " + f7 + " | ampH : " + f);
                    log(this.TAG, "renderWidth : " + i5 + " | renderHeight : " + i6);
                    if (i > 0 || i2 > 0) {
                        i9 = i5;
                    } else {
                        i6 = 0;
                    }
                    this.mStartX = (i - i9) / 2;
                    this.mStartY = (i2 - i6) / 2;
                    i2 = i6;
                    i = i9;
                    log(this.TAG, "startX : " + this.mStartX + " | startY : " + this.mStartY);
                    log(this.TAG, "targetWidth : " + i + " | targetHeight : " + i2);
                    super.setRenderSize(i, i2);
                } else if (f4 >= f5) {
                    i8 = (int) (f2 / f5);
                    this.mStartX = 0;
                    this.mStartY = (i2 - i8) / 2;
                    i2 = i8;
                    log(this.TAG, "startX : " + this.mStartX + " | startY : " + this.mStartY);
                    log(this.TAG, "targetWidth : " + i + " | targetHeight : " + i2);
                    super.setRenderSize(i, i2);
                } else {
                    i7 = (int) (f3 * f5);
                    this.mStartX = (i - i7) / 2;
                    this.mStartY = 0;
                }
                i = i7;
                log(this.TAG, "startX : " + this.mStartX + " | startY : " + this.mStartY);
                log(this.TAG, "targetWidth : " + i + " | targetHeight : " + i2);
                super.setRenderSize(i, i2);
            }
        }
    }
}
