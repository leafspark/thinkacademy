package com.tal.app.thinkacademy.business.study.study.service;

import com.tal.app.thinkacademy.business.study.study.Tag;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.base.XesBaseActivity;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/business/study/study/service/StudyService$switchAccount$1$2", "Lcom/tal/app/thinkacademy/lib/network/exception/IError;", "onError", "", "code", "", "msg", "", "onFail", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudyService.kt */
public final class StudyService$switchAccount$1$2 implements IError {
    final /* synthetic */ XesBaseActivity $currentActivity;

    StudyService$switchAccount$1$2(XesBaseActivity xesBaseActivity) {
        this.$currentActivity = xesBaseActivity;
    }

    public void onFail(int i, String str) {
        XesLog.e(Tag.StudyPageFragment, new Object[]{"切换账号失败"});
        this.$currentActivity.hideLoading();
        ToastUtils.setGravity(17, 0, 0);
        ToastUtils.showShort(Utils.getApp().getString(R.string.failed_to_switch), new Object[0]);
    }

    public void onError(int i, String str) {
        XesLog.e(Tag.StudyPageFragment, new Object[]{"切换账号异常"});
        this.$currentActivity.hideLoading();
        ToastUtils.setGravity(17, 0, 0);
        ToastUtils.showShort(Utils.getApp().getString(R.string.failed_to_switch), new Object[0]);
    }
}
