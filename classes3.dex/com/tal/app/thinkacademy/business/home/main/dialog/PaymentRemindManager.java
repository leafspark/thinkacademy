package com.tal.app.thinkacademy.business.home.main.dialog;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.home.R;
import com.tal.app.thinkacademy.business.home.databinding.HomeDialogPaymentReminderBinding;
import com.tal.app.thinkacademy.business.home.main.LaunchTrack;
import com.tal.app.thinkacademy.business.home.main.bean.UnPayNum;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0011R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0018\u00010\nR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/dialog/PaymentRemindManager;", "", "context", "Landroid/content/Context;", "unPayNum", "Lcom/tal/app/thinkacademy/business/home/main/bean/UnPayNum;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/business/home/main/bean/UnPayNum;)V", "MAX_DIFFER", "", "dialog", "Lcom/tal/app/thinkacademy/business/home/main/dialog/PaymentRemindManager$PaymentRemindDialog;", "incar", "unpay", "getText", "", "resId", "show", "", "mode", "showDialog", "", "showPoint", "PaymentRemindDialog", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentRemindManager.kt */
public final class PaymentRemindManager {
    private final int MAX_DIFFER = 259200;
    /* access modifiers changed from: private */
    public final Context context;
    private PaymentRemindDialog dialog;
    private final int incar;
    private final int unpay;

    public PaymentRemindManager(Context context2, UnPayNum unPayNum) {
        String str;
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        String str2 = null;
        if (unPayNum == null) {
            str = null;
        } else {
            str = unPayNum.getToBeContinueSku();
        }
        this.unpay = ParseUtils.tryParseInt(str, 0);
        this.incar = ParseUtils.tryParseInt(unPayNum != null ? unPayNum.getInCartSku() : str2, 0);
    }

    public final void showPoint() {
        long currentTimeMillis = (System.currentTimeMillis() / ((long) 1000)) - ShareDataManager.getInstance().getLong("shopping_unpay_red_point_time", 0, ShareDataManager.SHAREDATA_USER);
        XesLog.dt("PaymentRemindManager", new Object[]{Intrinsics.stringPlus("showPoint differ = ", Long.valueOf(currentTimeMillis))});
        if (currentTimeMillis > ((long) this.MAX_DIFFER) && this.unpay + this.incar > 0) {
            XesDataBus.with("home_tab_red_point").postStickyData(new Pair("TAB_ME", true));
            XesDataBus.with("me_page_unpay_num").postStickyData(Integer.valueOf(this.unpay + this.incar));
        }
    }

    public final boolean showDialog() {
        long currentTimeMillis = (System.currentTimeMillis() / ((long) 1000)) - ShareDataManager.getInstance().getLong("shopping_unpay_home_dialog_time", 0, ShareDataManager.SHAREDATA_USER);
        XesLog.dt("PaymentRemindManager", new Object[]{Intrinsics.stringPlus("showDialog differ = ", Long.valueOf(currentTimeMillis))});
        if (currentTimeMillis > ((long) this.MAX_DIFFER)) {
            if (this.unpay > 0) {
                show(1);
                return true;
            } else if (this.incar > 0) {
                show(2);
                return true;
            }
        }
        return false;
    }

    private final void show(int i) {
        if (this.dialog == null) {
            this.dialog = new PaymentRemindDialog(this, i);
        }
        PaymentRemindDialog paymentRemindDialog = this.dialog;
        if (paymentRemindDialog != null) {
            paymentRemindDialog.show();
        }
        ShareDataManager.getInstance().put("shopping_unpay_home_dialog_time", System.currentTimeMillis() / ((long) 1000), ShareDataManager.SHAREDATA_USER);
        LaunchTrack.INSTANCE.showDialog(i);
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0014J7\u0010\r\u001a\u00060\u0000R\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\t0\u0007H\u0002J\u001a\u0010\u0014\u001a\u00060\u0000R\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/dialog/PaymentRemindManager$PaymentRemindDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/home/databinding/HomeDialogPaymentReminderBinding;", "mode", "", "(Lcom/tal/app/thinkacademy/business/home/main/dialog/PaymentRemindManager;I)V", "positiveAction", "Lkotlin/Function1;", "", "", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "setPositiveButton", "Lcom/tal/app/thinkacademy/business/home/main/dialog/PaymentRemindManager;", "text", "action", "Lkotlin/ParameterName;", "name", "buttonName", "setTitleAndMsg", "title", "message", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentRemindManager.kt */
    public final class PaymentRemindDialog extends BaseBindDialog<HomeDialogPaymentReminderBinding> {
        /* access modifiers changed from: private */
        public final int mode;
        private final Function1<String, Unit> positiveAction;
        final /* synthetic */ PaymentRemindManager this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PaymentRemindDialog(PaymentRemindManager paymentRemindManager, int i) {
            super(paymentRemindManager.context);
            Intrinsics.checkNotNullParameter(paymentRemindManager, "this$0");
            this.this$0 = paymentRemindManager;
            this.mode = i;
            Function1<String, Unit> paymentRemindManager$PaymentRemindDialog$positiveAction$1 = new PaymentRemindManager$PaymentRemindDialog$positiveAction$1(this);
            this.positiveAction = paymentRemindManager$PaymentRemindDialog$positiveAction$1;
            layoutParams(new LinearLayout.LayoutParams(-1, -1));
            gravity(80);
            this.binding.tvCancel.setOnClickListener(new PaymentRemindManager$PaymentRemindDialog$$ExternalSyntheticLambda0(this));
            if (i == 1) {
                this.binding.tvTitle.setText(getContext().getString(R.string.going_pay_guide_dialog_title));
                this.binding.tvMessage.setText(paymentRemindManager.getText(R.string.going_pay_guide_dialog_message));
                String string = getContext().getString(R.string.going_pay_guide_dialog_positive);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…ay_guide_dialog_positive)");
                setPositiveButton(string, paymentRemindManager$PaymentRemindDialog$positiveAction$1);
                return;
            }
            this.binding.tvTitle.setText(getContext().getString(R.string.un_pay_guide_dialog_title));
            this.binding.tvMessage.setText(paymentRemindManager.getText(R.string.un_pay_guide_dialog_message));
            String string2 = getContext().getString(R.string.un_pay_guide_dialog_positive);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…ay_guide_dialog_positive)");
            setPositiveButton(string2, paymentRemindManager$PaymentRemindDialog$positiveAction$1);
        }

        /* access modifiers changed from: protected */
        public HomeDialogPaymentReminderBinding createViewBinding(LayoutInflater layoutInflater) {
            Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
            HomeDialogPaymentReminderBinding inflate = HomeDialogPaymentReminderBinding.inflate(layoutInflater);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
            return inflate;
        }

        /* access modifiers changed from: private */
        /* renamed from: _init_$lambda-0  reason: not valid java name */
        public static final void m38_init_$lambda0(PaymentRemindDialog paymentRemindDialog, View view) {
            Intrinsics.checkNotNullParameter(paymentRemindDialog, "this$0");
            paymentRemindDialog.dismiss();
            LaunchTrack launchTrack = LaunchTrack.INSTANCE;
            int i = paymentRemindDialog.mode;
            String string = paymentRemindDialog.getContext().getString(R.string.tv_cancel);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.tv_cancel)");
            launchTrack.clickDialog(i, string);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public final PaymentRemindDialog setTitleAndMsg(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "message");
            this.binding.tvTitle.setText(str);
            this.binding.tvMessage.setText(str2);
            return this;
        }

        private final PaymentRemindDialog setPositiveButton(String str, Function1<? super String, Unit> function1) {
            this.binding.tvGo.setText(str);
            this.binding.tvGo.setOnClickListener(new PaymentRemindManager$PaymentRemindDialog$$ExternalSyntheticLambda1(this, function1));
            return this;
        }

        /* access modifiers changed from: private */
        /* renamed from: setPositiveButton$lambda-1  reason: not valid java name */
        public static final void m39setPositiveButton$lambda1(PaymentRemindDialog paymentRemindDialog, Function1 function1, View view) {
            String str;
            Intrinsics.checkNotNullParameter(paymentRemindDialog, "this$0");
            Intrinsics.checkNotNullParameter(function1, "$action");
            paymentRemindDialog.dismiss();
            if (paymentRemindDialog.mode == 1) {
                str = paymentRemindDialog.getContext().getString(R.string.going_pay_guide_dialog_positive);
            } else {
                str = paymentRemindDialog.getContext().getString(R.string.un_pay_guide_dialog_positive);
            }
            Intrinsics.checkNotNullExpressionValue(str, "if (mode == 1) {\n       …ve)\n                    }");
            function1.invoke(str);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    public final CharSequence getText(int i) {
        String string = this.context.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(resId)");
        Spanned fromHtml = Html.fromHtml(string);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(html)");
        return fromHtml;
    }
}
