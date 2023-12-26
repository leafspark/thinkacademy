package com.tal.app.thinkacademy.live.business.canvastriplescreen;

import android.content.Context;
import android.os.Environment;
import com.tal.app.thinkacademy.lib.util.FileUtils;
import java.io.File;

public class DBManager {
    private static final String DB_VERSION = "v002";
    private static final long expireTime = 604800000;

    public static void clearDbCacheIfNeed(Context context) {
        File[] listFiles;
        try {
            File file = new File(getDbDir(context));
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    if (System.currentTimeMillis() - file2.lastModified() >= expireTime) {
                        if (file2.isFile()) {
                            FileUtils.delete(file2);
                        } else if (file2.isDirectory()) {
                            FileUtils.delete(file2);
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

    public static String getDbFilePath(Context context, String str) {
        File file = new File(getDbName(context, str));
        if (file.exists()) {
            file.setLastModified(System.currentTimeMillis());
        }
        return file.getAbsolutePath();
    }

    private static String getDbName(Context context, String str) {
        return getDbDir(context) + File.separator + "live_" + str + "_" + DB_VERSION + ".db";
    }

    public static String getDbDir(Context context) {
        return getDiskCacheDir(context) + File.separator + "graffiti";
    }
}
