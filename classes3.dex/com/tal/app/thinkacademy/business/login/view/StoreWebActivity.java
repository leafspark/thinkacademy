package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.business.LoginIn;
import com.tal.app.thinkacademy.business.login.widget.JumpToAgreementUtil;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.browser.agent.WebAgent;
import com.tal.app.thinkacademy.common.business.browser.handler.WebViewLifeHandler;
import com.tal.app.thinkacademy.common.business.browser.view.BrowserActivity;
import com.tal.app.thinkacademy.common.network.BaseUrlEx;
import com.tal.app.thinkacademy.common.network.ENVIRONMENTAL;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/StoreWebActivity;", "Lcom/tal/app/thinkacademy/common/business/browser/view/BrowserActivity;", "()V", "PAY_CHECKOUT", "", "getPAY_CHECKOUT", "()Ljava/lang/String;", "storeBackBtn", "Landroid/widget/TextView;", "getLifeHandler", "", "Lcom/tal/app/thinkacademy/common/business/browser/handler/WebViewLifeHandler;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "switchAccount", "json", "toggleack", "url", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StoreWebActivity.kt */
public final class StoreWebActivity extends BrowserActivity {
    private TextView storeBackBtn;

    private final String getPAY_CHECKOUT() {
        return ENVIRONMENTAL.ONLINE == BaseUrlEx.Companion.getEnvironment() ? "checkout.thethinkacademy.com" : "checkout-dev.thethinkacademy.com";
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        StoreWebActivity.super.onCreate(bundle);
        Context context = (Context) this;
        getTitleBar().setBackgroundColor(ContextCompat.getColor(context, R.color.color_f4f6fa));
        boolean z = true;
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, ContextCompat.getColor(context, R.color.color_f4f6fa), false);
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        XesDataBus.with("store_js_jump_my_orders").observe(lifecycleOwner, new StoreWebActivity$$ExternalSyntheticLambda3(this));
        XesDataBus.with("store_js_switch_account").observe(lifecycleOwner, new StoreWebActivity$$ExternalSyntheticLambda2(this));
        XesDataBus.with("user_center_login_bus").observe(lifecycleOwner, new StoreWebActivity$$ExternalSyntheticLambda1(this));
        String stringExtra = getIntent().getStringExtra("jump_key");
        String stringExtra2 = getIntent().getStringExtra("title");
        boolean booleanExtra = getIntent().getBooleanExtra("closeEnabled", false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("showTitle", false);
        XesLog.dt("app-pay-StoreWebActivity", new Object[]{Intrinsics.stringPlus("url = ", stringExtra)});
        if (booleanExtra2) {
            getTitleBar().setVisibility(0);
        }
        if (stringExtra2 != null) {
            getTitleBar().setTitle(stringExtra2);
        }
        if (!booleanExtra2 && !booleanExtra) {
            CharSequence charSequence = stringExtra2;
            if (!(charSequence == null || charSequence.length() == 0)) {
                z = false;
            }
            if (z) {
                return;
            }
        }
        getTitleBar().setVisibility(0);
        getTitleBar().setLeftIcon(R.drawable.bar_icon_close_black);
        getTitleBar().setOnTitleBarListener(new StoreWebActivity$onCreate$5(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m134onCreate$lambda0(StoreWebActivity storeWebActivity, String str) {
        Intrinsics.checkNotNullParameter(storeWebActivity, "this$0");
        JumpToAgreementUtil.jump2H5$default(JumpToAgreementUtil.INSTANCE, JumpToAgreementUtil.MENU_ORDERS_NEW, (Context) null, 2, (Object) null);
        storeWebActivity.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m135onCreate$lambda1(StoreWebActivity storeWebActivity, String str) {
        Intrinsics.checkNotNullParameter(storeWebActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(str, "it");
        storeWebActivity.switchAccount(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m136onCreate$lambda2(StoreWebActivity storeWebActivity, String str) {
        Intrinsics.checkNotNullParameter(storeWebActivity, "this$0");
        if (!Intrinsics.areEqual((Object) "h5", (Object) str)) {
            String stringExtra = storeWebActivity.getIntent().getStringExtra("jump_key");
            WebAgent mWebAgent = storeWebActivity.getMWebAgent();
            if (mWebAgent != null) {
                mWebAgent.loadUrl(stringExtra);
            }
        }
    }

    private final void switchAccount(String str) {
        UserBean userBean = (UserBean) GsonUtils.fromJson(str, UserBean.class);
        if (userBean != null) {
            ShareDataManager.getInstance().remove(ShareDataManager.SHAREDATA_NOT_CLEAR, new String[]{"user_uid"});
            ShareDataManager.getInstance().clearUser_sharedata();
            UserInfoBll.Companion.getInstance().clearUserInfo();
            ShareDataManager.getInstance().initUserSP(String.valueOf(userBean.getUid()));
            LoginIn.INSTANCE.loginInfo(userBean, false, (Context) this, 1);
            XesDataBus.with("user_center_login_bus").setStickyData("h5");
            XesLog.dt("==store==", new Object[]{Intrinsics.stringPlus("switchAccount ", str)});
        }
    }

    public List<WebViewLifeHandler> getLifeHandler() {
        return CollectionsKt.arrayListOf(new StoreWebActivity$getLifeHandler$handler$1(this));
    }

    /* access modifiers changed from: private */
    public final void toggleack(String str) {
        Boolean bool;
        XesLog.dt("==store==", new Object[]{Intrinsics.stringPlus("拦截url==> ", str)});
        if (str == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(StringsKt.contains$default(str, getPAY_CHECKOUT(), false, 2, (Object) null));
        }
        if (Intrinsics.areEqual((Object) bool, (Object) true)) {
            XesLog.dt("==store==", new Object[]{Intrinsics.stringPlus("isCheckout =>> ", bool)});
            if (this.storeBackBtn == null) {
                TextView textView = new TextView((Context) this);
                this.storeBackBtn = textView;
                textView.setBackgroundResource(R.drawable.bar_icon_back_white);
                FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fl_activity_browser_main);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 8388611;
                layoutParams.leftMargin = SizeUtils.dp2px(10.0f);
                layoutParams.topMargin = SizeUtils.dp2px(10.0f);
                TextView textView2 = this.storeBackBtn;
                if (textView2 != null) {
                    textView2.setGravity(17);
                }
                frameLayout.addView(this.storeBackBtn, layoutParams);
                TextView textView3 = this.storeBackBtn;
                if (textView3 != null) {
                    textView3.setOnClickListener(new StoreWebActivity$$ExternalSyntheticLambda0(this));
                }
            }
        } else if (this.storeBackBtn != null) {
            ((FrameLayout) findViewById(R.id.fl_activity_browser_main)).removeViewInLayout(this.storeBackBtn);
            this.storeBackBtn = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: toggleack$lambda-6  reason: not valid java name */
    public static final void m137toggleack$lambda6(StoreWebActivity storeWebActivity, View view) {
        Intrinsics.checkNotNullParameter(storeWebActivity, "this$0");
        WebAgent mWebAgent = storeWebActivity.getMWebAgent();
        if (mWebAgent != null && mWebAgent.canGoBack()) {
            mWebAgent.goBack();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
