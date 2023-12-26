package com.tal.app.thinkacademy.business.study.study.speaker;

import android.os.Bundle;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.business.study.study.entity.JumpParamsEntity;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassCalendarActivity;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 6, 0})
/* compiled from: LiveData.kt */
public final class ClassCalendarActivity$startObserve$$inlined$observe$3<T> implements Observer<T> {
    final /* synthetic */ ClassCalendarActivity this$0;

    public ClassCalendarActivity$startObserve$$inlined$observe$3(ClassCalendarActivity classCalendarActivity) {
        this.this$0 = classCalendarActivity;
    }

    public final void onChanged(T t) {
        Integer planId;
        Integer classId;
        StateData stateData = (StateData) t;
        this.this$0.hideLoading();
        int i = 0;
        if (ClassCalendarActivity.WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            Bundle bundle = new Bundle();
            bundle.putString("jump_key", (String) stateData.getData());
            bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).setLandscape(PadUtils.isPad(this.this$0.getApplicationContext())).build());
            JumpParamsEntity access$getMJumpParams$p = this.this$0.mJumpParams;
            String str = null;
            bundle.putString("homework_id", access$getMJumpParams$p == null ? null : access$getMJumpParams$p.getHomeworkId());
            JumpParamsEntity access$getMJumpParams$p2 = this.this$0.mJumpParams;
            if (!(access$getMJumpParams$p2 == null || (classId = access$getMJumpParams$p2.getClassId()) == null)) {
                str = classId.toString();
            }
            bundle.putString(ClassParamsKt.CLASS_ID, str);
            JumpParamsEntity access$getMJumpParams$p3 = this.this$0.mJumpParams;
            if (!(access$getMJumpParams$p3 == null || (planId = access$getMJumpParams$p3.getPlanId()) == null)) {
                i = planId.intValue();
            }
            bundle.putInt("plan_id", i);
            bundle.putInt("homework_type", this.this$0.mHomeworkType);
            XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
            this.this$0.finish();
            return;
        }
        ClassCalendarActivity classCalendarActivity = this.this$0;
        classCalendarActivity.showToast(classCalendarActivity.getString(R.string.net_fail));
        XesLog.it("PlanListActivity", new Object[]{stateData.getCode() + "  " + stateData.getMsg()});
    }
}
