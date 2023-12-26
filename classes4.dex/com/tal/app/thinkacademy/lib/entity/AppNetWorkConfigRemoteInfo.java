package com.tal.app.thinkacademy.lib.entity;

import com.tal.app.thinkacademy.lib.network.utils.NetWorkUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u001a\u0018\u0000 02\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010-\u001a\u00020\u0004J\u0006\u0010.\u001a\u00020\u0004J\u0006\u0010/\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\u0010R\u001a\u0010\"\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u001a\u0010%\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\u000e\u0010(\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015R\u000e\u0010,\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/tal/app/thinkacademy/lib/entity/AppNetWorkConfigRemoteInfo;", "", "()V", "connectTime", "", "defaultIP", "", "getDefaultIP", "()Ljava/lang/String;", "setDefaultIP", "(Ljava/lang/String;)V", "enableBackUpIp", "", "getEnableBackUpIp", "()Z", "setEnableBackUpIp", "(Z)V", "failedCountLimit", "getFailedCountLimit", "()I", "setFailedCountLimit", "(I)V", "failedCountTimeWindow", "", "getFailedCountTimeWindow", "()J", "setFailedCountTimeWindow", "(J)V", "firstuseTimeWindow", "getFirstuseTimeWindow", "setFirstuseTimeWindow", "forceUseIP", "getForceUseIP", "setForceUseIP", "globalTimeout", "getGlobalTimeout", "setGlobalTimeout", "maxBackUpIpTime", "getMaxBackUpIpTime", "setMaxBackUpIpTime", "readTimeout", "retryNum", "getRetryNum", "setRetryNum", "writeTimeout", "getConnectTime", "getReadTimeout", "getWriteTimeout", "Companion", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppNetWorkConfigRemoteInfo.kt */
public final class AppNetWorkConfigRemoteInfo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_TIME_OUT = 200;
    public static final int MIN_TIME_OUT = 10;
    private int connectTime = 10;
    private String defaultIP = "47.102.153.69";
    private boolean enableBackUpIp;
    private int failedCountLimit = 6;
    private long failedCountTimeWindow = 300;
    private long firstuseTimeWindow = 1800;
    private boolean forceUseIP = true;
    private long globalTimeout = 15000;
    private long maxBackUpIpTime = NetWorkUtils.MINUTE;
    private int readTimeout = 10;
    private int retryNum = 3;
    private int writeTimeout = 10;

    public final boolean getForceUseIP() {
        return this.forceUseIP;
    }

    public final void setForceUseIP(boolean z) {
        this.forceUseIP = z;
    }

    public final boolean getEnableBackUpIp() {
        return this.enableBackUpIp;
    }

    public final void setEnableBackUpIp(boolean z) {
        this.enableBackUpIp = z;
    }

    public final int getFailedCountLimit() {
        return this.failedCountLimit;
    }

    public final void setFailedCountLimit(int i) {
        this.failedCountLimit = i;
    }

    public final long getMaxBackUpIpTime() {
        return this.maxBackUpIpTime;
    }

    public final void setMaxBackUpIpTime(long j) {
        this.maxBackUpIpTime = j;
    }

    public final long getFailedCountTimeWindow() {
        return this.failedCountTimeWindow;
    }

    public final void setFailedCountTimeWindow(long j) {
        this.failedCountTimeWindow = j;
    }

    public final long getGlobalTimeout() {
        return this.globalTimeout;
    }

    public final void setGlobalTimeout(long j) {
        this.globalTimeout = j;
    }

    public final long getFirstuseTimeWindow() {
        return this.firstuseTimeWindow;
    }

    public final void setFirstuseTimeWindow(long j) {
        this.firstuseTimeWindow = j;
    }

    public final int getRetryNum() {
        return this.retryNum;
    }

    public final void setRetryNum(int i) {
        this.retryNum = i;
    }

    public final String getDefaultIP() {
        return this.defaultIP;
    }

    public final void setDefaultIP(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.defaultIP = str;
    }

    public final int getConnectTime() {
        int i = this.connectTime;
        boolean z = false;
        if (10 <= i && i < 201) {
            z = true;
        }
        if (z) {
            return i;
        }
        return 10;
    }

    public final int getReadTimeout() {
        int i = this.readTimeout;
        boolean z = false;
        if (10 <= i && i < 201) {
            z = true;
        }
        if (z) {
            return i;
        }
        return 10;
    }

    public final int getWriteTimeout() {
        int i = this.writeTimeout;
        boolean z = false;
        if (10 <= i && i < 201) {
            z = true;
        }
        if (z) {
            return i;
        }
        return 10;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/lib/entity/AppNetWorkConfigRemoteInfo$Companion;", "", "()V", "MAX_TIME_OUT", "", "MIN_TIME_OUT", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AppNetWorkConfigRemoteInfo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
