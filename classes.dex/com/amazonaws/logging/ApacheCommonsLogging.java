package com.amazonaws.logging;

import com.amazonaws.logging.LogFactory;

@Deprecated
public class ApacheCommonsLogging implements Log {
    private LogFactory.Level level = null;
    private Log log;
    private Class logClass;
    private String logString;

    public ApacheCommonsLogging(Class cls) {
        this.logClass = cls;
        this.log = LogFactory.getLog((Class<?>) cls);
    }

    public ApacheCommonsLogging(String str) {
        this.logString = str;
        this.log = LogFactory.getLog(str);
    }

    public boolean isDebugEnabled() {
        return this.log.isDebugEnabled() && (getLevel() == null || getLevel().getValue() <= LogFactory.Level.DEBUG.getValue());
    }

    public boolean isErrorEnabled() {
        return this.log.isErrorEnabled() && (getLevel() == null || getLevel().getValue() <= LogFactory.Level.ERROR.getValue());
    }

    public boolean isInfoEnabled() {
        return this.log.isInfoEnabled() && (getLevel() == null || getLevel().getValue() <= LogFactory.Level.INFO.getValue());
    }

    public boolean isTraceEnabled() {
        return this.log.isTraceEnabled() && (getLevel() == null || getLevel().getValue() <= LogFactory.Level.TRACE.getValue());
    }

    public boolean isWarnEnabled() {
        return this.log.isWarnEnabled() && (getLevel() == null || getLevel().getValue() <= LogFactory.Level.WARN.getValue());
    }

    public void trace(Object obj) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.TRACE.getValue()) {
            this.log.trace(obj);
        }
    }

    public void trace(Object obj, Throwable th) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.TRACE.getValue()) {
            this.log.trace(obj, th);
        }
    }

    public void debug(Object obj) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.DEBUG.getValue()) {
            this.log.debug(obj);
        }
    }

    public void debug(Object obj, Throwable th) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.DEBUG.getValue()) {
            this.log.debug(obj, th);
        }
    }

    public void info(Object obj) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.INFO.getValue()) {
            this.log.info(obj);
        }
    }

    public void info(Object obj, Throwable th) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.INFO.getValue()) {
            this.log.info(obj, th);
        }
    }

    public void warn(Object obj) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.WARN.getValue()) {
            this.log.warn(obj);
        }
    }

    public void warn(Object obj, Throwable th) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.WARN.getValue()) {
            this.log.warn(obj, th);
        }
    }

    public void error(Object obj) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.ERROR.getValue()) {
            this.log.error(obj);
        }
    }

    public void error(Object obj, Throwable th) {
        if (getLevel() == null || getLevel().getValue() <= LogFactory.Level.ERROR.getValue()) {
            this.log.error(obj, th);
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
