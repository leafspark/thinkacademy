package com.tal.app.thinkacademy;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivityKt;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassCalendarActivity;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.EncodeUtils;
import com.tal.appthinkacademy.Tag;
import com.tal.appthinkacademy.base.TalHwApplication;

public class NotificationActivity extends Activity {
    private final String COMMON_WEB = "web://?";
    private final String ROUTER_COINS = "points://?";
    private final String ROUTER_EXAM = "exam://?";
    private final String ROUTER_LEARN = "learnCenter://?";
    private final String ROUTER_PREVIEW_QUESTION = "previewQuestion://?";
    private String mRouter;

    public void finish() {
        super.finish();
        ActivityInfo.finishActivity(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PushAutoTrackHelper.onNewIntent(this, intent);
    }

    public void onPause() {
        ActivityInfo.pauseActivity(getClass().getName());
        super.onPause();
        ActivityInfo.endPauseActivity(getClass().getName());
    }

    public void onRestart() {
        ActivityInfo.onReStartTrace(getClass().getName());
        super.onRestart();
        ActivityInfo.endReStartTrace(getClass().getName());
    }

    public void onResume() {
        ActivityInfo.resumeActivity(getClass().getName());
        super.onResume();
        ActivityInfo.endResumeTrace(getClass().getName());
    }

    public void onStart() {
        ActivityInfo.onStartTrace(getClass().getName());
        super.onStart();
        ActivityInfo.endStartTrace(getClass().getName());
    }

    public void onStop() {
        super.onStop();
        ActivityInfo.stopActivity();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        super.onCreate(bundle);
        this.mRouter = getIntent().getStringExtra("router");
        startRouter();
        ActivityInfo.endTraceActivity(getClass().getName());
    }

    private void startRouter() {
        TalHwApplication talHwApplication = (TalHwApplication) getApplication();
        if (this.mRouter == null) {
            this.mRouter = "";
        }
        if (this.mRouter.startsWith("points://?")) {
            Bundle bundle = new Bundle();
            String string = ShareDataManager.getInstance().getString("h5_Domain", "", ShareDataManager.SHAREDATA_NOT_CLEAR);
            bundle.putString("jump_key", string + "/rewardCoins");
            bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).setLocalTitle("Coins").build());
            bundle.putBoolean("openApp", false);
            XesLog.i(Tag.PUSH, new Object[]{"跳转金币详情页面，H5页面"});
            XesRoute.getInstance().navigation("/login/coins_activity", bundle);
        } else if (this.mRouter.startsWith("learnCenter://?")) {
            Uri parse = Uri.parse(this.mRouter);
            String queryParameter = parse.getQueryParameter(LearnMaterialsListActivityKt.CLASSID);
            String queryParameter2 = parse.getQueryParameter("schoolCode");
            String string2 = ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR);
            if (TextUtils.equals(queryParameter2, string2)) {
                XesLog.i(Tag.PUSH, new Object[]{"跳转课程列表页面"});
                ClassCalendarActivity.Companion.startActivity(this, queryParameter, false);
            } else {
                Tag tag = Tag.PUSH;
                XesLog.e(tag, new Object[]{"分校与当前用户分校不同，跳转课前列表也失败 current=" + string2});
            }
        } else if (this.mRouter.startsWith("web://?")) {
            Uri parse2 = Uri.parse(this.mRouter);
            String queryParameter3 = parse2.getQueryParameter("url");
            String queryParameter4 = parse2.getQueryParameter("title");
            String urlDecode = EncodeUtils.urlDecode(queryParameter3);
            String urlDecode2 = EncodeUtils.urlDecode(queryParameter4);
            Bundle bundle2 = new Bundle();
            bundle2.putString("jump_key", urlDecode);
            AgentConfig.Builder showProgressBar = new AgentConfig.Builder().setShowProgressBar(true);
            if (TextUtils.isEmpty(urlDecode2)) {
                showProgressBar.setShowTitle(false);
            } else {
                showProgressBar.setShowTitle(true);
                showProgressBar.setLocalTitle(urlDecode2);
            }
            bundle2.putSerializable(ClassParamsKt.AGENT_CONFIG, showProgressBar.build());
            bundle2.putBoolean("openApp", false);
            Tag tag2 = Tag.PUSH;
            XesLog.i(tag2, new Object[]{"跳转站内公共网页 : " + urlDecode});
            XesRoute.getInstance().navigation("/commui/browser_activity", bundle2);
        } else {
            Tag tag3 = Tag.PUSH;
            XesLog.e(tag3, new Object[]{"不识别通知scheme类型：" + this.mRouter});
        }
        finish();
    }
}
