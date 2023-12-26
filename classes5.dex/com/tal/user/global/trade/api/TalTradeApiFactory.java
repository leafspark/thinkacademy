package com.tal.user.global.trade.api;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/tal/user/global/trade/api/TalTradeApiFactory;", "", "()V", "talTradeApi", "Lcom/tal/user/global/trade/api/ITalTradeApi;", "getTalTradeApi", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalTradeApiFactory.kt */
public final class TalTradeApiFactory {
    public static final TalTradeApiFactory INSTANCE = new TalTradeApiFactory();
    private static ITalTradeApi talTradeApi;

    private TalTradeApiFactory() {
    }

    public final ITalTradeApi getTalTradeApi() {
        if (talTradeApi == null) {
            talTradeApi = new TalTradeApi();
        }
        return talTradeApi;
    }
}
