package com.luck.picture.lib.compress;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.tools.BitmapUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class Engine {
    private static final int DEFAULT_QUALITY = 80;
    private int compressQuality;
    private final Context context;
    @Deprecated
    private final boolean focusAlpha;
    private final boolean isAutoRotating;
    private int srcHeight;
    private final InputStreamProvider srcImg;
    private int srcWidth;
    private final File tagImg;

    Engine(Context context2, InputStreamProvider inputStreamProvider, File file, boolean z, int i, boolean z2) throws IOException {
        this.tagImg = file;
        this.srcImg = inputStreamProvider;
        this.context = context2;
        this.focusAlpha = z;
        this.isAutoRotating = z2;
        this.compressQuality = i <= 0 ? 80 : i;
        if (inputStreamProvider.getMedia().getWidth() <= 0 || inputStreamProvider.getMedia().getHeight() <= 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = 1;
            BitmapFactoryInstrumentation.decodeStream(inputStreamProvider.open(), (Rect) null, options);
            this.srcWidth = options.outWidth;
            this.srcHeight = options.outHeight;
            return;
        }
        this.srcWidth = inputStreamProvider.getMedia().getWidth();
        this.srcHeight = inputStreamProvider.getMedia().getHeight();
    }

    private int computeSize() {
        int i = this.srcWidth;
        if (i % 2 == 1) {
            i++;
        }
        this.srcWidth = i;
        int i2 = this.srcHeight;
        if (i2 % 2 == 1) {
            i2++;
        }
        this.srcHeight = i2;
        int max = Math.max(i, i2);
        float min = ((float) Math.min(this.srcWidth, this.srcHeight)) / ((float) max);
        if (min > 1.0f || ((double) min) <= 0.5625d) {
            double d = (double) min;
            if (d > 0.5625d || d <= 0.5d) {
                return (int) Math.ceil(((double) max) / (1280.0d / d));
            }
            int i3 = max / 1280;
            if (i3 == 0) {
                return 1;
            }
            return i3;
        } else if (max < 1664) {
            return 1;
        } else {
            if (max < 4990) {
                return 2;
            }
            if (max <= 4990 || max >= 10240) {
                return max / 1280;
            }
            return 4;
        }
    }

    /* access modifiers changed from: package-private */
    public File compress() throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = computeSize();
        Bitmap decodeStream = BitmapFactoryInstrumentation.decodeStream(this.srcImg.open(), (Rect) null, options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (this.isAutoRotating && Checker.SINGLE.isJPG(this.srcImg.getMedia().getMimeType())) {
            String cutPath = this.srcImg.getMedia().isCut() && !TextUtils.isEmpty(this.srcImg.getMedia().getCutPath()) ? this.srcImg.getMedia().getCutPath() : this.srcImg.getMedia().getPath();
            int readPictureDegree = PictureMimeType.isContent(cutPath) ? BitmapUtils.readPictureDegree(this.srcImg.open()) : BitmapUtils.readPictureDegree(this.context, cutPath);
            if (readPictureDegree > 0) {
                decodeStream = BitmapUtils.rotatingImage(decodeStream, readPictureDegree);
            }
        }
        if (decodeStream == null) {
            return null;
        }
        int i = this.compressQuality;
        if (i <= 0 || i > 100) {
            i = 80;
        }
        this.compressQuality = i;
        decodeStream.compress((this.focusAlpha || decodeStream.hasAlpha()) ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, this.compressQuality, byteArrayOutputStream);
        decodeStream.recycle();
        FileOutputStream fileOutputStream = new FileOutputStream(this.tagImg);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.flush();
        fileOutputStream.close();
        byteArrayOutputStream.close();
        return this.tagImg;
    }
}
