package com.didi.hummer.component.canvas;

import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;

public class CanvasContext {
    private static final String TAG = "CanvasDrawHelperView";
    private Paint fillPaint = new Paint();
    private Paint linePaint = new Paint();
    private TextPaint textPaint = new TextPaint();

    public CanvasContext() {
        this.fillPaint.setAntiAlias(true);
        this.linePaint.setAntiAlias(true);
        this.textPaint.setAntiAlias(true);
    }

    public Paint getLinePaint() {
        return this.linePaint;
    }

    public TextPaint getTextPaint() {
        return this.textPaint;
    }

    public Paint getFillPaint() {
        return this.fillPaint;
    }

    public void lineWidth(float f) {
        this.linePaint.setStrokeWidth(f);
    }

    public void lineCap(int i) {
        if (i == 0) {
            this.linePaint.setStrokeCap(Paint.Cap.BUTT);
        } else if (i == 1) {
            this.linePaint.setStrokeCap(Paint.Cap.ROUND);
        } else if (i != 2) {
            this.linePaint.setStrokeCap(Paint.Cap.BUTT);
        } else {
            this.linePaint.setStrokeCap(Paint.Cap.SQUARE);
        }
    }

    public void lineJoin(int i) {
        if (i == 0) {
            this.linePaint.setStrokeJoin(Paint.Join.MITER);
        } else if (i == 1) {
            this.linePaint.setStrokeJoin(Paint.Join.ROUND);
        } else if (i != 2) {
            this.linePaint.setStrokeJoin(Paint.Join.MITER);
        } else {
            this.linePaint.setStrokeJoin(Paint.Join.BEVEL);
        }
    }

    public void lineColor(String str) {
        this.fillPaint.setStyle(Paint.Style.STROKE);
        this.linePaint.setColor(Color.parseColor(str));
    }

    public void fillColor(String str) {
        this.fillPaint.setStyle(Paint.Style.FILL);
        this.fillPaint.setColor(Color.parseColor(str));
    }

    public void textColor(String str) {
        this.textPaint.setColor(Color.parseColor(str));
    }
}
