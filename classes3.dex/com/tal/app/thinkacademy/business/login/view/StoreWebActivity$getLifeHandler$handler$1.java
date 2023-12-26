package com.tal.app.thinkacademy.business.login.view;

import com.tal.app.thinkacademy.common.business.browser.handler.WebViewLifeHandler;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/business/login/view/StoreWebActivity$getLifeHandler$handler$1", "Lcom/tal/app/thinkacademy/common/business/browser/handler/WebViewLifeHandler;", "onPageStart", "", "url", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StoreWebActivity.kt */
public final class StoreWebActivity$getLifeHandler$handler$1 extends WebViewLifeHandler {
    final /* synthetic */ StoreWebActivity this$0;

    StoreWebActivity$getLifeHandler$handler$1(StoreWebActivity storeWebActivity) {
        this.this$0 = storeWebActivity;
    }

    public void onPageStart(String str) {
        StoreWebActivity$getLifeHandler$handler$1.super.onPageStart(str);
        this.this$0.toggleack(str);
    }
}
