package com.igexin.sdk;

import android.app.Activity;
import android.os.Bundle;
import com.bonree.sdk.agent.engine.external.ActivityInfo;

public class GTBaseActivity extends Activity {
    public void finish() {
        super.finish();
        ActivityInfo.finishActivity(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        super.onCreate(bundle);
        GTServiceManager.getInstance().onActivityCreate(this);
        ActivityInfo.endTraceActivity(getClass().getName());
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
}
