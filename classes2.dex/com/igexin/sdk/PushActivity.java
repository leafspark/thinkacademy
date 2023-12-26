package com.igexin.sdk;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.igexin.sdk.a.a;

public class PushActivity extends Activity {
    public void finish() {
        super.finish();
        ActivityInfo.finishActivity(getClass().getName());
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (a.a().c() != null) {
            a.a().c().onActivityConfigurationChanged(this, configuration);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        super.onCreate(bundle);
        ActivityInfo.endTraceActivity(getClass().getName());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (a.a().c() != null) {
            return a.a().c().onActivityCreateOptionsMenu(this, menu);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (a.a().c() != null) {
            a.a().c().onActivityDestroy(this);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (a.a().c() == null || !a.a().c().onActivityKeyDown(this, i, keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (a.a().c() != null) {
            a.a().c().onActivityNewIntent(this, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        ActivityInfo.pauseActivity(getClass().getName());
        super.onPause();
        if (a.a().c() != null) {
            a.a().c().onActivityPause(this);
        }
        ActivityInfo.endPauseActivity(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        ActivityInfo.onReStartTrace(getClass().getName());
        super.onRestart();
        if (a.a().c() != null) {
            a.a().c().onActivityRestart(this);
        }
        ActivityInfo.endReStartTrace(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        ActivityInfo.resumeActivity(getClass().getName());
        super.onResume();
        if (a.a().c() != null) {
            a.a().c().onActivityResume(this);
        }
        ActivityInfo.endResumeTrace(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        ActivityInfo.onStartTrace(getClass().getName());
        super.onStart();
        if (a.a().c() != null) {
            a.a().c().onActivityStart(this, getIntent());
        }
        ActivityInfo.endStartTrace(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        ActivityInfo.stopActivity();
        super.onStop();
        if (a.a().c() != null) {
            a.a().c().onActivityStop(this);
        }
    }
}
