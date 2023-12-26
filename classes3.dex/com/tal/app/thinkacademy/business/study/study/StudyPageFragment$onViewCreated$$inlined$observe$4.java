package com.tal.app.thinkacademy.business.study.study;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.business.study.study.StudyPageFragment;
import com.tal.app.thinkacademy.business.study.study.utils.LoginIn;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.browser.helper.XesWebViewCookieUtils;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 6, 0})
/* compiled from: LiveData.kt */
public final class StudyPageFragment$onViewCreated$$inlined$observe$4<T> implements Observer<T> {
    final /* synthetic */ StudyPageFragment this$0;

    public StudyPageFragment$onViewCreated$$inlined$observe$4(StudyPageFragment studyPageFragment) {
        this.this$0 = studyPageFragment;
    }

    public final void onChanged(T t) {
        StateData stateData = (StateData) t;
        this.this$0.hideLoading();
        if (StudyPageFragment.WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] != 1) {
            ToastUtils.setGravity(17, 0, 0);
            ToastUtils.showShort(this.this$0.getString(R.string.failed_to_switch), new Object[0]);
        } else if (stateData.getData() == null) {
            ToastUtils.setGravity(17, 0, 0);
            ToastUtils.showShort(this.this$0.getString(R.string.failed_to_switch), new Object[0]);
        } else {
            ShareDataManager.getInstance().remove(ShareDataManager.SHAREDATA_NOT_CLEAR, new String[]{"user_uid"});
            ShareDataManager.getInstance().clearUser_sharedata();
            UserInfoBll.Companion.getInstance().clearUserInfo();
            XesWebViewCookieUtils.clearCookies();
            UserBean userBean = (UserBean) stateData.getData();
            ShareDataManager.getInstance().initUserSP(String.valueOf(userBean == null ? null : userBean.getUid()));
            Context access$getmActivity = this.this$0.getmActivity();
            Intrinsics.checkNotNullExpressionValue(access$getmActivity, "getmActivity()");
            LoginIn.INSTANCE.loginInfo((UserBean) stateData.getData(), false, access$getmActivity, 1);
            XesDataBus.with("user_center_login_bus").setStickyData("switchLogin");
            XesDataBus.with("user_switch_login_success").setStickyData(true);
            LiveCoursesFragment access$getMLiveCoursesFragment$p = this.this$0.mLiveCoursesFragment;
            if (access$getMLiveCoursesFragment$p != null) {
                access$getMLiveCoursesFragment$p.requestDataLoading();
            }
            RecordedCoursesFragment access$getMRecordedCoursesFragment$p = this.this$0.mRecordedCoursesFragment;
            if (access$getMRecordedCoursesFragment$p != null) {
                access$getMRecordedCoursesFragment$p.requestDataLoading();
            }
        }
    }
}
