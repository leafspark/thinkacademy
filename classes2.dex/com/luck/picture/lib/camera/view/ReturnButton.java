package com.luck.picture.lib.camera.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class ReturnButton extends View {
    private int center_X;
    private int center_Y;
    private Paint paint;
    Path path;
    private int size;
    private float strokeWidth;

    public ReturnButton(Context context, int i) {
        this(context);
        this.size = i;
        int i2 = i / 2;
        this.center_X = i2;
        this.center_Y = i2;
        this.strokeWidth = ((float) i) / 15.0f;
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setAntiAlias(true);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.strokeWidth);
        this.path = new Path();
    }

    public ReturnButton(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = this.size;
        setMeasuredDimension(i3, i3 / 2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path2 = this.path;
        float f = this.strokeWidth;
        path2.moveTo(f, f / 2.0f);
        this.path.lineTo((float) this.center_X, ((float) this.center_Y) - (this.strokeWidth / 2.0f));
        Path path3 = this.path;
        float f2 = this.strokeWidth;
        path3.lineTo(((float) this.size) - f2, f2 / 2.0f);
        canvas.drawPath(this.path, this.paint);
    }
}
