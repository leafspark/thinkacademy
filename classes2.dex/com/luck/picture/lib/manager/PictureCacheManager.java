package com.luck.picture.lib.manager;

import android.content.Context;
import android.os.Environment;
import com.luck.picture.lib.PictureMediaScannerConnection;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.listener.OnCallbackListener;
import com.luck.picture.lib.thread.PictureThreadUtils;
import java.io.File;

public class PictureCacheManager {
    public static void deleteCacheDirFile(String str) {
        deleteCacheDirFile(str, (OnCallbackListener<String>) null);
    }

    public static void deleteCacheDirFile(String str, OnCallbackListener<String> onCallbackListener) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile() && file.delete() && onCallbackListener != null) {
                    onCallbackListener.onCall(file.getAbsolutePath());
                }
            }
        }
    }

    public static void deleteCacheRefreshDirFile(Context context, int i) {
        deleteCacheDirFile(context, i, true, (OnCallbackListener<String>) null);
    }

    public static void deleteCacheDirFile(Context context, int i) {
        deleteCacheDirFile(context, i, false, (OnCallbackListener<String>) null);
    }

    public static void deleteCacheDirFile(Context context, int i, OnCallbackListener<String> onCallbackListener) {
        deleteCacheDirFile(context, i, false, onCallbackListener);
    }

    private static void deleteCacheDirFile(final Context context, int i, boolean z, OnCallbackListener<String> onCallbackListener) {
        File[] listFiles;
        File externalFilesDir = context.getExternalFilesDir(i == PictureMimeType.ofImage() ? Environment.DIRECTORY_PICTURES : Environment.DIRECTORY_MOVIES);
        if (externalFilesDir != null && (listFiles = externalFilesDir.listFiles()) != null) {
            for (final File file : listFiles) {
                if (file.isFile() && file.delete()) {
                    if (z) {
                        PictureThreadUtils.runOnUiThread(new Runnable() {
                            public void run() {
                                new PictureMediaScannerConnection(context, file.getAbsolutePath());
                            }
                        });
                    } else if (onCallbackListener != null) {
                        onCallbackListener.onCall(file.getAbsolutePath());
                    }
                }
            }
        }
    }

    public static void deleteAllCacheDirFile(Context context) {
        deleteAllCacheDirFile(context, false, (OnCallbackListener<String>) null);
    }

    public static void deleteAllCacheDirFile(Context context, OnCallbackListener<String> onCallbackListener) {
        deleteAllCacheDirFile(context, false, onCallbackListener);
    }

    public static void deleteAllCacheDirRefreshFile(Context context) {
        deleteAllCacheDirFile(context, true, (OnCallbackListener<String>) null);
    }

    private static void deleteAllCacheDirFile(final Context context, boolean z, OnCallbackListener<String> onCallbackListener) {
        File[] listFiles;
        File[] listFiles2;
        File[] listFiles3;
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (!(externalFilesDir == null || (listFiles3 = externalFilesDir.listFiles()) == null)) {
            for (final File file : listFiles3) {
                if (file.isFile() && file.delete()) {
                    if (z) {
                        PictureThreadUtils.runOnUiThread(new Runnable() {
                            public void run() {
                                new PictureMediaScannerConnection(context, file.getAbsolutePath());
                            }
                        });
                    } else if (onCallbackListener != null) {
                        onCallbackListener.onCall(file.getAbsolutePath());
                    }
                }
            }
        }
        File externalFilesDir2 = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        if (!(externalFilesDir2 == null || (listFiles2 = externalFilesDir2.listFiles()) == null)) {
            for (final File file2 : listFiles2) {
                if (file2.isFile() && file2.delete()) {
                    if (z) {
                        PictureThreadUtils.runOnUiThread(new Runnable() {
                            public void run() {
                                new PictureMediaScannerConnection(context, file2.getAbsolutePath());
                            }
                        });
                    } else if (onCallbackListener != null) {
                        onCallbackListener.onCall(file2.getAbsolutePath());
                    }
                }
            }
        }
        File externalFilesDir3 = context.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        if (externalFilesDir3 != null && (listFiles = externalFilesDir3.listFiles()) != null) {
            for (final File file3 : listFiles) {
                if (file3.isFile() && file3.delete()) {
                    if (z) {
                        PictureThreadUtils.runOnUiThread(new Runnable() {
                            public void run() {
                                new PictureMediaScannerConnection(context, file3.getAbsolutePath());
                            }
                        });
                    } else if (onCallbackListener != null) {
                        onCallbackListener.onCall(file3.getAbsolutePath());
                    }
                }
            }
        }
    }
}
