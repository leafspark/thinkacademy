package com.tal.app.thinkacademy.common.business.browser.view;

import android.view.View;
import com.tal.app.thinkacademy.common.business.browser.agent.WebAgent;
import com.tal.app.thinkacademy.lib.commui.widget.bar.OnTitleBarListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/common/business/browser/view/BrowserActivity$onCreate$1", "Lcom/tal/app/thinkacademy/lib/commui/widget/bar/OnTitleBarListener;", "onLeftClick", "", "v", "Landroid/view/View;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BrowserActivity.kt */
public final class BrowserActivity$onCreate$1 extends OnTitleBarListener {
    final /* synthetic */ BrowserActivity this$0;

    BrowserActivity$onCreate$1(BrowserActivity browserActivity) {
        this.this$0 = browserActivity;
    }

    public void onLeftClick(View view) {
        WebAgent mWebAgent = this.this$0.getMWebAgent();
        Intrinsics.checkNotNull(mWebAgent);
        if (mWebAgent.canGoBack()) {
            WebAgent mWebAgent2 = this.this$0.getMWebAgent();
            if (mWebAgent2 != null) {
                mWebAgent2.goBack();
                return;
            }
            return;
        }
        this.this$0.finish();
    }
}
