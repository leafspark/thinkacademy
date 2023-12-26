package com.wushuangtech.library.video.egl;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLDisplay;
import android.util.Log;

abstract class EGLConfigBaseChooser implements EGLConfigChooser {
    private static final String TAG = "EGLConfigBaseChooser";
    protected int[] mConfigSpec;
    private int mOpenGLClientVersion;

    /* access modifiers changed from: package-private */
    public abstract EGLConfig chooseConfig(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

    public EGLConfigBaseChooser(int[] iArr, int i) {
        this.mOpenGLClientVersion = i;
        this.mConfigSpec = filterConfigSpec(iArr);
    }

    public EGLConfig chooseConfig(EGLDisplay eGLDisplay) {
        int[] iArr = new int[100];
        EGLConfig[] eGLConfigArr = new EGLConfig[100];
        if (!EGL14.eglChooseConfig(eGLDisplay, this.mConfigSpec, 0, eGLConfigArr, 0, 100, iArr, 0)) {
            logE(TAG, "eglChooseConfig failed");
        }
        if (iArr[0] <= 0) {
            logE(TAG, "No configs match configSpec");
        }
        return chooseConfig(eGLDisplay, eGLConfigArr);
    }

    private int[] filterConfigSpec(int[] iArr) {
        int i = this.mOpenGLClientVersion;
        if (i != 2 && i != 3) {
            return iArr;
        }
        int length = iArr.length;
        int[] iArr2 = new int[(length + 2)];
        int i2 = length - 1;
        System.arraycopy(iArr, 0, iArr2, 0, i2);
        iArr2[i2] = 12352;
        if (this.mOpenGLClientVersion == 2) {
            iArr2[length] = 4;
        } else {
            iArr2[length] = 64;
        }
        iArr2[length + 1] = 12344;
        return iArr2;
    }

    /* access modifiers changed from: package-private */
    public void log(String str, String str2) {
        Log.d("<VRW> - " + str, str2);
    }

    /* access modifiers changed from: package-private */
    public void logE(String str, String str2) {
        Log.e("<VRW> - " + str, str2);
    }
}
