package org.libpag;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import org.extra.tools.a;

class VideoSurface implements SurfaceTexture.OnFrameAvailableListener {
    long nativeContext = 0;

    static {
        a.b("pag");
        nativeInit();
    }

    private VideoSurface(int i, int i2) {
        nativeSetup(i, i2);
    }

    static VideoSurface a(int i, int i2) {
        VideoSurface videoSurface = new VideoSurface(i, i2);
        if (videoSurface.nativeContext == 0) {
            return null;
        }
        return videoSurface;
    }

    private native void nativeFinalize();

    private static native void nativeInit();

    private native void nativeRelease();

    private native void nativeSetup(int i, int i2);

    private native void notifyFrameAvailable();

    /* access modifiers changed from: protected */
    public void finalize() {
        nativeFinalize();
    }

    /* access modifiers changed from: package-private */
    public native Surface getInputSurface();

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        notifyFrameAvailable();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        nativeRelease();
    }
}
