package com.tal.app.thinkacademy.common.business.browser.view;

import com.tal.app.thinkacademy.common.business.browser.agent.WebAgent;
import com.tal.app.thinkacademy.common.business.browser.view.WebFileSelectModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/common/business/browser/view/BrowserActivity$mWebFileSelectModel$1", "Lcom/tal/app/thinkacademy/common/business/browser/view/WebFileSelectModel$WebFileSelectModelCallBack;", "jsCall", "", "jsStr", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BrowserActivity.kt */
public final class BrowserActivity$mWebFileSelectModel$1 implements WebFileSelectModel.WebFileSelectModelCallBack {
    final /* synthetic */ BrowserActivity this$0;

    BrowserActivity$mWebFileSelectModel$1(BrowserActivity browserActivity) {
        this.this$0 = browserActivity;
    }

    public void jsCall(String str) {
        Intrinsics.checkNotNullParameter(str, "jsStr");
        WebAgent mWebAgent = this.this$0.getMWebAgent();
        if (mWebAgent != null) {
            mWebAgent.jsCallBack("window.clientMessageHandlers", str);
        }
    }
}
