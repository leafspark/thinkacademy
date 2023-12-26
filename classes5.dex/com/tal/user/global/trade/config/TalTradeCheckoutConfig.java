package com.tal.user.global.trade.config;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/tal/user/global/trade/config/TalTradeCheckoutConfig;", "", "()V", "btnRadiusDp", "", "getBtnRadiusDp", "()I", "setBtnRadiusDp", "(I)V", "primaryColor", "", "getPrimaryColor", "()Ljava/lang/String;", "setPrimaryColor", "(Ljava/lang/String;)V", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalTradeCheckoutConfig.kt */
public final class TalTradeCheckoutConfig {
    private int btnRadiusDp;
    private String primaryColor = "#FFE02727";

    public final String getPrimaryColor() {
        return this.primaryColor;
    }

    public final void setPrimaryColor(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.primaryColor = str;
    }

    public final int getBtnRadiusDp() {
        return this.btnRadiusDp;
    }

    public final void setBtnRadiusDp(int i) {
        this.btnRadiusDp = i;
    }
}
