package com.xueersi.lib.graffiti.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.TextureView;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.utils.CatchHandler;
import com.xueersi.lib.graffiti.utils.XesLog;
import java.util.List;

public class DrawingBoardTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    /* access modifiers changed from: private */
    public BaseDrawLayer mGraffitiLayer;
    /* access modifiers changed from: private */
    public BaseDrawLayer mShapeLayer;
    private Handler mWorkHandler;

    public DrawingBoardTextureView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DrawingBoardTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawingBoardTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mGraffitiLayer = new RealTimeDrawLayer();
        this.mShapeLayer = new RealTimeDrawLayer();
        this.mWorkHandler = null;
        setOpaque(false);
        setSurfaceTextureListener(this);
    }

    public void clear(String str) {
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            AnonymousClass1 r0 = new DrawRunnable() {
                public void beforeRun() {
                    DrawingBoardTextureView.this.mGraffitiLayer.removeAllObjects();
                    DrawingBoardTextureView.this.mShapeLayer.removeAllObjects();
                }
            };
            if (!(handler instanceof Handler)) {
                handler.post(r0);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, r0);
            }
        }
    }

    public void clearAll() {
        clear("");
    }

    public void updateGraffiti(String str, int i, final DrawableObject drawableObject, boolean z, boolean z2) {
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            AnonymousClass2 r2 = new DrawRunnable() {
                public void beforeRun() {
                    DrawingBoardTextureView.this.mGraffitiLayer.updateDrawableObj(drawableObject);
                }
            };
            if (!(handler instanceof Handler)) {
                handler.post(r2);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, r2);
            }
        }
    }

    public void deleteGraffiti(String str, int i, final DrawableObject drawableObject) {
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            AnonymousClass3 r2 = new DrawRunnable() {
                public void beforeRun() {
                    DrawingBoardTextureView.this.mGraffitiLayer.removeDrawableObj(drawableObject);
                }
            };
            if (!(handler instanceof Handler)) {
                handler.post(r2);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, r2);
            }
        }
    }

    public void deleteShape(String str, int i, final DrawableObject drawableObject) {
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            AnonymousClass4 r2 = new DrawRunnable() {
                public void beforeRun() {
                    DrawingBoardTextureView.this.mShapeLayer.removeDrawableObj(drawableObject);
                }
            };
            if (!(handler instanceof Handler)) {
                handler.post(r2);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, r2);
            }
        }
    }

    public void updateShape(String str, int i, final DrawableObject drawableObject, boolean z) {
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            AnonymousClass5 r2 = new DrawRunnable() {
                public void beforeRun() {
                    DrawingBoardTextureView.this.mShapeLayer.updateDrawableObj(drawableObject);
                }
            };
            if (!(handler instanceof Handler)) {
                handler.post(r2);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, r2);
            }
        }
    }

    public void resetAllGraphics(String str, final List<DrawableObject> list, final List<DrawableObject> list2) {
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            AnonymousClass6 r0 = new DrawRunnable() {
                public void beforeRun() {
                    DrawingBoardTextureView.this.mShapeLayer.removeAllObjects();
                    DrawingBoardTextureView.this.mShapeLayer.addAllObjects(list2);
                    DrawingBoardTextureView.this.mGraffitiLayer.removeAllObjects();
                    DrawingBoardTextureView.this.mGraffitiLayer.addAllObjects(list);
                }
            };
            if (!(handler instanceof Handler)) {
                handler.post(r0);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, r0);
            }
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        HandlerThread handlerThread = new HandlerThread("DrawingBoardSurfaceView");
        handlerThread.start();
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            handler.getLooper().quitSafely();
        }
        this.mWorkHandler = new CatchHandler(handlerThread.getLooper());
        this.mGraffitiLayer.onSizeChanged(i, i2);
        this.mShapeLayer.onSizeChanged(i, i2);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i, final int i2) {
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            AnonymousClass7 r0 = new DrawRunnable() {
                public void beforeRun() {
                    DrawingBoardTextureView.this.mGraffitiLayer.onSizeChanged(i, i2);
                    DrawingBoardTextureView.this.mShapeLayer.onSizeChanged(i, i2);
                }
            };
            if (!(handler instanceof Handler)) {
                handler.post(r0);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, r0);
            }
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Handler handler = this.mWorkHandler;
        if (handler == null) {
            return false;
        }
        handler.getLooper().quitSafely();
        this.mWorkHandler = null;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        if (XesLog.isEnabled()) {
            XesLog.d("onSurfaceTextureUpdated");
        }
    }

    abstract class DrawRunnable implements Runnable {
        /* access modifiers changed from: package-private */
        public abstract void beforeRun();

        DrawRunnable() {
        }

        public final void run() {
            long uptimeMillis = SystemClock.uptimeMillis();
            beforeRun();
            Canvas lockCanvas = DrawingBoardTextureView.this.lockCanvas((Rect) null);
            try {
                lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                int saveLayer = lockCanvas.saveLayer((RectF) null, (Paint) null);
                DrawingBoardTextureView.this.mShapeLayer.onDraw(lockCanvas);
                lockCanvas.restoreToCount(saveLayer);
                int saveLayer2 = lockCanvas.saveLayer((RectF) null, (Paint) null);
                DrawingBoardTextureView.this.mGraffitiLayer.onDraw(lockCanvas);
                lockCanvas.restoreToCount(saveLayer2);
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                if (XesLog.isEnabled()) {
                    XesLog.d("绘制一帧需要时间:" + uptimeMillis2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                DrawingBoardTextureView.this.unlockCanvasAndPost(lockCanvas);
                throw th;
            }
            DrawingBoardTextureView.this.unlockCanvasAndPost(lockCanvas);
        }
    }
}
