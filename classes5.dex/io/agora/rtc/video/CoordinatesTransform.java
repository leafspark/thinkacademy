package io.agora.rtc.video;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;

public class CoordinatesTransform {
    public static RectF normalizedFaceRect(Rect rect, int i, boolean z) {
        Matrix matrix = new Matrix();
        prepareMatrix(matrix, z, i);
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        return rectF;
    }

    private static void prepareMatrix(Matrix matrix, boolean z, int i) {
        matrix.setScale(z ? -1.0f : 1.0f, 1.0f);
        matrix.postRotate((float) i);
        matrix.postScale(5.0E-4f, 5.0E-4f);
        matrix.postTranslate(0.5f, 0.5f);
    }

    public static Rect sensorToNormalizedPreview(Rect rect, int i, int i2, Rect rect2) {
        double d;
        double d2;
        if (i > i2) {
            d2 = (double) i;
            d = (double) i2;
        } else {
            d2 = (double) i2;
            d = (double) i;
        }
        double d3 = d2 / d;
        double width = ((double) rect2.width()) / ((double) rect2.height());
        int width2 = rect2.width();
        int height = rect2.height();
        if (d3 > width) {
            height = (int) (((double) width2) / d3);
        } else {
            width2 = (int) (((double) height) * d3);
        }
        int abs = Math.abs(width2 - rect2.width());
        int abs2 = Math.abs(height - rect2.height());
        RectF rectF = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.postTranslate((float) ((-rect2.left) - (abs / 2)), (float) ((-rect2.top) - (abs2 / 2)));
        matrix.postTranslate((float) ((-width2) / 2), (float) ((-height) / 2));
        matrix.postScale(2000.0f / ((float) width2), 2000.0f / ((float) height));
        matrix.mapRect(rectF);
        Rect rect3 = new Rect();
        rectF.round(rect3);
        return rect3;
    }
}
