package com.didi.hummer.adapter.navigator.impl;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.hummer.core.util.DebugUtil;
import com.didi.hummer.core.util.HMLog;
import java.util.Stack;

public class ActivityStackManager implements Application.ActivityLifecycleCallbacks {
    private Stack<Activity> stack;

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    private static class Instance {
        public static ActivityStackManager INSTANCE = new ActivityStackManager();

        private Instance() {
        }
    }

    private ActivityStackManager() {
        this.stack = new Stack<>();
    }

    public static ActivityStackManager getInstance() {
        return Instance.INSTANCE;
    }

    public void register(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public void unRegister(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
    }

    private void addActivity(Activity activity) {
        this.stack.push(activity);
    }

    private void removeActivity(Activity activity) {
        if (!this.stack.isEmpty()) {
            this.stack.remove(activity);
        }
    }

    public Activity getTopActivity() {
        if (!this.stack.isEmpty()) {
            return this.stack.peek();
        }
        return null;
    }

    public void finishTopActivity() {
        if (this.stack.size() > 0) {
            this.stack.peek().finish();
        }
    }

    public void finishActivity(String str) {
        Activity activity = getActivity(str);
        if (activity != null) {
            activity.finish();
        }
    }

    public Activity getActivity(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Activity activity = (Activity) this.stack.get(size);
            if (str.equals(getPageIdFromActivity(activity))) {
                return activity;
            }
        }
        return null;
    }

    public void popToActivity(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            boolean z2 = true;
            int size = this.stack.size() - 1;
            int i = 0;
            while (true) {
                if (size < 0) {
                    z2 = false;
                    break;
                } else if (str.equals(getPageIdFromActivity((Activity) this.stack.get(size)))) {
                    break;
                } else {
                    i++;
                    size--;
                }
            }
            if (z2) {
                for (int i2 = 0; i2 < i; i2++) {
                    if (!this.stack.isEmpty()) {
                        Activity pop = this.stack.pop();
                        if (pop != null) {
                            pop.finish();
                        }
                        if (!z && pop != null) {
                            pop.overridePendingTransition(0, 0);
                        }
                    }
                }
            }
        }
    }

    public void popToRootActivity(boolean z) {
        while (this.stack.size() > 1) {
            Activity pop = this.stack.pop();
            if (pop != null) {
                pop.finish();
            }
            if (!z && pop != null) {
                pop.overridePendingTransition(0, 0);
            }
        }
    }

    public void popBack(int i, boolean z) {
        if (i < 1) {
            i = 1;
        }
        if (i > this.stack.size()) {
            i = this.stack.size();
        }
        for (int i2 = 0; i2 < i; i2++) {
            Activity pop = this.stack.pop();
            if (pop != null) {
                pop.finish();
            }
            if (!z && pop != null) {
                pop.overridePendingTransition(0, 0);
            }
        }
    }

    public void finishAllActivity() {
        while (!this.stack.empty()) {
            this.stack.pop().finish();
        }
    }

    private String getPageIdFromActivity(Activity activity) {
        String str = null;
        if (activity == null) {
            return null;
        }
        if (activity.getIntent() != null) {
            try {
                str = activity.getIntent().getStringExtra(DefaultNavigatorAdapter.EXTRA_PAGE_ID);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str == null ? activity.toString() : str;
    }

    private void printActivityStack(Stack<Activity> stack2) {
        HMLog.d("HummerNative", "----------- stack start -----------");
        for (int size = stack2.size() - 1; size >= 0; size += -1) {
            Activity activity = (Activity) stack2.get(size);
            HMLog.d("HummerNative", "|\t" + activity + " -> " + getPageIdFromActivity(activity));
        }
        HMLog.d("HummerNative", "----------- stack end -----------");
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        addActivity(activity);
        if (DebugUtil.isDebuggable()) {
            printActivityStack(this.stack);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        removeActivity(activity);
        if (DebugUtil.isDebuggable()) {
            printActivityStack(this.stack);
        }
    }
}
