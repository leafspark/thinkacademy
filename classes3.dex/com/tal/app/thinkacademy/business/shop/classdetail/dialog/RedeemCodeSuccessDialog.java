package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.flyco.roundview.RoundTextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.bean.RedeemCodeResponse;
import com.tal.app.thinkacademy.business.shop.bean.RedeemCodeResponseGrade;
import com.tal.app.thinkacademy.business.shop.databinding.ShopRedeemSuccessDialogLayoutBinding;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.constants.UrlUtils;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/dialog/RedeemCodeSuccessDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/shop/databinding/ShopRedeemSuccessDialogLayoutBinding;", "context", "Landroid/content/Context;", "listener", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "mIsContinue", "", "mListener", "mRedeemCode", "", "mStarList", "", "Landroid/widget/ImageView;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "setData", "isContinueTogo", "redeemCode", "info", "Lcom/tal/app/thinkacademy/business/shop/bean/RedeemCodeResponse;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedeemCodeSuccessDialog.kt */
public final class RedeemCodeSuccessDialog extends BaseBindDialog<ShopRedeemSuccessDialogLayoutBinding> {
    private boolean mIsContinue;
    private Function0<Unit> mListener;
    private String mRedeemCode;
    private final List<ImageView> mStarList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RedeemCodeSuccessDialog(Context context, Function0<Unit> function0) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        List<ImageView> arrayList = new ArrayList<>();
        this.mStarList = arrayList;
        this.mRedeemCode = "";
        this.mListener = function0;
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
        this.binding.dialogClose.setOnClickListener(new RedeemCodeSuccessDialog$$ExternalSyntheticLambda1(this));
        ImageView imageView = this.binding.difficulty1;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.difficulty1");
        arrayList.add(imageView);
        ImageView imageView2 = this.binding.difficulty2;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.difficulty2");
        arrayList.add(imageView2);
        ImageView imageView3 = this.binding.difficulty3;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.difficulty3");
        arrayList.add(imageView3);
        ImageView imageView4 = this.binding.difficulty4;
        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.difficulty4");
        arrayList.add(imageView4);
        ImageView imageView5 = this.binding.difficulty5;
        Intrinsics.checkNotNullExpressionValue(imageView5, "binding.difficulty5");
        arrayList.add(imageView5);
        this.binding.btnGotoContinue.setOnClickListener(new RedeemCodeSuccessDialog$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RedeemCodeSuccessDialog(Context context, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : function0);
    }

    /* access modifiers changed from: protected */
    public ShopRedeemSuccessDialogLayoutBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ShopRedeemSuccessDialogLayoutBinding inflate = ShopRedeemSuccessDialogLayoutBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m304_init_$lambda1(RedeemCodeSuccessDialog redeemCodeSuccessDialog, View view) {
        Intrinsics.checkNotNullParameter(redeemCodeSuccessDialog, "this$0");
        redeemCodeSuccessDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m305_init_$lambda2(RedeemCodeSuccessDialog redeemCodeSuccessDialog, View view) {
        Intrinsics.checkNotNullParameter(redeemCodeSuccessDialog, "this$0");
        if (!redeemCodeSuccessDialog.mIsContinue) {
            String touchHost = UrlUtils.INSTANCE.getTouchHost();
            Bundle bundle = new Bundle();
            StringBuffer stringBuffer = new StringBuffer(touchHost);
            stringBuffer.append(Intrinsics.stringPlus("/app-v2/test/recommended-classes/", redeemCodeSuccessDialog.mRedeemCode));
            bundle.putString("jump_key", stringBuffer.toString());
            bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).build());
            XesRoute.getInstance().navigation("/login/coins_activity", bundle);
        } else {
            Function0<Unit> function0 = redeemCodeSuccessDialog.mListener;
            if (function0 != null) {
                function0.invoke();
            }
        }
        redeemCodeSuccessDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void setData(boolean z, String str, RedeemCodeResponse redeemCodeResponse) {
        CharSequence charSequence;
        String str2;
        Intrinsics.checkNotNullParameter(str, "redeemCode");
        this.mRedeemCode = str;
        this.mIsContinue = z;
        if (redeemCodeResponse != null) {
            RoundTextView roundTextView = this.binding.btnGotoContinue;
            if (this.mIsContinue) {
                charSequence = getContext().getString(R.string.redeem_continue_to_registration);
            } else {
                charSequence = getContext().getString(R.string.redeem_check_available_classes);
            }
            roundTextView.setText(charSequence);
            List<RedeemCodeResponseGrade> gradeList = redeemCodeResponse.getGradeList();
            String str3 = "";
            if (!(gradeList != null && (gradeList.isEmpty() ^ true)) || (str2 = redeemCodeResponse.getGradeList().get(0).getGradeName()) == null) {
                str2 = str3;
            }
            String subjectName = redeemCodeResponse.getSubjectName();
            if (subjectName != null) {
                str3 = subjectName;
            }
            this.binding.levelDegreeName.setText(redeemCodeResponse.getLevelDegreeName());
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%s %s", Arrays.copyOf(new Object[]{str2, str3}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            TextView textView = this.binding.redeemDesc;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String string = getContext().getString(R.string.redeem_desc);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.redeem_desc)");
            String format2 = String.format(string, Arrays.copyOf(new Object[]{format}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            textView.setText(format2);
            int levelDegreeStar = redeemCodeResponse.getLevelDegreeStar();
            if (levelDegreeStar > 5) {
                levelDegreeStar = 5;
            }
            if (levelDegreeStar < 0) {
                levelDegreeStar = 0;
            }
            int i = 0;
            for (Object next : this.mStarList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ((ImageView) next).setSelected(i < levelDegreeStar);
                i = i2;
            }
        }
    }
}
