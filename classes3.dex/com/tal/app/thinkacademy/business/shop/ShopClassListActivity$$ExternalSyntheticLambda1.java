package com.tal.app.thinkacademy.business.shop;

import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.common.entity.StateData;

public final /* synthetic */ class ShopClassListActivity$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ ShopClassListActivity f$0;

    public /* synthetic */ ShopClassListActivity$$ExternalSyntheticLambda1(ShopClassListActivity shopClassListActivity) {
        this.f$0 = shopClassListActivity;
    }

    public final void onChanged(Object obj) {
        ShopClassListActivity.m189startObserve$lambda8(this.f$0, (StateData) obj);
    }
}
