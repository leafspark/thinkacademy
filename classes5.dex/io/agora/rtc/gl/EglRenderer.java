package io.agora.rtc.gl;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.yalantis.ucrop.view.CropImageView;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.RendererCommon;
import io.agora.rtc.utils.ThreadUtils;
import io.ktor.client.plugins.HttpTimeout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class EglRenderer {
    private static final long LOG_INTERVAL_SEC = 4;
    private static final int MAX_SURFACE_CLEAR_COUNT = 3;
    private static final String TAG = "EglRenderer";
    private final Matrix drawMatrix = new Matrix();
    /* access modifiers changed from: private */
    public RendererCommon.GlDrawer drawer;
    /* access modifiers changed from: private */
    public EglBase eglBase;
    private final EglSurfaceCreation eglSurfaceCreationRunnable = new EglSurfaceCreation();
    private final Object fpsReductionLock = new Object();
    /* access modifiers changed from: private */
    public final VideoFrameDrawer frameDrawer = new VideoFrameDrawer();
    /* access modifiers changed from: private */
    public final ArrayList<FrameListenerAndParams> frameListeners = new ArrayList<>();
    private final Object frameLock = new Object();
    private int framesDropped;
    private int framesReceived;
    private int framesRendered;
    /* access modifiers changed from: private */
    public final Object handlerLock = new Object();
    private float layoutAspectRatio;
    private final Object layoutLock = new Object();
    /* access modifiers changed from: private */
    public final Runnable logStatisticsRunnable = new Runnable() {
        public void run() {
            EglRenderer.this.logStatistics();
            synchronized (EglRenderer.this.handlerLock) {
                if (EglRenderer.this.renderThreadHandler != null) {
                    EglRenderer.this.renderThreadHandler.removeCallbacks(EglRenderer.this.logStatisticsRunnable);
                    EglRenderer.this.renderThreadHandler.postDelayed(EglRenderer.this.logStatisticsRunnable, TimeUnit.SECONDS.toMillis(4));
                }
            }
        }
    };
    private long minRenderPeriodNs;
    private boolean mirror;
    private final String name;
    private long nextFrameTimeNs;
    private VideoFrame pendingFrame;
    private long renderSwapBufferTimeNs;
    /* access modifiers changed from: private */
    public Handler renderThreadHandler;
    private long renderTimeNs;
    private final Object statisticsLock = new Object();
    private long statisticsStartTimeNs;

    public interface FrameListener {
        void onFrame(Bitmap bitmap);
    }

    private static class FrameListenerAndParams {
        public final boolean applyFpsReduction;
        public final RendererCommon.GlDrawer drawer;
        public final FrameListener listener;
        public final float scale;

        public FrameListenerAndParams(FrameListener frameListener, float f, RendererCommon.GlDrawer glDrawer, boolean z) {
            this.listener = frameListener;
            this.scale = f;
            this.drawer = glDrawer;
            this.applyFpsReduction = z;
        }
    }

    private class EglSurfaceCreation implements Runnable {
        private Object surface;

        private EglSurfaceCreation() {
        }

        public synchronized void setSurface(Object obj) {
            this.surface = obj;
        }

        public synchronized void run() {
            if (!(this.surface == null || EglRenderer.this.eglBase == null || EglRenderer.this.eglBase.hasSurface())) {
                Object obj = this.surface;
                if (obj instanceof Surface) {
                    EglRenderer.this.eglBase.createSurface((Surface) this.surface);
                } else if (obj instanceof SurfaceTexture) {
                    EglRenderer.this.eglBase.createSurface((SurfaceTexture) this.surface);
                } else {
                    throw new IllegalStateException("Invalid surface: " + this.surface);
                }
                EglRenderer.this.eglBase.makeCurrent();
                GLES20.glPixelStorei(3317, 1);
            }
        }
    }

    public EglRenderer(String str) {
        this.name = str;
    }

    public void init(final EglBase.Context context, final int[] iArr, RendererCommon.GlDrawer glDrawer) {
        synchronized (this.handlerLock) {
            if (this.renderThreadHandler == null) {
                logD("Initializing EglRenderer");
                this.drawer = glDrawer;
                HandlerThread handlerThread = new HandlerThread(this.name + TAG);
                handlerThread.start();
                Handler handler = new Handler(handlerThread.getLooper());
                this.renderThreadHandler = handler;
                ThreadUtils.invokeAtFrontUninterruptibly(handler, (Runnable) new Runnable() {
                    public void run() {
                        if (context == null) {
                            EglRenderer.this.logD("EglBase.create context");
                            EglBase unused = EglRenderer.this.eglBase = EglBase.create(context, iArr);
                            return;
                        }
                        EglRenderer.this.logD("EglBase.create shared context");
                        EglBase unused2 = EglRenderer.this.eglBase = EglBase.create(context, iArr);
                    }
                });
                Handler handler2 = this.renderThreadHandler;
                EglSurfaceCreation eglSurfaceCreation = this.eglSurfaceCreationRunnable;
                if (!(handler2 instanceof Handler)) {
                    handler2.post(eglSurfaceCreation);
                } else {
                    AsynchronousInstrumentation.handlerPost(handler2, eglSurfaceCreation);
                }
                resetStatistics(System.nanoTime());
            } else {
                throw new IllegalStateException(this.name + "Already initialized");
            }
        }
    }

    public EglBase.Context getEglContext() {
        return this.eglBase.getEglBaseContext();
    }

    public void createEglSurface(Surface surface) {
        createEglSurfaceInternal(surface);
    }

    public void createEglSurface(SurfaceTexture surfaceTexture) {
        createEglSurfaceInternal(surfaceTexture);
    }

    private void createEglSurfaceInternal(Object obj) {
        this.eglSurfaceCreationRunnable.setSurface(obj);
        postToRenderThread(this.eglSurfaceCreationRunnable);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        r2 = r5.frameLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r1 = r5.pendingFrame;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
        if (r1 == null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        r1.release();
        r5.pendingFrame = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        logD("Releasing done.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void release() {
        /*
            r5 = this;
            java.lang.String r0 = "Releasing."
            r5.logD(r0)
            java.util.concurrent.CountDownLatch r0 = new java.util.concurrent.CountDownLatch
            r1 = 1
            r0.<init>(r1)
            java.lang.Object r1 = r5.handlerLock
            monitor-enter(r1)
            android.os.Handler r2 = r5.renderThreadHandler     // Catch:{ all -> 0x0058 }
            if (r2 != 0) goto L_0x0019
            java.lang.String r0 = "Already released"
            r5.logD(r0)     // Catch:{ all -> 0x0058 }
            monitor-exit(r1)     // Catch:{ all -> 0x0058 }
            return
        L_0x0019:
            io.agora.rtc.gl.EglRenderer$3 r3 = new io.agora.rtc.gl.EglRenderer$3     // Catch:{ all -> 0x0058 }
            r3.<init>()     // Catch:{ all -> 0x0058 }
            r2.postAtFrontOfQueue(r3)     // Catch:{ all -> 0x0058 }
            android.os.Handler r2 = r5.renderThreadHandler     // Catch:{ all -> 0x0058 }
            android.os.Looper r2 = r2.getLooper()     // Catch:{ all -> 0x0058 }
            android.os.Handler r3 = r5.renderThreadHandler     // Catch:{ all -> 0x0058 }
            io.agora.rtc.gl.EglRenderer$4 r4 = new io.agora.rtc.gl.EglRenderer$4     // Catch:{ all -> 0x0058 }
            r4.<init>(r2, r0)     // Catch:{ all -> 0x0058 }
            boolean r2 = r3 instanceof android.os.Handler     // Catch:{ all -> 0x0058 }
            if (r2 != 0) goto L_0x0036
            r3.post(r4)     // Catch:{ all -> 0x0058 }
            goto L_0x003b
        L_0x0036:
            android.os.Handler r3 = (android.os.Handler) r3     // Catch:{ all -> 0x0058 }
            com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation.handlerPost(r3, r4)     // Catch:{ all -> 0x0058 }
        L_0x003b:
            io.agora.rtc.utils.ThreadUtils.awaitUninterruptibly(r0)     // Catch:{ all -> 0x0058 }
            r0 = 0
            r5.renderThreadHandler = r0     // Catch:{ all -> 0x0058 }
            monitor-exit(r1)     // Catch:{ all -> 0x0058 }
            java.lang.Object r2 = r5.frameLock
            monitor-enter(r2)
            io.agora.rtc.gl.VideoFrame r1 = r5.pendingFrame     // Catch:{ all -> 0x0055 }
            if (r1 == 0) goto L_0x004e
            r1.release()     // Catch:{ all -> 0x0055 }
            r5.pendingFrame = r0     // Catch:{ all -> 0x0055 }
        L_0x004e:
            monitor-exit(r2)     // Catch:{ all -> 0x0055 }
            java.lang.String r0 = "Releasing done."
            r5.logD(r0)
            return
        L_0x0055:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0055 }
            throw r0
        L_0x0058:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0058 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.gl.EglRenderer.release():void");
    }

    private void resetStatistics(long j) {
        synchronized (this.statisticsLock) {
            this.statisticsStartTimeNs = j;
            this.framesReceived = 0;
            this.framesDropped = 0;
            this.framesRendered = 0;
            this.renderTimeNs = 0;
            this.renderSwapBufferTimeNs = 0;
        }
    }

    public void printStackTrace() {
        Thread thread;
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            if (handler == null) {
                thread = null;
            } else {
                thread = handler.getLooper().getThread();
            }
            if (thread != null) {
                StackTraceElement[] stackTrace = thread.getStackTrace();
                if (stackTrace.length > 0) {
                    logD("EglRenderer stack trace:");
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        logD(stackTraceElement.toString());
                    }
                }
            }
        }
    }

    public void setMirror(boolean z) {
        logD("setMirror: " + z);
        synchronized (this.layoutLock) {
            this.mirror = z;
        }
    }

    public void setLayoutAspectRatio(float f) {
        logD("setLayoutAspectRatio: " + f);
        synchronized (this.layoutLock) {
            this.layoutAspectRatio = f;
        }
    }

    public void setFpsReduction(float f) {
        logD("setFpsReduction: " + f);
        synchronized (this.fpsReductionLock) {
            long j = this.minRenderPeriodNs;
            if (f <= CropImageView.DEFAULT_ASPECT_RATIO) {
                this.minRenderPeriodNs = HttpTimeout.INFINITE_TIMEOUT_MS;
            } else {
                this.minRenderPeriodNs = (long) (((float) TimeUnit.SECONDS.toNanos(1)) / f);
            }
            if (this.minRenderPeriodNs != j) {
                this.nextFrameTimeNs = System.nanoTime();
            }
        }
    }

    public void disableFpsReduction() {
        setFpsReduction(Float.POSITIVE_INFINITY);
    }

    public void pauseVideo() {
        setFpsReduction(CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public void addFrameListener(FrameListener frameListener, float f) {
        addFrameListener(frameListener, f, (RendererCommon.GlDrawer) null, false);
    }

    public void addFrameListener(FrameListener frameListener, float f, RendererCommon.GlDrawer glDrawer) {
        addFrameListener(frameListener, f, glDrawer, false);
    }

    public void addFrameListener(FrameListener frameListener, float f, RendererCommon.GlDrawer glDrawer, boolean z) {
        final RendererCommon.GlDrawer glDrawer2 = glDrawer;
        final FrameListener frameListener2 = frameListener;
        final float f2 = f;
        final boolean z2 = z;
        postToRenderThread(new Runnable() {
            public void run() {
                RendererCommon.GlDrawer glDrawer = glDrawer2;
                if (glDrawer == null) {
                    glDrawer = EglRenderer.this.drawer;
                }
                EglRenderer.this.frameListeners.add(new FrameListenerAndParams(frameListener2, f2, glDrawer, z2));
            }
        });
    }

    public void removeFrameListener(final FrameListener frameListener) {
        if (Thread.currentThread() != this.renderThreadHandler.getLooper().getThread()) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            postToRenderThread(new Runnable() {
                public void run() {
                    countDownLatch.countDown();
                    Iterator it = EglRenderer.this.frameListeners.iterator();
                    while (it.hasNext()) {
                        if (((FrameListenerAndParams) it.next()).listener == frameListener) {
                            it.remove();
                        }
                    }
                }
            });
            ThreadUtils.awaitUninterruptibly(countDownLatch);
            return;
        }
        throw new RuntimeException("removeFrameListener must not be called on the render thread.");
    }

    public void renderFrame(VideoFrame videoFrame) {
        onFrame(videoFrame);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0038, code lost:
        if (r4 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003a, code lost:
        r6 = r5.statisticsLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003c, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r5.framesDropped++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0042, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFrame(io.agora.rtc.gl.VideoFrame r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.statisticsLock
            monitor-enter(r0)
            int r1 = r5.framesReceived     // Catch:{ all -> 0x004e }
            r2 = 1
            int r1 = r1 + r2
            r5.framesReceived = r1     // Catch:{ all -> 0x004e }
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            java.lang.Object r1 = r5.handlerLock
            monitor-enter(r1)
            android.os.Handler r0 = r5.renderThreadHandler     // Catch:{ all -> 0x004b }
            if (r0 != 0) goto L_0x0018
            java.lang.String r6 = "Dropping frame - Not initialized or already released."
            r5.logD(r6)     // Catch:{ all -> 0x004b }
            monitor-exit(r1)     // Catch:{ all -> 0x004b }
            return
        L_0x0018:
            java.lang.Object r0 = r5.frameLock     // Catch:{ all -> 0x004b }
            monitor-enter(r0)     // Catch:{ all -> 0x004b }
            io.agora.rtc.gl.VideoFrame r3 = r5.pendingFrame     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0021
            r4 = r2
            goto L_0x0022
        L_0x0021:
            r4 = 0
        L_0x0022:
            if (r4 == 0) goto L_0x0027
            r3.release()     // Catch:{ all -> 0x0048 }
        L_0x0027:
            r5.pendingFrame = r6     // Catch:{ all -> 0x0048 }
            r6.retain()     // Catch:{ all -> 0x0048 }
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            android.os.Handler r6 = r5.renderThreadHandler     // Catch:{ all -> 0x004b }
            io.agora.rtc.gl.EglRenderer$7 r0 = new io.agora.rtc.gl.EglRenderer$7     // Catch:{ all -> 0x004b }
            r0.<init>()     // Catch:{ all -> 0x004b }
            io.agora.rtc.utils.ThreadUtils.invokeAtFrontUninterruptibly((android.os.Handler) r6, (java.lang.Runnable) r0)     // Catch:{ all -> 0x004b }
            monitor-exit(r1)     // Catch:{ all -> 0x004b }
            if (r4 == 0) goto L_0x0047
            java.lang.Object r6 = r5.statisticsLock
            monitor-enter(r6)
            int r0 = r5.framesDropped     // Catch:{ all -> 0x0044 }
            int r0 = r0 + r2
            r5.framesDropped = r0     // Catch:{ all -> 0x0044 }
            monitor-exit(r6)     // Catch:{ all -> 0x0044 }
            goto L_0x0047
        L_0x0044:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0044 }
            throw r0
        L_0x0047:
            return
        L_0x0048:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r6     // Catch:{ all -> 0x004b }
        L_0x004b:
            r6 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x004b }
            throw r6
        L_0x004e:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.gl.EglRenderer.onFrame(io.agora.rtc.gl.VideoFrame):void");
    }

    public void releaseEglSurface(final Runnable runnable) {
        this.eglSurfaceCreationRunnable.setSurface((Object) null);
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            if (handler != null) {
                handler.removeCallbacks(this.eglSurfaceCreationRunnable);
                this.renderThreadHandler.postAtFrontOfQueue(new Runnable() {
                    public void run() {
                        if (EglRenderer.this.eglBase != null) {
                            EglRenderer.this.eglBase.detachCurrent();
                            EglRenderer.this.eglBase.releaseSurface();
                        }
                        runnable.run();
                    }
                });
                return;
            }
            runnable.run();
        }
    }

    private void postToRenderThread(Runnable runnable) {
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            if (handler != null) {
                if (!(handler instanceof Handler)) {
                    handler.post(runnable);
                } else {
                    AsynchronousInstrumentation.handlerPost(handler, runnable);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void clearSurfaceOnRenderThread(float f, float f2, float f3, float f4) {
        EglBase eglBase2 = this.eglBase;
        if (eglBase2 != null && eglBase2.hasSurface()) {
            logD("clearSurface");
            GLES20.glClearColor(f, f2, f3, f4);
            GLES20.glClear(16384);
            this.eglBase.swapBuffers();
        }
    }

    public void clearImage() {
        clearImage(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public void clearImage(float f, float f2, float f3, float f4) {
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            if (handler != null) {
                final float f5 = f;
                final float f6 = f2;
                final float f7 = f3;
                final float f8 = f4;
                handler.postAtFrontOfQueue(new Runnable() {
                    public void run() {
                        EglRenderer.this.clearSurfaceOnRenderThread(f5, f6, f7, f8);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000f, code lost:
        if (r0 == null) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
        if (r0.hasSurface() != false) goto L_0x0019;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        r0 = r13.fpsReductionLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r1 = r13.minRenderPeriodNs;
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
        if (r1 != io.ktor.client.plugins.HttpTimeout.INFINITE_TIMEOUT_MS) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        if (r1 > 0) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0030, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0032, code lost:
        r1 = java.lang.System.nanoTime();
        r5 = r13.nextFrameTimeNs;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        if (r1 >= r5) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003c, code lost:
        logD("Skipping frame rendering - fps reduction is active.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0042, code lost:
        r5 = r5 + r13.minRenderPeriodNs;
        r13.nextFrameTimeNs = r5;
        r13.nextFrameTimeNs = java.lang.Math.max(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004e, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004f, code lost:
        r11 = java.lang.System.nanoTime();
        r0 = ((float) r9.getRotatedWidth()) / ((float) r9.getRotatedHeight());
        r1 = r13.layoutLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0060, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r2 = r13.layoutAspectRatio;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0066, code lost:
        if (r2 == com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0069, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006a, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006f, code lost:
        if (r0 <= r2) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0071, code lost:
        r2 = r2 / r0;
        r0 = 1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0074, code lost:
        r0 = r0 / r2;
        r2 = 1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0076, code lost:
        r13.drawMatrix.reset();
        r13.drawMatrix.preTranslate(0.5f, 0.5f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0084, code lost:
        if (r13.mirror == false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0086, code lost:
        r13.drawMatrix.preScale(-1.0f, 1.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x008d, code lost:
        r13.drawMatrix.preScale(r2, r0);
        r13.drawMatrix.preTranslate(-0.5f, -0.5f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0099, code lost:
        if (r4 == false) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009b, code lost:
        android.opengl.GLES20.glClearColor(com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO, com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO, com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO, com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO);
        android.opengl.GLES20.glClear(16384);
        r13.frameDrawer.drawFrame(r9, r13.drawer, r13.drawMatrix, 0, 0, r13.eglBase.surfaceWidth(), r13.eglBase.surfaceHeight());
        r0 = java.lang.System.nanoTime();
        r13.eglBase.swapBuffers();
        r2 = java.lang.System.nanoTime();
        r4 = r13.statisticsLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ca, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r13.framesRendered++;
        r13.renderTimeNs += r2 - r11;
        r13.renderSwapBufferTimeNs += r2 - r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00dd, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e2, code lost:
        r9.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e5, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00ec, code lost:
        logD("Dropping frame - No surface");
        r9.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f4, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000d, code lost:
        r0 = r13.eglBase;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void renderFrameOnRenderThread() {
        /*
            r13 = this;
            java.lang.Object r0 = r13.frameLock
            monitor-enter(r0)
            io.agora.rtc.gl.VideoFrame r9 = r13.pendingFrame     // Catch:{ all -> 0x00f5 }
            if (r9 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x00f5 }
            return
        L_0x0009:
            r1 = 0
            r13.pendingFrame = r1     // Catch:{ all -> 0x00f5 }
            monitor-exit(r0)     // Catch:{ all -> 0x00f5 }
            io.agora.rtc.gl.EglBase r0 = r13.eglBase
            if (r0 == 0) goto L_0x00ec
            boolean r0 = r0.hasSurface()
            if (r0 != 0) goto L_0x0019
            goto L_0x00ec
        L_0x0019:
            java.lang.Object r0 = r13.fpsReductionLock
            monitor-enter(r0)
            long r1 = r13.minRenderPeriodNs     // Catch:{ all -> 0x00e9 }
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r4 = 0
            r10 = 1
            if (r3 != 0) goto L_0x002a
            goto L_0x004e
        L_0x002a:
            r5 = 0
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 > 0) goto L_0x0032
        L_0x0030:
            r4 = r10
            goto L_0x004e
        L_0x0032:
            long r1 = java.lang.System.nanoTime()     // Catch:{ all -> 0x00e9 }
            long r5 = r13.nextFrameTimeNs     // Catch:{ all -> 0x00e9 }
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0042
            java.lang.String r1 = "Skipping frame rendering - fps reduction is active."
            r13.logD(r1)     // Catch:{ all -> 0x00e9 }
            goto L_0x004e
        L_0x0042:
            long r3 = r13.minRenderPeriodNs     // Catch:{ all -> 0x00e9 }
            long r5 = r5 + r3
            r13.nextFrameTimeNs = r5     // Catch:{ all -> 0x00e9 }
            long r1 = java.lang.Math.max(r5, r1)     // Catch:{ all -> 0x00e9 }
            r13.nextFrameTimeNs = r1     // Catch:{ all -> 0x00e9 }
            goto L_0x0030
        L_0x004e:
            monitor-exit(r0)     // Catch:{ all -> 0x00e9 }
            long r11 = java.lang.System.nanoTime()
            int r0 = r9.getRotatedWidth()
            float r0 = (float) r0
            int r1 = r9.getRotatedHeight()
            float r1 = (float) r1
            float r0 = r0 / r1
            java.lang.Object r1 = r13.layoutLock
            monitor-enter(r1)
            float r2 = r13.layoutAspectRatio     // Catch:{ all -> 0x00e6 }
            r3 = 0
            int r5 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0069
            goto L_0x006a
        L_0x0069:
            r2 = r0
        L_0x006a:
            monitor-exit(r1)     // Catch:{ all -> 0x00e6 }
            int r1 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r1 <= 0) goto L_0x0074
            float r2 = r2 / r0
            r0 = r5
            goto L_0x0076
        L_0x0074:
            float r0 = r0 / r2
            r2 = r5
        L_0x0076:
            android.graphics.Matrix r1 = r13.drawMatrix
            r1.reset()
            android.graphics.Matrix r1 = r13.drawMatrix
            r6 = 1056964608(0x3f000000, float:0.5)
            r1.preTranslate(r6, r6)
            boolean r1 = r13.mirror
            if (r1 == 0) goto L_0x008d
            android.graphics.Matrix r1 = r13.drawMatrix
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1.preScale(r6, r5)
        L_0x008d:
            android.graphics.Matrix r1 = r13.drawMatrix
            r1.preScale(r2, r0)
            android.graphics.Matrix r0 = r13.drawMatrix
            r1 = -1090519040(0xffffffffbf000000, float:-0.5)
            r0.preTranslate(r1, r1)
            if (r4 == 0) goto L_0x00e2
            android.opengl.GLES20.glClearColor(r3, r3, r3, r3)
            r0 = 16384(0x4000, float:2.2959E-41)
            android.opengl.GLES20.glClear(r0)
            io.agora.rtc.gl.VideoFrameDrawer r1 = r13.frameDrawer
            io.agora.rtc.gl.RendererCommon$GlDrawer r3 = r13.drawer
            android.graphics.Matrix r4 = r13.drawMatrix
            r5 = 0
            r6 = 0
            io.agora.rtc.gl.EglBase r0 = r13.eglBase
            int r7 = r0.surfaceWidth()
            io.agora.rtc.gl.EglBase r0 = r13.eglBase
            int r8 = r0.surfaceHeight()
            r2 = r9
            r1.drawFrame(r2, r3, r4, r5, r6, r7, r8)
            long r0 = java.lang.System.nanoTime()
            io.agora.rtc.gl.EglBase r2 = r13.eglBase
            r2.swapBuffers()
            long r2 = java.lang.System.nanoTime()
            java.lang.Object r4 = r13.statisticsLock
            monitor-enter(r4)
            int r5 = r13.framesRendered     // Catch:{ all -> 0x00df }
            int r5 = r5 + r10
            r13.framesRendered = r5     // Catch:{ all -> 0x00df }
            long r5 = r13.renderTimeNs     // Catch:{ all -> 0x00df }
            long r7 = r2 - r11
            long r5 = r5 + r7
            r13.renderTimeNs = r5     // Catch:{ all -> 0x00df }
            long r5 = r13.renderSwapBufferTimeNs     // Catch:{ all -> 0x00df }
            long r2 = r2 - r0
            long r5 = r5 + r2
            r13.renderSwapBufferTimeNs = r5     // Catch:{ all -> 0x00df }
            monitor-exit(r4)     // Catch:{ all -> 0x00df }
            goto L_0x00e2
        L_0x00df:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00df }
            throw r0
        L_0x00e2:
            r9.release()
            return
        L_0x00e6:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00e6 }
            throw r0
        L_0x00e9:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00e9 }
            throw r1
        L_0x00ec:
            java.lang.String r0 = "Dropping frame - No surface"
            r13.logD(r0)
            r9.release()
            return
        L_0x00f5:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00f5 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.gl.EglRenderer.renderFrameOnRenderThread():void");
    }

    private String averageTimeAsString(long j, int i) {
        if (i <= 0) {
            return "NA";
        }
        return TimeUnit.NANOSECONDS.toMicros(j / ((long) i)) + " us";
    }

    /* access modifiers changed from: private */
    public void logStatistics() {
        long nanoTime = System.nanoTime();
        synchronized (this.statisticsLock) {
            long j = nanoTime - this.statisticsStartTimeNs;
            if (j > 0) {
                float nanos = ((float) (((long) this.framesRendered) * TimeUnit.SECONDS.toNanos(1))) / ((float) j);
                logD("Duration: " + TimeUnit.NANOSECONDS.toMillis(j) + " ms. Frames received: " + this.framesReceived + ". Dropped: " + this.framesDropped + ". Rendered: " + this.framesRendered + ". Render fps: " + String.format(Locale.US, "%.1f", new Object[]{Float.valueOf(nanos)}) + ". Average render time: " + averageTimeAsString(this.renderTimeNs, this.framesRendered) + ". Average swapBuffer time: " + averageTimeAsString(this.renderSwapBufferTimeNs, this.framesRendered) + ".");
                resetStatistics(nanoTime);
            }
        }
    }

    /* access modifiers changed from: private */
    public void logD(String str) {
        Log.d(TAG, this.name + str);
    }
}
