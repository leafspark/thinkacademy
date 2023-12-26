package com.didi.hummer.utils.blankj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.didi.hummer.utils.blankj.Utils;
import java.util.HashMap;
import java.util.Map;

public class UtilsTransActivity extends AppCompatActivity {
    private static final Map<UtilsTransActivity, TransActivityDelegate> CALLBACK_MAP = new HashMap();
    private static TransActivityDelegate sDelegate;

    public static abstract class TransActivityDelegate {
        public boolean dispatchTouchEvent(UtilsTransActivity utilsTransActivity, MotionEvent motionEvent) {
            return false;
        }

        public void onActivityResult(UtilsTransActivity utilsTransActivity, int i, int i2, Intent intent) {
        }

        public void onCreateBefore(UtilsTransActivity utilsTransActivity, Bundle bundle) {
        }

        public void onCreated(UtilsTransActivity utilsTransActivity, Bundle bundle) {
        }

        public void onDestroy(UtilsTransActivity utilsTransActivity) {
        }

        public void onPaused(UtilsTransActivity utilsTransActivity) {
        }

        public void onRequestPermissionsResult(UtilsTransActivity utilsTransActivity, int i, String[] strArr, int[] iArr) {
        }

        public void onResumed(UtilsTransActivity utilsTransActivity) {
        }

        public void onSaveInstanceState(UtilsTransActivity utilsTransActivity, Bundle bundle) {
        }

        public void onStarted(UtilsTransActivity utilsTransActivity) {
        }

        public void onStopped(UtilsTransActivity utilsTransActivity) {
        }
    }

    public void finish() {
        UtilsTransActivity.super.finish();
        ActivityInfo.finishActivity(getClass().getName());
    }

    public void onRestart() {
        ActivityInfo.onReStartTrace(getClass().getName());
        UtilsTransActivity.super.onRestart();
        ActivityInfo.endReStartTrace(getClass().getName());
    }

    public static void start(TransActivityDelegate transActivityDelegate) {
        start((Activity) null, (Utils.Consumer<Intent>) null, transActivityDelegate);
    }

    public static void start(Utils.Consumer<Intent> consumer, TransActivityDelegate transActivityDelegate) {
        start((Activity) null, consumer, transActivityDelegate);
    }

    public static void start(Activity activity, TransActivityDelegate transActivityDelegate) {
        start(activity, (Utils.Consumer<Intent>) null, transActivityDelegate);
    }

    public static void start(Activity activity, Utils.Consumer<Intent> consumer, TransActivityDelegate transActivityDelegate) {
        if (transActivityDelegate != null) {
            Intent intent = new Intent(Utils.getApp(), UtilsTransActivity.class);
            if (consumer != null) {
                consumer.accept(intent);
            }
            if (activity == null) {
                intent.addFlags(268435456);
                Utils.getApp().startActivity(intent);
            } else {
                activity.startActivity(intent);
            }
            sDelegate = transActivityDelegate;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        overridePendingTransition(0, 0);
        TransActivityDelegate transActivityDelegate = sDelegate;
        if (transActivityDelegate == null) {
            UtilsTransActivity.super.onCreate(bundle);
            finish();
            ActivityInfo.endTraceActivity(getClass().getName());
            return;
        }
        CALLBACK_MAP.put(this, transActivityDelegate);
        sDelegate.onCreateBefore(this, bundle);
        UtilsTransActivity.super.onCreate(bundle);
        sDelegate.onCreated(this, bundle);
        sDelegate = null;
        ActivityInfo.endTraceActivity(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        ActivityInfo.onStartTrace(getClass().getName());
        UtilsTransActivity.super.onStart();
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate == null) {
            ActivityInfo.endStartTrace(getClass().getName());
            return;
        }
        transActivityDelegate.onStarted(this);
        ActivityInfo.endStartTrace(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        ActivityInfo.resumeActivity(getClass().getName());
        UtilsTransActivity.super.onResume();
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate == null) {
            ActivityInfo.endResumeTrace(getClass().getName());
            return;
        }
        transActivityDelegate.onResumed(this);
        ActivityInfo.endResumeTrace(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        ActivityInfo.pauseActivity(getClass().getName());
        overridePendingTransition(0, 0);
        UtilsTransActivity.super.onPause();
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate == null) {
            ActivityInfo.endPauseActivity(getClass().getName());
            return;
        }
        transActivityDelegate.onPaused(this);
        ActivityInfo.endPauseActivity(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        ActivityInfo.stopActivity();
        UtilsTransActivity.super.onStop();
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate != null) {
            transActivityDelegate.onStopped(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        UtilsTransActivity.super.onSaveInstanceState(bundle);
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate != null) {
            transActivityDelegate.onSaveInstanceState(this, bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        UtilsTransActivity.super.onDestroy();
        Map<UtilsTransActivity, TransActivityDelegate> map = CALLBACK_MAP;
        TransActivityDelegate transActivityDelegate = map.get(this);
        if (transActivityDelegate != null) {
            transActivityDelegate.onDestroy(this);
            map.remove(this);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        UtilsTransActivity.super.onRequestPermissionsResult(i, strArr, iArr);
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate != null) {
            transActivityDelegate.onRequestPermissionsResult(this, i, strArr, iArr);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        UtilsTransActivity.super.onActivityResult(i, i2, intent);
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate != null) {
            transActivityDelegate.onActivityResult(this, i, i2, intent);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate == null) {
            return UtilsTransActivity.super.dispatchTouchEvent(motionEvent);
        }
        if (transActivityDelegate.dispatchTouchEvent(this, motionEvent)) {
            return true;
        }
        return UtilsTransActivity.super.dispatchTouchEvent(motionEvent);
    }
}
