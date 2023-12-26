package io.agora.rtc.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.GlRectDrawer;
import io.agora.rtc.gl.GlUtil;
import io.agora.rtc.gl.RendererCommon;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.internal.Logging;

public class TextureRendererHelper {
    private static String TAG = "TextureRendererHelper";
    private static final boolean VERBOSE = false;
    private GlRectDrawer drawer = null;
    private boolean eglAttached = false;
    private EglBase eglBase = null;
    private boolean isTexture = false;
    private int localEglType = -1;
    private Object localRealEglContext = null;
    private int oesTextureId = -1;
    private int oldHeight = -1;
    private int oldWidth = -1;
    private Surface surface = null;
    private SurfaceTexture surfaceTexture = null;
    private boolean surfaceTextureRecreated = false;
    private TextureFrame textureFrame = null;
    private TextureRenderer textureRenderer = null;

    public boolean useJavaRender() {
        return false;
    }

    public class TextureFrame {
        public EglBase.Context context;
        public long firstRecvTimestamp;
        public int frameHeight;
        public int frameWidth;
        public boolean isDummy;
        public long renderMs;
        public int rotation;
        public int texId;
        public int textureType;

        public TextureFrame() {
        }

        public String toString() {
            return "TextureFrame{context=" + this.context + ", texId=" + this.texId + ", textureType=" + this.textureType + ", frameWidth=" + this.frameWidth + ", frameHeight=" + this.frameHeight + ", rotation=" + this.rotation + ", renderMs=" + this.renderMs + ", firstRecvTimestamp=" + this.firstRecvTimestamp + ", isDummy=" + this.isDummy + '}';
        }
    }

    public boolean isTexture() {
        return this.isTexture;
    }

    public TextureFrame getTextureFrame() {
        TextureFrame textureFrame2 = this.textureFrame;
        if (textureFrame2 != null) {
            textureFrame2.texId = this.oesTextureId;
            this.textureFrame.textureType = 1;
        }
        return this.textureFrame;
    }

    public void onTextureFrameArrived(VideoFrame.TextureBuffer textureBuffer, int i, long j, long j2, boolean z) {
        if (textureBuffer == null) {
            Logging.e(TAG, "texture buffer is null.");
            return;
        }
        textureBuffer.retain();
        this.isTexture = true;
        if (this.surfaceTexture == null || this.surface == null) {
            Logging.e(TAG, "frame is ready, but the gl renderer thread is not ready yet.");
            releaseProducerResourceIfNotYet();
            textureBuffer.release();
            return;
        }
        if (!textureBuffer.getRealEglContext().equals(this.localRealEglContext) || textureBuffer.getEglType() != this.localEglType) {
            this.localRealEglContext = textureBuffer.getRealEglContext();
            this.localEglType = textureBuffer.getEglType();
            releaseProducerResourceIfNotYet();
        }
        if (!(this.oldWidth == textureBuffer.getWidth() && this.oldHeight == textureBuffer.getHeight())) {
            this.oldWidth = textureBuffer.getWidth();
            this.oldHeight = textureBuffer.getHeight();
            this.surfaceTexture.setDefaultBufferSize(textureBuffer.getWidth(), textureBuffer.getHeight());
            releaseProducerResourceIfNotYet();
        }
        if (this.surfaceTextureRecreated) {
            releaseProducerResourceIfNotYet();
            this.surfaceTextureRecreated = false;
        }
        createProducerResourceIfNeeded(textureBuffer.getEglBaseContext());
        if (this.textureFrame == null) {
            this.textureFrame = new TextureFrame();
        }
        int textureId = textureBuffer.getTextureId();
        VideoFrame.TextureBuffer.Type type = textureBuffer.getType();
        int width = textureBuffer.getWidth();
        int height = textureBuffer.getHeight();
        float[] convertMatrixFromAndroidGraphicsMatrix = RendererCommon.convertMatrixFromAndroidGraphicsMatrix(textureBuffer.getTransformMatrix());
        this.textureFrame.frameWidth = textureBuffer.getWidth();
        this.textureFrame.frameHeight = textureBuffer.getHeight();
        this.textureFrame.rotation = i;
        this.textureFrame.renderMs = j;
        this.textureFrame.firstRecvTimestamp = j2;
        this.textureFrame.isDummy = z;
        try {
            if (!this.eglAttached) {
                String str = TAG;
                Logging.i(str, "attaching egl context, this: " + this + ", thread id: " + Thread.currentThread().getId());
                this.eglBase.makeCurrent();
                this.eglAttached = true;
            }
            GLES20.glClear(16384);
            if (type == VideoFrame.TextureBuffer.Type.RGB) {
                this.drawer.drawRgb(textureId, convertMatrixFromAndroidGraphicsMatrix, width, height, 0, 0, width, height);
            } else {
                this.drawer.drawOes(textureId, convertMatrixFromAndroidGraphicsMatrix, width, height, 0, 0, width, height);
            }
            this.eglBase.swapBuffers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        textureBuffer.release();
    }

    public void createProducerResourceIfNeeded(EglBase.Context context) {
        if (this.eglBase == null) {
            try {
                EglBase create = EglBase.create(context);
                this.eglBase = create;
                create.createSurface(this.surface);
            } catch (Exception e) {
                String str = TAG;
                Logging.e(str, "got exception when create eglbase:" + e.toString());
            }
            this.drawer = new GlRectDrawer();
        }
    }

    public void releaseProducerResourceIfNotYet() {
        if (this.eglBase != null) {
            try {
                String str = TAG;
                Logging.i(str, "release gl resource, this: " + this + ", thread id: " + Thread.currentThread().getId());
                if (!this.eglAttached) {
                    this.eglBase.makeCurrent();
                }
                GlRectDrawer glRectDrawer = this.drawer;
                if (glRectDrawer != null) {
                    glRectDrawer.release();
                    this.drawer = null;
                }
                this.eglBase.release();
                this.eglBase = null;
                this.eglAttached = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void setupSurfaceTexture(GLRendererController gLRendererController) {
        if (this.surfaceTexture == null && gLRendererController != null) {
            this.oesTextureId = GlUtil.generateTexture(36197, false);
            SurfaceTexture surfaceTexture2 = new SurfaceTexture(this.oesTextureId);
            this.surfaceTexture = surfaceTexture2;
            surfaceTexture2.setOnFrameAvailableListener(gLRendererController);
            this.surface = new Surface(this.surfaceTexture);
            this.surfaceTextureRecreated = true;
        }
    }

    public void releaseSurfaceTexture() {
        String str = TAG;
        Logging.d(str, "release surface texture, this: " + this);
        Surface surface2 = this.surface;
        if (surface2 != null) {
            surface2.release();
            this.surface = null;
        }
        SurfaceTexture surfaceTexture2 = this.surfaceTexture;
        if (surfaceTexture2 != null) {
            surfaceTexture2.release();
            this.surfaceTexture = null;
        }
        int i = this.oesTextureId;
        if (i >= 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
            this.oesTextureId = -1;
        }
    }

    private void checkViewSizeChanged() {
        releaseSurfaceTexture();
        this.oldWidth = -1;
        this.oldHeight = -1;
    }

    public void onSurfaceChanged(GLRendererController gLRendererController, int i, int i2) {
        String str = TAG;
        Logging.d(str, "onSurfaceChanged, width: " + i + " height: " + i2 + ", this: " + this);
        checkViewSizeChanged();
        setupSurfaceTexture(gLRendererController);
        if (useJavaRender()) {
            GLES20.glViewport(0, 0, i, i2);
        }
    }

    public void onDrawFrame(GLRendererController gLRendererController) {
        setupSurfaceTexture(gLRendererController);
        if (useJavaRender()) {
            GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
            GLES20.glClear(16640);
        }
        SurfaceTexture surfaceTexture2 = this.surfaceTexture;
        if (!(surfaceTexture2 == null || this.surface == null)) {
            surfaceTexture2.updateTexImage();
        }
        if (useJavaRender()) {
            if (this.textureRenderer == null) {
                this.textureRenderer = new TextureRenderer(true);
            }
            this.textureRenderer.draw(this.oesTextureId);
        }
    }

    public void onFrameAvailable(GLRendererController gLRendererController) {
        if (gLRendererController != null) {
            gLRendererController.ReDraw();
        }
    }
}
