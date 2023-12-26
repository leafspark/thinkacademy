package com.tal.app.thinkacademy.live.abilitypack.rtc;

import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.net.ApiSuccess;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u00020\u0001J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0002H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel$getAllStudents$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "", "Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/StudentVideoBean$ListBean;", "onSuccess", "", "response", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RtcViewModel.kt */
public final class RtcViewModel$getAllStudents$1 extends OmyCallback<HiResponse<List<? extends StudentVideoBean.ListBean>>> {
    final /* synthetic */ RtcViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RtcViewModel$getAllStudents$1(RtcViewModel rtcViewModel, RtcViewModel$getAllStudents$2 rtcViewModel$getAllStudents$2) {
        super(rtcViewModel$getAllStudents$2);
        this.this$0 = rtcViewModel;
    }

    public void onSuccess(HiResponse<List<StudentVideoBean.ListBean>> hiResponse) {
        Intrinsics.checkNotNullParameter(hiResponse, "response");
        if (hiResponse.successful()) {
            this.this$0.getMNetWork().setStickyData(new ApiSuccess(hiResponse.getData()));
        }
    }
}
