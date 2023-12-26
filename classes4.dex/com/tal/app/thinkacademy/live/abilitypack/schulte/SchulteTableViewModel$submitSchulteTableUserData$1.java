package com.tal.app.thinkacademy.live.abilitypack.schulte;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.live.abilitypack.schulte.listenbody.SchulteTableListenerBody;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableUserDataBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/abilitypack/schulte/SchulteTableViewModel$submitSchulteTableUserData$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableUserDataBean;", "onSuccess", "", "res", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTableViewModel.kt */
public final class SchulteTableViewModel$submitSchulteTableUserData$1 extends OmyCallback<HiResponse<SchulteTableUserDataBean>> {
    final /* synthetic */ Float $duration;
    final /* synthetic */ String $interactId;
    final /* synthetic */ SchulteTableViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SchulteTableViewModel$submitSchulteTableUserData$1(Float f, SchulteTableViewModel schulteTableViewModel, String str, SchulteTableViewModel$submitSchulteTableUserData$2 schulteTableViewModel$submitSchulteTableUserData$2) {
        super(schulteTableViewModel$submitSchulteTableUserData$2);
        this.$duration = f;
        this.this$0 = schulteTableViewModel;
        this.$interactId = str;
    }

    public void onSuccess(HiResponse<SchulteTableUserDataBean> hiResponse) {
        Unit unit;
        Intrinsics.checkNotNullParameter(hiResponse, "res");
        XesLog.i(SchulteTableViewModel.TAG, Intrinsics.stringPlus("提交数据成功=", GsonUtil.getInstance().objToJson(hiResponse)));
        SchulteTableUserDataBean data = hiResponse.getData();
        if (data == null) {
            unit = null;
        } else {
            Float f = this.$duration;
            SchulteTableViewModel schulteTableViewModel = this.this$0;
            data.setCurDuration(f.toString());
            schulteTableViewModel.getMListenerBody().setStickyData(new SchulteTableListenerBody.GameOver(data));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            SchulteTableViewModel schulteTableViewModel2 = this.this$0;
            String str = this.$interactId;
            Float f2 = this.$duration;
            SchulteTableViewModel$submitSchulteTableUserData$1 schulteTableViewModel$submitSchulteTableUserData$1 = this;
            XesLog.i(SchulteTableViewModel.TAG, "提交数据成功,但接口返回数据为空");
            schulteTableViewModel2.getMListenerBody().setStickyData(new SchulteTableListenerBody.GameSubmitError(str, f2.floatValue()));
        }
    }
}
