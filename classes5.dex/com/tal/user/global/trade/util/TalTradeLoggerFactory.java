package com.tal.user.global.trade.util;

import android.text.TextUtils;
import com.tal.user.global.trade.api.TalTradeSdk;
import java.util.HashMap;

public class TalTradeLoggerFactory {
    private static HashMap<String, TalTradeLogger> mMap = new HashMap<>();

    public static TalTradeLogger getLogger(String str) {
        if (TextUtils.isEmpty(str)) {
            str = TalTradeSdk.TAG;
        }
        if (mMap.get(str) == null) {
            mMap.put(str, new TalTradeLogger(str, TalTradeSdk.getInstance().getConfig().isLog()));
        }
        return mMap.get(str);
    }

    public static TalTradeLogger getLogger() {
        return getLogger("");
    }
}
