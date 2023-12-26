package com.tal.app.thinkacademy.lib.download.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tal.app.thinkacademy.lib.language.AppUtil;
import com.tal.app.thinkacademy.lib.util.FileUtils;
import java.io.File;

public class AppCacheUtil {
    public static final String CACHE_DIR_PIC_CHAT = "jiazhanghui/images/chat";
    public static final String IMAGE_DIR = "jiazhanghui/images";
    public static final String KMaterialsCache = "/material/";
    public static final String KTakePhoto = "/takephoto/";
    private static final String OFF_LINE = (AppUtil.getApplication().getFilesDir().getAbsolutePath() + "/offline/");
    public static final String PHOTOS_DIR = "jiazhanghui/photos/";
    public static final String ROOT_DIR = "jiazhanghui";
    public static final String UNZIP_DIR = (AppUtil.getApplication().getFilesDir().getAbsolutePath() + "/course_unzip/");
    public static final String ZIP_DIR = (AppUtil.getApplication().getFilesDir().getAbsolutePath() + "/course_zip/");
    public static String sCachePath = "";
    public static String sMaterialsCache = "";
    public static String sTakePhotoCache = "";

    public static String getCacheSize(Context context) {
        File classGroupImageDir = getClassGroupImageDir(context);
        File externalCacheDir = context.getExternalCacheDir();
        File externalFilesDir = context.getExternalFilesDir((String) null);
        File file = new File(getMaterialsCacheDir(context));
        File file2 = new File(UNZIP_DIR);
        ensureFileExist(file);
        return FileUtils.formatFileSize(context, FileUtils.getFolderSize(classGroupImageDir) + FileUtils.getFolderSize(externalCacheDir) + FileUtils.getFolderSize(externalFilesDir) + FileUtils.getFolderSize(file) + FileUtils.getFolderSize(file2), FileUtils.SizeUnit.MB);
    }

    public static void clearCache(Context context) {
        File classGroupImageDir = getClassGroupImageDir(context);
        File externalCacheDir = context.getExternalCacheDir();
        File externalFilesDir = context.getExternalFilesDir((String) null);
        File file = new File(getMaterialsCacheDir(context));
        ensureFileExist(file);
        File file2 = new File(UNZIP_DIR);
        File file3 = new File(ZIP_DIR);
        File file4 = new File(OFF_LINE);
        if (classGroupImageDir != null) {
            FileUtils.deleteDir(classGroupImageDir.getAbsolutePath(), false);
        }
        if (externalCacheDir != null) {
            FileUtils.deleteDir(externalCacheDir.getAbsolutePath(), false);
        }
        if (externalFilesDir != null) {
            FileUtils.deleteDir(externalFilesDir.getAbsolutePath(), false);
        }
        FileUtils.deleteDir(file.getAbsolutePath(), false);
        FileUtils.deleteDir(file2.getAbsolutePath(), false);
        FileUtils.deleteDir(file3.getAbsolutePath(), false);
        if (file4.exists()) {
            FileUtils.deleteDir(file4.getAbsolutePath(), false);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f A[SYNTHETIC, Splitter:B:19:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005d A[SYNTHETIC, Splitter:B:24:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void put(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.File r3 = r3.getCacheDir()
            r1.append(r3)
            java.lang.String r3 = "/"
            r1.append(r3)
            r1.append(r4)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            r3 = 0
            boolean r4 = r0.exists()     // Catch:{ IOException -> 0x0049 }
            if (r4 != 0) goto L_0x0027
            r0.createNewFile()     // Catch:{ IOException -> 0x0049 }
        L_0x0027:
            java.io.BufferedWriter r4 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x0049 }
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch:{ IOException -> 0x0049 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x0049 }
            r0 = 1024(0x400, float:1.435E-42)
            r4.<init>(r1, r0)     // Catch:{ IOException -> 0x0049 }
            r4.write(r5)     // Catch:{ IOException -> 0x0042, all -> 0x003d }
            r4.flush()     // Catch:{ IOException -> 0x0056 }
            r4.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x005a
        L_0x003d:
            r3 = move-exception
            r2 = r4
            r4 = r3
            r3 = r2
            goto L_0x005b
        L_0x0042:
            r3 = move-exception
            r2 = r4
            r4 = r3
            r3 = r2
            goto L_0x004a
        L_0x0047:
            r4 = move-exception
            goto L_0x005b
        L_0x0049:
            r4 = move-exception
        L_0x004a:
            r4.printStackTrace()     // Catch:{ all -> 0x0047 }
            if (r3 == 0) goto L_0x005a
            r3.flush()     // Catch:{ IOException -> 0x0056 }
            r3.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x005a
        L_0x0056:
            r3 = move-exception
            r3.printStackTrace()
        L_0x005a:
            return
        L_0x005b:
            if (r3 == 0) goto L_0x0068
            r3.flush()     // Catch:{ IOException -> 0x0064 }
            r3.close()     // Catch:{ IOException -> 0x0064 }
            goto L_0x0068
        L_0x0064:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0068:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.download.util.AppCacheUtil.put(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059 A[SYNTHETIC, Splitter:B:24:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0065 A[SYNTHETIC, Splitter:B:31:0x0065] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getString(android.content.Context r3, java.lang.String r4) {
        /*
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.File r3 = r3.getCacheDir()
            r1.append(r3)
            java.lang.String r3 = "/"
            r1.append(r3)
            r1.append(r4)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            boolean r3 = r0.exists()
            r4 = 0
            if (r3 != 0) goto L_0x0025
            return r4
        L_0x0025:
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0052, all -> 0x004d }
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ IOException -> 0x0052, all -> 0x004d }
            r1.<init>(r0)     // Catch:{ IOException -> 0x0052, all -> 0x004d }
            r3.<init>(r1)     // Catch:{ IOException -> 0x0052, all -> 0x004d }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x004b }
            r0.<init>()     // Catch:{ IOException -> 0x004b }
        L_0x0034:
            java.lang.String r1 = r3.readLine()     // Catch:{ IOException -> 0x004b }
            if (r1 == 0) goto L_0x003e
            r0.append(r1)     // Catch:{ IOException -> 0x004b }
            goto L_0x0034
        L_0x003e:
            java.lang.String r4 = r0.toString()     // Catch:{ IOException -> 0x004b }
            r3.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            r3 = move-exception
            r3.printStackTrace()
        L_0x004a:
            return r4
        L_0x004b:
            r0 = move-exception
            goto L_0x0054
        L_0x004d:
            r3 = move-exception
            r2 = r4
            r4 = r3
            r3 = r2
            goto L_0x0063
        L_0x0052:
            r0 = move-exception
            r3 = r4
        L_0x0054:
            r0.printStackTrace()     // Catch:{ all -> 0x0062 }
            if (r3 == 0) goto L_0x0061
            r3.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0061:
            return r4
        L_0x0062:
            r4 = move-exception
        L_0x0063:
            if (r3 == 0) goto L_0x006d
            r3.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r3 = move-exception
            r3.printStackTrace()
        L_0x006d:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.download.util.AppCacheUtil.getString(android.content.Context, java.lang.String):java.lang.String");
    }

    public static File getClassGroupImageDir(Context context) {
        File file;
        if (Environment.getExternalStorageState().equals("mounted")) {
            file = new File(Environment.getExternalStorageDirectory(), CACHE_DIR_PIC_CHAT);
        } else {
            file = context.getDir(ROOT_DIR, 0);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String getPhotosDir(Context context) {
        File file;
        if (Environment.getExternalStorageState().equals("mounted")) {
            file = context.getExternalFilesDir(PHOTOS_DIR);
        } else {
            file = context.getDir(ROOT_DIR, 0);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String getMaterialsCacheDir(Context context) {
        String str = getCacheDir(context) + KMaterialsCache;
        sMaterialsCache = str;
        ensureFileExist(str);
        return sMaterialsCache;
    }

    public static String getTakePhotoCacheDir(Context context) {
        String str = getCacheDir(context) + KTakePhoto;
        sTakePhotoCache = str;
        ensureFileExist(str);
        return sTakePhotoCache;
    }

    public static String getCacheDir(Context context) {
        File cacheDir;
        File externalCacheDir;
        if (TextUtils.isEmpty(sCachePath) && (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && (externalCacheDir = context.getExternalCacheDir()) != null)) {
            sCachePath = externalCacheDir.getPath();
        }
        if (TextUtils.isEmpty(sCachePath) && (cacheDir = context.getCacheDir()) != null) {
            sCachePath = cacheDir.getPath();
        }
        return sCachePath;
    }

    public static boolean ensureFileExist(String str) {
        return ensureFileExist(new File(str));
    }

    public static boolean ensureFileExist(File file) {
        if (!file.exists()) {
            return file.mkdirs();
        }
        return true;
    }

    private static String getOfflineFilePath(String str) {
        if (!TextUtils.isEmpty(str)) {
            return OFF_LINE + str;
        }
        return OFF_LINE + "other";
    }

    public static String getClassRoomOfflineGraffitiPath(String str) {
        return getOfflineFilePath(str) + "/graffiti/";
    }

    public static String getClassRoomOfflineMateInfoPath(String str) {
        return getOfflineFilePath(str) + "/mateinfo/";
    }
}
