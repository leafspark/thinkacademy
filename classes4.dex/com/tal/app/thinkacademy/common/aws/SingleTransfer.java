package com.tal.app.thinkacademy.common.aws;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u0016J \u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001a\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/common/aws/SingleTransfer;", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$SingleTransferListener;", "()V", "tag", "", "kotlin.jvm.PlatformType", "onError", "", "id", "", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onProgressChanged", "bytesCurrent", "", "bytesTotal", "onStateChanged", "state", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;", "onUploadSuccess", "name", "result", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SingleTransfer.kt */
public class SingleTransfer implements AwsS3Util.SingleTransferListener {
    private final String tag = "SingleTransfer";

    public void onUploadSuccess(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "result");
    }

    public void onStateChanged(int i, TransferState transferState) {
        String str = this.tag;
        XesLog.dt(str, "onStateChanged id = " + i + " state = " + transferState);
    }

    public void onProgressChanged(int i, long j, long j2) {
        String str = this.tag;
        XesLog.dt(str, "onProgressChanged id = " + i + " current = " + j + " total = " + j2);
    }

    public void onError(int i, Exception exc) {
        String str = this.tag;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("onError id = ");
        sb.append(i);
        sb.append(" message = ");
        sb.append(exc == null ? null : exc.getMessage());
        objArr[0] = sb.toString();
        XesLog.dt(str, objArr);
    }
}
