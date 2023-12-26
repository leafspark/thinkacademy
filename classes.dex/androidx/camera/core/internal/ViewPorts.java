package androidx.camera.core.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.UseCase;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Map;

public class ViewPorts {
    private static float flipX(float f, float f2) {
        return (f2 + f2) - f;
    }

    private static float flipY(float f, float f2) {
        return (f2 + f2) - f;
    }

    private static boolean shouldMirrorStartAndEnd(boolean z, int i) {
        boolean z2 = true;
        if (i != 1) {
            z2 = false;
        }
        return z ^ z2;
    }

    private ViewPorts() {
    }

    public static Map<UseCase, Rect> calculateViewPortRects(Rect rect, boolean z, Rational rational, int i, int i2, int i3, Map<UseCase, Size> map) {
        Preconditions.checkArgument(rect.width() > 0 && rect.height() > 0, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF rectF = new RectF(rect);
        HashMap hashMap = new HashMap();
        RectF rectF2 = new RectF(rect);
        for (Map.Entry next : map.entrySet()) {
            Matrix matrix = new Matrix();
            RectF rectF3 = new RectF(0.0f, 0.0f, (float) ((Size) next.getValue()).getWidth(), (float) ((Size) next.getValue()).getHeight());
            matrix.setRectToRect(rectF3, rectF, Matrix.ScaleToFit.CENTER);
            hashMap.put((UseCase) next.getKey(), matrix);
            RectF rectF4 = new RectF();
            matrix.mapRect(rectF4, rectF3);
            rectF2.intersect(rectF4);
        }
        RectF scaledRect = getScaledRect(rectF2, ImageUtil.getRotatedAspectRatio(i, rational), i2, z, i3, i);
        HashMap hashMap2 = new HashMap();
        RectF rectF5 = new RectF();
        Matrix matrix2 = new Matrix();
        for (Map.Entry entry : hashMap.entrySet()) {
            ((Matrix) entry.getValue()).invert(matrix2);
            matrix2.mapRect(rectF5, scaledRect);
            Rect rect2 = new Rect();
            rectF5.round(rect2);
            hashMap2.put((UseCase) entry.getKey(), rect2);
        }
        return hashMap2;
    }

    public static RectF getScaledRect(RectF rectF, Rational rational, int i, boolean z, int i2, int i3) {
        if (i == 3) {
            return rectF;
        }
        Matrix matrix = new Matrix();
        RectF rectF2 = new RectF(0.0f, 0.0f, (float) rational.getNumerator(), (float) rational.getDenominator());
        if (i == 0) {
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.START);
        } else if (i == 1) {
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.CENTER);
        } else if (i == 2) {
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.END);
        } else {
            throw new IllegalStateException("Unexpected scale type: " + i);
        }
        RectF rectF3 = new RectF();
        matrix.mapRect(rectF3, rectF2);
        return correctStartOrEnd(shouldMirrorStartAndEnd(z, i2), i3, rectF, rectF3);
    }

    private static RectF correctStartOrEnd(boolean z, int i, RectF rectF, RectF rectF2) {
        boolean z2 = true;
        boolean z3 = i == 0 && !z;
        boolean z4 = i == 90 && z;
        if (z3 || z4) {
            return rectF2;
        }
        boolean z5 = i == 0 && z;
        boolean z6 = i == 270 && !z;
        if (z5 || z6) {
            return flipHorizontally(rectF2, rectF.centerX());
        }
        boolean z7 = i == 90 && !z;
        boolean z8 = i == 180 && z;
        if (z7 || z8) {
            return flipVertically(rectF2, rectF.centerY());
        }
        boolean z9 = i == 180 && !z;
        if (i != 270 || !z) {
            z2 = false;
        }
        if (z9 || z2) {
            return flipHorizontally(flipVertically(rectF2, rectF.centerY()), rectF.centerX());
        }
        throw new IllegalArgumentException("Invalid argument: mirrored " + z + " rotation " + i);
    }

    private static RectF flipHorizontally(RectF rectF, float f) {
        return new RectF(flipX(rectF.right, f), rectF.top, flipX(rectF.left, f), rectF.bottom);
    }

    private static RectF flipVertically(RectF rectF, float f) {
        return new RectF(rectF.left, flipY(rectF.bottom, f), rectF.right, flipY(rectF.top, f));
    }
}
