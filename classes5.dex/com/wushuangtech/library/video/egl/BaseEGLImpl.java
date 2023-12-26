package com.wushuangtech.library.video.egl;

import android.opengl.EGLSurface;
import com.wushuangtech.utils.OmniLog;
import java.util.HashMap;

abstract class BaseEGLImpl implements BaseEGL {
    String TAG = getClass().getSimpleName();
    private HashMap<EGLSurface, Integer> mEglSurfaceRefs = new HashMap<>();

    BaseEGLImpl() {
    }

    /* access modifiers changed from: package-private */
    public void addEglSurfaceRefs(EGLSurface eGLSurface) {
        Integer num = this.mEglSurfaceRefs.get(eGLSurface);
        int i = 1;
        if (num != null) {
            i = Integer.valueOf(num.intValue() + 1).intValue();
        }
        this.mEglSurfaceRefs.put(eGLSurface, Integer.valueOf(i));
        log("Update eglSurface reference, add new reference, count : " + i + " | eglSurface : " + eGLSurface);
    }

    /* access modifiers changed from: package-private */
    public boolean checkDestory(EGLSurface eGLSurface) {
        Integer num = this.mEglSurfaceRefs.get(eGLSurface);
        if (num == null || num.intValue() == 0) {
            log("Update eglSurface reference, remove reference,  count : 0 | eglSurface : " + eGLSurface);
            return true;
        }
        int intValue = Integer.valueOf(num.intValue() - 1).intValue();
        this.mEglSurfaceRefs.put(eGLSurface, Integer.valueOf(intValue));
        log("Update eglSurface reference, remove reference,  count : " + intValue + " | eglSurface : " + eGLSurface);
        if (intValue == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void log(String str) {
        OmniLog.debugD(OmniLog.VIDEO_RENDER_WATCH, this.TAG, str);
    }
}
