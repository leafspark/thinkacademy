package com.xueersi.lib.graffiti.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.yalantis.ucrop.view.CropImageView;

public class Utils {
    public static float calculateDegrees(PointF pointF, PointF pointF2) {
        return (float) Math.toDegrees((double) ((float) Math.atan2((double) (pointF.y - pointF2.y), (double) (pointF.x - pointF2.x))));
    }

    public static float getAccurancyDistance(PointF pointF, PointF pointF2) {
        return (float) Math.sqrt(Math.pow((double) (pointF.x - pointF2.x), 2.0d) + Math.pow((double) (pointF.y - pointF2.y), 2.0d));
    }

    public static float getAccurancyDistance(float f, float f2, float f3, float f4) {
        return (float) Math.sqrt(Math.pow((double) (f - f3), 2.0d) + Math.pow((double) (f2 - f4), 2.0d));
    }

    public static boolean calculate(PointF[] pointFArr, float f, PointF[] pointFArr2) {
        boolean z = f > CropImageView.DEFAULT_ASPECT_RATIO;
        float abs = Math.abs(f);
        int i = 0;
        while (i < 3) {
            int i2 = i + 1;
            int i3 = i2 % 3;
            int i4 = (i + 2) % 3;
            int i5 = i % 3;
            double sin = (double) ((float) (((double) abs) / Math.sin((double) (calculateAngle(new PointF(pointFArr[i3].x - pointFArr[i5].x, pointFArr[i3].y - pointFArr[i5].y), new PointF(pointFArr[i4].x - pointFArr[i5].x, pointFArr[i4].y - pointFArr[i5].y)) / 2.0f))));
            double calculateMidAngle = (double) calculateMidAngle(new PointF(pointFArr[i3].x - pointFArr[i].x, pointFArr[i3].y - pointFArr[i5].y), new PointF(pointFArr[i4].x - pointFArr[i5].x, pointFArr[i4].y - pointFArr[i5].y));
            float sin2 = (float) (sin * Math.sin(calculateMidAngle));
            pointFArr2[i5].x = pointFArr[i5].x + ((float) (Math.cos(calculateMidAngle) * sin));
            pointFArr2[i5].y = pointFArr[i5].y + sin2;
            i = i2;
        }
        if (!z ? getDistance(pointFArr2[0], pointFArr2[1]) < getDistance(pointFArr[0], pointFArr[1]) : getDistance(pointFArr2[0], pointFArr2[1]) > getDistance(pointFArr[0], pointFArr[1])) {
            for (int i6 = 0; i6 < 3; i6++) {
                pointFArr2[i6].x = (pointFArr[i6].x * 2.0f) - pointFArr2[i6].x;
                pointFArr2[i6].y = (pointFArr[i6].y * 2.0f) - pointFArr2[i6].y;
            }
        }
        int i7 = 0;
        while (i7 < 3) {
            boolean isInTriangle = isInTriangle(pointFArr[0], pointFArr[1], pointFArr[2], pointFArr2[i7]);
            if (z && !isInTriangle) {
                return false;
            }
            if (!z && isInTriangle) {
                return false;
            }
            int i8 = i7 + 1;
            int i9 = i8 % 3;
            int i10 = (i7 + 2) % 3;
            int i11 = i7 % 3;
            if (calculateAngle(new PointF(pointFArr[i9].x - pointFArr[i11].x, pointFArr[i9].y - pointFArr[i11].y), new PointF(pointFArr[i10].x - pointFArr[i11].x, pointFArr[i10].y - pointFArr[i11].y)) * calculateAngle(new PointF(pointFArr2[i9].x - pointFArr2[i11].x, pointFArr2[i9].y - pointFArr2[i11].y), new PointF(pointFArr2[i10].x - pointFArr2[i11].x, pointFArr2[i10].y - pointFArr2[i11].y)) < CropImageView.DEFAULT_ASPECT_RATIO) {
                return false;
            }
            i7 = i8;
        }
        return true;
    }

    public static float getDistance(PointF pointF, PointF pointF2) {
        return (float) Math.sqrt((double) (((pointF.x - pointF2.x) * (pointF.x - pointF2.x)) + ((pointF.y - pointF2.y) * (pointF.y - pointF2.y))));
    }

    public static float calculateAngle(PointF pointF, PointF pointF2) {
        return ((float) Math.atan2((double) pointF2.y, (double) pointF2.x)) - ((float) Math.atan2((double) pointF.y, (double) pointF.x));
    }

    public static float calculateMidAngle(PointF pointF, PointF pointF2) {
        return (((float) Math.atan2((double) pointF2.y, (double) pointF2.x)) + ((float) Math.atan2((double) pointF.y, (double) pointF.x))) / 2.0f;
    }

    public static boolean isInTriangle(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        PointF pointF5 = new PointF(pointF4.x - pointF.x, pointF4.y - pointF.y);
        PointF pointF6 = new PointF(pointF4.x - pointF2.x, pointF4.y - pointF2.y);
        PointF pointF7 = new PointF(pointF4.x - pointF3.x, pointF4.y - pointF3.y);
        float f = (pointF5.x * pointF6.y) - (pointF5.y * pointF6.x);
        float f2 = (pointF6.x * pointF7.y) - (pointF6.y * pointF7.x);
        float f3 = (pointF7.x * pointF5.y) - (pointF7.y * pointF5.x);
        if (f > CropImageView.DEFAULT_ASPECT_RATIO || f2 > CropImageView.DEFAULT_ASPECT_RATIO || f3 > CropImageView.DEFAULT_ASPECT_RATIO) {
            return f > CropImageView.DEFAULT_ASPECT_RATIO && f2 > CropImageView.DEFAULT_ASPECT_RATIO && f3 > CropImageView.DEFAULT_ASPECT_RATIO;
        }
        return true;
    }

    public static Drawable getResIcon(Context context, String str) {
        try {
            return context.getResources().getDrawable(context.getResources().getIdentifier(str, "drawable", context.getPackageName()));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Bitmap getResBitmap(Context context, String str, BitmapFactory.Options options) {
        try {
            return BitmapFactoryInstrumentation.decodeResource(context.getResources(), context.getResources().getIdentifier(str, "drawable", context.getPackageName()), options);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String getRGBbyRGBA(String str) {
        return (!TextUtils.isEmpty(str) && str.length() > 7) ? str.substring(0, 7) : str;
    }
}
