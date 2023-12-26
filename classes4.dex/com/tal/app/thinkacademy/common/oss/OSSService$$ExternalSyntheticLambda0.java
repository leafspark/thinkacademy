package com.tal.app.thinkacademy.common.oss;

import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;

public final /* synthetic */ class OSSService$$ExternalSyntheticLambda0 implements OSSProgressCallback {
    public final /* synthetic */ AwsS3Util.SingleTransferListener f$0;

    public /* synthetic */ OSSService$$ExternalSyntheticLambda0(AwsS3Util.SingleTransferListener singleTransferListener) {
        this.f$0 = singleTransferListener;
    }

    public final void onProgress(Object obj, long j, long j2) {
        OSSService.lambda$realUploafFile$0(this.f$0, (PutObjectRequest) obj, j, j2);
    }
}
