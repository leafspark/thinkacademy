package com.tal.app.thinkacademy.live.business.mediacontroller.feedback;

import com.tal.app.thinkacademy.common.aws.SingleTransfer;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¨\u0006\u0011"}, d2 = {"com/tal/app/thinkacademy/live/business/mediacontroller/feedback/FeedBackPlayBackView$uploadScreenshot$1", "Lcom/tal/app/thinkacademy/common/aws/SingleTransfer;", "onError", "", "id", "", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onProgressChanged", "bytesCurrent", "", "bytesTotal", "onUploadSuccess", "name", "", "result", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBackPlayBackView.kt */
public final class FeedBackPlayBackView$uploadScreenshot$1 extends SingleTransfer {
    final /* synthetic */ FeedBackPlayBackView this$0;

    FeedBackPlayBackView$uploadScreenshot$1(FeedBackPlayBackView feedBackPlayBackView) {
        this.this$0 = feedBackPlayBackView;
    }

    public void onUploadSuccess(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "result");
        super.onUploadSuccess(str, str2);
        this.this$0.sendServer(str2);
        XesLog.s(FeedBackPlayBackView.TAG, Intrinsics.stringPlus("图片上传成功,url=", str2));
    }

    public void onProgressChanged(int i, long j, long j2) {
        super.onProgressChanged(i, j, j2);
    }

    public void onError(int i, Exception exc) {
        super.onError(i, exc);
        XesLog.e(FeedBackPlayBackView.TAG, Intrinsics.stringPlus("图片上失败，不上传图片地址了，错误=", exc));
        this.this$0.sendServer((String) null);
    }
}
