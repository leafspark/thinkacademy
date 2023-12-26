package com.tal.user.global.trade.api;

import android.net.ConnectivityManager;
import android.net.Network;
import com.tal.user.global.trade.util.TalTradeLoggerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/tal/user/global/trade/api/TalTradeSdk$registerNetworkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "onAvailable", "", "network", "Landroid/net/Network;", "onLost", "onUnavailable", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalTradeSdk.kt */
public final class TalTradeSdk$registerNetworkCallback$1 extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ TalTradeSdk this$0;

    TalTradeSdk$registerNetworkCallback$1(TalTradeSdk talTradeSdk) {
        this.this$0 = talTradeSdk;
    }

    public void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        super.onAvailable(network);
        TalTradeLoggerFactory.getLogger().i("network available");
        this.this$0.isNetAvailable = true;
    }

    public void onUnavailable() {
        super.onUnavailable();
        TalTradeLoggerFactory.getLogger().i("network unavailable");
        this.this$0.isNetAvailable = false;
    }

    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        super.onLost(network);
        TalTradeLoggerFactory.getLogger().i("network lost");
        this.this$0.isNetAvailable = false;
    }
}
