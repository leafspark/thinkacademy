package com.dianping.logan;

import com.dianping.logan.ConstantCode;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class CLoganProtocol implements LoganProtocolHandler {
    private static final String LIBRARY_NAME = "logan";
    private static CLoganProtocol sCLoganProtocol;
    private static boolean sIsCloganOk;
    private Set<Integer> mArraySet = Collections.synchronizedSet(new HashSet());
    private String mCurrentFile;
    private boolean mIsLoganInit;
    private boolean mIsLoganOpen;
    private OnLoganProtocolStatus mLoganProtocolStatus;

    private native void clogan_debug(boolean z);

    private native void clogan_flush();

    private native int clogan_init(String str, String str2, int i, String str3, String str4);

    private native int clogan_open(String str);

    private native int clogan_write(int i, String str, long j, String str2, String str3, String str4, String str5, int i2, long j2, int i3);

    CLoganProtocol() {
    }

    static {
        try {
            System.loadLibrary(LIBRARY_NAME);
            sIsCloganOk = true;
        } catch (Throwable th) {
            th.printStackTrace();
            sIsCloganOk = false;
        }
    }

    static boolean isCloganSuccess() {
        return sIsCloganOk;
    }

    static CLoganProtocol newInstance() {
        if (sCLoganProtocol == null) {
            synchronized (CLoganProtocol.class) {
                if (sCLoganProtocol == null) {
                    sCLoganProtocol = new CLoganProtocol();
                }
            }
        }
        return sCLoganProtocol;
    }

    public void logan_init(String str, String str2, int i, String str3, String str4) {
        if (!this.mIsLoganInit) {
            if (!sIsCloganOk) {
                loganStatusCode(ConstantCode.CloganStatus.CLOGAN_LOAD_SO, ConstantCode.CloganStatus.CLOGAN_LOAD_SO_FAIL);
                return;
            }
            try {
                int clogan_init = clogan_init(str, str2, i, str3, str4);
                this.mIsLoganInit = true;
                loganStatusCode(ConstantCode.CloganStatus.CLGOAN_INIT_STATUS, clogan_init);
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
                loganStatusCode(ConstantCode.CloganStatus.CLGOAN_INIT_STATUS, ConstantCode.CloganStatus.CLOGAN_INIT_FAIL_JNI);
            }
        }
    }

    public void logan_debug(boolean z) {
        if (this.mIsLoganInit && sIsCloganOk) {
            try {
                clogan_debug(z);
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        }
    }

    public void setOnLoganProtocolStatus(OnLoganProtocolStatus onLoganProtocolStatus) {
        this.mLoganProtocolStatus = onLoganProtocolStatus;
    }

    public String getCurrentFileName() {
        return this.mCurrentFile;
    }

    public void logan_open(String str) {
        if (this.mIsLoganInit && sIsCloganOk) {
            try {
                this.mCurrentFile = str;
                int clogan_open = clogan_open(str);
                this.mIsLoganOpen = true;
                loganStatusCode(ConstantCode.CloganStatus.CLOGAN_OPEN_STATUS, clogan_open);
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
                loganStatusCode(ConstantCode.CloganStatus.CLOGAN_OPEN_STATUS, ConstantCode.CloganStatus.CLOGAN_OPEN_FAIL_JNI);
            }
        }
    }

    public void logan_flush() {
        if (this.mIsLoganOpen && sIsCloganOk) {
            try {
                clogan_flush();
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        }
    }

    public void logan_write(int i, String str, long j, String str2, String str3, String str4, String str5, int i2, long j2, boolean z) {
        if (this.mIsLoganOpen && sIsCloganOk) {
            try {
                int clogan_write = clogan_write(i, str, j, str2, str3, str4, str5, i2, j2, z ? 1 : 0);
                if (clogan_write != -4010 || Logan.sDebug) {
                    loganStatusCode(ConstantCode.CloganStatus.CLOGAN_WRITE_STATUS, clogan_write);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
                loganStatusCode(ConstantCode.CloganStatus.CLOGAN_WRITE_STATUS, ConstantCode.CloganStatus.CLOGAN_WRITE_FAIL_JNI);
            }
        }
    }

    private void loganStatusCode(String str, int i) {
        if (i < 0) {
            if (ConstantCode.CloganStatus.CLOGAN_WRITE_STATUS.endsWith(str) && i != -4060) {
                if (!this.mArraySet.contains(Integer.valueOf(i))) {
                    this.mArraySet.add(Integer.valueOf(i));
                } else {
                    return;
                }
            }
            OnLoganProtocolStatus onLoganProtocolStatus = this.mLoganProtocolStatus;
            if (onLoganProtocolStatus != null) {
                onLoganProtocolStatus.loganProtocolStatus(str, i);
            }
        }
    }
}
