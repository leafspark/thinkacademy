package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.app.NotificationManagerCompat;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.databinding.ActivityNotificationBinding;
import com.tal.app.thinkacademy.business.login.databinding.DialogNotificationBinding;
import com.tal.app.thinkacademy.common.base.BaseBindActivity;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.util.IntentUtils;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u000eH\u0014J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/NotificationActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseBindActivity;", "Lcom/tal/app/thinkacademy/business/login/databinding/ActivityNotificationBinding;", "Landroid/view/View$OnClickListener;", "()V", "mSignOutDialog", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/login/databinding/DialogNotificationBinding;", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "", "onClick", "", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "setNotifyState", "showDialog", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NotificationActivity.kt */
public final class NotificationActivity extends BaseBindActivity<ActivityNotificationBinding> implements View.OnClickListener {
    private BaseBindDialog<DialogNotificationBinding> mSignOutDialog;

    /* access modifiers changed from: protected */
    public ActivityNotificationBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityNotificationBinding inflate = ActivityNotificationBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        NotificationActivity.super.onCreate(bundle);
        setContentView(R.layout.activity_notification);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, -1, false);
        getBinding().notificationTitleBar.setOnTitleBarListener(new NotificationActivity$onCreate$1(this));
        getBinding().ivNotificationState.setOnClickListener(this);
    }

    private final void setNotifyState() {
        if (NotificationManagerCompat.from((Context) this).areNotificationsEnabled()) {
            getBinding().ivNotificationState.setImageResource(R.drawable.notification_icon_on);
            getBinding().tvNotificationTip.setVisibility(8);
            return;
        }
        getBinding().ivNotificationState.setImageResource(R.drawable.notification_icon_off);
        getBinding().tvNotificationTip.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        NotificationActivity.super.onResume();
        setNotifyState();
    }

    private final void showDialog() {
        if (this.mSignOutDialog == null) {
            BaseBindDialog<DialogNotificationBinding> baseBindDialog = (BaseBindDialog) new NotificationActivity$showDialog$1(this);
            this.mSignOutDialog = baseBindDialog;
            baseBindDialog.gravity(80).layoutParams(new LinearLayout.LayoutParams(-1, -2)).canceledOnTouchOutside(true);
            baseBindDialog.binding.tvTurnOff.setOnClickListener(new NotificationActivity$$ExternalSyntheticLambda0(this, baseBindDialog));
            baseBindDialog.binding.tvKeep.setOnClickListener(new NotificationActivity$$ExternalSyntheticLambda1(baseBindDialog));
        }
        BaseBindDialog<DialogNotificationBinding> baseBindDialog2 = this.mSignOutDialog;
        if (baseBindDialog2 != null) {
            baseBindDialog2.show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showDialog$lambda-2$lambda-0  reason: not valid java name */
    public static final void m94showDialog$lambda2$lambda0(NotificationActivity notificationActivity, BaseBindDialog baseBindDialog, View view) {
        Intrinsics.checkNotNullParameter(notificationActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseBindDialog, "$this_apply");
        IntentUtils.startAppSettings((Context) notificationActivity);
        baseBindDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: showDialog$lambda-2$lambda-1  reason: not valid java name */
    public static final void m95showDialog$lambda2$lambda1(BaseBindDialog baseBindDialog, View view) {
        Intrinsics.checkNotNullParameter(baseBindDialog, "$this_apply");
        baseBindDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, NotificationActivity.class);
        Context context = (Context) this;
        if (NotificationManagerCompat.from(context).areNotificationsEnabled()) {
            showDialog();
        } else {
            IntentUtils.startAppSettings(context);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }
}
