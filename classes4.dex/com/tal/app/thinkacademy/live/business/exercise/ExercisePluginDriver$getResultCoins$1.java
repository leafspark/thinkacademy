package com.tal.app.thinkacademy.live.business.exercise;

import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.topic.bean.AnswerBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/business/exercise/ExercisePluginDriver$getResultCoins$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/topic/bean/AnswerBean;", "onSuccess", "", "t", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExercisePluginDriver.kt */
public final class ExercisePluginDriver$getResultCoins$1 extends OmyCallback<HiResponse<AnswerBean>> {
    final /* synthetic */ int $result;
    final /* synthetic */ ExercisePluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExercisePluginDriver$getResultCoins$1(int i, ExercisePluginDriver exercisePluginDriver, ExercisePluginDriver$getResultCoins$2 exercisePluginDriver$getResultCoins$2) {
        super(exercisePluginDriver$getResultCoins$2);
        this.$result = i;
        this.this$0 = exercisePluginDriver;
    }

    public void onSuccess(HiResponse<AnswerBean> hiResponse) {
        Intrinsics.checkNotNullParameter(hiResponse, "t");
        AnswerBean data = hiResponse.getData();
        if (data != null) {
            int i = this.$result;
            ExercisePluginDriver exercisePluginDriver = this.this$0;
            if (i != 3) {
                exercisePluginDriver.updateUserLevel(data.getLevel());
                ExercisePluginView access$getMExercisePluginView$p = exercisePluginDriver.mExercisePluginView;
                if (access$getMExercisePluginView$p != null) {
                    access$getMExercisePluginView$p.showCoinsView(Integer.valueOf(data.getRightCoin()));
                }
                ExercisePluginView access$getMExercisePluginView$p2 = exercisePluginDriver.mExercisePluginView;
                if (access$getMExercisePluginView$p2 != null) {
                    access$getMExercisePluginView$p2.drawResultView(data, Integer.valueOf(i));
                }
                exercisePluginDriver.mLiveRoomProvider.getDataStorage().getUserInfo().setGoldNum(data.getUserLatestCoin());
                XesLog.i(exercisePluginDriver.TAG, Intrinsics.stringPlus("interact+exercise---> 请求接口拿到答题赢得的金币数", data));
                exercisePluginDriver.track_exercise(LeanplumUtil.click_fill_blank_succ, exercisePluginDriver.mInteractId);
            } else {
                ExercisePluginView access$getMExercisePluginView$p3 = exercisePluginDriver.mExercisePluginView;
                if (access$getMExercisePluginView$p3 != null) {
                    access$getMExercisePluginView$p3.drawResultView(data, Integer.valueOf(i));
                }
                XesLog.i(exercisePluginDriver.TAG, "interact+exercise---> getResultCoins 渲染未作答");
            }
            exercisePluginDriver.removePlugin(5000);
            exercisePluginDriver.trackInteractiveLog("FillBlank", "submit", 1, "");
        }
    }
}
