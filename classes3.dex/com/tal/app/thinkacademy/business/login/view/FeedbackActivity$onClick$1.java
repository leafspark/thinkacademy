package com.tal.app.thinkacademy.business.login.view;

import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.login.presenter.FeedbackViewModel;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.common.aws.MultiTransfer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tH\u0016J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J$\u0010\u000e\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¨\u0006\u0013"}, d2 = {"com/tal/app/thinkacademy/business/login/view/FeedbackActivity$onClick$1", "Lcom/tal/app/thinkacademy/common/aws/MultiTransfer;", "onError", "", "currentIndex", "", "id", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onProgressChanged", "bytesCurrent", "", "bytesTotal", "onUploadSuccess", "names", "", "", "result", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedbackActivity.kt */
public final class FeedbackActivity$onClick$1 extends MultiTransfer {
    final /* synthetic */ FeedbackActivity this$0;

    FeedbackActivity$onClick$1(FeedbackActivity feedbackActivity) {
        this.this$0 = feedbackActivity;
    }

    public void onUploadSuccess(List<String> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(list, "names");
        Intrinsics.checkNotNullParameter(list2, DbParams.KEY_CHANNEL_RESULT);
        FeedbackViewModel access$getMViewModel = this.this$0.getMViewModel();
        String access$getMProblemTag$p = this.this$0.mProblemTag;
        String obj = StringsKt.trim(String.valueOf(this.this$0.getBinding().etContent.getText())).toString();
        Object[] array = list2.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        access$getMViewModel.submitFeedback(access$getMProblemTag$p, obj, (String[]) array);
        AwsS3Util.INSTANCE.reset();
    }

    public void onProgressChanged(int i, int i2, long j, long j2) {
        this.this$0.mUploadId = i2;
    }

    public void onError(int i, int i2, Exception exc) {
        AwsS3Util.INSTANCE.reset();
        this.this$0.mUploadIndex = 0;
        FeedbackViewModel.submitFeedback$default(this.this$0.getMViewModel(), this.this$0.mProblemTag, StringsKt.trim(String.valueOf(this.this$0.getBinding().etContent.getText())).toString(), (String[]) null, 4, (Object) null);
    }
}
