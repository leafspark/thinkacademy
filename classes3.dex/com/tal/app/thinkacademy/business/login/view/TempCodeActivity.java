package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.common.business.browser.view.BrowserActivity;
import com.tal.app.thinkacademy.common.util.ClipboardUtils;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/TempCodeActivity;", "Lcom/tal/app/thinkacademy/common/business/browser/view/BrowserActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TempCodeActivity.kt */
public final class TempCodeActivity extends BrowserActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        TempCodeActivity.super.onCreate(bundle);
        Context context = (Context) this;
        getTitleBar().setBackgroundColor(ContextCompat.getColor(context, R.color.color_f4f6fa));
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, ContextCompat.getColor(context, R.color.color_f4f6fa), false);
        ClipboardUtils.clearClipboardContent(context);
    }
}
