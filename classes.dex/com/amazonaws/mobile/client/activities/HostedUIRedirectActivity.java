package com.amazonaws.mobile.client.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobileconnectors.cognitoauth.activities.CustomTabsManagerActivity;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

public final class HostedUIRedirectActivity extends Activity {
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
        startActivity(CustomTabsManagerActivity.createResponseHandlingIntent(this, getIntent().getData()));
        ActivityInfo.endTraceActivity(getClass().getName());
    }

    public void onResume() {
        ActivityInfo.resumeActivity(getClass().getName());
        super.onResume();
        Log.d("AuthClient", "Handling auth redirect response");
        AWSMobileClient.getInstance().handleAuthResponse(getIntent());
        finish();
        ActivityInfo.endResumeTrace(getClass().getName());
    }
}
