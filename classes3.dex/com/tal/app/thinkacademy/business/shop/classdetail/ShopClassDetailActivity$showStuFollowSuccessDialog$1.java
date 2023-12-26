package com.tal.app.thinkacademy.business.shop.classdetail;

import android.os.Bundle;
import com.tal.app.thinkacademy.business.shop.classdetail.dialog.ReminderTwoButton;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.constants.UrlUtils;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/ReminderTwoButton$ButtonType;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailActivity.kt */
final class ShopClassDetailActivity$showStuFollowSuccessDialog$1 extends Lambda implements Function1<ReminderTwoButton.ButtonType, Unit> {
    final /* synthetic */ ShopClassDetailActivity this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShopClassDetailActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReminderTwoButton.ButtonType.values().length];
            iArr[ReminderTwoButton.ButtonType.BUTTON_LEFT.ordinal()] = 1;
            iArr[ReminderTwoButton.ButtonType.BUTTON_RIGHT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopClassDetailActivity$showStuFollowSuccessDialog$1(ShopClassDetailActivity shopClassDetailActivity) {
        super(1);
        this.this$0 = shopClassDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ReminderTwoButton.ButtonType) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ReminderTwoButton.ButtonType buttonType) {
        Intrinsics.checkNotNullParameter(buttonType, "it");
        int i = WhenMappings.$EnumSwitchMapping$0[buttonType.ordinal()];
        if (i == 1) {
            String touchHost = UrlUtils.INSTANCE.getTouchHost();
            Bundle bundle = new Bundle();
            StringBuffer stringBuffer = new StringBuffer(touchHost);
            stringBuffer.append("/app-v2/my-wish/list");
            bundle.putString("jump_key", stringBuffer.toString());
            bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).build());
            XesRoute.getInstance().navigation("/login/coins_activity", bundle);
            if (!this.this$0.mTempIsWished) {
                ShopTrack.INSTANCE.hw_classdetal_notify1_wish_list_click(this.this$0.mClassId);
            }
        } else if (i == 2) {
            if (this.this$0.mTempIsWished) {
                ShopTrack.INSTANCE.hw_classdetal_notify2_got_click(this.this$0.mClassId);
            } else {
                ShopTrack.INSTANCE.hw_classdetal_notify1_got_click(this.this$0.mClassId);
            }
        }
    }
}
