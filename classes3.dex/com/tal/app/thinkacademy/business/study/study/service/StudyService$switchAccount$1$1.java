package com.tal.app.thinkacademy.business.study.study.service;

import com.tal.app.thinkacademy.business.study.study.Tag;
import com.tal.app.thinkacademy.business.study.study.utils.LoginIn;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.base.XesBaseActivity;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.browser.helper.XesWebViewCookieUtils;
import com.tal.app.thinkacademy.common.flutter.EventToFlutter;
import com.tal.app.thinkacademy.common.flutter.HwFlutterUtil;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/business/study/study/service/StudyService$switchAccount$1$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/common/user/UserBean;", "onSuccess", "", "t", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudyService.kt */
public final class StudyService$switchAccount$1$1 extends OmyCallback<HiResponse<UserBean>> {
    final /* synthetic */ XesBaseActivity $currentActivity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StudyService$switchAccount$1$1(XesBaseActivity xesBaseActivity, StudyService$switchAccount$1$2 studyService$switchAccount$1$2) {
        super((IError) studyService$switchAccount$1$2);
        this.$currentActivity = xesBaseActivity;
    }

    public void onSuccess(HiResponse<UserBean> hiResponse) {
        Intrinsics.checkNotNullParameter(hiResponse, "t");
        XesLog.e(Tag.StudyPageFragment, new Object[]{"切换账号成功"});
        this.$currentActivity.hideLoading();
        UserBean userBean = (UserBean) hiResponse.getData();
        if (userBean == null) {
            ToastUtils.setGravity(17, 0, 0);
            ToastUtils.showShort(Utils.getApp().getString(R.string.failed_to_switch), new Object[0]);
            return;
        }
        ShareDataManager.getInstance().remove(ShareDataManager.SHAREDATA_NOT_CLEAR, new String[]{"user_uid"});
        ShareDataManager.getInstance().clearUser_sharedata();
        UserInfoBll.Companion.getInstance().clearUserInfo();
        XesWebViewCookieUtils.clearCookies();
        ShareDataManager.getInstance().initUserSP(String.valueOf(userBean.getUid()));
        LoginIn.INSTANCE.loginInfo(userBean, false, this.$currentActivity, 1);
        XesDataBus.with("user_center_login_bus").setStickyData("switchLogin");
        XesDataBus.with("user_switch_login_success").setStickyData(true);
        HwFlutterUtil.INSTANCE.sendEventToFlutterLogin(EventToFlutter.ACCOUNT_SWITCH_SUCCESS);
    }
}
