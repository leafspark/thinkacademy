package com.tal.app.thinkacademy.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {
    private final Tag TAG = Tag.WECHAT_SDK;
    private IWXAPI api;

    public void finish() {
        super.finish();
        ActivityInfo.finishActivity(getClass().getName());
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

    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        super.onCreate(bundle);
        this.api = WXAPIFactory.createWXAPI(this, "wx40f1268c6dcc7e97", false);
        try {
            XesLog.i(this.TAG, new Object[]{"onResp 微信分享成功 onCreate="});
            this.api.handleIntent(getIntent(), this);
        } catch (Exception e) {
            Tag tag = this.TAG;
            XesLog.i(tag, new Object[]{"onResp 微信分享成功 onCreate= error=" + e});
        }
        ActivityInfo.endTraceActivity(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        PushAutoTrackHelper.onNewIntent(this, intent);
        super.onNewIntent(intent);
        setIntent(intent);
        this.api.handleIntent(intent, this);
    }

    public void onReq(BaseReq baseReq) {
        int type = baseReq.getType();
        if (type == 3) {
            XesLog.i(this.TAG, new Object[]{"onReq COMMAND_GETMESSAGE_FROM_WX"});
        } else if (type != 4) {
            XesLog.i(this.TAG, new Object[]{"onReq other"});
        } else {
            XesLog.i(this.TAG, new Object[]{"onReq COMMAND_SHOWMESSAGE_FROM_WX"});
        }
        finish();
    }

    public void onResp(BaseResp baseResp) {
        if (baseResp.errCode != 0) {
            Tag tag = this.TAG;
            XesLog.i(tag, new Object[]{"onResp 微信分享失败 code=" + baseResp.errCode});
        } else {
            Tag tag2 = this.TAG;
            XesLog.i(tag2, new Object[]{"onResp 微信分享成功 code=" + baseResp.errCode});
        }
        finish();
    }
}
