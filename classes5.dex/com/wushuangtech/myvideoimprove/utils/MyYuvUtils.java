package com.wushuangtech.myvideoimprove.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;

public class MyYuvUtils {
    private static Allocation in;
    private static int lastDataLen;
    private static int lastHeight;
    private static int lastWidth;
    private static Allocation out;
    private static RenderScript renderScript;
    private static ScriptIntrinsicYuvToRGB yuvToRgbIntrinsic;

    public static Bitmap nv21ToBitmap(Context context, byte[] bArr, int i, int i2) {
        if (renderScript == null) {
            renderScript = RenderScript.create(context);
        }
        if (yuvToRgbIntrinsic == null) {
            RenderScript renderScript2 = renderScript;
            yuvToRgbIntrinsic = ScriptIntrinsicYuvToRGB.create(renderScript2, Element.U8_4(renderScript2));
        }
        if (in == null || lastDataLen != bArr.length) {
            RenderScript renderScript3 = renderScript;
            in = Allocation.createTyped(renderScript, new Type.Builder(renderScript3, Element.U8(renderScript3)).setX(bArr.length).create(), 1);
            lastDataLen = bArr.length;
        }
        if (!(out != null && lastWidth == i && lastHeight == i2)) {
            RenderScript renderScript4 = renderScript;
            out = Allocation.createTyped(renderScript, new Type.Builder(renderScript4, Element.RGBA_8888(renderScript4)).setX(i).setY(i2).create(), 1);
            lastWidth = i;
            lastHeight = i2;
        }
        in.copyFrom(bArr);
        yuvToRgbIntrinsic.setInput(in);
        yuvToRgbIntrinsic.forEach(out);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        out.copyTo(createBitmap);
        return createBitmap;
    }

    public static byte[] I420ToNV21(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[4147200];
        int i3 = i * i2;
        int i4 = i3 / 4;
        int i5 = (i3 * 5) / 4;
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = (i6 * 2) + i3;
            bArr2[i7] = bArr[i5 + i6];
            bArr2[i7 + 1] = bArr[i3 + i6];
        }
        return bArr2;
    }
}
