package com.tal.app.thinkacademy.live.abilitypack.schulte;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableStartBean;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableUserDataBean;
import com.tal.app.thinkacademy.live.business.schulte.listener.CheckSchulteTableUserDataListener;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"com/tal/app/thinkacademy/live/abilitypack/schulte/SchulteTableViewModel$onReceiveMessage$1$1", "Lcom/tal/app/thinkacademy/live/business/schulte/listener/CheckSchulteTableUserDataListener;", "onError", "", "code", "", "msg", "", "onSubmitted", "schulteTableUserData", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableUserDataBean;", "onUnSubmitted", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTableViewModel.kt */
public final class SchulteTableViewModel$onReceiveMessage$1$1 implements CheckSchulteTableUserDataListener {
    final /* synthetic */ SchulteTableStartBean $startBean;
    final /* synthetic */ SchulteTableViewModel this$0;

    SchulteTableViewModel$onReceiveMessage$1$1(SchulteTableViewModel schulteTableViewModel, SchulteTableStartBean schulteTableStartBean) {
        this.this$0 = schulteTableViewModel;
        this.$startBean = schulteTableStartBean;
    }

    public void onSubmitted(SchulteTableUserDataBean schulteTableUserDataBean) {
        Intrinsics.checkNotNullParameter(schulteTableUserDataBean, "schulteTableUserData");
        XesLog.i(SchulteTableViewModel.TAG, Intrinsics.stringPlus("已提交过成绩，将展示结果页", GsonUtil.getInstance().objToJson(schulteTableUserDataBean)));
        this.this$0.getMListenerBody().setStickyData(new SchulteTableListenerBody.GameOver(schulteTableUserDataBean));
    }

    public void onError(int i, String str) {
        XesLog.i(SchulteTableViewModel.TAG, "check接口请求失败，视为未提交，将开始游戏");
        ListenerData<SchulteTableListenerBody> mListenerBody = this.this$0.getMListenerBody();
        SchulteTableStartBean schulteTableStartBean = this.$startBean;
        Intrinsics.checkNotNullExpressionValue(schulteTableStartBean, "startBean");
        mListenerBody.setStickyData(new SchulteTableListenerBody.GameStart(schulteTableStartBean));
    }

    public void onUnSubmitted() {
        XesLog.i(SchulteTableViewModel.TAG, "未提交过成绩，将开始游戏");
        ListenerData<SchulteTableListenerBody> mListenerBody = this.this$0.getMListenerBody();
        SchulteTableStartBean schulteTableStartBean = this.$startBean;
        Intrinsics.checkNotNullExpressionValue(schulteTableStartBean, "startBean");
        mListenerBody.setStickyData(new SchulteTableListenerBody.GameStart(schulteTableStartBean));
    }
}
