package com.tal.app.thinkacademy.common.logan;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.tal.app.thinkacademy.common.aws.SingleTransfer;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.FileUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¨\u0006\u0014"}, d2 = {"com/tal/app/thinkacademy/common/logan/RealSendLogRunnable$uploadLog$1", "Lcom/tal/app/thinkacademy/common/aws/SingleTransfer;", "onError", "", "id", "", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onProgressChanged", "bytesCurrent", "", "bytesTotal", "onStateChanged", "state", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;", "onUploadSuccess", "name", "", "result", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RealSendLogRunnable.kt */
public final class RealSendLogRunnable$uploadLog$1 extends SingleTransfer {
    final /* synthetic */ Date $date;
    final /* synthetic */ File $logFile;
    final /* synthetic */ String $logName;
    final /* synthetic */ SimpleDateFormat $sdf;
    final /* synthetic */ File $zipFile;
    final /* synthetic */ File $zipFolder;
    final /* synthetic */ RealSendLogRunnable this$0;

    RealSendLogRunnable$uploadLog$1(RealSendLogRunnable realSendLogRunnable, SimpleDateFormat simpleDateFormat, Date date, String str, File file, File file2, File file3) {
        this.this$0 = realSendLogRunnable;
        this.$sdf = simpleDateFormat;
        this.$date = date;
        this.$logName = str;
        this.$logFile = file;
        this.$zipFile = file2;
        this.$zipFolder = file3;
    }

    public void onProgressChanged(int i, long j, long j2) {
        super.onProgressChanged(i, j, j2);
    }

    public void onUploadSuccess(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "result");
        super.onUploadSuccess(str, str2);
        this.this$0.finish();
        XesLog.s(this.this$0.TAG, "日志时间=" + this.$sdf.format(this.$date) + "，日志名称=" + this.$logName + "，日志链接=" + str2);
        LogTrack logTrack = LogTrack.INSTANCE;
        String format = this.$sdf.format(this.$date);
        Intrinsics.checkNotNullExpressionValue(format, "sdf.format(date)");
        logTrack.uploadLogUrl(format, str2);
        LogTrack.INSTANCE.uploadLogInfo(str2, LoganFileParser.INSTANCE.parse(this.$logFile), this.$zipFile.length());
        this.$logFile.delete();
        FileUtils.delete(this.$zipFolder);
        RealSendLogRunnable realSendLogRunnable = this.this$0;
        String str3 = this.$logName;
        Intrinsics.checkNotNullExpressionValue(str3, "logName");
        realSendLogRunnable.deleteCurrentRtcLog(str3);
        RealSendLogRunnable realSendLogRunnable2 = this.this$0;
        String str4 = this.$logName;
        Intrinsics.checkNotNullExpressionValue(str4, "logName");
        realSendLogRunnable2.deleteCurrentIrcFolder(str4);
    }

    public void onError(int i, Exception exc) {
        super.onError(i, exc);
        this.this$0.finish();
        String name = this.$logFile.getName();
        Intrinsics.checkNotNullExpressionValue(name, "logFile.name");
        if (StringsKt.contains$default(name, ".copy", false, 2, (Object) null)) {
            this.$logFile.delete();
        }
        FileUtils.delete(this.$zipFolder);
    }

    public void onStateChanged(int i, TransferState transferState) {
        super.onStateChanged(i, transferState);
    }
}
