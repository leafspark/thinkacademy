package com.linkedin.android.litr.preview;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import com.linkedin.android.litr.filter.GlFrameRenderFilter;
import com.linkedin.android.litr.filter.video.gl.DefaultVideoFrameRenderFilter;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class VideoPreviewRenderer implements GLSurfaceView.Renderer {
    private static final int GL_TEXTURE_EXTERNAL_OES = 36197;
    private static final String TAG = "VideoPreviewRenderer";
    /* access modifiers changed from: private */
    public GlFrameRenderFilter frameRenderFilter;
    private final InputSurfaceTextureListener inputSurfaceTextureListener;
    /* access modifiers changed from: private */
    public float[] mvpMatrix = new float[16];
    private SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener = new SurfaceTexture.OnFrameAvailableListener() {
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            VideoPreviewRenderer.this.previewRenderListener.onRenderRequested();
        }
    };
    /* access modifiers changed from: private */
    public PreviewRenderListener previewRenderListener;
    /* access modifiers changed from: private */
    public SurfaceTexture previewSurfaceTexture;
    private float[] stMatrix = new float[16];
    private int textureHandle;

    public interface InputSurfaceTextureListener {
        void onSurfaceTextureCreated(SurfaceTexture surfaceTexture);
    }

    interface PreviewRenderListener {
        void onEventQueued(Runnable runnable);

        void onRenderRequested();
    }

    public VideoPreviewRenderer(InputSurfaceTextureListener inputSurfaceTextureListener2) {
        this.inputSurfaceTextureListener = inputSurfaceTextureListener2;
        this.frameRenderFilter = new DefaultVideoFrameRenderFilter();
        Matrix.setIdentityM(this.stMatrix, 0);
    }

    public void setFilter(final GlFrameRenderFilter glFrameRenderFilter) {
        PreviewRenderListener previewRenderListener2;
        if (this.frameRenderFilter != glFrameRenderFilter && (previewRenderListener2 = this.previewRenderListener) != null) {
            previewRenderListener2.onEventQueued(new Runnable() {
                public void run() {
                    VideoPreviewRenderer.this.frameRenderFilter.release();
                    if (VideoPreviewRenderer.this.previewSurfaceTexture != null) {
                        glFrameRenderFilter.init();
                        glFrameRenderFilter.setVpMatrix(Arrays.copyOf(VideoPreviewRenderer.this.mvpMatrix, VideoPreviewRenderer.this.mvpMatrix.length), 0);
                    }
                    GlFrameRenderFilter unused = VideoPreviewRenderer.this.frameRenderFilter = glFrameRenderFilter;
                }
            });
        }
    }

    public void setPreviewRenderListener(PreviewRenderListener previewRenderListener2) {
        this.previewRenderListener = previewRenderListener2;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.textureHandle = iArr[0];
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.textureHandle);
        this.previewSurfaceTexture = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this.onFrameAvailableListener);
        GLES20.glBindTexture(GL_TEXTURE_EXTERNAL_OES, this.textureHandle);
        GLES20.glTexParameterf(GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
        GLES20.glTexParameterf(GL_TEXTURE_EXTERNAL_OES, 10241, 9728.0f);
        GLES20.glTexParameteri(GL_TEXTURE_EXTERNAL_OES, 10242, 33071);
        GLES20.glTexParameteri(GL_TEXTURE_EXTERNAL_OES, 10243, 33071);
        GLES20.glBindTexture(3553, 0);
        this.inputSurfaceTextureListener.onSurfaceTextureCreated(this.previewSurfaceTexture);
        this.frameRenderFilter.init();
        GLES20.glGetIntegerv(3379, iArr, 0);
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        initMvpMatrix(((float) i) / ((float) i2));
        GlFrameRenderFilter glFrameRenderFilter = this.frameRenderFilter;
        float[] fArr = this.mvpMatrix;
        glFrameRenderFilter.setVpMatrix(Arrays.copyOf(fArr, fArr.length), 0);
    }

    public void onDrawFrame(GL10 gl10) {
        synchronized (this) {
            this.previewSurfaceTexture.updateTexImage();
            this.previewSurfaceTexture.getTransformMatrix(this.stMatrix);
        }
        GLES20.glClear(16384);
        this.frameRenderFilter.initInputFrameTexture(this.textureHandle, this.stMatrix);
        this.frameRenderFilter.apply(this.previewSurfaceTexture.getTimestamp());
    }

    public void release() {
        this.frameRenderFilter.release();
        SurfaceTexture surfaceTexture = this.previewSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    private void initMvpMatrix(float f) {
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        float f2 = f;
        Matrix.orthoM(fArr, 0, -f2, f2, -1.0f, 1.0f, -1.0f, 1.0f);
        float[] fArr2 = new float[16];
        Matrix.setIdentityM(fArr2, 0);
        Matrix.setLookAtM(fArr2, 0, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        Matrix.setIdentityM(this.mvpMatrix, 0);
        Matrix.multiplyMM(this.mvpMatrix, 0, fArr, 0, fArr2, 0);
    }
}
