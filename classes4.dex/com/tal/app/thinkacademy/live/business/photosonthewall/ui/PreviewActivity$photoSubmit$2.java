package com.tal.app.thinkacademy.live.business.photosonthewall.ui;

import android.os.Handler;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosMaintainData;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/live/business/photosonthewall/ui/PreviewActivity$photoSubmit$2", "Lcom/tal/app/thinkacademy/lib/network/exception/IError;", "onError", "", "code", "", "msg", "", "onFail", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreviewActivity.kt */
public final class PreviewActivity$photoSubmit$2 implements IError {
    final /* synthetic */ PreviewActivity this$0;

    PreviewActivity$photoSubmit$2(PreviewActivity previewActivity) {
        this.this$0 = previewActivity;
    }

    public void onFail(int i, String str) {
        this.this$0.track(LeanplumUtil.failed_result_photowall);
        PhotosMaintainData access$getMPhotosMaintainData$p = this.this$0.mPhotosMaintainData;
        InteractReportKt.XesLogReport$default("uploadImage", "Photopost", access$getMPhotosMaintainData$p == null ? null : access$getMPhotosMaintainData$p.getInteractId(), 1, (String) null, 16, (Object) null);
        if (!this.this$0.isOnDestroy) {
            XesLog.i(this.this$0.TAG, Intrinsics.stringPlus("photoSubmit---> onFailed ---> ", str));
            this.this$0.updateSubmitState(false);
            RoundLinearLayout roundLinearLayout = this.this$0.getBinding().llSubmissionFailed;
            if (roundLinearLayout != null) {
                roundLinearLayout.setVisibility(0);
            }
            Handler access$getMHandler$p = this.this$0.mHandler;
            if (access$getMHandler$p != null) {
                access$getMHandler$p.sendEmptyMessageDelayed(this.this$0.KSubmissionFailed, 3000);
            }
        }
    }

    public void onError(int i, String str) {
        this.this$0.track(LeanplumUtil.failed_result_photowall);
        PhotosMaintainData access$getMPhotosMaintainData$p = this.this$0.mPhotosMaintainData;
        InteractReportKt.XesLogReport$default("uploadImage", "Photopost", access$getMPhotosMaintainData$p == null ? null : access$getMPhotosMaintainData$p.getInteractId(), 1, (String) null, 16, (Object) null);
        if (!this.this$0.isOnDestroy) {
            XesLog.i(this.this$0.TAG, Intrinsics.stringPlus("photoSubmit---> onError ---> ", str));
            this.this$0.updateSubmitState(false);
            RoundLinearLayout roundLinearLayout = this.this$0.getBinding().llSubmissionFailed;
            if (roundLinearLayout != null) {
                roundLinearLayout.setVisibility(0);
            }
            Handler access$getMHandler$p = this.this$0.mHandler;
            if (access$getMHandler$p != null) {
                access$getMHandler$p.sendEmptyMessageDelayed(this.this$0.KSubmissionFailed, 3000);
            }
        }
    }
}
