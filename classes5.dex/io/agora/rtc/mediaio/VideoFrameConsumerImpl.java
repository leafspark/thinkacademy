package io.agora.rtc.mediaio;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLException;
import android.util.Log;
import java.nio.ByteBuffer;

public class VideoFrameConsumerImpl implements IVideoFrameConsumer {
    private long mCaptureHandle;

    public native void provideByteArrayFrame(long j, byte[] bArr, int i, int i2, int i3, int i4, long j2);

    public native void provideByteBufferFrame(long j, ByteBuffer byteBuffer, int i, int i2, int i3, int i4, long j2);

    public native void provideTextureFrame(long j, Object obj, int i, int i2, int i3, int i4, int i5, long j2, float[] fArr);

    public VideoFrameConsumerImpl(long j) {
        this.mCaptureHandle = j;
    }

    public void consumeByteBufferFrame(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, long j) {
        provideByteBufferFrame(this.mCaptureHandle, byteBuffer, i, i2, i3, i4, j);
    }

    public void consumeByteArrayFrame(byte[] bArr, int i, int i2, int i3, int i4, long j) {
        int i5 = i;
        int i6 = (i5 == 8 || i5 == 3 || i5 == 1) ? (i2 * i3) + (((i2 + 1) >> 1) * ((i3 + 1) >> 1) * 2) : (i5 == 4 || i5 == 2 || i5 == 7) ? i2 * i3 * 4 : -1;
        if (i6 != 0) {
            byte[] bArr2 = bArr;
            if (i6 <= 0 || bArr2.length >= i6) {
                provideByteArrayFrame(this.mCaptureHandle, bArr, i, i2, i3, i4, j);
                return;
            }
        }
        Log.e("IVideoFrameConsumer", "The size of consumeByteArrayFrame is illegal, format " + i);
    }

    public void consumeTextureFrame(int i, int i2, int i3, int i4, int i5, long j, float[] fArr) {
        EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
            provideTextureFrame(this.mCaptureHandle, eglGetCurrentContext, i, i2, i3, i4, i5, j, fArr);
            return;
        }
        throw new GLException(eglGetError, "eglError: " + eglGetError);
    }
}
