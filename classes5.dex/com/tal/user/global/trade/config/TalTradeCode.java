package com.tal.user.global.trade.config;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/tal/user/global/trade/config/TalTradeCode;", "", "()V", "ErrorCode", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalTradeCode.kt */
public final class TalTradeCode {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/tal/user/global/trade/config/TalTradeCode$ErrorCode;", "", "()V", "DATA_JSON_ERROR", "", "ORDER_ERROR", "OTHER_ERROR", "UNINIT", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TalTradeCode.kt */
    public static final class ErrorCode {
        public static final int DATA_JSON_ERROR = 13202;
        public static final ErrorCode INSTANCE = new ErrorCode();
        public static final int ORDER_ERROR = 13201;
        public static final int OTHER_ERROR = 13240;
        public static final int UNINIT = 13200;

        private ErrorCode() {
        }
    }
}
