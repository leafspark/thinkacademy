package com.didi.hummer.delegate;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.didi.hummer.adapter.navigator.NavPage;
import com.didi.hummer.adapter.navigator.impl.DefaultNavigatorAdapter;

public class HummerDelegateActivity extends AppCompatActivity {
    private IHummerDelegagte mDelegate;

    public void onPause() {
        ActivityInfo.pauseActivity(getClass().getName());
        HummerDelegateActivity.super.onPause();
        ActivityInfo.endPauseActivity(getClass().getName());
    }

    public void onRestart() {
        ActivityInfo.onReStartTrace(getClass().getName());
        HummerDelegateActivity.super.onRestart();
        ActivityInfo.endReStartTrace(getClass().getName());
    }

    public void onResume() {
        ActivityInfo.resumeActivity(getClass().getName());
        HummerDelegateActivity.super.onResume();
        ActivityInfo.endResumeTrace(getClass().getName());
    }

    public void onStart() {
        ActivityInfo.onStartTrace(getClass().getName());
        HummerDelegateActivity.super.onStart();
        ActivityInfo.endStartTrace(getClass().getName());
    }

    public void onStop() {
        HummerDelegateActivity.super.onStop();
        ActivityInfo.stopActivity();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        HummerDelegateActivity.super.onCreate(bundle);
        IHummerDelegagte createHummerDelegate = createHummerDelegate(getPageInfo());
        this.mDelegate = createHummerDelegate;
        if (createHummerDelegate != null) {
            createHummerDelegate.initSDK();
            setContentView(this.mDelegate.initViewAndRender());
            ActivityInfo.endTraceActivity(getClass().getName());
            return;
        }
        RuntimeException runtimeException = new RuntimeException("Delegate cannot be null");
        ActivityInfo.endTraceActivity(getClass().getName());
        throw runtimeException;
    }

    public void onBackPressed() {
        if (!this.mDelegate.onBackPressed()) {
            HummerDelegateActivity.super.onBackPressed();
        }
    }

    public void finish() {
        ActivityInfo.finishActivity(getClass().getName());
        setPageResult();
        HummerDelegateActivity.super.finish();
    }

    /* access modifiers changed from: protected */
    public void setPageResult() {
        setResult(-1, this.mDelegate.getJsPageResultIntent());
    }

    /* access modifiers changed from: protected */
    public IHummerDelegagte createHummerDelegate(NavPage navPage) {
        return new HummerDelegateAdapter((FragmentActivity) this, navPage);
    }

    /* access modifiers changed from: protected */
    public NavPage getPageInfo() {
        try {
            return (NavPage) getIntent().getSerializableExtra(DefaultNavigatorAdapter.EXTRA_PAGE_MODEL);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
