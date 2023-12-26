package com.tal.app.thinkacademy.live.business.exercise;

import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.business.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/live/business/exercise/ExercisePluginDriver$getResultCoins$2", "Lcom/tal/app/thinkacademy/lib/network/exception/IError;", "onError", "", "code", "", "msg", "", "onFail", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExercisePluginDriver.kt */
public final class ExercisePluginDriver$getResultCoins$2 implements IError {
    final /* synthetic */ ExercisePluginDriver this$0;

    ExercisePluginDriver$getResultCoins$2(ExercisePluginDriver exercisePluginDriver) {
        this.this$0 = exercisePluginDriver;
    }

    public void onFail(int i, String str) {
        ToastUtils.showShort(R.string.net_fail);
        ExercisePluginDriver exercisePluginDriver = this.this$0;
        exercisePluginDriver.track_exercise(LeanplumUtil.click_fill_blank_fail, exercisePluginDriver.mInteractId);
        this.this$0.removePlugin(5000);
        this.this$0.trackInteractiveLog("FillBlank", "submit", 0, "");
        XesLog.e(this.this$0.TAG, "interact+exercise---> getResultCoins onFail " + i + ' ' + str);
    }

    public void onError(int i, String str) {
        ExercisePluginDriver exercisePluginDriver = this.this$0;
        exercisePluginDriver.track_exercise(LeanplumUtil.click_fill_blank_fail, exercisePluginDriver.mInteractId);
        this.this$0.removePlugin(5000);
        this.this$0.trackInteractiveLog("FillBlank", "submit", 0, "");
        XesLog.e(this.this$0.TAG, "interact+exercise---> getResultCoins onError " + i + ' ' + str);
    }
}
