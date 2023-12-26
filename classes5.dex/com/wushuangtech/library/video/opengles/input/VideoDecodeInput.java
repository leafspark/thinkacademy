package com.wushuangtech.library.video.opengles.input;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.wushuangtech.utils.OmniLog;
import java.nio.FloatBuffer;

public class VideoDecodeInput extends GLTextureOutputRenderer implements SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "VideoDecodeInput";
    private static final String UNIFORM_DISP_MATRIX = "u_Matrix";
    private final float[] mMatrix = new float[16];
    private int mMatrixHandle;
    private SurfaceTexture mSurfaceTexture;

    /* access modifiers changed from: protected */
    public String getFragmentShader() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES u_Texture0;\nvarying vec2 v_TexCoord;\nvoid main() {\n   gl_FragColor = texture2D(u_Texture0, v_TexCoord);\n}\n";
    }

    /* access modifiers changed from: protected */
    public String getVertexShader() {
        return "uniform mat4 u_Matrix;\nattribute vec4 a_Position;\nattribute vec2 a_TexCoord;\nvarying vec2 v_TexCoord;\nvoid main() {\n   vec4 texPos = u_Matrix * vec4(a_TexCoord, 1, 1);\n   v_TexCoord = texPos.xy;\n   gl_Position = a_Position;\n}\n";
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    public VideoDecodeInput() {
        markAsDirty();
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != this.mSurfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
        }
    }

    public void destroy() {
        super.destroy();
        this.mSurfaceTexture = null;
    }

    /* access modifiers changed from: protected */
    public boolean drawFrame() {
        try {
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.updateTexImage();
            }
            return super.drawFrame();
        } catch (Exception e) {
            String str = TAG;
            OmniLog.rv_d(str, "Update texture failed, exception : " + e.getLocalizedMessage());
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void initShaderHandles() {
        super.initShaderHandles();
        this.mMatrixHandle = GLES20.glGetUniformLocation(this.mProgramHandle, UNIFORM_DISP_MATRIX);
    }

    /* access modifiers changed from: protected */
    public void passShaderValues() {
        FloatBuffer vertextBuffer = getVertextBuffer();
        FloatBuffer textureBuffer = getTextureBuffer();
        vertextBuffer.position(0);
        GLES20.glVertexAttribPointer(this.mPositionHandle, 2, 5126, false, 8, vertextBuffer);
        GLES20.glEnableVertexAttribArray(this.mPositionHandle);
        GLES20.glVertexAttribPointer(this.mTexCoordHandle, 2, 5126, false, 8, textureBuffer);
        GLES20.glEnableVertexAttribArray(this.mTexCoordHandle);
        GLES20.glUniform1i(this.mTextureHandle, 0);
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.getTransformMatrix(this.mMatrix);
        }
        GLES20.glUniformMatrix4fv(this.mMatrixHandle, 1, false, this.mMatrix, 0);
    }
}
