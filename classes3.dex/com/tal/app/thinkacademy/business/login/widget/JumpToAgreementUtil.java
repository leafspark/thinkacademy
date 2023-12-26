package com.tal.app.thinkacademy.business.login.widget;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.constants.UrlUtils;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.utils.TextHighLightUtil;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.StringUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004J\u0016\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/widget/JumpToAgreementUtil;", "", "()V", "JUMP_KEY", "", "MENU_CHILD_PRIVACY", "MENU_CLASS_TRANSFER", "MENU_COUPONS", "MENU_CUSTOMER_SUPPORT", "MENU_LOGOUT_POLICY", "MENU_MY_ADDRESSES", "MENU_MY_ORDERS", "MENU_ORDERS_NEW", "MENU_PRIVACY_POLICY", "MENU_TERMS_OF_USE", "MENU_TEST_RESULTS", "MENU_UNPAID_COURSES", "MENU_WISH_LIST", "jump2H5", "", "type", "context", "Landroid/content/Context;", "jump2PolicyTip", "loginAgreementTips", "view", "Landroid/widget/TextView;", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: JumpToAgreementUtil.kt */
public final class JumpToAgreementUtil {
    public static final JumpToAgreementUtil INSTANCE = new JumpToAgreementUtil();
    public static final String JUMP_KEY = "jump_key";
    public static final String MENU_CHILD_PRIVACY = "Child Privacy";
    public static final String MENU_CLASS_TRANSFER = "menu_class_transfer";
    public static final String MENU_COUPONS = "menu_coupons";
    public static final String MENU_CUSTOMER_SUPPORT = "Customer Support";
    public static final String MENU_LOGOUT_POLICY = "menu_logout_policy";
    public static final String MENU_MY_ADDRESSES = "menu_my_addresses";
    public static final String MENU_MY_ORDERS = "My orders";
    public static final String MENU_ORDERS_NEW = "menu_orders_new";
    public static final String MENU_PRIVACY_POLICY = "Privacy Policy";
    public static final String MENU_TERMS_OF_USE = "Terms of Use";
    public static final String MENU_TEST_RESULTS = "menu_test_results";
    public static final String MENU_UNPAID_COURSES = "menu_unpaid_courses";
    public static final String MENU_WISH_LIST = "menu_wish_list";

    private JumpToAgreementUtil() {
    }

    public static /* synthetic */ void jump2H5$default(JumpToAgreementUtil jumpToAgreementUtil, String str, Context context, int i, Object obj) {
        if ((i & 2) != 0) {
            Application app = Utils.getApp();
            Intrinsics.checkNotNullExpressionValue(app, "getApp()");
            context = app;
        }
        jumpToAgreementUtil.jump2H5(str, context);
    }

    public final void jump2H5(String str, Context context) {
        Intrinsics.checkNotNullParameter(str, ClassParamsKt.TYPE);
        Intrinsics.checkNotNullParameter(context, "context");
        String touchHost = UrlUtils.INSTANCE.getTouchHost();
        Bundle bundle = new Bundle();
        switch (str.hashCode()) {
            case -2057627091:
                if (str.equals(MENU_COUPONS)) {
                    if (!UserInfoBll.Companion.getInstance().isGuest()) {
                        StringBuffer stringBuffer = new StringBuffer(touchHost);
                        stringBuffer.append("/app-v2/my-coupons/list");
                        bundle.putString("jump_key", stringBuffer.toString());
                        bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).build());
                        XesRoute.getInstance().navigation("/login/coins_activity", bundle);
                        bundle.clear();
                        return;
                    }
                    XesRoute.getInstance().navigation("/login/login_activity");
                    return;
                }
                return;
            case -1715756738:
                if (str.equals(MENU_UNPAID_COURSES)) {
                    if (!UserInfoBll.Companion.getInstance().isGuest()) {
                        StringBuffer stringBuffer2 = new StringBuffer(touchHost);
                        stringBuffer2.append("/app-v2/my-unpaid-courses/list");
                        bundle.putString("jump_key", stringBuffer2.toString());
                        bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).build());
                        XesRoute.getInstance().navigation("/login/coins_activity", bundle);
                        bundle.clear();
                        return;
                    }
                    XesRoute.getInstance().navigation("/login/login_activity");
                    return;
                }
                return;
            case -1529299927:
                if (str.equals(MENU_TEST_RESULTS)) {
                    if (!UserInfoBll.Companion.getInstance().isGuest()) {
                        StringBuffer stringBuffer3 = new StringBuffer(touchHost);
                        stringBuffer3.append("/app-v2/test/test-results");
                        bundle.putString("jump_key", stringBuffer3.toString());
                        bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).build());
                        XesRoute.getInstance().navigation("/login/coins_activity", bundle);
                        bundle.clear();
                        return;
                    }
                    XesRoute.getInstance().navigation("/login/login_activity");
                    return;
                }
                return;
            case -1205880435:
                if (str.equals(MENU_CUSTOMER_SUPPORT)) {
                    if (!UserInfoBll.Companion.getInstance().isGuest()) {
                        StringBuffer stringBuffer4 = new StringBuffer(touchHost);
                        stringBuffer4.append("/app/faq");
                        bundle.putString("jump_key", stringBuffer4.toString());
                        bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).setLocalTitle(context.getString(R.string.customer_support)).build());
                        XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
                        bundle.clear();
                        return;
                    }
                    XesRoute.getInstance().navigation("/login/login_activity");
                    return;
                }
                return;
            case -1069410038:
                if (str.equals(MENU_PRIVACY_POLICY)) {
                    StringBuffer stringBuffer5 = new StringBuffer(touchHost);
                    stringBuffer5.append("/app/privacy-policy");
                    bundle.putString("jump_key", stringBuffer5.toString());
                    bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).setLocalTitle(MENU_PRIVACY_POLICY).build());
                    XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
                    bundle.clear();
                    return;
                }
                return;
            case -831602650:
                if (str.equals(MENU_ORDERS_NEW)) {
                    if (!UserInfoBll.Companion.getInstance().isGuest()) {
                        StringBuffer stringBuffer6 = new StringBuffer(touchHost);
                        stringBuffer6.append("/app-v2/order/list");
                        bundle.putString("jump_key", stringBuffer6.toString());
                        bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).build());
                        XesRoute.getInstance().navigation("/login/coins_activity", bundle);
                        bundle.clear();
                        return;
                    }
                    XesRoute.getInstance().navigation("/login/login_activity");
                    return;
                }
                return;
            case -459694012:
                if (str.equals(MENU_CHILD_PRIVACY)) {
                    StringBuffer stringBuffer7 = new StringBuffer(touchHost);
                    stringBuffer7.append("/policyTip/childPrivacy");
                    bundle.putString("jump_key", stringBuffer7.toString());
                    bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).setLocalTitle(MENU_CHILD_PRIVACY).build());
                    XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
                    bundle.clear();
                    return;
                }
                return;
            case 201422258:
                if (str.equals(MENU_CLASS_TRANSFER)) {
                    if (!UserInfoBll.Companion.getInstance().isGuest()) {
                        StringBuffer stringBuffer8 = new StringBuffer(touchHost);
                        stringBuffer8.append("/app-v2/my-class-transfer");
                        bundle.putString("jump_key", stringBuffer8.toString());
                        bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).build());
                        XesRoute.getInstance().navigation("/login/coins_activity", bundle);
                        bundle.clear();
                        return;
                    }
                    XesRoute.getInstance().navigation("/login/login_activity");
                    return;
                }
                return;
            case 313156537:
                if (str.equals(MENU_MY_ORDERS)) {
                    if (!UserInfoBll.Companion.getInstance().isGuest()) {
                        StringBuffer stringBuffer9 = new StringBuffer(touchHost);
                        stringBuffer9.append("/app/order/list");
                        bundle.putString("jump_key", stringBuffer9.toString());
                        bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).build());
                        XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
                        bundle.clear();
                        return;
                    }
                    XesRoute.getInstance().navigation("/login/login_activity");
                    return;
                }
                return;
            case 945954935:
                if (str.equals(MENU_TERMS_OF_USE)) {
                    StringBuffer stringBuffer10 = new StringBuffer(touchHost);
                    stringBuffer10.append("/app/terms-of-use");
                    bundle.putString("jump_key", stringBuffer10.toString());
                    bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).setLocalTitle(MENU_TERMS_OF_USE).build());
                    XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
                    bundle.clear();
                    return;
                }
                return;
            case 1220095574:
                if (str.equals(MENU_WISH_LIST)) {
                    if (!UserInfoBll.Companion.getInstance().isGuest()) {
                        StringBuffer stringBuffer11 = new StringBuffer(touchHost);
                        stringBuffer11.append("/app-v2/my-wish/list");
                        bundle.putString("jump_key", stringBuffer11.toString());
                        bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).build());
                        XesRoute.getInstance().navigation("/login/coins_activity", bundle);
                        bundle.clear();
                        return;
                    }
                    XesRoute.getInstance().navigation("/login/login_activity");
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void jump2PolicyTip(String str) {
        Intrinsics.checkNotNullParameter(str, ClassParamsKt.TYPE);
        String studentHost = UrlUtils.INSTANCE.getStudentHost();
        Bundle bundle = new Bundle();
        switch (str.hashCode()) {
            case -1069410038:
                if (str.equals(MENU_PRIVACY_POLICY)) {
                    StringBuffer stringBuffer = new StringBuffer(studentHost);
                    stringBuffer.append("policyTip/privacyPolicy");
                    bundle.putString("jump_key", stringBuffer.toString());
                    bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).setLocalTitle(StringUtils.getString(R.string.Privacy_Policy)).build());
                    XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
                    bundle.clear();
                    return;
                }
                return;
            case -459694012:
                if (str.equals(MENU_CHILD_PRIVACY)) {
                    StringBuffer stringBuffer2 = new StringBuffer(studentHost);
                    stringBuffer2.append("policyTip/childPrivacy");
                    bundle.putString("jump_key", stringBuffer2.toString());
                    bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).setLocalTitle(StringUtils.getString(R.string.Child_Privacy)).build());
                    XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
                    bundle.clear();
                    return;
                }
                return;
            case 843162543:
                if (str.equals(MENU_MY_ADDRESSES)) {
                    StringBuffer stringBuffer3 = new StringBuffer(studentHost);
                    stringBuffer3.append("myAddresses");
                    bundle.putString("jump_key", stringBuffer3.toString());
                    bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).build());
                    XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
                    bundle.clear();
                    return;
                }
                return;
            case 945954935:
                if (str.equals(MENU_TERMS_OF_USE)) {
                    StringBuffer stringBuffer4 = new StringBuffer(studentHost);
                    stringBuffer4.append("policyTip/termsOfUse");
                    bundle.putString("jump_key", stringBuffer4.toString());
                    bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).setLocalTitle(StringUtils.getString(R.string.Terms_of_Use)).build());
                    XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
                    bundle.clear();
                    return;
                }
                return;
            case 1505407655:
                if (str.equals(MENU_LOGOUT_POLICY)) {
                    StringBuffer stringBuffer5 = new StringBuffer(studentHost);
                    stringBuffer5.append("policyTip/logoutPolicy");
                    bundle.putString("jump_key", stringBuffer5.toString());
                    bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).setLocalTitle(StringUtils.getString(R.string.login_delete_account)).build());
                    XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
                    bundle.clear();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void loginAgreementTips(Context context, TextView textView) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textView, "view");
        if (SchoolConstants.INSTANCE.hasChildPrivacyAgreement()) {
            str = context.getString(R.string.login_privacy_tips_child);
        } else {
            str = context.getString(R.string.login_privacy_tips);
        }
        String str2 = str;
        Intrinsics.checkNotNullExpressionValue(str2, "if (SchoolConstants.hasC…tring.login_privacy_tips)");
        TextHighLightUtil textHighLightUtil = TextHighLightUtil.INSTANCE;
        String string = context.getString(R.string.Terms_of_Use);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.Terms_of_Use)");
        String string2 = context.getString(R.string.Privacy_Policy);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.Privacy_Policy)");
        String string3 = context.getString(R.string.Child_Privacy);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.Child_Privacy)");
        textHighLightUtil.setTextHighLightWithClicks(textView, str2, new String[]{string, string2, string3}, new Integer[]{Integer.valueOf(R.color.color_3370FF), Integer.valueOf(R.color.color_3370FF), Integer.valueOf(R.color.color_3370FF)}, new View.OnClickListener[]{JumpToAgreementUtil$$ExternalSyntheticLambda0.INSTANCE, JumpToAgreementUtil$$ExternalSyntheticLambda1.INSTANCE, JumpToAgreementUtil$$ExternalSyntheticLambda2.INSTANCE});
    }

    /* access modifiers changed from: private */
    /* renamed from: loginAgreementTips$lambda-0  reason: not valid java name */
    public static final void m171loginAgreementTips$lambda0(View view) {
        INSTANCE.jump2PolicyTip(MENU_TERMS_OF_USE);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: loginAgreementTips$lambda-1  reason: not valid java name */
    public static final void m172loginAgreementTips$lambda1(View view) {
        INSTANCE.jump2PolicyTip(MENU_PRIVACY_POLICY);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: loginAgreementTips$lambda-2  reason: not valid java name */
    public static final void m173loginAgreementTips$lambda2(View view) {
        INSTANCE.jump2PolicyTip(MENU_CHILD_PRIVACY);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
