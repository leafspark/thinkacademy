package com.eaydu.omni.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FilePathUtils {
    private static String CoreRtcLogFileName = "CoreRtcLog";
    public static String CoreRtcLogFilefolder = (rootPath + File.separatorChar + CoreRtcLogFileName + File.separatorChar);
    private static String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath();

    public static void setLogRootPath(String str) {
        rootPath = str;
        CoreRtcLogFilefolder = rootPath + File.separatorChar + CoreRtcLogFileName + File.separatorChar;
    }

    public static String getFileFolderPath() {
        if (rootPath.endsWith("/")) {
            CoreRtcLogFilefolder = rootPath + CoreRtcLogFileName + File.separatorChar;
        } else {
            CoreRtcLogFilefolder = rootPath + File.separatorChar + CoreRtcLogFileName + File.separatorChar;
        }
        return CoreRtcLogFilefolder;
    }

    public static String getZipFilePath() {
        return rootPath + File.separatorChar;
    }

    public static String getZipFileName(String str) {
        String format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date(System.currentTimeMillis()));
        return str + "_android_" + format + ".zip";
    }

    public static String getAgoraInspectFileName(Context context) {
        if (context == null) {
            return "";
        }
        String str = context.getFilesDir().getAbsolutePath() + File.separatorChar + "RtcSdk" + File.separatorChar + "Inspect" + File.separatorChar;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str + "agora_inspect_image_temp.jpg";
    }
}
