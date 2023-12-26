package com.igexin.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.igexin.b.a.c.b;
import com.igexin.push.core.a.e;
import com.igexin.push.core.x;

public class GetuiActivity extends Activity {
    private String a = "GetuiActivity";

    public void finish() {
        super.finish();
        ActivityInfo.finishActivity(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        Intent intent = new Intent(this, e.a().a((Context) this));
        try {
            super.onCreate(bundle);
            Intent intent2 = getIntent();
            if (intent2 != null && intent2.hasExtra("action") && intent2.hasExtra("broadcast_intent")) {
                intent.putExtra("action", intent2.getStringExtra("action"));
                intent.putExtra("broadcast_intent", (Intent) intent2.getParcelableExtra("broadcast_intent"));
            }
        } catch (Throwable th) {
            b.a(this.a + "|put extra exception" + th.toString(), new Object[0]);
        }
        x.a().a((Context) this, intent);
        finish();
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
