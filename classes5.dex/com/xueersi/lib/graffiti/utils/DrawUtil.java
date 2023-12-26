package com.xueersi.lib.graffiti.utils;

import android.content.Context;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.ViewConfiguration;
import com.xueersi.lib.graffiti.draw.shape.math.VectorPath;
import com.yalantis.ucrop.view.CropImageView;

public class DrawUtil {
    public static void drawUShapePipe(Path path, Rect rect, float f) {
        float f2;
        double d;
        float f3;
        double d2;
        Path path2 = path;
        Rect rect2 = rect;
        int width = rect.width();
        int height = rect.height();
        int i = rect2.left;
        int i2 = rect2.top;
        int i3 = rect2.right;
        int i4 = rect2.bottom;
        path.reset();
        float f4 = (float) width;
        float f5 = f4 * 0.5f;
        float f6 = (float) i;
        float f7 = f6 + f5;
        float f8 = ((float) (i2 + height)) - f5;
        float f9 = ((float) height) - f5;
        float f10 = f6;
        double d3 = (double) f9;
        float sqrt = (float) Math.sqrt(Math.pow((double) f5, 2.0d) - Math.pow(d3, 2.0d));
        int i5 = (f9 > CropImageView.DEFAULT_ASPECT_RATIO ? 1 : (f9 == CropImageView.DEFAULT_ASPECT_RATIO ? 0 : -1));
        if (i5 < 0) {
            if (Math.abs(f9) < f5) {
                double degrees = 90.0d - Math.toDegrees(Math.acos((double) (Math.abs(f9) / f5)));
                float f11 = (float) (180.0d - (degrees * 2.0d));
                float f12 = f8 - f5;
                float f13 = f11;
                f3 = sqrt;
                d = d3;
                d2 = 2.0d;
                path.addArc(f10, f12, (float) i3, (float) i4, (float) (degrees + 0.0d), f13);
            } else {
                f3 = sqrt;
                d = d3;
                d2 = 2.0d;
            }
            f2 = f10;
        } else {
            f3 = sqrt;
            d = d3;
            d2 = 2.0d;
            float f14 = (float) i2;
            float f15 = f10;
            path2.moveTo(f15, f14);
            path2.lineTo(f15, f8);
            float f16 = (float) i3;
            path2.moveTo(f16, f14);
            path2.lineTo(f16, f8);
            f2 = f15;
            path.addArc(f15, f8 - f5, f16, (float) i4, CropImageView.DEFAULT_ASPECT_RATIO, 180.0f);
        }
        float f17 = (0.5f - f) * f4;
        if (i5 < 0) {
            float sqrt2 = (float) Math.sqrt(Math.pow((double) f17, d2) - Math.pow(d, d2));
            if (!Float.isNaN(sqrt2)) {
                float f18 = (float) i2;
                path2.moveTo(f7 - f3, f18);
                path2.lineTo(f7 - sqrt2, f18);
                path2.moveTo(f7 + f3, f18);
                path2.lineTo(sqrt2 + f7, f18);
                double degrees2 = 90.0d - Math.toDegrees(Math.acos((double) (Math.abs(f9) / f17)));
                path.addArc(f7 - f17, f8 - f17, f7 + f17, f8 + f17, (float) (degrees2 + 0.0d), (float) (180.0d - (degrees2 * d2)));
                return;
            }
            float f19 = (float) i2;
            path2.moveTo(f7 - f3, f19);
            path2.lineTo(f7 + f3, f19);
            return;
        }
        float f20 = (float) i2;
        float f21 = f2;
        path2.moveTo(f21, f20);
        float f22 = f21 + (f * f4);
        path2.lineTo(f22, f20);
        path2.lineTo(f22, f8);
        path2.moveTo((float) i3, f20);
        float f23 = f21 + ((1.0f - f) * f4);
        path2.lineTo(f23, f20);
        path2.lineTo(f23, f8);
        path.addArc(f7 - f17, f8 - f17, f7 + f17, f8 + f17, CropImageView.DEFAULT_ASPECT_RATIO, 180.0f);
    }

    public static void drawCircleFunnel(Path path, Rect rect) {
        Path path2 = path;
        Rect rect2 = rect;
        int width = rect.width();
        int height = rect.height();
        int i = rect2.left;
        int i2 = rect2.top;
        path.reset();
        float f = (float) i;
        float f2 = (float) width;
        float f3 = (float) i2;
        float f4 = (float) height;
        float f5 = f3 + (0.106f * f4);
        path2.moveTo((0.167f * f2) + f, f5);
        float f6 = f3 + (0.139f * f4);
        float f7 = f3 + (0.187f * f4);
        float f8 = f3 + (0.24f * f4);
        float f9 = f5;
        path.cubicTo(f + (0.0645f * f2), f6, f, f7, f, f8);
        float f10 = f3 + (0.33f * f4);
        float f11 = f3 + (0.404f * f4);
        float f12 = f3 + (0.418f * f4);
        path.cubicTo(f, f10, f + (0.18f * f2), f11, f + (0.417f * f2), f12);
        path2.moveTo((0.584f * f2) + f, f12);
        float f13 = (float) (i + width);
        path.cubicTo(f + (0.82f * f2), f11, f13, f10, f13, f8);
        path.cubicTo(f13, f7, f + (0.935f * f2), f6, f + (0.833f * f2), f9);
        float f14 = (0.416f * f2) + f;
        float f15 = (0.421f * f4) + f3;
        path2.moveTo(f14, f15);
        path2.lineTo(f14, (float) (i2 + height));
        float f16 = (0.581f * f2) + f;
        path2.lineTo(f16, (0.919f * f4) + f3);
        path2.lineTo(f16, f15);
        float f17 = f3 + (0.12f * f4);
        path2.moveTo((0.873f * f2) + f, f17);
        float f18 = f3 + (0.098f * f4);
        float f19 = f + (0.667f * f2);
        float f20 = f3 + (0.071f * f4);
        path.cubicTo(f + (0.817f * f2), f18, f + (0.747f * f2), f3 + (0.081f * f4), f19, f20);
        path2.lineTo(f19, f3);
        float f21 = (0.333f * f2) + f;
        path2.lineTo(f21, f3);
        path2.lineTo(f21, f20);
        path.cubicTo(f + (0.253f * f2), f3 + (f4 * 0.082f), f + (0.183f * f2), f18, f + (f2 * 0.127f), f17);
    }

    public static void drawPolygon(Path path, Rect rect, int i, boolean z) {
        Path path2 = path;
        Rect rect2 = rect;
        int i2 = i;
        int width = rect.width();
        int height = rect.height();
        int i3 = rect2.left;
        int i4 = rect2.top;
        float f = 0.5f;
        float min = ((float) Math.min(width, height)) * 0.5f;
        float f2 = (float) (6.283185307179586d / ((double) i2));
        float f3 = i2 % 2 == 0 ? -f2 : -1.5707964f;
        path.reset();
        int i5 = width - height;
        Math.abs(i5);
        int i6 = 0;
        int max = Math.max(i5, 0);
        int max2 = Math.max(height - width, 0);
        while (i6 <= i2) {
            double d = (double) min;
            double d2 = (double) f3;
            float f4 = f2;
            int cos = (int) (((Math.cos(d2) + 1.0d) * d) + ((double) (((float) max) * f)));
            int sin = (int) ((d * (Math.sin(d2) + 1.0d)) + ((double) (((float) max2) * 0.5f)));
            if (i6 == 0) {
                path2.moveTo((float) (cos + i3), (float) (sin + i4));
            } else if (!z) {
                path2.lineTo((float) (cos + i3), (float) (sin + i4));
            } else if (i6 % 2 == 0) {
                path2.moveTo((float) (cos + i3), (float) (sin + i4));
            } else {
                path2.lineTo((float) (cos + i3), (float) (sin + i4));
            }
            f3 += f4;
            i6++;
            f = 0.5f;
            f2 = f4;
        }
    }

    public static void drawHalfOval(Path path, int i, int i2, int i3, int i4, boolean z) {
        Path path2 = path;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        float f = (float) (((double) i7) * 0.5522847771644592d);
        float f2 = (float) (((double) i8) * 0.5522847771644592d);
        if (z) {
            float f3 = (float) (i5 - i7);
            float f4 = (float) i6;
            path.moveTo(f3, f4);
            float f5 = f4 - f2;
            float f6 = (float) i5;
            float f7 = (float) (i6 - i8);
            path.cubicTo(f3, f5, f6 - f, f7, f6, f7);
            float f8 = (float) (i5 + i7);
            path.cubicTo(f6 + f, f7, f8, f5, f8, f4);
            return;
        }
        float f9 = (float) (i5 + i7);
        float f10 = (float) i6;
        path.moveTo(f9, f10);
        float f11 = f10 + f2;
        float f12 = (float) i5;
        float f13 = (float) (i6 + i8);
        path.cubicTo(f9, f11, f12 + f, f13, f12, f13);
        float f14 = (float) (i5 - i7);
        path.cubicTo(f12 - f, f13, f14, f11, f14, f10);
    }

    public static void drawHalfOval(VectorPath vectorPath, float f, float f2, float f3, float f4, boolean z) {
        VectorPath vectorPath2 = vectorPath;
        float f5 = f2;
        float f6 = f3;
        float f7 = f4;
        float f8 = (float) (((double) f6) * 0.5522847771644592d);
        float f9 = (float) (((double) f7) * 0.5522847771644592d);
        if (z) {
            float f10 = f - f6;
            vectorPath.moveTo(f10, f2);
            float f11 = f5 - f9;
            float f12 = f5 - f7;
            VectorPath vectorPath3 = vectorPath;
            vectorPath3.cubicTo(f10, f11, f - f8, f12, f, f12);
            float f13 = f + f6;
            vectorPath3.cubicTo(f + f8, f12, f13, f11, f13, f2);
            return;
        }
        float f14 = f + f6;
        vectorPath.moveTo(f14, f2);
        float f15 = f5 + f9;
        float f16 = f5 + f7;
        VectorPath vectorPath4 = vectorPath;
        vectorPath4.cubicTo(f14, f15, f + f8, f16, f, f16);
        float f17 = f - f6;
        vectorPath4.cubicTo(f - f8, f16, f17, f15, f17, f2);
    }

    public static void computePathBounds(Path path, RectF rectF, float f) {
        if (path != null && rectF != null) {
            rectF.setEmpty();
            path.computeBounds(rectF, false);
            float f2 = -((f * 0.5f) + 1.0f);
            rectF.inset(f2, f2);
        }
    }

    public static void computePathBounds(Path path, RectF rectF, Rect rect, float f) {
        computePathBounds(path, rectF, f);
        rectF.roundOut(rect);
    }

    public static boolean canSoftwareDraw(Context context, int i, int i2) {
        return ((long) ((i * i2) * 4)) <= ((long) ViewConfiguration.get(context).getScaledMaximumDrawingCacheSize());
    }
}
