package io.agora.rtc.mediaio;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.RendererCommon;
import io.agora.rtc.mediaio.MediaIO;
import io.agora.rtc.utils.ThreadUtils;
import java.nio.ByteBuffer;

public class AgoraSurfaceView extends SurfaceView implements IVideoSink, SurfaceHolder.Callback {
    private static final String TAG = "AgoraSurfaceView";
    private int[] mConfigAttributes;
    private RendererCommon.GlDrawer mDrawer;
    private EglBase.Context mEglContext;
    private BaseVideoRenderer mRender;

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public AgoraSurfaceView(Context context) {
        super(context);
        BaseVideoRenderer baseVideoRenderer = new BaseVideoRenderer(TAG);
        this.mRender = baseVideoRenderer;
        baseVideoRenderer.setRenderView((SurfaceView) this, (SurfaceHolder.Callback) this);
    }

    public AgoraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        BaseVideoRenderer baseVideoRenderer = new BaseVideoRenderer(TAG);
        this.mRender = baseVideoRenderer;
        baseVideoRenderer.setRenderView((SurfaceView) this, (SurfaceHolder.Callback) this);
    }

    public void init(EglBase.Context context) {
        this.mEglContext = context;
    }

    public void init(EglBase.Context context, int[] iArr, RendererCommon.GlDrawer glDrawer) {
        this.mEglContext = context;
        this.mConfigAttributes = iArr;
        this.mDrawer = glDrawer;
    }

    public long getEGLContextHandle() {
        return this.mRender.getEGLContextHandle();
    }

    public void setBufferType(MediaIO.BufferType bufferType) {
        this.mRender.setBufferType(bufferType);
    }

    public void setPixelFormat(MediaIO.PixelFormat pixelFormat) {
        this.mRender.setPixelFormat(pixelFormat);
    }

    public void setMirror(boolean z) {
        this.mRender.getEglRender().setMirror(z);
    }

    public boolean onInitialize() {
        RendererCommon.GlDrawer glDrawer;
        int[] iArr = this.mConfigAttributes;
        if (iArr == null || (glDrawer = this.mDrawer) == null) {
            this.mRender.init(this.mEglContext);
            return true;
        }
        this.mRender.init(this.mEglContext, iArr, glDrawer);
        return true;
    }

    public boolean onStart() {
        return this.mRender.start();
    }

    public void onStop() {
        this.mRender.stop();
    }

    public void onDispose() {
        this.mRender.release();
    }

    public void consumeByteBufferFrame(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, long j) {
        this.mRender.consume(byteBuffer, i, i2, i3, i4, j);
    }

    public void consumeByteArrayFrame(byte[] bArr, int i, int i2, int i3, int i4, long j) {
        this.mRender.consume(bArr, i, i2, i3, i4, j);
    }

    public void consumeTextureFrame(int i, int i2, int i3, int i4, int i5, long j, float[] fArr) {
        this.mRender.consume(i, i2, i3, i4, i5, j, fArr);
    }

    public int getBufferType() {
        int bufferType = this.mRender.getBufferType();
        if (bufferType != -1) {
            return bufferType;
        }
        throw new IllegalArgumentException("Buffer type is not set");
    }

    public int getPixelFormat() {
        int pixelFormat = this.mRender.getPixelFormat();
        if (pixelFormat != -1) {
            return pixelFormat;
        }
        throw new IllegalArgumentException("Pixel format is not set");
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        String str = TAG;
        Log.i(str, "surfaceChanged: format: " + i + " size: " + i2 + "x" + i3);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ThreadUtils.checkIsOnMainThread();
        this.mRender.getEglRender().setLayoutAspectRatio(((float) (i3 - i)) / ((float) (i4 - i2)));
    }
}
