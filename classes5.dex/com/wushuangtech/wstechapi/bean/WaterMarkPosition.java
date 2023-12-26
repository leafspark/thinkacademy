package com.wushuangtech.wstechapi.bean;

import android.graphics.Bitmap;
import com.wushuangtech.inter.OnVideoWaterMarkChangeListener;
import com.yalantis.ucrop.view.CropImageView;

public class WaterMarkPosition {
    private Bitmap mBitmap;
    public ChangeWaterMarkBitmapCallBack mChangeWaterMarkBitmapCallBack;
    public ChangeWaterMarkPositionCallBack mChangeWaterMarkPositionCallBack;
    private float mHeight;
    public OnVideoWaterMarkChangeListener mOnVideoWaterMarkChangeListener;
    private float mWidth;
    private float x_soffset = CropImageView.DEFAULT_ASPECT_RATIO;
    private float y_soffset = CropImageView.DEFAULT_ASPECT_RATIO;

    public interface ChangeWaterMarkBitmapCallBack {
        void notifyReiniBitmap(Bitmap bitmap);
    }

    public interface ChangeWaterMarkPositionCallBack {
        void notifyReinitWaterMark();

        void notifyVisibile(boolean z);
    }

    public float getX_soffset() {
        return this.x_soffset;
    }

    public float getY_soffset() {
        return this.y_soffset;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public void setX_soffset(float f) {
        this.x_soffset = f;
        ChangeWaterMarkPositionCallBack changeWaterMarkPositionCallBack = this.mChangeWaterMarkPositionCallBack;
        if (changeWaterMarkPositionCallBack != null) {
            changeWaterMarkPositionCallBack.notifyReinitWaterMark();
        }
        OnVideoWaterMarkChangeListener onVideoWaterMarkChangeListener = this.mOnVideoWaterMarkChangeListener;
        if (onVideoWaterMarkChangeListener != null) {
            onVideoWaterMarkChangeListener.onLocationChanged(this.x_soffset, this.y_soffset);
        }
    }

    public void setY_soffset(float f) {
        this.y_soffset = f;
        ChangeWaterMarkPositionCallBack changeWaterMarkPositionCallBack = this.mChangeWaterMarkPositionCallBack;
        if (changeWaterMarkPositionCallBack != null) {
            changeWaterMarkPositionCallBack.notifyReinitWaterMark();
        }
        OnVideoWaterMarkChangeListener onVideoWaterMarkChangeListener = this.mOnVideoWaterMarkChangeListener;
        if (onVideoWaterMarkChangeListener != null) {
            onVideoWaterMarkChangeListener.onBitmapChanged(this.mBitmap);
        }
        OnVideoWaterMarkChangeListener onVideoWaterMarkChangeListener2 = this.mOnVideoWaterMarkChangeListener;
        if (onVideoWaterMarkChangeListener2 != null) {
            onVideoWaterMarkChangeListener2.onLocationChanged(this.x_soffset, this.y_soffset);
        }
    }

    public void setmBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
        if (bitmap == null) {
            ChangeWaterMarkPositionCallBack changeWaterMarkPositionCallBack = this.mChangeWaterMarkPositionCallBack;
            if (changeWaterMarkPositionCallBack != null) {
                changeWaterMarkPositionCallBack.notifyVisibile(false);
            }
        } else {
            ChangeWaterMarkPositionCallBack changeWaterMarkPositionCallBack2 = this.mChangeWaterMarkPositionCallBack;
            if (changeWaterMarkPositionCallBack2 != null) {
                changeWaterMarkPositionCallBack2.notifyVisibile(true);
            }
        }
        ChangeWaterMarkBitmapCallBack changeWaterMarkBitmapCallBack = this.mChangeWaterMarkBitmapCallBack;
        if (changeWaterMarkBitmapCallBack != null) {
            changeWaterMarkBitmapCallBack.notifyReiniBitmap(bitmap);
        }
        ChangeWaterMarkPositionCallBack changeWaterMarkPositionCallBack3 = this.mChangeWaterMarkPositionCallBack;
        if (changeWaterMarkPositionCallBack3 != null) {
            changeWaterMarkPositionCallBack3.notifyReinitWaterMark();
        }
        OnVideoWaterMarkChangeListener onVideoWaterMarkChangeListener = this.mOnVideoWaterMarkChangeListener;
        if (onVideoWaterMarkChangeListener != null) {
            onVideoWaterMarkChangeListener.onBitmapChanged(bitmap);
        }
    }

    public void setmWidthAndHeight(float f, float f2) {
        this.mWidth = f;
        this.mHeight = f2;
        ChangeWaterMarkPositionCallBack changeWaterMarkPositionCallBack = this.mChangeWaterMarkPositionCallBack;
        if (changeWaterMarkPositionCallBack != null) {
            changeWaterMarkPositionCallBack.notifyReinitWaterMark();
        }
    }

    public String toString() {
        String str;
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            str = "";
        } else {
            str = Integer.toHexString(bitmap.hashCode());
        }
        return str + "," + this.mWidth + "," + this.mHeight;
    }
}
