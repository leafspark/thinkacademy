package com.amazonaws.mobile.auth.core.signin.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class BackgroundDrawable extends Drawable {
    private static final int DEFAULT_BACKGROUND_COLOR = -1;
    private int backgroundColor;
    private Paint paint;

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public BackgroundDrawable() {
        this.paint = new Paint();
        this.backgroundColor = -1;
    }

    public BackgroundDrawable(int i) {
        this.paint = new Paint();
        this.backgroundColor = i;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.paint.setColor(this.backgroundColor);
        canvas.drawRect(0.0f, 0.0f, (float) bounds.width(), (float) bounds.height(), this.paint);
    }
}
