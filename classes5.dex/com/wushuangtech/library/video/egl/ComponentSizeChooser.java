package com.wushuangtech.library.video.egl;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLDisplay;

class ComponentSizeChooser extends EGLConfigBaseChooser {
    private static final String TAG = "ComponentSizeChooser";
    protected int mAlphaSize;
    protected int mBlueSize;
    protected int mDepthSize;
    protected int mGreenSize;
    protected int mRedSize;
    protected int mStencilSize;
    private int[] mValue = new int[10];

    public ComponentSizeChooser(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(new int[]{12324, i2, 12323, i3, 12322, i4, 12321, i5, 12325, i6, 12326, i7, 12344}, i);
        this.mRedSize = i2;
        this.mGreenSize = i3;
        this.mBlueSize = i4;
        this.mAlphaSize = i5;
        this.mDepthSize = i6;
        this.mStencilSize = i7;
    }

    public EGLConfig chooseConfig(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        for (EGLConfig eGLConfig : eGLConfigArr) {
            log(TAG, "------------------ divider ------------------");
            int findConfigAttrib = findConfigAttrib(eGLDisplay, eGLConfig, 12325, 0);
            int findConfigAttrib2 = findConfigAttrib(eGLDisplay, eGLConfig, 12326, 0);
            log(TAG, "Config list : depth : " + findConfigAttrib + " | stencil : " + findConfigAttrib2);
            if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                int findConfigAttrib3 = findConfigAttrib(eGLDisplay, eGLConfig, 12324, 0);
                int findConfigAttrib4 = findConfigAttrib(eGLDisplay, eGLConfig, 12323, 0);
                int findConfigAttrib5 = findConfigAttrib(eGLDisplay, eGLConfig, 12322, 0);
                int findConfigAttrib6 = findConfigAttrib(eGLDisplay, eGLConfig, 12321, 0);
                log(TAG, "Config list : read : " + findConfigAttrib3 + " | green : " + findConfigAttrib4 + " | blue : " + findConfigAttrib5 + " | alpha : " + findConfigAttrib6);
                if (findConfigAttrib3 == this.mRedSize && findConfigAttrib4 == this.mGreenSize && findConfigAttrib5 == this.mBlueSize && findConfigAttrib6 == this.mAlphaSize) {
                    return eGLConfig;
                }
            }
        }
        return null;
    }

    private int findConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
        return EGL14.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue, 0) ? this.mValue[0] : i2;
    }
}
