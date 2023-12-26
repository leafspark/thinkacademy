package com.tal.app.thinkacademy.live.business.topic.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tal.app.thinkacademy.lib.util.constant.AppConfig;
import com.tal.app.thinkacademy.live.business.R;

public final class CountdownView extends View {
    private static final String TAG = "CountdownView";
    private static final float strokeWidth = 6.0f;
    private int angle = 0;
    private int centerX;
    private int centerY;
    private int countdownTime;
    private int height;
    private Paint innerPaint;
    private Paint outPaint;
    private int radius;
    private int realCountDownTime;
    private int width;

    public CountdownView(Context context) {
        super(context);
        initPaint();
    }

    public CountdownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initPaint();
    }

    public CountdownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initPaint();
    }

    public void setCountdownTime(int i, int i2) {
        this.countdownTime = i;
        this.realCountDownTime = i2;
        initAngle();
    }

    private void initAngle() {
        this.angle = (this.countdownTime - this.realCountDownTime) * sweepAngle();
    }

    public void invalidateView() {
        if (this.angle < 360) {
            invalidate();
            this.angle += sweepAngle();
        }
    }

    private void initPaint() {
        Paint paint = new Paint();
        this.outPaint = paint;
        paint.setColor(getResources().getColor(R.color.color_ffaa0a, (Resources.Theme) null));
        this.outPaint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.innerPaint = paint2;
        paint2.setColor(getResources().getColor(17170443, (Resources.Theme) null));
        this.innerPaint.setAntiAlias(true);
    }

    private void drawArcByTime(Canvas canvas) {
        canvas.drawArc(new RectF(strokeWidth, strokeWidth, ((float) this.width) - strokeWidth, ((float) this.height) - strokeWidth), -90.0f, (float) this.angle, true, this.innerPaint);
    }

    private int sweepAngle() {
        int i = this.countdownTime;
        if (i != 0) {
            return AppConfig.SCREEN_RESOLUTION_PORTRAIT_MIN / i;
        }
        throw new IllegalArgumentException("countdownTime must be than 0");
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        int i5 = i / 2;
        this.centerX = i5;
        this.centerY = i2 / 2;
        this.radius = i5;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle((float) this.centerX, (float) this.centerY, (float) this.radius, this.outPaint);
        drawArcByTime(canvas);
    }
}
