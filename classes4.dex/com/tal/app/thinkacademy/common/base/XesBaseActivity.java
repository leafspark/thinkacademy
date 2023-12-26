package com.tal.app.thinkacademy.common.base;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.tal.app.thinkacademy.lib.commui.widget.pad.PadAutoUtil;
import com.tal.app.thinkacademy.lib.language.LanguageUtil;
import com.tal.app.thinkcademy.lib.commui.dialog.LoadingDialog;
import java.util.regex.Pattern;

public class XesBaseActivity extends AppCompatActivity implements XesBaseActionInterface {
    private LoadingDialog loadingDialog;

    public void finish() {
        XesBaseActivity.super.finish();
        ActivityInfo.finishActivity(getClass().getName());
    }

    public void onPause() {
        ActivityInfo.pauseActivity(getClass().getName());
        XesBaseActivity.super.onPause();
        ActivityInfo.endPauseActivity(getClass().getName());
    }

    public void onRestart() {
        ActivityInfo.onReStartTrace(getClass().getName());
        XesBaseActivity.super.onRestart();
        ActivityInfo.endReStartTrace(getClass().getName());
    }

    public void onStart() {
        ActivityInfo.onStartTrace(getClass().getName());
        XesBaseActivity.super.onStart();
        ActivityInfo.endStartTrace(getClass().getName());
    }

    public void onStop() {
        XesBaseActivity.super.onStop();
        ActivityInfo.stopActivity();
    }

    public void applyOverrideConfiguration(Configuration configuration) {
        if (configuration != null) {
            int i = configuration.uiMode;
            configuration.setTo(getBaseContext().getResources().getConfiguration());
            configuration.uiMode = i;
        }
        XesBaseActivity.super.applyOverrideConfiguration(configuration);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        XesBaseActivity.super.attachBaseContext(LanguageUtil.attachBaseContext(context));
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.tal.app.thinkacademy.common.base.XesBaseActivity, java.lang.Object, android.app.Activity, androidx.appcompat.app.AppCompatActivity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        PadAutoUtil.setupAutoScreenOrientation(this);
        XesBaseActivity.super.onCreate(bundle);
        ActivityInfo.endTraceActivity(getClass().getName());
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.tal.app.thinkacademy.common.base.XesBaseActivity, android.app.Activity, androidx.appcompat.app.AppCompatActivity] */
    public void setContentView(View view) {
        XesBaseActivity.super.setContentView(PadAutoUtil.setupAutoViewCenter(view, this));
    }

    public Resources getResources() {
        return PadAutoUtil.adaptScreenResources(getClass(), XesBaseActivity.super.getResources());
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [android.content.Context, com.tal.app.thinkacademy.common.base.XesBaseActivity] */
    public void showToast(String str) {
        if (!TextUtils.isEmpty(str)) {
            Toast.makeText(this, str, 0).show();
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [android.content.Context, com.tal.app.thinkacademy.common.base.XesBaseActivity] */
    public void showLoading() {
        if (!isFinishing()) {
            if (this.loadingDialog == null) {
                this.loadingDialog = new LoadingDialog(this);
            }
            if (!this.loadingDialog.isShowing()) {
                this.loadingDialog.show();
            }
        }
    }

    public void hideLoading() {
        if (this.loadingDialog != null && !isFinishing()) {
            this.loadingDialog.dismiss();
        }
    }

    public LoadingDialog getLoadingDialog() {
        return this.loadingDialog;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        ActivityInfo.resumeActivity(getClass().getName());
        XesBaseActivity.super.onResume();
        ActivityInfo.endResumeTrace(getClass().getName());
    }

    private boolean isAllowActivity(String str) {
        return !"LaunchActivity".equals(str) && !"SelectSchoolActivity".equals(str);
    }

    /* access modifiers changed from: protected */
    public String getNumeric(String str) {
        return Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
    }

    private Boolean isTempClass(String str) {
        return Boolean.valueOf(str.contains("Think Academy Classroom App"));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        XesBaseActivity.super.onDestroy();
        hideLoading();
    }
}
