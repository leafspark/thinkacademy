package com.tal.app.thinkacademy.live.business.mediacontroller.live.delegate;

import android.text.TextUtils;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.exam.bean.ExamInfo;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.MediaControlSmallLiveViewPad;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/business/mediacontroller/live/delegate/PadSmallClassBarDelegate$requestExamReport$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/exam/bean/ExamInfo;", "onSuccess", "", "t", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PadSmallClassBarDelegate.kt */
public final class PadSmallClassBarDelegate$requestExamReport$1 extends OmyCallback<HiResponse<ExamInfo>> {
    final /* synthetic */ boolean $isShow;
    final /* synthetic */ PadSmallClassBarDelegate this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PadSmallClassBarDelegate$requestExamReport$1(boolean z, PadSmallClassBarDelegate padSmallClassBarDelegate, PadSmallClassBarDelegate$requestExamReport$2 padSmallClassBarDelegate$requestExamReport$2) {
        super(padSmallClassBarDelegate$requestExamReport$2);
        this.$isShow = z;
        this.this$0 = padSmallClassBarDelegate;
    }

    public void onSuccess(HiResponse<ExamInfo> hiResponse) {
        String str;
        Intrinsics.checkNotNullParameter(hiResponse, "t");
        ExamInfo data = hiResponse.getData();
        if (this.$isShow) {
            boolean z = false;
            if (data != null && data.getShowReportEnter() == 1) {
                z = true;
            }
            if (z && this.this$0.mediaViewSmall != null) {
                MediaControlSmallLiveViewPad access$getMediaViewSmall$p = this.this$0.mediaViewSmall;
                Intrinsics.checkNotNull(access$getMediaViewSmall$p);
                access$getMediaViewSmall$p.showExamReportButton();
                return;
            }
            return;
        }
        if (data == null) {
            str = null;
        } else {
            str = data.getStudentReportUrl();
        }
        if (TextUtils.isEmpty(str)) {
            this.this$0.showNoExamReport();
        } else {
            this.this$0.showExamReportDialog(str);
        }
    }
}
