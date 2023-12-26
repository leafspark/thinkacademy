package com.tal.app.thinkacademy.lib.commui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CircleImageView extends ImageView {
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private static final int COLORDRAWABLE_DIMENSION = 1;
    protected static final int DEFAULT_BORDER_COLOR = -16777216;
    protected static final int DEFAULT_BORDER_WIDTH = 0;
    private static final ImageView.ScaleType SCALE_TYPE = ImageView.ScaleType.CENTER_CROP;
    private Bitmap mBitmap;
    protected int mBitmapHeight;
    protected final Paint mBitmapPaint;
    private BitmapShader mBitmapShader;
    protected int mBitmapWidth;
    protected int mBorderColor;
    protected final Paint mBorderPaint;
    protected float mBorderRadius;
    private final RectF mBorderRect;
    protected int mBorderWidth;
    protected float mDrawableRadius;
    private final RectF mDrawableRect;
    private boolean mReady;
    private boolean mSetupPending;
    private final Matrix mShaderMatrix;

    public CircleImageView(Context context) {
        super(context);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mBorderColor = DEFAULT_BORDER_COLOR;
        this.mBorderWidth = 0;
        init();
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDrawableRect = new RectF();
        this.mBorderRect = new RectF();
        this.mShaderMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBorderPaint = new Paint();
        this.mBorderColor = DEFAULT_BORDER_COLOR;
        this.mBorderWidth = 0;
        init();
    }

    private void init() {
        super.setScaleType(SCALE_TYPE);
        this.mReady = true;
        if (this.mSetupPending) {
            setup();
            this.mSetupPending = false;
        }
    }

    public ImageView.ScaleType getScaleType() {
        return SCALE_TYPE;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != SCALE_TYPE) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.mDrawableRadius, this.mBitmapPaint);
        if (this.mBorderWidth != 0) {
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.mBorderRadius, this.mBorderPaint);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
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

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public void setBorderWidth(int i) {
        if (i != this.mBorderWidth) {
            this.mBorderWidth = i;
            setup();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.mBitmap = bitmap;
        setup();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.mBitmap = getBitmapFromDrawable(drawable);
        setup();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        this.mBitmap = getBitmapFromDrawable(getDrawable());
        setup();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
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
            if (!(drawable instanceof ColorDrawable) && drawable.getIntrinsicWidth() > 0) {
                if (drawable.getIntrinsicHeight() > 0) {
                    bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), BITMAP_CONFIG);
                    Canvas canvas = new Canvas(bitmap);
                    drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    drawable.draw(canvas);
                    return bitmap;
                }
            }
            bitmap = Bitmap.createBitmap(1, 1, BITMAP_CONFIG);
            Canvas canvas2 = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas2.getWidth(), canvas2.getHeight());
            drawable.draw(canvas2);
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
            this.mBorderPaint.setStrokeWidth((float) this.mBorderWidth);
            this.mBitmapHeight = this.mBitmap.getHeight();
            this.mBitmapWidth = this.mBitmap.getWidth();
            this.mBorderRect.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.mBorderRadius = Math.min((this.mBorderRect.height() - ((float) this.mBorderWidth)) / 2.0f, (this.mBorderRect.width() - ((float) this.mBorderWidth)) / 2.0f);
            RectF rectF = this.mDrawableRect;
            int i = this.mBorderWidth;
            rectF.set((float) i, (float) i, this.mBorderRect.width() - ((float) this.mBorderWidth), this.mBorderRect.height() - ((float) this.mBorderWidth));
            this.mDrawableRadius = Math.min(this.mDrawableRect.height() / 2.0f, this.mDrawableRect.width() / 2.0f);
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
        int i = this.mBorderWidth;
        matrix.postTranslate((float) (((int) (f3 + 0.5f)) + i), (float) (((int) (f + 0.5f)) + i));
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
    }
}
