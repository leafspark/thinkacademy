package com.tal.app.thinkacademy.live.business.studentvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.studentvideo.listen.PermissionListen;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;

public class PermissCameraView extends BaseLivePluginView implements View.OnClickListener {
    private Context context;
    private PermissionListen driver;
    private TextView tvCancel;
    private TextView tvSetting;
    private TextView tvTip;

    public PermissCameraView(Context context2) {
        super(context2);
        this.context = context2;
        initView();
    }

    public PermissCameraView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.context = context2;
        initView();
    }

    public PermissCameraView(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.context = context2;
        initView();
    }

    public void setDriver(PermissionListen permissionListen) {
        this.driver = permissionListen;
    }

    private void initView() {
        this.tvTip = (TextView) getRootView().findViewById(R.id.tv_live_business_permission_tip);
        this.tvCancel = (TextView) getRootView().findViewById(R.id.tv_live_business_permission_cancel);
        this.tvSetting = (TextView) getRootView().findViewById(R.id.tv_live_business_permission_setting);
        this.tvCancel.setOnClickListener(this);
        this.tvSetting.setOnClickListener(this);
    }

    public void showMicrophoneTip() {
        this.tvTip.setText(R.string.open_microphone_tip);
    }

    public int getLayoutId() {
        return R.layout.live_business_student_video_permiss_camera;
    }

    public void onClick(View view) {
        PermissionListen permissionListen;
        MethodInfo.onClickEventEnter(view, PermissCameraView.class);
        if (view.getId() == R.id.tv_live_business_permission_cancel) {
            PermissionListen permissionListen2 = this.driver;
            if (permissionListen2 != null) {
                permissionListen2.removePermissView();
            }
        } else if (view.getId() == R.id.tv_live_business_permission_setting && (permissionListen = this.driver) != null) {
            permissionListen.settingView();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }
}
