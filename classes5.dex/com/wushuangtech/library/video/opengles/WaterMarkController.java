package com.wushuangtech.library.video.opengles;

import android.graphics.Bitmap;
import com.yalantis.ucrop.view.CropImageView;

public class WaterMarkController {
    private volatile Bitmap mBitmap;
    private volatile float mHeight;
    private volatile float mWidth;
    private OnWaterMarkBitmapChangedListener onWaterMarkBitmapChangedListener;
    private OnWaterMarkStatusChangedListener onWaterMarkStatusChangedListener;
    private volatile float x_soffset = CropImageView.DEFAULT_ASPECT_RATIO;
    private volatile float y_soffset = CropImageView.DEFAULT_ASPECT_RATIO;

    public interface OnWaterMarkBitmapChangedListener {
        void onWaterMarkBitmapChanged(Bitmap bitmap);
    }

    public interface OnWaterMarkStatusChangedListener {
        void onWaterMarkParamsChanged();
    }

    public void setOnWaterMarkStatusChangedListener(OnWaterMarkStatusChangedListener onWaterMarkStatusChangedListener2) {
        this.onWaterMarkStatusChangedListener = onWaterMarkStatusChangedListener2;
    }

    public void setOnWaterMarkBitmapChangedListener(OnWaterMarkBitmapChangedListener onWaterMarkBitmapChangedListener2) {
        this.onWaterMarkBitmapChangedListener = onWaterMarkBitmapChangedListener2;
    }

    public float getX_soffset() {
        return this.x_soffset;
    }

    public float getY_soffset() {
        return this.y_soffset;
    }

    public Bitmap getBitmap() {
        if (this.mBitmap == null || this.mBitmap.isRecycled()) {
            return null;
        }
        return Bitmap.createBitmap(this.mBitmap);
    }

    public float getWidth() {
        return this.mWidth;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public void setX_soffset(float f) {
        this.x_soffset = f;
        OnWaterMarkStatusChangedListener onWaterMarkStatusChangedListener2 = this.onWaterMarkStatusChangedListener;
        if (onWaterMarkStatusChangedListener2 != null) {
            onWaterMarkStatusChangedListener2.onWaterMarkParamsChanged();
        }
    }

    public void setY_soffset(float f) {
        this.y_soffset = f;
        OnWaterMarkStatusChangedListener onWaterMarkStatusChangedListener2 = this.onWaterMarkStatusChangedListener;
        if (onWaterMarkStatusChangedListener2 != null) {
            onWaterMarkStatusChangedListener2.onWaterMarkParamsChanged();
        }
    }

    public void setBitmap(Bitmap bitmap) {
        if (bitmap == null || this.mBitmap == null || !bitmap.equals(this.mBitmap)) {
            if (bitmap == null) {
                bitmap = Bitmap.createBitmap(5, 5, Bitmap.Config.ARGB_8888);
            }
            this.mBitmap = bitmap;
            OnWaterMarkBitmapChangedListener onWaterMarkBitmapChangedListener2 = this.onWaterMarkBitmapChangedListener;
            if (onWaterMarkBitmapChangedListener2 != null) {
                onWaterMarkBitmapChangedListener2.onWaterMarkBitmapChanged(bitmap);
            }
        }
    }

    public void setWidthAndHeight(float f, float f2) {
        this.mWidth = f;
        this.mHeight = f2;
        OnWaterMarkStatusChangedListener onWaterMarkStatusChangedListener2 = this.onWaterMarkStatusChangedListener;
        if (onWaterMarkStatusChangedListener2 != null) {
            onWaterMarkStatusChangedListener2.onWaterMarkParamsChanged();
        }
    }

    public void updateValues(WaterMarkController waterMarkController) {
        boolean z;
        OnWaterMarkStatusChangedListener onWaterMarkStatusChangedListener2;
        boolean z2 = true;
        if (this.x_soffset != waterMarkController.x_soffset) {
            this.x_soffset = waterMarkController.x_soffset;
            z = true;
        } else {
            z = false;
        }
        if (this.y_soffset != waterMarkController.y_soffset) {
            this.y_soffset = waterMarkController.y_soffset;
            z = true;
        }
        if (this.mWidth != waterMarkController.mWidth) {
            this.mWidth = waterMarkController.mWidth;
            z = true;
        }
        if (this.mHeight != waterMarkController.mHeight) {
            this.mHeight = waterMarkController.mHeight;
        } else {
            z2 = z;
        }
        if (this.mBitmap != waterMarkController.mBitmap) {
            this.mBitmap = waterMarkController.mBitmap;
            OnWaterMarkBitmapChangedListener onWaterMarkBitmapChangedListener2 = this.onWaterMarkBitmapChangedListener;
            if (onWaterMarkBitmapChangedListener2 != null) {
                onWaterMarkBitmapChangedListener2.onWaterMarkBitmapChanged(this.mBitmap);
            }
        } else if (z2 && (onWaterMarkStatusChangedListener2 = this.onWaterMarkStatusChangedListener) != null) {
            onWaterMarkStatusChangedListener2.onWaterMarkParamsChanged();
        }
    }

    public void clearResource() {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
    }

    public void onBitmapChanged(Bitmap bitmap) {
        setBitmap(bitmap);
    }

    public void onLocationChanged(float f, float f2) {
        this.x_soffset = f;
        this.y_soffset = f2;
        OnWaterMarkStatusChangedListener onWaterMarkStatusChangedListener2 = this.onWaterMarkStatusChangedListener;
        if (onWaterMarkStatusChangedListener2 != null) {
            onWaterMarkStatusChangedListener2.onWaterMarkParamsChanged();
        }
    }
}
