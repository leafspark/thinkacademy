package com.linkedin.android.litr.render;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;

class VideoRenderInputSurface implements SurfaceTexture.OnFrameAvailableListener {
    private static final int FRAME_WAIT_TIMEOUT_MS = 10000;
    private boolean frameAvailable;
    private final Object frameSyncObject = new Object();
    private Surface surface = new Surface(this.surfaceTexture);
    private SurfaceTexture surfaceTexture = new SurfaceTexture(this.textureId);
    private int textureId = createTexture();

    VideoRenderInputSurface() {
        this.surfaceTexture.setOnFrameAvailableListener(this);
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture2) {
        synchronized (this.frameSyncObject) {
            if (!this.frameAvailable) {
                this.frameAvailable = true;
                this.frameSyncObject.notifyAll();
            } else {
                throw new RuntimeException("frameAvailable already set, frame could be dropped");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Surface getSurface() {
        return this.surface;
    }

    /* access modifiers changed from: package-private */
    public SurfaceTexture getSurfaceTexture() {
        return this.surfaceTexture;
    }

    /* access modifiers changed from: package-private */
    public int getTextureId() {
        return this.textureId;
    }

    /* access modifiers changed from: package-private */
    public float[] getTransformMatrix() {
        float[] fArr = new float[16];
        this.surfaceTexture.getTransformMatrix(fArr);
        return fArr;
    }

    /* access modifiers changed from: package-private */
    public void getTransformMatrix(float[] fArr) {
        this.surfaceTexture.getTransformMatrix(fArr);
    }

    /* access modifiers changed from: package-private */
    public void awaitNewImage() {
        synchronized (this.frameSyncObject) {
            while (!this.frameAvailable) {
                try {
                    this.frameSyncObject.wait(10000);
                    if (!this.frameAvailable) {
                        throw new RuntimeException("Surface frame wait timed out");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.frameAvailable = false;
        }
        GlRenderUtils.checkGlError("before updateTexImage");
        this.surfaceTexture.updateTexImage();
    }

    /* access modifiers changed from: package-private */
    public void release() {
        Surface surface2 = this.surface;
        if (surface2 != null) {
            surface2.release();
            this.surface = null;
        }
    }

    private int createTexture() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        GLES20.glBindTexture(36197, i);
        GlRenderUtils.checkGlError("glBindTexture textureID");
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GlRenderUtils.checkGlError("glTexParameter");
        return i;
    }
}
