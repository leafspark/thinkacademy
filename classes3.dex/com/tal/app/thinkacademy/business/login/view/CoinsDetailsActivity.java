package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.common.business.browser.view.BrowserActivity;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/CoinsDetailsActivity;", "Lcom/tal/app/thinkacademy/common/business/browser/view/BrowserActivity;", "()V", "mOpenApp", "", "finish", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoinsDetailsActivity.kt */
public final class CoinsDetailsActivity extends BrowserActivity {
    private boolean mOpenApp;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        CoinsDetailsActivity.super.onCreate(bundle);
        Context context = (Context) this;
        getTitleBar().setBackgroundColor(ContextCompat.getColor(context, R.color.color_f4f6fa));
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, ContextCompat.getColor(context, R.color.color_f4f6fa), false);
        this.mOpenApp = getIntent().getBooleanExtra("openApp", false);
    }

    public void finish() {
        CoinsDetailsActivity.super.finish();
        if (this.mOpenApp) {
            XesRoute.getInstance().navigation("/home/main_activity");
        }
    }
}
