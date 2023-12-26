package com.amazonaws.logging;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.HashMap;
import java.util.Map;

public class LogFactory {
    private static final String TAG = "LogFactory";
    private static Level globalLogLevel = null;
    private static final Map<String, Log> logMap = new HashMap();

    public static synchronized Log getLog(Class<?> cls) {
        Log log;
        synchronized (LogFactory.class) {
            log = getLog(getTruncatedLogTag(cls.getSimpleName()));
        }
        return log;
    }

    public static synchronized Log getLog(String str) {
        Log log;
        synchronized (LogFactory.class) {
            String truncatedLogTag = getTruncatedLogTag(str);
            Map<String, Log> map = logMap;
            Log log2 = map.get(truncatedLogTag);
            if (log2 != null) {
                return log2;
            }
            if (Environment.isJUnitTest()) {
                log = new ConsoleLog(truncatedLogTag);
            } else {
                log = new AndroidLog(truncatedLogTag);
            }
            map.put(truncatedLogTag, log);
            return log;
        }
    }

    public static void setLevel(Level level) {
        globalLogLevel = level;
    }

    public static Level getLevel() {
        return globalLogLevel;
    }

    private static String getTruncatedLogTag(String str) {
        if (str.length() <= 23) {
            return str;
        }
        getLog(TAG).warn("Truncating log tag length as it exceed 23, the limit imposed by Android on certain API Levels");
        return str.substring(0, 23);
    }

    public enum Level {
        ALL(Integer.MIN_VALUE),
        TRACE(0),
        DEBUG(1),
        INFO(2),
        WARN(3),
        ERROR(4),
        OFF(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        
        private final int value;

        public int getValue() {
            return this.value;
        }

        private Level(int i) {
            this.value = i;
        }
    }
}
