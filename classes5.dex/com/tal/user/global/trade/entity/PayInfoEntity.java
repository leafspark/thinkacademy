package com.tal.user.global.trade.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/tal/user/global/trade/entity/PayInfoEntity;", "", "()V", "merchantOrderNo", "", "getMerchantOrderNo", "()Ljava/lang/String;", "setMerchantOrderNo", "(Ljava/lang/String;)V", "payData", "getPayData", "setPayData", "payOrderNo", "getPayOrderNo", "setPayOrderNo", "payTradeNo", "getPayTradeNo", "setPayTradeNo", "status", "", "getStatus", "()I", "setStatus", "(I)V", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: PayInfoEntity.kt */
public final class PayInfoEntity {
    private String merchantOrderNo = "";
    private String payData = "";
    private String payOrderNo = "";
    private String payTradeNo = "";
    private int status;

    public final String getMerchantOrderNo() {
        return this.merchantOrderNo;
    }

    public final void setMerchantOrderNo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.merchantOrderNo = str;
    }

    public final String getPayData() {
        return this.payData;
    }

    public final void setPayData(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.payData = str;
    }

    public final String getPayOrderNo() {
        return this.payOrderNo;
    }

    public final void setPayOrderNo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.payOrderNo = str;
    }

    public final String getPayTradeNo() {
        return this.payTradeNo;
    }

    public final void setPayTradeNo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.payTradeNo = str;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }
}
