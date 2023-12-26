package com.tal.app.thinkacademy.live.business.redpackagerain.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.live.business.R;

public class RedPackageRainDialog extends Dialog implements View.OnClickListener {
    public RedPackageRainDialog(Context context) {
        super(context, R.style.redPackageRainDialog);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.live_business_dialog_red_package_rain_load_failed);
        findViewById(R.id.btn_live_business_red_package_rain).setOnClickListener(this);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        if (window != null) {
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -2;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, RedPackageRainDialog.class);
        if (view.getId() == R.id.btn_live_business_red_package_rain) {
            cancel();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }
}
