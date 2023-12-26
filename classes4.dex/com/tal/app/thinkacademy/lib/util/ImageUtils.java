package com.tal.app.thinkacademy.lib.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.tal.app.thinkacademy.common.location.CustomLocationManagerKt;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;

public final class ImageUtils {
    private ImageUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        return bitmap2Bytes(bitmap, Bitmap.CompressFormat.PNG, 100);
    }

    public static byte[] bitmap2Bytes(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Bitmap bytes2Bitmap(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return BitmapFactoryInstrumentation.decodeByteArray(bArr, 0, bArr.length);
    }

    public static Bitmap drawable2Bitmap(Drawable drawable) {
        Bitmap bitmap;
        Bitmap.Config config;
        Bitmap.Config config2;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            if (drawable.getOpacity() != -1) {
                config = Bitmap.Config.ARGB_8888;
            } else {
                config = Bitmap.Config.RGB_565;
            }
            bitmap = Bitmap.createBitmap(1, 1, config);
        } else {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (drawable.getOpacity() != -1) {
                config2 = Bitmap.Config.ARGB_8888;
            } else {
                config2 = Bitmap.Config.RGB_565;
            }
            bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config2);
        }
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static Drawable bitmap2Drawable(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapDrawable(Utils.getApp().getResources(), bitmap);
    }

    public static byte[] drawable2Bytes(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        return bitmap2Bytes(drawable2Bitmap(drawable));
    }

    public static byte[] drawable2Bytes(Drawable drawable, Bitmap.CompressFormat compressFormat, int i) {
        if (drawable == null) {
            return null;
        }
        return bitmap2Bytes(drawable2Bitmap(drawable), compressFormat, i);
    }

    public static Drawable bytes2Drawable(byte[] bArr) {
        return bitmap2Drawable(bytes2Bitmap(bArr));
    }

    public static Bitmap view2Bitmap(View view) {
        Bitmap bitmap;
        if (view == null) {
            return null;
        }
        boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
        boolean willNotCacheDrawing = view.willNotCacheDrawing();
        view.setDrawingCacheEnabled(true);
        view.setWillNotCacheDrawing(false);
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache();
            Bitmap drawingCache2 = view.getDrawingCache();
            if (drawingCache2 != null) {
                bitmap = Bitmap.createBitmap(drawingCache2);
            } else {
                bitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                view.draw(new Canvas(bitmap));
            }
        } else {
            bitmap = Bitmap.createBitmap(drawingCache);
        }
        view.destroyDrawingCache();
        view.setWillNotCacheDrawing(willNotCacheDrawing);
        view.setDrawingCacheEnabled(isDrawingCacheEnabled);
        return bitmap;
    }

    public static Bitmap getBitmap(File file) {
        if (file == null) {
            return null;
        }
        return BitmapFactoryInstrumentation.decodeFile(file.getAbsolutePath());
    }

    public static Bitmap getBitmap(File file, int i, int i2) {
        if (file == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactoryInstrumentation.decodeFile(file.getAbsolutePath(), options);
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactoryInstrumentation.decodeFile(file.getAbsolutePath(), options);
    }

    public static Bitmap getBitmap(String str) {
        if (UtilsBridge.isSpace(str)) {
            return null;
        }
        return BitmapFactoryInstrumentation.decodeFile(str);
    }

    public static Bitmap getBitmap(String str, int i, int i2) {
        if (UtilsBridge.isSpace(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactoryInstrumentation.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactoryInstrumentation.decodeFile(str, options);
    }

    public static Bitmap getBitmap(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        return BitmapFactoryInstrumentation.decodeStream(inputStream);
    }

    public static Bitmap getBitmap(InputStream inputStream, int i, int i2) {
        if (inputStream == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactoryInstrumentation.decodeStream(inputStream, (Rect) null, options);
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactoryInstrumentation.decodeStream(inputStream, (Rect) null, options);
    }

    public static Bitmap getBitmap(byte[] bArr, int i) {
        if (bArr.length == 0) {
            return null;
        }
        return BitmapFactoryInstrumentation.decodeByteArray(bArr, i, bArr.length);
    }

    public static Bitmap getBitmap(byte[] bArr, int i, int i2, int i3) {
        if (bArr.length == 0) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactoryInstrumentation.decodeByteArray(bArr, i, bArr.length, options);
        options.inSampleSize = calculateInSampleSize(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactoryInstrumentation.decodeByteArray(bArr, i, bArr.length, options);
    }

    public static Bitmap getBitmap(int i) {
        Drawable drawable = ContextCompat.getDrawable(Utils.getApp(), i);
        Canvas canvas = new Canvas();
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static Bitmap getBitmap(int i, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        Resources resources = Utils.getApp().getResources();
        options.inJustDecodeBounds = true;
        BitmapFactoryInstrumentation.decodeResource(resources, i, options);
        options.inSampleSize = calculateInSampleSize(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactoryInstrumentation.decodeResource(resources, i, options);
    }

    public static Bitmap getBitmap(FileDescriptor fileDescriptor) {
        if (fileDescriptor == null) {
            return null;
        }
        return BitmapFactoryInstrumentation.decodeFileDescriptor(fileDescriptor);
    }

    public static Bitmap getBitmap(FileDescriptor fileDescriptor, int i, int i2) {
        if (fileDescriptor == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactoryInstrumentation.decodeFileDescriptor(fileDescriptor, (Rect) null, options);
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactoryInstrumentation.decodeFileDescriptor(fileDescriptor, (Rect) null, options);
    }

    public static Bitmap drawColor(Bitmap bitmap, int i) {
        return drawColor(bitmap, i, false);
    }

    public static Bitmap drawColor(Bitmap bitmap, int i, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        if (!z) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        new Canvas(bitmap).drawColor(i, PorterDuff.Mode.DARKEN);
        return bitmap;
    }

    public static Bitmap scale(Bitmap bitmap, int i, int i2) {
        return scale(bitmap, i, i2, false);
    }

    public static Bitmap scale(Bitmap bitmap, int i, int i2, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
        if (z && !bitmap.isRecycled() && createScaledBitmap != bitmap) {
            bitmap.recycle();
        }
        return createScaledBitmap;
    }

    public static Bitmap scale(Bitmap bitmap, float f, float f2) {
        return scale(bitmap, f, f2, false);
    }

    public static Bitmap scale(Bitmap bitmap, float f, float f2, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap clip(Bitmap bitmap, int i, int i2, int i3, int i4) {
        return clip(bitmap, i, i2, i3, i4, false);
    }

    public static Bitmap clip(Bitmap bitmap, int i, int i2, int i3, int i4, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, i, i2, i3, i4);
        if (z && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap skew(Bitmap bitmap, float f, float f2) {
        return skew(bitmap, f, f2, 0.0f, 0.0f, false);
    }

    public static Bitmap skew(Bitmap bitmap, float f, float f2, boolean z) {
        return skew(bitmap, f, f2, 0.0f, 0.0f, z);
    }

    public static Bitmap skew(Bitmap bitmap, float f, float f2, float f3, float f4) {
        return skew(bitmap, f, f2, f3, f4, false);
    }

    public static Bitmap skew(Bitmap bitmap, float f, float f2, float f3, float f4, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setSkew(f, f2, f3, f4);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap rotate(Bitmap bitmap, int i, float f, float f2) {
        return rotate(bitmap, i, f, f2, false);
    }

    public static Bitmap rotate(Bitmap bitmap, int i, float f, float f2, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        if (i == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i, f, f2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static int getRotateDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static Bitmap toRound(Bitmap bitmap) {
        return toRound(bitmap, 0, 0, false);
    }

    public static Bitmap toRound(Bitmap bitmap, boolean z) {
        return toRound(bitmap, 0, 0, z);
    }

    public static Bitmap toRound(Bitmap bitmap, int i, int i2) {
        return toRound(bitmap, i, i2, false);
    }

    public static Bitmap toRound(Bitmap bitmap, int i, int i2, boolean z) {
        Bitmap bitmap2 = bitmap;
        int i3 = i;
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int min = Math.min(width, height);
        Paint paint = new Paint(1);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig());
        float f = (float) min;
        float f2 = f / 2.0f;
        float f3 = (float) width;
        float f4 = (float) height;
        RectF rectF = new RectF(0.0f, 0.0f, f3, f4);
        rectF.inset(((float) (width - min)) / 2.0f, ((float) (height - min)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.setTranslate(rectF.left, rectF.top);
        if (width != height) {
            matrix.preScale(f / f3, f / f4);
        }
        BitmapShader bitmapShader = new BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (i3 > 0) {
            paint.setShader((Shader) null);
            paint.setColor(i2);
            paint.setStyle(Paint.Style.STROKE);
            float f5 = (float) i3;
            paint.setStrokeWidth(f5);
            canvas.drawCircle(f3 / 2.0f, f4 / 2.0f, f2 - (f5 / 2.0f), paint);
        }
        if (z && !bitmap.isRecycled() && createBitmap != bitmap2) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float f) {
        return toRoundCorner(bitmap, f, 0, 0, false);
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float f, boolean z) {
        return toRoundCorner(bitmap, f, 0, 0, z);
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float f, int i, int i2) {
        return toRoundCorner(bitmap, f, i, i2, false);
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float f, int i, int i2, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Paint paint = new Paint(1);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig());
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF(0.0f, 0.0f, (float) width, (float) height);
        float f2 = (float) i;
        float f3 = f2 / 2.0f;
        rectF.inset(f3, f3);
        canvas.drawRoundRect(rectF, f, f, paint);
        if (i > 0) {
            paint.setShader((Shader) null);
            paint.setColor(i2);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(f2);
            paint.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawRoundRect(rectF, f, f, paint);
        }
        if (z && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap addCornerBorder(Bitmap bitmap, int i, int i2, float f) {
        return addBorder(bitmap, i, i2, false, f, false);
    }

    public static Bitmap addCornerBorder(Bitmap bitmap, int i, int i2, float f, boolean z) {
        return addBorder(bitmap, i, i2, false, f, z);
    }

    public static Bitmap addCircleBorder(Bitmap bitmap, int i, int i2) {
        return addBorder(bitmap, i, i2, true, 0.0f, false);
    }

    public static Bitmap addCircleBorder(Bitmap bitmap, int i, int i2, boolean z) {
        return addBorder(bitmap, i, i2, true, 0.0f, z);
    }

    private static Bitmap addBorder(Bitmap bitmap, int i, int i2, boolean z, float f, boolean z2) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        if (!z2) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(1);
        paint.setColor(i2);
        paint.setStyle(Paint.Style.STROKE);
        float f2 = (float) i;
        paint.setStrokeWidth(f2);
        if (z) {
            canvas.drawCircle(((float) width) / 2.0f, ((float) height) / 2.0f, (((float) Math.min(width, height)) / 2.0f) - (f2 / 2.0f), paint);
        } else {
            int i3 = i >> 1;
            float f3 = (float) i3;
            canvas.drawRoundRect(new RectF(f3, f3, (float) (width - i3), (float) (height - i3)), f, f, paint);
        }
        return bitmap;
    }

    public static Bitmap addReflection(Bitmap bitmap, int i) {
        return addReflection(bitmap, i, false);
    }

    public static Bitmap addReflection(Bitmap bitmap, int i, boolean z) {
        Bitmap bitmap2 = bitmap;
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f, -1.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, height - i, width, i, matrix, false);
        Bitmap createBitmap2 = Bitmap.createBitmap(width, height + i, bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap2);
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        float f = (float) (height + 0);
        canvas.drawBitmap(createBitmap, 0.0f, f, (Paint) null);
        Paint paint = new Paint(1);
        paint.setShader(new LinearGradient(0.0f, (float) height, 0.0f, (float) (createBitmap2.getHeight() + 0), 1895825407, 16777215, Shader.TileMode.MIRROR));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawRect(0.0f, f, (float) width, (float) createBitmap2.getHeight(), paint);
        if (!createBitmap.isRecycled()) {
            createBitmap.recycle();
        }
        if (z && !bitmap.isRecycled() && createBitmap2 != bitmap2) {
            bitmap.recycle();
        }
        return createBitmap2;
    }

    public static Bitmap addTextWatermark(Bitmap bitmap, String str, int i, int i2, float f, float f2) {
        return addTextWatermark(bitmap, str, (float) i, i2, f, f2, false);
    }

    public static Bitmap addTextWatermark(Bitmap bitmap, String str, float f, int i, float f2, float f3, boolean z) {
        if (isEmptyBitmap(bitmap) || str == null) {
            return null;
        }
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        Paint paint = new Paint(1);
        Canvas canvas = new Canvas(copy);
        paint.setColor(i);
        paint.setTextSize(f);
        paint.getTextBounds(str, 0, str.length(), new Rect());
        canvas.drawText(str, f2, f3 + f, paint);
        if (z && !bitmap.isRecycled() && copy != bitmap) {
            bitmap.recycle();
        }
        return copy;
    }

    public static Bitmap addImageWatermark(Bitmap bitmap, Bitmap bitmap2, int i, int i2, int i3) {
        return addImageWatermark(bitmap, bitmap2, i, i2, i3, false);
    }

    public static Bitmap addImageWatermark(Bitmap bitmap, Bitmap bitmap2, int i, int i2, int i3, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        if (!isEmptyBitmap(bitmap2)) {
            Paint paint = new Paint(1);
            Canvas canvas = new Canvas(copy);
            paint.setAlpha(i3);
            canvas.drawBitmap(bitmap2, (float) i, (float) i2, paint);
        }
        if (z && !bitmap.isRecycled() && copy != bitmap) {
            bitmap.recycle();
        }
        return copy;
    }

    public static Bitmap toAlpha(Bitmap bitmap) {
        return toAlpha(bitmap, false);
    }

    public static Bitmap toAlpha(Bitmap bitmap, Boolean bool) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap extractAlpha = bitmap.extractAlpha();
        if (bool.booleanValue() && !bitmap.isRecycled() && extractAlpha != bitmap) {
            bitmap.recycle();
        }
        return extractAlpha;
    }

    public static Bitmap toGray(Bitmap bitmap) {
        return toGray(bitmap, false);
    }

    public static Bitmap toGray(Bitmap bitmap, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        if (z && !bitmap.isRecycled() && createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap fastBlur(Bitmap bitmap, float f, float f2) {
        return fastBlur(bitmap, f, f2, false, false);
    }

    public static Bitmap fastBlur(Bitmap bitmap, float f, float f2, boolean z) {
        return fastBlur(bitmap, f, f2, z, false);
    }

    public static Bitmap fastBlur(Bitmap bitmap, float f, float f2, boolean z, boolean z2) {
        Bitmap bitmap2;
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(f, f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        Paint paint = new Paint(3);
        Canvas canvas = new Canvas();
        paint.setColorFilter(new PorterDuffColorFilter(0, PorterDuff.Mode.SRC_ATOP));
        canvas.scale(f, f);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint);
        if (Build.VERSION.SDK_INT >= 17) {
            bitmap2 = renderScriptBlur(createBitmap, f2, z);
        } else {
            bitmap2 = stackBlur(createBitmap, (int) f2, z);
        }
        if (f == 1.0f || z2) {
            if (z && !bitmap.isRecycled() && bitmap2 != bitmap) {
                bitmap.recycle();
            }
            return bitmap2;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, width, height, true);
        if (!bitmap2.isRecycled()) {
            bitmap2.recycle();
        }
        if (z && !bitmap.isRecycled() && createScaledBitmap != bitmap) {
            bitmap.recycle();
        }
        return createScaledBitmap;
    }

    public static Bitmap renderScriptBlur(Bitmap bitmap, float f) {
        return renderScriptBlur(bitmap, f, false);
    }

    public static Bitmap renderScriptBlur(Bitmap bitmap, float f, boolean z) {
        if (!z) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        RenderScript renderScript = null;
        try {
            renderScript = RenderScript.create(Utils.getApp());
            renderScript.setMessageHandler(new RenderScript.RSMessageHandler());
            Allocation createFromBitmap = Allocation.createFromBitmap(renderScript, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            Allocation createTyped = Allocation.createTyped(renderScript, createFromBitmap.getType());
            ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
            create.setInput(createFromBitmap);
            create.setRadius(f);
            create.forEach(createTyped);
            createTyped.copyTo(bitmap);
            return bitmap;
        } finally {
            if (renderScript != null) {
                renderScript.destroy();
            }
        }
    }

    public static Bitmap stackBlur(Bitmap bitmap, int i) {
        return stackBlur(bitmap, i, false);
    }

    public static Bitmap stackBlur(Bitmap bitmap, int i, boolean z) {
        int[] iArr;
        Bitmap copy = z ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        int i2 = i;
        int i3 = i2 < 1 ? 1 : i2;
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i4 = width * height;
        int[] iArr2 = new int[i4];
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i5 = width - 1;
        int i6 = height - 1;
        int i7 = i3 + i3 + 1;
        int[] iArr3 = new int[i4];
        int[] iArr4 = new int[i4];
        int[] iArr5 = new int[i4];
        int[] iArr6 = new int[Math.max(width, height)];
        int i8 = (i7 + 1) >> 1;
        int i9 = i8 * i8;
        int i10 = i9 * 256;
        int[] iArr7 = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            iArr7[i11] = i11 / i9;
        }
        int[] iArr8 = new int[2];
        iArr8[1] = 3;
        iArr8[0] = i7;
        int[][] iArr9 = (int[][]) Array.newInstance(int.class, iArr8);
        int i12 = i3 + 1;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < height) {
            Bitmap bitmap2 = copy;
            int i16 = height;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = -i3;
            int i26 = 0;
            while (i25 <= i3) {
                int i27 = i6;
                int[] iArr10 = iArr6;
                int i28 = iArr2[i14 + Math.min(i5, Math.max(i25, 0))];
                int[] iArr11 = iArr9[i25 + i3];
                iArr11[0] = (i28 & 16711680) >> 16;
                iArr11[1] = (i28 & 65280) >> 8;
                iArr11[2] = i28 & 255;
                int abs = i12 - Math.abs(i25);
                i26 += iArr11[0] * abs;
                i17 += iArr11[1] * abs;
                i18 += iArr11[2] * abs;
                if (i25 > 0) {
                    i22 += iArr11[0];
                    i23 += iArr11[1];
                    i24 += iArr11[2];
                } else {
                    i19 += iArr11[0];
                    i20 += iArr11[1];
                    i21 += iArr11[2];
                }
                i25++;
                i6 = i27;
                iArr6 = iArr10;
            }
            int i29 = i6;
            int[] iArr12 = iArr6;
            int i30 = i26;
            int i31 = i3;
            int i32 = 0;
            while (i32 < width) {
                iArr3[i14] = iArr7[i30];
                iArr4[i14] = iArr7[i17];
                iArr5[i14] = iArr7[i18];
                int i33 = i30 - i19;
                int i34 = i17 - i20;
                int i35 = i18 - i21;
                int[] iArr13 = iArr9[((i31 - i3) + i7) % i7];
                int i36 = i19 - iArr13[0];
                int i37 = i20 - iArr13[1];
                int i38 = i21 - iArr13[2];
                if (i13 == 0) {
                    iArr = iArr7;
                    iArr12[i32] = Math.min(i32 + i3 + 1, i5);
                } else {
                    iArr = iArr7;
                }
                int i39 = iArr2[i15 + iArr12[i32]];
                iArr13[0] = (i39 & 16711680) >> 16;
                iArr13[1] = (i39 & 65280) >> 8;
                iArr13[2] = i39 & 255;
                int i40 = i22 + iArr13[0];
                int i41 = i23 + iArr13[1];
                int i42 = i24 + iArr13[2];
                i30 = i33 + i40;
                i17 = i34 + i41;
                i18 = i35 + i42;
                i31 = (i31 + 1) % i7;
                int[] iArr14 = iArr9[i31 % i7];
                i19 = i36 + iArr14[0];
                i20 = i37 + iArr14[1];
                i21 = i38 + iArr14[2];
                i22 = i40 - iArr14[0];
                i23 = i41 - iArr14[1];
                i24 = i42 - iArr14[2];
                i14++;
                i32++;
                iArr7 = iArr;
            }
            int[] iArr15 = iArr7;
            i15 += width;
            i13++;
            copy = bitmap2;
            height = i16;
            i6 = i29;
            iArr6 = iArr12;
        }
        Bitmap bitmap3 = copy;
        int i43 = i6;
        int[] iArr16 = iArr6;
        int i44 = height;
        int[] iArr17 = iArr7;
        int i45 = 0;
        while (i45 < width) {
            int i46 = -i3;
            int i47 = i7;
            int[] iArr18 = iArr2;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = i46;
            int i56 = i46 * width;
            int i57 = 0;
            int i58 = 0;
            while (i55 <= i3) {
                int i59 = width;
                int max = Math.max(0, i56) + i45;
                int[] iArr19 = iArr9[i55 + i3];
                iArr19[0] = iArr3[max];
                iArr19[1] = iArr4[max];
                iArr19[2] = iArr5[max];
                int abs2 = i12 - Math.abs(i55);
                i57 += iArr3[max] * abs2;
                i58 += iArr4[max] * abs2;
                i48 += iArr5[max] * abs2;
                if (i55 > 0) {
                    i52 += iArr19[0];
                    i53 += iArr19[1];
                    i54 += iArr19[2];
                } else {
                    i49 += iArr19[0];
                    i50 += iArr19[1];
                    i51 += iArr19[2];
                }
                int i60 = i43;
                if (i55 < i60) {
                    i56 += i59;
                }
                i55++;
                i43 = i60;
                width = i59;
            }
            int i61 = width;
            int i62 = i43;
            int i63 = i45;
            int i64 = i58;
            int i65 = i3;
            int i66 = i44;
            int i67 = i57;
            int i68 = 0;
            while (i68 < i66) {
                iArr18[i63] = (iArr18[i63] & -16777216) | (iArr17[i67] << 16) | (iArr17[i64] << 8) | iArr17[i48];
                int i69 = i67 - i49;
                int i70 = i64 - i50;
                int i71 = i48 - i51;
                int[] iArr20 = iArr9[((i65 - i3) + i47) % i47];
                int i72 = i49 - iArr20[0];
                int i73 = i50 - iArr20[1];
                int i74 = i51 - iArr20[2];
                int i75 = i3;
                if (i45 == 0) {
                    iArr16[i68] = Math.min(i68 + i12, i62) * i61;
                }
                int i76 = iArr16[i68] + i45;
                iArr20[0] = iArr3[i76];
                iArr20[1] = iArr4[i76];
                iArr20[2] = iArr5[i76];
                int i77 = i52 + iArr20[0];
                int i78 = i53 + iArr20[1];
                int i79 = i54 + iArr20[2];
                i67 = i69 + i77;
                i64 = i70 + i78;
                i48 = i71 + i79;
                i65 = (i65 + 1) % i47;
                int[] iArr21 = iArr9[i65];
                i49 = i72 + iArr21[0];
                i50 = i73 + iArr21[1];
                i51 = i74 + iArr21[2];
                i52 = i77 - iArr21[0];
                i53 = i78 - iArr21[1];
                i54 = i79 - iArr21[2];
                i63 += i61;
                i68++;
                i3 = i75;
            }
            int i80 = i3;
            i45++;
            i43 = i62;
            i44 = i66;
            i7 = i47;
            iArr2 = iArr18;
            width = i61;
        }
        int i81 = width;
        bitmap3.setPixels(iArr2, 0, i81, 0, 0, i81, i44);
        return bitmap3;
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        return save(bitmap, str, compressFormat, 100, false);
    }

    public static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat) {
        return save(bitmap, file, compressFormat, 100, false);
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, boolean z) {
        return save(bitmap, str, compressFormat, 100, z);
    }

    public static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, boolean z) {
        return save(bitmap, file, compressFormat, 100, z);
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i) {
        return save(bitmap, UtilsBridge.getFileByPath(str), compressFormat, i, false);
    }

    public static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i) {
        return save(bitmap, file, compressFormat, i, false);
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i, boolean z) {
        return save(bitmap, UtilsBridge.getFileByPath(str), compressFormat, i, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006c A[SYNTHETIC, Splitter:B:34:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0072 A[SYNTHETIC, Splitter:B:38:0x0072] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean save(android.graphics.Bitmap r4, java.io.File r5, android.graphics.Bitmap.CompressFormat r6, int r7, boolean r8) {
        /*
            boolean r0 = isEmptyBitmap(r4)
            java.lang.String r1 = "ImageUtils"
            r2 = 0
            if (r0 == 0) goto L_0x000f
            java.lang.String r4 = "bitmap is empty."
            android.util.Log.e(r1, r4)
            return r2
        L_0x000f:
            boolean r0 = r4.isRecycled()
            if (r0 == 0) goto L_0x001b
            java.lang.String r4 = "bitmap is recycled."
            android.util.Log.e(r1, r4)
            return r2
        L_0x001b:
            boolean r0 = com.tal.app.thinkacademy.lib.util.UtilsBridge.createFileByDeleteOldFile(r5)
            if (r0 != 0) goto L_0x003b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "create or delete file <"
            r4.append(r6)
            r4.append(r5)
            java.lang.String r5 = "> failed."
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.util.Log.e(r1, r4)
            return r2
        L_0x003b:
            r0 = 0
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0066 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0066 }
            r3.<init>(r5)     // Catch:{ IOException -> 0x0066 }
            r1.<init>(r3)     // Catch:{ IOException -> 0x0066 }
            boolean r2 = r4.compress(r6, r7, r1)     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            if (r8 == 0) goto L_0x0055
            boolean r5 = r4.isRecycled()     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            if (r5 != 0) goto L_0x0055
            r4.recycle()     // Catch:{ IOException -> 0x0061, all -> 0x005e }
        L_0x0055:
            r1.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x006f
        L_0x0059:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x006f
        L_0x005e:
            r4 = move-exception
            r0 = r1
            goto L_0x0070
        L_0x0061:
            r4 = move-exception
            r0 = r1
            goto L_0x0067
        L_0x0064:
            r4 = move-exception
            goto L_0x0070
        L_0x0066:
            r4 = move-exception
        L_0x0067:
            r4.printStackTrace()     // Catch:{ all -> 0x0064 }
            if (r0 == 0) goto L_0x006f
            r0.close()     // Catch:{ IOException -> 0x0059 }
        L_0x006f:
            return r2
        L_0x0070:
            if (r0 == 0) goto L_0x007a
            r0.close()     // Catch:{ IOException -> 0x0076 }
            goto L_0x007a
        L_0x0076:
            r5 = move-exception
            r5.printStackTrace()
        L_0x007a:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.util.ImageUtils.save(android.graphics.Bitmap, java.io.File, android.graphics.Bitmap$CompressFormat, int, boolean):boolean");
    }

    @Deprecated
    public static File save2Album(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        return save2Album(bitmap, compressFormat, 100, false);
    }

    @Deprecated
    public static File save2Album(Bitmap bitmap, Bitmap.CompressFormat compressFormat, boolean z) {
        return save2Album(bitmap, compressFormat, 100, z);
    }

    @Deprecated
    public static File save2Album(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) {
        return save2Album(bitmap, compressFormat, i, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f7 A[SYNTHETIC, Splitter:B:39:0x00f7] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0104 A[SYNTHETIC, Splitter:B:47:0x0104] */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File save2Album(android.graphics.Bitmap r7, android.graphics.Bitmap.CompressFormat r8, int r9, boolean r10) {
        /*
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = "JPG"
            goto L_0x000f
        L_0x000b:
            java.lang.String r0 = r8.name()
        L_0x000f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            long r2 = java.lang.System.currentTimeMillis()
            r1.append(r2)
            java.lang.String r2 = "_"
            r1.append(r2)
            r1.append(r9)
            java.lang.String r2 = "."
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            java.lang.String r3 = "/"
            r4 = 0
            if (r1 >= r2) goto L_0x007c
            java.lang.String r1 = "android.permission.WRITE_EXTERNAL_STORAGE"
            java.lang.String[] r1 = new java.lang.String[]{r1}
            boolean r1 = com.tal.app.thinkacademy.lib.util.UtilsBridge.isGranted(r1)
            if (r1 != 0) goto L_0x004c
            java.lang.String r7 = "ImageUtils"
            java.lang.String r8 = "save to album need storage permission"
            android.util.Log.e(r7, r8)
            return r4
        L_0x004c:
            java.lang.String r1 = android.os.Environment.DIRECTORY_DCIM
            java.io.File r1 = android.os.Environment.getExternalStoragePublicDirectory(r1)
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            android.app.Application r6 = com.tal.app.thinkacademy.lib.util.Utils.getApp()
            java.lang.String r6 = r6.getPackageName()
            r5.append(r6)
            r5.append(r3)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r2.<init>(r1, r0)
            boolean r7 = save((android.graphics.Bitmap) r7, (java.io.File) r2, (android.graphics.Bitmap.CompressFormat) r8, (int) r9, (boolean) r10)
            if (r7 != 0) goto L_0x0078
            return r4
        L_0x0078:
            com.tal.app.thinkacademy.lib.util.UtilsBridge.notifySystemToScan(r2)
            return r2
        L_0x007c:
            android.content.ContentValues r10 = new android.content.ContentValues
            r10.<init>()
            java.lang.String r1 = "_display_name"
            r10.put(r1, r0)
            java.lang.String r0 = "mime_type"
            java.lang.String r1 = "image/*"
            r10.put(r0, r1)
            java.lang.String r0 = android.os.Environment.getExternalStorageState()
            java.lang.String r1 = "mounted"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x009c
            android.net.Uri r0 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            goto L_0x009e
        L_0x009c:
            android.net.Uri r0 = android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI
        L_0x009e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = android.os.Environment.DIRECTORY_DCIM
            r1.append(r2)
            r1.append(r3)
            android.app.Application r2 = com.tal.app.thinkacademy.lib.util.Utils.getApp()
            java.lang.String r2 = r2.getPackageName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "relative_path"
            r10.put(r2, r1)
            android.app.Application r1 = com.tal.app.thinkacademy.lib.util.Utils.getApp()
            android.content.ContentResolver r1 = r1.getContentResolver()
            android.net.Uri r10 = r1.insert(r0, r10)
            if (r10 != 0) goto L_0x00ce
            return r4
        L_0x00ce:
            android.app.Application r0 = com.tal.app.thinkacademy.lib.util.Utils.getApp()     // Catch:{ Exception -> 0x00f0, all -> 0x00ee }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x00f0, all -> 0x00ee }
            java.io.OutputStream r0 = r0.openOutputStream(r10)     // Catch:{ Exception -> 0x00f0, all -> 0x00ee }
            r7.compress(r8, r9, r0)     // Catch:{ Exception -> 0x00ec }
            java.io.File r7 = com.tal.app.thinkacademy.lib.util.UtilsBridge.uri2File(r10)     // Catch:{ Exception -> 0x00ec }
            if (r0 == 0) goto L_0x00eb
            r0.close()     // Catch:{ IOException -> 0x00e7 }
            goto L_0x00eb
        L_0x00e7:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00eb:
            return r7
        L_0x00ec:
            r7 = move-exception
            goto L_0x00f2
        L_0x00ee:
            r7 = move-exception
            goto L_0x0102
        L_0x00f0:
            r7 = move-exception
            r0 = r4
        L_0x00f2:
            r7.printStackTrace()     // Catch:{ all -> 0x0100 }
            if (r0 == 0) goto L_0x00ff
            r0.close()     // Catch:{ IOException -> 0x00fb }
            goto L_0x00ff
        L_0x00fb:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00ff:
            return r4
        L_0x0100:
            r7 = move-exception
            r4 = r0
        L_0x0102:
            if (r4 == 0) goto L_0x010c
            r4.close()     // Catch:{ IOException -> 0x0108 }
            goto L_0x010c
        L_0x0108:
            r8 = move-exception
            r8.printStackTrace()
        L_0x010c:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.util.ImageUtils.save2Album(android.graphics.Bitmap, android.graphics.Bitmap$CompressFormat, int, boolean):java.io.File");
    }

    public static boolean isImage(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return isImage(file.getPath());
    }

    public static boolean isImage(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactoryInstrumentation.decodeFile(str, options);
            if (options.outWidth <= 0 || options.outHeight <= 0) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static ImageType getImageType(String str) {
        return getImageType(UtilsBridge.getFileByPath(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0027 A[SYNTHETIC, Splitter:B:22:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0034 A[SYNTHETIC, Splitter:B:30:0x0034] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.lib.util.ImageUtils.ImageType getImageType(java.io.File r2) {
        /*
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0020, all -> 0x001e }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0020, all -> 0x001e }
            com.tal.app.thinkacademy.lib.util.ImageUtils$ImageType r2 = getImageType((java.io.InputStream) r1)     // Catch:{ IOException -> 0x001c }
            if (r2 == 0) goto L_0x0018
            r1.close()     // Catch:{ IOException -> 0x0013 }
            goto L_0x0017
        L_0x0013:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0017:
            return r2
        L_0x0018:
            r1.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x002f
        L_0x001c:
            r2 = move-exception
            goto L_0x0022
        L_0x001e:
            r2 = move-exception
            goto L_0x0032
        L_0x0020:
            r2 = move-exception
            r1 = r0
        L_0x0022:
            r2.printStackTrace()     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002f
            r1.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r2 = move-exception
            r2.printStackTrace()
        L_0x002f:
            return r0
        L_0x0030:
            r2 = move-exception
            r0 = r1
        L_0x0032:
            if (r0 == 0) goto L_0x003c
            r0.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r0 = move-exception
            r0.printStackTrace()
        L_0x003c:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.util.ImageUtils.getImageType(java.io.File):com.tal.app.thinkacademy.lib.util.ImageUtils$ImageType");
    }

    private static ImageType getImageType(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[12];
            if (inputStream.read(bArr) != -1) {
                return getImageType(bArr);
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static ImageType getImageType(byte[] bArr) {
        String upperCase = UtilsBridge.bytes2HexString(bArr).toUpperCase();
        if (upperCase.contains("FFD8FF")) {
            return ImageType.TYPE_JPG;
        }
        if (upperCase.contains("89504E47")) {
            return ImageType.TYPE_PNG;
        }
        if (upperCase.contains("47494638")) {
            return ImageType.TYPE_GIF;
        }
        if (upperCase.contains("49492A00") || upperCase.contains("4D4D002A")) {
            return ImageType.TYPE_TIFF;
        }
        if (upperCase.contains("424D")) {
            return ImageType.TYPE_BMP;
        }
        if (upperCase.startsWith("52494646") && upperCase.endsWith("57454250")) {
            return ImageType.TYPE_WEBP;
        }
        if (upperCase.contains("00000100") || upperCase.contains("00000200")) {
            return ImageType.TYPE_ICO;
        }
        return ImageType.TYPE_UNKNOWN;
    }

    private static boolean isJPEG(byte[] bArr) {
        return bArr.length >= 2 && bArr[0] == -1 && bArr[1] == -40;
    }

    private static boolean isGIF(byte[] bArr) {
        return bArr.length >= 6 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 56 && (bArr[4] == 55 || bArr[4] == 57) && bArr[5] == 97;
    }

    private static boolean isPNG(byte[] bArr) {
        return bArr.length >= 8 && bArr[0] == -119 && bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71 && bArr[4] == 13 && bArr[5] == 10 && bArr[6] == 26 && bArr[7] == 10;
    }

    private static boolean isBMP(byte[] bArr) {
        return bArr.length >= 2 && bArr[0] == 66 && bArr[1] == 77;
    }

    private static boolean isEmptyBitmap(Bitmap bitmap) {
        return bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0;
    }

    public static Bitmap compressByScale(Bitmap bitmap, int i, int i2) {
        return scale(bitmap, i, i2, false);
    }

    public static Bitmap compressByScale(Bitmap bitmap, int i, int i2, boolean z) {
        return scale(bitmap, i, i2, z);
    }

    public static Bitmap compressByScale(Bitmap bitmap, float f, float f2) {
        return scale(bitmap, f, f2, false);
    }

    public static Bitmap compressByScale(Bitmap bitmap, float f, float f2, boolean z) {
        return scale(bitmap, f, f2, z);
    }

    public static byte[] compressByQuality(Bitmap bitmap, int i) {
        return compressByQuality(bitmap, i, false);
    }

    public static byte[] compressByQuality(Bitmap bitmap, int i, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return byteArray;
    }

    public static byte[] compressByQuality(Bitmap bitmap, long j) {
        return compressByQuality(bitmap, j, false);
    }

    public static byte[] compressByQuality(Bitmap bitmap, long j, boolean z) {
        byte[] bArr;
        int i = 0;
        if (isEmptyBitmap(bitmap) || j <= 0) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        if (((long) byteArrayOutputStream.size()) <= j) {
            bArr = byteArrayOutputStream.toByteArray();
        } else {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 0, byteArrayOutputStream);
            if (((long) byteArrayOutputStream.size()) >= j) {
                bArr = byteArrayOutputStream.toByteArray();
            } else {
                int i3 = 0;
                while (i < i2) {
                    i3 = (i + i2) / 2;
                    byteArrayOutputStream.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i3, byteArrayOutputStream);
                    int i4 = (((long) byteArrayOutputStream.size()) > j ? 1 : (((long) byteArrayOutputStream.size()) == j ? 0 : -1));
                    if (i4 == 0) {
                        break;
                    } else if (i4 > 0) {
                        i2 = i3 - 1;
                    } else {
                        i = i3 + 1;
                    }
                }
                if (i2 == i3 - 1) {
                    byteArrayOutputStream.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                }
                bArr = byteArrayOutputStream.toByteArray();
            }
        }
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bArr;
    }

    public static Bitmap compressBySampleSize(Bitmap bitmap, int i) {
        return compressBySampleSize(bitmap, i, false);
    }

    public static Bitmap compressBySampleSize(Bitmap bitmap, int i, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactoryInstrumentation.decodeByteArray(byteArray, 0, byteArray.length, options);
    }

    public static Bitmap compressBySampleSize(Bitmap bitmap, int i, int i2) {
        return compressBySampleSize(bitmap, i, i2, false);
    }

    public static Bitmap compressBySampleSize(Bitmap bitmap, int i, int i2, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactoryInstrumentation.decodeByteArray(byteArray, 0, byteArray.length, options);
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactoryInstrumentation.decodeByteArray(byteArray, 0, byteArray.length, options);
    }

    public static int[] getSize(String str) {
        return getSize(UtilsBridge.getFileByPath(str));
    }

    public static int[] getSize(File file) {
        if (file == null) {
            return new int[]{0, 0};
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactoryInstrumentation.decodeFile(file.getAbsolutePath(), options);
        return new int[]{options.outWidth, options.outHeight};
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        while (true) {
            if (i3 <= i2 && i4 <= i) {
                return i5;
            }
            i3 >>= 1;
            i4 >>= 1;
            i5 <<= 1;
        }
    }

    public enum ImageType {
        TYPE_JPG("jpg"),
        TYPE_PNG("png"),
        TYPE_GIF("gif"),
        TYPE_TIFF("tiff"),
        TYPE_BMP("bmp"),
        TYPE_WEBP("webp"),
        TYPE_ICO("ico"),
        TYPE_UNKNOWN(CustomLocationManagerKt.KUnKnown);
        
        String value;

        private ImageType(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }
}
