package com.tal.app.thinkacademy.common.aws;

import android.os.SystemClock;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.common.entity.STSToken;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/tal/app/thinkacademy/common/aws/AwsS3Util$uploadFiles$2$transferListener$1", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferListener;", "onError", "", "id", "", "ex", "Ljava/lang/Exception;", "onProgressChanged", "bytesCurrent", "", "bytesTotal", "onStateChanged", "state", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AwsS3Util.kt */
public final class AwsS3Util$uploadFiles$2$transferListener$1 implements TransferListener {
    final /* synthetic */ Ref.IntRef $currentIndex;
    final /* synthetic */ List<File> $files;
    final /* synthetic */ AwsS3Util.MultiTransferListener $listener;
    final /* synthetic */ List<String> $names;
    final /* synthetic */ String $scene;
    final /* synthetic */ Ref.LongRef $startTime;
    final /* synthetic */ STSToken $stsToken;

    AwsS3Util$uploadFiles$2$transferListener$1(AwsS3Util.MultiTransferListener multiTransferListener, Ref.IntRef intRef, List<? extends File> list, Ref.LongRef longRef, STSToken sTSToken, List<String> list2, String str) {
        this.$listener = multiTransferListener;
        this.$currentIndex = intRef;
        this.$files = list;
        this.$startTime = longRef;
        this.$stsToken = sTSToken;
        this.$names = list2;
        this.$scene = str;
    }

    public void onStateChanged(int i, TransferState transferState) {
        AwsS3Util.MultiTransferListener multiTransferListener = this.$listener;
        if (multiTransferListener != null) {
            multiTransferListener.onStateChanged(this.$currentIndex.element, i, transferState);
        }
        if (transferState == TransferState.COMPLETED) {
            XesLogTag access$getTag$p = AwsS3Util.tag;
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("文件上传成功>>>上传方式=aws，文件大小=");
            File file = this.$files.get(this.$currentIndex.element);
            Long l = null;
            sb.append(file == null ? null : Long.valueOf(file.length()));
            sb.append("，文件名称=");
            File file2 = this.$files.get(this.$currentIndex.element);
            sb.append(file2 == null ? null : file2.getName());
            sb.append("，耗时=");
            sb.append(SystemClock.elapsedRealtime() - this.$startTime.element);
            sb.append("毫秒，文件地址=");
            sb.append(this.$stsToken.getAppUrl());
            sb.append(File.separator);
            sb.append(this.$names.get(this.$currentIndex.element));
            objArr[0] = sb.toString();
            XesLog.i(access$getTag$p, objArr);
            UploadFileTrackUtil uploadFileTrackUtil = UploadFileTrackUtil.INSTANCE;
            String str = this.$scene;
            UploadFileType uploadFileType = UploadFileType.AWS;
            File file3 = this.$files.get(this.$currentIndex.element);
            if (file3 != null) {
                l = Long.valueOf(file3.length());
            }
            Long valueOf = Long.valueOf(SystemClock.elapsedRealtime() - this.$startTime.element);
            uploadFileTrackUtil.trackSuccessEvent(str, uploadFileType, l, valueOf, this.$stsToken.getAppUrl() + File.separator + this.$names.get(this.$currentIndex.element));
            ArrayList arrayList = new ArrayList();
            this.$currentIndex.element = this.$currentIndex.element + 1;
            if (this.$currentIndex.element == this.$names.size()) {
                int size = this.$names.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(this.$stsToken.getAppUrl() + File.separator + this.$names.get(i2));
                }
                AwsS3Util.MultiTransferListener multiTransferListener2 = this.$listener;
                if (multiTransferListener2 != null) {
                    multiTransferListener2.onUploadSuccess(this.$names, arrayList);
                    return;
                }
                return;
            }
            this.$startTime.element = SystemClock.elapsedRealtime();
            AwsS3Util.INSTANCE.uploadFile(this.$names.get(this.$currentIndex.element), this.$files.get(this.$currentIndex.element), (TransferListener) this);
        }
    }

    public void onProgressChanged(int i, long j, long j2) {
        AwsS3Util.MultiTransferListener multiTransferListener = this.$listener;
        if (multiTransferListener != null) {
            multiTransferListener.onProgressChanged(this.$currentIndex.element, i, j, j2);
        }
    }

    public void onError(int i, Exception exc) {
        String str;
        XesLogTag access$getTag$p = AwsS3Util.tag;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("文件上传失败>>>上传方式=aws，文件大小=");
        File file = this.$files.get(this.$currentIndex.element);
        String str2 = null;
        sb.append(file == null ? null : Long.valueOf(file.length()));
        sb.append("，文件名称=");
        File file2 = this.$files.get(this.$currentIndex.element);
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
        File file3 = this.$files.get(this.$currentIndex.element);
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
        AwsS3Util.MultiTransferListener multiTransferListener = this.$listener;
        if (multiTransferListener != null) {
            multiTransferListener.onError(this.$currentIndex.element, i, exc);
        }
    }
}
