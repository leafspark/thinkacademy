package com.tal.app.thinkacademy.business.shop.classdetail;

import android.content.Context;
import com.tal.app.thinkacademy.business.shop.bean.request.PerfectInforRequest;
import com.tal.app.thinkacademy.business.shop.classdetail.dialog.PerfectInfor;
import com.tal.app.thinkacademy.business.shop.classdetail.dialog.SecondaryConfirDialog;
import com.tal.app.thinkacademy.business.shop.viewmodel.SeletedStudentViewModel;
import com.tal.app.thinkacademy.common.base.XesBaseActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "perfectInfor", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/PerfectInfor;", "request", "Lcom/tal/app/thinkacademy/business/shop/bean/request/PerfectInforRequest;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudentInfo.kt */
final class StudentInfo$showPerfectInforDialog$1$1 extends Lambda implements Function2<PerfectInfor, PerfectInforRequest, Unit> {
    final /* synthetic */ XesBaseActivity $this_run;
    final /* synthetic */ StudentInfo this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StudentInfo.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PerfectInfor.values().length];
            iArr[PerfectInfor.CLOSE.ordinal()] = 1;
            iArr[PerfectInfor.PERFECTINFOR.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StudentInfo$showPerfectInforDialog$1$1(XesBaseActivity xesBaseActivity, StudentInfo studentInfo) {
        super(2);
        this.$this_run = xesBaseActivity;
        this.this$0 = studentInfo;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((PerfectInfor) obj, (PerfectInforRequest) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(PerfectInfor perfectInfor, PerfectInforRequest perfectInforRequest) {
        Intrinsics.checkNotNullParameter(perfectInfor, "perfectInfor");
        int i = WhenMappings.$EnumSwitchMapping$0[perfectInfor.ordinal()];
        if (i == 1) {
            Context context = this.$this_run;
            Intrinsics.checkNotNullExpressionValue(context, "this");
            new SecondaryConfirDialog(context, new StudentInfo$showPerfectInforDialog$1$1$dialog$1(this.this$0)).show();
        } else if (i == 2 && perfectInforRequest != null) {
            StudentInfo studentInfo = this.this$0;
            XesBaseActivity xesBaseActivity = this.$this_run;
            studentInfo.mPerfectInforRequest = perfectInforRequest;
            xesBaseActivity.showLoading();
            SeletedStudentViewModel mViewModel = studentInfo.getMViewModel();
            if (mViewModel != null) {
                mViewModel.modifyUserBasicInfo(perfectInforRequest.getAvatar(), perfectInforRequest.getNickName(), perfectInforRequest.getFirstName(), perfectInforRequest.getLastName(), Integer.valueOf(perfectInforRequest.getGrade()));
            }
        }
    }
}
