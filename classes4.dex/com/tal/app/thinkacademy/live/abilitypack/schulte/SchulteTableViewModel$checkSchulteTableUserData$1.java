package com.tal.app.thinkacademy.live.abilitypack.schulte;

import android.text.TextUtils;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableUserDataBean;
import com.tal.app.thinkacademy.live.business.schulte.listener.CheckSchulteTableUserDataListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/abilitypack/schulte/SchulteTableViewModel$checkSchulteTableUserData$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableUserDataBean;", "onSuccess", "", "response", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTableViewModel.kt */
public final class SchulteTableViewModel$checkSchulteTableUserData$1 extends OmyCallback<HiResponse<SchulteTableUserDataBean>> {
    final /* synthetic */ CheckSchulteTableUserDataListener $listener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SchulteTableViewModel$checkSchulteTableUserData$1(CheckSchulteTableUserDataListener checkSchulteTableUserDataListener, SchulteTableViewModel$checkSchulteTableUserData$2 schulteTableViewModel$checkSchulteTableUserData$2) {
        super(schulteTableViewModel$checkSchulteTableUserData$2);
        this.$listener = checkSchulteTableUserDataListener;
    }

    public void onSuccess(HiResponse<SchulteTableUserDataBean> hiResponse) {
        Unit unit;
        Intrinsics.checkNotNullParameter(hiResponse, "response");
        XesLog.i(SchulteTableViewModel.TAG, Intrinsics.stringPlus("查询是否提交过数据成功=", GsonUtil.getInstance().objToJson(hiResponse)));
        SchulteTableUserDataBean data = hiResponse.getData();
        Unit unit2 = null;
        if (data != null) {
            CheckSchulteTableUserDataListener checkSchulteTableUserDataListener = this.$listener;
            if (TextUtils.isEmpty(data.getCurDuration()) || Intrinsics.areEqual(data.getCurDuration(), EnterRoomMuteData.STATUS_UN_MUTE)) {
                if (checkSchulteTableUserDataListener != null) {
                    checkSchulteTableUserDataListener.onUnSubmitted();
                    unit = Unit.INSTANCE;
                }
            } else if (checkSchulteTableUserDataListener != null) {
                checkSchulteTableUserDataListener.onSubmitted(data);
                unit = Unit.INSTANCE;
            }
            unit2 = unit;
        }
        if (unit2 == null) {
            CheckSchulteTableUserDataListener checkSchulteTableUserDataListener2 = this.$listener;
            SchulteTableViewModel$checkSchulteTableUserData$1 schulteTableViewModel$checkSchulteTableUserData$1 = this;
            if (checkSchulteTableUserDataListener2 != null) {
                checkSchulteTableUserDataListener2.onUnSubmitted();
            }
        }
    }
}
