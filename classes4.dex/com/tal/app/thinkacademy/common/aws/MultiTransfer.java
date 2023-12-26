package com.tal.app.thinkacademy.common.aws;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\u000b\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\rH\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\"\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u0015\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017H\u0016R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/common/aws/MultiTransfer;", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$MultiTransferListener;", "()V", "tag", "", "kotlin.jvm.PlatformType", "onError", "", "currentIndex", "", "id", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onProgressChanged", "bytesCurrent", "", "bytesTotal", "onStateChanged", "state", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;", "onUploadSuccess", "names", "", "result", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MultiTransfer.kt */
public class MultiTransfer implements AwsS3Util.MultiTransferListener {
    private final String tag = "MultiTransfer";

    public void onUploadSuccess(List<String> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(list, "names");
        Intrinsics.checkNotNullParameter(list2, "result");
    }

    public void onStateChanged(int i, int i2, TransferState transferState) {
        String str = this.tag;
        XesLog.dt(str, "currentIndex = " + i + " upload onStateChanged id = " + i2);
        if (transferState == TransferState.COMPLETED) {
            String str2 = this.tag;
            XesLog.dt(str2, "currentIndex = " + i + " id = " + i2 + " upload completed");
        }
    }

    public void onProgressChanged(int i, int i2, long j, long j2) {
        String str = this.tag;
        XesLog.dt(str, "currentIndex = " + i + " upload onProgressChanged id = " + i2 + "  current = " + j + "  total = " + j2);
    }

    public void onError(int i, int i2, Exception exc) {
        String str = this.tag;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("currentIndex = ");
        sb.append(i);
        sb.append(" onError id = ");
        sb.append(i2);
        sb.append(" message = ");
        sb.append(exc == null ? null : exc.getMessage());
        objArr[0] = sb.toString();
        XesLog.dt(str, objArr);
    }
}
