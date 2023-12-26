package com.tal.app.thinkacademy.lib.commui.baseview.popupwindow;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.commui.baseview.popupwindow.PopupWindowUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;

public class PopupWindowUtilsDemo extends AppCompatActivity {
    private Button btn_show;
    private Context mContext;
    private ConstraintLayout root_view;

    public void finish() {
        PopupWindowUtilsDemo.super.finish();
        ActivityInfo.finishActivity(getClass().getName());
    }

    public void onPause() {
        ActivityInfo.pauseActivity(getClass().getName());
        PopupWindowUtilsDemo.super.onPause();
        ActivityInfo.endPauseActivity(getClass().getName());
    }

    public void onRestart() {
        ActivityInfo.onReStartTrace(getClass().getName());
        PopupWindowUtilsDemo.super.onRestart();
        ActivityInfo.endReStartTrace(getClass().getName());
    }

    public void onResume() {
        ActivityInfo.resumeActivity(getClass().getName());
        PopupWindowUtilsDemo.super.onResume();
        ActivityInfo.endResumeTrace(getClass().getName());
    }

    public void onStart() {
        ActivityInfo.onStartTrace(getClass().getName());
        PopupWindowUtilsDemo.super.onStart();
        ActivityInfo.endStartTrace(getClass().getName());
    }

    public void onStop() {
        PopupWindowUtilsDemo.super.onStop();
        ActivityInfo.stopActivity();
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [android.content.Context, com.tal.app.thinkacademy.lib.commui.baseview.popupwindow.PopupWindowUtilsDemo, java.lang.Object, androidx.appcompat.app.AppCompatActivity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        PopupWindowUtilsDemo.super.onCreate(bundle);
        setContentView(R.layout.activity_popup_window_utils_demo);
        this.mContext = this;
        this.btn_show = (Button) findViewById(R.id.btn_xixi);
        this.root_view = findViewById(R.id.root_view);
        this.btn_show.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, PopupWindowUtilsDemo.class);
                PopupWindowUtilsDemo.this.initPopWindow(view);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        ActivityInfo.endTraceActivity(getClass().getName());
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [android.content.Context, com.tal.app.thinkacademy.lib.commui.baseview.popupwindow.PopupWindowUtilsDemo] */
    /* access modifiers changed from: private */
    public void initPopWindow(View view) {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        int i = R.layout.item_popup;
        ConstraintLayout constraintLayout = this.root_view;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i, constraintLayout, false) : XMLParseInstrumentation.inflate(from, i, constraintLayout, false);
        final PopupWindowUtils showAtLocation = new PopupWindowUtils.Builder().setContext(this).setContentView(inflate).setWidth(-2).setHeight(-2).setFocus(true).setOutSideCancel(true).setAnimationStyle(R.anim.anim_pop).builder().showAtLocation(R.layout.activity_popup_window_utils_demo, 16, 10, 10);
        ((Button) inflate.findViewById(R.id.btn_xixi)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, PopupWindowUtilsDemo.class);
                ToastUtils.showShort((CharSequence) "你点击了：嘻嘻");
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        ((Button) inflate.findViewById(R.id.btn_haha)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, PopupWindowUtilsDemo.class);
                ToastUtils.showShort((CharSequence) "你点击了：哈哈");
                showAtLocation.dismiss();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
    }
}
