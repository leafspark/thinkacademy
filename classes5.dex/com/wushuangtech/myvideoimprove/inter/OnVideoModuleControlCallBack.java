package com.wushuangtech.myvideoimprove.inter;

import android.graphics.Bitmap;

public interface OnVideoModuleControlCallBack {
    void videoEncodeParamsChanged(boolean z, int i, int i2);

    void videoEncodeStarted(boolean z);

    void videoEncodeStoped(boolean z);

    void waterMarkBitmapChanged(Bitmap bitmap);

    void waterMarkLocationChanged(float f, float f2);
}
