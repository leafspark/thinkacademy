package org.libpag;

import android.hardware.HardwareBuffer;
import android.os.Build;

abstract class a {
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.util.Pair a(int r3, int r4, boolean r5) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x003a
            if (r4 != 0) goto L_0x0006
            goto L_0x003a
        L_0x0006:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 30
            if (r1 >= r2) goto L_0x0012
            if (r5 != 0) goto L_0x002f
            r5 = 29
            if (r1 < r5) goto L_0x002f
        L_0x0012:
            android.hardware.HardwareBuffer r5 = a(r3, r4)
            if (r5 == 0) goto L_0x0027
            android.graphics.ColorSpace$Named r1 = android.graphics.ColorSpace.Named.SRGB     // Catch:{ Exception -> 0x0023 }
            android.graphics.ColorSpace r1 = android.graphics.ColorSpace.get(r1)     // Catch:{ Exception -> 0x0023 }
            android.graphics.Bitmap r1 = android.graphics.Bitmap.wrapHardwareBuffer(r5, r1)     // Catch:{ Exception -> 0x0023 }
            goto L_0x0028
        L_0x0023:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0027:
            r1 = r0
        L_0x0028:
            if (r1 == 0) goto L_0x002f
            android.util.Pair r3 = android.util.Pair.create(r1, r5)
            return r3
        L_0x002f:
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r3, r4, r5)
            android.util.Pair r3 = android.util.Pair.create(r3, r0)
            return r3
        L_0x003a:
            android.util.Pair r3 = android.util.Pair.create(r0, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.libpag.a.a(int, int, boolean):android.util.Pair");
    }

    private static HardwareBuffer a(int i, int i2) {
        if (i <= 0 || i2 <= 0 || Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            return HardwareBuffer.create(i, i2, 1, 1, 307);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
