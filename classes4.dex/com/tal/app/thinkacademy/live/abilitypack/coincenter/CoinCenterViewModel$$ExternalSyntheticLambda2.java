package com.tal.app.thinkacademy.live.abilitypack.coincenter;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;

public final /* synthetic */ class CoinCenterViewModel$$ExternalSyntheticLambda2 implements Observer {
    public final /* synthetic */ CoinCenterViewModel f$0;

    public /* synthetic */ CoinCenterViewModel$$ExternalSyntheticLambda2(CoinCenterViewModel coinCenterViewModel) {
        this.f$0 = coinCenterViewModel;
    }

    public final void onChanged(Object obj) {
        CoinCenterViewModel.m137observerUserCoins$lambda0(this.f$0, (PluginEventData) obj);
    }
}
