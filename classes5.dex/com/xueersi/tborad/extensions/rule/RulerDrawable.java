package com.xueersi.tborad.extensions.rule;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PointF;
import android.text.TextPaint;
import android.text.TextUtils;
import com.xueersi.lib.graffiti.utils.XesLog;
import com.xueersi.tborad.extensions.rule.RulerProtoBean;
import com.yalantis.ucrop.view.CropImageView;

public class RulerDrawable extends BaseDrawable {
    private final PointF leftTopPoint = new PointF();
    private float originalLeft;
    private float originalLength;
    private float originalTop;
    private final Paint paint;
    private final PointF rightBottomPoint = new PointF();
    private float rotate;
    private String text;
    private final TextPaint textPaint;

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public /* bridge */ /* synthetic */ void updateConfig(Object obj) {
        super.updateConfig(obj);
    }

    public RulerDrawable() {
        TextPaint textPaint2 = new TextPaint();
        this.textPaint = textPaint2;
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(10.0f);
        textPaint2.setAntiAlias(true);
        textPaint2.setStyle(Paint.Style.FILL);
    }

    public void draw(Canvas canvas) {
        if (this.originalLength > CropImageView.DEFAULT_ASPECT_RATIO) {
            calculatePoints();
            canvas.save();
            canvas.rotate((float) Math.toDegrees((double) this.rotate), this.leftTopPoint.x, this.leftTopPoint.y);
            drawBackground(canvas);
            drawRulerMarkBg(canvas);
            drawRuler(canvas);
            drawText(canvas);
            canvas.restore();
        }
    }

    private void drawText(Canvas canvas) {
        if (RulerExtension.DEBUG && TextUtils.isEmpty(this.text)) {
            this.text = "13.3cm";
        }
        if (canvas != null && !TextUtils.isEmpty(this.text)) {
            this.textPaint.setColor(RulerExtension.RULER_COLOR);
            this.textPaint.setTextSize(getValue(RulerExtension.FILL_TEXT_SIZE));
            this.textPaint.setTypeface(RulerExtension.FILL_TEXT_TYPEFACE);
            canvas.drawText(this.text, ((this.rightBottomPoint.x + this.leftTopPoint.x) / 2.0f) - (this.textPaint.measureText(this.text) / 2.0f), this.rightBottomPoint.y - getY(RulerExtension.FILL_TEXT_PADDING_BOTTOM), this.textPaint);
        }
    }

    private void drawRuler(Canvas canvas) {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(RulerExtension.RULER_COLOR);
        this.paint.setStrokeWidth(getValue(RulerExtension.RULER_STORE_WIDTH));
        this.paint.setTextSize(getValue(RulerExtension.RULER_TEXT_SIZE));
        this.paint.setTypeface(RulerExtension.RULER_TEXT_TYPEFACE);
        float value = getValue(RulerExtension.RULER_PADDING_LEFT);
        int i = 0;
        while (getX(RulerExtension.RULER_LINE_WIDTH) + value < Math.abs(this.rightBottomPoint.x - this.leftTopPoint.x)) {
            float f = this.leftTopPoint.x + value;
            float f2 = this.leftTopPoint.y;
            canvas.drawRect(f, f2, this.leftTopPoint.x + value + getX(RulerExtension.RULER_LINE_WIDTH), this.leftTopPoint.y + getY(RulerExtension.RULER_HEIGHT_LIST[i % RulerExtension.RULER_HEIGHT_LIST.length]), this.paint);
            if (i % 10 == 0) {
                canvas.drawText(String.valueOf(i / 10), f - getValue(RulerExtension.RULER_TEXT_SIZE / 4.0f), f2 + getY(RulerExtension.RULER_MARK_BG_HEIGHT) + getValue(RulerExtension.RULER_TEXT_SIZE * 0.8f), this.paint);
            }
            value += getX(RulerExtension.RULER_LINE_WIDTH + RulerExtension.RULER_INTERVAL);
            i++;
        }
        if (i == 0) {
            XesLog.i("RulerDrawable:尺寸太窄，无法容纳");
            if (RulerExtension.DEBUG) {
                canvas.drawText("尺寸长度太小，无法正常显示", this.leftTopPoint.x, this.leftTopPoint.y, this.paint);
            }
        }
    }

    private void drawBackground(Canvas canvas) {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(RulerExtension.BG_FILL_COLOR);
        canvas.drawRect(this.leftTopPoint.x, RulerExtension.RULER_MARK_COLOR_OVERLAY ? this.leftTopPoint.y : this.leftTopPoint.y + getY(RulerExtension.RULER_MARK_BG_HEIGHT), this.rightBottomPoint.x, this.rightBottomPoint.y, this.paint);
    }

    private void drawRulerMarkBg(Canvas canvas) {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(RulerExtension.BG_RULER_MARK_COLOR);
        canvas.drawRect(this.leftTopPoint.x, this.leftTopPoint.y, this.rightBottomPoint.x, this.leftTopPoint.y + getY(RulerExtension.RULER_MARK_BG_HEIGHT), this.paint);
    }

    private void calculatePoints() {
        this.leftTopPoint.set(getX(this.originalLeft), getY(this.originalTop));
        this.rightBottomPoint.set(getX(this.originalLeft + this.originalLength), getY(this.originalTop + RulerExtension.BG_HEIGHT));
    }

    public void updateConfig(RulerProtoBean.RulerConfig rulerConfig) {
        float left = rulerConfig.getLeft();
        float top = rulerConfig.getTop();
        this.originalLength = rulerConfig.getLength();
        this.rotate = rulerConfig.getRotate();
        this.originalLeft = left;
        this.originalTop = top;
        this.text = rulerConfig.getFillText();
        XesLog.i("直尺接收数据:" + rulerConfig.toString());
    }
}
