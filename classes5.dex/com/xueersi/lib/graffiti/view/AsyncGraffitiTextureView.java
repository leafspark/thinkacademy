package com.xueersi.lib.graffiti.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.View;
import com.xueersi.lib.graffiti.utils.XesLog;

public class AsyncGraffitiTextureView extends BaseAsyncGraffitiView {
    private TextureView textureView;

    /* access modifiers changed from: protected */
    public void setVisibility(int i) {
    }

    /* access modifiers changed from: protected */
    public boolean useBitmapDoubleCached() {
        return false;
    }

    public AsyncGraffitiTextureView(Context context) {
        super(context);
        this.textureView = new DrawTextureView(context);
    }

    public View getDrawView() {
        return this.textureView;
    }

    /* access modifiers changed from: protected */
    public void post(Runnable runnable) {
        this.textureView.post(runnable);
    }

    /* access modifiers changed from: protected */
    public void postInvalidate() {
        Canvas canvas = null;
        try {
            canvas = this.textureView.lockCanvas();
            if (canvas != null) {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                onDraw(canvas);
            }
            if (canvas == null) {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (0 == 0) {
                return;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                this.textureView.unlockCanvasAndPost((Canvas) null);
            }
            throw th;
        }
        this.textureView.unlockCanvasAndPost(canvas);
    }

    class DrawTextureView extends TextureView implements TextureView.SurfaceTextureListener {
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public DrawTextureView(Context context) {
            super(context);
            setOpaque(false);
            setSurfaceTextureListener(this);
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            AsyncGraffitiTextureView.this.postInvalidate();
            if (XesLog.isEnabled()) {
                XesLog.d("DrawTextureView:onSurfaceTextureAvailable");
            }
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            AsyncGraffitiTextureView.this.postInvalidate();
            if (XesLog.isEnabled()) {
                XesLog.d("DrawTextureView:onSurfaceTextureSizeChanged");
            }
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (!XesLog.isEnabled()) {
                return true;
            }
            XesLog.d("DrawTextureView:onSurfaceTextureDestroyed");
            return true;
        }

        /* access modifiers changed from: protected */
        public void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            AsyncGraffitiTextureView.this.onSizeChanged(i, i2, i3, i4);
            if (XesLog.isEnabled()) {
                XesLog.d("DrawTextureView:onSizeChanged");
            }
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            AsyncGraffitiTextureView.this.onAttachedToWindow();
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            AsyncGraffitiTextureView.this.onDetachedFromWindow();
            if (XesLog.isEnabled()) {
                XesLog.d("DrawTextureView:onDetachedFromWindow");
            }
        }
    }
}
