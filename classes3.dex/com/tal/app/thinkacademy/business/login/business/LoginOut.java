package com.tal.app.thinkacademy.business.login.business;

import android.content.Context;
import android.content.Intent;
import com.tal.app.thinkacademy.business.login.view.OtpLoginActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.browser.helper.XesWebViewCookieUtils;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/business/LoginOut;", "", "()V", "cleanLoginUserInfo", "", "loginOut", "activity", "Landroid/content/Context;", "isNormal", "", "startToLogin", "from", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoginOut.kt */
public final class LoginOut {
    public static final LoginOut INSTANCE = new LoginOut();

    private LoginOut() {
    }

    public final void loginOut(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "activity");
        ShareDataManager.getInstance().remove(ShareDataManager.SHAREDATA_NOT_CLEAR, new String[]{"user_uid"});
        cleanLoginUserInfo();
        UserInfoBll.Companion.getInstance().clearUserInfo();
        XesWebViewCookieUtils.clearCookies();
        XesDataBus.with("user_center_logout_bus").setStickyData("LoginOut");
        HwTrackUtil.INSTANCE.userLogout();
    }

    public final void startToLogin(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "activity");
        context.startActivity(new Intent(context, OtpLoginActivity.class));
    }

    public final void cleanLoginUserInfo() {
        ShareDataManager.getInstance().clearUser_sharedata();
    }
}
