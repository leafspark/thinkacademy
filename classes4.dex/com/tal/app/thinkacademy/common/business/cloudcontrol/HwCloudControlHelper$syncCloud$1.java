package com.tal.app.thinkacademy.common.business.cloudcontrol;

import com.tal.app.thinkacademy.common.business.cloudcontrol.api.CloudData;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/common/business/cloudcontrol/HwCloudControlHelper$syncCloud$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/common/business/cloudcontrol/api/CloudData;", "onSuccess", "", "t", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwCloudControlHelper.kt */
public final class HwCloudControlHelper$syncCloud$1 extends OmyCallback<HiResponse<CloudData>> {
    final /* synthetic */ HwCloudControlHelper this$0;

    HwCloudControlHelper$syncCloud$1(HwCloudControlHelper hwCloudControlHelper) {
        this.this$0 = hwCloudControlHelper;
    }

    public void onSuccess(HiResponse<CloudData> hiResponse) {
        Intrinsics.checkNotNullParameter(hiResponse, "t");
        this.this$0.dealResult(hiResponse);
    }
}
