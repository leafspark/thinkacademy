package com.wushuangtech.library.video.egl;

import com.wushuangtech.utils.OmniLog;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLSurface;

public class EGLSurfaceWrap {
    private String TAG = "EGLSurfaceWrap";
    EGLSurface eglSurface11;
    public android.opengl.EGLSurface eglSurface14;
    EGLContext mEglContext11;
    public android.opengl.EGLContext mEglContext14;
    private long mErrorStartTimestamp;
    private int mErrorType;
    EGLSurfaceType mType;
    boolean mValid = true;
    public String mWindowId;
    public Object window;

    public void setTAG(String str) {
        this.TAG = "-" + str;
    }

    public String toString() {
        return "EGLSurfaceWrap{windowId=" + this.mWindowId + ", window=" + this.window + ", eglSurface11=" + this.eglSurface11 + ", eglSurface14=" + this.eglSurface14 + ", mVaild=" + this.mValid + ", mErrorType=" + this.mErrorType + '}';
    }

    public void updateRenderStatus(int i) {
        if (this.mValid) {
            if (i == 0) {
                this.mErrorType = 0;
                this.mErrorStartTimestamp = 0;
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mErrorType != i) {
                this.mErrorType = i;
                this.mErrorStartTimestamp = currentTimeMillis;
                String str = this.TAG;
                OmniLog.e(OmniLog.VIDEO_RENDER_WATCH, str, "EGLSurface is error " + toString());
                return;
            }
            long j = this.mErrorStartTimestamp;
            if (j == 0) {
                this.mErrorStartTimestamp = System.currentTimeMillis();
            } else if (currentTimeMillis - j > 3000) {
                String str2 = this.TAG;
                OmniLog.e(OmniLog.VIDEO_RENDER_WATCH, str2, "EGLSurface is invalid! " + toString());
                this.mValid = false;
            }
        }
    }
}
