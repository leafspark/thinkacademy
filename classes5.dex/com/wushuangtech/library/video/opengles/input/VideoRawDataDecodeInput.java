package com.wushuangtech.library.video.opengles.input;

import android.opengl.GLES20;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.video.bean.VideoRemoteRawDataBean;
import com.wushuangtech.utils.OmniLog;
import com.yalantis.ucrop.view.CropImageView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class VideoRawDataDecodeInput extends GLTextureOutputRenderer {
    private int mLastLineSizeY;
    private int mLastWidth;
    private ByteBuffer mRawDataBuffer;
    private final float[] mTextureArray;
    private final FloatBuffer mTextureBuffer;
    private int mTextureHandleU;
    private int mTextureHandleV;
    private int mTextureHandleY;
    private int mUTextureId;
    private int mVTextureId;
    private VideoRemoteRawDataBean mVideoRemoteRawDataBean;
    private int mYTextureId;

    /* access modifiers changed from: protected */
    public String getFragmentShader() {
        return "precision mediump float;\nuniform sampler2D u_TextureY;\nuniform sampler2D u_TextureU;\nuniform sampler2D u_TextureV;\nvarying vec2 v_TexCoord;\nvoid main(){\n   vec2 texCo = vec2(v_TexCoord.x, v_TexCoord.y);\n   vec3 yuv;\n   yuv.r = texture2D(u_TextureY, texCo).r - 0.0625;\n   yuv.g = texture2D(u_TextureU, texCo).r - 0.5;\n   yuv.b = texture2D(u_TextureV, texCo).r - 0.5;\n   gl_FragColor = clamp(vec4(mat3(1.1643, 1.16430, 1.1643, 0.0, -0.39173, 2.0170, 1.5958, -0.81290, 0.0) * yuv, 1.0), 0.0, 1.0);\n}\n";
    }

    /* access modifiers changed from: protected */
    public String getVertexShader() {
        return "attribute vec4 a_Position;\nattribute vec2 a_TexCoord;\nvarying vec2 v_TexCoord;\nvoid main() {\n   v_TexCoord = vec2(a_TexCoord.x, 1.0 - a_TexCoord.y);\n   gl_Position = a_Position;\n}\n";
    }

    public VideoRawDataDecodeInput(String str) {
        this.TAG = "VideoRawDataDecodeInput<" + str + ">";
        markAsDirty();
        this.mTextureIn = 1;
        float[] fArr = {1.0f, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f, 1.0f, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO};
        this.mTextureArray = fArr;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTextureBuffer = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
    }

    public void setRawData(VideoRemoteRawDataBean videoRemoteRawDataBean) {
        this.mVideoRemoteRawDataBean = videoRemoteRawDataBean;
    }

    public void destroy() {
        super.destroy();
        deleteTextureId(this.mYTextureId);
        deleteTextureId(this.mUTextureId);
        deleteTextureId(this.mVTextureId);
        this.mTextureHandleY = 0;
        this.mTextureHandleU = 0;
        this.mTextureHandleV = 0;
    }

    /* access modifiers changed from: protected */
    public FloatBuffer getTextureBuffer() {
        return this.mTextureBuffer;
    }

    /* access modifiers changed from: protected */
    public void initShaderHandles() {
        this.mPositionHandle = GLES20.glGetAttribLocation(this.mProgramHandle, "a_Position");
        this.mTexCoordHandle = GLES20.glGetAttribLocation(this.mProgramHandle, "a_TexCoord");
        this.mTextureHandleY = GLES20.glGetUniformLocation(this.mProgramHandle, "u_TextureY");
        this.mTextureHandleU = GLES20.glGetUniformLocation(this.mProgramHandle, "u_TextureU");
        this.mTextureHandleV = GLES20.glGetUniformLocation(this.mProgramHandle, "u_TextureV");
        deleteTextureId(this.mYTextureId);
        deleteTextureId(this.mUTextureId);
        deleteTextureId(this.mVTextureId);
        int[] iArr = new int[3];
        GLES20.glGenTextures(3, iArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        this.mYTextureId = iArr[0];
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, iArr[1]);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        this.mUTextureId = iArr[1];
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, iArr[2]);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        this.mVTextureId = iArr[2];
        checkGLError("initShaderHandles end");
    }

    /* access modifiers changed from: protected */
    public void passShaderValues() {
        VideoRemoteRawDataBean videoRemoteRawDataBean = this.mVideoRemoteRawDataBean;
        if (videoRemoteRawDataBean != null && this.mRawDataBuffer != null && this.mYTextureId != 0 && this.mUTextureId != 0 && this.mVTextureId != 0) {
            int i = videoRemoteRawDataBean.mLineSizeY * this.mHeight;
            if ((i * 3) / 2 <= this.mRawDataBuffer.capacity()) {
                this.mRawDataBuffer.limit(i);
                this.mRawDataBuffer.position(0);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, this.mYTextureId);
                GLES20.glTexImage2D(3553, 0, 6409, this.mVideoRemoteRawDataBean.mLineSizeY, this.mHeight, 0, 6409, 5121, this.mRawDataBuffer);
                GLES20.glUniform1i(this.mTextureHandleY, 0);
                checkGLError("render GL_TEXTURE0");
                int i2 = (i / 4) + i;
                this.mRawDataBuffer.limit(i2);
                this.mRawDataBuffer.position(i);
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(3553, this.mUTextureId);
                GLES20.glTexImage2D(3553, 0, 6409, this.mVideoRemoteRawDataBean.mLineSizeU, this.mHeight / 2, 0, 6409, 5121, this.mRawDataBuffer);
                GLES20.glUniform1i(this.mTextureHandleU, 1);
                checkGLError("render GL_TEXTURE1");
                ByteBuffer byteBuffer = this.mRawDataBuffer;
                byteBuffer.limit(byteBuffer.capacity());
                this.mRawDataBuffer.position(i2);
                GLES20.glActiveTexture(33986);
                GLES20.glBindTexture(3553, this.mVTextureId);
                GLES20.glTexImage2D(3553, 0, 6409, this.mVideoRemoteRawDataBean.mLineSizeV, this.mHeight / 2, 0, 6409, 5121, this.mRawDataBuffer);
                GLES20.glUniform1i(this.mTextureHandleV, 2);
                checkGLError("render GL_TEXTURE2");
            }
        }
    }

    public boolean onDrawFrame() {
        VideoRemoteRawDataBean videoRemoteRawDataBean;
        if (this.mWidth == 0 || this.mHeight == 0 || (videoRemoteRawDataBean = this.mVideoRemoteRawDataBean) == null) {
            return true;
        }
        if (!(videoRemoteRawDataBean.mWidth == this.mWidth && this.mVideoRemoteRawDataBean.mHeight == this.mHeight)) {
            String str = this.TAG;
            OmniLog.w(str, "Buffer size changed, width : " + this.mWidth + " | height : " + this.mHeight + " | bean : " + this.mVideoRemoteRawDataBean.toString());
            setRenderSize(this.mVideoRemoteRawDataBean.mWidth, this.mVideoRemoteRawDataBean.mHeight);
        }
        if (this.mVideoRemoteRawDataBean.mLineSizeY != this.mVideoRemoteRawDataBean.mWidth) {
            if (!(this.mLastLineSizeY == this.mVideoRemoteRawDataBean.mLineSizeY && this.mLastWidth == this.mVideoRemoteRawDataBean.mWidth)) {
                float f = (((float) (this.mVideoRemoteRawDataBean.mLineSizeY - this.mVideoRemoteRawDataBean.mWidth)) + 0.5f) / ((float) this.mVideoRemoteRawDataBean.mLineSizeY);
                float[] fArr = this.mTextureArray;
                float f2 = 1.0f - f;
                fArr[0] = f2;
                fArr[2] = f;
                fArr[4] = f2;
                fArr[6] = f;
                this.mTextureBuffer.put(fArr).position(0);
                this.mLastLineSizeY = this.mVideoRemoteRawDataBean.mLineSizeY;
                this.mLastWidth = this.mVideoRemoteRawDataBean.mWidth;
            }
        } else if (!(this.mLastLineSizeY == this.mVideoRemoteRawDataBean.mLineSizeY && this.mLastWidth == this.mVideoRemoteRawDataBean.mWidth)) {
            float[] fArr2 = this.mTextureArray;
            fArr2[0] = 1.0f;
            fArr2[2] = 0.0f;
            fArr2[4] = 1.0f;
            fArr2[6] = 0.0f;
            this.mLastLineSizeY = this.mVideoRemoteRawDataBean.mLineSizeY;
            this.mLastWidth = this.mVideoRemoteRawDataBean.mWidth;
        }
        try {
            int i = ((this.mVideoRemoteRawDataBean.mLineSizeY * this.mHeight) * 3) / 2;
            if (!GlobalConfig.mRemoteVideoTransByBuffer || this.mVideoRemoteRawDataBean.mBuffer == null) {
                ByteBuffer byteBuffer = this.mRawDataBuffer;
                if (byteBuffer == null || byteBuffer.capacity() < i) {
                    this.mRawDataBuffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
                }
                this.mRawDataBuffer.rewind();
                this.mRawDataBuffer.put(this.mVideoRemoteRawDataBean.mData);
            } else {
                this.mRawDataBuffer = this.mVideoRemoteRawDataBean.mBuffer;
            }
            return super.onDrawFrame();
        } catch (Exception e) {
            String str2 = this.TAG;
            OmniLog.e(str2, "error:" + e.toString());
            return true;
        }
    }

    private void deleteTextureId(int i) {
        if (i != 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
        }
    }
}
