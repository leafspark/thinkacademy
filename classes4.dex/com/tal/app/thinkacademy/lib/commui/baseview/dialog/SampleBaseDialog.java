package com.tal.app.thinkacademy.lib.commui.baseview.dialog;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;

public class SampleBaseDialog extends AppCompatActivity implements View.OnClickListener {
    private BaseDialog dialog;

    public void finish() {
        SampleBaseDialog.super.finish();
        ActivityInfo.finishActivity(getClass().getName());
    }

    public void onPause() {
        ActivityInfo.pauseActivity(getClass().getName());
        SampleBaseDialog.super.onPause();
        ActivityInfo.endPauseActivity(getClass().getName());
    }

    public void onPointerCaptureChanged(boolean z) {
    }

    public void onRestart() {
        ActivityInfo.onReStartTrace(getClass().getName());
        SampleBaseDialog.super.onRestart();
        ActivityInfo.endReStartTrace(getClass().getName());
    }

    public void onResume() {
        ActivityInfo.resumeActivity(getClass().getName());
        SampleBaseDialog.super.onResume();
        ActivityInfo.endResumeTrace(getClass().getName());
    }

    public void onStart() {
        ActivityInfo.onStartTrace(getClass().getName());
        SampleBaseDialog.super.onStart();
        ActivityInfo.endStartTrace(getClass().getName());
    }

    public void onStop() {
        SampleBaseDialog.super.onStop();
        ActivityInfo.stopActivity();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        SampleBaseDialog.super.onCreate(bundle);
        setContentView(R.layout.layout_base_dialog);
        findViewById(R.id.btn_bottom).setOnClickListener(this);
        findViewById(R.id.btn_left).setOnClickListener(this);
        findViewById(R.id.btn_top).setOnClickListener(this);
        findViewById(R.id.btn_right).setOnClickListener(this);
        findViewById(R.id.btn_center).setOnClickListener(this);
        ActivityInfo.endTraceActivity(getClass().getName());
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [android.content.Context, android.view.View$OnClickListener, java.lang.Object, com.tal.app.thinkacademy.lib.commui.baseview.dialog.SampleBaseDialog] */
    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, this);
        int id = view.getId();
        if (id == R.id.btn_center) {
            BaseDialog baseDialog = new BaseDialog(this);
            this.dialog = baseDialog;
            baseDialog.contentView(R.layout.dialog_quit).canceledOnTouchOutside(true).show();
            this.dialog.findViewById(R.id.tv_confirm).setOnClickListener(this);
            this.dialog.findViewById(R.id.tv_cancel).setOnClickListener(this);
        } else if (id == R.id.btn_left) {
            new BaseDialog(this).contentView(R.layout.dialog_left).layoutParams(new ViewGroup.LayoutParams(-2, -1)).dimAmount(0.5f).gravity(19).animType(BaseDialog.AnimInType.LEFT).canceledOnTouchOutside(true).show();
        } else if (id == R.id.btn_top) {
            new BaseDialog(this).contentView(R.layout.dialog_photo).layoutParams(new ViewGroup.LayoutParams(-1, -2)).dimAmount(0.5f).gravity(48).offset(0, SizeUtils.dp2px(48.0f)).animType(BaseDialog.AnimInType.TOP).canceledOnTouchOutside(true).show();
        } else if (id == R.id.btn_right) {
            new BaseDialog(this).contentView(R.layout.dialog_right).layoutParams(new ViewGroup.LayoutParams(-2, -1)).gravity(21).animType(BaseDialog.AnimInType.RIGHT).offset(20, 0).canceledOnTouchOutside(true).show();
        } else if (id == R.id.btn_bottom) {
            new BaseDialog(this).contentView(R.layout.dialog_photo).gravity(80).animType(BaseDialog.AnimInType.BOTTOM).canceledOnTouchOutside(true).show();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }
}
