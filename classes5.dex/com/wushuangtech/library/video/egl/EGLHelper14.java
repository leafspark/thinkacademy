package com.wushuangtech.library.video.egl;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;
import com.wushuangtech.utils.MyGLUtils;
import com.wushuangtech.utils.OmniLog;
import java.util.Arrays;

public class EGLHelper14 {
    private static final int OPENGLES_VERSION_2 = 2;
    private static final int OPENGLES_VERSION_3 = 3;
    private static final String TAG = "EGL14";
    private EGLConfig mEGLConfig = null;
    private EGLContext mEGLContext = EGL14.EGL_NO_CONTEXT;
    private EGLDisplay mEGLDisplay = EGL14.EGL_NO_DISPLAY;
    private boolean mEGLInited;
    private int mGLVersion = -1;

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public boolean destory() {
        if (!this.mEGLInited) {
            return false;
        }
        this.mEGLInited = false;
        EGL14.eglMakeCurrent(this.mEGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
        EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
        EGL14.eglTerminate(this.mEGLDisplay);
        EGL14.eglReleaseThread();
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
        log("EGL14 client destory success!");
        return true;
    }

    public boolean eglInit() {
        return eglInit(EGL14.EGL_NO_CONTEXT);
    }

    public boolean eglInit(EGLContext eGLContext) {
        if (this.mEGLInited) {
            return true;
        }
        EGL14.eglBindAPI(12448);
        int eglQueryAPI = EGL14.eglQueryAPI();
        log("queryAPI : " + eglQueryAPI);
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            printlnEGLErrorMsg("eglGetDisplay", "EGL init failed!");
            return false;
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
            printlnEGLErrorMsg("eglInitialize", "EGL init failed!");
            return false;
        }
        log("major version : " + iArr[0] + " - minor version : " + iArr[1]);
        boolean tryCreateEGLContext = tryCreateEGLContext(3, eglGetDisplay, eGLContext);
        if (!tryCreateEGLContext) {
            tryCreateEGLContext = tryCreateEGLContext(2, eglGetDisplay, eGLContext);
        }
        if (!tryCreateEGLContext) {
            log("EGL14 client create context failed, version : " + iArr[0] + " - minor version : " + iArr[1]);
            return false;
        }
        int[] iArr2 = new int[4];
        EGL14.eglQueryContext(eglGetDisplay, this.mEGLContext, 12440, iArr2, 0);
        EGL14.eglQueryContext(eglGetDisplay, this.mEGLContext, 12440, iArr2, 1);
        EGL14.eglQueryContext(eglGetDisplay, this.mEGLContext, 12539, iArr2, 2);
        EGL14.eglQueryContext(eglGetDisplay, this.mEGLContext, 12540, iArr2, 3);
        this.mGLVersion = iArr2[0];
        this.mEGLDisplay = eglGetDisplay;
        this.mEGLInited = true;
        log("EGL14 client init success! version " + Arrays.toString(iArr2));
        return true;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY) {
                logW("WARNING: EGLHelper14 was not explicitly released -- state may be leaked");
                destory();
            }
        } finally {
            super.finalize();
        }
    }

    public boolean destorySurface(EGLSurface eGLSurface) {
        if (eGLSurface == null) {
            return true;
        }
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        if (eGLDisplay == null || eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            logE("Destory eglSurface failed! EGLDisplay obj is null!");
            return false;
        } else if (!EGL14.eglDestroySurface(eGLDisplay, eGLSurface)) {
            printlnEGLErrorMsg("eglDestroySurface", "Destory eglSurface failed!");
            return false;
        } else {
            log("Destory eglSurface success! " + eGLSurface);
            return true;
        }
    }

    public EGLSurface createWindowSurface(Object obj) {
        EGLSurface eGLSurface;
        if (!obj.getClass().getSimpleName().equals("Surface") || ((Surface) obj).isValid()) {
            EGLDisplay eGLDisplay = this.mEGLDisplay;
            EGLConfig eGLConfig = this.mEGLConfig;
            if (eGLDisplay == null || eGLDisplay == EGL14.EGL_NO_DISPLAY || eGLConfig == null) {
                logE("Create window eglSurface failed! EGLDisplay or EGLConfig obj is null!");
                return null;
            }
            try {
                eGLSurface = EGL14.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, new int[]{12344}, 0);
                try {
                    if (eGLSurface == EGL14.EGL_NO_SURFACE) {
                        printlnEGLErrorMsg("eglCreateWindowSurface", "Create window eglSurface failed!");
                        return null;
                    }
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                eGLSurface = null;
            }
            if (eGLSurface == null) {
                log("Create window eglSurface failed! src : " + obj);
                return null;
            }
            log("Create window eglSurface success! " + eGLSurface + " | src : " + obj);
            return eGLSurface;
        }
        logE("Create window eglSurface failed! invalid surface: " + obj);
        return null;
    }

    public EGLSurface createOffscreenSurface(int i, int i2) {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLConfig eGLConfig = this.mEGLConfig;
        if (eGLDisplay == null || eGLDisplay == EGL14.EGL_NO_DISPLAY || eGLConfig == null) {
            logE("Create window eglSurface failed! EGLDisplay or EGLConfig obj is null!");
            return null;
        }
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, (i == 0 || i2 == 0) ? new int[]{12344} : new int[]{12375, i, 12374, i2, 12344}, 0);
        if (eglCreatePbufferSurface == EGL14.EGL_NO_SURFACE) {
            printlnEGLErrorMsg("eglCreatePbufferSurface", "Create buffer eglSurface failed!");
            return null;
        }
        log("Create buffer eglSurface success! " + eglCreatePbufferSurface);
        return eglCreatePbufferSurface;
    }

    public boolean makeCurrent(EGLSurface eGLSurface) {
        if (eGLSurface == null) {
            return true;
        }
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLContext eGLContext = this.mEGLContext;
        if (eGLDisplay == null || eGLDisplay == EGL14.EGL_NO_DISPLAY || eGLContext == null || eGLContext == EGL14.EGL_NO_CONTEXT) {
            logE("Make thread failed! EGLDisplay or EGLContext obj is null!");
            return false;
        } else if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext)) {
            return true;
        } else {
            printlnEGLErrorMsg("eglMakeCurrent", "Make thread failed!");
            return false;
        }
    }

    public boolean makeCurrent() {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLContext eGLContext = this.mEGLContext;
        if (eGLDisplay == null || eGLDisplay == EGL14.EGL_NO_DISPLAY || eGLContext == null || eGLContext == EGL14.EGL_NO_CONTEXT) {
            logE("Make thread failed! EGLDisplay or EGLContext obj is null!");
            return false;
        } else if (EGL14.eglMakeCurrent(eGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, eGLContext)) {
            return true;
        } else {
            printlnEGLErrorMsg("eglMakeCurrent", "Make thread failed!");
            return true;
        }
    }

    public boolean swapBuffers(EGLSurface eGLSurface) {
        if (eGLSurface == null) {
            return true;
        }
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        if (eGLDisplay == null || eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            logE("Swap buffer failed! EGLDisplay or EGLContext obj is null!");
            return false;
        } else if (EGL14.eglSwapBuffers(eGLDisplay, eGLSurface)) {
            return true;
        } else {
            printlnEGLErrorMsg("eglSwapBuffers", "Swap buffer failed : " + eGLSurface);
            return false;
        }
    }

    public boolean setPresentationTime(EGLSurface eGLSurface, long j) {
        if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
            logE("Set PresentationTime failed! EGLDisplay obj is null!");
            return false;
        } else if (EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, eGLSurface, j)) {
            return true;
        } else {
            printlnEGLErrorMsg("eglPresentationTimeANDROID", "Set PresentationTime failed!");
            return false;
        }
    }

    public boolean isCurrent(EGLSurface eGLSurface) {
        return this.mEGLContext.equals(EGL14.eglGetCurrentContext()) && eGLSurface.equals(EGL14.eglGetCurrentSurface(12377));
    }

    public int querySurface(EGLSurface eGLSurface, int i) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.mEGLDisplay, eGLSurface, i, iArr, 0);
        return iArr[0];
    }

    public String queryString(int i) {
        return EGL14.eglQueryString(this.mEGLDisplay, i);
    }

    public int getGlVersion() {
        return this.mGLVersion;
    }

    public static void logCurrent(String str) {
        EGLDisplay eglGetCurrentDisplay = EGL14.eglGetCurrentDisplay();
        EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
        EGLSurface eglGetCurrentSurface = EGL14.eglGetCurrentSurface(12377);
        Log.d(TAG, "Current EGL (" + str + "): display=" + eglGetCurrentDisplay + ", context=" + eglGetCurrentContext + ", surface=" + eglGetCurrentSurface);
    }

    private boolean tryCreateEGLContext(int i, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        EGLConfig tryCreateEGLConfig = tryCreateEGLConfig(i, eGLDisplay);
        if (tryCreateEGLConfig == null) {
            log("EGL14 client create rgb888 config failed...");
            return false;
        }
        EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, tryCreateEGLConfig, eGLContext, new int[]{12440, i, 12344}, 0);
        if (eglCreateContext == EGL14.EGL_NO_CONTEXT) {
            printlnEGLErrorMsg("eglCreateContext", "EGL init failed!");
            return false;
        }
        this.mEGLConfig = tryCreateEGLConfig;
        this.mEGLContext = eglCreateContext;
        return true;
    }

    private EGLConfig tryCreateEGLConfig(int i, EGLDisplay eGLDisplay) {
        return new ComponentSizeChooser(i, 8, 8, 8, 8, 0, 0).chooseConfig(eGLDisplay);
    }

    private void log(String str) {
        Log.d(OmniLog.TAG, "[VRW] - " + str);
    }

    private void logW(String str) {
        Log.w(OmniLog.TAG, "[VRW] - " + str);
    }

    private void logE(String str) {
        Log.e(OmniLog.TAG, "[VRW] - " + str);
    }

    private void printlnEGLErrorMsg(String str, String str2) {
        MyGLUtils.printlnEGLErrorMsg(str, TAG, str2);
    }
}
