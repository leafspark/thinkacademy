package com.tal.user.global.trade.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\bR\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/tal/user/global/trade/config/TalTradeSdkConfig;", "", "()V", "<set-?>", "", "businessType", "getBusinessType", "()I", "", "isDebug", "()Z", "isLog", "setBusinessType", "setDebug", "debug", "setLog", "log", "Companion", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalTradeSdkConfig.kt */
public final class TalTradeSdkConfig {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TALTradeSDKCompanyTypeTal = 0;
    public static final int TALTradeSDKCompanyTypeVdyoo = 1;
    private int businessType;
    private boolean isDebug;
    private boolean isLog;

    public final boolean isDebug() {
        return this.isDebug;
    }

    public final boolean isLog() {
        return this.isLog;
    }

    public final int getBusinessType() {
        return this.businessType;
    }

    public final TalTradeSdkConfig setDebug(boolean z) {
        this.isDebug = z;
        return this;
    }

    public final TalTradeSdkConfig setLog(boolean z) {
        this.isLog = z;
        return this;
    }

    public final TalTradeSdkConfig setBusinessType(int i) {
        this.businessType = i;
        return this;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/tal/user/global/trade/config/TalTradeSdkConfig$Companion;", "", "()V", "TALTradeSDKCompanyTypeTal", "", "TALTradeSDKCompanyTypeVdyoo", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TalTradeSdkConfig.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
