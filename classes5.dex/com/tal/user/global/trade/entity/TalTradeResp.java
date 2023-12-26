package com.tal.user.global.trade.entity;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/tal/user/global/trade/entity/TalTradeResp;", "", "()V", "StringResp", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalTradeResp.kt */
public final class TalTradeResp {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0019\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/tal/user/global/trade/entity/TalTradeResp$StringResp;", "", "()V", "result", "", "modify_time", "", "(Ljava/lang/String;J)V", "getModify_time", "()J", "setModify_time", "(J)V", "getResult", "()Ljava/lang/String;", "setResult", "(Ljava/lang/String;)V", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TalTradeResp.kt */
    public static final class StringResp {
        private long modify_time;
        private String result;

        public final String getResult() {
            return this.result;
        }

        public final void setResult(String str) {
            this.result = str;
        }

        public final long getModify_time() {
            return this.modify_time;
        }

        public final void setModify_time(long j) {
            this.modify_time = j;
        }

        public StringResp() {
        }

        public StringResp(String str, long j) {
            this.result = str;
            this.modify_time = j;
        }
    }
}
