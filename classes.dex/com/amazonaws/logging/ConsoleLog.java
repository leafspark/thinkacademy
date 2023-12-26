package com.amazonaws.logging;

import com.amazonaws.logging.LogFactory;

public final class ConsoleLog implements Log {
    private LogFactory.Level level = null;
    private final String tag;

    public ConsoleLog(String str) {
        this.tag = str;
    }

    public boolean isDebugEnabled() {
        return getLevel() == null || getLevel().getValue() <= LogFactory.Level.DEBUG.getValue();
    }

    public boolean isErrorEnabled() {
        return getLevel() == null || getLevel().getValue() <= LogFactory.Level.ERROR.getValue();
    }

    public boolean isInfoEnabled() {
        return getLevel() == null || getLevel().getValue() <= LogFactory.Level.INFO.getValue();
    }

    public boolean isTraceEnabled() {
        return getLevel() == null || getLevel().getValue() <= LogFactory.Level.TRACE.getValue();
    }

    public boolean isWarnEnabled() {
        return getLevel() == null || getLevel().getValue() <= LogFactory.Level.WARN.getValue();
    }

    public void trace(Object obj) {
        if (isTraceEnabled()) {
            log(LogFactory.Level.TRACE, obj, (Throwable) null);
        }
    }

    public void trace(Object obj, Throwable th) {
        if (isTraceEnabled()) {
            log(LogFactory.Level.TRACE, obj, th);
        }
    }

    public void debug(Object obj) {
        if (isDebugEnabled()) {
            log(LogFactory.Level.DEBUG, obj, (Throwable) null);
        }
    }

    public void debug(Object obj, Throwable th) {
        if (isDebugEnabled()) {
            log(LogFactory.Level.DEBUG, obj, th);
        }
    }

    public void info(Object obj) {
        if (isInfoEnabled()) {
            log(LogFactory.Level.INFO, obj, (Throwable) null);
        }
    }

    public void info(Object obj, Throwable th) {
        if (isInfoEnabled()) {
            log(LogFactory.Level.INFO, obj, th);
        }
    }

    public void warn(Object obj) {
        if (isWarnEnabled()) {
            log(LogFactory.Level.WARN, obj, (Throwable) null);
        }
    }

    public void warn(Object obj, Throwable th) {
        if (isWarnEnabled()) {
            log(LogFactory.Level.WARN, obj, th);
        }
    }

    public void error(Object obj) {
        if (isErrorEnabled()) {
            log(LogFactory.Level.ERROR, obj, (Throwable) null);
        }
    }

    public void error(Object obj, Throwable th) {
        if (isErrorEnabled()) {
            log(LogFactory.Level.ERROR, obj, th);
        }
    }

    public void setLevel(LogFactory.Level level2) {
        this.level = level2;
    }

    private void log(LogFactory.Level level2, Object obj, Throwable th) {
        System.out.printf("%s/%s: %s\n", new Object[]{this.tag, level2.name(), obj});
        if (th != null) {
            System.out.println(th.toString());
        }
    }

    private LogFactory.Level getLevel() {
        LogFactory.Level level2 = this.level;
        if (level2 != null) {
            return level2;
        }
        return LogFactory.getLevel();
    }
}
