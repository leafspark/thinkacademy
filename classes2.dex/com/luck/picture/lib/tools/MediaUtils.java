package com.luck.picture.lib.tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.luck.picture.lib.PictureContentResolver;
import com.luck.picture.lib.app.PictureAppMaster;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.MediaExtraInfo;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;

public class MediaUtils {
    public static boolean isLongImg(int i, int i2) {
        return i > 0 && i2 > 0 && i2 > i * 3;
    }

    public static Uri createImageUri(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        Uri[] uriArr = {null};
        String externalStorageState = Environment.getExternalStorageState();
        String valueOf = ValueOf.toString(Long.valueOf(System.currentTimeMillis()));
        ContentValues contentValues = new ContentValues(3);
        if (TextUtils.isEmpty(str)) {
            contentValues.put("_display_name", DateUtils.getCreateFileName("IMG_"));
        } else if (str.lastIndexOf(".") == -1) {
            contentValues.put("_display_name", DateUtils.getCreateFileName("IMG_"));
        } else {
            contentValues.put("_display_name", str.replaceAll(str.substring(str.lastIndexOf(".")), ""));
        }
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("datetaken", valueOf);
        }
        if (TextUtils.isEmpty(str2) || str2.startsWith(PictureMimeType.MIME_TYPE_PREFIX_VIDEO)) {
            str2 = "image/jpeg";
        }
        contentValues.put("mime_type", str2);
        if (externalStorageState.equals("mounted")) {
            if (Build.VERSION.SDK_INT >= 29) {
                contentValues.put("relative_path", PictureMimeType.DCIM);
            }
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Images.Media.getContentUri("external"), contentValues);
        } else {
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Images.Media.getContentUri("internal"), contentValues);
        }
        return uriArr[0];
    }

    public static Uri createVideoUri(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        Uri[] uriArr = {null};
        String externalStorageState = Environment.getExternalStorageState();
        String valueOf = ValueOf.toString(Long.valueOf(System.currentTimeMillis()));
        ContentValues contentValues = new ContentValues(3);
        if (TextUtils.isEmpty(str)) {
            contentValues.put("_display_name", DateUtils.getCreateFileName("VID_"));
        } else if (str.lastIndexOf(".") == -1) {
            contentValues.put("_display_name", DateUtils.getCreateFileName("VID_"));
        } else {
            contentValues.put("_display_name", str.replaceAll(str.substring(str.lastIndexOf(".")), ""));
        }
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("datetaken", valueOf);
        }
        if (TextUtils.isEmpty(str2) || str2.startsWith(PictureMimeType.MIME_TYPE_PREFIX_IMAGE)) {
            str2 = "video/mp4";
        }
        contentValues.put("mime_type", str2);
        if (externalStorageState.equals("mounted")) {
            if (Build.VERSION.SDK_INT >= 29) {
                contentValues.put("relative_path", Environment.DIRECTORY_MOVIES);
            }
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Video.Media.getContentUri("external"), contentValues);
        } else {
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Video.Media.getContentUri("internal"), contentValues);
        }
        return uriArr[0];
    }

    public static Uri createAudioUri(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        Uri[] uriArr = {null};
        String externalStorageState = Environment.getExternalStorageState();
        String valueOf = ValueOf.toString(Long.valueOf(System.currentTimeMillis()));
        ContentValues contentValues = new ContentValues(3);
        contentValues.put("_display_name", DateUtils.getCreateFileName("AUD_"));
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("datetaken", valueOf);
        }
        if (TextUtils.isEmpty(str) || str.startsWith(PictureMimeType.MIME_TYPE_PREFIX_IMAGE) || str.startsWith(PictureMimeType.MIME_TYPE_PREFIX_VIDEO)) {
            str = "audio/amr";
        }
        contentValues.put("mime_type", str);
        if (externalStorageState.equals("mounted")) {
            if (Build.VERSION.SDK_INT >= 29) {
                contentValues.put("relative_path", Environment.DIRECTORY_MUSIC);
            }
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Audio.Media.getContentUri("external"), contentValues);
        } else {
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Audio.Media.getContentUri("internal"), contentValues);
        }
        return uriArr[0];
    }

    public static boolean isLongImg(LocalMedia localMedia) {
        int width = localMedia.getWidth();
        int height = localMedia.getHeight();
        return width > 0 && height > 0 && height > width * 3;
    }

    public static MediaExtraInfo getImageSize(Context context, String str) {
        ExifInterface exifInterface;
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        InputStream inputStream = null;
        try {
            if (PictureMimeType.isContent(str)) {
                inputStream = PictureContentResolver.getContentResolverOpenInputStream(context, Uri.parse(str));
                exifInterface = new ExifInterface(inputStream);
            } else {
                exifInterface = new ExifInterface(str);
            }
            mediaExtraInfo.setWidth(exifInterface.getAttributeInt("ImageWidth", 1));
            mediaExtraInfo.setHeight(exifInterface.getAttributeInt("ImageLength", 1));
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            PictureFileUtils.close((Closeable) null);
            throw th;
        }
        PictureFileUtils.close(inputStream);
        return mediaExtraInfo;
    }

    public static MediaExtraInfo getImageSize(String str) {
        InputStream inputStream;
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        InputStream inputStream2 = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            if (PictureMimeType.isContent(str)) {
                inputStream = PictureContentResolver.getContentResolverOpenInputStream(PictureAppMaster.getInstance().getAppContext(), Uri.parse(str));
            } else {
                inputStream = new FileInputStream(str);
            }
            try {
                BitmapFactoryInstrumentation.decodeStream(inputStream, (Rect) null, options);
                mediaExtraInfo.setWidth(options.outWidth);
                mediaExtraInfo.setHeight(options.outHeight);
                PictureFileUtils.close(inputStream);
            } catch (Exception e) {
                Exception exc = e;
                inputStream2 = inputStream;
                e = exc;
                try {
                    e.printStackTrace();
                    PictureFileUtils.close(inputStream2);
                    return mediaExtraInfo;
                } catch (Throwable th) {
                    th = th;
                    PictureFileUtils.close(inputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                inputStream2 = inputStream;
                th = th2;
                PictureFileUtils.close(inputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            PictureFileUtils.close(inputStream2);
            return mediaExtraInfo;
        }
        return mediaExtraInfo;
    }

    public static MediaExtraInfo getVideoSize(Context context, String str) {
        int i;
        int i2;
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            if (PictureMimeType.isContent(str)) {
                mediaMetadataRetriever.setDataSource(context, Uri.parse(str));
            } else {
                mediaMetadataRetriever.setDataSource(str);
            }
            String extractMetadata = mediaMetadataRetriever.extractMetadata(24);
            if (!TextUtils.equals("90", extractMetadata)) {
                if (!TextUtils.equals("270", extractMetadata)) {
                    i2 = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(18));
                    i = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(19));
                    mediaExtraInfo.setWidth(i2);
                    mediaExtraInfo.setHeight(i);
                    mediaExtraInfo.setDuration(ValueOf.toLong(mediaMetadataRetriever.extractMetadata(9)));
                    mediaMetadataRetriever.release();
                    return mediaExtraInfo;
                }
            }
            i = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(18));
            i2 = ValueOf.toInt(mediaMetadataRetriever.extractMetadata(19));
            mediaExtraInfo.setWidth(i2);
            mediaExtraInfo.setHeight(i);
            mediaExtraInfo.setDuration(ValueOf.toLong(mediaMetadataRetriever.extractMetadata(9)));
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
        mediaMetadataRetriever.release();
        return mediaExtraInfo;
    }

    public static MediaExtraInfo getAudioSize(Context context, String str) {
        MediaExtraInfo mediaExtraInfo = new MediaExtraInfo();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            if (PictureMimeType.isContent(str)) {
                mediaMetadataRetriever.setDataSource(context, Uri.parse(str));
            } else {
                mediaMetadataRetriever.setDataSource(str);
            }
            mediaExtraInfo.setDuration(ValueOf.toLong(mediaMetadataRetriever.extractMetadata(9)));
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
        mediaMetadataRetriever.release();
        return mediaExtraInfo;
    }

    public static void removeMedia(Context context, int i) {
        try {
            context.getApplicationContext().getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{Long.toString((long) i)});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [android.os.CancellationSignal, java.lang.String[], android.database.Cursor] */
    public static int getDCIMLastImageId(Context context) {
        Cursor cursor;
        int i = -1;
        ? r1 = 0;
        try {
            String dCIMCameraPath = PictureFileUtils.getDCIMCameraPath();
            String[] strArr = {dCIMCameraPath + "%"};
            if (SdkVersionUtils.checkedAndroid_R()) {
                cursor = context.getApplicationContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r1, createQueryArgsBundle("_data like ?", strArr, 1, 0), r1);
            } else {
                cursor = context.getApplicationContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (String[]) null, "_data like ?", strArr, "_id DESC limit 1 offset 0");
            }
            Cursor cursor2 = cursor;
            if (cursor2 == null || cursor2.getCount() <= 0 || !cursor2.moveToFirst()) {
                if (cursor2 != null) {
                    cursor2.close();
                }
                return -1;
            }
            int i2 = cursor2.getInt(cursor2.getColumnIndex("_id"));
            if (DateUtils.dateDiffer(cursor2.getLong(cursor2.getColumnIndex("date_added"))) <= 1) {
                i = i2;
            }
            if (cursor2 != null) {
                cursor2.close();
            }
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            if (r1 != 0) {
                r1.close();
            }
            return -1;
        } catch (Throwable th) {
            if (r1 != 0) {
                r1.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [android.os.CancellationSignal, java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v4, types: [android.database.Cursor] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long getCameraFirstBucketId(android.content.Context r8) {
        /*
            r0 = 0
            java.lang.String r1 = com.luck.picture.lib.tools.PictureFileUtils.getDCIMCameraPath()     // Catch:{ Exception -> 0x0072 }
            java.lang.String r5 = "_data like ?"
            r2 = 1
            java.lang.String[] r6 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0072 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0072 }
            r3.<init>()     // Catch:{ Exception -> 0x0072 }
            r3.append(r1)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r1 = "%"
            r3.append(r1)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0072 }
            r3 = 0
            r6[r3] = r1     // Catch:{ Exception -> 0x0072 }
            boolean r1 = com.luck.picture.lib.tools.SdkVersionUtils.checkedAndroid_R()     // Catch:{ Exception -> 0x0072 }
            java.lang.String r4 = "external"
            if (r1 == 0) goto L_0x003b
            android.os.Bundle r1 = createQueryArgsBundle(r5, r6, r2, r3)     // Catch:{ Exception -> 0x0072 }
            android.content.Context r8 = r8.getApplicationContext()     // Catch:{ Exception -> 0x0072 }
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch:{ Exception -> 0x0072 }
            android.net.Uri r2 = android.provider.MediaStore.Files.getContentUri(r4)     // Catch:{ Exception -> 0x0072 }
            android.database.Cursor r8 = r8.query(r2, r0, r1, r0)     // Catch:{ Exception -> 0x0072 }
            goto L_0x004e
        L_0x003b:
            java.lang.String r7 = "_id DESC limit 1 offset 0"
            android.content.Context r8 = r8.getApplicationContext()     // Catch:{ Exception -> 0x0072 }
            android.content.ContentResolver r2 = r8.getContentResolver()     // Catch:{ Exception -> 0x0072 }
            android.net.Uri r3 = android.provider.MediaStore.Files.getContentUri(r4)     // Catch:{ Exception -> 0x0072 }
            r4 = 0
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0072 }
        L_0x004e:
            r0 = r8
            if (r0 == 0) goto L_0x006d
            int r8 = r0.getCount()     // Catch:{ Exception -> 0x0072 }
            if (r8 <= 0) goto L_0x006d
            boolean r8 = r0.moveToFirst()     // Catch:{ Exception -> 0x0072 }
            if (r8 == 0) goto L_0x006d
            java.lang.String r8 = "bucket_id"
            int r8 = r0.getColumnIndex(r8)     // Catch:{ Exception -> 0x0072 }
            long r1 = r0.getLong(r8)     // Catch:{ Exception -> 0x0072 }
            if (r0 == 0) goto L_0x006c
            r0.close()
        L_0x006c:
            return r1
        L_0x006d:
            if (r0 == 0) goto L_0x007b
            goto L_0x0078
        L_0x0070:
            r8 = move-exception
            goto L_0x007e
        L_0x0072:
            r8 = move-exception
            r8.printStackTrace()     // Catch:{ all -> 0x0070 }
            if (r0 == 0) goto L_0x007b
        L_0x0078:
            r0.close()
        L_0x007b:
            r0 = -1
            return r0
        L_0x007e:
            if (r0 == 0) goto L_0x0083
            r0.close()
        L_0x0083:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.tools.MediaUtils.getCameraFirstBucketId(android.content.Context):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (r7 != null) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        r1 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getAudioFilePathFromUri(android.content.Context r7, android.net.Uri r8) {
        /*
            java.lang.String r0 = ""
            android.content.Context r7 = r7.getApplicationContext()     // Catch:{ Exception -> 0x0037 }
            android.content.ContentResolver r1 = r7.getContentResolver()     // Catch:{ Exception -> 0x0037 }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r2 = r8
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0037 }
            if (r7 == 0) goto L_0x0031
            r7.moveToFirst()     // Catch:{ all -> 0x0023 }
            java.lang.String r8 = "_data"
            int r8 = r7.getColumnIndex(r8)     // Catch:{ all -> 0x0023 }
            java.lang.String r0 = r7.getString(r8)     // Catch:{ all -> 0x0023 }
            goto L_0x0031
        L_0x0023:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0025 }
        L_0x0025:
            r1 = move-exception
            if (r7 == 0) goto L_0x0030
            r7.close()     // Catch:{ all -> 0x002c }
            goto L_0x0030
        L_0x002c:
            r7 = move-exception
            r8.addSuppressed(r7)     // Catch:{ Exception -> 0x0037 }
        L_0x0030:
            throw r1     // Catch:{ Exception -> 0x0037 }
        L_0x0031:
            if (r7 == 0) goto L_0x003b
            r7.close()     // Catch:{ Exception -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r7 = move-exception
            r7.printStackTrace()
        L_0x003b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.tools.MediaUtils.getAudioFilePathFromUri(android.content.Context, android.net.Uri):java.lang.String");
    }

    public static Bundle createQueryArgsBundle(String str, String[] strArr, int i, int i2) {
        Bundle bundle = new Bundle();
        if (Build.VERSION.SDK_INT >= 26) {
            bundle.putString("android:query-arg-sql-selection", str);
            bundle.putStringArray("android:query-arg-sql-selection-args", strArr);
            bundle.putString("android:query-arg-sql-sort-order", "_id DESC");
            if (Build.VERSION.SDK_INT >= 30) {
                bundle.putString("android:query-arg-sql-limit", i + " offset " + i2);
            }
        }
        return bundle;
    }

    public static void deleteCamera(Context context, String str) {
        try {
            if (PictureMimeType.isContent(str)) {
                context.getContentResolver().delete(Uri.parse(str), (String) null, (String[]) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
