package com.tal.app.thinkacademy.lib.util;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.io.File;
import java.io.IOException;

public class StorageUtil {
    private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final String INDIVIDUAL_DIR_NAME = "uil-images";

    public static File getCacheDirectory(Context context) {
        return getCacheDirectory(context, true);
    }

    public static File getCacheDirectory(Context context, boolean z) {
        String str = "";
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError | NullPointerException unused) {
        }
        File externalCacheDir = (!z || !"mounted".equals(str) || !hasExternalStoragePermission(context)) ? null : getExternalCacheDir(context);
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir != null) {
            return externalCacheDir;
        }
        return new File("/data/data/" + context.getPackageName() + "/cache/");
    }

    public static File getIndividualCacheDirectory(Context context) {
        return getIndividualCacheDirectory(context, INDIVIDUAL_DIR_NAME);
    }

    public static File getIndividualCacheDirectory(Context context, String str) {
        File cacheDirectory = getCacheDirectory(context);
        File file = new File(cacheDirectory, str);
        return (file.exists() || file.mkdir()) ? file : cacheDirectory;
    }

    public static File getOwnCacheDirectory(Context context, String str) {
        File file = (!"mounted".equals(Environment.getExternalStorageState()) || !hasExternalStoragePermission(context)) ? null : new File(Environment.getExternalStorageDirectory(), str);
        return (file == null || (!file.exists() && !file.mkdirs())) ? context.getCacheDir() : file;
    }

    public static File getOwnCacheDirectory(Context context, String str, boolean z) {
        File file = (!z || !"mounted".equals(Environment.getExternalStorageState()) || !hasExternalStoragePermission(context)) ? null : new File(Environment.getExternalStorageDirectory(), str);
        return (file == null || (!file.exists() && !file.mkdirs())) ? context.getCacheDir() : file;
    }

    private static File getExternalCacheDir(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                return null;
            }
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    private static boolean hasExternalStoragePermission(Context context) {
        return context.checkCallingOrSelfPermission(EXTERNAL_STORAGE_PERMISSION) == 0;
    }

    public static long getAvailableSize(Context context) {
        Context context2 = context;
        StatFs statFs = new StatFs(context.getFilesDir().getPath());
        long blockCountLong = statFs.getBlockCountLong();
        long blockSizeLong = statFs.getBlockSizeLong();
        long availableBlocksLong = statFs.getAvailableBlocksLong();
        long freeBlocksLong = statFs.getFreeBlocksLong();
        long totalBytes = statFs.getTotalBytes();
        long availableBytes = statFs.getAvailableBytes();
        XesLog.it("statfs", "total = " + Formatter.formatFileSize(context2, totalBytes));
        XesLog.it("statfs", "availableSize = " + Formatter.formatFileSize(context2, availableBytes));
        XesLog.it("statfs", "total = " + Formatter.formatFileSize(context2, blockCountLong * blockSizeLong));
        XesLog.it("statfs", "available = " + Formatter.formatFileSize(context2, availableBlocksLong * blockSizeLong));
        XesLog.it("statfs", "free = " + Formatter.formatFileSize(context2, blockSizeLong * freeBlocksLong));
        return availableBytes;
    }
}
