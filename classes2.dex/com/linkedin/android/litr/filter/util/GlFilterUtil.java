package com.linkedin.android.litr.filter.util;

import android.opengl.Matrix;
import com.linkedin.android.litr.filter.Transform;

public class GlFilterUtil {
    public static float[] createFilterMvpMatrix(float[] fArr, Transform transform) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        Transform transform2 = transform;
        boolean z = fArr[0] == 0.0f;
        if (z) {
            f = Math.abs(fArr[4]);
        } else {
            f = Math.abs(fArr[0]);
        }
        float f6 = 1.0f / f;
        if (z) {
            f3 = transform2.size.x;
            f2 = transform2.size.y * f6;
        } else {
            f3 = transform2.size.x * f6;
            f2 = transform2.size.y;
        }
        if (z) {
            f5 = (transform2.position.x * 2.0f) - 1.0f;
            f4 = (1.0f - (transform2.position.y * 2.0f)) * f6;
        } else {
            f5 = ((transform2.position.x * 2.0f) - 1.0f) * f6;
            f4 = 1.0f - (transform2.position.y * 2.0f);
        }
        float[] fArr2 = new float[16];
        Matrix.setIdentityM(fArr2, 0);
        Matrix.translateM(fArr2, 0, f5, f4, 0.0f);
        Matrix.rotateM(fArr2, 0, transform2.rotation, 0.0f, 0.0f, 1.0f);
        Matrix.scaleM(fArr2, 0, f3, f2, 1.0f);
        float[] fArr3 = new float[16];
        Matrix.multiplyMM(fArr3, 0, fArr, 0, fArr2, 0);
        return fArr3;
    }
}
