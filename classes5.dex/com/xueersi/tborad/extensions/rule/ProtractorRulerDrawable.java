package com.xueersi.tborad.extensions.rule;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.wushuangtech.constants.LocalSDKConstants;
import com.xueersi.lib.graffiti.utils.XesLog;
import com.xueersi.tborad.extensions.protractor.ProtractorProtoBean;
import com.yalantis.ucrop.view.CropImageView;

public class ProtractorRulerDrawable extends BaseDrawable<ProtractorProtoBean.ProtractorConfig> {
    private final String TAG = "ProtractorRulerDrawable";
    private final Paint angleTextPaint;
    private final float[] angles = new float[2];
    private float arcCenterBgRadius;
    private final Paint arcPaint;
    private final Paint bgPaint;
    private ProtractorProtoBean.ProtractorConfig cacheRulerConfig;
    private float centerX;
    private float centerY;
    private boolean isFirstDraw = true;
    private float lineWidth;
    private final Paint markOutPaint;
    private final Paint markTextPaint;
    private final RectF oval;
    private float radius;
    private float rotate;
    private String text = "<60°";

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public ProtractorRulerDrawable() {
        Paint paint = new Paint();
        this.bgPaint = paint;
        paint.setAntiAlias(true);
        paint.setColor(ProtractorRulerExtension.BG_FILL_COLOR);
        Paint paint2 = new Paint();
        this.markTextPaint = paint2;
        paint2.setAntiAlias(true);
        paint2.setColor(ProtractorRulerExtension.PROTRACTOR_TEXT_COLOR);
        Paint paint3 = new Paint();
        this.markOutPaint = paint3;
        paint3.setAntiAlias(true);
        paint3.setColor(ProtractorRulerExtension.PROTRACTOR_OUT_MARK_COLOR);
        paint3.setStyle(Paint.Style.STROKE);
        this.oval = new RectF();
        Paint paint4 = new Paint();
        this.arcPaint = paint4;
        paint4.setAntiAlias(true);
        paint4.setColor(ProtractorRulerExtension.PROTRACTOR_ARC_COLOR);
        paint4.setStyle(Paint.Style.STROKE);
        Paint paint5 = new Paint();
        this.angleTextPaint = paint5;
        paint5.setAntiAlias(true);
    }

    public void draw(Canvas canvas) {
        if (this.isFirstDraw) {
            if (getBounds().width() != 0) {
                ProtractorProtoBean.ProtractorConfig protractorConfig = this.cacheRulerConfig;
                if (protractorConfig != null) {
                    updateConfig(protractorConfig);
                    this.cacheRulerConfig = null;
                }
                this.isFirstDraw = false;
            } else {
                return;
            }
        }
        canvas.save();
        canvas.translate(this.centerX, this.centerY);
        float f = this.rotate;
        if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
            canvas.rotate(f);
        }
        drawLayer1(canvas);
        drawLayer2(canvas);
        drawLayer3(canvas);
        canvas.restore();
    }

    private void drawLayer1(Canvas canvas) {
        this.oval.left = -this.radius;
        RectF rectF = this.oval;
        rectF.top = rectF.left;
        this.oval.right = this.radius;
        this.oval.bottom = this.radius;
        canvas.drawArc(this.oval, 180.0f, 180.0f, true, this.bgPaint);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(ProtractorRulerExtension.PROTRACTOR_MARK_COLOR);
        paint.setStrokeWidth(this.lineWidth);
        canvas.save();
        for (int i = 0; i <= 18; i++) {
            canvas.drawLine(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, this.radius, CropImageView.DEFAULT_ASPECT_RATIO, paint);
            canvas.rotate(-10.0f);
        }
        canvas.restore();
        float max = Math.max(this.radius / 48.0f, 12.0f);
        float f = this.radius * ProtractorRulerExtension.PROTRACTOR_ANGLE_LINE_LENGTH;
        for (int i2 = 0; i2 < 2; i2++) {
            canvas.save();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(ProtractorRulerExtension.PROTRACTOR_ANGLE_MARK_COLOR);
            canvas.rotate(this.angles[i2]);
            canvas.drawLine(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, f, CropImageView.DEFAULT_ASPECT_RATIO, paint);
            canvas.translate(f, CropImageView.DEFAULT_ASPECT_RATIO);
            paint.setColor(ProtractorRulerExtension.BG_FILL_COLOR);
            canvas.drawCircle(max, CropImageView.DEFAULT_ASPECT_RATIO, max, paint);
            paint.setColor(ProtractorRulerExtension.PROTRACTOR_ANGLE_MARK_COLOR);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(max, CropImageView.DEFAULT_ASPECT_RATIO, this.lineWidth + max, paint);
            canvas.restore();
        }
        paint.reset();
    }

    private void drawLayer2(Canvas canvas) {
        float f = this.radius * ProtractorRulerExtension.PROTRACTOR_ARC_BG_HEIGHT;
        float f2 = f / 2.0f;
        float f3 = this.radius * ProtractorRulerExtension.PROTRACTOR_ARC_HEIGHT;
        this.arcPaint.setStrokeWidth(f);
        this.markOutPaint.setStrokeWidth(this.lineWidth);
        float f4 = this.radius - ((f + f3) + f2);
        float f5 = -f4;
        this.oval.left = f5;
        RectF rectF = this.oval;
        rectF.top = rectF.left;
        this.oval.right = f4;
        this.oval.bottom = f4;
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.oval, 180.0f, 180.0f, false, this.arcPaint);
        float f6 = this.radius - f2;
        this.oval.left = -f6;
        RectF rectF2 = this.oval;
        rectF2.top = rectF2.left;
        this.oval.right = f6;
        this.oval.bottom = f6;
        canvas2.drawArc(this.oval, 180.0f, 180.0f, false, this.arcPaint);
        float f7 = f * 0.4f;
        float f8 = f7 + f7;
        float textVerticalCenter = getTextVerticalCenter(this.markTextPaint, (f + (f3 / 2.0f)) - this.radius);
        float textVerticalCenter2 = getTextVerticalCenter(this.markTextPaint, f5);
        canvas.save();
        canvas.rotate(1.0f);
        for (int i = 0; i <= 90; i++) {
            drawLayer3MarkAndText(true, canvas, i, 90, -1.0f, textVerticalCenter, textVerticalCenter2, f8, f7);
        }
        canvas.restore();
        canvas.save();
        for (int i2 = 91; i2 <= 180; i2++) {
            drawLayer3MarkAndText(false, canvas, i2, LocalSDKConstants.SCREEN_ROTATE_180, 1.0f, textVerticalCenter, textVerticalCenter2, f8, f7);
        }
        canvas.restore();
    }

    private void drawLayer3MarkAndText(boolean z, Canvas canvas, int i, int i2, float f, float f2, float f3, float f4, float f5) {
        String str;
        String str2;
        canvas.rotate(f);
        if (i % 5 == 0) {
            if (i % 10 == 0) {
                if (z) {
                    str = String.valueOf(i2 - i);
                } else {
                    str = String.valueOf(i);
                }
                float f6 = -this.markTextPaint.measureText(str);
                float f7 = f6 / 2.0f;
                if (i2 != i) {
                    canvas.drawText(str, f7, f2, this.markTextPaint);
                } else if (z) {
                    canvas.drawText(str, CropImageView.DEFAULT_ASPECT_RATIO, f2, this.markTextPaint);
                } else {
                    canvas.drawText(str, f6, f2, this.markTextPaint);
                }
                if (z) {
                    str2 = String.valueOf(i2 + i);
                } else {
                    str2 = String.valueOf(i2 - i);
                }
                float f8 = -this.markTextPaint.measureText(str2);
                float f9 = f8 / 2.0f;
                if (i2 != i) {
                    canvas.drawText(str2, f9, f3, this.markTextPaint);
                } else if (z) {
                    canvas.drawText(str2, CropImageView.DEFAULT_ASPECT_RATIO, f3, this.markTextPaint);
                } else {
                    canvas.drawText(str2, f8, f3, this.markTextPaint);
                }
            }
            float f10 = this.radius;
            canvas.drawLine(CropImageView.DEFAULT_ASPECT_RATIO, f4 - f10, CropImageView.DEFAULT_ASPECT_RATIO, -f10, this.markOutPaint);
            return;
        }
        float f11 = this.radius;
        canvas.drawLine(CropImageView.DEFAULT_ASPECT_RATIO, f5 - f11, CropImageView.DEFAULT_ASPECT_RATIO, -f11, this.markOutPaint);
    }

    private void drawLayer3(Canvas canvas) {
        this.oval.left = -this.arcCenterBgRadius;
        RectF rectF = this.oval;
        rectF.top = rectF.left;
        this.oval.right = this.arcCenterBgRadius;
        this.oval.bottom = this.arcCenterBgRadius;
        canvas.drawArc(this.oval, 180.0f, 180.0f, true, this.bgPaint);
        this.angleTextPaint.setTextSize(this.radius * ProtractorRulerExtension.CENTER_TEXT_SIZE);
        this.angleTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        float textVerticalCenter = getTextVerticalCenter(this.angleTextPaint, (-this.arcCenterBgRadius) / 3.0f);
        canvas.drawText(this.text, (-this.angleTextPaint.measureText(this.text)) / 2.0f, textVerticalCenter, this.angleTextPaint);
    }

    private float getTextVerticalCenter(Paint paint, float f) {
        if (paint == null) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (f + ((fontMetrics.bottom - fontMetrics.top) / 2.0f)) - fontMetrics.bottom;
    }

    public void updateConfig(ProtractorProtoBean.ProtractorConfig protractorConfig) {
        if (protractorConfig != null) {
            if (getBounds().width() == 0) {
                this.cacheRulerConfig = protractorConfig;
                return;
            }
            this.rotate = (float) Math.toDegrees((double) protractorConfig.getRotate());
            this.centerX = getX(protractorConfig.getCenterPos().getX());
            this.centerY = getY(protractorConfig.getCenterPos().getY());
            this.radius = getValue(protractorConfig.getRadius());
            this.angles[0] = (float) Math.toDegrees((double) protractorConfig.getFirCircleAngle());
            this.angles[1] = (float) Math.toDegrees((double) protractorConfig.getSecCircleAngle());
            this.lineWidth = this.radius * ProtractorRulerExtension.PROTRACTOR_STORE_WIDTH;
            this.arcCenterBgRadius = this.radius * ProtractorRulerExtension.PROTRACTOR_ARC_CENTER_HEIGHT;
            this.text = protractorConfig.getFillText();
            this.markTextPaint.setTextSize(Math.max(this.radius * ProtractorRulerExtension.TEXT_SIZE, 10.0f));
            String fillTextColor = protractorConfig.getFillTextColor();
            if (!TextUtils.isEmpty(fillTextColor)) {
                this.angleTextPaint.setColor(Color.parseColor(fillTextColor));
            } else {
                this.angleTextPaint.setColor(ProtractorRulerExtension.PROTRACTOR_TEXT_COLOR);
            }
            XesLog.i("量角器:" + protractorConfig.toString());
        }
    }
}
