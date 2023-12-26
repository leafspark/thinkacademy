package com.tal.app.thinkacademy.live.business.photosonthewall.ui;

import android.os.Handler;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.common.aws.SingleTransfer;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.live.business.photosonthewall.dialog.SubmitDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, d2 = {"com/tal/app/thinkacademy/live/business/photosonthewall/ui/PreviewActivity$uploadFile$1", "Lcom/tal/app/thinkacademy/common/aws/SingleTransfer;", "onError", "", "id", "", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onProgressChanged", "bytesCurrent", "", "bytesTotal", "onUploadSuccess", "name", "", "result", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreviewActivity.kt */
public final class PreviewActivity$uploadFile$1 extends SingleTransfer {
    final /* synthetic */ PreviewActivity this$0;

    PreviewActivity$uploadFile$1(PreviewActivity previewActivity) {
        this.this$0 = previewActivity;
    }

    public void onUploadSuccess(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "result");
        this.this$0.hideSubmitDialog();
        XesLog.i(this.this$0.TAG, Intrinsics.stringPlus("uploadFile---> onUploadSuccess--> ", str2));
        this.this$0.resultPath = str;
        this.this$0.picAbsPath = str2;
        PreviewActivity previewActivity = this.this$0;
        String access$getResultPath$p = previewActivity.resultPath;
        Intrinsics.checkNotNull(access$getResultPath$p);
        previewActivity.photoSubmit(access$getResultPath$p);
    }

    public void onProgressChanged(int i, long j, long j2) {
        SubmitDialog access$getMSubmitDialog$p = this.this$0.mSubmitDialog;
        if (access$getMSubmitDialog$p != null) {
            access$getMSubmitDialog$p.updateProgress(((int) (j / j2)) * 100);
        }
    }

    public void onError(int i, Exception exc) {
        XesLogTag access$getTAG$p = this.this$0.TAG;
        Object[] objArr = new Object[1];
        objArr[0] = Intrinsics.stringPlus("uploadFile---> onError--> ", exc == null ? null : exc.getMessage());
        XesLog.i(access$getTAG$p, objArr);
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
