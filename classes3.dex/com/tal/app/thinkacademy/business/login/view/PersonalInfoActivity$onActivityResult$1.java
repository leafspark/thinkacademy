package com.tal.app.thinkacademy.business.login.view;

import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.entity.UseGetInfo;
import com.tal.app.thinkacademy.business.login.presenter.PersonalInfoViewModel;
import com.tal.app.thinkacademy.common.aws.SingleTransfer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"com/tal/app/thinkacademy/business/login/view/PersonalInfoActivity$onActivityResult$1", "Lcom/tal/app/thinkacademy/common/aws/SingleTransfer;", "onError", "", "id", "", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onUploadSuccess", "name", "", "result", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalInfoActivity.kt */
public final class PersonalInfoActivity$onActivityResult$1 extends SingleTransfer {
    final /* synthetic */ PersonalInfoActivity this$0;

    PersonalInfoActivity$onActivityResult$1(PersonalInfoActivity personalInfoActivity) {
        this.this$0 = personalInfoActivity;
    }

    public void onUploadSuccess(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, DbParams.KEY_CHANNEL_RESULT);
        this.this$0.mOnlyChangePhoto = true;
        this.this$0.mPhotoUrl = str2;
        PersonalInfoViewModel access$getMViewModel = this.this$0.getMViewModel();
        UseGetInfo access$getMUserInfo$p = this.this$0.mUserInfo;
        String nickName = access$getMUserInfo$p == null ? null : access$getMUserInfo$p.getNickName();
        UseGetInfo access$getMUserInfo$p2 = this.this$0.mUserInfo;
        String firstName = access$getMUserInfo$p2 == null ? null : access$getMUserInfo$p2.getFirstName();
        UseGetInfo access$getMUserInfo$p3 = this.this$0.mUserInfo;
        String lastName = access$getMUserInfo$p3 == null ? null : access$getMUserInfo$p3.getLastName();
        UseGetInfo access$getMUserInfo$p4 = this.this$0.mUserInfo;
        Integer valueOf = access$getMUserInfo$p4 == null ? null : Integer.valueOf(access$getMUserInfo$p4.getGradeId());
        UseGetInfo access$getMUserInfo$p5 = this.this$0.mUserInfo;
        access$getMViewModel.modifyUserBasicInfo(str2, nickName, firstName, lastName, valueOf, access$getMUserInfo$p5 == null ? null : access$getMUserInfo$p5.getLinkedAccount());
    }

    public void onError(int i, Exception exc) {
        this.this$0.hideLoading();
        PersonalInfoActivity personalInfoActivity = this.this$0;
        personalInfoActivity.showToast(personalInfoActivity.getString(R.string.file_upload_failed));
    }
}
