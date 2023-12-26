package com.luck.picture.lib.photoview;

interface OnGestureListener {
    void onDrag(float f, float f2);

    void onFling(float f, float f2, float f3, float f4);

    void onScale(float f, float f2, float f3);

    void onScale(float f, float f2, float f3, float f4, float f5);
}
