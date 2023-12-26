package com.xueersi.tborad.extensions.rule;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;

public class TriangularRulerView extends View {
    private static final String TAG = "TriangularRulerView";
    private float angle;
    private final String backgroundColor;
    private final int baseLength;
    private int interval;
    private int[] lengthList;
    private Paint mLinePaint;
    private float padding;
    private PointF pointA;
    private final PointF pointA1;
    private PointF pointB;
    private final PointF pointB1;
    private PointF pointC;
    private final PointF pointC1;
    private Paint textPaint;

    public TriangularRulerView(Context context) {
        this(context, (AttributeSet) null);
        init();
    }

    public TriangularRulerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init();
    }

    public TriangularRulerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.backgroundColor = "#405B4837";
        this.pointA = null;
        this.pointB = null;
        this.pointC = null;
        this.pointA1 = new PointF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
        this.pointB1 = new PointF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
        this.pointC1 = new PointF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
        this.angle = CropImageView.DEFAULT_ASPECT_RATIO;
        this.interval = 20;
        this.padding = 60.0f;
        this.baseLength = 20;
        this.lengthList = new int[]{60, 20, 20, 20, 20, 40, 20, 20, 20, 20};
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.mLinePaint = paint;
        paint.setColor(-16777216);
        this.mLinePaint.setAntiAlias(true);
        this.mLinePaint.setStyle(Paint.Style.STROKE);
        this.mLinePaint.setStrokeWidth(2.0f);
        Paint paint2 = new Paint();
        this.textPaint = paint2;
        paint2.setAntiAlias(true);
        this.textPaint.setTextSize(50.0f);
        this.textPaint.setStrokeWidth(4.0f);
        this.textPaint.setColor(-16777216);
        this.textPaint.setStyle(Paint.Style.FILL);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, TriangularRulerView.class);
                TriangularRulerView.this.postInvalidate();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
    }

    public void setParams(List<PointF> list, float f, float f2) {
        if (list != null && list.size() >= 3 && list.get(0) != null && list.get(1) != null && list.get(2) != null) {
            this.pointA = list.get(0);
            this.pointB = list.get(1);
            this.pointC = list.get(2);
            this.padding = f;
            this.angle = f2;
            invalidate();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (action == 0) {
            if (!(this.pointA == null || this.pointB == null || this.pointC == null)) {
                this.pointA = null;
                this.pointB = null;
                this.pointC = null;
            }
        } else if (action == 1) {
            if (this.pointA == null) {
                this.pointA = new PointF(x, y);
            } else if (this.pointB == null) {
                this.pointB = new PointF(x, y);
            } else if (this.pointC == null) {
                this.pointC = new PointF(x, y);
            }
        }
        invalidate();
        return true;
    }

    private boolean calculate(PointF[] pointFArr, float f, PointF[] pointFArr2) {
        boolean z = f > CropImageView.DEFAULT_ASPECT_RATIO;
        float abs = Math.abs(f);
        int i = 0;
        while (i < 3) {
            int i2 = i + 1;
            int i3 = i2 % 3;
            int i4 = (i + 2) % 3;
            int i5 = i % 3;
            double sin = (double) ((float) (((double) abs) / Math.sin((double) (calculateAngle(new PointF(pointFArr[i3].x - pointFArr[i5].x, pointFArr[i3].y - pointFArr[i5].y), new PointF(pointFArr[i4].x - pointFArr[i5].x, pointFArr[i4].y - pointFArr[i5].y)) / 2.0f))));
            double calculateMidAngle = (double) calculateMidAngle(new PointF(pointFArr[i3].x - pointFArr[i].x, pointFArr[i3].y - pointFArr[i5].y), new PointF(pointFArr[i4].x - pointFArr[i5].x, pointFArr[i4].y - pointFArr[i5].y));
            float sin2 = (float) (sin * Math.sin(calculateMidAngle));
            pointFArr2[i5].x = pointFArr[i5].x + ((float) (Math.cos(calculateMidAngle) * sin));
            pointFArr2[i5].y = pointFArr[i5].y + sin2;
            i = i2;
        }
        if (!z ? getDistance(pointFArr2[0], pointFArr2[1]) < getDistance(pointFArr[0], pointFArr[1]) : getDistance(pointFArr2[0], pointFArr2[1]) > getDistance(pointFArr[0], pointFArr[1])) {
            for (int i6 = 0; i6 < 3; i6++) {
                pointFArr2[i6].x = (pointFArr[i6].x * 2.0f) - pointFArr2[i6].x;
                pointFArr2[i6].y = (pointFArr[i6].y * 2.0f) - pointFArr2[i6].y;
            }
        }
        int i7 = 0;
        while (i7 < 3) {
            boolean isInTriangle = isInTriangle(pointFArr[0], pointFArr[1], pointFArr[2], pointFArr2[i7]);
            if (z && !isInTriangle) {
                Toast.makeText(getContext(), "三角形面积太小1，失败", 0).show();
                return false;
            } else if (z || !isInTriangle) {
                int i8 = i7 + 1;
                int i9 = i8 % 3;
                int i10 = (i7 + 2) % 3;
                int i11 = i7 % 3;
                if (calculateAngle(new PointF(pointFArr[i9].x - pointFArr[i11].x, pointFArr[i9].y - pointFArr[i11].y), new PointF(pointFArr[i10].x - pointFArr[i11].x, pointFArr[i10].y - pointFArr[i11].y)) * calculateAngle(new PointF(pointFArr2[i9].x - pointFArr2[i11].x, pointFArr2[i9].y - pointFArr2[i11].y), new PointF(pointFArr2[i10].x - pointFArr2[i11].x, pointFArr2[i10].y - pointFArr2[i11].y)) < CropImageView.DEFAULT_ASPECT_RATIO) {
                    Toast.makeText(getContext(), "三角形面积太小2，失败", 0).show();
                    return false;
                }
                i7 = i8;
            } else {
                Toast.makeText(getContext(), "三角形面积太小1，失败", 0).show();
                return false;
            }
        }
        return true;
    }

    public static boolean isInTriangle(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        PointF pointF5 = new PointF(pointF4.x - pointF.x, pointF4.y - pointF.y);
        PointF pointF6 = new PointF(pointF4.x - pointF2.x, pointF4.y - pointF2.y);
        PointF pointF7 = new PointF(pointF4.x - pointF3.x, pointF4.y - pointF3.y);
        float f = (pointF5.x * pointF6.y) - (pointF5.y * pointF6.x);
        float f2 = (pointF6.x * pointF7.y) - (pointF6.y * pointF7.x);
        float f3 = (pointF7.x * pointF5.y) - (pointF7.y * pointF5.x);
        if (f > CropImageView.DEFAULT_ASPECT_RATIO || f2 > CropImageView.DEFAULT_ASPECT_RATIO || f3 > CropImageView.DEFAULT_ASPECT_RATIO) {
            return f > CropImageView.DEFAULT_ASPECT_RATIO && f2 > CropImageView.DEFAULT_ASPECT_RATIO && f3 > CropImageView.DEFAULT_ASPECT_RATIO;
        }
        return true;
    }

    private float getDistance(PointF pointF, PointF pointF2) {
        return (float) Math.sqrt((double) (((pointF.x - pointF2.x) * (pointF.x - pointF2.x)) + ((pointF.y - pointF2.y) * (pointF.y - pointF2.y))));
    }

    private float calculateAngle(PointF pointF, PointF pointF2) {
        return ((float) Math.atan2((double) pointF2.y, (double) pointF2.x)) - ((float) Math.atan2((double) pointF.y, (double) pointF.x));
    }

    private float calculateMidAngle(PointF pointF, PointF pointF2) {
        return (((float) Math.atan2((double) pointF2.y, (double) pointF2.x)) + ((float) Math.atan2((double) pointF.y, (double) pointF.x))) / 2.0f;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        PointF pointF;
        super.onDraw(canvas);
        canvas.save();
        boolean z = false;
        if (!(this.pointA == null || (pointF = this.pointB) == null || this.pointC == null)) {
            double d = (double) (((pointF.x - this.pointA.x) * (this.pointC.y - this.pointA.y)) - ((this.pointC.x - this.pointA.x) * (this.pointB.y - this.pointA.y)));
            float f = this.angle;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                canvas.rotate(f, this.pointA.x, this.pointA.y);
            }
            z = calculate(new PointF[]{this.pointA, this.pointB, this.pointC}, this.padding, new PointF[]{this.pointA1, this.pointB1, this.pointC1});
            Paint paint = new Paint();
            paint.setColor(Color.parseColor("#405B4837"));
            Path path = new Path();
            path.moveTo(this.pointA.x, this.pointA.y);
            path.lineTo(this.pointB.x, this.pointB.y);
            path.lineTo(this.pointC.x, this.pointC.y);
            path.close();
            canvas.drawPath(path, paint);
            Path path2 = new Path();
            path2.moveTo(this.pointA.x, this.pointA.y);
            path2.lineTo(this.pointB.x, this.pointB.y);
            path2.lineTo(this.pointC.x, this.pointC.y);
            if (z) {
                Path path3 = new Path();
                path3.moveTo(this.pointA1.x, this.pointA1.y);
                path3.lineTo(this.pointB1.x, this.pointB1.y);
                path3.lineTo(this.pointC1.x, this.pointC1.y);
                path2.op(path3, Path.Op.XOR);
            }
            path2.close();
            canvas.drawPath(path2, paint);
            if (!z) {
                canvas.drawText("A", this.pointA.x, this.pointA.y, this.textPaint);
                canvas.drawText("B", this.pointB.x, this.pointB.y, this.textPaint);
                canvas.drawText("C", this.pointC.x, this.pointC.y, this.textPaint);
                return;
            }
            PointF pointF2 = this.pointA1;
            Canvas canvas2 = canvas;
            double d2 = d;
            drawRuler(canvas2, pointF2, this.pointB1, pointF2, d2);
            PointF pointF3 = this.pointB1;
            drawRuler(canvas2, pointF3, this.pointC1, pointF3, d2);
            PointF pointF4 = this.pointC1;
            PointF pointF5 = this.pointA1;
            drawRuler(canvas2, pointF4, pointF5, pointF5, d2);
        }
        PointF pointF6 = this.pointA;
        if (pointF6 != null) {
            canvas.drawText("A", pointF6.x, this.pointA.y, this.textPaint);
        }
        PointF pointF7 = this.pointB;
        if (pointF7 != null) {
            canvas.drawText("B", pointF7.x, this.pointB.y, this.textPaint);
        }
        PointF pointF8 = this.pointC;
        if (pointF8 != null) {
            canvas.drawText("C", pointF8.x, this.pointC.y, this.textPaint);
        }
        if (!(!z || this.pointA == null || this.pointB == null || this.pointC == null)) {
            canvas.drawText("A1", this.pointA1.x, this.pointA1.y, this.textPaint);
            canvas.drawText("B1", this.pointB1.x, this.pointB1.y, this.textPaint);
            canvas.drawText("C1", this.pointC1.x, this.pointC1.y, this.textPaint);
        }
        canvas.restore();
    }

    private void drawRuler(Canvas canvas, PointF pointF, PointF pointF2, PointF pointF3, double d) {
        int i;
        Canvas canvas2 = canvas;
        PointF pointF4 = pointF;
        PointF pointF5 = pointF2;
        PointF pointF6 = pointF3;
        if (canvas2 != null && pointF4 != null && pointF5 != null && d != 0.0d) {
            float calculateDegrees = calculateDegrees(pointF5, pointF4);
            canvas2.rotate(calculateDegrees, pointF4.x, pointF4.y);
            Log.i(TAG, "canvas.rotate = " + calculateDegrees);
            float accurancyDistance = getAccurancyDistance(pointF5, pointF4);
            int i2 = ((int) accurancyDistance) / this.interval;
            int i3 = 0;
            if (i > 0) {
                canvas2.translate(CropImageView.DEFAULT_ASPECT_RATIO, (float) (-this.lengthList[0]));
                if (pointF6 == pointF5) {
                    for (int i4 = 0; i4 < i2; i4++) {
                        canvas.drawLine(pointF4.x + accurancyDistance, pointF4.y, pointF4.x + accurancyDistance, pointF4.y + ((float) this.lengthList[i4 % 10]), this.mLinePaint);
                        canvas2.translate((float) (-this.interval), CropImageView.DEFAULT_ASPECT_RATIO);
                    }
                    canvas2.translate((float) (this.interval * i2), CropImageView.DEFAULT_ASPECT_RATIO);
                    canvas2.translate(CropImageView.DEFAULT_ASPECT_RATIO, (float) this.lengthList[0]);
                    canvas2.rotate(-calculateDegrees, this.pointC1.x, this.pointC1.y);
                    return;
                }
                for (int i5 = 0; i5 < i2; i5++) {
                    canvas.drawLine(pointF4.x, pointF4.y, pointF4.x, pointF4.y + ((float) this.lengthList[i5 % 10]), this.mLinePaint);
                    canvas2.translate((float) this.interval, CropImageView.DEFAULT_ASPECT_RATIO);
                }
                canvas2.translate((float) ((-this.interval) * i2), CropImageView.DEFAULT_ASPECT_RATIO);
                canvas2.translate(CropImageView.DEFAULT_ASPECT_RATIO, (float) this.lengthList[0]);
                canvas2.rotate(-calculateDegrees, pointF4.x, pointF4.y);
            } else if (pointF6 == pointF5) {
                while (i3 < i2) {
                    canvas.drawLine(pointF4.x + accurancyDistance, pointF4.y + (this.padding - ((float) this.lengthList[i3 % 10])), pointF4.x + accurancyDistance, this.padding + pointF4.y, this.mLinePaint);
                    canvas2.translate((float) (-this.interval), CropImageView.DEFAULT_ASPECT_RATIO);
                    i3++;
                }
                canvas2.translate((float) (this.interval * i2), CropImageView.DEFAULT_ASPECT_RATIO);
                canvas2.rotate(-calculateDegrees, pointF4.x, pointF4.y);
            } else {
                while (i3 < i2) {
                    canvas.drawLine(pointF4.x, pointF4.y + (this.padding - ((float) this.lengthList[i3 % 10])), pointF4.x, this.padding + pointF4.y, this.mLinePaint);
                    canvas2.translate((float) this.interval, CropImageView.DEFAULT_ASPECT_RATIO);
                    i3++;
                }
                canvas2.translate((float) ((-this.interval) * i2), CropImageView.DEFAULT_ASPECT_RATIO);
                canvas2.rotate(-calculateDegrees, pointF4.x, pointF4.y);
            }
        }
    }

    private float calculateDegrees(PointF pointF, PointF pointF2) {
        return (float) Math.toDegrees((double) ((float) Math.atan2((double) (pointF.y - pointF2.y), (double) (pointF.x - pointF2.x))));
    }

    public float getAccurancyDistance(PointF pointF, PointF pointF2) {
        return (float) Math.sqrt(Math.pow((double) (pointF.x - pointF2.x), 2.0d) + Math.pow((double) (pointF.y - pointF2.y), 2.0d));
    }
}
