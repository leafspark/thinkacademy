package com.wushuangtech.library.video.opengles.input;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.wushuangtech.utils.MyGLUtils;
import java.util.Arrays;

public class ExternalVideoSourceRenderer extends GLTextureOutputRenderer {
    protected static final String UNIFORM_POSITION_MATRIX = "u_posMatrix";
    protected float[] mPosMatrix;
    protected int mPosMatrixHandler;

    /* access modifiers changed from: protected */
    public String getVertexShader() {
        return "attribute vec4 a_Position;\nattribute vec2 a_TexCoord;\nvarying vec2 v_TexCoord;\nuniform mat4 u_posMatrix;\nvoid main() {\n  v_TexCoord = a_TexCoord;\n   gl_Position = u_posMatrix * a_Position;\n}\n";
    }

    public ExternalVideoSourceRenderer() {
        float[] fArr = new float[16];
        this.mPosMatrix = fArr;
        Matrix.setIdentityM(fArr, 0);
        markAsDirty();
    }

    public void setMatrix(float[] fArr) {
        if (!Arrays.equals(fArr, this.mPosMatrix)) {
            this.mPosMatrix = fArr;
        }
    }

    public void destroy() {
        super.destroy();
        this.mPosMatrixHandler = 0;
    }

    /* access modifiers changed from: protected */
    public void initShaderHandles() {
        super.initShaderHandles();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.mProgramHandle, UNIFORM_POSITION_MATRIX);
        this.mPosMatrixHandler = glGetUniformLocation;
        MyGLUtils.checkLocation(glGetUniformLocation, UNIFORM_POSITION_MATRIX);
    }

    /* access modifiers changed from: protected */
    public void passShaderValues() {
        super.passShaderValues();
        GLES20.glUniformMatrix4fv(this.mPosMatrixHandler, 1, false, this.mPosMatrix, 0);
    }
}
