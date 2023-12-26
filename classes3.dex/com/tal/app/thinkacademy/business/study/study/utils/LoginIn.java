package com.tal.app.thinkacademy.business.study.study.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.courseware.ImCousesWare;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J(\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/utils/LoginIn;", "", "()V", "configInfo", "", "getConfigInfo", "()Lkotlin/Unit;", "changeUserInfo", "myUserBean", "Lcom/tal/app/thinkacademy/common/user/UserBean;", "loginInfo", "isNormal", "", "context", "Landroid/content/Context;", "mGuestType", "", "needLoginConfigInfo", "sendLoginAction", "startLoginUI", "Landroid/app/Activity;", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "废弃")
/* compiled from: LoginIn.kt */
public final class LoginIn {
    public static final LoginIn INSTANCE = new LoginIn();

    private final void needLoginConfigInfo() {
    }

    private LoginIn() {
    }

    public final void loginInfo(UserBean userBean, boolean z, Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (userBean != null) {
            changeUserInfo(userBean);
            if (z) {
                startLoginUI((Activity) context, i);
            }
        }
        if (!TextUtils.isEmpty(ShareDataManager.getInstance().getString("unified_Access_Token", "", ShareDataManager.SHAREDATA_USER))) {
            getConfigInfo();
            if (z) {
                needLoginConfigInfo();
            }
        }
    }

    private final void changeUserInfo(UserBean userBean) {
        if (userBean != null) {
            UserInfoBll.Companion.getInstance().saveUserInfo(userBean);
        }
    }

    private final Unit getConfigInfo() {
        ImConfig.INSTANCE.getConfigInfo();
        return Unit.INSTANCE;
    }

    private final void startLoginUI(Activity activity, int i) {
        if (!TextUtils.isEmpty(ShareDataManager.getInstance().getString("unified_Access_Token", "", ShareDataManager.SHAREDATA_USER))) {
            if (UserInfoBll.Companion.getInstance().isLoginFromYouke(i)) {
                ImCousesWare.INSTANCE.getCourseWarePreList();
                activity.setResult(-1);
                activity.finish();
            } else {
                Bundle bundle = new Bundle();
                bundle.putBoolean("login", true);
                XesRoute.getInstance().navigation("/home/home_fragment", bundle, 32768);
                activity.finish();
            }
        }
        XesDataBus.with("user_center_login_bus").setStickyData("LoginIn");
        sendLoginAction(activity);
    }

    public final void sendLoginAction(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.setAction("xes_app_login");
        context.sendBroadcast(intent);
        XesLog.et("broadcast", new Object[]{"xes_app_login"});
    }
}
