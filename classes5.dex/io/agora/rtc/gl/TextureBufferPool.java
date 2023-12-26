package io.agora.rtc.gl;

import android.graphics.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.internal.Logging;
import io.agora.rtc.utils.ThreadUtils;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class TextureBufferPool {
    /* access modifiers changed from: private */
    public static final String TAG = "TextureBufferPool";
    private static final boolean VERBOSE = false;
    private static final AtomicInteger nextSeq = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public int bufferSlotCount;
    /* access modifiers changed from: private */
    public int bufferSlotIndex;
    private GlRectDrawer drawer;
    private final EglBase eglBase;
    private final EglBase.Context eglContext;
    private final boolean flushPool;
    /* access modifiers changed from: private */
    public final ConcurrentLinkedQueue<Integer> freeSlots;
    /* access modifiers changed from: private */
    public final Handler handler;
    /* access modifiers changed from: private */
    public boolean isQuitting;
    private final String name;
    private final boolean ownGlThread;
    /* access modifiers changed from: private */
    public final PoolMode poolMode;
    private GlTextureFrameBuffer[] textureFrameBuffers;
    /* access modifiers changed from: private */
    public final Map<Integer, Integer> textureIdToSlotMap;
    private final YuvConverter yuvConverter;

    public enum PoolMode {
        POOL_MODE_DYNAMIC,
        POOL_MODE_STATIC
    }

    static /* synthetic */ int access$510(TextureBufferPool textureBufferPool) {
        int i = textureBufferPool.bufferSlotIndex;
        textureBufferPool.bufferSlotIndex = i - 1;
        return i;
    }

    public static TextureBufferPool create(final String str, final EglBase.Context context, final int i) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        final Handler handler2 = new Handler(handlerThread.getLooper());
        return (TextureBufferPool) ThreadUtils.invokeAtFrontUninterruptibly(handler2, new Callable<TextureBufferPool>() {
            public TextureBufferPool call() {
                try {
                    return new TextureBufferPool(str, handler2, i, context);
                } catch (RuntimeException e) {
                    String access$100 = TextureBufferPool.TAG;
                    Logging.e(access$100, str + " create failure", e);
                    return null;
                }
            }
        });
    }

    public static TextureBufferPool createWithinGlThread(String str, Handler handler2, int i, EglBase eglBase2, YuvConverter yuvConverter2, boolean z) {
        return new TextureBufferPool(str, handler2, i, eglBase2, yuvConverter2, z);
    }

    private TextureBufferPool(String str, Handler handler2, int i, EglBase.Context context) {
        this.isQuitting = false;
        this.poolMode = PoolMode.POOL_MODE_DYNAMIC;
        this.textureIdToSlotMap = new HashMap();
        this.freeSlots = new ConcurrentLinkedQueue<>();
        this.name = str;
        this.handler = handler2;
        this.ownGlThread = true;
        EglBase create = EglBase.create(context, EglBase.CONFIG_PIXEL_BUFFER);
        this.eglBase = create;
        this.flushPool = false;
        try {
            create.createDummyPbufferSurface();
            create.makeCurrent();
            this.eglContext = create.getEglBaseContext();
            this.yuvConverter = new YuvConverter();
            initBufferPool(i);
        } catch (RuntimeException e) {
            String str2 = TAG;
            Logging.e(str2, str + " failed to create pbufferSurface!!");
            this.eglBase.release();
            handler2.getLooper().quit();
            throw e;
        }
    }

    private TextureBufferPool(String str, Handler handler2, int i, EglBase eglBase2, YuvConverter yuvConverter2, boolean z) {
        this.isQuitting = false;
        this.poolMode = PoolMode.POOL_MODE_DYNAMIC;
        this.textureIdToSlotMap = new HashMap();
        this.freeSlots = new ConcurrentLinkedQueue<>();
        this.name = str;
        this.handler = handler2;
        this.ownGlThread = false;
        this.eglContext = eglBase2.getEglBaseContext();
        this.eglBase = eglBase2;
        this.yuvConverter = yuvConverter2 == null ? new YuvConverter() : yuvConverter2;
        this.flushPool = z;
        initBufferPool(i);
    }

    public VideoFrame.TextureBuffer textureCopy(VideoFrame.TextureBuffer textureBuffer, Runnable runnable) {
        if (textureBuffer == null) {
            return null;
        }
        VideoFrame.TextureBuffer textureCopy = textureCopy(textureBuffer.getTextureId(), textureBuffer.getType(), textureBuffer.getWidth(), textureBuffer.getHeight(), textureBuffer.getTransformMatrix(), runnable);
        if (!this.flushPool || textureCopy != null || this.bufferSlotIndex < this.bufferSlotCount) {
            return textureCopy;
        }
        return new TextureBufferImpl(textureBuffer.getEglBaseContext(), textureBuffer.getWidth(), textureBuffer.getHeight(), textureBuffer.getType(), textureBuffer.getTextureId(), textureBuffer.getTransformMatrix(), textureBuffer.getToI420Handler(), textureBuffer.getYuvConverter(), runnable, nextSeq.getAndIncrement());
    }

    public VideoFrame.TextureBuffer textureCopy(int i, VideoFrame.TextureBuffer.Type type, int i2, int i3, Matrix matrix, Runnable runnable) {
        final int i4 = i;
        final VideoFrame.TextureBuffer.Type type2 = type;
        final int i5 = i2;
        final int i6 = i3;
        final Matrix matrix2 = matrix;
        final Runnable runnable2 = runnable;
        return (VideoFrame.TextureBuffer) ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Callable<VideoFrame.TextureBuffer>() {
            public VideoFrame.TextureBuffer call() throws Exception {
                return TextureBufferPool.this.doTextureCopy(i4, type2, i5, i6, matrix2, runnable2);
            }
        });
    }

    public void dispose() {
        String str = TAG;
        Logging.i(str, this.name + " dispose()");
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, (Runnable) new Runnable() {
            public void run() {
                boolean unused = TextureBufferPool.this.isQuitting = true;
                if (TextureBufferPool.this.poolMode == PoolMode.POOL_MODE_DYNAMIC) {
                    if (TextureBufferPool.this.bufferSlotIndex == 0) {
                        TextureBufferPool.this.release();
                    }
                } else if (TextureBufferPool.this.poolMode == PoolMode.POOL_MODE_STATIC && TextureBufferPool.this.freeSlots.size() == TextureBufferPool.this.bufferSlotCount) {
                    TextureBufferPool.this.release();
                }
            }
        });
    }

    private void initBufferPool(int i) {
        String str = TAG;
        Logging.i(str, this.name + " init buffer pool, ownGlThread: " + this.ownGlThread + " slots: " + i + " flushPool: " + this.flushPool);
        this.bufferSlotCount = Math.max(i, 1);
        if (this.poolMode == PoolMode.POOL_MODE_DYNAMIC) {
            this.bufferSlotIndex = 0;
        } else if (this.poolMode == PoolMode.POOL_MODE_STATIC) {
            this.textureFrameBuffers = new GlTextureFrameBuffer[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.textureFrameBuffers[i2] = new GlTextureFrameBuffer(6408);
                this.textureIdToSlotMap.put(Integer.valueOf(this.textureFrameBuffers[i2].getTextureId()), Integer.valueOf(i2));
                this.freeSlots.offer(Integer.valueOf(i2));
            }
        }
        this.drawer = new GlRectDrawer();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.agora.rtc.gl.VideoFrame.TextureBuffer doTextureCopy(int r18, io.agora.rtc.gl.VideoFrame.TextureBuffer.Type r19, int r20, int r21, android.graphics.Matrix r22, java.lang.Runnable r23) {
        /*
            r17 = this;
            r0 = r17
            io.agora.rtc.gl.TextureBufferPool$PoolMode r1 = r0.poolMode
            io.agora.rtc.gl.TextureBufferPool$PoolMode r2 = io.agora.rtc.gl.TextureBufferPool.PoolMode.POOL_MODE_DYNAMIC
            r3 = 0
            r4 = 1
            if (r1 != r2) goto L_0x001b
            int r1 = r0.bufferSlotIndex
            int r2 = r0.bufferSlotCount
            if (r1 >= r2) goto L_0x0034
            int r1 = r1 + r4
            r0.bufferSlotIndex = r1
            io.agora.rtc.gl.GlTextureFrameBuffer r1 = new io.agora.rtc.gl.GlTextureFrameBuffer
            r2 = 6408(0x1908, float:8.98E-42)
            r1.<init>(r2)
            goto L_0x0035
        L_0x001b:
            io.agora.rtc.gl.TextureBufferPool$PoolMode r1 = r0.poolMode
            io.agora.rtc.gl.TextureBufferPool$PoolMode r2 = io.agora.rtc.gl.TextureBufferPool.PoolMode.POOL_MODE_STATIC
            if (r1 != r2) goto L_0x0034
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Integer> r1 = r0.freeSlots
            java.lang.Object r1 = r1.poll()
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 == 0) goto L_0x0034
            io.agora.rtc.gl.GlTextureFrameBuffer[] r2 = r0.textureFrameBuffers
            int r1 = r1.intValue()
            r1 = r2[r1]
            goto L_0x0035
        L_0x0034:
            r1 = r3
        L_0x0035:
            if (r1 != 0) goto L_0x0038
            return r3
        L_0x0038:
            r2 = r20
            r3 = r21
            r1.setSize(r2, r3)
            int r5 = r1.getFrameBufferId()
            r14 = 36160(0x8d40, float:5.0671E-41)
            android.opengl.GLES20.glBindFramebuffer(r14, r5)
            java.lang.String r5 = "TextureBufferPool.glBindFramebuffer"
            io.agora.rtc.gl.GlUtil.checkNoGLES2Error(r5)
            r5 = 16384(0x4000, float:2.2959E-41)
            android.opengl.GLES20.glClear(r5)
            int[] r5 = io.agora.rtc.gl.TextureBufferPool.AnonymousClass5.$SwitchMap$io$agora$rtc$gl$VideoFrame$TextureBuffer$Type
            int r6 = r19.ordinal()
            r5 = r5[r6]
            if (r5 == r4) goto L_0x007c
            r6 = 2
            if (r5 != r6) goto L_0x0074
            io.agora.rtc.gl.GlRectDrawer r5 = r0.drawer
            float[] r7 = io.agora.rtc.gl.GlUtil.IDENTITY_MATRIX
            r10 = 0
            r11 = 0
            r6 = r18
            r8 = r20
            r9 = r21
            r12 = r20
            r13 = r21
            r5.drawRgb(r6, r7, r8, r9, r10, r11, r12, r13)
            goto L_0x008f
        L_0x0074:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Unknown texture type."
            r1.<init>(r2)
            throw r1
        L_0x007c:
            io.agora.rtc.gl.GlRectDrawer r5 = r0.drawer
            float[] r7 = io.agora.rtc.gl.GlUtil.IDENTITY_MATRIX
            r10 = 0
            r11 = 0
            r6 = r18
            r8 = r20
            r9 = r21
            r12 = r20
            r13 = r21
            r5.drawOes(r6, r7, r8, r9, r10, r11, r12, r13)
        L_0x008f:
            java.lang.String r5 = "TextureBufferPool.copy"
            io.agora.rtc.gl.GlUtil.checkNoGLES2Error(r5)
            r15 = 0
            android.opengl.GLES20.glBindFramebuffer(r14, r15)
            android.opengl.GLES20.glFlush()
            io.agora.rtc.gl.TextureBufferPool$PoolMode r5 = r0.poolMode
            io.agora.rtc.gl.TextureBufferPool$PoolMode r6 = io.agora.rtc.gl.TextureBufferPool.PoolMode.POOL_MODE_DYNAMIC
            if (r5 != r6) goto L_0x00a4
            r1.releaseAllButTextures()
        L_0x00a4:
            int r10 = r1.getTextureId()
            io.agora.rtc.gl.VideoFrame$TextureBuffer[] r1 = new io.agora.rtc.gl.VideoFrame.TextureBuffer[r4]
            io.agora.rtc.gl.TextureBufferImpl r4 = new io.agora.rtc.gl.TextureBufferImpl
            io.agora.rtc.gl.EglBase$Context r6 = r0.eglContext
            io.agora.rtc.gl.VideoFrame$TextureBuffer$Type r9 = io.agora.rtc.gl.VideoFrame.TextureBuffer.Type.RGB
            android.os.Handler r12 = r0.handler
            io.agora.rtc.gl.YuvConverter r13 = r0.yuvConverter
            io.agora.rtc.gl.TextureBufferPool$4 r14 = new io.agora.rtc.gl.TextureBufferPool$4
            r5 = r23
            r14.<init>(r1, r10, r5)
            java.util.concurrent.atomic.AtomicInteger r5 = nextSeq
            int r16 = r5.getAndIncrement()
            r5 = r4
            r7 = r20
            r8 = r21
            r11 = r22
            r2 = r15
            r15 = r16
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r1[r2] = r4
            r1 = r1[r2]
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.gl.TextureBufferPool.doTextureCopy(int, io.agora.rtc.gl.VideoFrame$TextureBuffer$Type, int, int, android.graphics.Matrix, java.lang.Runnable):io.agora.rtc.gl.VideoFrame$TextureBuffer");
    }

    /* renamed from: io.agora.rtc.gl.TextureBufferPool$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$io$agora$rtc$gl$VideoFrame$TextureBuffer$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.agora.rtc.gl.VideoFrame$TextureBuffer$Type[] r0 = io.agora.rtc.gl.VideoFrame.TextureBuffer.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$agora$rtc$gl$VideoFrame$TextureBuffer$Type = r0
                io.agora.rtc.gl.VideoFrame$TextureBuffer$Type r1 = io.agora.rtc.gl.VideoFrame.TextureBuffer.Type.OES     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$agora$rtc$gl$VideoFrame$TextureBuffer$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                io.agora.rtc.gl.VideoFrame$TextureBuffer$Type r1 = io.agora.rtc.gl.VideoFrame.TextureBuffer.Type.RGB     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.gl.TextureBufferPool.AnonymousClass5.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void release() {
        String str = TAG;
        Logging.i(str, this.name + " release()");
        if (this.handler.getLooper().getThread() == Thread.currentThread()) {
            if (this.poolMode == PoolMode.POOL_MODE_DYNAMIC) {
                if (this.bufferSlotIndex != 0 || !this.isQuitting) {
                    throw new IllegalStateException("Unexpected release.");
                }
            } else if (this.poolMode == PoolMode.POOL_MODE_STATIC) {
                if (this.freeSlots.size() != this.bufferSlotCount || !this.isQuitting) {
                    throw new IllegalStateException("Unexpected release.");
                }
                for (int i = 0; i < this.bufferSlotCount; i++) {
                    this.textureFrameBuffers[i].release();
                }
            }
            this.drawer.release();
            if (this.ownGlThread) {
                EglBase eglBase2 = this.eglBase;
                if (eglBase2 != null) {
                    eglBase2.release();
                }
                this.handler.getLooper().quit();
                return;
            }
            return;
        }
        throw new IllegalStateException("Wrong thread.");
    }

    public static VideoFrame.TextureBuffer makeTextureBuffer(EglBase.Context context, int i, int i2, int i3, int i4, float[] fArr, Handler handler2, YuvConverter yuvConverter2, Runnable runnable) {
        Matrix matrix;
        if (fArr == null) {
            matrix = new Matrix();
        } else {
            matrix = RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr);
        }
        return new TextureBufferImpl(context, i3, i4, agoraFrameTypeToTextureBufferType(i), i2, matrix, handler2, yuvConverter2, runnable, nextSeq.getAndIncrement());
    }

    public static VideoFrame.TextureBuffer.Type agoraFrameTypeToTextureBufferType(int i) {
        return i == 11 ? VideoFrame.TextureBuffer.Type.OES : VideoFrame.TextureBuffer.Type.RGB;
    }

    public static void textureDump(VideoFrame.TextureBuffer textureBuffer, FileOutputStream fileOutputStream) {
        VideoFrame.I420Buffer i420;
        if (textureBuffer != null && fileOutputStream != null && (i420 = textureBuffer.toI420()) != null) {
            try {
                ByteBuffer dataY = i420.getDataY();
                byte[] bArr = new byte[dataY.remaining()];
                dataY.get(bArr);
                for (int i = 0; i < i420.getHeight(); i++) {
                    fileOutputStream.write(bArr, i420.getStrideY() * i, i420.getWidth());
                }
                ByteBuffer dataU = i420.getDataU();
                byte[] bArr2 = new byte[dataU.remaining()];
                dataU.get(bArr2);
                for (int i2 = 0; i2 < (i420.getHeight() + 1) / 2; i2++) {
                    fileOutputStream.write(bArr2, i420.getStrideU() * i2, i420.getWidth() / 2);
                }
                ByteBuffer dataV = i420.getDataV();
                byte[] bArr3 = new byte[dataV.remaining()];
                dataV.get(bArr3);
                for (int i3 = 0; i3 < (i420.getHeight() + 1) / 2; i3++) {
                    fileOutputStream.write(bArr3, i420.getStrideV() * i3, i420.getWidth() / 2);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
