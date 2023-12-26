package com.luck.picture.lib.camera.listener;

import java.io.File;

public interface CameraListener {
    void onError(int i, String str, Throwable th);

    void onPictureSuccess(File file);

    void onRecordSuccess(File file);
}
