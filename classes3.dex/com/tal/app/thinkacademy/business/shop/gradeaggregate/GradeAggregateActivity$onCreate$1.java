package com.tal.app.thinkacademy.business.shop.gradeaggregate;

import com.tal.app.thinkacademy.business.shop.classdetail.AccountListTypeEnum;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tal/app/thinkacademy/business/shop/classdetail/AccountListTypeEnum;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateActivity.kt */
final class GradeAggregateActivity$onCreate$1 extends Lambda implements Function1<AccountListTypeEnum, Unit> {
    final /* synthetic */ GradeAggregateActivity this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GradeAggregateActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AccountListTypeEnum.values().length];
            iArr[AccountListTypeEnum.Admission.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GradeAggregateActivity$onCreate$1(GradeAggregateActivity gradeAggregateActivity) {
        super(1);
        this.this$0 = gradeAggregateActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AccountListTypeEnum) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(AccountListTypeEnum accountListTypeEnum) {
        Intrinsics.checkNotNullParameter(accountListTypeEnum, "it");
        if (WhenMappings.$EnumSwitchMapping$0[accountListTypeEnum.ordinal()] == 1) {
            GradeAggregateActivity gradeAggregateActivity = this.this$0;
            gradeAggregateActivity.gotoAdmissionTest(gradeAggregateActivity.examId);
        }
    }
}
