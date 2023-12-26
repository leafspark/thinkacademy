package com.eaydu.omni.log;

import android.os.Build;
import android.os.HandlerThread;
import com.eaydu.omni.logger.DiskLogStrategy;
import com.eaydu.omni.logger.LogStrategy;
import com.eaydu.omni.logger.Utils;
import com.eaydu.omni.utils.FilePathUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CoreRtcLogWrite {
    private static final int LOG_MAX_BYTES = 5242880;
    private static final int LOG_MAX_COUNT = 6;
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String NEW_LINE_REPLACEMENT = " <br> ";
    private static final String SEPARATOR = ",";
    private Date date;
    private final SimpleDateFormat dateFormat;
    LogStrategy logStrategy;
    HandlerThread mHandlerThread;
    private final String tag;

    enum LogState {
        INIT,
        ZIP_STATE,
        LOG_AUTH,
        UPLOAD_START,
        UPLOAD_SUCCESS_STATE,
        UPLOAD_FAIL_STATE
    }

    public CoreRtcLogWrite() {
        this.date = null;
        this.mHandlerThread = null;
        this.tag = "";
        this.date = new Date();
        if (this.logStrategy == null) {
            HandlerThread handlerThread = new HandlerThread("CoreRtcLogWrite.");
            this.mHandlerThread = handlerThread;
            handlerThread.start();
            this.logStrategy = new DiskLogStrategy(new DiskLogStrategy.WriteHandler(this.mHandlerThread.getLooper(), FilePathUtils.getFileFolderPath(), LOG_MAX_BYTES, 6));
        }
        this.dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS", Locale.UK);
    }

    private String formatTag(String str) {
        if (Utils.isEmpty(str) || Utils.equals(this.tag, str)) {
            return this.tag;
        }
        return this.tag + "-" + str;
    }

    public void log(int i, String str, String str2) {
        Utils.checkNotNull(str2);
        String formatTag = formatTag(str);
        this.date.setTime(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append(Long.toString(this.date.getTime()));
        sb.append(SEPARATOR);
        sb.append(this.dateFormat.format(this.date));
        sb.append(SEPARATOR);
        sb.append(Utils.logLevel(i));
        sb.append(SEPARATOR);
        sb.append(formatTag);
        String str3 = NEW_LINE;
        if (str2.contains(str3)) {
            str2 = str2.replaceAll(str3, NEW_LINE_REPLACEMENT);
        }
        sb.append(SEPARATOR);
        sb.append(str2);
        sb.append(str3);
        this.logStrategy.log(i, formatTag, sb.toString());
    }

    public void stop() {
        LogStrategy logStrategy2 = this.logStrategy;
        if (logStrategy2 != null) {
            logStrategy2.stop();
        }
        if (this.mHandlerThread != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.mHandlerThread.quitSafely();
            } else {
                this.mHandlerThread.quit();
            }
            this.mHandlerThread = null;
        }
    }
}
