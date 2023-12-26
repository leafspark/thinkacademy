package com.tal.app.thinkacademy.business.study.study.speaker.viewmodel;

import android.app.Application;
import com.tal.app.thinkacademy.business.study.study.entity.TeachMethodEntity;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.utils.AppGlobals;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/business/study/study/speaker/viewmodel/PlanListVM$requestTeachMethod$1", "Lcom/tal/app/thinkacademy/lib/network/exception/IError;", "onError", "", "code", "", "msg", "", "onFail", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlanListVM.kt */
public final class PlanListVM$requestTeachMethod$1 implements IError {
    final /* synthetic */ PlanListVM this$0;

    PlanListVM$requestTeachMethod$1(PlanListVM planListVM) {
        this.this$0 = planListVM;
    }

    public void onFail(int i, String str) {
        String str2 = null;
        if (i != 0) {
            StateLiveData<TeachMethodEntity> teachMethodData = this.this$0.getTeachMethodData();
            Application application = AppGlobals.INSTANCE.get();
            if (application != null) {
                str2 = application.getString(R.string.study_center_net_error);
            }
            teachMethodData.postFailure(i, str2);
            return;
        }
        StateLiveData<TeachMethodEntity> teachMethodData2 = this.this$0.getTeachMethodData();
        Application application2 = AppGlobals.INSTANCE.get();
        if (application2 != null) {
            str2 = application2.getString(R.string.study_center_data_error);
        }
        teachMethodData2.postFailure(i, str2);
    }

    public void onError(int i, String str) {
        this.this$0.getTeachMethodData().postError(i, str);
    }
}
