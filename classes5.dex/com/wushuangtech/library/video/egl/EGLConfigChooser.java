package com.wushuangtech.library.video.egl;

import android.opengl.EGLConfig;
import android.opengl.EGLDisplay;

interface EGLConfigChooser {
    EGLConfig chooseConfig(EGLDisplay eGLDisplay);
}
