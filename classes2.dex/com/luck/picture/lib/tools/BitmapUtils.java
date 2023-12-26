package com.luck.picture.lib.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.luck.picture.lib.PictureContentResolver;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class BitmapUtils {
    public static void rotateImage(Context context, boolean z, String str) {
        if (z) {
            try {
                int readPictureDegree = readPictureDegree(context, str);
                if (readPictureDegree > 0) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inSampleSize = 2;
                    File file = new File(str);
                    Bitmap rotatingImage = rotatingImage(BitmapFactoryInstrumentation.decodeFile(file.getAbsolutePath(), options), readPictureDegree);
                    if (rotatingImage != null) {
                        saveBitmapFile(rotatingImage, file);
                        rotatingImage.recycle();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Bitmap rotatingImage(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private static void saveBitmapFile(Bitmap bitmap, File file) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream2);
                bufferedOutputStream2.flush();
                PictureFileUtils.close(bufferedOutputStream2);
            } catch (Exception e) {
                e = e;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    e.printStackTrace();
                    PictureFileUtils.close(bufferedOutputStream);
                } catch (Throwable th) {
                    th = th;
                    PictureFileUtils.close(bufferedOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                PictureFileUtils.close(bufferedOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            PictureFileUtils.close(bufferedOutputStream);
        }
    }

    public static int readPictureDegree(Context context, String str) {
        ExifInterface exifInterface;
        int i;
        InputStream inputStream = null;
        try {
            if (PictureMimeType.isContent(str)) {
                inputStream = PictureContentResolver.getContentResolverOpenInputStream(context, Uri.parse(str));
                exifInterface = new ExifInterface(inputStream);
            } else {
                exifInterface = new ExifInterface(str);
            }
            int attributeInt = exifInterface.getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                i = 180;
            } else if (attributeInt == 6) {
                i = 90;
            } else if (attributeInt != 8) {
                return 0;
            } else {
                i = 270;
            }
            PictureFileUtils.close(inputStream);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            PictureFileUtils.close(inputStream);
        }
    }

    public static int readPictureDegree(InputStream inputStream) {
        try {
            int attributeInt = new ExifInterface(inputStream).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return 270;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
