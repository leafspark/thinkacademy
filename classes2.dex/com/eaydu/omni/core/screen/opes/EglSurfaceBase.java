package com.eaydu.omni.core.screen.opes;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import com.wushuangtech.utils.OmniLog;

public class EglSurfaceBase {
    protected static final String TAG = "OPEN_GL";
    private EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;
    EglCore mEglCore;
    private int mHeight = -1;
    private int mWidth = -1;

    EglSurfaceBase(EglCore eglCore) {
        this.mEglCore = eglCore;
    }

    /* access modifiers changed from: package-private */
    public void createWindowSurface(Object obj) {
        if (this.mEGLSurface == EGL14.EGL_NO_SURFACE) {
            this.mEGLSurface = this.mEglCore.createWindowSurface(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    /* access modifiers changed from: package-private */
    public void createOffscreenSurface(int i, int i2) {
        if (this.mEGLSurface == EGL14.EGL_NO_SURFACE) {
            this.mEGLSurface = this.mEglCore.createOffscreenSurface(i, i2);
            this.mWidth = i;
            this.mHeight = i2;
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public int getWidth() {
        int i = this.mWidth;
        return i < 0 ? this.mEglCore.querySurface(this.mEGLSurface, 12375) : i;
    }

    public int getHeight() {
        int i = this.mHeight;
        return i < 0 ? this.mEglCore.querySurface(this.mEGLSurface, 12374) : i;
    }

    public void releaseEglSurface() {
        this.mEglCore.releaseSurface(this.mEGLSurface);
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mHeight = -1;
        this.mWidth = -1;
    }

    public void makeCurrent() {
        this.mEglCore.makeCurrent(this.mEGLSurface);
    }

    public void makeCurrentReadFrom(EglSurfaceBase eglSurfaceBase) {
        this.mEglCore.makeCurrent(this.mEGLSurface, eglSurfaceBase.mEGLSurface);
    }

    public boolean swapBuffers() {
        boolean swapBuffers = this.mEglCore.swapBuffers(this.mEGLSurface);
        if (!swapBuffers) {
            OmniLog.d("OPEN_GL", "WARNING: swapBuffers() failed");
        }
        return swapBuffers;
    }

    public void setPresentationTime(long j) {
        this.mEglCore.setPresentationTime(this.mEGLSurface, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void saveFrame(java.io.File r12) throws java.io.IOException {
        /*
            r11 = this;
            com.eaydu.omni.core.screen.opes.EglCore r0 = r11.mEglCore
            android.opengl.EGLSurface r1 = r11.mEGLSurface
            boolean r0 = r0.isCurrent(r1)
            if (r0 == 0) goto L_0x00a2
            java.lang.String r12 = r12.toString()
            int r7 = r11.getWidth()
            int r8 = r11.getHeight()
            int r0 = r7 * r8
            int r0 = r0 * 4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "saveFrame allocateDirect invoked! allocType: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r9 = "OPEN_GL"
            com.wushuangtech.utils.OmniLog.amd(r9, r1)
            java.nio.ByteBuffer r10 = java.nio.ByteBuffer.allocateDirect(r0)
            java.nio.ByteOrder r0 = java.nio.ByteOrder.LITTLE_ENDIAN
            r10.order(r0)
            r0 = 0
            r1 = 0
            r4 = 6408(0x1908, float:8.98E-42)
            r5 = 5121(0x1401, float:7.176E-42)
            r2 = r7
            r3 = r8
            r6 = r10
            android.opengl.GLES20.glReadPixels(r0, r1, r2, r3, r4, r5, r6)
            java.lang.String r0 = "glReadPixels"
            com.eaydu.omni.core.screen.opes.GlUtil.checkGlError(r0)
            r10.rewind()
            r0 = 0
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x009b }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x009b }
            r2.<init>(r12)     // Catch:{ all -> 0x009b }
            r1.<init>(r2)     // Catch:{ all -> 0x009b }
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x0098 }
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r7, r8, r0)     // Catch:{ all -> 0x0098 }
            r0.copyPixelsFromBuffer(r10)     // Catch:{ all -> 0x0098 }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ all -> 0x0098 }
            r3 = 90
            r0.compress(r2, r3, r1)     // Catch:{ all -> 0x0098 }
            r0.recycle()     // Catch:{ all -> 0x0098 }
            r1.close()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Saved "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = "x"
            r0.append(r1)
            r0.append(r8)
            java.lang.String r1 = " frame as '"
            r0.append(r1)
            r0.append(r12)
            java.lang.String r12 = "'"
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            com.wushuangtech.utils.OmniLog.d(r9, r12)
            return
        L_0x0098:
            r12 = move-exception
            r0 = r1
            goto L_0x009c
        L_0x009b:
            r12 = move-exception
        L_0x009c:
            if (r0 == 0) goto L_0x00a1
            r0.close()
        L_0x00a1:
            throw r12
        L_0x00a2:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException
            java.lang.String r0 = "Expected EGL context/surface is not current"
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.core.screen.opes.EglSurfaceBase.saveFrame(java.io.File):void");
    }
}
