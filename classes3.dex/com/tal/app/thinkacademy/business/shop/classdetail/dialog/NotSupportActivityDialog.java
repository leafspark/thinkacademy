package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.databinding.ShopNotSupportActivityDialogLayoutBinding;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.constants.UrlUtils;
import com.tal.app.thinkacademy.common.utils.TextHighLightUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0014R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/NotSupportActivityDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/shop/databinding/ShopNotSupportActivityDialogLayoutBinding;", "context", "Landroid/content/Context;", "skuId", "", "listener", "Lkotlin/Function0;", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "mListener", "mSkuId", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NotSupportActivityDialog.kt */
public final class NotSupportActivityDialog extends BaseBindDialog<ShopNotSupportActivityDialogLayoutBinding> {
    private Function0<Unit> mListener;
    private String mSkuId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotSupportActivityDialog(Context context, String str, Function0<Unit> function0) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "skuId");
        this.mListener = function0;
        this.mSkuId = str;
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window == null ? null : window.getAttributes();
        if (attributes != null) {
            attributes.width = -1;
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
        gravity(80);
        animType(BaseDialog.AnimInType.BOTTOM);
        this.binding.dialogClose.setOnClickListener(new NotSupportActivityDialog$$ExternalSyntheticLambda2(this));
        Intrinsics.checkNotNullExpressionValue(context.getString(R.string.not_support_dialog_msg_high_light), "context.getString(R.stri…rt_dialog_msg_high_light)");
        String string = context.getString(R.string.not_support_dialog_msg);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.not_support_dialog_msg)");
        this.binding.notSupportMsg.setText(string);
        this.binding.notSupportBtn.setOnClickListener(new NotSupportActivityDialog$$ExternalSyntheticLambda0(this));
        String string2 = context.getString(R.string.not_support_dialog_tips_high_ligt);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…rt_dialog_tips_high_ligt)");
        String string3 = context.getString(R.string.not_support_dialog_tips);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri….not_support_dialog_tips)");
        TextHighLightUtil textHighLightUtil = TextHighLightUtil.INSTANCE;
        TextView textView = this.binding.notSupportTips;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.notSupportTips");
        textHighLightUtil.setTextHighLightWithClick(textView, string3, string2, R.color.color_ffaa0a, new NotSupportActivityDialog$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NotSupportActivityDialog(Context context, String str, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? null : function0);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m295_init_$lambda1(NotSupportActivityDialog notSupportActivityDialog, View view) {
        Intrinsics.checkNotNullParameter(notSupportActivityDialog, "this$0");
        notSupportActivityDialog.dismiss();
        Function0<Unit> function0 = notSupportActivityDialog.mListener;
        if (function0 != null) {
            function0.invoke();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m296_init_$lambda2(NotSupportActivityDialog notSupportActivityDialog, View view) {
        Intrinsics.checkNotNullParameter(notSupportActivityDialog, "this$0");
        String touchHost = UrlUtils.INSTANCE.getTouchHost();
        Bundle bundle = new Bundle();
        StringBuffer stringBuffer = new StringBuffer(touchHost);
        stringBuffer.append(Intrinsics.stringPlus("/app-v2/courses/detail/", notSupportActivityDialog.mSkuId));
        bundle.putBoolean("can_use_cache", true);
        bundle.putString("cache_jump_url", Intrinsics.stringPlus("/courses/detail/", notSupportActivityDialog.mSkuId));
        bundle.putString("jump_key", stringBuffer.toString());
        bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).build());
        XesRoute.getInstance().navigation("/login/coins_activity", bundle);
        notSupportActivityDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final void m297_init_$lambda3(NotSupportActivityDialog notSupportActivityDialog, View view) {
        Intrinsics.checkNotNullParameter(notSupportActivityDialog, "this$0");
        notSupportActivityDialog.dismiss();
        Function0<Unit> function0 = notSupportActivityDialog.mListener;
        if (function0 != null) {
            function0.invoke();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: protected */
    public ShopNotSupportActivityDialogLayoutBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ShopNotSupportActivityDialogLayoutBinding inflate = ShopNotSupportActivityDialogLayoutBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
