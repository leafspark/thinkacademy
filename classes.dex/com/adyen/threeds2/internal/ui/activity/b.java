package com.adyen.threeds2.internal.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;
import atd.n0.a;
import com.adyen.threeds2.customization.UiCustomization;
import com.adyen.threeds2.internal.h;
import com.bonree.sdk.agent.engine.external.ActivityInfo;

abstract class b extends AppCompatActivity {
    b() {
    }

    private atd.n0.b a(h hVar) {
        UiCustomization a = hVar.a();
        if (a != null) {
            return new atd.n0.b(getWindow(), new a(a));
        }
        return null;
    }

    private void f() {
        getWindow().setFlags(8192, 8192);
    }

    /* access modifiers changed from: package-private */
    public abstract h e();

    public void finish() {
        super.finish();
        ActivityInfo.finishActivity(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        atd.n0.b a = a(e());
        if (a != null) {
            a(a);
        }
        super.onCreate(bundle);
        f();
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

    private void a(atd.n0.b bVar) {
        LayoutInflater from = LayoutInflater.from(this);
        if (from.getFactory() == null) {
            LayoutInflaterCompat.setFactory2(from, bVar);
        }
    }
}
