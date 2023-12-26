package com.wushuangtech.myvideoimprove.render.imageprocessing;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Build;
import com.wushuangtech.library.video.VideoStatus;
import com.wushuangtech.utils.MyGLUtils;
import com.wushuangtech.utils.OmniLog;
import java.nio.ByteBuffer;

public class OpenGLPixelReader {
    private static final int FBO_TEST_NUMS = 5;
    private static final int PBO_TEST_NUMS = 6;
    private static final int PIXEL_BUFFER_SIZE = 10;
    private static final String TAG = "OpenGLPixelReader";
    private boolean enablePboBuffer;
    private int height;
    private int index;
    private int lastHeight;
    private int lastWidth;
    private ByteBuffer[] mArrayGLFboBuffer;
    private int mFBOSpendTime;
    private int mIndex;
    private boolean mIsTestPBOFinish;
    private boolean mIsUsePBO;
    private int mPBOSpendTime;
    private int nextIndex;
    private int[] pboBufferIndex;
    private int startX;
    private int startY;
    private int testFBOCount = 5;
    private int testPBOCount = 6;
    private int width;

    public OpenGLPixelReader() {
        boolean z = false;
        this.index = 0;
        this.nextIndex = 1;
        this.enablePboBuffer = Build.VERSION.SDK_INT >= 24 ? true : z;
    }

    public void setEnablePboBuffer(boolean z) {
        this.enablePboBuffer = z;
    }

    public void setReadPixelParams(int i, int i2, int i3, int i4) {
        this.startX = i;
        this.startY = i2;
        this.width = i3;
        this.height = i4;
        if (this.lastWidth != i3 || this.lastHeight != i4) {
            this.mArrayGLFboBuffer = new ByteBuffer[10];
            for (int i5 = 0; i5 < 10; i5++) {
                this.mArrayGLFboBuffer[i5] = ByteBuffer.allocate(i3 * i4 * 4);
            }
            int[] iArr = this.pboBufferIndex;
            if (iArr != null) {
                GLES20.glDeleteBuffers(iArr.length, iArr, 0);
            }
            this.pboBufferIndex = MyGLUtils.createPboBuffer(i3, i4);
            this.lastWidth = i3;
            this.lastHeight = i4;
        }
    }

    public void clearResource() {
        int[] iArr = this.pboBufferIndex;
        if (iArr != null) {
            GLES20.glDeleteBuffers(iArr.length, iArr, 0);
            this.pboBufferIndex = null;
        }
        this.mArrayGLFboBuffer = null;
    }

    public ByteBuffer readPixels() {
        int[] iArr = this.pboBufferIndex;
        if (iArr == null) {
            return null;
        }
        if (!this.enablePboBuffer) {
            return readPixelFromFBO();
        }
        if (!this.mIsTestPBOFinish) {
            testPboEffectiveness(iArr);
            return null;
        } else if (this.mIsUsePBO) {
            return readPixelFromPBO(iArr);
        } else {
            return readPixelFromFBO();
        }
    }

    private void testPboEffectiveness(int[] iArr) {
        boolean z = true;
        if (this.testPBOCount > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            readPixelFromPBO(iArr);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            int i = this.testPBOCount;
            if (i != 6) {
                this.mPBOSpendTime = (int) (((long) this.mPBOSpendTime) + currentTimeMillis2);
            }
            this.testPBOCount = i - 1;
        }
        if (this.testFBOCount > 0) {
            long currentTimeMillis3 = System.currentTimeMillis();
            readPixelFromFBO();
            this.mFBOSpendTime = (int) (((long) this.mFBOSpendTime) + (System.currentTimeMillis() - currentTimeMillis3));
            this.testFBOCount--;
        }
        if (this.testPBOCount == 0 && this.testFBOCount == 0) {
            OmniLog.debugD(OmniLog.VIDEO_RENDER_WATCH, TAG, "select fastest render mode : " + this.mPBOSpendTime + " vs " + this.mFBOSpendTime);
            this.mIsTestPBOFinish = true;
            if (this.mPBOSpendTime >= this.mFBOSpendTime) {
                z = false;
            }
            this.mIsUsePBO = z;
        }
    }

    private ByteBuffer readPixelFromFBO() {
        ByteBuffer byteBuffer = getByteBuffer();
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.clear();
        if (VideoStatus.mVideoReadPixelType != VideoStatus.OpenglESVideoReadPixelType.FBO) {
            VideoStatus.mVideoReadPixelType = VideoStatus.OpenglESVideoReadPixelType.FBO;
            OmniLog.debugD(OmniLog.VIDEO_RENDER_WATCH, TAG, "change read pixel mode : " + VideoStatus.OpenglESVideoReadPixelType.FBO.ordinal());
        }
        long currentTimeMillis = System.currentTimeMillis();
        GLES20.glReadPixels(this.startX, this.startY, this.width, this.height, 6408, 5121, byteBuffer);
        if (!this.mIsTestPBOFinish) {
            OmniLog.debugD(OmniLog.VIDEO_RENDER_WATCH, TAG, "read fbo spend time : " + (System.currentTimeMillis() - currentTimeMillis));
        }
        VideoStatus.mVideoReadPixelSpendTime = System.currentTimeMillis() - currentTimeMillis;
        return byteBuffer;
    }

    private ByteBuffer readPixelFromPBO(int[] iArr) {
        ByteBuffer byteBuffer;
        if (Build.VERSION.SDK_INT < 24 || (byteBuffer = getByteBuffer()) == null) {
            return null;
        }
        byteBuffer.clear();
        if (VideoStatus.mVideoReadPixelType != VideoStatus.OpenglESVideoReadPixelType.PBO) {
            VideoStatus.mVideoReadPixelType = VideoStatus.OpenglESVideoReadPixelType.PBO;
            OmniLog.debugD(OmniLog.VIDEO_RENDER_WATCH, TAG, "change read pixel mode : " + VideoStatus.OpenglESVideoReadPixelType.PBO.ordinal());
        }
        long currentTimeMillis = System.currentTimeMillis();
        GLES30.glBindBuffer(35051, iArr[this.index]);
        GLES30.glReadPixels(this.startX, this.startY, this.width, this.height, 6408, 5121, 0);
        GLES30.glBindBuffer(35051, iArr[this.nextIndex]);
        if (!this.mIsTestPBOFinish) {
            OmniLog.debugD(OmniLog.VIDEO_RENDER_WATCH, TAG, "read pbo part one time : " + (System.currentTimeMillis() - currentTimeMillis));
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        ByteBuffer byteBuffer2 = (ByteBuffer) GLES30.glMapBufferRange(35051, 0, this.width * this.height * 4, 1);
        GLES30.glUnmapBuffer(35051);
        GLES30.glBindBuffer(35051, 0);
        if (!this.mIsTestPBOFinish) {
            OmniLog.debugD(OmniLog.VIDEO_RENDER_WATCH, TAG, "read pbo part two time : " + (System.currentTimeMillis() - currentTimeMillis2));
        }
        this.index = (this.index + 1) % 2;
        this.nextIndex = (this.nextIndex + 1) % 2;
        long currentTimeMillis3 = System.currentTimeMillis();
        if (byteBuffer2 != null) {
            try {
                byteBuffer.put(byteBuffer2);
            } catch (Exception unused) {
                return null;
            }
        }
        if (!this.mIsTestPBOFinish) {
            OmniLog.debugD(OmniLog.VIDEO_RENDER_WATCH, TAG, "read pbo part three time : " + (System.currentTimeMillis() - currentTimeMillis3));
        }
        VideoStatus.mVideoReadPixelSpendTimePBO = System.currentTimeMillis() - currentTimeMillis;
        return byteBuffer;
    }

    private ByteBuffer getByteBuffer() {
        ByteBuffer[] byteBufferArr = this.mArrayGLFboBuffer;
        if (byteBufferArr == null) {
            return null;
        }
        if (this.mIndex > 9) {
            this.mIndex = 0;
        }
        int i = this.mIndex;
        this.mIndex = i + 1;
        return byteBufferArr[i];
    }
}
