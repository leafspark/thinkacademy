package com.xueersi.lib.graffiti.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public class AsyncGraffitiNormalView extends BaseAsyncGraffitiView {
    private View drawView;

    public AsyncGraffitiNormalView(Context context) {
        super(context);
        this.drawView = new DrawView(context);
    }

    public View getDrawView() {
        return this.drawView;
    }

    /* access modifiers changed from: protected */
    public void post(Runnable runnable) {
        this.drawView.post(runnable);
    }

    /* access modifiers changed from: protected */
    public void setVisibility(int i) {
        this.drawView.setVisibility(i);
    }

    /* access modifiers changed from: protected */
    public void postInvalidate() {
        this.drawView.postInvalidate();
    }

    class DrawView extends View {
        public DrawView(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            AsyncGraffitiNormalView.this.onSizeChanged(i, i2, i3, i4);
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.save();
            AsyncGraffitiNormalView.this.onDraw(canvas);
            canvas.restore();
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            AsyncGraffitiNormalView.this.onDetachedFromWindow();
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            AsyncGraffitiNormalView.this.onAttachedToWindow();
        }
    }
}
