package com.tal.app.thinkacademy.business.study.study.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.LinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.studycenter.databinding.StudyDialogInternetSafetyTipsBinding;
import com.tal.app.thinkacademy.common.business.browser.view.XesWebView;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/dialog/InternetSafetyTipsDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/StudyDialogInternetSafetyTipsBinding;", "context", "Landroid/content/Context;", "url", "", "(Landroid/content/Context;Ljava/lang/String;)V", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "isUseImmersive", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InternetSafetyTipsDialog.kt */
public final class InternetSafetyTipsDialog extends BaseBindDialog<StudyDialogInternetSafetyTipsBinding> {
    public boolean isUseImmersive() {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InternetSafetyTipsDialog(Context context, String str) {
        super(context);
        Intrinsics.checkNotNullParameter(str, "url");
        layoutParams(new LinearLayout.LayoutParams(-1, -1)).dimAmount(0.1f).canceledOnTouchOutside(true);
        this.binding.iGotIt.setOnClickListener(new InternetSafetyTipsDialog$$ExternalSyntheticLambda0(this));
        WebSettings settings = this.binding.wvBrowser.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
        }
        XesWebView xesWebView = this.binding.wvBrowser;
        xesWebView.loadUrl(str);
        SensorsDataAutoTrackHelper.loadUrl2(xesWebView, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m411_init_$lambda0(InternetSafetyTipsDialog internetSafetyTipsDialog, View view) {
        Intrinsics.checkNotNullParameter(internetSafetyTipsDialog, "this$0");
        internetSafetyTipsDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: protected */
    public StudyDialogInternetSafetyTipsBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        StudyDialogInternetSafetyTipsBinding inflate = StudyDialogInternetSafetyTipsBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
