package com.tal.user.global.trade.api;

import com.tal.user.global.trade.entity.TalTradeErrorMsg;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0017\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/tal/user/global/trade/api/TalTradeApiCallBack;", "T", "", "()V", "onCancel", "", "cancelMessage", "Lcom/tal/user/global/trade/api/TalTradeApiCancelMessage;", "onError", "errorMsg", "Lcom/tal/user/global/trade/entity/TalTradeErrorMsg;", "onSuccess", "data", "(Ljava/lang/Object;)V", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalTradeApiCallBack.kt */
public abstract class TalTradeApiCallBack<T> {
    public final void onCancel(TalTradeApiCancelMessage talTradeApiCancelMessage) {
    }

    public abstract void onError(TalTradeErrorMsg talTradeErrorMsg);

    public abstract void onSuccess(T t);
}
