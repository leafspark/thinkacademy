package com.didi.hummer.component.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.didi.hummer.render.style.HummerStyleUtils;
import java.util.ArrayList;
import java.util.List;

public class CanvasDrawHelperView extends View {
    private static final String TAG = "CanvasDrawHelperView";
    private List<CanvasAction> actions = new ArrayList();
    private CanvasContext canvasContext = new CanvasContext();

    private interface CanvasAction {
        void draw(Canvas canvas);
    }

    public CanvasDrawHelperView(Context context) {
        super(context);
    }

    public CanvasDrawHelperView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CanvasDrawHelperView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CanvasContext getCanvasContext() {
        return this.canvasContext;
    }

    private Paint getLinePaint() {
        return this.canvasContext.getLinePaint();
    }

    private Paint getFillPaint() {
        return this.canvasContext.getFillPaint();
    }

    private TextPaint getTextPaint() {
        return this.canvasContext.getTextPaint();
    }

    private float dp2px(Object obj) {
        return HummerStyleUtils.convertNumber(obj);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (CanvasAction draw : this.actions) {
            draw.draw(canvas);
        }
    }

    public void drawImage(Bitmap bitmap, Object obj, Object obj2, Object obj3, Object obj4) {
        this.actions.add(new CanvasDrawHelperView$$ExternalSyntheticLambda13(this, bitmap, obj3, obj4, obj, obj2));
        invalidate();
    }

    public /* synthetic */ void lambda$drawImage$0$CanvasDrawHelperView(Bitmap bitmap, Object obj, Object obj2, Object obj3, Object obj4, Canvas canvas) {
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(dp2px(obj) / ((float) width), dp2px(obj2) / ((float) height));
            canvas.drawBitmap(Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true), dp2px(obj3), dp2px(obj4), getLinePaint());
        }
    }

    public void fillRect(Object obj, Object obj2, Object obj3, Object obj4) {
        Log.i(TAG, "fillRect do");
        this.actions.add(new CanvasDrawHelperView$$ExternalSyntheticLambda1(this, obj, obj2, obj3, obj4));
        invalidate();
    }

    public /* synthetic */ void lambda$fillRect$1$CanvasDrawHelperView(Object obj, Object obj2, Object obj3, Object obj4, Canvas canvas) {
        getFillPaint().setStyle(Paint.Style.FILL);
        Log.i(TAG, "fillRect Action");
        float dp2px = dp2px(obj);
        float dp2px2 = dp2px(obj2);
        canvas.drawRect(new Rect((int) dp2px, (int) dp2px2, (int) (dp2px + dp2px(obj3)), (int) (dp2px2 + dp2px(obj4))), getFillPaint());
    }

    public void strokeRect(Object obj, Object obj2, Object obj3, Object obj4) {
        this.actions.add(new CanvasDrawHelperView$$ExternalSyntheticLambda3(this, obj, obj2, obj3, obj4));
        invalidate();
    }

    public /* synthetic */ void lambda$strokeRect$2$CanvasDrawHelperView(Object obj, Object obj2, Object obj3, Object obj4, Canvas canvas) {
        getLinePaint().setStyle(Paint.Style.STROKE);
        float dp2px = dp2px(obj);
        float dp2px2 = dp2px(obj2);
        canvas.drawRect(new Rect((int) dp2px, (int) dp2px2, (int) (dp2px + dp2px(obj3)), (int) (dp2px2 + dp2px(obj4))), getLinePaint());
    }

    public void fillCircle(Object obj, Object obj2, Object obj3) {
        this.actions.add(new CanvasDrawHelperView$$ExternalSyntheticLambda15(this, obj, obj2, obj3));
        invalidate();
    }

    public /* synthetic */ void lambda$fillCircle$3$CanvasDrawHelperView(Object obj, Object obj2, Object obj3, Canvas canvas) {
        getFillPaint().setStyle(Paint.Style.FILL);
        canvas.drawCircle(dp2px(obj), dp2px(obj2), dp2px(obj3), getFillPaint());
    }

    public void strokeCircle(Object obj, Object obj2, Object obj3) {
        this.actions.add(new CanvasDrawHelperView$$ExternalSyntheticLambda16(this, obj, obj2, obj3));
        invalidate();
    }

    public /* synthetic */ void lambda$strokeCircle$4$CanvasDrawHelperView(Object obj, Object obj2, Object obj3, Canvas canvas) {
        getLinePaint().setStyle(Paint.Style.STROKE);
        canvas.drawCircle(dp2px(obj), dp2px(obj2), dp2px(obj3), getLinePaint());
    }

    public void fontSize(float f) {
        this.actions.add(new CanvasDrawHelperView$$ExternalSyntheticLambda0(this, f));
    }

    public /* synthetic */ void lambda$fontSize$5$CanvasDrawHelperView(float f, Canvas canvas) {
        getTextPaint().setTextSize(dp2px(Float.valueOf(f)));
    }

    public void fillText(String str, Object obj, Object obj2, Object obj3) {
        this.actions.add(new CanvasDrawHelperView$$ExternalSyntheticLambda5(this, obj, obj2, obj3, str));
        invalidate();
    }

    public /* synthetic */ void lambda$fillText$6$CanvasDrawHelperView(Object obj, Object obj2, Object obj3, String str, Canvas canvas) {
        float dp2px = dp2px(obj);
        float dp2px2 = dp2px(obj2);
        String str2 = str;
        StaticLayout staticLayout = new StaticLayout(str2, getTextPaint(), (int) dp2px(obj3), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        canvas.save();
        canvas.translate(dp2px, dp2px2);
        staticLayout.draw(canvas);
        canvas.restore();
    }

    public void arc(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        this.actions.add(new CanvasDrawHelperView$$ExternalSyntheticLambda4(this, obj, obj2, obj3, obj6, obj4, obj5));
    }

    public /* synthetic */ void lambda$arc$7$CanvasDrawHelperView(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Canvas canvas) {
        float dp2px = dp2px(obj);
        float dp2px2 = dp2px(obj2);
        float dp2px3 = dp2px(obj3);
        boolean parseBoolean = Boolean.parseBoolean(obj4.toString());
        float piToAngle = piToAngle(obj5);
        Canvas canvas2 = canvas;
        canvas2.drawArc(new RectF(dp2px - dp2px3, dp2px2 - dp2px3, dp2px + dp2px3, dp2px2 + dp2px3), piToAngle, getSweepAngle(piToAngle, piToAngle(obj6), parseBoolean), false, getLinePaint());
    }

    private float getSweepAngle(float f, float f2, boolean z) {
        if (f == f2) {
            return 0.0f;
        }
        if (z) {
            return f2 > f ? f2 - (f + 360.0f) : -Math.abs(f - f2);
        }
        if (f2 > f) {
            return f2 - f;
        }
        return 360.0f - Math.abs(f2 - f);
    }

    private float piToAngle(Object obj) {
        return (float) ((Double.parseDouble(obj.toString()) / 3.141592653589793d) * 180.0d);
    }

    public void drawLine(Object obj, Object obj2, Object obj3, Object obj4) {
        Log.i(TAG, "drawLine do");
        this.actions.add(new CanvasDrawHelperView$$ExternalSyntheticLambda17(this, obj, obj2, obj3, obj4));
        invalidate();
    }

    public /* synthetic */ void lambda$drawLine$8$CanvasDrawHelperView(Object obj, Object obj2, Object obj3, Object obj4, Canvas canvas) {
        float dp2px = dp2px(obj);
        float dp2px2 = dp2px(obj2);
        float dp2px3 = dp2px(obj3);
        float dp2px4 = dp2px(obj4);
        Log.i(TAG, "drawLine Action");
        canvas.drawLine(dp2px, dp2px2, dp2px3, dp2px4, getLinePaint());
    }

    public void drawLines(Object[] objArr) {
        this.actions.add(new CanvasDrawHelperView$$ExternalSyntheticLambda9(this, objArr));
        invalidate();
    }

    public /* synthetic */ void lambda$drawLines$9$CanvasDrawHelperView(Object[] objArr, Canvas canvas) {
        float[] fArr = new float[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            fArr[i] = dp2px(objArr[i]);
        }
        Log.i(TAG, "drawLines Action");
        canvas.drawLines(fArr, getLinePaint());
    }

    public void drawPath(CanvasPath canvasPath) {
        this.actions.add(new CanvasDrawHelperView$$ExternalSyntheticLambda14(this, canvasPath));
        invalidate();
    }

    public /* synthetic */ void lambda$drawPath$10$CanvasDrawHelperView(CanvasPath canvasPath, Canvas canvas) {
        canvas.drawPath(canvasPath.getPath(), getLinePaint());
    }

    public void strokeEllipse(Object obj, Object obj2, Object obj3, Object obj4) {
        this.actions.add(new CanvasDrawHelperView$$ExternalSyntheticLambda2(this, obj, obj2, obj3, obj4));
        invalidate();
    }

    public /* synthetic */ void lambda$strokeEllipse$11$CanvasDrawHelperView(Object obj, Object obj2, Object obj3, Object obj4, Canvas canvas) {
        canvas.drawOval(new RectF(dp2px(obj), dp2px(obj2), dp2px(obj3), dp2px(obj4)), getLinePaint());
    }

    public void fillEllipse(Object obj, Object obj2, Object obj3, Object obj4) {
        this.actions.add(new CanvasDrawHelperView$$ExternalSyntheticLambda18(this, obj, obj2, obj3, obj4));
        invalidate();
    }

    public /* synthetic */ void lambda$fillEllipse$12$CanvasDrawHelperView(Object obj, Object obj2, Object obj3, Object obj4, Canvas canvas) {
        canvas.drawOval(new RectF(dp2px(obj), dp2px(obj2), dp2px(obj3), dp2px(obj4)), getFillPaint());
    }

    public void lineWidth(float f) {
        this.actions.add(new CanvasDrawHelperView$$ExternalSyntheticLambda10(this, f));
    }

    public /* synthetic */ void lambda$lineWidth$13$CanvasDrawHelperView(float f, Canvas canvas) {
        this.canvasContext.lineWidth(dp2px(Float.valueOf(f)));
    }

    public void lineCap(int i) {
        this.actions.add(new CanvasDrawHelperView$$ExternalSyntheticLambda11(this, i));
    }

    public /* synthetic */ void lambda$lineCap$14$CanvasDrawHelperView(int i, Canvas canvas) {
        this.canvasContext.lineCap(i);
    }

    public void lineColor(String str) {
        this.actions.add(new CanvasDrawHelperView$$ExternalSyntheticLambda7(this, str));
    }

    public /* synthetic */ void lambda$lineColor$15$CanvasDrawHelperView(String str, Canvas canvas) {
        this.canvasContext.lineColor(str);
    }

    public void lineJoin(int i) {
        this.actions.add(new CanvasDrawHelperView$$ExternalSyntheticLambda12(this, i));
    }

    public /* synthetic */ void lambda$lineJoin$16$CanvasDrawHelperView(int i, Canvas canvas) {
        this.canvasContext.lineJoin(i);
    }

    public void fillColor(String str) {
        this.actions.add(new CanvasDrawHelperView$$ExternalSyntheticLambda6(this, str));
    }

    public /* synthetic */ void lambda$fillColor$17$CanvasDrawHelperView(String str, Canvas canvas) {
        this.canvasContext.fillColor(str);
    }

    public void textColor(String str) {
        this.actions.add(new CanvasDrawHelperView$$ExternalSyntheticLambda8(this, str));
    }

    public /* synthetic */ void lambda$textColor$18$CanvasDrawHelperView(String str, Canvas canvas) {
        this.canvasContext.textColor(str);
    }
}
