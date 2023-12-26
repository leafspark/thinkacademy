package com.tal.user.global.trade.util;

import android.text.TextUtils;
import android.util.Log;
import com.tal.user.global.trade.api.TalTradeSdk;
import com.tal.user.global.trade.listener.TalTradeLogListener;

public class TalTradeLogger {
    private boolean isLog;
    private String key;

    public TalTradeLogger(String str, boolean z) {
        this.key = TextUtils.isEmpty(str) ? TalTradeSdk.TAG : str;
        this.isLog = z;
    }

    public void e(Object obj) {
        String obj2 = obj != null ? obj.toString() : "null";
        if (this.isLog) {
            Log.e(this.key, obj2);
        }
        if (TalTradeSdk.getInstance().getTalTradeLogListener() != null) {
            TalTradeLogListener talTradeLogListener = TalTradeSdk.getInstance().getTalTradeLogListener();
            talTradeLogListener.onLogReceive("error:" + obj2);
        }
    }

    public void i(Object obj) {
        String obj2 = obj != null ? obj.toString() : "null";
        if (this.isLog) {
            Log.i(this.key, obj2);
        }
        if (TalTradeSdk.getInstance().getTalTradeLogListener() != null) {
            TalTradeLogListener talTradeLogListener = TalTradeSdk.getInstance().getTalTradeLogListener();
            talTradeLogListener.onLogReceive("info:" + obj2);
        }
    }

    public void d(Object obj) {
        String obj2 = obj != null ? obj.toString() : "null";
        if (this.isLog) {
            Log.d(this.key, obj2);
        }
        if (TalTradeSdk.getInstance().getTalTradeLogListener() != null) {
            TalTradeLogListener talTradeLogListener = TalTradeSdk.getInstance().getTalTradeLogListener();
            talTradeLogListener.onLogReceive("debug:" + obj2);
        }
    }
}
