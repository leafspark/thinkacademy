package com.tal.app.thinkacademy.business.shop.classdetail;

import com.tal.app.thinkacademy.business.shop.classdetail.dialog.ChooseStudent;
import com.tal.app.thinkacademy.business.shop.viewmodel.SeletedStudentViewModel;
import com.tal.app.thinkacademy.common.base.XesBaseActivity;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "chooose", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/ChooseStudent;", "isSwitch", "", "uid", "", "invoke", "(Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/ChooseStudent;Ljava/lang/Boolean;Ljava/lang/String;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudentInfo.kt */
final class StudentInfo$showChooseStudentDialog$1$1 extends Lambda implements Function3<ChooseStudent, Boolean, String, Unit> {
    final /* synthetic */ XesBaseActivity $this_run;
    final /* synthetic */ StudentInfo this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StudentInfo.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ChooseStudent.values().length];
            iArr[ChooseStudent.ADDSTUDENT.ordinal()] = 1;
            iArr[ChooseStudent.CONTINUE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StudentInfo$showChooseStudentDialog$1$1(StudentInfo studentInfo, XesBaseActivity xesBaseActivity) {
        super(3);
        this.this$0 = studentInfo;
        this.$this_run = xesBaseActivity;
    }

    public final void invoke(ChooseStudent chooseStudent, Boolean bool, String str) {
        Intrinsics.checkNotNullParameter(chooseStudent, "chooose");
        int i = WhenMappings.$EnumSwitchMapping$0[chooseStudent.ordinal()];
        if (i != 1) {
            if (i == 2) {
                if (Intrinsics.areEqual((Object) bool, (Object) true)) {
                    CharSequence charSequence = str;
                    if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                        XesLog.dt(this.this$0.TAG, new Object[]{"选择账号：继续，切换账号"});
                        this.this$0.mSwitchLogin = SwitchLogin.OnlySwitch;
                        this.$this_run.showLoading();
                        SeletedStudentViewModel mViewModel = this.this$0.getMViewModel();
                        if (mViewModel != null) {
                            mViewModel.switchLogin(str);
                            return;
                        }
                        return;
                    }
                    XesLog.et(this.this$0.TAG, new Object[]{"选择账号：继续，uid为空了，中断流程"});
                    return;
                }
                XesLog.dt(this.this$0.TAG, new Object[]{"选择账号：继续，不需要切换账号，直接购买"});
                Function1<AccountListTypeEnum, Unit> listener = this.this$0.getListener();
                if (listener != null) {
                    listener.invoke(this.this$0.mAccountListTypeEnum);
                }
            }
        } else if (this.this$0.mGradeStageList.isEmpty()) {
            XesLog.dt(this.this$0.TAG, new Object[]{"选择账号：添加账号，无年级列表，先请求年级列表"});
            this.this$0.mGradeStageListEnum = GradeStageListEnum.AddStudent;
            this.this$0.getActivity().showLoading();
            SeletedStudentViewModel mViewModel2 = this.this$0.getMViewModel();
            if (mViewModel2 != null) {
                mViewModel2.getGradeStageList();
            }
        } else {
            XesLog.dt(this.this$0.TAG, new Object[]{"选择账号：添加账号，有年级列表，弹窗添加账号"});
            this.this$0.showAddStudentDialog();
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((ChooseStudent) obj, (Boolean) obj2, (String) obj3);
        return Unit.INSTANCE;
    }
}
