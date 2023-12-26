package com.tal.app.thinkacademy.business.login.view;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.databinding.DialogQuitBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.download.operation.DownloadEngine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SettingsActivity.kt */
final class SettingsActivity$dialogClick$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SettingsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsActivity$dialogClick$2(SettingsActivity settingsActivity) {
        super(0);
        this.this$0 = settingsActivity;
    }

    public final void invoke() {
        if (this.this$0.mClearDialog == null) {
            SettingsActivity settingsActivity = this.this$0;
            BaseBindDialog r1 = new BaseBindDialog<DialogQuitBinding>(this.this$0) {
                final /* synthetic */ SettingsActivity this$0;

                {
                    this.this$0 = r2;
                }

                /* access modifiers changed from: protected */
                public DialogQuitBinding createViewBinding(LayoutInflater layoutInflater) {
                    Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
                    DialogQuitBinding inflate = DialogQuitBinding.inflate(layoutInflater);
                    Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
                    return inflate;
                }
            };
            SettingsActivity settingsActivity2 = this.this$0;
            r1.gravity(80).layoutParams(new LinearLayout.LayoutParams(-1, -2)).canceledOnTouchOutside(true);
            TextView textView = r1.binding.tvDialogTitle;
            Resources resources = settingsActivity2.getResources();
            Intrinsics.checkNotNull(resources);
            textView.setText(resources.getText(R.string.tv_clear_cache));
            r1.binding.tvConfirm.setOnClickListener(new SettingsActivity$dialogClick$2$$ExternalSyntheticLambda1(settingsActivity2, r1));
            r1.binding.tvCancel.setOnClickListener(new SettingsActivity$dialogClick$2$$ExternalSyntheticLambda0(r1));
            settingsActivity.mClearDialog = r1;
        }
        BaseBindDialog access$getMClearDialog$p = this.this$0.mClearDialog;
        if (access$getMClearDialog$p != null) {
            access$getMClearDialog$p.show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2$lambda-0  reason: not valid java name */
    public static final void m130invoke$lambda2$lambda0(SettingsActivity settingsActivity, AnonymousClass1 r2, View view) {
        Intrinsics.checkNotNullParameter(settingsActivity, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$this_apply");
        DownloadEngine.getInstance().pauseOnlineAll();
        settingsActivity.clearCache();
        r2.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2$lambda-1  reason: not valid java name */
    public static final void m131invoke$lambda2$lambda1(AnonymousClass1 r1, View view) {
        Intrinsics.checkNotNullParameter(r1, "$this_apply");
        r1.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
