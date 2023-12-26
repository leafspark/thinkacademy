package com.tal.app.thinkacademy.common.business.browser.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.common.databinding.CommonDialogGoldcoinBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/view/GoldCoinDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/common/databinding/CommonDialogGoldcoinBinding;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "updateGoldCoin", "", "submitCoin", "", "earlySubmitCoin", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GoldCoinDialog.kt */
public final class GoldCoinDialog extends BaseBindDialog<CommonDialogGoldcoinBinding> {
    public GoldCoinDialog(Context context) {
        super(context);
        layoutParams(new LinearLayout.LayoutParams(SizeUtils.dp2px(360.0f), SizeUtils.dp2px(271.0f)));
        gravity(17);
        TextView textView = this.binding.tvGotIt;
        if (textView != null) {
            textView.setOnClickListener(new GoldCoinDialog$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m25_init_$lambda0(GoldCoinDialog goldCoinDialog, View view) {
        Intrinsics.checkNotNullParameter(goldCoinDialog, "this$0");
        goldCoinDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: protected */
    public CommonDialogGoldcoinBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        CommonDialogGoldcoinBinding inflate = CommonDialogGoldcoinBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    public final void updateGoldCoin(int i, int i2) {
        if (i2 > 0) {
            this.binding.llTwo.setVisibility(0);
            TextView textView = this.binding.tvOne;
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append('+');
            sb.append(i2);
            textView.setText(sb.toString());
            this.binding.tvTwo.setText(getContext().getString(R.string.coins_for_your_early_submission, new Object[]{Integer.valueOf(i2)}));
            return;
        }
        this.binding.llTwo.setVisibility(8);
        this.binding.tvOne.setText(String.valueOf(i));
    }
}
