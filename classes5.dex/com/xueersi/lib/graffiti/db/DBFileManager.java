package com.xueersi.lib.graffiti.db;

import android.content.Context;
import android.os.Environment;
import com.xueersi.lib.graffiti.utils.FileUtil;
import java.io.File;

class DBFileManager {
    private static final String DB_VERSION = "v002";
    private static final long expireTime = 604800000;

    DBFileManager() {
    }

    public static void clearDBCacheIfNeed(Context context, long j) {
        File[] listFiles;
        try {
            File file = new File(getDBSaveDir(context));
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    if (System.currentTimeMillis() - file2.lastModified() >= j) {
                        if (file2.isFile()) {
                            FileUtil.deleteFile(file2);
                        } else if (file2.isDirectory()) {
                            FileUtil.deleteDir(file2);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getDiskCacheDir(Context context) {
        if (!"mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable()) {
            return context.getCacheDir().getAbsolutePath();
        }
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            return externalCacheDir.getAbsolutePath();
        }
        return context.getCacheDir().getAbsolutePath();
    }

    public static String getDBFilePath(Context context, String str) {
        File file = new File(buildDBName(context, str));
        if (file.exists()) {
            file.setLastModified(System.currentTimeMillis());
        }
        return file.getAbsolutePath();
    }

    private static String buildDBName(Context context, String str) {
        return getDBSaveDir(context) + File.separator + str + "_" + DB_VERSION + ".db";
    }

    public static String getDBSaveDir(Context context) {
        return getDiskCacheDir(context) + File.separator + "graffiti";
    }
}
