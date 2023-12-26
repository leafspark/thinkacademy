package com.tal.app.thinkacademy.lib.imageloader.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\"\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/lib/imageloader/util/BlurUtils;", "", "()V", "blur", "Landroid/graphics/Bitmap;", "toTransform", "radius", "", "rsBlur", "context", "Landroid/content/Context;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BlurUtils.kt */
public final class BlurUtils {
    public static final BlurUtils INSTANCE = new BlurUtils();

    private BlurUtils() {
    }

    public final Bitmap rsBlur(Context context, Bitmap bitmap, int i) {
        Intrinsics.checkNotNullParameter(bitmap, "toTransform");
        RenderScript create = RenderScript.create(context);
        Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
        Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        create2.setInput(createFromBitmap);
        create2.setRadius((float) i);
        create2.forEach(createTyped);
        createTyped.copyTo(bitmap);
        create.destroy();
        return bitmap;
    }

    public final Bitmap blur(Bitmap bitmap, int i) {
        int[] iArr;
        int i2 = i;
        Intrinsics.checkNotNullParameter(bitmap, "toTransform");
        if (i2 < 1) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = width * height;
        int[] iArr2 = new int[i3];
        bitmap.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i4 = width - 1;
        int i5 = height - 1;
        int i6 = i2 + i2 + 1;
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[i3];
        int[] iArr5 = new int[i3];
        int[] iArr6 = new int[Math.max(width, height)];
        int i7 = (i6 + 1) >> 1;
        int i8 = i7 * i7;
        int i9 = i8 * 256;
        int[] iArr7 = new int[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            iArr7[i10] = i10 / i8;
        }
        int[][] iArr8 = new int[i6][];
        for (int i11 = 0; i11 < i6; i11++) {
            iArr8[i11] = new int[3];
        }
        int i12 = i2 + 1;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < height) {
            int i16 = -i2;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            while (i16 <= i2) {
                int i26 = i5;
                int i27 = height;
                int i28 = iArr2[i14 + Math.min(i4, Math.max(i16, 0))];
                int[] iArr9 = iArr8[i16 + i2];
                iArr9[0] = (i28 & 16711680) >> 16;
                iArr9[1] = (i28 & 65280) >> 8;
                iArr9[2] = i28 & 255;
                int abs = i12 - Math.abs(i16);
                i17 += iArr9[0] * abs;
                i18 += iArr9[1] * abs;
                i19 += iArr9[2] * abs;
                if (i16 > 0) {
                    i23 += iArr9[0];
                    i24 += iArr9[1];
                    i25 += iArr9[2];
                } else {
                    i20 += iArr9[0];
                    i21 += iArr9[1];
                    i22 += iArr9[2];
                }
                i16++;
                height = i27;
                i5 = i26;
            }
            int i29 = i5;
            int i30 = height;
            int i31 = i2;
            int i32 = 0;
            while (i32 < width) {
                iArr3[i14] = iArr7[i17];
                iArr4[i14] = iArr7[i18];
                iArr5[i14] = iArr7[i19];
                int i33 = i17 - i20;
                int i34 = i18 - i21;
                int i35 = i19 - i22;
                int[] iArr10 = iArr8[((i31 - i2) + i6) % i6];
                int i36 = i20 - iArr10[0];
                int i37 = i21 - iArr10[1];
                int i38 = i22 - iArr10[2];
                if (i13 == 0) {
                    iArr = iArr7;
                    iArr6[i32] = Math.min(i32 + i2 + 1, i4);
                } else {
                    iArr = iArr7;
                }
                int i39 = iArr2[i15 + iArr6[i32]];
                iArr10[0] = (i39 & 16711680) >> 16;
                iArr10[1] = (i39 & 65280) >> 8;
                iArr10[2] = i39 & 255;
                int i40 = i23 + iArr10[0];
                int i41 = i24 + iArr10[1];
                int i42 = i25 + iArr10[2];
                i17 = i33 + i40;
                i18 = i34 + i41;
                i19 = i35 + i42;
                i31 = (i31 + 1) % i6;
                int[] iArr11 = iArr8[i31 % i6];
                i20 = i36 + iArr11[0];
                i21 = i37 + iArr11[1];
                i22 = i38 + iArr11[2];
                i23 = i40 - iArr11[0];
                i24 = i41 - iArr11[1];
                i25 = i42 - iArr11[2];
                i14++;
                i32++;
                iArr7 = iArr;
            }
            int[] iArr12 = iArr7;
            i15 += width;
            i13++;
            Bitmap bitmap2 = bitmap;
            height = i30;
            i5 = i29;
        }
        int i43 = i5;
        int i44 = height;
        int[] iArr13 = iArr7;
        int i45 = 0;
        while (i45 < width) {
            int i46 = -i2;
            int i47 = i46 * width;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = 0;
            int i56 = 0;
            while (i46 <= i2) {
                int[] iArr14 = iArr6;
                int max = Math.max(0, i47) + i45;
                int[] iArr15 = iArr8[i46 + i2];
                iArr15[0] = iArr3[max];
                iArr15[1] = iArr4[max];
                iArr15[2] = iArr5[max];
                int abs2 = i12 - Math.abs(i46);
                i48 += iArr3[max] * abs2;
                i49 += iArr4[max] * abs2;
                i50 += iArr5[max] * abs2;
                if (i46 > 0) {
                    i54 += iArr15[0];
                    i55 += iArr15[1];
                    i56 += iArr15[2];
                } else {
                    i51 += iArr15[0];
                    i52 += iArr15[1];
                    i53 += iArr15[2];
                }
                int i57 = i43;
                if (i46 < i57) {
                    i47 += width;
                }
                i46++;
                i43 = i57;
                iArr6 = iArr14;
            }
            int[] iArr16 = iArr6;
            int i58 = i43;
            int i59 = i2;
            int i60 = i45;
            int i61 = i44;
            int i62 = 0;
            while (i62 < i61) {
                iArr2[i60] = (iArr2[i60] & -16777216) | (iArr13[i48] << 16) | (iArr13[i49] << 8) | iArr13[i50];
                int i63 = i48 - i51;
                int i64 = i49 - i52;
                int i65 = i50 - i53;
                int[] iArr17 = iArr8[((i59 - i2) + i6) % i6];
                int i66 = i51 - iArr17[0];
                int i67 = i52 - iArr17[1];
                int i68 = i53 - iArr17[2];
                int i69 = i61;
                if (i45 == 0) {
                    iArr16[i62] = Math.min(i62 + i12, i58) * width;
                }
                int i70 = iArr16[i62] + i45;
                iArr17[0] = iArr3[i70];
                iArr17[1] = iArr4[i70];
                iArr17[2] = iArr5[i70];
                int i71 = i54 + iArr17[0];
                int i72 = i55 + iArr17[1];
                int i73 = i56 + iArr17[2];
                i48 = i63 + i71;
                i49 = i64 + i72;
                i50 = i65 + i73;
                i59 = (i59 + 1) % i6;
                int[] iArr18 = iArr8[i59];
                i51 = i66 + iArr18[0];
                i52 = i67 + iArr18[1];
                i53 = i68 + iArr18[2];
                i54 = i71 - iArr18[0];
                i55 = i72 - iArr18[1];
                i56 = i73 - iArr18[2];
                i60 += width;
                i62++;
                i61 = i69;
            }
            i44 = i61;
            i45++;
            i43 = i58;
            iArr6 = iArr16;
        }
        bitmap.setPixels(iArr2, 0, width, 0, 0, width, i44);
        return bitmap;
    }
}
