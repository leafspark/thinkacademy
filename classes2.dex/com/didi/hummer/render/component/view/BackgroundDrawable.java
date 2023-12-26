package com.didi.hummer.render.component.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import com.didi.hummer.render.utility.RTLUtil;
import java.util.Arrays;

public class BackgroundDrawable extends Drawable {
    private Border border = new Border();
    private int color = 0;
    private Drawable drawable;
    private final RectF extendInnerRect = new RectF();
    private GradientDrawable gradientDrawable;
    private final Paint mBgPaint = new Paint(1);
    private final Paint mBorderPaint = new Paint(1);
    private final Path mEachBorderPath = new Path();
    private final Path mInnerBoundsPath = new Path();
    private final RectF mInnerBoundsRect = new RectF();
    private final float[] mInnerRadii = new float[8];
    private final Path mOuterBoundsPath = new Path();
    private final RectF mOuterBoundsRect = new RectF();
    private final float[] mOuterRadii = new float[8];
    private final Paint mShadowPaint = new Paint(1);
    private final RectF mStrokeBoundsRect = new RectF();
    private final float[] mStrokeRadii = new float[8];
    private final Path mWholeBorderPath = new Path();
    private boolean needRTL = false;
    private Shadow shadow;
    private RectF shadowInnerBounds = new RectF();
    private Rect shadowOuterBounds = new Rect();

    public @interface BorderStyle {
        public static final int DASHED = 2;
        public static final int DOTTED = 3;
        public static final int NONE = 0;
        public static final int SOLID = 1;
    }

    public int getOpacity() {
        return -2;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public static class BorderRadius {
        float bottomLeftPercent;
        float bottomLeftX;
        float bottomLeftY;
        float bottomRightPercent;
        float bottomRightX;
        float bottomRightY;
        float topLeftPercent;
        float topLeftX;
        float topLeftY;
        float topRightPercent;
        float topRightX;
        float topRightY;

        public BorderRadius() {
        }

        public BorderRadius(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
            set(f, f2, f3, f4, f5, f6, f7, f8);
        }

        public void set(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
            this.topLeftX = f;
            this.topLeftY = f2;
            this.topRightX = f3;
            this.topRightY = f4;
            this.bottomRightX = f5;
            this.bottomRightY = f6;
            this.bottomLeftX = f7;
            this.bottomLeftY = f8;
        }

        public boolean isValid() {
            return this.topLeftX > 0.0f || this.topLeftY > 0.0f || this.topRightX > 0.0f || this.topRightY > 0.0f || this.bottomRightX > 0.0f || this.bottomRightY > 0.0f || this.bottomLeftX > 0.0f || this.bottomLeftY > 0.0f || this.topLeftPercent > 0.0f || this.topRightPercent > 0.0f || this.bottomRightPercent > 0.0f || this.bottomLeftPercent > 0.0f;
        }

        public void fillWithPercent(Rect rect) {
            if (rect != null && !rect.isEmpty()) {
                if (this.topLeftPercent > 0.0f) {
                    if (this.topLeftX <= 0.0f) {
                        this.topLeftX = (((float) rect.width()) * this.topLeftPercent) / 100.0f;
                    }
                    if (this.topLeftY <= 0.0f) {
                        this.topLeftY = (((float) rect.height()) * this.topLeftPercent) / 100.0f;
                    }
                }
                if (this.topRightPercent > 0.0f) {
                    float f = this.topRightX;
                    if (f <= 0.0f && this.topRightY <= 0.0f) {
                        if (f <= 0.0f) {
                            this.topRightX = (((float) rect.width()) * this.topRightPercent) / 100.0f;
                        }
                        if (this.topRightY <= 0.0f) {
                            this.topRightY = (((float) rect.height()) * this.topRightPercent) / 100.0f;
                        }
                    }
                }
                if (this.bottomRightPercent > 0.0f) {
                    float f2 = this.bottomRightX;
                    if (f2 <= 0.0f && this.bottomRightY <= 0.0f) {
                        if (f2 <= 0.0f) {
                            this.bottomRightX = (((float) rect.width()) * this.bottomRightPercent) / 100.0f;
                        }
                        if (this.bottomRightY <= 0.0f) {
                            this.bottomRightY = (((float) rect.height()) * this.bottomRightPercent) / 100.0f;
                        }
                    }
                }
                if (this.bottomLeftPercent > 0.0f) {
                    float f3 = this.bottomLeftX;
                    if (f3 <= 0.0f && this.bottomLeftY <= 0.0f) {
                        if (f3 <= 0.0f) {
                            this.bottomLeftX = (((float) rect.width()) * this.bottomLeftPercent) / 100.0f;
                        }
                        if (this.bottomLeftY <= 0.0f) {
                            this.bottomLeftY = (((float) rect.height()) * this.bottomLeftPercent) / 100.0f;
                        }
                    }
                }
            }
        }

        public void toRTL() {
            float f = this.topLeftX;
            this.topLeftX = this.topRightX;
            this.topRightX = f;
            float f2 = this.topLeftY;
            this.topLeftY = this.topRightY;
            this.topRightY = f2;
            float f3 = this.bottomLeftX;
            this.bottomLeftX = this.bottomRightX;
            this.bottomRightX = f3;
            float f4 = this.bottomLeftY;
            this.bottomLeftY = this.bottomRightY;
            this.bottomRightY = f4;
            float f5 = this.topLeftPercent;
            this.topLeftPercent = this.topRightPercent;
            this.topRightPercent = f5;
            float f6 = this.bottomLeftPercent;
            this.bottomLeftPercent = this.bottomRightPercent;
            this.bottomRightPercent = f6;
        }
    }

    public static class Border {
        public Rect color;
        public BorderRadius radius;
        public Rect style;
        public RectF width;

        public Border() {
            this.style = new Rect(1, 1, 1, 1);
            this.width = new RectF();
            this.color = new Rect(-16777216, -16777216, -16777216, -16777216);
            this.radius = new BorderRadius();
        }

        public Border(float f, int i, float f2) {
            this(f, i, f2, 1);
        }

        public Border(float f, int i, float f2, int i2) {
            this.style = new Rect(i2, i2, i2, i2);
            this.width = new RectF(f, f, f, f);
            this.color = new Rect(i, i, i, i);
            this.radius = new BorderRadius(f2, f2, f2, f2, f2, f2, f2, f2);
        }

        public boolean hasBorder() {
            return hasStyleWidthColor() || hasRadius();
        }

        public boolean hasStyleWidthColor() {
            return hasStyle() && hasWidth() && hasColor();
        }

        public boolean hasStyle() {
            Rect rect = this.style;
            return (rect == null || (rect.left == 0 && this.style.top == 0 && this.style.right == 0 && this.style.bottom == 0)) ? false : true;
        }

        public boolean hasWidth() {
            RectF rectF = this.width;
            return rectF != null && (rectF.left > 0.0f || this.width.top > 0.0f || this.width.right > 0.0f || this.width.bottom > 0.0f);
        }

        public boolean hasColor() {
            Rect rect = this.color;
            return (rect == null || (rect.left == 0 && this.color.top == 0 && this.color.right == 0 && this.color.bottom == 0)) ? false : true;
        }

        public boolean hasRadius() {
            BorderRadius borderRadius = this.radius;
            return borderRadius != null && borderRadius.isValid();
        }

        public boolean isAllBorderSame() {
            return this.style.left == this.style.top && this.style.left == this.style.right && this.style.left == this.style.bottom && this.width.left == this.width.top && this.width.left == this.width.right && this.width.left == this.width.bottom && this.color.left == this.color.top && this.color.left == this.color.right && this.color.left == this.color.bottom;
        }

        public static int getStyle(String str) {
            if (TextUtils.isEmpty(str)) {
                return 1;
            }
            String upperCase = str.toUpperCase();
            upperCase.hashCode();
            char c = 65535;
            switch (upperCase.hashCode()) {
                case 79081099:
                    if (upperCase.equals("SOLID")) {
                        c = 0;
                        break;
                    }
                    break;
                case 2009355185:
                    if (upperCase.equals("DASHED")) {
                        c = 1;
                        break;
                    }
                    break;
                case 2022325802:
                    if (upperCase.equals("DOTTED")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return 1;
                case 1:
                    return 2;
                case 2:
                    return 3;
                default:
                    return 0;
            }
        }

        public void toRTL() {
            RTLUtil.toRTLRect(this.style);
            RTLUtil.toRTLRect(this.width);
            RTLUtil.toRTLRect(this.color);
            this.radius.toRTL();
        }
    }

    public static class Shadow {
        public int color;
        public float dx;
        public float dy;
        public float radius;

        public Shadow(float f, float f2, float f3, int i) {
            this.radius = f;
            this.dx = f2;
            this.dy = f3;
            this.color = i;
        }
    }

    public BackgroundDrawable() {
    }

    public BackgroundDrawable(boolean z) {
        this.needRTL = z;
    }

    public void draw(Canvas canvas) {
        if (!this.border.hasBorder()) {
            drawShadowIfNeed(canvas);
            drawBackground(canvas);
            return;
        }
        initBorderData();
        drawShadowIfNeed(canvas);
        drawBackgroundWithBorder(canvas);
    }

    private void initBorderData() {
        fixedBorderWidth();
        RectF rectF = this.border.width;
        BorderRadius borderRadius = this.border.radius;
        borderRadius.fillWithPercent(getBounds());
        if (this.needRTL) {
            this.border.toRTL();
        }
        this.mOuterBoundsRect.set(getBounds());
        this.mInnerBoundsRect.set(getBounds());
        this.mInnerBoundsRect.left += rectF.left;
        this.mInnerBoundsRect.top += rectF.top;
        this.mInnerBoundsRect.right -= rectF.right;
        this.mInnerBoundsRect.bottom -= rectF.bottom;
        this.mStrokeBoundsRect.set(getBounds());
        this.mStrokeBoundsRect.left += rectF.left / 2.0f;
        this.mStrokeBoundsRect.top += rectF.top / 2.0f;
        this.mStrokeBoundsRect.right -= rectF.right / 2.0f;
        this.mStrokeBoundsRect.bottom -= rectF.bottom / 2.0f;
        this.mOuterRadii[0] = borderRadius.topLeftX;
        this.mOuterRadii[1] = borderRadius.topLeftY;
        this.mOuterRadii[2] = borderRadius.topRightX;
        this.mOuterRadii[3] = borderRadius.topRightY;
        this.mOuterRadii[4] = borderRadius.bottomRightX;
        this.mOuterRadii[5] = borderRadius.bottomRightY;
        this.mOuterRadii[6] = borderRadius.bottomLeftX;
        this.mOuterRadii[7] = borderRadius.bottomLeftY;
        this.mInnerRadii[0] = Math.max(borderRadius.topLeftX - rectF.left, 0.0f);
        this.mInnerRadii[1] = Math.max(borderRadius.topLeftY - rectF.top, 0.0f);
        this.mInnerRadii[2] = Math.max(borderRadius.topRightX - rectF.right, 0.0f);
        this.mInnerRadii[3] = Math.max(borderRadius.topRightY - rectF.top, 0.0f);
        this.mInnerRadii[4] = Math.max(borderRadius.bottomRightX - rectF.right, 0.0f);
        this.mInnerRadii[5] = Math.max(borderRadius.bottomRightY - rectF.bottom, 0.0f);
        this.mInnerRadii[6] = Math.max(borderRadius.bottomLeftX - rectF.left, 0.0f);
        this.mInnerRadii[7] = Math.max(borderRadius.bottomLeftY - rectF.bottom, 0.0f);
        this.mStrokeRadii[0] = Math.max(borderRadius.topLeftX - (rectF.left / 2.0f), 0.0f);
        this.mStrokeRadii[1] = Math.max(borderRadius.topLeftY - (rectF.top / 2.0f), 0.0f);
        this.mStrokeRadii[2] = Math.max(borderRadius.topRightX - (rectF.right / 2.0f), 0.0f);
        this.mStrokeRadii[3] = Math.max(borderRadius.topRightY - (rectF.top / 2.0f), 0.0f);
        this.mStrokeRadii[4] = Math.max(borderRadius.bottomRightX - (rectF.right / 2.0f), 0.0f);
        this.mStrokeRadii[5] = Math.max(borderRadius.bottomRightY - (rectF.bottom / 2.0f), 0.0f);
        this.mStrokeRadii[6] = Math.max(borderRadius.bottomLeftX - (rectF.left / 2.0f), 0.0f);
        this.mStrokeRadii[7] = Math.max(borderRadius.bottomLeftY - (rectF.bottom / 2.0f), 0.0f);
    }

    private void fixedBorderWidth() {
        Rect bounds = getBounds();
        if (bounds.width() > 0 && this.border.width.left + this.border.width.right > ((float) bounds.width())) {
            this.border.width.left = (((float) bounds.width()) * this.border.width.left) / (this.border.width.left + this.border.width.right);
            this.border.width.right = ((float) bounds.width()) - this.border.width.left;
        }
        if (bounds.height() > 0 && this.border.width.top + this.border.width.bottom > ((float) bounds.height())) {
            this.border.width.top = (((float) bounds.height()) * this.border.width.top) / (this.border.width.top + this.border.width.bottom);
            this.border.width.bottom = ((float) bounds.height()) - this.border.width.top;
        }
    }

    private void drawBackground(Canvas canvas) {
        Drawable drawable2 = this.drawable;
        if (drawable2 != null) {
            drawable2.setBounds(getBounds());
            this.drawable.draw(canvas);
            return;
        }
        GradientDrawable gradientDrawable2 = this.gradientDrawable;
        if (gradientDrawable2 != null) {
            gradientDrawable2.setBounds(getBounds());
            this.gradientDrawable.draw(canvas);
            return;
        }
        int i = this.color;
        if (i != 0) {
            this.mBgPaint.setColor(i);
            this.mBgPaint.setStyle(Paint.Style.FILL);
            canvas.drawRect(getBounds(), this.mBgPaint);
        }
    }

    private void drawBackgroundWithBorder(Canvas canvas) {
        if (this.drawable != null) {
            if (this.border.hasRadius()) {
                clipOuterRoundBounds(canvas);
            }
            this.drawable.setBounds(getBounds());
            this.drawable.draw(canvas);
        } else if (this.gradientDrawable != null) {
            if (this.border.hasRadius()) {
                clipOuterRoundBounds(canvas);
            }
            this.gradientDrawable.setBounds(getBounds());
            this.gradientDrawable.draw(canvas);
        } else {
            int i = this.color;
            if (i != 0) {
                this.mBgPaint.setColor(i);
                this.mBgPaint.setStyle(Paint.Style.FILL);
                if (!this.border.hasRadius() || this.border.hasStyleWidthColor()) {
                    if (this.border.hasRadius()) {
                        clipOuterRoundBounds(canvas);
                    }
                    canvas.drawRect(getBounds(), this.mBgPaint);
                } else {
                    this.mOuterBoundsPath.reset();
                    this.mOuterBoundsPath.addRoundRect(this.mOuterBoundsRect, this.mOuterRadii, Path.Direction.CW);
                    canvas.drawPath(this.mOuterBoundsPath, this.mBgPaint);
                }
            } else if (this.border.hasRadius()) {
                clipOuterRoundBounds(canvas);
            }
        }
        if (this.border.hasStyleWidthColor()) {
            drawBorders(canvas, this.border);
        }
    }

    private void drawBorders(Canvas canvas, Border border2) {
        if (border2.isAllBorderSame()) {
            drawSameBorders(canvas, border2);
        } else {
            drawEachBorders(canvas, border2);
        }
    }

    private void drawSameBorders(Canvas canvas, Border border2) {
        int i = border2.style.left;
        float f = border2.width.left;
        int i2 = border2.color.left;
        this.mBorderPaint.reset();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setStrokeWidth(f);
        this.mBorderPaint.setColor(i2);
        this.mBorderPaint.setPathEffect(makePathEffect(i, f));
        this.mWholeBorderPath.reset();
        if (border2.hasRadius()) {
            this.mWholeBorderPath.addRoundRect(this.mStrokeBoundsRect, this.mStrokeRadii, Path.Direction.CW);
        } else {
            this.mWholeBorderPath.addRect(this.mStrokeBoundsRect, Path.Direction.CW);
        }
        canvas.drawPath(this.mWholeBorderPath, this.mBorderPaint);
    }

    private void drawEachBorders(Canvas canvas, Border border2) {
        Border border3 = border2;
        canvas.save();
        if (border2.hasRadius()) {
            clipBorderInnerRoundBounds(canvas);
        } else {
            clipBorderInnerRectBounds(canvas);
        }
        if (!border2.hasRadius()) {
            this.extendInnerRect.set(this.mInnerBoundsRect);
        } else if (this.mInnerBoundsRect.width() > this.mInnerBoundsRect.height()) {
            float height = (this.mInnerBoundsRect.height() * border3.width.top) / (border3.width.top + border3.width.bottom);
            this.extendInnerRect.left = this.mInnerBoundsRect.left + (((float) Math.tan((((double) (border3.width.left / (border3.width.top + border3.width.left))) * 3.141592653589793d) / 2.0d)) * height);
            this.extendInnerRect.right = this.mInnerBoundsRect.right - (((float) Math.tan((((double) (border3.width.right / (border3.width.top + border3.width.right))) * 3.141592653589793d) / 2.0d)) * height);
            this.extendInnerRect.top = this.mInnerBoundsRect.top + height;
            RectF rectF = this.extendInnerRect;
            rectF.bottom = rectF.top;
        } else {
            float width = (this.mInnerBoundsRect.width() * border3.width.left) / (border3.width.left + border3.width.right);
            float tan = ((float) Math.tan((((double) (border3.width.top / (border3.width.left + border3.width.top))) * 3.141592653589793d) / 2.0d)) * width;
            float tan2 = ((float) Math.tan((((double) (border3.width.bottom / (border3.width.left + border3.width.bottom))) * 3.141592653589793d) / 2.0d)) * width;
            this.extendInnerRect.left = this.mInnerBoundsRect.left + width;
            RectF rectF2 = this.extendInnerRect;
            rectF2.right = rectF2.left;
            this.extendInnerRect.top = this.mInnerBoundsRect.top + tan;
            this.extendInnerRect.bottom = this.mInnerBoundsRect.bottom - tan2;
        }
        RectF rectF3 = this.mOuterBoundsRect;
        if (!(border3.style.left == 0 || border3.width.left <= 0.0f || border3.color.left == 0)) {
            float f = rectF3.left;
            float f2 = rectF3.top;
            float f3 = rectF3.bottom;
            float f4 = this.extendInnerRect.left;
            float f5 = this.extendInnerRect.bottom;
            float f6 = this.extendInnerRect.left;
            float f7 = this.extendInnerRect.top;
            drawEachBorder(canvas, border3.color.left, f, f2, f, f3, f4, f5, f6, f7);
        }
        if (!(border3.style.top == 0 || border3.width.top <= 0.0f || border3.color.top == 0)) {
            float f8 = rectF3.left;
            float f9 = rectF3.top;
            float f10 = rectF3.right;
            float f11 = this.extendInnerRect.right;
            float f12 = this.extendInnerRect.top;
            float f13 = this.extendInnerRect.left;
            float f14 = this.extendInnerRect.top;
            drawEachBorder(canvas, border3.color.top, f8, f9, f10, f9, f11, f12, f13, f14);
        }
        if (!(border3.style.right == 0 || border3.width.right <= 0.0f || border3.color.right == 0)) {
            float f15 = rectF3.right;
            float f16 = rectF3.top;
            float f17 = rectF3.bottom;
            float f18 = this.extendInnerRect.right;
            float f19 = this.extendInnerRect.bottom;
            float f20 = this.extendInnerRect.right;
            float f21 = this.extendInnerRect.top;
            drawEachBorder(canvas, border3.color.right, f15, f16, f15, f17, f18, f19, f20, f21);
        }
        if (!(border3.style.bottom == 0 || border3.width.bottom <= 0.0f || border3.color.bottom == 0)) {
            float f22 = rectF3.left;
            float f23 = rectF3.bottom;
            float f24 = rectF3.right;
            float f25 = this.extendInnerRect.right;
            float f26 = this.extendInnerRect.bottom;
            float f27 = this.extendInnerRect.left;
            float f28 = this.extendInnerRect.bottom;
            drawEachBorder(canvas, border3.color.bottom, f22, f23, f24, f23, f25, f26, f27, f28);
        }
        canvas.restore();
    }

    private void drawEachBorder(Canvas canvas, int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.mBorderPaint.reset();
        this.mBorderPaint.setStyle(Paint.Style.FILL);
        this.mBorderPaint.setColor(i);
        this.mEachBorderPath.reset();
        this.mEachBorderPath.moveTo(f, f2);
        this.mEachBorderPath.lineTo(f3, f4);
        this.mEachBorderPath.lineTo(f5, f6);
        this.mEachBorderPath.lineTo(f7, f8);
        this.mEachBorderPath.lineTo(f, f2);
        canvas.drawPath(this.mEachBorderPath, this.mBorderPaint);
    }

    private void drawShadowIfNeed(Canvas canvas) {
        if (this.shadow != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                drawShadow(canvas);
            } else {
                drawShadowBelow_9_0(canvas);
            }
        }
    }

    private void drawShadow(Canvas canvas) {
        this.mShadowPaint.setColor(-1);
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setShadowLayer(this.shadow.radius, this.shadow.dx, this.shadow.dy, this.shadow.color);
        if (this.border.hasRadius()) {
            this.mOuterBoundsPath.reset();
            this.mOuterBoundsPath.addRoundRect(this.mOuterBoundsRect, this.mOuterRadii, Path.Direction.CW);
            canvas.drawPath(this.mOuterBoundsPath, this.mShadowPaint);
            return;
        }
        canvas.drawRect(getBounds(), this.mShadowPaint);
    }

    private void drawShadowBelow_9_0(Canvas canvas) {
        int i = (int) (this.shadow.radius * 2.4f);
        this.shadowOuterBounds.set(getBounds());
        int i2 = -i;
        this.shadowOuterBounds.inset(i2, i2);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.shadowOuterBounds.width(), this.shadowOuterBounds.height(), Bitmap.Config.ARGB_4444);
            Canvas canvas2 = new Canvas(createBitmap);
            float f = (float) i;
            canvas2.translate((-this.shadow.dx) + f, (-this.shadow.dy) + f);
            this.mShadowPaint.setColor(-1);
            this.mShadowPaint.setStyle(Paint.Style.FILL);
            this.mShadowPaint.setShadowLayer(this.shadow.radius, this.shadow.dx, this.shadow.dy, this.shadow.color);
            if (this.border.hasRadius()) {
                this.shadowInnerBounds.set(this.mOuterBoundsRect);
                this.shadowInnerBounds.inset(1.0f, 1.0f);
                this.mOuterBoundsPath.reset();
                this.mOuterBoundsPath.addRoundRect(this.shadowInnerBounds, this.mOuterRadii, Path.Direction.CW);
                canvas2.drawPath(this.mOuterBoundsPath, this.mShadowPaint);
            } else {
                this.shadowInnerBounds.set(getBounds());
                this.shadowInnerBounds.inset(1.0f, 1.0f);
                canvas2.drawRect(this.shadowInnerBounds, this.mShadowPaint);
            }
            canvas.drawBitmap(createBitmap, this.shadow.dx - f, this.shadow.dy - f, (Paint) null);
            if (!createBitmap.isRecycled()) {
                createBitmap.recycle();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void clipOuterRoundBounds(Canvas canvas) {
        this.mOuterBoundsPath.reset();
        this.mOuterBoundsPath.addRoundRect(this.mOuterBoundsRect, this.mOuterRadii, Path.Direction.CW);
        canvas.clipPath(this.mOuterBoundsPath);
    }

    private void clipBorderInnerRectBounds(Canvas canvas) {
        this.mInnerBoundsPath.reset();
        this.mInnerBoundsPath.addRect(this.mInnerBoundsRect, Path.Direction.CW);
        canvas.clipPath(this.mInnerBoundsPath, Region.Op.DIFFERENCE);
    }

    private void clipBorderInnerRoundBounds(Canvas canvas) {
        this.mInnerBoundsPath.reset();
        this.mInnerBoundsPath.addRoundRect(this.mInnerBoundsRect, this.mInnerRadii, Path.Direction.CW);
        canvas.clipPath(this.mInnerBoundsPath, Region.Op.DIFFERENCE);
    }

    public void setDrawable(Drawable drawable2) {
        this.drawable = drawable2;
        invalidateSelf();
    }

    public void setColor(int i) {
        this.color = i;
        this.gradientDrawable = null;
        this.drawable = null;
        invalidateSelf();
    }

    public void setColor(int i, int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.gradientDrawable = new GradientDrawable(transOrientation(i), iArr);
            this.color = 0;
            this.drawable = null;
            invalidateSelf();
        }
    }

    public void setColor(Object obj) {
        if (obj instanceof Integer) {
            setColor(((Integer) obj).intValue());
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            setColor(iArr[0], Arrays.copyOfRange(iArr, 1, iArr.length));
        }
    }

    public int getColor() {
        return this.color;
    }

    private GradientDrawable.Orientation transOrientation(int i) {
        int i2 = i % 360;
        if (i2 == 45) {
            return GradientDrawable.Orientation.BL_TR;
        }
        if (i2 == 90) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
        if (i2 == 135) {
            return GradientDrawable.Orientation.TL_BR;
        }
        if (i2 == 180) {
            return GradientDrawable.Orientation.TOP_BOTTOM;
        }
        if (i2 == 225) {
            return GradientDrawable.Orientation.TR_BL;
        }
        if (i2 == 270) {
            return GradientDrawable.Orientation.RIGHT_LEFT;
        }
        if (i2 != 315) {
            return GradientDrawable.Orientation.BOTTOM_TOP;
        }
        return GradientDrawable.Orientation.BR_TL;
    }

    private PathEffect makePathEffect(int i, float f) {
        if (i == 2) {
            float f2 = f * 3.0f;
            return new DashPathEffect(new float[]{f2, f2, f2, f2}, 0.0f);
        } else if (i != 3) {
            return null;
        } else {
            return new DashPathEffect(new float[]{f, f, f, f}, 0.0f);
        }
    }

    public void setBorder(float f, int i, float f2, int i2) {
        this.border = new Border(f, i, f2, i2);
        invalidateSelf();
    }

    public void setBorder(Border border2) {
        this.border = border2;
        invalidateSelf();
    }

    public void setBorderStyle(int i) {
        this.border.style.set(i, i, i, i);
        invalidateSelf();
    }

    public void setBorderLeftStyle(int i) {
        this.border.style.left = i;
        invalidateSelf();
    }

    public void setBorderTopStyle(int i) {
        this.border.style.top = i;
        invalidateSelf();
    }

    public void setBorderRightStyle(int i) {
        this.border.style.right = i;
        invalidateSelf();
    }

    public void setBorderBottomStyle(int i) {
        this.border.style.bottom = i;
        invalidateSelf();
    }

    public void setBorderStyle(String str) {
        setBorderStyle(Border.getStyle(str));
    }

    public void setBorderLeftStyle(String str) {
        setBorderLeftStyle(Border.getStyle(str));
    }

    public void setBorderTopStyle(String str) {
        setBorderTopStyle(Border.getStyle(str));
    }

    public void setBorderRightStyle(String str) {
        setBorderRightStyle(Border.getStyle(str));
    }

    public void setBorderBottomStyle(String str) {
        setBorderBottomStyle(Border.getStyle(str));
    }

    public void setBorderWidth(float f) {
        this.border.width.set(f, f, f, f);
        invalidateSelf();
    }

    public void setBorderLeftWidth(float f) {
        this.border.width.left = f;
        invalidateSelf();
    }

    public void setBorderTopWidth(float f) {
        this.border.width.top = f;
        invalidateSelf();
    }

    public void setBorderRightWidth(float f) {
        this.border.width.right = f;
        invalidateSelf();
    }

    public void setBorderBottomWidth(float f) {
        this.border.width.bottom = f;
        invalidateSelf();
    }

    public void setBorderColor(int i) {
        this.border.color.set(i, i, i, i);
        invalidateSelf();
    }

    public void setBorderLeftColor(int i) {
        this.border.color.left = i;
        invalidateSelf();
    }

    public void setBorderTopColor(int i) {
        this.border.color.top = i;
        invalidateSelf();
    }

    public void setBorderRightColor(int i) {
        this.border.color.right = i;
        invalidateSelf();
    }

    public void setBorderBottomColor(int i) {
        this.border.color.bottom = i;
        invalidateSelf();
    }

    public void setBorderRadius(float f) {
        this.border.radius.set(f, f, f, f, f, f, f, f);
        invalidateSelf();
    }

    public void setBorderTopLeftRadius(float f) {
        this.border.radius.topLeftX = f;
        this.border.radius.topLeftY = f;
        invalidateSelf();
    }

    public void setBorderTopRightRadius(float f) {
        this.border.radius.topRightX = f;
        this.border.radius.topRightY = f;
        invalidateSelf();
    }

    public void setBorderBottomRightRadius(float f) {
        this.border.radius.bottomRightX = f;
        this.border.radius.bottomRightY = f;
        invalidateSelf();
    }

    public void setBorderBottomLeftRadius(float f) {
        this.border.radius.bottomLeftX = f;
        this.border.radius.bottomLeftY = f;
        invalidateSelf();
    }

    public void setBorderRadiusPercent(float f) {
        this.border.radius.topLeftPercent = f;
        this.border.radius.topRightPercent = f;
        this.border.radius.bottomRightPercent = f;
        this.border.radius.bottomLeftPercent = f;
        invalidateSelf();
    }

    public void setBorderTopLeftRadiusPercent(float f) {
        this.border.radius.topLeftPercent = f;
        invalidateSelf();
    }

    public void setBorderTopRightRadiusPercent(float f) {
        this.border.radius.topRightPercent = f;
        invalidateSelf();
    }

    public void setBorderBottomRightRadiusPercent(float f) {
        this.border.radius.bottomRightPercent = f;
        invalidateSelf();
    }

    public void setBorderBottomLeftRadiusPercent(float f) {
        this.border.radius.bottomLeftPercent = f;
        invalidateSelf();
    }

    public Border getBorder() {
        return this.border;
    }

    public float[] getBorderRadii() {
        return this.mOuterRadii;
    }

    public void setShadow(float f, float f2, float f3, int i) {
        this.shadow = new Shadow(f, f2, f3, i);
        invalidateSelf();
    }
}
