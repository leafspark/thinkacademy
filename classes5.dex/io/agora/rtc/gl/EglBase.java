package io.agora.rtc.gl;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;
import io.agora.rtc.gl.EglBase10;
import io.agora.rtc.gl.EglBase14;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

public abstract class EglBase {
    public static final int[] CONFIG_PIXEL_BUFFER = {12324, 8, 12323, 8, 12322, 8, 12352, 4, 12339, 1, 12344};
    public static final int[] CONFIG_PIXEL_RGBA_BUFFER = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344};
    public static final int[] CONFIG_PLAIN = {12324, 8, 12323, 8, 12322, 8, 12352, 4, 12344};
    public static final int[] CONFIG_RECORDABLE = {12324, 8, 12323, 8, 12322, 8, 12352, 4, EGL_RECORDABLE_ANDROID, 1, 12344};
    public static final int[] CONFIG_RGBA = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344};
    public static final int EGL_OPENGL_ES2_BIT = 4;
    public static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final Object lock = new Object();

    public interface Context {
        int getEglType();

        long getNativeEglContext();

        Object getRealEglContext();
    }

    public interface EglType {
        public static final int EGL10 = 0;
        public static final int EGL14 = 1;
    }

    public abstract void createDummyPbufferSurface();

    public abstract void createPbufferSurface(int i, int i2);

    public abstract void createSurface(SurfaceTexture surfaceTexture);

    public abstract void createSurface(Surface surface);

    public abstract void detachCurrent();

    public abstract Context getEglBaseContext();

    public abstract boolean hasSurface();

    public abstract void makeCurrent();

    public abstract void release();

    public abstract void releaseSurface();

    public abstract int surfaceHeight();

    public abstract int surfaceWidth();

    public abstract void swapBuffers();

    public abstract void swapBuffers(long j);

    public static EglBase create(Context context, int[] iArr) {
        return (!EglBase14.isEGL14Supported() || (context != null && !(context instanceof EglBase14.Context))) ? new EglBase10((EglBase10.Context) context, iArr) : new EglBase14((EglBase14.Context) context, iArr);
    }

    public static EglBase create() {
        return create((Context) null, CONFIG_PLAIN);
    }

    public static EglBase create(Context context) {
        return create(context, CONFIG_PLAIN);
    }

    public static EglBase createEgl10(int[] iArr) {
        return new EglBase10((EglBase10.Context) null, iArr);
    }

    public static EglBase createEgl10(EGLContext eGLContext, int[] iArr) {
        return new EglBase10(new EglBase10.Context(eGLContext), iArr);
    }

    public static EglBase createEgl14(int[] iArr) {
        return new EglBase14((EglBase14.Context) null, iArr);
    }

    public static EglBase createEgl14(android.opengl.EGLContext eGLContext, int[] iArr) {
        return new EglBase14(new EglBase14.Context(eGLContext), iArr);
    }

    public static Context getCurrentContext() {
        if (EglBase14.isEGL14Supported()) {
            return new EglBase14.Context(EGL14.eglGetCurrentContext());
        }
        return new EglBase10.Context(((EGL10) EGLContext.getEGL()).eglGetCurrentContext());
    }
}
