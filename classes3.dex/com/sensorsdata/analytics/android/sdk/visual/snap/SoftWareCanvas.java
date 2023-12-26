package com.sensorsdata.analytics.android.sdk.visual.snap;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.util.WeakSet;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Iterator;

public class SoftWareCanvas extends Canvas {
    private static final String TAG = "SA.SoftWareCanvas";
    private WeakSet<Bitmap> bitmapWeakSet = new WeakSet<>();
    private Bitmap mBitmap;

    public SoftWareCanvas(Bitmap bitmap) {
        super(bitmap);
        this.mBitmap = bitmap;
    }

    private Bitmap drawOnSFCanvas(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT < 26 || bitmap.getConfig() != Bitmap.Config.HARDWARE) {
            return bitmap;
        }
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
        this.bitmapWeakSet.add(copy);
        return copy;
    }

    private Paint replaceBitmapShader(Paint paint) {
        if (paint == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26 && (paint.getShader() instanceof BitmapShader)) {
            Paint paint2 = new Paint(paint);
            BitmapShader bitmapShader = (BitmapShader) paint2.getShader();
            try {
                Field field = BitmapShader.class.getField("mBitmap");
                field.setAccessible(true);
                if (((Bitmap) field.get(bitmapShader)).getConfig() == Bitmap.Config.HARDWARE) {
                    Field declaredField = BitmapShader.class.getDeclaredField("mTileX");
                    Field declaredField2 = BitmapShader.class.getDeclaredField("mTileY");
                    declaredField.setAccessible(true);
                    declaredField2.setAccessible(true);
                    Bitmap copy = ((Bitmap) field.get(bitmapShader)).copy(Bitmap.Config.ARGB_8888, false);
                    this.bitmapWeakSet.add(copy);
                    Constructor<BitmapShader> declaredConstructor = BitmapShader.class.getDeclaredConstructor(new Class[]{Bitmap.class, Integer.TYPE, Integer.TYPE});
                    declaredConstructor.setAccessible(true);
                    BitmapShader newInstance = declaredConstructor.newInstance(new Object[]{copy, declaredField.get(bitmapShader), declaredField2.get(bitmapShader)});
                    Matrix matrix = new Matrix();
                    paint.getShader().getLocalMatrix(matrix);
                    newInstance.setLocalMatrix(matrix);
                    paint2.setShader(newInstance);
                    return paint2;
                }
            } catch (Exception e) {
                SALog.i(TAG, e.toString());
            }
        }
        return paint;
    }

    public void destroy() {
        Iterator<Bitmap> it = this.bitmapWeakSet.iterator();
        while (it.hasNext()) {
            it.next().recycle();
        }
        this.bitmapWeakSet.clear();
    }

    public void drawLines(float[] fArr, int i, int i2, Paint paint) {
        super.drawLines(fArr, i, i2, replaceBitmapShader(paint));
    }

    public void drawBitmap(Bitmap bitmap, float f, float f2, Paint paint) {
        Bitmap drawOnSFCanvas = drawOnSFCanvas(bitmap);
        if (drawOnSFCanvas.getDensity() != this.mBitmap.getDensity()) {
            int i = (int) f;
            int i2 = (int) f2;
            Rect rect = new Rect(i, i2, drawOnSFCanvas.getWidth() + i, drawOnSFCanvas.getHeight() + i2);
            super.drawBitmap(drawOnSFCanvas, rect, rect, replaceBitmapShader(paint));
            return;
        }
        super.drawBitmap(drawOnSFCanvas, f, f2, replaceBitmapShader(paint));
    }

    public void drawBitmap(Bitmap bitmap, Rect rect, RectF rectF, Paint paint) {
        super.drawBitmap(drawOnSFCanvas(bitmap), rect, rectF, replaceBitmapShader(paint));
    }

    public void drawBitmap(Bitmap bitmap, Rect rect, Rect rect2, Paint paint) {
        super.drawBitmap(drawOnSFCanvas(bitmap), rect, rect2, replaceBitmapShader(paint));
    }

    public void drawBitmap(int[] iArr, int i, int i2, float f, float f2, int i3, int i4, boolean z, Paint paint) {
        super.drawBitmap(iArr, i, i2, f, f2, i3, i4, z, replaceBitmapShader(paint));
    }

    public void drawBitmap(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z, Paint paint) {
        super.drawBitmap(iArr, i, i2, i3, i4, i5, i6, z, replaceBitmapShader(paint));
    }

    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        super.drawBitmap(drawOnSFCanvas(bitmap), matrix, replaceBitmapShader(paint));
    }

    public void drawBitmapMesh(Bitmap bitmap, int i, int i2, float[] fArr, int i3, int[] iArr, int i4, Paint paint) {
        super.drawBitmapMesh(drawOnSFCanvas(bitmap), i, i2, fArr, i3, iArr, i4, replaceBitmapShader(paint));
    }

    public void drawRoundRect(RectF rectF, float f, float f2, Paint paint) {
        super.drawRoundRect(rectF, f, f2, replaceBitmapShader(paint));
    }

    public void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        super.drawRoundRect(f, f2, f3, f4, f5, f6, replaceBitmapShader(paint));
    }

    public void setBitmap(Bitmap bitmap) {
        super.setBitmap(drawOnSFCanvas(bitmap));
    }

    public int saveLayer(RectF rectF, Paint paint, int i) {
        return super.saveLayer(rectF, replaceBitmapShader(paint), i);
    }

    public int saveLayer(RectF rectF, Paint paint) {
        return super.saveLayer(rectF, replaceBitmapShader(paint));
    }

    public int saveLayer(float f, float f2, float f3, float f4, Paint paint, int i) {
        return super.saveLayer(f, f2, f3, f4, replaceBitmapShader(paint), i);
    }

    public int saveLayer(float f, float f2, float f3, float f4, Paint paint) {
        return super.saveLayer(f, f2, f3, f4, replaceBitmapShader(paint));
    }

    public void drawArc(RectF rectF, float f, float f2, boolean z, Paint paint) {
        super.drawArc(rectF, f, f2, z, replaceBitmapShader(paint));
    }

    public void drawCircle(float f, float f2, float f3, Paint paint) {
        super.drawCircle(f, f2, f3, replaceBitmapShader(paint));
    }

    public void drawLine(float f, float f2, float f3, float f4, Paint paint) {
        super.drawLine(f, f2, f3, f4, replaceBitmapShader(paint));
    }

    public void drawLines(float[] fArr, Paint paint) {
        super.drawLines(fArr, replaceBitmapShader(paint));
    }

    public void drawOval(RectF rectF, Paint paint) {
        super.drawOval(rectF, replaceBitmapShader(paint));
    }

    public void drawOval(float f, float f2, float f3, float f4, Paint paint) {
        super.drawOval(f, f2, f3, f4, replaceBitmapShader(paint));
    }

    public void drawPaint(Paint paint) {
        super.drawPaint(replaceBitmapShader(paint));
    }

    public void drawPath(Path path, Paint paint) {
        super.drawPath(path, replaceBitmapShader(paint));
    }

    public void drawPoint(float f, float f2, Paint paint) {
        super.drawPoint(f, f2, replaceBitmapShader(paint));
    }

    public void drawPoints(float[] fArr, int i, int i2, Paint paint) {
        super.drawPoints(fArr, i, i2, replaceBitmapShader(paint));
    }

    public void drawPoints(float[] fArr, Paint paint) {
        super.drawPoints(fArr, replaceBitmapShader(paint));
    }

    public void drawPosText(char[] cArr, int i, int i2, float[] fArr, Paint paint) {
        super.drawPosText(cArr, i, i2, fArr, replaceBitmapShader(paint));
    }

    public void drawPosText(String str, float[] fArr, Paint paint) {
        super.drawPosText(str, fArr, replaceBitmapShader(paint));
    }

    public void drawRect(RectF rectF, Paint paint) {
        super.drawRect(rectF, replaceBitmapShader(paint));
    }

    public void drawRect(Rect rect, Paint paint) {
        super.drawRect(rect, replaceBitmapShader(paint));
    }

    public void drawRect(float f, float f2, float f3, float f4, Paint paint) {
        super.drawRect(f, f2, f3, f4, replaceBitmapShader(paint));
    }

    public void drawText(char[] cArr, int i, int i2, float f, float f2, Paint paint) {
        super.drawText(cArr, i, i2, f, f2, replaceBitmapShader(paint));
    }

    public void drawText(String str, float f, float f2, Paint paint) {
        super.drawText(str, f, f2, replaceBitmapShader(paint));
    }

    public void drawText(String str, int i, int i2, float f, float f2, Paint paint) {
        super.drawText(str, i, i2, f, f2, replaceBitmapShader(paint));
    }

    public void drawText(CharSequence charSequence, int i, int i2, float f, float f2, Paint paint) {
        super.drawText(charSequence, i, i2, f, f2, replaceBitmapShader(paint));
    }

    public void drawTextOnPath(char[] cArr, int i, int i2, Path path, float f, float f2, Paint paint) {
        super.drawTextOnPath(cArr, i, i2, path, f, f2, replaceBitmapShader(paint));
    }

    public void drawTextOnPath(String str, Path path, float f, float f2, Paint paint) {
        super.drawTextOnPath(str, path, f, f2, replaceBitmapShader(paint));
    }
}
