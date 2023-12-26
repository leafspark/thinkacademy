package com.wushuangtech.library.video.opengles.input;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.wushuangtech.utils.MyGLUtils;

public class CameraPreviewInput extends GLTextureOutputRenderer {
    private static final String TAG = "CameraPreviewInput";
    private static final String UNIFORM_CAM_MATRIX = "u_Matrix";
    private int mMatrixHandle;
    private float[] mOutSettingMatrix;
    private SurfaceTexture mSurfaceTexture;
    private final float[] mSurfaceTextureMatrix = new float[16];

    /* access modifiers changed from: protected */
    public String getFragmentShader() {
        return "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES u_Texture0;\nvarying vec2 v_TexCoord;\nvoid main() {\n   gl_FragColor = texture2D(u_Texture0, v_TexCoord);\n}\n";
    }

    /* access modifiers changed from: protected */
    public String getVertexShader() {
        return "uniform mat4 u_Matrix;\nattribute vec4 a_Position;\nattribute vec2 a_TexCoord;\nvarying vec2 v_TexCoord;\nvoid main() {\n   vec4 texPos = u_Matrix * vec4(a_TexCoord, 1, 1);\n   v_TexCoord = texPos.xy;\n   gl_Position = a_Position;\n}\n";
    }

    public CameraPreviewInput() {
        markAsDirty();
    }

    public void setMatrix(float[] fArr) {
        this.mOutSettingMatrix = fArr;
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.mSurfaceTexture = surfaceTexture;
    }

    /* access modifiers changed from: protected */
    public void initShaderHandles() {
        super.initShaderHandles();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.mProgramHandle, UNIFORM_CAM_MATRIX);
        this.mMatrixHandle = glGetUniformLocation;
        MyGLUtils.checkLocation(glGetUniformLocation, UNIFORM_CAM_MATRIX);
    }

    public void destroy() {
        super.destroy();
        this.mSurfaceTexture = null;
        this.mMatrixHandle = 0;
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
            e.printStackTrace();
            String str = TAG;
            logE(str, "updateTexImage failed , exception : " + e.getLocalizedMessage());
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void passShaderValues() {
        SurfaceTexture surfaceTexture;
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.mTextureIn);
        GLES20.glUniform1i(this.mTextureHandle, 0);
        float[] fArr = this.mOutSettingMatrix;
        if (fArr == null && (surfaceTexture = this.mSurfaceTexture) != null) {
            surfaceTexture.getTransformMatrix(this.mSurfaceTextureMatrix);
            fArr = this.mSurfaceTextureMatrix;
        }
        if (fArr != null) {
            GLES20.glUniformMatrix4fv(this.mMatrixHandle, 1, false, this.mSurfaceTextureMatrix, 0);
        }
    }
}
