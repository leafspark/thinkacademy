package com.tal.app.thinkacademy.business.home.main.vm;

import com.tal.app.thinkacademy.common.imconfig.SchoolListInfo;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/business/home/main/vm/LaunchViewModel$getSchoolList$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/common/imconfig/SchoolListInfo;", "onSuccess", "", "t", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LaunchViewModel.kt */
public final class LaunchViewModel$getSchoolList$1 extends OmyCallback<HiResponse<SchoolListInfo>> {
    final /* synthetic */ LaunchViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LaunchViewModel$getSchoolList$1(LaunchViewModel launchViewModel, LaunchViewModel$getSchoolList$2 launchViewModel$getSchoolList$2) {
        super((IError) launchViewModel$getSchoolList$2);
        this.this$0 = launchViewModel;
    }

    public void onSuccess(HiResponse<SchoolListInfo> hiResponse) {
        Intrinsics.checkNotNullParameter(hiResponse, "t");
        this.this$0.getSchoolListInfo().postSuccess(hiResponse.getData());
        XesLog.dt("分校列表", new Object[]{"获取分校列表成功："});
    }
}
