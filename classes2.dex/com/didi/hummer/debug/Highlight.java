package com.didi.hummer.debug;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class Highlight {
    /* access modifiers changed from: private */
    public static HighlightLayer layer;

    public static void show(View view) {
        if (layer == null) {
            layer = new HighlightLayer(view.getContext());
            ((ViewGroup) ((Activity) view.getContext()).getWindow().getDecorView()).addView(layer);
        }
        layer.hide();
        layer.post(new Highlight$$ExternalSyntheticLambda0(view));
    }

    public static void clear() {
        HighlightLayer highlightLayer = layer;
        if (highlightLayer != null) {
            highlightLayer.hide();
            ((ViewGroup) ((Activity) layer.getContext()).getWindow().getDecorView()).removeView(layer);
            layer = null;
        }
    }

    private static class HighlightLayer extends View {
        private Paint mPaint;
        private Rect mRect = new Rect();

        public void hide() {
        }

        public HighlightLayer(Context context) {
            super(context, (AttributeSet) null);
            init();
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            HighlightLayer unused = Highlight.layer = null;
        }

        private void init() {
            Paint paint = new Paint(1);
            this.mPaint = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(8.0f);
            this.mPaint.setColor(-1593901056);
        }

        public void show(View view) {
            int[] iArr = new int[2];
            view.getDrawingRect(this.mRect);
            view.getLocationOnScreen(iArr);
            this.mRect.left = iArr[0];
            this.mRect.top = iArr[1];
            this.mRect.right += this.mRect.left;
            this.mRect.bottom += this.mRect.top;
            postInvalidate();
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawRect(this.mRect, this.mPaint);
        }
    }
}
