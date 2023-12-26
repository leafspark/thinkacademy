package com.tal.user.global.trade.listener;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&¨\u0006\u0007"}, d2 = {"Lcom/tal/user/global/trade/listener/TalTradeWebviewListener;", "", "()V", "webviewPaSuccess", "", "webviewPageError", "webviewPayBack", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalTradeWebviewListener.kt */
public abstract class TalTradeWebviewListener {
    public abstract void webviewPaSuccess();

    public abstract void webviewPageError();

    public abstract void webviewPayBack();
}
