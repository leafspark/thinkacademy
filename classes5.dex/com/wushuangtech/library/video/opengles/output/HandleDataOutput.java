package com.wushuangtech.library.video.opengles.output;

import android.opengl.GLES20;
import android.util.Log;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.video.bean.HandleDataOutputBean;
import com.wushuangtech.library.video.opengles.BasicFilter;
import com.wushuangtech.library.video.opengles.GLRenderer;
import com.wushuangtech.library.video.opengles.input.GLTextureOutputRenderer;
import com.wushuangtech.utils.OmniLog;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class HandleDataOutput extends BasicFilter {
    private static final int FRAME_CACHE_SIZE = 1;
    private static final String TAG = "HandleDataOutput";
    private boolean TEST = false;
    private HandleDataOutputBean[] mArrayGLFboBuffer;
    private final Object mCacheArrayLock = new Object();
    private int mDataHeight;
    private int mDataWidth;
    private boolean mDestroyed;
    private HandleDataOutputBean mLastBuffer;
    private int mLastVideoDataLen;
    private GLRenderer.OnGLRendererCallBack mOnGLRendererCallBack;
    private int mPollQueueIndex;
    private int mPutQueueIndex;
    private int mTexelHeightHandle;
    private int mTexelWidthAdjustHandle;
    private int mTexelWidthHandle;
    private int mTextureHandleU;
    private int mTextureHandleV;
    private int mTextureHandleY;
    private ByteBuffer mUBuffer;
    private int mUTextureId;
    private ByteBuffer mVBuffer;
    private int mVTextureId;
    private ByteBuffer mYBuffer;
    private int mYTextureId;

    public HandleDataOutput() {
        markAsDirty();
        this.mPutQueueIndex = 0;
        this.mPollQueueIndex = 0;
    }

    public void setOnOpenGLTextureDataCallBack(GLRenderer.OnGLRendererCallBack onGLRendererCallBack) {
        this.mOnGLRendererCallBack = onGLRendererCallBack;
    }

    /* access modifiers changed from: protected */
    public String getVertexShader() {
        return this.TEST ? super.getVertexShader() : "attribute vec4 a_Position;\nattribute vec2 a_TexCoord;\nvarying vec2 v_TexCoord;\nvoid main() {\n   v_TexCoord = a_TexCoord;\n   gl_Position = a_Position;\n}\n";
    }

    /* access modifiers changed from: protected */
    public String getFragmentShader() {
        return this.TEST ? super.getFragmentShader() : "precision mediump float;\nuniform sampler2D u_TextureY;\nuniform sampler2D u_TextureU;\nuniform sampler2D u_TextureV;\nuniform float uDivW;\nuniform float uDivH;\nuniform float uWidthAdjust;\nvarying vec2 v_TexCoord;\nvoid main(){\n   vec2 texCo = vec2(v_TexCoord.x, 1.0 - v_TexCoord.y);\n   vec3 yuv;\n   yuv.r = texture2D(u_TextureY, texCo).r - 0.0625;\n   yuv.g = texture2D(u_TextureU, texCo).r - 0.5;\n   yuv.b = texture2D(u_TextureV, texCo).r - 0.5;\n   gl_FragColor = clamp(vec4(mat3(1.1643, 1.16430, 1.1643, 0.0, -0.39173, 2.0170, 1.5958, -0.81290, 0.0) * yuv, 1.0), 0.0, 1.0);\n}\n";
    }

    /* access modifiers changed from: protected */
    public void initShaderHandles() {
        if (this.TEST) {
            super.initShaderHandles();
            return;
        }
        this.mPositionHandle = GLES20.glGetAttribLocation(this.mProgramHandle, "a_Position");
        this.mTexCoordHandle = GLES20.glGetAttribLocation(this.mProgramHandle, "a_TexCoord");
        this.mTextureHandleY = GLES20.glGetUniformLocation(this.mProgramHandle, "u_TextureY");
        this.mTextureHandleU = GLES20.glGetUniformLocation(this.mProgramHandle, "u_TextureU");
        this.mTextureHandleV = GLES20.glGetUniformLocation(this.mProgramHandle, "u_TextureV");
        this.mTexelWidthHandle = GLES20.glGetUniformLocation(this.mProgramHandle, "uDivW");
        this.mTexelHeightHandle = GLES20.glGetUniformLocation(this.mProgramHandle, "uDivH");
        this.mTexelWidthAdjustHandle = GLES20.glGetUniformLocation(this.mProgramHandle, "uWidthAdjust");
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

    public void newTextureReady(int i, GLTextureOutputRenderer gLTextureOutputRenderer, boolean z) {
        HandleDataOutputBean pollByteBuffer;
        boolean z2;
        int width = gLTextureOutputRenderer.getWidth();
        int height = gLTextureOutputRenderer.getHeight();
        this.mTextureIn = i;
        synchronized (this.mCacheArrayLock) {
            pollByteBuffer = pollByteBuffer();
            if (pollByteBuffer != null) {
                this.mLastBuffer = pollByteBuffer;
            } else {
                HandleDataOutputBean handleDataOutputBean = this.mLastBuffer;
                if (handleDataOutputBean != null) {
                    pollByteBuffer = handleDataOutputBean;
                }
            }
            z2 = pollByteBuffer != null;
        }
        if (z2) {
            int width2 = pollByteBuffer.getWidth();
            int height2 = pollByteBuffer.getHeight();
            if ((width == width2 && height == height2) || (width == height2 && height == width2)) {
                pollByteBuffer.setUsed(true);
            } else {
                logE(TAG, "width != frameWidth || height != frameHeight");
                return;
            }
        }
        setWidth(width);
        setHeight(height);
        if (pollByteBuffer == null) {
            this.TEST = true;
            this.mTextureIn = -1;
            onDrawFrame();
            return;
        }
        if (this.TEST) {
            this.TEST = false;
            OmniLog.i(OmniLog.VIDEO_CAP_SPEED_WATCH, TAG, "Draw first raw data: " + (System.currentTimeMillis() - GlobalConfig.mVideoCapStartTimestamp));
            reInitialize();
        }
        render(pollByteBuffer);
    }

    /* access modifiers changed from: protected */
    public void passShaderValues() {
        if (this.TEST) {
            super.passShaderValues();
            return;
        }
        ByteBuffer byteBuffer = this.mYBuffer;
        if (byteBuffer != null && this.mUBuffer != null && this.mVBuffer != null) {
            byteBuffer.position(0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.mYTextureId);
            GLES20.glTexImage2D(3553, 0, 6409, this.mDataWidth, this.mDataHeight, 0, 6409, 5121, this.mYBuffer);
            GLES20.glUniform1i(this.mTextureHandleY, 0);
            checkGLError("render GL_TEXTURE0");
            this.mUBuffer.position(0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.mUTextureId);
            GLES20.glTexImage2D(3553, 0, 6409, this.mDataWidth / 2, this.mDataHeight / 2, 0, 6409, 5121, this.mUBuffer);
            GLES20.glUniform1i(this.mTextureHandleU, 1);
            checkGLError("render GL_TEXTURE1");
            this.mVBuffer.position(0);
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, this.mVTextureId);
            GLES20.glTexImage2D(3553, 0, 6409, this.mDataWidth / 2, this.mDataHeight / 2, 0, 6409, 5121, this.mVBuffer);
            GLES20.glUniform1i(this.mTextureHandleV, 2);
            checkGLError("render GL_TEXTURE2");
            GLES20.glUniform1f(this.mTexelWidthHandle, 1.0f);
            GLES20.glUniform1f(this.mTexelHeightHandle, 1.0f);
            GLES20.glUniform1f(this.mTexelWidthAdjustHandle, 1.0f);
            checkGLError("handleDataOutput render passShaderValues");
        }
    }

    private void render(HandleDataOutputBean handleDataOutputBean) {
        if (handleDataOutputBean.getWidth() > 0 && handleDataOutputBean.getHeight() > 0) {
            this.mDataWidth = handleDataOutputBean.getWidth();
            this.mDataHeight = handleDataOutputBean.getHeight();
            checkGLError("render start");
            ByteBuffer byteBuffer = this.mYBuffer;
            if (byteBuffer == null || byteBuffer.capacity() != this.mDataWidth * this.mDataHeight) {
                this.mYBuffer = ByteBuffer.allocateDirect(this.mDataWidth * this.mDataHeight).order(ByteOrder.nativeOrder());
                this.mUBuffer = ByteBuffer.allocateDirect((this.mDataWidth * this.mDataHeight) / 4).order(ByteOrder.nativeOrder());
                this.mVBuffer = ByteBuffer.allocateDirect((this.mDataWidth * this.mDataHeight) / 4).order(ByteOrder.nativeOrder());
            }
            this.mYBuffer.position(0);
            this.mYBuffer.put(handleDataOutputBean.array(), 0, this.mDataWidth * this.mDataHeight);
            this.mUBuffer.position(0);
            ByteBuffer byteBuffer2 = this.mUBuffer;
            byte[] array = handleDataOutputBean.array();
            int i = this.mDataWidth;
            int i2 = this.mDataHeight;
            byteBuffer2.put(array, i * i2, (i * i2) / 4);
            this.mVBuffer.position(0);
            ByteBuffer byteBuffer3 = this.mVBuffer;
            byte[] array2 = handleDataOutputBean.array();
            int i3 = this.mDataWidth;
            int i4 = this.mDataHeight;
            byteBuffer3.put(array2, ((i3 * i4) * 5) / 4, (i3 * i4) / 4);
            onDrawFrame();
        }
    }

    public void destroy() {
        super.destroy();
        deleteTextureId(this.mYTextureId);
        deleteTextureId(this.mUTextureId);
        deleteTextureId(this.mVTextureId);
        this.mTextureHandleY = 0;
        this.mTextureHandleU = 0;
        this.mTextureHandleV = 0;
        synchronized (this.mCacheArrayLock) {
            this.mDestroyed = true;
            if (this.mArrayGLFboBuffer != null) {
                this.mArrayGLFboBuffer = null;
            }
            if (this.mLastBuffer != null) {
                this.mLastBuffer = null;
            }
            this.mPutQueueIndex = 0;
            this.mPollQueueIndex = 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveVideoData(byte[] r4, int r5, int r6, int r7, long r8, boolean r10) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mCacheArrayLock
            monitor-enter(r0)
            if (r4 != 0) goto L_0x0007
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0007:
            int r1 = r3.mLastVideoDataLen     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x000e
            int r2 = r4.length     // Catch:{ all -> 0x0027 }
            if (r1 == r2) goto L_0x0015
        L_0x000e:
            int r1 = r4.length     // Catch:{ all -> 0x0027 }
            r3.createCacheArrayBuffer(r1)     // Catch:{ all -> 0x0027 }
            int r1 = r4.length     // Catch:{ all -> 0x0027 }
            r3.mLastVideoDataLen = r1     // Catch:{ all -> 0x0027 }
        L_0x0015:
            boolean r4 = r3.putByteBuffer(r4, r5, r6, r7, r8, r10)     // Catch:{ all -> 0x0027 }
            if (r4 != 0) goto L_0x0025
            r4 = 0
            r3.mLastVideoDataLen = r4     // Catch:{ all -> 0x0027 }
            java.lang.String r4 = "HandleDataOutput"
            java.lang.String r5 = "Put raw video data error ..."
            com.wushuangtech.utils.OmniLog.e(r4, r5)     // Catch:{ all -> 0x0027 }
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            return
        L_0x0027:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.library.video.opengles.output.HandleDataOutput.receiveVideoData(byte[], int, int, int, long, boolean):void");
    }

    private void createCacheArrayBuffer(int i) {
        System.currentTimeMillis();
        if (!this.mDestroyed) {
            this.mArrayGLFboBuffer = new HandleDataOutputBean[1];
            for (int i2 = 0; i2 < 1; i2++) {
                this.mArrayGLFboBuffer[i2] = new HandleDataOutputBean();
            }
        }
    }

    private boolean putByteBuffer(byte[] bArr, int i, int i2, int i3, long j, boolean z) {
        if (this.mArrayGLFboBuffer == null) {
            return true;
        }
        byte[] transNV21ToI420DirectBuffer = GlobalHolder.getInstance().getYuvManager().transNV21ToI420DirectBuffer(bArr, i, i2, false, 0);
        GLRenderer.OnGLRendererCallBack onGLRendererCallBack = this.mOnGLRendererCallBack;
        if (onGLRendererCallBack != null) {
            onGLRendererCallBack.notifyHandleTextureData(transNV21ToI420DirectBuffer, this.mTextureIn, i, i2, i3, j);
        }
        if (!this.mArrayGLFboBuffer[this.mPutQueueIndex % 1].putData(transNV21ToI420DirectBuffer, i, i2, i3, j, z)) {
            OmniLog.e("putByteBuffer putDatas old:" + transNV21ToI420DirectBuffer.length + " reallen:" + (((i * i2) * 3) / 2));
            return false;
        }
        this.mPutQueueIndex++;
        if (this.TEST) {
            OmniLog.i(OmniLog.VIDEO_CAP_SPEED_WATCH, TAG, "Put first raw data: " + (System.currentTimeMillis() - GlobalConfig.mVideoCapStartTimestamp));
        }
        return true;
    }

    private HandleDataOutputBean pollByteBuffer() {
        if (this.mArrayGLFboBuffer == null) {
            return null;
        }
        if (this.mPollQueueIndex % 1000 == 0) {
            OmniLog.i(TAG, "mPollQueueIndex " + this.mPollQueueIndex);
        }
        HandleDataOutputBean handleDataOutputBean = this.mArrayGLFboBuffer[this.mPollQueueIndex % 1];
        if (handleDataOutputBean.isUsed()) {
            return null;
        }
        this.mPollQueueIndex++;
        return handleDataOutputBean;
    }

    private void deleteTextureId(int i) {
        if (i != 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
        }
    }

    private void backyuv(byte[] bArr, int i, int i2, int i3) {
        Log.e("backyuv:", "width: " + i + " height:" + i2);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/sdcard/rtclog/sxw_" + i + "_" + i2 + "_" + i3 + ".yuv", true);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
