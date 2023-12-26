package com.tal.app.thinkacademy.common.aws;

import android.os.SystemClock;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.common.entity.STSToken;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, d2 = {"com/tal/app/thinkacademy/common/aws/AwsS3Util$uploadFile$2$transferListener$1", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferListener;", "onError", "", "id", "", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onProgressChanged", "bytesCurrent", "", "bytesTotal", "onStateChanged", "state", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AwsS3Util.kt */
public final class AwsS3Util$uploadFile$2$transferListener$1 implements TransferListener {
    final /* synthetic */ File $file;
    final /* synthetic */ AwsS3Util.SingleTransferListener $listener;
    final /* synthetic */ String $name;
    final /* synthetic */ String $scene;
    final /* synthetic */ long $startTime;
    final /* synthetic */ STSToken $stsToken;

    AwsS3Util$uploadFile$2$transferListener$1(AwsS3Util.SingleTransferListener singleTransferListener, File file, long j, STSToken sTSToken, String str, String str2) {
        this.$listener = singleTransferListener;
        this.$file = file;
        this.$startTime = j;
        this.$stsToken = sTSToken;
        this.$name = str;
        this.$scene = str2;
    }

    public void onStateChanged(int i, TransferState transferState) {
        AwsS3Util.SingleTransferListener singleTransferListener = this.$listener;
        if (singleTransferListener != null) {
            singleTransferListener.onStateChanged(i, transferState);
        }
        if (transferState == TransferState.COMPLETED) {
            XesLogTag access$getTag$p = AwsS3Util.tag;
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("文件上传成功>>>上传方式=aws，文件大小=");
            File file = this.$file;
            Long l = null;
            sb.append(file == null ? null : Long.valueOf(file.length()));
            sb.append("，文件名称=");
            File file2 = this.$file;
            sb.append(file2 == null ? null : file2.getName());
            sb.append("，耗时=");
            sb.append(SystemClock.elapsedRealtime() - this.$startTime);
            sb.append("毫秒，文件地址=");
            sb.append(this.$stsToken.getAppUrl());
            sb.append(File.separator);
            sb.append(this.$name);
            objArr[0] = sb.toString();
            XesLog.i(access$getTag$p, objArr);
            UploadFileTrackUtil uploadFileTrackUtil = UploadFileTrackUtil.INSTANCE;
            String str = this.$scene;
            UploadFileType uploadFileType = UploadFileType.AWS;
            File file3 = this.$file;
            if (file3 != null) {
                l = Long.valueOf(file3.length());
            }
            Long valueOf = Long.valueOf(SystemClock.elapsedRealtime() - this.$startTime);
            uploadFileTrackUtil.trackSuccessEvent(str, uploadFileType, l, valueOf, this.$stsToken.getAppUrl() + File.separator + this.$name);
            AwsS3Util.SingleTransferListener singleTransferListener2 = this.$listener;
            if (singleTransferListener2 != null) {
                String str2 = this.$name;
                Intrinsics.checkNotNull(str2);
                singleTransferListener2.onUploadSuccess(str2, this.$stsToken.getAppUrl() + File.separator + this.$name);
            }
            AwsS3Util.INSTANCE.reset();
        }
    }

    public void onProgressChanged(int i, long j, long j2) {
        AwsS3Util.SingleTransferListener singleTransferListener = this.$listener;
        if (singleTransferListener != null) {
            singleTransferListener.onProgressChanged(i, j, j2);
        }
    }

    public void onError(int i, Exception exc) {
        String str;
        XesLogTag access$getTag$p = AwsS3Util.tag;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("文件上传失败>>>上传方式=aws，文件大小=");
        File file = this.$file;
        String str2 = null;
        sb.append(file == null ? null : Long.valueOf(file.length()));
        sb.append("，文件名称=");
        File file2 = this.$file;
        sb.append(file2 == null ? null : file2.getName());
        sb.append("，错误信息=【id=");
        sb.append(i);
        sb.append(",描述=");
        if (exc == null) {
            str = null;
        } else {
            str = exc.getMessage();
        }
        sb.append(str);
        sb.append(12305);
        objArr[0] = sb.toString();
        XesLog.i(access$getTag$p, objArr);
        UploadFileTrackUtil uploadFileTrackUtil = UploadFileTrackUtil.INSTANCE;
        String str3 = this.$scene;
        UploadFileType uploadFileType = UploadFileType.AWS;
        File file3 = this.$file;
        Long valueOf = file3 == null ? null : Long.valueOf(file3.length());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("id=");
        sb2.append(i);
        sb2.append(",exception=");
        if (exc != null) {
            str2 = exc.getMessage();
        }
        sb2.append(str2);
        uploadFileTrackUtil.trackFailEvent(str3, uploadFileType, valueOf, sb2.toString());
        AwsS3Util.SingleTransferListener singleTransferListener = this.$listener;
        if (singleTransferListener != null) {
            singleTransferListener.onError(i, exc);
        }
        AwsS3Util.INSTANCE.reset();
    }
}
