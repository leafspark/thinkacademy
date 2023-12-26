package com.tal.app.thinkacademy.lib.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class StorageDirUtils {
    public static String getAppFileDir(Context context) {
        File externalFilesDir = context.getExternalFilesDir((String) null);
        if (externalFilesDir == null) {
            externalFilesDir = context.getExternalCacheDir();
        }
        if (externalFilesDir == null) {
            externalFilesDir = context.getFilesDir();
        }
        return externalFilesDir.getAbsolutePath();
    }

    public static String getProductFilePath(Context context) {
        File filesDir = context.getFilesDir();
        return (filesDir == null || !filesDir.exists()) ? "" : filesDir.getAbsolutePath();
    }

    public static String getProductExternalCachePath(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        return (externalCacheDir == null || !externalCacheDir.exists()) ? "" : externalCacheDir.getAbsolutePath();
    }

    public static String getPublicPicturePath() {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        return (externalStoragePublicDirectory == null || !externalStoragePublicDirectory.exists()) ? "" : externalStoragePublicDirectory.getAbsolutePath();
    }

    public static String getExternalStorageDir() {
        return isExternalCardExist() ? Environment.getExternalStorageDirectory().getAbsolutePath() : "";
    }

    public static boolean isExternalCardExist() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
