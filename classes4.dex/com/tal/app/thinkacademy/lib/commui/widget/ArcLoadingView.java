package com.tal.app.thinkacademy.lib.commui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.util.SizeUtils;

public class ArcLoadingView extends View {
    private static final int INTER_CIRCLE_ANGLE = -180;
    int circleWitdh;
    int diff;
    float lineWidth;
    private RectF mInnerCircleRectF;
    private Paint mStrokePaint;
    private Path path;

    public ArcLoadingView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ArcLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ArcLoadingView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public ArcLoadingView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.lineWidth = 1.0f;
        this.circleWitdh = SizeUtils.dp2px(2.0f);
        this.diff = SizeUtils.dp2px(5.0f);
        initView(context, attributeSet);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        int color = context.getResources().getColor(R.color.color_fd7924);
        this.mInnerCircleRectF = new RectF();
        initPaint(this.lineWidth, color);
        this.path = new Path();
    }

    private void initPaint(float f, int i) {
        Paint paint = new Paint();
        this.mStrokePaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mStrokePaint.setStrokeWidth(f);
        this.mStrokePaint.setColor(i);
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStrokeCap(Paint.Cap.ROUND);
        this.mStrokePaint.setStrokeJoin(Paint.Join.ROUND);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = (float) (getWidth() / 2);
        float height = (float) (getHeight() / 2);
        if (this.lineWidth <= width) {
            RectF rectF = this.mInnerCircleRectF;
            int i = this.diff;
            int i2 = this.circleWitdh;
            rectF.set(0.0f, (((float) i) + height) - ((float) (i2 / 2)), (float) i2, ((float) i) + width + ((float) (i2 / 2)));
            this.path.moveTo(0.0f, ((float) this.diff) + height);
            float f = 2.0f * height;
            this.path.quadTo(12.0f, f - 10.0f, width, f - ((float) (this.circleWitdh / 2)));
            this.path.quadTo(15.0f, f - 12.0f, (float) this.circleWitdh, height + ((float) this.diff));
            this.path.addArc(this.mInnerCircleRectF, 0.0f, -180.0f);
            canvas.drawPath(this.path, this.mStrokePaint);
            canvas.save();
            canvas.restore();
            return;
        }
        throw new IllegalArgumentException("lineWidth值太大了");
    }
}
