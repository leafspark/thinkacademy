package com.wushuangtech.library.video.opengles.input;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.wushuangtech.library.video.opengles.WaterMarkController;
import com.wushuangtech.utils.MyGLUtils;

public class ImageResourceInput extends GLTextureOutputRenderer implements WaterMarkController.OnWaterMarkBitmapChangedListener {
    private static final String TAG = "ImageResourceInput";
    private Bitmap bitmap;
    private boolean bitmapChanged;
    private final Object lock = new Object();
    private Bitmap newBitmap;

    public void setBitmap(Bitmap bitmap2) {
    }

    public ImageResourceInput() {
        markAsDirty();
    }

    /* access modifiers changed from: protected */
    public boolean initWithGLContext() {
        synchronized (this.lock) {
            if (this.bitmapChanged) {
                handleBitmapChanged();
            }
        }
        return super.initWithGLContext();
    }

    public void setOnWaterMarkBitmapChangedListener(WaterMarkController waterMarkController) {
        waterMarkController.setOnWaterMarkBitmapChangedListener(this);
    }

    private void handleBitmapChanged() {
        int i;
        if (this.mTextureIn != 0) {
            GLES20.glDeleteTextures(1, new int[]{this.mTextureIn}, 0);
        }
        int i2 = 50;
        if (this.newBitmap != null) {
            Bitmap bitmap2 = this.bitmap;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.bitmap.recycle();
                this.bitmap = null;
            }
            Bitmap bitmap3 = this.newBitmap;
            this.bitmap = bitmap3;
            this.newBitmap = null;
            this.mTextureIn = MyGLUtils.createTextureByBitmap(bitmap3);
            i2 = this.bitmap.getWidth();
            i = this.bitmap.getHeight();
            log(TAG, "New bitmap size : " + i2 + " * " + i);
        } else {
            this.mTextureIn = MyGLUtils.createWhiteTextureId(false, 50, 50)[0];
            i = 50;
        }
        log(TAG, "New texture id : " + this.mTextureIn);
        setRenderSize(i2, i);
    }

    public void destroy() {
        super.destroy();
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.bitmap = null;
        }
        Bitmap bitmap3 = this.newBitmap;
        if (bitmap3 != null) {
            bitmap3.recycle();
            this.newBitmap = null;
        }
    }

    public void onWaterMarkBitmapChanged(Bitmap bitmap2) {
        synchronized (this.lock) {
            if (bitmap2 == null) {
                if (this.bitmap != null) {
                    logD(TAG, "Bitmap changed, old : " + this.bitmap + " | new bitmap : null");
                    this.bitmapChanged = true;
                }
            } else if (!(this.newBitmap == bitmap2 || bitmap2 == this.bitmap)) {
                logD(TAG, "Bitmap changed, old : " + this.bitmap + " | new bitmap : " + bitmap2);
                this.bitmapChanged = true;
                this.newBitmap = bitmap2;
            }
            if (this.bitmapChanged) {
                reInitialize();
            }
        }
    }
}
