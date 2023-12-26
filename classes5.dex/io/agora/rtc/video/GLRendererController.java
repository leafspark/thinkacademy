package io.agora.rtc.video;

import android.graphics.SurfaceTexture;

public interface GLRendererController extends SurfaceTexture.OnFrameAvailableListener {
    int GetAPILevel();

    void ReDraw();
}
