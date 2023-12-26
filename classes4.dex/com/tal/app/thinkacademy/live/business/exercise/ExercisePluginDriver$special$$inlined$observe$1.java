package com.tal.app.thinkacademy.live.business.exercise;

import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.google.gson.internal.LinkedTreeMap;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameJsSubmitData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 6, 0})
/* compiled from: LiveData.kt */
public final class ExercisePluginDriver$special$$inlined$observe$1<T> implements Observer<T> {
    final /* synthetic */ ExercisePluginDriver this$0;

    public ExercisePluginDriver$special$$inlined$observe$1(ExercisePluginDriver exercisePluginDriver) {
        this.this$0 = exercisePluginDriver;
    }

    public final void onChanged(T t) {
        ExercisePluginDriver exercisePluginDriver = this.this$0;
        exercisePluginDriver.track_exercise(LeanplumUtil.click_fill_blank, exercisePluginDriver.mInteractId);
        int i = 1;
        XesLog.i(this.this$0.TAG, Intrinsics.stringPlus("interact+exercise---> JS给的答题结果", t));
        this.this$0.isSubmit = true;
        JSONObject jSONObject = new JSONObject((LinkedTreeMap) t);
        GameJsSubmitData gameJsSubmitData = (GameJsSubmitData) GsonUtils.fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject), GameJsSubmitData.class);
        ExercisePluginDriver exercisePluginDriver2 = this.this$0;
        Intrinsics.checkNotNullExpressionValue(gameJsSubmitData, "data");
        Integer isRight = gameJsSubmitData.isRight();
        if (isRight == null || isRight.intValue() != 1) {
            i = 2;
        }
        exercisePluginDriver2.getResultCoins(gameJsSubmitData, i);
    }
}
