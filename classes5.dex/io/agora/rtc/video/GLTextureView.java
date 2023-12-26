package io.agora.rtc.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import io.agora.rtc.internal.Logging;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    private static final boolean LOG_ATTACH_DETACH = false;
    private static final boolean LOG_EGL = false;
    private static final boolean LOG_GL_STATE = false;
    private static final boolean LOG_PAUSE_RESUME = false;
    private static final boolean LOG_RENDERER = false;
    private static final boolean LOG_RENDERER_DRAW_FRAME = false;
    private static final boolean LOG_SURFACE = false;
    private static final boolean LOG_THREADS = false;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    private static final String TAG = "GLTextureView";
    /* access modifiers changed from: private */
    public static final GLThreadManager sGLThreadManager = new GLThreadManager();
    /* access modifiers changed from: private */
    public int mDebugFlags;
    private boolean mDetached;
    /* access modifiers changed from: private */
    public EGLConfigChooser mEGLConfigChooser;
    /* access modifiers changed from: private */
    public int mEGLContextClientVersion;
    /* access modifiers changed from: private */
    public EGLContextFactory mEGLContextFactory;
    /* access modifiers changed from: private */
    public EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    private GLThread mGLThread;
    /* access modifiers changed from: private */
    public GLWrapper mGLWrapper;
    /* access modifiers changed from: private */
    public boolean mPreserveEGLContextOnPause;
    /* access modifiers changed from: private */
    public Renderer mRenderer;
    private final WeakReference<GLTextureView> mThisWeakRef = new WeakReference<>(this);

    public interface EGLConfigChooser {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    public interface EGLContextFactory {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    public interface EGLWindowSurfaceFactory {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    public interface GLWrapper {
        GL wrap(GL gl);
    }

    public interface Renderer {
        void onDrawFrame(GL10 gl10);

        void onSurfaceChanged(GL10 gl10, int i, int i2);

        void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);

        void onSurfaceDestroyed(GL10 gl10);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public GLTextureView(Context context) {
        super(context);
        init();
    }

    public GLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            GLThread gLThread = this.mGLThread;
            if (gLThread != null) {
                gLThread.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public void setGLWrapper(GLWrapper gLWrapper) {
        this.mGLWrapper = gLWrapper;
    }

    public void setDebugFlags(int i) {
        this.mDebugFlags = i;
    }

    public int getDebugFlags() {
        return this.mDebugFlags;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.mPreserveEGLContextOnPause = z;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.mPreserveEGLContextOnPause;
    }

    public void setRenderer(Renderer renderer) {
        checkRenderThreadState();
        if (this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new SimpleEGLConfigChooser(true);
        }
        if (this.mEGLContextFactory == null) {
            this.mEGLContextFactory = new DefaultContextFactory();
        }
        if (this.mEGLWindowSurfaceFactory == null) {
            this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory();
        }
        this.mRenderer = renderer;
        GLThread gLThread = new GLThread(this.mThisWeakRef);
        this.mGLThread = gLThread;
        gLThread.start();
    }

    public void setEGLContextFactory(EGLContextFactory eGLContextFactory) {
        checkRenderThreadState();
        this.mEGLContextFactory = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        checkRenderThreadState();
        this.mEGLWindowSurfaceFactory = eGLWindowSurfaceFactory;
    }

    public void setEGLConfigChooser(EGLConfigChooser eGLConfigChooser) {
        checkRenderThreadState();
        this.mEGLConfigChooser = eGLConfigChooser;
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser((EGLConfigChooser) new SimpleEGLConfigChooser(z));
    }

    public void setEGLConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
        setEGLConfigChooser((EGLConfigChooser) new ComponentSizeChooser(i, i2, i3, i4, i5, i6));
    }

    public void setEGLContextClientVersion(int i) {
        checkRenderThreadState();
        this.mEGLContextClientVersion = i;
    }

    public void setRenderMode(int i) {
        this.mGLThread.setRenderMode(i);
    }

    public int getRenderMode() {
        return this.mGLThread.getRenderMode();
    }

    public void requestRender() {
        this.mGLThread.requestRender();
    }

    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.mGLThread.surfaceCreated();
    }

    public void surfaceDestroyed(SurfaceTexture surfaceTexture) {
        this.mGLThread.surfaceDestroyed();
    }

    public void surfaceChanged(SurfaceTexture surfaceTexture, int i, int i2, int i3) {
        this.mGLThread.onWindowResize(i2, i3);
    }

    public void onPause() {
        this.mGLThread.onPause();
    }

    public void onResume() {
        this.mGLThread.onResume();
    }

    public void queueEvent(Runnable runnable) {
        this.mGLThread.queueEvent(runnable);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDetached && this.mRenderer != null) {
            GLThread gLThread = this.mGLThread;
            int renderMode = gLThread != null ? gLThread.getRenderMode() : 1;
            GLThread gLThread2 = new GLThread(this.mThisWeakRef);
            this.mGLThread = gLThread2;
            if (renderMode != 1) {
                gLThread2.setRenderMode(renderMode);
            }
            this.mGLThread.start();
        }
        this.mDetached = false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        GLThread gLThread = this.mGLThread;
        if (gLThread != null) {
            gLThread.requestExitAndWait();
        }
        this.mDetached = true;
        super.onDetachedFromWindow();
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        surfaceChanged(getSurfaceTexture(), 0, i3 - i, i4 - i2);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        surfaceCreated(surfaceTexture);
        surfaceChanged(surfaceTexture, 0, i, i2);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        surfaceChanged(surfaceTexture, 0, i, i2);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        surfaceDestroyed(surfaceTexture);
        return true;
    }

    private class DefaultContextFactory implements EGLContextFactory {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private DefaultContextFactory() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, GLTextureView.this.mEGLContextClientVersion, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (GLTextureView.this.mEGLContextClientVersion == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Logging.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                EglHelper.throwEglException("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    private static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
        private DefaultWindowSurfaceFactory() {
        }

        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, (int[]) null);
            } catch (IllegalArgumentException e) {
                Logging.e(GLTextureView.TAG, "eglCreateWindowSurface", e);
                return null;
            }
        }

        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    private abstract class BaseConfigChooser implements EGLConfigChooser {
        protected int[] mConfigSpec;

        /* access modifiers changed from: package-private */
        public abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public BaseConfigChooser(int[] iArr) {
            this.mConfigSpec = filterConfigSpec(iArr);
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, (EGLConfig[]) null, 0, iArr)) {
                int i = iArr[0];
                if (i > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i];
                    if (egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, eGLConfigArr, i, iArr)) {
                        EGLConfig chooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
                        if (chooseConfig != null) {
                            return chooseConfig;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }

        private int[] filterConfigSpec(int[] iArr) {
            if (GLTextureView.this.mEGLContextClientVersion != 2) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[(length + 2)];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            iArr2[length] = 4;
            iArr2[length + 1] = 12344;
            return iArr2;
        }
    }

    private class ComponentSizeChooser extends BaseConfigChooser {
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue = new int[1];

        public ComponentSizeChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.mRedSize = i;
            this.mGreenSize = i2;
            this.mBlueSize = i3;
            this.mAlphaSize = i4;
            this.mDepthSize = i5;
            this.mStencilSize = i6;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                EGL10 egl102 = egl10;
                EGLDisplay eGLDisplay2 = eGLDisplay;
                EGLConfig eGLConfig2 = eGLConfig;
                int findConfigAttrib = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, 12325, 0);
                int findConfigAttrib2 = findConfigAttrib(egl102, eGLDisplay2, eGLConfig2, 12326, 0);
                if (findConfigAttrib >= this.mDepthSize && findConfigAttrib2 >= this.mStencilSize) {
                    EGL10 egl103 = egl10;
                    EGLDisplay eGLDisplay3 = eGLDisplay;
                    EGLConfig eGLConfig3 = eGLConfig;
                    int findConfigAttrib3 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12324, 0);
                    int findConfigAttrib4 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12323, 0);
                    int findConfigAttrib5 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12322, 0);
                    int findConfigAttrib6 = findConfigAttrib(egl103, eGLDisplay3, eGLConfig3, 12321, 0);
                    if (findConfigAttrib3 == this.mRedSize && findConfigAttrib4 == this.mGreenSize && findConfigAttrib5 == this.mBlueSize && findConfigAttrib6 == this.mAlphaSize) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue) ? this.mValue[0] : i2;
        }
    }

    private class SimpleEGLConfigChooser extends ComponentSizeChooser {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SimpleEGLConfigChooser(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    private static class EglHelper {
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        private WeakReference<GLTextureView> mGLSurfaceViewWeakRef;

        public EglHelper(WeakReference<GLTextureView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        public void start() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.mEgl = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.mEglDisplay = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.mEgl.eglInitialize(this.mEglDisplay, new int[2])) {
                    GLTextureView gLTextureView = (GLTextureView) this.mGLSurfaceViewWeakRef.get();
                    if (gLTextureView == null) {
                        this.mEglConfig = null;
                        this.mEglContext = null;
                    } else {
                        this.mEglConfig = gLTextureView.mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
                        this.mEglContext = gLTextureView.mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
                    }
                    EGLContext eGLContext = this.mEglContext;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.mEglContext = null;
                        throwEglException("createContext");
                    }
                    this.mEglSurface = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public boolean createSurface() {
            if (this.mEgl == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.mEglDisplay == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.mEglConfig != null) {
                destroySurfaceImp();
                GLTextureView gLTextureView = (GLTextureView) this.mGLSurfaceViewWeakRef.get();
                if (gLTextureView != null) {
                    this.mEglSurface = gLTextureView.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, gLTextureView.getSurfaceTexture());
                } else {
                    this.mEglSurface = null;
                }
                EGLSurface eGLSurface = this.mEglSurface;
                if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                    if (this.mEgl.eglGetError() == 12299) {
                        Logging.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    return false;
                }
                EGL10 egl10 = this.mEgl;
                EGLDisplay eGLDisplay = this.mEglDisplay;
                EGLSurface eGLSurface2 = this.mEglSurface;
                if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.mEglContext)) {
                    return true;
                }
                logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
                return false;
            } else {
                throw new RuntimeException("mEglConfig not initialized");
            }
        }

        /* access modifiers changed from: package-private */
        public GL createGL() {
            GL gl = this.mEglContext.getGL();
            GLTextureView gLTextureView = (GLTextureView) this.mGLSurfaceViewWeakRef.get();
            if (gLTextureView == null) {
                return gl;
            }
            if (gLTextureView.mGLWrapper != null) {
                gl = gLTextureView.mGLWrapper.wrap(gl);
            }
            if ((gLTextureView.mDebugFlags & 3) == 0) {
                return gl;
            }
            int i = 0;
            LogWriter logWriter = null;
            if ((gLTextureView.mDebugFlags & 1) != 0) {
                i = 1;
            }
            if ((gLTextureView.mDebugFlags & 2) != 0) {
                logWriter = new LogWriter();
            }
            return GLDebugHelper.wrap(gl, i, logWriter);
        }

        public int swap() {
            if (!this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
                return this.mEgl.eglGetError();
            }
            return 12288;
        }

        public void destroySurface() {
            destroySurfaceImp();
        }

        private void destroySurfaceImp() {
            EGLSurface eGLSurface = this.mEglSurface;
            if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                this.mEgl.eglMakeCurrent(this.mEglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                GLTextureView gLTextureView = (GLTextureView) this.mGLSurfaceViewWeakRef.get();
                if (gLTextureView != null) {
                    gLTextureView.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
                }
                this.mEglSurface = null;
            }
        }

        public void finish() {
            if (this.mEglContext != null) {
                GLTextureView gLTextureView = (GLTextureView) this.mGLSurfaceViewWeakRef.get();
                if (gLTextureView != null) {
                    gLTextureView.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
                }
                this.mEglContext = null;
            }
            EGLDisplay eGLDisplay = this.mEglDisplay;
            if (eGLDisplay != null) {
                this.mEgl.eglTerminate(eGLDisplay);
                this.mEglDisplay = null;
            }
        }

        private void throwEglException(String str) {
            throwEglException(str, this.mEgl.eglGetError());
        }

        public static void throwEglException(String str, int i) {
            throw new RuntimeException(formatEglError(str, i));
        }

        public static void logEglErrorAsWarning(String str, String str2, int i) {
            Logging.w(str, formatEglError(str2, i));
        }

        public static String formatEglError(String str, int i) {
            return str + " failed: " + i;
        }
    }

    static class GLThread extends Thread {
        private EglHelper mEglHelper;
        private ArrayList<Runnable> mEventQueue = new ArrayList<>();
        /* access modifiers changed from: private */
        public boolean mExited;
        private WeakReference<GLTextureView> mGLSurfaceViewWeakRef;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private int mHeight = 0;
        private boolean mPaused;
        private boolean mRenderComplete;
        private int mRenderMode = 1;
        private boolean mRequestPaused;
        private boolean mRequestRender = true;
        private boolean mShouldExit;
        private boolean mShouldReleaseEglContext;
        private boolean mSizeChanged = true;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private int mWidth = 0;

        GLThread(WeakReference<GLTextureView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        public void run() {
            setName("GLThread " + getId());
            try {
                guardedRun();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                GLTextureView.sGLThreadManager.threadExiting(this);
                throw th;
            }
            GLTextureView.sGLThreadManager.threadExiting(this);
        }

        private void stopEglSurfaceLocked() {
            if (this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.mEglHelper.destroySurface();
            }
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.mEglHelper.finish();
                this.mHaveEglContext = false;
                GLTextureView.sGLThreadManager.releaseEglContextLocked(this);
            }
        }

        /* JADX WARNING: type inference failed for: r2v24, types: [javax.microedition.khronos.opengles.GL] */
        /* JADX WARNING: Code restructure failed: missing block: B:100:0x0160, code lost:
            r2 = io.agora.rtc.video.GLTextureView.access$800();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x0164, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:?, code lost:
            r1.mSurfaceIsBad = true;
            io.agora.rtc.video.GLTextureView.access$800().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:0x016f, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x0175, code lost:
            r8 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:112:0x0176, code lost:
            if (r9 == false) goto L_0x0189;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x0178, code lost:
            r6 = r1.mEglHelper.createGL();
            io.agora.rtc.video.GLTextureView.access$800().checkGLDriver(r6);
            r9 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x0189, code lost:
            if (r7 == false) goto L_0x01a1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x018b, code lost:
            r2 = (io.agora.rtc.video.GLTextureView) r1.mGLSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x0193, code lost:
            if (r2 == null) goto L_0x01a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x0195, code lost:
            io.agora.rtc.video.GLTextureView.access$1000(r2).onSurfaceCreated(r6, r1.mEglHelper.mEglConfig);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x01a0, code lost:
            r7 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x01a1, code lost:
            if (r10 == false) goto L_0x01b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x01a3, code lost:
            r2 = (io.agora.rtc.video.GLTextureView) r1.mGLSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:121:0x01ab, code lost:
            if (r2 == null) goto L_0x01b4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x01ad, code lost:
            io.agora.rtc.video.GLTextureView.access$1000(r2).onSurfaceChanged(r6, r11, r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x01b4, code lost:
            r10 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x01b5, code lost:
            r2 = (io.agora.rtc.video.GLTextureView) r1.mGLSurfaceViewWeakRef.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x01bd, code lost:
            if (r2 == null) goto L_0x01c6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x01bf, code lost:
            io.agora.rtc.video.GLTextureView.access$1000(r2).onDrawFrame(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x01c6, code lost:
            r2 = r1.mEglHelper.swap();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x01ce, code lost:
            if (r2 == 12288) goto L_0x01f2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:0x01d2, code lost:
            if (r2 == 12302) goto L_0x01ef;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x01d4, code lost:
            io.agora.rtc.video.GLTextureView.EglHelper.logEglErrorAsWarning("GLThread", "eglSwapBuffers", r2);
            r2 = io.agora.rtc.video.GLTextureView.access$800();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x01df, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x01e0, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:135:?, code lost:
            r1.mSurfaceIsBad = true;
            io.agora.rtc.video.GLTextureView.access$800().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:0x01ea, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x01ef, code lost:
            r0 = true;
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:143:0x01f2, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x01f3, code lost:
            if (r13 == false) goto L_0x01f6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x01f5, code lost:
            r4 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x014f, code lost:
            if (r14 == null) goto L_0x0156;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x0156, code lost:
            if (r8 == false) goto L_0x0176;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x015e, code lost:
            if (r1.mEglHelper.createSurface() != false) goto L_0x0175;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void guardedRun() throws java.lang.InterruptedException {
            /*
                r16 = this;
                r1 = r16
                io.agora.rtc.video.GLTextureView$EglHelper r0 = new io.agora.rtc.video.GLTextureView$EglHelper
                java.lang.ref.WeakReference<io.agora.rtc.video.GLTextureView> r2 = r1.mGLSurfaceViewWeakRef
                r0.<init>(r2)
                r1.mEglHelper = r0
                r0 = 0
                r1.mHaveEglContext = r0
                r1.mHaveEglSurface = r0
                r3 = r0
                r4 = r3
                r5 = r4
                r7 = r5
                r8 = r7
                r9 = r8
                r10 = r9
                r11 = r10
                r12 = r11
                r13 = r12
                r6 = 0
            L_0x001b:
                r14 = 0
            L_0x001c:
                io.agora.rtc.video.GLTextureView$GLThreadManager r15 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0206 }
                monitor-enter(r15)     // Catch:{ all -> 0x0206 }
            L_0x0021:
                boolean r2 = r1.mShouldExit     // Catch:{ all -> 0x0203 }
                if (r2 == 0) goto L_0x0036
                monitor-exit(r15)     // Catch:{ all -> 0x0203 }
                io.agora.rtc.video.GLTextureView$GLThreadManager r2 = io.agora.rtc.video.GLTextureView.sGLThreadManager
                monitor-enter(r2)
                r16.stopEglSurfaceLocked()     // Catch:{ all -> 0x0033 }
                r16.stopEglContextLocked()     // Catch:{ all -> 0x0033 }
                monitor-exit(r2)     // Catch:{ all -> 0x0033 }
                return
            L_0x0033:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0033 }
                throw r0
            L_0x0036:
                java.util.ArrayList<java.lang.Runnable> r2 = r1.mEventQueue     // Catch:{ all -> 0x0203 }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0203 }
                if (r2 != 0) goto L_0x004b
                java.util.ArrayList<java.lang.Runnable> r2 = r1.mEventQueue     // Catch:{ all -> 0x0203 }
                r14 = 0
                java.lang.Object r2 = r2.remove(r14)     // Catch:{ all -> 0x0203 }
                r14 = r2
                java.lang.Runnable r14 = (java.lang.Runnable) r14     // Catch:{ all -> 0x0203 }
                r0 = 0
                goto L_0x014e
            L_0x004b:
                boolean r2 = r1.mPaused     // Catch:{ all -> 0x0203 }
                boolean r0 = r1.mRequestPaused     // Catch:{ all -> 0x0203 }
                if (r2 == r0) goto L_0x005b
                r1.mPaused = r0     // Catch:{ all -> 0x0203 }
                io.agora.rtc.video.GLTextureView$GLThreadManager r2 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0203 }
                r2.notifyAll()     // Catch:{ all -> 0x0203 }
                goto L_0x005c
            L_0x005b:
                r0 = 0
            L_0x005c:
                boolean r2 = r1.mShouldReleaseEglContext     // Catch:{ all -> 0x0203 }
                if (r2 == 0) goto L_0x006a
                r16.stopEglSurfaceLocked()     // Catch:{ all -> 0x0203 }
                r16.stopEglContextLocked()     // Catch:{ all -> 0x0203 }
                r2 = 0
                r1.mShouldReleaseEglContext = r2     // Catch:{ all -> 0x0203 }
                r5 = 1
            L_0x006a:
                if (r3 == 0) goto L_0x0073
                r16.stopEglSurfaceLocked()     // Catch:{ all -> 0x0203 }
                r16.stopEglContextLocked()     // Catch:{ all -> 0x0203 }
                r3 = 0
            L_0x0073:
                if (r0 == 0) goto L_0x007c
                boolean r2 = r1.mHaveEglSurface     // Catch:{ all -> 0x0203 }
                if (r2 == 0) goto L_0x007c
                r16.stopEglSurfaceLocked()     // Catch:{ all -> 0x0203 }
            L_0x007c:
                if (r0 == 0) goto L_0x00a1
                boolean r2 = r1.mHaveEglContext     // Catch:{ all -> 0x0203 }
                if (r2 == 0) goto L_0x00a1
                java.lang.ref.WeakReference<io.agora.rtc.video.GLTextureView> r2 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x0203 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0203 }
                io.agora.rtc.video.GLTextureView r2 = (io.agora.rtc.video.GLTextureView) r2     // Catch:{ all -> 0x0203 }
                if (r2 != 0) goto L_0x008e
                r2 = 0
                goto L_0x0092
            L_0x008e:
                boolean r2 = r2.mPreserveEGLContextOnPause     // Catch:{ all -> 0x0203 }
            L_0x0092:
                if (r2 == 0) goto L_0x009e
                io.agora.rtc.video.GLTextureView$GLThreadManager r2 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0203 }
                boolean r2 = r2.shouldReleaseEGLContextWhenPausing()     // Catch:{ all -> 0x0203 }
                if (r2 == 0) goto L_0x00a1
            L_0x009e:
                r16.stopEglContextLocked()     // Catch:{ all -> 0x0203 }
            L_0x00a1:
                if (r0 == 0) goto L_0x00b2
                io.agora.rtc.video.GLTextureView$GLThreadManager r0 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0203 }
                boolean r0 = r0.shouldTerminateEGLWhenPausing()     // Catch:{ all -> 0x0203 }
                if (r0 == 0) goto L_0x00b2
                io.agora.rtc.video.GLTextureView$EglHelper r0 = r1.mEglHelper     // Catch:{ all -> 0x0203 }
                r0.finish()     // Catch:{ all -> 0x0203 }
            L_0x00b2:
                boolean r0 = r1.mHasSurface     // Catch:{ all -> 0x0203 }
                if (r0 != 0) goto L_0x00ce
                boolean r0 = r1.mWaitingForSurface     // Catch:{ all -> 0x0203 }
                if (r0 != 0) goto L_0x00ce
                boolean r0 = r1.mHaveEglSurface     // Catch:{ all -> 0x0203 }
                if (r0 == 0) goto L_0x00c1
                r16.stopEglSurfaceLocked()     // Catch:{ all -> 0x0203 }
            L_0x00c1:
                r0 = 1
                r1.mWaitingForSurface = r0     // Catch:{ all -> 0x0203 }
                r0 = 0
                r1.mSurfaceIsBad = r0     // Catch:{ all -> 0x0203 }
                io.agora.rtc.video.GLTextureView$GLThreadManager r0 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0203 }
                r0.notifyAll()     // Catch:{ all -> 0x0203 }
            L_0x00ce:
                boolean r0 = r1.mHasSurface     // Catch:{ all -> 0x0203 }
                if (r0 == 0) goto L_0x00e0
                boolean r0 = r1.mWaitingForSurface     // Catch:{ all -> 0x0203 }
                if (r0 == 0) goto L_0x00e0
                r0 = 0
                r1.mWaitingForSurface = r0     // Catch:{ all -> 0x0203 }
                io.agora.rtc.video.GLTextureView$GLThreadManager r0 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0203 }
                r0.notifyAll()     // Catch:{ all -> 0x0203 }
            L_0x00e0:
                if (r4 == 0) goto L_0x00ee
                r0 = 1
                r1.mRenderComplete = r0     // Catch:{ all -> 0x0203 }
                io.agora.rtc.video.GLTextureView$GLThreadManager r0 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0203 }
                r0.notifyAll()     // Catch:{ all -> 0x0203 }
                r4 = 0
                r13 = 0
            L_0x00ee:
                boolean r0 = r16.readyToDraw()     // Catch:{ all -> 0x0203 }
                if (r0 == 0) goto L_0x01f9
                boolean r0 = r1.mHaveEglContext     // Catch:{ all -> 0x0203 }
                if (r0 != 0) goto L_0x0120
                if (r5 == 0) goto L_0x00fc
                r5 = 0
                goto L_0x0120
            L_0x00fc:
                io.agora.rtc.video.GLTextureView$GLThreadManager r0 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0203 }
                boolean r0 = r0.tryAcquireEglContextLocked(r1)     // Catch:{ all -> 0x0203 }
                if (r0 == 0) goto L_0x0120
                io.agora.rtc.video.GLTextureView$EglHelper r0 = r1.mEglHelper     // Catch:{ RuntimeException -> 0x0117 }
                r0.start()     // Catch:{ RuntimeException -> 0x0117 }
                r0 = 1
                r1.mHaveEglContext = r0     // Catch:{ all -> 0x0203 }
                io.agora.rtc.video.GLTextureView$GLThreadManager r0 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0203 }
                r0.notifyAll()     // Catch:{ all -> 0x0203 }
                r7 = 1
                goto L_0x0120
            L_0x0117:
                r0 = move-exception
                io.agora.rtc.video.GLTextureView$GLThreadManager r2 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0203 }
                r2.releaseEglContextLocked(r1)     // Catch:{ all -> 0x0203 }
                throw r0     // Catch:{ all -> 0x0203 }
            L_0x0120:
                boolean r0 = r1.mHaveEglContext     // Catch:{ all -> 0x0203 }
                if (r0 == 0) goto L_0x012e
                boolean r0 = r1.mHaveEglSurface     // Catch:{ all -> 0x0203 }
                if (r0 != 0) goto L_0x012e
                r0 = 1
                r1.mHaveEglSurface = r0     // Catch:{ all -> 0x0203 }
                r8 = 1
                r9 = 1
                r10 = 1
            L_0x012e:
                boolean r0 = r1.mHaveEglSurface     // Catch:{ all -> 0x0203 }
                if (r0 == 0) goto L_0x01f9
                boolean r0 = r1.mSizeChanged     // Catch:{ all -> 0x0203 }
                if (r0 == 0) goto L_0x0144
                int r0 = r1.mWidth     // Catch:{ all -> 0x0203 }
                int r2 = r1.mHeight     // Catch:{ all -> 0x0203 }
                r8 = 0
                r1.mSizeChanged = r8     // Catch:{ all -> 0x0203 }
                r11 = r0
                r12 = r2
                r0 = r8
                r8 = 1
                r10 = 1
                r13 = 1
                goto L_0x0145
            L_0x0144:
                r0 = 0
            L_0x0145:
                r1.mRequestRender = r0     // Catch:{ all -> 0x0203 }
                io.agora.rtc.video.GLTextureView$GLThreadManager r2 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0203 }
                r2.notifyAll()     // Catch:{ all -> 0x0203 }
            L_0x014e:
                monitor-exit(r15)     // Catch:{ all -> 0x0203 }
                if (r14 == 0) goto L_0x0156
                r14.run()     // Catch:{ all -> 0x0206 }
                goto L_0x001b
            L_0x0156:
                if (r8 == 0) goto L_0x0176
                io.agora.rtc.video.GLTextureView$EglHelper r2 = r1.mEglHelper     // Catch:{ all -> 0x0206 }
                boolean r2 = r2.createSurface()     // Catch:{ all -> 0x0206 }
                if (r2 != 0) goto L_0x0175
                io.agora.rtc.video.GLTextureView$GLThreadManager r2 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0206 }
                monitor-enter(r2)     // Catch:{ all -> 0x0206 }
                r15 = 1
                r1.mSurfaceIsBad = r15     // Catch:{ all -> 0x0172 }
                io.agora.rtc.video.GLTextureView$GLThreadManager r15 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0172 }
                r15.notifyAll()     // Catch:{ all -> 0x0172 }
                monitor-exit(r2)     // Catch:{ all -> 0x0172 }
                goto L_0x001c
            L_0x0172:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0172 }
                throw r0     // Catch:{ all -> 0x0206 }
            L_0x0175:
                r8 = r0
            L_0x0176:
                if (r9 == 0) goto L_0x0189
                io.agora.rtc.video.GLTextureView$EglHelper r2 = r1.mEglHelper     // Catch:{ all -> 0x0206 }
                javax.microedition.khronos.opengles.GL r2 = r2.createGL()     // Catch:{ all -> 0x0206 }
                r6 = r2
                javax.microedition.khronos.opengles.GL10 r6 = (javax.microedition.khronos.opengles.GL10) r6     // Catch:{ all -> 0x0206 }
                io.agora.rtc.video.GLTextureView$GLThreadManager r2 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0206 }
                r2.checkGLDriver(r6)     // Catch:{ all -> 0x0206 }
                r9 = r0
            L_0x0189:
                if (r7 == 0) goto L_0x01a1
                java.lang.ref.WeakReference<io.agora.rtc.video.GLTextureView> r2 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x0206 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0206 }
                io.agora.rtc.video.GLTextureView r2 = (io.agora.rtc.video.GLTextureView) r2     // Catch:{ all -> 0x0206 }
                if (r2 == 0) goto L_0x01a0
                io.agora.rtc.video.GLTextureView$Renderer r2 = r2.mRenderer     // Catch:{ all -> 0x0206 }
                io.agora.rtc.video.GLTextureView$EglHelper r7 = r1.mEglHelper     // Catch:{ all -> 0x0206 }
                javax.microedition.khronos.egl.EGLConfig r7 = r7.mEglConfig     // Catch:{ all -> 0x0206 }
                r2.onSurfaceCreated(r6, r7)     // Catch:{ all -> 0x0206 }
            L_0x01a0:
                r7 = r0
            L_0x01a1:
                if (r10 == 0) goto L_0x01b5
                java.lang.ref.WeakReference<io.agora.rtc.video.GLTextureView> r2 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x0206 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0206 }
                io.agora.rtc.video.GLTextureView r2 = (io.agora.rtc.video.GLTextureView) r2     // Catch:{ all -> 0x0206 }
                if (r2 == 0) goto L_0x01b4
                io.agora.rtc.video.GLTextureView$Renderer r2 = r2.mRenderer     // Catch:{ all -> 0x0206 }
                r2.onSurfaceChanged(r6, r11, r12)     // Catch:{ all -> 0x0206 }
            L_0x01b4:
                r10 = r0
            L_0x01b5:
                java.lang.ref.WeakReference<io.agora.rtc.video.GLTextureView> r2 = r1.mGLSurfaceViewWeakRef     // Catch:{ all -> 0x0206 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0206 }
                io.agora.rtc.video.GLTextureView r2 = (io.agora.rtc.video.GLTextureView) r2     // Catch:{ all -> 0x0206 }
                if (r2 == 0) goto L_0x01c6
                io.agora.rtc.video.GLTextureView$Renderer r2 = r2.mRenderer     // Catch:{ all -> 0x0206 }
                r2.onDrawFrame(r6)     // Catch:{ all -> 0x0206 }
            L_0x01c6:
                io.agora.rtc.video.GLTextureView$EglHelper r2 = r1.mEglHelper     // Catch:{ all -> 0x0206 }
                int r2 = r2.swap()     // Catch:{ all -> 0x0206 }
                r15 = 12288(0x3000, float:1.7219E-41)
                if (r2 == r15) goto L_0x01f2
                r15 = 12302(0x300e, float:1.7239E-41)
                if (r2 == r15) goto L_0x01ef
                java.lang.String r15 = "GLThread"
                java.lang.String r0 = "eglSwapBuffers"
                io.agora.rtc.video.GLTextureView.EglHelper.logEglErrorAsWarning(r15, r0, r2)     // Catch:{ all -> 0x0206 }
                io.agora.rtc.video.GLTextureView$GLThreadManager r2 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0206 }
                monitor-enter(r2)     // Catch:{ all -> 0x0206 }
                r0 = 1
                r1.mSurfaceIsBad = r0     // Catch:{ all -> 0x01ec }
                io.agora.rtc.video.GLTextureView$GLThreadManager r15 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x01ec }
                r15.notifyAll()     // Catch:{ all -> 0x01ec }
                monitor-exit(r2)     // Catch:{ all -> 0x01ec }
                goto L_0x01f3
            L_0x01ec:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x01ec }
                throw r0     // Catch:{ all -> 0x0206 }
            L_0x01ef:
                r0 = 1
                r3 = r0
                goto L_0x01f3
            L_0x01f2:
                r0 = 1
            L_0x01f3:
                if (r13 == 0) goto L_0x01f6
                r4 = r0
            L_0x01f6:
                r0 = 0
                goto L_0x001c
            L_0x01f9:
                io.agora.rtc.video.GLTextureView$GLThreadManager r0 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0203 }
                r0.wait()     // Catch:{ all -> 0x0203 }
                r0 = 0
                goto L_0x0021
            L_0x0203:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x0203 }
                throw r0     // Catch:{ all -> 0x0206 }
            L_0x0206:
                r0 = move-exception
                io.agora.rtc.video.GLTextureView$GLThreadManager r2 = io.agora.rtc.video.GLTextureView.sGLThreadManager
                monitor-enter(r2)
                r16.stopEglSurfaceLocked()     // Catch:{ all -> 0x0214 }
                r16.stopEglContextLocked()     // Catch:{ all -> 0x0214 }
                monitor-exit(r2)     // Catch:{ all -> 0x0214 }
                throw r0
            L_0x0214:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0214 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.video.GLTextureView.GLThread.guardedRun():void");
        }

        public boolean ableToDraw() {
            return this.mHaveEglContext && this.mHaveEglSurface && readyToDraw();
        }

        private boolean readyToDraw() {
            return !this.mPaused && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (GLTextureView.sGLThreadManager) {
                this.mRenderMode = i;
                GLTextureView.sGLThreadManager.notifyAll();
            }
        }

        public int getRenderMode() {
            int i;
            synchronized (GLTextureView.sGLThreadManager) {
                i = this.mRenderMode;
            }
            return i;
        }

        public void requestRender() {
            synchronized (GLTextureView.sGLThreadManager) {
                this.mRequestRender = true;
                GLTextureView.sGLThreadManager.notifyAll();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|22|18|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void surfaceCreated() {
            /*
                r2 = this;
                io.agora.rtc.video.GLTextureView$GLThreadManager r0 = io.agora.rtc.video.GLTextureView.sGLThreadManager
                monitor-enter(r0)
                r1 = 1
                r2.mHasSurface = r1     // Catch:{ all -> 0x0029 }
                io.agora.rtc.video.GLTextureView$GLThreadManager r1 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0029 }
                r1.notifyAll()     // Catch:{ all -> 0x0029 }
            L_0x000f:
                boolean r1 = r2.mWaitingForSurface     // Catch:{ all -> 0x0029 }
                if (r1 == 0) goto L_0x0027
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                io.agora.rtc.video.GLTextureView$GLThreadManager r1 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ InterruptedException -> 0x001f }
                r1.wait()     // Catch:{ InterruptedException -> 0x001f }
                goto L_0x000f
            L_0x001f:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0029 }
                r1.interrupt()     // Catch:{ all -> 0x0029 }
                goto L_0x000f
            L_0x0027:
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                return
            L_0x0029:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.video.GLTextureView.GLThread.surfaceCreated():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|22|18|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void surfaceDestroyed() {
            /*
                r2 = this;
                io.agora.rtc.video.GLTextureView$GLThreadManager r0 = io.agora.rtc.video.GLTextureView.sGLThreadManager
                monitor-enter(r0)
                r1 = 0
                r2.mHasSurface = r1     // Catch:{ all -> 0x0029 }
                io.agora.rtc.video.GLTextureView$GLThreadManager r1 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0029 }
                r1.notifyAll()     // Catch:{ all -> 0x0029 }
            L_0x000f:
                boolean r1 = r2.mWaitingForSurface     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                io.agora.rtc.video.GLTextureView$GLThreadManager r1 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ InterruptedException -> 0x001f }
                r1.wait()     // Catch:{ InterruptedException -> 0x001f }
                goto L_0x000f
            L_0x001f:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0029 }
                r1.interrupt()     // Catch:{ all -> 0x0029 }
                goto L_0x000f
            L_0x0027:
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                return
            L_0x0029:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.video.GLTextureView.GLThread.surfaceDestroyed():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|22|18|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPause() {
            /*
                r2 = this;
                io.agora.rtc.video.GLTextureView$GLThreadManager r0 = io.agora.rtc.video.GLTextureView.sGLThreadManager
                monitor-enter(r0)
                r1 = 1
                r2.mRequestPaused = r1     // Catch:{ all -> 0x0029 }
                io.agora.rtc.video.GLTextureView$GLThreadManager r1 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0029 }
                r1.notifyAll()     // Catch:{ all -> 0x0029 }
            L_0x000f:
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                boolean r1 = r2.mPaused     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0027
                io.agora.rtc.video.GLTextureView$GLThreadManager r1 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ InterruptedException -> 0x001f }
                r1.wait()     // Catch:{ InterruptedException -> 0x001f }
                goto L_0x000f
            L_0x001f:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0029 }
                r1.interrupt()     // Catch:{ all -> 0x0029 }
                goto L_0x000f
            L_0x0027:
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                return
            L_0x0029:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0029 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.video.GLTextureView.GLThread.onPause():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|25|20|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0014, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0028 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onResume() {
            /*
                r3 = this;
                io.agora.rtc.video.GLTextureView$GLThreadManager r0 = io.agora.rtc.video.GLTextureView.sGLThreadManager
                monitor-enter(r0)
                r1 = 0
                r3.mRequestPaused = r1     // Catch:{ all -> 0x0032 }
                r2 = 1
                r3.mRequestRender = r2     // Catch:{ all -> 0x0032 }
                r3.mRenderComplete = r1     // Catch:{ all -> 0x0032 }
                io.agora.rtc.video.GLTextureView$GLThreadManager r1 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0032 }
                r1.notifyAll()     // Catch:{ all -> 0x0032 }
            L_0x0014:
                boolean r1 = r3.mExited     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                boolean r1 = r3.mPaused     // Catch:{ all -> 0x0032 }
                if (r1 == 0) goto L_0x0030
                boolean r1 = r3.mRenderComplete     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                io.agora.rtc.video.GLTextureView$GLThreadManager r1 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ InterruptedException -> 0x0028 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0028 }
                goto L_0x0014
            L_0x0028:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0032 }
                r1.interrupt()     // Catch:{ all -> 0x0032 }
                goto L_0x0014
            L_0x0030:
                monitor-exit(r0)     // Catch:{ all -> 0x0032 }
                return
            L_0x0032:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0032 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.video.GLTextureView.GLThread.onResume():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:12|13|14|15|27|21|4) */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0018, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0032 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onWindowResize(int r2, int r3) {
            /*
                r1 = this;
                io.agora.rtc.video.GLTextureView$GLThreadManager r0 = io.agora.rtc.video.GLTextureView.sGLThreadManager
                monitor-enter(r0)
                r1.mWidth = r2     // Catch:{ all -> 0x003c }
                r1.mHeight = r3     // Catch:{ all -> 0x003c }
                r2 = 1
                r1.mSizeChanged = r2     // Catch:{ all -> 0x003c }
                r1.mRequestRender = r2     // Catch:{ all -> 0x003c }
                r2 = 0
                r1.mRenderComplete = r2     // Catch:{ all -> 0x003c }
                io.agora.rtc.video.GLTextureView$GLThreadManager r2 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x003c }
                r2.notifyAll()     // Catch:{ all -> 0x003c }
            L_0x0018:
                boolean r2 = r1.mExited     // Catch:{ all -> 0x003c }
                if (r2 != 0) goto L_0x003a
                boolean r2 = r1.mPaused     // Catch:{ all -> 0x003c }
                if (r2 != 0) goto L_0x003a
                boolean r2 = r1.mRenderComplete     // Catch:{ all -> 0x003c }
                if (r2 != 0) goto L_0x003a
                boolean r2 = r1.ableToDraw()     // Catch:{ all -> 0x003c }
                if (r2 == 0) goto L_0x003a
                io.agora.rtc.video.GLTextureView$GLThreadManager r2 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ InterruptedException -> 0x0032 }
                r2.wait()     // Catch:{ InterruptedException -> 0x0032 }
                goto L_0x0018
            L_0x0032:
                java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x003c }
                r2.interrupt()     // Catch:{ all -> 0x003c }
                goto L_0x0018
            L_0x003a:
                monitor-exit(r0)     // Catch:{ all -> 0x003c }
                return
            L_0x003c:
                r2 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x003c }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.video.GLTextureView.GLThread.onWindowResize(int, int):void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|9|10|19|16|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void requestExitAndWait() {
            /*
                r2 = this;
                io.agora.rtc.video.GLTextureView$GLThreadManager r0 = io.agora.rtc.video.GLTextureView.sGLThreadManager
                monitor-enter(r0)
                r1 = 1
                r2.mShouldExit = r1     // Catch:{ all -> 0x0025 }
                io.agora.rtc.video.GLTextureView$GLThreadManager r1 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ all -> 0x0025 }
                r1.notifyAll()     // Catch:{ all -> 0x0025 }
            L_0x000f:
                boolean r1 = r2.mExited     // Catch:{ all -> 0x0025 }
                if (r1 != 0) goto L_0x0023
                io.agora.rtc.video.GLTextureView$GLThreadManager r1 = io.agora.rtc.video.GLTextureView.sGLThreadManager     // Catch:{ InterruptedException -> 0x001b }
                r1.wait()     // Catch:{ InterruptedException -> 0x001b }
                goto L_0x000f
            L_0x001b:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0025 }
                r1.interrupt()     // Catch:{ all -> 0x0025 }
                goto L_0x000f
            L_0x0023:
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                return
            L_0x0025:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.video.GLTextureView.GLThread.requestExitAndWait():void");
        }

        public void requestReleaseEglContextLocked() {
            this.mShouldReleaseEglContext = true;
            GLTextureView.sGLThreadManager.notifyAll();
        }

        public void queueEvent(Runnable runnable) {
            if (runnable != null) {
                synchronized (GLTextureView.sGLThreadManager) {
                    this.mEventQueue.add(runnable);
                    GLTextureView.sGLThreadManager.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }
    }

    static class LogWriter extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        LogWriter() {
        }

        public void close() {
            flushBuilder();
        }

        public void flush() {
            flushBuilder();
        }

        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c = cArr[i + i3];
                if (c == 10) {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c);
                }
            }
        }

        private void flushBuilder() {
            if (this.mBuilder.length() > 0) {
                Logging.d(GLTextureView.TAG, this.mBuilder.toString());
                StringBuilder sb = this.mBuilder;
                sb.delete(0, sb.length());
            }
        }
    }

    private void checkRenderThreadState() {
        if (this.mGLThread != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private static class GLThreadManager {
        private static String TAG = "GLThreadManager";
        private static final int kGLES_20 = 131072;
        private static final String kMSM7K_RENDERER_PREFIX = "Q3Dimension MSM7500 ";
        private GLThread mEglOwner;
        private boolean mGLESDriverCheckComplete;
        private int mGLESVersion;
        private boolean mGLESVersionCheckComplete;
        private boolean mLimitedGLESContexts;
        private boolean mMultipleGLESContextsAllowed;

        private GLThreadManager() {
        }

        public synchronized void threadExiting(GLThread gLThread) {
            boolean unused = gLThread.mExited = true;
            if (this.mEglOwner == gLThread) {
                this.mEglOwner = null;
            }
            notifyAll();
        }

        public boolean tryAcquireEglContextLocked(GLThread gLThread) {
            GLThread gLThread2 = this.mEglOwner;
            if (gLThread2 == gLThread || gLThread2 == null) {
                this.mEglOwner = gLThread;
                notifyAll();
                return true;
            }
            checkGLESVersion();
            if (this.mMultipleGLESContextsAllowed) {
                return true;
            }
            GLThread gLThread3 = this.mEglOwner;
            if (gLThread3 == null) {
                return false;
            }
            gLThread3.requestReleaseEglContextLocked();
            return false;
        }

        public void releaseEglContextLocked(GLThread gLThread) {
            if (this.mEglOwner == gLThread) {
                this.mEglOwner = null;
            }
            notifyAll();
        }

        public synchronized boolean shouldReleaseEGLContextWhenPausing() {
            return this.mLimitedGLESContexts;
        }

        public synchronized boolean shouldTerminateEGLWhenPausing() {
            checkGLESVersion();
            return !this.mMultipleGLESContextsAllowed;
        }

        public synchronized void checkGLDriver(GL10 gl10) {
            if (!this.mGLESDriverCheckComplete) {
                checkGLESVersion();
                String glGetString = gl10.glGetString(7937);
                boolean z = false;
                if (this.mGLESVersion < 131072) {
                    this.mMultipleGLESContextsAllowed = !glGetString.startsWith(kMSM7K_RENDERER_PREFIX);
                    notifyAll();
                }
                if (!this.mMultipleGLESContextsAllowed) {
                    z = true;
                }
                this.mLimitedGLESContexts = z;
                this.mGLESDriverCheckComplete = true;
            }
        }

        private void checkGLESVersion() {
            if (!this.mGLESVersionCheckComplete) {
                this.mGLESVersionCheckComplete = true;
            }
        }
    }
}
