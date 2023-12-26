package com.igexin.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.igexin.b.a.c.b;
import com.igexin.push.core.a.e;
import com.igexin.push.core.x;

public class GActivity extends Activity {
    public static final String TAG = "com.igexin.sdk.GActivity";

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
            if (intent2 != null && intent2.hasExtra("action") && intent2.hasExtra("isSlave")) {
                intent.putExtra("action", intent2.getStringExtra("action"));
                intent.putExtra("isSlave", intent2.getBooleanExtra("isSlave", false));
                if (intent2.hasExtra("op_app")) {
                    intent.putExtra("op_app", intent2.getStringExtra("op_app"));
                }
                b.a("GActivity action = " + intent2.getStringExtra("action") + ", isSlave = " + intent2.getBooleanExtra("isSlave", false), new Object[0]);
            }
        } catch (Throwable th) {
            b.a(TAG + "|put extra exception" + th.toString(), new Object[0]);
        }
        x.a().a((Context) this, intent);
        b.a(TAG + "|start PushService from GActivity", new Object[0]);
        finish();
        ActivityInfo.endTraceActivity(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
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
