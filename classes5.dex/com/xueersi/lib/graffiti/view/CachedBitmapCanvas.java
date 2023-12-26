package com.xueersi.lib.graffiti.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import com.xueersi.lib.graffiti.utils.XesLog;
import com.yalantis.ucrop.view.CropImageView;
import java.util.concurrent.atomic.AtomicBoolean;

public class CachedBitmapCanvas {
    static float maxHeight = 3240.0f;
    private final boolean enableCached;
    private volatile Bitmap mCachedBitmap;
    private volatile ScaleCanvas mCachedCanvas;
    private volatile Bitmap mDisplayBitmap;
    private volatile ScaleCanvas mDisplayCanvas;
    private volatile AtomicBoolean mHasDrawFlag = new AtomicBoolean(false);

    public CachedBitmapCanvas(boolean z) {
        this.enableCached = z;
    }

    public void drawOnView(Canvas canvas) {
        if (canvas != null && this.mDisplayBitmap != null && !this.mDisplayBitmap.isRecycled() && this.mHasDrawFlag.get()) {
            try {
                synchronized (this) {
                    float scale = this.mDisplayCanvas != null ? this.mDisplayCanvas.getScale() : 1.0f;
                    if (scale == 1.0f || scale <= CropImageView.DEFAULT_ASPECT_RATIO) {
                        canvas.drawBitmap(this.mDisplayBitmap, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, (Paint) null);
                    } else {
                        canvas.save();
                        float f = 1.0f / scale;
                        canvas.scale(f, f);
                        canvas.drawBitmap(this.mDisplayBitmap, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, (Paint) null);
                        canvas.restore();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (XesLog.isEnabled()) {
            StringBuilder sb = new StringBuilder();
            sb.append("drawOnView内容空白:");
            sb.append(this.mHasDrawFlag.get());
            sb.append("mDisplayBitmap:");
            sb.append(this.mDisplayBitmap != null ? Boolean.valueOf(this.mDisplayBitmap.isRecycled()) : "null");
            XesLog.d(sb.toString());
        }
    }

    public void updateSize(int i, int i2) {
        int[] iArr = {i, i2};
        float sizeScale = getSizeScale(iArr);
        if (this.mDisplayBitmap == null || this.mDisplayBitmap.isRecycled() || this.mDisplayBitmap.getWidth() != iArr[0] || this.mDisplayBitmap.getHeight() != iArr[1]) {
            Bitmap bitmap = this.mDisplayBitmap;
            this.mDisplayBitmap = Bitmap.createBitmap(iArr[0], iArr[1], Bitmap.Config.ARGB_8888);
            if (this.mDisplayCanvas == null) {
                this.mDisplayCanvas = new ScaleCanvas(this.mDisplayBitmap);
            } else {
                this.mDisplayCanvas.setBitmap(this.mDisplayBitmap);
            }
            this.mDisplayCanvas.setScale(sizeScale);
            if (this.mCachedCanvas != null) {
                this.mCachedCanvas.setScale(sizeScale);
            }
            if (bitmap != null) {
                bitmap.recycle();
                return;
            }
            return;
        }
        if (this.mCachedCanvas != null) {
            this.mCachedCanvas.setScale(sizeScale);
        }
        if (this.mDisplayCanvas != null) {
            this.mDisplayCanvas.setScale(sizeScale);
        }
    }

    public void clearDisplay() {
        if (this.mDisplayCanvas != null) {
            this.mDisplayCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        if (this.mCachedBitmap != null) {
            this.mCachedBitmap.recycle();
            this.mCachedBitmap = null;
        }
        if (this.mCachedCanvas != null) {
            this.mCachedCanvas.setBitmap((Bitmap) null);
        }
        this.mHasDrawFlag.set(false);
    }

    public Canvas lockCanvas(boolean z) {
        if (z) {
            return getCachedCanvas();
        }
        return getDisplayCanvas();
    }

    private Canvas getDisplayCanvas() {
        return this.mDisplayCanvas;
    }

    private Canvas getCachedCanvas() {
        if (!this.enableCached) {
            return this.mDisplayCanvas;
        }
        if (this.mDisplayBitmap != null) {
            int width = this.mDisplayBitmap.getWidth();
            int height = this.mDisplayBitmap.getHeight();
            float f = 1.0f;
            if (this.mDisplayCanvas != null) {
                f = this.mDisplayCanvas.getScale();
            }
            if (this.mCachedBitmap == null || ((this.mCachedBitmap.isRecycled() && this.mCachedBitmap.getWidth() != width) || this.mCachedBitmap.getHeight() != height)) {
                Bitmap bitmap = this.mCachedBitmap;
                this.mCachedBitmap = Bitmap.createBitmap(this.mDisplayBitmap.getWidth(), this.mDisplayBitmap.getHeight(), Bitmap.Config.ARGB_8888);
                if (this.mCachedCanvas == null) {
                    this.mCachedCanvas = new ScaleCanvas(this.mCachedBitmap);
                } else {
                    this.mCachedCanvas.setBitmap(this.mCachedBitmap);
                }
                this.mCachedCanvas.setScale(f);
                if (bitmap != null) {
                    bitmap.recycle();
                }
            } else if (this.mCachedCanvas != null) {
                this.mCachedCanvas.setScale(f);
            }
        }
        return this.mCachedCanvas;
    }

    public void unlockCanvasAndPost(Canvas canvas) {
        if (canvas != null && canvas == this.mCachedCanvas) {
            synchronized (this) {
                Bitmap bitmap = this.mDisplayBitmap;
                this.mDisplayBitmap = this.mCachedBitmap;
                this.mCachedBitmap = bitmap;
                if (this.mCachedCanvas != null) {
                    this.mCachedCanvas.setBitmap(this.mCachedBitmap);
                }
                if (this.mDisplayCanvas != null) {
                    this.mDisplayCanvas.setBitmap(this.mDisplayBitmap);
                }
            }
        }
        this.mHasDrawFlag.set(true);
    }

    public boolean available() {
        return this.mDisplayBitmap != null && !this.mDisplayBitmap.isRecycled();
    }

    public void recycle() {
        if (this.mDisplayBitmap != null) {
            this.mDisplayBitmap.recycle();
            this.mDisplayBitmap = null;
        }
        if (this.mDisplayCanvas != null) {
            this.mDisplayCanvas.setBitmap((Bitmap) null);
            this.mDisplayCanvas = null;
        }
        if (this.mCachedBitmap != null) {
            this.mCachedBitmap.recycle();
            this.mCachedBitmap = null;
        }
        if (this.mCachedCanvas != null) {
            this.mCachedCanvas.setBitmap((Bitmap) null);
            this.mCachedCanvas = null;
        }
    }

    private static float getSizeScale(int[] iArr) {
        if (iArr == null || iArr.length != 2) {
            return 1.0f;
        }
        float f = maxHeight;
        if (((float) iArr[1]) <= f) {
            return 1.0f;
        }
        float f2 = f / ((float) iArr[1]);
        iArr[1] = (int) f;
        iArr[0] = (int) (((float) iArr[0]) * f2);
        return f2;
    }

    private static class ScaleCanvas extends Canvas {
        Matrix matrix = new Matrix();
        private float scale = 1.0f;

        public ScaleCanvas() {
        }

        public void setScale(float f) {
            this.scale = f;
            this.matrix.reset();
            this.matrix.postScale(f, f);
            super.setMatrix(this.matrix);
        }

        public void setBitmap(Bitmap bitmap) {
            super.setBitmap(bitmap);
            Matrix matrix2 = this.matrix;
            if (matrix2 != null) {
                setMatrix(matrix2);
            }
        }

        public ScaleCanvas(Bitmap bitmap) {
            super(bitmap);
        }

        public float getScale() {
            return this.scale;
        }
    }
}
