package com.tal.app.thinkacademy.live.business.exercise;

import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.live.business.topic.bean.InteractStateBean;
import com.tal.app.thinkacademy.live.util.InteractLogReport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/business/exercise/ExercisePluginDriver$requestInteractiveStatus$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/topic/bean/InteractStateBean;", "onSuccess", "", "response", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExercisePluginDriver.kt */
public final class ExercisePluginDriver$requestInteractiveStatus$1 extends OmyCallback<HiResponse<InteractStateBean>> {
    final /* synthetic */ ExercisePluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExercisePluginDriver$requestInteractiveStatus$1(ExercisePluginDriver exercisePluginDriver, ExercisePluginDriver$requestInteractiveStatus$2 exercisePluginDriver$requestInteractiveStatus$2) {
        super(exercisePluginDriver$requestInteractiveStatus$2);
        this.this$0 = exercisePluginDriver;
    }

    public void onSuccess(HiResponse<InteractStateBean> hiResponse) {
        Integer access$getMClassId$p;
        Intrinsics.checkNotNullParameter(hiResponse, "response");
        InteractStateBean data = hiResponse.getData();
        if (data != null) {
            ExercisePluginDriver exercisePluginDriver = this.this$0;
            if (!data.isSubmit()) {
                exercisePluginDriver.mQuestionId = data.getQuestionId();
                exercisePluginDriver.loadPluginView(GsonUtils.toJson(new InteractionJsBean("interactionData", new InteractionData(Long.valueOf(exercisePluginDriver.getRealCountDownTime()), data.getQuestionContent(), exercisePluginDriver.mStuId, 0))));
                Integer access$getMPlanId$p = exercisePluginDriver.mPlanId;
                if (access$getMPlanId$p != null) {
                    int intValue = access$getMPlanId$p.intValue();
                    String access$getMInteractId$p = exercisePluginDriver.mInteractId;
                    if (!(access$getMInteractId$p == null || (access$getMClassId$p = exercisePluginDriver.mClassId) == null)) {
                        InteractLogReport.uploadLog(access$getMInteractId$p, intValue, access$getMClassId$p.intValue());
                    }
                }
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("收到填空题打开信令", "接口请求成功--->interact+exercise---> 收到互动并且确认需要加载互动页面;需要传给JS渲染的内容");
                XesLog.ut((XesLogTag) exercisePluginDriver.TAG, jsonObject);
            }
        }
    }
}
