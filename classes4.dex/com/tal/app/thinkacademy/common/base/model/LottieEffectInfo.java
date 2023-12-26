package com.tal.app.thinkacademy.common.base.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.JsonReader;
import com.airbnb.lottie.LottieAnimationView;
import com.tal.app.thinkacademy.lib.util.AssertUtil;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class LottieEffectInfo {
    private String imgDir;
    private String jsonFilePath;
    private List<String> targetFileName;

    public Bitmap fetchTargetBitMap(LottieAnimationView lottieAnimationView, String str, String str2, int i, int i2) {
        return null;
    }

    public String getImgDir() {
        return this.imgDir;
    }

    public LottieEffectInfo(String str, String str2, String... strArr) {
        this.imgDir = str;
        this.jsonFilePath = str2;
        this.targetFileName = Arrays.asList(strArr);
    }

    public void setTargetFileFilter(String[] strArr) {
        this.targetFileName = Arrays.asList(strArr);
    }

    public Bitmap fetchBitmap(LottieAnimationView lottieAnimationView, String str, String str2, int i, int i2) {
        List<String> list = this.targetFileName;
        if (list == null || !list.contains(str)) {
            return getBitMap(str);
        }
        return fetchTargetBitMap(lottieAnimationView, str, str2, i, i2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.io.InputStream} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040 A[SYNTHETIC, Splitter:B:20:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004c A[SYNTHETIC, Splitter:B:26:0x004c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap getBitMap(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0039 }
            r1.<init>()     // Catch:{ Exception -> 0x0039 }
            java.lang.String r2 = r4.imgDir     // Catch:{ Exception -> 0x0039 }
            r1.append(r2)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r2 = java.io.File.separator     // Catch:{ Exception -> 0x0039 }
            r1.append(r2)     // Catch:{ Exception -> 0x0039 }
            r1.append(r5)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r5 = r1.toString()     // Catch:{ Exception -> 0x0039 }
            java.io.InputStream r5 = com.tal.app.thinkacademy.lib.util.AssertUtil.open(r5)     // Catch:{ Exception -> 0x0039 }
            android.graphics.Bitmap r0 = com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation.decodeStream(r5)     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            r5.close()     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            if (r5 == 0) goto L_0x0049
            r5.close()     // Catch:{ IOException -> 0x0028 }
            goto L_0x0049
        L_0x0028:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x0049
        L_0x002d:
            r0 = move-exception
            goto L_0x004a
        L_0x002f:
            r1 = move-exception
            r3 = r0
            r0 = r5
            r5 = r3
            goto L_0x003b
        L_0x0034:
            r5 = move-exception
            r3 = r0
            r0 = r5
            r5 = r3
            goto L_0x004a
        L_0x0039:
            r1 = move-exception
            r5 = r0
        L_0x003b:
            r1.printStackTrace()     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0048
            r0.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0048:
            r0 = r5
        L_0x0049:
            return r0
        L_0x004a:
            if (r5 == 0) goto L_0x0054
            r5.close()     // Catch:{ IOException -> 0x0050 }
            goto L_0x0054
        L_0x0050:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0054:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.base.model.LottieEffectInfo.getBitMap(java.lang.String):android.graphics.Bitmap");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.io.InputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004f A[SYNTHETIC, Splitter:B:26:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005b A[SYNTHETIC, Splitter:B:32:0x005b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap fetchBitmapFromAssets(com.airbnb.lottie.LottieAnimationView r2, java.lang.String r3, java.lang.String r4, int r5, int r6, android.content.Context r7) {
        /*
            r1 = this;
            java.util.List<java.lang.String> r7 = r1.targetFileName
            if (r7 == 0) goto L_0x000f
            boolean r7 = r7.contains(r3)
            if (r7 == 0) goto L_0x000f
            android.graphics.Bitmap r2 = r1.fetchTargetBitMap(r2, r3, r4, r5, r6)
            return r2
        L_0x000f:
            r2 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0048 }
            r4.<init>()     // Catch:{ Exception -> 0x0048 }
            java.lang.String r5 = r1.imgDir     // Catch:{ Exception -> 0x0048 }
            r4.append(r5)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r5 = java.io.File.separator     // Catch:{ Exception -> 0x0048 }
            r4.append(r5)     // Catch:{ Exception -> 0x0048 }
            r4.append(r3)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0048 }
            java.io.InputStream r3 = com.tal.app.thinkacademy.lib.util.AssertUtil.open(r3)     // Catch:{ Exception -> 0x0048 }
            android.graphics.Bitmap r2 = com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation.decodeStream(r3)     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            r3.close()     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            if (r3 == 0) goto L_0x0058
            r3.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x0058
        L_0x0037:
            r3 = move-exception
            r3.printStackTrace()
            goto L_0x0058
        L_0x003c:
            r2 = move-exception
            goto L_0x0059
        L_0x003e:
            r4 = move-exception
            r0 = r3
            r3 = r2
            r2 = r0
            goto L_0x004a
        L_0x0043:
            r3 = move-exception
            r0 = r3
            r3 = r2
            r2 = r0
            goto L_0x0059
        L_0x0048:
            r4 = move-exception
            r3 = r2
        L_0x004a:
            r4.printStackTrace()     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x0057
            r2.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0057
        L_0x0053:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0057:
            r2 = r3
        L_0x0058:
            return r2
        L_0x0059:
            if (r3 == 0) goto L_0x0063
            r3.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0063:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.base.model.LottieEffectInfo.fetchBitmapFromAssets(com.airbnb.lottie.LottieAnimationView, java.lang.String, java.lang.String, int, int, android.content.Context):android.graphics.Bitmap");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: android.graphics.Bitmap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: java.io.InputStream} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040 A[SYNTHETIC, Splitter:B:20:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004c A[SYNTHETIC, Splitter:B:26:0x004c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap getBitMapFromAssets(java.lang.String r4, android.content.Context r5) {
        /*
            r3 = this;
            r5 = 0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0039 }
            r0.<init>()     // Catch:{ Exception -> 0x0039 }
            java.lang.String r1 = r3.imgDir     // Catch:{ Exception -> 0x0039 }
            r0.append(r1)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r1 = java.io.File.separator     // Catch:{ Exception -> 0x0039 }
            r0.append(r1)     // Catch:{ Exception -> 0x0039 }
            r0.append(r4)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r4 = r0.toString()     // Catch:{ Exception -> 0x0039 }
            java.io.InputStream r4 = com.tal.app.thinkacademy.lib.util.AssertUtil.open(r4)     // Catch:{ Exception -> 0x0039 }
            android.graphics.Bitmap r5 = com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation.decodeStream(r4)     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            r4.close()     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            if (r4 == 0) goto L_0x0049
            r4.close()     // Catch:{ IOException -> 0x0028 }
            goto L_0x0049
        L_0x0028:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x0049
        L_0x002d:
            r5 = move-exception
            goto L_0x004a
        L_0x002f:
            r0 = move-exception
            r2 = r5
            r5 = r4
            r4 = r2
            goto L_0x003b
        L_0x0034:
            r4 = move-exception
            r2 = r5
            r5 = r4
            r4 = r2
            goto L_0x004a
        L_0x0039:
            r0 = move-exception
            r4 = r5
        L_0x003b:
            r0.printStackTrace()     // Catch:{ all -> 0x0034 }
            if (r5 == 0) goto L_0x0048
            r5.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0048:
            r5 = r4
        L_0x0049:
            return r5
        L_0x004a:
            if (r4 == 0) goto L_0x0054
            r4.close()     // Catch:{ IOException -> 0x0050 }
            goto L_0x0054
        L_0x0050:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0054:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.base.model.LottieEffectInfo.getBitMapFromAssets(java.lang.String, android.content.Context):android.graphics.Bitmap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043 A[SYNTHETIC, Splitter:B:21:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004a A[SYNTHETIC, Splitter:B:26:0x004a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getJsonStr() {
        /*
            r4 = this;
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x003c, all -> 0x0038 }
            java.lang.String r2 = r4.jsonFilePath     // Catch:{ Exception -> 0x003c, all -> 0x0038 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x003c, all -> 0x0038 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x003c, all -> 0x0038 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x003c, all -> 0x0038 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x003c, all -> 0x0038 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x003c, all -> 0x0038 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0036 }
            r1.<init>()     // Catch:{ Exception -> 0x0036 }
        L_0x0017:
            java.lang.String r3 = r2.readLine()     // Catch:{ Exception -> 0x0036 }
            if (r3 == 0) goto L_0x0026
            r1.append(r3)     // Catch:{ Exception -> 0x0036 }
            java.lang.String r3 = "\n"
            r1.append(r3)     // Catch:{ Exception -> 0x0036 }
            goto L_0x0017
        L_0x0026:
            r2.close()     // Catch:{ Exception -> 0x0036 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0036 }
            r2.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0046
        L_0x0031:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0046
        L_0x0036:
            r1 = move-exception
            goto L_0x003e
        L_0x0038:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L_0x0048
        L_0x003c:
            r1 = move-exception
            r2 = r0
        L_0x003e:
            r1.printStackTrace()     // Catch:{ all -> 0x0047 }
            if (r2 == 0) goto L_0x0046
            r2.close()     // Catch:{ IOException -> 0x0031 }
        L_0x0046:
            return r0
        L_0x0047:
            r0 = move-exception
        L_0x0048:
            if (r2 == 0) goto L_0x0052
            r2.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0052:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.base.model.LottieEffectInfo.getJsonStr():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0042 A[SYNTHETIC, Splitter:B:21:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0049 A[SYNTHETIC, Splitter:B:26:0x0049] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getJsonStrFromAssets(android.content.Context r4) {
        /*
            r3 = this;
            r4 = 0
            java.lang.String r0 = r3.jsonFilePath     // Catch:{ Exception -> 0x003b, all -> 0x0037 }
            java.io.InputStream r0 = com.tal.app.thinkacademy.lib.util.AssertUtil.open(r0)     // Catch:{ Exception -> 0x003b, all -> 0x0037 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x003b, all -> 0x0037 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x003b, all -> 0x0037 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x003b, all -> 0x0037 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x003b, all -> 0x0037 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0035 }
            r0.<init>()     // Catch:{ Exception -> 0x0035 }
        L_0x0016:
            java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x0035 }
            if (r2 == 0) goto L_0x0025
            r0.append(r2)     // Catch:{ Exception -> 0x0035 }
            java.lang.String r2 = "\n"
            r0.append(r2)     // Catch:{ Exception -> 0x0035 }
            goto L_0x0016
        L_0x0025:
            r1.close()     // Catch:{ Exception -> 0x0035 }
            java.lang.String r4 = r0.toString()     // Catch:{ Exception -> 0x0035 }
            r1.close()     // Catch:{ IOException -> 0x0030 }
            goto L_0x0045
        L_0x0030:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0045
        L_0x0035:
            r0 = move-exception
            goto L_0x003d
        L_0x0037:
            r0 = move-exception
            r1 = r4
            r4 = r0
            goto L_0x0047
        L_0x003b:
            r0 = move-exception
            r1 = r4
        L_0x003d:
            r0.printStackTrace()     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x0045
            r1.close()     // Catch:{ IOException -> 0x0030 }
        L_0x0045:
            return r4
        L_0x0046:
            r4 = move-exception
        L_0x0047:
            if (r1 == 0) goto L_0x0051
            r1.close()     // Catch:{ IOException -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0051:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.base.model.LottieEffectInfo.getJsonStrFromAssets(android.content.Context):java.lang.String");
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap circleBitmap(Bitmap bitmap, int i) {
        int i2 = i * 2;
        Bitmap bitmap2 = null;
        try {
            bitmap2 = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap2);
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            Rect rect2 = new Rect(0, 0, i2, i2);
            Path path = new Path();
            float f = (float) i;
            path.addCircle(f, f, f, Path.Direction.CCW);
            canvas.clipPath(path);
            Paint paint = new Paint();
            paint.setFlags(3);
            canvas.drawBitmap(bitmap, rect, rect2, paint);
            return bitmap2;
        } catch (Exception e) {
            e.printStackTrace();
            return bitmap2;
        }
    }

    public JsonReader getJsonReader(Context context) {
        try {
            return new JsonReader(new InputStreamReader(AssertUtil.xrsAssertOpen(context, this.jsonFilePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
