package com.tal.app.thinkacademy.business.login.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.view.devicetest.DeviceTestActivity;
import com.tal.app.thinkacademy.business.login.view.item.MyPageRecyclerItem;
import com.tal.app.thinkacademy.business.login.widget.JumpToAgreementUtil;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.CommonKtxKt;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.imconfig.SchoolDataInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "myPageRecyclerItem", "Lcom/tal/app/thinkacademy/business/login/view/item/MyPageRecyclerItem;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MePageFragment.kt */
final class MePageFragment$setRecyclerView$1 extends Lambda implements Function2<MyPageRecyclerItem, Integer, Unit> {
    final /* synthetic */ MePageFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MePageFragment$setRecyclerView$1(MePageFragment mePageFragment) {
        super(2);
        this.this$0 = mePageFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((MyPageRecyclerItem) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(MyPageRecyclerItem myPageRecyclerItem, int i) {
        boolean z;
        String coinDetailUrl;
        Intrinsics.checkNotNullParameter(myPageRecyclerItem, "myPageRecyclerItem");
        if (this.this$0.isNetWorked()) {
            String key = myPageRecyclerItem.getKey();
            switch (key.hashCode()) {
                case -2087981620:
                    if (key.equals("COURSE_TESTING")) {
                        if (!UserInfoBll.Companion.getInstance().isGuest()) {
                            this.this$0.startActivity(new Intent(this.this$0.getActivity(), DeviceTestActivity.class));
                            return;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("login_page_path", "settings");
                        XesRoute.getInstance().navigation("/login/login_activity", bundle);
                        return;
                    }
                    return;
                case -2077709277:
                    if (key.equals("SETTINGS")) {
                        if (!UserInfoBll.Companion.getInstance().isGuest()) {
                            this.this$0.startActivity(new Intent(this.this$0.getActivity(), SettingsActivity.class));
                            return;
                        }
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("login_page_path", "settings");
                        XesRoute.getInstance().navigation("/login/login_activity", bundle2);
                        return;
                    }
                    return;
                case -1529299927:
                    if (key.equals(JumpToAgreementUtil.MENU_TEST_RESULTS)) {
                        JumpToAgreementUtil.jump2H5$default(JumpToAgreementUtil.INSTANCE, JumpToAgreementUtil.MENU_TEST_RESULTS, (Context) null, 2, (Object) null);
                        return;
                    }
                    return;
                case -1205880435:
                    if (key.equals(JumpToAgreementUtil.MENU_CUSTOMER_SUPPORT)) {
                        JumpToAgreementUtil.jump2H5$default(JumpToAgreementUtil.INSTANCE, JumpToAgreementUtil.MENU_CUSTOMER_SUPPORT, (Context) null, 2, (Object) null);
                        return;
                    }
                    return;
                case 201422258:
                    if (key.equals(JumpToAgreementUtil.MENU_CLASS_TRANSFER)) {
                        JumpToAgreementUtil.jump2H5$default(JumpToAgreementUtil.INSTANCE, JumpToAgreementUtil.MENU_CLASS_TRANSFER, (Context) null, 2, (Object) null);
                        return;
                    }
                    return;
                case 313156537:
                    if (key.equals(JumpToAgreementUtil.MENU_MY_ORDERS)) {
                        this.this$0.track("click_my_orders");
                        JumpToAgreementUtil.jump2H5$default(JumpToAgreementUtil.INSTANCE, JumpToAgreementUtil.MENU_MY_ORDERS, (Context) null, 2, (Object) null);
                        return;
                    }
                    return;
                case 591125381:
                    if (key.equals("FEEDBACK")) {
                        if (!UserInfoBll.Companion.getInstance().isGuest()) {
                            this.this$0.uploadLog();
                            this.this$0.track("app_click_feedback");
                            this.this$0.startActivity(new Intent(this.this$0.getActivity(), FeedbackActivity.class));
                            return;
                        }
                        XesRoute.getInstance().navigation("/login/login_activity");
                        return;
                    }
                    return;
                case 1220095574:
                    if (key.equals(JumpToAgreementUtil.MENU_WISH_LIST)) {
                        JumpToAgreementUtil.jump2H5$default(JumpToAgreementUtil.INSTANCE, JumpToAgreementUtil.MENU_WISH_LIST, (Context) null, 2, (Object) null);
                        return;
                    }
                    return;
                case 1683946577:
                    if (key.equals("About Us")) {
                        this.this$0.startActivity(new Intent(this.this$0.getActivity(), AboutUsActivity.class));
                        return;
                    }
                    return;
                case 2047592590:
                    if (key.equals("My Coins")) {
                        if (!UserInfoBll.Companion.getInstance().isGuest()) {
                            Bundle bundle3 = new Bundle();
                            SchoolDataInfo currentSchoolInfo = SchoolConstants.INSTANCE.getCurrentSchoolInfo();
                            if (currentSchoolInfo != null && currentSchoolInfo.getCoinStoreEnabled()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            String str = "";
                            if (!z ? !(currentSchoolInfo == null || (coinDetailUrl = currentSchoolInfo.getCoinDetailUrl()) == null) : (coinDetailUrl = currentSchoolInfo.getCoinMallUrl()) != null) {
                                str = coinDetailUrl;
                            }
                            bundle3.putString("jump_key", Intrinsics.stringPlus(str, StringsKt.contains$default(str, "?", false, 2, (Object) null) ? "&previous_source=个人中心入口" : "?previous_source=个人中心入口"));
                            bundle3.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).build());
                            XesRoute.getInstance().navigation("/login/coins_activity", bundle3);
                            bundle3.clear();
                            return;
                        }
                        XesRoute.getInstance().navigation("/login/login_activity");
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (!UserInfoBll.Companion.getInstance().isGuest() || !Intrinsics.areEqual((Object) myPageRecyclerItem.getKey(), (Object) JumpToAgreementUtil.MENU_MY_ORDERS)) {
            ToastUtils.setGravity(17, 0, 0);
            String string = this.this$0.getString(R.string.login_no_network);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.login_no_network)");
            ToastUtils.showShort(CommonKtxKt.formatDevice(string), new Object[0]);
        } else {
            XesRoute.getInstance().navigation("/login/login_activity");
        }
    }
}
