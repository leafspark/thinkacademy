package com.wushuangtech.library.video.egl;

import com.wushuangtech.utils.MyGLUtils;
import com.wushuangtech.utils.OmniLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class EGLHelper {
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private static final int SURFACE_PBUFFER = 1;
    private static final int SURFACE_PIM = 2;
    private static final int SURFACE_WINDOW = 3;
    private static final String TAG = "EGLHelper";
    private int alpha = 8;
    private int blue = 8;
    private int green = 8;
    private EGL10 mEgl;
    private EGLConfig mEglConfig;
    private EGLContext mEglContext = EGL10.EGL_NO_CONTEXT;
    private EGLDisplay mEglDisplay = EGL10.EGL_NO_DISPLAY;
    private int red = 8;
    private int renderType = 4;

    public EGLContext getEglContext() {
        return this.mEglContext;
    }

    public EGL10 getEgl() {
        return this.mEgl;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.mEglDisplay != EGL10.EGL_NO_DISPLAY) {
                logW("WARNING: EGLHelper14 was not explicitly released -- state may be leaked");
                destory();
            }
        } finally {
            super.finalize();
        }
    }

    public EGLSurface createWindowSurface(Object obj) {
        EGLSurface createEglSurface = createEglSurface(3, obj, new int[]{12344});
        log("Create window eglSurface : " + createEglSurface + " | src obj : " + obj);
        return createEglSurface;
    }

    public EGLSurface createOffScreenSurface(int i, int i2) {
        EGLSurface createEglSurface = createEglSurface(1, (Object) null, (i == 0 || i2 == 0) ? new int[]{12344} : new int[]{12375, i, 12374, i2, 12344});
        log("Create off screen eglSurface : " + createEglSurface);
        return createEglSurface;
    }

    public void config(int i, int i2, int i3, int i4, int i5) {
        this.red = i;
        this.green = i2;
        this.blue = i3;
        this.alpha = i4;
        this.renderType = i5;
    }

    public boolean eglInit(EGLContext eGLContext) {
        if (this.mEglDisplay != EGL10.EGL_NO_DISPLAY) {
            return false;
        }
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.mEgl = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.mEglDisplay = eglGetDisplay;
        if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            checkEgl10Error("eglGetDisplay");
            return false;
        }
        if (!this.mEgl.eglInitialize(this.mEglDisplay, new int[2])) {
            this.mEglDisplay = null;
            checkEgl10Error("eglInitialize");
            return false;
        }
        int i = this.red;
        int i2 = this.green;
        int i3 = this.blue;
        int i4 = this.alpha;
        int[] iArr = {12324, i, 12323, i2, 12322, i3, 12321, i4, 12320, i + i2 + i3 + i4, 12352, this.renderType, 12339, 1, 12344};
        int[] iArr2 = new int[1];
        if (!this.mEgl.eglChooseConfig(this.mEglDisplay, iArr, (EGLConfig[]) null, 0, iArr2)) {
            checkEgl10Error("eglChooseConfig");
            return false;
        } else if (iArr2[0] == 0) {
            logE(" No EGLConfig support ! ");
            return false;
        } else {
            EGLConfig[] eGLConfigArr = new EGLConfig[iArr2[0]];
            if (!this.mEgl.eglChooseConfig(this.mEglDisplay, iArr, eGLConfigArr, iArr2[0], iArr2)) {
                checkEgl10Error("eglChooseConfig second");
                return false;
            }
            this.mEglConfig = eGLConfigArr[0];
            int[] iArr3 = {EGL_CONTEXT_CLIENT_VERSION, 2, 12344};
            if (eGLContext == null) {
                eGLContext = EGL10.EGL_NO_CONTEXT;
            }
            EGLContext eglCreateContext = this.mEgl.eglCreateContext(this.mEglDisplay, this.mEglConfig, eGLContext, iArr3);
            this.mEglContext = eglCreateContext;
            if (eglCreateContext != EGL10.EGL_NO_CONTEXT) {
                return true;
            }
            checkEgl10Error("eglCreateContext");
            return false;
        }
    }

    public boolean destory() {
        log("Destory current egl! " + this.mEgl);
        EGL10 egl10 = this.mEgl;
        if (egl10 != null) {
            egl10.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            this.mEgl.eglDestroyContext(this.mEglDisplay, this.mEglContext);
            this.mEgl.eglTerminate(this.mEglDisplay);
            this.mEgl = null;
        }
        this.mEglDisplay = EGL10.EGL_NO_DISPLAY;
        this.mEglConfig = null;
        return true;
    }

    public boolean makeCurrent() {
        EGL10 egl10 = this.mEgl;
        if (egl10 == null) {
            logE("swapBuffers -> EGL10 obj is null!");
            return false;
        } else if (egl10.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, this.mEglContext)) {
            return true;
        } else {
            checkEgl10Error("eglMakeCurrent");
            return false;
        }
    }

    public boolean makeCurrent(EGLSurface eGLSurface) {
        if (eGLSurface == null) {
            return true;
        }
        EGL10 egl10 = this.mEgl;
        if (egl10 == null) {
            logE("swapBuffers -> EGL10 obj is null!");
            return false;
        } else if (egl10.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, this.mEglContext)) {
            return true;
        } else {
            checkEgl10Error("eglMakeCurrent");
            return false;
        }
    }

    public boolean swapBuffers(EGLSurface eGLSurface) {
        if (eGLSurface == null) {
            return true;
        }
        EGL10 egl10 = this.mEgl;
        if (egl10 == null) {
            logE("Swap buffer failed! -> EGL10 obj is null!");
            return false;
        }
        boolean eglSwapBuffers = egl10.eglSwapBuffers(this.mEglDisplay, eGLSurface);
        if (!eglSwapBuffers) {
            checkEgl10Error("eglSwapBuffers");
        }
        return eglSwapBuffers;
    }

    public boolean destorySurface(EGLSurface eGLSurface) {
        if (eGLSurface == null) {
            return true;
        }
        EGL10 egl10 = this.mEgl;
        if (egl10 == null) {
            logE("Destory surface failed! -> EGL10 obj is null!");
            return false;
        } else if (egl10.eglDestroySurface(this.mEglDisplay, eGLSurface)) {
            return true;
        } else {
            checkEgl10Error("eglDestroySurface");
            return false;
        }
    }

    private EGLSurface createEglSurface(int i, Object obj, int[] iArr) {
        String str;
        EGLSurface eGLSurface;
        EGL10 egl10 = this.mEgl;
        if (egl10 == null) {
            return null;
        }
        if (i == 2) {
            eGLSurface = egl10.eglCreatePixmapSurface(this.mEglDisplay, this.mEglConfig, obj, iArr);
            str = "eglCreatePixmapSurface";
        } else if (i != 3) {
            eGLSurface = egl10.eglCreatePbufferSurface(this.mEglDisplay, this.mEglConfig, iArr);
            str = "eglCreatePbufferSurface";
        } else {
            eGLSurface = egl10.eglCreateWindowSurface(this.mEglDisplay, this.mEglConfig, obj, iArr);
            str = "eglCreateWindowSurface";
        }
        if (eGLSurface != EGL10.EGL_NO_SURFACE) {
            return eGLSurface;
        }
        checkEgl10Error(str);
        return null;
    }

    private void log(String str) {
        OmniLog.d("<VRW> - EGLHelper", str);
    }

    private void logW(String str) {
        OmniLog.e("<VRW> - EGLHelper", str);
    }

    private void logE(String str) {
        OmniLog.e("<VRW> - EGLHelper", str);
    }

    private void checkEgl10Error(String str) {
        EGL10 egl10 = this.mEgl;
        if (egl10 != null) {
            MyGLUtils.checkEgl10Error(egl10, TAG, str);
        }
    }
}
