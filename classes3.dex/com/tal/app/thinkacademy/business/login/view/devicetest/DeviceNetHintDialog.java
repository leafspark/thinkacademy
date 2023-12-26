package com.tal.app.thinkacademy.business.login.view.devicetest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/devicetest/DeviceNetHintDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceNetHintDialog.kt */
public final class DeviceNetHintDialog extends BaseDialog {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceNetHintDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        contentView(R.layout.layout_device_net_dialog);
        canceledOnTouchOutside(true);
        gravity(17);
        layoutParams(new ViewGroup.LayoutParams(context.getResources().getDimensionPixelSize(R.dimen.size_340dp), -2));
        ((TextView) findViewById(R.id.btn_got_it)).setOnClickListener(new DeviceNetHintDialog$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m139_init_$lambda0(DeviceNetHintDialog deviceNetHintDialog, View view) {
        Intrinsics.checkNotNullParameter(deviceNetHintDialog, "this$0");
        deviceNetHintDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
