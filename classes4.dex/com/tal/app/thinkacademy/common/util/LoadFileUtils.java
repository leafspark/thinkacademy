package com.tal.app.thinkacademy.common.util;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class LoadFileUtils {
    public static File geCacheFile(Context context, String str) {
        File file;
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            file = new File(externalCacheDir, str);
        } else if ("mounted".equals(Environment.getExternalStorageState())) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            file = new File(externalStorageDirectory, "parentsmeeting/" + str);
        } else {
            file = new File(context.getCacheDir(), str);
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
