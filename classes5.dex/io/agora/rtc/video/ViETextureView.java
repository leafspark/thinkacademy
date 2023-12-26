package io.agora.rtc.video;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.internal.Logging;
import io.agora.rtc.video.GLTextureView;
import io.agora.rtc.video.TextureRendererHelper;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

public class ViETextureView extends GLTextureView implements GLTextureView.Renderer, GLRendererController {
    private static final boolean DEBUG = false;
    /* access modifiers changed from: private */
    public static String TAG = "ViETextureView";
    private int mLastRotation = -1;
    private ReentrantLock nativeFunctionLock = new ReentrantLock();
    private boolean nativeFunctionsRegisted = false;
    /* access modifiers changed from: private */
    public int nativeGLPragram = 0;
    private boolean nativeGLResourceUpdated = false;
    /* access modifiers changed from: private */
    public int[] nativeGLTextureId = {0, 0, 0};
    private long nativeObject = 0;
    /* access modifiers changed from: private */
    public int nativeOesGLProgram = 0;
    private boolean openGLCreated = false;
    /* access modifiers changed from: private */
    public boolean surfaceCreated = false;
    /* access modifiers changed from: private */
    public TextureRendererHelper textureRendererHelper = new TextureRendererHelper();
    private int viewHeight = 0;
    private int viewWidth = 0;

    private native int CreateOpenGLNative(long j, int i, int i2);

    private native void DrawNative(long j);

    private native void DrawNativeTexture(long j, int i, int i2, int i3, int i4, int i5, long j2, long j3, boolean z);

    private native void OnCfgChangedNative(long j, int i);

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
    }

    public void onSurfaceDestroyed(GL10 gl10) {
    }

    public static boolean UseOpenGL2(Object obj) {
        return ViETextureView.class.isInstance(obj);
    }

    public ViETextureView(Context context) {
        super(context);
        init(false, 0, 0);
    }

    public ViETextureView(Context context, boolean z, int i, int i2) {
        super(context);
        init(z, i, i2);
    }

    private void init(boolean z, int i, int i2) {
        ConfigChooser configChooser;
        setEGLContextClientVersion(2);
        if (z) {
            int i3 = i;
            int i4 = i2;
        } else {
            new ConfigChooser(5, 6, 5, 0, i, i2);
        }
        setEGLConfigChooser((GLTextureView.EGLConfigChooser) configChooser);
        setRenderer(this);
        setRenderMode(0);
    }

    private static void checkEglError(String str, EGL10 egl10) {
        while (true) {
            int eglGetError = egl10.eglGetError();
            if (eglGetError != 12288) {
                try {
                    Logging.e(TAG, String.format("%s: EGL error: 0x%x", new Object[]{str, Integer.valueOf(eglGetError)}));
                } catch (Exception unused) {
                    Logging.e("AGORA_SDK", "egl error!!, video may not displayed!!");
                }
            } else {
                return;
            }
        }
    }

    private static class ConfigChooser implements GLTextureView.EGLConfigChooser {
        private static int EGL_OPENGL_ES2_BIT = 4;
        private static int[] s_configAttribs2 = {12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344};
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue = new int[1];

        public ConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            this.mRedSize = i;
            this.mGreenSize = i2;
            this.mBlueSize = i3;
            this.mAlphaSize = i4;
            this.mDepthSize = i5;
            this.mStencilSize = i6;
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, s_configAttribs2, (EGLConfig[]) null, 0, iArr);
            int i = iArr[0];
            if (i <= 0) {
                Logging.w(ViETextureView.TAG, "no configurations found");
                return null;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            egl10.eglChooseConfig(eGLDisplay, s_configAttribs2, eGLConfigArr, i, iArr);
            return chooseConfig(egl10, eGLDisplay, eGLConfigArr);
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

        private void printConfigs(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            int length = eGLConfigArr.length;
            Logging.w(ViETextureView.TAG, String.format("%d configurations", new Object[]{Integer.valueOf(length)}));
            for (int i = 0; i < length; i++) {
                Logging.w(ViETextureView.TAG, String.format("Configuration %d:\n", new Object[]{Integer.valueOf(i)}));
                printConfig(egl10, eGLDisplay, eGLConfigArr[i]);
            }
        }

        private void printConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354};
            String[] strArr = {"EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT"};
            int[] iArr2 = new int[1];
            for (int i = 0; i < 33; i++) {
                int i2 = iArr[i];
                String str = strArr[i];
                if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, iArr2)) {
                    Logging.w(ViETextureView.TAG, String.format("  %s: %d\n", new Object[]{str, Integer.valueOf(iArr2[0])}));
                } else {
                    do {
                    } while (egl10.eglGetError() != 12288);
                }
            }
        }
    }

    public static boolean IsSupported(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 131072;
    }

    public void onDrawFrame(GL10 gl10) {
        if (this.textureRendererHelper.isTexture()) {
            synchronized (this) {
                onDrawFrameTexture(gl10);
            }
            return;
        }
        updateOrientation();
        this.nativeFunctionLock.lock();
        if (!this.nativeFunctionsRegisted || !this.surfaceCreated) {
            this.nativeFunctionLock.unlock();
            return;
        }
        if (!this.openGLCreated) {
            if (CreateOpenGLNative(this.nativeObject, this.viewWidth, this.viewHeight) != 0) {
                this.nativeFunctionLock.unlock();
                return;
            }
            this.openGLCreated = true;
        }
        DrawNative(this.nativeObject);
        this.nativeFunctionLock.unlock();
    }

    public void onDrawFrameTexture(GL10 gl10) {
        if (this.textureRendererHelper.isTexture()) {
            this.textureRendererHelper.onDrawFrame(this);
            if (this.textureRendererHelper.useJavaRender()) {
                return;
            }
        }
        updateOrientation();
        this.nativeFunctionLock.lock();
        if (!this.nativeFunctionsRegisted || !this.surfaceCreated) {
            this.nativeFunctionLock.unlock();
            return;
        }
        if (!this.openGLCreated) {
            if (CreateOpenGLNative(this.nativeObject, this.viewWidth, this.viewHeight) != 0) {
                this.nativeFunctionLock.unlock();
                return;
            }
            this.openGLCreated = true;
        }
        if (this.textureRendererHelper.isTexture()) {
            TextureRendererHelper.TextureFrame textureFrame = this.textureRendererHelper.getTextureFrame();
            if (textureFrame != null) {
                DrawNativeTexture(this.nativeObject, textureFrame.textureType, textureFrame.texId, textureFrame.frameWidth, textureFrame.frameHeight, textureFrame.rotation, textureFrame.renderMs, textureFrame.firstRecvTimestamp, textureFrame.isDummy);
            }
        } else {
            DrawNative(this.nativeObject);
        }
        this.nativeFunctionLock.unlock();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003d, code lost:
        if (r3.nativeFunctionsRegisted == false) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
        if (CreateOpenGLNative(r3.nativeObject, r5, r6) != 0) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        r3.openGLCreated = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        io.agora.rtc.internal.Logging.w("AGORA_SDK", "Exception occurs when create RtcEngine");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        r3.nativeFunctionLock.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        android.util.Log.i("AGORA_SDK", "Surface changed to width " + r5 + " height " + r6);
        r3.nativeFunctionLock.lock();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSurfaceChanged(javax.microedition.khronos.opengles.GL10 r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.surfaceCreated = r4
            r3.viewWidth = r5
            r3.viewHeight = r6
            monitor-enter(r3)
            io.agora.rtc.video.TextureRendererHelper r0 = r3.textureRendererHelper     // Catch:{ all -> 0x0060 }
            r0.onSurfaceChanged(r3, r5, r6)     // Catch:{ all -> 0x0060 }
            io.agora.rtc.video.TextureRendererHelper r0 = r3.textureRendererHelper     // Catch:{ all -> 0x0060 }
            boolean r0 = r0.useJavaRender()     // Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x0017
            monitor-exit(r3)     // Catch:{ all -> 0x0060 }
            return
        L_0x0017:
            monitor-exit(r3)     // Catch:{ all -> 0x0060 }
            java.lang.String r0 = "AGORA_SDK"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Surface changed to width "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = " height "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            android.util.Log.i(r0, r1)
            java.util.concurrent.locks.ReentrantLock r0 = r3.nativeFunctionLock
            r0.lock()
            boolean r0 = r3.nativeFunctionsRegisted     // Catch:{ Exception -> 0x0051 }
            if (r0 == 0) goto L_0x0049
            long r0 = r3.nativeObject     // Catch:{ Exception -> 0x0051 }
            int r5 = r3.CreateOpenGLNative(r0, r5, r6)     // Catch:{ Exception -> 0x0051 }
            if (r5 != 0) goto L_0x0049
            r3.openGLCreated = r4     // Catch:{ Exception -> 0x0051 }
        L_0x0049:
            java.util.concurrent.locks.ReentrantLock r4 = r3.nativeFunctionLock
            r4.unlock()
            goto L_0x0059
        L_0x004f:
            r4 = move-exception
            goto L_0x005a
        L_0x0051:
            java.lang.String r4 = "AGORA_SDK"
            java.lang.String r5 = "Exception occurs when create RtcEngine"
            io.agora.rtc.internal.Logging.w(r4, r5)     // Catch:{ all -> 0x004f }
            goto L_0x0049
        L_0x0059:
            return
        L_0x005a:
            java.util.concurrent.locks.ReentrantLock r5 = r3.nativeFunctionLock
            r5.unlock()
            throw r4
        L_0x0060:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0060 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.video.ViETextureView.onSurfaceChanged(javax.microedition.khronos.opengles.GL10, int, int):void");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateOrientation();
    }

    private int checkOrientation() {
        Display defaultDisplay;
        if (getContext() == null || getContext().getSystemService("window") == null || (defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay()) == null) {
            return this.mLastRotation;
        }
        try {
            return defaultDisplay.getRotation();
        } catch (RuntimeException unused) {
            Logging.e(TAG, "checkOrientation display getRotation throwout exception");
            return this.mLastRotation;
        }
    }

    private void updateOrientation() {
        int checkOrientation = checkOrientation();
        if (checkOrientation != this.mLastRotation) {
            this.nativeFunctionLock.lock();
            if (this.nativeFunctionsRegisted) {
                OnCfgChangedNative(this.nativeObject, checkOrientation);
            }
            this.mLastRotation = checkOrientation;
            this.nativeFunctionLock.unlock();
        }
    }

    public void RegisterNativeObject(long j) {
        this.nativeFunctionLock.lock();
        this.nativeObject = j;
        this.nativeFunctionsRegisted = true;
        this.nativeFunctionLock.unlock();
    }

    public void DeRegisterNativeObject() {
        this.nativeFunctionLock.lock();
        this.nativeFunctionsRegisted = false;
        this.openGLCreated = false;
        this.nativeObject = 0;
        this.nativeFunctionLock.unlock();
        releaseOpenGLResource();
    }

    public void ReDraw() {
        if (this.surfaceCreated) {
            requestRender();
        }
    }

    public int GetAPILevel() {
        return Build.VERSION.SDK_INT;
    }

    public void UpdateOpenGLResource(int[] iArr) {
        this.nativeGLPragram = iArr[0];
        int i = 0;
        while (i < 3) {
            int i2 = i + 1;
            this.nativeGLTextureId[i] = iArr[i2];
            i = i2;
        }
        this.nativeOesGLProgram = iArr[4];
        this.nativeGLResourceUpdated = true;
        Logging.i(TAG, "UpdateOpenGLResource, program = " + iArr[0] + " texture[0~2] = " + iArr[1] + " ," + iArr[2] + " ," + iArr[3]);
    }

    public void surfaceDestroyed(SurfaceTexture surfaceTexture) {
        queueEvent(new Runnable() {
            public void run() {
                synchronized (ViETextureView.this) {
                    boolean unused = ViETextureView.this.surfaceCreated = false;
                    ViETextureView.this.textureRendererHelper.releaseSurfaceTexture();
                }
            }
        });
        super.surfaceDestroyed(surfaceTexture);
    }

    public void releaseOpenGLResource() {
        if (this.nativeGLResourceUpdated) {
            queueEvent(new Runnable() {
                public void run() {
                    String access$000 = ViETextureView.TAG;
                    Logging.i(access$000, "releaseOpenGLResource, value = " + ViETextureView.this.nativeGLPragram + " ," + ViETextureView.this.nativeGLTextureId[0] + " ," + ViETextureView.this.nativeGLTextureId[1] + " ," + ViETextureView.this.nativeGLTextureId[2] + ", " + ViETextureView.this.nativeOesGLProgram);
                    if (ViETextureView.this.nativeGLPragram > 0) {
                        GLES20.glDeleteProgram(ViETextureView.this.nativeGLPragram);
                    }
                    if (ViETextureView.this.nativeGLTextureId[0] > 0) {
                        GLES20.glDeleteTextures(3, ViETextureView.this.nativeGLTextureId, 0);
                    }
                    if (ViETextureView.this.nativeOesGLProgram > 0) {
                        GLES20.glDeleteProgram(ViETextureView.this.nativeOesGLProgram);
                    }
                    int glGetError = GLES20.glGetError();
                    if (glGetError != 0) {
                        String access$0002 = ViETextureView.TAG;
                        Logging.e(access$0002, "glDelete error: " + glGetError);
                    }
                }
            });
            this.nativeGLResourceUpdated = false;
        }
    }

    public void deliverVideoTextureFrame(VideoFrame.TextureBuffer textureBuffer, int i, long j, long j2, boolean z) {
        synchronized (this) {
            this.textureRendererHelper.onTextureFrameArrived(textureBuffer, i, j, j2, z);
        }
    }

    public void textureRenderThreadWillExit() {
        synchronized (this) {
            Logging.i(TAG, "texture render thread will exit");
            this.textureRendererHelper.releaseProducerResourceIfNotYet();
        }
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.textureRendererHelper.isTexture()) {
            this.textureRendererHelper.onFrameAvailable(this);
        }
    }
}
