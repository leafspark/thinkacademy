package com.amazonaws.logging;

import android.util.Log;
import com.amazonaws.logging.LogFactory;

public class AndroidLog implements Log {
    private LogFactory.Level level = null;
    private final String tag;

    public AndroidLog(String str) {
        this.tag = str;
    }

    public boolean isDebugEnabled() {
        return Log.isLoggable(this.tag, 3) && (getLevel() == null || getLevel().getValue() <= LogFactory.Level.DEBUG.getValue());
    }

    public boolean isErrorEnabled() {
        return Log.isLoggable(this.tag, 6) && (getLevel() == null || getLevel().getValue() <= LogFactory.Level.ERROR.getValue());
    }

    public boolean isInfoEnabled() {
        return Log.isLoggable(this.tag, 4) && (getLevel() == null || getLevel().getValue() <= LogFactory.Level.INFO.getValue());
    }

    public boolean isTraceEnabled() {
        return Log.isLoggable(this.tag, 2) && (getLevel() == null || getLevel().getValue() <= LogFactory.Level.TRACE.getValue());
    }

    public boolean isWarnEnabled() {
        return Log.isLoggable(this.tag, 5) && (getLevel() == null || getLevel().getValue() <= LogFactory.Level.WARN.getValue());
    }

    public void trace(Object obj) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.TRACE.getValue()) {
            Log.v(this.tag, obj.toString());
        }
    }

    public void trace(Object obj, Throwable th) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.TRACE.getValue()) {
            Log.v(this.tag, obj.toString(), th);
        }
    }

    public void debug(Object obj) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.DEBUG.getValue()) {
            Log.d(this.tag, obj.toString());
        }
    }

    public void debug(Object obj, Throwable th) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.DEBUG.getValue()) {
            Log.d(this.tag, obj.toString(), th);
        }
    }

    public void info(Object obj) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.INFO.getValue()) {
            Log.i(this.tag, obj.toString());
        }
    }

    public void info(Object obj, Throwable th) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.INFO.getValue()) {
            Log.i(this.tag, obj.toString(), th);
        }
    }

    public void warn(Object obj) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.WARN.getValue()) {
            Log.w(this.tag, obj.toString());
        }
    }

    public void warn(Object obj, Throwable th) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.WARN.getValue()) {
            Log.w(this.tag, obj.toString(), th);
        }
    }

    public void error(Object obj) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.ERROR.getValue()) {
            Log.e(this.tag, obj.toString());
        }
    }

    public void error(Object obj, Throwable th) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.ERROR.getValue()) {
            Log.e(this.tag, obj.toString(), th);
        }
    }

    public void setLevel(LogFactory.Level level2) {
        this.level = level2;
    }

    private LogFactory.Level getLevel() {
        LogFactory.Level level2 = this.level;
        if (level2 != null) {
            return level2;
        }
        return LogFactory.getLevel();
    }
}
