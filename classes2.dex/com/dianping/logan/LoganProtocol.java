package com.dianping.logan;

class LoganProtocol implements LoganProtocolHandler {
    private static LoganProtocol sLoganProtocol;
    private LoganProtocolHandler mCurProtocol;
    private boolean mIsInit;
    private OnLoganProtocolStatus mLoganProtocolStatus;

    private LoganProtocol() {
    }

    static LoganProtocol newInstance() {
        if (sLoganProtocol == null) {
            synchronized (LoganProtocol.class) {
                sLoganProtocol = new LoganProtocol();
            }
        }
        return sLoganProtocol;
    }

    public void logan_flush() {
        LoganProtocolHandler loganProtocolHandler = this.mCurProtocol;
        if (loganProtocolHandler != null) {
            loganProtocolHandler.logan_flush();
        }
    }

    public void logan_write(int i, String str, long j, String str2, String str3, String str4, String str5, int i2, long j2, boolean z) {
        LoganProtocolHandler loganProtocolHandler = this.mCurProtocol;
        if (loganProtocolHandler != null) {
            loganProtocolHandler.logan_write(i, str, j, str2, str3, str4, str5, i2, j2, z);
        }
    }

    public void logan_open(String str) {
        LoganProtocolHandler loganProtocolHandler = this.mCurProtocol;
        if (loganProtocolHandler != null) {
            loganProtocolHandler.logan_open(str);
        }
    }

    public void logan_init(String str, String str2, int i, String str3, String str4) {
        if (!this.mIsInit) {
            if (CLoganProtocol.isCloganSuccess()) {
                CLoganProtocol newInstance = CLoganProtocol.newInstance();
                this.mCurProtocol = newInstance;
                newInstance.setOnLoganProtocolStatus(this.mLoganProtocolStatus);
                this.mCurProtocol.logan_init(str, str2, i, str3, str4);
                this.mIsInit = true;
                return;
            }
            this.mCurProtocol = null;
        }
    }

    public void logan_debug(boolean z) {
        LoganProtocolHandler loganProtocolHandler = this.mCurProtocol;
        if (loganProtocolHandler != null) {
            loganProtocolHandler.logan_debug(z);
        }
    }

    public void setOnLoganProtocolStatus(OnLoganProtocolStatus onLoganProtocolStatus) {
        this.mLoganProtocolStatus = onLoganProtocolStatus;
    }

    public String getCurrentFileName() {
        LoganProtocolHandler loganProtocolHandler = this.mCurProtocol;
        if (loganProtocolHandler == null) {
            return null;
        }
        return loganProtocolHandler.getCurrentFileName();
    }
}
