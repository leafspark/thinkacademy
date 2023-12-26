package com.didi.hummer.component.imageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

public class RoundedImageView extends AppCompatImageView {
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private static final int COLORDRAWABLE_DIMENSION = 1;
    private Bitmap mBitmap;
    private int mBitmapHeight;
    private final Paint mBitmapPaint;
    private BitmapShader mBitmapShader;
    private int mBitmapWidth;
    private int mBorderColor;
    private final Paint mBorderPaint;
    private final RectF mBorderRect;
    private int mBorderStyle;
    private float mBorderWidth;
    private float mCircleRadius;
    private RectF mClipBounds;
    private float[] mCornerRadii;
    private final RectF mDrawableRect;
    private boolean mReady;
    private float mRoundRadius;
    private float mRoundRadiusPercent;
    private boolean mSetupPending;
    private final Matrix mShaderMatrix;
    private Path mViewPath;
    private final Path roundPath;

    public @interface BorderStyle {
        public static final int DASHED = 2;
        public static final int DOTTED = 3;
        public static final int NONE = 0;
        public static final int SOLID = 1;
    }

    public RoundedImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.roundPath = new Path();
        this.mBorderColor = 0;
        this.mBorderWidth = 0.0f;
        this.mBorderStyle = 0;
        this.mClipBounds = new RectF();
        this.mViewPath = new Path();
        this.mReady = true;
        if (this.mSetupPending) {
            setup();
            this.mSetupPending = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (getDrawable() != null) {
            if (this.mCornerRadii != null) {
                this.mClipBounds.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
                this.mViewPath.reset();
                this.mViewPath.addRoundRect(this.mClipBounds, this.mCornerRadii, Path.Direction.CW);
                canvas.clipPath(this.mViewPath);
            }
            if (this.mRoundRadius <= 0.0f && this.mRoundRadiusPercent > 0.0f) {
                this.mRoundRadius = ((float) Math.min(getWidth(), getHeight())) * this.mRoundRadiusPercent;
            }
            float f = this.mRoundRadius;
            if (f <= 0.0f) {
                RoundedImageView.super.onDraw(canvas);
            } else if (f >= Math.min(this.mDrawableRect.height() / 2.0f, this.mDrawableRect.width() / 2.0f)) {
                canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.mCircleRadius, this.mBitmapPaint);
            } else {
                this.roundPath.reset();
                Path path = this.roundPath;
                RectF rectF = this.mDrawableRect;
                float f2 = this.mRoundRadius;
                path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
                canvas.drawPath(this.roundPath, this.mBitmapPaint);
            }
            if (this.mBorderWidth > 0.0f) {
                float f3 = this.mRoundRadius;
                if (f3 <= 0.0f) {
                    canvas.drawRect(this.mBorderRect, this.mBorderPaint);
                } else if (f3 >= Math.min(this.mDrawableRect.height() / 2.0f, this.mDrawableRect.width() / 2.0f)) {
                    canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.mCircleRadius, this.mBorderPaint);
                } else {
                    this.roundPath.reset();
                    Path path2 = this.roundPath;
                    RectF rectF2 = this.mBorderRect;
                    float f4 = this.mRoundRadius;
                    path2.addRoundRect(rectF2, f4, f4, Path.Direction.CW);
                    canvas.drawPath(this.roundPath, this.mBorderPaint);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        RoundedImageView.super.onSizeChanged(i, i2, i3, i4);
        setup();
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public void setBorderColor(int i) {
        if (i != this.mBorderColor) {
            this.mBorderColor = i;
            this.mBorderPaint.setColor(i);
            invalidate();
        }
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public void setBorderWidth(float f) {
        if (((double) Math.abs(this.mBorderWidth - f)) >= 1.0E-8d) {
            this.mBorderWidth = f;
            setup();
        }
    }

    public void setBorderStyle(String str) {
        int style = getStyle(str);
        if (this.mBorderStyle != style) {
            this.mBorderStyle = style;
            setup();
        }
    }

    /* access modifiers changed from: protected */
    public void setBorderRadius(float f) {
        if (((double) Math.abs(this.mRoundRadius - f)) >= 1.0E-8d) {
            this.mRoundRadius = f;
            this.mRoundRadiusPercent = 0.0f;
            setup();
        }
    }

    /* access modifiers changed from: protected */
    public void setBorderRadiusPercent(float f) {
        if (((double) Math.abs(this.mRoundRadiusPercent - f)) >= 1.0E-8d) {
            this.mRoundRadiusPercent = f;
            this.mRoundRadius = 0.0f;
            setup();
        }
    }

    public void setCornerRadii(float[] fArr) {
        this.mCornerRadii = fArr;
    }

    public void setImageBitmap(Bitmap bitmap) {
        RoundedImageView.super.setImageBitmap(bitmap);
        this.mBitmap = bitmap;
        setup();
    }

    public void setImageDrawable(Drawable drawable) {
        RoundedImageView.super.setImageDrawable(drawable);
        this.mBitmap = getBitmapFromDrawable(drawable);
        setup();
    }

    public void setImageResource(int i) {
        RoundedImageView.super.setImageResource(i);
        this.mBitmap = getBitmapFromDrawable(getDrawable());
        setup();
    }

    private Bitmap getBitmapFromDrawable(Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                bitmap = Bitmap.createBitmap(1, 1, BITMAP_CONFIG);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), BITMAP_CONFIG);
            }
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    private void setup() {
        if (!this.mReady) {
            this.mSetupPending = true;
        } else if (this.mBitmap != null) {
            this.mBitmapShader = new BitmapShader(this.mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.mBitmapPaint.setAntiAlias(true);
            this.mBitmapPaint.setShader(this.mBitmapShader);
            this.mBorderPaint.setStyle(Paint.Style.STROKE);
            this.mBorderPaint.setAntiAlias(true);
            this.mBorderPaint.setColor(this.mBorderColor);
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setPathEffect(makePathEffect(this.mBorderStyle, this.mBorderWidth));
            this.mBitmapHeight = this.mBitmap.getHeight();
            this.mBitmapWidth = this.mBitmap.getWidth();
            RectF rectF = this.mBorderRect;
            float f = this.mBorderWidth;
            rectF.set(f / 2.0f, f / 2.0f, ((float) getWidth()) - (this.mBorderWidth / 2.0f), ((float) getHeight()) - (this.mBorderWidth / 2.0f));
            RectF rectF2 = this.mDrawableRect;
            float f2 = this.mBorderWidth;
            rectF2.set(f2 / 2.0f, f2 / 2.0f, ((float) getWidth()) - (this.mBorderWidth / 2.0f), ((float) getHeight()) - (this.mBorderWidth / 2.0f));
            this.mCircleRadius = Math.min(this.mDrawableRect.height() / 2.0f, this.mDrawableRect.width() / 2.0f);
            updateShaderMatrix();
            invalidate();
        }
    }

    private void updateShaderMatrix() {
        float f;
        float f2;
        this.mShaderMatrix.set((Matrix) null);
        float f3 = 0.0f;
        if (((float) this.mBitmapWidth) * this.mDrawableRect.height() > this.mDrawableRect.width() * ((float) this.mBitmapHeight)) {
            f2 = this.mDrawableRect.height() / ((float) this.mBitmapHeight);
            f = 0.0f;
            f3 = (this.mDrawableRect.width() - (((float) this.mBitmapWidth) * f2)) * 0.5f;
        } else {
            f2 = this.mDrawableRect.width() / ((float) this.mBitmapWidth);
            f = (this.mDrawableRect.height() - (((float) this.mBitmapHeight) * f2)) * 0.5f;
        }
        this.mShaderMatrix.setScale(f2, f2);
        Matrix matrix = this.mShaderMatrix;
        float f4 = this.mBorderWidth;
        matrix.postTranslate(((float) ((int) (f3 + 0.5f))) + f4, ((float) ((int) (f + 0.5f))) + f4);
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
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
}
