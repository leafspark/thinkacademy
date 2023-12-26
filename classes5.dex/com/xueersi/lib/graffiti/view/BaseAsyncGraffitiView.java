package com.xueersi.lib.graffiti.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.View;
import com.xueersi.lib.graffiti.LocalCanvasSize;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.WorkExecutor;
import com.xueersi.lib.graffiti.entity.DrawActionParams;
import com.xueersi.lib.graffiti.utils.ListUtil;
import com.xueersi.lib.graffiti.utils.XesLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseAsyncGraffitiView {
    protected String TAG = getClass().getSimpleName();
    /* access modifiers changed from: private */
    public volatile AtomicBoolean canvasDirty = new AtomicBoolean(false);
    private Choreographer choreographer;
    private WorkExecutor drawingExecutor;
    Choreographer.FrameCallback frameCallback = new Choreographer.FrameCallback() {
        public void doFrame(long j) {
            BaseAsyncGraffitiView.this.postInvalidate();
            BaseAsyncGraffitiView.this.removeFrameCallback(false);
            if (SystemClock.uptimeMillis() - BaseAsyncGraffitiView.this.lastInvalidateTime < 3000) {
                BaseAsyncGraffitiView.this.postFrameCallback();
            }
        }
    };
    private boolean keepFps = false;
    /* access modifiers changed from: private */
    public long lastInvalidateTime = 0;
    protected CachedBitmapCanvas mCachedCanvas;
    protected String mHashFlag = "";
    /* access modifiers changed from: private */
    public DrawActionParams mTempDrawAction = null;
    private volatile AtomicInteger postCount = new AtomicInteger(0);

    public abstract View getDrawView();

    /* access modifiers changed from: protected */
    public abstract void post(Runnable runnable);

    /* access modifiers changed from: protected */
    public abstract void postInvalidate();

    /* access modifiers changed from: protected */
    public abstract void setVisibility(int i);

    /* access modifiers changed from: protected */
    public boolean useBitmapDoubleCached() {
        return true;
    }

    public BaseAsyncGraffitiView(Context context) {
        init();
    }

    public void setKeepFps(boolean z) {
        this.keepFps = z;
    }

    private void init() {
        this.mCachedCanvas = new CachedBitmapCanvas(useBitmapDoubleCached());
        this.mHashFlag = Integer.toHexString(hashCode());
    }

    public void setDrawingExecutor(WorkExecutor workExecutor) {
        this.drawingExecutor = workExecutor;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (canvas != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            CachedBitmapCanvas cachedBitmapCanvas = this.mCachedCanvas;
            if (cachedBitmapCanvas != null) {
                cachedBitmapCanvas.drawOnView(canvas);
            }
            DrawActionParams drawActionParams = this.mTempDrawAction;
            if (!(drawActionParams == null || drawActionParams.getDrawableObject() == null)) {
                this.mTempDrawAction.getDrawableObject().draw(canvas);
            }
            if (XesLog.isEnabled()) {
                XesLog.d("涂鸦：onDraw绘制耗时ms:" + (SystemClock.uptimeMillis() - uptimeMillis) + " >>" + this.mHashFlag);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(final int i, final int i2, int i3, int i4) {
        runOnWorkThread(new Runnable() {
            public void run() {
                int width = LocalCanvasSize.sdkInner().getWidth();
                int height = LocalCanvasSize.sdkInner().getHeight();
                if (BaseAsyncGraffitiView.this.mCachedCanvas != null) {
                    if (width <= 0) {
                        width = i;
                    }
                    if (height <= 0) {
                        height = i2;
                    }
                    BaseAsyncGraffitiView.this.mCachedCanvas.updateSize(width, height);
                    DrawActionParams unused = BaseAsyncGraffitiView.this.mTempDrawAction = null;
                    long unused2 = BaseAsyncGraffitiView.this.lastInvalidateTime = 0;
                    if (XesLog.isEnabled()) {
                        XesLog.d("涂鸦：尺寸变化清空画布:" + i + "*" + i2 + " >>" + BaseAsyncGraffitiView.this.mHashFlag);
                    }
                }
            }
        });
    }

    public void addAction(final DrawActionParams drawActionParams) {
        runOnWorkThread(new Runnable() {
            public void run() {
                BaseAsyncGraffitiView.this.checkCanvasAvailable();
                Canvas lockCanvas = BaseAsyncGraffitiView.this.mCachedCanvas.lockCanvas(false);
                long uptimeMillis = SystemClock.uptimeMillis();
                boolean z = !drawActionParams.isIncrementDraw();
                if (z) {
                    DrawActionParams unused = BaseAsyncGraffitiView.this.mTempDrawAction = drawActionParams;
                } else {
                    if (!(lockCanvas == null || BaseAsyncGraffitiView.this.mCachedCanvas == null || BaseAsyncGraffitiView.this.mTempDrawAction == null)) {
                        BaseAsyncGraffitiView baseAsyncGraffitiView = BaseAsyncGraffitiView.this;
                        baseAsyncGraffitiView.drawIntoBitmap(lockCanvas, baseAsyncGraffitiView.mTempDrawAction);
                        DrawActionParams unused2 = BaseAsyncGraffitiView.this.mTempDrawAction = null;
                    }
                    BaseAsyncGraffitiView.this.drawIntoBitmap(lockCanvas, drawActionParams);
                }
                if (!(!z || drawActionParams.getLastAction() == null || !drawActionParams.getLastAction().checkPointEnd() || lockCanvas == null || BaseAsyncGraffitiView.this.mCachedCanvas == null || BaseAsyncGraffitiView.this.mTempDrawAction == null)) {
                    BaseAsyncGraffitiView baseAsyncGraffitiView2 = BaseAsyncGraffitiView.this;
                    baseAsyncGraffitiView2.drawIntoBitmap(lockCanvas, baseAsyncGraffitiView2.mTempDrawAction);
                    DrawActionParams unused3 = BaseAsyncGraffitiView.this.mTempDrawAction = null;
                }
                if (XesLog.isEnabled()) {
                    XesLog.d("涂鸦：绘制一次耗时:" + (SystemClock.uptimeMillis() - uptimeMillis) + " >>" + BaseAsyncGraffitiView.this.mHashFlag);
                }
                BaseAsyncGraffitiView.this.canvasDirty.set(true);
                BaseAsyncGraffitiView.this.mCachedCanvas.unlockCanvasAndPost(lockCanvas);
                BaseAsyncGraffitiView.this.dispatchInvalidate(true);
            }
        });
    }

    /* access modifiers changed from: private */
    public void checkCanvasAvailable() {
        CachedBitmapCanvas cachedBitmapCanvas = this.mCachedCanvas;
        if (cachedBitmapCanvas != null && !cachedBitmapCanvas.available()) {
            this.mCachedCanvas.updateSize(LocalCanvasSize.sdkInner().getWidth(), LocalCanvasSize.sdkInner().getHeight());
        }
    }

    public void resetActions(final List<DrawActionParams> list) {
        WorkExecutor workExecutor = this.drawingExecutor;
        if (workExecutor != null) {
            workExecutor.removeTaskByGroupId(this.mHashFlag);
        }
        runOnWorkThread(new Runnable() {
            public void run() {
                DrawActionParams unused = BaseAsyncGraffitiView.this.mTempDrawAction = null;
                BaseAsyncGraffitiView.this.onAddActions(list, true);
            }
        });
    }

    public void addActions(final List<DrawActionParams> list) {
        runOnWorkThread(new Runnable() {
            public void run() {
                BaseAsyncGraffitiView.this.onAddActions(list, false);
            }
        });
    }

    /* access modifiers changed from: private */
    public void onAddActions(List<DrawActionParams> list, boolean z) {
        checkCanvasAvailable();
        long uptimeMillis = SystemClock.uptimeMillis();
        Canvas lockCanvas = this.mCachedCanvas.lockCanvas(z && this.canvasDirty.get());
        if (z && lockCanvas != null) {
            lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        if (!(list == null || lockCanvas == null)) {
            for (DrawActionParams drawIntoBitmap : list) {
                drawIntoBitmap(lockCanvas, drawIntoBitmap);
            }
        }
        this.mCachedCanvas.unlockCanvasAndPost(lockCanvas);
        if (XesLog.isEnabled()) {
            XesLog.d("涂鸦：批量绘制" + ListUtil.size(list) + "个线条耗时:" + (SystemClock.uptimeMillis() - uptimeMillis) + " >>" + this.mHashFlag);
        }
        this.canvasDirty.set(true);
        dispatchInvalidate(!z);
    }

    /* access modifiers changed from: private */
    public void drawIntoBitmap(Canvas canvas, DrawActionParams drawActionParams) {
        if (canvas != null && drawActionParams != null && drawActionParams.getDrawableObject() != null && drawActionParams.getLastAction() != null) {
            if (ListUtil.isNotEmpty(drawActionParams.getActionList())) {
                for (WXWBAction next : drawActionParams.getActionList()) {
                    if (next != null) {
                        drawActionParams.getDrawableObject().incrementDraw(canvas, next);
                    }
                }
                return;
            }
            drawActionParams.getDrawableObject().incrementDraw(canvas, drawActionParams.getLastAction());
        }
    }

    private void runOnWorkThread(Runnable runnable) {
        WorkExecutor workExecutor = this.drawingExecutor;
        if (workExecutor != null) {
            workExecutor.submitTask(this.mHashFlag, runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        this.choreographer = Choreographer.getInstance();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        try {
            WorkExecutor workExecutor = this.drawingExecutor;
            if (workExecutor != null) {
                workExecutor.removeTaskByGroupId(this.mHashFlag);
            }
            runOnWorkThread(new Runnable() {
                public void run() {
                    if (BaseAsyncGraffitiView.this.mCachedCanvas != null) {
                        BaseAsyncGraffitiView.this.mCachedCanvas.recycle();
                    }
                    BaseAsyncGraffitiView.this.canvasDirty.set(false);
                }
            });
            removeFrameCallback(true);
            this.lastInvalidateTime = 0;
            this.choreographer = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        runOnWorkThread(new Runnable() {
            public void run() {
                if (BaseAsyncGraffitiView.this.mCachedCanvas != null) {
                    BaseAsyncGraffitiView.this.mCachedCanvas.clearDisplay();
                }
                DrawActionParams unused = BaseAsyncGraffitiView.this.mTempDrawAction = null;
                BaseAsyncGraffitiView.this.canvasDirty.set(false);
                BaseAsyncGraffitiView.this.dispatchInvalidate(false);
            }
        });
    }

    /* access modifiers changed from: private */
    public void dispatchInvalidate(boolean z) {
        if (this.choreographer == null || !z || !this.keepFps) {
            this.lastInvalidateTime = 0;
            postInvalidate();
            return;
        }
        this.lastInvalidateTime = SystemClock.uptimeMillis();
        postFrameCallback();
    }

    /* access modifiers changed from: private */
    public void postFrameCallback() {
        if (this.postCount.get() <= 0) {
            this.postCount.set(1);
            Choreographer choreographer2 = this.choreographer;
            if (choreographer2 != null) {
                choreographer2.postFrameCallback(this.frameCallback);
            }
        }
    }

    /* access modifiers changed from: private */
    public void removeFrameCallback(boolean z) {
        Choreographer choreographer2;
        if (this.postCount.get() > 0) {
            this.postCount.set(0);
            if (z && (choreographer2 = this.choreographer) != null) {
                choreographer2.removeFrameCallback(this.frameCallback);
            }
        }
    }

    public void destroy() {
        onDetachedFromWindow();
    }
}
