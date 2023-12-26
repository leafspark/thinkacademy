package com.luck.picture.lib.tools;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.channels.FileChannel;
import java.util.Locale;
import java.util.Objects;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

public class PictureFileUtils {
    public static final int BYTE = 1;
    public static final int GB = 1073741824;
    public static final int KB = 1024;
    public static final int MB = 1048576;
    public static final String POSTFIX = ".jpeg";
    public static final String POST_AUDIO = ".amr";
    public static final String POST_VIDEO = ".mp4";
    static final String TAG = "PictureFileUtils";

    @Retention(RetentionPolicy.SOURCE)
    public @interface Unit {
    }

    public static File createCameraFile(Context context, int i, String str, String str2, String str3) {
        return createMediaFile(context, i, str, str2, str3);
    }

    private static File createMediaFile(Context context, int i, String str, String str2, String str3) {
        return createOutFile(context, i, str, str2, str3);
    }

    private static File createOutFile(Context context, int i, String str, String str2, String str3) {
        File file;
        File file2;
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(str3)) {
            if (TextUtils.equals("mounted", Environment.getExternalStorageState())) {
                file2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                file = new File(file2.getAbsolutePath() + File.separator + PictureMimeType.CAMERA + File.separator);
            } else {
                file2 = getRootDirFile(applicationContext, i);
                file = new File(file2.getAbsolutePath() + File.separator);
            }
            if (!file2.exists()) {
                file2.mkdirs();
            }
        } else {
            File file3 = new File(str3);
            File parentFile = file3.getParentFile();
            Objects.requireNonNull(parentFile);
            if (!parentFile.exists()) {
                file3.getParentFile().mkdirs();
            }
            file = file3;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        if (i == 2) {
            if (isEmpty) {
                str = DateUtils.getCreateFileName("VID_") + ".mp4";
            }
            return new File(file, str);
        } else if (i != 3) {
            if (TextUtils.isEmpty(str2)) {
                str2 = ".jpeg";
            }
            if (isEmpty) {
                str = DateUtils.getCreateFileName("IMG_") + str2;
            }
            return new File(file, str);
        } else {
            if (isEmpty) {
                str = DateUtils.getCreateFileName("AUD_") + ".amr";
            }
            return new File(file, str);
        }
    }

    private static File getRootDirFile(Context context, int i) {
        if (i == 2) {
            return context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        }
        if (i != 3) {
            return context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        }
        return context.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
    }

    private PictureFileUtils() {
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, (String) null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor == null) {
                    return "";
                }
                cursor.close();
                return "";
            }
            String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
            if (cursor != null) {
                cursor.close();
            }
            return string;
        } catch (IllegalArgumentException e) {
            Log.i(TAG, String.format(Locale.getDefault(), "getDataColumn: _data - [%s]", new Object[]{e.getMessage()}));
            if (cursor == null) {
                return "";
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static String getPath(Context context, Uri uri) {
        Context applicationContext = context.getApplicationContext();
        Uri uri2 = null;
        if (!(Build.VERSION.SDK_INT >= 19) || !DocumentsContract.isDocumentUri(applicationContext, uri)) {
            if (!FirebaseAnalytics.Param.CONTENT.equalsIgnoreCase(uri.getScheme())) {
                return "file".equalsIgnoreCase(uri.getScheme()) ? uri.getPath() : "";
            }
            if (isGooglePhotosUri(uri)) {
                return uri.getLastPathSegment();
            }
            return getDataColumn(applicationContext, uri, (String) null, (String[]) null);
        } else if (isExternalStorageDocument(uri)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            if (!"primary".equalsIgnoreCase(split[0])) {
                return "";
            }
            if (SdkVersionUtils.checkedAndroid_Q()) {
                return applicationContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES) + "/" + split[1];
            }
            return Environment.getExternalStorageDirectory() + "/" + split[1];
        } else if (isDownloadsDocument(uri)) {
            return getDataColumn(applicationContext, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), ValueOf.toLong(DocumentsContract.getDocumentId(uri))), (String) null, (String[]) null);
        } else if (!isMediaDocument(uri)) {
            return "";
        } else {
            String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
            String str = split2[0];
            if (PictureMimeType.MIME_TYPE_PREFIX_IMAGE.equals(str)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if (PictureMimeType.MIME_TYPE_PREFIX_VIDEO.equals(str)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if (PictureMimeType.MIME_TYPE_PREFIX_AUDIO.equals(str)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return getDataColumn(applicationContext, uri2, "_id=?", new String[]{split2[1]});
        }
    }

    public static void copyFile(String str, String str2) throws IOException {
        FileChannel fileChannel;
        if (!str.equalsIgnoreCase(str2)) {
            FileChannel fileChannel2 = null;
            try {
                FileChannel channel = new FileInputStream(new File(str)).getChannel();
                try {
                    fileChannel2 = new FileOutputStream(new File(str2)).getChannel();
                    channel.transferTo(0, channel.size(), fileChannel2);
                    close(channel);
                    close(fileChannel2);
                } catch (Exception e) {
                    e = e;
                    FileChannel fileChannel3 = fileChannel2;
                    fileChannel2 = channel;
                    fileChannel = fileChannel3;
                    try {
                        e.printStackTrace();
                        close(fileChannel2);
                        close(fileChannel);
                    } catch (Throwable th) {
                        th = th;
                        close(fileChannel2);
                        close(fileChannel);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    FileChannel fileChannel4 = fileChannel2;
                    fileChannel2 = channel;
                    fileChannel = fileChannel4;
                    close(fileChannel2);
                    close(fileChannel);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileChannel = null;
                e.printStackTrace();
                close(fileChannel2);
                close(fileChannel);
            } catch (Throwable th3) {
                th = th3;
                fileChannel = null;
                close(fileChannel2);
                close(fileChannel);
                throw th;
            }
        }
    }

    public static boolean copyFile(FileInputStream fileInputStream, String str) throws IOException {
        FileChannel fileChannel;
        FileChannel fileChannel2;
        if (fileInputStream == null) {
            return false;
        }
        FileChannel fileChannel3 = null;
        try {
            FileChannel channel = fileInputStream.getChannel();
            try {
                fileChannel3 = new FileOutputStream(new File(str)).getChannel();
                channel.transferTo(0, channel.size(), fileChannel3);
                close(fileInputStream);
                close(channel);
                close(fileChannel3);
                return true;
            } catch (Exception unused) {
                fileChannel = fileChannel3;
                fileChannel3 = channel;
                close(fileInputStream);
                close(fileChannel3);
                close(fileChannel);
                return false;
            } catch (Throwable th) {
                th = th;
                fileChannel2 = fileChannel3;
                fileChannel3 = channel;
                close(fileInputStream);
                close(fileChannel3);
                close(fileChannel2);
                throw th;
            }
        } catch (Exception unused2) {
            fileChannel = null;
            close(fileInputStream);
            close(fileChannel3);
            close(fileChannel);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileChannel2 = null;
            close(fileInputStream);
            close(fileChannel3);
            close(fileChannel2);
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public static boolean bufferCopy(BufferedSource bufferedSource, File file) {
        BufferedSink bufferedSink = null;
        try {
            bufferedSink = Okio.buffer(Okio.sink(file));
            bufferedSink.writeAll(bufferedSource);
            bufferedSink.flush();
            close(bufferedSource);
            close(bufferedSink);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            close(bufferedSource);
            close(bufferedSink);
            return false;
        } catch (Throwable th) {
            close(bufferedSource);
            close(bufferedSink);
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public static boolean bufferCopy(BufferedSource bufferedSource, OutputStream outputStream) {
        BufferedSink bufferedSink = null;
        try {
            bufferedSink = Okio.buffer(Okio.sink(outputStream));
            bufferedSink.writeAll(bufferedSource);
            bufferedSink.flush();
            close(bufferedSource);
            close(bufferedSink);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            close(bufferedSource);
            close(bufferedSink);
            return false;
        } catch (Throwable th) {
            close(bufferedSource);
            close(bufferedSink);
            throw th;
        }
    }

    public static boolean bufferCopy(File file, OutputStream outputStream) {
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            Closeable buffer = Okio.buffer(Okio.source(file));
            try {
                closeable2 = Okio.buffer(Okio.sink(outputStream));
                closeable2.writeAll(buffer);
                closeable2.flush();
                close(buffer);
                close(outputStream);
                close(closeable2);
                return true;
            } catch (Exception e) {
                e = e;
                Closeable closeable3 = closeable2;
                closeable2 = buffer;
                closeable = closeable3;
                try {
                    e.printStackTrace();
                    close(closeable2);
                    close(outputStream);
                    close(closeable);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    close(closeable2);
                    close(outputStream);
                    close(closeable);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                Closeable closeable4 = closeable2;
                closeable2 = buffer;
                closeable = closeable4;
                close(closeable2);
                close(outputStream);
                close(closeable);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            closeable = null;
            e.printStackTrace();
            close(closeable2);
            close(outputStream);
            close(closeable);
            return false;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            close(closeable2);
            close(outputStream);
            close(closeable);
            throw th;
        }
    }

    public static String rename(String str) {
        String substring = str.substring(0, str.lastIndexOf("."));
        String substring2 = str.substring(str.lastIndexOf("."));
        return substring + "_" + DateUtils.getCreateFileName() + substring2;
    }

    public static String getDCIMCameraPath() {
        try {
            return "%" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/Camera";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Deprecated
    public static void deleteCacheDirFile(Context context, int i) {
        File[] listFiles;
        File externalFilesDir = context.getExternalFilesDir(i == PictureMimeType.ofImage() ? Environment.DIRECTORY_PICTURES : Environment.DIRECTORY_MOVIES);
        if (externalFilesDir != null && (listFiles = externalFilesDir.listFiles()) != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    file.delete();
                }
            }
        }
    }

    @Deprecated
    public static void deleteAllCacheDirFile(Context context) {
        File[] listFiles;
        File[] listFiles2;
        File[] listFiles3;
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (!(externalFilesDir == null || (listFiles3 = externalFilesDir.listFiles()) == null)) {
            for (File file : listFiles3) {
                if (file.isFile()) {
                    file.delete();
                }
            }
        }
        File externalFilesDir2 = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        if (!(externalFilesDir2 == null || (listFiles2 = externalFilesDir2.listFiles()) == null)) {
            for (File file2 : listFiles2) {
                if (file2.isFile()) {
                    file2.delete();
                }
            }
        }
        File externalFilesDir3 = context.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        if (externalFilesDir3 != null && (listFiles = externalFilesDir3.listFiles()) != null) {
            for (File file3 : listFiles) {
                if (file3.isFile()) {
                    file3.delete();
                }
            }
        }
    }

    public static String getDiskCacheDir(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir == null) {
            return "";
        }
        return externalFilesDir.getPath();
    }

    public static String getVideoDiskCacheDir(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        if (externalFilesDir == null) {
            return "";
        }
        return externalFilesDir.getPath();
    }

    public static String getAudioDiskCacheDir(Context context) {
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        if (externalFilesDir == null) {
            return "";
        }
        return externalFilesDir.getPath();
    }

    public static Uri parUri(Context context, File file) {
        String str = context.getPackageName() + ".luckProvider";
        if (Build.VERSION.SDK_INT > 23) {
            return FileProvider.getUriForFile(context, str, file);
        }
        return Uri.fromFile(file);
    }

    public static String createFilePath(Context context, String str, String str2, String str3) {
        String lastImgSuffix = PictureMimeType.getLastImgSuffix(str2);
        if (PictureMimeType.isHasVideo(str2)) {
            String str4 = getVideoDiskCacheDir(context) + File.separator;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = DateUtils.getCreateFileName("VID_") + lastImgSuffix;
                }
                return str4 + str3;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "VID_" + str.toUpperCase() + lastImgSuffix;
            }
            return str4 + str3;
        } else if (PictureMimeType.isHasAudio(str2)) {
            String str5 = getAudioDiskCacheDir(context) + File.separator;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = DateUtils.getCreateFileName("AUD_") + lastImgSuffix;
                }
                return str5 + str3;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "AUD_" + str.toUpperCase() + lastImgSuffix;
            }
            return str5 + str3;
        } else {
            String str6 = getDiskCacheDir(context) + File.separator;
            if (TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = DateUtils.getCreateFileName("IMG_") + lastImgSuffix;
                }
                return str6 + str3;
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "IMG_" + str.toUpperCase() + lastImgSuffix;
            }
            return str6 + str3;
        }
    }

    public static boolean isFileExists(String str) {
        return TextUtils.isEmpty(str) || new File(str).exists();
    }

    public static String formatFileSize(long j, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("precision shouldn't be less than zero!");
        } else if (j < 0) {
            throw new IllegalArgumentException("byteSize shouldn't be less than zero!");
        } else if (j < 1024) {
            return String.format("%." + i + "fB", new Object[]{Double.valueOf((double) j)});
        } else if (j < PictureConfig.MB) {
            return String.format("%." + i + "fKB", new Object[]{Double.valueOf(((double) j) / 1024.0d)});
        } else if (j < 1073741824) {
            return String.format("%." + i + "fMB", new Object[]{Double.valueOf(((double) j) / 1048576.0d)});
        } else {
            return String.format("%." + i + "fGB", new Object[]{Double.valueOf(((double) j) / 1.073741824E9d)});
        }
    }

    public static void close(Closeable closeable) {
        if (closeable instanceof Closeable) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }
}
