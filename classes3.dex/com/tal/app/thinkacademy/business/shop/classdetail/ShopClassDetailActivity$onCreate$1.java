package com.tal.app.thinkacademy.business.shop.classdetail;

import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailExamEntrance;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tal/app/thinkacademy/business/shop/classdetail/AccountListTypeEnum;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailActivity.kt */
final class ShopClassDetailActivity$onCreate$1 extends Lambda implements Function1<AccountListTypeEnum, Unit> {
    final /* synthetic */ ShopClassDetailActivity this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShopClassDetailActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AccountListTypeEnum.values().length];
            iArr[AccountListTypeEnum.GoToBuy.ordinal()] = 1;
            iArr[AccountListTypeEnum.Admission.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopClassDetailActivity$onCreate$1(ShopClassDetailActivity shopClassDetailActivity) {
        super(1);
        this.this$0 = shopClassDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AccountListTypeEnum) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(AccountListTypeEnum accountListTypeEnum) {
        ShopClassDetailExamEntrance examEntrance;
        Intrinsics.checkNotNullParameter(accountListTypeEnum, "it");
        int i = WhenMappings.$EnumSwitchMapping$0[accountListTypeEnum.ordinal()];
        if (i == 1) {
            this.this$0.diagnosisProcess();
        } else if (i == 2) {
            ShopClassDetailActivity shopClassDetailActivity = this.this$0;
            ShopClassDetailInfoBean access$getMShopClassDetailInfoBean$p = shopClassDetailActivity.mShopClassDetailInfoBean;
            Integer num = null;
            if (!(access$getMShopClassDetailInfoBean$p == null || (examEntrance = access$getMShopClassDetailInfoBean$p.getExamEntrance()) == null)) {
                num = Integer.valueOf(examEntrance.getExamId());
            }
            shopClassDetailActivity.gotoAdmissionTest(String.valueOf(num));
        }
    }
}
