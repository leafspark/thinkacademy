package com.luck.picture.lib.camera.listener;

public interface CaptureListener {
    void recordEnd(long j);

    void recordError();

    void recordShort(long j);

    void recordStart();

    void recordUpdateTime(long j);

    void recordZoom(float f);

    void takePictures();
}
