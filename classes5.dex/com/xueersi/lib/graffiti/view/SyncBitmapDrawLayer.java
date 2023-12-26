package com.xueersi.lib.graffiti.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.os.SystemClock;
import com.xueersi.lib.graffiti.LocalCanvasSize;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.utils.XesLog;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;

public class SyncBitmapDrawLayer extends BaseDrawLayer {
    private float[] bitmapSizeInfo = {CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f};
    private int count;
    private volatile Bitmap mBitmap;
    private Paint mBitmapPaint;
    private Canvas mWorkCanvas;

    public boolean removeDrawableObj(DrawableObject drawableObject) {
        boolean removeDrawableObj = super.removeDrawableObj(drawableObject);
        if (removeDrawableObj) {
            reDrawAll();
        }
        return removeDrawableObj;
    }

    private void reDrawAll() {
        makeBitmapNotNull();
        Canvas canvas = this.mWorkCanvas;
        if (canvas != null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
        long currentTimeMillis = System.currentTimeMillis();
        drawAllObjects(this.mWorkCanvas);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        XesLog.d("drawAllTimeMillis: currentTimeMillis" + currentTimeMillis2);
    }

    public void addAllObjects(List<DrawableObject> list) {
        super.addAllObjects(list);
        if (list != null && list.size() > 0) {
            makeBitmapNotNull();
            for (DrawableObject draw : list) {
                draw.draw(this.mWorkCanvas);
            }
        }
    }

    public void updateDrawableObj(DrawableObject drawableObject) {
        super.updateDrawableObj(drawableObject);
        if (drawableObject != null) {
            makeBitmapNotNull();
            drawableObject.draw(this.mWorkCanvas);
        }
    }

    private synchronized void setBitmapSize(int i, int i2, float f) {
        float[] fArr = this.bitmapSizeInfo;
        fArr[0] = (float) i;
        fArr[1] = (float) i2;
        fArr[2] = f;
    }

    private synchronized float[] getBitmapSize() {
        float[] fArr = this.bitmapSizeInfo;
        if (fArr[0] == CropImageView.DEFAULT_ASPECT_RATIO) {
            fArr[0] = (float) LocalCanvasSize.sdkInner().getWidth();
        }
        float[] fArr2 = this.bitmapSizeInfo;
        if (fArr2[1] == CropImageView.DEFAULT_ASPECT_RATIO) {
            fArr2[1] = (float) LocalCanvasSize.sdkInner().getHeight();
        }
        return this.bitmapSizeInfo;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2) {
        super.onSizeChanged(i, i2);
        if (i != 0 && i2 != 0) {
            if (this.mBitmapPaint == null) {
                Paint paint = new Paint();
                this.mBitmapPaint = paint;
                paint.setAntiAlias(true);
                this.mBitmapPaint.setDither(true);
            }
            float min = Math.min(1.0f, 960.0f / ((float) Math.min(i, i2)));
            setBitmapSize(Math.round(((float) i) * min), Math.round(((float) i2) * min), min);
            if (this.mBitmap != null) {
                this.mBitmap.recycle();
                this.mBitmap = null;
            }
            Canvas canvas = this.mWorkCanvas;
            if (canvas != null) {
                canvas.setBitmap((Bitmap) null);
                this.mWorkCanvas = null;
            }
            if (getObjectSize() > 0) {
                reDrawAll();
            }
        }
    }

    private void makeBitmapNotNull() {
        if (this.mBitmap == null) {
            float[] bitmapSize = getBitmapSize();
            XesLog.d("重新创建bitmap: w:" + bitmapSize[0] + " h:" + bitmapSize[1] + " scale:" + bitmapSize[2]);
            this.mBitmap = Bitmap.createBitmap((int) bitmapSize[0], (int) bitmapSize[1], Bitmap.Config.ARGB_8888);
            Canvas canvas = this.mWorkCanvas;
            if (canvas == null) {
                Canvas canvas2 = new Canvas(this.mBitmap);
                this.mWorkCanvas = canvas2;
                canvas2.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            } else {
                canvas.setBitmap(this.mBitmap);
            }
            this.mWorkCanvas.scale(bitmapSize[2], bitmapSize[2]);
        }
    }

    public void onDraw(Canvas canvas) {
        if (this.mBitmap == null || this.mBitmap.isRecycled() || this.mWorkCanvas == null || this.mBitmapPaint == null) {
            XesLog.d("BitmapDrawLayer不需要绘制");
        } else {
            try {
                long uptimeMillis = SystemClock.uptimeMillis();
                canvas.save();
                canvas.scale(1.0f / getBitmapSize()[2], 1.0f / getBitmapSize()[2]);
                canvas.drawBitmap(this.mBitmap, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, this.mBitmapPaint);
                canvas.restore();
                XesLog.d("BitmapDrawLayer绘制一帧所需时间:" + (SystemClock.uptimeMillis() - uptimeMillis));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.count++;
        if (XesLog.isEnabled()) {
            XesLog.d("BitmapDrawLayer绘制次数" + this.count);
        }
    }

    public void removeAllObjects() {
        super.removeAllObjects();
        Canvas canvas = this.mWorkCanvas;
        if (canvas != null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
    }
}
