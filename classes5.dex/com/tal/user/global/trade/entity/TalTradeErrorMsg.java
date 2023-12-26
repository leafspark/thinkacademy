package com.tal.user.global.trade.entity;

import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\b\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/tal/user/global/trade/entity/TalTradeErrorMsg;", "", "code", "", "msg", "isBusinessError", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "", "(ILjava/lang/String;Z)V", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "()Z", "setBusinessError", "(Z)V", "getMsg", "setMsg", "toString", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalTradeErrorMsg.kt */
public final class TalTradeErrorMsg {
    private String code;
    private boolean isBusinessError;
    private String msg = "";

    public final String getCode() {
        return this.code;
    }

    public final void setCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.code = str;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setMsg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.msg = str;
    }

    public final boolean isBusinessError() {
        return this.isBusinessError;
    }

    public final void setBusinessError(boolean z) {
        this.isBusinessError = z;
    }

    public TalTradeErrorMsg(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
        this.code = str;
        if (str2 != null) {
            this.msg = str2;
        } else {
            this.msg = "";
        }
        this.isBusinessError = z;
    }

    public TalTradeErrorMsg(int i, String str, boolean z) {
        this.code = String.valueOf(i) + "";
        if (str != null) {
            this.msg = str;
        } else {
            this.msg = "";
        }
        this.isBusinessError = z;
    }

    public String toString() {
        return "TalTradeErrorMsg{code=" + this.code + ", msg='" + this.msg + '\'' + ", isBusinessError=" + this.isBusinessError + '}';
    }
}
